package com.mappls.sdk.services.api.whoami.model;

import com.google.common.net.HttpHeaders;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class LicensingHeader {

    @SerializedName(HttpHeaders.AUTHORIZATION)
    @Expose
    private Boolean authorization;

    @SerializedName("x-dh")
    @Expose
    private Boolean xDh;

    @SerializedName("x-ms-seh")
    @Expose
    private Boolean xMsSeh;

    public Boolean getAuthorization() {
        return this.authorization;
    }

    public void setAuthorization(Boolean bool) {
        this.authorization = bool;
    }

    public Boolean getxMsSeh() {
        return this.xMsSeh;
    }

    public void setxMsSeh(Boolean bool) {
        this.xMsSeh = bool;
    }

    public Boolean getxDh() {
        return this.xDh;
    }

    public void setxDh(Boolean bool) {
        this.xDh = bool;
    }
}
