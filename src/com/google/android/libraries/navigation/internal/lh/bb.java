package com.google.android.libraries.navigation.internal.lh;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bb implements com.google.android.libraries.navigation.internal.ld.t {
    final /* synthetic */ com.google.android.libraries.navigation.internal.ld.u a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.me.aa b;
    final /* synthetic */ bc c;
    final /* synthetic */ ba d;

    public bb(com.google.android.libraries.navigation.internal.ld.u uVar, com.google.android.libraries.navigation.internal.me.aa aaVar, bc bcVar, ba baVar) {
        this.a = uVar;
        this.b = aaVar;
        this.c = bcVar;
        this.d = baVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ld.t
    public final void a(com.google.android.libraries.navigation.internal.ld.ab abVar) {
        com.google.android.libraries.navigation.internal.ld.y yVar;
        if (!abVar.b()) {
            this.b.a(a.a(abVar));
            return;
        }
        com.google.android.libraries.navigation.internal.ld.u uVar = this.a;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        com.google.android.libraries.navigation.internal.le.q qVar = (com.google.android.libraries.navigation.internal.le.q) uVar;
        be.g(!qVar.g, "Result has already been consumed.");
        com.google.android.libraries.navigation.internal.le.bl blVar = qVar.h;
        be.g(true, "Cannot await if then() has been called.");
        try {
            if (!((com.google.android.libraries.navigation.internal.le.q) uVar).d.await(0L, timeUnit)) {
                ((com.google.android.libraries.navigation.internal.le.q) uVar).g(com.google.android.libraries.navigation.internal.ld.ab.d);
            }
        } catch (InterruptedException unused) {
            qVar.g(com.google.android.libraries.navigation.internal.ld.ab.b);
        }
        be.g(qVar.j(), "Result is not ready.");
        synchronized (qVar.c) {
            be.g(!((com.google.android.libraries.navigation.internal.le.q) uVar).g, "Result has already been consumed.");
            be.g(((com.google.android.libraries.navigation.internal.le.q) uVar).j(), "Result is not ready.");
            yVar = ((com.google.android.libraries.navigation.internal.le.q) uVar).f;
            ((com.google.android.libraries.navigation.internal.le.q) uVar).f = null;
            ((com.google.android.libraries.navigation.internal.le.q) uVar).g = true;
        }
        com.google.android.libraries.navigation.internal.le.bm bmVar = (com.google.android.libraries.navigation.internal.le.bm) qVar.e.getAndSet(null);
        if (bmVar != null) {
            bmVar.a();
        }
        be.j(yVar);
        this.b.b(null);
    }
}
