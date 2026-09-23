package com.google.android.libraries.navigation.internal.px;

import android.os.SystemClock;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class bp implements bk {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.px.bp");
    private final bb A;
    private final ca B;
    private final com.google.android.libraries.navigation.internal.nt.p C;
    private final com.google.android.libraries.navigation.internal.nt.p D;
    private final com.google.android.libraries.navigation.internal.nt.p E;
    private com.google.android.libraries.navigation.internal.nt.m F;
    private boolean G;
    private final com.google.android.libraries.navigation.internal.fq.f H;
    private final com.google.android.libraries.navigation.internal.kl.b I;
    private final com.google.android.libraries.navigation.internal.agl.a J;
    private final com.google.android.libraries.navigation.internal.aac.bm K;
    private final Executor L;
    private final bh M;
    private final com.google.android.libraries.navigation.internal.yx.an N;
    private final com.google.android.libraries.navigation.internal.nt.p O;
    private final com.google.android.libraries.navigation.internal.ol.ax P;
    private final boolean Q;
    private final boolean R;
    private final boolean S;
    private final com.google.android.libraries.navigation.internal.po.dg T;
    public final Object b = new Object();
    public ArrayList c = new ArrayList();
    public ArrayList d = new ArrayList();
    public final com.google.android.libraries.navigation.internal.kk.n e;
    public final com.google.android.libraries.navigation.internal.kk.l f;
    public final bs g;
    public final bs h;
    public final cq i;
    public final com.google.android.libraries.navigation.internal.fq.o j;
    public final ArrayList k;
    public volatile boolean l;
    public boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicReference f540n;
    public final a o;
    public final com.google.android.libraries.navigation.internal.qc.g p;
    public final List q;
    public final List r;
    com.google.android.libraries.navigation.internal.pd.d s;
    com.google.android.libraries.navigation.internal.pd.d t;
    public final com.google.android.libraries.navigation.internal.om.n u;
    public final com.google.android.libraries.navigation.internal.ni.a v;
    private final cn w;
    private final AtomicBoolean x;
    private bv y;
    private final com.google.android.libraries.navigation.internal.pq.b z;

    /* JADX INFO: compiled from: PG */
    class a {
        private static final com.google.android.libraries.navigation.internal.zb.j g = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.px.bp$a");
        public boolean a;
        public boolean b;
        public boolean c;
        public List d = new ArrayList();
        public List e = new ArrayList();
        public final com.google.android.libraries.navigation.internal.nt.p f;
        private final boolean h;

        public a(com.google.android.libraries.navigation.internal.nt.p pVar, boolean z) {
            this.f = pVar;
            this.h = z;
        }

        final synchronized void a() {
            this.b = true;
            this.a = true;
            this.f.c(false);
        }

        final synchronized void b() {
            this.c = true;
            this.b = false;
            this.a = false;
            this.f.c(false);
            List list = this.d;
            this.d = this.e;
            this.e = list;
            if (list.isEmpty()) {
                return;
            }
            ((com.google.android.libraries.navigation.internal.zb.h) g.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 937)).p("Logic error in label pass completion; had pending listeners when starting a new pass");
            this.e.clear();
        }

        final synchronized boolean c() {
            if (this.h) {
                return (this.b || this.c || this.a) ? false : true;
            }
            return (this.b || this.c) ? false : true;
        }
    }

    public bp(com.google.android.libraries.navigation.internal.pq.b bVar, com.google.android.libraries.navigation.internal.po.dg dgVar, bb bbVar, ca caVar, com.google.android.libraries.navigation.internal.fq.f fVar, com.google.android.libraries.navigation.internal.kl.b bVar2, com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.aac.bm bmVar, Executor executor, com.google.android.libraries.navigation.internal.qc.g gVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.ni.a aVar3, com.google.android.libraries.navigation.internal.rc.f fVar2, boolean z, com.google.android.libraries.navigation.internal.ol.ax axVar, boolean z2, boolean z3) {
        bs bsVar = new bs();
        this.g = bsVar;
        bs bsVar2 = new bs();
        this.h = bsVar2;
        this.i = new cq();
        this.j = new br();
        this.k = new ArrayList();
        this.l = true;
        this.x = new AtomicBoolean(false);
        this.f540n = new AtomicReference(null);
        this.C = new com.google.android.libraries.navigation.internal.nt.p(false);
        com.google.android.libraries.navigation.internal.nt.p pVar = new com.google.android.libraries.navigation.internal.nt.p(false);
        this.D = pVar;
        this.E = new com.google.android.libraries.navigation.internal.nt.p(false);
        this.G = false;
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.N = com.google.android.libraries.navigation.internal.yx.a.a;
        this.R = false;
        this.S = false;
        this.z = bVar;
        this.T = dgVar;
        this.A = bbVar;
        this.B = caVar;
        this.H = fVar;
        this.I = bVar2;
        this.J = aVar;
        com.google.android.libraries.navigation.internal.om.n nVar = (com.google.android.libraries.navigation.internal.om.n) aVar.a();
        this.u = nVar;
        this.K = bmVar;
        this.L = executor;
        this.v = aVar3;
        this.p = gVar;
        this.M = new bh(gVar, aVar, aVar2, fVar2);
        this.O = new com.google.android.libraries.navigation.internal.nt.p(com.google.android.libraries.navigation.internal.ol.af.a);
        this.P = axVar;
        this.w = new cn(nVar.m(), bVar2);
        this.Q = z2;
        this.o = new a(pVar, z3);
        com.google.android.libraries.navigation.internal.kk.n nVar2 = (com.google.android.libraries.navigation.internal.kk.n) bVar2.a(com.google.android.libraries.navigation.internal.km.p.d);
        this.e = nVar2;
        this.f = (com.google.android.libraries.navigation.internal.kk.l) bVar2.a(com.google.android.libraries.navigation.internal.km.p.e);
        bsVar2.g = z ? com.google.android.libraries.geo.mapcore.internal.model.aq.b : com.google.android.libraries.geo.mapcore.internal.model.aq.a;
        bsVar.g = z ? com.google.android.libraries.geo.mapcore.internal.model.aq.b : com.google.android.libraries.geo.mapcore.internal.model.aq.a;
        bsVar2.k = nVar2.a();
        bsVar.k = nVar2.a();
    }

    private final void A() {
        bv bvVar = this.y;
        if (bvVar == null || !this.G) {
            return;
        }
        cd cdVar = new cd(this.y.a, this.J);
        com.google.android.libraries.navigation.internal.kl.b bVar = this.I;
        bv bvVar2 = this.y;
        com.google.android.libraries.navigation.internal.pb.t tVar = bvVar2.b;
        com.google.android.libraries.geo.mapcore.renderer.ax axVar = bvVar2.a;
        com.google.android.libraries.navigation.internal.po.dg dgVar = this.T;
        bb bbVar = this.A;
        cn cnVar = this.w;
        com.google.android.libraries.navigation.internal.ni.a aVar = this.v;
        this.J.a();
        cz czVar = new cz(bVar, tVar, axVar, dgVar, bbVar, cnVar, aVar, this.C, this.E);
        bv bvVar3 = this.y;
        if (bvVar3 != null) {
            bvVar3.a.f = czVar;
        }
        ed edVar = new ed(czVar, cdVar, this.B, this.z, new bj(this.H), new eq(this.H), this.T, this.w, this.J, this.M, new cv(), this.O, this.g.g);
        edVar.d.b = false;
        edVar.d.c = false;
        bt btVar = new bt(this, edVar, this.K, this.L);
        this.g.a = bvVar.b.w();
        this.g.c = bvVar.b.s();
        this.g.d = bvVar.b.r();
        this.g.e = bvVar.b.n();
        bu buVar = new bu(new com.google.android.libraries.navigation.internal.pb.t(bvVar.b), edVar, btVar, new Runnable() { // from class: com.google.android.libraries.navigation.internal.px.bn
            @Override // java.lang.Runnable
            public final void run() {
                this.a.z();
            }
        });
        this.f540n.set(buVar);
        this.y.a.f(buVar.d);
        bt btVar2 = buVar.c;
        btVar2.e.aA(btVar2.d.submit(btVar2));
        btVar2.a = true;
        r();
    }

    private final void B(boolean z) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        bu buVar = (bu) this.f540n.get();
        if (buVar != null) {
            Runnable runnable = new Runnable() { // from class: com.google.android.libraries.navigation.internal.px.bm
                @Override // java.lang.Runnable
                public final void run() {
                    countDownLatch.countDown();
                }
            };
            com.google.android.libraries.navigation.internal.aac.bm bmVar = this.K;
            bt btVar = buVar.c;
            if (btVar.a) {
                btVar.e.l(runnable, bmVar);
            } else {
                bmVar.execute(runnable);
            }
            buVar.c.b();
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            buVar = null;
        }
        synchronized (this) {
            if (z) {
                synchronized (this.b) {
                    ArrayList arrayList = new ArrayList();
                    for (bq bqVar : this.c) {
                        if (bqVar.a.Z()) {
                            bqVar.a();
                            this.j.g(bqVar);
                        } else {
                            arrayList.add(bqVar);
                        }
                    }
                    this.c = arrayList;
                }
                int i = ev.d;
                com.google.android.libraries.navigation.internal.yz.eq eqVar = new com.google.android.libraries.navigation.internal.yz.eq();
                int size = this.k.size();
                for (int i2 = 0; i2 < size; i2++) {
                    cr crVar = (cr) this.k.get(i2);
                    if (crVar.Z()) {
                        ((cr) this.k.get(i2)).d(this);
                        eqVar.h(crVar);
                    }
                }
                this.k.removeAll(eqVar.g());
            } else {
                int size2 = this.k.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    ((cr) this.k.get(i3)).d(this);
                }
                this.k.clear();
            }
            this.m = true;
            if (buVar != null) {
                bv bvVar = this.y;
                if (bvVar != null) {
                    bvVar.a.n(buVar.d);
                }
                cs csVar = buVar.b;
                ((ed) csVar).b.j();
                ((ed) csVar).e.b();
                ((ed) csVar).d.b();
                ((ed) csVar).a.c();
                ((ed) csVar).c.a();
                this.w.c();
                this.f540n.set(null);
            }
            this.G = false;
        }
        if (z) {
            return;
        }
        this.K.shutdown();
    }

    @Override // com.google.android.libraries.navigation.internal.qz.g
    public final void a(com.google.android.libraries.navigation.internal.qz.k kVar) {
        if (!kVar.p() || kVar.c() == null) {
            return;
        }
        r();
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final synchronized com.google.android.libraries.navigation.internal.nt.m b() {
        if (this.F == null) {
            com.google.android.libraries.navigation.internal.nt.p pVar = this.D;
            com.google.android.libraries.navigation.internal.nt.p pVar2 = this.C;
            final com.google.android.libraries.navigation.internal.nt.o oVar = pVar.a;
            final com.google.android.libraries.navigation.internal.nt.o oVar2 = pVar2.a;
            this.F = new com.google.android.libraries.navigation.internal.nt.i(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.px.bl
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    Boolean bool = (Boolean) oVar.c();
                    Boolean bool2 = (Boolean) oVar2.c();
                    boolean z = false;
                    if (bool != null && bool2 != null && bool.booleanValue() && bool2.booleanValue()) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            }, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE, oVar2, oVar);
        }
        return this.F;
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final synchronized com.google.android.libraries.navigation.internal.pz.d c() {
        return this.g.f;
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final void d(com.google.android.libraries.navigation.internal.ol.ac acVar) {
        synchronized (this.q) {
            if (!this.q.contains(acVar)) {
                this.q.add(acVar);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final void e(com.google.android.libraries.navigation.internal.ol.ad adVar) {
        synchronized (this.r) {
            if (!this.r.contains(adVar)) {
                this.r.add(adVar);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final synchronized void f(com.google.android.libraries.navigation.internal.ol.am amVar) {
        this.w.d.add(amVar);
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final void g(cr crVar) {
        synchronized (this.b) {
            ArrayList arrayList = this.c;
            bq bqVar = (bq) this.j.c();
            bqVar.b(crVar, 1);
            arrayList.add(bqVar);
        }
        r();
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final synchronized void h() {
        this.g.h = true;
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final synchronized void i(com.google.android.libraries.navigation.internal.ol.ah ahVar) {
        bs bsVar = this.g;
        if (bsVar.i != ahVar) {
            bsVar.i = ahVar;
            r();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final void j() {
        B(false);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x001a */
    @Override // com.google.android.libraries.navigation.internal.px.bk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("LabelControllerImpl.onGLContextChanged");
        B(true);
        synchronized (this) {
            try {
                this.G = true;
                A();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (dVarB != null) {
            Trace.endSection();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final void l(cr crVar) {
        synchronized (this.b) {
            ArrayList arrayList = this.c;
            bq bqVar = (bq) this.j.c();
            bqVar.b(crVar, 3);
            arrayList.add(bqVar);
        }
        r();
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final void n(com.google.android.libraries.navigation.internal.ol.ac acVar) {
        synchronized (this.q) {
            this.q.remove(acVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final void o(com.google.android.libraries.navigation.internal.ol.ad adVar) {
        synchronized (this.r) {
            this.r.remove(adVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final void p(cr crVar) {
        synchronized (this.b) {
            ArrayList arrayList = this.c;
            bq bqVar = (bq) this.j.c();
            bqVar.b(crVar, 2);
            arrayList.add(bqVar);
        }
        r();
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final void q(cr crVar, cr crVar2) {
        synchronized (this.b) {
            if (crVar != null) {
                try {
                    ArrayList arrayList = this.c;
                    bq bqVar = (bq) this.j.c();
                    bqVar.b(crVar, 2);
                    arrayList.add(bqVar);
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (crVar2 != null) {
                ArrayList arrayList2 = this.c;
                bq bqVar2 = (bq) this.j.c();
                bqVar2.b(crVar2, 1);
                arrayList2.add(bqVar2);
            }
        }
        r();
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final void r() {
        if (this.x.get()) {
            return;
        }
        this.o.a();
        bu buVar = (bu) this.f540n.get();
        if (buVar == null || buVar.c.e.isDone()) {
            return;
        }
        boolean z = ((ed) buVar.b).f;
        synchronized (this) {
            com.google.android.libraries.navigation.internal.kk.m mVar = this.g.k;
            com.google.android.libraries.navigation.internal.yx.ar.q(mVar);
            mVar.b();
            this.g.j = SystemClock.elapsedRealtime();
        }
        buVar.c.a();
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final synchronized void s(com.google.android.libraries.navigation.internal.pz.d dVar) {
        bs bsVar = this.g;
        if (bsVar.f != dVar) {
            bsVar.f = dVar;
            r();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final void t(boolean z) {
        this.x.set(z);
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final synchronized void u(com.google.android.libraries.geo.mapcore.internal.model.aq aqVar) {
        bs bsVar = this.g;
        if (bsVar.g != aqVar) {
            bsVar.g = aqVar;
            r();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final synchronized void v(com.google.android.libraries.geo.mapcore.renderer.ax axVar, com.google.android.libraries.navigation.internal.pb.t tVar) {
        com.google.android.libraries.navigation.internal.yr.ai aiVarA = com.google.android.libraries.navigation.internal.yu.f.a();
        try {
            if (this.y == null) {
                this.y = new bv(axVar, tVar);
                A();
            }
            aiVarA.close();
        } catch (Throwable th) {
            try {
                aiVarA.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final boolean w() {
        if (!this.l || this.x.get()) {
            return true;
        }
        synchronized (this) {
            if (this.y != null && this.G) {
                bu buVar = (bu) this.f540n.get();
                com.google.android.libraries.navigation.internal.yx.ar.q(buVar);
                if (((ed) buVar.b).d.g()) {
                    return this.o.c();
                }
                return false;
            }
            return false;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final void x() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final void y() {
        if (!this.l) {
            this.l = true;
            r();
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005a A[Catch: all -> 0x006b, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0006, B:8:0x002a, B:10:0x0037, B:13:0x0042, B:18:0x005a, B:19:0x0061, B:16:0x004c), top: B:27:0x0001 }] */
    public final synchronized void z() {
        bv bvVar = this.y;
        if (bvVar != null) {
            bs bsVar = this.g;
            com.google.android.libraries.navigation.internal.pb.t tVar = bvVar.b;
            bsVar.c = tVar.s();
            this.g.d = tVar.r();
            this.g.e = tVar.n();
            this.g.b = tVar.a;
            if (this.l) {
                com.google.android.libraries.navigation.internal.pd.d dVarW = tVar.w();
                boolean z = false;
                if (dVarW.equals(this.t) && !this.t.equals(this.s)) {
                    z = true;
                }
                if (this.u.q() && z) {
                    this.g.a = dVarW;
                    r();
                } else {
                    bs bsVar2 = this.g;
                    if (bw.a(dVarW, bsVar2.a, bsVar2.d, bsVar2.e)) {
                        this.g.a = dVarW;
                        r();
                    }
                }
                this.s = this.t;
                this.t = dVarW;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.bk
    public final void m(Runnable runnable, Executor executor) {
        boolean z;
        a aVar = this.o;
        synchronized (aVar) {
            z = false;
            if (aVar.a) {
                aVar.e.add(new bo(runnable, executor));
            } else if (aVar.c) {
                aVar.d.add(new bo(runnable, executor));
            } else {
                z = true;
            }
        }
        if (z) {
            executor.execute(runnable);
        }
    }
}
