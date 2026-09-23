package com.google.android.libraries.navigation.internal.po;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class co implements com.google.android.libraries.navigation.internal.qc.f {
    private com.google.android.libraries.navigation.internal.px.ek a = null;
    private long b = -1;
    private final com.google.android.libraries.geo.mapcore.internal.model.v c;

    public co(com.google.android.libraries.geo.mapcore.internal.model.v vVar) {
        this.c = vVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qc.f
    public final boolean a(com.google.android.libraries.navigation.internal.px.ek ekVar, com.google.android.libraries.navigation.internal.adg.ag agVar) {
        long jN;
        if (com.google.android.libraries.geo.mapcore.internal.model.f.a(ekVar.o().q, agVar)) {
            return true;
        }
        com.google.android.libraries.geo.mapcore.internal.model.v vVarK = ekVar.k();
        if (vVarK == null && ekVar.p().c != 0) {
            vVarK = this.c;
        }
        if (vVarK == null) {
            return false;
        }
        synchronized (this) {
            if (ekVar == this.a) {
                jN = this.b;
            } else {
                this.a = ekVar;
                com.google.android.libraries.navigation.internal.adg.ef efVarO = ekVar.o();
                int i = ekVar.p().c;
                if (i != 0) {
                    jN = vVarK.c.b(i).b;
                } else if ((efVarO.b & 8192) != 0) {
                    long j = efVarO.m;
                    com.google.android.libraries.navigation.internal.agg.ez ezVarA = com.google.android.libraries.navigation.internal.px.ei.a(efVarO);
                    com.google.android.libraries.navigation.internal.agg.fa faVar = com.google.android.libraries.navigation.internal.agg.fd.a;
                    jN = hi.n(j, new com.google.android.libraries.navigation.internal.agg.fc(ezVarA), vVarK.d);
                } else {
                    jN = -1;
                }
                this.b = jN;
            }
        }
        if (jN == -1) {
            return false;
        }
        com.google.android.libraries.geo.mapcore.internal.model.bd bdVar = vVarK.d;
        List list = ekVar.o().q;
        List list2 = (List) bdVar.b.b.p((int) jN);
        if (list2 == null) {
            if (list.isEmpty()) {
                return false;
            }
            return com.google.android.libraries.geo.mapcore.internal.model.f.a(list, agVar);
        }
        if (!list2.isEmpty()) {
            if (list.isEmpty()) {
                list = list2;
            } else {
                ArrayList arrayList = new ArrayList(list2.size() + list.size());
                com.google.android.libraries.navigation.internal.yz.gz gzVarI = com.google.android.libraries.navigation.internal.yz.hb.i(list2.iterator());
                com.google.android.libraries.navigation.internal.yz.gz gzVarI2 = com.google.android.libraries.navigation.internal.yz.hb.i(list.iterator());
                while (gzVarI.hasNext() && gzVarI2.hasNext()) {
                    int iCompare = com.google.android.libraries.geo.mapcore.internal.model.f.a.compare((com.google.android.libraries.navigation.internal.adg.w) gzVarI.a(), (com.google.android.libraries.navigation.internal.adg.w) gzVarI2.a());
                    if (iCompare < 0) {
                        arrayList.add((com.google.android.libraries.navigation.internal.adg.w) gzVarI.next());
                    } else if (iCompare > 0) {
                        arrayList.add((com.google.android.libraries.navigation.internal.adg.w) gzVarI2.next());
                    } else {
                        arrayList.add((com.google.android.libraries.navigation.internal.adg.w) gzVarI.next());
                        gzVarI2.next();
                    }
                }
                com.google.android.libraries.navigation.internal.yz.hb.f(arrayList, gzVarI);
                com.google.android.libraries.navigation.internal.yz.hb.f(arrayList, gzVarI2);
                list = arrayList;
            }
        }
        return com.google.android.libraries.geo.mapcore.internal.model.f.a(list, agVar);
    }
}
