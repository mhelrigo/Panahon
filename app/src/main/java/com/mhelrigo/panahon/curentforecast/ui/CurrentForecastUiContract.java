package com.mhelrigo.panahon.curentforecast.ui;

import com.mhelrigo.domain.forecast.entity.ForecastData;

public interface CurrentForecastUiContract {
    interface View {
        void navigateToAppDetailSettings();

        void navigateToLocationSettings();
    }

    interface Presenter {
        void handleLocationPermissionStatus(boolean isGranted);

        void requestForCurrentLocation();

        void requestForForecastData(Double latitude, Double longitude);

        void onGoToAppDetailSettings();

        void onGoToLocationSettings();
    }

    interface ViewModel {
        void persistForecastData(ForecastData forecastData);

        void changeUiState(CurrentForecastUiState currentForecastUiState);
    }
}
