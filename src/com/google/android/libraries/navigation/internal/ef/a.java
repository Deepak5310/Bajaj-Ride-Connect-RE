package com.google.android.libraries.navigation.internal.ef;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import com.google.android.libraries.navigation.internal.ee.e;
import com.google.android.libraries.navigation.internal.ee.p;
import com.google.android.libraries.navigation.internal.yx.am;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    static final Uri a = RingtoneManager.getDefaultUri(2);
    static final AudioAttributes b = new AudioAttributes.Builder().setUsage(5).build();

    public static void a(Application application, p pVar, NotificationManager notificationManager) {
        NotificationChannel notificationChannel;
        NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(pVar.e());
        String string = application.getString(pVar.b());
        String string2 = pVar.c().g() ? application.getString(((Integer) pVar.c().c()).intValue()) : null;
        if (notificationChannel2 != null && (!am.a(notificationChannel2.getName(), string) || !am.a(notificationChannel2.getDescription(), string2))) {
            notificationManager.createNotificationChannel(c(notificationChannel2.getId(), string, string2, notificationChannel2));
            return;
        }
        if (notificationChannel2 == null && pVar.d().g() && (notificationChannel = notificationManager.getNotificationChannel(((e) pVar.d().c()).a)) != null) {
            NotificationChannel notificationChannelC = notificationChannel.getImportance() != ((e) pVar.d().c()).b ? c(pVar.e(), string, string2, notificationChannel) : d(string, string2, pVar);
            notificationManager.deleteNotificationChannel(notificationChannel.getId());
            notificationManager.createNotificationChannel(notificationChannelC);
        } else if (notificationChannel2 == null) {
            notificationManager.createNotificationChannel(d(string, string2, pVar));
        }
    }

    private static NotificationChannel b(String str, String str2, String str3, int i, Uri uri, AudioAttributes audioAttributes, boolean z) {
        NotificationChannel notificationChannelM = ComponentDialog$$ExternalSyntheticApiModelOutline0.m(str, str2, i);
        if (str3 != null) {
            notificationChannelM.setDescription(str3);
        }
        notificationChannelM.setSound(uri, audioAttributes);
        notificationChannelM.setShowBadge(false);
        notificationChannelM.enableVibration(z);
        return notificationChannelM;
    }

    private static NotificationChannel c(String str, String str2, String str3, NotificationChannel notificationChannel) {
        return b(str, str2, str3, notificationChannel.getImportance(), notificationChannel.getSound(), notificationChannel.getAudioAttributes(), notificationChannel.shouldVibrate());
    }

    private static NotificationChannel d(String str, String str2, p pVar) {
        return b(pVar.e(), str, str2, pVar.a(), pVar.f() ? a : null, pVar.f() ? b : null, pVar.g());
    }
}
