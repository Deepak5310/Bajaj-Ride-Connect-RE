package com.google.android.libraries.navigation.internal.dp;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class t implements Runnable {
    final /* synthetic */ v a;

    public t(v vVar) {
        this.a = vVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.libraries.navigation.internal.dt.f fVar;
        v vVar = this.a;
        if (vVar.l == null) {
            ((com.google.android.libraries.navigation.internal.zb.h) v.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 417)).p("mapContainer is null in MyLocationCameraUpdatedRunnable.");
            return;
        }
        if (vVar.j == null) {
            ((com.google.android.libraries.navigation.internal.zb.h) v.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 416)).p("cameraManager is null in MyLocationCameraUpdatedRunnable.");
            return;
        }
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("MylocationMarkerControllerImpl.run");
        try {
            v vVar2 = this.a;
            com.google.android.libraries.navigation.internal.p002do.l lVar = vVar2.s;
            com.google.android.libraries.navigation.internal.oq.d dVar = vVar2.j;
            ar.q(dVar);
            lVar.i(dVar);
            synchronized (this.a.r) {
                v vVar3 = this.a;
                vVar3.s.b(vVar3.r);
                com.google.android.libraries.navigation.internal.dt.f fVar2 = this.a.r;
                boolean z = false;
                if (fVar2.f()) {
                    v vVar4 = this.a;
                    com.google.android.libraries.navigation.internal.dt.f fVar3 = vVar4.r;
                    com.google.android.libraries.navigation.internal.oq.d dVar2 = vVar4.j;
                    ar.q(dVar2);
                    if (fVar3.e(dVar2)) {
                        z = true;
                    }
                }
                fVar2.p = z;
                fVar = new com.google.android.libraries.navigation.internal.dt.f(this.a.r);
            }
            synchronized (this.a) {
                v vVar5 = this.a;
                com.google.android.libraries.navigation.internal.dr.i iVar = vVar5.o;
                if (iVar != null) {
                    com.google.android.libraries.navigation.internal.oq.d dVar3 = vVar5.j;
                    ar.q(dVar3);
                    iVar.c(fVar, dVar3);
                }
            }
            this.a.l.p.d(this);
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
