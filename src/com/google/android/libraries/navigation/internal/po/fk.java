package com.google.android.libraries.navigation.internal.po;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.os.Looper;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.yz.nn;
import j$.time.Duration;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class fk implements SharedPreferences.OnSharedPreferenceChangeListener, com.google.android.libraries.geo.mapcore.internal.model.u, com.google.android.libraries.navigation.internal.oa.e, com.google.android.libraries.navigation.internal.pp.e, com.google.android.libraries.geo.mapcore.internal.model.w {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.po.fk");
    private static final com.google.android.libraries.navigation.internal.yz.fy ar = com.google.android.libraries.navigation.internal.yz.fy.s(com.google.android.libraries.navigation.internal.ob.h.TRAFFIC, com.google.android.libraries.navigation.internal.ob.h.TRANSIT, com.google.android.libraries.navigation.internal.ob.h.BICYCLING, com.google.android.libraries.navigation.internal.ob.h.THREE_DIMENSIONAL);
    private static final com.google.android.libraries.navigation.internal.adi.an as = com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE;
    private static final com.google.android.libraries.navigation.internal.yx.as at = new com.google.android.libraries.navigation.internal.yx.as() { // from class: com.google.android.libraries.navigation.internal.po.eh
        @Override // com.google.android.libraries.navigation.internal.yx.as
        public final boolean a(Object obj) {
            return fk.G((com.google.android.libraries.navigation.internal.adg.ef) obj);
        }
    };
    public final com.google.android.libraries.navigation.internal.aac.bn A;
    public final com.google.android.libraries.geo.mapcore.renderer.ax B;
    public final gr C;
    public com.google.android.libraries.navigation.internal.ob.t D;
    public com.google.android.libraries.navigation.internal.hj.i E;
    public final d F;
    public final Cdo G;
    public final dh H;
    public final hi I;
    public final bw J;
    public final com.google.android.libraries.navigation.internal.qk.n K;
    public final dp L;
    public final Object P;
    public eq Q;
    public final com.google.android.libraries.navigation.internal.yx.br R;
    public eq S;
    public final com.google.android.libraries.navigation.internal.pc.a T;
    public final ds U;
    public boolean V;
    public final AtomicBoolean W;
    public final com.google.android.libraries.navigation.internal.ps.y X;
    public final Context Y;
    public final com.google.android.libraries.navigation.internal.ra.a Z;
    private final com.google.android.libraries.navigation.internal.qu.cf aA;
    private final com.google.android.libraries.navigation.internal.rq.i aB;
    private com.google.android.libraries.navigation.internal.qd.w aC;
    private boolean aD;
    private com.google.android.libraries.navigation.internal.qd.w aE;
    private final Object aF;
    private com.google.android.libraries.navigation.internal.qd.w aG;
    private final Object aH;
    private com.google.android.libraries.navigation.internal.qd.w aI;
    private boolean aJ;
    private final AtomicBoolean aK;
    private final com.google.android.libraries.navigation.internal.agl.a aL;
    private final com.google.android.libraries.navigation.internal.oe.m aM;
    private final boolean aN;
    private volatile com.google.android.libraries.navigation.internal.kk.e aO;
    public final com.google.android.libraries.navigation.internal.agl.a aa;
    public final com.google.android.libraries.navigation.internal.ps.h ab;
    public final com.google.android.libraries.navigation.internal.ps.b ac;
    public final bs ad;
    public final com.google.android.libraries.geo.mapcore.internal.model.ct ae;
    public final com.google.android.libraries.navigation.internal.di.b af;
    public final com.google.android.libraries.navigation.internal.agl.a ag;
    public final com.google.android.libraries.navigation.internal.nt.t ah;
    public final com.google.android.libraries.navigation.internal.nt.t ai;
    public final Object aj;
    public com.google.android.libraries.navigation.internal.kk.m ak;
    public final fi al;
    public final com.google.android.libraries.navigation.internal.qd.k am;
    public final er an;
    public com.google.android.libraries.navigation.internal.ql.a ao;
    public volatile com.google.android.libraries.navigation.internal.oa.d ap;
    public final com.google.android.libraries.navigation.internal.pu.k aq;
    private final boolean ay;
    public String b;
    public boolean d;
    public final com.google.android.libraries.navigation.internal.kl.b h;
    public final com.google.android.libraries.navigation.internal.pb.t i;
    public final com.google.android.libraries.navigation.internal.qq.al j;
    public l k;
    public final com.google.android.libraries.navigation.internal.pc.g l;
    public final com.google.android.libraries.navigation.internal.px.bk m;
    public com.google.android.libraries.navigation.internal.oy.a o;
    public com.google.android.libraries.geo.mapcore.renderer.bg p;
    public com.google.android.libraries.navigation.internal.pb.b q;
    public final com.google.android.libraries.navigation.internal.qd.x r;
    public final com.google.android.libraries.navigation.internal.oe.aq s;
    public final Resources t;
    public final com.google.android.libraries.geo.mapcore.internal.model.x u;
    public final com.google.android.libraries.navigation.internal.ia.e v;
    public final com.google.android.libraries.navigation.internal.pi.s w;
    public final com.google.android.libraries.navigation.internal.iv.f x;
    public final com.google.android.libraries.navigation.internal.qy.h y;
    public final Executor z;
    public boolean c = true;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    private boolean au = false;
    private com.google.android.libraries.navigation.internal.qq.e av = null;
    private final AtomicBoolean aw = new AtomicBoolean(false);
    private final AtomicBoolean ax = new AtomicBoolean(false);
    private final Set az = new HashSet();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List f524n = new ArrayList();
    public final Map M = new HashMap();
    public final Map N = new EnumMap(com.google.android.libraries.navigation.internal.ob.h.class);
    public final Map O = new EnumMap(com.google.android.libraries.navigation.internal.adi.an.class);

    public fk(String str, bw bwVar, gr grVar, com.google.android.libraries.geo.mapcore.renderer.ax axVar, com.google.android.libraries.navigation.internal.ps.y yVar, com.google.android.libraries.navigation.internal.pb.t tVar, com.google.android.libraries.navigation.internal.qq.al alVar, Context context, final com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.oe.m mVar, com.google.android.libraries.navigation.internal.qd.k kVar, com.google.android.libraries.navigation.internal.pc.g gVar, bs bsVar, ds dsVar, com.google.android.libraries.navigation.internal.px.bk bkVar, com.google.android.libraries.navigation.internal.qd.x xVar, com.google.android.libraries.navigation.internal.oe.aq aqVar, hi hiVar, dh dhVar, Cdo cdo, d dVar, com.google.android.libraries.navigation.internal.px.ca caVar, com.google.android.libraries.navigation.internal.fq.f fVar, com.google.android.libraries.navigation.internal.kl.b bVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.pi.s sVar, com.google.android.libraries.geo.mapcore.internal.model.x xVar2, com.google.android.libraries.navigation.internal.iv.f fVar2, com.google.android.libraries.navigation.internal.qy.h hVar, com.google.android.libraries.navigation.internal.ra.a aVar4, Executor executor, com.google.android.libraries.navigation.internal.aac.bn bnVar, com.google.android.libraries.navigation.internal.qu.cf cfVar, com.google.android.libraries.geo.mapcore.internal.model.ct ctVar, com.google.android.libraries.navigation.internal.qk.n nVar, dp dpVar, com.google.android.libraries.navigation.internal.ob.t tVar2, com.google.android.libraries.navigation.internal.di.b bVar2, com.google.android.libraries.navigation.internal.qd.w wVar, com.google.android.libraries.navigation.internal.qd.w wVar2, final com.google.android.libraries.navigation.internal.pu.k kVar2, boolean z, boolean z2, fi fiVar, boolean z3) {
        Object obj = new Object();
        this.P = obj;
        this.aD = false;
        this.aF = new Object();
        this.aH = new Object();
        this.aJ = false;
        this.aK = new AtomicBoolean(false);
        new AtomicBoolean(false);
        this.W = new AtomicBoolean(false);
        this.ah = new com.google.android.libraries.navigation.internal.nt.t() { // from class: com.google.android.libraries.navigation.internal.po.ej
            /* JADX WARN: Code duplicated, block: B:8:0x0027 A[Catch: all -> 0x002c, TryCatch #0 {, blocks: (B:5:0x0007, B:7:0x0016, B:9:0x002a, B:8:0x0027), top: B:14:0x0007 }] */
            @Override // com.google.android.libraries.navigation.internal.nt.t
            public final void a(com.google.android.libraries.navigation.internal.nt.m mVar2) {
                fk fkVar = this.a;
                synchronized (fkVar.aj) {
                    if (mVar2 != null) {
                        Boolean bool = (Boolean) mVar2.c();
                        com.google.android.libraries.navigation.internal.yx.ar.q(bool);
                        if (bool.booleanValue()) {
                            fkVar.ak = ((com.google.android.libraries.navigation.internal.kk.n) fkVar.h.a(com.google.android.libraries.navigation.internal.km.as.a)).a();
                        } else {
                            fkVar.ak = null;
                        }
                    } else {
                        fkVar.ak = null;
                    }
                    throw th;
                }
            }
        };
        this.ai = new com.google.android.libraries.navigation.internal.nt.t() { // from class: com.google.android.libraries.navigation.internal.po.ek
            @Override // com.google.android.libraries.navigation.internal.nt.t
            public final void a(com.google.android.libraries.navigation.internal.nt.m mVar2) {
                com.google.android.libraries.navigation.internal.kk.m mVar3;
                fk fkVar = this.a;
                synchronized (fkVar.aj) {
                    if (mVar2 != null) {
                        Boolean bool = (Boolean) mVar2.c();
                        com.google.android.libraries.navigation.internal.yx.ar.q(bool);
                        if (bool.booleanValue() && (mVar3 = fkVar.ak) != null) {
                            mVar3.a();
                            com.google.android.libraries.navigation.internal.kk.m mVar4 = fkVar.ak;
                            com.google.android.libraries.navigation.internal.yx.ar.q(mVar4);
                            com.google.android.libraries.navigation.internal.ky.an anVar = mVar4.a;
                            (anVar != null ? Duration.ofMillis(anVar.a()) : Duration.ZERO).toMillis();
                            fkVar.ak = null;
                        }
                    }
                }
            }
        };
        this.aj = new Object();
        this.an = new er(this);
        this.b = str;
        this.h = bVar;
        this.v = eVar;
        this.w = sVar;
        this.u = xVar2;
        this.x = fVar2;
        this.y = hVar;
        this.z = executor;
        this.A = bnVar;
        this.aA = cfVar;
        this.ae = ctVar;
        this.C = grVar;
        this.B = axVar;
        this.X = yVar;
        this.i = tVar;
        this.j = alVar;
        this.Y = context;
        this.Z = aVar4;
        this.t = context.getResources();
        this.aO = bVar.c();
        this.aL = aVar2;
        this.aa = aVar3;
        this.J = bwVar;
        this.I = hiVar;
        this.H = dhVar;
        this.G = cdo;
        this.F = dVar;
        this.am = kVar;
        this.aM = mVar;
        this.l = gVar;
        this.ad = bsVar;
        this.r = xVar;
        this.s = aqVar;
        this.m = bkVar;
        this.U = dsVar;
        this.aB = com.google.android.libraries.navigation.internal.rq.i.a;
        this.D = tVar2;
        this.af = bVar2;
        this.ay = z;
        this.d = false;
        this.al = fiVar;
        this.ag = aVar;
        this.aq = kVar2;
        this.aN = false;
        this.R = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.dz
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                com.google.android.libraries.navigation.internal.zb.j jVar = fk.a;
                com.google.android.libraries.navigation.internal.pu.k kVar3 = kVar2;
                return Boolean.valueOf(kVar3 != null ? kVar3.a() : ((com.google.android.libraries.navigation.internal.om.l) aVar.a()).y());
            }
        });
        synchronized (obj) {
            f fVar3 = new f();
            fVar3.c(-1);
            fVar3.b(K().a(z2));
            eq eqVarA = fVar3.a();
            this.Q = eqVarA;
            this.aD = z2;
            this.S = new f(eqVarA).a();
            en enVar = en.LEGACY_AMBIENT;
        }
        this.K = nVar;
        this.L = dpVar;
        this.aG = wVar;
        dsVar.g(wVar);
        this.aI = null;
        com.google.android.libraries.navigation.internal.ps.h hVar2 = new com.google.android.libraries.navigation.internal.ps.h(fVar, bnVar, cfVar);
        this.ab = hVar2;
        this.ac = new com.google.android.libraries.navigation.internal.ps.b(hVar2);
        if (kVar2 == null || !kVar2.c()) {
            nn nnVarListIterator = fiVar.a().listIterator();
            while (nnVarListIterator.hasNext()) {
                com.google.android.libraries.navigation.internal.adi.an anVar = (com.google.android.libraries.navigation.internal.adi.an) nnVarListIterator.next();
                if (H(anVar)) {
                    synchronized (this.O) {
                        com.google.android.libraries.navigation.internal.qd.w wVarJ = J(anVar);
                        if (wVarJ != null) {
                            this.O.put(anVar, wVarJ);
                            dsVar.g(wVarJ);
                        }
                    }
                }
            }
        }
        caVar.e = bkVar;
        this.H.f = caVar;
        dsVar.j();
        this.T = new eo(this.az);
        C(false);
        xVar2.a(this);
        xVar2.b();
    }

    static /* synthetic */ boolean G(com.google.android.libraries.navigation.internal.adg.ef efVar) {
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.W);
        efVar.h(bhVarS);
        return efVar.w.n(bhVarS.d);
    }

    private final com.google.android.libraries.navigation.internal.qd.w J(com.google.android.libraries.navigation.internal.adi.an anVar) {
        com.google.android.libraries.navigation.internal.oe.ap apVarB;
        if (this.al.b.containsKey(anVar)) {
            if (this.E == null) {
                this.E = this.af.c();
            }
            if (I(anVar)) {
                apVarB = this.s.c(anVar, this.E.c);
            } else {
                if (!this.al.b(anVar)) {
                    return null;
                }
                apVarB = this.s.b(anVar);
            }
        } else {
            apVarB = this.s.b(anVar);
        }
        ds dsVar = this.U;
        Object obj = this.P;
        com.google.android.libraries.geo.mapcore.internal.model.cg cgVarE = dsVar.e();
        synchronized (obj) {
            if (anVar == com.google.android.libraries.navigation.internal.adi.an.EVCS) {
                return this.r.a(apVarB, cgVarE, ((g) this.Q).a);
            }
            return this.r.b(apVarB, cgVarE, ((g) this.Q).a, false);
        }
    }

    private final com.google.android.libraries.navigation.internal.qq.e K() {
        if (this.ay || this.e) {
            return this.d ? com.google.android.libraries.navigation.internal.qq.e.j : com.google.android.libraries.navigation.internal.qq.e.c;
        }
        if (this.N.containsKey(com.google.android.libraries.navigation.internal.ob.h.AIR_QUALITY_HEATMAP)) {
            return com.google.android.libraries.navigation.internal.qq.e.y;
        }
        if (this.N.containsKey(com.google.android.libraries.navigation.internal.ob.h.BICYCLING)) {
            return this.d ? com.google.android.libraries.navigation.internal.qq.e.o : com.google.android.libraries.navigation.internal.qq.e.b;
        }
        if (this.d) {
            return com.google.android.libraries.navigation.internal.qq.e.p;
        }
        if (this.N.containsKey(com.google.android.libraries.navigation.internal.ob.h.TRANSIT) || this.g) {
            return com.google.android.libraries.navigation.internal.qq.e.t;
        }
        if (this.N.containsKey(com.google.android.libraries.navigation.internal.ob.h.THREE_DIMENSIONAL)) {
            return com.google.android.libraries.navigation.internal.qq.e.b;
        }
        return this.f ? com.google.android.libraries.navigation.internal.qq.e.v : com.google.android.libraries.navigation.internal.qq.e.b;
    }

    private final void L(eq eqVar, com.google.android.libraries.geo.mapcore.internal.model.v vVar) {
        com.google.android.libraries.navigation.internal.yz.ev evVarO;
        com.google.android.libraries.navigation.internal.yz.ev evVarO2;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("PhoenixGoogleMap.updateDrawingConfig");
        try {
            com.google.android.libraries.geo.mapcore.internal.model.v vVarP = this.I.p();
            boolean z = (vVarP != null && vVarP.b == eqVar.c() && vVarP.a == ((g) eqVar).b) ? false : true;
            if (!eqVar.equals(this.Q) || z) {
                boolean zG = ((g) eqVar).a.g(((g) this.Q).a);
                this.Q = eqVar;
                com.google.android.libraries.geo.mapcore.internal.model.cg cgVarB = b();
                Object objA = this.aa.a();
                String str = this.b;
                com.google.android.libraries.navigation.internal.adi.an anVar = as;
                com.google.android.libraries.geo.mapcore.internal.model.cg cgVarY = cgVarB.y(((com.google.android.libraries.navigation.internal.om.v) objA).a(str, anVar), ((com.google.android.libraries.navigation.internal.om.v) this.aa.a()).b(this.b, this.Q.c().E), ((com.google.android.libraries.navigation.internal.qq.b) ((g) this.Q).a).a);
                boolean zEquals = cgVarY.equals(this.aG.e);
                if (!zG || !zEquals) {
                    com.google.android.libraries.navigation.internal.qd.w wVarC = this.r.c(anVar, cgVarY, ((g) this.Q).a, false);
                    synchronized (this.aF) {
                        this.U.o(this.aG, wVarC);
                        this.aG = wVarC;
                    }
                }
                this.U.r(((g) this.Q).a);
                this.U.u(this.Q.c());
                synchronized (this.aH) {
                    com.google.android.libraries.navigation.internal.qd.w wVar = this.aI;
                    if (wVar != null && wVar.B.b != this.Q.c()) {
                        com.google.android.libraries.navigation.internal.qd.w wVar2 = this.aI;
                        com.google.android.libraries.navigation.internal.yx.ar.q(wVar2);
                        wVar2.H(this.Q.c());
                    }
                }
                hi hiVar = this.I;
                hiVar.h.set(new com.google.android.libraries.geo.mapcore.internal.model.v(vVar));
                synchronized (hiVar.i) {
                    evVarO = com.google.android.libraries.navigation.internal.yz.ev.o(hiVar.i);
                }
                int size = evVarO.size();
                for (int i = 0; i < size; i++) {
                    ((com.google.android.libraries.navigation.internal.ol.aw) evVarO.get(i)).a(vVar.b.E);
                }
                this.aA.g(((g) this.Q).b);
                bw bwVar = this.J;
                synchronized (bwVar) {
                    bwVar.b = true;
                    evVarO2 = com.google.android.libraries.navigation.internal.yz.ev.o(bwVar.c);
                    bwVar.c.clear();
                }
                if (evVarO2 != null) {
                    int size2 = evVarO2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((Runnable) evVarO2.get(i2)).run();
                    }
                }
                this.m.h();
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

    public final void A(com.google.android.libraries.navigation.internal.qd.d dVar) {
        if (this.V) {
            this.U.n(dVar);
        }
    }

    public final void B(eq eqVar) {
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVarC = eqVar.c();
        synchronized (this.P) {
            this.S = eqVar;
            int i = ((g) eqVar).b;
            eq eqVar2 = this.Q;
            if (((g) eqVar2).b == -1 || !eqVar.equals(eqVar2)) {
                if (this.c) {
                    this.u.i(i, aqVarC, this.b, this);
                }
            }
        }
    }

    public final void C(boolean z) {
        this.U.s(z);
        if (this.ax.compareAndSet(z, !z)) {
            if (z) {
            } else {
                this.aO = this.h.c();
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pp.e
    public final void D(com.google.android.libraries.navigation.internal.adi.bo boVar) {
        v();
        synchronized (this.P) {
            eq eqVar = this.S;
            if (eqVar == null) {
                eqVar = this.Q;
            }
            f fVar = new f(eqVar);
            fVar.b(new com.google.android.libraries.navigation.internal.qq.b(com.google.android.libraries.geo.mapcore.renderer.ez.DEFAULT, com.google.android.libraries.navigation.internal.rq.a.a, com.google.android.libraries.geo.mapcore.internal.model.aq.a(boVar), ((com.google.android.libraries.navigation.internal.qq.b) ((g) eqVar).a).d, null));
            B(fVar.a());
        }
    }

    final boolean E() {
        boolean z;
        v();
        synchronized (this.P) {
            z = ((com.google.android.libraries.navigation.internal.qq.b) ((g) this.Q).a).d;
        }
        return z;
    }

    public final boolean F() {
        boolean z;
        synchronized (this.P) {
            z = false;
            if (!m(com.google.android.libraries.navigation.internal.ob.h.SATELLITE) && !m(com.google.android.libraries.navigation.internal.ob.h.TERRAIN) && ((com.google.android.libraries.navigation.internal.qq.b) ((g) this.Q).a).e != com.google.android.libraries.navigation.internal.qq.e.a) {
                z = true;
            }
        }
        return z;
    }

    public final boolean H(com.google.android.libraries.navigation.internal.adi.an anVar) {
        if ((anVar == com.google.android.libraries.navigation.internal.adi.an.GMM_BASEMAP_PHOTOS && this.al.d(this.W.get())) || !this.al.c(anVar)) {
            return false;
        }
        fh fhVar = (fh) this.al.a.get(anVar);
        if (fhVar != null) {
            return fhVar.ordinal() == 0;
        }
        ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(897)).s("Asking if a pipe that is not configured with pipes properties is enabled: %s", anVar);
        return false;
    }

    public final boolean I(com.google.android.libraries.navigation.internal.adi.an anVar) {
        return com.google.android.libraries.navigation.internal.hj.g.b && this.al.b(anVar);
    }

    @Override // com.google.android.libraries.navigation.internal.oa.e
    public final com.google.android.libraries.navigation.internal.on.h a() {
        bw bwVar = this.J;
        if (bwVar.a == null) {
            bwVar.a = new com.google.android.libraries.navigation.internal.on.h(bwVar);
        }
        com.google.android.libraries.navigation.internal.on.h hVar = bwVar.a;
        com.google.android.libraries.navigation.internal.yx.ar.q(hVar);
        return hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.oa.e
    public final com.google.android.libraries.geo.mapcore.internal.model.cg b() {
        return this.U.e();
    }

    @Override // com.google.android.libraries.navigation.internal.oa.e
    public final com.google.android.libraries.navigation.internal.qq.f c() {
        com.google.android.libraries.navigation.internal.qq.f fVar;
        v();
        synchronized (this.P) {
            fVar = ((g) this.Q).a;
        }
        return fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.oa.e
    public final void d() {
        com.google.android.libraries.navigation.internal.kg.c cVar;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("PhoenixGoogleMap.onStart()");
        try {
            this.c = true;
            com.google.android.libraries.navigation.internal.qq.al alVar = this.j;
            com.google.android.libraries.navigation.internal.ox.c cVar2 = alVar.i;
            com.google.android.libraries.navigation.internal.yx.ar.q(cVar2);
            cVar2.d();
            com.google.android.libraries.geo.mapcore.renderer.bg bgVar = alVar.e;
            com.google.android.libraries.navigation.internal.yx.ar.q(bgVar);
            bgVar.d();
            com.google.android.libraries.navigation.internal.pk.c cVar3 = alVar.o;
            if (cVar3 != null && (cVar = alVar.f) != null) {
                cVar.a(cVar3);
            }
            y(false);
            synchronized (this.P) {
                eq eqVar = this.S;
                if (eqVar != null) {
                    B(eqVar);
                } else {
                    B(this.Q);
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            com.google.android.libraries.navigation.internal.yx.ar.q(this.o);
            com.google.android.libraries.navigation.internal.qe.j jVar = (com.google.android.libraries.navigation.internal.qe.j) this.o;
            jVar.d = false;
            jVar.q();
            this.U.l();
            this.m.v(this.B, this.i);
            this.m.r();
            bs bsVar = this.ad;
            com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
            bsVar.k.b(bsVar);
            if (this.V) {
                this.U.w(((com.google.android.libraries.navigation.internal.om.v) this.aa.a()).d(this.b), ((com.google.android.libraries.navigation.internal.om.v) this.aa.a()).b(this.b, t()));
                z();
            }
            final com.google.android.libraries.navigation.internal.nt.m mVarC = this.U.c();
            final fj fjVar = new fj();
            final Runnable runnable = new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.ed
                @Override // java.lang.Runnable
                public final void run() {
                    fk fkVar = this.a;
                    fkVar.am.b();
                    com.google.android.libraries.navigation.internal.yx.ar.q(fkVar.p);
                    fkVar.p.setGlThreadPriority$ar$ds();
                    com.google.android.libraries.navigation.internal.ob.t tVar = fkVar.D;
                    if (tVar != null) {
                        tVar.a();
                        fkVar.D = null;
                    }
                    fkVar.u.h();
                }
            };
            fjVar.b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.ee
                @Override // java.lang.Runnable
                public final void run() {
                    fk fkVar = this.a;
                    fkVar.am.f();
                    fkVar.m.m(runnable, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
                    final com.google.android.libraries.navigation.internal.nt.m mVar = mVarC;
                    final fj fjVar2 = fjVar;
                    fkVar.A.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.ea
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.google.android.libraries.navigation.internal.zb.j jVar2 = fk.a;
                            mVar.h(fjVar2);
                        }
                    });
                }
            });
            mVarC.e(fjVar, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
            com.google.android.libraries.navigation.internal.aac.bn bnVar = this.A;
            final com.google.android.libraries.geo.mapcore.internal.model.x xVar = this.u;
            Objects.requireNonNull(xVar);
            bnVar.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.ef
                @Override // java.lang.Runnable
                public final void run() {
                    xVar.h();
                }
            }, 10L, TimeUnit.SECONDS);
            ds dsVar = this.U;
            com.google.android.libraries.navigation.internal.nt.t tVar = this.ah;
            com.google.android.libraries.navigation.internal.nt.m mVarC2 = dsVar.c();
            com.google.android.libraries.navigation.internal.yx.ar.q(tVar);
            mVarC2.g(tVar, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
            com.google.android.libraries.navigation.internal.px.bk bkVar = this.m;
            com.google.android.libraries.navigation.internal.nt.t tVar2 = this.ai;
            com.google.android.libraries.navigation.internal.nt.m mVarB = bkVar.b();
            com.google.android.libraries.navigation.internal.yx.ar.q(tVar2);
            mVarB.g(tVar2, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
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

    @Override // com.google.android.libraries.navigation.internal.oa.e
    public final void e() {
        com.google.android.libraries.navigation.internal.qd.w wVar;
        if (!this.V || (wVar = this.aE) == null) {
            return;
        }
        this.U.n(wVar);
        this.X.p();
        this.H.f(at);
    }

    @Override // com.google.android.libraries.navigation.internal.oa.e
    public final void f() {
        fk fkVar = this;
        if (fkVar.V) {
            if (fkVar.aE == null) {
                com.google.android.libraries.navigation.internal.qd.x xVar = fkVar.r;
                com.google.android.libraries.geo.mapcore.renderer.ax axVar = fkVar.B;
                com.google.android.libraries.navigation.internal.pb.t tVar = fkVar.i;
                com.google.android.libraries.geo.mapcore.internal.model.cg cgVarB = b();
                com.google.android.libraries.navigation.internal.qq.f fVarC = c();
                if (xVar.p == null) {
                    throw new IllegalArgumentException("Labels cannot be null when creating an indoor overlay.");
                }
                com.google.android.libraries.navigation.internal.oe.ap apVarA = xVar.r.a(com.google.android.libraries.navigation.internal.adi.an.GMM_INDOOR);
                com.google.android.libraries.navigation.internal.afo.a aVar = xVar.b;
                com.google.android.libraries.geo.mapcore.internal.model.x xVar2 = xVar.c;
                com.google.android.libraries.navigation.internal.qv.k kVarB = xVar.f.b(apVarA, cgVarB);
                com.google.android.libraries.navigation.internal.pq.b bVar = xVar.f549n;
                com.google.android.libraries.navigation.internal.qd.k kVar = xVar.d;
                com.google.android.libraries.navigation.internal.qf.d dVar = xVar.e;
                com.google.android.libraries.navigation.internal.mj.a aVar2 = xVar.g;
                com.google.android.libraries.navigation.internal.hp.e eVar = xVar.h;
                ScheduledExecutorService scheduledExecutorService = xVar.i;
                Executor executor = xVar.j;
                com.google.android.libraries.geo.mapcore.internal.model.ct ctVar = xVar.l;
                com.google.android.libraries.navigation.internal.pg.g gVar = xVar.k;
                com.google.android.libraries.navigation.internal.ol.ai aiVar = xVar.p;
                com.google.android.libraries.navigation.internal.qs.a aVar3 = xVar.w;
                com.google.android.libraries.navigation.internal.oe.at atVar = xVar.q;
                boolean zBooleanValue = ((Boolean) xVar.t.a()).booleanValue();
                com.google.android.libraries.navigation.internal.afo.a aVar4 = xVar.u;
                boolean z = xVar.v;
                com.google.android.libraries.navigation.internal.agl.a aVar5 = xVar.s;
                fkVar = this;
                fkVar.aE = new com.google.android.libraries.navigation.internal.qd.i(axVar, tVar, apVarA, cgVarB, kVarB, new com.google.android.libraries.navigation.internal.qg.j(axVar, aVar, xVar2, apVarA, cgVarB, kVarB, true, 4, bVar, dVar, aVar2, executor, atVar, fVarC), kVar, dVar, aVar2, scheduledExecutorService, new com.google.android.libraries.navigation.internal.rc.f(eVar, aVar2), gVar, ctVar, 4, aiVar, aVar3, atVar, zBooleanValue, aVar4, false);
            }
            fkVar.U.g(fkVar.aE);
            fkVar.X.r((com.google.android.libraries.navigation.internal.qd.i) fkVar.aE, fkVar.B, fkVar.C, fkVar.i, new es(fkVar.m));
            fkVar.H.k(at);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oa.e
    public final void g(com.google.android.libraries.navigation.internal.pz.c cVar) {
        com.google.android.libraries.navigation.internal.pz.d dVarA;
        if (this.V) {
            com.google.android.libraries.navigation.internal.ra.c.b.f();
            com.google.android.libraries.navigation.internal.px.bk bkVar = this.m;
            Resources resources = this.t;
            com.google.android.libraries.navigation.internal.pz.d dVarC = bkVar.c();
            float f = resources.getConfiguration().fontScale;
            if (dVarC != null && dVarC.b == cVar && dVarC.e == f) {
                return;
            }
            int iOrdinal = cVar.ordinal();
            if (iOrdinal == 0) {
                dVarA = com.google.android.libraries.navigation.internal.pz.d.a(f);
            } else {
                if (iOrdinal != 1) {
                    throw new IllegalArgumentException("Unknown type: ".concat(String.valueOf(String.valueOf(cVar))));
                }
                dVarA = new com.google.android.libraries.navigation.internal.pz.d(com.google.android.libraries.navigation.internal.pz.c.CAR_HEAD_UNIT, 12, Math.max(f, 1.0f), true);
            }
            dh dhVar = this.H;
            dhVar.k = dVarA;
            dhVar.h.b(dVarA);
            dhVar.j.f.set(true);
            this.m.s(dVarA);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oa.e
    public final void h(com.google.android.libraries.navigation.internal.ob.h hVar, boolean z) {
        com.google.android.libraries.navigation.internal.qd.w zVar;
        boolean zE;
        v();
        com.google.android.libraries.navigation.internal.yx.ar.q(hVar);
        if (z) {
            if (!m(hVar)) {
                com.google.android.libraries.navigation.internal.ob.h hVar2 = com.google.android.libraries.navigation.internal.ob.h.TRAFFIC;
                switch (hVar) {
                    case TRAFFIC:
                        com.google.android.libraries.navigation.internal.qd.x xVar = this.r;
                        com.google.android.libraries.geo.mapcore.internal.model.cg cgVarB = b();
                        long millis = TimeUnit.SECONDS.toMillis(((com.google.android.libraries.navigation.internal.om.x) this.aL.a()).e());
                        com.google.android.libraries.navigation.internal.qq.f fVarC = c();
                        com.google.android.libraries.navigation.internal.oe.ap apVar = xVar.o;
                        if (apVar == null) {
                            throw new IllegalArgumentException("TrafficTileLayerId cannot be null when we create a traffic overlay.");
                        }
                        com.google.android.libraries.geo.mapcore.renderer.ax axVar = xVar.a;
                        com.google.android.libraries.navigation.internal.afo.a aVar = xVar.b;
                        com.google.android.libraries.geo.mapcore.internal.model.x xVar2 = xVar.c;
                        com.google.android.libraries.navigation.internal.pb.t tVar = xVar.m;
                        com.google.android.libraries.navigation.internal.qv.k kVarB = xVar.f.b(apVar, cgVarB);
                        com.google.android.libraries.navigation.internal.qd.k kVar = xVar.d;
                        com.google.android.libraries.navigation.internal.qf.d dVar = xVar.e;
                        com.google.android.libraries.navigation.internal.mj.a aVar2 = xVar.g;
                        com.google.android.libraries.navigation.internal.hp.e eVar = xVar.h;
                        ScheduledExecutorService scheduledExecutorService = xVar.i;
                        Executor executor = xVar.j;
                        com.google.android.libraries.navigation.internal.pg.g gVar = xVar.k;
                        com.google.android.libraries.navigation.internal.qs.a aVar3 = xVar.w;
                        com.google.android.libraries.navigation.internal.oe.at atVar = xVar.q;
                        boolean zBooleanValue = ((Boolean) xVar.t.a()).booleanValue();
                        com.google.android.libraries.navigation.internal.afo.a aVar4 = xVar.u;
                        boolean z2 = xVar.v;
                        zVar = new com.google.android.libraries.navigation.internal.qd.z(axVar, tVar, apVar, cgVarB, kVarB, new com.google.android.libraries.navigation.internal.qg.j(axVar, aVar, xVar2, apVar, cgVarB, kVarB, true, 2, null, dVar, aVar2, executor, atVar, fVarC), kVar, dVar, aVar2, scheduledExecutorService, gVar, new com.google.android.libraries.navigation.internal.rc.f(eVar, aVar2), 2, true, millis, aVar3, atVar, zBooleanValue, aVar4, false);
                        break;
                        break;
                    case BICYCLING:
                    case TRANSIT:
                    case REALTIME:
                        zVar = this.r.c(hVar.b(E()), b(), c(), false);
                        break;
                    case SATELLITE:
                    case TERRAIN:
                        u();
                        com.google.android.libraries.navigation.internal.qd.x xVar3 = this.r;
                        com.google.android.libraries.navigation.internal.pu.k kVar2 = this.aq;
                        if (kVar2 != null && kVar2.b()) {
                            synchronized (this.P) {
                                zE = this.aD;
                            }
                        } else {
                            zE = E();
                        }
                        zVar = xVar3.f(hVar.b(zE), b());
                        break;
                    case STREETVIEW:
                    case THREE_DIMENSIONAL:
                    case COVID19:
                    case AIR_QUALITY:
                    case WILDFIRES:
                        synchronized (this.P) {
                            zVar = this.r.c(hVar.b(E()), b(), ((g) this.Q).a, false);
                            break;
                        }
                        break;
                    case AIR_QUALITY_HEATMAP:
                        synchronized (this.P) {
                            zVar = this.r.c(hVar.b(E()), b(), ((g) this.Q).a, true);
                            break;
                        }
                        break;
                    default:
                        throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.e(hVar, "Layer ", " is not a layer we can enable."));
                }
                this.U.g(zVar);
                this.N.put(hVar, zVar);
            }
        } else if (m(hVar) && this.N.containsKey(hVar)) {
            this.U.n((com.google.android.libraries.navigation.internal.qd.w) this.N.get(hVar));
            this.N.remove(hVar);
        }
        hVar.equals(com.google.android.libraries.navigation.internal.ob.h.THREE_DIMENSIONAL);
        if (ar.contains(hVar) && F()) {
            i();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oa.e
    public final void i() {
        v();
        u();
        o();
        synchronized (this.P) {
            eq eqVar = this.S;
            if (eqVar == null) {
                eqVar = this.Q;
            }
            f fVar = new f(eqVar);
            fVar.b(K().a(((com.google.android.libraries.navigation.internal.qq.b) ((g) eqVar).a).d));
            B(fVar.a());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oa.e
    public final void j(com.google.android.libraries.navigation.internal.adi.an anVar, boolean z) {
        boolean z2 = false;
        if (z && this.al.c(anVar)) {
            z2 = true;
        }
        synchronized (this.O) {
            if (!this.O.containsKey(anVar) && z2) {
                com.google.android.libraries.navigation.internal.qd.w wVarJ = J(anVar);
                if (wVarJ != null) {
                    this.U.g(wVarJ);
                    this.O.put(anVar, wVarJ);
                }
            } else if (this.O.containsKey(anVar) && !z2) {
                this.U.n((com.google.android.libraries.navigation.internal.qd.d) this.O.get(anVar));
                this.O.remove(anVar);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oa.e
    public final void k() {
        h(com.google.android.libraries.navigation.internal.ob.h.SATELLITE, true);
        o();
        synchronized (this.P) {
            eq eqVar = this.S;
            if (eqVar == null) {
                eqVar = this.Q;
            }
            f fVar = new f(eqVar);
            fVar.b((((this.ay || this.e) && ((com.google.android.libraries.navigation.internal.om.x) this.aL.a()).o()) ? com.google.android.libraries.navigation.internal.qq.e.e : com.google.android.libraries.navigation.internal.qq.e.q).a(((com.google.android.libraries.navigation.internal.qq.b) ((g) eqVar).a).d));
            B(fVar.a());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oa.e
    public final synchronized void l(boolean z) {
        com.google.android.libraries.navigation.internal.yr.ai aiVarA = com.google.android.libraries.navigation.internal.yu.f.a();
        try {
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("PhoenixGoogleMap.startEarlyTileFetching");
            try {
                if (this.aK.compareAndSet(false, true)) {
                    this.am.n();
                    this.U.t();
                } else if (z) {
                    this.U.t();
                }
                if (dVarB != null) {
                    Trace.endSection();
                }
                aiVarA.close();
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
        } catch (Throwable th3) {
            try {
                aiVarA.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oa.e
    public final boolean m(com.google.android.libraries.navigation.internal.ob.h hVar) {
        v();
        return this.N.containsKey(hVar);
    }

    @Override // com.google.android.libraries.navigation.internal.oa.e
    public final void n(final com.google.android.libraries.navigation.internal.pb.c cVar) {
        ConfigurationInfo deviceConfigurationInfo;
        if (!this.V || this.k == null) {
            return;
        }
        if (!this.j.g || ((deviceConfigurationInfo = ((ActivityManager) this.Y.getSystemService("activity")).getDeviceConfigurationInfo()) != null && deviceConfigurationInfo.reqGlEsVersion < 131072)) {
            com.google.android.libraries.navigation.internal.pb.b bVar = this.q;
            if (bVar != null) {
                cVar.a(bVar);
                return;
            }
            return;
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.z.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.eb
                @Override // java.lang.Runnable
                public final void run() {
                    fk fkVar = this.a;
                    if (fkVar.k != null) {
                        fkVar.k.d(cVar);
                    }
                }
            });
        } else {
            this.k.d(cVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oa.e
    public final void o() {
        if (this.V) {
            this.m.y();
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        v();
        this.aw.get();
    }

    @Override // com.google.android.libraries.navigation.internal.ob.g
    public final com.google.android.libraries.navigation.internal.ol.a p() {
        return this.F;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.g
    public final com.google.android.libraries.navigation.internal.ol.ai q() {
        return this.H;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.g
    public final com.google.android.libraries.navigation.internal.ol.ak r() {
        return this.G;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.g
    public final com.google.android.libraries.navigation.internal.ol.ax s() {
        return this.I;
    }

    public final com.google.android.libraries.navigation.internal.adi.bo t() {
        com.google.android.libraries.navigation.internal.adi.bo boVar;
        synchronized (this.P) {
            boVar = this.Q.c().E;
        }
        return boVar;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        synchronized (this.P) {
            akVarB.g("baseMapType", as);
            akVarB.g("drawingConfig", this.Q);
        }
        return akVarB.toString();
    }

    public final void u() {
        if (this.N.containsKey(com.google.android.libraries.navigation.internal.ob.h.SATELLITE)) {
            this.U.n((com.google.android.libraries.navigation.internal.qd.d) this.N.get(com.google.android.libraries.navigation.internal.ob.h.SATELLITE));
            this.N.remove(com.google.android.libraries.navigation.internal.ob.h.SATELLITE);
        }
        if (this.N.containsKey(com.google.android.libraries.navigation.internal.ob.h.TERRAIN)) {
            this.U.n((com.google.android.libraries.navigation.internal.qd.d) this.N.get(com.google.android.libraries.navigation.internal.ob.h.TERRAIN));
            this.N.remove(com.google.android.libraries.navigation.internal.ob.h.TERRAIN);
        }
    }

    public final void v() {
        com.google.android.libraries.navigation.internal.rq.i iVar = this.aB;
        if (iVar != null) {
            com.google.android.libraries.navigation.internal.yx.ar.l(Thread.currentThread() == iVar.b, iVar.c);
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.u
    public final void w(int i) {
        synchronized (this.P) {
            eq eqVar = this.S;
            if (eqVar == null) {
                eqVar = this.Q;
            }
            f fVar = new f(eqVar);
            fVar.c(i);
            B(fVar.a());
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.w
    public final void x(com.google.android.libraries.geo.mapcore.internal.model.v vVar) {
        C(true);
        if (vVar == null) {
            return;
        }
        Object obj = this.P;
        int i = vVar.a;
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar = vVar.b;
        synchronized (obj) {
            eq eqVar = this.S;
            if (eqVar != null && aqVar == eqVar.c()) {
                f fVar = new f(this.S);
                fVar.c(i);
                L(fVar.a(), vVar);
                this.S = null;
            } else if (aqVar == this.Q.c()) {
                f fVar2 = new f(this.Q);
                fVar2.c(i);
                L(fVar2.a(), vVar);
            }
        }
    }

    public final void y(boolean z) {
        this.m.t(z);
    }

    public final void z() {
        v();
        synchronized (this.aF) {
            this.aG = this.U.d(this.aG);
        }
        for (com.google.android.libraries.navigation.internal.ob.h hVar : com.google.android.libraries.navigation.internal.ob.h.values()) {
            if (!hVar.equals(com.google.android.libraries.navigation.internal.ob.h.UNKNOWN) && !hVar.equals(com.google.android.libraries.navigation.internal.ob.h.STREETVIEW) && this.N.containsKey(hVar)) {
                Map map = this.N;
                map.put(hVar, this.U.d((com.google.android.libraries.navigation.internal.qd.w) map.get(hVar)));
            }
        }
        com.google.android.libraries.navigation.internal.qd.w wVar = this.aC;
        if (wVar != null) {
            this.aC = this.U.d(wVar);
        }
        synchronized (this.O) {
            nn nnVarListIterator = this.al.a().listIterator();
            while (nnVarListIterator.hasNext()) {
                com.google.android.libraries.navigation.internal.adi.an anVar = (com.google.android.libraries.navigation.internal.adi.an) nnVarListIterator.next();
                if (this.O.containsKey(anVar)) {
                    Map map2 = this.O;
                    map2.put(anVar, this.U.d((com.google.android.libraries.navigation.internal.qd.w) map2.get(anVar)));
                }
            }
        }
        if (this.aE == null || !this.X.j()) {
            com.google.android.libraries.navigation.internal.qd.w wVar2 = this.aE;
            if (wVar2 != null) {
                com.google.android.libraries.navigation.internal.qd.i iVar = (com.google.android.libraries.navigation.internal.qd.i) wVar2;
                com.google.android.libraries.geo.mapcore.internal.model.cg cgVarZ = iVar.e.z(b());
                if (!cgVarZ.equals(iVar.e)) {
                    this.aE = iVar.g(cgVarZ, this.aA.b(iVar.d, cgVarZ));
                }
            }
        } else {
            this.X.p();
            ds dsVar = this.U;
            com.google.android.libraries.navigation.internal.qd.w wVar3 = this.aE;
            com.google.android.libraries.navigation.internal.yx.ar.q(wVar3);
            com.google.android.libraries.navigation.internal.qd.w wVarD = dsVar.d(wVar3);
            this.aE = wVarD;
            this.X.r((com.google.android.libraries.navigation.internal.qd.i) wVarD, this.B, this.C, this.i, new es(this.m));
        }
        synchronized (this.aH) {
            com.google.android.libraries.navigation.internal.qd.w wVar4 = this.aI;
            if (wVar4 != null) {
                com.google.android.libraries.navigation.internal.yx.ar.q(wVar4);
                com.google.android.libraries.geo.mapcore.internal.model.cg cgVarZ2 = wVar4.e.z(b());
                if (!cgVarZ2.equals(wVar4.e)) {
                    this.aI = wVar4.g(cgVarZ2, this.aA.b(wVar4.d, cgVarZ2));
                }
            }
        }
        for (Map.Entry entry : this.M.entrySet()) {
            if (entry.getValue() instanceof com.google.android.libraries.navigation.internal.qd.w) {
                com.google.android.libraries.navigation.internal.qd.w wVar5 = (com.google.android.libraries.navigation.internal.qd.w) entry.getValue();
                if (wVar5.c != com.google.android.libraries.navigation.internal.adi.an.GMM_MY_MAPS && wVar5.c != com.google.android.libraries.navigation.internal.adi.an.MAPS_API_DDS_1P) {
                    entry.setValue(this.U.d(wVar5));
                }
            }
        }
    }
}
