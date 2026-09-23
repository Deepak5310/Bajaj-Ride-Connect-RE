package com.google.android.libraries.geo.navcore.service.base;

import com.google.android.libraries.navigation.internal.aac.as;
import com.google.android.libraries.navigation.internal.add.aw;
import com.google.android.libraries.navigation.internal.add.bv;
import com.google.android.libraries.navigation.internal.add.bw;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class b implements as {
    final /* synthetic */ aw a;
    final /* synthetic */ c b;

    public b(c cVar, aw awVar) {
        this.a = awVar;
        this.b = cVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        bv bvVar = (bv) bw.a.q();
        if (!bvVar.b.H()) {
            bvVar.v();
        }
        aw awVar = this.a;
        c cVar = this.b;
        bw bwVar = (bw) bvVar.b;
        awVar.getClass();
        bwVar.c = awVar;
        bwVar.b |= 1;
        cVar.b.b((bw) bvVar.t());
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
    }
}
