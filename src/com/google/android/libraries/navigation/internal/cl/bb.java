package com.google.android.libraries.navigation.internal.cl;

import android.content.Context;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adr.ci;
import com.google.android.libraries.navigation.internal.adr.cy;
import com.google.android.libraries.navigation.internal.adr.db;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.adr.kk;
import com.google.android.libraries.navigation.internal.bp.cf;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bb extends i {
    public bb(com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.bj.b bVar, Context context, com.google.android.libraries.navigation.internal.hf.c cVar, com.google.android.libraries.navigation.ao aoVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.hn.r rVar, com.google.android.libraries.navigation.internal.op.i iVar) {
        super(aVar, bVar, context, rVar, cVar, iVar);
    }

    @Override // com.google.android.libraries.navigation.internal.cl.i
    public final void c(f fVar, dy dyVar, boolean z, com.google.android.libraries.navigation.internal.bp.bg bgVar) {
        com.google.android.libraries.navigation.internal.yx.an anVarJ;
        int iA;
        com.google.android.libraries.navigation.internal.yx.an anVarJ2;
        k kVar = (k) fVar;
        ev evVarB = b(kVar.b, kVar.h, kVar.k);
        if (bgVar.g.k(kk.b)) {
            iA = com.google.android.libraries.navigation.internal.afe.j.f255n.a;
        } else {
            com.google.android.libraries.navigation.internal.ady.al alVarB = null;
            if (g(evVarB, ci.f)) {
                cf cfVar = bgVar.g;
                if ((cfVar.f().b & 1) != 0 && (alVarB = com.google.android.libraries.navigation.internal.ady.al.b(cfVar.f().c)) == null) {
                    alVarB = com.google.android.libraries.navigation.internal.ady.al.DRIVE;
                }
                iA = (com.google.android.libraries.navigation.internal.yx.am.a(alVarB, com.google.android.libraries.navigation.internal.ady.al.TWO_WHEELER) ? com.google.android.libraries.navigation.internal.afe.j.v : com.google.android.libraries.navigation.internal.afe.j.m).a;
            } else {
                com.google.android.libraries.navigation.internal.bp.bg bgVar2 = kVar.b.a;
                if (bgVar2.g.d() != null) {
                    Iterator it2 = bgVar2.g.d().b.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            anVarJ = com.google.android.libraries.navigation.internal.yx.a.a;
                            break;
                        }
                        db dbVar = (db) it2.next();
                        int iA2 = cy.a(dbVar.c);
                        if (iA2 == 0) {
                            iA2 = cy.a;
                        }
                        boolean z2 = iA2 == cy.b;
                        if (iA2 == 0) {
                            throw null;
                        }
                        if (z2 && (dbVar.b & 8) != 0) {
                            anVarJ = com.google.android.libraries.navigation.internal.yx.an.j(dbVar);
                            break;
                        }
                    }
                } else {
                    anVarJ = com.google.android.libraries.navigation.internal.yx.a.a;
                }
                if (anVarJ.g()) {
                    iA = com.google.android.libraries.navigation.internal.afe.j.p.a;
                } else if (g(evVarB, ci.b)) {
                    iA = com.google.android.libraries.navigation.internal.afe.j.q.a;
                } else if (z) {
                    com.google.android.libraries.navigation.internal.yx.an anVarA = kVar.b.a();
                    if (!anVarA.g()) {
                        anVarJ2 = com.google.android.libraries.navigation.internal.yx.a.a;
                        break;
                    }
                    com.google.android.libraries.navigation.internal.adr.ap apVar = ((cf) anVarA.c()).f().j;
                    if (apVar == null) {
                        apVar = com.google.android.libraries.navigation.internal.adr.ap.a;
                    }
                    Iterator it3 = apVar.b.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            anVarJ2 = com.google.android.libraries.navigation.internal.yx.a.a;
                            break;
                        }
                        com.google.android.libraries.navigation.internal.adr.ao aoVar = (com.google.android.libraries.navigation.internal.adr.ao) it3.next();
                        int iA3 = com.google.android.libraries.navigation.internal.adr.an.a(aoVar.b);
                        if (iA3 == 0) {
                            iA3 = com.google.android.libraries.navigation.internal.adr.an.a;
                        }
                        if (iA3 != com.google.android.libraries.navigation.internal.adr.an.a) {
                            ii.a aVar = ii.a.DELAY_NODATA;
                            int iA4 = com.google.android.libraries.navigation.internal.adr.an.a(aoVar.b);
                            if (iA4 == 0) {
                                iA4 = com.google.android.libraries.navigation.internal.adr.an.a;
                            }
                            int i = iA4 - 1;
                            if (iA4 == 0) {
                                throw null;
                            }
                            switch (i) {
                                case 1:
                                    anVarJ2 = com.google.android.libraries.navigation.internal.yx.an.j(com.google.android.libraries.navigation.internal.afe.j.f);
                                    break;
                                case 2:
                                    anVarJ2 = com.google.android.libraries.navigation.internal.yx.an.j(com.google.android.libraries.navigation.internal.afe.j.g);
                                    break;
                                case 3:
                                    anVarJ2 = com.google.android.libraries.navigation.internal.yx.an.j(com.google.android.libraries.navigation.internal.afe.j.j);
                                    break;
                                case 4:
                                    anVarJ2 = com.google.android.libraries.navigation.internal.yx.an.j(com.google.android.libraries.navigation.internal.afe.j.l);
                                    break;
                                case 5:
                                    anVarJ2 = com.google.android.libraries.navigation.internal.yx.an.j(com.google.android.libraries.navigation.internal.afe.j.h);
                                    break;
                                case 6:
                                    anVarJ2 = com.google.android.libraries.navigation.internal.yx.an.j(com.google.android.libraries.navigation.internal.afe.j.i);
                                    break;
                                case 7:
                                    anVarJ2 = com.google.android.libraries.navigation.internal.yx.an.j(com.google.android.libraries.navigation.internal.afe.j.k);
                                    break;
                                default:
                                    anVarJ2 = com.google.android.libraries.navigation.internal.yx.a.a;
                                    break;
                            }
                        }
                    }
                    iA = ((com.google.android.libraries.navigation.internal.afd.a) anVarJ2.e(com.google.android.libraries.navigation.internal.afe.j.o)).a();
                } else {
                    iA = com.google.android.libraries.navigation.internal.afe.j.o.a;
                }
            }
        }
        if (iA != -1) {
            com.google.android.libraries.navigation.internal.adf.m mVar = (com.google.android.libraries.navigation.internal.adf.m) com.google.android.libraries.navigation.internal.adf.n.a.q();
            if (!mVar.b.H()) {
                mVar.v();
            }
            com.google.android.libraries.navigation.internal.adf.n nVar = (com.google.android.libraries.navigation.internal.adf.n) mVar.b;
            nVar.b |= 8;
            nVar.d = iA;
            String strG = bgVar.G();
            if (!mVar.b.H()) {
                mVar.v();
            }
            com.google.android.libraries.navigation.internal.adf.n nVar2 = (com.google.android.libraries.navigation.internal.adf.n) mVar.b;
            strG.getClass();
            nVar2.b |= 2;
            nVar2.c = strG;
            com.google.android.libraries.navigation.internal.rp.c.f(dyVar, (com.google.android.libraries.navigation.internal.adf.n) mVar.t());
        }
    }
}
