package com.mappls.sdk.services.api.auth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class AuthenticationResponse {

    @SerializedName("t")
    @Expose
    private String tokenString;

    public String getTokenString() {
        return this.tokenString;
    }

    public void setTokenString(String str) {
        this.tokenString = str;
    }
}
