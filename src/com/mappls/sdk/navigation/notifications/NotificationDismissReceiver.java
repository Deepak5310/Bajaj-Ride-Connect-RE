package com.mappls.sdk.navigation.notifications;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.NotificationHelper;
import com.mappls.sdk.navigation.apis.NavigationLogger;

/* JADX INFO: loaded from: classes4.dex */
public class NotificationDismissReceiver extends BroadcastReceiver {
    public static PendingIntent a(Context context, a.EnumC0097a enumC0097a) {
        Intent intent = new Intent(context, (Class<?>) NotificationDismissReceiver.class);
        intent.putExtra("com.mmi.navigation.notifications.NotificationType", enumC0097a.name());
        return PendingIntent.getBroadcast(context.getApplicationContext(), 0, intent, Build.VERSION.SDK_INT >= 31 ? 33554432 : 134217728);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        NotificationHelper notificationHelper = NavigationContext.getNavigationContext().getNotificationHelper();
        String string = intent.getExtras().getString("com.mmi.navigation.notifications.NotificationType");
        if (com.mappls.sdk.navigation.util.a.a(string)) {
            return;
        }
        try {
            notificationHelper.onNotificationDismissed((a.EnumC0097a) Enum.valueOf(a.EnumC0097a.class, string));
        } catch (Exception e) {
            NavigationLogger.d(e);
        }
    }
}
