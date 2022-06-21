package com.mhelrigo.domain.forecast.entity;

import java.util.List;

public class Forecast{
	private List<ForecastdayItem> forecastday;

	public Forecast() {
	}

	public Forecast(List<ForecastdayItem> forecastday) {
		this.forecastday = forecastday;
	}

	public void setForecastday(List<ForecastdayItem> forecastday){
		this.forecastday = forecastday;
	}

	public List<ForecastdayItem> getForecastday(){
		return forecastday;
	}
}