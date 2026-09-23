package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class al {
    private final AtomicReference b = new AtomicReference(be.a);
    public ak a = new ak();

    static /* synthetic */ void b(ci ciVar, ca caVar, bj bjVar, bj bjVar2, aj ajVar) {
        if (ciVar.isDone()) {
            caVar.aA(bjVar);
        } else if (bjVar2.isCancelled() && ajVar.compareAndSet(ai.NOT_RUN, ai.CANCELLED)) {
            ciVar.cancel(false);
        }
    }

    public final bj a(s sVar, Executor executor) {
        com.google.android.libraries.navigation.internal.yx.ar.q(executor);
        final aj ajVar = new aj(executor, this);
        ah ahVar = new ah(ajVar, sVar);
        final ca caVar = new ca();
        final bj bjVar = (bj) this.b.getAndSet(caVar);
        final ci ciVar = new ci(ahVar);
        bjVar.l(ciVar, ajVar);
        final bj bjVarI = az.i(ciVar);
        Runnable runnable = new Runnable() { // from class: com.google.android.libraries.navigation.internal.aac.ag
            @Override // java.lang.Runnable
            public final void run() {
                al.b(ciVar, caVar, bjVar, bjVarI, ajVar);
            }
        };
        bjVarI.l(runnable, ac.INSTANCE);
        ciVar.l(runnable, ac.INSTANCE);
        return bjVarI;
    }
}
