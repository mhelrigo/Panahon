package com.mhelrigo.domain.forecast.repository;

import com.mhelrigo.domain.forecast.entity.ForecastData;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public interface ForecastRepository {
    Single<ForecastData> fetchForecastData(String location, int dayRange, String getAirQuality, String getAlerts);
    Single<ForecastData> cacheForecastData(ForecastData forecastData);
    Single<ForecastData> getCachedForecastData();
}
