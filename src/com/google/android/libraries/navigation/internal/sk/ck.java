package com.google.android.libraries.navigation.internal.sk;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ck implements com.google.android.libraries.navigation.internal.sl.l {
    static final com.google.android.libraries.navigation.internal.sl.m a = com.google.android.libraries.navigation.internal.sl.m.MUTED;
    static final com.google.android.libraries.navigation.internal.sl.m b = com.google.android.libraries.navigation.internal.sl.m.UNMUTED;
    private final Set c = new HashSet();
    private final com.google.android.libraries.navigation.internal.iv.f d;
    private final Executor e;
    private boolean f;
    private com.google.android.libraries.navigation.internal.sl.m g;
    private boolean h;

    public ck(com.google.android.libraries.navigation.internal.iv.f fVar, Executor executor) {
        this.d = fVar;
        this.e = executor;
        this.f = fVar.y(com.google.android.libraries.navigation.internal.iv.ab.U, false);
        com.google.android.libraries.navigation.internal.sl.m mVarA = com.google.android.libraries.navigation.internal.sl.m.a(fVar.a(com.google.android.libraries.navigation.internal.iv.ab.V, com.google.android.libraries.navigation.internal.sl.m.UNMUTED.d));
        this.g = mVarA == null ? com.google.android.libraries.navigation.internal.sl.m.UNMUTED : mVarA;
    }

    private final synchronized void f() {
        for (final t tVar : this.c) {
            Executor executor = this.e;
            Objects.requireNonNull(tVar);
            executor.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.cj
                @Override // java.lang.Runnable
                public final void run() {
                    tVar.a();
                }
            });
        }
    }

    private final void g(boolean z) {
        this.f = z;
        this.d.n(com.google.android.libraries.navigation.internal.iv.ab.U, z);
    }

    @Override // com.google.android.libraries.navigation.internal.sl.l
    public final synchronized com.google.android.libraries.navigation.internal.sl.m a() {
        if (this.f) {
            return a;
        }
        if (this.h) {
            return this.g;
        }
        return b;
    }

    @Override // com.google.android.libraries.navigation.internal.sl.l
    public final void b(boolean z) {
        if (this.h != z) {
            this.h = z;
            f();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sl.l
    public final synchronized void c(com.google.android.libraries.navigation.internal.sl.m mVar) {
        if (mVar == a()) {
            return;
        }
        if (mVar.equals(a)) {
            g(true);
        } else {
            g(false);
            if (this.h) {
                this.g = mVar;
                this.d.q(com.google.android.libraries.navigation.internal.iv.ab.V, mVar.d);
            }
        }
        f();
    }

    final synchronized boolean d(com.google.android.libraries.navigation.internal.sl.h hVar) {
        return ((com.google.android.libraries.navigation.internal.sl.k) hVar.l).e.e > a().e;
    }

    public final synchronized void e(t tVar) {
        this.c.add(tVar);
    }
}
