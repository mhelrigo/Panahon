package com.mhelrigo.data.forecast.datasource.local.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.mhelrigo.domain.forecast.entity.Current;
import com.mhelrigo.domain.forecast.entity.Forecast;
import com.mhelrigo.domain.forecast.entity.Location;

@Entity
public class ForecastDataDatabaseEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @Ignore
    private CurrentDatabaseEntity current;
    @Ignore
    private LocationDatabaseEntity location;
    @Ignore
    private ForecastDatabaseEntity forecast;
    private Long createdAt;
    private Long updateAt;

    public ForecastDataDatabaseEntity() {
    }

    public ForecastDataDatabaseEntity(Long createdAt, Long updateAt) {
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public void setCurrent(CurrentDatabaseEntity current){
        this.current = current;
    }

    public CurrentDatabaseEntity getCurrent(){
        return current;
    }

    public void setLocation(LocationDatabaseEntity location){
        this.location = location;
    }

    public LocationDatabaseEntity getLocation(){
        return location;
    }

    public void setForecast(ForecastDatabaseEntity forecast){
        this.forecast = forecast;
    }

    public ForecastDatabaseEntity getForecast(){
        return forecast;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }
}
