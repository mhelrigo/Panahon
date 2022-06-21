package com.mhelrigo.panahon.curentforecast.ui.di;

import com.mhelrigo.domain.forecast.LocationProviderInteractor;
import com.mhelrigo.domain.forecast.entity.ForecastData;
import com.mhelrigo.domain.forecast.entity.Location;
import com.mhelrigo.domain.forecast.repository.ForecastRepository;
import com.mhelrigo.domain.forecast.usecase.GetCurrentLocationUseCase;
import com.mhelrigo.domain.forecast.usecase.GetForecastUseCase;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;

public class FakeCurrentPresenterDependencyProvider {

    public static Double LATITUDE = 14.21;
    public static Double LONGITUDE = 121.17;

    public static Location LOCATION = new Location("2022-06-15 10:29", "Philippines", 1655260176, "Calamba", 121.17, "Laguna", 14.21, "Asia/Manila");

    public static GetCurrentLocationUseCase fakeGetCurrentLocationUseCase() {
        return new GetCurrentLocationUseCase(onLocationReceived -> onLocationReceived.data(LATITUDE, LONGITUDE));
    }

    public static GetCurrentLocationUseCase fakeGetCurrentLocationUseCaseFailed() {
        return new GetCurrentLocationUseCase(onLocationReceived -> onLocationReceived.dataInvalid());
    }

    private static ForecastRepository fakeForecastRepository() {
        return new ForecastRepository() {
            @Override
            public Single<ForecastData> fetchForecastData(String location, int dayRange, String getAirQuality, String getAlerts) {
                return Single.create(emitter -> {
                    ForecastData forecastData = new ForecastData();
                    forecastData.setLocation(LOCATION);
                    emitter.onSuccess(forecastData);
                });
            }

            @Override
            public Single<ForecastData> cacheForecastData(ForecastData forecastData) {
                return null;
            }

            @Override
            public Single<ForecastData> getCachedForecastData() {
                return null;
            }
        };
    }

    public static GetForecastUseCase fakeGetForecastUseCase() {
        return new GetForecastUseCase(fakeForecastRepository());
    }
}
