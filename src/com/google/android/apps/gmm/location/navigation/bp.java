package com.google.android.apps.gmm.location.navigation;

import j$.time.Duration;
import j$.time.Instant;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class bp implements com.google.android.libraries.navigation.internal.cw.i {
    private final com.google.android.libraries.navigation.internal.fz.d a;

    public bp(com.google.android.libraries.navigation.internal.fz.d dVar) {
        this.a = dVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cw.i
    public final void a(com.google.android.libraries.navigation.internal.db.q qVar) {
        com.google.android.libraries.navigation.internal.db.r rVarA = qVar.a();
        int i = this.a.F().g;
        long j = this.a.F().h;
        double d = rVarA.b;
        double d2 = rVarA.c;
        Duration durationOfMinutes = Duration.ofMinutes(j);
        com.google.android.libraries.navigation.internal.zk.c cVar = new com.google.android.libraries.navigation.internal.zk.c(com.google.android.libraries.navigation.internal.zk.d.h(com.google.android.libraries.navigation.internal.zk.e.d(d, d2)).i(Math.min(12, i)));
        com.google.android.libraries.navigation.internal.zk.e eVar = new com.google.android.libraries.navigation.internal.zk.e(com.google.android.libraries.navigation.internal.zk.f.b(cVar.d.k()));
        com.google.android.libraries.navigation.internal.aef.a aVar = new com.google.android.libraries.navigation.internal.aef.a(eVar.a(), eVar.b(), Math.max(cVar.a(0).a(cVar.a(2)), cVar.a(1).a(cVar.a(3))) * 6367000.0d * 0.5d);
        double d3 = aVar.a;
        double d4 = aVar.b;
        double d5 = aVar.c;
        boolean z = rVarA.z();
        Instant instantQ = Instant.EPOCH;
        if (z) {
            instantQ = rVarA.q();
        }
        qVar.q = new com.google.android.libraries.navigation.internal.db.ab(d3, d4, (float) d5, rVarA, durationOfMinutes, z, instantQ);
    }
}
