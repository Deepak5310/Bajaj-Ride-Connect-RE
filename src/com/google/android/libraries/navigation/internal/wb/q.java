package com.google.android.libraries.navigation.internal.wb;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.ms.cy;
import com.google.android.libraries.navigation.internal.uh.v;
import com.google.android.libraries.navigation.internal.xe.bp;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q implements v {
    public final com.google.android.libraries.navigation.internal.rw.f a;
    public final Executor b;
    public n c;
    public com.google.android.libraries.navigation.internal.ua.a d;
    public boolean f = false;
    public final p e = new p(this);

    public q(com.google.android.libraries.navigation.internal.rw.f fVar, Executor executor) {
        this.a = fVar;
        this.b = executor;
    }

    @Override // com.google.android.libraries.navigation.internal.uh.v
    public final void a(com.google.android.libraries.navigation.internal.ui.a aVar) {
    }

    public final void b() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.wb.o
            @Override // java.lang.Runnable
            public final void run() {
                n nVar = this.a.c;
                ar.q(nVar);
                com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("NavigationControllers.onNavigationStarted");
                try {
                    nVar.c = true;
                    nVar.b();
                    if (dVarB != null) {
                        Trace.endSection();
                    }
                } catch (Throwable th) {
                    if (dVarB != null) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        });
        com.google.android.libraries.navigation.internal.ua.a aVar = this.d;
        ar.q(aVar);
        bp bpVar = (bp) aVar;
        bpVar.k = true;
        bpVar.l.aa();
        bpVar.b();
        cy.a(bpVar.l);
    }

    @Override // com.google.android.libraries.navigation.internal.uh.v
    public final void f(com.google.android.libraries.navigation.internal.ui.a aVar, com.google.android.libraries.navigation.internal.ui.a aVar2) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("NavigationEventForwarder.onNavigationUiStateChanged");
        try {
            if (this.f) {
                n nVar = this.c;
                ar.q(nVar);
                nVar.f(aVar, aVar2);
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
