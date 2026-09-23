package com.mappls.sdk.services.api.transit.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.annotations.SerializedName;
import com.henninghall.date_picker.props.ModeProp;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class TransitRouteLeg {

    @SerializedName("arrivalDelay")
    private Integer arrivalDelay;

    @SerializedName("departureDelay")
    private Integer departureDelay;

    @SerializedName(DirectionsCriteria.ANNOTATION_DISTANCE)
    private Double distance;

    @SerializedName("duration")
    private Double duration;

    @SerializedName("endTime")
    private Long endTime;

    @SerializedName("from")
    private TransitVertex from;

    @SerializedName("interlineWithPreviousLeg")
    private Boolean interlineWithPreviousLeg;

    @SerializedName("legGeometry")
    private TransitLegGeometry legGeometry;

    @SerializedName(ModeProp.name)
    private String mode;

    @SerializedName("realTime")
    private Boolean realTime;

    @SerializedName(PlaceTypes.ROUTE)
    private String route;

    @SerializedName("startTime")
    private Long startTime;

    @SerializedName("steps")
    private List<TransitLegStep> steps;

    @SerializedName(TypedValues.TransitionType.S_TO)
    private TransitVertex to;

    @SerializedName("transitLeg")
    private Boolean transitLeg;

    public TransitLegGeometry getLegGeometry() {
        return this.legGeometry;
    }

    public void setLegGeometry(TransitLegGeometry transitLegGeometry) {
        this.legGeometry = transitLegGeometry;
    }

    public Boolean getTransitLeg() {
        return this.transitLeg;
    }

    public void setTransitLeg(Boolean bool) {
        this.transitLeg = bool;
    }

    public Double getDistance() {
        return this.distance;
    }

    public void setDistance(Double d) {
        this.distance = d;
    }

    public Integer getArrivalDelay() {
        return this.arrivalDelay;
    }

    public void setArrivalDelay(Integer num) {
        this.arrivalDelay = num;
    }

    public Integer getDepartureDelay() {
        return this.departureDelay;
    }

    public void setDepartureDelay(Integer num) {
        this.departureDelay = num;
    }

    public List<TransitLegStep> getSteps() {
        return this.steps;
    }

    public void setSteps(List<TransitLegStep> list) {
        this.steps = list;
    }

    public Boolean getRealTime() {
        return this.realTime;
    }

    public void setRealTime(Boolean bool) {
        this.realTime = bool;
    }

    public String getMode() {
        return this.mode;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public Double getDuration() {
        return this.duration;
    }

    public void setDuration(Double d) {
        this.duration = d;
    }

    public String getRoute() {
        return this.route;
    }

    public void setRoute(String str) {
        this.route = str;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Long l) {
        this.startTime = l;
    }

    public TransitVertex getFrom() {
        return this.from;
    }

    public void setFrom(TransitVertex transitVertex) {
        this.from = transitVertex;
    }

    public Long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Long l) {
        this.endTime = l;
    }

    public TransitVertex getTo() {
        return this.to;
    }

    public void setTo(TransitVertex transitVertex) {
        this.to = transitVertex;
    }

    public Boolean getInterlineWithPreviousLeg() {
        return this.interlineWithPreviousLeg;
    }

    public void setInterlineWithPreviousLeg(Boolean bool) {
        this.interlineWithPreviousLeg = bool;
    }
}
