package com.google.android.libraries.navigation.internal.kh;

import com.google.android.libraries.navigation.internal.yz.lv;
import j$.time.Duration;
import j$.time.Instant;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class t {
    public final com.google.android.libraries.navigation.internal.mj.a a;
    public final com.google.android.libraries.navigation.internal.afo.a b;
    public final i c;
    public final q d = new q();

    public t(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2, i iVar) {
        this.a = aVar;
        this.b = aVar2;
        this.c = iVar;
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, java.util.List] */
    public final void a(com.google.android.libraries.navigation.internal.hb.b bVar) {
        com.google.android.libraries.navigation.internal.nj.i.a();
        com.google.android.libraries.navigation.internal.nk.p pVar = ((com.google.android.libraries.navigation.internal.nk.s) this.b.a()).a().e;
        if (pVar == null) {
            pVar = com.google.android.libraries.navigation.internal.nk.p.a;
        }
        long j = pVar.m;
        com.google.android.libraries.navigation.internal.nk.p pVar2 = ((com.google.android.libraries.navigation.internal.nk.s) this.b.a()).a().e;
        if (pVar2 == null) {
            pVar2 = com.google.android.libraries.navigation.internal.nk.p.a;
        }
        ?? A = bVar.a(Long.valueOf(Duration.between(Instant.ofEpochMilli(Duration.ofMinutes(pVar2.f490n).toMillis()), this.a.f()).toMillis()), Long.valueOf(j));
        lv lvVar = (lv) A;
        int i = lvVar.c;
        for (int i2 = 0; i2 < i; i2++) {
            h hVar = (h) A.get(i2);
            this.d.b(hVar.b(), hVar.a());
        }
        int i3 = lvVar.c;
    }
}
