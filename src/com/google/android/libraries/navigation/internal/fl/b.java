package com.google.android.libraries.navigation.internal.fl;

import com.google.android.libraries.geo.mapcore.internal.model.cc;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.geo.mapcore.internal.model.ch;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.di;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.br;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b implements com.google.android.libraries.navigation.internal.qv.d {
    private static final com.google.android.libraries.navigation.internal.zb.j c = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.fl.b");
    public final com.google.android.apps.gmm.offline.routing.m a;
    public final int b;
    private volatile com.google.android.libraries.navigation.internal.adj.b d;

    public b(com.google.android.apps.gmm.offline.routing.m mVar, int i) {
        this.a = mVar;
        this.b = i;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final com.google.android.libraries.navigation.internal.dm.s a(cd cdVar) {
        if (!h(cdVar)) {
            return null;
        }
        com.google.android.libraries.navigation.internal.dm.r rVar = (com.google.android.libraries.navigation.internal.dm.r) com.google.android.libraries.navigation.internal.dm.s.a.q();
        com.google.android.libraries.navigation.internal.dm.o oVarA = ch.a(d.H, cg.s, cdVar, "", "");
        if (!rVar.b.H()) {
            rVar.v();
        }
        com.google.android.libraries.navigation.internal.dm.s sVar = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
        oVarA.getClass();
        sVar.c = oVarA;
        sVar.b |= 1;
        return (com.google.android.libraries.navigation.internal.dm.s) rVar.t();
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public cc b(cd cdVar) {
        throw null;
    }

    protected final Object c(br brVar) {
        return this.a.e(brVar);
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final void d() {
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final void e(cd cdVar, cc ccVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final void f(cd cdVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final void g(com.google.android.libraries.navigation.internal.dm.s sVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final boolean h(cd cdVar) {
        int i = com.google.android.apps.gmm.offline.routing.m.c - cdVar.a;
        ar.b(i >= 0, Integer.valueOf(i));
        int i2 = cdVar.b << i;
        int i3 = cdVar.c << i;
        com.google.android.libraries.navigation.internal.adj.g gVar = (com.google.android.libraries.navigation.internal.adj.g) com.google.android.libraries.navigation.internal.adj.h.a.q();
        if (!gVar.b.H()) {
            gVar.v();
        }
        int i4 = this.b;
        com.google.android.libraries.navigation.internal.adj.h hVar = (com.google.android.libraries.navigation.internal.adj.h) gVar.b;
        hVar.b |= 1;
        hVar.d = i4;
        com.google.android.libraries.navigation.internal.adj.k kVar = (com.google.android.libraries.navigation.internal.adj.k) com.google.android.libraries.navigation.internal.adj.l.a.q();
        com.google.android.libraries.navigation.internal.adj.e eVar = (com.google.android.libraries.navigation.internal.adj.e) com.google.android.libraries.navigation.internal.adj.f.a.q();
        if (!eVar.b.H()) {
            eVar.v();
        }
        com.google.android.libraries.navigation.internal.adj.f fVar = (com.google.android.libraries.navigation.internal.adj.f) eVar.b;
        fVar.b |= 1;
        fVar.c = i2;
        if (!eVar.b.H()) {
            eVar.v();
        }
        com.google.android.libraries.navigation.internal.adj.f fVar2 = (com.google.android.libraries.navigation.internal.adj.f) eVar.b;
        fVar2.b |= 2;
        fVar2.d = i3;
        if (!kVar.b.H()) {
            kVar.v();
        }
        com.google.android.libraries.navigation.internal.adj.l lVar = (com.google.android.libraries.navigation.internal.adj.l) kVar.b;
        com.google.android.libraries.navigation.internal.adj.f fVar3 = (com.google.android.libraries.navigation.internal.adj.f) eVar.t();
        fVar3.getClass();
        lVar.c = fVar3;
        lVar.b |= 1;
        com.google.android.libraries.navigation.internal.adj.e eVar2 = (com.google.android.libraries.navigation.internal.adj.e) com.google.android.libraries.navigation.internal.adj.f.a.q();
        int i5 = i2 + 1;
        if (!eVar2.b.H()) {
            eVar2.v();
        }
        com.google.android.libraries.navigation.internal.adj.f fVar4 = (com.google.android.libraries.navigation.internal.adj.f) eVar2.b;
        fVar4.b |= 1;
        fVar4.c = i5;
        int i6 = i3 + 1;
        if (!eVar2.b.H()) {
            eVar2.v();
        }
        com.google.android.libraries.navigation.internal.adj.f fVar5 = (com.google.android.libraries.navigation.internal.adj.f) eVar2.b;
        fVar5.b |= 2;
        fVar5.d = i6;
        if (!kVar.b.H()) {
            kVar.v();
        }
        com.google.android.libraries.navigation.internal.adj.l lVar2 = (com.google.android.libraries.navigation.internal.adj.l) kVar.b;
        com.google.android.libraries.navigation.internal.adj.f fVar6 = (com.google.android.libraries.navigation.internal.adj.f) eVar2.t();
        fVar6.getClass();
        lVar2.d = fVar6;
        lVar2.b |= 2;
        if (!gVar.b.H()) {
            gVar.v();
        }
        com.google.android.libraries.navigation.internal.adj.h hVar2 = (com.google.android.libraries.navigation.internal.adj.h) gVar.b;
        com.google.android.libraries.navigation.internal.adj.l lVar3 = (com.google.android.libraries.navigation.internal.adj.l) kVar.t();
        lVar3.getClass();
        bz bzVar = hVar2.c;
        if (!bzVar.c()) {
            hVar2.c = bi.A(bzVar);
        }
        hVar2.c.add(lVar3);
        final com.google.android.libraries.navigation.internal.adj.h hVar3 = (com.google.android.libraries.navigation.internal.adj.h) gVar.t();
        byte[] bArr = (byte[]) c(new br() { // from class: com.google.android.libraries.navigation.internal.fl.a
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return this.a.a.g(hVar3.m());
            }
        });
        if (bArr != null) {
            try {
                com.google.android.libraries.navigation.internal.ael.ar arVar = com.google.android.libraries.navigation.internal.ael.ar.a;
                di diVar = di.a;
                bi biVarV = bi.v(com.google.android.libraries.navigation.internal.adj.j.a, bArr, 0, bArr.length, com.google.android.libraries.navigation.internal.ael.ar.a);
                bi.I(biVarV);
                return ((com.google.android.libraries.navigation.internal.adj.j) biVarV).b.size() > 0;
            } catch (com.google.android.libraries.navigation.internal.ael.cc e) {
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) c.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 474)).o();
            }
        }
        return false;
    }

    public final boolean i() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.g
    public final boolean j(cc ccVar) {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final /* synthetic */ boolean k() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final boolean l() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final byte[] m(cd cdVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.qv.d
    public final void n(cd cdVar, String str, String str2, int i, int i2) {
        throw new UnsupportedOperationException();
    }
}
