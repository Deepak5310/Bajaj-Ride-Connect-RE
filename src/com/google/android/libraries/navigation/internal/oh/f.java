package com.google.android.libraries.navigation.internal.oh;

import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.qk.s;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements a {
    private final n a;
    private final com.google.android.libraries.navigation.internal.qa.a b;

    public f() {
        n nVar = new n();
        this.b = new com.google.android.libraries.navigation.internal.qa.a(0.0f, 0.0f, 0.0f, 0.0f);
        this.a = nVar;
    }

    @Override // com.google.android.libraries.navigation.internal.oh.a
    public final float a(com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.qk.q qVar, x xVar, com.google.android.libraries.navigation.internal.adg.b bVar, s sVar) {
        float fMin;
        if (m.a(qVar, gVar, xVar, bVar, this.b)) {
            Iterator it2 = qVar.e.a.iterator();
            float fA = 0.0f;
            while (it2.hasNext()) {
                fA += n.a(this.b, (com.google.android.libraries.navigation.internal.qa.a) it2.next());
            }
            fMin = Math.min(fA, 1.0f);
        } else {
            fMin = 0.5f;
        }
        if (sVar != null) {
            sVar.a(xVar, bVar, com.google.android.libraries.navigation.internal.b.b.h(fMin, "OverlapsAnotherCallout:"));
        }
        return fMin;
    }
}
