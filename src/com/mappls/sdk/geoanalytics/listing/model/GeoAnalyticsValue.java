package com.mappls.sdk.geoanalytics.listing.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class GeoAnalyticsValue {

    @SerializedName("geo_bound")
    @Expose
    private String geoBound;

    @SerializedName("get_attr_values")
    @Expose
    private List<Map<String, Object>> getAttrValues = null;

    public String getGeoBound() {
        return this.geoBound;
    }

    public List<Map<String, Object>> getGetAttrValues() {
        return this.getAttrValues;
    }

    public void setGeoBound(String str) {
        this.geoBound = str;
    }

    public void setGetAttrValues(List<Map<String, Object>> list) {
        this.getAttrValues = list;
    }
}
