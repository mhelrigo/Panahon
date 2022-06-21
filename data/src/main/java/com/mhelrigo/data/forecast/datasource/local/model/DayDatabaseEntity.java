package com.mhelrigo.data.forecast.datasource.local.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.mhelrigo.domain.forecast.entity.Condition;

public class DayDatabaseEntity {
    public int dayId;
    private double avgvisKm;
    private double uv;
    private double avgtempF;
    private double avgtempC;
    private int dailyChanceOfSnow;
    private double maxtempC;
    private double maxtempF;
    private double mintempC;
    private double avgvisMiles;
    private int dailyWillItRain;
    private double mintempF;
    private double totalprecipIn;
    private double avghumidity;
    @Embedded
    private ConditionDatabaseEntity condition;
    private double maxwindKph;
    private double maxwindMph;
    private int dailyChanceOfRain;
    private double totalprecipMm;
    private int dailyWillItSnow;

    public DayDatabaseEntity() {
    }

    public DayDatabaseEntity(double avgvisKm, double uv, double avgtempF, double avgtempC, int dailyChanceOfSnow, double maxtempC, double maxtempF, double mintempC, double avgvisMiles, int dailyWillItRain, double mintempF, double totalprecipIn, double avghumidity, ConditionDatabaseEntity condition, double maxwindKph, double maxwindMph, int dailyChanceOfRain, double totalprecipMm, int dailyWillItSnow) {
        this.avgvisKm = avgvisKm;
        this.uv = uv;
        this.avgtempF = avgtempF;
        this.avgtempC = avgtempC;
        this.dailyChanceOfSnow = dailyChanceOfSnow;
        this.maxtempC = maxtempC;
        this.maxtempF = maxtempF;
        this.mintempC = mintempC;
        this.avgvisMiles = avgvisMiles;
        this.dailyWillItRain = dailyWillItRain;
        this.mintempF = mintempF;
        this.totalprecipIn = totalprecipIn;
        this.avghumidity = avghumidity;
        this.condition = condition;
        this.maxwindKph = maxwindKph;
        this.maxwindMph = maxwindMph;
        this.dailyChanceOfRain = dailyChanceOfRain;
        this.totalprecipMm = totalprecipMm;
        this.dailyWillItSnow = dailyWillItSnow;
    }

    public int getId() {
        return dayId;
    }

    public void setId(int id) {
        this.dayId = id;
    }

    public void setAvgvisKm(double avgvisKm) {
        this.avgvisKm = avgvisKm;
    }

    public double getAvgvisKm() {
        return avgvisKm;
    }

    public void setUv(double uv) {
        this.uv = uv;
    }

    public double getUv() {
        return uv;
    }

    public void setAvgtempF(double avgtempF) {
        this.avgtempF = avgtempF;
    }

    public double getAvgtempF() {
        return avgtempF;
    }

    public void setAvgtempC(double avgtempC) {
        this.avgtempC = avgtempC;
    }

    public double getAvgtempC() {
        return avgtempC;
    }

    public void setDailyChanceOfSnow(int dailyChanceOfSnow) {
        this.dailyChanceOfSnow = dailyChanceOfSnow;
    }

    public int getDailyChanceOfSnow() {
        return dailyChanceOfSnow;
    }

    public void setMaxtempC(double maxtempC) {
        this.maxtempC = maxtempC;
    }

    public double getMaxtempC() {
        return maxtempC;
    }

    public void setMaxtempF(double maxtempF) {
        this.maxtempF = maxtempF;
    }

    public double getMaxtempF() {
        return maxtempF;
    }

    public void setMintempC(double mintempC) {
        this.mintempC = mintempC;
    }

    public double getMintempC() {
        return mintempC;
    }

    public void setAvgvisMiles(double avgvisMiles) {
        this.avgvisMiles = avgvisMiles;
    }

    public double getAvgvisMiles() {
        return avgvisMiles;
    }

    public void setDailyWillItRain(int dailyWillItRain) {
        this.dailyWillItRain = dailyWillItRain;
    }

    public int getDailyWillItRain() {
        return dailyWillItRain;
    }

    public void setMintempF(double mintempF) {
        this.mintempF = mintempF;
    }

    public double getMintempF() {
        return mintempF;
    }

    public void setTotalprecipIn(double totalprecipIn) {
        this.totalprecipIn = totalprecipIn;
    }

    public double getTotalprecipIn() {
        return totalprecipIn;
    }

    public void setAvghumidity(double avghumidity) {
        this.avghumidity = avghumidity;
    }

    public double getAvghumidity() {
        return avghumidity;
    }

    public void setCondition(ConditionDatabaseEntity condition) {
        this.condition = condition;
    }

    public ConditionDatabaseEntity getCondition() {
        return condition;
    }

    public void setMaxwindKph(double maxwindKph) {
        this.maxwindKph = maxwindKph;
    }

    public double getMaxwindKph() {
        return maxwindKph;
    }

    public void setMaxwindMph(double maxwindMph) {
        this.maxwindMph = maxwindMph;
    }

    public double getMaxwindMph() {
        return maxwindMph;
    }

    public void setDailyChanceOfRain(int dailyChanceOfRain) {
        this.dailyChanceOfRain = dailyChanceOfRain;
    }

    public int getDailyChanceOfRain() {
        return dailyChanceOfRain;
    }

    public void setTotalprecipMm(double totalprecipMm) {
        this.totalprecipMm = totalprecipMm;
    }

    public double getTotalprecipMm() {
        return totalprecipMm;
    }

    public void setDailyWillItSnow(int dailyWillItSnow) {
        this.dailyWillItSnow = dailyWillItSnow;
    }

    public int getDailyWillItSnow() {
        return dailyWillItSnow;
    }
}
