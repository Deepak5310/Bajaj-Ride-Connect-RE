package com.mappls.sdk.navigation.notifications;

import androidx.core.app.NotificationCompat;

/* JADX INFO: loaded from: classes4.dex */
public interface INotificationManagerCallback {
    NotificationCompat.Builder buildNotification(boolean z);

    Integer getNavigationNotificationId();
}
