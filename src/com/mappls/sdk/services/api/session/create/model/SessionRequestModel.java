package com.mappls.sdk.services.api.session.create.model;

import com.BV.LinearGradient.LinearGradientManager;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class SessionRequestModel {

    @SerializedName("associationId")
    private String associationId;

    @SerializedName("deviceAlias")
    @Expose
    private String deviceAlias;

    @SerializedName("deviceFingerprint")
    @Expose
    private String deviceFingerprint;

    @SerializedName(LinearGradientManager.PROP_END_POINT)
    @Expose
    private String endPoint;

    @SerializedName("nst")
    @Expose
    private Long nst;

    @SerializedName("osName")
    @Expose
    private String osName;

    @SerializedName("osVersion")
    @Expose
    private String osVersion;

    @SerializedName("requestedTTL")
    @Expose
    private Integer requestedTTL;

    @SerializedName(RemoteConfigConstants.RequestFieldKey.SDK_VERSION)
    @Expose
    private String sdkVersion;

    @SerializedName(LinearGradientManager.PROP_START_POINT)
    @Expose
    private String startPoint;

    @SerializedName("tripDistance")
    @Expose
    private Long tripDistance;

    @SerializedName("tripDuration")
    @Expose
    private Long tripDuration;

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public String getDeviceFingerprint() {
        return this.deviceFingerprint;
    }

    public void setDeviceFingerprint(String str) {
        this.deviceFingerprint = str;
    }

    public String getOsName() {
        return this.osName;
    }

    public void setOsName(String str) {
        this.osName = str;
    }

    public Integer getRequestedTTL() {
        return this.requestedTTL;
    }

    public void setRequestedTTL(Integer num) {
        this.requestedTTL = num;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public String getDeviceAlias() {
        return this.deviceAlias;
    }

    public void setDeviceAlias(String str) {
        this.deviceAlias = str;
    }

    public String getAssociationId() {
        return this.associationId;
    }

    public void setAssociationId(String str) {
        this.associationId = str;
    }

    public String getStartPoint() {
        return this.startPoint;
    }

    public void setStartPoint(String str) {
        this.startPoint = str;
    }

    public String getEndPoint() {
        return this.endPoint;
    }

    public void setEndPoint(String str) {
        this.endPoint = str;
    }

    public Long getNst() {
        return this.nst;
    }

    public void setNst(Long l) {
        this.nst = l;
    }

    public Long getTripDistance() {
        return this.tripDistance;
    }

    public void setTripDistance(Long l) {
        this.tripDistance = l;
    }

    public Long getTripDuration() {
        return this.tripDuration;
    }

    public void setTripDuration(Long l) {
        this.tripDuration = l;
    }
}
