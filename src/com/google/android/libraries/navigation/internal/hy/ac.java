package com.google.android.libraries.navigation.internal.hy;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.hx.ap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public ac(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    public static bn c(com.google.android.libraries.navigation.internal.hx.ai aiVar) {
        bn bnVar = (bn) aiVar.a(ap.TILE_PREP_THREADPOOL);
        com.google.android.libraries.navigation.internal.afr.j.d(bnVar);
        return bnVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final bn a() {
        return c((com.google.android.libraries.navigation.internal.hx.ai) this.a.a());
    }
}
