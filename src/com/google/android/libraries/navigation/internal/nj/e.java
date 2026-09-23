package com.google.android.libraries.navigation.internal.nj;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.aac.bt;
import com.google.android.libraries.navigation.internal.aac.cc;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;

    public e(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        com.google.android.libraries.navigation.internal.ml.a aVarA = ((com.google.android.libraries.navigation.internal.ml.b) this.a).a();
        ((p) this.b.a()).a();
        cc ccVar = new cc();
        ccVar.b();
        ccVar.a = "Blocking-%d";
        ThreadFactory threadFactoryA = cc.a(ccVar);
        int[] iArr = com.google.android.libraries.navigation.internal.mm.c.a;
        bn bnVarA = aVarA.a(bt.a(new ScheduledThreadPoolExecutor(0, new com.google.android.libraries.navigation.internal.mm.a(11, threadFactoryA))));
        com.google.android.libraries.navigation.internal.afr.j.d(bnVarA);
        return bnVarA;
    }
}
