package com.google.android.libraries.navigation.internal.px;

import com.google.android.libraries.navigation.internal.adg.gq;
import com.google.android.libraries.navigation.internal.agi.ia;
import com.google.android.libraries.navigation.internal.agi.iq;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ch implements Comparator {
    private final ia a;

    public ch(List list, com.google.android.libraries.navigation.internal.yx.as asVar) {
        this.a = new iq(list.size());
        com.google.android.libraries.navigation.internal.agh.bu buVar = new com.google.android.libraries.navigation.internal.agh.bu();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ek ekVar = (ek) it2.next();
            if (asVar.a(ekVar)) {
                long jE = ekVar.e();
                if (!buVar.d(jE) || buVar.s(jE) < ekVar.o().i) {
                    buVar.a(jE, ekVar.o().i);
                }
            }
        }
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            ek ekVar2 = (ek) it3.next();
            int iS = ekVar2.o().i;
            if (ekVar2.B() && buVar.d(ekVar2.e())) {
                iS = buVar.s(ekVar2.e());
            }
            this.a.a(ekVar2, iS);
        }
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        int iN;
        int iN2;
        int iN3;
        int iN4;
        ek ekVar = (ek) obj;
        ek ekVar2 = (ek) obj2;
        com.google.android.libraries.navigation.internal.yz.ck ckVarE = com.google.android.libraries.navigation.internal.yz.ck.b.g(ekVar.an(), ekVar2.an()).g(ekVar.al(), ekVar2.al()).g(ekVar.am(), ekVar2.am()).c(this.a.o(ekVar), this.a.o(ekVar2)).g(ekVar.B(), ekVar2.B()).c(ekVar.o().o, ekVar2.o().o).e(ekVar.f(), ekVar2.f());
        com.google.android.libraries.navigation.internal.adg.d dVar = ekVar.o().e;
        if (dVar == null) {
            dVar = com.google.android.libraries.navigation.internal.adg.d.a;
        }
        if (dVar.H()) {
            iN = dVar.n();
        } else {
            int iN5 = dVar.ak;
            if (iN5 == 0) {
                iN5 = dVar.n();
                dVar.ak = iN5;
            }
            iN = iN5;
        }
        com.google.android.libraries.navigation.internal.adg.d dVar2 = ekVar2.o().e;
        if (dVar2 == null) {
            dVar2 = com.google.android.libraries.navigation.internal.adg.d.a;
        }
        if (dVar2.H()) {
            iN2 = dVar2.n();
        } else {
            int iN6 = dVar2.ak;
            if (iN6 == 0) {
                iN6 = dVar2.n();
                dVar2.ak = iN6;
            }
            iN2 = iN6;
        }
        com.google.android.libraries.navigation.internal.yz.ck ckVarC = ckVarE.c(iN, iN2);
        gq gqVar = ekVar.o().f;
        if (gqVar == null) {
            gqVar = gq.a;
        }
        if (gqVar.H()) {
            iN3 = gqVar.n();
        } else {
            int iN7 = gqVar.ak;
            if (iN7 == 0) {
                iN7 = gqVar.n();
                gqVar.ak = iN7;
            }
            iN3 = iN7;
        }
        gq gqVar2 = ekVar2.o().f;
        if (gqVar2 == null) {
            gqVar2 = gq.a;
        }
        if (gqVar2.H()) {
            iN4 = gqVar2.n();
        } else {
            int iN8 = gqVar2.ak;
            if (iN8 == 0) {
                iN8 = gqVar2.n();
                gqVar2.ak = iN8;
            }
            iN4 = iN8;
        }
        return ckVarC.c(iN3, iN4).g(ekVar.C(), ekVar2.C()).c(ekVar.hashCode(), ekVar2.hashCode()).a();
    }
}
