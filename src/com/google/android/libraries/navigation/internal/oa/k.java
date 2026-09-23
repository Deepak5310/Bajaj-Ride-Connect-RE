package com.google.android.libraries.navigation.internal.oa;

import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.geo.mapcore.internal.model.cj;
import com.google.android.libraries.geo.mapcore.internal.model.ct;
import com.google.android.libraries.geo.mapcore.renderer.ax;
import com.google.android.libraries.geo.mapcore.renderer.bg;
import com.google.android.libraries.geo.mapcore.renderer.ea;
import com.google.android.libraries.geo.mapcore.renderer.ep;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.nt.m;
import com.google.android.libraries.navigation.internal.ob.n;
import com.google.android.libraries.navigation.internal.ob.o;
import com.google.android.libraries.navigation.internal.ob.w;
import com.google.android.libraries.navigation.internal.oe.ap;
import com.google.android.libraries.navigation.internal.oe.aq;
import com.google.android.libraries.navigation.internal.oe.at;
import com.google.android.libraries.navigation.internal.om.v;
import com.google.android.libraries.navigation.internal.pb.t;
import com.google.android.libraries.navigation.internal.pi.aa;
import com.google.android.libraries.navigation.internal.pi.s;
import com.google.android.libraries.navigation.internal.pn.u;
import com.google.android.libraries.navigation.internal.po.bs;
import com.google.android.libraries.navigation.internal.po.cc;
import com.google.android.libraries.navigation.internal.po.dd;
import com.google.android.libraries.navigation.internal.po.dh;
import com.google.android.libraries.navigation.internal.po.ds;
import com.google.android.libraries.navigation.internal.po.el;
import com.google.android.libraries.navigation.internal.po.em;
import com.google.android.libraries.navigation.internal.po.eq;
import com.google.android.libraries.navigation.internal.po.er;
import com.google.android.libraries.navigation.internal.po.fk;
import com.google.android.libraries.navigation.internal.po.gq;
import com.google.android.libraries.navigation.internal.po.gr;
import com.google.android.libraries.navigation.internal.px.ag;
import com.google.android.libraries.navigation.internal.px.cr;
import com.google.android.libraries.navigation.internal.qd.x;
import com.google.android.libraries.navigation.internal.qq.al;
import com.google.android.libraries.navigation.internal.qu.cf;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.fz;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k implements o, com.google.android.libraries.navigation.internal.oi.a {
    private final com.google.android.libraries.navigation.internal.afo.a A;
    private final com.google.android.libraries.navigation.internal.pz.c B;
    private boolean C;
    private com.google.android.libraries.navigation.internal.pb.c G;
    private final ScheduledExecutorService I;
    private final Executor J;
    private final DisplayMetrics K;
    private final com.google.android.libraries.navigation.internal.qs.a L;
    public final com.google.android.libraries.navigation.internal.agl.a a;
    public final aq b;
    public final com.google.android.libraries.navigation.internal.afo.a c;
    public final com.google.android.libraries.navigation.internal.afo.a g;
    public final s h;
    public final w i;
    public final n k;
    public final com.google.android.libraries.navigation.internal.pq.b l;
    public final com.google.android.libraries.navigation.internal.qd.k m;
    public boolean o;
    public final gr p;
    private final com.google.android.libraries.navigation.internal.kl.b q;
    private final com.google.android.libraries.navigation.internal.mj.a r;
    private final com.google.android.libraries.navigation.internal.hp.e s;
    private final com.google.android.libraries.navigation.internal.qf.d t;
    private final com.google.android.libraries.navigation.internal.qt.a u;
    private final com.google.android.libraries.navigation.internal.agl.a v;
    private final com.google.android.libraries.navigation.internal.afo.a w;
    private final at x;
    private final com.google.android.libraries.navigation.internal.afo.a y;
    private final com.google.android.libraries.navigation.internal.afo.a z;
    public final ca d = new ca();
    final List e = new ArrayList();
    boolean f = false;
    public volatile boolean j = false;
    private boolean D = false;
    private Set E = new HashSet();
    private final Object F = new Object();
    private final AtomicBoolean H = new AtomicBoolean(false);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicBoolean f491n = new AtomicBoolean(false);

    public k(com.google.android.libraries.navigation.internal.afo.a aVar, n nVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.pq.b bVar, com.google.android.libraries.navigation.internal.pz.c cVar, com.google.android.libraries.navigation.internal.afo.a aVar4, gr grVar, com.google.android.libraries.navigation.internal.afo.a aVar5, s sVar, com.google.android.libraries.navigation.internal.qd.k kVar, com.google.android.libraries.navigation.internal.qs.a aVar6, com.google.android.libraries.navigation.internal.kl.b bVar2, com.google.android.libraries.navigation.internal.mj.a aVar7, com.google.android.libraries.navigation.internal.hp.e eVar, com.google.android.libraries.navigation.internal.qt.a aVar8, com.google.android.libraries.navigation.internal.qf.d dVar, ScheduledExecutorService scheduledExecutorService, Executor executor, com.google.android.libraries.navigation.internal.agl.a aVar9, com.google.android.libraries.navigation.internal.agl.a aVar10, com.google.android.libraries.navigation.internal.afo.a aVar11, at atVar, w wVar, DisplayMetrics displayMetrics) {
        this.c = aVar;
        this.k = nVar;
        this.y = aVar2;
        this.z = aVar3;
        this.l = bVar;
        this.A = aVar4;
        this.p = grVar;
        this.q = bVar2;
        this.r = aVar7;
        this.s = eVar;
        this.t = dVar;
        this.B = cVar;
        this.g = aVar5;
        this.h = sVar;
        this.m = kVar;
        this.L = aVar6;
        this.I = scheduledExecutorService;
        this.J = executor;
        this.u = aVar8;
        this.v = aVar9;
        this.a = aVar10;
        this.w = aVar11;
        this.x = atVar;
        this.b = new aq(atVar);
        this.i = wVar;
        this.K = displayMetrics;
    }

    private final com.google.android.libraries.navigation.internal.oy.a O() {
        return ((f) this.c.a()).c();
    }

    public final void A() {
        b().i();
    }

    public final void B() {
        b().k();
    }

    public final void C() {
        e eVarB = b();
        fk fkVar = (fk) eVarB;
        fkVar.h(com.google.android.libraries.navigation.internal.ob.h.SATELLITE, true);
        fkVar.o();
        synchronized (fkVar.P) {
            eq eqVar = ((fk) eVarB).S;
            if (eqVar == null) {
                eqVar = ((fk) eVarB).Q;
            }
            com.google.android.libraries.navigation.internal.po.f fVar = new com.google.android.libraries.navigation.internal.po.f(eqVar);
            fVar.b(com.google.android.libraries.navigation.internal.qq.e.r.a(((com.google.android.libraries.navigation.internal.qq.b) ((com.google.android.libraries.navigation.internal.po.g) eqVar).a).d));
            ((fk) eVarB).B(fVar.a());
        }
    }

    public final void D(boolean z) {
        fk fkVar = (fk) b();
        if (fkVar.V) {
            fkVar.v();
            if (fkVar.g != z) {
                fkVar.g = z;
                if (fkVar.F()) {
                    fkVar.i();
                }
            }
        }
    }

    public final void E(boolean z) {
        fk fkVar = (fk) b();
        if (fkVar.V) {
            fkVar.v();
            if (fkVar.f != z) {
                fkVar.f = z;
                if (fkVar.F()) {
                    fkVar.i();
                }
            }
        }
    }

    public final void F() {
        e eVarB = b();
        fk fkVar = (fk) eVarB;
        fkVar.h(com.google.android.libraries.navigation.internal.ob.h.TERRAIN, true);
        fkVar.o();
        synchronized (fkVar.P) {
            eq eqVar = ((fk) eVarB).S;
            if (eqVar == null) {
                eqVar = ((fk) eVarB).Q;
            }
            com.google.android.libraries.navigation.internal.po.f fVar = new com.google.android.libraries.navigation.internal.po.f(eqVar);
            fVar.b(com.google.android.libraries.navigation.internal.qq.e.s.a(((com.google.android.libraries.navigation.internal.qq.b) ((com.google.android.libraries.navigation.internal.po.g) eqVar).a).d));
            ((fk) eVarB).B(fVar.a());
        }
    }

    public final void G() {
        this.D = true;
        if (this.j) {
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("MapContainer.stopTrackingLocation");
            try {
                this.j = false;
                b().l(false);
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

    public final void H(String str, com.google.android.libraries.navigation.internal.qd.d dVar) {
        N(str, dVar);
    }

    public final boolean I() {
        return false;
    }

    public final boolean J(com.google.android.libraries.navigation.internal.ob.h hVar) {
        return b().m(hVar);
    }

    public final boolean K() {
        fk fkVar = (fk) b();
        fkVar.v();
        return fkVar.d;
    }

    public final void L(final com.google.android.libraries.navigation.internal.pb.c cVar) {
        if (!this.C) {
            this.G = cVar;
            return;
        }
        if (this.d.isDone()) {
            View viewA = ((f) this.c.a()).g().a();
            if (viewA.getWidth() > 0 && viewA.getHeight() > 0) {
                b().n(cVar);
                return;
            }
        }
        ((f) this.c.a()).g().a().post(new Runnable() { // from class: com.google.android.libraries.navigation.internal.oa.i
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b().n(cVar);
            }
        });
    }

    public final void M() {
        fk fkVar = (fk) b();
        if (fkVar.V) {
            fkVar.j.h(false);
            fkVar.y(false);
        }
    }

    public final void N(final String str, final com.google.android.libraries.navigation.internal.qd.d dVar) {
        synchronized (this.e) {
            if (!this.f) {
                this.e.add(new Runnable() { // from class: com.google.android.libraries.navigation.internal.oa.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.N(str, dVar);
                    }
                });
                return;
            }
            fk fkVar = (fk) b();
            com.google.android.libraries.navigation.internal.qd.d dVar2 = (com.google.android.libraries.navigation.internal.qd.d) fkVar.M.get(str);
            fkVar.M.put(str, dVar);
            if (dVar2 != null) {
                fkVar.A(dVar2);
            }
            if (fkVar.V) {
                fkVar.U.g(dVar);
            }
        }
    }

    public final View a() {
        return ((f) this.c.a()).g().a();
    }

    public final e b() {
        return ((f) this.c.a()).b();
    }

    public final t c() {
        return ((f) this.c.a()).d();
    }

    public final com.google.android.libraries.navigation.internal.pd.d d() {
        return c().w();
    }

    public final com.google.android.libraries.navigation.internal.qd.w e(ap apVar, cg cgVar, boolean z, int i) {
        cg cgVarZ = cgVar.z(b().b());
        x xVarF = f();
        cf cfVar = xVarF.f;
        return xVarF.e(apVar, cgVarZ, cfVar.b(apVar, cgVarZ), null, z, i, g());
    }

    public final x f() {
        ax axVar = (ax) this.A.a();
        com.google.android.libraries.navigation.internal.afo.a aVarH = ((f) this.c.a()).h();
        com.google.android.libraries.geo.mapcore.internal.model.x xVarF = ((f) this.c.a()).f();
        t tVarC = c();
        cf cfVar = (cf) this.z.a();
        com.google.android.libraries.navigation.internal.qf.d dVar = this.t;
        ar.q(dVar);
        com.google.android.libraries.navigation.internal.mj.a aVar = this.r;
        ar.q(aVar);
        com.google.android.libraries.navigation.internal.pg.d dVar2 = new com.google.android.libraries.navigation.internal.pg.d((ct) this.y.a());
        ct ctVar = (ct) this.y.a();
        ar.q(ctVar);
        com.google.android.libraries.navigation.internal.kg.c cVarA = ((f) this.c.a()).a();
        ar.q(cVarA);
        com.google.android.libraries.navigation.internal.kl.b bVar = this.q;
        ar.q(bVar);
        br brVarA = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.oa.j
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.l) this.a.a.a()).H());
            }
        });
        com.google.android.libraries.navigation.internal.afo.a aVarI = ((f) this.c.a()).i();
        com.google.android.libraries.navigation.internal.hp.e eVar = this.s;
        com.google.android.libraries.navigation.internal.agl.a aVar2 = this.v;
        return new x(axVar, aVarH, xVarF, tVarC, null, cfVar, this.l, this.m, dVar, aVar, eVar, this.I, this.J, dVar2, ctVar, cVarA, bVar, false, null, aVar2, this.L, this.x, brVarA, aVarI, false, this.K);
    }

    public final com.google.android.libraries.navigation.internal.qq.f g() {
        return b().c();
    }

    public final ax h() {
        return (ax) this.A.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.content.SharedPreferences$OnSharedPreferenceChangeListener, com.google.android.libraries.geo.mapcore.internal.model.w, com.google.android.libraries.navigation.internal.oa.e] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final synchronized void j() {
        if (!this.d.isDone()) {
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("MapContainer.ensureMapStarted");
            try {
                com.google.android.libraries.navigation.internal.oy.a aVarO = O();
                ?? B = b();
                bg bgVarG = ((f) this.c.a()).g();
                com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("PhoenixGoogleMap onCreate");
                try {
                    synchronized (((fk) B).P) {
                        ((fk) B).U.r(((com.google.android.libraries.navigation.internal.po.g) ((fk) B).Q).a);
                    }
                    ((fk) B).l.e(((fk) B).T);
                    d dVar = ((fk) B).ap;
                    com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.o.a = ((fk) B).t.getDisplayMetrics().density;
                    ((fk) B).X.n(((fk) B).v, ((fk) B).ab, ((fk) B).ac);
                    ax axVar = ((fk) B).B;
                    axVar.q = ((fk) B).ad;
                    al alVar = ((fk) B).j;
                    ar.k(axVar.k == null);
                    axVar.k = alVar;
                    ax axVar2 = ((fk) B).B;
                    t tVar = ((fk) B).i;
                    ar.k(axVar2.l == null);
                    axVar2.l = tVar;
                    al alVar2 = ((fk) B).j;
                    alVar2.b = ((fk) B).U;
                    alVar2.g(((fk) B).I);
                    ((fk) B).j.g(((fk) B).G);
                    ((fk) B).j.g(((fk) B).F);
                    Iterator it2 = ((fk) B).f524n.iterator();
                    while (it2.hasNext()) {
                        ((fk) B).m.g((cr) it2.next());
                    }
                    ((fk) B).f524n.clear();
                    ((fk) B).m.g(((fk) B).H.b);
                    com.google.android.libraries.navigation.internal.pc.g gVar = ((fk) B).l;
                    ((fk) B).o = aVarO;
                    ((fk) B).p = bgVarG;
                    cj.a[0] = ((com.google.android.libraries.navigation.internal.om.l) ((fk) B).ag.a()).F();
                    ((fk) B).q = new el((fk) B, bgVarG, (com.google.android.libraries.navigation.internal.qe.e) gVar);
                    com.google.android.libraries.navigation.internal.po.l lVar = new com.google.android.libraries.navigation.internal.po.l(bgVarG.a(), ((fk) B).i, gVar, new em(new Handler(Looper.getMainLooper())));
                    if (!((Boolean) ((fk) B).R.a()).booleanValue()) {
                        com.google.android.libraries.navigation.internal.pc.g gVar2 = ((fk) B).l;
                        u uVarA = ((fk) B).o.a();
                        float f = ((fk) B).Y.getResources().getDisplayMetrics().density;
                        bgVarG.a().setOnKeyListener(new cc(uVarA));
                    }
                    ((fk) B).k = lVar;
                    ((fk) B).V = true;
                    com.google.android.libraries.navigation.internal.ia.e eVar = ((fk) B).v;
                    er erVar = ((fk) B).an;
                    fz fzVar = new fz();
                    fzVar.b(aa.class, new gq(aa.class, erVar, com.google.android.libraries.navigation.internal.hx.ap.DANGEROUS_PUBLISHER_THREAD));
                    eVar.c(erVar, fzVar.a());
                    ((fk) B).w.a(((fk) B).F, ((fk) B).z);
                    ((fk) B).w.a(((fk) B).G, ((fk) B).z);
                    synchronized (((fk) B).P) {
                        com.google.android.libraries.geo.mapcore.internal.model.x xVar = ((fk) B).u;
                        eq eqVar = ((fk) B).Q;
                        xVar.i(((com.google.android.libraries.navigation.internal.po.g) eqVar).b, eqVar.c(), ((fk) B).b, B);
                        ((fk) B).C(true);
                    }
                    ((fk) B).x.l(B);
                    if (dVarB2 != null) {
                        Trace.endSection();
                    }
                    b().g(this.B);
                    if (!((com.google.android.libraries.navigation.internal.ob.f) this.g.a()).e()) {
                        b().l(false);
                    } else if (!this.D && !this.j) {
                        com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("MapContainer.startTrackingLocation");
                        try {
                            this.j = true;
                            if (dVarB3 != null) {
                                Trace.endSection();
                            }
                        } catch (Throwable th) {
                            if (dVarB3 != null) {
                                try {
                                    Trace.endSection();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    }
                    synchronized (this.F) {
                        Set set = this.E;
                        if (set != null) {
                            this.E = null;
                            Iterator it3 = set.iterator();
                            while (it3.hasNext()) {
                                i((com.google.android.libraries.navigation.internal.pc.e) it3.next());
                            }
                        }
                    }
                    synchronized (this.e) {
                        this.f = true;
                        Iterator it4 = this.e.iterator();
                        while (it4.hasNext()) {
                            ((Runnable) it4.next()).run();
                        }
                        this.e.clear();
                    }
                    this.d.d(b());
                    if (dVarB != null) {
                        Trace.endSection();
                    }
                } catch (Throwable th3) {
                    if (dVarB2 != null) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                if (dVarB != null) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        }
    }

    public final void k() {
        fk fkVar = (fk) b();
        fkVar.Z.a.b();
        com.google.android.libraries.navigation.internal.ps.b bVar = fkVar.ac;
        synchronized (bVar) {
            bVar.e = true;
        }
        fkVar.U.h();
    }

    @Deprecated
    public final void l(Point point) {
        this.i.a(point);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.content.SharedPreferences$OnSharedPreferenceChangeListener, com.google.android.libraries.geo.mapcore.internal.model.u, com.google.android.libraries.navigation.internal.oa.e] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void m() {
        fy fyVarO;
        if (this.d.isDone()) {
            ?? B = b();
            fk fkVar = (fk) B;
            fkVar.v.e(fkVar.an);
            fkVar.w.k(fkVar.F);
            fkVar.w.k(fkVar.G);
            com.google.android.libraries.navigation.internal.qk.n nVar = fkVar.K;
            nVar.b.j(nVar.f.e);
            nVar.g = true;
            fkVar.X.p();
            fkVar.u.g(B);
            fkVar.u.c();
            fkVar.x.v(B);
            bg bgVar = fkVar.p;
            if (bgVar != null) {
                bgVar.c();
            }
            fkVar.U.k();
            fkVar.C.f();
            dh dhVar = fkVar.H;
            dhVar.a.y(dhVar.i);
            dd ddVar = dhVar.b;
            synchronized (ddVar) {
                fyVarO = fy.o(ddVar.d);
                ddVar.d.clear();
            }
            nn nnVarListIterator = fyVarO.listIterator();
            while (nnVarListIterator.hasNext()) {
                ((ag) nnVarListIterator.next()).a();
            }
            fkVar.m.j();
            bs bsVar = fkVar.ad;
            com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
            Runnable runnable = bsVar.g;
            if (runnable != null) {
                bsVar.l.n(runnable);
                bsVar.g = null;
            }
            bsVar.k.a = true;
            ax axVar = fkVar.B;
            if (ea.i.get() != ea.IDLE) {
                ea.i.get();
            }
            ea.i.set(ea.INVALID);
            ep epVar = axVar.m;
            ep epVar2 = axVar.f75n;
            ep epVar3 = axVar.o;
            if (axVar.A != null) {
                AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener = axVar.B;
            }
            synchronized (axVar) {
                int i = ev.d;
                axVar.g = lv.a;
            }
            axVar.e.c();
            fkVar.j.i(fkVar.I);
            fkVar.j.i(fkVar.G);
            fkVar.j.i(fkVar.F);
            fkVar.j.h(true);
            fkVar.y(true);
            fkVar.V = false;
            synchronized (fkVar.P) {
                ((fk) B).I.w();
            }
        }
        synchronized (this.e) {
            this.e.clear();
        }
    }

    public final void n() {
        if (this.H.compareAndSet(false, true)) {
            this.m.j();
        }
    }

    public final void o() {
        final fk fkVar = (fk) b();
        fkVar.u.e();
        if (fkVar.V) {
            if (fkVar.U.w(((v) fkVar.aa.a()).d(fkVar.b), ((v) fkVar.aa.a()).b(fkVar.b, fkVar.t()))) {
                fkVar.z.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.ec
                    @Override // java.lang.Runnable
                    public final void run() {
                        fkVar.z();
                    }
                });
            }
        }
    }

    public final void p() {
        e eVarB = b();
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("PhoenixGoogleMap.onParametersChanged");
        try {
            final fk fkVar = (fk) eVarB;
            ((fk) eVarB).A.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.eg
                @Override // java.lang.Runnable
                public final void run() {
                    fk fkVar2 = fkVar;
                    try {
                        fkVar2.U.i();
                    } catch (RuntimeException e) {
                        ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) fk.a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 889)).p("Failure in overlayManager.onParametersChanged");
                    }
                    nn nnVarListIterator = fkVar2.al.a().listIterator();
                    while (nnVarListIterator.hasNext()) {
                        com.google.android.libraries.navigation.internal.adi.an anVar = (com.google.android.libraries.navigation.internal.adi.an) nnVarListIterator.next();
                        fkVar2.j(anVar, fkVar2.H(anVar));
                    }
                }
            });
            try {
                ((fk) eVarB).ae.c();
            } catch (RuntimeException e) {
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) fk.a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F(892)).p("Failure in zoomTableManager.onParametersChanged");
            }
            try {
                ((fk) eVarB).u.f();
            } catch (RuntimeException e2) {
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) fk.a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e2)).F(891)).p("Failure in globalStyleTables.onParametersChanged");
            }
            try {
                ((fk) eVarB).y.f();
            } catch (RuntimeException e3) {
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) fk.a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e3)).F(890)).p("Failure in resourceManager.onParametersChanged");
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

    public final void q() {
        this.C = true;
        j();
        b().d();
        com.google.android.libraries.navigation.internal.qt.a aVar = this.u;
        synchronized (aVar) {
            aVar.a++;
        }
        aVar.b();
        com.google.android.libraries.navigation.internal.pb.c cVar = this.G;
        if (cVar != null) {
            L(cVar);
            this.G = null;
        }
    }

    public final void r() {
        com.google.android.libraries.navigation.internal.kg.c cVar;
        c cVar2;
        com.google.android.libraries.navigation.internal.ob.i iVar;
        com.google.android.libraries.navigation.internal.pd.d dVarW = c().w();
        if (this.o && (iVar = (cVar2 = (c) this.g.a()).b) != null) {
            iVar.b(dVarW, Boolean.TRUE.equals(cVar2.e));
        }
        com.google.android.libraries.navigation.internal.qt.a aVar = this.u;
        synchronized (aVar) {
            ar.k(aVar.a > 0);
            aVar.a--;
        }
        aVar.b();
        fk fkVar = (fk) b();
        ar.q(fkVar.o);
        m mVarC = fkVar.U.c();
        com.google.android.libraries.navigation.internal.nt.t tVar = fkVar.ah;
        ar.q(tVar);
        mVarC.h(tVar);
        m mVarB = fkVar.m.b();
        com.google.android.libraries.navigation.internal.nt.t tVar2 = fkVar.ai;
        ar.q(tVar2);
        mVarB.h(tVar2);
        ((com.google.android.libraries.navigation.internal.qe.j) fkVar.o).d = true;
        ax axVar = fkVar.B;
        fkVar.u.d();
        fkVar.U.m();
        al alVar = fkVar.j;
        bg bgVar = alVar.e;
        ar.q(bgVar);
        bgVar.e();
        com.google.android.libraries.navigation.internal.ox.c cVar3 = alVar.i;
        ar.q(cVar3);
        cVar3.e();
        com.google.android.libraries.navigation.internal.pk.c cVar4 = alVar.o;
        if (cVar4 != null && (cVar = alVar.f) != null) {
            cVar.k.remove(cVar4);
        }
        alVar.h.a(new aa(true));
        fkVar.c = false;
        fkVar.y(true);
        this.C = false;
    }

    public final void t(final String str) {
        synchronized (this.e) {
            if (!this.f) {
                this.e.add(new Runnable() { // from class: com.google.android.libraries.navigation.internal.oa.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.t(str);
                    }
                });
                return;
            }
            fk fkVar = (fk) b();
            com.google.android.libraries.navigation.internal.qd.d dVar = (com.google.android.libraries.navigation.internal.qd.d) fkVar.M.remove(str);
            if (dVar != null) {
                fkVar.A(dVar);
            }
        }
    }

    public final void u(com.google.android.libraries.navigation.internal.ql.a aVar) {
        com.google.android.libraries.navigation.internal.qe.j jVar = (com.google.android.libraries.navigation.internal.qe.j) O();
        jVar.c = aVar;
        jVar.q();
        ((fk) b()).ao = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.oi.a
    public final void v(boolean z) {
        fk fkVar = (fk) b();
        if (fkVar.V) {
            fkVar.v();
            if (fkVar.e != z) {
                fkVar.e = z;
                if (fkVar.F()) {
                    fkVar.i();
                } else if (fkVar.m(com.google.android.libraries.navigation.internal.ob.h.SATELLITE)) {
                    fkVar.k();
                }
            }
        }
    }

    public final void w(boolean z) {
        e eVarB = b();
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("PhoenixGoogleMap.setDarkModeEnabled");
        try {
            ((fk) eVarB).v();
            synchronized (((fk) eVarB).P) {
                eq eqVar = ((fk) eVarB).S;
                if (eqVar == null) {
                    eqVar = ((fk) eVarB).Q;
                }
                com.google.android.libraries.navigation.internal.qq.f fVar = ((com.google.android.libraries.navigation.internal.po.g) eqVar).a;
                if (z != ((com.google.android.libraries.navigation.internal.qq.b) fVar).d) {
                    com.google.android.libraries.navigation.internal.po.f fVar2 = new com.google.android.libraries.navigation.internal.po.f(eqVar);
                    fVar2.b(fVar.f(z));
                    ((fk) eVarB).B(fVar2.a());
                    if (!((fk) eVarB).F()) {
                        if (((fk) eVarB).m(com.google.android.libraries.navigation.internal.ob.h.TERRAIN)) {
                            com.google.android.libraries.navigation.internal.qd.w wVarF = ((fk) eVarB).r.f(z ? an.GMM_TERRAIN_DARK : an.GMM_TERRAIN, ((fk) eVarB).b());
                            ds dsVar = ((fk) eVarB).U;
                            com.google.android.libraries.navigation.internal.qd.w wVar = (com.google.android.libraries.navigation.internal.qd.w) ((fk) eVarB).N.get(com.google.android.libraries.navigation.internal.ob.h.TERRAIN);
                            ar.q(wVar);
                            dsVar.o(wVar, wVarF);
                            ((fk) eVarB).N.put(com.google.android.libraries.navigation.internal.ob.h.TERRAIN, wVarF);
                        }
                    }
                }
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

    public final void x(com.google.android.libraries.navigation.internal.ob.h hVar, boolean z) {
        b().h(hVar, z);
    }

    @Override // com.google.android.libraries.navigation.internal.oi.a
    public final void y(boolean z) {
        fk fkVar = (fk) b();
        fkVar.v();
        if (z == fkVar.d) {
            return;
        }
        fkVar.d = z;
        if (fkVar.F()) {
            fkVar.i();
        }
    }

    public final void z() {
        e eVarB = b();
        fk fkVar = (fk) eVarB;
        fkVar.v();
        fkVar.u();
        fkVar.o();
        synchronized (fkVar.P) {
            eq eqVar = ((fk) eVarB).S;
            if (eqVar == null) {
                eqVar = ((fk) eVarB).Q;
            }
            com.google.android.libraries.navigation.internal.po.f fVar = new com.google.android.libraries.navigation.internal.po.f(eqVar);
            fVar.b(com.google.android.libraries.navigation.internal.qq.e.a.a(((com.google.android.libraries.navigation.internal.qq.b) ((com.google.android.libraries.navigation.internal.po.g) eqVar).a).d));
            ((fk) eVarB).B(fVar.a());
        }
    }

    public final void i(com.google.android.libraries.navigation.internal.pc.e eVar) {
        com.google.android.libraries.navigation.internal.po.l lVar;
        boolean zAdd;
        synchronized (this.F) {
            Set set = this.E;
            if (set == null) {
                e eVarB = b();
                if (((fk) eVarB).V && (lVar = ((fk) eVarB).k) != null) {
                    synchronized (lVar) {
                        if (lVar.d == null) {
                            lVar.d = new HashSet();
                        }
                        zAdd = lVar.d.add(eVar);
                    }
                    if (zAdd) {
                        lVar.c();
                    }
                }
            } else {
                set.add(eVar);
            }
        }
    }

    public final void s(com.google.android.libraries.navigation.internal.pc.e eVar) {
        com.google.android.libraries.navigation.internal.po.l lVar;
        synchronized (this.F) {
            Set set = this.E;
            if (set == null) {
                e eVarB = b();
                if (((fk) eVarB).V && (lVar = ((fk) eVarB).k) != null) {
                    synchronized (lVar) {
                        Set set2 = lVar.d;
                        if (set2 != null) {
                            set2.remove(eVar);
                            if (lVar.d.isEmpty()) {
                                lVar.d = null;
                            }
                            lVar.c();
                        }
                    }
                }
            } else {
                set.remove(eVar);
            }
        }
    }
}
