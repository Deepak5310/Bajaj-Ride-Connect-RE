package com.mappls.sdk.services.api.transit.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class TransitLegGeometry {

    @SerializedName("length")
    private Integer length;

    @SerializedName("points")
    private String points;

    public Integer getLength() {
        return this.length;
    }

    public void setLength(Integer num) {
        this.length = num;
    }

    public String getPoints() {
        return this.points;
    }

    public void setPoints(String str) {
        this.points = str;
    }
}
