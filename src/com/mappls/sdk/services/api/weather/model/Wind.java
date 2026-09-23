package com.mappls.sdk.services.api.weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class Wind {

    @SerializedName("windAngle")
    @Expose
    private Integer windAngle;

    @SerializedName("windAngleUnit")
    @Expose
    private String windAngleUnit;

    @SerializedName("windSpeed")
    @Expose
    private Double windSpeed;

    @SerializedName("windSpeedUnit")
    @Expose
    private String windSpeedUnit;

    public Double getWindSpeed() {
        return this.windSpeed;
    }

    public void setWindSpeed(Double d) {
        this.windSpeed = d;
    }

    public String getWindSpeedUnit() {
        return this.windSpeedUnit;
    }

    public void setWindSpeedUnit(String str) {
        this.windSpeedUnit = str;
    }

    public Integer getWindAngle() {
        return this.windAngle;
    }

    public void setWindAngle(Integer num) {
        this.windAngle = num;
    }

    public String getWindAngleUnit() {
        return this.windAngleUnit;
    }

    public void setWindAngleUnit(String str) {
        this.windAngleUnit = str;
    }
}
