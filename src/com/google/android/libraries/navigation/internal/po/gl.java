package com.google.android.libraries.navigation.internal.po;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class gl {
    private final AtomicReference a;

    public gl(com.google.android.libraries.navigation.internal.aac.bn bnVar) {
        this.a = new AtomicReference(bnVar);
    }

    public final com.google.android.libraries.navigation.internal.aac.bn a() {
        com.google.android.libraries.navigation.internal.aac.bn bnVar = (com.google.android.libraries.navigation.internal.aac.bn) this.a.getAndSet(null);
        com.google.android.libraries.navigation.internal.yx.ar.q(bnVar);
        return bnVar;
    }
}
