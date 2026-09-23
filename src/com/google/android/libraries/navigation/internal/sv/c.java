package com.google.android.libraries.navigation.internal.sv;

import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public com.google.android.libraries.navigation.internal.db.r a;
    public final ConcurrentLinkedDeque b = new ConcurrentLinkedDeque();
    public final AtomicBoolean c = new AtomicBoolean(false);
    private final Executor d;

    public c(Executor executor) {
        this.d = executor;
    }

    public final com.google.android.libraries.navigation.internal.aac.bj a() {
        com.google.android.libraries.navigation.internal.db.r rVar = this.a;
        if (rVar != null) {
            return com.google.android.libraries.navigation.internal.aac.az.h((com.google.android.libraries.navigation.internal.db.r) Objects.requireNonNull(rVar));
        }
        com.google.android.libraries.navigation.internal.aac.bk bkVar = new com.google.android.libraries.navigation.internal.aac.bk(new Callable() { // from class: com.google.android.libraries.navigation.internal.sv.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return (com.google.android.libraries.navigation.internal.db.r) Objects.requireNonNull(this.a.a);
            }
        });
        this.b.add(bkVar);
        return bkVar;
    }

    public final void b(com.google.android.libraries.navigation.internal.ia.e eVar) {
        if (this.c.compareAndSet(false, true)) {
            fd fdVarK = fd.k(com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL, this.d);
            fz fzVar = new fz();
            fzVar.b(com.google.android.libraries.navigation.internal.db.s.class, new e(com.google.android.libraries.navigation.internal.db.s.class, this, com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL, e.b(com.google.android.libraries.navigation.internal.hx.ap.NAVIGATION_INTERNAL, fdVarK)));
            eVar.c(this, fzVar.a());
        }
    }
}
