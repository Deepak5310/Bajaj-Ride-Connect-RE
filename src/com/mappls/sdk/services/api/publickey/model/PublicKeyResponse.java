package com.mappls.sdk.services.api.publickey.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class PublicKeyResponse {

    @SerializedName("expiresAfter")
    private Long expiresAfter;

    @SerializedName("expiresOn")
    private Long expiresOn;

    @SerializedName("k")
    private String secretKey;

    public String getSecretKey() {
        return this.secretKey;
    }

    public void setSecretKey(String str) {
        this.secretKey = str;
    }

    public Long getExpiresAfter() {
        return this.expiresAfter;
    }

    public void setExpiresAfter(Long l) {
        this.expiresAfter = l;
    }

    public Long getExpiresOn() {
        return this.expiresOn;
    }

    public void setExpiresOn(Long l) {
        this.expiresOn = l;
    }
}
