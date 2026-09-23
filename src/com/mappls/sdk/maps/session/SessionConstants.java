package com.mappls.sdk.maps.session;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;

/* JADX INFO: loaded from: classes4.dex */
public class SessionConstants {
    public static final String AUTO_SESSION = "auto";
    public static final String GLOBAL_SESSION = "global";

    public static String deviceFingerPrint(Context context) {
        return Build.BRAND + ':' + Build.MODEL + ':' + Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String getOSName() {
        return Build.VERSION_CODES.class.getFields()[Build.VERSION.SDK_INT - 1].getName();
    }
}
