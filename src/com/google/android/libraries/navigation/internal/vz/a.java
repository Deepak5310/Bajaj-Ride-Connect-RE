package com.google.android.libraries.navigation.internal.vz;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BuildCompat;
import com.google.android.libraries.navigation.internal.yx.aq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements h {
    public Notification a;
    public Intent b;
    public String c;
    private final Application d;
    private String e;

    public a(Application application) {
        this.d = application;
    }

    @Override // com.google.android.libraries.navigation.internal.vz.h
    public final Notification a() {
        String str;
        if (this.a == null) {
            Application application = this.d;
            if (Build.VERSION.SDK_INT >= 26) {
                if (this.e == null) {
                    NotificationManager notificationManager = (NotificationManager) this.d.getSystemService("notification");
                    NotificationChannel notificationChannelM = ComponentDialog$$ExternalSyntheticApiModelOutline0.m("default", "Default persistent notification", 3);
                    notificationManager.createNotificationChannel(notificationChannelM);
                    this.e = notificationChannelM.getId();
                }
                str = this.e;
            } else {
                str = "";
            }
            NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(application, str).setContentTitle(aq.b(this.c)).setSmallIcon(com.google.android.libraries.navigation.internal.dw.c.v);
            Intent intent = this.b;
            if (intent != null) {
                smallIcon.setContentIntent(PendingIntent.getActivity(this.d, 0, intent, true != BuildCompat.isAtLeastS() ? 0 : 33554432));
            }
            this.a = smallIcon.build();
        }
        return this.a;
    }

    public final void b() {
        this.a = null;
    }
}
