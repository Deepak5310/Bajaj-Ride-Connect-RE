package com.google.android.libraries.geo.mapcore.renderer;

import androidx.tracing.Trace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class dl implements dm {
    private final aj a;
    private final com.google.android.libraries.navigation.internal.ol.au b;

    public dl(aj ajVar, com.google.android.libraries.navigation.internal.ol.au auVar) {
        this.a = ajVar;
        this.b = auVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.dm
    public final void a(bv bvVar, com.google.android.libraries.navigation.internal.yz.ev evVar, dp dpVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarC = com.google.android.libraries.navigation.internal.nw.e.c("addEntity ", this.a.y());
        try {
            com.google.android.libraries.navigation.internal.nw.a aVarB = com.google.android.libraries.navigation.internal.nw.b.b("addEntity ", this.a.y());
            try {
                this.a.A(bvVar);
                ((dx) evVar.get(this.a.y().ordinal())).b(this.a);
                if (this.a.g() != null && dpVar != null) {
                    aj ajVar = this.a;
                    com.google.android.libraries.navigation.internal.ol.au auVar = this.b;
                    if (!(ajVar instanceof com.google.android.libraries.navigation.internal.qq.h)) {
                        throw new IllegalArgumentException("Current implementation only supports GmmEntity");
                    }
                    if (auVar != null) {
                        ((com.google.android.libraries.navigation.internal.po.bs) dpVar).e.put((com.google.android.libraries.navigation.internal.qq.h) ajVar, auVar);
                    }
                    ((com.google.android.libraries.navigation.internal.po.bs) dpVar).c.add((com.google.android.libraries.navigation.internal.qq.h) ajVar);
                    ((com.google.android.libraries.navigation.internal.po.bs) dpVar).b();
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
    }
}
