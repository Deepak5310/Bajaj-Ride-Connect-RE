package com.supersami.foregroundservice;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: loaded from: classes4.dex */
class NotificationConfig {
    private static final String KEY_CHANNEL_DESCRIPTION = "com.supersami.foregroundservice.notification_channel_description";
    private static final String KEY_CHANNEL_NAME = "com.supersami.foregroundservice.notification_channel_name";
    private static final String KEY_NOTIFICATION_COLOR = "com.supersami.foregroundservice.notification_color";
    private static Bundle metadata;
    private Context context;

    public NotificationConfig(Context context) {
        this.context = context;
        if (metadata == null) {
            try {
                metadata = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                Log.e("NotificationConfig", "Error reading application meta, falling back to defaults");
                metadata = new Bundle();
            }
        }
    }

    public String getChannelName() {
        try {
            return metadata.getString(KEY_CHANNEL_NAME);
        } catch (Exception unused) {
            Log.w("NotificationConfig", "Unable to find com.supersami.foregroundservice.notification_channel_name in manifest. Falling back to default");
            return BuildConfig.LIBRARY_PACKAGE_NAME;
        }
    }

    public String getChannelDescription() {
        try {
            return metadata.getString(KEY_CHANNEL_DESCRIPTION);
        } catch (Exception unused) {
            Log.w("NotificationConfig", "Unable to find com.supersami.foregroundservice.notification_channel_description in manifest. Falling back to default");
            return BuildConfig.LIBRARY_PACKAGE_NAME;
        }
    }

    public int getNotificationColor() {
        try {
            return ResourcesCompat.getColor(this.context.getResources(), metadata.getInt(KEY_NOTIFICATION_COLOR), null);
        } catch (Exception unused) {
            Log.w("NotificationConfig", "Unable to find com.supersami.foregroundservice.notification_color in manifest. Falling back to default");
            return -1;
        }
    }
}
