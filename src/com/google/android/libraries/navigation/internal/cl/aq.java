package com.google.android.libraries.navigation.internal.cl;

import android.graphics.Rect;
import com.google.android.libraries.navigation.internal.bp.ck;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aq implements com.google.android.libraries.navigation.internal.oh.a {
    private final List a;
    private final Rect b;
    private final com.google.android.libraries.navigation.internal.qa.a c = new com.google.android.libraries.navigation.internal.qa.a(0.0f, 0.0f, 0.0f, 0.0f);
    private final com.google.android.libraries.navigation.internal.qa.a d = new com.google.android.libraries.navigation.internal.qa.a(0.0f, 0.0f, 0.0f, 0.0f);

    public aq(Rect rect, List list) {
        this.b = rect;
        this.a = list;
    }

    @Override // com.google.android.libraries.navigation.internal.oh.a
    public final float a(com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.qk.q qVar, com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.adg.b bVar, com.google.android.libraries.navigation.internal.qk.s sVar) {
        float size;
        com.google.android.libraries.navigation.internal.oe.ay ayVarF;
        com.google.android.libraries.navigation.internal.op.l lVarA = qVar.i.a(qVar.h, gVar, xVar, bVar);
        if (lVarA == null) {
            size = 0.5f;
        } else {
            com.google.android.libraries.navigation.internal.op.d dVar = (com.google.android.libraries.navigation.internal.op.d) lVarA;
            this.c.d(dVar.a, dVar.b, dVar.c, dVar.d);
            Iterator it2 = this.a.iterator();
            int i = 0;
            while (it2.hasNext()) {
                com.google.android.libraries.navigation.internal.oe.r rVarN = ((ck) it2.next()).n();
                if (rVarN != null && (ayVarF = qVar.h.f(com.google.android.libraries.navigation.internal.oe.x.z(rVarN))) != null) {
                    this.d.d(ayVarF.b - (this.b.width() / 2.0f), ayVarF.c - this.b.height(), ayVarF.b + (this.b.width() / 2.0f), ayVarF.c);
                    if (this.c.f(this.d)) {
                        i++;
                    }
                }
            }
            size = this.a.isEmpty() ? 0.0f : i / this.a.size();
        }
        if (sVar != null) {
            sVar.a(xVar, bVar, com.google.android.libraries.navigation.internal.b.b.h(size, "OverlapsWaypoint:"));
        }
        return size;
    }
}
