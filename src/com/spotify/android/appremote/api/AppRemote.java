package com.spotify.android.appremote.api;

import com.spotify.protocol.client.CallResult;
import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.Item;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface AppRemote {
    @Nonnull
    <T extends Item, S extends Item> CallResult<T> call(@Nullable String str, @Nullable S s, @Nullable Class<T> cls);

    @Nonnull
    ConnectApi getConnectApi();

    @Nonnull
    ContentApi getContentApi();

    @Nonnull
    ImagesApi getImagesApi();

    @Nonnull
    PlayerApi getPlayerApi();

    @Nonnull
    UserApi getUserApi();

    boolean isConnected();

    @Nonnull
    <T extends Item> Subscription<T> subscribe(@Nullable String str, @Nullable Class<T> cls);
}
