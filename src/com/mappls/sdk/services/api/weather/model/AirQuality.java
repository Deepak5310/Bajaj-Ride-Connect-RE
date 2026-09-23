package com.mappls.sdk.services.api.weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class AirQuality {

    @SerializedName("airQualityIndex")
    @Expose
    private Integer airQualityIndex;

    @SerializedName("airQualityIndexText")
    @Expose
    private String airQualityIndexText;

    @SerializedName("airQualityIndexUnit")
    @Expose
    private String airQualityIndexUnit;

    public Integer getAirQualityIndex() {
        return this.airQualityIndex;
    }

    public void setAirQualityIndex(Integer num) {
        this.airQualityIndex = num;
    }

    public String getAirQualityIndexText() {
        return this.airQualityIndexText;
    }

    public void setAirQualityIndexText(String str) {
        this.airQualityIndexText = str;
    }

    public String getAirQualityIndexUnit() {
        return this.airQualityIndexUnit;
    }

    public void setAirQualityIndexUnit(String str) {
        this.airQualityIndexUnit = str;
    }
}
