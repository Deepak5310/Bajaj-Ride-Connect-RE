package com.mappls.sdk.traffic.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.traffic.db.ProbeLocation;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ProbeWrapper {

    @SerializedName("device_id")
    @Expose
    private String deviceId;

    @SerializedName("gps")
    @Expose
    private List<ProbeLocation> gps = null;

    public String getDeviceId() {
        return this.deviceId;
    }

    public List<ProbeLocation> getGps() {
        return this.gps;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setGps(List<ProbeLocation> list) {
        this.gps = list;
    }
}
