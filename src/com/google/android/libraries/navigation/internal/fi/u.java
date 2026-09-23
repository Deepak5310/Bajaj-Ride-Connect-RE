package com.google.android.libraries.navigation.internal.fi;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class u {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public u(com.google.android.libraries.navigation.internal.agl.a aVar) {
        aVar.getClass();
        this.a = aVar;
    }

    public final t a(c cVar) {
        Executor executor = (Executor) this.a.a();
        executor.getClass();
        return new t(executor, cVar);
    }
}
