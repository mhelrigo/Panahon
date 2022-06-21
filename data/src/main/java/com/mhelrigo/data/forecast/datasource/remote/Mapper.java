package com.mhelrigo.data.forecast.datasource.remote;

import com.mhelrigo.data.forecast.datasource.local.model.ConditionDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.remote.model.ApiResponse;
import com.mhelrigo.data.forecast.datasource.remote.model.AstroApiResponse;
import com.mhelrigo.data.forecast.datasource.remote.model.ConditionApiResponse;
import com.mhelrigo.data.forecast.datasource.remote.model.CurrentApiResponse;
import com.mhelrigo.data.forecast.datasource.remote.model.DayApiResponse;
import com.mhelrigo.data.forecast.datasource.remote.model.ForecastApiResponse;
import com.mhelrigo.data.forecast.datasource.remote.model.ForecastdayItemApiResponse;
import com.mhelrigo.data.forecast.datasource.remote.model.HourItemApiResponse;
import com.mhelrigo.data.forecast.datasource.remote.model.LocationApiResponse;
import com.mhelrigo.domain.forecast.entity.Astro;
import com.mhelrigo.domain.forecast.entity.Condition;
import com.mhelrigo.domain.forecast.entity.Current;
import com.mhelrigo.domain.forecast.entity.Day;
import com.mhelrigo.domain.forecast.entity.Forecast;
import com.mhelrigo.domain.forecast.entity.ForecastData;
import com.mhelrigo.domain.forecast.entity.ForecastdayItem;
import com.mhelrigo.domain.forecast.entity.HourItem;
import com.mhelrigo.domain.forecast.entity.Location;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static ForecastData transform(ApiResponse apiResponse) {
        return new ForecastData(transform(apiResponse.getCurrent()),
                transform(apiResponse.getLocation()), transform(apiResponse.getForecast()));
    }

    public static Current transform(CurrentApiResponse currentApiResponse) {
        return new Current(currentApiResponse.getFeelslikeC(),
                currentApiResponse.getUv(),
                currentApiResponse.getLastUpdated(),
                currentApiResponse.getFeelslikeF(),
                currentApiResponse.getWindDegree(),
                currentApiResponse.getLastUpdatedEpoch(),
                currentApiResponse.getIsDay(),
                currentApiResponse.getPrecipIn(),
                currentApiResponse.getWindDir(),
                currentApiResponse.getGustMph(),
                currentApiResponse.getTempC(),
                currentApiResponse.getPressureIn(),
                currentApiResponse.getGustKph(),
                currentApiResponse.getTempF(),
                currentApiResponse.getPrecipMm(),
                currentApiResponse.getCloud(),
                currentApiResponse.getWindKph(),
                transform(currentApiResponse.getCondition()),
                currentApiResponse.getWindMph(),
                currentApiResponse.getVisKm(),
                currentApiResponse.getHumidity(),
                currentApiResponse.getPressureMb(),
                currentApiResponse.getVisMiles());
    }

    public static Condition transform(ConditionApiResponse conditionApiResponse) {
        return new Condition(conditionApiResponse.getCode(),
                conditionApiResponse.getIcon(),
                conditionApiResponse.getText());
    }

    public static Location transform(LocationApiResponse locationApiResponse) {
        return new Location(locationApiResponse.getLocaltime(),
                locationApiResponse.getCountry(),
                locationApiResponse.getLocaltimeEpoch(),
                locationApiResponse.getName(),
                locationApiResponse.getLon(),
                locationApiResponse.getRegion(),
                locationApiResponse.getLat(),
                locationApiResponse.getTzId());
    }

    public static Forecast transform(ForecastApiResponse forecastApiResponse) {
        return new Forecast(transformForecastDayItem(forecastApiResponse.getForecastday()));
    }

    public static List<ForecastdayItem> transformForecastDayItem(List<ForecastdayItemApiResponse> forecastdayItemApiResponses) {
        ArrayList<ForecastdayItem> forecastdayItems = new ArrayList<>();

        for (ForecastdayItemApiResponse forecastdayItemApiResponse : forecastdayItemApiResponses) {
            forecastdayItems.add(transform(forecastdayItemApiResponse));
        }

        return forecastdayItems;
    }

    public static ForecastdayItem transform(ForecastdayItemApiResponse forecastdayItemApiResponse) {
        return new ForecastdayItem(
                forecastdayItemApiResponse.getDate(),
                transform(forecastdayItemApiResponse.getAstro()),
                forecastdayItemApiResponse.getDateEpoch(),
                transform(forecastdayItemApiResponse.getHour()),
                transform(forecastdayItemApiResponse.getDay())
        );
    }

    public static Astro transform(AstroApiResponse astroApiResponse) {
        return new Astro(astroApiResponse.getMoonset(),
                astroApiResponse.getMoonIllumination(),
                astroApiResponse.getSunrise(),
                astroApiResponse.getMoonPhase(),
                astroApiResponse.getSunset(),
                astroApiResponse.getMoonrise());
    }

    public static List<HourItem> transform(List<HourItemApiResponse> hourItemApiResponses) {
        ArrayList<HourItem> hourItems = new ArrayList<>();

        for (HourItemApiResponse hourItemApiResponse : hourItemApiResponses) {
            hourItems.add(transform(hourItemApiResponse));
        }

        return hourItems;
    }

    public static HourItem transform(HourItemApiResponse hourItemApiResponse) {
        return new HourItem(hourItemApiResponse.getFeelslikeC(),
                hourItemApiResponse.getFeelslikeF(),
                hourItemApiResponse.getWindDegree(),
                hourItemApiResponse.getWindchillF(),
                hourItemApiResponse.getWindchillC(),
                hourItemApiResponse.getTempC(),
                hourItemApiResponse.getTempF(),
                hourItemApiResponse.getCloud(),
                hourItemApiResponse.getWindKph(),
                hourItemApiResponse.getWindMph(),
                hourItemApiResponse.getHumidity(),
                hourItemApiResponse.getDewpointF(),
                hourItemApiResponse.getWillItRain(),
                hourItemApiResponse.getUv(),
                hourItemApiResponse.getHeatindexF(),
                hourItemApiResponse.getDewpointC(),
                hourItemApiResponse.getIsDay(),
                hourItemApiResponse.getPrecipIn(),
                hourItemApiResponse.getHeatindexC(),
                hourItemApiResponse.getWindDir(),
                hourItemApiResponse.getGustMph(),
                hourItemApiResponse.getPressureIn(),
                hourItemApiResponse.getChanceOfRain(),
                hourItemApiResponse.getGustKph(), hourItemApiResponse.getPrecipMm(),
                transform(hourItemApiResponse.getCondition()),
                hourItemApiResponse.getWillItSnow(),
                hourItemApiResponse.getVisKm(),
                hourItemApiResponse.getTimeEpoch(),
                hourItemApiResponse.getTime(),
                hourItemApiResponse.getChanceOfSnow(),
                hourItemApiResponse.getPressureMb(),
                hourItemApiResponse.getVisMiles());
    }

    public static Day transform(DayApiResponse dayApiResponse) {
        return new Day(dayApiResponse.getAvgvisKm(),
                dayApiResponse.getUv(),
                dayApiResponse.getAvgtempF(),
                dayApiResponse.getAvgtempC(),
                dayApiResponse.getDailyChanceOfSnow(),
                dayApiResponse.getMaxtempC(),
                dayApiResponse.getMaxtempF(),
                dayApiResponse.getMintempC(),
                dayApiResponse.getAvgvisMiles(),
                dayApiResponse.getDailyWillItRain(),
                dayApiResponse.getMintempF(),
                dayApiResponse.getTotalprecipIn(),
                dayApiResponse.getAvghumidity(),
                transform(dayApiResponse.getCondition()),
                dayApiResponse.getMaxwindKph(),
                dayApiResponse.getMaxwindMph(),
                dayApiResponse.getDailyChanceOfRain(),
                dayApiResponse.getTotalprecipMm(),
                dayApiResponse.getDailyWillItSnow());
    }
}
