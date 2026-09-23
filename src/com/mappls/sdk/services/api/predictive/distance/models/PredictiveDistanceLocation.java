package com.mappls.sdk.services.api.predictive.distance.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class PredictiveDistanceLocation {

    @SerializedName("lat")
    @Expose
    private Double latitude;

    @SerializedName("lon")
    @Expose
    private Double longitude;

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double d) {
        this.latitude = d;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double d) {
        this.longitude = d;
    }
}
