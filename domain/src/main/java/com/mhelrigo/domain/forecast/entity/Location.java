package com.mhelrigo.domain.forecast.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Location {
    private String localtime;
    private String country;
    private int localtimeEpoch;
    private String name;
    private double lon;
    private String region;
    private double lat;
    private String tzId;

    public Location() {
    }

    public Location(String localtime, String country, int localtimeEpoch, String name, double lon, String region, double lat, String tzId) {
        this.localtime = localtime;
        this.country = country;
        this.localtimeEpoch = localtimeEpoch;
        this.name = name;
        this.lon = lon;
        this.region = region;
        this.lat = lat;
        this.tzId = tzId;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    public String getLocaltime() {
        return localtime;
    }

    public String parLocaltime() {
        return localtime.substring(localtime.indexOf(" "));
    }

    public String getLocaltimeForDisplaying() {
        return "as of" + parLocaltime();
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
