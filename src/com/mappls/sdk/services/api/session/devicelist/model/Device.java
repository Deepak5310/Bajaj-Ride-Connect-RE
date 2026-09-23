package com.mappls.sdk.services.api.session.devicelist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class Device {

    @SerializedName("deviceAlias")
    @Expose
    private String deviceAlias;

    @SerializedName("deviceFingerprint")
    @Expose
    private String deviceFingerprint;

    public String getDeviceFingerprint() {
        return this.deviceFingerprint;
    }

    public void setDeviceFingerprint(String str) {
        this.deviceFingerprint = str;
    }

    public String getDeviceAlias() {
        return this.deviceAlias;
    }

    public void setDeviceAlias(String str) {
        this.deviceAlias = str;
    }
}
