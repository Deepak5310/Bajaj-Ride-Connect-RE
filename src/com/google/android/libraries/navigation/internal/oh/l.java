package com.google.android.libraries.navigation.internal.oh;

import android.graphics.Rect;
import com.google.android.libraries.navigation.internal.oe.ay;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.qk.s;
import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l implements a {
    private final com.google.android.libraries.navigation.internal.qa.a a = new com.google.android.libraries.navigation.internal.qa.a(0.0f, 0.0f, 0.0f, 0.0f);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.oh.a
    public final float a(com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.qk.q qVar, x xVar, com.google.android.libraries.navigation.internal.adg.b bVar, s sVar) {
        com.google.android.libraries.navigation.internal.pb.k kVar = qVar.g;
        ay ayVarF = qVar.h.f(xVar);
        float f = 0.5f;
        if (kVar != null && ayVarF != null) {
            com.google.android.libraries.navigation.internal.qa.a aVar = this.a;
            Rect rectA = kVar.a();
            aVar.d(rectA.left, rectA.top, rectA.right, rectA.bottom);
            if (!this.a.e(ayVarF)) {
                f = 1.0f;
                break;
            }
            ev evVarB = kVar.b();
            int size = evVarB.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    f = 0.0f;
                    break;
                }
                boolean zE = ((com.google.android.libraries.navigation.internal.qa.a) evVarB.get(i)).e(ayVarF);
                i++;
                if (zE) {
                    f = 1.0f;
                    break;
                }
            }
        }
        if (sVar != null) {
            sVar.a(xVar, bVar, com.google.android.libraries.navigation.internal.b.b.h(f, "PointIsOffscreen:"));
        }
        return f;
    }
}
