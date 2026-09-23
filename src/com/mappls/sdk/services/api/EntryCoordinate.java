package com.mappls.sdk.services.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class EntryCoordinate {

    @SerializedName("elat")
    @Expose
    private double entryLatitude;

    @SerializedName("elng")
    @Expose
    private double entryLongitude;

    public double getEntryLatitude() {
        return this.entryLatitude;
    }

    public void setEntryLatitude(double d) {
        this.entryLatitude = d;
    }

    public double getEntryLongitude() {
        return this.entryLongitude;
    }

    public void setEntryLongitude(double d) {
        this.entryLongitude = d;
    }
}
