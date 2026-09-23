package com.google.android.libraries.navigation.internal.cz;

import com.google.android.libraries.navigation.internal.afr.f;
import com.google.android.libraries.navigation.internal.yx.an;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;

    public e(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        com.google.android.libraries.navigation.internal.mj.a aVar = (com.google.android.libraries.navigation.internal.mj.a) this.a.a();
        com.google.android.libraries.navigation.internal.kc.a aVar2 = (com.google.android.libraries.navigation.internal.kc.a) this.b.a();
        return aVar2 == null ? com.google.android.libraries.navigation.internal.yx.a.a : an.j(new d(aVar2, aVar));
    }
}
