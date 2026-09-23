package com.mappls.sdk.services.api.weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.api.weather.WeatherCriteria;

/* JADX INFO: loaded from: classes4.dex */
public class ForecastData {

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName(WeatherCriteria.UNIT_TYPE_DAY)
    @Expose
    private String day;

    @SerializedName(WeatherCriteria.UNIT_TYPE_HOUR)
    @Expose
    private String hour;

    @SerializedName("temperature")
    @Expose
    private WeatherTemperature temperature;

    @SerializedName("weatherCondition")
    @Expose
    private WeatherCondition weatherCondition;

    public String getHour() {
        return this.hour;
    }

    public void setHour(String str) {
        this.hour = str;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String str) {
        this.day = str;
    }

    public WeatherTemperature getTemperature() {
        return this.temperature;
    }

    public void setTemperature(WeatherTemperature weatherTemperature) {
        this.temperature = weatherTemperature;
    }

    public WeatherCondition getWeatherCondition() {
        return this.weatherCondition;
    }

    public void setWeatherCondition(WeatherCondition weatherCondition) {
        this.weatherCondition = weatherCondition;
    }
}
