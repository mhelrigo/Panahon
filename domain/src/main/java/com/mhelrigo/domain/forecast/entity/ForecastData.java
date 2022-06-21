package com.mhelrigo.domain.forecast.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ForecastData {
	private Current current;
	private Location location;
	private Forecast forecast;
	private HourItem currentHour;

	public ForecastData() {
	}

	public ForecastData(Current current, Location location, Forecast forecast) {
		this.current = current;
		this.location = location;
		this.forecast = forecast;
	}

	public void setCurrent(Current current){
		this.current = current;
	}

	public Current getCurrent(){
		return current;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setForecast(Forecast forecast){
		this.forecast = forecast;
	}

	public Forecast getForecast(){
		return forecast;
	}

	public void setCurrentHour(HourItem currentHour) {
		this.currentHour = currentHour;
	}

	public HourItem getCurrentHour() {
		return currentHour;
	}

	public HourItem findCurrentHour() throws ParseException {
		Date currentDate = new Date();
		Date dateOfHourlyForecast = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
		currentDate = simpleDateFormat.parse(location.getLocaltime());

		ForecastdayItem forecastdayItem = forecast.getForecastday().get(0);

		for (HourItem hourItem : forecastdayItem.getHour()) {
			dateOfHourlyForecast = simpleDateFormat.parse(hourItem.getTime());
			if (currentDate.compareTo(dateOfHourlyForecast) == 1) {
				return hourItem;
			}
		}

		throw new IllegalArgumentException();
	}
}
