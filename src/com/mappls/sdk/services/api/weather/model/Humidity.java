package com.mappls.sdk.services.api.weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class Humidity {

    @SerializedName("indoorRelHumidity")
    @Expose
    private Integer indoorRelHumidity;

    @SerializedName("relHumidity")
    @Expose
    private Integer relHumidity;

    public Integer getRelHumidity() {
        return this.relHumidity;
    }

    public void setRelHumidity(Integer num) {
        this.relHumidity = num;
    }

    public Integer getIndoorRelHumidity() {
        return this.indoorRelHumidity;
    }

    public void setIndoorRelHumidity(Integer num) {
        this.indoorRelHumidity = num;
    }
}
