package com.mappls.sdk.services.api.transit.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class TransitVertex {

    @SerializedName("arrival")
    private Long arrival;

    @SerializedName("departure")
    private Long departure;

    @SerializedName("lat")
    private Double latitude;

    @SerializedName("lon")
    private Double longitude;

    @SerializedName("name")
    private String name;

    @SerializedName("stopId")
    private Long stopId;

    @SerializedName("stopIndex")
    private Integer stopIndex;

    @SerializedName("stopSequence")
    private Integer stopSequence;

    @SerializedName("vertexType")
    private String vertexType;

    public String getVertexType() {
        return this.vertexType;
    }

    public void setVertexType(String str) {
        this.vertexType = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double d) {
        this.longitude = d;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double d) {
        this.latitude = d;
    }

    public Integer getStopIndex() {
        return this.stopIndex;
    }

    public void setStopIndex(Integer num) {
        this.stopIndex = num;
    }

    public Integer getStopSequence() {
        return this.stopSequence;
    }

    public void setStopSequence(Integer num) {
        this.stopSequence = num;
    }

    public Long getArrival() {
        return this.arrival;
    }

    public void setArrival(Long l) {
        this.arrival = l;
    }

    public Long getStopId() {
        return this.stopId;
    }

    public void setStopId(Long l) {
        this.stopId = l;
    }

    public Long getDeparture() {
        return this.departure;
    }

    public void setDeparture(Long l) {
        this.departure = l;
    }
}
