package com.spotify.protocol.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Shuffle implements Item {

    @SerializedName("shuffle")
    @JsonProperty("shuffle")
    public final boolean shuffle;

    private Shuffle() {
        this(false);
    }

    public Shuffle(boolean z) {
        this.shuffle = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Shuffle) && this.shuffle == ((Shuffle) obj).shuffle;
    }

    public int hashCode() {
        return this.shuffle ? 1 : 0;
    }

    public String toString() {
        return "Shuffle{shuffle=" + this.shuffle + '}';
    }
}
