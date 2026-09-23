package com.google.android.libraries.navigation.internal.oh;

import com.google.android.libraries.navigation.internal.oe.ay;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.qk.s;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class h implements a {
    private final com.google.android.libraries.navigation.internal.qa.a a = new com.google.android.libraries.navigation.internal.qa.a(0.0f, 0.0f, 0.0f, 0.0f);

    @Override // com.google.android.libraries.navigation.internal.oh.a
    public final float a(com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.qk.q qVar, x xVar, com.google.android.libraries.navigation.internal.adg.b bVar, s sVar) {
        float fB = b(gVar, qVar, xVar, bVar);
        if (sVar != null) {
            sVar.a(xVar, bVar, com.google.android.libraries.navigation.internal.b.b.h(fB, "OverlapsLocation:"));
        }
        return fB;
    }

    public final float b(com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.qk.q qVar, x xVar, com.google.android.libraries.navigation.internal.adg.b bVar) {
        ay ayVarF;
        x xVarD = d(qVar);
        if (xVarD == null || (ayVarF = qVar.h.f(xVarD)) == null || !m.a(qVar, gVar, xVar, bVar, this.a)) {
            return 0.5f;
        }
        return c(this.a, ayVarF);
    }

    protected abstract float c(com.google.android.libraries.navigation.internal.qa.a aVar, ay ayVar);

    protected abstract x d(com.google.android.libraries.navigation.internal.qk.q qVar);
}
