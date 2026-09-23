package com.google.android.libraries.navigation.internal.pv;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.internal.model.ct;
import com.google.android.libraries.geo.mapcore.internal.model.x;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.afl.pw;
import com.google.android.libraries.navigation.internal.fr.k;
import com.google.android.libraries.navigation.internal.fr.l;
import com.google.android.libraries.navigation.internal.oe.at;
import com.google.android.libraries.navigation.internal.qu.bg;
import com.google.android.libraries.navigation.internal.qu.bl;
import com.google.android.libraries.navigation.internal.qu.cf;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements com.google.android.libraries.navigation.internal.oc.a {
    public final com.google.android.libraries.navigation.internal.od.a a;
    public final com.google.android.libraries.navigation.internal.pm.d b;
    private final com.google.android.libraries.navigation.internal.qf.d c;
    private final com.google.android.libraries.navigation.internal.pg.g d;
    private final com.google.android.libraries.navigation.internal.qy.h e;
    private final x f;
    private final cf g;
    private final at h;
    private final com.google.android.libraries.navigation.internal.qt.a i;
    private final br j;
    private final br k;
    private final com.google.android.libraries.navigation.internal.ra.a l;
    private final com.google.android.libraries.navigation.internal.ox.f m;

    public i(final com.google.android.libraries.navigation.internal.od.a aVar, final com.google.android.libraries.navigation.internal.qy.h hVar, com.google.android.libraries.navigation.internal.qu.br brVar, final com.google.android.libraries.navigation.internal.qv.a aVar2, com.google.android.libraries.navigation.internal.ra.a aVar3, at atVar, final com.google.android.libraries.navigation.internal.ox.f fVar) {
        Objects.requireNonNull(aVar);
        com.google.android.libraries.navigation.internal.pm.d dVar = new com.google.android.libraries.navigation.internal.pm.d(new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.pv.a
            @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
            public final Object a() {
                return aVar.J();
            }
        });
        this.b = dVar;
        this.e = hVar;
        this.l = aVar3;
        this.h = atVar;
        this.m = fVar;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("SharedMapComponentImpl.<init>");
        try {
            this.a = aVar;
            this.c = new com.google.android.libraries.navigation.internal.qf.d(aVar.w(), aVar.H(), bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.pv.b
                /* JADX WARN: Code duplicated, block: B:12:0x0028  */
                /* JADX WARN: Code duplicated, block: B:9:0x001d  */
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    k kVar = l.a;
                    com.google.android.libraries.navigation.internal.od.a aVar4 = aVar;
                    boolean z = true;
                    if (k.a(aVar4.t())) {
                        pw pwVar = aVar4.ac().l;
                        if (pwVar == null) {
                            pwVar = pw.a;
                        }
                        if (!pwVar.b) {
                            if (!aVar4.z().n()) {
                                z = false;
                            }
                        }
                    } else if (!aVar4.z().n()) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
            }));
            com.google.android.libraries.navigation.internal.ih.a aVarB = com.google.android.libraries.navigation.internal.ih.a.b(new br() { // from class: com.google.android.libraries.navigation.internal.pv.c
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    final com.google.android.libraries.navigation.internal.od.a aVar4 = aVar;
                    com.google.android.libraries.navigation.internal.mj.a aVarH = aVar4.H();
                    aVar4.t();
                    com.google.android.libraries.navigation.internal.ih.a aVarC = com.google.android.libraries.navigation.internal.ih.a.c(hVar);
                    Objects.requireNonNull(aVar4);
                    com.google.android.libraries.navigation.internal.ih.a aVarB2 = com.google.android.libraries.navigation.internal.ih.a.b(new d(aVar4));
                    com.google.android.libraries.navigation.internal.ih.a aVarC2 = com.google.android.libraries.navigation.internal.ih.a.c(aVar4.G());
                    com.google.android.libraries.navigation.internal.qv.a aVar5 = aVar2;
                    bn bnVarV = aVar4.V();
                    bn bnVarS = aVar4.S();
                    com.google.android.libraries.navigation.internal.ih.a aVarC3 = com.google.android.libraries.navigation.internal.ih.a.c(aVar5);
                    pw pwVar = aVar4.ac().l;
                    if (pwVar == null) {
                        pwVar = pw.a;
                    }
                    return new bg(aVarH, aVarC, aVarB2, aVarC2, bnVarV, bnVarS, aVarC3, pwVar, new br() { // from class: com.google.android.libraries.navigation.internal.pv.h
                        @Override // com.google.android.libraries.navigation.internal.yx.br
                        public final Object a() {
                            return Integer.valueOf(aVar4.ac().z);
                        }
                    }, this.a.b);
                }
            });
            Runnable runnableAd = aVar.ad();
            Objects.requireNonNull(aVar);
            com.google.android.libraries.navigation.internal.agl.a aVar4 = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.pv.a
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return aVar.J();
                }
            };
            Objects.requireNonNull(aVar);
            this.f = new bl(runnableAd, aVar4, fVar, com.google.android.libraries.navigation.internal.ih.a.b(new d(aVar)), com.google.android.libraries.navigation.internal.ih.a.c(aVar.G()), aVar.S(), aVarB, aVar.H());
            br brVarA = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.pv.e
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    float f;
                    Context contextT = aVar.t();
                    com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("SharedMapComponentImpl.shouldEnableCopyrights");
                    try {
                        float f2 = contextT.getResources().getDisplayMetrics().densityDpi;
                        DisplayMetrics displayMetrics = contextT.getResources().getDisplayMetrics();
                        if (Math.abs(displayMetrics.xdpi - f2) / f2 > 0.25d || Math.abs(displayMetrics.ydpi - f2) / f2 > 0.25d) {
                            f = f2;
                        } else {
                            f2 = displayMetrics.xdpi;
                            f = displayMetrics.ydpi;
                        }
                        float f3 = displayMetrics.widthPixels / f2;
                        float f4 = displayMetrics.heightPixels / f;
                        boolean z = (f3 * f3) + (f4 * f4) >= 49.0f;
                        if (dVarB2 != null) {
                            Trace.endSection();
                        }
                        return Boolean.valueOf(z);
                    } catch (Throwable th) {
                        if (dVarB2 != null) {
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
            this.k = brVarA;
            Resources resources = aVar.t().getResources();
            Map mapAe = aVar.ae();
            com.google.android.libraries.navigation.internal.ih.a aVarC = com.google.android.libraries.navigation.internal.ih.a.c(aVar.y());
            com.google.android.libraries.navigation.internal.fq.f fVarW = aVar.w();
            com.google.android.libraries.navigation.internal.kl.b bVarG = aVar.G();
            Objects.requireNonNull(aVar);
            this.g = new cf(resources, atVar, aVar2, mapAe, aVarC, fVarW, bVarG, new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.pv.a
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return aVar.J();
                }
            }, fVar, aVar.ad(), dVar, aVar.H(), aVar.V(), aVar.S(), brVarA, bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.pv.f
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    i iVar = this.a;
                    com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("SharedMapComponentImpl.getMaxJavaHeapSizeImpl");
                    try {
                        int memoryClass = ((ActivityManager) iVar.a.t().getSystemService("activity")).getMemoryClass();
                        if (dVarB2 != null) {
                            Trace.endSection();
                        }
                        return Integer.valueOf(memoryClass);
                    } catch (Throwable th) {
                        if (dVarB2 != null) {
                            try {
                                Trace.endSection();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                }
            }), com.google.android.libraries.navigation.internal.ih.a.c(aVar.C()), com.google.android.libraries.navigation.internal.ih.a.c(aVar.x()), brVar, aVar.Y(), aVar.X(), aVar.aa(), aVar.z());
            this.i = new com.google.android.libraries.navigation.internal.qt.a();
            br brVarA2 = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.pv.g
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    ct ctVar = new ct(fVar);
                    ctVar.b();
                    return ctVar;
                }
            });
            this.j = brVarA2;
            this.d = new com.google.android.libraries.navigation.internal.pg.g(brVarA2);
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB == null) {
                throw th;
            }
            try {
                Trace.endSection();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oc.a
    public final at h() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.oc.a
    public final com.google.android.libraries.navigation.internal.pg.g i() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.oc.a
    public final com.google.android.libraries.navigation.internal.pm.d j() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.oc.a
    public final com.google.android.libraries.navigation.internal.qf.d k() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.oc.a
    public final x l() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.oc.a
    public final ct m() {
        return (ct) this.j.a();
    }

    @Override // com.google.android.libraries.navigation.internal.oc.a
    public final com.google.android.libraries.navigation.internal.qt.a n() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.oc.a
    public final cf o() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.oc.a, com.google.android.libraries.navigation.internal.qy.i
    public final com.google.android.libraries.navigation.internal.qy.h p() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.oc.a
    public final com.google.android.libraries.navigation.internal.ra.a q() {
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.oc.a
    public final br r() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.oc.a
    public final com.google.android.libraries.navigation.internal.ox.f s() {
        return this.m;
    }
}
