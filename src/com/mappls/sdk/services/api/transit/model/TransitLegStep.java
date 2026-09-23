package com.mappls.sdk.services.api.transit.model;

import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;

/* JADX INFO: loaded from: classes4.dex */
public class TransitLegStep {

    @SerializedName("absoluteDirection")
    private String absoluteDirection;

    @SerializedName(DirectionsCriteria.ANNOTATION_DISTANCE)
    private Double distance;

    @SerializedName("lat")
    private Double latitude;

    @SerializedName("lon")
    private Double longitude;

    @SerializedName("relativeDirection")
    private String relativeDirection;

    @SerializedName("stayOn")
    private Boolean stayOn;

    @SerializedName("streetName")
    private String streetName;

    public String getStreetName() {
        return this.streetName;
    }

    public void setStreetName(String str) {
        this.streetName = str;
    }

    public Double getDistance() {
        return this.distance;
    }

    public void setDistance(Double d) {
        this.distance = d;
    }

    public Boolean getStayOn() {
        return this.stayOn;
    }

    public void setStayOn(Boolean bool) {
        this.stayOn = bool;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double d) {
        this.longitude = d;
    }

    public String getAbsoluteDirection() {
        return this.absoluteDirection;
    }

    public void setAbsoluteDirection(String str) {
        this.absoluteDirection = str;
    }

    public String getRelativeDirection() {
        return this.relativeDirection;
    }

    public void setRelativeDirection(String str) {
        this.relativeDirection = str;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double d) {
        this.latitude = d;
    }
}
