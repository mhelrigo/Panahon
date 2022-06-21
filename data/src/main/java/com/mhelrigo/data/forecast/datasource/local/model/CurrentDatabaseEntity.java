package com.mhelrigo.data.forecast.datasource.local.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CurrentDatabaseEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private int forecastDataId;
    private double feelslikeC;
    private double uv;
    private String lastUpdated;
    private double feelslikeF;
    private int windDegree;
    private int lastUpdatedEpoch;
    private int isDay;
    private double precipIn;
    private String windDir;
    private double gustMph;
    private double tempC;
    private double pressureIn;
    private double gustKph;
    private double tempF;
    private double precipMm;
    private int cloud;
    private double windKph;
    @Embedded
    private ConditionDatabaseEntity condition;
    private double windMph;
    private double visKm;
    private int humidity;
    private double pressureMb;
    private double visMiles;

    public CurrentDatabaseEntity() {
    }

    public CurrentDatabaseEntity(double feelslikeC, double uv, String lastUpdated, double feelslikeF, int windDegree, int lastUpdatedEpoch, int isDay, double precipIn, String windDir, double gustMph, double tempC, double pressureIn, double gustKph, double tempF, double precipMm, int cloud, double windKph, ConditionDatabaseEntity condition, double windMph, double visKm, int humidity, double pressureMb, double visMiles) {
        this.feelslikeC = feelslikeC;
        this.uv = uv;
        this.lastUpdated = lastUpdated;
        this.feelslikeF = feelslikeF;
        this.windDegree = windDegree;
        this.lastUpdatedEpoch = lastUpdatedEpoch;
        this.isDay = isDay;
        this.precipIn = precipIn;
        this.windDir = windDir;
        this.gustMph = gustMph;
        this.tempC = tempC;
        this.pressureIn = pressureIn;
        this.gustKph = gustKph;
        this.tempF = tempF;
        this.precipMm = precipMm;
        this.cloud = cloud;
        this.windKph = windKph;
        this.condition = condition;
        this.windMph = windMph;
        this.visKm = visKm;
        this.humidity = humidity;
        this.pressureMb = pressureMb;
        this.visMiles = visMiles;
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

    public void setFeelslikeC(double feelslikeC) {
        this.feelslikeC = feelslikeC;
    }

    public double getFeelslikeC() {
        return feelslikeC;
    }

    public void setUv(double uv) {
        this.uv = uv;
    }

    public double getUv() {
        return uv;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setFeelslikeF(double feelslikeF) {
        this.feelslikeF = feelslikeF;
    }

    public double getFeelslikeF() {
        return feelslikeF;
    }

    public void setWindDegree(int windDegree) {
        this.windDegree = windDegree;
    }

    public int getWindDegree() {
        return windDegree;
    }

    public void setLastUpdatedEpoch(int lastUpdatedEpoch) {
        this.lastUpdatedEpoch = lastUpdatedEpoch;
    }

    public int getLastUpdatedEpoch() {
        return lastUpdatedEpoch;
    }

    public void setIsDay(int isDay) {
        this.isDay = isDay;
    }

    public int getIsDay() {
        return isDay;
    }

    public void setPrecipIn(double precipIn) {
        this.precipIn = precipIn;
    }

    public double getPrecipIn() {
        return precipIn;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setGustMph(double gustMph) {
        this.gustMph = gustMph;
    }

    public double getGustMph() {
        return gustMph;
    }

    public void setTempC(double tempC) {
        this.tempC = tempC;
    }

    public double getTempC() {
        return tempC;
    }

    public void setPressureIn(double pressureIn) {
        this.pressureIn = pressureIn;
    }

    public double getPressureIn() {
        return pressureIn;
    }

    public void setGustKph(double gustKph) {
        this.gustKph = gustKph;
    }

    public double getGustKph() {
        return gustKph;
    }

    public void setTempF(double tempF) {
        this.tempF = tempF;
    }

    public double getTempF() {
        return tempF;
    }

    public void setPrecipMm(double precipMm) {
        this.precipMm = precipMm;
    }

    public double getPrecipMm() {
        return precipMm;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
    }

    public int getCloud() {
        return cloud;
    }

    public void setWindKph(double windKph) {
        this.windKph = windKph;
    }

    public double getWindKph() {
        return windKph;
    }

    public void setCondition(ConditionDatabaseEntity condition) {
        this.condition = condition;
    }

    public ConditionDatabaseEntity getCondition() {
        return condition;
    }

    public void setWindMph(double windMph) {
        this.windMph = windMph;
    }

    public double getWindMph() {
        return windMph;
    }

    public void setVisKm(double visKm) {
        this.visKm = visKm;
    }

    public double getVisKm() {
        return visKm;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setPressureMb(double pressureMb) {
        this.pressureMb = pressureMb;
    }

    public double getPressureMb() {
        return pressureMb;
    }

    public void setVisMiles(double visMiles) {
        this.visMiles = visMiles;
    }

    public double getVisMiles() {
        return visMiles;
    }
}
