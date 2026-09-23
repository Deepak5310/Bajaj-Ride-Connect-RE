package com.google.android.libraries.navigation.internal.r;

import com.google.android.libraries.navigation.internal.ol.ai;
import com.google.android.libraries.navigation.internal.ol.u;
import com.google.android.libraries.navigation.internal.vu.n;
import com.google.android.libraries.navigation.internal.vu.o;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k implements j {
    final u a;
    final com.google.android.libraries.navigation.internal.ol.g b;
    final com.google.android.libraries.navigation.internal.on.l c;
    final com.google.android.libraries.navigation.internal.on.l d;
    final com.google.android.libraries.navigation.internal.on.l e;
    final /* synthetic */ m f;

    public k(m mVar, u uVar, com.google.android.libraries.navigation.internal.ol.g gVar, com.google.android.libraries.navigation.internal.on.l lVar, com.google.android.libraries.navigation.internal.on.l lVar2, com.google.android.libraries.navigation.internal.on.l lVar3) {
        this.f = mVar;
        this.a = uVar;
        this.b = gVar;
        this.c = lVar;
        this.d = lVar2;
        this.e = lVar3;
    }

    @Override // com.google.android.libraries.navigation.internal.r.j
    public final void a() {
        ai aiVar = ((o) this.f.c).a;
        aiVar.i(this.a);
        aiVar.g(this.a);
        com.google.android.libraries.navigation.internal.ol.g gVar = this.b;
        if (gVar != null) {
            com.google.android.libraries.navigation.internal.ol.a aVar = ((n) this.f.b).a;
            aVar.d(gVar);
            aVar.c(this.b);
        }
        this.c.b();
        this.d.b();
    }
}
