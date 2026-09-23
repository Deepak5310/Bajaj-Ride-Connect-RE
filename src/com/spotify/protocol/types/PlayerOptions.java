package com.spotify.protocol.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerOptions implements Item {
    public static final PlayerOptions DEFAULT = new PlayerOptions();

    @SerializedName("shuffle")
    @JsonProperty("shuffle")
    public final boolean isShuffling;

    @SerializedName("repeat")
    @JsonProperty("repeat")
    public final int repeatMode;

    private PlayerOptions() {
        this(false, 0);
    }

    public PlayerOptions(boolean z, int i) {
        this.isShuffling = z;
        this.repeatMode = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerOptions)) {
            return false;
        }
        PlayerOptions playerOptions = (PlayerOptions) obj;
        return this.isShuffling == playerOptions.isShuffling && this.repeatMode == playerOptions.repeatMode;
    }

    public int hashCode() {
        return ((this.isShuffling ? 1 : 0) * 31) + this.repeatMode;
    }

    public String toString() {
        return "PlayerOptions{isShuffling=" + this.isShuffling + ", repeatMode=" + this.repeatMode + '}';
    }
}
