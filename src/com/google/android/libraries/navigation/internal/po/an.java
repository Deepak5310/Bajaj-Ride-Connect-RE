package com.google.android.libraries.navigation.internal.po;

import android.content.Context;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.adg.jr;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class an extends b implements com.google.android.libraries.navigation.internal.pp.b {
    private static final com.google.android.libraries.geo.mapcore.internal.model.ar[] g = new com.google.android.libraries.geo.mapcore.internal.model.ar[0];
    public com.google.android.libraries.navigation.internal.qd.f c;
    public com.google.android.libraries.navigation.internal.qd.f d;
    public boolean e;
    public final boolean f;
    private float h;
    private com.google.android.libraries.geo.mapcore.internal.model.ar[] i;
    private final Object j;
    private final List k;
    private final com.google.android.libraries.navigation.internal.ol.ak l;
    private final com.google.android.libraries.geo.mapcore.renderer.af m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Map f519n;
    private final com.google.android.libraries.geo.mapcore.renderer.ax o;
    private com.google.android.libraries.navigation.internal.adg.fg p;
    private com.google.android.libraries.navigation.internal.qd.o q;
    private final gr r;

    public an(com.google.android.libraries.navigation.internal.ol.ak akVar, com.google.android.libraries.geo.mapcore.internal.vector.gl.p pVar, com.google.android.libraries.geo.mapcore.renderer.ax axVar, Map map, gr grVar, com.google.android.libraries.navigation.internal.pi.s sVar, Context context, com.google.android.libraries.geo.mapcore.renderer.af afVar, boolean z) {
        super(grVar);
        this.h = 0.0f;
        this.j = new Object();
        this.k = new ArrayList();
        this.f519n = map;
        this.o = axVar;
        this.r = grVar;
        this.l = akVar;
        this.m = afVar;
        this.i = null;
        this.p = null;
        this.q = null;
        this.f = z;
        this.q = new com.google.android.libraries.navigation.internal.qd.o(pVar, axVar, this, context.getResources().getDisplayMetrics().density, sVar);
    }

    private final void C(final boolean z, final boolean z2) {
        boolean z3;
        synchronized (this) {
            if (this.b) {
                return;
            }
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("setGLState");
            try {
                synchronized (this.j) {
                    if (this.k.isEmpty()) {
                        z3 = true;
                    } else {
                        final com.google.android.libraries.navigation.internal.hx.d dVar = new com.google.android.libraries.navigation.internal.hx.d(this.k.size(), new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.ak
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.f(z, z2);
                            }
                        });
                        Iterator it2 = this.k.iterator();
                        while (it2.hasNext()) {
                            ((com.google.android.libraries.navigation.internal.ol.aq) it2.next()).f(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.al
                                @Override // java.lang.Runnable
                                public final void run() {
                                    dVar.a();
                                }
                            });
                        }
                        z3 = false;
                    }
                }
                if (z3) {
                    f(z, z2);
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

    final void A(com.google.android.libraries.geo.mapcore.internal.model.ar[] arVarArr) {
        if (arVarArr.length == 0) {
            return;
        }
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("setParsedRoadsFromProto");
        try {
            com.google.android.libraries.navigation.internal.qd.o oVar = this.q;
            com.google.android.libraries.geo.mapcore.internal.model.ar arVar = arVarArr[0];
            long j = arVar.e.g(arVar.r).H;
            com.google.android.libraries.geo.mapcore.internal.model.ar arVar2 = arVarArr[0];
            long j2 = arVar2.b;
            long j3 = arVar2.c;
            com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("setZOrderTriple-styleLock");
            try {
                synchronized (oVar.y) {
                    oVar.v = j;
                    oVar.w = j2;
                    oVar.x = j3;
                }
                if (dVarB2 != null) {
                    Trace.endSection();
                }
                synchronized (this) {
                    if (!this.b) {
                        this.a = false;
                        com.google.android.libraries.navigation.internal.qd.f fVar = this.c;
                        if (fVar != null) {
                            fVar.g();
                        }
                        this.i = arVarArr;
                        com.google.android.libraries.navigation.internal.qd.o oVar2 = this.q;
                        com.google.android.libraries.geo.mapcore.renderer.ax axVar = this.o;
                        gr grVar = this.r;
                        com.google.android.libraries.geo.mapcore.renderer.af afVar = this.m;
                        com.google.android.libraries.navigation.internal.adg.fg fgVarN = n();
                        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.geo.mapcore.internal.model.aw.e);
                        fgVarN.h(bhVarS);
                        Object objK = fgVarN.w.k(bhVarS.d);
                        this.c = new com.google.android.libraries.navigation.internal.qd.f(arVarArr, oVar2, axVar, grVar, afVar, ((Boolean) (objK == null ? bhVarS.b : bhVarS.c(objK))).booleanValue());
                        C(true, false);
                    }
                }
                if (dVarB != null) {
                    Trace.endSection();
                }
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
        } catch (Throwable th3) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }

    final void B(com.google.android.libraries.navigation.internal.adg.fg fgVar, jr jrVar, com.google.android.libraries.navigation.internal.pp.h hVar, com.google.android.libraries.navigation.internal.agg.ez ezVar) {
        com.google.android.libraries.geo.mapcore.internal.model.ar[] arVarArr;
        int i;
        int i2;
        this.p = fgVar;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("setDependentStyles");
        try {
            synchronized (this.j) {
                this.k.clear();
                com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.f);
                fgVar.h(bhVarS);
                if (fgVar.w.n(bhVarS.d)) {
                    List list = this.k;
                    com.google.android.libraries.navigation.internal.ael.bh bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.f);
                    fgVar.h(bhVarS2);
                    Object objK = fgVar.w.k(bhVarS2.d);
                    list.add(hVar.c(((com.google.android.libraries.navigation.internal.adg.es) (objK == null ? bhVarS2.b : bhVarS2.c(objK))).c));
                } else {
                    int i3 = fgVar.b;
                    if ((i3 & 512) != 0) {
                        this.k.add(hVar.c(fgVar.f197n));
                    } else if ((i3 & 256) != 0) {
                        this.k.add(hVar.c(fgVar.m));
                    }
                }
                com.google.android.libraries.navigation.internal.yx.ar.k(this.k.size() <= 1);
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            com.google.android.libraries.navigation.internal.oe.o oVar = (com.google.android.libraries.navigation.internal.oe.o) this.f519n.get(jrVar);
            com.google.android.libraries.navigation.internal.yx.ar.q(oVar);
            try {
                ArrayList arrayList = new ArrayList();
                com.google.android.libraries.geo.mapcore.internal.model.ar.d(fgVar, oVar, hVar, null, true, arrayList, ezVar);
                if (arrayList.isEmpty()) {
                    arVarArr = g;
                } else {
                    arVarArr = new com.google.android.libraries.geo.mapcore.internal.model.ar[arrayList.size()];
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        com.google.android.libraries.geo.mapcore.internal.model.ar arVar = (com.google.android.libraries.geo.mapcore.internal.model.ar) arrayList.get(i4);
                        com.google.android.libraries.navigation.internal.yx.ar.k(arVar != null);
                        arVarArr[i4] = arVar;
                    }
                }
            } catch (IOException unused) {
                arVarArr = g;
            }
            int i5 = fgVar.j;
            int i6 = com.google.android.libraries.navigation.internal.adg.fc.c;
            if (i6 == 0) {
                throw null;
            }
            boolean z = (i5 & i6) != 0;
            int iA = com.google.android.libraries.navigation.internal.adg.ff.a(fgVar.g);
            if (iA == 0) {
                iA = com.google.android.libraries.navigation.internal.adg.ff.b;
            }
            int iA2 = com.google.android.libraries.navigation.internal.adg.ff.a(fgVar.h);
            int i7 = iA - 1;
            if (iA == 0) {
                throw null;
            }
            if (iA2 == 0) {
                iA2 = com.google.android.libraries.navigation.internal.adg.ff.b;
            }
            com.google.android.libraries.navigation.internal.ael.bh bhVarS3 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.g);
            fgVar.h(bhVarS3);
            Object objK2 = fgVar.w.k(bhVarS3.d);
            int i8 = iA2 - 1;
            if (iA2 == 0) {
                throw null;
            }
            float fFloatValue = ((Float) (objK2 == null ? bhVarS3.b : bhVarS3.c(objK2))).floatValue();
            ArrayList arrayList2 = new ArrayList();
            for (int i9 = 0; i9 < arVarArr.length; i9++) {
                for (com.google.android.libraries.navigation.internal.oe.ad adVar : arVarArr[i9].d) {
                    float f = this.h;
                    adVar.f = f + fFloatValue;
                    this.h = f + adVar.a();
                }
                arrayList2.add(arVarArr[i9].e);
            }
            com.google.android.libraries.navigation.internal.qd.o oVar2 = this.q;
            com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("setStyleForSegments-styleLock");
            try {
                synchronized (oVar2.y) {
                    oVar2.p.clear();
                    oVar2.p.addAll(arrayList2);
                    com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("setOrder-styleLock");
                    try {
                        synchronized (oVar2.y) {
                            if (oVar2.p.isEmpty() || oVar2.p.get(0) == null || oVar2.j == null || oVar2.k == null) {
                                i = i7;
                                i2 = i8;
                                if (dVarB3 != null) {
                                    Trace.endSection();
                                }
                            } else {
                                oVar2.v = ((com.google.android.libraries.geo.mapcore.internal.model.bt) oVar2.p.get(0)).d().H;
                                if (dVarB3 != null) {
                                    Trace.endSection();
                                }
                                i = i7;
                                i2 = i8;
                                com.google.android.libraries.geo.mapcore.renderer.ae aeVar = new com.google.android.libraries.geo.mapcore.renderer.ae(oVar2.v, oVar2.w, oVar2.x, oVar2.o);
                                if (!oVar2.j.E().equals(aeVar)) {
                                    oVar2.j.u(aeVar);
                                    oVar2.k.u(aeVar);
                                    oVar2.g.h(oVar2.j);
                                }
                            }
                        }
                        oVar2.f();
                    } catch (Throwable th) {
                        if (dVarB3 == null) {
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
                if (dVarB2 != null) {
                    Trace.endSection();
                }
                com.google.android.libraries.navigation.internal.qd.o oVar3 = this.q;
                com.google.android.libraries.navigation.internal.nw.d dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("setStitchSegmentsEnabled-styleLock");
                try {
                    synchronized (oVar3.y) {
                        try {
                            oVar3.q = z;
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    if (dVarB4 != null) {
                        Trace.endSection();
                    }
                    com.google.android.libraries.navigation.internal.qd.o oVar4 = this.q;
                    synchronized (oVar4.y) {
                        oVar4.r = i;
                        oVar4.s = i2;
                    }
                    A(arVarArr);
                } catch (Throwable th4) {
                    if (dVarB4 == null) {
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
            } catch (Throwable th6) {
                if (dVarB2 == null) {
                    throw th6;
                }
                try {
                    Trace.endSection();
                    throw th6;
                } catch (Throwable th7) {
                    th6.addSuppressed(th7);
                    throw th6;
                }
            }
        } catch (Throwable th8) {
            if (dVarB == null) {
                throw th8;
            }
            try {
                Trace.endSection();
                throw th8;
            } catch (Throwable th9) {
                th8.addSuppressed(th9);
                throw th8;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.p
    public final Set a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet();
            com.google.android.libraries.geo.mapcore.internal.model.ar[] arVarArr = this.i;
            if (arVarArr != null) {
                for (com.google.android.libraries.geo.mapcore.internal.model.ar arVar : arVarArr) {
                    com.google.android.libraries.geo.mapcore.internal.model.ai[] aiVarArr = arVar.e.c;
                    int length = aiVarArr.length;
                    if (length != 0) {
                        int i = 0;
                        while (true) {
                            if (i < length) {
                                com.google.android.libraries.geo.mapcore.internal.model.bs[] bsVarArr = aiVarArr[i].o;
                                if (bsVarArr.length != 0) {
                                    for (com.google.android.libraries.geo.mapcore.internal.model.bs bsVar : bsVarArr) {
                                        if (bsVar.d()) {
                                            break;
                                        }
                                    }
                                    i++;
                                }
                            }
                        }
                    }
                    hashSet.add(Long.valueOf(arVar.e.b));
                }
            }
        }
        return hashSet;
    }

    @Override // com.google.android.libraries.navigation.internal.po.b, com.google.android.libraries.navigation.internal.ol.v
    public final synchronized void aq() {
        super.aq();
        com.google.android.libraries.navigation.internal.qd.o oVar = this.q;
        synchronized (oVar.l) {
            if (oVar.f547n) {
                oVar.f547n = false;
                com.google.android.libraries.navigation.internal.qq.j jVar = oVar.k;
                if (jVar != null) {
                    jVar.f74n = com.google.android.libraries.navigation.internal.qq.u.a;
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.p
    public final void b(com.google.android.libraries.navigation.internal.ol.q qVar) {
        this.q.z = qVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.p
    public final void c(com.google.android.libraries.navigation.internal.of.a aVar) {
        com.google.android.libraries.navigation.internal.ol.q qVar = this.q.z;
        if (qVar != null) {
            synchronized (((com.google.android.libraries.navigation.internal.p002do.s) qVar).a) {
                long jA = ((com.google.android.libraries.navigation.internal.p002do.s) qVar).d.a();
                double dMin = Math.min((jA - ((com.google.android.libraries.navigation.internal.p002do.s) qVar).e) / 1000.0d, 1.0d);
                double dA = com.google.android.libraries.navigation.internal.p002do.s.a(aVar, ((com.google.android.libraries.navigation.internal.p002do.s) qVar).b, ((com.google.android.libraries.navigation.internal.p002do.s) qVar).c.e(dMin));
                if (!Double.isNaN(dA)) {
                    double dE = aVar.x() ? ((double) ((com.google.android.libraries.navigation.internal.db.r) aVar).f) * com.google.android.libraries.navigation.internal.oe.x.A(((com.google.android.libraries.navigation.internal.db.r) aVar).b, ((com.google.android.libraries.navigation.internal.db.r) aVar).c).e() : 0.0d;
                    ((com.google.android.libraries.navigation.internal.p002do.s) qVar).e = jA;
                    ((com.google.android.libraries.navigation.internal.p002do.s) qVar).c.h(dMin, dA + dE, dE);
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.au
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final com.google.android.libraries.navigation.internal.adg.fg n() {
        com.google.android.libraries.navigation.internal.adg.fg fgVar = this.p;
        return fgVar != null ? fgVar : com.google.android.libraries.navigation.internal.adg.fg.a;
    }

    public final void e(boolean z) {
        com.google.android.libraries.geo.mapcore.renderer.cc.a();
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("onPolylineOverlayReadyInternal");
        try {
            synchronized (this) {
                if (!this.b) {
                    com.google.android.libraries.navigation.internal.qd.f fVar = this.c;
                    if (fVar != null) {
                        if (this.e) {
                            com.google.android.libraries.navigation.internal.qd.f fVar2 = this.d;
                            if (fVar2 != null) {
                                fVar2.h();
                            }
                            fVar.f();
                        }
                        this.d = fVar;
                        this.c = null;
                        boolean z2 = this.a;
                        this.a = true;
                        if (z && !z2) {
                            q();
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

    public final void f(final boolean z, boolean z2) {
        synchronized (this) {
            com.google.android.libraries.navigation.internal.qd.f fVar = this.c;
            if (fVar != null) {
                fVar.j();
                if (z2 || !this.f) {
                    p(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.ai
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.e(z);
                        }
                    });
                }
            } else {
                com.google.android.libraries.geo.mapcore.internal.model.ar[] arVarArr = this.i;
                if (arVarArr != null) {
                    A(arVarArr);
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.v
    public final void h() {
        this.l.c(this);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.v
    public final void i() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.po.b, com.google.android.libraries.navigation.internal.ol.v
    public final synchronized void k(com.google.android.libraries.navigation.internal.ol.as asVar) {
        super.k(asVar);
        com.google.android.libraries.navigation.internal.qd.o oVar = this.q;
        synchronized (oVar.l) {
            if (oVar.f547n) {
                return;
            }
            oVar.f547n = true;
            com.google.android.libraries.navigation.internal.qq.j jVar = oVar.k;
            if (jVar != null) {
                jVar.f74n = oVar.m;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.po.b, com.google.android.libraries.navigation.internal.ol.v
    public final synchronized void l() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.v
    public final void m() {
        this.l.at(this);
    }

    @Override // com.google.android.libraries.navigation.internal.po.b
    protected final void u(int i) {
        v(i, this);
    }

    @Override // com.google.android.libraries.navigation.internal.pp.d
    public final void w() {
        synchronized (this) {
            if (this.b) {
                return;
            }
            C(false, true);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pp.d
    public final void x() {
        synchronized (this) {
            if (this.b) {
                return;
            }
            p(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.am
                @Override // java.lang.Runnable
                public final void run() {
                    com.google.android.libraries.geo.mapcore.renderer.cc.a();
                    an anVar = this.a;
                    com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("onDestroyInternal");
                    try {
                        synchronized (anVar) {
                            if (!anVar.b) {
                                anVar.b = true;
                                anVar.o();
                                com.google.android.libraries.navigation.internal.qd.f fVar = anVar.c;
                                if (fVar != null) {
                                    fVar.g();
                                }
                                com.google.android.libraries.navigation.internal.qd.f fVar2 = anVar.d;
                                if (fVar2 != null) {
                                    fVar2.g();
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
            });
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pp.d
    public final void y() {
        synchronized (this) {
            if (this.b) {
                return;
            }
            p(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.aj
                @Override // java.lang.Runnable
                public final void run() {
                    com.google.android.libraries.geo.mapcore.renderer.cc.a();
                    an anVar = this.a;
                    com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("onRemoveFromRendererInternal");
                    try {
                        synchronized (anVar) {
                            if (!anVar.b) {
                                if (anVar.e) {
                                    anVar.e = false;
                                    com.google.android.libraries.navigation.internal.qd.f fVar = anVar.d;
                                    if (fVar != null) {
                                        fVar.h();
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
            });
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pp.d
    public final void z() {
        synchronized (this) {
            if (this.b) {
                return;
            }
            p(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.ah
                @Override // java.lang.Runnable
                public final void run() {
                    com.google.android.libraries.geo.mapcore.renderer.cc.a();
                    an anVar = this.a;
                    com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("onAddToRenderInternal");
                    try {
                        synchronized (anVar) {
                            if (!anVar.b) {
                                if (!anVar.e) {
                                    if (anVar.f && anVar.d == null) {
                                        anVar.e(true);
                                    }
                                    anVar.e = true;
                                    com.google.android.libraries.navigation.internal.qd.f fVar = anVar.d;
                                    if (fVar != null) {
                                        fVar.f();
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
            });
        }
    }
}
