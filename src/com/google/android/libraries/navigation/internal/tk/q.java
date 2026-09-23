package com.google.android.libraries.navigation.internal.tk;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationManagerCompat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.tk.q");
    public static final int b;
    static final long[] c;
    public final Service d;
    public final com.google.android.libraries.navigation.internal.tn.m e;
    public final NotificationManagerCompat f;
    public final com.google.android.libraries.navigation.internal.uq.l g;
    public final com.google.android.libraries.navigation.internal.aq.m h;
    public final PendingIntent i;
    public final PendingIntent j;
    public final com.google.android.libraries.navigation.internal.eg.a l;
    public final com.google.android.libraries.navigation.internal.eh.d m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f600n;
    public int o;
    public com.google.android.libraries.navigation.internal.ut.d p;
    public final Runnable q = new p(this);
    public final Handler k = new Handler(Looper.getMainLooper());

    static {
        b = Build.VERSION.SDK_INT >= 26 ? 201326592 : 134217728;
        c = new long[]{0};
    }

    public q(com.google.android.libraries.navigation.internal.tn.m mVar, com.google.android.libraries.navigation.internal.uq.l lVar, com.google.android.libraries.navigation.internal.aq.m mVar2, Service service, com.google.android.libraries.navigation.internal.eg.a aVar, com.google.android.libraries.navigation.internal.eh.d dVar, e eVar) {
        this.e = mVar;
        this.g = lVar;
        this.h = mVar2;
        this.d = service;
        this.l = aVar;
        this.m = dVar;
        this.f600n = eVar;
        this.f = NotificationManagerCompat.from(service);
        Intent intentPutExtra = new Intent(service.getApplicationContext(), service.getClass()).putExtra("acceptsuggestion", true);
        int i = b;
        this.i = PendingIntent.getService(service, 1, intentPutExtra, i);
        this.j = PendingIntent.getService(service, 2, new Intent(service.getApplicationContext(), service.getClass()).putExtra("declinesuggestion", true), i);
    }

    public final void a() {
        this.f.cancel(com.google.android.libraries.navigation.internal.adu.m.NAVIGATION_PROMPTS.eU);
        this.p = null;
    }

    public final void b(com.google.android.libraries.navigation.internal.ut.d.b bVar, boolean z) {
        if (bVar == null) {
            return;
        }
        bVar.c();
        a();
        Intent intent = this.f600n.c;
        if (!z || intent == null) {
            return;
        }
        this.d.startActivity(intent);
    }
}
