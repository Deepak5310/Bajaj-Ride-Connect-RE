package com.mappls.sdk.services.api.whoami.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class LicensingParams {

    @SerializedName("clusterId")
    @Expose
    private Boolean clusterDevice;

    @SerializedName("deviceFingerprint")
    @Expose
    private Boolean deviceFingerprint;

    @SerializedName("userId")
    @Expose
    private Boolean userId;

    @SerializedName("vin")
    @Expose
    private Boolean vin;

    public Boolean getVin() {
        return this.vin;
    }

    public void setVin(Boolean bool) {
        this.vin = bool;
    }

    public Boolean getClusterDevice() {
        return this.clusterDevice;
    }

    public void setClusterDevice(Boolean bool) {
        this.clusterDevice = bool;
    }

    public Boolean getDeviceFingerprint() {
        return this.deviceFingerprint;
    }

    public void setDeviceFingerprint(Boolean bool) {
        this.deviceFingerprint = bool;
    }

    public Boolean getUserId() {
        return this.userId;
    }

    public void setUserId(Boolean bool) {
        this.userId = bool;
    }
}
