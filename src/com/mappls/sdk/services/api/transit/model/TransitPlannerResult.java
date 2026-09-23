package com.mappls.sdk.services.api.transit.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class TransitPlannerResult {

    @SerializedName("plan")
    private TransitPlan transitPlan;

    public TransitPlan getTransitPlan() {
        return this.transitPlan;
    }

    public void setTransitPlan(TransitPlan transitPlan) {
        this.transitPlan = transitPlan;
    }
}
