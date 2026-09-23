package com.google.android.libraries.navigation.internal.tm;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.google.android.libraries.navigation.internal.aq.m;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public final g a;
    public i b;
    public final com.google.android.libraries.navigation.internal.wa.g c;
    private final com.google.android.libraries.navigation.internal.tp.d d;
    private final m e;
    private final Service f;
    private final com.google.android.libraries.navigation.internal.wa.a g;

    public b(Intent intent, g gVar, com.google.android.libraries.navigation.internal.wa.a aVar, com.google.android.libraries.navigation.internal.tp.d dVar, com.google.android.libraries.navigation.internal.wa.g gVar2, m mVar, Service service, com.google.android.libraries.navigation.internal.tj.h hVar) {
        this.a = gVar;
        this.g = aVar;
        this.b = gVar.a(hVar);
        this.d = dVar;
        this.c = gVar2;
        this.e = mVar;
        this.f = service;
        ar.q(com.google.android.libraries.navigation.internal.xv.a.b(service, intent, com.google.android.libraries.navigation.internal.xv.a.a | 134217728));
    }

    public final void a(PendingIntent pendingIntent) {
        NotificationCompat.Builder localOnly = new NotificationCompat.Builder(this.f.getApplicationContext()).setSmallIcon(com.google.android.libraries.navigation.internal.dw.c.v).setOngoing(true).setLocalOnly(true);
        if (Build.VERSION.SDK_INT >= 28) {
            localOnly.setCategory("navigation");
        }
        if (pendingIntent != null) {
            localOnly.setContentIntent(pendingIntent);
        }
        localOnly.setPriority(2);
        localOnly.setGroup("navigation_status_notification_group");
        localOnly.setOnlyAlertOnce(true);
        localOnly.setVisibility(1);
        if (Build.VERSION.SDK_INT >= 26) {
            if (!this.d.a(localOnly, 0)) {
                return;
            }
            localOnly.setContentTitle(((a) this.b).a);
            localOnly.setColor(this.g.a());
            localOnly.setColorized(true);
            PendingIntent pendingIntentB = this.g.b(((a) this.b).b);
            if (pendingIntentB != null) {
                localOnly.setContentIntent(pendingIntentB);
            }
        }
        Notification notificationBuild = localOnly.build();
        if (Build.VERSION.SDK_INT < 26) {
            com.google.android.libraries.navigation.internal.tp.i iVar = new com.google.android.libraries.navigation.internal.tp.i(this.f);
            iVar.a(this.g.a());
            iVar.b(((a) this.b).a);
            iVar.c(null);
            notificationBuild.contentView = iVar.a;
            if (!this.e.a().a()) {
                com.google.android.libraries.navigation.internal.tp.g gVar = new com.google.android.libraries.navigation.internal.tp.g(this.f);
                gVar.a(((a) this.b).a);
                gVar.a.setViewVisibility(com.google.android.libraries.navigation.internal.dw.d.m, 8);
                notificationBuild.bigContentView = gVar.a;
            }
        }
        this.c.c(notificationBuild);
    }
}
