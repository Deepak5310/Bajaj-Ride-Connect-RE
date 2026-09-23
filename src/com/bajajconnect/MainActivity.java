package com.bajajconnect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.bajajconnect.ble.BleFeatures;
import com.bajajconnect.gMaps.NavigationActivity;
import com.bajajconnect.interfaces.SpotifySession;
import com.bajajconnect.interfaces.SpotifySessionCallback;
import com.bajajconnect.models.SongInfo;
import com.bajajconnect.navigate.HomeActivity;
import com.bajajconnect.navigation.OnActivityResultImplementation;
import com.bajajconnect.variables.GlobalVar;
import com.bajajconnect.wifi.MirroringPolicy;
import com.facebook.react.ReactActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.FirebaseInstallations;
import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;
import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.PlayerContext;
import com.spotify.protocol.types.PlayerState;
import com.spotify.sdk.android.auth.AuthorizationClient;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import com.spotify.sdk.android.auth.AuthorizationResponse;
import com.zoontek.rnbootsplash.RNBootSplash;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class MainActivity extends ReactActivity implements SpotifySession {
    private static final long AUTH_BACKOFF_MS = 60000;
    public static final int AUTH_CODE_REQUEST_CODE = 17;
    public static final int AUTH_TOKEN_REQUEST_CODE = 16;
    public static AssetManager assetManager = null;
    public static SpotifyAppRemote spotifyAppRemote = null;
    public static String spotifyPlaylistUri = "";
    private final String clientId = BuildConfig.SPOTIFY_CLIENT_ID;
    private final String redirectUri = BuildConfig.SPOTIFY_REDIRECT_URI;
    private String currentSpotifySong = "";
    private String MY_PREFS_NAME = "bajajConnectApp";
    private long lastAuthAttemptTs = 0;
    private boolean isSpotifyConnecting = false;
    public OnActivityResultImplementation onActivityResultImplementation = null;
    public ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.bajajconnect.MainActivity$$ExternalSyntheticLambda1
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$0((ActivityResult) obj);
        }
    });

    public static String getSecretKey2(Context context, String str) {
        return PasswordGenerator.getPassword(str + "QEAwHxJ+uymNLicUwdhEYwhFj/5zS/sa");
    }

    @Override // com.facebook.react.ReactActivity
    protected String getMainComponentName() {
        return "BajajConnect";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ActivityResult activityResult) {
        this.onActivityResultImplementation.execute(activityResult);
    }

    @Override // com.facebook.react.ReactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(null);
        setRequestedOrientation(1);
        BleFeatures.getInstance().spotifySessionCallback = new SpotifySessionCallback() { // from class: com.bajajconnect.MainActivity$$ExternalSyntheticLambda3
            @Override // com.bajajconnect.interfaces.SpotifySessionCallback
            public final void onSession(boolean z) {
                this.f$0.onSession(z);
            }
        };
        RNBootSplash.init(this, R.drawable.splashscreen);
        NavApplication.activity = this;
        assetManager = getAssets();
    }

    public boolean isSpotifyInstalled() {
        return SpotifyAppRemote.isSpotifyInstalled(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        FirebaseInstallations.getInstance().getId().addOnCompleteListener(new OnCompleteListener<String>() { // from class: com.bajajconnect.MainActivity.1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<String> task) {
                if (task.isSuccessful()) {
                    Log.d("Firebase", "Installation ID: " + task.getResult());
                    return;
                }
                Log.e("Firebase", "Unable to get Firebase Installation ID", task.getException());
            }
        });
    }

    @Override // com.facebook.react.ReactActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        bringActiveNavigationToFrontIfNeeded();
    }

    @Override // com.facebook.react.ReactActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (bringActiveNavigationToFrontIfNeeded()) {
            return;
        }
        MirroringPolicy.stopMirroringWhenReturningToReactNative(this);
    }

    private boolean bringActiveNavigationToFrontIfNeeded() {
        Intent intent;
        if (!GlobalVar.isNavigationActive) {
            return false;
        }
        try {
            if (GlobalVar.isGoogleNavigation) {
                intent = NavigationActivity.createLaunchIntent(this);
            } else {
                intent = new Intent(this, (Class<?>) HomeActivity.class);
                intent.addFlags(872546304);
            }
            startActivity(intent);
            Log.i("MainActivity", "restored active navigation activity (google=" + GlobalVar.isGoogleNavigation + ")");
            return true;
        } catch (Exception e) {
            Log.w("MainActivity", "bringActiveNavigationToFrontIfNeeded failed", e);
            return false;
        }
    }

    /* JADX INFO: renamed from: onRequestTokenClicked, reason: merged with bridge method [inline-methods] */
    public void lambda$onConnect$1() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastAuthAttemptTs < 60000) {
            Log.w("MainActivity", "onRequestTokenClicked: throttled (backoff 60000ms)");
        } else {
            this.lastAuthAttemptTs = jCurrentTimeMillis;
            AuthorizationClient.openLoginActivity(this, 16, getAuthenticationRequest(AuthorizationResponse.Type.TOKEN));
        }
    }

    private AuthorizationRequest getAuthenticationRequest(AuthorizationResponse.Type type) {
        return new AuthorizationRequest.Builder(BuildConfig.SPOTIFY_CLIENT_ID, type, BuildConfig.SPOTIFY_REDIRECT_URI).setShowDialog(false).setScopes(new String[]{"user-read-email"}).setCampaign("your-campaign-token").build();
    }

    public void connectToASpotifyRemot() {
        if (this.isSpotifyConnecting) {
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.MainActivity.2
            @Override // java.lang.Runnable
            public void run() {
                if (MainActivity.spotifyAppRemote != null && MainActivity.spotifyAppRemote.isConnected()) {
                    MainActivity.this.isSpotifyConnecting = false;
                    return;
                }
                if (System.currentTimeMillis() - MainActivity.this.lastAuthAttemptTs < 60000 && MainActivity.this.lastAuthAttemptTs > 0) {
                    MainActivity.this.isSpotifyConnecting = false;
                    return;
                }
                MainActivity.this.isSpotifyConnecting = true;
                SpotifyAppRemote.connect(MainActivity.this.getApplicationContext(), new ConnectionParams.Builder(BuildConfig.SPOTIFY_CLIENT_ID).setRedirectUri(BuildConfig.SPOTIFY_REDIRECT_URI).showAuthView(false).build(), new AnonymousClass1());
            }

            /* JADX INFO: renamed from: com.bajajconnect.MainActivity$2$1, reason: invalid class name */
            class AnonymousClass1 implements Connector.ConnectionListener {
                AnonymousClass1() {
                }

                @Override // com.spotify.android.appremote.api.Connector.ConnectionListener
                public void onConnected(SpotifyAppRemote spotifyAppRemote) {
                    MainActivity.this.isSpotifyConnecting = false;
                    MainActivity.spotifyAppRemote = spotifyAppRemote;
                    MainActivity.this.setSpotifyState(true);
                    MainActivity.this.onConnect();
                }

                @Override // com.spotify.android.appremote.api.Connector.ConnectionListener
                public void onFailure(Throwable th) {
                    String message;
                    MainActivity.this.isSpotifyConnecting = false;
                    MainActivity.spotifyAppRemote = null;
                    if (th != null && (message = th.getMessage()) != null && message.contains("Explicit user authorization")) {
                        MainActivity.this.runOnUiThread(new Runnable() { // from class: com.bajajconnect.MainActivity$2$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onFailure$0();
                            }
                        });
                        return;
                    }
                    StringBuilder sb = new StringBuilder("SpotifyAppRemote.connect failed: ");
                    sb.append(th == null ? com.google.maps.android.BuildConfig.TRAVIS : th.getMessage());
                    Log.w("MainActivity", sb.toString());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onFailure$0() {
                    MainActivity.this.lambda$onConnect$1();
                }
            }
        }, 500L);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    public void onConnect() {
        SpotifyAppRemote spotifyAppRemote2 = spotifyAppRemote;
        if (spotifyAppRemote2 != null) {
            spotifyAppRemote2.getPlayerApi().subscribeToPlayerContext().setEventCallback(new Subscription.EventCallback() { // from class: com.bajajconnect.MainActivity$$ExternalSyntheticLambda2
                @Override // com.spotify.protocol.client.Subscription.EventCallback
                public final void onEvent(Object obj) {
                    this.f$0.lambda$onConnect$2((PlayerContext) obj);
                }
            });
            spotifyAppRemote.getPlayerApi().subscribeToPlayerState().setEventCallback(new Subscription.EventCallback<PlayerState>() { // from class: com.bajajconnect.MainActivity.3
                @Override // com.spotify.protocol.client.Subscription.EventCallback
                public void onEvent(PlayerState playerState) {
                    if (MainActivity.this.currentSpotifySong.equals(playerState.track.name)) {
                        return;
                    }
                    MainActivity.this.currentSpotifySong = playerState.track.name;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConnect$2(PlayerContext playerContext) {
        if ((spotifyPlaylistUri.equals("") || !playerContext.uri.equals("")) && !spotifyPlaylistUri.equals(playerContext.uri)) {
            spotifyPlaylistUri = playerContext.uri;
            GlobalVar.LAST_SHUFFLE_STATUS = GlobalVar.SHUFFLE_STATUS;
            try {
                spotifyAppRemote.getPlayerApi().setShuffle(false);
            } catch (Exception e) {
                String message = e.getMessage();
                if (message != null && message.contains("Explicit user authorization")) {
                    runOnUiThread(new Runnable() { // from class: com.bajajconnect.MainActivity$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onConnect$1();
                        }
                    });
                } else {
                    e.printStackTrace();
                }
            }
            GlobalVar.spotifyPlaylistUriChange = true;
            playSpotifySongOne();
        }
    }

    @Override // com.bajajconnect.interfaces.SpotifySession
    public void onSession(boolean z) {
        if (z) {
            SpotifyAppRemote spotifyAppRemote2 = spotifyAppRemote;
            if (spotifyAppRemote2 == null || !spotifyAppRemote2.isConnected()) {
                Log.e("Mainactivity", "On spotify session connect");
                connectToASpotifyRemot();
                return;
            }
            return;
        }
        SpotifyAppRemote spotifyAppRemote3 = spotifyAppRemote;
        if (spotifyAppRemote3 != null && spotifyAppRemote3.isConnected()) {
            SpotifyAppRemote.disconnect(spotifyAppRemote);
        }
        spotifyPlaylistUri = "";
    }

    public static boolean playSpotifySongURI(int i) {
        try {
            SpotifyAppRemote spotifyAppRemote2 = spotifyAppRemote;
            boolean z = spotifyAppRemote2 != null && spotifyAppRemote2.isConnected();
            Log.d("MainActivity", "playSpotifySongURI: requestedIndex=" + i + " connected=" + z + " spotifyPlaylistUri=" + spotifyPlaylistUri);
            if (!z) {
                Log.w("MainActivity", "playSpotifySongURI: spotifyAppRemote not connected");
                return false;
            }
            String str = spotifyPlaylistUri;
            if (str == null || str.isEmpty()) {
                Log.w("MainActivity", "playSpotifySongURI: spotifyPlaylistUri is empty, cannot skipToIndex");
                return false;
            }
            try {
                spotifyAppRemote.getPlayerApi().skipToIndex(spotifyPlaylistUri, i);
                return true;
            } catch (Exception e) {
                Log.e("MainActivity", "playSpotifySongURI: skipToIndex failed", e);
                return false;
            }
        } catch (Exception e2) {
            Log.e("MainActivity", "playSpotifySongURI: exception", e2);
            return false;
        }
    }

    public void playSpotifySongOne() {
        if (!GlobalVar.songName.equals("")) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.MainActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    GlobalVar.lastSpotifySong = GlobalVar.songName;
                    GlobalVar.lastSpotifyPlaySate = GlobalVar.playStatus;
                    GlobalVar.spotifySongOneFlag = true;
                    try {
                        BleFeatures.getInstance().mMediaSessionListener.musicCallback.onSongSelected(0);
                    } catch (Exception unused) {
                    }
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.MainActivity.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                BleFeatures.getInstance().mMediaSessionListener.musicCallback.onFetchSpotifyPlaylist();
                            } catch (Exception unused2) {
                            }
                        }
                    }, 1000L);
                }
            }, 1000L);
        } else {
            new Handler((Looper) Objects.requireNonNull(Looper.myLooper())).postDelayed(new Runnable() { // from class: com.bajajconnect.MainActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    MainActivity.this.playSpotifySongOne();
                }
            }, 2000L);
        }
    }

    @Override // com.facebook.react.ReactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (16 == i) {
            try {
                if (AuthorizationClient.getResponse(i2, intent).getAccessToken() != null) {
                    this.lastAuthAttemptTs = 0L;
                }
                setSpotifyState(true);
                connectToASpotifyRemot();
            } catch (Exception unused) {
            }
        }
    }

    public void setSpotifyState(boolean z) {
        SharedPreferences.Editor editorEdit = getApplicationContext().getSharedPreferences(this.MY_PREFS_NAME, 0).edit();
        editorEdit.putBoolean("isFirstTime", z);
        editorEdit.apply();
        editorEdit.commit();
    }

    public boolean getSpotifyState() {
        return getApplicationContext().getSharedPreferences(this.MY_PREFS_NAME, 0).getBoolean("isFirstTime", false);
    }

    public void sendPlaylistToCluster(List<SongInfo> list, int i) {
        BleFeatures.getInstance().sendPlaylistToCluster(list, i);
    }

    public void sendResetPlaylistToCluster() {
        BleFeatures.getInstance().sendResetPlaylistToCluster();
    }
}
