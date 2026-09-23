package com.google.android.libraries.navigation.internal.oh;

import com.google.android.libraries.navigation.internal.oe.ad;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.qk.s;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k implements a {
    private final x a = new x();

    @Override // com.google.android.libraries.navigation.internal.oh.a
    public final float a(com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.qk.q qVar, x xVar, com.google.android.libraries.navigation.internal.adg.b bVar, s sVar) {
        float f;
        Iterator it2 = qVar.e.c.iterator();
        loop0: while (true) {
            if (!it2.hasNext()) {
                f = 0.0f;
                break;
            }
            List listQ = ((ad) it2.next()).q();
            for (int i = 1; i < listQ.size(); i++) {
                if (x.k((x) listQ.get(i - 1), (x) listQ.get(i), xVar, this.a) < 10000.0f) {
                    f = 1.0f;
                    break loop0;
                }
            }
        }
        if (sVar != null) {
            sVar.a(xVar, bVar, com.google.android.libraries.navigation.internal.b.b.h(f, "PointIsNearReservedPolyline:"));
        }
        return f;
    }
}
