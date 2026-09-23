package com.google.android.libraries.navigation.internal.cl;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class az implements com.google.android.libraries.navigation.internal.qk.r {
    private final boolean a;
    private final com.google.android.libraries.navigation.internal.oh.a b;
    private final aw c;

    public az(boolean z, aw awVar, List list, aq aqVar, p pVar) {
        this.a = z;
        this.c = awVar;
        com.google.android.libraries.navigation.internal.oh.g gVar = new com.google.android.libraries.navigation.internal.oh.g(awVar.c, list, 10.0f, 0.3f);
        com.google.android.libraries.navigation.internal.oh.p.a aVar = new com.google.android.libraries.navigation.internal.oh.p.a();
        aVar.c(new com.google.android.libraries.navigation.internal.oh.l());
        aVar.c(new com.google.android.libraries.navigation.internal.oh.k());
        aVar.c(new com.google.android.libraries.navigation.internal.oh.f());
        aVar.c(aqVar);
        aVar.b(0, new com.google.android.libraries.navigation.internal.oh.j(), 0.5f);
        aVar.b(85, gVar, 0.99f);
        aVar.c(pVar);
        aVar.e(10, new com.google.android.libraries.navigation.internal.oh.e());
        aVar.e(5, new com.google.android.libraries.navigation.internal.oh.d());
        if (awVar.d) {
            aVar.b(10, new com.google.android.libraries.navigation.internal.oh.b(), 0.5f);
        } else {
            aVar.c(new com.google.android.libraries.navigation.internal.oh.b());
        }
        this.b = aVar.a();
    }

    public static az c(aw awVar, aq aqVar, boolean z) {
        int i = ev.d;
        return new az(z, awVar, lv.a, aqVar, p.a);
    }

    private static void d(com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.adg.b bVar, com.google.android.libraries.navigation.internal.qk.s sVar) {
        if (sVar == null || xVar == null) {
            return;
        }
        sVar.b(xVar, bVar);
    }

    private final boolean e(com.google.android.libraries.navigation.internal.qk.q qVar, com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.adg.b bVar, com.google.android.libraries.navigation.internal.qk.p pVar) {
        com.google.android.libraries.navigation.internal.op.l lVarA;
        if (qVar.h.f(xVar) == null || (lVarA = qVar.i.a(qVar.h, gVar, xVar, bVar)) == null) {
            return false;
        }
        com.google.android.libraries.navigation.internal.op.d dVar = (com.google.android.libraries.navigation.internal.op.d) lVarA;
        qVar.e.b(qVar.a, new com.google.android.libraries.navigation.internal.qa.a(dVar.a, dVar.b, dVar.c, dVar.d));
        if (this.a) {
            qVar.e.b.add(this.c.c);
        }
        pVar.a(xVar);
        pVar.b = bVar;
        this.c.e = Float.valueOf(((com.google.android.libraries.navigation.internal.oq.b) qVar.h.g()).e);
        return true;
    }

    private final boolean f(com.google.android.libraries.navigation.internal.rf.g gVar) {
        Float f = this.c.e;
        return f != null && f.floatValue() - ((com.google.android.libraries.navigation.internal.oq.b) gVar.g()).e >= 2.0f;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.r
    public final boolean a(com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.qk.q qVar, com.google.android.libraries.navigation.internal.qk.p pVar) {
        return b(gVar, qVar, pVar, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.qk.r
    public final boolean b(com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.qk.q qVar, com.google.android.libraries.navigation.internal.qk.p pVar, com.google.android.libraries.navigation.internal.qk.s sVar) {
        com.google.android.libraries.navigation.internal.oe.x xVarA;
        int i;
        if (!f(qVar.h)) {
            com.google.android.libraries.navigation.internal.oe.x xVarA2 = qVar.a();
            com.google.android.libraries.navigation.internal.adg.b bVar = qVar.d;
            if (xVarA2 != null) {
                float fA = this.b.a(gVar, qVar, xVarA2, bVar, sVar);
                d(xVarA2, bVar, sVar);
                if (fA > 0.8f && e(qVar, gVar, xVarA2, bVar, pVar)) {
                    return true;
                }
            }
        }
        if (!f(qVar.h) && (xVarA = qVar.a()) != null) {
            com.google.android.libraries.navigation.internal.adg.b bVar2 = qVar.d;
            ev evVar = qVar.f;
            int size = evVar.size();
            com.google.android.libraries.navigation.internal.adg.b bVar3 = bVar2;
            float f = 0.0f;
            int i2 = 0;
            while (i2 < size) {
                com.google.android.libraries.navigation.internal.adg.b bVar4 = (com.google.android.libraries.navigation.internal.adg.b) evVar.get(i2);
                if (bVar4 != qVar.d) {
                    i = i2;
                    float fA2 = this.b.a(gVar, qVar, xVarA, bVar4, sVar);
                    if (fA2 > f) {
                        bVar3 = bVar4;
                    }
                    if (fA2 > f) {
                        f = fA2;
                    }
                } else {
                    i = i2;
                }
                i2 = i + 1;
            }
            d(xVarA, bVar3, sVar);
            if (f > 0.8f && e(qVar, gVar, xVarA, bVar3, pVar)) {
                return true;
            }
        }
        com.google.android.libraries.navigation.internal.oe.x xVarA3 = qVar.a();
        com.google.android.libraries.navigation.internal.adg.b bVar5 = qVar.d;
        ay ayVar = new ay(qVar.h, this.c.c, bVar5, qVar.f);
        com.google.android.libraries.navigation.internal.oe.x xVar = xVarA3;
        com.google.android.libraries.navigation.internal.adg.b bVar6 = bVar5;
        float f2 = 0.0f;
        while (ayVar.hasNext()) {
            ax next = ayVar.next();
            float fA3 = this.b.a(gVar, qVar, next.a, next.b, sVar);
            if (fA3 > f2) {
                xVar = next.a;
                bVar6 = next.b;
                if (fA3 > 0.8f) {
                    d(xVar, bVar6, sVar);
                    return e(qVar, gVar, xVar, bVar6, pVar);
                }
                f2 = fA3;
            }
        }
        d(xVar, bVar6, sVar);
        if (f2 <= 0.0f) {
            return false;
        }
        com.google.android.libraries.navigation.internal.yx.ar.q(xVar);
        return e(qVar, gVar, xVar, bVar6, pVar);
    }
}
