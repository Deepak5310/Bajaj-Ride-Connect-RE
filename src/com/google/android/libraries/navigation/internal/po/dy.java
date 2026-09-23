package com.google.android.libraries.navigation.internal.po;

import android.content.res.Resources;
import android.graphics.Color;
import android.widget.TextView;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.mq;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dy implements ds {
    private final com.google.android.libraries.geo.mapcore.renderer.eb A;
    private final com.google.android.libraries.geo.mapcore.renderer.ax B;
    private final com.google.android.libraries.navigation.internal.oe.at C;
    public boolean f;
    public final com.google.android.libraries.navigation.internal.qu.cf g;
    private final com.google.android.libraries.navigation.internal.yx.br k;
    private final com.google.android.libraries.navigation.internal.pb.t m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.px.bk f523n;
    private final com.google.android.libraries.navigation.internal.yx.br o;
    private final ScheduledExecutorService p;
    private String u;
    private com.google.android.libraries.navigation.internal.qq.f x;
    private com.google.android.libraries.navigation.internal.qq.f y;
    private final Integer z;
    private static final com.google.android.libraries.navigation.internal.yz.fy i = new mq(com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE);
    public static final com.google.android.libraries.navigation.internal.yz.fy a = new mq(com.google.android.libraries.navigation.internal.adi.an.GMM_INDOOR);
    public final com.google.android.libraries.navigation.internal.nt.p d = new com.google.android.libraries.navigation.internal.nt.p(false);
    public final com.google.android.libraries.navigation.internal.nt.p e = new com.google.android.libraries.navigation.internal.nt.p(false);
    private com.google.android.libraries.geo.mapcore.internal.model.cg l = com.google.android.libraries.geo.mapcore.internal.model.cg.s;
    private final Set q = new com.google.android.libraries.navigation.internal.agi.hc();
    private final Set r = new com.google.android.libraries.navigation.internal.agi.hc();
    private final int[] s = new int[1];
    private final Map t = new EnumMap(com.google.android.libraries.navigation.internal.adi.an.class);
    private boolean v = false;
    private volatile boolean w = false;
    final dv h = new dv(this);
    private boolean D = true;
    public final List b = new ArrayList();
    public final ArrayList c = new ArrayList();
    private final ArrayList j = new ArrayList();

    public dy(final Resources resources, com.google.android.libraries.navigation.internal.pb.t tVar, com.google.android.libraries.geo.mapcore.renderer.eb ebVar, com.google.android.libraries.geo.mapcore.renderer.ax axVar, com.google.android.libraries.navigation.internal.px.bk bkVar, final com.google.android.libraries.navigation.internal.yx.br brVar, com.google.android.libraries.navigation.internal.qu.cf cfVar, com.google.android.libraries.navigation.internal.oe.at atVar, boolean z, com.google.android.libraries.navigation.internal.yx.br brVar2, Integer num, ScheduledExecutorService scheduledExecutorService) {
        this.m = tVar;
        this.B = axVar;
        this.A = ebVar;
        this.z = num;
        int iIntValue = num != null ? num.intValue() : ((com.google.android.libraries.navigation.internal.qq.b) com.google.android.libraries.navigation.internal.qq.e.b.a(z)).c.D;
        ebVar.q(Color.red(iIntValue) / 255.0f, Color.green(iIntValue) / 255.0f, Color.blue(iIntValue) / 255.0f, Color.alpha(iIntValue) / 255.0f);
        this.f523n = bkVar;
        this.x = com.google.android.libraries.navigation.internal.qq.e.b.a(z);
        bkVar.k();
        bkVar.u(((com.google.android.libraries.navigation.internal.qq.b) this.x).c);
        this.g = cfVar;
        this.C = atVar;
        this.o = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.dt
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                Object objJ;
                com.google.android.libraries.navigation.internal.yz.fy fyVar = dy.a;
                Resources resources2 = resources;
                com.google.android.libraries.navigation.internal.yx.br brVar3 = brVar;
                com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("OverlayManagerImpl.createCopyrightHud");
                try {
                    if (((Boolean) brVar3.a()).booleanValue()) {
                        objJ = com.google.android.libraries.navigation.internal.yx.an.j(new com.google.android.libraries.geo.mapcore.internal.ui.k(resources2));
                        if (dVarB != null) {
                            Trace.endSection();
                        }
                    } else {
                        objJ = com.google.android.libraries.navigation.internal.yx.a.a;
                        if (dVarB != null) {
                            Trace.endSection();
                        }
                    }
                    return objJ;
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
        this.k = brVar2;
        this.p = scheduledExecutorService;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C(boolean z) {
        com.google.android.libraries.navigation.internal.yz.ev evVarO;
        int i2;
        synchronized (this) {
            com.google.android.libraries.navigation.internal.qq.f fVar = this.y;
            evVarO = null;
            if (fVar == null || fVar.g(this.x)) {
                this.y = null;
            }
            com.google.android.libraries.navigation.internal.qq.f fVar2 = this.y;
            if (fVar2 != null) {
                this.x = fVar2;
                this.y = null;
            }
            if (A()) {
                this.f = true;
            }
        }
        synchronized (this.b) {
            int size = this.b.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (((com.google.android.libraries.navigation.internal.qd.d) this.b.get(i3)).n(this.x)) {
                    evVarO = com.google.android.libraries.navigation.internal.yz.ev.o(this.b);
                    break;
                }
            }
        }
        if (evVarO != null) {
            int size2 = evVarO.size();
            for (i2 = 0; i2 < size2; i2++) {
                ((com.google.android.libraries.navigation.internal.qd.d) evVarO.get(i2)).m(this.x, z);
            }
        }
        this.f523n.u(((com.google.android.libraries.navigation.internal.qq.b) this.x).c);
        Integer num = this.z;
        int iIntValue = num != null ? num.intValue() : ((com.google.android.libraries.navigation.internal.qq.b) this.x).c.D;
        this.A.q(Color.red(iIntValue) / 255.0f, Color.green(iIntValue) / 255.0f, Color.blue(iIntValue) / 255.0f, Color.alpha(iIntValue) / 255.0f);
    }

    private final void D() {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((com.google.android.libraries.navigation.internal.qd.d) this.b.get(i2)).l();
        }
    }

    public final boolean A() {
        return ((com.google.android.libraries.navigation.internal.yx.an) this.o.a()).g();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0018  */
    /* JADX WARN: Code duplicated, block: B:36:0x0069  */
    protected final void B(com.google.android.libraries.navigation.internal.qd.d dVar, com.google.android.libraries.navigation.internal.qd.d dVar2, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        synchronized (this.b) {
            z2 = true;
            if (dVar2 != null) {
                try {
                    if (this.b.contains(dVar2)) {
                        z3 = false;
                        z4 = false;
                        z5 = false;
                    } else {
                        z3 = this.v;
                        z4 = this.D;
                        z5 = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                z3 = false;
                z4 = false;
                z5 = false;
            }
        }
        com.google.android.libraries.navigation.internal.qd.d dVar3 = null;
        com.google.android.libraries.navigation.internal.qd.w wVar = dVar instanceof com.google.android.libraries.navigation.internal.qd.w ? (com.google.android.libraries.navigation.internal.qd.w) dVar : null;
        if (z5 && (dVar2 instanceof com.google.android.libraries.navigation.internal.qd.w)) {
            com.google.android.libraries.navigation.internal.qd.w wVar2 = (com.google.android.libraries.navigation.internal.qd.w) dVar2;
            wVar2.M = this.h;
            if (z3) {
                wVar2.A();
            }
            if (this.C.f(wVar2.c)) {
                wVar2.D(z4);
            }
            wVar2.B();
            wVar2.x(true);
            wVar2.A.o();
            dVar3 = dVar2;
        }
        synchronized (this.b) {
            if (dVar != null) {
                try {
                    if (!this.b.remove(dVar)) {
                        z2 = false;
                    } else if (wVar != null) {
                        this.c.remove(wVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            } else {
                z2 = false;
            }
            if (z5) {
                if (dVar3 != null) {
                    if (z4 != this.D && this.C.f(((com.google.android.libraries.navigation.internal.qd.w) dVar3).c)) {
                        ((com.google.android.libraries.navigation.internal.qd.w) dVar3).D(this.D);
                    }
                    if (!z3 && this.v) {
                        ((com.google.android.libraries.navigation.internal.qd.w) dVar3).A();
                    }
                    this.c.add(dVar3);
                }
                com.google.android.libraries.navigation.internal.yx.ar.q(dVar2);
                this.b.add(dVar2);
            }
        }
        if (z2) {
            com.google.android.libraries.navigation.internal.yx.ar.q(dVar);
            dVar.l();
            if (wVar != null) {
                com.google.android.libraries.navigation.internal.oe.ap apVar = wVar.d;
                if (!apVar.d) {
                    com.google.android.libraries.navigation.internal.qu.cf cfVar = this.g;
                    synchronized (cfVar.e(apVar)) {
                        com.google.android.libraries.navigation.internal.qv.k kVar = (com.google.android.libraries.navigation.internal.qv.k) cfVar.a.get(apVar);
                        if (kVar != null) {
                            cfVar.d.e(kVar);
                            kVar.F();
                            cfVar.a.remove(apVar);
                        }
                    }
                }
            }
        }
        if (z5) {
            com.google.android.libraries.navigation.internal.yx.ar.q(dVar2);
            dVar2.m(this.x, z);
            dVar2.j();
            dVar2.k();
        }
        if (this.f523n != null) {
            if (z5 && z2) {
                com.google.android.libraries.navigation.internal.yx.ar.q(dVar);
                com.google.android.libraries.navigation.internal.yx.ar.q(dVar2);
                this.f523n.q(dVar, dVar2);
            } else if (z5) {
                com.google.android.libraries.navigation.internal.yx.ar.q(dVar2);
                this.f523n.g(dVar2);
            } else if (z2) {
                com.google.android.libraries.navigation.internal.yx.ar.q(dVar);
                this.f523n.p(dVar);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pb.l
    public final float a(com.google.android.libraries.navigation.internal.oe.x xVar) {
        float fMin;
        float f;
        synchronized (this.b) {
            int size = this.c.size();
            fMin = 21.0f;
            for (int i2 = 0; i2 < size; i2++) {
                com.google.android.libraries.navigation.internal.pg.f fVar = ((com.google.android.libraries.navigation.internal.qd.w) this.c.get(i2)).f548n;
                if (fVar == null) {
                    f = 21.0f;
                } else {
                    fVar.b(xVar);
                    f = 22.0f;
                }
                fMin = Math.min(fMin, f);
            }
        }
        return fMin;
    }

    @Override // com.google.android.libraries.navigation.internal.qq.aj
    public final void au() {
        int i2 = com.google.android.libraries.navigation.internal.gz.h.a;
        this.f523n.k();
        synchronized (this.b) {
            D();
            int size = this.b.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.google.android.libraries.navigation.internal.qd.d dVar = (com.google.android.libraries.navigation.internal.qd.d) this.b.get(i3);
                dVar.j();
                dVar.k();
                this.f523n.g(dVar);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pb.l
    public final float b() {
        return this.m.k();
    }

    @Override // com.google.android.libraries.navigation.internal.po.ds
    public final com.google.android.libraries.navigation.internal.nt.m c() {
        return this.d.a;
    }

    @Override // com.google.android.libraries.navigation.internal.po.ds
    public final com.google.android.libraries.navigation.internal.qd.w d(com.google.android.libraries.navigation.internal.qd.w wVar) {
        if (!(wVar.E instanceof com.google.android.libraries.navigation.internal.qu.aa)) {
            return wVar;
        }
        synchronized (this.b) {
            com.google.android.libraries.geo.mapcore.internal.model.cg cgVarY = wVar.e.z(this.l).y((String) this.t.get(wVar.c), this.u, ((com.google.android.libraries.navigation.internal.qq.b) wVar.u()).a);
            if (cgVarY.equals(wVar.e)) {
                return wVar;
            }
            com.google.android.libraries.navigation.internal.qd.w wVarG = wVar.g(cgVarY, this.g.b(wVar.d, cgVarY));
            o(wVar, wVarG);
            return wVarG;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.po.ds
    public final com.google.android.libraries.geo.mapcore.internal.model.cg e() {
        com.google.android.libraries.geo.mapcore.internal.model.cg cgVar;
        synchronized (this.b) {
            cgVar = this.l;
        }
        return cgVar;
    }

    @Override // com.google.android.libraries.navigation.internal.po.ds
    public final void g(com.google.android.libraries.navigation.internal.qd.d dVar) {
        synchronized (this.b) {
            if (this.A.l()) {
                this.j.add(com.google.android.libraries.navigation.internal.yu.f.b(new dw(this, null, dVar)));
                this.B.o();
            } else {
                B(null, dVar, false);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.po.ds
    public final void h() {
        synchronized (this.b) {
            this.v = true;
            Iterator it2 = this.c.iterator();
            while (it2.hasNext()) {
                ((com.google.android.libraries.navigation.internal.qd.w) it2.next()).A();
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.po.ds
    public final void i() {
        synchronized (this.b) {
            Iterator it2 = this.c.iterator();
            while (it2.hasNext()) {
                ((com.google.android.libraries.navigation.internal.qd.w) it2.next()).B();
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.po.ds
    public final void j() {
        this.B.f(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.du
            @Override // java.lang.Runnable
            public final void run() {
                boolean z;
                boolean z2;
                dy dyVar = this.a;
                synchronized (dyVar.b) {
                    Iterator it2 = dyVar.c.iterator();
                    z = false;
                    while (true) {
                        if (!it2.hasNext()) {
                            z2 = true;
                            break;
                        }
                        com.google.android.libraries.navigation.internal.qd.w wVar = (com.google.android.libraries.navigation.internal.qd.w) it2.next();
                        if (!dy.a.contains(wVar.c) && !wVar.u && !wVar.s) {
                            z2 = false;
                            z = true;
                            break;
                        }
                        z = true;
                    }
                }
                dyVar.d.c(Boolean.valueOf(z && z2));
                dyVar.e.c(false);
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.po.ds
    public final void k() {
        synchronized (this.b) {
            D();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.po.ds
    public final void l() {
        synchronized (this.b) {
            Iterator it2 = this.c.iterator();
            while (it2.hasNext()) {
                ((com.google.android.libraries.navigation.internal.qd.w) it2.next()).g.p(true);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.po.ds
    public final void m() {
        com.google.android.libraries.navigation.internal.kl.b bVar;
        synchronized (this.b) {
            for (com.google.android.libraries.navigation.internal.qd.w wVar : this.c) {
                wVar.g.p(false);
                if (wVar.c.equals(com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE) && (bVar = wVar.F) != null) {
                    long j = wVar.l;
                    if (j >= 0 && wVar.m - j >= 5000) {
                        ((com.google.android.libraries.navigation.internal.kk.j) bVar.a(com.google.android.libraries.navigation.internal.km.p.ap)).a();
                    }
                }
                wVar.q = 0L;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.po.ds
    public final void n(com.google.android.libraries.navigation.internal.qd.d dVar) {
        synchronized (this.b) {
            if (this.A.l()) {
                this.j.add(com.google.android.libraries.navigation.internal.yu.f.b(new dw(this, dVar, null)));
                this.B.o();
            } else {
                B(dVar, null, false);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.po.ds
    public final void o(com.google.android.libraries.navigation.internal.qd.d dVar, com.google.android.libraries.navigation.internal.qd.d dVar2) {
        p(dVar, dVar2, false);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0053 */
    @Override // com.google.android.libraries.navigation.internal.po.ds
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p(com.google.android.libraries.navigation.internal.qd.d dVar, com.google.android.libraries.navigation.internal.qd.d dVar2, boolean z) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("OverlayManagerImpl.replaceOverlay");
        synchronized (this.b) {
            try {
                if (this.A.l()) {
                    if (z) {
                        this.j.add(com.google.android.libraries.navigation.internal.yu.f.b(new dx(this, dVar, dVar2)));
                    } else {
                        this.j.add(com.google.android.libraries.navigation.internal.yu.f.b(new dw(this, dVar, dVar2)));
                    }
                    this.B.o();
                } else {
                    if (z && (dVar instanceof com.google.android.libraries.navigation.internal.qd.w)) {
                        ((com.google.android.libraries.navigation.internal.qd.w) dVar2).w((com.google.android.libraries.navigation.internal.qd.w) dVar);
                    }
                    B(dVar, dVar2, false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (dVarB != null) {
            Trace.endSection();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.po.ds
    public final void q(TextView textView) {
        com.google.android.libraries.navigation.internal.yx.an anVar = (com.google.android.libraries.navigation.internal.yx.an) this.o.a();
        if (anVar.g()) {
            com.google.android.libraries.geo.mapcore.internal.ui.k kVar = (com.google.android.libraries.geo.mapcore.internal.ui.k) anVar.c();
            if (textView != null) {
                textView.setVisibility(0);
                kVar.b = textView;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.po.ds
    public final synchronized void r(com.google.android.libraries.navigation.internal.qq.f fVar) {
        this.y = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.po.ds
    public final void s(boolean z) {
        synchronized (this.b) {
            this.D = z;
            for (com.google.android.libraries.navigation.internal.qd.w wVar : this.c) {
                if (this.C.f(wVar.c)) {
                    wVar.D(z);
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.po.ds
    public final void t() {
        if (((Boolean) this.k.a()).booleanValue() && !this.A.l()) {
            C(false);
        }
        synchronized (this.b) {
            for (com.google.android.libraries.navigation.internal.qd.d dVar : this.b) {
                if (dVar instanceof com.google.android.libraries.navigation.internal.qd.w) {
                    final com.google.android.libraries.navigation.internal.qd.w wVar = (com.google.android.libraries.navigation.internal.qd.w) dVar;
                    final com.google.android.libraries.navigation.internal.pb.t tVar = this.m;
                    final com.google.android.libraries.navigation.internal.pg.f fVar = wVar.f548n;
                    if (fVar != null) {
                        wVar.C.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qd.t
                            @Override // java.lang.Runnable
                            public final void run() {
                                w wVar2 = wVar;
                                com.google.android.libraries.navigation.internal.pb.t tVar2 = tVar;
                                com.google.android.libraries.navigation.internal.pg.f fVar2 = fVar;
                                synchronized (wVar2) {
                                    if (!wVar2.t) {
                                        com.google.android.libraries.navigation.internal.yt.a aVarC = com.google.android.libraries.navigation.internal.yt.d.c("TileOverlay.startEarlyTileFetching() ", wVar2.c);
                                        try {
                                            com.google.android.libraries.navigation.internal.pb.t tVar3 = new com.google.android.libraries.navigation.internal.pb.t(tVar2);
                                            ar.q(fVar2);
                                            long jA = fVar2.a(tVar3, wVar2.y);
                                            boolean z = false;
                                            if (wVar2.q != jA && !wVar2.y.isEmpty()) {
                                                z = true;
                                            }
                                            if (wVar2.c == an.GMM_VECTOR_BASE) {
                                                wVar2.z.q(jA);
                                            }
                                            if (z && (!wVar2.w || wVar2.g.w(tVar3.t(), wVar2.y, null, tVar3.v().d, 0, false, true, com.google.android.libraries.navigation.internal.rb.b.a()))) {
                                                wVar2.q = jA;
                                                wVar2.o = true;
                                            }
                                            aVarC.close();
                                        } catch (Throwable th) {
                                            try {
                                                aVarC.close();
                                                throw th;
                                            } catch (Throwable th2) {
                                                th.addSuppressed(th2);
                                                throw th;
                                            }
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.po.ds
    public final void u(com.google.android.libraries.geo.mapcore.internal.model.aq aqVar) {
        synchronized (this.b) {
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((com.google.android.libraries.navigation.internal.qd.w) this.c.get(i2)).H(aqVar);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.po.ds
    public final boolean v() {
        synchronized (this.b) {
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.google.android.libraries.navigation.internal.qd.w wVar = (com.google.android.libraries.navigation.internal.qd.w) this.c.get(i2);
                if (i.contains(wVar.c) && !wVar.K()) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.po.ds
    public final boolean w(Map map, String str) {
        boolean z;
        boolean z2;
        synchronized (this.b) {
            z = true;
            if ((!map.isEmpty() || this.t.isEmpty()) && map.keySet().equals(this.t.keySet())) {
                z2 = false;
            } else {
                this.t.clear();
                z2 = true;
            }
            for (Map.Entry entry : map.entrySet()) {
                if (!com.google.android.libraries.navigation.internal.yx.am.a((String) this.t.get(entry.getKey()), entry.getValue())) {
                    this.t.put((com.google.android.libraries.navigation.internal.adi.an) entry.getKey(), (String) entry.getValue());
                    z2 = true;
                }
            }
            if (com.google.android.libraries.navigation.internal.yx.am.a(str, this.u)) {
                z = z2;
            } else {
                this.u = str;
            }
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.po.ds
    public final boolean x(String str) {
        synchronized (this.b) {
            if (com.google.android.libraries.navigation.internal.yx.am.a(str, ((com.google.android.libraries.geo.mapcore.internal.model.b) this.l).m)) {
                return false;
            }
            com.google.android.libraries.geo.mapcore.internal.model.a aVar = new com.google.android.libraries.geo.mapcore.internal.model.a(this.l);
            aVar.l = str;
            this.l = aVar.a();
            return true;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qq.ak
    public final void y() {
        C(true);
    }

    @Override // com.google.android.libraries.navigation.internal.qq.ak
    public final void z() {
        boolean z;
        String string;
        com.google.android.libraries.navigation.internal.qq.e eVar;
        y();
        synchronized (this.b) {
            if (!this.j.isEmpty()) {
                com.google.android.libraries.navigation.internal.yz.ev evVarO = com.google.android.libraries.navigation.internal.yz.ev.o(this.j);
                this.j.clear();
                int size = evVarO.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((Runnable) evVarO.get(i2)).run();
                }
                this.B.o();
            }
        }
        if (A()) {
            synchronized (this) {
                z = this.f;
                this.f = false;
            }
            if (z) {
                synchronized (this.b) {
                    this.q.clear();
                    this.r.clear();
                    this.s[0] = -1;
                    int i3 = -1;
                    for (com.google.android.libraries.navigation.internal.qd.w wVar : this.c) {
                        com.google.android.libraries.navigation.internal.pb.t tVar = this.m;
                        Set set = this.q;
                        Set set2 = this.r;
                        int[] iArr = this.s;
                        int size2 = wVar.h.size();
                        int i4 = -1;
                        for (int i5 = 0; i5 < size2; i5++) {
                            com.google.android.libraries.navigation.internal.qi.d dVar = (com.google.android.libraries.navigation.internal.qi.d) wVar.h.get(i5);
                            dVar.o(tVar, set);
                            dVar.H(set2);
                            int iG = dVar.g();
                            if (iG > i4) {
                                i4 = iG;
                            }
                        }
                        iArr[0] = i4;
                        int i6 = this.s[0];
                        if (i6 > i3) {
                            i3 = i6;
                        }
                    }
                    com.google.android.libraries.navigation.internal.yx.an anVar = (com.google.android.libraries.navigation.internal.yx.an) this.o.a();
                    if (anVar.g()) {
                        com.google.android.libraries.geo.mapcore.internal.ui.k kVar = (com.google.android.libraries.geo.mapcore.internal.ui.k) anVar.c();
                        Set set3 = this.q;
                        Set set4 = this.r;
                        com.google.android.libraries.navigation.internal.qq.f fVar = this.x;
                        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar = ((com.google.android.libraries.navigation.internal.qq.b) fVar).c;
                        String str = ((com.google.android.libraries.geo.mapcore.internal.model.b) this.l).m;
                        TextView textView = kVar.b;
                        if (textView != null) {
                            if (i3 == -1) {
                                i3 = Calendar.getInstance().get(1);
                            }
                            String strA = kVar.a(set3);
                            String strA2 = kVar.a(set4);
                            if (!set3.isEmpty() && !set4.isEmpty()) {
                                Resources resources = kVar.a;
                                int i7 = com.google.android.libraries.navigation.internal.qr.e.i;
                                Integer numValueOf = Integer.valueOf(i3);
                                string = resources.getString(i7, numValueOf, numValueOf, strA2, numValueOf, strA);
                            } else if (set3.isEmpty() && set4.isEmpty()) {
                                string = kVar.a.getString(com.google.android.libraries.navigation.internal.qr.e.j, Integer.valueOf(i3));
                            } else if (set4.isEmpty()) {
                                Resources resources2 = kVar.a;
                                int i8 = com.google.android.libraries.navigation.internal.qr.e.l;
                                Integer numValueOf2 = Integer.valueOf(i3);
                                string = resources2.getString(i8, numValueOf2, numValueOf2, strA);
                            } else {
                                Resources resources3 = kVar.a;
                                int i9 = com.google.android.libraries.navigation.internal.qr.e.k;
                                Integer numValueOf3 = Integer.valueOf(i3);
                                string = resources3.getString(i9, numValueOf3, numValueOf3, strA2);
                            }
                            if (((com.google.android.libraries.navigation.internal.qq.b) fVar).e == com.google.android.libraries.navigation.internal.qq.e.q || (eVar = ((com.google.android.libraries.navigation.internal.qq.b) fVar).e) == com.google.android.libraries.navigation.internal.qq.e.r || ((str != null && eVar == com.google.android.libraries.navigation.internal.qq.e.b) || aqVar.G)) {
                                kVar.b(textView, string, com.google.android.libraries.navigation.internal.f.b.h, com.google.android.libraries.navigation.internal.f.b.q);
                            } else {
                                kVar.b(textView, string, com.google.android.libraries.navigation.internal.f.b.q, com.google.android.libraries.navigation.internal.f.b.h);
                            }
                        }
                    }
                }
            }
        }
    }
}
