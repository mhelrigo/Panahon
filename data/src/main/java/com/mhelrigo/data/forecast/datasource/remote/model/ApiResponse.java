package com.mhelrigo.data.forecast.datasource.remote.model;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {

	@SerializedName("current")
	private CurrentApiResponse currentApiResponse;

	@SerializedName("location")
	private LocationApiResponse locationApiResponse;

	@SerializedName("forecast")
	private ForecastApiResponse forecastApiResponse;

	public CurrentApiResponse getCurrent(){
		return currentApiResponse;
	}

	public LocationApiResponse getLocation(){
		return locationApiResponse;
	}

	public ForecastApiResponse getForecast(){
		return forecastApiResponse;
	}
}