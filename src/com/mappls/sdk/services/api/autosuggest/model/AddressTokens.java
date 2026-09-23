package com.mappls.sdk.services.api.autosuggest.model;

import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.api.geocoding.GeoCodingCriteria;

/* JADX INFO: loaded from: classes4.dex */
public class AddressTokens {

    @SerializedName(GeoCodingCriteria.POD_CITY)
    @Expose
    public String city;

    @SerializedName("district")
    @Expose
    public String district;

    @SerializedName("houseName")
    @Expose
    public String houseName;

    @SerializedName("houseNumber")
    @Expose
    public String houseNumber;

    @SerializedName(PlaceTypes.LOCALITY)
    @Expose
    public String locality;

    @SerializedName(GeoCodingCriteria.POD_PINCODE)
    @Expose
    public String pincode;

    @SerializedName(GeoCodingCriteria.POD_POINT_OF_INTEREST)
    @Expose
    public String poi;

    @SerializedName("state")
    @Expose
    public String state;

    @SerializedName(GeoCodingCriteria.POD_STREET)
    @Expose
    public String street;

    @SerializedName("subDistrict")
    @Expose
    public String subDistrict;

    @SerializedName("subLocality")
    @Expose
    public String subLocality;

    @SerializedName("subSubLocality")
    @Expose
    public String subSubLocality;

    @SerializedName(GeoCodingCriteria.POD_VILLAGE)
    @Expose
    public String village;
}
