package com.mhelrigo.data.forecast.datasource.remote.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ForecastApiResponse {

	@SerializedName("forecastday")
	private List<ForecastdayItemApiResponse> forecastday;

	public List<ForecastdayItemApiResponse> getForecastday(){
		return forecastday;
	}
}