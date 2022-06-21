package com.mhelrigo.domain.forecast.repository;

import com.mhelrigo.domain.forecast.entity.Current;
import com.mhelrigo.domain.forecast.entity.Forecast;
import com.mhelrigo.domain.forecast.entity.ForecastData;
import com.mhelrigo.domain.forecast.entity.ForecastdayItem;
import com.mhelrigo.domain.forecast.entity.HourItem;
import com.mhelrigo.domain.forecast.entity.Location;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public interface LocalForecastDataSource {
    Single<Long> saveForecast(ForecastData forecastData);
    Single<Long> saveCurrent(Current current, int forecastId);
    Single<Long> saveLocation(Location location, int forecastId);
    Completable saveForecastData(Forecast forecast, int forecastId);
    Completable saveForecastDayItem(ForecastdayItem forecastdayItem);
    Single<Long> saveForecastHourItem(HourItem hourItem);
    Single<ForecastData> getCachedForecastData();
    Completable deleteAll();
}
