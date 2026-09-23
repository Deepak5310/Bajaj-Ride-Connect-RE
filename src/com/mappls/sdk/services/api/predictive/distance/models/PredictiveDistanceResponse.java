package com.mappls.sdk.services.api.predictive.distance.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PredictiveDistanceResponse {

    @SerializedName("sources")
    @Expose
    private List<List<PredictiveDistanceLocation>> sources;

    @SerializedName("sources_to_targets")
    @Expose
    private List<List<PredictiveDistanceResults>> sourcesToTargets;

    @SerializedName("targets")
    @Expose
    private List<List<PredictiveDistanceLocation>> targets;

    @SerializedName("units")
    @Expose
    private String units;

    public List<List<PredictiveDistanceResults>> getSourcesToTargets() {
        return this.sourcesToTargets;
    }

    public void setSourcesToTargets(List<List<PredictiveDistanceResults>> list) {
        this.sourcesToTargets = list;
    }

    public List<List<PredictiveDistanceLocation>> getSources() {
        return this.sources;
    }

    public void setSources(List<List<PredictiveDistanceLocation>> list) {
        this.sources = list;
    }

    public String getUnits() {
        return this.units;
    }

    public void setUnits(String str) {
        this.units = str;
    }

    public List<List<PredictiveDistanceLocation>> getTargets() {
        return this.targets;
    }

    public void setTargets(List<List<PredictiveDistanceLocation>> list) {
        this.targets = list;
    }
}
