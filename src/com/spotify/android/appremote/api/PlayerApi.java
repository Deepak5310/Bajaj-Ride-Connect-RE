package com.spotify.android.appremote.api;

import androidx.core.app.NotificationCompat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.spotify.protocol.client.CallResult;
import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.CrossfadeState;
import com.spotify.protocol.types.Empty;
import com.spotify.protocol.types.PlaybackSpeed;
import com.spotify.protocol.types.PlayerContext;
import com.spotify.protocol.types.PlayerState;

/* JADX INFO: loaded from: classes4.dex */
public interface PlayerApi {
    CallResult<CrossfadeState> getCrossfadeState();

    CallResult<PlayerState> getPlayerState();

    CallResult<Empty> pause();

    CallResult<Empty> play(String str);

    CallResult<Empty> play(String str, StreamType streamType);

    CallResult<Empty> queue(String str);

    CallResult<Empty> resume();

    CallResult<Empty> seekTo(long j);

    CallResult<Empty> seekToRelativePosition(long j);

    CallResult<Empty> setPodcastPlaybackSpeed(PlaybackSpeed.PodcastPlaybackSpeed podcastPlaybackSpeed);

    CallResult<Empty> setRepeat(int i);

    CallResult<Empty> setShuffle(boolean z);

    CallResult<Empty> skipNext();

    CallResult<Empty> skipPrevious();

    CallResult<Empty> skipToIndex(String str, int i);

    Subscription<PlayerContext> subscribeToPlayerContext();

    Subscription<PlayerState> subscribeToPlayerState();

    CallResult<Empty> toggleRepeat();

    CallResult<Empty> toggleShuffle();

    public enum StreamType {
        ALARM(NotificationCompat.CATEGORY_ALARM);


        @SerializedName("type")
        @JsonProperty("type")
        public final String name;

        StreamType(String str) {
            this.name = str;
        }
    }
}
