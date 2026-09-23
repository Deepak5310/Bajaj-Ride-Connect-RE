package com.mappls.sdk.services.api.predictive.directions.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PredictiveDirectionsResponse {

    @SerializedName("alternates")
    @Expose
    private List<PredictiveDirectionsResponse> alternates;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("trip")
    @Expose
    private PredictiveDirectionsTrip trip;

    public PredictiveDirectionsTrip getTrip() {
        return this.trip;
    }

    public void setTrip(PredictiveDirectionsTrip predictiveDirectionsTrip) {
        this.trip = predictiveDirectionsTrip;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public List<PredictiveDirectionsResponse> getAlternates() {
        return this.alternates;
    }

    public void setAlternates(List<PredictiveDirectionsResponse> list) {
        this.alternates = list;
    }
}
