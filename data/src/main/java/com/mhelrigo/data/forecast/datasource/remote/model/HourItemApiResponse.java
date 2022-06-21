package com.mhelrigo.data.forecast.datasource.remote.model;

import com.google.gson.annotations.SerializedName;

public class HourItemApiResponse {

	@SerializedName("feelslike_c")
	private double feelslikeC;

	@SerializedName("feelslike_f")
	private double feelslikeF;

	@SerializedName("wind_degree")
	private int windDegree;

	@SerializedName("windchill_f")
	private double windchillF;

	@SerializedName("windchill_c")
	private double windchillC;

	@SerializedName("temp_c")
	private double tempC;

	@SerializedName("temp_f")
	private double tempF;

	@SerializedName("cloud")
	private int cloud;

	@SerializedName("wind_kph")
	private double windKph;

	@SerializedName("wind_mph")
	private double windMph;

	@SerializedName("humidity")
	private int humidity;

	@SerializedName("dewpoint_f")
	private double dewpointF;

	@SerializedName("will_it_rain")
	private int willItRain;

	@SerializedName("uv")
	private double uv;

	@SerializedName("heatindex_f")
	private double heatindexF;

	@SerializedName("dewpoint_c")
	private double dewpointC;

	@SerializedName("is_day")
	private int isDay;

	@SerializedName("precip_in")
	private double precipIn;

	@SerializedName("heatindex_c")
	private double heatindexC;

	@SerializedName("wind_dir")
	private String windDir;

	@SerializedName("gust_mph")
	private double gustMph;

	@SerializedName("pressure_in")
	private double pressureIn;

	@SerializedName("chance_of_rain")
	private int chanceOfRain;

	@SerializedName("gust_kph")
	private double gustKph;

	@SerializedName("precip_mm")
	private double precipMm;

	@SerializedName("condition")
	private ConditionApiResponse conditionApiResponse;

	@SerializedName("will_it_snow")
	private int willItSnow;

	@SerializedName("vis_km")
	private double visKm;

	@SerializedName("time_epoch")
	private int timeEpoch;

	@SerializedName("time")
	private String time;

	@SerializedName("chance_of_snow")
	private int chanceOfSnow;

	@SerializedName("pressure_mb")
	private double pressureMb;

	@SerializedName("vis_miles")
	private double visMiles;

	public double getFeelslikeC(){
		return feelslikeC;
	}

	public double getFeelslikeF(){
		return feelslikeF;
	}

	public int getWindDegree(){
		return windDegree;
	}

	public double getWindchillF(){
		return windchillF;
	}

	public double getWindchillC(){
		return windchillC;
	}

	public double getTempC(){
		return tempC;
	}

	public double getTempF(){
		return tempF;
	}

	public int getCloud(){
		return cloud;
	}

	public double getWindKph(){
		return windKph;
	}

	public double getWindMph(){
		return windMph;
	}

	public int getHumidity(){
		return humidity;
	}

	public double getDewpointF(){
		return dewpointF;
	}

	public int getWillItRain(){
		return willItRain;
	}

	public double getUv(){
		return uv;
	}

	public double getHeatindexF(){
		return heatindexF;
	}

	public double getDewpointC(){
		return dewpointC;
	}

	public int getIsDay(){
		return isDay;
	}

	public double getPrecipIn(){
		return precipIn;
	}

	public double getHeatindexC(){
		return heatindexC;
	}

	public String getWindDir(){
		return windDir;
	}

	public double getGustMph(){
		return gustMph;
	}

	public double getPressureIn(){
		return pressureIn;
	}

	public int getChanceOfRain(){
		return chanceOfRain;
	}

	public double getGustKph(){
		return gustKph;
	}

	public double getPrecipMm(){
		return precipMm;
	}

	public ConditionApiResponse getCondition(){
		return conditionApiResponse;
	}

	public int getWillItSnow(){
		return willItSnow;
	}

	public double getVisKm(){
		return visKm;
	}

	public int getTimeEpoch(){
		return timeEpoch;
	}

	public String getTime(){
		return time;
	}

	public int getChanceOfSnow(){
		return chanceOfSnow;
	}

	public double getPressureMb(){
		return pressureMb;
	}

	public double getVisMiles(){
		return visMiles;
	}
}