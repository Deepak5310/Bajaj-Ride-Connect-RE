package com.google.android.libraries.navigation.internal.oh;

import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.qk.s;
import com.google.android.libraries.navigation.internal.qk.t;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements a {
    private final t a;

    public c(t tVar) {
        this.a = tVar;
    }

    @Override // com.google.android.libraries.navigation.internal.oh.a
    public final float a(com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.qk.q qVar, x xVar, com.google.android.libraries.navigation.internal.adg.b bVar, s sVar) {
        com.google.android.libraries.navigation.internal.qk.o oVar = qVar.e;
        Map map = oVar.d;
        t tVar = this.a;
        float f = 0.0f;
        if (map.containsKey(tVar) && ((Integer) oVar.d.get(tVar)).intValue() > 0) {
            f = 1.0f;
        }
        if (sVar != null) {
            sVar.a(xVar, bVar, com.google.android.libraries.navigation.internal.b.b.h(f, "CalloutOfGivenUseCaseAlreadyPlaced:"));
        }
        return f;
    }
}
