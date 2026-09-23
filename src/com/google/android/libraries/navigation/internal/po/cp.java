package com.google.android.libraries.navigation.internal.po;

import android.util.SparseIntArray;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cp implements com.google.android.libraries.navigation.internal.qc.g {
    private static final com.google.android.libraries.navigation.internal.px.da c = com.google.android.libraries.navigation.internal.px.di.a;
    public final hi a;
    public com.google.android.libraries.geo.mapcore.internal.model.v b;

    public cp(hi hiVar) {
        this.a = hiVar;
        this.b = hiVar.p();
    }

    private static com.google.android.libraries.geo.mapcore.internal.model.bt f(int i, com.google.android.libraries.geo.mapcore.internal.model.v vVar) {
        return vVar == null ? com.google.android.libraries.geo.mapcore.internal.model.bt.a : vVar.c.b(i);
    }

    private final com.google.android.libraries.geo.mapcore.internal.model.bt g(com.google.android.libraries.navigation.internal.px.ek ekVar, com.google.android.libraries.navigation.internal.agg.ez ezVar) {
        com.google.android.libraries.navigation.internal.adg.ef efVarO = ekVar.o();
        com.google.android.libraries.navigation.internal.adg.es esVarP = ekVar.p();
        com.google.android.libraries.geo.mapcore.internal.model.v vVarK = ekVar.k();
        com.google.android.libraries.geo.mapcore.internal.model.bt btVar = com.google.android.libraries.geo.mapcore.internal.model.bt.a;
        int i = esVarP.c;
        if (i == 0) {
            int i2 = efVarO.b;
            if ((i2 & 8192) == 0) {
                return (i2 & 4096) == 0 ? btVar : this.a.q(ekVar.c()).k(efVarO.l);
            }
            com.google.android.libraries.geo.mapcore.internal.model.bt btVarH = h(efVarO.m, ezVar, vVarK);
            return efVarO.m != btVarH.b ? btVarH : btVarH;
        }
        if (vVarK == null) {
            vVarK = this.b;
        }
        com.google.android.libraries.geo.mapcore.internal.model.bt btVarH2 = h(f(i, vVarK).b, ezVar, vVarK);
        int i3 = esVarP.c;
        long j = btVarH2.b;
        return btVarH2;
    }

    private static com.google.android.libraries.geo.mapcore.internal.model.bt h(long j, com.google.android.libraries.navigation.internal.agg.ez ezVar, com.google.android.libraries.geo.mapcore.internal.model.v vVar) {
        if (vVar == null) {
            return com.google.android.libraries.geo.mapcore.internal.model.bt.a;
        }
        return vVar.c.c(hi.n(j, ezVar, vVar.d));
    }

    @Override // com.google.android.libraries.navigation.internal.qc.g
    public final com.google.android.libraries.geo.mapcore.internal.model.ai a(com.google.android.libraries.navigation.internal.adg.dp dpVar, com.google.android.libraries.navigation.internal.px.ek ekVar, int i) {
        com.google.android.libraries.navigation.internal.agg.ez ezVarA = com.google.android.libraries.navigation.internal.px.ei.a(ekVar.o());
        com.google.android.libraries.navigation.internal.agg.fa faVar = com.google.android.libraries.navigation.internal.agg.fd.a;
        return b(dpVar, ekVar, new com.google.android.libraries.navigation.internal.agg.fc(ezVarA), i);
    }

    @Override // com.google.android.libraries.navigation.internal.qc.g
    public final com.google.android.libraries.geo.mapcore.internal.model.ai b(com.google.android.libraries.navigation.internal.adg.dp dpVar, com.google.android.libraries.navigation.internal.px.ek ekVar, com.google.android.libraries.navigation.internal.agg.ez ezVar, int i) {
        com.google.android.libraries.geo.mapcore.internal.model.bt btVarK;
        com.google.android.libraries.geo.mapcore.internal.model.bt btVarH;
        int iMax = Math.max(0, i);
        com.google.android.libraries.navigation.internal.adg.ef efVarO = ekVar.o();
        com.google.android.libraries.geo.mapcore.internal.model.v vVarK = ekVar.k();
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.e);
        dpVar.h(bhVarS);
        Object objK = dpVar.w.k(bhVarS.d);
        com.google.android.libraries.navigation.internal.adg.es esVar = (com.google.android.libraries.navigation.internal.adg.es) (objK == null ? bhVarS.b : bhVarS.c(objK));
        int i2 = esVar.c;
        if (i2 != 0) {
            if (vVarK == null) {
                vVarK = this.b;
            }
            btVarK = h(f(i2, vVarK).b, ezVar, vVarK);
            int i3 = esVar.c;
            long j = btVarK.b;
        } else {
            int i4 = dpVar.b;
            if ((i4 & 16) != 0) {
                com.google.android.libraries.geo.mapcore.internal.model.bt btVarG = g(ekVar, ezVar);
                int i5 = dpVar.g;
                SparseIntArray sparseIntArray = btVarG.d;
                int i6 = sparseIntArray != null ? sparseIntArray.get(i5, -1) : -1;
                if (vVarK == null) {
                    vVarK = this.b;
                }
                btVarH = h(i6, com.google.android.libraries.navigation.internal.agg.fd.a, vVarK);
                int i7 = dpVar.g;
                long j2 = btVarH.b;
            } else if ((i4 & 4) != 0) {
                if ((i4 & 8) != 0 && vVarK != null) {
                    if (vVarK.a != dpVar.f) {
                        return com.google.android.libraries.geo.mapcore.internal.model.bt.a.d();
                    }
                }
                btVarH = h(dpVar.e, ezVar, vVarK);
                long j3 = dpVar.e;
                long j4 = btVarH.b;
            } else {
                if ((i4 & 2) == 0) {
                    return com.google.android.libraries.geo.mapcore.internal.model.bt.a.d();
                }
                btVarK = this.a.q(ekVar.c()).k(dpVar.d);
            }
            btVarK = btVarH;
        }
        com.google.android.libraries.geo.mapcore.internal.model.ai aiVarG = btVarK.g(iMax);
        com.google.android.libraries.navigation.internal.ael.bh bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.b);
        efVarO.h(bhVarS2);
        Object objK2 = efVarO.w.k(bhVarS2.d);
        if ((((com.google.android.libraries.navigation.internal.adl.f) (objK2 == null ? bhVarS2.b : bhVarS2.c(objK2))).b & 2) == 0) {
            return aiVarG;
        }
        com.google.android.libraries.navigation.internal.ael.bh bhVarS3 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.b);
        efVarO.h(bhVarS3);
        Object objK3 = efVarO.w.k(bhVarS3.d);
        com.google.android.libraries.navigation.internal.adl.h hVar = ((com.google.android.libraries.navigation.internal.adl.f) (objK3 == null ? bhVarS3.b : bhVarS3.c(objK3))).d;
        if (hVar == null) {
            hVar = com.google.android.libraries.navigation.internal.adl.h.a;
        }
        if (!aiVarG.q()) {
            return aiVarG;
        }
        com.google.android.libraries.geo.mapcore.internal.model.n nVar = new com.google.android.libraries.geo.mapcore.internal.model.n(aiVarG.r);
        if ((hVar.b & 1) != 0) {
            nVar.c(hVar.c);
        }
        if ((hVar.b & 2) != 0) {
            nVar.b(hVar.d);
        }
        com.google.android.libraries.geo.mapcore.internal.model.ah ahVarF = aiVarG.f();
        ahVarF.f57n = nVar.a();
        return new com.google.android.libraries.geo.mapcore.internal.model.ai(ahVarF);
    }

    @Override // com.google.android.libraries.navigation.internal.qc.g
    public final com.google.android.libraries.geo.mapcore.internal.model.ai c(com.google.android.libraries.navigation.internal.adg.dt dtVar, com.google.android.libraries.navigation.internal.px.ek ekVar, int i) {
        com.google.android.libraries.navigation.internal.adg.ef efVarO = ekVar.o();
        int iMax = Math.max(0, i);
        com.google.android.libraries.navigation.internal.agg.ez ezVarA = com.google.android.libraries.navigation.internal.px.ei.a(efVarO);
        com.google.android.libraries.navigation.internal.agg.fa faVar = com.google.android.libraries.navigation.internal.agg.fd.a;
        com.google.android.libraries.navigation.internal.agg.fc fcVar = new com.google.android.libraries.navigation.internal.agg.fc(ezVarA);
        com.google.android.libraries.geo.mapcore.internal.model.v vVarK = ekVar.k();
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.d);
        dtVar.h(bhVarS);
        Object objK = dtVar.w.k(bhVarS.d);
        int i2 = ((com.google.android.libraries.navigation.internal.adg.es) (objK == null ? bhVarS.b : bhVarS.c(objK))).c;
        if (i2 != 0) {
            if (vVarK == null) {
                vVarK = this.b;
            }
            return h(f(i2, vVarK).b, fcVar, vVarK).g(iMax);
        }
        int i3 = dtVar.b;
        if ((i3 & 2) != 0) {
            return h(dtVar.e, fcVar, vVarK).g(iMax);
        }
        return (i3 & 1) != 0 ? this.a.q(ekVar.c()).k(dtVar.d).g(iMax) : com.google.android.libraries.geo.mapcore.internal.model.bt.a.d();
    }

    @Override // com.google.android.libraries.navigation.internal.qc.g
    public final com.google.android.libraries.geo.mapcore.internal.model.ai d(com.google.android.libraries.navigation.internal.px.ek ekVar, com.google.android.libraries.navigation.internal.agg.ez ezVar, int i) {
        int iMax = Math.max(0, i);
        com.google.android.libraries.geo.mapcore.internal.model.bt btVarG = g(ekVar, ezVar);
        if (btVarG.b != -1) {
            ekVar.o();
            long j = btVarG.b;
        }
        return btVarG.g(iMax);
    }

    @Override // com.google.android.libraries.navigation.internal.qc.g
    public final com.google.android.libraries.navigation.internal.zy.e e(com.google.android.libraries.navigation.internal.px.ek ekVar) {
        return ekVar.k() != null ? ekVar.k().e : com.google.android.libraries.navigation.internal.zy.e.a;
    }
}
