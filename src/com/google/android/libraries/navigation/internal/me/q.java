package com.google.android.libraries.navigation.internal.me;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q implements x {
    public final Object a = new Object();
    public final r b;
    private final Executor c;

    public q(Executor executor, r rVar) {
        this.c = executor;
        this.b = rVar;
    }

    @Override // com.google.android.libraries.navigation.internal.me.x
    public final void a(w wVar) {
        if (wVar.e() || ((ae) wVar).d) {
            return;
        }
        synchronized (this.a) {
        }
        this.c.execute(new p(this, wVar));
    }
}
