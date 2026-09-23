package com.mappls.sdk.services.api.autosuggest.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes4.dex */
public class SuggestedSearchAtlas {

    @SerializedName("hyperLink")
    @Expose
    public String hyperLink;

    @SerializedName("identifier")
    @Expose
    public String identifier;

    @SerializedName("keyword")
    @Expose
    public String keyword;

    @SerializedName(FirebaseAnalytics.Param.LOCATION)
    @Expose
    public String location;

    @SerializedName(alternate = {"eLoc"}, value = "mapplsPin")
    @Expose
    private String mapplsPin;

    @SerializedName("orderIndex")
    @Expose
    public long orderIndex;

    public String getKeyword() {
        return this.keyword;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public String getHyperLink() {
        return this.hyperLink;
    }

    public void setHyperLink(String str) {
        this.hyperLink = str;
    }

    public String getSearchStringToShow() {
        return this.keyword + StringUtils.SPACE + this.identifier + StringUtils.SPACE + this.location;
    }

    public long getOrderIndex() {
        return this.orderIndex;
    }

    public void setOrderIndex(long j) {
        this.orderIndex = j;
    }

    public String getMapplsPin() {
        return this.mapplsPin;
    }

    public void setMapplsPin(String str) {
        this.mapplsPin = str;
    }
}
