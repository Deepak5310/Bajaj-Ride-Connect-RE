package com.google.android.libraries.navigation.internal.bm;

import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.bp.bk;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ao extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public ao(int i, Class cls, am amVar, com.google.android.libraries.navigation.internal.hx.ap apVar) {
        super(cls, amVar, apVar, null);
        this.f = i;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0063  */
    /* JADX WARN: Code duplicated, block: B:28:0x0072  */
    /* JADX WARN: Code duplicated, block: B:30:0x0088  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:42:0x0106  */
    /* JADX WARN: Code duplicated, block: B:45:0x0120  */
    /* JADX WARN: Code duplicated, block: B:48:0x0138  */
    /* JADX WARN: Code duplicated, block: B:72:0x0147 A[EDGE_INSN: B:72:0x0147->B:50:0x0147 BREAK  A[LOOP:1: B:23:0x0058->B:49:0x013e], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0147 A[EDGE_INSN: B:73:0x0147->B:50:0x0147 BREAK  A[LOOP:1: B:23:0x0058->B:49:0x013e], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x013e A[SYNTHETIC] */
    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        com.google.android.libraries.navigation.internal.bt.h hVarB;
        com.google.android.libraries.navigation.internal.acg.q qVar;
        int i;
        bh bhVar;
        com.google.android.libraries.navigation.internal.acg.l lVar;
        com.google.android.libraries.navigation.internal.acg.m mVar;
        com.google.android.libraries.navigation.internal.acg.u uVar;
        com.google.android.libraries.navigation.internal.acg.r rVar;
        bz bzVar;
        if (this.f == 0) {
            am amVar = (am) this.c;
            bk bkVar = (bk) aVar;
            amVar.G = bkVar;
            synchronized (amVar.X) {
                ak akVar = amVar.Y;
                if (akVar != null) {
                    akVar.a.f(bkVar);
                }
            }
            return;
        }
        am amVar2 = (am) this.c;
        com.google.android.libraries.navigation.internal.db.s sVar = (com.google.android.libraries.navigation.internal.db.s) aVar;
        com.google.android.libraries.navigation.internal.db.r rVarD = sVar.d();
        if (rVarD != null) {
            synchronized (amVar2.U) {
                Iterator it2 = amVar2.A.iterator();
                while (it2.hasNext()) {
                    ((com.google.android.libraries.navigation.internal.ol.p) it2.next()).c(rVarD);
                }
            }
            com.google.android.libraries.navigation.internal.db.s sVar2 = amVar2.L;
            if (sVar2 != null) {
                com.google.android.libraries.navigation.internal.yx.ar.q(sVar2);
                com.google.android.libraries.navigation.internal.db.r rVarD2 = sVar2.d();
                com.google.android.libraries.navigation.internal.yx.ar.q(rVarD2);
                if (rVarD.d(rVarD2) > 20.0f) {
                    if (amVar2.N != null && (hVarB = amVar2.b()) != null) {
                        qVar = (com.google.android.libraries.navigation.internal.acg.q) com.google.android.libraries.navigation.internal.acg.r.a.q();
                        i = 0;
                        while (true) {
                            bhVar = ((com.google.android.libraries.navigation.internal.bt.b) hVarB).a;
                            if (i < bhVar.d()) {
                                break;
                            }
                            lVar = amVar2.N;
                            com.google.android.libraries.navigation.internal.yx.ar.q(lVar);
                            if (i >= lVar.b.size()) {
                                break;
                            }
                            bg bgVarE = bhVar.e(i);
                            mVar = (com.google.android.libraries.navigation.internal.acg.m) com.google.android.libraries.navigation.internal.acg.n.a.q();
                            long j = bgVarE.Y;
                            if (!mVar.b.H()) {
                                mVar.v();
                            }
                            com.google.android.libraries.navigation.internal.acg.n nVar = (com.google.android.libraries.navigation.internal.acg.n) mVar.b;
                            nVar.b |= 1;
                            nVar.c = j;
                            uVar = (com.google.android.libraries.navigation.internal.acg.u) com.google.android.libraries.navigation.internal.acg.v.a.q();
                            if (!uVar.b.H()) {
                                uVar.v();
                            }
                            com.google.android.libraries.navigation.internal.acg.v vVar = (com.google.android.libraries.navigation.internal.acg.v) uVar.b;
                            vVar.b |= 1;
                            vVar.c = 0;
                            int iA = amVar2.a(bgVarE);
                            if (!uVar.b.H()) {
                                uVar.v();
                            }
                            com.google.android.libraries.navigation.internal.acg.v vVar2 = (com.google.android.libraries.navigation.internal.acg.v) uVar.b;
                            vVar2.b |= 2;
                            vVar2.d = iA;
                            if (!mVar.b.H()) {
                                mVar.v();
                            }
                            com.google.android.libraries.navigation.internal.acg.n nVar2 = (com.google.android.libraries.navigation.internal.acg.n) mVar.b;
                            com.google.android.libraries.navigation.internal.acg.v vVar3 = (com.google.android.libraries.navigation.internal.acg.v) uVar.t();
                            vVar3.getClass();
                            nVar2.d = vVar3;
                            nVar2.b |= 2;
                            com.google.android.libraries.navigation.internal.acg.l lVar2 = amVar2.N;
                            com.google.android.libraries.navigation.internal.yx.ar.q(lVar2);
                            com.google.android.libraries.navigation.internal.ach.j jVar = (com.google.android.libraries.navigation.internal.ach.j) lVar2.b.get(i);
                            if (!mVar.b.H()) {
                                mVar.v();
                            }
                            com.google.android.libraries.navigation.internal.acg.n nVar3 = (com.google.android.libraries.navigation.internal.acg.n) mVar.b;
                            jVar.getClass();
                            nVar3.e = jVar;
                            nVar3.b |= 4;
                            if (!qVar.b.H()) {
                                qVar.v();
                            }
                            rVar = (com.google.android.libraries.navigation.internal.acg.r) qVar.b;
                            com.google.android.libraries.navigation.internal.acg.n nVar4 = (com.google.android.libraries.navigation.internal.acg.n) mVar.t();
                            nVar4.getClass();
                            bzVar = rVar.b;
                            if (!bzVar.c()) {
                                rVar.b = bi.A(bzVar);
                            }
                            rVar.b.add(nVar4);
                            i++;
                        }
                        amVar2.ak.a((com.google.android.libraries.navigation.internal.acg.r) qVar.t());
                    }
                }
            } else if (amVar2.N != null) {
                qVar = (com.google.android.libraries.navigation.internal.acg.q) com.google.android.libraries.navigation.internal.acg.r.a.q();
                i = 0;
                while (true) {
                    bhVar = ((com.google.android.libraries.navigation.internal.bt.b) hVarB).a;
                    if (i < bhVar.d()) {
                        break;
                        break;
                    }
                    lVar = amVar2.N;
                    com.google.android.libraries.navigation.internal.yx.ar.q(lVar);
                    if (i >= lVar.b.size()) {
                        break;
                        break;
                    }
                    bg bgVarE2 = bhVar.e(i);
                    mVar = (com.google.android.libraries.navigation.internal.acg.m) com.google.android.libraries.navigation.internal.acg.n.a.q();
                    long j2 = bgVarE2.Y;
                    if (!mVar.b.H()) {
                        mVar.v();
                    }
                    com.google.android.libraries.navigation.internal.acg.n nVar5 = (com.google.android.libraries.navigation.internal.acg.n) mVar.b;
                    nVar5.b |= 1;
                    nVar5.c = j2;
                    uVar = (com.google.android.libraries.navigation.internal.acg.u) com.google.android.libraries.navigation.internal.acg.v.a.q();
                    if (!uVar.b.H()) {
                        uVar.v();
                    }
                    com.google.android.libraries.navigation.internal.acg.v vVar4 = (com.google.android.libraries.navigation.internal.acg.v) uVar.b;
                    vVar4.b |= 1;
                    vVar4.c = 0;
                    int iA2 = amVar2.a(bgVarE2);
                    if (!uVar.b.H()) {
                        uVar.v();
                    }
                    com.google.android.libraries.navigation.internal.acg.v vVar5 = (com.google.android.libraries.navigation.internal.acg.v) uVar.b;
                    vVar5.b |= 2;
                    vVar5.d = iA2;
                    if (!mVar.b.H()) {
                        mVar.v();
                    }
                    com.google.android.libraries.navigation.internal.acg.n nVar6 = (com.google.android.libraries.navigation.internal.acg.n) mVar.b;
                    com.google.android.libraries.navigation.internal.acg.v vVar6 = (com.google.android.libraries.navigation.internal.acg.v) uVar.t();
                    vVar6.getClass();
                    nVar6.d = vVar6;
                    nVar6.b |= 2;
                    com.google.android.libraries.navigation.internal.acg.l lVar3 = amVar2.N;
                    com.google.android.libraries.navigation.internal.yx.ar.q(lVar3);
                    com.google.android.libraries.navigation.internal.ach.j jVar2 = (com.google.android.libraries.navigation.internal.ach.j) lVar3.b.get(i);
                    if (!mVar.b.H()) {
                        mVar.v();
                    }
                    com.google.android.libraries.navigation.internal.acg.n nVar7 = (com.google.android.libraries.navigation.internal.acg.n) mVar.b;
                    jVar2.getClass();
                    nVar7.e = jVar2;
                    nVar7.b |= 4;
                    if (!qVar.b.H()) {
                        qVar.v();
                    }
                    rVar = (com.google.android.libraries.navigation.internal.acg.r) qVar.b;
                    com.google.android.libraries.navigation.internal.acg.n nVar8 = (com.google.android.libraries.navigation.internal.acg.n) mVar.t();
                    nVar8.getClass();
                    bzVar = rVar.b;
                    if (!bzVar.c()) {
                        rVar.b = bi.A(bzVar);
                    }
                    rVar.b.add(nVar8);
                    i++;
                }
                amVar2.ak.a((com.google.android.libraries.navigation.internal.acg.r) qVar.t());
            }
            amVar2.L = sVar;
        }
    }
}
