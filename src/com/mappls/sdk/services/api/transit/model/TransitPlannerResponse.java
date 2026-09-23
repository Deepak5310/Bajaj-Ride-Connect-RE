package com.mappls.sdk.services.api.transit.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class TransitPlannerResponse {

    @SerializedName("responseCode")
    private Integer responseCode;

    @SerializedName("results")
    private TransitPlannerResult result;

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(Integer num) {
        this.responseCode = num;
    }

    public TransitPlannerResult getResult() {
        return this.result;
    }

    public void setResult(TransitPlannerResult transitPlannerResult) {
        this.result = transitPlannerResult;
    }
}
