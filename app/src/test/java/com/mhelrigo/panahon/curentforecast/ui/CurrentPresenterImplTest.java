package com.mhelrigo.panahon.curentforecast.ui;

import static com.mhelrigo.panahon.curentforecast.ui.di.FakeCurrentPresenterDependencyProvider.LATITUDE;
import static com.mhelrigo.panahon.curentforecast.ui.di.FakeCurrentPresenterDependencyProvider.LOCATION;
import static com.mhelrigo.panahon.curentforecast.ui.di.FakeCurrentPresenterDependencyProvider.LONGITUDE;

import com.mhelrigo.domain.forecast.entity.ForecastData;
import com.mhelrigo.domain.forecast.usecase.GetCurrentLocationUseCase;
import com.mhelrigo.domain.forecast.usecase.GetForecastUseCase;
import com.mhelrigo.panahon.curentforecast.ui.di.FakeCurrentPresenterDependencyProvider;

import junit.framework.TestCase;

import java.util.List;

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subscribers.TestSubscriber;

public class CurrentPresenterImplTest extends TestCase {
    private GetCurrentLocationUseCase getCurrentLocationUseCase;
    private GetCurrentLocationUseCase getCurrentLocationUseCaseFailed;
    private GetForecastUseCase getForecastUseCase;
    private FakeCurrentForecastView fakeCurrentForecastView;
    private FakeCurrentForecastViewModel fakeCurrentForecastViewModel;

    private Boolean isRequestedForCurrentLocation = false;
    private Boolean isRequestForForecastData = false;
    public Boolean isLocationPermissionGranted = false;

    public void setUp() throws Exception {
        super.setUp();
        getCurrentLocationUseCase = FakeCurrentPresenterDependencyProvider.fakeGetCurrentLocationUseCase();
        getCurrentLocationUseCaseFailed = FakeCurrentPresenterDependencyProvider.fakeGetCurrentLocationUseCaseFailed();
        getForecastUseCase = FakeCurrentPresenterDependencyProvider.fakeGetForecastUseCase();
        fakeCurrentForecastView = new FakeCurrentForecastView();
        fakeCurrentForecastViewModel = new FakeCurrentForecastViewModel();

        RxAndroidPlugins.setInitMainThreadSchedulerHandler(schedulerCallable -> Schedulers.trampoline());
    }

    public void testHandleLocationPermissionStatus() {
        if (isLocationPermissionGranted) {
            testRequestForCurrentLocation();

            assertTrue(isRequestedForCurrentLocation);
            assertTrue(isRequestForForecastData);
        } else {
            fakeCurrentForecastViewModel.changeUiState(CurrentForecastUiState.RETRIEVING_LOCATION_NOT_PERMITTED);
            assertEquals(CurrentForecastUiState.RETRIEVING_LOCATION_NOT_PERMITTED, fakeCurrentForecastViewModel.currentForecastUiState);
        }
    }

    public void testRequestForCurrentLocation() {
        isRequestedForCurrentLocation = true;

        List<Double> coordinates = getCurrentLocationUseCase.execute(null)
                .observeOn(AndroidSchedulers.mainThread())
                .blockingGet();

        fakeCurrentForecastViewModel.changeUiState(CurrentForecastUiState.RETRIEVING_LOCATION);

        assertEquals(LATITUDE, coordinates.get(0));
        assertEquals(LONGITUDE, coordinates.get(1));
        assertEquals(CurrentForecastUiState.RETRIEVING_LOCATION, fakeCurrentForecastViewModel.currentForecastUiState);

        testRequestForForecastData();
    }

    public void testRequestForCurrentLocationFailed() {

        try {
            getCurrentLocationUseCaseFailed.execute(null)
                    .observeOn(AndroidSchedulers.mainThread())
                    .blockingGet();
        }catch (Exception e) {
            fakeCurrentForecastViewModel.changeUiState(CurrentForecastUiState.NO_RETRIEVED_LOCATION);
            fakeCurrentForecastView.navigateToLocationSettings();

            assertTrue(fakeCurrentForecastView.isNavigateToLocationSettings);
            assertEquals(CurrentForecastUiState.NO_RETRIEVED_LOCATION, fakeCurrentForecastViewModel.currentForecastUiState);
        }
    }

    public void testRequestForForecastData() {
        isRequestForForecastData = true;

        String coordinates = LATITUDE + " " + LONGITUDE;

        ForecastData forecastData = getForecastUseCase.execute(GetForecastUseCase.Params.setter(coordinates, 7, "yes", "yes"))
                .observeOn(AndroidSchedulers.mainThread())
                .blockingGet();

        fakeCurrentForecastViewModel.persistForecastData(forecastData);
        fakeCurrentForecastViewModel.changeUiState(CurrentForecastUiState.RETRIEVING_DATA);

        assertEquals(LOCATION.getLat(), forecastData.getLocation().getLat());
        assertEquals(LOCATION.getLon(), forecastData.getLocation().getLon());
        assertEquals(forecastData.getLocation().getLon(), fakeCurrentForecastViewModel.forecastData.getLocation().getLon());
        assertEquals(CurrentForecastUiState.RETRIEVING_DATA, fakeCurrentForecastViewModel.currentForecastUiState);
    }

    public void testOnGoToAppDetailSettings() {
        fakeCurrentForecastView.navigateToAppDetailSettings();

        assertTrue(fakeCurrentForecastView.isNavigateToAppDetailsSettings);
    }

    class FakeCurrentForecastView implements CurrentForecastUiContract.View {

        public Boolean isNavigateToAppDetailsSettings = false;

        public Boolean isNavigateToLocationSettings = false;

        public FakeCurrentForecastView() {
        }

        @Override
        public void navigateToAppDetailSettings() {
            isNavigateToAppDetailsSettings = true;
        }

        @Override
        public void navigateToLocationSettings() {
            isNavigateToLocationSettings = true;
        }
    }

    class FakeCurrentForecastViewModel implements CurrentForecastUiContract.ViewModel {
        public ForecastData forecastData;
        public CurrentForecastUiState currentForecastUiState;

        @Override
        public void persistForecastData(ForecastData forecastData) {
            this.forecastData = forecastData;
        }

        @Override
        public void changeUiState(CurrentForecastUiState currentForecastUiState) {
            this.currentForecastUiState = currentForecastUiState;
        }
    }
}