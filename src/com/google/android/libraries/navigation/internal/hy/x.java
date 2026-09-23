package com.google.android.libraries.navigation.internal.hy;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.hx.ap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;

    public x(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    public static bn c(com.google.android.libraries.navigation.internal.hx.ai aiVar, com.google.android.libraries.navigation.internal.ml.a aVar) {
        bn bnVarA = aVar.a((bn) aiVar.a(ap.NAVIGATION_INTERNAL));
        com.google.android.libraries.navigation.internal.afr.j.d(bnVarA);
        return bnVarA;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final bn a() {
        return c((com.google.android.libraries.navigation.internal.hx.ai) this.a.a(), ((com.google.android.libraries.navigation.internal.ml.b) this.b).a());
    }
}
