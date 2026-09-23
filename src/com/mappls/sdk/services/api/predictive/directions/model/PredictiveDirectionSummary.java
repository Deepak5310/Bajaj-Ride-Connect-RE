package com.mappls.sdk.services.api.predictive.directions.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class PredictiveDirectionSummary {

    @SerializedName("cost")
    @Expose
    private Double cost;

    @SerializedName("has_time_restrictions")
    @Expose
    private Boolean hasTimeRestrictions;

    @SerializedName("length")
    @Expose
    private Double length;

    @SerializedName("max_lat")
    @Expose
    private Double maximumLatitude;

    @SerializedName("max_lon")
    @Expose
    private Double maximumLongitude;

    @SerializedName("min_lat")
    @Expose
    private Double minimumLatitude;

    @SerializedName("min_lon")
    @Expose
    private Double minimumLongitude;

    @SerializedName("time")
    @Expose
    private Double time;

    public Double getMinimumLongitude() {
        return this.minimumLongitude;
    }

    public void setMinimumLongitude(Double d) {
        this.minimumLongitude = d;
    }

    public Double getMaximumLatitude() {
        return this.maximumLatitude;
    }

    public void setMaximumLatitude(Double d) {
        this.maximumLatitude = d;
    }

    public Double getCost() {
        return this.cost;
    }

    public void setCost(Double d) {
        this.cost = d;
    }

    public Double getMaximumLongitude() {
        return this.maximumLongitude;
    }

    public void setMaximumLongitude(Double d) {
        this.maximumLongitude = d;
    }

    public Double getLength() {
        return this.length;
    }

    public void setLength(Double d) {
        this.length = d;
    }

    public Double getTime() {
        return this.time;
    }

    public void setTime(Double d) {
        this.time = d;
    }

    public Double getMinimumLatitude() {
        return this.minimumLatitude;
    }

    public void setMinimumLatitude(Double d) {
        this.minimumLatitude = d;
    }

    public Boolean getHasTimeRestrictions() {
        return this.hasTimeRestrictions;
    }

    public void setHasTimeRestrictions(Boolean bool) {
        this.hasTimeRestrictions = bool;
    }
}
