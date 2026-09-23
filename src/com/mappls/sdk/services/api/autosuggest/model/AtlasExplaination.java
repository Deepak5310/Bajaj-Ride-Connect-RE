package com.mappls.sdk.services.api.autosuggest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class AtlasExplaination {

    @SerializedName("isKeyword")
    @Expose
    private boolean isKeyword;

    @SerializedName("keyword")
    @Expose
    private String keyword;

    @SerializedName("refLocation")
    @Expose
    private String refLocation;

    public boolean isIsKeyword() {
        return this.isKeyword;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public String getRefLocation() {
        return this.refLocation;
    }
}
