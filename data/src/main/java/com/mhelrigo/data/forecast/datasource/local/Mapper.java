package com.mhelrigo.data.forecast.datasource.local;

import com.mhelrigo.data.forecast.datasource.local.model.AstroDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.ConditionDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.CurrentDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.DayDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.ForecastDataDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.ForecastDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.ForecastdayItemDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.HourItemDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.LocationDatabaseEntity;
import com.mhelrigo.domain.forecast.entity.Astro;
import com.mhelrigo.domain.forecast.entity.Condition;
import com.mhelrigo.domain.forecast.entity.Current;
import com.mhelrigo.domain.forecast.entity.Day;
import com.mhelrigo.domain.forecast.entity.Forecast;
import com.mhelrigo.domain.forecast.entity.ForecastData;
import com.mhelrigo.domain.forecast.entity.ForecastdayItem;
import com.mhelrigo.domain.forecast.entity.HourItem;
import com.mhelrigo.domain.forecast.entity.Location;

import java.util.ArrayList;
import java.util.List;

class Mapper {
    public static ForecastData transform(ForecastDataDatabaseEntity forecastDataDatabaseEntity) {
        return new ForecastData(transform(forecastDataDatabaseEntity.getCurrent()),
                transform(forecastDataDatabaseEntity.getLocation()), transform(forecastDataDatabaseEntity.getForecast()));
    }

    public static Current transform(CurrentDatabaseEntity currentDatabaseEntity) {
        return new Current(currentDatabaseEntity.getFeelslikeC(),
                currentDatabaseEntity.getUv(),
                currentDatabaseEntity.getLastUpdated(),
                currentDatabaseEntity.getFeelslikeF(),
                currentDatabaseEntity.getWindDegree(),
                currentDatabaseEntity.getLastUpdatedEpoch(),
                currentDatabaseEntity.getIsDay(),
                currentDatabaseEntity.getPrecipIn(),
                currentDatabaseEntity.getWindDir(),
                currentDatabaseEntity.getGustMph(),
                currentDatabaseEntity.getTempC(),
                currentDatabaseEntity.getPressureIn(),
                currentDatabaseEntity.getGustKph(),
                currentDatabaseEntity.getTempF(),
                currentDatabaseEntity.getPrecipMm(),
                currentDatabaseEntity.getCloud(),
                currentDatabaseEntity.getWindKph(),
                transform(currentDatabaseEntity.getCondition()),
                currentDatabaseEntity.getWindMph(),
                currentDatabaseEntity.getVisKm(),
                currentDatabaseEntity.getHumidity(),
                currentDatabaseEntity.getPressureMb(),
                currentDatabaseEntity.getVisMiles());
    }

    public static Condition transform(ConditionDatabaseEntity conditionDatabaseEntity) {
        return new Condition(conditionDatabaseEntity.getCode(),
                conditionDatabaseEntity.getIcon(),
                conditionDatabaseEntity.getText());
    }

    public static Location transform(LocationDatabaseEntity locationDatabaseEntity) {
        return new Location(locationDatabaseEntity.getLocaltime(),
                locationDatabaseEntity.getCountry(),
                locationDatabaseEntity.getLocaltimeEpoch(),
                locationDatabaseEntity.getName(),
                locationDatabaseEntity.getLon(),
                locationDatabaseEntity.getRegion(),
                locationDatabaseEntity.getLat(),
                locationDatabaseEntity.getTzId());
    }

    public static Forecast transform(ForecastDatabaseEntity forecastDatabaseEntity) {
        return new Forecast(transformForecastDayItemDatabaseEntity(forecastDatabaseEntity.getForecastday()));
    }

    public static List<ForecastdayItem> transformForecastDayItemDatabaseEntity(List<ForecastdayItemDatabaseEntity> forecastdayItemDatabaseEntities) {
        ArrayList<ForecastdayItem> forecastdayItems = new ArrayList<>();

        for (ForecastdayItemDatabaseEntity forecastdayItemDatabaseEntity : forecastdayItemDatabaseEntities) {
            forecastdayItems.add(transform(forecastdayItemDatabaseEntity));
        }

        return forecastdayItems;
    }

    public static ForecastdayItem transform(ForecastdayItemDatabaseEntity forecastdayItemDatabaseEntity) {
        return new ForecastdayItem(forecastdayItemDatabaseEntity.getDate(),
                transform(forecastdayItemDatabaseEntity.getAstro()),
                forecastdayItemDatabaseEntity.getDateEpoch(),
                transformHourItemDatabaseEntity(forecastdayItemDatabaseEntity.getHour()),
                transform(forecastdayItemDatabaseEntity.getDay()));
    }

    public static Astro transform(AstroDatabaseEntity astroDatabaseEntity) {
        return new Astro(astroDatabaseEntity.getMoonset(),
                astroDatabaseEntity.getMoonIllumination(),
                astroDatabaseEntity.getSunrise(),
                astroDatabaseEntity.getMoonPhase(),
                astroDatabaseEntity.getSunset(),
                astroDatabaseEntity.getMoonrise());
    }

