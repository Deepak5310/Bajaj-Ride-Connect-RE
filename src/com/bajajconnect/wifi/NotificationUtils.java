package com.bajajconnect.wifi;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.util.Pair;
import com.bajajconnect.R;
import it.innove.Peripheral$$ExternalSyntheticApiModelOutline0;

/* JADX INFO: loaded from: classes3.dex */
public class NotificationUtils {
    private static final String NOTIFICATION_CHANNEL_ID = "com.mtsahakis.mediaprojectiondemo.app";
    private static final String NOTIFICATION_CHANNEL_NAME = "com.mtsahakis.mediaprojectiondemo.app";
    public static final int NOTIFICATION_ID = 1337;

    public static Pair<Integer, Notification> getNotification(Context context) {
        createNotificationChannel(context);
        Notification notificationCreateNotification = createNotification(context);
        ((NotificationManager) context.getSystemService("notification")).notify(NOTIFICATION_ID, notificationCreateNotification);
        return new Pair<>(Integer.valueOf(NOTIFICATION_ID), notificationCreateNotification);
    }

    private static void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannelM = Peripheral$$ExternalSyntheticApiModelOutline0.m("com.mtsahakis.mediaprojectiondemo.app", "com.mtsahakis.mediaprojectiondemo.app", 2);
            notificationChannelM.setLockscreenVisibility(0);
            ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(notificationChannelM);
        }
    }

    private static Notification createNotification(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "com.mtsahakis.mediaprojectiondemo.app");
        builder.setSmallIcon(R.drawable.ic_camera);
        builder.setContentTitle(context.getString(R.string.app_name));
        builder.setContentText(context.getString(R.string.recording));
        builder.setOngoing(true);
        builder.setCategory(NotificationCompat.CATEGORY_SERVICE);
        builder.setPriority(-1);
        builder.setShowWhen(true);
        return builder.build();
    }
}
