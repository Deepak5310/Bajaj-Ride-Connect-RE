package com.mappls.sdk.maps.promo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.navigation.util.SavingTrackHelper;

/* JADX INFO: loaded from: classes4.dex */
public class HyperlinkContent {

    @SerializedName(SavingTrackHelper.POINT_COL_DESCRIPTION)
    @Expose
    private String description;

    @SerializedName("iconSource")
    @Expose
    private String iconSource;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("triggerUrl")
    @Expose
    private String triggerUrl;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getIconSource() {
        return this.iconSource;
    }

    public void setIconSource(String str) {
        this.iconSource = str;
    }

    public String getTriggerUrl() {
        return this.triggerUrl;
    }

    public void setTriggerUrl(String str) {
        this.triggerUrl = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }
}
