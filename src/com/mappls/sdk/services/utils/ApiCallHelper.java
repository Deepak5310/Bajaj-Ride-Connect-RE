package com.mappls.sdk.services.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.provider.Settings;
import android.util.Base64;
import com.google.gson.Gson;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class ApiCallHelper {
    private static final String ONLY_PRINTABLE_CHARS = "[^\\p{ASCII}]";

    private ApiCallHelper() {
    }

    public static String getHeaderUserAgent() {
        Context sDKContext = MapplsUtils.getSDKContext();
        UserAgent userAgent = new UserAgent();
        userAgent.setAndroidVersion(Build.VERSION.RELEASE);
        userAgent.setAndroidVersionAPI(Integer.valueOf(Build.VERSION.SDK_INT));
        userAgent.setDeviceBrand(Build.BRAND);
        userAgent.setModel(Build.MODEL);
        userAgent.setMapsSDKVersion(MapplsUtils.getText());
        if (sDKContext != null) {
            String string = sDKContext.getApplicationInfo().loadLabel(sDKContext.getPackageManager()).toString();
            userAgent.setDeviceId(Settings.Secure.getString(sDKContext.getContentResolver(), "android_id"));
            userAgent.setAppName(string);
            try {
                PackageInfo packageInfo = sDKContext.getPackageManager().getPackageInfo(sDKContext.getPackageName(), 0);
                userAgent.setAppPackageName(packageInfo.packageName);
                userAgent.setAppVersion(packageInfo.versionName);
                userAgent.setVersionCode(Integer.valueOf(packageInfo.versionCode));
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return String.format(new Gson().toJson(userAgent), "UTF-8");
    }

    public static String getAnalyticsHeader(Location location, boolean z) {
        Context sDKContext = MapplsUtils.getSDKContext();
        StringBuilder sb = new StringBuilder(Settings.Secure.getString(sDKContext.getContentResolver(), "android_id") + "|");
        if (location != null) {
            sb.append(location.getLatitude());
        }
        sb.append("|");
        if (location != null) {
            sb.append(location.getLongitude());
        }
        sb.append("|");
        if (location != null && location.hasBearing()) {
            sb.append(location.getBearing());
        }
        sb.append("|");
        if (location != null && location.hasSpeed()) {
            sb.append(location.getSpeed());
        }
        sb.append("|");
        sb.append(System.currentTimeMillis());
        sb.append("|");
        sb.append(z);
        sb.append("|");
        try {
            PackageInfo packageInfo = sDKContext.getPackageManager().getPackageInfo(sDKContext.getPackageName(), 0);
            sb.append(packageInfo.packageName);
            sb.append("|");
            sb.append(packageInfo.versionName);
            sb.append("|");
        } catch (PackageManager.NameNotFoundException unused) {
            sb.append("||");
        }
        sb.append("5.2.9|5.2.9|");
        sb.append(MapplsUtils.getText());
        sb.append("|ANDROID|");
        sb.append(Build.VERSION.SDK_INT);
        sb.append("|");
        sb.append(Build.MANUFACTURER);
        sb.append("|");
        sb.append(Build.MODEL);
        return Base64.encodeToString(sb.toString().getBytes(), 2);
    }

    public static String getHeaderUserAgent(String str) {
        Context sDKContext = MapplsUtils.getSDKContext();
        if (sDKContext == null) {
            String property = System.getProperty("os.name");
            String property2 = System.getProperty("os.version");
            String property3 = System.getProperty("os.arch");
            if (MapplsUtils.isEmpty(property) || MapplsUtils.isEmpty(property2) || MapplsUtils.isEmpty(property3)) {
                return Constants.HEADER_USER_AGENT;
            }
            return getHeaderUserAgent(str, property, property2, property3);
        }
        return getUserAgent(sDKContext);
    }

    public static String getUserAgent(Context context) {
        UserAgent userAgent = new UserAgent();
        userAgent.setAndroidVersion(Build.VERSION.RELEASE);
        userAgent.setAndroidVersionAPI(Integer.valueOf(Build.VERSION.SDK_INT));
        userAgent.setDeviceBrand(Build.BRAND);
        userAgent.setModel(Build.MODEL);
        userAgent.setMapsSDKVersion(MapplsUtils.getText());
        if (context != null) {
            userAgent.setAppName(context.getApplicationInfo().loadLabel(context.getPackageManager()).toString());
            userAgent.setDeviceId(Settings.Secure.getString(context.getContentResolver(), "android_id"));
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                userAgent.setAppPackageName(packageInfo.packageName);
                userAgent.setAppVersion(packageInfo.versionName);
                userAgent.setVersionCode(Integer.valueOf(packageInfo.versionCode));
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return new Gson().toJson(userAgent);
    }

    public static String getHeaderUserAgent(String str, String str2, String str3, String str4) {
        String str5 = String.format(Locale.US, "%s %s/%s (%s)", Constants.HEADER_USER_AGENT, str2.replaceAll(ONLY_PRINTABLE_CHARS, ""), str3.replaceAll(ONLY_PRINTABLE_CHARS, ""), str4.replaceAll(ONLY_PRINTABLE_CHARS, ""));
        return MapplsUtils.isEmpty(str) ? str5 : String.format(Locale.US, "%s %s", str, str5);
    }
}
