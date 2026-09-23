package com.mappls.sdk.services.api.predictive.directions.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.api.geocoding.GeoCodingCriteria;

/* JADX INFO: loaded from: classes4.dex */
public class PredictiveDirectionLocation {

    @SerializedName(GeoCodingCriteria.POD_CITY)
    @Expose
    private String city;

    @SerializedName("lat")
    @Expose
    private Double latitude;

    @SerializedName("lon")
    @Expose
    private Double longitude;

    @SerializedName("original_index")
    @Expose
    private Integer originalIndex;

    @SerializedName("type")
    @Expose
    private String type;

    public Integer getOriginalIndex() {
        return this.originalIndex;
    }

    public void setOriginalIndex(Integer num) {
        this.originalIndex = num;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double d) {
        this.longitude = d;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double d) {
        this.latitude = d;
    }
}
