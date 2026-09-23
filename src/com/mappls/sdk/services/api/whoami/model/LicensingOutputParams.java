package com.mappls.sdk.services.api.whoami.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class LicensingOutputParams {

    @SerializedName("deviceRegion")
    @Expose
    private List<String> deviceRegion;

    public List<String> getDeviceRegion() {
        return this.deviceRegion;
    }

    public void setDeviceRegion(List<String> list) {
        this.deviceRegion = list;
    }
}
