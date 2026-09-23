package com.mappls.sdk.maps.http;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.mappls.sdk.maps.MapStrictMode;
import com.mappls.sdk.maps.Mappls;

/* JADX INFO: loaded from: classes4.dex */
public class HttpIdentifier {
    private HttpIdentifier() {
    }

    public static String getIdentifier() {
        return getIdentifier(Mappls.getApplicationContext());
    }

    private static String getIdentifier(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return String.format("%s/%s (%s)", context.getPackageName(), packageInfo.versionName, Integer.valueOf(packageInfo.versionCode));
        } catch (Exception e) {
            MapStrictMode.strictModeViolation(e);
            return "";
        }
    }
}
