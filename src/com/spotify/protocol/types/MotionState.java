package com.spotify.protocol.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MotionState implements Item {
    public static final int DETECTED = 2;
    public static final int DETECTING = 1;
    public static final int ERROR = 3;
    public static final int INITIAL = 0;
    public static final int SKIPPED = 4;
    public static final int UNKNOWN = -1;

    @SerializedName("state")
    @JsonProperty("state")
    public final int state;

    private MotionState() {
        this(-1);
    }

    public MotionState(int i) {
        this.state = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MotionState) && this.state == ((MotionState) obj).state;
    }

    public int hashCode() {
        return this.state;
    }

    public String toString() {
        return "MotionState{state=" + this.state + '}';
    }
}
