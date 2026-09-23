package com.google.android.libraries.navigation.internal.me;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g implements x {
    public final e a;
    public final ae b;
    private final Executor c;

    public g(Executor executor, e eVar, ae aeVar) {
        this.c = executor;
        this.a = eVar;
        this.b = aeVar;
    }

    @Override // com.google.android.libraries.navigation.internal.me.x
    public final void a(w wVar) {
        this.c.execute(new f(this, wVar));
    }
}
