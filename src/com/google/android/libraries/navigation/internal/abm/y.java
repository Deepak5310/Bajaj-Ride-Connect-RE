package com.google.android.libraries.navigation.internal.abm;

import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.fw;
import java.io.IOException;
import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y {
    public static final Comparator a = new Comparator() { // from class: com.google.android.libraries.navigation.internal.abm.w
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((y) obj2).d.compareTo(((y) obj).d);
        }
    };
    public static final Comparator b = new Comparator() { // from class: com.google.android.libraries.navigation.internal.abm.x
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            y yVar = (y) obj;
            y yVar2 = (y) obj2;
            int iCompare = Integer.compare(yVar2.f, yVar.f);
            return (iCompare == 0 && (iCompare = Float.compare(yVar.h, yVar2.h)) == 0) ? yVar2.d.compareTo(yVar.d) : iCompare;
        }
    };
    private static final com.google.android.libraries.navigation.internal.oe.o i = new com.google.android.libraries.navigation.internal.oe.v();
    final com.google.android.libraries.navigation.internal.ol.at c;
    final String d;
    final int f;
    final com.google.android.libraries.navigation.internal.oe.x g;
    boolean e = false;
    float h = 0.0f;

    public y(com.google.android.libraries.navigation.internal.ol.at atVar) {
        com.google.android.libraries.navigation.internal.oe.x xVar;
        this.c = atVar;
        ef efVar = (ef) atVar.b().n();
        this.f = efVar.o ^ Integer.MIN_VALUE;
        com.google.android.libraries.navigation.internal.adg.d dVar = efVar.e;
        dVar = dVar == null ? com.google.android.libraries.navigation.internal.adg.d.a : dVar;
        com.google.android.libraries.navigation.internal.abf.s.j(dVar);
        com.google.android.libraries.navigation.internal.adg.h hVar = dVar.c;
        hVar = hVar == null ? com.google.android.libraries.navigation.internal.adg.h.a : hVar;
        com.google.android.libraries.navigation.internal.abf.s.j(hVar);
        com.google.android.libraries.navigation.internal.ael.x xVar2 = hVar.c;
        com.google.android.libraries.navigation.internal.abf.s.j(xVar2);
        try {
            xVar = i.g(xVar2);
        } catch (IOException unused) {
            xVar = new com.google.android.libraries.navigation.internal.oe.x(0, 0);
        }
        this.g = xVar;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.U);
        efVar.h(bhVarS);
        Object objK = efVar.w.k(bhVarS.d);
        this.d = ((fw) (objK == null ? bhVarS.b : bhVarS.c(objK))).c;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.abf.aj ajVarF = com.google.android.libraries.navigation.internal.abf.aj.f(this);
        ajVarF.g("pickObject", this.c);
        com.google.android.libraries.navigation.internal.abf.aj ajVarC = ajVarF.c("zWithinGrade", this.f);
        ajVarC.g("featureLocation", this.g);
        ajVarC.g("featureId", this.d);
        return ajVarC.b("squaredDistanceToPickLocation", this.h).e("hasBeenSelectedThisCycle", this.e).toString();
    }
}
