package com.spotify.protocol.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaybackSpeed implements Item {

    @SerializedName("playback_speed")
    @JsonProperty("playback_speed")
    public final int playbackSpeed;

    protected PlaybackSpeed() {
        this(0);
    }

    public PlaybackSpeed(int i) {
        this.playbackSpeed = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PlaybackSpeed) && this.playbackSpeed == ((PlaybackSpeed) obj).playbackSpeed;
    }

    public int hashCode() {
        return this.playbackSpeed;
    }

    public String toString() {
        return "PlaybackSpeed{playbackSpeed=" + this.playbackSpeed + '}';
    }

    public enum PodcastPlaybackSpeed {
        PLAYBACK_SPEED_50(50),
        PLAYBACK_SPEED_80(80),
        PLAYBACK_SPEED_100(100),
        PLAYBACK_SPEED_120(120),
        PLAYBACK_SPEED_150(150),
        PLAYBACK_SPEED_200(200),
        PLAYBACK_SPEED_300(300);

        private final int mValue;

        PodcastPlaybackSpeed(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }
}
