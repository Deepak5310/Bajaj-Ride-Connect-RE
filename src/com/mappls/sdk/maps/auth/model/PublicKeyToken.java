package com.mappls.sdk.maps.auth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class PublicKeyToken {

    @SerializedName("expiresOn")
    @Expose
    private long expiresOn;

    @SerializedName("publicKey")
    @Expose
    private String publicKey;

    public long getExpiresOn() {
        return this.expiresOn;
    }

    public void setExpiresOn(long j) {
        this.expiresOn = j;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public void setPublicKey(String str) {
        this.publicKey = str;
    }
}
