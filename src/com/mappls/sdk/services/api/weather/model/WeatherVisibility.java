package com.mappls.sdk.services.api.weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class WeatherVisibility {

    @SerializedName("visibilityUnit")
    @Expose
    private String unit;

    @SerializedName("visibility")
    @Expose
    private Integer value;

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer num) {
        this.value = num;
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public String getUnit() {
        return this.unit;
    }
}
