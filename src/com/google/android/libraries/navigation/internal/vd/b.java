package com.google.android.libraries.navigation.internal.vd;

import com.google.android.libraries.navigation.internal.acd.ud;
import com.google.android.libraries.navigation.internal.adu.w;
import com.google.android.libraries.navigation.internal.adu.y;
import com.google.android.libraries.navigation.internal.jy.af;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.zp.t;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b implements com.google.android.libraries.navigation.internal.gg.e {
    final /* synthetic */ y a;
    final /* synthetic */ c b;

    public b(c cVar, y yVar) {
        this.a = yVar;
        this.b = cVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final void a(com.google.android.libraries.navigation.internal.gg.i iVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        int i = c.e;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final /* bridge */ /* synthetic */ void b(com.google.android.libraries.navigation.internal.gg.i iVar, Object obj) {
        com.google.android.libraries.navigation.internal.zp.k kVar;
        ud udVar = (ud) obj;
        this.b.h(w.b, this.a);
        if ((udVar.b & 4) != 0) {
            this.b.d.add(udVar.c);
        }
        c cVar = this.b;
        com.google.android.libraries.navigation.internal.kd.b bVar = new com.google.android.libraries.navigation.internal.kd.b();
        com.google.android.libraries.navigation.internal.zp.n nVar = com.google.android.libraries.navigation.internal.zp.n.CV;
        Objects.requireNonNull(nVar);
        bVar.a = nVar;
        com.google.android.libraries.navigation.internal.jy.a aVar = new com.google.android.libraries.navigation.internal.jy.a();
        aVar.c = (byte) 1;
        com.google.android.libraries.navigation.internal.zp.k kVar2 = com.google.android.libraries.navigation.internal.zp.k.CL;
        Objects.requireNonNull(kVar2);
        aVar.a = kVar2;
        com.google.android.libraries.navigation.internal.zp.q qVar = (com.google.android.libraries.navigation.internal.zp.q) com.google.android.libraries.navigation.internal.zp.r.a.q();
        com.google.android.libraries.navigation.internal.zp.s sVar = (com.google.android.libraries.navigation.internal.zp.s) t.a.q();
        y yVar = this.a;
        if (!sVar.b.H()) {
            sVar.v();
        }
        t tVar = (t) sVar.b;
        tVar.c = yVar.x;
        tVar.b |= 1;
        if (!qVar.b.H()) {
            qVar.v();
        }
        com.google.android.libraries.navigation.internal.zp.r rVar = (com.google.android.libraries.navigation.internal.zp.r) qVar.b;
        t tVar2 = (t) sVar.t();
        tVar2.getClass();
        rVar.d = tVar2;
        rVar.c |= 8192;
        aVar.b = (com.google.android.libraries.navigation.internal.zp.r) qVar.t();
        if (aVar.c != 1 || (kVar = aVar.a) == null) {
            throw new IllegalStateException();
        }
        af afVar = cVar.b;
        bVar.b().h(new com.google.android.libraries.navigation.internal.jy.b(kVar, aVar.b));
        com.google.android.libraries.navigation.internal.kd.i iVarA = bVar.a();
        ar.l(!((com.google.android.libraries.navigation.internal.kd.c) iVarA).a.isEmpty(), "Must have at least one data element.");
        afVar.j(iVarA);
    }
}
