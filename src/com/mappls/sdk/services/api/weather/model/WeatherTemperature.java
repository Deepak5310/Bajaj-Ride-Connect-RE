package com.mappls.sdk.services.api.weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class WeatherTemperature {

    @SerializedName("maxTemperature")
    @Expose
    private Double maxTemperature;

    @SerializedName("maxTemperatureUnit")
    @Expose
    private String maxTemperatureUnit;

    @SerializedName("minTemperature")
    @Expose
    private Double minTemperature;

    @SerializedName("minTemperatureUnit")
    @Expose
    private String minTemperatureUnit;

    @SerializedName("temperatureUnit")
    @Expose
    private String unit;

    @SerializedName("temperature")
    @Expose
    private Double value;

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double d) {
        this.value = d;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public Double getMinTemperature() {
        return this.minTemperature;
    }

    public void setMinTemperature(Double d) {
        this.minTemperature = d;
    }

    public String getMinTemperatureUnit() {
        return this.minTemperatureUnit;
    }

    public void setMinTemperatureUnit(String str) {
        this.minTemperatureUnit = str;
    }

    public Double getMaxTemperature() {
        return this.maxTemperature;
    }

    public void setMaxTemperature(Double d) {
        this.maxTemperature = d;
    }

    public String getMaxTemperatureUnit() {
        return this.maxTemperatureUnit;
    }

    public void setMaxTemperatureUnit(String str) {
        this.maxTemperatureUnit = str;
    }
}
