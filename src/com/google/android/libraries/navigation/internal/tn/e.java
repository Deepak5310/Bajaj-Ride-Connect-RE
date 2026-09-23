package com.google.android.libraries.navigation.internal.tn;

import android.app.PendingIntent;
import android.app.Service;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.nc.ap;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements com.google.android.libraries.navigation.internal.tp.f {
    public static final ap a = com.google.android.libraries.navigation.internal.nc.a.g(48);
    public final Service b;
    public final g c;
    public final com.google.android.libraries.navigation.internal.tp.a d;
    public final l e;
    public final bn f;
    public final com.google.android.libraries.navigation.internal.hn.r g;
    public d h = null;

    public e(Service service, com.google.android.libraries.navigation.internal.tp.a aVar, g gVar, Executor executor, com.google.android.libraries.navigation.internal.hn.r rVar) {
        this.b = service;
        this.c = gVar;
        this.d = aVar;
        ar.a(executor instanceof com.google.android.libraries.navigation.internal.hx.b);
        this.f = ((com.google.android.libraries.navigation.internal.hx.b) executor).o("GuidedNavNotificationContent updater");
        this.g = rVar;
        this.e = new l();
    }

    @Override // com.google.android.libraries.navigation.internal.tp.f
    public final void a() {
        d dVar = this.h;
        if (dVar != null) {
            dVar.b.b();
            this.h = null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.tp.f
    public final void b() {
        this.h = null;
    }

    @Override // com.google.android.libraries.navigation.internal.tp.f
    public final void c(boolean z, long j, boolean z2, PendingIntent pendingIntent) {
        d dVar = this.h;
        if (dVar != null) {
            dVar.a(z, j, z2, pendingIntent);
        }
    }
}
