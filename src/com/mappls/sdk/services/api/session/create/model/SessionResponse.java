package com.mappls.sdk.services.api.session.create.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class SessionResponse {

    @SerializedName("expiresAfter")
    @Expose
    public double expiresAfter;

    @SerializedName("passport")
    @Expose
    public String passport;

    @SerializedName(alternate = {"sessionLink"}, value = "link")
    @Expose
    public String passportLink;
}
