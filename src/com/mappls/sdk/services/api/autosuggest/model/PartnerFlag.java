package com.mappls.sdk.services.api.autosuggest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class PartnerFlag {

    @SerializedName("categoryIcon")
    @Expose
    private String categoryIcon;

    @SerializedName("categoryName")
    @Expose
    private String categoryName;

    @SerializedName("previewText")
    @Expose
    private String previewText;

    @SerializedName("providerId")
    @Expose
    private String providerId;

    @SerializedName("richInformationFlag")
    @Expose
    private Boolean richInformationFlag;

    public Boolean getRichInformationFlag() {
        return this.richInformationFlag;
    }

    public void setRichInformationFlag(Boolean bool) {
        this.richInformationFlag = bool;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public String getCategoryIcon() {
        return this.categoryIcon;
    }

    public void setCategoryIcon(String str) {
        this.categoryIcon = str;
    }

    public String getPreviewText() {
        return this.previewText;
    }

    public void setPreviewText(String str) {
        this.previewText = str;
    }

    public String getProviderId() {
        return this.providerId;
    }

    public void setProviderId(String str) {
        this.providerId = str;
    }
}
