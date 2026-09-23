package com.mappls.sdk.navigation.model;

import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class NavigationLogsRequestModel {

    @SerializedName("deviceId")
    @Expose
    private String deviceId;

    @SerializedName("DoDV")
    @Expose
    private int doDV;

    @SerializedName("duration")
    @Expose
    private double duration;

    @SerializedName("duration_act")
    @Expose
    private long durationAct;

    @SerializedName("fromNode")
    @Expose
    private long fromNode;

    @SerializedName("latitude")
    @Expose
    private double latitude;

    @SerializedName("longitude")
    @Expose
    private double longitude;

    @SerializedName("node_latitude")
    @Expose
    private double nodeLatitude;

    @SerializedName("node_longitude")
    @Expose
    private double nodeLongitude;

    @SerializedName(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID)
    @Expose
    private String routeId;

    @SerializedName("routeIndex")
    @Expose
    private int routeIndex;

    @SerializedName("snapped_latitude")
    @Expose
    private double snappedLatitude;

    @SerializedName("snapped_longitude")
    @Expose
    private double snappedLongitude;

    @SerializedName("successfullySent")
    @Expose
    private Boolean successfullySent;

    @SerializedName("timestamp")
    @Expose
    private long timestamp;

    @SerializedName("toNode")
    @Expose
    private long toNode;

    public NavigationLogsRequestModel(String str, String str2, int i) {
        this.routeId = str;
        this.deviceId = str2;
        this.routeIndex = i;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getDoDV() {
        return this.doDV;
    }

    public double getDuration() {
        return this.duration;
    }

    public long getDurationAct() {
        return this.durationAct;
    }

    public long getFromNode() {
        return this.fromNode;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getNodeLatitude() {
        return this.nodeLatitude;
    }

    public double getNodeLongitude() {
        return this.nodeLongitude;
    }

    public String getRouteId() {
        return this.routeId;
    }

    public int getRouteIndex() {
        return this.routeIndex;
    }

    public double getSnappedLatitude() {
        return this.snappedLatitude;
    }

    public double getSnappedLongitude() {
        return this.snappedLongitude;
    }

    public Boolean getSuccessfullySent() {
        return this.successfullySent;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public long getToNode() {
        return this.toNode;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDoDV(int i) {
        this.doDV = i;
    }

    public void setDuration(double d) {
        this.duration = d;
    }

    public void setDurationAct(long j) {
        this.durationAct = j;
    }

    public void setFromNode(long j) {
        this.fromNode = j;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setNodeLatitude(double d) {
        this.nodeLatitude = d;
    }

    public void setNodeLongitude(double d) {
        this.nodeLongitude = d;
    }

    public void setRouteId(String str) {
        this.routeId = str;
    }

    public void setRouteIndex(int i) {
        this.routeIndex = i;
    }

    public void setSnappedLatitude(double d) {
        this.snappedLatitude = d;
    }

    public void setSnappedLongitude(double d) {
        this.snappedLongitude = d;
    }

    public void setSuccessfullySent(Boolean bool) {
        this.successfullySent = bool;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setToNode(long j) {
        this.toNode = j;
    }
}
