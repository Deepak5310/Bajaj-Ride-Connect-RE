package com.mappls.sdk.navigation.model;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.navigation.data.LocationPoint;
import com.mappls.sdk.navigation.data.a;

/* JADX INFO: loaded from: classes4.dex */
public class Junction implements LocationPoint {
    public Bitmap bitmap;

    @SerializedName("encodeImage")
    @Expose
    public String encodeImage;
    private double entryLeftDistance = 0.0d;

    @SerializedName("id")
    @Expose
    public String id;

    @SerializedName("image")
    @Expose
    public String image;

    @SerializedName("latitude")
    @Expose
    public double latitude;
    private double leftDistance;

    @SerializedName("longitude")
    @Expose
    public double longitude;

    @SerializedName("nodeId")
    @Expose
    public int nodeId;

    @SerializedName("nodeIdx")
    @Expose
    public int nodeIdx;

    @SerializedName("startLatitude")
    @Expose
    public Double startLatitude;

    @SerializedName("startLongitude")
    @Expose
    public Double startLongitude;

    @SerializedName("startNodeId")
    @Expose
    public int startNodeId;

    @SerializedName("startNodeIdx")
    @Expose
    public Integer startNodeIdx;

    @SerializedName("viaLatitude")
    @Expose
    public Double viaLatitude;

    @SerializedName("viaLongitude")
    @Expose
    public Double viaLongitude;

    @SerializedName("viaNodeId")
    @Expose
    public int viaNodeId;

    @SerializedName("viaNodeIdx")
    @Expose
    public int viaNodeIdx;

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public String getEncodeImage() {
        return this.encodeImage;
    }

    public double getEntryLeftDistance() {
        return this.entryLeftDistance;
    }

    public String getId() {
        return this.id;
    }

    public String getImage() {
        return this.image;
    }

    @Override // com.mappls.sdk.navigation.data.LocationPoint
    public double getLatitude() {
        return this.latitude;
    }

    public double getLeftDistance() {
        return this.leftDistance;
    }

    @Override // com.mappls.sdk.navigation.data.LocationPoint
    public double getLongitude() {
        return this.longitude;
    }

    public int getNodeId() {
        return this.nodeId;
    }

    public int getNodeIdx() {
        return this.nodeIdx;
    }

    @Override // com.mappls.sdk.navigation.data.LocationPoint
    public a getPointDescription(Context context) {
        return new a(this.latitude, this.longitude);
    }

    public Double getStartLatitude() {
        return this.startLatitude;
    }

    public Double getStartLongitude() {
        return this.startLongitude;
    }

    public int getStartNodeId() {
        return this.startNodeId;
    }

    public int getStartNodeIdx() {
        return this.startNodeIdx.intValue();
    }

    public Double getViaLatitude() {
        return this.viaLatitude;
    }

    public Double getViaLongitude() {
        return this.viaLongitude;
    }

    public int getViaNodeId() {
        return this.viaNodeId;
    }

    public int getViaNodeIdx() {
        return this.viaNodeIdx;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setEncodeImage(String str) {
        this.encodeImage = str;
    }

    public void setEntryLeftDistance(double d) {
        this.entryLeftDistance = d;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLeftDistance(double d) {
        this.leftDistance = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setNodeId(int i) {
        this.nodeId = i;
    }

    public void setNodeIdx(int i) {
        this.nodeIdx = i;
    }

    public void setStartLatitude(Double d) {
        this.startLatitude = d;
    }

    public void setStartLongitude(Double d) {
        this.startLongitude = d;
    }

    public void setStartNodeId(int i) {
        this.startNodeId = i;
    }

    public void setStartNodeIdx(int i) {
        this.startNodeIdx = Integer.valueOf(i);
    }

    public void setViaLatitude(Double d) {
        this.viaLatitude = d;
    }

    public void setViaLongitude(Double d) {
        this.viaLongitude = d;
    }

    public void setViaNodeId(int i) {
        this.viaNodeId = i;
    }

    public void setViaNodeIdx(int i) {
        this.viaNodeIdx = i;
    }
}
