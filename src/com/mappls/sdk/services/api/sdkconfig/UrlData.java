package com.mappls.sdk.services.api.sdkconfig;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.api.predictive.distance.PredictiveDistanceCriteria;

/* JADX INFO: loaded from: classes4.dex */
public class UrlData {

    @SerializedName("anchor")
    @Expose
    private String anchorUrl;

    @SerializedName("apis")
    @Expose
    private String apisUrl;

    @SerializedName("atlas")
    @Expose
    private String atlasUrl;

    @SerializedName("backend")
    @Expose
    private String backendUrl;

    @SerializedName("explore")
    @Expose
    private String exploreUrl;

    @SerializedName("geoanalytics")
    @Expose
    private String geoanalyticsUrl;

    @SerializedName("intouch")
    @Expose
    private String intouchUrl;

    @SerializedName("lms")
    @Expose
    private String lmsUrl;

    @SerializedName("mgis_api")
    @Expose
    private String mgisApiUrl;

    @SerializedName("mgis")
    @Expose
    private String mgisUrl;

    @SerializedName("outpost")
    @Expose
    private String outpostUrl;

    @SerializedName(PredictiveDistanceCriteria.SPEED_TYPES_TRAFFIC)
    @Expose
    private String trafficUrl;

    public String getAtlasUrl() {
        return this.atlasUrl;
    }

    public void setAtlasUrl(String str) {
        this.atlasUrl = str;
    }

    public String getApisUrl() {
        return this.apisUrl;
    }

    public void setApisUrl(String str) {
        this.apisUrl = str;
    }

    public String getAnchorUrl() {
        return this.anchorUrl;
    }

    public void setAnchorUrl(String str) {
        this.anchorUrl = str;
    }

    public String getExploreUrl() {
        return this.exploreUrl;
    }

    public void setExploreUrl(String str) {
        this.exploreUrl = str;
    }

    public String getTrafficUrl() {
        return this.trafficUrl;
    }

    public void setTrafficUrl(String str) {
        this.trafficUrl = str;
    }

    public String getOutpostUrl() {
        return this.outpostUrl;
    }

    public void setOutpostUrl(String str) {
        this.outpostUrl = str;
    }

    public String getLmsUrl() {
        return this.lmsUrl;
    }

    public void setLmsUrl(String str) {
        this.lmsUrl = str;
    }

    public String getMgisUrl() {
        return this.mgisUrl;
    }

    public void setMgisUrl(String str) {
        this.mgisUrl = str;
    }

    public String getMgisApiUrl() {
        return this.mgisApiUrl;
    }

    public void setMgisApiUrl(String str) {
        this.mgisApiUrl = str;
    }

    public String getIntouchUrl() {
        return this.intouchUrl;
    }

    public void setIntouchUrl(String str) {
        this.intouchUrl = str;
    }

    public String getGeoanalyticsUrl() {
        return this.geoanalyticsUrl;
    }

    public void setGeoanalyticsUrl(String str) {
        this.geoanalyticsUrl = str;
    }

    public String getBackendUrl() {
        return this.backendUrl;
    }

    public void setBackendUrl(String str) {
        this.backendUrl = str;
    }
}