    public static List<HourItem> transformHourItemDatabaseEntity(List<HourItemDatabaseEntity> hourItemDatabaseEntities) {
        ArrayList<HourItem> hourItems = new ArrayList<>();

        for (HourItemDatabaseEntity hourItemDatabaseEntity : hourItemDatabaseEntities) {
            hourItems.add(transform(hourItemDatabaseEntity));
        }

        return hourItems;
    }

    public static Day transform(DayDatabaseEntity dayDatabaseEntity) {
        return new Day(dayDatabaseEntity.getAvgvisKm(),
                dayDatabaseEntity.getUv(),
                dayDatabaseEntity.getAvgtempF(),
                dayDatabaseEntity.getAvgtempC(),
                dayDatabaseEntity.getDailyChanceOfSnow(),
                dayDatabaseEntity.getMaxtempC(),
                dayDatabaseEntity.getMaxtempF(),
                dayDatabaseEntity.getMintempC(),
                dayDatabaseEntity.getAvgvisMiles(),
                dayDatabaseEntity.getDailyWillItRain(),
                dayDatabaseEntity.getMintempF(),
                dayDatabaseEntity.getTotalprecipIn(),
                dayDatabaseEntity.getAvghumidity(),
                transform(dayDatabaseEntity.getCondition()),
                dayDatabaseEntity.getMaxwindKph(),
                dayDatabaseEntity.getMaxwindMph(),
                dayDatabaseEntity.getDailyChanceOfRain(),
                dayDatabaseEntity.getTotalprecipMm(),
                dayDatabaseEntity.getDailyWillItSnow());
    }

    public static HourItem transform(HourItemDatabaseEntity hourItemDatabaseEntity) {
        return new HourItem(hourItemDatabaseEntity.getFeelslikeC(),
                hourItemDatabaseEntity.getFeelslikeF(),
                hourItemDatabaseEntity.getWindDegree(),
                hourItemDatabaseEntity.getWindchillF(),
                hourItemDatabaseEntity.getWindchillC(),
                hourItemDatabaseEntity.getTempC(),
                hourItemDatabaseEntity.getTempF(),
                hourItemDatabaseEntity.getCloud(),
                hourItemDatabaseEntity.getWindKph(),
                hourItemDatabaseEntity.getWindMph(),
                hourItemDatabaseEntity.getHumidity(),
                hourItemDatabaseEntity.getDewpointF(),
                hourItemDatabaseEntity.getWillItRain(),
                hourItemDatabaseEntity.getUv(),
                hourItemDatabaseEntity.getHeatindexF(),
                hourItemDatabaseEntity.getDewpointC(),
                hourItemDatabaseEntity.getIsDay(),
                hourItemDatabaseEntity.getPrecipIn(),
                hourItemDatabaseEntity.getHeatindexC(),
                hourItemDatabaseEntity.getWindDir(),
                hourItemDatabaseEntity.getGustMph(),
                hourItemDatabaseEntity.getPressureIn(),
                hourItemDatabaseEntity.getChanceOfRain(),
                hourItemDatabaseEntity.getGustKph(), hourItemDatabaseEntity.getPrecipMm(),
                transform(hourItemDatabaseEntity.getCondition()),
                hourItemDatabaseEntity.getWillItSnow(),
                hourItemDatabaseEntity.getVisKm(),
                hourItemDatabaseEntity.getTimeEpoch(),
                hourItemDatabaseEntity.getTime(),
                hourItemDatabaseEntity.getChanceOfSnow(),
                hourItemDatabaseEntity.getPressureMb(),
                hourItemDatabaseEntity.getVisMiles());
    }

    public static CurrentDatabaseEntity transform(Current current, int id) {
        CurrentDatabaseEntity currentDatabaseEntity =
                new CurrentDatabaseEntity(current.getFeelslikeC(),
                        current.getUv(),
                        current.getLastUpdated(),
                        current.getFeelslikeF(),
                        current.getWindDegree(),
                        current.getLastUpdatedEpoch(),
                        current.getIsDay(),
                        current.getPrecipIn(),
                        current.getWindDir(),
                        current.getGustMph(),
                        current.getTempC(),
                        current.getPressureIn(),
                        current.getGustKph(),
                        current.getTempF(),
                        current.getPrecipMm(),
                        current.getCloud(),
                        current.getWindKph(),
                        transform(current.getCondition(), ConditionDatabaseEntity.Type.DAILY),
                        current.getWindMph(),
                        current.getVisKm(),
                        current.getHumidity(),
                        current.getPressureMb(),
                        current.getVisMiles()
                );

        currentDatabaseEntity.setForecastDataId(id);

        return currentDatabaseEntity;
    }

    public static ConditionDatabaseEntity transform(Condition condition, ConditionDatabaseEntity.Type type) {
        return new ConditionDatabaseEntity(condition.getCode(),
                condition.getIcon(),
                condition.getText(),
                type);
    }

    public static LocationDatabaseEntity transform(Location location, int forecastId) {
        LocationDatabaseEntity locationDatabaseEntity =
                new LocationDatabaseEntity(location.getLocaltime(),
                        location.getCountry(),
                        location.getLocaltimeEpoch(),
                        location.getName(),
                        location.getLon(),
                        location.getRegion(),
                        location.getLat(),
                        location.getTzId());

        locationDatabaseEntity.setForecastDataId(forecastId);

        return locationDatabaseEntity;
    }

