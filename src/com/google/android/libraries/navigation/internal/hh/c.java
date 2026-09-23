package com.google.android.libraries.navigation.internal.hh;

import com.google.android.libraries.navigation.internal.iv.ab;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    private static final com.google.android.libraries.navigation.internal.iv.u a;
    private final com.google.android.libraries.navigation.internal.iv.f b;

    static {
        Intrinsics.checkNotNullExpressionValue(com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.hh.c"), "forInjectedClassName(...)");
        a = new com.google.android.libraries.navigation.internal.iv.u("GMM_STORAGE_NEXT_ID", ab.c);
    }

    public c(com.google.android.libraries.navigation.internal.iv.f gmmSettings) {
        Intrinsics.checkNotNullParameter(gmmSettings, "gmmSettings");
        this.b = gmmSettings;
    }

    public final synchronized b a() {
        int iA;
        com.google.android.libraries.navigation.internal.iv.f fVar = this.b;
        com.google.android.libraries.navigation.internal.iv.u uVar = a;
        iA = fVar.a(uVar, 0);
        this.b.q(uVar, iA + 1);
        return new b(String.valueOf(iA));
    }
}
