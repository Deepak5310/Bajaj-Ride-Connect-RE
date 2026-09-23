package com.google.android.libraries.navigation.internal.vz;

import android.app.Application;
import android.app.NotificationManager;
import androidx.core.os.BuildCompat;
import com.google.android.libraries.navigation.internal.ee.n;
import com.google.android.libraries.navigation.internal.ee.p;
import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements com.google.android.libraries.navigation.internal.eg.a {
    private static final p b;
    private final Application c;
    private final com.google.android.libraries.navigation.internal.en.a d;
    private final com.google.android.libraries.navigation.internal.afo.a e;

    static {
        n nVarH = p.h(2);
        nVarH.b("OtherChannel");
        nVarH.d(com.google.android.libraries.navigation.internal.em.a.T);
        b = nVarH.a();
    }

    public f(Application application, com.google.android.libraries.navigation.internal.en.a aVar) {
        this.c = application;
        this.d = aVar;
        this.e = com.google.android.libraries.navigation.internal.ih.a.b(new e(application));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.eg.a
    public final void a() {
        if (BuildCompat.isAtLeastO()) {
            NotificationManager notificationManager = (NotificationManager) this.e.a();
            ev evVar = ((com.google.android.libraries.navigation.internal.ee.b) this.d.a()).a;
            int size = evVar.size();
            for (int i = 0; i < size; i++) {
                com.google.android.libraries.navigation.internal.ef.a.a(this.c, (p) evVar.get(i), notificationManager);
            }
            if (notificationManager.getNotificationChannel(com.google.android.libraries.navigation.internal.ee.k.a) != null) {
                notificationManager.deleteNotificationChannel(com.google.android.libraries.navigation.internal.ee.k.a);
            }
            com.google.android.libraries.navigation.internal.ef.a.a(this.c, b, notificationManager);
        }
    }
}
