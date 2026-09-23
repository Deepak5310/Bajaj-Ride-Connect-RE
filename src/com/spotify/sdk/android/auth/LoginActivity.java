package com.spotify.sdk.android.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;

/* JADX INFO: loaded from: classes4.dex */
public class LoginActivity extends Activity implements AuthorizationClient.AuthorizationClientListener {
    static final String EXTRA_AUTH_REQUEST = "EXTRA_AUTH_REQUEST";
    static final String EXTRA_AUTH_RESPONSE = "EXTRA_AUTH_RESPONSE";
    static final String EXTRA_ERROR = "ERROR";
    static final String EXTRA_REPLY = "REPLY";
    private static final String NO_CALLER_ERROR = "Can't use LoginActivity with a null caller. Possible reasons: calling activity has a singleInstance mode or LoginActivity is in a singleInstance/singleTask mode";
    private static final String NO_REQUEST_ERROR = "No authorization request";
    public static final int REQUEST_CODE = 1138;
    public static final String REQUEST_KEY = "request";
    public static final String RESPONSE_KEY = "response";
    static final String RESPONSE_TYPE_CODE = "code";
    static final String RESPONSE_TYPE_TOKEN = "token";
    private static final int RESULT_ERROR = -2;
    private static final String TAG = "com.spotify.sdk.android.auth.LoginActivity";
    private final AuthorizationClient mAuthorizationClient = new AuthorizationClient(this);

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mAuthorizationClient.complete(AuthorizationResponse.fromUri(intent.getData()));
    }

    public static Intent getAuthIntent(Activity activity, AuthorizationRequest authorizationRequest) {
        if (activity == null || authorizationRequest == null) {
            throw new IllegalArgumentException("Context activity or request can't be null");
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(REQUEST_KEY, authorizationRequest);
        Intent intent = new Intent(activity, (Class<?>) LoginActivity.class);
        intent.putExtra(EXTRA_AUTH_REQUEST, bundle);
        return intent;
    }

    static AuthorizationResponse getResponseFromIntent(Intent intent) {
        Bundle bundleExtra;
        if (intent == null || (bundleExtra = intent.getBundleExtra(EXTRA_AUTH_RESPONSE)) == null) {
            return null;
        }
        return (AuthorizationResponse) bundleExtra.getParcelable(RESPONSE_KEY);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.com_spotify_sdk_login_activity);
        AuthorizationRequest requestFromIntent = getRequestFromIntent();
        this.mAuthorizationClient.setOnCompleteListener(this);
        if (getCallingActivity() == null) {
            Log.e(TAG, NO_CALLER_ERROR);
            finish();
        } else if (requestFromIntent == null) {
            Log.e(TAG, NO_REQUEST_ERROR);
            setResult(0);
            finish();
        } else if (bundle == null) {
            Log.d(TAG, String.format("Spotify Auth starting with the request [%s]", requestFromIntent.toUri().toString()));
            this.mAuthorizationClient.authorize(requestFromIntent);
        }
    }

    private AuthorizationRequest getRequestFromIntent() {
        Bundle bundleExtra = getIntent().getBundleExtra(EXTRA_AUTH_REQUEST);
        if (bundleExtra == null) {
            return null;
        }
        return (AuthorizationRequest) bundleExtra.getParcelable(REQUEST_KEY);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mAuthorizationClient.notifyInCaseUserCanceledAuth();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.mAuthorizationClient.cancel();
        this.mAuthorizationClient.setOnCompleteListener(null);
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        super.onActivityResult(i, i2, intent);
        if (i == 1138) {
            AuthorizationResponse.Builder builder = new AuthorizationResponse.Builder();
            if (i2 == -2) {
                builder.setType(AuthorizationResponse.Type.ERROR);
                if (intent == null) {
                    stringExtra = "Invalid message format";
                } else {
                    stringExtra = intent.getStringExtra(EXTRA_ERROR);
                }
                if (stringExtra == null) {
                    stringExtra = "Unknown error";
                }
                builder.setError(stringExtra);
            } else if (i2 == -1) {
                Bundle bundle = (Bundle) intent.getParcelableExtra(EXTRA_REPLY);
                if (bundle == null) {
                    builder.setType(AuthorizationResponse.Type.ERROR);
                    builder.setError("Missing response data");
                } else {
                    String string = bundle.getString(IntentExtras.KEY_RESPONSE_TYPE, EnvironmentCompat.MEDIA_UNKNOWN);
                    Log.d(TAG, "Response: " + string);
                    builder.setState(bundle.getString("STATE", null));
                    string.hashCode();
                    if (string.equals("code")) {
                        String string2 = bundle.getString(IntentExtras.KEY_AUTHORIZATION_CODE);
                        builder.setType(AuthorizationResponse.Type.CODE);
                        builder.setCode(string2);
                    } else if (string.equals("token")) {
                        String string3 = bundle.getString(IntentExtras.KEY_ACCESS_TOKEN);
                        int i3 = bundle.getInt(IntentExtras.KEY_EXPIRES_IN);
                        builder.setType(AuthorizationResponse.Type.TOKEN);
                        builder.setAccessToken(string3);
                        builder.setExpiresIn(i3);
                    } else {
                        builder.setType(AuthorizationResponse.Type.UNKNOWN);
                    }
                }
            } else {
                builder.setType(AuthorizationResponse.Type.EMPTY);
            }
            this.mAuthorizationClient.setOnCompleteListener(this);
            this.mAuthorizationClient.complete(builder.build());
        }
    }

    @Override // com.spotify.sdk.android.auth.AuthorizationClient.AuthorizationClientListener
    public void onClientComplete(AuthorizationResponse authorizationResponse) {
        Intent intent = new Intent();
        Log.i(TAG, String.format("Spotify auth completing. The response is in EXTRA with key '%s'", RESPONSE_KEY));
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESPONSE_KEY, authorizationResponse);
        intent.putExtra(EXTRA_AUTH_RESPONSE, bundle);
        setResult(-1, intent);
        finish();
    }

    @Override // com.spotify.sdk.android.auth.AuthorizationClient.AuthorizationClientListener
    public void onClientCancelled() {
        Log.w(TAG, "Spotify Auth cancelled due to LoginActivity being finished");
        setResult(0);
    }
}
