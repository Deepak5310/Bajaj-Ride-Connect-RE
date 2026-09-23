package com.google.android.libraries.navigation.internal.qd;

import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.ClientLineStampShaderState;
import com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.RoadStrokePointSpriteShaderState;
import com.google.android.libraries.geo.mapcore.internal.model.ar;
import com.google.android.libraries.geo.mapcore.internal.model.ay;
import com.google.android.libraries.geo.mapcore.internal.model.bs;
import com.google.android.libraries.geo.mapcore.internal.model.bt;
import com.google.android.libraries.geo.mapcore.internal.vector.gl.GeometryUtil;
import com.google.android.libraries.geo.mapcore.renderer.Cdo;
import com.google.android.libraries.geo.mapcore.renderer.ae;
import com.google.android.libraries.geo.mapcore.renderer.af;
import com.google.android.libraries.geo.mapcore.renderer.ax;
import com.google.android.libraries.geo.mapcore.renderer.cs;
import com.google.android.libraries.geo.mapcore.renderer.ef;
import com.google.android.libraries.geo.mapcore.renderer.ek;
import com.google.android.libraries.geo.mapcore.renderer.ey;
import com.google.android.libraries.geo.mapcore.renderer.ff;
import com.google.android.libraries.navigation.internal.adg.ib;
import com.google.android.libraries.navigation.internal.oe.ad;
import com.google.android.libraries.navigation.internal.oe.ai;
import com.google.android.libraries.navigation.internal.ol.au;
import com.google.android.libraries.navigation.internal.yz.ee;
import com.google.android.libraries.navigation.internal.yz.gs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o extends l {
    private static long A;
    private static int B;
    private final com.google.android.libraries.geo.mapcore.internal.vector.gl.p C;
    private GeometryUtil D;
    private final float E;
    private int F;
    private float G;
    private float H;
    private ef I;
    private boolean J;
    public final au i;
    public com.google.android.libraries.navigation.internal.qq.d j;
    public com.google.android.libraries.navigation.internal.qq.j k;
    public final Object l;
    public Cdo m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f547n;
    public final long o;
    public final List p;
    public boolean q;
    public int r;
    public int s;
    public final float t;
    public final com.google.android.libraries.navigation.internal.pi.s u;
    public long v;
    public long w;
    public long x;
    public final Object y;
    public com.google.android.libraries.navigation.internal.ol.q z;

    public o(com.google.android.libraries.geo.mapcore.internal.vector.gl.p pVar, ax axVar, au auVar, float f, com.google.android.libraries.navigation.internal.pi.s sVar) {
        super(axVar);
        this.l = new Object();
        this.m = com.google.android.libraries.navigation.internal.qq.u.a;
        this.f547n = false;
        this.q = false;
        this.r = 1;
        this.s = 1;
        this.F = -2;
        this.G = 1.0f;
        this.y = new Object();
        this.J = false;
        this.C = pVar;
        this.i = auVar;
        this.u = sVar;
        this.E = f;
        this.t = f * 4.5f;
        this.p = new ArrayList();
        long j = A;
        A = 1 + j;
        this.o = j;
    }

    private final boolean n() {
        int i = ((ar) this.d.keySet().iterator().next()).e.d().J;
        int i2 = ib.a;
        if (i2 != 0) {
            return ay.f(i, i2);
        }
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.qd.l
    public final void a() {
        com.google.android.libraries.navigation.internal.qq.d dVar = this.j;
        if (dVar == null || this.k == null) {
            return;
        }
        this.g.c(dVar);
        this.g.d(this.k, this.i);
        this.J = true;
    }

    @Override // com.google.android.libraries.navigation.internal.qd.l
    public final synchronized void d() {
        super.d();
        com.google.android.libraries.geo.mapcore.internal.vector.gl.v vVar = this.h;
        if (vVar != null) {
            vVar.l();
            this.h = null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qd.l
    protected final void e(af afVar) {
        ae aeVar;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("doInitialize-styleLock");
        try {
            synchronized (this.y) {
                long j = this.v;
                long j2 = this.w;
                long j3 = this.x;
                int i = B;
                B = i + 1;
                aeVar = new ae(j, j2, j3, i);
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            com.google.android.libraries.navigation.internal.qq.d dVar = new com.google.android.libraries.navigation.internal.qq.d(afVar, aeVar);
            this.j = dVar;
            dVar.a = this.C;
            com.google.android.libraries.navigation.internal.qq.d dVar2 = this.j;
            dVar2.t = 519;
            dVar2.t(1, 771);
            com.google.android.libraries.navigation.internal.qq.j jVar = new com.google.android.libraries.navigation.internal.qq.j(afVar, aeVar);
            this.k = jVar;
            jVar.f74n = com.google.android.libraries.navigation.internal.qq.u.a;
            this.D = GeometryUtil.getGeometryUtilFactory().a();
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

    @Override // com.google.android.libraries.navigation.internal.qd.l
    protected final void h(com.google.android.libraries.navigation.internal.pb.t tVar) {
        float f = tVar.w().k;
        if (Math.abs(f - this.H) < 0.001d) {
            return;
        }
        this.H = f;
        ef efVar = this.I;
        if (efVar instanceof com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.e) {
            ((com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.e) efVar).a(f, this.F, false);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qd.l
    public final void i() {
        com.google.android.libraries.navigation.internal.qq.d dVar = this.j;
        if (dVar == null || this.k == null) {
            return;
        }
        if (this.J) {
            this.g.m(dVar);
            this.g.m(this.k);
        }
        this.J = false;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:40:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:49:0x010d  */
    /* JADX WARN: Code duplicated, block: B:55:0x0173  */
    /* JADX WARN: Code duplicated, block: B:59:0x0190  */
    /* JADX WARN: Code duplicated, block: B:89:0x0162 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.libraries.navigation.internal.qd.l
    protected final boolean k(com.google.android.libraries.navigation.internal.pb.t tVar, ai aiVar) {
        com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.a aVar;
        ff ffVarM;
        com.google.android.libraries.navigation.internal.nw.d dVarB;
        ef efVar;
        com.google.android.libraries.geo.mapcore.internal.model.ai aiVarF;
        ek ekVarT;
        if (this.j != null && this.k != null) {
            float f = tVar.w().k;
            synchronized (this.y) {
                com.google.android.libraries.navigation.internal.yx.ar.k(true);
            }
            int size = this.d.size();
            com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("reduceOrExtendRoadStyleMapping-styleLock");
            try {
                synchronized (this.y) {
                    if (!this.p.isEmpty()) {
                        int iAbs = Math.abs(size - this.p.size());
                        if (iAbs != 0) {
                            if (size < this.p.size()) {
                                int size2 = this.p.size() - 1;
                                for (int i = 0; i < iAbs; i++) {
                                    this.p.remove(size2 - i);
                                }
                            } else {
                                this.p.addAll(Collections.nCopies(iAbs, (bt) gs.d(this.p)));
                            }
                            if (dVarB2 != null) {
                            }
                        } else if (dVarB2 != null) {
                        }
                    } else if (dVarB2 != null) {
                    }
                    this.F = (int) f;
                    this.G = com.google.android.libraries.navigation.internal.pb.j.d(tVar.w().k, tVar.r(), 1.0f, tVar.j(), tVar.i());
                    this.H = f;
                    aVar = new com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.a(this.E, this.F, false);
                    ffVarM = m(aVar, aiVar.e(), aiVar.a);
                    if (n()) {
                        com.google.android.libraries.navigation.internal.yx.ar.q(this.j);
                        RoadStrokePointSpriteShaderState roadStrokePointSpriteShaderState = new RoadStrokePointSpriteShaderState(this.z);
                        aiVarF = ((ar) this.d.keySet().iterator().next()).e.f(this.H);
                        if (aVar.d(aiVarF) > 0) {
                            ekVarT = this.C.t(aVar.f(aiVarF, 0).i);
                            if (ekVarT != null) {
                                this.j.B(3, ekVarT);
                            }
                        }
                        synchronized (this.y) {
                            this.j.f(aVar.c, false);
                            this.j.e(this.H);
                        }
                        efVar = roadStrokePointSpriteShaderState;
                    } else {
                        com.google.android.libraries.navigation.internal.yx.ar.q(this.j);
                        ey eyVar = new ey("stroke_dash", null, 2, 3);
                        eyVar.d(new cs(aVar.a((int) this.H), 1, 64, 32, true));
                        this.j.B(5, eyVar);
                        ey eyVar2 = new ey("stroke_color", null, 2, 1);
                        eyVar2.d(new cs(aVar.b(), 4, com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.a.a, 96, false));
                        this.j.B(4, eyVar2);
                        dVarB = com.google.android.libraries.navigation.internal.nw.e.b("regenerateRoadShaderState-styleLock");
                        try {
                            synchronized (this.y) {
                                try {
                                    this.j.f(aVar.c, false);
                                    this.j.e(this.H);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            if (dVarB != null) {
                                Trace.endSection();
                            }
                            float f2 = this.F;
                            ClientLineStampShaderState clientLineStampShaderState = new ClientLineStampShaderState(f2, this.j, this.z);
                            clientLineStampShaderState.a(this.H, f2, false);
                            efVar = clientLineStampShaderState;
                        } catch (Throwable th2) {
                            if (dVarB == null) {
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
                    this.I = efVar;
                    this.j.w(ffVarM);
                    if (ffVarM != null) {
                        this.j.v(this.I);
                        this.j.k(aiVar.a);
                        this.j.l(1.0f);
                        return true;
                    }
                }
                Trace.endSection();
                this.F = (int) f;
                this.G = com.google.android.libraries.navigation.internal.pb.j.d(tVar.w().k, tVar.r(), 1.0f, tVar.j(), tVar.i());
                this.H = f;
                aVar = new com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.a(this.E, this.F, false);
                ffVarM = m(aVar, aiVar.e(), aiVar.a);
                if (n()) {
                    com.google.android.libraries.navigation.internal.yx.ar.q(this.j);
                    RoadStrokePointSpriteShaderState roadStrokePointSpriteShaderState2 = new RoadStrokePointSpriteShaderState(this.z);
                    aiVarF = ((ar) this.d.keySet().iterator().next()).e.f(this.H);
                    if (aVar.d(aiVarF) > 0) {
                        ekVarT = this.C.t(aVar.f(aiVarF, 0).i);
                        if (ekVarT != null) {
                            this.j.B(3, ekVarT);
                        }
                    }
                    synchronized (this.y) {
                        this.j.f(aVar.c, false);
                        this.j.e(this.H);
                        efVar = roadStrokePointSpriteShaderState2;
                    }
                } else {
                    com.google.android.libraries.navigation.internal.yx.ar.q(this.j);
                    ey eyVar3 = new ey("stroke_dash", null, 2, 3);
                    eyVar3.d(new cs(aVar.a((int) this.H), 1, 64, 32, true));
                    this.j.B(5, eyVar3);
                    ey eyVar4 = new ey("stroke_color", null, 2, 1);
                    eyVar4.d(new cs(aVar.b(), 4, com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.a.a, 96, false));
                    this.j.B(4, eyVar4);
                    dVarB = com.google.android.libraries.navigation.internal.nw.e.b("regenerateRoadShaderState-styleLock");
                    synchronized (this.y) {
                        this.j.f(aVar.c, false);
                        this.j.e(this.H);
                        if (dVarB != null) {
                            Trace.endSection();
                        }
                        float f3 = this.F;
                        ClientLineStampShaderState clientLineStampShaderState2 = new ClientLineStampShaderState(f3, this.j, this.z);
                        clientLineStampShaderState2.a(this.H, f3, false);
                        efVar = clientLineStampShaderState2;
                    }
                }
                this.I = efVar;
                this.j.w(ffVarM);
                if (ffVarM != null) {
                    this.j.v(this.I);
                    this.j.k(aiVar.a);
                    this.j.l(1.0f);
                    return true;
                }
            } catch (Throwable th4) {
                if (dVarB2 == null) {
                    throw th4;
                }
                try {
                    Trace.endSection();
                    throw th4;
                } catch (Throwable th5) {
                    th4.addSuppressed(th5);
                    throw th4;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.qd.l
    public final boolean l(com.google.android.libraries.navigation.internal.pb.t tVar) {
        if (this.d.isEmpty()) {
            return false;
        }
        synchronized (this) {
            if (this.f) {
                this.f = false;
                return true;
            }
            float f = tVar.w().k - this.F;
            return f > (true != n() ? 1.0f : 0.25f) || f < 0.0f;
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00ee  */
    public final synchronized ff m(com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.a aVar, float f, com.google.android.libraries.navigation.internal.oe.x xVar) {
        boolean z;
        int i;
        int i2;
        ff ffVar;
        boolean z2;
        com.google.android.libraries.geo.mapcore.internal.vector.gl.v vVar;
        boolean z3;
        float f2;
        float f3;
        float f4;
        boolean z4;
        float f5;
        ad adVar;
        com.google.android.libraries.navigation.internal.oe.ae aeVar;
        com.google.android.libraries.navigation.internal.oe.ae aeVar2;
        com.google.android.libraries.navigation.internal.oe.x xVar2;
        try {
            com.google.android.libraries.navigation.internal.yx.ar.q(this.D);
            boolean zN = n();
            if (this.h == null) {
                this.h = this.D.getBuilderWithNormalizedDistance("client_roads", true != zN ? 385 : 17, false, 0, 0, null);
            }
            this.h.h();
            this.h.h = 32767.0f / f;
            int maxGeneratedVerticesForPointSpriteLine = 0;
            for (Map.Entry entry : this.d.entrySet()) {
                if (zN) {
                    bs bsVarF = aVar.f(((ar) entry.getKey()).e.f(this.F), 0);
                    float f6 = bsVarF.l + bsVarF.d;
                    Iterator it2 = ((List) entry.getValue()).iterator();
                    float fA = 0.0f;
                    while (it2.hasNext()) {
                        fA += ((ad) it2.next()).a();
                    }
                    maxGeneratedVerticesForPointSpriteLine += GeometryUtil.getMaxGeneratedVerticesForPointSpriteLine(fA, this.G, f6);
                } else {
                    int i3 = ((ar) entry.getKey()).i;
                    Iterator it3 = ((List) entry.getValue()).iterator();
                    while (it3.hasNext()) {
                        maxGeneratedVerticesForPointSpriteLine += GeometryUtil.getMaxGeneratedVerticesForLine(((ad) it3.next()).e(), i3, 0);
                    }
                }
            }
            this.h.n(maxGeneratedVerticesForPointSpriteLine);
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("regenerateVertexData-styleLock");
            try {
                synchronized (this.y) {
                    try {
                        z = this.q;
                        i = this.r;
                        i2 = this.s;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (dVarB != null) {
                    Trace.endSection();
                }
                com.google.android.libraries.geo.mapcore.internal.vector.gl.v vVar2 = this.h;
                ffVar = null;
                if (vVar2 != null) {
                    Map map = this.d;
                    float f7 = this.F;
                    float f8 = this.G;
                    GeometryUtil geometryUtil = this.D;
                    if (z) {
                        ArrayList arrayList = new ArrayList();
                        if (map.isEmpty()) {
                            z2 = zN;
                            vVar = vVar2;
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = new ArrayList();
                            ArrayList arrayList4 = new ArrayList();
                            bt btVar = ((ar) map.keySet().iterator().next()).e;
                            if (btVar != null) {
                                Iterator it4 = map.entrySet().iterator();
                                while (it4.hasNext()) {
                                    Map.Entry entry2 = (Map.Entry) it4.next();
                                    List list = (List) entry2.getValue();
                                    Iterator it5 = it4;
                                    ar arVar = (ar) entry2.getKey();
                                    float f9 = f8;
                                    if (arVar.e == null) {
                                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.v.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1054)).p("null style entry for a segment.");
                                    }
                                    bt btVar2 = arVar.e;
                                    bt btVar3 = arVar.f;
                                    if (btVar3 == null) {
                                        btVar3 = bt.a;
                                    }
                                    if (btVar2.f(f7) != null) {
                                        int size = list.size();
                                        int i4 = 0;
                                        while (i4 < size) {
                                            List list2 = list;
                                            ad adVar2 = (ad) list.get(i4);
                                            int i5 = size;
                                            int i6 = i2;
                                            if (adVar2.e() >= 2 && btVar2.l()) {
                                                arrayList.add(adVar2);
                                                arrayList2.add(btVar2);
                                                arrayList3.add(btVar3);
                                                arrayList4.add(Integer.valueOf(arVar.i));
                                            }
                                            i4++;
                                            size = i5;
                                            list = list2;
                                            i2 = i6;
                                        }
                                    }
                                    f8 = f9;
                                    it4 = it5;
                                    vVar2 = vVar2;
                                    i = i;
                                    geometryUtil = geometryUtil;
                                }
                                int i7 = i;
                                int i8 = i2;
                                GeometryUtil geometryUtil2 = geometryUtil;
                                float f10 = f8;
                                com.google.android.libraries.geo.mapcore.internal.vector.gl.v vVar3 = vVar2;
                                if (arrayList.isEmpty()) {
                                    z2 = zN;
                                } else {
                                    ArrayList arrayList5 = new ArrayList();
                                    HashSet hashSet = new HashSet();
                                    ee eeVar = new ee();
                                    ee eeVar2 = new ee();
                                    int i9 = 0;
                                    while (i9 < arrayList.size()) {
                                        ad adVar3 = (ad) arrayList.get(i9);
                                        bt btVar4 = btVar;
                                        com.google.android.libraries.navigation.internal.oe.x xVarL = adVar3.l(0);
                                        com.google.android.libraries.navigation.internal.oe.x xVarK = adVar3.k();
                                        Iterator it6 = eeVar2.c(xVarL).iterator();
                                        if (it6.hasNext()) {
                                            aeVar = (com.google.android.libraries.navigation.internal.oe.ae) it6.next();
                                            com.google.android.libraries.navigation.internal.oe.af.a(aeVar, eeVar, eeVar2, hashSet);
                                        } else {
                                            aeVar = null;
                                        }
                                        Iterator it7 = eeVar.c(xVarK).iterator();
                                        if (it7.hasNext()) {
                                            aeVar2 = (com.google.android.libraries.navigation.internal.oe.ae) it7.next();
                                            com.google.android.libraries.navigation.internal.oe.af.a(aeVar2, eeVar, eeVar2, hashSet);
                                        } else {
                                            aeVar2 = null;
                                        }
                                        ArrayList arrayList6 = new ArrayList();
                                        if (aeVar != null) {
                                            xVarL = aeVar.b();
                                            arrayList6.addAll(aeVar.c());
                                        }
                                        com.google.android.libraries.navigation.internal.oe.x xVar3 = xVarL;
                                        ArrayList arrayList7 = arrayList4;
                                        arrayList6.add(Integer.valueOf(i9));
                                        if (aeVar2 != null) {
                                            com.google.android.libraries.navigation.internal.oe.x xVarA = aeVar2.a();
                                            arrayList6.addAll(aeVar2.c());
                                            xVar2 = xVarA;
                                        } else {
                                            xVar2 = xVarK;
                                        }
                                        com.google.android.libraries.navigation.internal.oe.a aVar2 = new com.google.android.libraries.navigation.internal.oe.a(xVar3, xVar2, arrayList6);
                                        hashSet.add(aVar2);
                                        eeVar.t(xVar3, aVar2);
                                        eeVar2.t(xVar2, aVar2);
                                        i9++;
                                        btVar = btVar4;
                                        arrayList4 = arrayList7;
                                    }
                                    ArrayList arrayList8 = arrayList4;
                                    bt btVar5 = btVar;
                                    ArrayList arrayList9 = new ArrayList();
                                    Iterator it8 = hashSet.iterator();
                                    while (it8.hasNext()) {
                                        List listC = ((com.google.android.libraries.navigation.internal.oe.ae) it8.next()).c();
                                        if (arrayList.isEmpty()) {
                                            adVar = ad.a;
                                            z4 = zN;
                                            f5 = f7;
                                        } else {
                                            int i10 = 0;
                                            int i11 = 0;
                                            while (i10 < listC.size()) {
                                                int iE = ((ad) arrayList.get(((Integer) listC.get(i10)).intValue())).e() - (i10 == 0 ? 0 : 1);
                                                i11 += iE + iE;
                                                i10++;
                                            }
                                            int[] iArr = new int[i11];
                                            int i12 = ((ad) arrayList.get(0)).e;
                                            int i13 = ((ad) arrayList.get(0)).c;
                                            int i14 = ((ad) arrayList.get(0)).d;
                                            int i15 = 0;
                                            int i16 = 0;
                                            while (i15 < listC.size()) {
                                                ad adVar4 = (ad) arrayList.get(((Integer) listC.get(i15)).intValue());
                                                boolean z5 = zN;
                                                if (adVar4.e != i12 || adVar4.c != i13 || adVar4.d != i14) {
                                                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.oe.af.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(814)).A("PolylineStitcher given polylines with different scales (%s, %s)  or xOffset (%s, %s) or yOffset(%s, %s)", Integer.valueOf(adVar4.e), Integer.valueOf(i12), Integer.valueOf(adVar4.c), Integer.valueOf(i13), Integer.valueOf(adVar4.d), Integer.valueOf(i14));
                                                }
                                                int i17 = i15 > 0 ? 2 : 0;
                                                while (true) {
                                                    int[] iArr2 = adVar4.b;
                                                    ad adVar5 = adVar4;
                                                    if (i17 < iArr2.length) {
                                                        int i18 = i16 + 1;
                                                        iArr[i16] = iArr2[i17];
                                                        i16 += 2;
                                                        iArr[i18] = iArr2[i17 + 1];
                                                        i17 += 2;
                                                        adVar4 = adVar5;
                                                    }
                                                }
                                                i15++;
                                                zN = z5;
                                                f7 = f7;
                                            }
                                            z4 = zN;
                                            f5 = f7;
                                            adVar = new ad(iArr, i12, i13, i14, !listC.isEmpty() ? ((ad) arrayList.get(((Integer) listC.get(0)).intValue())).f : 0.0f);
                                        }
                                        arrayList9.add(adVar);
                                        arrayList5.add(listC);
                                        it8 = it8;
                                        zN = z4;
                                        f7 = f5;
                                    }
                                    z2 = zN;
                                    float f11 = f7;
                                    ArrayList arrayList10 = new ArrayList();
                                    ArrayList arrayList11 = new ArrayList();
                                    ArrayList arrayList12 = new ArrayList();
                                    ArrayList arrayList13 = new ArrayList();
                                    ArrayList arrayList14 = new ArrayList();
                                    ArrayList arrayList15 = new ArrayList();
                                    ArrayList arrayList16 = new ArrayList();
                                    int size2 = arrayList5.size();
                                    int i19 = 0;
                                    while (i19 < size2) {
                                        int i20 = size2;
                                        List list3 = (List) arrayList5.get(i19);
                                        ArrayList arrayList17 = arrayList9;
                                        int[] iArr3 = new int[list3.size()];
                                        ArrayList arrayList18 = arrayList5;
                                        float[] fArr = new float[list3.size()];
                                        int i21 = i19;
                                        int[] iArr4 = new int[list3.size()];
                                        ArrayList arrayList19 = arrayList16;
                                        float[] fArr2 = new float[list3.size()];
                                        ArrayList arrayList20 = arrayList15;
                                        float[] fArr3 = new float[list3.size()];
                                        ArrayList arrayList21 = arrayList14;
                                        float[] fArr4 = new float[list3.size()];
                                        ArrayList arrayList22 = arrayList13;
                                        int size3 = list3.size() - 1;
                                        ArrayList arrayList23 = arrayList12;
                                        ArrayList arrayList24 = arrayList11;
                                        int i22 = 0;
                                        int i23 = 0;
                                        int iIntValue = 0;
                                        int iE2 = 0;
                                        while (i22 < list3.size()) {
                                            int iIntValue2 = ((Integer) list3.get(i22)).intValue();
                                            List list4 = list3;
                                            bt btVar6 = (bt) arrayList2.get(iIntValue2);
                                            ArrayList arrayList25 = arrayList2;
                                            iArr3[i23] = aVar.c(btVar6, (bt) arrayList3.get(iIntValue2));
                                            float f12 = f11;
                                            com.google.android.libraries.geo.mapcore.internal.model.ai aiVarF = btVar6.f(f12);
                                            fArr[i23] = 0.0f;
                                            fArr2[i23] = 0.0f;
                                            if (aVar.d(aiVarF) > 0) {
                                                bs bsVarF2 = aVar.f(aiVarF, 0);
                                                if (z2) {
                                                    fArr2[i23] = bsVarF2.d;
                                                    fArr3[i23] = bsVarF2.l;
                                                    fArr4[i23] = bsVarF2.m;
                                                }
                                                fArr[i23] = bsVarF2.h;
                                            }
                                            iE2 += ((ad) arrayList.get(iIntValue2)).e() - (i22 == size3 ? 0 : 1);
                                            iArr4[i23] = iE2;
                                            ArrayList arrayList26 = arrayList8;
                                            iIntValue = ((Integer) arrayList26.get(iIntValue2)).intValue();
                                            i23++;
                                            i22++;
                                            arrayList3 = arrayList3;
                                            arrayList8 = arrayList26;
                                            f11 = f12;
                                            list3 = list4;
                                            arrayList2 = arrayList25;
                                        }
                                        arrayList10.add(iArr3);
                                        arrayList11 = arrayList24;
                                        arrayList11.add(fArr);
                                        arrayList12 = arrayList23;
                                        arrayList12.add(iArr4);
                                        arrayList13 = arrayList22;
                                        arrayList13.add(fArr2);
                                        arrayList21.add(fArr3);
                                        arrayList15 = arrayList20;
                                        arrayList15.add(fArr4);
                                        arrayList16 = arrayList19;
                                        arrayList16.add(Integer.valueOf(iIntValue));
                                        i19 = i21 + 1;
                                        arrayList3 = arrayList3;
                                        arrayList8 = arrayList8;
                                        f11 = f11;
                                        arrayList14 = arrayList21;
                                        arrayList9 = arrayList17;
                                        size2 = i20;
                                        arrayList5 = arrayList18;
                                        arrayList2 = arrayList2;
                                    }
                                    ArrayList arrayList27 = arrayList5;
                                    ArrayList arrayList28 = arrayList9;
                                    ArrayList arrayList29 = arrayList14;
                                    com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.s sVarA = com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.v.a(aVar, btVar5, f11, i7, i8);
                                    int i24 = 0;
                                    while (i24 < arrayList27.size()) {
                                        ArrayList arrayList30 = arrayList28;
                                        float f13 = f10;
                                        geometryUtil2.addExtrudedMultiSegmentRoadsWithNormals(((ad) arrayList30.get(i24)).b, (int[]) arrayList12.get(i24), xVar, (float[]) arrayList11.get(i24), vVar3, sVarA.a, sVarA.b, ((Integer) arrayList16.get(i24)).intValue(), 0.0f, (int[]) arrayList10.get(i24), z2, (float[]) arrayList13.get(i24), (float[]) arrayList29.get(i24), (float[]) arrayList15.get(i24), false, f13, ((ad) arrayList30.get(i24)).f, null, null);
                                        i24++;
                                        sVarA = sVarA;
                                        vVar3 = vVar3;
                                        arrayList12 = arrayList12;
                                        arrayList27 = arrayList27;
                                        arrayList28 = arrayList30;
                                        arrayList11 = arrayList11;
                                        arrayList16 = arrayList16;
                                        arrayList15 = arrayList15;
                                        arrayList29 = arrayList29;
                                        arrayList13 = arrayList13;
                                        geometryUtil2 = geometryUtil2;
                                        f10 = f13;
                                    }
                                }
                                vVar = vVar3;
                            } else {
                                z2 = zN;
                                vVar = vVar2;
                            }
                        }
                    } else {
                        z2 = zN;
                        if (!map.isEmpty()) {
                            ArrayList arrayList31 = new ArrayList();
                            ArrayList arrayList32 = new ArrayList();
                            ArrayList arrayList33 = new ArrayList();
                            Iterator it9 = map.entrySet().iterator();
                            while (it9.hasNext()) {
                                Map.Entry entry3 = (Map.Entry) it9.next();
                                arrayList31.clear();
                                arrayList32.clear();
                                List list5 = (List) entry3.getValue();
                                ar arVar2 = (ar) entry3.getKey();
                                bt btVar7 = arVar2.e;
                                bt btVar8 = arVar2.f;
                                if (btVar7 == null) {
                                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.v.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1053)).p("segment style entry is null");
                                }
                                int size4 = list5.size();
                                for (int i25 = 0; i25 < size4; i25++) {
                                    ad adVar6 = (ad) list5.get(i25);
                                    if (adVar6.e() >= 2 && btVar7.l()) {
                                        arrayList31.add(adVar6);
                                        arrayList32.add(btVar7);
                                        if (btVar8 == null) {
                                            btVar8 = bt.a;
                                        }
                                        arrayList33.add(btVar8);
                                    }
                                }
                                com.google.android.libraries.geo.mapcore.internal.model.ai aiVarF2 = btVar7.f(f7);
                                if (aiVarF2 != null && aVar.d(aiVarF2) != 0) {
                                    int i26 = arVar2.g;
                                    int i27 = arVar2.h;
                                    int i28 = arVar2.i;
                                    float f14 = arVar2.a;
                                    int i29 = 0;
                                    bs bsVarF3 = aVar.f(aiVarF2, 0);
                                    if (z2) {
                                        f2 = bsVarF3.d;
                                        f3 = bsVarF3.l;
                                        f4 = bsVarF3.m;
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                        f2 = 0.0f;
                                        f3 = 0.0f;
                                        f4 = 0.0f;
                                    }
                                    float f15 = bsVarF3.h;
                                    Iterator it10 = it9;
                                    while (i29 < arrayList31.size()) {
                                        ad adVar7 = (ad) arrayList31.get(i29);
                                        geometryUtil.addExtrudedRoadsWithNormals(adVar7.b, null, xVar, f15, vVar2, i26, i27, i28, f14, aVar.c((bt) arrayList32.get(i29), (bt) arrayList33.get(i29)), z3, f2, f3, f4, f8, 0, adVar7.f);
                                        i29++;
                                        arrayList31 = arrayList31;
                                        arrayList32 = arrayList32;
                                    }
                                    it9 = it10;
                                }
                            }
                        }
                        vVar = vVar2;
                    }
                    if (vVar.f > 0) {
                        ff ffVarC = vVar.c(true != z2 ? 5 : 4);
                        ffVarC.c(false);
                        ffVar = ffVarC;
                    }
                }
                int i30 = this.h.f;
            } catch (Throwable th2) {
                if (dVarB == null) {
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
        } catch (Throwable th4) {
            throw th4;
        }
        return ffVar;
    }
}
