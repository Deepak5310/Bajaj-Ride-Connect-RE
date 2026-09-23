package com.mappls.sdk.geoanalytics;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class MapplsGeoAnalyticsDetail {

    @SerializedName("id")
    private String id;

    @SerializedName("properties")
    private Map<String, Object> properties;
    private String type;

    public Map<String, Object> getProperties() {
        return this.properties;
    }

    public String getType() {
        return this.type;
    }

    public void setProperties(Map<String, Object> map) {
        this.properties = map;
    }

    public void setType(String str) {
        this.type = str;
    }
}
