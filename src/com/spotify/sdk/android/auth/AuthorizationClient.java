package com.spotify.sdk.android.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.spotify.sdk.android.auth.app.SpotifyAuthHandler;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class AuthorizationClient {
    static final String ANDROID_SDK = "android-sdk";
    static final String DEFAULT_CAMPAIGN = "android-sdk";
    static final String MARKET_PATH = "details";
    static final String MARKET_SCHEME = "market";
    static final String MARKET_VIEW_PATH = "market://";
    static final String PLAY_STORE_AUTHORITY = "play.google.com";
    static final String PLAY_STORE_PATH = "store/apps/details";
    static final String PLAY_STORE_SCHEME = "https";
    static final String SPOTIFY_ID = "com.spotify.music";
    static final String SPOTIFY_SDK = "spotify-sdk";
    private static final String TAG = "Spotify Auth Client";
    private AuthorizationClientListener mAuthorizationClientListener;
    private List<AuthorizationHandler> mAuthorizationHandlers;
    private boolean mAuthorizationPending;
    private AuthorizationHandler mCurrentHandler;
    private final Activity mLoginActivity;

    interface AuthorizationClientListener {
        void onClientCancelled();

        void onClientComplete(AuthorizationResponse authorizationResponse);
    }

    static final class PlayStoreParams {
        public static final String ID = "id";
        public static final String REFERRER = "referrer";
        public static final String UTM_CAMPAIGN = "utm_campaign";
        public static final String UTM_MEDIUM = "utm_medium";
        public static final String UTM_SOURCE = "utm_source";

        PlayStoreParams() {
        }
    }

    public static void openLoginInBrowser(Activity activity, AuthorizationRequest authorizationRequest) {
        activity.startActivity(new Intent("android.intent.action.VIEW", authorizationRequest.toUri()));
    }

    public static Intent createLoginActivityIntent(Activity activity, AuthorizationRequest authorizationRequest) {
        Intent authIntent = LoginActivity.getAuthIntent(activity, authorizationRequest);
        authIntent.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        return authIntent;
    }

    public static void openLoginActivity(Activity activity, int i, AuthorizationRequest authorizationRequest) {
        activity.startActivityForResult(createLoginActivityIntent(activity, authorizationRequest), i);
    }

    public static void stopLoginActivity(Activity activity, int i) {
        activity.finishActivity(i);
    }

    public static AuthorizationResponse getResponse(int i, Intent intent) {
        if (i == -1 && LoginActivity.getResponseFromIntent(intent) != null) {
            return LoginActivity.getResponseFromIntent(intent);
        }
        return new AuthorizationResponse.Builder().setType(AuthorizationResponse.Type.EMPTY).build();
    }

    public static void openDownloadSpotifyActivity(Activity activity) {
        openDownloadSpotifyActivity(activity, "android-sdk");
    }

    public static void openDownloadSpotifyActivity(Activity activity, String str) {
        Uri.Builder builder = new Uri.Builder();
        if (isAvailable(activity, new Intent("android.intent.action.VIEW", Uri.parse(MARKET_VIEW_PATH)))) {
            builder.scheme(MARKET_SCHEME).appendPath(MARKET_PATH);
        } else {
            builder.scheme("https").authority(PLAY_STORE_AUTHORITY).appendEncodedPath(PLAY_STORE_PATH);
        }
        builder.appendQueryParameter("id", "com.spotify.music");
        Uri.Builder builder2 = new Uri.Builder();
        builder2.appendQueryParameter("utm_source", SPOTIFY_SDK).appendQueryParameter("utm_medium", "android-sdk");
        if (TextUtils.isEmpty(str)) {
            builder2.appendQueryParameter("utm_campaign", "android-sdk");
        } else {
            builder2.appendQueryParameter("utm_campaign", str);
        }
        builder.appendQueryParameter(PlayStoreParams.REFERRER, builder2.build().getEncodedQuery());
        activity.startActivity(new Intent("android.intent.action.VIEW", builder.build()));
    }

    public static boolean isAvailable(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public AuthorizationClient(Activity activity) {
        ArrayList arrayList = new ArrayList();
        this.mAuthorizationHandlers = arrayList;
        this.mLoginActivity = activity;
        arrayList.add(new SpotifyAuthHandler());
        this.mAuthorizationHandlers.add(new FallbackHandlerProvider().provideFallback());
    }

    void setOnCompleteListener(AuthorizationClientListener authorizationClientListener) {
        this.mAuthorizationClientListener = authorizationClientListener;
    }

    void authorize(AuthorizationRequest authorizationRequest) {
        if (this.mAuthorizationPending) {
            return;
        }
        this.mAuthorizationPending = true;
        for (AuthorizationHandler authorizationHandler : this.mAuthorizationHandlers) {
            if (tryAuthorizationHandler(authorizationHandler, authorizationRequest)) {
                this.mCurrentHandler = authorizationHandler;
                return;
            }
        }
    }

    void cancel() {
        if (this.mAuthorizationPending) {
            this.mAuthorizationPending = false;
            closeAuthorizationHandler(this.mCurrentHandler);
            AuthorizationClientListener authorizationClientListener = this.mAuthorizationClientListener;
            if (authorizationClientListener != null) {
                authorizationClientListener.onClientCancelled();
                this.mAuthorizationClientListener = null;
            }
        }
    }

    void complete(AuthorizationResponse authorizationResponse) {
        sendComplete(this.mCurrentHandler, authorizationResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendComplete(AuthorizationHandler authorizationHandler, AuthorizationResponse authorizationResponse) {
        this.mAuthorizationPending = false;
        closeAuthorizationHandler(authorizationHandler);
        AuthorizationClientListener authorizationClientListener = this.mAuthorizationClientListener;
        if (authorizationClientListener != null) {
            authorizationClientListener.onClientComplete(authorizationResponse);
            this.mAuthorizationClientListener = null;
        } else {
            Log.w(TAG, "Can't deliver the Spotify Auth response. The listener is null");
        }
    }

    private boolean tryAuthorizationHandler(final AuthorizationHandler authorizationHandler, AuthorizationRequest authorizationRequest) {
        authorizationHandler.setOnCompleteListener(new AuthorizationHandler.OnCompleteListener() { // from class: com.spotify.sdk.android.auth.AuthorizationClient.1
            @Override // com.spotify.sdk.android.auth.AuthorizationHandler.OnCompleteListener
            public void onComplete(AuthorizationResponse authorizationResponse) {
                Log.i(AuthorizationClient.TAG, String.format("Spotify auth response:%s", authorizationResponse.getType().name()));
                AuthorizationClient.this.sendComplete(authorizationHandler, authorizationResponse);
            }

            @Override // com.spotify.sdk.android.auth.AuthorizationHandler.OnCompleteListener
            public void onCancel() {
                Log.i(AuthorizationClient.TAG, "Spotify auth response: User cancelled");
                AuthorizationClient.this.sendComplete(authorizationHandler, new AuthorizationResponse.Builder().setType(AuthorizationResponse.Type.EMPTY).build());
            }

            @Override // com.spotify.sdk.android.auth.AuthorizationHandler.OnCompleteListener
            public void onError(Throwable th) {
                Log.e(AuthorizationClient.TAG, "Spotify auth Error", th);
                AuthorizationClient.this.sendComplete(authorizationHandler, new AuthorizationResponse.Builder().setType(AuthorizationResponse.Type.ERROR).setError(th.getMessage()).build());
            }
        });
        if (authorizationHandler.start(this.mLoginActivity, authorizationRequest)) {
            return true;
        }
        closeAuthorizationHandler(authorizationHandler);
        return false;
    }

    private void closeAuthorizationHandler(AuthorizationHandler authorizationHandler) {
        if (authorizationHandler != null) {
            authorizationHandler.setOnCompleteListener(null);
            authorizationHandler.stop();
        }
    }

    void notifyInCaseUserCanceledAuth() {
        AuthorizationHandler authorizationHandler = this.mCurrentHandler;
        if (authorizationHandler == null || !authorizationHandler.isAuthInProgress()) {
            return;
        }
        Log.i(TAG, "Spotify auth response: User cancelled");
        complete(new AuthorizationResponse.Builder().setType(AuthorizationResponse.Type.EMPTY).build());
    }
}
