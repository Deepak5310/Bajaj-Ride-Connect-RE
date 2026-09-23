package com.mappls.sdk.services.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PlaceResponse {

    @SerializedName("results")
    @Expose
    private List<Place> places = null;

    @SerializedName("responseCode")
    @Expose
    private long responseCode;

    @SerializedName("version")
    @Expose
    private String version;

    public long getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(long j) {
        this.responseCode = j;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public List<Place> getPlaces() {
        return this.places;
    }

    public void setPlaces(List<Place> list) {
        this.places = list;
    }
}
