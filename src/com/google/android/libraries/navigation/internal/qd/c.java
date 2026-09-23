package com.google.android.libraries.navigation.internal.qd;

import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.geo.mapcore.renderer.ax;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.oe.ap;
import com.google.android.libraries.navigation.internal.oe.at;
import j$.time.Duration;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends w {
    private static final Duration a = Duration.ofSeconds(10);
    private ScheduledFuture O;

    public c(ax axVar, com.google.android.libraries.navigation.internal.pb.t tVar, ap apVar, cg cgVar, com.google.android.libraries.navigation.internal.qv.k kVar, com.google.android.libraries.navigation.internal.qg.j jVar, k kVar2, com.google.android.libraries.navigation.internal.qf.d dVar, com.google.android.libraries.navigation.internal.mj.a aVar, ScheduledExecutorService scheduledExecutorService, com.google.android.libraries.navigation.internal.pg.h hVar, com.google.android.libraries.navigation.internal.rc.f fVar, int i, boolean z, com.google.android.libraries.navigation.internal.qs.a aVar2, at atVar, boolean z2, com.google.android.libraries.navigation.internal.afo.a aVar3, boolean z3) {
        super(axVar, tVar, apVar, cgVar, kVar, jVar, kVar2, dVar, aVar, scheduledExecutorService, fVar, hVar, null, null, i, true, atVar.a(an.EVCS), atVar.k(an.EVCS), z, null, aVar2, atVar, z2, aVar3, false, false, false, com.google.android.libraries.navigation.internal.yx.a.a);
    }

    @Override // com.google.android.libraries.navigation.internal.qd.w
    public final w g(cg cgVar, com.google.android.libraries.navigation.internal.qv.k kVar) {
        return new c(this.A, this.H, this.d, cgVar, kVar, this.g.c(cgVar, kVar), this.z, this.D, this.k, this.C, this.v, this.f, this.i, this.r, this.N, this.G, this.J, this.K, false);
    }

    @Override // com.google.android.libraries.navigation.internal.qd.w
    public final void h() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("EvcsTileOverlay.cancelTileRefresh");
        try {
            ScheduledFuture scheduledFuture = this.O;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                this.O = null;
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

    @Override // com.google.android.libraries.navigation.internal.qd.w
    public final void i() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("EvcsTileOverlay.startTileRefresh");
        try {
            this.O = this.C.scheduleWithFixedDelay(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qd.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.z();
                }
            }, 0L, a.toMillis(), TimeUnit.MILLISECONDS);
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
