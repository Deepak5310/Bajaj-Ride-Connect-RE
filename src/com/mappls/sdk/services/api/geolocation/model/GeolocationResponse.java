package com.mappls.sdk.services.api.geolocation.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class GeolocationResponse {

    @SerializedName("accuracy")
    @Expose
    private Accuracy accuracy;

    @SerializedName(FirebaseAnalytics.Param.LOCATION)
    @Expose
    private Geolocation location;

    public Geolocation getLocation() {
        return this.location;
    }

    public void setLocation(Geolocation geolocation) {
        this.location = geolocation;
    }

    public Accuracy getAccuracy() {
        return this.accuracy;
    }

    public void setAccuracy(Accuracy accuracy) {
        this.accuracy = accuracy;
    }
}
