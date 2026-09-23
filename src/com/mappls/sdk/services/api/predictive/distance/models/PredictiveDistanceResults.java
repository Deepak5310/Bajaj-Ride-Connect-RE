package com.mappls.sdk.services.api.predictive.distance.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;

/* JADX INFO: loaded from: classes4.dex */
public class PredictiveDistanceResults {

    @SerializedName(DirectionsCriteria.ANNOTATION_DISTANCE)
    @Expose
    private Double distance;

    @SerializedName("from_index")
    @Expose
    private Integer fromIndex;

    @SerializedName("time")
    @Expose
    private Integer time;

    @SerializedName("to_index")
    @Expose
    private Integer toIndex;

    public Integer getFromIndex() {
        return this.fromIndex;
    }

    public void setFromIndex(Integer num) {
        this.fromIndex = num;
    }

    public Double getDistance() {
        return this.distance;
    }

    public void setDistance(Double d) {
        this.distance = d;
    }

    public Integer getTime() {
        return this.time;
    }

    public void setTime(Integer num) {
        this.time = num;
    }

    public Integer getToIndex() {
        return this.toIndex;
    }

    public void setToIndex(Integer num) {
        this.toIndex = num;
    }
}
