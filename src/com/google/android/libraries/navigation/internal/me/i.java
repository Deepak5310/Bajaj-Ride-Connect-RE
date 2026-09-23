package com.google.android.libraries.navigation.internal.me;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i implements x, u, r {
    public final e a;
    public final ae b;
    private final Executor c;

    public i(Executor executor, e eVar, ae aeVar) {
        this.c = executor;
        this.a = eVar;
        this.b = aeVar;
    }

    @Override // com.google.android.libraries.navigation.internal.me.x
    public final void a(w wVar) {
        this.c.execute(new h(this, wVar));
    }

    public final void b() {
        this.b.n();
    }

    @Override // com.google.android.libraries.navigation.internal.me.r
    public final void c(Exception exc) {
        this.b.l(exc);
    }

    @Override // com.google.android.libraries.navigation.internal.me.u
    public final void d(Object obj) {
        this.b.m(obj);
    }
}
