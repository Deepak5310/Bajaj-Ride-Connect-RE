package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.adg.ef;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ad {
    public static float a(cd cdVar) {
        int i;
        com.google.android.libraries.navigation.internal.pt.d dVar = cdVar.d;
        float f = 0.0f;
        if (dVar != null && (i = dVar.c) != Integer.MIN_VALUE) {
            if (i > 0) {
                f = 3.0f;
            } else if (i < 0) {
                f = -3.0f;
            }
        }
        return f * ((float) cdVar.d().a.e());
    }

    public static void b(ef efVar, c cVar) {
        float f;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.W);
        efVar.h(bhVarS);
        if (efVar.w.n(bhVarS.d)) {
            com.google.android.libraries.navigation.internal.ael.bh bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.W);
            efVar.h(bhVarS2);
            Object objK = efVar.w.k(bhVarS2.d);
            com.google.android.libraries.navigation.internal.acw.j jVar = (com.google.android.libraries.navigation.internal.acw.j) (objK == null ? bhVarS2.b : bhVarS2.c(objK));
            if (jVar.b.size() > 0) {
                int i = ((com.google.android.libraries.navigation.internal.acw.h) jVar.b.get(0)).d;
                if (i > 0) {
                    f = 3.0f;
                } else {
                    f = i < 0 ? -3.0f : 0.0f;
                }
                com.google.android.libraries.navigation.internal.oe.x xVar = cVar.a;
                xVar.c = (int) (xVar.e() * ((double) f));
            }
        }
    }
}
