package com.mhelrigo.domain.forecast.entity;

public class Astro {
    private String moonset;
    private String moonIllumination;
    private String sunrise;
    private String moonPhase;
    private String sunset;
    private String moonrise;

    public Astro() {
    }

    public Astro(String moonset, String moonIllumination, String sunrise, String moonPhase, String sunset, String moonrise) {
        this.moonset = moonset;
        this.moonIllumination = moonIllumination;
        this.sunrise = sunrise;
        this.moonPhase = moonPhase;
        this.sunset = sunset;
        this.moonrise = moonrise;
    }

    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }

    public String getMoonset() {
        return moonset;
    }

    public void setMoonIllumination(String moonIllumination) {
        this.moonIllumination = moonIllumination;
    }

    public String getMoonIllumination() {
        return moonIllumination;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setMoonPhase(String moonPhase) {
        this.moonPhase = moonPhase;
    }

    public String getMoonPhase() {
        return moonPhase;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getSunset() {
        return sunset;
    }

    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }

    public String getMoonrise() {
        return moonrise;
    }
}
