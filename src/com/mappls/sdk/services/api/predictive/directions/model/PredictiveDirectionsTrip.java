package com.mappls.sdk.services.api.predictive.directions.model;

import androidx.core.app.NotificationCompat;
import com.BV.LinearGradient.LinearGradientManager;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PredictiveDirectionsTrip {

    @SerializedName("language")
    @Expose
    private String language;

    @SerializedName("legs")
    @Expose
    private List<PredictiveDirectionsLeg> legs;

    @SerializedName(LinearGradientManager.PROP_LOCATIONS)
    @Expose
    private List<PredictiveDirectionLocation> locations;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    @Expose
    private Integer status;

    @SerializedName("status_message")
    @Expose
    private String statusMessage;

    @SerializedName("summary")
    @Expose
    private PredictiveDirectionSummary summary;

    @SerializedName("units")
    @Expose
    private String units;

    public PredictiveDirectionSummary getSummary() {
        return this.summary;
    }

    public void setSummary(PredictiveDirectionSummary predictiveDirectionSummary) {
        this.summary = predictiveDirectionSummary;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public List<PredictiveDirectionsLeg> getLegs() {
        return this.legs;
    }

    public void setLegs(List<PredictiveDirectionsLeg> list) {
        this.legs = list;
    }

    public List<PredictiveDirectionLocation> getLocations() {
        return this.locations;
    }

    public void setLocations(List<PredictiveDirectionLocation> list) {
        this.locations = list;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public String getUnits() {
        return this.units;
    }

    public void setUnits(String str) {
        this.units = str;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }
}
