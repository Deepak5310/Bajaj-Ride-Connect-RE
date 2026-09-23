package com.mappls.sdk.services.api.costestimation.model;

import com.BV.LinearGradient.LinearGradientManager;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class CostEstimationResponse {

    @SerializedName(PlaceTypes.COUNTRY)
    private String country;

    @SerializedName(FirebaseAnalytics.Param.CURRENCY)
    private String currency;

    @SerializedName("departureTime")
    private Long departureTime;

    @SerializedName(DirectionsCriteria.ANNOTATION_DISTANCE)
    private Double distance;

    @SerializedName("duration")
    private Double duration;

    @SerializedName("fuelEfficiency")
    private String fuelEfficiency;

    @SerializedName("fuelPrice")
    private Double fuelPrice;

    @SerializedName("hasTolls")
    private Boolean hasTolls;

    @SerializedName(LinearGradientManager.PROP_LOCATIONS)
    private List<MapplsLocation> locations;

    @SerializedName("tolls")
    private List<CostEstimationTollDetail> tolls;

    @SerializedName("totalFuelCost")
    private Integer totalFuelCost;

    @SerializedName("totalTollCost")
    private Integer totalTollCost;

    @SerializedName("totalTolls")
    private Integer totalTolls;

    @SerializedName("totalTripCostEstimate")
    private Double totalTripCostEstimate;

    @SerializedName(ImagesContract.URL)
    private String url;

    @SerializedName("vehicleFuelType")
    private String vehicleFuelType;

    @SerializedName("vehicleType")
    private String vehicleType;

    public Boolean getHasTolls() {
        return this.hasTolls;
    }

    public void setHasTolls(Boolean bool) {
        this.hasTolls = bool;
    }

    public Integer getTotalTolls() {
        return this.totalTolls;
    }

    public void setTotalTolls(Integer num) {
        this.totalTolls = num;
    }

    public List<MapplsLocation> getLocations() {
        return this.locations;
    }

    public void setLocations(List<MapplsLocation> list) {
        this.locations = list;
    }

    public Long getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(Long l) {
        this.departureTime = l;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getVehicleType() {
        return this.vehicleType;
    }

    public void setVehicleType(String str) {
        this.vehicleType = str;
    }

    public Integer getTotalTollCost() {
        return this.totalTollCost;
    }

    public void setTotalTollCost(Integer num) {
        this.totalTollCost = num;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
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

    public List<CostEstimationTollDetail> getTolls() {
        return this.tolls;
    }

    public void setTolls(List<CostEstimationTollDetail> list) {
        this.tolls = list;
    }

    public String getFuelEfficiency() {
        return this.fuelEfficiency;
    }

    public void setFuelEfficiency(String str) {
        this.fuelEfficiency = str;
    }

    public Integer getTotalFuelCost() {
        return this.totalFuelCost;
    }

    public void setTotalFuelCost(Integer num) {
        this.totalFuelCost = num;
    }

    public Double getFuelPrice() {
        return this.fuelPrice;
    }

    public void setFuelPrice(Double d) {
        this.fuelPrice = d;
    }

    public String getVehicleFuelType() {
        return this.vehicleFuelType;
    }

    public void setVehicleFuelType(String str) {
        this.vehicleFuelType = str;
    }

    public Double getTotalTripCostEstimate() {
        return this.totalTripCostEstimate;
    }

    public void setTotalTripCostEstimate(Double d) {
        this.totalTripCostEstimate = d;
    }
}
