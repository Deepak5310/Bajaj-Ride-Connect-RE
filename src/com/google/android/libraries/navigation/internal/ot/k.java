package com.google.android.libraries.navigation.internal.ot;

import com.google.android.libraries.navigation.internal.adg.bj;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adl.an;
import com.google.android.libraries.navigation.internal.adl.ao;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.yx.as;
import com.google.android.libraries.navigation.internal.yz.fy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class k {
    static /* synthetic */ boolean d(fy fyVar, ef efVar) {
        bh bhVarS = bi.s(bj.J);
        efVar.h(bhVarS);
        Object objK = efVar.w.k(bhVarS.d);
        long j = ((com.google.android.libraries.navigation.internal.aff.b) (objK == null ? bhVarS.b : bhVarS.c(objK))).c;
        return j != 0 && fyVar.contains(Long.valueOf(j));
    }

    public abstract as a();

    public abstract ao b();

    public static k c(ao aoVar) {
        as asVar;
        int iA = an.a(aoVar.b);
        int i = iA - 1;
        if (iA == 0) {
            throw null;
        }
        if (i != 4) {
            int i2 = aoVar.b;
            asVar = new as() { // from class: com.google.android.libraries.navigation.internal.ot.j
                @Override // com.google.android.libraries.navigation.internal.yx.as
                public final boolean a(Object obj) {
                    return false;
                }
            };
        } else {
            final fy fyVarO = fy.o((aoVar.b == 5 ? (com.google.android.libraries.navigation.internal.adl.o) aoVar.c : com.google.android.libraries.navigation.internal.adl.o.a).b);
            asVar = new as() { // from class: com.google.android.libraries.navigation.internal.ot.i
                @Override // com.google.android.libraries.navigation.internal.yx.as
                public final boolean a(Object obj) {
                    return k.d(fyVarO, (ef) obj);
                }
            };
        }
        return new c(asVar, aoVar);
    }
}
