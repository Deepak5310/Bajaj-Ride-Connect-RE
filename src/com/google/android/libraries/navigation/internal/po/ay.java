package com.google.android.libraries.navigation.internal.po;

import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.internal.vector.gl.GeometryUtil;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.no;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ay extends b implements com.google.android.libraries.navigation.internal.pp.c {
    public static int c;
    private final Set A;
    private final com.google.android.libraries.navigation.internal.adg.fi B;
    private final Set C;
    private final com.google.android.libraries.navigation.internal.qq.u D;
    private final com.google.android.libraries.navigation.internal.ol.ak E;
    private final com.google.android.libraries.navigation.internal.ol.g F;
    private final Runnable G;
    private final Runnable H;
    public final com.google.android.libraries.navigation.internal.qq.j d;
    public final com.google.android.libraries.navigation.internal.qq.p e;
    public final com.google.android.libraries.geo.mapcore.internal.vector.gl.p f;
    public final float g;
    public final com.google.android.libraries.geo.mapcore.renderer.ax h;
    public boolean i;
    public final com.google.android.libraries.navigation.internal.pb.t j;
    public final Object k;
    public boolean l;
    public final boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f520n;
    public final com.google.android.libraries.geo.mapcore.renderer.af o;
    public final aw p;
    public float q;
    public float r;
    public float s;
    public int t;
    public float u;
    public boolean v;
    final com.google.android.libraries.navigation.internal.yz.ev w;
    public final Runnable x;
    public final gr y;
    private com.google.android.libraries.navigation.internal.pp.h z;

    /* JADX WARN: Code duplicated, block: B:43:0x017a  */
    public ay(com.google.android.libraries.navigation.internal.ol.ak akVar, com.google.android.libraries.geo.mapcore.internal.vector.gl.p pVar, com.google.android.libraries.geo.mapcore.renderer.ax axVar, gr grVar, com.google.android.libraries.navigation.internal.pi.s sVar, com.google.android.libraries.navigation.internal.pb.t tVar, float f, com.google.android.libraries.navigation.internal.adg.fi fiVar, com.google.android.libraries.navigation.internal.ol.g gVar, com.google.android.libraries.navigation.internal.pp.h hVar, com.google.android.libraries.navigation.internal.oe.o oVar) {
        com.google.android.libraries.navigation.internal.yz.ev evVarG;
        int i;
        long j;
        com.google.android.libraries.navigation.internal.ol.aq aqVarC;
        super(grVar);
        this.A = new HashSet();
        this.C = new HashSet();
        this.i = false;
        this.k = new Object();
        this.l = false;
        this.p = new aw();
        this.q = 1.0f;
        this.r = 1.0f;
        this.v = true;
        this.G = new ar(this);
        this.x = new as(this);
        this.H = new at(this);
        this.E = akVar;
        this.f = pVar;
        this.h = axVar;
        this.y = grVar;
        this.j = tVar;
        this.B = fiVar;
        float f2 = tVar.w().k;
        this.s = f2;
        this.t = (int) Math.floor(f2);
        this.u = f2;
        this.z = hVar;
        this.F = gVar;
        if (gVar != null) {
            this.m = true;
            this.o = ((com.google.android.libraries.navigation.internal.qq.h) ((x) gVar).g).d;
        } else {
            this.m = false;
            this.o = com.google.android.libraries.geo.mapcore.renderer.cg.CLIENT_INJECTED_DRAW_ORDER;
        }
        this.g = f;
        com.google.android.libraries.navigation.internal.ael.bz bzVar = fiVar.b;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < bzVar.size(); i2++) {
            try {
                int[] iArrN = oVar.n(((com.google.android.libraries.navigation.internal.adg.fg) bzVar.get(i2)).c, 0);
                if (iArrN.length != 0) {
                    arrayList.add(new com.google.android.libraries.navigation.internal.oe.ad(iArrN, 0, 0, 0));
                }
            } catch (IOException e) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(864)).s("ClientLinesImpl Encountered an error while parsing Polylines for picking. %s", e.getMessage());
            }
        }
        this.f520n = !(oVar instanceof com.google.android.libraries.navigation.internal.oe.am);
        ax axVar2 = new ax(this, oVar);
        if (fiVar.b.size() == 0) {
            int i3 = com.google.android.libraries.navigation.internal.yz.ev.d;
            evVarG = lv.a;
        } else {
            ArrayList arrayList2 = new ArrayList();
            com.google.android.libraries.navigation.internal.ael.bz<com.google.android.libraries.navigation.internal.adg.fg> bzVar2 = fiVar.b;
            com.google.android.libraries.navigation.internal.yz.eq eqVar = new com.google.android.libraries.navigation.internal.yz.eq();
            gw gwVarA = null;
            for (com.google.android.libraries.navigation.internal.adg.fg fgVar : bzVar2) {
                arrayList2.clear();
                if (fgVar.f.size() != 0) {
                    for (Long l : fgVar.f) {
                        long jLongValue = l.longValue();
                        this.C.add(l);
                        arrayList2.add((com.google.android.libraries.navigation.internal.pp.g) hVar.c(jLongValue));
                    }
                } else {
                    com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.f);
                    fgVar.h(bhVarS);
                    if (fgVar.w.n(bhVarS.d)) {
                        com.google.android.libraries.navigation.internal.ael.bh bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.f);
                        fgVar.h(bhVarS2);
                        Object objK = fgVar.w.k(bhVarS2.d);
                        i = ((com.google.android.libraries.navigation.internal.adg.es) (objK == null ? bhVarS2.b : bhVarS2.c(objK))).c;
                    } else {
                        if ((fgVar.b & 512) != 0) {
                            j = fgVar.f197n;
                        } else {
                            i = fgVar.m;
                        }
                        aqVarC = hVar.c(j);
                        if (aqVarC instanceof com.google.android.libraries.navigation.internal.pp.g) {
                            this.C.add(Long.valueOf(j));
                            arrayList2.add((com.google.android.libraries.navigation.internal.pp.g) aqVarC);
                        }
                    }
                    j = i;
                    aqVarC = hVar.c(j);
                    if (aqVarC instanceof com.google.android.libraries.navigation.internal.pp.g) {
                        this.C.add(Long.valueOf(j));
                        arrayList2.add((com.google.android.libraries.navigation.internal.pp.g) aqVarC);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    gwVarA = gwVarA == null ? axVar2.a(hVar) : gwVarA;
                    if (!gwVarA.e(fgVar, arrayList2)) {
                        gwVarA.d();
                        eqVar.h(gwVarA);
                        gwVarA = axVar2.a(hVar);
                        gwVarA.e(fgVar, arrayList2);
                    }
                }
            }
            if (gwVarA != null) {
                gwVarA.d();
                eqVar.h(gwVarA);
            }
            evVarG = eqVar.g();
        }
        this.w = evVarG;
        if (arrayList.isEmpty()) {
            this.d = null;
            this.D = null;
            this.e = null;
        } else {
            com.google.android.libraries.navigation.internal.qq.j jVar = new com.google.android.libraries.navigation.internal.qq.j(this.o);
            this.d = jVar;
            jVar.C(false);
            c++;
            jVar.f74n = com.google.android.libraries.navigation.internal.qq.u.a;
            com.google.android.libraries.navigation.internal.qq.p pVar2 = new com.google.android.libraries.navigation.internal.qq.p(18.0f, arrayList);
            this.e = pVar2;
            this.D = new com.google.android.libraries.navigation.internal.qq.u(pVar2);
        }
        f(this.z);
        grVar.a(this.x);
        ar(this.G);
    }

    public static float a(float f) {
        return (float) (Math.floor(((double) f) / 0.25d) * 0.25d);
    }

    private final void e(boolean z) {
        synchronized (this.k) {
            this.l = z;
        }
        p(this.H);
    }

    private final synchronized void f(com.google.android.libraries.navigation.internal.pp.h hVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("setupReadiness");
        try {
            this.a = false;
            this.A.clear();
            Iterator it2 = this.C.iterator();
            while (it2.hasNext()) {
                this.A.add(hVar.c(((Long) it2.next()).longValue()));
            }
            if (this.A.isEmpty()) {
                q();
            } else {
                final com.google.android.libraries.navigation.internal.hx.d dVar = new com.google.android.libraries.navigation.internal.hx.d(this.A.size(), new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.ap
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.q();
                    }
                });
                Iterator it3 = this.A.iterator();
                while (it3.hasNext()) {
                    ((com.google.android.libraries.navigation.internal.ol.aq) it3.next()).f(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.aq
                        @Override // java.lang.Runnable
                        public final void run() {
                            dVar.a();
                        }
                    });
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

    @Override // com.google.android.libraries.navigation.internal.po.b, com.google.android.libraries.navigation.internal.ol.v
    public final synchronized void aq() {
        super.aq();
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("clearPickHandler");
        try {
            com.google.android.libraries.navigation.internal.qq.j jVar = this.d;
            if (jVar != null) {
                jVar.f74n = com.google.android.libraries.navigation.internal.qq.u.a;
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

    /* JADX WARN: Multi-variable type inference failed */
    final void b(List list) {
        int i = 0;
        while (true) {
            com.google.android.libraries.navigation.internal.yz.ev evVar = this.w;
            if (i >= ((lv) evVar).c) {
                return;
            }
            list.add(((gw) evVar.get(i)).d);
            i++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() throws Throwable {
        com.google.android.libraries.navigation.internal.nw.d dVar;
        com.google.android.libraries.navigation.internal.nw.d dVar2;
        com.google.android.libraries.geo.mapcore.internal.vector.gl.v vVar;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        Iterator it2;
        com.google.android.libraries.navigation.internal.nw.d dVar3;
        float f6;
        Iterator it3;
        float fA;
        com.google.android.libraries.geo.mapcore.renderer.ea eaVar = com.google.android.libraries.geo.mapcore.renderer.ea.INVALID;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("updateGroupVertexData");
        try {
            GeometryUtil geometryUtilA = GeometryUtil.getGeometryUtilFactory().a();
            com.google.android.libraries.geo.mapcore.internal.vector.gl.v builderWithNormalizedDistance = geometryUtilA.getBuilderWithNormalizedDistance("client_line", 385, false, 0, 0, null);
            com.google.android.libraries.geo.mapcore.internal.vector.gl.v builder = geometryUtilA.getBuilder("client_line", 17, false, 0, 0, null);
            float fD = 1.0f;
            if (this.f520n) {
                com.google.android.libraries.navigation.internal.pb.t tVar = new com.google.android.libraries.navigation.internal.pb.t(this.j);
                fD = com.google.android.libraries.navigation.internal.pb.j.d(tVar.w().k, tVar.r(), 1.0f, tVar.j(), tVar.i());
            }
            float f7 = fD;
            no it4 = this.w.iterator();
            while (it4.hasNext()) {
                gw gwVar = (gw) it4.next();
                int i = this.t;
                com.google.android.libraries.navigation.internal.yx.ar.q(gwVar.g);
                boolean zF = gwVar.f();
                float f8 = 0.0f;
                if (zF) {
                    com.google.android.libraries.geo.mapcore.internal.model.bs bsVarF = gwVar.g.f(gw.a(gwVar.g, i), 0);
                    float f9 = bsVarF.d;
                    float f10 = bsVarF.l;
                    float f11 = bsVarF.m;
                    float f12 = f9 + f10;
                    Iterator it5 = gwVar.c.iterator();
                    float f13 = 0.0f;
                    while (it5.hasNext()) {
                        com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.t tVar2 = (com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.t) it5.next();
                        float f14 = f11;
                        float f15 = tVar2.f;
                        if (f15 > f8) {
                            dVar = dVarB;
                            f4 = f9;
                            f5 = f10;
                            it2 = it5;
                        } else {
                            Iterator it6 = tVar2.b.iterator();
                            while (it6.hasNext()) {
                                com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.u uVar = (com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.u) it6.next();
                                Iterator it7 = it6;
                                float f16 = tVar2.f;
                                float f17 = f9;
                                float f18 = uVar.h;
                                if (f18 > 0.0f) {
                                    dVar3 = dVarB;
                                    f6 = f10;
                                    it3 = it5;
                                } else {
                                    int length = uVar.b.length;
                                    if (length != 0) {
                                        float[] fArr = new float[length];
                                        f6 = f10;
                                        it3 = it5;
                                        int i2 = 0;
                                        while (true) {
                                            int[] iArr = uVar.b;
                                            dVar3 = dVarB;
                                            if (i2 >= iArr.length) {
                                                break;
                                            }
                                            fArr[i2] = iArr[i2];
                                            i2++;
                                            dVarB = dVar3;
                                        }
                                        fA = com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.u.a(fArr);
                                        uVar.h = fA;
                                    } else {
                                        dVar3 = dVarB;
                                        f6 = f10;
                                        it3 = it5;
                                        float[] fArr2 = uVar.c;
                                        if (fArr2.length != 0) {
                                            fA = com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.u.a(fArr2);
                                            uVar.h = fA;
                                        }
                                    }
                                    tVar2.f = f16 + fA;
                                    it6 = it7;
                                    f9 = f17;
                                    f10 = f6;
                                    it5 = it3;
                                    dVarB = dVar3;
                                }
                                fA = f18;
                                tVar2.f = f16 + fA;
                                it6 = it7;
                                f9 = f17;
                                f10 = f6;
                                it5 = it3;
                                dVarB = dVar3;
                            }
                            dVar = dVarB;
                            f4 = f9;
                            f5 = f10;
                            it2 = it5;
                            f15 = tVar2.f;
                        }
                        try {
                            f13 += f15;
                            f11 = f14;
                            f9 = f4;
                            f10 = f5;
                            it5 = it2;
                            dVarB = dVar;
                            f8 = 0.0f;
                        } catch (Throwable th) {
                            th = th;
                            Throwable th2 = th;
                            if (dVar == null) {
                                throw th2;
                            }
                            try {
                                Trace.endSection();
                                throw th2;
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                                throw th2;
                            }
                        }
                    }
                    dVar2 = dVarB;
                    gwVar.f = GeometryUtil.getMaxGeneratedVerticesForPointSpriteLine(f13, f7, f12);
                    vVar = builder;
                    f = f11;
                    f2 = f9;
                    f3 = f10;
                } else {
                    dVar2 = dVarB;
                    vVar = builderWithNormalizedDistance;
                    f = 0.0f;
                    f2 = 0.0f;
                    f3 = 0.0f;
                }
                vVar.h();
                float fA2 = gwVar.a.a();
                if (fA2 != 0.0f) {
                    vVar.h = 32767.0f / fA2;
                } else {
                    vVar.h = 32767.0f;
                }
                vVar.n(gwVar.f);
                gwVar.d.w(gwVar.a.c(gwVar.c, zF, new float[]{f2}, new float[]{f3}, new float[]{f}, f7, geometryUtilA, gwVar.g, vVar));
                geometryUtilA = geometryUtilA;
                dVarB = dVar2;
            }
            dVar = dVarB;
            builderWithNormalizedDistance.l();
            builder.l();
            this.u = a(this.s);
            if (dVar != null) {
                Trace.endSection();
            }
        } catch (Throwable th4) {
            th = th4;
            dVar = dVarB;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d() {
        com.google.android.libraries.geo.mapcore.renderer.ea eaVar = com.google.android.libraries.geo.mapcore.renderer.ea.INVALID;
        int i = 0;
        while (true) {
            com.google.android.libraries.navigation.internal.yz.ev evVar = this.w;
            if (i >= ((lv) evVar).c) {
                return;
            }
            com.google.android.libraries.geo.mapcore.renderer.ef efVar = ((gw) evVar.get(i)).h;
            if (efVar instanceof com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.e) {
                com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.e eVar = (com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.e) efVar;
                eVar.d = this.q;
                aw awVar = this.p;
                if (awVar.a) {
                    float f = awVar.b;
                    eVar.a = true;
                    eVar.b = f;
                } else {
                    eVar.a = false;
                }
                eVar.g = this.r;
                eVar.a(this.s, this.t, this.f520n);
            }
            i++;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.v
    public final void h() {
        this.E.d(this);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.v
    public final void i() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.po.b, com.google.android.libraries.navigation.internal.ol.v
    public final synchronized void k(com.google.android.libraries.navigation.internal.ol.as asVar) {
        super.k(asVar);
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("setPickHandler");
        try {
            com.google.android.libraries.navigation.internal.qq.j jVar = this.d;
            if (jVar != null && this.D != null) {
                if (dVarB != null) {
                    Trace.endSection();
                }
                jVar.f74n = this.D;
                return;
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

    @Override // com.google.android.libraries.navigation.internal.po.b, com.google.android.libraries.navigation.internal.ol.v
    public final synchronized void l() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.v
    public final void m() {
        this.E.g(this);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.au
    public final /* synthetic */ com.google.android.libraries.navigation.internal.ael.cy n() {
        return this.B;
    }

    @Override // com.google.android.libraries.navigation.internal.po.b
    protected final void u(int i) {
        v(i, this);
    }

    @Override // com.google.android.libraries.navigation.internal.pp.d
    public final void w() {
        this.v = true;
        ar(this.G);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.pp.d
    public final synchronized void x() {
        if (!this.b) {
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("ClientLinesImpl.onDestroy");
            try {
                this.y.e(this.x);
                this.b = true;
                o();
                if (this.i) {
                    no it2 = this.w.iterator();
                    while (it2.hasNext()) {
                        this.h.m(((gw) it2.next()).d);
                    }
                    com.google.android.libraries.navigation.internal.qq.j jVar = this.d;
                    if (jVar != null) {
                        this.h.m(jVar);
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
    }

    @Override // com.google.android.libraries.navigation.internal.pp.d
    public final void y() {
        e(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.pp.d
    public final synchronized void z() {
        if (this.b) {
            return;
        }
        if (!this.i) {
            this.i = true;
            com.google.android.libraries.navigation.internal.yz.ev evVar = this.w;
            for (int i = 0; i < ((lv) evVar).c; i++) {
                this.h.c(((gw) evVar.get(i)).d);
            }
            com.google.android.libraries.navigation.internal.qq.j jVar = this.d;
            if (jVar != null) {
                com.google.android.libraries.navigation.internal.ol.g gVar = this.F;
                if (gVar != null) {
                    this.h.d(jVar, gVar);
                } else {
                    this.h.d(jVar, this);
                }
            }
        }
        e(true);
    }
}
