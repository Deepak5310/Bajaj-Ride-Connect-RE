package com.spotify.protocol.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repeat implements Item {
    public static final int ALL = 2;
    public static final int OFF = 0;
    public static final int ONE = 1;

    @SerializedName("repeat")
    @JsonProperty("repeat")
    public final int repeat;

    private Repeat() {
        this(0);
    }

    public Repeat(int i) {
        this.repeat = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Repeat) && this.repeat == ((Repeat) obj).repeat;
    }

    public int hashCode() {
        return this.repeat;
    }

    public String toString() {
        return "Repeat{repeat=" + this.repeat + '}';
    }
}
