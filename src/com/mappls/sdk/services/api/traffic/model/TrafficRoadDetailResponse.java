package com.mappls.sdk.services.api.traffic.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class TrafficRoadDetailResponse {

    @SerializedName("creationTime")
    @Expose
    private String creationTime;

    @SerializedName("responseCode")
    @Expose
    private Integer responseCode;

    @SerializedName("result")
    @Expose
    private TrafficRoadDetailResult result;

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(Integer num) {
        this.responseCode = num;
    }

    public String getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(String str) {
        this.creationTime = str;
    }

    public TrafficRoadDetailResult getResult() {
        return this.result;
    }

    public void setResult(TrafficRoadDetailResult trafficRoadDetailResult) {
        this.result = trafficRoadDetailResult;
    }
}
