package com.mhelrigo.data.forecast.datasource.local.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HourItemDatabaseEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private int dayItemId;
    private double feelslikeC;
    private double feelslikeF;
    private int windDegree;
    private double windchillF;
    private double windchillC;
    private double tempC;
    private double tempF;
    private int cloud;
    private double windKph;
    private double windMph;
    private int humidity;
    private double dewpointF;
    private int willItRain;
    private double uv;
    private double heatindexF;
    private double dewpointC;
    private int isDay;
    private double precipIn;
    private double heatindexC;
    private String windDir;
    private double gustMph;
    private double pressureIn;
    private int chanceOfRain;
    private double gustKph;
    private double precipMm;
    @Embedded
    private ConditionDatabaseEntity condition;
    private int willItSnow;
    private double visKm;
    private int timeEpoch;
    private String time;
    private int chanceOfSnow;
    private double pressureMb;
    private double visMiles;

    public HourItemDatabaseEntity() {
    }

    public HourItemDatabaseEntity(double feelslikeC, double feelslikeF, int windDegree, double windchillF, double windchillC, double tempC, double tempF, int cloud, double windKph, double windMph, int humidity, double dewpointF, int willItRain, double uv, double heatindexF, double dewpointC, int isDay, double precipIn, double heatindexC, String windDir, double gustMph, double pressureIn, int chanceOfRain, double gustKph, double precipMm, ConditionDatabaseEntity condition, int willItSnow, double visKm, int timeEpoch, String time, int chanceOfSnow, double pressureMb, double visMiles) {
        this.feelslikeC = feelslikeC;
        this.feelslikeF = feelslikeF;
        this.windDegree = windDegree;
        this.windchillF = windchillF;
        this.windchillC = windchillC;
        this.tempC = tempC;
        this.tempF = tempF;
        this.cloud = cloud;
        this.windKph = windKph;
        this.windMph = windMph;
        this.humidity = humidity;
        this.dewpointF = dewpointF;
        this.willItRain = willItRain;
        this.uv = uv;
        this.heatindexF = heatindexF;
        this.dewpointC = dewpointC;
        this.isDay = isDay;
        this.precipIn = precipIn;
        this.heatindexC = heatindexC;
        this.windDir = windDir;
        this.gustMph = gustMph;
        this.pressureIn = pressureIn;
        this.chanceOfRain = chanceOfRain;
        this.gustKph = gustKph;
        this.precipMm = precipMm;
        this.condition = condition;
        this.willItSnow = willItSnow;
        this.visKm = visKm;
        this.timeEpoch = timeEpoch;
        this.time = time;
        this.chanceOfSnow = chanceOfSnow;
        this.pressureMb = pressureMb;
        this.visMiles = visMiles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDayItemId() {
        return dayItemId;
    }

    public void setDayItemId(int dayItemId) {
        this.dayItemId = dayItemId;
    }

    public void setFeelslikeC(double feelslikeC) {
        this.feelslikeC = feelslikeC;
    }

    public double getFeelslikeC() {
        return feelslikeC;
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

    public void setWindchillF(double windchillF) {
        this.windchillF = windchillF;
    }

    public double getWindchillF() {
        return windchillF;
    }

    public void setWindchillC(double windchillC) {
        this.windchillC = windchillC;
    }

    public double getWindchillC() {
        return windchillC;
    }

    public void setTempC(double tempC) {
        this.tempC = tempC;
    }

    public double getTempC() {
        return tempC;
    }

    public void setTempF(double tempF) {
        this.tempF = tempF;
    }

    public double getTempF() {
        return tempF;
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

    public void setWindMph(double windMph) {
        this.windMph = windMph;
    }

    public double getWindMph() {
        return windMph;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setDewpointF(double dewpointF) {
        this.dewpointF = dewpointF;
    }

    public double getDewpointF() {
        return dewpointF;
    }

    public void setWillItRain(int willItRain) {
        this.willItRain = willItRain;
    }

    public int getWillItRain() {
        return willItRain;
    }

    public void setUv(double uv) {
        this.uv = uv;
    }

    public double getUv() {
        return uv;
    }

    public void setHeatindexF(double heatindexF) {
        this.heatindexF = heatindexF;
    }

    public double getHeatindexF() {
        return heatindexF;
    }

    public void setDewpointC(double dewpointC) {
        this.dewpointC = dewpointC;
    }

    public double getDewpointC() {
        return dewpointC;
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

    public void setHeatindexC(double heatindexC) {
        this.heatindexC = heatindexC;
    }

    public double getHeatindexC() {
        return heatindexC;
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

    public void setPressureIn(double pressureIn) {
        this.pressureIn = pressureIn;
    }

    public double getPressureIn() {
        return pressureIn;
    }

    public void setChanceOfRain(int chanceOfRain) {
        this.chanceOfRain = chanceOfRain;
    }

    public int getChanceOfRain() {
        return chanceOfRain;
    }

    public void setGustKph(double gustKph) {
        this.gustKph = gustKph;
    }

    public double getGustKph() {
        return gustKph;
    }

    public void setPrecipMm(double precipMm) {
        this.precipMm = precipMm;
    }

    public double getPrecipMm() {
        return precipMm;
    }

    public void setCondition(ConditionDatabaseEntity condition) {
        this.condition = condition;
    }

    public ConditionDatabaseEntity getCondition() {
        return condition;
    }

    public void setWillItSnow(int willItSnow) {
        this.willItSnow = willItSnow;
    }

    public int getWillItSnow() {
        return willItSnow;
    }

    public void setVisKm(double visKm) {
        this.visKm = visKm;
    }

    public double getVisKm() {
        return visKm;
    }

    public void setTimeEpoch(int timeEpoch) {
        this.timeEpoch = timeEpoch;
    }

    public int getTimeEpoch() {
        return timeEpoch;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setChanceOfSnow(int chanceOfSnow) {
        this.chanceOfSnow = chanceOfSnow;
    }

    public int getChanceOfSnow() {
        return chanceOfSnow;
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
