package com.mappls.sdk.services.api.weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class WeatherCondition {

    @SerializedName("realFeelWeatherText")
    @Expose
    private String realFeelWeatherText;

    @SerializedName("weatherDesc")
    @Expose
    private String weatherDescription;

    @SerializedName("weatherIcon")
    @Expose
    private String weatherIcon;

    @SerializedName("weatherIconDay")
    @Expose
    private String weatherIconDay;

    @SerializedName("weatherIconNight")
    @Expose
    private String weatherIconNight;

    @SerializedName("weatherId")
    @Expose
    private Integer weatherId;

    @SerializedName("weatherIdDay")
    @Expose
    private Integer weatherIdDay;

    @SerializedName("weatherIdNight")
    @Expose
    private Integer weatherIdNight;

    @SerializedName("weatherText")
    @Expose
    private String weatherText;

    @SerializedName("weatherTextDay")
    @Expose
    private String weatherTextDay;

    @SerializedName("weatherTextNight")
    @Expose
    private String weatherTextNight;

    public Integer getWeatherId() {
        return this.weatherId;
    }

    public void setWeatherId(Integer num) {
        this.weatherId = num;
    }

    public String getWeatherText() {
        return this.weatherText;
    }

    public void setWeatherText(String str) {
        this.weatherText = str;
    }

    public String getWeatherDescription() {
        return this.weatherDescription;
    }

    public void setWeatherDescription(String str) {
        this.weatherDescription = str;
    }

    public String getWeatherIcon() {
        return this.weatherIcon;
    }

    public void setWeatherIcon(String str) {
        this.weatherIcon = str;
    }

    public String getRealFeelWeatherText() {
        return this.realFeelWeatherText;
    }

    public void setRealFeelWeatherText(String str) {
        this.realFeelWeatherText = str;
    }

    public Integer getWeatherIdDay() {
        return this.weatherIdDay;
    }

    public void setWeatherIdDay(Integer num) {
        this.weatherIdDay = num;
    }

    public String getWeatherTextDay() {
        return this.weatherTextDay;
    }

    public void setWeatherTextDay(String str) {
        this.weatherTextDay = str;
    }

    public String getWeatherIconDay() {
        return this.weatherIconDay;
    }

    public void setWeatherIconDay(String str) {
        this.weatherIconDay = str;
    }

    public Integer getWeatherIdNight() {
        return this.weatherIdNight;
    }

    public void setWeatherIdNight(Integer num) {
        this.weatherIdNight = num;
    }

    public String getWeatherTextNight() {
        return this.weatherTextNight;
    }

    public void setWeatherTextNight(String str) {
        this.weatherTextNight = str;
    }

    public String getWeatherIconNight() {
        return this.weatherIconNight;
    }

    public void setWeatherIconNight(String str) {
        this.weatherIconNight = str;
    }
}
