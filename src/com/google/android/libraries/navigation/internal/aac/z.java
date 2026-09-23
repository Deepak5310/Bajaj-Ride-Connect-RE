package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class z extends aa {
    final /* synthetic */ ab a;
    private final Callable c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(ab abVar, Callable callable, Executor executor) {
        super(abVar, executor);
        this.a = abVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(callable);
        this.c = callable;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.bh
    public final Object a() throws Exception {
        return this.c.call();
    }

    @Override // com.google.android.libraries.navigation.internal.aac.bh
    public final String b() {
        return this.c.toString();
    }

    @Override // com.google.android.libraries.navigation.internal.aac.aa
    public final void c(Object obj) {
        this.a.d(obj);
    }
}
