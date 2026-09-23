package com.mappls.sdk.services.api.transit.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class TransitPlan {

    @SerializedName("date")
    private Long date;

    @SerializedName(TypedValues.TransitionType.S_TO)
    private TransitVertex destination;

    @SerializedName("itineraries")
    private List<TransitItinerary> itineraries;

    @SerializedName("from")
    private TransitVertex source;

    public Long getDate() {
        return this.date;
    }

    public void setDate(Long l) {
        this.date = l;
    }

    public List<TransitItinerary> getItineraries() {
        return this.itineraries;
    }

    public void setItineraries(List<TransitItinerary> list) {
        this.itineraries = list;
    }

    public TransitVertex getSource() {
        return this.source;
    }

    public void setSource(TransitVertex transitVertex) {
        this.source = transitVertex;
    }

    public TransitVertex getDestination() {
        return this.destination;
    }

    public void setDestination(TransitVertex transitVertex) {
        this.destination = transitVertex;
    }
}
