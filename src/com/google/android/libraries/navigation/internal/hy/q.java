package com.google.android.libraries.navigation.internal.hy;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.aac.bt;
import com.google.android.libraries.navigation.internal.hx.ap;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q implements com.google.android.libraries.navigation.internal.afr.f {
    public static bn b() {
        bn bnVarA = bt.a(Executors.newSingleThreadScheduledExecutor(new com.google.android.libraries.navigation.internal.hx.w(ap.LABELING_THREAD)));
        com.google.android.libraries.navigation.internal.afr.j.d(bnVarA);
        return bnVarA;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* synthetic */ Object a() {
        return b();
    }
}
