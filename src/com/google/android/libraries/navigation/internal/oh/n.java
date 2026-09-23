package com.google.android.libraries.navigation.internal.oh;

import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.qk.s;
import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n {
    public static final float a(com.google.android.libraries.navigation.internal.qa.a aVar, com.google.android.libraries.navigation.internal.qa.a aVar2) {
        if (aVar.f(aVar2)) {
            float f = aVar.a;
            float f2 = aVar2.a;
            if (f <= f2 && aVar.b <= aVar2.b && aVar.c >= aVar2.c && aVar.d >= aVar2.d) {
                return 1.0f;
            }
            float fMax = Math.max(f2, f);
            float fMin = Math.min(aVar2.c, aVar.c);
            float f3 = fMin - fMax;
            float fMin2 = Math.min(aVar2.d, aVar.d) - Math.max(aVar2.b, aVar.b);
            if (f3 >= 0.0f && fMin2 >= 0.0f) {
                return (fMin2 * f3) / (aVar2.a() * aVar2.b());
            }
        }
        return 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean b(com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.qk.q qVar, a aVar, x xVar, com.google.android.libraries.navigation.internal.qk.p pVar, s sVar) {
        com.google.android.libraries.navigation.internal.op.l lVarA;
        ev evVar = qVar.f;
        int size = evVar.size();
        com.google.android.libraries.navigation.internal.adg.b bVar = null;
        float f = 0.0f;
        for (int i = 0; i < size; i++) {
            com.google.android.libraries.navigation.internal.adg.b bVar2 = (com.google.android.libraries.navigation.internal.adg.b) evVar.get(i);
            float fA = aVar.a(gVar, qVar, xVar, bVar2, sVar);
            if (fA > f) {
                bVar = bVar2;
            }
            if (fA > f) {
                f = fA;
            }
        }
        if (f <= 0.0f || bVar == null || (lVarA = qVar.i.a(qVar.h, gVar, xVar, bVar)) == null) {
            return false;
        }
        com.google.android.libraries.navigation.internal.op.d dVar = (com.google.android.libraries.navigation.internal.op.d) lVarA;
        qVar.e.b(qVar.a, new com.google.android.libraries.navigation.internal.qa.a(dVar.a, dVar.b, dVar.c, dVar.d));
        pVar.a(xVar);
        pVar.b = bVar;
        if (sVar == null) {
            return true;
        }
        sVar.b(xVar, bVar);
        return true;
    }
}
