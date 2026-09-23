package com.mappls.sdk.services.api.weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class WeatherData {

    @SerializedName("airQuality")
    @Expose
    private AirQuality airQuality;

    @SerializedName("forecastData")
    @Expose
    private List<ForecastData> forecastData;

    @SerializedName("humidity")
    @Expose
    private Humidity humidity;

    @SerializedName("temperature")
    @Expose
    private WeatherTemperature temperature;

    @SerializedName("visibility")
    @Expose
    private WeatherVisibility visibility;

    @SerializedName("weatherCondition")
    @Expose
    private WeatherCondition weatherCondition;

    @SerializedName("wind")
    @Expose
    private Wind wind;

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

    public AirQuality getAirQuality() {
        return this.airQuality;
    }

    public void setAirQuality(AirQuality airQuality) {
        this.airQuality = airQuality;
    }

    public Humidity getHumidity() {
        return this.humidity;
    }

    public void setHumidity(Humidity humidity) {
        this.humidity = humidity;
    }

    public Wind getWind() {
        return this.wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public WeatherVisibility getVisibility() {
        return this.visibility;
    }

    public void setVisibility(WeatherVisibility weatherVisibility) {
        this.visibility = weatherVisibility;
    }

    public List<ForecastData> getForecastData() {
        return this.forecastData;
    }

    public void setForecastData(List<ForecastData> list) {
        this.forecastData = list;
    }
}
