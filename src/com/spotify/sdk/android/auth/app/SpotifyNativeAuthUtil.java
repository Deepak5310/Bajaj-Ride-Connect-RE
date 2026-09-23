package com.spotify.sdk.android.auth.app;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import com.spotify.sdk.android.auth.IntentExtras;
import com.spotify.sdk.android.auth.LoginActivity;

/* JADX INFO: loaded from: classes4.dex */
public class SpotifyNativeAuthUtil {
    private static final int PROTOCOL_VERSION = 1;
    private static final String SPOTIFY_AUTH_ACTIVITY_ACTION = "com.spotify.sso.action.START_AUTH_FLOW";
    private static final String SPOTIFY_PACKAGE_NAME = "com.spotify.music";
    private static final String[] SPOTIFY_PACKAGE_SUFFIXES = {".debug", ".canary", ".partners", ""};
    private static final String[] SPOTIFY_SIGNATURE_HASH = {"25a9b2d2745c098361edaa3b87936dc29a28e7f1", "80abdd17dcc4cb3a33815d354355bf87c9378624", "88df4d670ed5e01fc7b3eff13b63258628ff5a00", "d834ae340d1e854c5f4092722f9788216d9221e5", "1cbedd9e7345f64649bad2b493a20d9eea955352", "4b3d76a2de89033ea830f476a1f815692938e33b"};
    private final Activity mContextActivity;
    private final AuthorizationRequest mRequest;
    private final Sha1HashUtil mSha1HashUtil;

    public SpotifyNativeAuthUtil(Activity activity, AuthorizationRequest authorizationRequest, Sha1HashUtil sha1HashUtil) {
        this.mContextActivity = activity;
        this.mRequest = authorizationRequest;
        this.mSha1HashUtil = sha1HashUtil;
    }

    public boolean startAuthActivity() {
        Intent intentCreateAuthActivityIntent = createAuthActivityIntent(this.mContextActivity, this.mSha1HashUtil);
        if (intentCreateAuthActivityIntent == null) {
            return false;
        }
        intentCreateAuthActivityIntent.putExtra(IntentExtras.KEY_VERSION, 1);
        intentCreateAuthActivityIntent.putExtra(IntentExtras.KEY_CLIENT_ID, this.mRequest.getClientId());
        intentCreateAuthActivityIntent.putExtra(IntentExtras.KEY_REDIRECT_URI, this.mRequest.getRedirectUri());
        intentCreateAuthActivityIntent.putExtra(IntentExtras.KEY_RESPONSE_TYPE, this.mRequest.getResponseType());
        intentCreateAuthActivityIntent.putExtra(IntentExtras.KEY_REQUESTED_SCOPES, this.mRequest.getScopes());
        intentCreateAuthActivityIntent.putExtra("STATE", this.mRequest.getState());
        try {
            this.mContextActivity.startActivityForResult(intentCreateAuthActivityIntent, LoginActivity.REQUEST_CODE);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public static Intent createAuthActivityIntent(Context context) {
        return createAuthActivityIntent(context, new Sha1HashUtilImpl());
    }

    static Intent createAuthActivityIntent(Context context, Sha1HashUtil sha1HashUtil) {
        Intent intentTryResolveActivity = null;
        for (String str : SPOTIFY_PACKAGE_SUFFIXES) {
            intentTryResolveActivity = tryResolveActivity(context, "com.spotify.music" + str, sha1HashUtil);
            if (intentTryResolveActivity != null) {
                break;
            }
        }
        return intentTryResolveActivity;
    }

    public static boolean isSpotifyInstalled(Context context) {
        return isSpotifyInstalled(context, new Sha1HashUtilImpl());
    }

    static boolean isSpotifyInstalled(Context context, Sha1HashUtil sha1HashUtil) {
        return createAuthActivityIntent(context, sha1HashUtil) != null;
    }

    private static Intent tryResolveActivity(Context context, String str, Sha1HashUtil sha1HashUtil) {
        Intent intent = new Intent(SPOTIFY_AUTH_ACTIVITY_ACTION);
        intent.setPackage(str);
        ComponentName componentNameResolveActivity = intent.resolveActivity(context.getPackageManager());
        if (componentNameResolveActivity != null && validateSignature(context, componentNameResolveActivity.getPackageName(), sha1HashUtil)) {
            return intent;
        }
        return null;
    }

    private static boolean validateSignature(Context context, String str, Sha1HashUtil sha1HashUtil) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 134217728);
                if (packageInfo.signingInfo == null) {
                    return false;
                }
                if (packageInfo.signingInfo.hasMultipleSigners()) {
                    return validateSignatures(sha1HashUtil, packageInfo.signingInfo.getApkContentsSigners());
                }
                return validateSignatures(sha1HashUtil, packageInfo.signingInfo.getSigningCertificateHistory());
            }
            return validateSignatures(sha1HashUtil, context.getPackageManager().getPackageInfo(str, 64).signatures);
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private static boolean validateSignatures(Sha1HashUtil sha1HashUtil, Signature[] signatureArr) {
        if (signatureArr == null || signatureArr.length == 0) {
            return false;
        }
        for (Signature signature : signatureArr) {
            String strSha1Hash = sha1HashUtil.sha1Hash(signature.toCharsString());
            for (String str : SPOTIFY_SIGNATURE_HASH) {
                if (str.equalsIgnoreCase(strSha1Hash)) {
                }
            }
            return false;
        }
        return true;
    }

    public void stopAuthActivity() {
        this.mContextActivity.finishActivity(LoginActivity.REQUEST_CODE);
    }
}
