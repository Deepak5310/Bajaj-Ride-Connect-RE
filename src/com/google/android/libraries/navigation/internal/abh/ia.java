package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ia extends com.google.android.libraries.navigation.internal.ny.e {
    public final ExecutorService i;

    public ia(Context context, com.google.android.libraries.navigation.internal.mj.a aVar, ExecutorService executorService, com.google.android.libraries.navigation.internal.ky.o oVar) {
        super(context, aVar, executorService, oVar);
        this.i = executorService;
        g(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.hy
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.libraries.navigation.internal.ky.ap apVar = this.a.a;
                com.google.android.libraries.navigation.internal.lh.be.j(apVar.e);
                apVar.d.writeLock().lock();
                try {
                    apVar.f = true;
                } finally {
                    apVar.d.writeLock().unlock();
                }
            }
        });
    }

    private final void g(final Runnable runnable) {
        com.google.android.libraries.navigation.internal.me.w wVarA = ht.a();
        if (wVarA != null) {
            wVarA.j(new com.google.android.libraries.navigation.internal.me.u() { // from class: com.google.android.libraries.navigation.internal.abh.hz
                @Override // com.google.android.libraries.navigation.internal.me.u
                public final void d(Object obj) {
                    if (!((com.google.android.libraries.navigation.internal.mf.o) obj).a()) {
                        com.google.android.libraries.navigation.internal.abf.p.f("MonitoringLogger", 4);
                        return;
                    }
                    Runnable runnable2 = runnable;
                    ia iaVar = this.a;
                    com.google.android.libraries.navigation.internal.abf.p.f("MonitoringLogger", 4);
                    iaVar.i.execute(runnable2);
                }
            });
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ny.e
    public final void a() {
        g(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.hx
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f();
            }
        });
    }

    public final /* synthetic */ void f() {
        super.a();
    }
}
