package com.mappls.sdk.services.api;

import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.api.geocoding.GeoCodingCriteria;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class Place {

    @SerializedName("area")
    @Expose
    private String area;

    @SerializedName("areaCode")
    @Expose
    private String areaCode;

    @SerializedName(GeoCodingCriteria.POD_CITY)
    @Expose
    private String city;

    @SerializedName("district")
    @Expose
    private String district;

    @SerializedName("dstCenCd")
    @Expose
    private String dstCenCd;

    @SerializedName("dstLgdCd")
    @Expose
    private String dstLgdCd;

    @SerializedName("entryCoordinates")
    @Expose
    private List<EntryCoordinate> entryCoordinates;

    @SerializedName("formatted_address")
    @Expose
    private String formattedAddress;

    @SerializedName("houseName")
    @Expose
    private String houseName;

    @SerializedName("houseNumber")
    @Expose
    private String houseNumber;

    @SerializedName("isRooftop")
    @Expose
    private Boolean isRoofTop;

    @SerializedName(alternate = {"latitude"}, value = "lat")
    @Expose
    private Double lat;

    @SerializedName(alternate = {"longitude"}, value = "lng")
    @Expose
    private Double lng;

    @SerializedName(PlaceTypes.LOCALITY)
    @Expose
    private String locality;

    @SerializedName(alternate = {"eLoc", "place_id"}, value = "mapplsPin")
    @Expose
    private String mapplsPin;

    @SerializedName(GeoCodingCriteria.POD_PINCODE)
    @Expose
    private String pincode;

    @SerializedName(GeoCodingCriteria.POD_POINT_OF_INTEREST)
    @Expose
    private String poi;

    @SerializedName("poi_dist")
    @Expose
    private String poiDist;

    @SerializedName("richInfo")
    @Expose
    private Map richInfo;

    @SerializedName("sdbCenCd")
    @Expose
    private String sdbCenCd;

    @SerializedName("sdbLgdCd")
    @Expose
    private String sdbLgdCd;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName(GeoCodingCriteria.POD_STREET)
    @Expose
    private String street;

    @SerializedName("street_dist")
    @Expose
    private String streetDist;

    @SerializedName("sttCenCd")
    @Expose
    private String sttCenCd;

    @SerializedName("sttLgdCd")
    @Expose
    private String sttLgdCd;

    @SerializedName("subDistrict")
    @Expose
    private String subDistrict;

    @SerializedName("subLocality")
    @Expose
    private String subLocality;

    @SerializedName("subSubLocality")
    @Expose
    private String subSubLocality;

    @SerializedName("twnCenCd")
    @Expose
    private String twnCenCd;

    @SerializedName("twnLgdCd")
    @Expose
    private String twnLgdCd;

    @SerializedName("twnName")
    @Expose
    private String twnName;

    @SerializedName(GeoCodingCriteria.POD_VILLAGE)
    @Expose
    private String village;

    @SerializedName("vlgCenCd")
    @Expose
    private String vlgCenCd;

    @SerializedName("vlgLgdCd")
    @Expose
    private String vlgLgdCd;

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

    public String getPoiDist() {
        return this.poiDist;
    }

    public void setPoiDist(String str) {
        this.poiDist = str;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String str) {
        this.street = str;
    }

    public String getStreetDist() {
        return this.streetDist;
    }

    public void setStreetDist(String str) {
        this.streetDist = str;
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

    public Double getLat() {
        return this.lat;
    }

    public void setLat(Double d) {
        this.lat = d;
    }

    public Double getLng() {
        return this.lng;
    }

    public void setLng(Double d) {
        this.lng = d;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String str) {
        this.area = str;
    }

    public String getFormattedAddress() {
        return this.formattedAddress;
    }

    public void setFormattedAddress(String str) {
        this.formattedAddress = str;
    }

    public String getMapplsPin() {
        return this.mapplsPin;
    }

    public void setMapplsPin(String str) {
        this.mapplsPin = str;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String str) {
        this.areaCode = str;
    }

    public String getTwnName() {
        return this.twnName;
    }

    public void setTwnName(String str) {
        this.twnName = str;
    }

    public String getVlgCenCd() {
        return this.vlgCenCd;
    }

    public void setVlgCenCd(String str) {
        this.vlgCenCd = str;
    }

    public String getVlgLgdCd() {
        return this.vlgLgdCd;
    }

    public void setVlgLgdCd(String str) {
        this.vlgLgdCd = str;
    }

    public String getSdbCenCd() {
        return this.sdbCenCd;
    }

    public void setSdbCenCd(String str) {
        this.sdbCenCd = str;
    }

    public String getSdbLgdCd() {
        return this.sdbLgdCd;
    }

    public void setSdbLgdCd(String str) {
        this.sdbLgdCd = str;
    }

    public String getDstCenCd() {
        return this.dstCenCd;
    }

    public void setDstCenCd(String str) {
        this.dstCenCd = str;
    }

    public String getDstLgdCd() {
        return this.dstLgdCd;
    }

    public void setDstLgdCd(String str) {
        this.dstLgdCd = str;
    }

    public String getSttCenCd() {
        return this.sttCenCd;
    }

    public void setSttCenCd(String str) {
        this.sttCenCd = str;
    }

    public String getSttLgdCd() {
        return this.sttLgdCd;
    }

    public void setSttLgdCd(String str) {
        this.sttLgdCd = str;
    }

    public String getTwnCenCd() {
        return this.twnCenCd;
    }

    public void setTwnCenCd(String str) {
        this.twnCenCd = str;
    }

    public String getTwnLgdCd() {
        return this.twnLgdCd;
    }

    public void setTwnLgdCd(String str) {
        this.twnLgdCd = str;
    }

    public Boolean isRoofTop() {
        return this.isRoofTop;
    }

    public void setRoofTop(Boolean bool) {
        this.isRoofTop = bool;
    }

    public Map getRichInfo() {
        return this.richInfo;
    }

    public void setRichInfo(Map map) {
        this.richInfo = map;
    }

    public List<EntryCoordinate> getEntryCoordinates() {
        return this.entryCoordinates;
    }

    public void setEntryCoordinates(List<EntryCoordinate> list) {
        this.entryCoordinates = list;
    }
}
