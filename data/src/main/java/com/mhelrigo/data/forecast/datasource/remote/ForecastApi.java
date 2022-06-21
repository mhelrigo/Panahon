package com.mhelrigo.data.forecast.datasource.remote;

import com.mhelrigo.data.BuildConfig;
import com.mhelrigo.data.forecast.datasource.remote.model.ApiResponse;
import com.mhelrigo.domain.forecast.entity.ForecastData;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ForecastApi {
    @GET("forecast.json?key=" + BuildConfig.API_KEY)
    Single<ApiResponse> get(@Query("q") String location,
                            @Query("days") int dayRange,
                            @Query("aqi") String airQuality,
                            @Query("alerts") String getAlerts);
}
