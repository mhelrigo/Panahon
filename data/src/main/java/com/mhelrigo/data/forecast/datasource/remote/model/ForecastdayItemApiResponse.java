package com.mhelrigo.data.forecast.datasource.remote.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ForecastdayItemApiResponse {

	@SerializedName("date")
	private String date;

	@SerializedName("astro")
	private AstroApiResponse astro;

	@SerializedName("date_epoch")
	private int dateEpoch;

	@SerializedName("hour")
	private List<HourItemApiResponse> hour;

	@SerializedName("day")
	private DayApiResponse day;

	public String getDate(){
		return date;
	}

	public AstroApiResponse getAstro(){
		return astro;
	}

	public int getDateEpoch(){
		return dateEpoch;
	}

	public List<HourItemApiResponse> getHour(){
		return hour;
	}

	public DayApiResponse getDay(){
		return day;
	}
}