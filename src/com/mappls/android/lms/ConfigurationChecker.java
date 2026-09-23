package com.mappls.android.lms;

import android.content.Context;
import android.content.pm.PackageManager;
import com.mappls.android.util.MPLog;

/* JADX INFO: loaded from: classes6.dex */
class ConfigurationChecker {
    public static String LOGTAG = "MapplsAnalyticsAPI.ConfigurationChecker";

    ConfigurationChecker() {
    }

    public static boolean checkBasicConfiguration(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        if (packageManager == null || packageName == null) {
            MPLog.w(LOGTAG, "Can't check configuration when using a Context with null packageManager or packageName");
            return false;
        }
        if (packageManager.checkPermission("android.permission.INTERNET", packageName) == 0) {
            return true;
        }
        MPLog.w(LOGTAG, "Package does not have permission android.permission.INTERNET - Mappls Analytics will not work at all!");
        MPLog.i(LOGTAG, "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"android.permission.INTERNET\" />");
        return false;
    }
}
