package com.google.android.libraries.navigation.internal.to;

import android.app.PendingIntent;
import android.app.Service;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.google.android.libraries.navigation.internal.dw.h;
import com.google.android.libraries.navigation.internal.tp.i;
import com.google.android.libraries.navigation.internal.wa.e;
import com.google.android.libraries.navigation.internal.wa.g;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public final g a;
    private final com.google.android.libraries.navigation.internal.tp.d b;
    private final Service c;
    private final e d;

    public a(e eVar, com.google.android.libraries.navigation.internal.tp.d dVar, g gVar, Service service) {
        this.d = eVar;
        this.b = dVar;
        this.a = gVar;
        this.c = service;
    }

    public final void a(PendingIntent pendingIntent) {
        NotificationCompat.Builder localOnly = new NotificationCompat.Builder(this.c.getApplicationContext()).setSmallIcon(com.google.android.libraries.navigation.internal.dw.c.v).setOngoing(true).setLocalOnly(true);
        if (Build.VERSION.SDK_INT >= 28) {
            localOnly.setCategory("navigation");
        }
        if (pendingIntent != null) {
            localOnly.setContentIntent(pendingIntent);
        }
        localOnly.setPriority(2).setGroup("navigation_status_notification_group").setOnlyAlertOnce(true).setVisibility(1);
        if (Build.VERSION.SDK_INT < 26) {
            i iVar = new i(this.c);
            iVar.a(this.d.a());
            iVar.b(this.c.getString(h.W));
            localOnly.setContent(iVar.a);
        } else if (!this.b.a(localOnly, 0)) {
            return;
        } else {
            localOnly.setContentTitle(this.c.getString(h.W)).setColor(this.d.a()).setColorized(true);
        }
        this.a.c(localOnly.build());
    }
}
