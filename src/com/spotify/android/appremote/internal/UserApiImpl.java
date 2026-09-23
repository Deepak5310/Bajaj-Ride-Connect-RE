package com.spotify.android.appremote.internal;

import com.spotify.android.appremote.api.UserApi;
import com.spotify.protocol.AppProtocol;
import com.spotify.protocol.client.CallResult;
import com.spotify.protocol.client.RemoteClient;
import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.Capabilities;
import com.spotify.protocol.types.Empty;
import com.spotify.protocol.types.Identifier;
import com.spotify.protocol.types.LibraryState;
import com.spotify.protocol.types.UserStatus;

/* JADX INFO: loaded from: classes4.dex */
public class UserApiImpl implements UserApi {
    private final RemoteClient mRemoteClient;

    public UserApiImpl(RemoteClient remoteClient) {
        this.mRemoteClient = remoteClient;
    }

    @Override // com.spotify.android.appremote.api.UserApi
    public CallResult<Capabilities> getCapabilities() {
        return this.mRemoteClient.call(AppProtocol.CallUri.CAPABILITIES, Capabilities.class);
    }

    @Override // com.spotify.android.appremote.api.UserApi
    public Subscription<Capabilities> subscribeToCapabilities() {
        return this.mRemoteClient.subscribe(AppProtocol.Topic.CAPABILITIES, Capabilities.class);
    }

    @Override // com.spotify.android.appremote.api.UserApi
    public Subscription<UserStatus> subscribeToUserStatus() {
        return this.mRemoteClient.subscribe(AppProtocol.Topic.STATUS, UserStatus.class);
    }

    @Override // com.spotify.android.appremote.api.UserApi
    public CallResult<Empty> addToLibrary(String str) {
        return this.mRemoteClient.call(AppProtocol.CallUri.SET_SAVED, new LibraryState(str, true, false), Empty.class);
    }

    @Override // com.spotify.android.appremote.api.UserApi
    public CallResult<Empty> removeFromLibrary(String str) {
        return this.mRemoteClient.call(AppProtocol.CallUri.SET_SAVED, new LibraryState(str, false, false), Empty.class);
    }

    @Override // com.spotify.android.appremote.api.UserApi
    public CallResult<LibraryState> getLibraryState(String str) {
        return this.mRemoteClient.call(AppProtocol.CallUri.GET_SAVED, new Identifier(str), LibraryState.class);
    }
}
