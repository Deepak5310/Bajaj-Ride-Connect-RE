package com.bajajconnect.navigate.poi;

/* JADX INFO: loaded from: classes3.dex */
public class PoiModel {
    public String address;
    public float distanceMeters;
    public double lat;
    public double lng;
    public String name;
    public String placeId;

    public PoiModel(String str, String str2, String str3, double d, double d2) {
        this.placeId = str;
        this.name = str2;
        this.address = str3;
        this.lat = d;
        this.lng = d2;
    }
}
