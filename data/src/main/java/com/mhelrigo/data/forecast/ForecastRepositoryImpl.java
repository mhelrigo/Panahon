package com.mhelrigo.data.forecast;

import android.util.Log;

import com.mhelrigo.domain.forecast.repository.LocalForecastDataSource;
import com.mhelrigo.domain.forecast.repository.RemoteForecastDataSource;
import com.mhelrigo.domain.forecast.repository.ForecastRepository;
import com.mhelrigo.domain.forecast.entity.ForecastData;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Consumer;

public class ForecastRepositoryImpl implements ForecastRepository {

    private RemoteForecastDataSource remoteForecastDataSource;
    private LocalForecastDataSource localForecastDataSource;

    public ForecastRepositoryImpl(RemoteForecastDataSource remoteForecastDataSource, LocalForecastDataSource localForecastDataSource) {
        this.remoteForecastDataSource = remoteForecastDataSource;
        this.localForecastDataSource = localForecastDataSource;
    }

    @Override
    public Single<ForecastData> fetchForecastData(String location, int dayRange, String getAirQuality, String getAlerts) {
        return remoteForecastDataSource.fetchForecastData(location, dayRange, getAirQuality, getAlerts)
                .concatMap(forecastData -> cacheForecastData(forecastData))
                .onErrorResumeNext(throwable -> {
                    throwable.printStackTrace();
                    return getCachedForecastData();
                });
    }

    @Override
    public Single<ForecastData> cacheForecastData(ForecastData forecastData) {
        return localForecastDataSource.deleteAll().andThen(localForecastDataSource.saveForecast(forecastData))
                .flatMap(forecastDataId -> localForecastDataSource.saveCurrent(forecastData.getCurrent(), forecastDataId.intValue()).map(current -> forecastDataId))
                .flatMap(forecastDataId -> localForecastDataSource.saveLocation(forecastData.getLocation(), forecastDataId.intValue()).map(location -> forecastDataId))
                .flatMapCompletable(forecastDataId -> localForecastDataSource.saveForecastData(forecastData.getForecast(), forecastDataId.intValue()))
                .andThen(Single.just(forecastData));
    }

    @Override
    public Single<ForecastData> getCachedForecastData() {
        return localForecastDataSource.getCachedForecastData();
    }
}
