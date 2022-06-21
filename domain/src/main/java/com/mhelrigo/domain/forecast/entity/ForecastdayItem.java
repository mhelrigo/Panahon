package com.mhelrigo.domain.forecast.entity;

import java.util.List;

public class ForecastdayItem {
    private int forecastDataId;
    private String date;
    private Astro astro;
    private int dateEpoch;
    private List<HourItem> hour;
    private Day day;

    public ForecastdayItem() {
    }

    public ForecastdayItem(String date, Astro astro, int dateEpoch, List<HourItem> hour, Day day) {
        this.date = date;
        this.astro = astro;
        this.dateEpoch = dateEpoch;
        this.hour = hour;
        this.day = day;
    }

    public int getForecastDataId() {
        return forecastDataId;
    }

    public void setForecastDataId(int id) {
        this.forecastDataId = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setAstro(Astro astro) {
        this.astro = astro;
    }

    public Astro getAstro() {
        return astro;
    }

    public void setDateEpoch(int dateEpoch) {
        this.dateEpoch = dateEpoch;
    }

    public int getDateEpoch() {
        return dateEpoch;
    }

    public void setHour(List<HourItem> hour) {
        this.hour = hour;
    }

    public List<HourItem> getHour() {
        return hour;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Day getDay() {
        return day;
    }
}