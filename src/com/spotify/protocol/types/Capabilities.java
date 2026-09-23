package com.spotify.protocol.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Capabilities implements Item {

    @SerializedName("can_play_on_demand")
    @JsonProperty("can_play_on_demand")
    public final boolean canPlayOnDemand;

    private Capabilities() {
        this(false);
    }

    public Capabilities(boolean z) {
        this.canPlayOnDemand = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Capabilities) && this.canPlayOnDemand == ((Capabilities) obj).canPlayOnDemand;
    }

    public int hashCode() {
        return this.canPlayOnDemand ? 1 : 0;
    }

    public String toString() {
        return "Capabilities{canPlayOnDemand=" + this.canPlayOnDemand + '}';
    }
}
