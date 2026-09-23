package com.mappls.sdk.services.api.tripplan.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SmartTripPlanResponse {

    @SerializedName("results")
    private List<SmartTripPlanStop> results;

    public List<SmartTripPlanStop> getResults() {
        return this.results;
    }

    public void setResults(List<SmartTripPlanStop> list) {
        this.results = list;
    }
}
