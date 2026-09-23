package com.spotify.protocol.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.firebase.perf.util.Constants;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CrossfadeState implements Item {

    @JsonProperty("duration")
    public int duration;

    @JsonProperty(Constants.ENABLE_DISABLE)
    public boolean isEnabled;

    public CrossfadeState(boolean z, int i) {
        this.isEnabled = z;
        this.duration = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CrossfadeState)) {
            return false;
        }
        CrossfadeState crossfadeState = (CrossfadeState) obj;
        return this.isEnabled == crossfadeState.isEnabled && this.duration == crossfadeState.duration;
    }

    public int hashCode() {
        return ((this.isEnabled ? 1 : 0) * 31) + this.duration;
    }

    public String toString() {
        return "CrossfadeState{isEnabled=" + this.isEnabled + ", duration=" + this.duration + '}';
    }
}
