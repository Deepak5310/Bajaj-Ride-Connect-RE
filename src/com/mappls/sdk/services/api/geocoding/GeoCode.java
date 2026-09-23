package com.mappls.sdk.services.api.geocoding;

import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class GeoCode {

    @SerializedName(GeoCodingCriteria.POD_CITY)
    @Expose
    public String city;

    @SerializedName("confidenceScore")
    @Expose
    public Float confidenceScore;

    @SerializedName("district")
    @Expose
    public String district;

    @SerializedName("dstCenCd")
    @Expose
    public String dstCenCd;

    @SerializedName("dstLgdCd")
    @Expose
    public String dstLgdCd;

    @SerializedName("formattedAddress")
    @Expose
    public String formattedAddress;

    @SerializedName("geocodeLevel")
    @Expose
    public String geocodeLevel;

    @SerializedName("houseName")
    @Expose
    public String houseName;

    @SerializedName("houseNumber")
    @Expose
    public String houseNumber;

    @SerializedName("latitude")
    @Expose
    public double latitude;

    @SerializedName(PlaceTypes.LOCALITY)
    @Expose
    public String locality;

    @SerializedName("longitude")
    @Expose
    public double longitude;

    @SerializedName(alternate = {"eLoc"}, value = "mapplsPin")
    @Expose
    public String mapplsPin;

    @SerializedName(GeoCodingCriteria.POD_PINCODE)
    @Expose
    public String pincode;

    @SerializedName(GeoCodingCriteria.POD_POINT_OF_INTEREST)
    @Expose
    public String poi;

    @SerializedName("sdbCenCd")
    @Expose
    public String sdbCenCd;

    @SerializedName("sdbLgdCd")
    @Expose
    public String sdbLgdCd;

    @SerializedName("state")
    @Expose
    public String state;

    @SerializedName(GeoCodingCriteria.POD_STREET)
    @Expose
    public String street;

    @SerializedName("sttCenCd")
    @Expose
    public String sttCenCd;

    @SerializedName("sttLgdCd")
    @Expose
    public String sttLgdCd;

    @SerializedName("subDistrict")
    @Expose
    public String subDistrict;

    @SerializedName("subLocality")
    @Expose
    public String subLocality;

    @SerializedName("subSubLocality")
    @Expose
    public String subSubLocality;

    @SerializedName("twnCenCd")
    @Expose
    public String twnCenCd;

    @SerializedName("twnLgdCd")
    @Expose
    public String twnLgdCd;

    @SerializedName("twnName")
    @Expose
    public String twnName;

    @SerializedName(GeoCodingCriteria.POD_VILLAGE)
    @Expose
    public String village;

    @SerializedName("vlgCenCd")
    @Expose
    public String vlgCenCd;

    @SerializedName("vlgLgdCd")
    @Expose
    public String vlgLgdCd;
}
