package com.mappls.sdk.services.api.transit.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class TransitItinerary {

    @SerializedName("duration")
    private Double duration;

    @SerializedName("endTime")
    private Long endTime;

    @SerializedName("startTime")
    private Long startTime;

    @SerializedName("transfers")
    private Integer transfers;

    @SerializedName("fare")
    private TransitFare transitFare;

    @SerializedName("legs")
    private List<TransitRouteLeg> transitRouteLegs;

    @SerializedName("transitTime")
    private Integer transitTime;

    @SerializedName("waitingTime")
    private Integer waitingTime;

    @SerializedName("walkDistance")
    private Double walkDistance;

    @SerializedName("walkTime")
    private Integer walkTime;

    public Double getWalkDistance() {
        return this.walkDistance;
    }

    public void setWalkDistance(Double d) {
        this.walkDistance = d;
    }

    public Integer getTransitTime() {
        return this.transitTime;
    }

    public void setTransitTime(Integer num) {
        this.transitTime = num;
    }

    public Integer getWalkTime() {
        return this.walkTime;
    }

    public void setWalkTime(Integer num) {
        this.walkTime = num;
    }

    public Integer getWaitingTime() {
        return this.waitingTime;
    }

    public void setWaitingTime(Integer num) {
        this.waitingTime = num;
    }

    public Double getDuration() {
        return this.duration;
    }

    public void setDuration(Double d) {
        this.duration = d;
    }

    public Integer getTransfers() {
        return this.transfers;
    }

    public void setTransfers(Integer num) {
        this.transfers = num;
    }

    public List<TransitRouteLeg> getTransitLegSteps() {
        return this.transitRouteLegs;
    }

    public void setTransitLegSteps(List<TransitRouteLeg> list) {
        this.transitRouteLegs = list;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Long l) {
        this.startTime = l;
    }

    public Long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Long l) {
        this.endTime = l;
    }

    public TransitFare getTransitFare() {
        return this.transitFare;
    }

    public void setTransitFare(TransitFare transitFare) {
        this.transitFare = transitFare;
    }
}
