package com.spotify.android.appremote.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;

/* JADX INFO: loaded from: classes4.dex */
final class SpotifyServiceBinder {
    private static final String BIND_PROTOCOL_SERVICE = "com.spotify.mobile.appprotocol.action.BIND_PROTOCOL_SERVICE";
    private static final String LEGACY_SPOTIFY_SERVICE_ACTION = "com.spotify.mobile.appprotocol.action.START_APP_PROTOCOL_SERVICE";

    private SpotifyServiceBinder() {
    }

    static Boolean bindService(Context context, ServiceConnection serviceConnection, String str) {
        try {
            if (bindToService(new Intent(BIND_PROTOCOL_SERVICE).setPackage(str), context, serviceConnection).booleanValue()) {
                return true;
            }
        } catch (Exception unused) {
        }
        return bindLegacyService(context, str, serviceConnection);
    }

    private static Boolean bindToService(Intent intent, Context context, ServiceConnection serviceConnection) {
        return Boolean.valueOf(context.getApplicationContext().bindService(intent, serviceConnection, 65));
    }

    private static Boolean bindLegacyService(Context context, String str, ServiceConnection serviceConnection) {
        Intent intent = new Intent(LEGACY_SPOTIFY_SERVICE_ACTION).setPackage(str);
        startServiceForBuildVersion(context, intent);
        return bindToService(intent, context, serviceConnection);
    }

    private static void startServiceForBuildVersion(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.getApplicationContext().startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }
}
