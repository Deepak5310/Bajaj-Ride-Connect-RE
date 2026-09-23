package com.spotify.android.appremote.internal;

import com.spotify.android.appremote.api.PlayerApi;
import com.spotify.protocol.AppProtocol;
import com.spotify.protocol.client.CallResult;
import com.spotify.protocol.client.RemoteClient;
import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.CrossfadeState;
import com.spotify.protocol.types.Empty;
import com.spotify.protocol.types.PlaybackPosition;
import com.spotify.protocol.types.PlaybackSpeed;
import com.spotify.protocol.types.PlayerContext;
import com.spotify.protocol.types.PlayerState;
import com.spotify.protocol.types.Repeat;
import com.spotify.protocol.types.Shuffle;
import com.spotify.protocol.types.Uri;
import com.spotify.protocol.types.UriWithOptionExtras;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class PlayerApiImpl implements PlayerApi {
    private static final int PLAYBACK_PAUSED = 0;
    private static final int PLAYBACK_PLAYING = 1;
    private final RemoteClient mClient;

    public PlayerApiImpl(RemoteClient remoteClient) {
        this.mClient = remoteClient;
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<Empty> play(@Nullable String str) {
        return this.mClient.call(AppProtocol.CallUri.PLAY_URI, new Uri(ensureNonNull(str)), Empty.class);
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<Empty> play(@Nullable String str, PlayerApi.StreamType streamType) {
        Validate.checkNotNull(streamType);
        return this.mClient.call(AppProtocol.CallUri.PLAY_URI_WITH_OPTION_EXTRAS, new UriWithOptionExtras(ensureNonNull(str), new String[]{streamType.name}), Empty.class);
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<Empty> queue(@Nullable String str) {
        return this.mClient.call(AppProtocol.CallUri.PLAY_QUEUE, new Uri(ensureNonNull(str)), Empty.class);
    }

    @Nonnull
    private static String ensureNonNull(@Nullable String str) {
        return str != null ? str : "";
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<Empty> resume() {
        return setPlaybackSpeed(new PlaybackSpeed(1));
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<Empty> pause() {
        return setPlaybackSpeed(new PlaybackSpeed(0));
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<Empty> setPodcastPlaybackSpeed(PlaybackSpeed.PodcastPlaybackSpeed podcastPlaybackSpeed) {
        return setPlaybackSpeed(new PlaybackSpeed(podcastPlaybackSpeed.getValue()));
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<Empty> skipNext() {
        return this.mClient.call(AppProtocol.CallUri.SKIP_NEXT, Empty.class);
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<Empty> skipPrevious() {
        return this.mClient.call(AppProtocol.CallUri.SKIP_PREVIOUS, Empty.class);
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<Empty> skipToIndex(@Nullable String str, int i) {
        return this.mClient.call(AppProtocol.CallUri.SKIP_TO_INDEX, new UriWithOptionExtras(ensureNonNull(str), new String[]{String.valueOf(i)}), Empty.class);
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<Empty> setShuffle(boolean z) {
        return this.mClient.call(AppProtocol.CallUri.SET_SHUFFLE, new Shuffle(z), Empty.class);
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<Empty> toggleShuffle() {
        return this.mClient.call(AppProtocol.CallUri.TOGGLE_SHUFFLE, Empty.class);
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<Empty> setRepeat(int i) {
        return this.mClient.call(AppProtocol.CallUri.SET_REPEAT, new Repeat(i), Empty.class);
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<Empty> toggleRepeat() {
        return this.mClient.call(AppProtocol.CallUri.TOGGLE_REPEAT, Empty.class);
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<Empty> seekTo(long j) {
        return this.mClient.call(AppProtocol.CallUri.SET_PLAYBACK_POSITION, new PlaybackPosition(j), Empty.class);
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<Empty> seekToRelativePosition(long j) {
        return this.mClient.call(AppProtocol.CallUri.SEEK_TO_RELATIVE_POSITION, new PlaybackPosition(j), Empty.class);
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<PlayerState> getPlayerState() {
        return this.mClient.call(AppProtocol.CallUri.GET_PLAYER_STATE, PlayerState.class);
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public Subscription<PlayerState> subscribeToPlayerState() {
        return this.mClient.subscribe(AppProtocol.Topic.PLAYER_STATE, PlayerState.class);
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public Subscription<PlayerContext> subscribeToPlayerContext() {
        return this.mClient.subscribe(AppProtocol.Topic.PLAYER_CONTEXT, PlayerContext.class);
    }

    @Override // com.spotify.android.appremote.api.PlayerApi
    public CallResult<CrossfadeState> getCrossfadeState() {
        return this.mClient.call(AppProtocol.CallUri.GET_CROSSFADE, CrossfadeState.class);
    }

    private CallResult<Empty> setPlaybackSpeed(PlaybackSpeed playbackSpeed) {
        return this.mClient.call(AppProtocol.CallUri.SET_PLAYBACK_SPEED, playbackSpeed, Empty.class);
    }
}
