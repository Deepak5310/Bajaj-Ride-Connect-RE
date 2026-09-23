package com.google.android.libraries.navigation.internal.ck;

import com.google.android.libraries.navigation.internal.adg.ex;
import com.google.android.libraries.navigation.internal.adr.im;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class bl {
    public static void a(Map map, int i, bn bnVar) {
        Integer numValueOf = Integer.valueOf(i);
        if (!map.containsKey(numValueOf)) {
            map.put(numValueOf, bnVar);
            return;
        }
        bn bnVar2 = (bn) map.get(numValueOf);
        com.google.android.libraries.navigation.internal.yx.ar.q(bnVar2);
        f fVar = (f) bnVar;
        com.google.android.libraries.navigation.internal.yx.an anVarA = fVar.a.a(bnVar2.a());
        if (fVar.a.g() && bnVar2.a().g()) {
            if (fVar.a.c() != im.UNKNOWN_STYLE) {
                anVarA = fVar.a;
            } else if (bnVar2.a().c() != im.UNKNOWN_STYLE) {
                anVarA = bnVar2.a();
            }
        }
        ex exVarC = fVar.b;
        if (exVarC == null) {
            exVarC = bnVar2.c();
        }
        if (fVar.b != null && bnVar2.c() != null) {
            if (fVar.b != ex.LEGEND_STYLE_UNDEFINED) {
                exVarC = fVar.b;
            } else if (bnVar2.c() != ex.LEGEND_STYLE_UNDEFINED) {
                exVarC = bnVar2.c();
            }
        }
        ex exVarB = fVar.c;
        if (exVarB == null) {
            exVarB = bnVar2.b();
        }
        e eVar = new e();
        eVar.b(anVarA);
        eVar.a = exVarC;
        eVar.b = exVarB;
        map.put(numValueOf, eVar.a());
    }
}
