package com.google.android.libraries.navigation.internal.ip;

import com.google.android.libraries.navigation.internal.afr.e;
import com.google.android.libraries.navigation.internal.afr.f;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;
    private final com.google.android.libraries.navigation.internal.agl.a f;
    private final com.google.android.libraries.navigation.internal.agl.a g;

    public b(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5, com.google.android.libraries.navigation.internal.agl.a aVar6, com.google.android.libraries.navigation.internal.agl.a aVar7) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
        this.f = aVar6;
        this.g = aVar7;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final a a() {
        com.google.android.libraries.navigation.internal.afo.a aVarC = e.c(this.a);
        com.google.android.libraries.navigation.internal.afo.a aVarC2 = e.c(this.b);
        return new a(aVarC, aVarC2, this.c, this.d, e.c(this.f), ((com.google.android.libraries.navigation.internal.nj.b) this.g).a());
    }
}
