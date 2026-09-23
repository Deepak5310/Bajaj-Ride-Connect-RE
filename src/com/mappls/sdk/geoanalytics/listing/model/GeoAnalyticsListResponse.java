package com.mappls.sdk.geoanalytics.listing.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class GeoAnalyticsListResponse {

    @SerializedName("responseCode")
    @Expose
    private Integer responseCode;

    @SerializedName("results")
    @Expose
    private GeoAnalyticsListResult results;

    @SerializedName("total_feature_count")
    @Expose
    private Integer totalFeatureCount;

    @SerializedName("version")
    @Expose
    private String version;

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public GeoAnalyticsListResult getResults() {
        return this.results;
    }

    public Integer getTotalFeatureCount() {
        return this.totalFeatureCount;
    }

    public String getVersion() {
        return this.version;
    }

    public void setResponseCode(Integer num) {
        this.responseCode = num;
    }

    public void setResults(GeoAnalyticsListResult geoAnalyticsListResult) {
        this.results = geoAnalyticsListResult;
    }

    public void setTotalFeatureCount(Integer num) {
        this.totalFeatureCount = num;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
