package com.mhelrigo.data.forecast.datasource.remote;

import com.mhelrigo.domain.forecast.entity.ForecastData;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;

public class RemoteForecastDataSourceImpl implements com.mhelrigo.domain.forecast.repository.RemoteForecastDataSource {

    private ForecastApi forecastApi;

    public RemoteForecastDataSourceImpl(Retrofit retrofit) {
        this.forecastApi = retrofit.create(ForecastApi.class);
    }

    @Override
    public Single<ForecastData> fetchForecastData(String location, int dayRange, String getAirQuality, String getAlerts) {
        return forecastApi.get(location, dayRange, getAirQuality, getAlerts)
                .map(apiResponse -> Mapper.transform(apiResponse))
                .subscribeOn(Schedulers.io());
    }
}
