package com.spotify.android.appremote.api;

import android.content.Context;
import com.spotify.android.appremote.api.error.AuthenticationFailedException;
import com.spotify.android.appremote.api.error.CouldNotFindSpotifyApp;
import com.spotify.android.appremote.api.error.NotLoggedInException;
import com.spotify.android.appremote.api.error.OfflineModeException;
import com.spotify.android.appremote.api.error.SpotifyConnectionTerminatedException;
import com.spotify.android.appremote.api.error.SpotifyRemoteServiceException;
import com.spotify.android.appremote.api.error.UnsupportedFeatureVersionException;
import com.spotify.android.appremote.api.error.UserNotAuthorizedException;
import com.spotify.android.appremote.internal.ConnectApiImpl;
import com.spotify.android.appremote.internal.ContentApiImpl;
import com.spotify.android.appremote.internal.ImagesApiImpl;
import com.spotify.android.appremote.internal.PlayerApiImpl;
import com.spotify.android.appremote.internal.SdkRemoteClientConnector;
import com.spotify.android.appremote.internal.SdkRemoteClientConnectorFactory;
import com.spotify.android.appremote.internal.SpotifyAppRemoteIsConnectedRule;
import com.spotify.android.appremote.internal.SpotifyLocator;
import com.spotify.android.appremote.internal.StrictRemoteClient;
import com.spotify.android.appremote.internal.UserApiImpl;
import com.spotify.protocol.AppProtocol;
import com.spotify.protocol.client.Coding;
import com.spotify.protocol.client.Debug;
import com.spotify.protocol.client.ErrorCallback;
import com.spotify.protocol.client.OnConnectionTerminatedListener;
import com.spotify.protocol.client.RemoteClient;
import com.spotify.protocol.client.RemoteClientConnector;
import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.client.error.RemoteClientException;
import com.spotify.protocol.error.SpotifyAppRemoteException;
import com.spotify.protocol.types.UserStatus;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class LocalConnector implements Connector {
    private final SdkRemoteClientConnectorFactory mSdkRemoteClientConnectorFactory;
    private final SpotifyLocator mSpotifyLocator;

    public LocalConnector(SpotifyLocator spotifyLocator, SdkRemoteClientConnectorFactory sdkRemoteClientConnectorFactory) {
        this.mSpotifyLocator = spotifyLocator;
        this.mSdkRemoteClientConnectorFactory = sdkRemoteClientConnectorFactory;
    }

    @Override // com.spotify.android.appremote.api.Connector
    public void connect(@Nullable Context context, @Nullable ConnectionParams connectionParams, @Nullable Connector.ConnectionListener connectionListener) {
        if (!this.mSpotifyLocator.isSpotifyInstalled(context)) {
            connectionListener.onFailure(new CouldNotFindSpotifyApp());
            return;
        }
        try {
            SdkRemoteClientConnector sdkRemoteClientConnector = (SdkRemoteClientConnector) Coding.checkNotNull(this.mSdkRemoteClientConnectorFactory.newConnector(context, connectionParams, this.mSpotifyLocator.getSpotifyBestPackageName(context)));
            sdkRemoteClientConnector.connect(new AnonymousClass1(sdkRemoteClientConnector, connectionListener));
        } catch (CouldNotFindSpotifyApp e) {
            connectionListener.onFailure(e);
        }
    }

    /* JADX INFO: renamed from: com.spotify.android.appremote.api.LocalConnector$1, reason: invalid class name */
    class AnonymousClass1 implements RemoteClientConnector.ConnectionCallback {
        final /* synthetic */ Connector.ConnectionListener val$connectionListener;
        final /* synthetic */ SdkRemoteClientConnector val$remoteClientConnector;

        AnonymousClass1(SdkRemoteClientConnector sdkRemoteClientConnector, Connector.ConnectionListener connectionListener) {
            this.val$remoteClientConnector = sdkRemoteClientConnector;
            this.val$connectionListener = connectionListener;
        }

        @Override // com.spotify.protocol.client.RemoteClientConnector.ConnectionCallback
        public void onConnected(RemoteClient remoteClient) {
            StrictRemoteClient strictRemoteClient = new StrictRemoteClient(remoteClient);
            final SpotifyAppRemote spotifyAppRemote = new SpotifyAppRemote(strictRemoteClient, new PlayerApiImpl(strictRemoteClient), new ImagesApiImpl(strictRemoteClient), new UserApiImpl(strictRemoteClient), new ContentApiImpl(strictRemoteClient), new ConnectApiImpl(strictRemoteClient), this.val$remoteClientConnector);
            spotifyAppRemote.setConnected(true);
            strictRemoteClient.addRule(new SpotifyAppRemoteIsConnectedRule(spotifyAppRemote));
            SdkRemoteClientConnector sdkRemoteClientConnector = this.val$remoteClientConnector;
            final Connector.ConnectionListener connectionListener = this.val$connectionListener;
            sdkRemoteClientConnector.setConnectionTerminatedListener(new OnConnectionTerminatedListener() { // from class: com.spotify.android.appremote.api.LocalConnector$1$$ExternalSyntheticLambda0
                @Override // com.spotify.protocol.client.OnConnectionTerminatedListener
                public final void onConnectionTerminated() {
                    LocalConnector.AnonymousClass1.lambda$onConnected$0(spotifyAppRemote, connectionListener);
                }
            });
            Subscription<UserStatus> subscriptionSubscribeToUserStatus = spotifyAppRemote.getUserApi().subscribeToUserStatus();
            final Connector.ConnectionListener connectionListener2 = this.val$connectionListener;
            subscriptionSubscribeToUserStatus.setEventCallback(new Subscription.EventCallback() { // from class: com.spotify.android.appremote.api.LocalConnector$1$$ExternalSyntheticLambda1
                @Override // com.spotify.protocol.client.Subscription.EventCallback
                public final void onEvent(Object obj) {
                    LocalConnector.AnonymousClass1.lambda$onConnected$1(connectionListener2, spotifyAppRemote, (UserStatus) obj);
                }
            });
            final Connector.ConnectionListener connectionListener3 = this.val$connectionListener;
            Objects.requireNonNull(connectionListener3);
            subscriptionSubscribeToUserStatus.setErrorCallback(new ErrorCallback() { // from class: com.spotify.android.appremote.api.LocalConnector$1$$ExternalSyntheticLambda2
                @Override // com.spotify.protocol.client.ErrorCallback
                public final void onError(Throwable th) {
                    connectionListener3.onFailure(th);
                }
            });
        }

        static /* synthetic */ void lambda$onConnected$0(SpotifyAppRemote spotifyAppRemote, Connector.ConnectionListener connectionListener) {
            spotifyAppRemote.disconnectRemoteClient();
            connectionListener.onFailure(new SpotifyConnectionTerminatedException());
        }

        static /* synthetic */ void lambda$onConnected$1(Connector.ConnectionListener connectionListener, SpotifyAppRemote spotifyAppRemote, UserStatus userStatus) {
            Debug.d("LoggedIn:%s", Boolean.valueOf(userStatus.isLoggedIn()));
            if (userStatus.isLoggedIn()) {
                connectionListener.onConnected(spotifyAppRemote);
            } else {
                connectionListener.onFailure(new NotLoggedInException("The user must go to the Spotify and log-in", new Throwable("The user must go to the Spotify and log-in")));
            }
        }

        @Override // com.spotify.protocol.client.RemoteClientConnector.ConnectionCallback
        public void onConnectionFailed(Throwable th) {
            Debug.d(th, "Connection failed.", new Object[0]);
            this.val$remoteClientConnector.disconnect();
            this.val$connectionListener.onFailure(LocalConnector.asAppRemoteException(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Throwable asAppRemoteException(Throwable th) {
        String reasonUri = th instanceof RemoteClientException ? ((RemoteClientException) th).getReasonUri() : null;
        String message = th.getMessage();
        if (th instanceof SpotifyRemoteServiceException) {
            return th;
        }
        if (AppProtocol.ErrorUri.ERROR_AUTHENTICATION_FAILED.equals(reasonUri)) {
            return new AuthenticationFailedException(message, th);
        }
        if (AppProtocol.ErrorUri.ERROR_FEATURE_VERSION_MISMATCH.equals(reasonUri)) {
            return new UnsupportedFeatureVersionException(message, th);
        }
        if (AppProtocol.ErrorUri.ERROR_OFFLINE_MODE_ACTIVE.equals(reasonUri)) {
            return new OfflineModeException(message, th);
        }
        if (AppProtocol.ErrorUri.ERROR_USER_NOT_AUTHORIZED.equals(reasonUri)) {
            return new UserNotAuthorizedException(message, th);
        }
        if (AppProtocol.ErrorUri.ERROR_NOT_LOGGED_IN.equals(reasonUri)) {
            return new NotLoggedInException(message, th);
        }
        return new SpotifyAppRemoteException(message, th);
    }

    @Override // com.spotify.android.appremote.api.Connector
    public void disconnect(SpotifyAppRemote spotifyAppRemote) {
        if (spotifyAppRemote != null) {
            spotifyAppRemote.disconnectRemoteClient();
        }
    }
}
