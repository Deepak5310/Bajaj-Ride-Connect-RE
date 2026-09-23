package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ci extends am implements RunnableFuture {
    private volatile bh a;

    public ci(s sVar) {
        this.a = new cg(this, sVar);
    }

    public static ci f(Runnable runnable, Object obj) {
        return new ci(Executors.callable(runnable, obj));
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    protected final String ao() {
        bh bhVar = this.a;
        return bhVar != null ? com.google.android.libraries.navigation.internal.b.b.n(bhVar, "task=[", "]") : super.ao();
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    protected final void b() {
        bh bhVar;
        if (p() && (bhVar = this.a) != null) {
            bhVar.h();
        }
        this.a = null;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        bh bhVar = this.a;
        if (bhVar != null) {
            bhVar.run();
        }
        this.a = null;
    }

    public ci(Callable callable) {
        this.a = new ch(this, callable);
    }
}
