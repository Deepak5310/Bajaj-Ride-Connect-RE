package com.google.android.libraries.navigation.internal.aac;

import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ax {
    public final boolean a;
    public final ev b;

    public ax(boolean z, ev evVar) {
        this.a = z;
        this.b = evVar;
    }

    public final bj a(Callable callable, Executor executor) {
        return new ab(this.b, this.a, executor, callable);
    }

    public final void b(Runnable runnable, Executor executor) {
        a(new aw(runnable), executor);
    }
}
