package com.mappls.sdk.services.api.placedetail.model;

import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.api.geocoding.GeoCodingCriteria;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class PlaceDetailResponse {

    @SerializedName(PlaceTypes.ADDRESS)
    @Expose
    private String address;

    @SerializedName("avgRating")
    @Expose
    private Integer avgRating;

    @SerializedName(GeoCodingCriteria.POD_CITY)
    @Expose
    private String city;

    @SerializedName("district")
    @Expose
    private String district;

    @SerializedName("houseName")
    @Expose
    private String houseName;

    @SerializedName("houseNumber")
    @Expose
    private String houseNumber;

    @SerializedName("latitude")
    @Expose
    private Double latitude;

    @SerializedName(PlaceTypes.LOCALITY)
    @Expose
    private String locality;

    @SerializedName("longitude")
    @Expose
    private Double longitude;

    @SerializedName(alternate = {"eloc"}, value = "mapplsPin")
    @Expose
    private String mapplsPin;

    @SerializedName(GeoCodingCriteria.POD_PINCODE)
    @Expose
    private String pincode;

    @SerializedName("placeName")
    @Expose
    private String placeName;

    @SerializedName(GeoCodingCriteria.POD_POINT_OF_INTEREST)
    @Expose
    private String poi;

    @SerializedName("richInfo")
    @Expose
    private Map richInfo;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName(GeoCodingCriteria.POD_STREET)
    @Expose
    private String street;

    @SerializedName("subDistrict")
    @Expose
    private String subDistrict;

    @SerializedName("subLocality")
    @Expose
    private String subLocality;

    @SerializedName("subSubLocality")
    @Expose
    private String subSubLocality;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName(GeoCodingCriteria.POD_VILLAGE)
    @Expose
    private String village;

    public String getMapplsPin() {
        return this.mapplsPin;
    }

    public void setMapplsPin(String str) {
        this.mapplsPin = str;
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

    public String getPlaceName() {
        return this.placeName;
    }

    public void setPlaceName(String str) {
        this.placeName = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getHouseNumber() {
        return this.houseNumber;
    }

    public void setHouseNumber(String str) {
        this.houseNumber = str;
    }

    public String getHouseName() {
        return this.houseName;
    }

    public void setHouseName(String str) {
        this.houseName = str;
    }

    public String getPoi() {
        return this.poi;
    }

    public void setPoi(String str) {
        this.poi = str;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String str) {
        this.street = str;
    }

    public String getSubSubLocality() {
        return this.subSubLocality;
    }

    public void setSubSubLocality(String str) {
        this.subSubLocality = str;
    }

    public String getSubLocality() {
        return this.subLocality;
    }

    public void setSubLocality(String str) {
        this.subLocality = str;
    }

    public String getLocality() {
        return this.locality;
    }

    public void setLocality(String str) {
        this.locality = str;
    }

    public String getVillage() {
        return this.village;
    }

    public void setVillage(String str) {
        this.village = str;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String str) {
        this.district = str;
    }

    public String getSubDistrict() {
        return this.subDistrict;
    }

    public void setSubDistrict(String str) {
        this.subDistrict = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String getPincode() {
        return this.pincode;
    }

    public void setPincode(String str) {
        this.pincode = str;
    }

    public Integer getAvgRating() {
        return this.avgRating;
    }

    public void setAvgRating(Integer num) {
        this.avgRating = num;
    }

    public Map getRichInfo() {
        return this.richInfo;
    }

    public void setRichInfo(Map map) {
        this.richInfo = map;
    }
}
