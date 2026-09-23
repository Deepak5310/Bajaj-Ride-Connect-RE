package com.spotify.protocol.types;

import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VolumeState implements Item {

    @SerializedName("controllable")
    @JsonProperty("controllable")
    public final boolean mControllable;

    @SerializedName(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME)
    @JsonProperty(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME)
    public final float mVolume;

    public VolumeState(float f, boolean z) {
        this.mVolume = f;
        this.mControllable = z;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VolumeState)) {
            return false;
        }
        VolumeState volumeState = (VolumeState) obj;
        return Float.compare(volumeState.mVolume, this.mVolume) == 0 && this.mControllable == volumeState.mControllable;
    }

    public int hashCode() {
        float f = this.mVolume;
        return ((f != 0.0f ? Float.floatToIntBits(f) : 0) * 31) + (this.mControllable ? 1 : 0);
    }
}
