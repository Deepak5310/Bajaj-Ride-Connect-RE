package com.google.android.libraries.navigation.internal.hy;

import com.google.android.libraries.navigation.internal.hx.ap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public z(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Executor executorA = ((com.google.android.libraries.navigation.internal.hx.ai) com.google.android.libraries.navigation.internal.afr.e.c(this.a).a()).a(ap.NETWORK_TTS_SYNTHESIS);
        com.google.android.libraries.navigation.internal.afr.j.d(executorA);
        return executorA;
    }
}
