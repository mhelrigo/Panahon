package com.mhelrigo.data.forecast.datasource.local.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class ForecastDatabaseEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private int forecastDataId;
    @Ignore
    private List<ForecastdayItemDatabaseEntity> forecastday;

    public ForecastDatabaseEntity() {
    }

    public ForecastDatabaseEntity(List<ForecastdayItemDatabaseEntity> forecastday) {
        this.forecastday = forecastday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getForecastDataId() {
        return forecastDataId;
    }

    public void setForecastDataId(int forecastDataId) {
        this.forecastDataId = forecastDataId;
    }

    public void setForecastday(List<ForecastdayItemDatabaseEntity> forecastday) {
        this.forecastday = forecastday;
    }

    public List<ForecastdayItemDatabaseEntity> getForecastday() {
        return forecastday;
    }
}
