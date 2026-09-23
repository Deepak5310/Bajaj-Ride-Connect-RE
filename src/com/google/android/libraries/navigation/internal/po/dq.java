package com.google.android.libraries.navigation.internal.po;

import androidx.core.math.MathUtils;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.adg.Cdo;
import com.google.android.libraries.navigation.internal.adg.ib;
import com.google.android.libraries.navigation.internal.yz.mb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class dq implements com.google.android.libraries.navigation.internal.pp.g {
    private final int a;
    private final List b;
    protected final com.google.android.libraries.geo.mapcore.internal.model.bt c;
    public final gx d;
    public final int e;
    boolean f;
    private final AtomicReference g;
    private boolean h;

    public dq(gx gxVar, com.google.android.libraries.geo.mapcore.internal.model.bt btVar, int i) {
        this(gxVar, btVar, i, mb.a);
    }

    private static void l(com.google.android.libraries.geo.mapcore.internal.model.bs bsVar, com.google.android.libraries.navigation.internal.yz.fw fwVar) {
        if (!bsVar.i.c()) {
            fwVar.c(bsVar.i);
        }
        if (!bsVar.j.c()) {
            fwVar.c(bsVar.j);
        }
        if (bsVar.k.c()) {
            return;
        }
        fwVar.c(bsVar.k);
    }

    private final synchronized boolean m(Runnable runnable) {
        boolean z;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("addRunnableIfNotCachedIsReady");
        try {
            if (this.f) {
                z = true;
            } else {
                if (runnable != null) {
                    this.b.add(runnable);
                }
                z = false;
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
        return z;
    }

    private final boolean n(Runnable runnable) {
        boolean zM;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("isReadyAddRunnableIfNot");
        try {
            synchronized (this) {
                zM = true;
                if (!this.f) {
                    if (g() != null && this.h) {
                        synchronized (this) {
                            this.f = true;
                        }
                    } else {
                        zM = m(runnable);
                    }
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            return zM;
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

    @Override // com.google.android.libraries.navigation.internal.ol.aq
    public int a() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.aq
    public Cdo b() {
        Cdo cdo = (Cdo) com.google.android.libraries.navigation.internal.adg.dp.a.q();
        int iA = a();
        if (!cdo.b.H()) {
            cdo.v();
        }
        com.google.android.libraries.navigation.internal.adg.dp dpVar = (com.google.android.libraries.navigation.internal.adg.dp) cdo.b;
        dpVar.b |= 2;
        dpVar.d = iA;
        return cdo;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.aq
    public com.google.android.libraries.navigation.internal.adg.dq c() {
        com.google.android.libraries.navigation.internal.adg.dq dqVar = (com.google.android.libraries.navigation.internal.adg.dq) com.google.android.libraries.navigation.internal.adg.dt.a.q();
        int iA = a();
        if (!dqVar.b.H()) {
            dqVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.dt dtVar = (com.google.android.libraries.navigation.internal.adg.dt) dqVar.b;
        dtVar.b |= 1;
        dtVar.d = iA;
        return dqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.aq
    public com.google.android.libraries.navigation.internal.adg.dy d() {
        com.google.android.libraries.navigation.internal.adg.dy dyVar = (com.google.android.libraries.navigation.internal.adg.dy) com.google.android.libraries.navigation.internal.adg.ef.a.q();
        int iA = a();
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.ef efVar = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
        efVar.b |= 4096;
        efVar.l = iA;
        return dyVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.aq
    public final com.google.android.libraries.navigation.internal.adg.es e() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof dq) {
            dq dqVar = (dq) obj;
            gx gxVar = this.d;
            if (gxVar.d == dqVar.d.d && this.e == dqVar.e) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.aq
    public final void f(Runnable runnable) {
        if (n(runnable)) {
            runnable.run();
        }
    }

    public void h() {
    }

    public final int hashCode() {
        return this.a;
    }

    final com.google.android.libraries.navigation.internal.yz.fy i() {
        com.google.android.libraries.navigation.internal.yz.fw fwVar = new com.google.android.libraries.navigation.internal.yz.fw();
        com.google.android.libraries.geo.mapcore.internal.model.bt btVarG = g();
        for (int i = 0; i < btVarG.b(); i++) {
            com.google.android.libraries.geo.mapcore.internal.model.ai[] aiVarArr = btVarG.c;
            com.google.android.libraries.geo.mapcore.internal.model.ai aiVar = aiVarArr[MathUtils.clamp(i, 0, aiVarArr.length - 1)];
            for (com.google.android.libraries.geo.mapcore.internal.model.bs bsVar : aiVar.o) {
                l(bsVar, fwVar);
            }
            for (com.google.android.libraries.geo.mapcore.internal.model.bs bsVar2 : aiVar.f58n) {
                l(bsVar2, fwVar);
            }
            if (!aiVar.L.c()) {
                fwVar.c(aiVar.L);
            }
        }
        return fwVar.i();
    }

    final com.google.android.libraries.navigation.internal.yz.fy j(com.google.android.libraries.navigation.internal.yz.fy fyVar) {
        return (com.google.android.libraries.navigation.internal.yz.fy) this.g.getAndSet(fyVar);
    }

    public final void k(boolean z) {
        this.h = z;
        synchronized (this) {
            if (n(null)) {
                this.f = true;
                com.google.android.libraries.navigation.internal.yz.ev evVarO = com.google.android.libraries.navigation.internal.yz.ev.o(this.b);
                this.b.clear();
                int size = evVarO.size();
                for (int i = 0; i < size; i++) {
                    ((Runnable) evVarO.get(i)).run();
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pp.g
    public final boolean o(com.google.android.libraries.navigation.internal.ol.aq aqVar, boolean z) {
        for (int i = 0; i < 22; i++) {
            if (!(aqVar instanceof dq)) {
                return false;
            }
            com.google.android.libraries.geo.mapcore.internal.model.ai aiVarG = g().g(i);
            com.google.android.libraries.geo.mapcore.internal.model.ai aiVarG2 = ((dq) aqVar).g().g(i);
            if (aiVarG.H != aiVarG2.H) {
                return false;
            }
            int i2 = ib.a;
            if (i2 == 0) {
                throw null;
            }
            if (com.google.android.libraries.geo.mapcore.internal.model.ay.f(aiVarG.J, i2) != com.google.android.libraries.geo.mapcore.internal.model.ay.f(aiVarG2.J, i2)) {
                return false;
            }
            com.google.android.libraries.geo.mapcore.internal.model.bs[] bsVarArr = z ? aiVarG.f58n : aiVarG.o;
            com.google.android.libraries.geo.mapcore.internal.model.bs[] bsVarArr2 = z ? aiVarG2.f58n : aiVarG2.o;
            if (bsVarArr.length != bsVarArr2.length) {
                return false;
            }
            for (int i3 = 0; i3 < bsVarArr.length; i3++) {
                com.google.android.libraries.geo.mapcore.internal.model.bs bsVar = bsVarArr[i3];
                com.google.android.libraries.geo.mapcore.internal.model.bs bsVar2 = bsVarArr2[i3];
                if (bsVar.d != 0.0f && bsVar2.d != 0.0f && (!bsVar.i.equals(bsVar2.i) || !bsVar.j.equals(bsVar2.j) || !bsVar.k.equals(bsVar2.k) || bsVar.f != bsVar2.f || bsVar.g != bsVar2.g)) {
                    return false;
                }
            }
        }
        return true;
    }

    public dq(gx gxVar, com.google.android.libraries.geo.mapcore.internal.model.bt btVar, int i, com.google.android.libraries.navigation.internal.yz.fy fyVar) {
        this.f = false;
        this.b = new ArrayList();
        AtomicReference atomicReference = new AtomicReference(mb.a);
        this.g = atomicReference;
        this.d = gxVar;
        this.c = btVar;
        this.e = i;
        this.a = Arrays.hashCode(new Object[]{Integer.valueOf(gxVar.d), Integer.valueOf(i)});
        atomicReference.set(fyVar);
    }

    public com.google.android.libraries.geo.mapcore.internal.model.bt g() {
        synchronized (this) {
            com.google.android.libraries.geo.mapcore.internal.model.bt btVar = this.c;
            if (btVar != com.google.android.libraries.geo.mapcore.internal.model.bt.a) {
                return btVar;
            }
            int i = this.e;
            return i != -1 ? this.d.f(i) : com.google.android.libraries.geo.mapcore.internal.model.bt.a;
        }
    }
}
