package com.google.android.libraries.navigation.internal.px;

import android.util.SparseArray;
import com.google.android.libraries.navigation.internal.adg.hg;
import com.google.android.libraries.navigation.internal.adg.ho;
import com.google.android.libraries.navigation.internal.agh.ez;
import com.google.android.libraries.navigation.internal.agh.fp;
import com.google.android.libraries.navigation.internal.agh.hd;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bd {
    public final ez a = new fp();
    public final List b = new ArrayList();
    public final f c;
    public final j d;
    public final com.google.android.libraries.navigation.internal.qc.f e;
    public final int f;
    public final boolean g;

    public bd(j jVar, f fVar, com.google.android.libraries.navigation.internal.qc.f fVar2, com.google.android.libraries.navigation.internal.agg.ez ezVar, Set set, int i, boolean z) {
        this.c = fVar;
        this.d = jVar;
        this.e = fVar2;
        this.f = i;
        this.g = z;
        hd hdVar = new hd(fVar.b.a.h + ((lv) fVar.a).c);
        e eVar = new e(fVar);
        while (eVar.hasNext()) {
            hg next = eVar.next();
            int i2 = eVar.a;
            com.google.android.libraries.navigation.internal.adg.df dfVar = next.d;
            if (!set.contains(Integer.valueOf((dfVar == null ? com.google.android.libraries.navigation.internal.adg.df.a : dfVar).c)) && com.google.android.libraries.navigation.internal.pa.a.c(next, ezVar)) {
                float fD = com.google.android.libraries.geo.mapcore.internal.model.ay.d(i2, next.k);
                float fB = com.google.android.libraries.geo.mapcore.internal.model.ay.b(i2, next.l);
                float f = i;
                if (fD <= f && f < fB) {
                    long j = next.f;
                    if (j == 0 || hdVar.c(j)) {
                        ho hoVar = next.c;
                        if (((hoVar == null ? ho.a : hoVar).b & 1) != 0) {
                            ho hoVar2 = next.c;
                            long j2 = (hoVar2 == null ? ho.a : hoVar2).c;
                            SparseArray sparseArray = (SparseArray) this.a.h(j2);
                            if (sparseArray == null) {
                                SparseArray sparseArray2 = new SparseArray();
                                com.google.android.libraries.navigation.internal.adg.df dfVar2 = next.d;
                                sparseArray2.put((dfVar2 == null ? com.google.android.libraries.navigation.internal.adg.df.a : dfVar2).c, next);
                                this.a.a(j2, sparseArray2);
                            } else {
                                a(fVar, sparseArray, next);
                            }
                        } else {
                            ho hoVar3 = next.c;
                            if (((hoVar3 == null ? ho.a : hoVar3).b & 2) != 0) {
                                this.b.add(next);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void a(f fVar, SparseArray sparseArray, hg hgVar) {
        com.google.android.libraries.navigation.internal.adg.df dfVar = hgVar.d;
        if (dfVar == null) {
            dfVar = com.google.android.libraries.navigation.internal.adg.df.a;
        }
        int i = dfVar.c;
        hg hgVar2 = (hg) sparseArray.get(i);
        if (hgVar2 != null) {
            float fD = com.google.android.libraries.geo.mapcore.internal.model.ay.d(fVar.a(hgVar2), hgVar2.k);
            float fD2 = com.google.android.libraries.geo.mapcore.internal.model.ay.d(fVar.a(hgVar), hgVar.k);
            com.google.android.libraries.navigation.internal.yz.ck ckVar = com.google.android.libraries.navigation.internal.yz.ck.b;
            ho hoVar = hgVar2.c;
            if (hoVar == null) {
                hoVar = ho.a;
            }
            int i2 = hoVar.b & 1;
            ho hoVar2 = hgVar.c;
            if (hoVar2 == null) {
                hoVar2 = ho.a;
            }
            if (ckVar.g(1 == i2, 1 == (hoVar2.b & 1)).c(hgVar2.g, hgVar.g).b(fD, fD2).d(hgVar2.f, hgVar.f).a() >= 0) {
                return;
            }
        }
        sparseArray.put(i, hgVar);
    }
}
