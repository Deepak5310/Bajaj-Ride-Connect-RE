package com.bajajconnect.wifi.tftEnums;

/* JADX INFO: loaded from: classes3.dex */
public class TftAddress {
    String address;
    Double lat;
    Double lng;

    public void setLat(Double d) {
    }

    public void setLng(Double d) {
    }

    public TftAddress(String str, Double d, Double d2) {
        this.address = str;
        this.lat = d;
        this.lng = d2;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public Double getLat() {
        return this.lat;
    }

    public String getAddress() {
        return this.address;
    }

    public Double getLng() {
        return this.lng;
    }
}
