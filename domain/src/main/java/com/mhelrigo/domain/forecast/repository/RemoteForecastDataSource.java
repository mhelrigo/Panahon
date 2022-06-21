package com.mhelrigo.domain.forecast.repository;

import com.mhelrigo.domain.forecast.entity.ForecastData;

import io.reactivex.rxjava3.core.Single;

public interface RemoteForecastDataSource {
    Single<ForecastData> fetchForecastData(String location, int dayRange, String getAirQuality, String getAlerts);
}
