package com.google.android.libraries.navigation.internal.qu;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g implements Runnable {
    final /* synthetic */ com.google.android.libraries.geo.mapcore.internal.model.cd a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.qv.i b;
    final /* synthetic */ h c;

    public g(h hVar, com.google.android.libraries.geo.mapcore.internal.model.cd cdVar, com.google.android.libraries.navigation.internal.qv.i iVar) {
        this.a = cdVar;
        this.b = iVar;
        this.c = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k.b.name();
        final k kVar = this.c.c;
        ch chVar = kVar.f;
        final com.google.android.libraries.geo.mapcore.internal.model.cd cdVar = this.a;
        chVar.a(cdVar);
        cg cgVar = (cg) kVar.f.a.get(cdVar);
        long j = cgVar == null ? 0L : cgVar.c;
        if (j <= 0) {
            return;
        }
        final com.google.android.libraries.navigation.internal.qv.i iVar = this.b;
        kVar.j.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.d
            @Override // java.lang.Runnable
            public final void run() {
                k kVar2 = kVar;
                kVar2.j("ApiTileStore.scheduleFailureRetryOnBackground", kVar2.i, new i(kVar2, cdVar, iVar));
            }
        }, j + 50, TimeUnit.MILLISECONDS);
    }
}
