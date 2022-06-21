package com.mhelrigo.data.forecast.datasource.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.mhelrigo.data.forecast.datasource.local.model.AstroDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.ConditionDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.CurrentDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.DayDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.ForecastDataDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.ForecastDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.ForecastdayItemDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.HourItemDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.LocationDatabaseEntity;

@Database(entities = {CurrentDatabaseEntity.class,
        ForecastDatabaseEntity.class,
        ForecastDataDatabaseEntity.class,
        ForecastdayItemDatabaseEntity.class,
        HourItemDatabaseEntity.class,
        LocationDatabaseEntity.class}, version = 1, exportSchema = false)
public abstract class PanahonDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "panahon_database";

    public PanahonDatabase() {
    }

    public abstract ForecastDao forecastDao();
}
