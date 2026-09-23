package com.mappls.sdk.services.api.traffic.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.api.geocoding.GeoCodingCriteria;

/* JADX INFO: loaded from: classes4.dex */
public class TrafficRoadDetailResult {

    @SerializedName("avg_spd")
    @Expose
    private Integer averageSpeed;

    @SerializedName(GeoCodingCriteria.POD_CITY)
    @Expose
    private String city;

    @SerializedName(DirectionsCriteria.ANNOTATION_DISTANCE)
    @Expose
    private Double distance;

    @SerializedName("district")
    @Expose
    private String district;

    @SerializedName("formOfWay")
    @Expose
    private String formOfWay;

    @SerializedName("geometry")
    @Expose
    private String geometry;

    @SerializedName("divider")
    @Expose
    private Boolean isDividerExist;

    @SerializedName("multi_cw")
    @Expose
    private Boolean isMultiCarriageWay;

    @SerializedName("oneway")
    @Expose
    private Boolean isOneWay;

    @SerializedName("shoulder")
    @Expose
    private Boolean isShoulderLaneExist;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("numOfLanes")
    @Expose
    private Integer numberOfLanes;

    @SerializedName("owner")
    @Expose
    private String owner;

    @SerializedName("roadClass")
    @Expose
    private String roadClass;

    @SerializedName("routeNo")
    @Expose
    private String routeNumber;

    @SerializedName("spd_lmt")
    @Expose
    private Integer speedLimit;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("trafficStatus")
    @Expose
    private String trafficStatus;

    @SerializedName("trafficType")
    @Expose
    private Integer trafficType;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getRouteNumber() {
        return this.routeNumber;
    }

    public void setRouteNumber(String str) {
        this.routeNumber = str;
    }

    public Boolean getOneWay() {
        return this.isOneWay;
    }

    public void setOneWay(Boolean bool) {
        this.isOneWay = bool;
    }

    public Integer getAverageSpeed() {
        return this.averageSpeed;
    }

    public void setAverageSpeed(Integer num) {
        this.averageSpeed = num;
    }

    public Integer getSpeedLimit() {
        return this.speedLimit;
    }

    public void setSpeedLimit(Integer num) {
        this.speedLimit = num;
    }

    public String getFormOfWay() {
        return this.formOfWay;
    }

    public void setFormOfWay(String str) {
        this.formOfWay = str;
    }

    public String getRoadClass() {
        return this.roadClass;
    }

    public void setRoadClass(String str) {
        this.roadClass = str;
    }

    public Boolean getMultiCarriageWay() {
        return this.isMultiCarriageWay;
    }

    public void setMultiCarriageWay(Boolean bool) {
        this.isMultiCarriageWay = bool;
    }

    public Boolean getDividerExist() {
        return this.isDividerExist;
    }

    public void setDividerExist(Boolean bool) {
        this.isDividerExist = bool;
    }

    public Integer getNumberOfLanes() {
        return this.numberOfLanes;
    }

    public void setNumberOfLanes(Integer num) {
        this.numberOfLanes = num;
    }

    public Boolean getShoulderLaneExist() {
        return this.isShoulderLaneExist;
    }

    public void setShoulderLaneExist(Boolean bool) {
        this.isShoulderLaneExist = bool;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String str) {
        this.owner = str;
    }

    public Double getDistance() {
        return this.distance;
    }

    public void setDistance(Double d) {
        this.distance = d;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String str) {
        this.district = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String getGeometry() {
        return this.geometry;
    }

    public void setGeometry(String str) {
        this.geometry = str;
    }

    public String getTrafficStatus() {
        return this.trafficStatus;
    }

    public void setTrafficStatus(String str) {
        this.trafficStatus = str;
    }

    public Integer getTrafficType() {
        return this.trafficType;
    }

    public void setTrafficType(Integer num) {
        this.trafficType = num;
    }
}
