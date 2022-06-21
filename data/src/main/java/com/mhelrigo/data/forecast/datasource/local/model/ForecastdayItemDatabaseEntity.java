package com.mhelrigo.data.forecast.datasource.local.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.mhelrigo.domain.forecast.entity.Astro;
import com.mhelrigo.domain.forecast.entity.Day;

import java.util.List;

@Entity
public class ForecastdayItemDatabaseEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private int forecastDataId;
    private String date;
    @Embedded
    private AstroDatabaseEntity astro;
    private int dateEpoch;
    @Ignore
    private List<HourItemDatabaseEntity> hour;
    @Embedded
    private DayDatabaseEntity day;

    public ForecastdayItemDatabaseEntity() {
    }

    public ForecastdayItemDatabaseEntity(String date, AstroDatabaseEntity astro, int dateEpoch, List<HourItemDatabaseEntity> hour, DayDatabaseEntity day) {
        this.date = date;
        this.astro = astro;
        this.dateEpoch = dateEpoch;
        this.hour = hour;
        this.day = day;
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

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setAstro(AstroDatabaseEntity astro) {
        this.astro = astro;
    }

    public AstroDatabaseEntity getAstro() {
        return astro;
    }

    public void setDateEpoch(int dateEpoch) {
        this.dateEpoch = dateEpoch;
    }

    public int getDateEpoch() {
        return dateEpoch;
    }

    public void setHour(List<HourItemDatabaseEntity> hour) {
        this.hour = hour;
    }

    public List<HourItemDatabaseEntity> getHour() {
        return hour;
    }

    public void setDay(DayDatabaseEntity day) {
        this.day = day;
    }

    public DayDatabaseEntity getDay() {
        return day;
    }
}
