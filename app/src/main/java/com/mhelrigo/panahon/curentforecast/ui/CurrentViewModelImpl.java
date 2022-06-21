package com.mhelrigo.panahon.curentforecast.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mhelrigo.domain.forecast.entity.ForecastData;

public class CurrentViewModelImpl extends ViewModel implements CurrentForecastUiContract.ViewModel {

    public MutableLiveData<ForecastData> forecastDataLiveData = new MutableLiveData<>();
    public MutableLiveData<CurrentForecastUiState> currentForecastUiStateMutableLiveData = new MutableLiveData<>();

    public CurrentViewModelImpl() {
    }

    @Override
    public void persistForecastData(ForecastData forecastData) {
        forecastDataLiveData.postValue(forecastData);
    }

    @Override
    public void changeUiState(CurrentForecastUiState currentForecastUiState) {
        currentForecastUiStateMutableLiveData.postValue(currentForecastUiState);
    }
}
