package com.google.android.libraries.navigation.internal.nj;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.aac.bt;
import com.google.android.libraries.navigation.internal.aac.cc;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;

    public f(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        com.google.android.libraries.navigation.internal.ml.a aVarA = ((com.google.android.libraries.navigation.internal.ml.b) this.a).a();
        ((p) this.b.a()).a();
        int iMax = Math.max(2, Runtime.getRuntime().availableProcessors() - 2);
        cc ccVar = new cc();
        ccVar.b();
        ccVar.a = "Lite-%d";
        ThreadFactory threadFactoryA = cc.a(ccVar);
        int[] iArr = com.google.android.libraries.navigation.internal.mm.c.a;
        bn bnVarA = aVarA.a(bt.a(Executors.newScheduledThreadPool(iMax, new com.google.android.libraries.navigation.internal.mm.a(0, threadFactoryA))));
        com.google.android.libraries.navigation.internal.afr.j.d(bnVarA);
        return bnVarA;
    }
}
