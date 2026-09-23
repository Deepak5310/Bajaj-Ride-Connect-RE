package com.mappls.sdk.services.api.weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class WeatherResponse {

    @SerializedName("data")
    @Expose
    private WeatherData data;

    public WeatherData getData() {
        return this.data;
    }

    public void setData(WeatherData weatherData) {
        this.data = weatherData;
    }
}
