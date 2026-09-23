package com.google.android.libraries.navigation.internal.tr;

import com.google.android.libraries.navigation.internal.afr.f;
import com.google.android.libraries.navigation.internal.bn.d;
import com.google.android.libraries.navigation.internal.nj.h;
import com.google.android.libraries.navigation.internal.rw.q;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;

    public b(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final a a() {
        return new a((q) this.a.a(), (d) this.b.a(), ((h) this.c).a());
    }
}
