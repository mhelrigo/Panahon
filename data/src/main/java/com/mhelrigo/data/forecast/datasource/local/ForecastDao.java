package com.mhelrigo.data.forecast.datasource.local;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mhelrigo.data.forecast.datasource.local.model.CurrentDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.ForecastDataDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.ForecastDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.ForecastdayItemDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.HourItemDatabaseEntity;
import com.mhelrigo.data.forecast.datasource.local.model.LocationDatabaseEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface ForecastDao {
    @Insert(onConflict = REPLACE)
    Single<Long> saveForecastData(ForecastDataDatabaseEntity forecastDataDatabaseEntity);

    @Query("SELECT * FROM ForecastDataDatabaseEntity ORDER BY id ASC LIMIT 1")
    Single<ForecastDataDatabaseEntity> getForecastData();

    @Query("DELETE FROM ForecastDataDatabaseEntity")
    Completable deleteForecastData();

    @Insert(onConflict = REPLACE)
    Single<Long> saveCurrent(CurrentDatabaseEntity currentDatabaseEntity);

    @Query("SELECT * FROM CurrentDatabaseEntity WHERE forecastDataId = :forecastDataId")
    Single<CurrentDatabaseEntity> getCurrentForecast(int forecastDataId);

    @Query("DELETE FROM CurrentDatabaseEntity")
    Completable deleteCurrentForecast();

    @Insert(onConflict = REPLACE)
    Single<Long> saveLocation(LocationDatabaseEntity locationDatabaseEntity);

    @Query("SELECT * FROM LocationDatabaseEntity WHERE forecastDataId = :forecastDataId")
    Single<LocationDatabaseEntity> getLocationForecast(int forecastDataId);

    @Query("DELETE FROM LocationDatabaseEntity")
    Completable deleteLocationForecast();

    @Insert(onConflict = REPLACE)
    Single<Long> saveForecast(ForecastDatabaseEntity forecastDatabaseEntity);

    @Query("SELECT * FROM ForecastDatabaseEntity WHERE forecastDataId = :forecastDataId")
    Single<ForecastDatabaseEntity> getForecast(int forecastDataId);

    @Query("DELETE FROM ForecastDatabaseEntity")
    Completable deleteForecast();

    @Insert(onConflict = REPLACE)
    Single<Long> saveForecastDayItem(ForecastdayItemDatabaseEntity forecastdayItemDatabase);

    @Query("SELECT * FROM ForecastdayItemDatabaseEntity WHERE forecastDataId = :forecastDataId")
    Single<List<ForecastdayItemDatabaseEntity>> getForecastDayItem(int forecastDataId);

    @Query("DELETE FROM ForecastdayItemDatabaseEntity")
    Completable deleteForecastDayItem();

    @Insert(onConflict = REPLACE)
    Single<Long> saveForecastHourItem(HourItemDatabaseEntity hourItemDatabaseEntity);

    @Query("SELECT * FROM HourItemDatabaseEntity WHERE dayItemId = :dayItemId")
    Single<List<HourItemDatabaseEntity>> getForecastHourItem(int dayItemId);

    @Query("DELETE FROM HourItemDatabaseEntity")
    Completable deleteForecastHourItem();
}
