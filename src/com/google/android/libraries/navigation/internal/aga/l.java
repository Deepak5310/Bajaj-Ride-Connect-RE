package com.google.android.libraries.navigation.internal.aga;

import java.net.SocketAddress;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l implements s {
    private final s a;

    public l(s sVar, Executor executor) {
        this.a = sVar;
        com.google.android.libraries.navigation.internal.yx.ar.r(executor, "appExecutor");
    }

    @Override // com.google.android.libraries.navigation.internal.aga.s
    public final u a(SocketAddress socketAddress, r rVar, com.google.android.libraries.navigation.internal.afx.g gVar) {
        return new k(this.a.a(socketAddress, rVar, gVar), rVar.a);
    }

    @Override // com.google.android.libraries.navigation.internal.aga.s
    public final Collection b() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.aga.s
    public final ScheduledExecutorService c() {
        return this.a.c();
    }

    @Override // com.google.android.libraries.navigation.internal.aga.s, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.a.close();
    }
}
