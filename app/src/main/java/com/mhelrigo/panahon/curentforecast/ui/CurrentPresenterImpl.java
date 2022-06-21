package com.mhelrigo.panahon.curentforecast.ui;

import com.mhelrigo.domain.forecast.usecase.GetCurrentLocationUseCase;
import com.mhelrigo.domain.forecast.usecase.GetForecastUseCase;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Consumer;
import timber.log.Timber;

public class CurrentPresenterImpl implements CurrentForecastUiContract.Presenter {

    private CurrentForecastUiContract.ViewModel forecastViewModel;
    private CurrentForecastUiContract.View forecastView;
    private GetCurrentLocationUseCase getCurrentLocationUseCase;
    private GetForecastUseCase getForecastUseCase;

    public CurrentPresenterImpl(CurrentForecastUiContract.ViewModel forecastViewModel,
                                CurrentForecastUiContract.View forecastView,
                                GetCurrentLocationUseCase getCurrentLocationUseCase,
                                GetForecastUseCase getForecastUseCase) {
        this.forecastViewModel = forecastViewModel;
        this.forecastView = forecastView;
        this.getCurrentLocationUseCase = getCurrentLocationUseCase;
        this.getForecastUseCase = getForecastUseCase;
    }

    @Override
    public void handleLocationPermissionStatus(boolean isGranted) {
        if (isGranted) {
            requestForCurrentLocation();
        } else {
            forecastViewModel.changeUiState(CurrentForecastUiState.RETRIEVING_LOCATION_NOT_PERMITTED);
        }
    }

    @Override
    public void requestForCurrentLocation() {
        forecastViewModel.changeUiState(CurrentForecastUiState.RETRIEVING_LOCATION);
        getCurrentLocationUseCase.execute(null)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((doubles, throwable) -> {
                    if (throwable != null) {
                        forecastViewModel.changeUiState(CurrentForecastUiState.NO_RETRIEVED_LOCATION);
                        throwable.printStackTrace();
                    } else {
                        requestForForecastData(doubles.get(0), doubles.get(1));
                    }
                });
    }

    @Override
    public void requestForForecastData(Double latitude, Double longitude) {
        String coordinates = latitude + " " + longitude;
        getForecastUseCase.execute(GetForecastUseCase.Params.setter(coordinates, 7, "yes", "yes"))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((forecastData, throwable) -> {
                    if (throwable != null) {
                        throwable.printStackTrace();
                        return;
                    }
                    forecastViewModel.persistForecastData(forecastData);
                    forecastViewModel.changeUiState(CurrentForecastUiState.RETRIEVING_DATA);
                });
    }

    @Override
    public void onGoToAppDetailSettings() {
        forecastView.navigateToAppDetailSettings();
        // Possibly show a loading for getting data.
    }

    @Override
    public void onGoToLocationSettings() {
        forecastView.navigateToLocationSettings();
    }
}
