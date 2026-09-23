package com.google.android.libraries.navigation.internal.wf;

import com.google.android.libraries.navigation.internal.add.ba;
import com.google.android.libraries.navigation.internal.add.bb;
import com.google.android.libraries.navigation.internal.adq.ab;
import com.google.android.libraries.navigation.internal.adq.z;
import com.google.android.libraries.navigation.internal.adr.aj;
import com.google.android.libraries.navigation.internal.adr.gn;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.oe.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k {
    public static com.google.android.libraries.navigation.internal.afj.b a(x xVar) {
        com.google.android.libraries.navigation.internal.afj.a aVar = (com.google.android.libraries.navigation.internal.afj.a) com.google.android.libraries.navigation.internal.afj.b.a.q();
        double dB = xVar.b();
        if (!aVar.b.H()) {
            aVar.v();
        }
        ((com.google.android.libraries.navigation.internal.afj.b) aVar.b).b = dB;
        double d = xVar.d();
        if (!aVar.b.H()) {
            aVar.v();
        }
        ((com.google.android.libraries.navigation.internal.afj.b) aVar.b).c = d;
        return (com.google.android.libraries.navigation.internal.afj.b) aVar.t();
    }

    public static List b(bg bgVar, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        double d = i2 + i;
        int iG = bgVar.g(d);
        for (int iH = bgVar.h(i); iH <= iG; iH++) {
            arrayList.add(a((x) bgVar.N().get(iH)));
        }
        return arrayList;
    }

    public static List c(ab abVar) {
        ArrayList arrayList = new ArrayList();
        com.google.android.libraries.navigation.internal.afj.a aVar = (com.google.android.libraries.navigation.internal.afj.a) com.google.android.libraries.navigation.internal.afj.b.a.q();
        z zVar = abVar.b;
        if (zVar == null) {
            zVar = z.a;
        }
        double d = zVar.c;
        if (!aVar.b.H()) {
            aVar.v();
        }
        ((com.google.android.libraries.navigation.internal.afj.b) aVar.b).b = d;
        z zVar2 = abVar.b;
        if (zVar2 == null) {
            zVar2 = z.a;
        }
        double d2 = zVar2.d;
        if (!aVar.b.H()) {
            aVar.v();
        }
        ((com.google.android.libraries.navigation.internal.afj.b) aVar.b).c = d2;
        arrayList.add((com.google.android.libraries.navigation.internal.afj.b) aVar.t());
        com.google.android.libraries.navigation.internal.afj.a aVar2 = (com.google.android.libraries.navigation.internal.afj.a) com.google.android.libraries.navigation.internal.afj.b.a.q();
        z zVar3 = abVar.c;
        if (zVar3 == null) {
            zVar3 = z.a;
        }
        double d3 = zVar3.c;
        if (!aVar2.b.H()) {
            aVar2.v();
        }
        ((com.google.android.libraries.navigation.internal.afj.b) aVar2.b).b = d3;
        z zVar4 = abVar.c;
        if (zVar4 == null) {
            zVar4 = z.a;
        }
        double d4 = zVar4.d;
        if (!aVar2.b.H()) {
            aVar2.v();
        }
        ((com.google.android.libraries.navigation.internal.afj.b) aVar2.b).c = d4;
        arrayList.add((com.google.android.libraries.navigation.internal.afj.b) aVar2.t());
        return arrayList;
    }

    public static List d(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            aj ajVar = ((gn) it2.next()).d;
            if (ajVar == null) {
                ajVar = aj.a;
            }
            arrayList.add(ajVar.c);
        }
        return arrayList;
    }

    public static bb e(List list, final int i) {
        String str = (String) list.stream().filter(new Predicate() { // from class: com.google.android.libraries.navigation.internal.wf.j
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                int iA = com.google.android.libraries.navigation.internal.adr.m.a(((com.google.android.libraries.navigation.internal.adr.n) obj).d);
                if (iA == 0) {
                    iA = com.google.android.libraries.navigation.internal.adr.m.a;
                }
                return iA == i;
            }
        }).map(new i()).findFirst().orElse("");
        if (str.isEmpty()) {
            return null;
        }
        ba baVar = (ba) bb.a.q();
        if (!baVar.b.H()) {
            baVar.v();
        }
        bb bbVar = (bb) baVar.b;
        str.getClass();
        bbVar.b = str;
        return (bb) baVar.t();
    }
}
