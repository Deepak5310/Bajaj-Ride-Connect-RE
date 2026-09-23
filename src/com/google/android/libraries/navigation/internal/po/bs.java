package com.google.android.libraries.navigation.internal.po;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.google.android.libraries.geo.mapcore.renderer.Cdo;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bs implements com.google.android.libraries.geo.mapcore.renderer.dp {
    public static final int[] a = {0};
    public final float b;
    public final ArrayList c;
    public boolean d;
    public final Map e;
    public final com.google.android.libraries.navigation.internal.pb.t f;
    public Runnable g;
    public final bj h;
    public final bj i;
    public final Semaphore j;
    public final a k;
    public final com.google.android.libraries.geo.mapcore.renderer.ax l;
    public final bv m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Executor f521n;
    public final com.google.android.libraries.navigation.internal.rc.c o;
    private final com.google.android.libraries.navigation.internal.pb.t p;

    /* JADX INFO: compiled from: PG */
    public class a implements Runnable {
        private static final com.google.android.libraries.navigation.internal.zb.j c = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.po.bs$a");
        public volatile boolean a;
        private final Executor e;
        private final ArrayBlockingQueue d = new ArrayBlockingQueue(10);
        final AtomicInteger b = new AtomicInteger();
        private final AtomicReference f = new AtomicReference(null);

        public a(Executor executor) {
            this.e = new com.google.android.libraries.navigation.internal.hx.ag(executor);
        }

        public final void a(br brVar) {
            if (this.a) {
                ((com.google.android.libraries.navigation.internal.zb.h) c.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 872)).p("Asked to add pending request after stop().");
                return;
            }
            if (!this.d.offer(brVar)) {
                ((com.google.android.libraries.navigation.internal.zb.h) c.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 871)).p("Failed to add pending request. Queue is full.");
            }
            this.b.incrementAndGet();
            this.e.execute(this);
        }

        public final void b(bs bsVar) {
            AtomicReference atomicReference;
            do {
                atomicReference = this.f;
                if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, bsVar)) {
                    return;
                }
            } while (atomicReference.get() == null);
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x044e */
        /* JADX WARN: Bottom block not found for handler: all -> 0x0454 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() throws Throwable {
            int i;
            int[] iArr;
            Iterator it2;
            int i2;
            a aVar;
            final com.google.android.libraries.navigation.internal.oe.x xVar;
            final com.google.android.libraries.navigation.internal.ol.at atVarA;
            Iterator it3;
            int i3;
            com.google.android.libraries.navigation.internal.qq.x xVar2;
            boolean z;
            int i4;
            com.google.android.libraries.navigation.internal.yz.ev evVarG;
            com.google.android.libraries.navigation.internal.ol.au auVar;
            com.google.android.libraries.navigation.internal.ol.at gtVar;
            a aVar2 = this;
            try {
                ArrayList arrayList = new ArrayList(10);
                aVar2.d.drainTo(arrayList);
                if (arrayList.isEmpty()) {
                    return;
                }
                final bs bsVar = (bs) aVar2.f.get();
                com.google.android.libraries.navigation.internal.yx.ar.q(bsVar);
                bsVar.j.acquire();
                synchronized (bsVar) {
                    try {
                        try {
                            bj bjVar = bsVar.h;
                            bj bjVar2 = bsVar.i;
                            bjVar.a = bjVar2.a;
                            bjVar.b = bjVar2.b;
                            bjVar.c = bjVar2.c;
                        } catch (Throwable th) {
                            th = th;
                            while (true) {
                                throw th;
                            }
                        }
                    } catch (InterruptedException unused) {
                        return;
                    }
                }
                bsVar.f.B(bsVar.h.a);
                com.google.android.libraries.navigation.internal.pb.t tVar = bsVar.f;
                bj bjVar3 = bsVar.h;
                tVar.C(bjVar3.b, bjVar3.c);
                synchronized (bsVar) {
                    try {
                        i = 0;
                        if (bsVar.d) {
                            Iterator it4 = bsVar.c.iterator();
                            while (it4.hasNext()) {
                                ((com.google.android.libraries.navigation.internal.qq.h) it4.next()).z();
                            }
                            Collections.sort(bsVar.c, new Comparator() { // from class: com.google.android.libraries.navigation.internal.po.bi
                                @Override // java.util.Comparator
                                public final int compare(Object obj, Object obj2) {
                                    com.google.android.libraries.navigation.internal.qq.h hVar = (com.google.android.libraries.navigation.internal.qq.h) obj;
                                    com.google.android.libraries.navigation.internal.qq.h hVar2 = (com.google.android.libraries.navigation.internal.qq.h) obj2;
                                    return com.google.android.libraries.navigation.internal.yz.ck.b.c(hVar2.d.c().ordinal(), hVar.d.c().ordinal()).c(hVar2.d.b(), hVar.d.b()).e(hVar2.E(), hVar.E()).c(System.identityHashCode(hVar2), System.identityHashCode(hVar)).a();
                                }
                            });
                            bsVar.d = false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        while (true) {
                            throw th;
                        }
                    }
                }
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    br brVar = (br) it5.next();
                    int i5 = brVar.b;
                    com.google.android.libraries.navigation.internal.oe.x xVar3 = brVar.a;
                    int i6 = 1;
                    if (i5 == 1) {
                        iArr = bsVar.m.d;
                        if (iArr.length == 0) {
                            it2 = it5;
                            aVar = aVar2;
                            i2 = i;
                        }
                        aVar.b.decrementAndGet();
                        i = i2;
                        aVar2 = aVar;
                        it5 = it2;
                    } else {
                        iArr = bs.a;
                    }
                    bv bvVar = bsVar.m;
                    com.google.android.libraries.navigation.internal.yx.an anVar = bvVar.a;
                    ArrayList arrayList2 = new ArrayList();
                    if (i5 != 1) {
                        int length = iArr.length;
                    }
                    com.google.android.libraries.navigation.internal.yz.eq eqVarJ = com.google.android.libraries.navigation.internal.yz.ev.j(iArr.length);
                    for (int i7 = i; i7 < iArr.length; i7++) {
                        com.google.android.libraries.navigation.internal.pb.t tVar2 = bsVar.f;
                        float f = bsVar.b * iArr[i7];
                        eqVarJ.h(f == 0.0f ? new com.google.android.libraries.navigation.internal.qq.y(xVar3, tVar2) : new com.google.android.libraries.navigation.internal.qq.x(xVar3, f, tVar2));
                    }
                    com.google.android.libraries.navigation.internal.yz.ev evVarG2 = eqVarJ.g();
                    com.google.android.libraries.navigation.internal.qq.x xVar4 = (com.google.android.libraries.navigation.internal.qq.x) com.google.android.libraries.navigation.internal.yz.gs.d(evVarG2);
                    ArrayList arrayList3 = bsVar.c;
                    int size = arrayList3.size();
                    int i8 = i;
                    while (i8 < size) {
                        try {
                            com.google.android.libraries.navigation.internal.qq.h hVar = (com.google.android.libraries.navigation.internal.qq.h) arrayList3.get(i8);
                            com.google.android.libraries.navigation.internal.qq.u uVarE = bs.e(hVar, i5, xVar4, bsVar.b);
                            if (uVarE != null) {
                                com.google.android.libraries.navigation.internal.qq.q qVar = uVarE.d;
                                boolean z2 = qVar instanceof com.google.android.libraries.navigation.internal.qq.o;
                                if (z2 || (qVar instanceof com.google.android.libraries.navigation.internal.qq.m)) {
                                    it3 = it5;
                                    xVar3 = xVar3;
                                    int i9 = i5;
                                    bvVar = bvVar;
                                    xVar2 = xVar4;
                                    arrayList3 = arrayList3;
                                    size = size;
                                    i8 = i8;
                                    float f2 = bsVar.b;
                                    if (z2) {
                                        com.google.android.libraries.navigation.internal.qq.o oVar = (com.google.android.libraries.navigation.internal.qq.o) qVar;
                                        synchronized (oVar) {
                                            oVar.b.d(oVar.f);
                                            oVar.d = oVar.h;
                                            oVar.e = oVar.i;
                                            oVar.c = oVar.g;
                                        }
                                        com.google.android.libraries.navigation.internal.yz.eq eqVar = new com.google.android.libraries.navigation.internal.yz.eq();
                                        for (com.google.android.libraries.geo.mapcore.internal.model.g gVar : oVar.a) {
                                            int i10 = -1;
                                            for (int i11 = ((lv) evVarG2).c - 1; i11 >= 0 && oVar.d(gVar, (com.google.android.libraries.navigation.internal.qq.x) evVarG2.get(i11)); i11--) {
                                                i10 = i11;
                                            }
                                            if (i10 >= 0) {
                                                eqVar.h(new com.google.android.libraries.navigation.internal.qq.n(gVar, i10));
                                            }
                                        }
                                        com.google.android.libraries.navigation.internal.yz.ev evVarG3 = eqVar.g();
                                        com.google.android.libraries.navigation.internal.yz.eq eqVar2 = new com.google.android.libraries.navigation.internal.yz.eq();
                                        int i12 = ((lv) evVarG3).c;
                                        for (int i13 = 0; i13 < i12; i13++) {
                                            com.google.android.libraries.navigation.internal.qq.n nVar = (com.google.android.libraries.navigation.internal.qq.n) evVarG3.get(i13);
                                            if (com.google.android.libraries.geo.mapcore.internal.model.g.i(nVar.a.j)) {
                                                final com.google.android.libraries.geo.mapcore.internal.model.g gVar2 = nVar.a;
                                                Objects.requireNonNull(gVar2);
                                                eqVar2.h(new com.google.android.libraries.navigation.internal.qq.t(new com.google.android.libraries.navigation.internal.ol.au() { // from class: com.google.android.libraries.navigation.internal.qq.r
                                                    @Override // com.google.android.libraries.navigation.internal.ol.au
                                                    public final cy n() {
                                                        return gVar2.j;
                                                    }
                                                }, nVar.b));
                                            } else {
                                                com.google.android.libraries.navigation.internal.adl.j jVar = nVar.a.k;
                                                com.google.android.libraries.geo.mapcore.internal.model.g.j().booleanValue();
                                            }
                                            com.google.android.libraries.navigation.internal.yz.fd fdVar = nVar.a.m;
                                        }
                                        evVarG = eqVar2.g();
                                        i3 = 0;
                                        z = false;
                                    } else if (qVar instanceof com.google.android.libraries.navigation.internal.qq.m) {
                                        com.google.android.libraries.navigation.internal.qq.x xVar5 = (com.google.android.libraries.navigation.internal.qq.x) evVarG2.get(0);
                                        com.google.android.libraries.navigation.internal.yz.eq eqVar3 = new com.google.android.libraries.navigation.internal.yz.eq();
                                        for (com.google.android.libraries.navigation.internal.qq.l lVar : ((com.google.android.libraries.navigation.internal.qq.m) qVar).a) {
                                            com.google.android.libraries.navigation.internal.oe.x xVar6 = new com.google.android.libraries.navigation.internal.oe.x(lVar.a, lVar.b);
                                            float f3 = (lVar.c / 2.0f) * f2;
                                            if (com.google.android.libraries.navigation.internal.pb.j.m(xVar5.c, xVar6, xVar5.g)) {
                                                float[] fArr = xVar5.e;
                                                float f4 = fArr[0];
                                                float[] fArr2 = xVar5.g;
                                                float f5 = f4 - fArr2[0];
                                                float f6 = (fArr[1] - fArr2[1]) + 0.0f;
                                                float f7 = f5 + 0.0f;
                                                float f8 = xVar5.f + f3;
                                                if ((f7 * f7) + (f6 * f6) <= f8 * f8) {
                                                    eqVar3.h(lVar);
                                                }
                                            }
                                        }
                                        z = false;
                                        com.google.android.libraries.navigation.internal.yz.ev evVarG4 = eqVar3.g();
                                        com.google.android.libraries.navigation.internal.yz.eq eqVar4 = new com.google.android.libraries.navigation.internal.yz.eq();
                                        if (((lv) evVarG4).c > 0) {
                                            com.google.android.libraries.navigation.internal.yz.fd fdVar2 = ((com.google.android.libraries.navigation.internal.qq.l) evVarG4.get(0)).d;
                                            throw null;
                                        }
                                        evVarG = eqVar4.g();
                                        i3 = 0;
                                    } else {
                                        i3 = 0;
                                        z = false;
                                        evVarG = lv.a;
                                    }
                                    int i14 = ((lv) evVarG).c;
                                    int i15 = i3;
                                    while (i15 < i14) {
                                        com.google.android.libraries.navigation.internal.qq.t tVar3 = (com.google.android.libraries.navigation.internal.qq.t) evVarG.get(i15);
                                        int i16 = i9;
                                        arrayList2.add(new gt(tVar3.a, i16 == 1 ? tVar3.b : -1, hVar));
                                        i15++;
                                        i9 = i16;
                                    }
                                    i4 = i9;
                                    if (evVarG.isEmpty() && (auVar = (com.google.android.libraries.navigation.internal.ol.au) bsVar.e.get(hVar)) != null) {
                                        int i17 = i4 == 1 ? ((lv) evVarG2).c - 1 : -1;
                                        for (int i18 = ((lv) evVarG2).c - 2; i18 >= 0 && bs.e(hVar, i4, (com.google.android.libraries.navigation.internal.qq.x) evVarG2.get(i18), bsVar.b) != null; i18--) {
                                            i17 = i18;
                                        }
                                        arrayList2.add(new gt(auVar, i17, hVar));
                                    }
                                } else {
                                    com.google.android.libraries.navigation.internal.ol.au auVar2 = (com.google.android.libraries.navigation.internal.ol.au) bsVar.e.get(hVar);
                                    if (auVar2 != null) {
                                        int i19 = i5 == 1 ? ((lv) evVarG2).c - 1 : -1;
                                        int i20 = ((lv) evVarG2).c - 2;
                                        int i21 = i19;
                                        while (true) {
                                            if (i20 < 0) {
                                                it3 = it5;
                                                xVar2 = xVar4;
                                                break;
                                            }
                                            it3 = it5;
                                            xVar2 = xVar4;
                                            if (bs.e(hVar, i5, (com.google.android.libraries.navigation.internal.qq.x) evVarG2.get(i20), bsVar.b) == null) {
                                                break;
                                            }
                                            i21 = i20;
                                            xVar4 = xVar2;
                                            i20--;
                                            it5 = it3;
                                        }
                                        if (hVar instanceof com.google.android.libraries.navigation.internal.qq.ap) {
                                            com.google.android.libraries.navigation.internal.qq.ap apVar = (com.google.android.libraries.navigation.internal.qq.ap) hVar;
                                            com.google.android.libraries.navigation.internal.oe.x xVarF = apVar.f();
                                            if (auVar2 instanceof com.google.android.libraries.navigation.internal.pp.f) {
                                                com.google.android.libraries.navigation.internal.pp.f fVar = (com.google.android.libraries.navigation.internal.pp.f) auVar2;
                                                fVar.D().ai();
                                                fVar.D().V();
                                            } else {
                                                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) c.d(com.google.android.libraries.navigation.internal.nl.a.a).g(new IllegalStateException(String.format("Found a %s for a %s that doesn't implement %s (%s).", com.google.android.libraries.navigation.internal.qq.ap.class.getName(), com.google.android.libraries.navigation.internal.ol.au.class.getName(), com.google.android.libraries.navigation.internal.pp.f.class.getName(), auVar2.getClass().getName())))).F((char) 868)).o();
                                                com.google.android.libraries.navigation.internal.adg.fs fsVar = com.google.android.libraries.navigation.internal.adg.fs.a;
                                            }
                                            apVar.m();
                                            gtVar = new cd((com.google.android.libraries.navigation.internal.ol.aa) auVar2, i21, hVar, xVarF);
                                        } else {
                                            xVar3 = xVar3;
                                            i5 = i5;
                                            bvVar = bvVar;
                                            arrayList3 = arrayList3;
                                            size = size;
                                            i8 = i8;
                                            gtVar = new gt(auVar2, i21, hVar);
                                        }
                                        arrayList2.add(gtVar);
                                        i4 = i5;
                                    } else {
                                        it3 = it5;
                                        xVar3 = xVar3;
                                        bvVar = bvVar;
                                        xVar2 = xVar4;
                                        arrayList3 = arrayList3;
                                        size = size;
                                        i8 = i8;
                                        i4 = i5;
                                    }
                                    i3 = 0;
                                    z = false;
                                }
                            } else {
                                it3 = it5;
                                xVar3 = xVar3;
                                bvVar = bvVar;
                                i3 = i;
                                xVar2 = xVar4;
                                arrayList3 = arrayList3;
                                size = size;
                                i8 = i8;
                                z = false;
                                i4 = i5;
                            }
                            i8++;
                            i = i3;
                            i5 = i4;
                            it5 = it3;
                            xVar4 = xVar2;
                            arrayList3 = arrayList3;
                            size = size;
                            xVar3 = xVar3;
                            bvVar = bvVar;
                            i6 = 1;
                        } catch (InterruptedException unused2) {
                            return;
                        }
                    }
                    it2 = it5;
                    com.google.android.libraries.navigation.internal.oe.x xVar7 = xVar3;
                    bv bvVar2 = bvVar;
                    i2 = i;
                    final int i22 = i5;
                    if (i22 == i6) {
                        Collections.sort(arrayList2, new Comparator() { // from class: com.google.android.libraries.navigation.internal.po.bk
                            @Override // java.util.Comparator
                            public final int compare(Object obj, Object obj2) {
                                return Integer.compare(((com.google.android.libraries.navigation.internal.ol.at) obj).a(), ((com.google.android.libraries.navigation.internal.ol.at) obj2).a());
                            }
                        });
                    }
                    final com.google.android.libraries.navigation.internal.ol.y yVar = bvVar2.c;
                    if (yVar != null) {
                        if (arrayList2.isEmpty()) {
                            atVarA = null;
                            xVar = xVar7;
                        } else {
                            xVar = xVar7;
                            atVarA = bsVar.m.b.a(arrayList2, xVar);
                        }
                        if (atVarA != null) {
                            final com.google.android.libraries.navigation.internal.ol.au auVarB = atVarA.b();
                            final Runnable runnable = (!(auVarB instanceof b) || atVarA.c()) ? i22 == 1 ? new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.bo
                                @Override // java.lang.Runnable
                                public final void run() {
                                    yVar.a(atVarA, xVar);
                                }
                            } : new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.bp
                                @Override // java.lang.Runnable
                                public final void run() {
                                    yVar.d(xVar);
                                }
                            } : new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.bn
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ((b) auVarB).u(i22);
                                }
                            };
                            bsVar.f521n.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.bq
                                @Override // java.lang.Runnable
                                public final void run() {
                                    com.google.android.libraries.navigation.internal.yx.an anVarJ;
                                    com.google.android.libraries.navigation.internal.ol.at atVar = atVarA;
                                    if (atVar instanceof cd) {
                                        bs bsVar2 = bsVar;
                                        com.google.android.libraries.navigation.internal.pp.f fVar2 = (com.google.android.libraries.navigation.internal.pp.f) auVarB;
                                        com.google.android.libraries.navigation.internal.px.ek ekVarD = fVar2.D();
                                        com.google.android.libraries.navigation.internal.px.b bVar = (com.google.android.libraries.navigation.internal.px.b) ekVarD;
                                        com.google.android.libraries.navigation.internal.adg.ef efVar = bVar.a;
                                        com.google.android.libraries.navigation.internal.adg.fs fsVarV = ekVarD.V();
                                        com.google.android.libraries.navigation.internal.oe.j jVar2 = bVar.d;
                                        boolean zAi = ekVarD.ai();
                                        com.google.android.libraries.navigation.internal.px.dj djVar = (com.google.android.libraries.navigation.internal.px.dj) fVar2.E().f();
                                        com.google.android.libraries.navigation.internal.rc.c cVar = bsVar2.o;
                                        if (cVar.b(efVar, fsVarV, jVar2, zAi, djVar) == null) {
                                            anVarJ = com.google.android.libraries.navigation.internal.yx.a.a;
                                        } else {
                                            try {
                                                anVarJ = com.google.android.libraries.navigation.internal.yx.an.j(cVar.c());
                                            } catch (com.google.android.libraries.navigation.internal.rc.b unused3) {
                                                anVarJ = com.google.android.libraries.navigation.internal.yx.a.a;
                                            }
                                        }
                                        if (anVarJ.g()) {
                                            fVar2.G((com.google.android.libraries.navigation.internal.jy.p) anVarJ.c());
                                            com.google.android.libraries.navigation.internal.yx.an.j(anVarJ.c());
                                        }
                                    }
                                    runnable.run();
                                }
                            });
                        } else if (i22 == 1) {
                            bsVar.f521n.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.bl
                                @Override // java.lang.Runnable
                                public final void run() {
                                    yVar.c(xVar);
                                }
                            });
                        } else {
                            final com.google.android.libraries.navigation.internal.pi.t tVar4 = new com.google.android.libraries.navigation.internal.pi.t(xVar);
                            bsVar.f521n.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.bm
                                @Override // java.lang.Runnable
                                public final void run() {
                                    bsVar.o.d();
                                    yVar.b(xVar);
                                }
                            });
                        }
                    }
                    aVar = this;
                    aVar.b.decrementAndGet();
                    i = i2;
                    aVar2 = aVar;
                    it5 = it2;
                }
                bsVar.j.release();
            } catch (InterruptedException unused3) {
            }
        }
    }

    public bs(com.google.android.libraries.navigation.internal.pb.t tVar, float f, com.google.android.libraries.geo.mapcore.renderer.ax axVar, bv bvVar, Executor executor, Executor executor2, com.google.android.libraries.navigation.internal.rc.c cVar) {
        com.google.android.libraries.navigation.internal.pb.t tVar2 = new com.google.android.libraries.navigation.internal.pb.t(tVar);
        this.c = new ArrayList();
        this.d = false;
        this.e = new HashMap();
        this.h = new bj();
        this.i = new bj();
        this.j = new Semaphore(1);
        this.b = f;
        this.p = tVar;
        this.f = tVar2;
        this.l = axVar;
        this.m = bvVar;
        Runnable runnable = new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.bh
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c();
            }
        };
        this.g = runnable;
        this.f521n = executor2;
        this.o = cVar;
        axVar.f(runnable);
        this.k = new a(executor);
    }

    public static com.google.android.libraries.navigation.internal.qq.u e(com.google.android.libraries.navigation.internal.qq.h hVar, int i, com.google.android.libraries.navigation.internal.qq.x xVar, float f) {
        Cdo cdo;
        if (hVar.k && (cdo = hVar.f74n) != null && (i != 1 ? ((com.google.android.libraries.navigation.internal.qq.u) cdo).c : ((com.google.android.libraries.navigation.internal.qq.u) cdo).b)) {
            if (hVar instanceof com.google.android.libraries.navigation.internal.qq.j) {
                com.google.android.libraries.navigation.internal.oe.x xVar2 = ((com.google.android.libraries.navigation.internal.qq.j) hVar).e;
            }
            com.google.android.libraries.navigation.internal.qq.u uVar = (com.google.android.libraries.navigation.internal.qq.u) cdo;
            if (uVar.d.a(xVar, f)) {
                return uVar;
            }
        }
        return null;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.dp
    public final void a() {
        boolean z = false;
        while (true) {
            try {
                this.j.acquire();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.dp
    public final void b() {
        synchronized (this) {
            this.d = true;
        }
    }

    public final synchronized void c() {
        com.google.android.libraries.navigation.internal.pb.t tVar = this.p;
        if (tVar != null) {
            this.i.a = tVar.w();
            this.i.b = this.p.s();
            this.i.c = this.p.r();
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.dp
    public final void d() {
        this.j.release();
    }
}
