package com.mappls.sdk.services.api.costestimation.model;

import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class CostEstimationTollDetail {

    @SerializedName(PlaceTypes.ADDRESS)
    private String address;

    @SerializedName("agency")
    private String agency;

    @SerializedName("amenities")
    private List<String> amenities;

    @SerializedName("averageWaitTimeRange")
    private Double averageWaitTimeRange;

    @SerializedName("cost")
    private Integer cost;

    @SerializedName(DirectionsCriteria.ANNOTATION_DISTANCE)
    private Double distance;

    @SerializedName("duration")
    private Double duration;

    @SerializedName("emergency")
    private String emergency;

    @SerializedName("lanes")
    private Integer lanes;

    @SerializedName("latitude")
    private Double latitude;

    @SerializedName("longitude")
    private Double longitude;

    @SerializedName(alternate = {"eloc"}, value = "mapplsPin")
    private String mapplsPin;

    @SerializedName("node")
    private Double node;

    @SerializedName("nodeIdx")
    private Integer nodeIdx;

    @SerializedName("payment")
    private List<String> payment;

    @SerializedName("road")
    private String road;

    @SerializedName("roadType")
    private String roadType;

    @SerializedName("state")
    private String state;

    @SerializedName("tollGrpId")
    private Integer tollGrpId;

    @SerializedName("tollName")
    private String tollName;

    @SerializedName("type")
    private String type;

    public String getMapplsPin() {
        return this.mapplsPin;
    }

    public void setMapplsPin(String str) {
        this.mapplsPin = str;
    }

    public String getTollName() {
        return this.tollName;
    }

    public void setTollName(String str) {
        this.tollName = str;
    }

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

    public Double getNode() {
        return this.node;
    }

    public void setNode(Double d) {
        this.node = d;
    }

    public Integer getTollGrpId() {
        return this.tollGrpId;
    }

    public void setTollGrpId(Integer num) {
        this.tollGrpId = num;
    }

    public String getRoad() {
        return this.road;
    }

    public void setRoad(String str) {
        this.road = str;
    }

    public String getRoadType() {
        return this.roadType;
    }

    public void setRoadType(String str) {
        this.roadType = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }

    public Integer getLanes() {
        return this.lanes;
    }

    public void setLanes(Integer num) {
        this.lanes = num;
    }

    public String getAgency() {
        return this.agency;
    }

    public void setAgency(String str) {
        this.agency = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public Double getAverageWaitTimeRange() {
        return this.averageWaitTimeRange;
    }

    public void setAverageWaitTimeRange(Double d) {
        this.averageWaitTimeRange = d;
    }

    public Integer getNodeIdx() {
        return this.nodeIdx;
    }

    public void setNodeIdx(Integer num) {
        this.nodeIdx = num;
    }

    public List<String> getPayment() {
        return this.payment;
    }

    public void setPayment(List<String> list) {
        this.payment = list;
    }

    public Integer getCost() {
        return this.cost;
    }

    public void setCost(Integer num) {
        this.cost = num;
    }

    public String getEmergency() {
        return this.emergency;
    }

    public void setEmergency(String str) {
        this.emergency = str;
    }

    public List<String> getAmenities() {
        return this.amenities;
    }

    public void setAmenities(List<String> list) {
        this.amenities = list;
    }

    public Double getDistance() {
        return this.distance;
    }

    public void setDistance(Double d) {
        this.distance = d;
    }

    public Double getDuration() {
        return this.duration;
    }

    public void setDuration(Double d) {
        this.duration = d;
    }
}
