package com.google.android.libraries.navigation.internal.oh;

import android.graphics.Rect;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.qk.s;
import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements a {
    private final n a;
    private final com.google.android.libraries.navigation.internal.qa.a b;
    private final com.google.android.libraries.navigation.internal.qa.a c;

    public b() {
        n nVar = new n();
        this.b = new com.google.android.libraries.navigation.internal.qa.a(0.0f, 0.0f, 0.0f, 0.0f);
        this.c = new com.google.android.libraries.navigation.internal.qa.a(0.0f, 0.0f, 0.0f, 0.0f);
        this.a = nVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.oh.a
    public final float a(com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.qk.q qVar, x xVar, com.google.android.libraries.navigation.internal.adg.b bVar, s sVar) {
        com.google.android.libraries.navigation.internal.pb.k kVar = qVar.g;
        float fMin = 0.5f;
        if (kVar != null && m.a(qVar, gVar, xVar, bVar, this.c)) {
            com.google.android.libraries.navigation.internal.qa.a aVar = this.b;
            Rect rectA = kVar.a();
            aVar.d(rectA.left, rectA.top, rectA.right, rectA.bottom);
            float fA = 1.0f - n.a(this.b, this.c);
            ev evVarB = kVar.b();
            int size = evVarB.size();
            for (int i = 0; i < size; i++) {
                fA += n.a((com.google.android.libraries.navigation.internal.qa.a) evVarB.get(i), this.c);
            }
            fMin = Math.min(fA, 1.0f);
        }
        if (sVar != null) {
            sVar.a(xVar, bVar, com.google.android.libraries.navigation.internal.b.b.h(fMin, "BodyIsOffscreen:"));
        }
        return fMin;
    }
}
