package com.google.android.libraries.navigation.internal.po;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.hardware.SensorManager;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.adg.jr;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gm extends com.google.android.libraries.navigation.internal.oa.f {
    public static final /* synthetic */ int z = 0;
    private final com.google.android.libraries.navigation.internal.agl.a A;
    private final com.google.android.libraries.navigation.internal.agl.a B;
    private final com.google.android.libraries.navigation.internal.agl.a C;
    private final com.google.android.libraries.navigation.internal.agl.a D;
    private final com.google.android.libraries.navigation.internal.pm.d E;
    private final String G;
    private final Integer H;
    private final com.google.android.libraries.navigation.internal.fq.f I;
    private final com.google.android.libraries.navigation.internal.mj.a J;
    private final com.google.android.libraries.navigation.internal.hp.e K;
    private final com.google.android.libraries.navigation.internal.ni.a L;
    private final com.google.android.libraries.navigation.internal.kg.c M;
    private final com.google.android.libraries.navigation.internal.qf.d N;
    private final com.google.android.libraries.navigation.internal.ia.e O;
    private final com.google.android.libraries.navigation.internal.di.b P;
    private final com.google.android.libraries.navigation.internal.qd.k Q;
    private final com.google.android.libraries.navigation.internal.iz.n R;
    private final com.google.android.libraries.navigation.internal.ps.y S;
    private final com.google.android.libraries.navigation.internal.ra.a T;
    private final com.google.android.libraries.navigation.internal.aac.bn U;
    private final Executor V;
    private final Executor W;
    private final gl X;
    private final com.google.android.libraries.navigation.internal.pg.g Y;
    private final com.google.android.libraries.navigation.internal.qu.cf Z;
    public final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.oe.ap aa;
    private final com.google.android.libraries.geo.mapcore.internal.model.ct ab;
    private final com.google.android.libraries.navigation.internal.rc.c ac;
    private final com.google.android.libraries.navigation.internal.pn.g ad;
    private final com.google.android.libraries.navigation.internal.ob.t ae;
    private final com.google.android.libraries.navigation.internal.yx.br af;
    private final boolean ag;
    private final boolean ah;
    private final com.google.android.libraries.navigation.internal.pm.a ap;
    private final com.google.android.libraries.navigation.internal.qs.a aq;
    public final com.google.android.libraries.navigation.internal.agl.a b;
    public final Context c;
    public final com.google.android.libraries.navigation.internal.kl.b d;
    public final Context e;
    public final com.google.android.libraries.geo.mapcore.internal.model.x f;
    public final com.google.android.libraries.navigation.internal.pi.s g;
    public final com.google.android.libraries.navigation.internal.iv.f h;
    public final com.google.android.libraries.navigation.internal.afo.a i;
    public final com.google.android.libraries.navigation.internal.afo.a j;
    public final com.google.android.libraries.navigation.internal.afo.a k;
    public final com.google.android.libraries.navigation.internal.ob.n l;
    public final com.google.android.libraries.navigation.internal.qy.h m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Resources f525n;
    public final com.google.android.libraries.navigation.internal.aac.bn o;
    public final com.google.android.libraries.navigation.internal.yx.br p;
    public final com.google.android.libraries.navigation.internal.yx.br q;
    public final com.google.android.libraries.navigation.internal.pb.m r;
    public final com.google.android.libraries.navigation.internal.pb.i s;
    public final boolean t;
    public final com.google.android.libraries.navigation.internal.oe.at u;
    public final com.google.android.libraries.navigation.internal.afo.a v;
    public final gr w;
    public final com.google.android.libraries.navigation.internal.rg.b x;
    public final com.google.android.libraries.navigation.internal.pu.k y;
    private final Map F = new EnumMap(com.google.android.libraries.navigation.internal.yz.fd.m(jr.WORLD_ENCODING_LAT_LNG_E7, new com.google.android.libraries.navigation.internal.oe.v(), jr.WORLD_ENCODING_LAT_LNG_DOUBLE, new com.google.android.libraries.navigation.internal.oe.u(), jr.SCREEN_SPACE_FLOAT, new com.google.android.libraries.navigation.internal.oe.am()));
    private final com.google.android.libraries.navigation.internal.yx.br ai = com.google.android.libraries.navigation.internal.yx.bw.a(new fy(this));
    private final com.google.android.libraries.navigation.internal.yx.br aj = com.google.android.libraries.navigation.internal.yx.bw.a(new fz(this));
    private final com.google.android.libraries.navigation.internal.yx.br ak = com.google.android.libraries.navigation.internal.yx.bw.a(new ga(this));
    private com.google.android.libraries.navigation.internal.oa.e al = null;
    private com.google.android.libraries.navigation.internal.qe.e am = null;
    private com.google.android.libraries.navigation.internal.oy.a an = null;
    private final com.google.android.libraries.navigation.internal.afo.a ao = com.google.android.libraries.navigation.internal.ih.a.b(new gi(this));

    static {
        SensorManager.getAltitude(1.0f, 1.0f);
    }

    public gm(String str, Integer num, Resources resources, com.google.android.libraries.geo.mapcore.internal.model.x xVar, com.google.android.libraries.navigation.internal.ob.n nVar, Context context, com.google.android.libraries.navigation.internal.ps.y yVar, com.google.android.libraries.navigation.internal.adi.an anVar, com.google.android.libraries.navigation.internal.afo.a aVar, gr grVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.qd.k kVar, Context context2, com.google.android.libraries.navigation.internal.fq.f fVar, com.google.android.libraries.navigation.internal.kl.b bVar, final com.google.android.libraries.navigation.internal.om.p pVar, final com.google.android.libraries.navigation.internal.ox.f fVar2, com.google.android.libraries.navigation.internal.pm.d dVar, com.google.android.libraries.navigation.internal.mj.a aVar4, com.google.android.libraries.navigation.internal.hp.e eVar, com.google.android.libraries.navigation.internal.ni.a aVar5, com.google.android.libraries.navigation.internal.pi.s sVar, com.google.android.libraries.navigation.internal.ia.e eVar2, com.google.android.libraries.navigation.internal.kg.c cVar, com.google.android.libraries.navigation.internal.qf.d dVar2, com.google.android.libraries.navigation.internal.iv.f fVar3, com.google.android.libraries.navigation.internal.di.b bVar2, com.google.android.libraries.navigation.internal.qy.h hVar, com.google.android.libraries.navigation.internal.pm.a aVar6, com.google.android.libraries.navigation.internal.ra.a aVar7, com.google.android.libraries.navigation.internal.iz.n nVar2, com.google.android.libraries.navigation.internal.aac.bn bnVar, com.google.android.libraries.navigation.internal.aac.bn bnVar2, Executor executor, Executor executor2, com.google.android.libraries.navigation.internal.aac.bn bnVar3, com.google.android.libraries.navigation.internal.qu.cf cfVar, com.google.android.libraries.navigation.internal.pg.g gVar, com.google.android.libraries.geo.mapcore.internal.model.ct ctVar, com.google.android.libraries.navigation.internal.pn.g gVar2, com.google.android.libraries.navigation.internal.yx.br brVar, com.google.android.libraries.navigation.internal.ob.t tVar, com.google.android.libraries.navigation.internal.qs.a aVar8, com.google.android.libraries.navigation.internal.rc.c cVar2, com.google.android.libraries.navigation.internal.oe.at atVar, com.google.android.libraries.navigation.internal.rg.b bVar3, com.google.android.libraries.navigation.internal.pu.k kVar2, boolean z2, boolean z3) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("PhoenixGoogleMapActivityEnvironment.<init>");
        try {
            this.G = str;
            this.H = num;
            this.c = context2;
            this.I = fVar;
            this.d = bVar;
            Objects.requireNonNull(pVar);
            this.a = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.po.fl
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return pVar.b();
                }
            };
            Objects.requireNonNull(pVar);
            this.A = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.po.fq
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return pVar.a();
                }
            };
            Objects.requireNonNull(pVar);
            this.b = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.po.fr
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return pVar.e();
                }
            };
            Objects.requireNonNull(pVar);
            com.google.android.libraries.navigation.internal.agl.a aVar9 = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.po.fs
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return pVar.c();
                }
            };
            this.B = aVar9;
            Objects.requireNonNull(fVar2);
            this.C = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.po.ft
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return fVar2.a();
                }
            };
            Objects.requireNonNull(pVar);
            this.D = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.po.fu
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return pVar.d();
                }
            };
            this.E = dVar;
            this.J = aVar4;
            this.K = eVar;
            this.L = aVar5;
            this.g = sVar;
            this.O = eVar2;
            this.M = cVar;
            this.N = dVar2;
            this.P = bVar2;
            this.m = hVar;
            this.ap = aVar6;
            this.h = fVar3;
            this.R = nVar2;
            this.T = aVar7;
            this.U = bnVar;
            this.o = bnVar2;
            this.V = executor;
            this.W = executor2;
            this.X = new gl(bnVar3);
            this.Z = cfVar;
            this.Y = gVar;
            this.ab = ctVar;
            this.ad = gVar2;
            this.af = brVar;
            this.ag = ((com.google.android.libraries.navigation.internal.om.n) aVar9.a()).p();
            this.f525n = resources;
            this.l = nVar;
            this.j = aVar;
            this.f = xVar;
            this.e = context;
            this.S = yVar;
            this.aa = new com.google.android.libraries.navigation.internal.oe.aq(atVar).a(anVar);
            this.w = grVar;
            this.k = aVar2;
            this.i = aVar3;
            this.Q = kVar;
            this.ae = tVar;
            this.aq = aVar8;
            this.ac = cVar2;
            com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("PhoenixGoogleMapActivityEnvironment.createCameraPositionSanitizer");
            try {
                com.google.android.libraries.navigation.internal.pb.m mVar = new com.google.android.libraries.navigation.internal.pb.m(resources.getDisplayMetrics(), ((com.google.android.libraries.navigation.internal.om.b) pVar.a()).a);
                if (dVarB2 != null) {
                    Trace.endSection();
                }
                this.r = mVar;
                this.s = new com.google.android.libraries.navigation.internal.pb.i(mVar);
                this.u = atVar;
                this.t = z2;
                this.ah = false;
                this.x = bVar3;
                this.y = kVar2;
                this.v = com.google.android.libraries.navigation.internal.ih.a.b(new gc(pVar, fVar3, eVar, aVar4));
                this.p = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.fv
                    @Override // com.google.android.libraries.navigation.internal.yx.br
                    public final Object a() {
                        return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.l) this.a.a.a()).H());
                    }
                });
                this.q = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.fw
                    @Override // com.google.android.libraries.navigation.internal.yx.br
                    public final Object a() {
                        return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.l) this.a.a.a()).E());
                    }
                });
                if (dVarB != null) {
                    Trace.endSection();
                }
            } catch (Throwable th) {
                if (dVarB2 == null) {
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
        } catch (Throwable th3) {
            if (dVarB == null) {
                throw th3;
            }
            try {
                Trace.endSection();
                throw th3;
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
                throw th3;
            }
        }
    }

    private final synchronized com.google.android.libraries.navigation.internal.oa.e m() {
        com.google.android.libraries.navigation.internal.pb.t tVarD;
        hi hiVarL;
        dh dhVar;
        com.google.android.libraries.geo.mapcore.renderer.ax axVar;
        com.google.android.libraries.navigation.internal.px.ca caVar;
        com.google.android.libraries.navigation.internal.px.bp bpVar;
        dp dpVar;
        com.google.android.libraries.navigation.internal.qd.x xVar;
        com.google.android.libraries.navigation.internal.oe.aq aqVar;
        com.google.android.libraries.navigation.internal.qd.w wVarC;
        com.google.android.libraries.navigation.internal.qq.al alVar;
        dy dyVar;
        Cdo cdo;
        d dVar;
        bs bsVar;
        bw bwVar;
        String str;
        gr grVar;
        com.google.android.libraries.navigation.internal.ps.y yVar;
        Context context;
        com.google.android.libraries.navigation.internal.agl.a aVar;
        com.google.android.libraries.navigation.internal.agl.a aVar2;
        com.google.android.libraries.navigation.internal.agl.a aVar3;
        com.google.android.libraries.navigation.internal.oe.m mVar;
        com.google.android.libraries.navigation.internal.qd.k kVar;
        com.google.android.libraries.navigation.internal.qe.e eVar;
        com.google.android.libraries.navigation.internal.fq.f fVar;
        com.google.android.libraries.navigation.internal.kl.b bVar;
        com.google.android.libraries.navigation.internal.ia.e eVar2;
        com.google.android.libraries.navigation.internal.pi.s sVar;
        com.google.android.libraries.geo.mapcore.internal.model.x xVar2;
        com.google.android.libraries.navigation.internal.iv.f fVar2;
        com.google.android.libraries.navigation.internal.qy.h hVar;
        com.google.android.libraries.navigation.internal.ra.a aVar4;
        com.google.android.libraries.navigation.internal.aac.bn bnVar;
        com.google.android.libraries.navigation.internal.aac.bn bnVar2;
        com.google.android.libraries.navigation.internal.qu.cf cfVar;
        com.google.android.libraries.geo.mapcore.internal.model.ct ctVar;
        com.google.android.libraries.navigation.internal.qk.n nVar;
        com.google.android.libraries.navigation.internal.ob.t tVar;
        com.google.android.libraries.navigation.internal.di.b bVar2;
        com.google.android.libraries.navigation.internal.pu.k kVar2;
        boolean z2;
        boolean zI;
        fi fiVar;
        tVarD = d();
        gd gdVar = new gd(this);
        hiVarL = l();
        cp cpVar = new cp(hiVarL);
        dhVar = new dh(hiVarL, cpVar, gdVar, this.F, this.f525n.getDisplayMetrics().density, ((com.google.android.libraries.navigation.internal.om.n) this.B.a()).h() ? ca.a : new ca(this.o, this.m, cpVar), this.w, this.t, this.ag);
        axVar = (com.google.android.libraries.geo.mapcore.renderer.ax) this.j.a();
        axVar.z = this.G;
        com.google.android.libraries.geo.mapcore.renderer.ep epVar = axVar.m;
        com.google.android.libraries.geo.mapcore.renderer.ep epVar2 = axVar.f75n;
        Resources resources = this.f525n;
        float f = resources.getDisplayMetrics().density;
        com.google.android.libraries.navigation.internal.fq.f fVar3 = this.I;
        com.google.android.libraries.navigation.internal.qy.h hVar2 = this.m;
        com.google.android.libraries.navigation.internal.pm.a aVar5 = this.ap;
        caVar = new com.google.android.libraries.navigation.internal.px.ca(fVar3, resources, new com.google.android.libraries.navigation.internal.qe.b(epVar, f, new Paint(), new Paint(), ((com.google.android.libraries.navigation.internal.om.n) this.B.a()).s()), new com.google.android.libraries.navigation.internal.pz.a(epVar, hVar2, aVar5, f), new com.google.android.libraries.navigation.internal.pz.a(epVar2, hVar2, aVar5, f), dhVar, cpVar);
        com.google.android.libraries.navigation.internal.ps.y yVar2 = this.S;
        dg dgVar = dhVar.c;
        df dfVar = dhVar.d;
        com.google.android.libraries.navigation.internal.fq.f fVar4 = this.I;
        com.google.android.libraries.navigation.internal.kl.b bVar3 = this.d;
        com.google.android.libraries.navigation.internal.agl.a aVar6 = this.B;
        gl glVar = this.X;
        com.google.android.libraries.navigation.internal.aac.bn bnVar3 = this.U;
        com.google.android.libraries.navigation.internal.aac.bn bnVarA = glVar.a();
        com.google.android.libraries.navigation.internal.agl.a aVar7 = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.po.fm
            @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
            public final Object a() {
                return this.a.h.i(com.google.android.libraries.navigation.internal.iv.ab.B, "");
            }
        };
        com.google.android.libraries.navigation.internal.ni.a aVar8 = this.L;
        this.l.f();
        bpVar = new com.google.android.libraries.navigation.internal.px.bp(yVar2, dgVar, dfVar, caVar, fVar4, bVar3, aVar6, bnVarA, bnVar3, cpVar, aVar7, aVar8, new com.google.android.libraries.navigation.internal.rc.f(this.K, this.J), this.t, hiVarL, this.h.y(com.google.android.libraries.navigation.internal.iv.ab.I, false), ((com.google.android.libraries.navigation.internal.om.l) this.a.a()).v());
        dpVar = new dp(bpVar);
        xVar = new com.google.android.libraries.navigation.internal.qd.x(axVar, this.ao, this.f, tVarD, this.aa, this.Z, this.S, this.Q, this.N, this.J, this.K, this.o, this.V, this.Y, this.ab, this.M, this.d, this.l.i(), dhVar, this.b, this.aq, this.u, this.p, this.v, false, this.f525n.getDisplayMetrics());
        aqVar = new com.google.android.libraries.navigation.internal.oe.aq(this.u);
        com.google.android.libraries.navigation.internal.agl.a aVar9 = this.D;
        String str2 = this.G;
        com.google.android.libraries.navigation.internal.qq.e eVar3 = com.google.android.libraries.navigation.internal.qq.e.b;
        wVarC = xVar.c(com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE, com.google.android.libraries.geo.mapcore.internal.model.cg.s.y(((com.google.android.libraries.navigation.internal.om.v) aVar9.a()).a(str2, com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE), ((com.google.android.libraries.navigation.internal.om.v) this.D.a()).b(this.G, ((com.google.android.libraries.navigation.internal.qq.b) eVar3.a(this.t)).c.E), ((com.google.android.libraries.navigation.internal.qq.b) eVar3.a(this.t)).a), eVar3.a(this.t), false);
        alVar = (com.google.android.libraries.navigation.internal.qq.al) this.k.a();
        dyVar = new dy(this.f525n, tVarD, alVar, axVar, bpVar, this.af, this.Z, this.u, this.t, com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.fn
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.x) this.a.b.a()).g());
            }
        }), this.H, this.o);
        dr drVar = new dr();
        dk dkVar = new dk(xVar, this.Z, dyVar);
        cdo = new Cdo(axVar, hiVarL, this.F, this.w, tVarD, this.g, this.c);
        dVar = new d(hiVarL, cdo, this.F, axVar, this.w, tVarD, this.g, this.e, this.p, this.E);
        bv bvVar = new bv();
        bsVar = new bs(tVarD, this.f525n.getDisplayMetrics().density, axVar, bvVar, this.W, this.U, this.ac);
        bwVar = new bw(this, axVar, bvVar, dVar, cdo, dhVar, hiVarL, dkVar, drVar);
        com.google.android.libraries.navigation.internal.qe.e eVar4 = new com.google.android.libraries.navigation.internal.qe.e(this.e, tVarD, this.s, this.L, this.A, this.g);
        this.am = eVar4;
        eVar4.a.b.b = new ge(tVarD, dyVar);
        str = this.G;
        grVar = this.w;
        yVar = this.S;
        context = this.e;
        aVar = this.a;
        aVar2 = this.b;
        aVar3 = this.D;
        mVar = new com.google.android.libraries.navigation.internal.oe.m();
        kVar = this.Q;
        eVar = this.am;
        com.google.android.libraries.navigation.internal.yx.ar.q(eVar);
        fVar = this.I;
        bVar = this.d;
        eVar2 = this.O;
        sVar = this.g;
        xVar2 = this.f;
        fVar2 = this.h;
        hVar = this.m;
        aVar4 = this.T;
        bnVar = this.U;
        bnVar2 = this.o;
        cfVar = this.Z;
        ctVar = this.ab;
        nVar = new com.google.android.libraries.navigation.internal.qk.n(dhVar);
        tVar = this.ae;
        bVar2 = this.P;
        kVar2 = this.y;
        com.google.android.libraries.navigation.internal.ob.n nVar2 = this.l;
        z2 = this.t;
        com.google.android.libraries.navigation.internal.agl.a aVar10 = this.a;
        zI = nVar2.i();
        fiVar = new fi(nVar2.b(), aVar10);
        this.a.a();
        return new fk(str, bwVar, grVar, axVar, yVar, tVarD, alVar, context, aVar, aVar2, aVar3, mVar, kVar, eVar, bsVar, dyVar, bpVar, xVar, aqVar, hiVarL, dhVar, cdo, dVar, caVar, fVar, bVar, eVar2, sVar, xVar2, fVar2, hVar, aVar4, bnVar, bnVar2, cfVar, ctVar, nVar, dpVar, tVar, bVar2, wVarC, null, kVar2, zI, z2, fiVar, false);
    }

    @Override // com.google.android.libraries.navigation.internal.oa.f
    public final com.google.android.libraries.navigation.internal.kg.c a() {
        return this.M;
    }

    @Override // com.google.android.libraries.navigation.internal.oa.f
    public final com.google.android.libraries.navigation.internal.oa.e b() {
        com.google.android.libraries.navigation.internal.oa.e eVarM;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("PhoenixGoogleMapActivityEnvironment.getMap");
        try {
            synchronized (this) {
                eVarM = this.al;
                if (eVarM == null) {
                    eVarM = m();
                    this.al = eVarM;
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            return eVarM;
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

    @Override // com.google.android.libraries.navigation.internal.oa.f
    public final com.google.android.libraries.navigation.internal.oy.a c() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("PhoenixGoogleMapActivityEnvironment.getVectorMapGestureView");
        try {
            com.google.android.libraries.navigation.internal.oy.a aVarK = k();
            if (dVarB != null) {
                Trace.endSection();
            }
            return aVarK;
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

    @Override // com.google.android.libraries.navigation.internal.oa.f
    public final com.google.android.libraries.navigation.internal.pb.t d() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("PhoenixGoogleMapActivityEnvironment.getGmmCamera");
        try {
            com.google.android.libraries.navigation.internal.pb.t tVar = (com.google.android.libraries.navigation.internal.pb.t) this.aj.a();
            if (dVarB != null) {
                Trace.endSection();
            }
            return tVar;
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

    @Override // com.google.android.libraries.navigation.internal.oa.f
    public final synchronized com.google.android.libraries.navigation.internal.pc.g e() {
        com.google.android.libraries.navigation.internal.qe.e eVar;
        b();
        eVar = this.am;
        com.google.android.libraries.navigation.internal.yx.ar.q(eVar);
        return eVar;
    }

    @Override // com.google.android.libraries.navigation.internal.oa.f
    public final com.google.android.libraries.geo.mapcore.internal.model.x f() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.oa.f
    public final com.google.android.libraries.geo.mapcore.renderer.bg g() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("PhoenixGoogleMapActivityEnvironment.getGLView");
        try {
            com.google.android.libraries.geo.mapcore.renderer.bg bgVar = (com.google.android.libraries.geo.mapcore.renderer.bg) this.ai.a();
            if (dVarB != null) {
                Trace.endSection();
            }
            return bgVar;
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

    @Override // com.google.android.libraries.navigation.internal.oa.f
    public final synchronized com.google.android.libraries.navigation.internal.afo.a h() {
        return this.ao;
    }

    @Override // com.google.android.libraries.navigation.internal.oa.f
    public final com.google.android.libraries.navigation.internal.afo.a i() {
        return this.v;
    }

    public final synchronized com.google.android.libraries.navigation.internal.ol.z j() {
        bw bwVar;
        bwVar = ((fk) b()).J;
        com.google.android.libraries.navigation.internal.yx.ar.q(bwVar);
        return bwVar;
    }

    /* JADX WARN: Type inference failed for: r1v19, types: [com.google.android.libraries.navigation.internal.pb.a, com.google.android.libraries.navigation.internal.pc.g] */
    public final synchronized com.google.android.libraries.navigation.internal.oy.a k() {
        com.google.android.libraries.navigation.internal.pn.j jVar;
        com.google.android.libraries.navigation.internal.pn.j kVar;
        com.google.android.libraries.navigation.internal.oy.a aVar = this.an;
        if (aVar != null) {
            return aVar;
        }
        b();
        com.google.android.libraries.geo.mapcore.renderer.bg bgVarG = g();
        com.google.android.libraries.navigation.internal.pn.g gVar = this.ad;
        if (gVar == null || (jVar = gVar.a) == null) {
            jVar = null;
        }
        if (jVar == null) {
            kVar = new com.google.android.libraries.navigation.internal.qe.k(this.J, this.O, (com.google.android.libraries.navigation.internal.qe.e) e(), this.f525n.getDisplayMetrics().density);
        } else {
            kVar = jVar;
        }
        com.google.android.libraries.navigation.internal.pb.t tVarD = d();
        com.google.android.libraries.navigation.internal.ol.z zVarJ = j();
        com.google.android.libraries.navigation.internal.yx.ar.q(zVarJ);
        final com.google.android.libraries.navigation.internal.qe.j jVar2 = new com.google.android.libraries.navigation.internal.qe.j(bgVarG, tVarD, zVarJ, kVar, this.Q, ((com.google.android.libraries.navigation.internal.om.l) this.a.a()).N());
        com.google.android.libraries.navigation.internal.pu.k kVar2 = this.y;
        boolean zA = kVar2 != null ? kVar2.a() : ((com.google.android.libraries.navigation.internal.om.l) this.a.a()).y();
        com.google.android.libraries.navigation.internal.pn.g gVar2 = this.ad;
        if (gVar2 == null || gVar2.a != null || zA) {
            tVarD.c = null;
        } else {
            tVarD.c = e();
        }
        com.google.android.libraries.navigation.internal.pn.g gVar3 = this.ad;
        jVar2.b = gVar3 != null ? gVar3.b : new com.google.android.libraries.navigation.internal.pn.a();
        kVar.p(new com.google.android.libraries.navigation.internal.afo.a() { // from class: com.google.android.libraries.navigation.internal.po.fo
            @Override // com.google.android.libraries.navigation.internal.afo.a
            public final Object a() {
                int i = gm.z;
                return jVar2;
            }
        });
        bgVarG.setGestureController$ar$class_merging(new fx(jVar2));
        this.an = jVar2;
        return jVar2;
    }

    public final hi l() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("PhoenixGoogleMapActivityEnvironment.getStylesImpl");
        try {
            hi hiVar = (hi) this.ak.a();
            if (dVarB != null) {
                Trace.endSection();
            }
            return hiVar;
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
