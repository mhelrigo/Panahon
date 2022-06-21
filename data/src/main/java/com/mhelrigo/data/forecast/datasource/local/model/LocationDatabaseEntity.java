package com.mhelrigo.data.forecast.datasource.local.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LocationDatabaseEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private int forecastDataId;
    private String localtime;
    private String country;
    private int localtimeEpoch;
    private String name;
    private double lon;
    private String region;
    private double lat;
    private String tzId;

    public LocationDatabaseEntity() {
    }

    public LocationDatabaseEntity(String localtime, String country, int localtimeEpoch, String name, double lon, String region, double lat, String tzId) {
        this.localtime = localtime;
        this.country = country;
        this.localtimeEpoch = localtimeEpoch;
        this.name = name;
        this.lon = lon;
        this.region = region;
        this.lat = lat;
        this.tzId = tzId;
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

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setLocaltimeEpoch(int localtimeEpoch) {
        this.localtimeEpoch = localtimeEpoch;
    }

    public int getLocaltimeEpoch() {
        return localtimeEpoch;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLon() {
        return lon;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLat() {
        return lat;
    }

    public void setTzId(String tzId) {
        this.tzId = tzId;
    }

    public String getTzId() {
        return tzId;
    }
}
