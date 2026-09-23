package com.mappls.sdk.services.api.predictive.directions.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PredictiveDirectionsLeg {

    @SerializedName("maneuvers")
    @Expose
    private List<PredictiveDirectionManeuver> maneuvers;

    @SerializedName("shape")
    @Expose
    private String shape;

    @SerializedName("summary")
    @Expose
    private PredictiveDirectionSummary summary;

    public PredictiveDirectionSummary getSummary() {
        return this.summary;
    }

    public void setSummary(PredictiveDirectionSummary predictiveDirectionSummary) {
        this.summary = predictiveDirectionSummary;
    }

    public String getShape() {
        return this.shape;
    }

    public void setShape(String str) {
        this.shape = str;
    }

    public List<PredictiveDirectionManeuver> getManeuvers() {
        return this.maneuvers;
    }

    public void setManeuvers(List<PredictiveDirectionManeuver> list) {
        this.maneuvers = list;
    }
}
