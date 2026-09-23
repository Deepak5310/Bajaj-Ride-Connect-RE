package com.google.android.libraries.navigation.internal.vz;

import android.app.Application;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public final NotificationManager b;
    public h c;
    public int a = 1001;
    public boolean d = true;

    public c(Application application, a aVar) {
        this.c = aVar;
        this.b = (NotificationManager) application.getSystemService("notification");
    }

    public static final void e(Service service) {
        service.stopForeground(true);
    }

    public final void a(String str) {
        if (this.d) {
            a aVar = (a) this.c;
            aVar.b();
            aVar.c = str;
        }
    }

    public final void b(Intent intent) {
        if (this.d) {
            a aVar = (a) this.c;
            aVar.b();
            aVar.b = intent;
        }
    }

    public final void c(Service service) {
        service.startForeground(this.a, this.c.a());
    }

    public final void d() {
        this.b.notify(this.a, this.c.a());
    }
}
