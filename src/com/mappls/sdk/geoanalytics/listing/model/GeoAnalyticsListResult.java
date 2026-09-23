package com.mappls.sdk.geoanalytics.listing.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class GeoAnalyticsListResult {

    @SerializedName("api_name")
    @Expose
    private String apiName;

    @SerializedName("attribute")
    @Expose
    private String attribute;

    @SerializedName("get_attr_values")
    @Expose
    private List<GeoAnalyticsValue> getAttrValues = null;

    public String getApiName() {
        return this.apiName;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public List<GeoAnalyticsValue> getGetAttrValues() {
        return this.getAttrValues;
    }

    public void setApiName(String str) {
        this.apiName = str;
    }

    public void setAttribute(String str) {
        this.attribute = str;
    }

    public void setGetAttrValues(List<GeoAnalyticsValue> list) {
        this.getAttrValues = list;
    }
}
