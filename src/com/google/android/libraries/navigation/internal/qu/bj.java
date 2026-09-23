package com.google.android.libraries.navigation.internal.qu;

import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.kc;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bj {
    public final fd a;
    public final String b;
    public final com.google.android.libraries.navigation.internal.zy.e c;
    public final fd d;
    public final int e;
    public final com.google.android.libraries.navigation.internal.adi.c f;
    public Map g = new HashMap();

    public bj(com.google.android.libraries.navigation.internal.adi.d dVar) {
        int iN;
        com.google.android.libraries.navigation.internal.adi.c cVarB = com.google.android.libraries.navigation.internal.adi.c.b(dVar.d);
        this.f = cVarB == null ? com.google.android.libraries.navigation.internal.adi.c.MULTIZOOM_STYLE_TABLE : cVarB;
        EnumMap enumMap = new EnumMap(com.google.android.libraries.geo.mapcore.internal.model.aq.class);
        for (int i = 0; i < dVar.c.size(); i++) {
            com.google.android.libraries.navigation.internal.adi.bp bpVar = (com.google.android.libraries.navigation.internal.adi.bp) dVar.c.get(i);
            com.google.android.libraries.navigation.internal.adi.bo boVarB = com.google.android.libraries.navigation.internal.adi.bo.b(bpVar.c);
            int i2 = (boVarB == null ? com.google.android.libraries.navigation.internal.adi.bo.UNKNOWN : boVarB).ab;
            int length = bl.a.length;
            com.google.android.libraries.geo.mapcore.internal.model.aq aqVar = bl.a[i2];
            if (aqVar != null && (bpVar.b & 2) != 0) {
                com.google.android.libraries.navigation.internal.yx.ar.q(aqVar);
                enumMap.put(aqVar, bpVar.d);
            }
        }
        this.a = kc.b(enumMap);
        this.b = dVar.e;
        com.google.android.libraries.navigation.internal.adi.l lVar = dVar.f;
        com.google.android.libraries.navigation.internal.ael.bq bqVar = (lVar == null ? com.google.android.libraries.navigation.internal.adi.l.a : lVar).b;
        com.google.android.libraries.navigation.internal.zy.e eVar = com.google.android.libraries.navigation.internal.zy.e.a;
        this.c = bqVar.isEmpty() ? com.google.android.libraries.navigation.internal.zy.e.a : new com.google.android.libraries.navigation.internal.zy.e(com.google.android.libraries.navigation.internal.zy.i.f(bqVar));
        if (dVar.H()) {
            iN = dVar.n();
        } else {
            iN = dVar.ak;
            if (iN == 0) {
                iN = dVar.n();
                dVar.ak = iN;
            }
        }
        this.e = iN;
        ez ezVar = new ez();
        com.google.android.libraries.navigation.internal.adi.l lVar2 = dVar.f;
        for (com.google.android.libraries.navigation.internal.adi.j jVar : (lVar2 == null ? com.google.android.libraries.navigation.internal.adi.l.a : lVar2).c) {
            ezVar.f(Integer.valueOf(jVar.c), Integer.valueOf(jVar.d));
        }
        this.d = ezVar.d();
    }
}
