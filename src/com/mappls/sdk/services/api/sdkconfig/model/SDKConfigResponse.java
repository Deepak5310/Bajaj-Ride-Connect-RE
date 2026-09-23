package com.mappls.sdk.services.api.sdkconfig.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class SDKConfigResponse {

    @SerializedName("data")
    @Expose
    private String data;

    @SerializedName("environment")
    @Expose
    private String environment;

    @SerializedName("version")
    @Expose
    private String version;

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public void setEnvironment(String str) {
        this.environment = str;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }
}
