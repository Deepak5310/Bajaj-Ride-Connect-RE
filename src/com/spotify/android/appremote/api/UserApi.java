package com.spotify.android.appremote.api;

import com.spotify.protocol.client.CallResult;
import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.Capabilities;
import com.spotify.protocol.types.Empty;
import com.spotify.protocol.types.LibraryState;
import com.spotify.protocol.types.UserStatus;

/* JADX INFO: loaded from: classes4.dex */
public interface UserApi {
    CallResult<Empty> addToLibrary(String str);

    CallResult<Capabilities> getCapabilities();

    CallResult<LibraryState> getLibraryState(String str);

    CallResult<Empty> removeFromLibrary(String str);

    Subscription<Capabilities> subscribeToCapabilities();

    Subscription<UserStatus> subscribeToUserStatus();
}
