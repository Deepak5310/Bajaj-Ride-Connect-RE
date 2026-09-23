package com.bajajconnect.wifi.model;

import com.mappls.sdk.maps.geometry.LatLng;

/* JADX INFO: loaded from: classes3.dex */
public class SearchResultModel {
    private String address;
    private LatLng latLng;
    private String mapplsPin;
    private String placeName;

    public SearchResultModel(String str, String str2, String str3, LatLng latLng) {
        this.address = str;
        this.placeName = str2;
        this.mapplsPin = str3;
        this.latLng = latLng;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setPlaceName(String str) {
        this.placeName = str;
    }

    public void setMapplsPin(String str) {
        this.mapplsPin = str;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPlaceName() {
        return this.placeName;
    }

    public String getMapplsPin() {
        return this.mapplsPin;
    }

    public LatLng getLatLng() {
        return this.latLng;
    }
}
