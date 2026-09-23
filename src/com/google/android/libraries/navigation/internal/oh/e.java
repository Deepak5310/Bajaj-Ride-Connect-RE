package com.google.android.libraries.navigation.internal.oh;

import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.qk.s;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements a {
    @Override // com.google.android.libraries.navigation.internal.oh.a
    public final float a(com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.qk.q qVar, x xVar, com.google.android.libraries.navigation.internal.adg.b bVar, s sVar) {
        boolean zEquals = xVar.equals(qVar.a());
        boolean zEquals2 = bVar.equals(qVar.d);
        float f = 0.0f;
        if (zEquals && zEquals2) {
            f = 1.0f;
        }
        if (sVar != null) {
            sVar.a(xVar, bVar, com.google.android.libraries.navigation.internal.b.b.h(f, "MaintainsCurrentPlacement:"));
        }
        return f;
    }
}