    public static ForecastDatabaseEntity transform(Forecast forecast, int forecastId) {
        ForecastDatabaseEntity forecastDatabaseEntity =
                new ForecastDatabaseEntity(transformForecastDayItem(forecast.getForecastday()));

        forecastDatabaseEntity.setForecastDataId(forecastId);

        return forecastDatabaseEntity;
    }

    public static ForecastdayItemDatabaseEntity transform(ForecastdayItem forecastdayItem) {
        ForecastdayItemDatabaseEntity forecastdayItemDatabaseEntity = new ForecastdayItemDatabaseEntity(
                forecastdayItem.getDate(),
                transform(forecastdayItem.getAstro()),
                forecastdayItem.getDateEpoch(),
                transformHourItem(forecastdayItem.getHour()),
                transform(forecastdayItem.getDay())
        );

        forecastdayItemDatabaseEntity.setForecastDataId(forecastdayItem.getForecastDataId());

        return forecastdayItemDatabaseEntity;
    }

    public static List<ForecastdayItemDatabaseEntity> transformForecastDayItem(List<ForecastdayItem> forecastdayItems) {
        ArrayList<ForecastdayItemDatabaseEntity> forecastdayItemDatabaseEntities = new ArrayList<>();

        for (ForecastdayItem forecastDayItem :
                forecastdayItems) {
            forecastdayItemDatabaseEntities.add(transform(forecastDayItem));
        }

        return forecastdayItemDatabaseEntities;
    }

    public static AstroDatabaseEntity transform(Astro astro) {
        return new AstroDatabaseEntity(astro.getMoonset(),
                astro.getMoonIllumination(),
                astro.getSunrise(),
                astro.getMoonPhase(),
                astro.getSunset(),
                astro.getMoonrise());
    }

    public static HourItemDatabaseEntity transform(HourItem hourItem) {
        HourItemDatabaseEntity hourItemDatabaseEntity = new HourItemDatabaseEntity(
                hourItem.getFeelslikeC(),
                hourItem.getFeelslikeF(),
                hourItem.getWindDegree(),
                hourItem.getWindchillF(),
                hourItem.getWindchillC(),
                hourItem.getTempC(),
                hourItem.getTempF(),
                hourItem.getCloud(),
                hourItem.getWindKph(),
                hourItem.getWindMph(),
                hourItem.getHumidity(),
                hourItem.getDewpointF(),
                hourItem.getWillItRain(),
                hourItem.getUv(),
                hourItem.getHeatindexF(),
                hourItem.getDewpointC(),
                hourItem.getIsDay(),
                hourItem.getPrecipIn(),
                hourItem.getHeatindexC(),
                hourItem.getWindDir(),
                hourItem.getGustMph(),
                hourItem.getPressureIn(),
                hourItem.getChanceOfRain(),
                hourItem.getGustKph(), hourItem.getPrecipMm(),
                transform(hourItem.getCondition(), ConditionDatabaseEntity.Type.HOURLY),
                hourItem.getWillItSnow(),
                hourItem.getVisKm(),
                hourItem.getTimeEpoch(),
                hourItem.getTime(),
                hourItem.getChanceOfSnow(),
                hourItem.getPressureMb(),
                hourItem.getVisMiles()
        );

        hourItemDatabaseEntity.setDayItemId(hourItem.getDayItemId());

        return hourItemDatabaseEntity;
    }

    public static List<HourItemDatabaseEntity> transformHourItem(List<HourItem> hourItems) {
        ArrayList<HourItemDatabaseEntity> hourItemDatabaseEntities = new ArrayList<>();

        for (HourItem hourItem : hourItems) {
            hourItemDatabaseEntities.add(transform(hourItem));
        }

        return hourItemDatabaseEntities;
    }

    public static DayDatabaseEntity transform(Day day) {
        return new DayDatabaseEntity(
                day.getAvgvisKm(),
                day.getUv(),
                day.getAvgtempF(),
                day.getAvgtempC(),
                day.getDailyChanceOfSnow(),
                day.getMaxtempC(),
                day.getMaxtempF(),
                day.getMintempC(),
                day.getAvgvisMiles(),
                day.getDailyWillItRain(),
                day.getMintempF(),
                day.getTotalprecipIn(),
                day.getAvghumidity(),
                transform(day.getCondition(), ConditionDatabaseEntity.Type.DAILY),
                day.getMaxwindKph(),
                day.getMaxwindMph(),
                day.getDailyChanceOfRain(),
                day.getTotalprecipMm(),
                day.getDailyWillItSnow()
        );
    }

    public static ForecastDataDatabaseEntity transform(ForecastData forecastData) {
        ForecastDataDatabaseEntity forecastDataDatabaseEntity =
                new ForecastDataDatabaseEntity(System.currentTimeMillis(),
                        System.currentTimeMillis());

        return forecastDataDatabaseEntity;
    }
}
