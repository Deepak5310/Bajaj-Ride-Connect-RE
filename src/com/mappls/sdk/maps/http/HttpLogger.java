package com.mappls.sdk.maps.http;

import com.mappls.sdk.maps.log.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class HttpLogger {
    private static final String TAG = "Mbgl-HttpRequest";
    public static boolean logEnabled = false;
    public static boolean logRequestUrl = false;

    private HttpLogger() {
    }

    public static void logFailure(int i, String str, String str2) {
        int i2;
        String str3;
        if (i == 1) {
            i2 = 3;
        } else {
            i2 = i == 0 ? 4 : 5;
        }
        if (i == 1) {
            str3 = "temporary";
        } else {
            str3 = i == 0 ? "connection" : "permanent";
        }
        if (!logRequestUrl) {
            str2 = "";
        }
        log(i2, String.format("Request failed due to a %s error: %s %s", str3, str, str2));
    }

    public static void log(int i, String str) {
        if (logEnabled) {
            Logger.log(i, TAG, str);
        }
    }
}
