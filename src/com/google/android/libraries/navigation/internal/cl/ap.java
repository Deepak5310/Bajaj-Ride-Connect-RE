package com.google.android.libraries.navigation.internal.cl;

import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ap implements com.google.android.libraries.navigation.internal.oh.a {
    private final ev a;
    private final bq b;
    private final com.google.android.libraries.navigation.internal.qa.a c = new com.google.android.libraries.navigation.internal.qa.a(0.0f, 0.0f, 0.0f, 0.0f);

    public ap(ev evVar, bq bqVar) {
        this.a = evVar;
        this.b = bqVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.oh.a
    public final float a(com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.qk.q qVar, com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.adg.b bVar, com.google.android.libraries.navigation.internal.qk.s sVar) {
        float f;
        com.google.android.libraries.navigation.internal.oe.ay ayVarF;
        com.google.android.libraries.navigation.internal.op.l lVarA = qVar.i.a(qVar.h, gVar, xVar, bVar);
        if (lVarA == null) {
            f = 0.5f;
        } else {
            com.google.android.libraries.navigation.internal.op.d dVar = (com.google.android.libraries.navigation.internal.op.d) lVarA;
            this.c.d(dVar.a, dVar.b, dVar.c, dVar.d);
            ev evVar = this.a;
            int i = 0;
            for (int i2 = 0; i2 < ((lv) evVar).c; i2++) {
                bq bqVar = (bq) evVar.get(i2);
                com.google.android.libraries.navigation.internal.oe.x xVar2 = bqVar.c;
                if (!bqVar.equals(this.b) && (ayVarF = qVar.h.f(xVar2)) != null && ((bqVar.d != com.google.android.libraries.navigation.internal.aap.l.MANEUVER_UNKNOWN || bqVar.p.toString().trim().length() != 0) && this.c.e(ayVarF))) {
                    i++;
                }
            }
            f = this.a.isEmpty() ? 0.0f : i / ((lv) this.a).c;
        }
        if (sVar != null) {
            sVar.a(xVar, bVar, com.google.android.libraries.navigation.internal.b.b.h(f, "OverlapsStep:"));
        }
        return f;
    }
}
