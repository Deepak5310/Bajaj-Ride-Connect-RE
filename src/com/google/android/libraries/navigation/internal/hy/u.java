package com.google.android.libraries.navigation.internal.hy;

import android.os.Looper;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public u(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Looper a() {
        Looper looper = ((com.google.android.libraries.navigation.internal.hx.aa) ((t) this.a).a()).f;
        com.google.android.libraries.navigation.internal.afr.j.d(looper);
        return looper;
    }
}
