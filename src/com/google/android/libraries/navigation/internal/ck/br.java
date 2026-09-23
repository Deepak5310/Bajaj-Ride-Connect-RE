package com.google.android.libraries.navigation.internal.ck;

import com.google.android.libraries.navigation.internal.adg.cz;
import com.google.android.libraries.navigation.internal.adg.ff;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.ToIntFunction;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class br extends ax {
    private static final com.google.android.libraries.navigation.internal.cq.ac a;
    private final com.google.android.libraries.navigation.internal.on.h b;
    private final bs c;
    private final k d;

    static {
        com.google.android.libraries.navigation.internal.cq.e eVar = new com.google.android.libraries.navigation.internal.cq.e();
        eVar.c("");
        eVar.e(0);
        eVar.d(0);
        eVar.b(com.google.android.libraries.navigation.internal.cq.k.UNKNOWN);
        a = eVar.a();
    }

    public br(bs bsVar, k kVar, com.google.android.libraries.navigation.internal.on.h hVar) {
        this.b = hVar;
        this.c = bsVar;
        this.d = kVar;
    }

    private final aw g(boolean z, com.google.android.libraries.navigation.internal.cq.ac acVar, int i) {
        return new aw(z ? this.c.d(acVar) : this.c.f(acVar), z ? this.c.c(acVar) : this.c.f(a), i);
    }

    @Override // com.google.android.libraries.navigation.internal.ck.ax
    protected final double a(com.google.android.libraries.navigation.internal.zk.e eVar, com.google.android.libraries.navigation.internal.zk.e eVar2) {
        return eVar.c(eVar2).a * 6371010.0d;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.ax
    protected final List c(be beVar, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        if (z2 && !z) {
            bs bsVar = this.c;
            com.google.android.libraries.navigation.internal.cq.ac acVar = a;
            arrayList.add(new aw(bsVar.e(acVar), this.c.e(acVar), 0));
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(beVar.i);
        Collections.sort(arrayList2, Comparator.comparingInt(new ToIntFunction() { // from class: com.google.android.libraries.navigation.internal.ck.bq
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((com.google.android.libraries.navigation.internal.cq.ac) obj).b();
            }
        }));
        int size = arrayList2.size();
        int iB = 0;
        for (int i = 0; i < size; i++) {
            com.google.android.libraries.navigation.internal.cq.ac acVar2 = (com.google.android.libraries.navigation.internal.cq.ac) arrayList2.get(i);
            if (acVar2.b() >= iB) {
                if (acVar2.b() > iB) {
                    arrayList.add(g(z2, a, iB));
                }
                arrayList.add(g(z2, acVar2, acVar2.b()));
                iB = acVar2.b() + acVar2.a();
            }
        }
        arrayList.add(g(z2, a, iB));
        return arrayList;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cm
    public final void e(com.google.android.libraries.navigation.internal.ol.ax axVar) {
        ev evVarB = ((bw) this.c).a.b();
        int i = ((lv) evVarB).c;
        for (int i2 = 0; i2 < i; i2++) {
            axVar.j((com.google.android.libraries.navigation.internal.ol.aq) evVarB.get(i2));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cm
    public final List f(be beVar, boolean z, int i) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        d(beVar, z, arrayList, arrayList2, arrayList3, arrayList4);
        com.google.android.libraries.navigation.internal.yx.ar.l(!arrayList.isEmpty(), "At least one merged point must be provided.");
        arrayList.size();
        arrayList2.size();
        arrayList3.size();
        int i2 = beVar.j;
        float f = beVar.k;
        int[] iArrF = com.google.android.libraries.navigation.internal.zy.i.f(arrayList2);
        int i3 = beVar.j;
        int i4 = ff.b;
        int i5 = ff.b;
        int i6 = cz.a;
        List listF = this.b.f(arrayList, iArrF, arrayList3, arrayList4, z ? 1 : 0, i3, i4, i5, i6, beVar.k, i, av.d(i));
        Set setC = av.c(listF);
        if (setC.isEmpty()) {
            return listF;
        }
        com.google.android.libraries.navigation.internal.zb.j.a aVar = com.google.android.libraries.navigation.internal.zb.j.b;
        new au(String.format("[b/110101804] ClientLines are transparent. Falling back on hardcoded route polyline styles. styleIds=%s", setC));
        ((com.google.android.libraries.navigation.internal.zb.h) aVar.F(123)).o();
        Collections.fill(arrayList3, this.d.a(z));
        Iterator it2 = listF.iterator();
        while (it2.hasNext()) {
            this.b.c.c((com.google.android.libraries.navigation.internal.ol.p) it2.next());
        }
        com.google.android.libraries.navigation.internal.on.h hVar = this.b;
        int[] iArrF2 = com.google.android.libraries.navigation.internal.zy.i.f(arrayList2);
        int i7 = beVar.j;
        float f2 = beVar.k;
        int i8 = ff.b;
        return hVar.f(arrayList, iArrF2, arrayList3, arrayList4, z ? 1 : 0, i7, i8, i8, cz.a, f2, i, av.d(i));
    }
}
