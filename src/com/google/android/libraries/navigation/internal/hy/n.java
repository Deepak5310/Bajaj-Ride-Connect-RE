package com.google.android.libraries.navigation.internal.hy;

import com.google.android.libraries.navigation.internal.hx.ap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public n(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    public static Executor c(com.google.android.libraries.navigation.internal.hx.ai aiVar) {
        Executor executorA = aiVar.a(ap.GMM_PICKER);
        com.google.android.libraries.navigation.internal.afr.j.d(executorA);
        return executorA;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Executor a() {
        return c((com.google.android.libraries.navigation.internal.hx.ai) this.a.a());
    }
}
