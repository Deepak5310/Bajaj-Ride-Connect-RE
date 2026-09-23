package com.mappls.sdk.services.api.alongroute.models;

import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import com.mappls.sdk.services.api.autosuggest.model.PartnerFlag;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.api.geocoding.GeoCodingCriteria;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class SuggestedPOI {

    @SerializedName(PlaceTypes.ADDRESS)
    @Expose
    private String address;

    @SerializedName("brand_code")
    @Expose
    private String brandCode;

    @SerializedName(SavingTrackHelper.POINT_COL_CATEGORY)
    @Expose
    private String category;

    @SerializedName(GeoCodingCriteria.POD_CITY)
    @Expose
    private String city;

    @SerializedName(DirectionsCriteria.ANNOTATION_DISTANCE)
    @Expose
    private Integer distance;

    @SerializedName("district")
    @Expose
    private String district;

    @SerializedName("e_lat")
    @Expose
    private Double eLat;

    @SerializedName("e_lng")
    @Expose
    private Double eLng;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("hourOfOperation")
    @Expose
    private String hourOfOperation;

    @SerializedName("latitude")
    @Expose
    private Double latitude;

    @SerializedName(PlaceTypes.LOCALITY)
    @Expose
    private String locality;

    @SerializedName("longDesc")
    @Expose
    private String longDescription;

    @SerializedName("longitude")
    @Expose
    private Double longitude;

    @SerializedName(alternate = {"place_id"}, value = "mapplsPin")
    @Expose
    private String mapplsPin;

    @SerializedName("orderIndex")
    @Expose
    private Integer orderIndex;

    @SerializedName("partnersFlag")
    @Expose
    public List<PartnerFlag> partnersFlag;

    @SerializedName(GeoCodingCriteria.POD_POINT_OF_INTEREST)
    @Expose
    private String poi;

    @SerializedName("poplrName")
    @Expose
    private String popularName;

    @SerializedName("richInfo")
    @Expose
    private Map richInfo;

    @SerializedName("shortDesc")
    @Expose
    private String shortDescription;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("subDistrict")
    @Expose
    private String subDistrict;

    @SerializedName("subLocality")
    @Expose
    private String subLocality;

    @SerializedName("subSubLocality")
    @Expose
    private String subSubLocality;

    @SerializedName("tel")
    @Expose
    private String telNo;

    @SerializedName("website")
    @Expose
    private String website;

    public Integer getDistance() {
        return this.distance;
    }

    public void setDistance(Integer num) {
        this.distance = num;
    }

    public String getMapplsPin() {
        return this.mapplsPin;
    }

    public void setMapplsPin(String str) {
        this.mapplsPin = str;
    }

    public String getPoi() {
        return this.poi;
    }

    public void setPoi(String str) {
        this.poi = str;
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

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getSubDistrict() {
        return this.subDistrict;
    }

    public void setSubDistrict(String str) {
        this.subDistrict = str;
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

    public String getPopularName() {
        return this.popularName;
    }

    public void setPopularName(String str) {
        this.popularName = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getTelNo() {
        return this.telNo;
    }

    public void setTelNo(String str) {
        this.telNo = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String str) {
        this.website = str;
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

    public Double getELng() {
        return this.eLng;
    }

    public void setELng(Double d) {
        this.eLng = d;
    }

    public Double getELat() {
        return this.eLat;
    }

    public void setELat(Double d) {
        this.eLat = d;
    }

    public String getBrandCode() {
        return this.brandCode;
    }

    public void setBrandCode(String str) {
        this.brandCode = str;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public Integer getOrderIndex() {
        return this.orderIndex;
    }

    public void setOrderIndex(Integer num) {
        this.orderIndex = num;
    }

    public Map getRichInfo() {
        return this.richInfo;
    }

    public void setRichInfo(Map map) {
        this.richInfo = map;
    }

    public List<PartnerFlag> getPartnersFlag() {
        return this.partnersFlag;
    }

    public void setPartnersFlag(List<PartnerFlag> list) {
        this.partnersFlag = list;
    }

    public String getHourOfOperation() {
        return this.hourOfOperation;
    }

    public void setHourOfOperation(String str) {
        this.hourOfOperation = str;
    }

    public String getLongDescription() {
        return this.longDescription;
    }

    public void setLongDescription(String str) {
        this.longDescription = str;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String str) {
        this.shortDescription = str;
    }
}
