package com.google.android.libraries.navigation.internal.sv;

import com.google.android.libraries.navigation.internal.adr.dx;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.fp;
import com.google.android.libraries.navigation.internal.adr.ix;
import com.google.android.libraries.navigation.internal.adr.iy;
import com.google.android.libraries.navigation.internal.adr.iz;
import com.google.android.libraries.navigation.internal.adr.ja;
import com.google.android.libraries.navigation.internal.adr.jb;
import com.google.android.libraries.navigation.internal.adr.je;
import com.google.android.libraries.navigation.internal.adr.jf;
import com.google.android.libraries.navigation.internal.adr.jg;
import com.google.android.libraries.navigation.internal.adr.kn;
import com.google.android.libraries.navigation.internal.adr.kq;
import com.google.android.libraries.navigation.internal.adr.kr;
import com.google.android.libraries.navigation.internal.adr.kt;
import com.google.android.libraries.navigation.internal.adr.ku;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.joda.time.DateTimeConstants;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class am extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public am(int i, Class cls, ak akVar, com.google.android.libraries.navigation.internal.hx.ap apVar, Executor executor) {
        super(cls, akVar, apVar, executor);
        this.f = i;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00ed  */
    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        com.google.android.libraries.navigation.internal.bp.bg bgVar;
        com.google.android.libraries.navigation.internal.sc.f fVar;
        com.google.android.libraries.navigation.internal.ael.x xVar;
        int i;
        com.google.android.libraries.navigation.internal.db.r rVar;
        com.google.android.libraries.navigation.internal.bp.bg bgVar2 = null;
        int i2 = 1;
        switch (this.f) {
            case 0:
                ((ak) this.c).H(null, false, false, true);
                return;
            case 1:
                ak akVar = (ak) this.c;
                com.google.android.libraries.navigation.internal.ady.i iVar = (com.google.android.libraries.navigation.internal.ady.i) com.google.android.libraries.navigation.internal.ady.n.a.q();
                iVar.c(((com.google.android.libraries.navigation.internal.ss.d) aVar).c());
                akVar.o((com.google.android.libraries.navigation.internal.ady.n) iVar.t());
                return;
            case 2:
                ak akVar2 = (ak) this.c;
                com.google.android.libraries.navigation.internal.ady.i iVar2 = (com.google.android.libraries.navigation.internal.ady.i) com.google.android.libraries.navigation.internal.ady.n.a.q();
                com.google.android.libraries.navigation.internal.ady.l lVar = (com.google.android.libraries.navigation.internal.ady.l) com.google.android.libraries.navigation.internal.ady.m.a.q();
                if (!lVar.b.H()) {
                    lVar.v();
                }
                com.google.android.libraries.navigation.internal.ady.m mVar = (com.google.android.libraries.navigation.internal.ady.m) lVar.b;
                mVar.b |= 1;
                mVar.c = true;
                com.google.android.libraries.navigation.internal.ady.m mVar2 = (com.google.android.libraries.navigation.internal.ady.m) lVar.t();
                if (!iVar2.b.H()) {
                    iVar2.v();
                }
                com.google.android.libraries.navigation.internal.ady.n nVar = (com.google.android.libraries.navigation.internal.ady.n) iVar2.b;
                mVar2.getClass();
                nVar.d = mVar2;
                nVar.b |= 1;
                akVar2.o((com.google.android.libraries.navigation.internal.ady.n) iVar2.t());
                return;
            case 3:
                ak akVar3 = (ak) this.c;
                if (akVar3.D != null) {
                    com.google.android.libraries.navigation.internal.tj.o oVarG = akVar3.g();
                    akVar3.e.c(oVarG);
                    akVar3.q.b();
                    akVar3.p.k();
                    akVar3.p.h(oVarG, akVar3.D, akVar3.C, null);
                    return;
                }
                return;
            case 4:
                ak akVar4 = (ak) this.c;
                com.google.android.libraries.navigation.internal.sc.f fVar2 = akVar4.J.f;
                if (fVar2 != null) {
                    ix ixVar = (ix) jg.a.q();
                    iy iyVar = (iy) iz.a.q();
                    je jeVar = (je) jf.a.q();
                    if (!jeVar.b.H()) {
                        jeVar.v();
                    }
                    jf jfVar = (jf) jeVar.b;
                    jfVar.b |= 1;
                    jfVar.c = 100;
                    if (!jeVar.b.H()) {
                        jeVar.v();
                    }
                    jf.c((jf) jeVar.b);
                    if (!iyVar.b.H()) {
                        iyVar.v();
                    }
                    iz izVar = (iz) iyVar.b;
                    jf jfVar2 = (jf) jeVar.t();
                    jfVar2.getClass();
                    izVar.c = jfVar2;
                    izVar.b |= 1;
                    je jeVar2 = (je) jf.a.q();
                    if (!jeVar2.b.H()) {
                        jeVar2.v();
                    }
                    jf jfVar3 = (jf) jeVar2.b;
                    jfVar3.b |= 1;
                    jfVar3.c = 0;
                    if (!jeVar2.b.H()) {
                        jeVar2.v();
                    }
                    jf.c((jf) jeVar2.b);
                    if (!iyVar.b.H()) {
                        iyVar.v();
                    }
                    iz izVar2 = (iz) iyVar.b;
                    jf jfVar4 = (jf) jeVar2.t();
                    jfVar4.getClass();
                    izVar2.d = jfVar4;
                    izVar2.b = 2 | izVar2.b;
                    if (!ixVar.b.H()) {
                        ixVar.v();
                    }
                    jg jgVar = (jg) ixVar.b;
                    iz izVar3 = (iz) iyVar.t();
                    izVar3.getClass();
                    jgVar.j = izVar3;
                    jgVar.b |= 64;
                    dx dxVar = (dx) el.a.q();
                    fp fpVar = fp.ON_ROUTE_PROBLEM;
                    if (!dxVar.b.H()) {
                        dxVar.v();
                    }
                    el elVar = (el) dxVar.b;
                    elVar.g = fpVar.L;
                    elVar.b |= 8;
                    dxVar.c(com.google.android.libraries.navigation.internal.br.s.a("Test prompt title"));
                    dxVar.d(com.google.android.libraries.navigation.internal.br.s.a("Test subtitle"));
                    if (!ixVar.b.H()) {
                        ixVar.v();
                    }
                    jg jgVar2 = (jg) ixVar.b;
                    el elVarT = dxVar.t();
                    elVarT.getClass();
                    jgVar2.i = elVarT;
                    jgVar2.b |= 32;
                    com.google.android.libraries.navigation.internal.ael.x xVarV = com.google.android.libraries.navigation.internal.ael.x.v("\b\u0001");
                    if (!ixVar.b.H()) {
                        ixVar.v();
                    }
                    jg jgVar3 = (jg) ixVar.b;
                    jgVar3.b |= 8;
                    jgVar3.g = xVarV;
                    com.google.android.libraries.navigation.internal.adr.k kVar = (com.google.android.libraries.navigation.internal.adr.k) com.google.android.libraries.navigation.internal.adr.n.a.q();
                    if (!kVar.b.H()) {
                        kVar.v();
                    }
                    com.google.android.libraries.navigation.internal.adr.n.c((com.google.android.libraries.navigation.internal.adr.n) kVar.b);
                    ixVar.c(kVar);
                    ja jaVar = (ja) jb.a.q();
                    if (!jaVar.b.H()) {
                        jaVar.v();
                    }
                    jb jbVar = (jb) jaVar.b;
                    jbVar.b = 1 | jbVar.b;
                    jbVar.c = DateTimeConstants.SECONDS_PER_DAY;
                    if (!ixVar.b.H()) {
                        ixVar.v();
                    }
                    jg jgVar4 = (jg) ixVar.b;
                    jb jbVar2 = (jb) jaVar.t();
                    jbVar2.getClass();
                    jgVar4.k = jbVar2;
                    jgVar4.b |= 128;
                    akVar4.q((jg) ixVar.t(), fVar2.e.i.toEpochMilli());
                    return;
                }
                return;
            case 5:
                throw null;
            case 6:
                ak akVar5 = (ak) this.c;
                k kVar2 = akVar5.J;
                com.google.android.libraries.navigation.internal.sc.f fVar3 = kVar2.f;
                if (fVar3 == null) {
                    bgVar = null;
                } else {
                    List<com.google.android.libraries.navigation.internal.sc.f> list = kVar2.e;
                    double d = fVar3.d();
                    com.google.android.libraries.navigation.internal.sc.f fVar4 = null;
                    for (com.google.android.libraries.navigation.internal.sc.f fVar5 : list) {
                        if (fVar5.d() < d) {
                            d = fVar5.d();
                            fVar4 = fVar5;
                        }
                    }
                    if (fVar4 == null) {
                        bgVar = null;
                    } else {
                        bgVar = fVar4.e;
                    }
                }
                if (bgVar != null) {
                    kr krVar = (kr) ku.a.q();
                    int i3 = kt.c;
                    if (!krVar.b.H()) {
                        krVar.v();
                    }
                    ku kuVar = (ku) krVar.b;
                    if (i3 == 0) {
                        throw null;
                    }
                    kuVar.c = i3;
                    kuVar.b = 1 | kuVar.b;
                    kn knVar = (kn) kq.a.q();
                    ix ixVar2 = (ix) jg.a.q();
                    com.google.android.libraries.navigation.internal.adr.k kVar3 = (com.google.android.libraries.navigation.internal.adr.k) com.google.android.libraries.navigation.internal.adr.n.a.q();
                    int i4 = com.google.android.libraries.navigation.internal.adr.m.d;
                    if (!kVar3.b.H()) {
                        kVar3.v();
                    }
                    com.google.android.libraries.navigation.internal.adr.n nVar2 = (com.google.android.libraries.navigation.internal.adr.n) kVar3.b;
                    int i5 = i4 - 1;
                    if (i4 == 0) {
                        throw null;
                    }
                    nVar2.d = i5;
                    nVar2.b |= 2;
                    ixVar2.c(kVar3);
                    if (!knVar.b.H()) {
                        knVar.v();
                    }
                    kq kqVar = (kq) knVar.b;
                    jg jgVar5 = (jg) ixVar2.t();
                    jgVar5.getClass();
                    kqVar.e = jgVar5;
                    kqVar.b |= 4;
                    kq kqVar2 = (kq) knVar.t();
                    if (!krVar.b.H()) {
                        krVar.v();
                    }
                    ku kuVar2 = (ku) krVar.b;
                    kqVar2.getClass();
                    kuVar2.d = kqVar2;
                    kuVar2.b = 2 | kuVar2.b;
                    if (akVar5.B(bgVar, (ku) krVar.t()) && akVar5.h.f165n) {
                        akVar5.p.l(akVar5.g(), akVar5.C, null);
                        return;
                    }
                    return;
                }
                return;
            case 7:
                ak akVar6 = (ak) this.c;
                long jA = akVar6.c.a();
                long millis = TimeUnit.SECONDS.toMillis(ak.d(akVar6.r, akVar6.g.e()));
                long j = akVar6.B;
                if ((akVar6.A + j) - jA > millis) {
                    akVar6.A = (jA + millis) - j;
                    return;
                }
                return;
            case 8:
                ak akVar7 = (ak) this.c;
                if (akVar7.D == null || (fVar = akVar7.J.f) == null) {
                    return;
                }
                akVar7.n(fVar, null, false);
                return;
            case 9:
                ak akVar8 = (ak) this.c;
                com.google.android.libraries.navigation.internal.sc.f fVar6 = akVar8.J.f;
                if (akVar8.D == null || fVar6 == null) {
                    return;
                }
                akVar8.n(fVar6, null, true);
                return;
            case 10:
                com.google.android.libraries.navigation.internal.sc.f fVar7 = ((ak) this.c).J.f;
                fVar7.getClass();
                com.google.android.libraries.navigation.internal.ady.al alVar = fVar7.e.j;
                throw null;
            case 11:
                ak akVar9 = (ak) this.c;
                com.google.android.libraries.navigation.internal.sr.c cVar = (com.google.android.libraries.navigation.internal.sr.c) aVar;
                aj ajVar = akVar9.E;
                if (ajVar == null) {
                    i = 3;
                } else {
                    akVar9.E = null;
                    boolean z = cVar.a;
                    com.google.android.libraries.navigation.internal.bp.bg bgVar3 = ajVar.a;
                    kq kqVar3 = ajVar.b;
                    if (z) {
                        if (akVar9.z() && cVar.b) {
                            akVar9.t(com.google.android.libraries.navigation.internal.vn.b.DING_DEE, "");
                        }
                        xVar = kqVar3.f;
                        if (akVar9.C(bgVar3.Z, cVar.c) && akVar9.h.f165n && (rVar = akVar9.D) != null) {
                            akVar9.w(rVar);
                        }
                    } else {
                        i2 = 2;
                        xVar = kqVar3.g;
                    }
                    com.google.android.libraries.navigation.internal.sc.f fVar8 = akVar9.J.f;
                    if (fVar8 != null) {
                        fVar8.e.U = xVar;
                    }
                    i = i2;
                    bgVar2 = bgVar3;
                }
                akVar9.d.a(new com.google.android.libraries.navigation.internal.sw.b(i, cVar.b, bgVar2));
                return;
            default:
                ak akVar10 = (ak) this.c;
                akVar10.f.c();
                com.google.android.libraries.navigation.internal.sc.f fVar9 = akVar10.J.f;
                if (fVar9 == null) {
                    return;
                }
                akVar10.f.d(akVar10.d, fVar9.e, fVar9.a());
                return;
        }
    }
}
