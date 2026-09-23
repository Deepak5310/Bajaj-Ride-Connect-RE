package com.google.android.libraries.navigation.internal.hy;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.hx.ap;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public w(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final ScheduledExecutorService a() {
        bn bnVar = (bn) ((com.google.android.libraries.navigation.internal.hx.ai) this.a.a()).a(ap.MEMORY_MONITOR);
        com.google.android.libraries.navigation.internal.afr.j.d(bnVar);
        return bnVar;
    }
}
