package com.mappls.sdk.services.api.event.catmaster.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class BaseUrl {

    @SerializedName("icon_url")
    @Expose
    private String iconUrl;

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }
}
