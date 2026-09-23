package com.google.android.libraries.navigation.internal.wa;

import android.app.Notification;
import android.app.Service;
import com.google.android.libraries.navigation.internal.zb.j;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    private static final j a = j.e("com.google.android.libraries.navigation.internal.wa.g");
    private final Service b;
    private final com.google.android.libraries.navigation.internal.vz.c c;
    private final com.google.android.libraries.navigation.internal.vz.a d;
    private boolean e = false;

    public g(Service service, com.google.android.libraries.navigation.internal.vz.c cVar, com.google.android.libraries.navigation.internal.vz.a aVar) {
        this.b = service;
        this.c = cVar;
        this.d = aVar;
    }

    public final void a() {
        com.google.android.libraries.navigation.internal.vz.c cVar = this.c;
        cVar.b.cancel(cVar.a);
    }

    public final void b() {
        com.google.android.libraries.navigation.internal.vz.c.e(this.b);
        this.d.b();
        this.e = false;
    }

    public final void c(Notification notification) {
        this.d.a = notification;
        if (!this.e) {
            try {
                this.c.c(this.b);
                this.e = true;
            } catch (RuntimeException e) {
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 1945)).p("Call failed potentially due to Android's foreground services restriction");
                return;
            }
        }
        this.c.d();
    }
}
