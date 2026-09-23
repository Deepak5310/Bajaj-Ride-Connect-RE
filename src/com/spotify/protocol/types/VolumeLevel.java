package com.spotify.protocol.types;

import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VolumeLevel implements Item {

    @SerializedName(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME)
    @JsonProperty(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME)
    public final float mVolume;

    public VolumeLevel(float f) {
        this.mVolume = f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VolumeLevel) && Float.compare(((VolumeLevel) obj).mVolume, this.mVolume) == 0;
    }

    public int hashCode() {
        float f = this.mVolume;
        if (f != 0.0f) {
            return Float.floatToIntBits(f);
        }
        return 0;
    }
}
