package com.spotify.android.appremote.internal;

import android.content.Context;
import android.os.AsyncTask;
import com.spotify.android.appremote.BuildConfig;
import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.protocol.client.AppProtocolCommunicator;
import com.spotify.protocol.client.Coding;
import com.spotify.protocol.client.ConnectionDetails;
import com.spotify.protocol.client.OnConnectionTerminatedListener;
import com.spotify.protocol.client.RemoteClientConnector;
import com.spotify.protocol.client.RemoteWampClient;
import com.spotify.protocol.client.Result;
import com.spotify.protocol.client.ResultUtils;
import com.spotify.protocol.client.WampCallsOrchestrator;
import com.spotify.protocol.mappers.JsonMapper;
import com.spotify.protocol.types.WelcomeDetails;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class SdkRemoteClientConnector implements RemoteClientConnector {
    public static final String APP_ID_AUTH = "appid";
    public static final String CATEGORY = "app";
    public static final String EXTRA_REDIRECT_URI = "redirect_uri";
    public static final String EXTRA_SCOPES = "scopes";
    public static final String EXTRA_SHOW_AUTH_VIEW = "show_auth_view";
    public static final String REMOTE_CONTROL_SCOPE = "app-remote-control";
    private ConnectionTask mConnectionTask;
    private final Context mContext;
    private final ConnectionParams mParams;
    private RemoteService mRemoteService;
    private RemoteWampClient mRemoteWampClient;
    private final String mSpotifyPackagename;

    @Nonnull
    public static SdkRemoteClientConnector create(@Nonnull Context context, @Nonnull ConnectionParams connectionParams, @Nonnull String str) {
        Coding.checkNotNull(context);
        Coding.checkNotNull(connectionParams);
        Coding.checkNotNull(str);
        return new SdkRemoteClientConnector(context, connectionParams, str);
    }

    private SdkRemoteClientConnector(@Nonnull Context context, @Nonnull ConnectionParams connectionParams, @Nonnull String str) {
        this.mContext = context;
        this.mParams = connectionParams;
        this.mSpotifyPackagename = str;
    }

    @Override // com.spotify.protocol.client.RemoteClientConnector
    public void connect(@Nonnull RemoteClientConnector.ConnectionCallback connectionCallback) {
        ConnectionTask connectionTask = new ConnectionTask(this.mParams, connectionCallback);
        this.mConnectionTask = connectionTask;
        connectionTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Override // com.spotify.protocol.client.RemoteClientConnector
    public void disconnect() {
        RemoteService remoteService = this.mRemoteService;
        if (remoteService != null) {
            remoteService.disconnect();
        }
    }

    public void setConnectionTerminatedListener(@Nonnull OnConnectionTerminatedListener onConnectionTerminatedListener) {
        this.mRemoteWampClient.setOnConnectionTerminatedListener(onConnectionTerminatedListener);
        this.mRemoteService.setOnConnectionTerminatedListener(onConnectionTerminatedListener);
    }

    @Nonnull
    public ConnectionParams getParams() {
        return this.mParams;
    }

    @Nonnull
    public String getSpotifyPackagename() {
        return this.mSpotifyPackagename;
    }

    private static final class ConnectionTask extends AsyncTask<Void, Void, Result<WelcomeDetails>> {
        private final RemoteClientConnector.ConnectionCallback mConnectionCallback;
        private final ConnectionDetails mConnectionDetails;
        private final JsonMapper mJsonMapper;
        private final SdkRemoteClientConnector mOuter;

        private ConnectionTask(SdkRemoteClientConnector sdkRemoteClientConnector, ConnectionParams connectionParams, RemoteClientConnector.ConnectionCallback connectionCallback) {
            this.mOuter = sdkRemoteClientConnector;
            this.mConnectionCallback = connectionCallback;
            this.mJsonMapper = connectionParams.getJsonMapper();
            ConnectionDetails.Builder requiredFeatures = new ConnectionDetails.Builder(connectionParams.getClientId()).setName(sdkRemoteClientConnector.mContext.getPackageName()).setCategory(SdkRemoteClientConnector.CATEGORY).setVersion(BuildConfig.APP_REMOTE_VERSION_NAME).setRequiredFeatures(connectionParams.getRequiredFeatures());
            if (connectionParams.getAuthMethod() == ConnectionParams.AuthMethod.APP_ID) {
                HashMap map = new HashMap(5);
                map.put("redirect_uri", connectionParams.getRedirectUri());
                map.put(SdkRemoteClientConnector.EXTRA_SHOW_AUTH_VIEW, String.valueOf(connectionParams.shouldShowAuthView()));
                map.put(SdkRemoteClientConnector.EXTRA_SCOPES, SdkRemoteClientConnector.REMOTE_CONTROL_SCOPE);
                requiredFeatures.setAuthMethods(new String[]{SdkRemoteClientConnector.APP_ID_AUTH});
                requiredFeatures.setAuthId(connectionParams.getClientId());
                requiredFeatures.setExtras(map);
            }
            this.mConnectionDetails = requiredFeatures.build();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            SdkRemoteClientConnector sdkRemoteClientConnector = this.mOuter;
            sdkRemoteClientConnector.mRemoteService = new RemoteServiceIo(sdkRemoteClientConnector.mSpotifyPackagename, this.mOuter.mContext);
            AppProtocolCommunicator appProtocolCommunicator = new AppProtocolCommunicator(this.mConnectionDetails, this.mJsonMapper, this.mOuter.mRemoteService);
            this.mOuter.mRemoteWampClient = new RemoteWampClient(appProtocolCommunicator, new WampCallsOrchestrator());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Result<WelcomeDetails> doInBackground(Void... voidArr) {
            Result<Void> resultAwait = this.mOuter.mRemoteService.connect().await(30L, TimeUnit.SECONDS);
            if (resultAwait.isSuccessful()) {
                return this.mOuter.mRemoteWampClient.hello(WelcomeDetails.class).await(1L, TimeUnit.HOURS);
            }
            return ResultUtils.createErrorResult(resultAwait.getError());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Result<WelcomeDetails> result) {
            if (result.isSuccessful()) {
                this.mConnectionCallback.onConnected(this.mOuter.mRemoteWampClient);
            } else {
                this.mConnectionCallback.onConnectionFailed(result.getError());
            }
            this.mOuter.mConnectionTask = null;
        }
    }
}
