package com.google.android.libraries.navigation.internal.bm;

import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.po.Cdo;
import com.google.android.libraries.navigation.internal.po.fk;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ac implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ com.google.android.libraries.navigation.internal.bt.h a;
    final /* synthetic */ am b;

    public ac(am amVar, com.google.android.libraries.navigation.internal.bt.h hVar) {
        this.a = hVar;
        this.b = amVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        boolean z;
        int iN;
        List<al> list = (List) obj;
        com.google.android.libraries.navigation.internal.nj.i.b();
        am amVar = this.b;
        Cdo cdo = ((fk) amVar.i.b()).G;
        synchronized (amVar.U) {
            if (this.a == amVar.V.a) {
                amVar.f();
                for (al alVar : list) {
                    com.google.android.libraries.navigation.internal.nj.i.b();
                    ev evVarB = alVar.b();
                    int size = evVarB.size();
                    for (int i = 0; i < size; i++) {
                        com.google.android.libraries.navigation.internal.ol.p pVar = (com.google.android.libraries.navigation.internal.ol.p) evVarB.get(i);
                        cdo.at(pVar);
                        amVar.A.add(pVar);
                    }
                    amVar.B.add(alVar);
                }
                z = true;
            } else {
                for (al alVar2 : list) {
                    com.google.android.libraries.navigation.internal.ol.ax axVar = (com.google.android.libraries.navigation.internal.ol.ax) amVar.w.a();
                    ev evVarB2 = alVar2.b();
                    int size2 = evVarB2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        cdo.c((com.google.android.libraries.navigation.internal.ol.p) evVarB2.get(i2));
                    }
                    alVar2.d().d(null);
                    alVar2.a().e(axVar);
                }
                z = false;
            }
        }
        if (z) {
            for (al alVar3 : list) {
                if (alVar3.g()) {
                    ev evVarC = alVar3.c();
                    List<com.google.android.libraries.navigation.internal.ol.p> list2 = (List) amVar.R.get(evVarC);
                    if (list2 != null) {
                        for (com.google.android.libraries.navigation.internal.ol.p pVar2 : list2) {
                            cdo.e(pVar2);
                            cdo.c(pVar2);
                        }
                    }
                    amVar.R.put(evVarC, alVar3.b());
                }
                ev evVarB3 = alVar3.b();
                int size3 = evVarB3.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    com.google.android.libraries.navigation.internal.ol.p pVar3 = (com.google.android.libraries.navigation.internal.ol.p) evVarB3.get(i3);
                    com.google.android.libraries.navigation.internal.jy.r rVarD = amVar.E.d();
                    com.google.android.libraries.navigation.internal.zb.j jVar = com.google.android.libraries.navigation.internal.jy.aa.a;
                    com.google.android.libraries.navigation.internal.jy.x xVar = new com.google.android.libraries.navigation.internal.jy.x();
                    xVar.i = alVar3.f() ? com.google.android.libraries.navigation.internal.afe.o.v : com.google.android.libraries.navigation.internal.afe.o.w;
                    com.google.android.libraries.navigation.internal.jy.o oVarB = rVarD.b(xVar.a(alVar3.e()).b());
                    if (oVarB != null) {
                        ConcurrentHashMap concurrentHashMap = amVar.S;
                        bi biVar = (bi) pVar3.n();
                        if (biVar.H()) {
                            iN = biVar.n();
                        } else {
                            int iN2 = biVar.ak;
                            if (iN2 == 0) {
                                iN2 = biVar.n();
                                biVar.ak = iN2;
                            }
                            iN = iN2;
                        }
                        concurrentHashMap.put(Integer.valueOf(iN), oVarB);
                    }
                }
                alVar3.d().d(null);
                if (!amVar.Z) {
                    amVar.Z = true;
                }
            }
        }
    }
}
