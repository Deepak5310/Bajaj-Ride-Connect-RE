package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ch extends bh {
    final /* synthetic */ ci a;
    private final Callable b;

    public ch(ci ciVar, Callable callable) {
        this.a = ciVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(callable);
        this.b = callable;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.bh
    public final Object a() throws Exception {
        return this.b.call();
    }

    @Override // com.google.android.libraries.navigation.internal.aac.bh
    public final String b() {
        return this.b.toString();
    }

    @Override // com.google.android.libraries.navigation.internal.aac.bh
    public final void d(Throwable th) {
        this.a.ap(th);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.bh
    public final void e(Object obj) {
        this.a.d(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.bh
    public final boolean g() {
        return this.a.isDone();
    }
}
