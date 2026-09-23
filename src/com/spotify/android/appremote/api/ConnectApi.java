package com.spotify.android.appremote.api;

import com.spotify.protocol.client.CallResult;
import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.Empty;
import com.spotify.protocol.types.VolumeState;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public interface ConnectApi {
    @Nonnull
    CallResult<Empty> connectDecreaseVolume();

    @Nonnull
    CallResult<Empty> connectIncreaseVolume();

    @Nonnull
    CallResult<Empty> connectSetVolume(float f);

    @Nonnull
    CallResult<Empty> connectSwitchToLocalDevice();

    @Nonnull
    Subscription<VolumeState> subscribeToVolumeState();
}
