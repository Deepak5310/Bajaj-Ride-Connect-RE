package com.google.android.libraries.navigation.internal.po;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.tracing.Trace;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class gx implements com.google.android.libraries.navigation.internal.pp.h {
    private static final com.google.android.libraries.navigation.internal.zb.j g = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.po.gx");
    public final com.google.android.libraries.navigation.internal.agh.ez a = new com.google.android.libraries.navigation.internal.agh.fp();
    public final AtomicInteger b = new AtomicInteger();
    public final String c;
    public final int d;
    public final boolean e;
    protected final hi f;

    public gx(hi hiVar, String str, int i, boolean z) {
        this.f = hiVar;
        this.c = str;
        this.d = i;
        this.e = z;
    }

    private final dq i(long j) {
        dq dqVar;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("getStyleInternal");
        try {
            synchronized (this.a) {
                if (this.a.c(j)) {
                    dqVar = (dq) this.a.h(j);
                    if (dqVar == null) {
                        ((com.google.android.libraries.navigation.internal.zb.h) g.d(com.google.android.libraries.navigation.internal.nl.a.a).F(TypedValues.Custom.TYPE_COLOR)).p("namespaceStyles contains a key mapped to a null style.");
                    }
                } else {
                    dqVar = null;
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            return dqVar;
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

    @Override // com.google.android.libraries.navigation.internal.ol.av
    public final int a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.av
    public final com.google.android.libraries.navigation.internal.ol.s b(com.google.android.libraries.navigation.internal.adg.ga gaVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("createStyle");
        try {
            az azVar = new az(this.f, this, gaVar, this.b.getAndIncrement());
            this.f.v(azVar, false);
            synchronized (this.a) {
                this.a.a(azVar.a(), azVar);
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            return azVar;
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

    @Override // com.google.android.libraries.navigation.internal.ol.av
    public final com.google.android.libraries.navigation.internal.ol.aq c(long j) {
        dq dqVarI = i(j);
        return dqVarI == null ? hi.b : dqVarI;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.be
    public final com.google.android.libraries.geo.mapcore.internal.model.bt d(int i, com.google.android.libraries.navigation.internal.agg.ez ezVar) {
        com.google.android.libraries.geo.mapcore.internal.model.v vVarP = this.f.p();
        return vVarP != null ? hi.z(i, vVarP, ezVar) : com.google.android.libraries.geo.mapcore.internal.model.bt.a;
    }

    public final dq e(com.google.android.libraries.geo.mapcore.internal.model.ai aiVar, int i, com.google.android.libraries.navigation.internal.yz.fy fyVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("createMapStyleAndAddToNamespace-textures");
        try {
            dq dqVar = new dq(this, com.google.android.libraries.geo.mapcore.internal.model.bt.j(aiVar, this.e), i, fyVar);
            synchronized (this.a) {
                this.a.a(dqVar.e, dqVar);
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            return dqVar;
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

    protected final com.google.android.libraries.geo.mapcore.internal.model.bt f(long j) {
        dq dqVarI = i(j);
        return dqVarI == null ? com.google.android.libraries.geo.mapcore.internal.model.bt.a : dqVarI.g();
    }

    final dq g(com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar, int i) {
        return h(nVar, 0, i, null);
    }

    final dq h(com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar, int i, int i2, com.google.android.libraries.navigation.internal.ol.aq aqVar) {
        int andIncrement = this.b.getAndIncrement();
        com.google.android.libraries.geo.mapcore.internal.model.ai aiVar = com.google.android.libraries.geo.mapcore.internal.model.ai.c;
        com.google.android.libraries.geo.mapcore.internal.model.ah ahVar = new com.google.android.libraries.geo.mapcore.internal.model.ah();
        ahVar.b = true;
        ahVar.v = i2;
        com.google.android.libraries.navigation.internal.yz.fw fwVar = new com.google.android.libraries.navigation.internal.yz.fw();
        if (nVar != null) {
            ahVar.a = true;
            ahVar.A = nVar;
            fwVar.c(nVar);
        } else {
            ahVar.a = false;
            ahVar.g = i;
        }
        if (aqVar instanceof dq) {
            ahVar.j = ((dq) aqVar).g().d().o;
            ahVar.b = false;
        }
        dq dqVarE = e(new com.google.android.libraries.geo.mapcore.internal.model.ai(ahVar), andIncrement, fwVar.i());
        this.f.v(dqVarE, false);
        return dqVarE;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.be
    public final com.google.android.libraries.geo.mapcore.internal.model.bt j(long j) {
        return this.f.r(j);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.be
    public final com.google.android.libraries.geo.mapcore.internal.model.bt k(int i) {
        return f(i);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.be
    public final com.google.android.libraries.geo.mapcore.internal.model.bt l(int i) {
        return d(i, com.google.android.libraries.navigation.internal.agg.fd.a);
    }
}
