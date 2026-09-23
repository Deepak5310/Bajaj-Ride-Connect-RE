package com.google.android.libraries.navigation.internal.dp;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.po.gr;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y implements Runnable {
    public com.google.android.libraries.navigation.internal.oq.d a;
    public final gr b;
    private com.google.android.libraries.navigation.internal.dr.i c;
    private final com.google.android.libraries.navigation.internal.dt.f d;
    private final p e;

    public y(com.google.android.libraries.navigation.internal.dr.i iVar, p pVar, gr grVar) {
        com.google.android.libraries.navigation.internal.dt.f fVar = new com.google.android.libraries.navigation.internal.dt.f();
        this.c = iVar;
        ar.q(pVar);
        this.e = pVar;
        ar.q(grVar);
        this.b = grVar;
        this.d = fVar;
    }

    public final synchronized void a(com.google.android.libraries.navigation.internal.dr.i iVar) {
        this.c = iVar;
        this.b.d(this);
        this.b.b();
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        com.google.android.libraries.navigation.internal.oq.d dVar = this.a;
        ar.q(dVar);
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("MyLocationMarkerUpdateRunnable.run");
        try {
            this.e.a(this.d);
            if (this.d.f() && this.d.e(dVar)) {
                com.google.android.libraries.navigation.internal.dt.f fVar = this.d;
                fVar.p = true;
                com.google.android.libraries.navigation.internal.dr.i iVar = this.c;
                if (iVar != null) {
                    iVar.c(fVar, dVar);
                }
            } else {
                this.d.p = false;
            }
            if (this.e.b()) {
                this.b.d(this);
                this.b.b();
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
