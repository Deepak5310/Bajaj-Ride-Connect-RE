package com.google.android.libraries.geo.mapcore.renderer;

import androidx.tracing.Trace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class dn implements dm {
    private final aj a;

    public dn(aj ajVar) {
        this.a = ajVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.dm
    public final void a(bv bvVar, com.google.android.libraries.navigation.internal.yz.ev evVar, dp dpVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarC = com.google.android.libraries.navigation.internal.nw.e.c("removeEntity ", this.a.y());
        try {
            com.google.android.libraries.navigation.internal.nw.a aVarB = com.google.android.libraries.navigation.internal.nw.b.b("removeEntity ", this.a.y());
            try {
                this.a.d(false);
                ((dx) evVar.get(this.a.y().ordinal())).g(this.a);
                if (this.a.g() != null && dpVar != null) {
                    aj ajVar = this.a;
                    ((com.google.android.libraries.navigation.internal.po.bs) dpVar).c.remove(ajVar);
                    ((com.google.android.libraries.navigation.internal.po.bs) dpVar).e.remove(ajVar);
                }
                if (aVarB != null) {
                    aVarB.close();
                }
                if (dVarC != null) {
                    Trace.endSection();
                }
            } catch (Throwable th) {
                if (aVarB != null) {
                    try {
                        aVarB.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (dVarC != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.dm
    public final void b() {
        this.a.d(true);
    }
}
