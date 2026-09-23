package com.google.android.libraries.navigation.internal.me;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n implements x {
    public final Object a = new Object();
    public final o b;
    private final Executor c;

    public n(Executor executor, o oVar) {
        this.c = executor;
        this.b = oVar;
    }

    @Override // com.google.android.libraries.navigation.internal.me.x
    public final void a(w wVar) {
        synchronized (this.a) {
        }
        this.c.execute(new m(this, wVar));
    }
}
