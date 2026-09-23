package com.google.android.libraries.navigation.internal.po;

import android.graphics.Bitmap;
import android.util.SparseArray;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.yz.mb;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class hi implements com.google.android.libraries.navigation.internal.ol.ax, com.google.android.libraries.geo.mapcore.internal.model.af, com.google.android.libraries.geo.mapcore.internal.vector.gl.p, com.google.android.libraries.navigation.internal.qq.aj {
    static final com.google.android.libraries.navigation.internal.ol.s a;
    public static final com.google.android.libraries.navigation.internal.ol.aq b;
    static final hd c;
    private static final com.google.android.libraries.navigation.internal.zb.j j = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.po.hi");
    public final hn d;
    public final gx f;
    public final hh g;
    public final AtomicReference h;
    public final List i;
    private final boolean l;
    private final boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Map f527n;
    private final com.google.android.libraries.navigation.internal.yz.az o;
    private final AtomicInteger k = new AtomicInteger(3);
    public final Object e = new Object();

    static {
        gy gyVar = new gy();
        a = gyVar;
        b = gyVar;
        c = new hd();
    }

    public hi(gr grVar, com.google.android.libraries.navigation.internal.qy.h hVar, boolean z, boolean z2, com.google.android.libraries.navigation.internal.kl.b bVar, com.google.android.libraries.navigation.internal.aac.bn bnVar) {
        HashMap map = new HashMap();
        this.f527n = map;
        new SparseArray();
        this.i = Collections.synchronizedList(new ArrayList());
        this.o = com.google.android.libraries.navigation.internal.yz.ed.g();
        this.h = new AtomicReference();
        this.d = new hn(grVar, hVar, bVar, bnVar);
        this.m = z;
        this.l = z2;
        gx gxVar = new gx(this, "GMM-CLIENT-INJECTED-STYLE-NAMESPACE", 1, z);
        this.f = gxVar;
        map.put(1, gxVar);
        hh hhVar = new hh(this);
        this.g = hhVar;
        map.put(2, hhVar);
    }

    private final List B(List list) {
        com.google.android.libraries.navigation.internal.yx.ar.b(!list.isEmpty(), "There should be at least one bitmap line definition");
        com.google.android.libraries.navigation.internal.yx.ar.b(list.size() < 4, String.format(Locale.US, "There should be less than %d bitmap line definitions", 4));
        synchronized (this.e) {
            com.google.android.libraries.navigation.internal.yz.fw fwVar = new com.google.android.libraries.navigation.internal.yz.fw();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                com.google.android.libraries.navigation.internal.ol.f fVar = (com.google.android.libraries.navigation.internal.ol.f) it2.next();
                Bitmap bitmapB = fVar.b();
                if (bitmapB != null) {
                    fwVar.c(new h(bitmapB, com.google.android.libraries.geo.mapcore.internal.vector.gl.o.WRAP_T));
                }
                Bitmap bitmapC = fVar.c();
                if (bitmapC != null) {
                    fwVar.c(new h(bitmapC, com.google.android.libraries.geo.mapcore.internal.vector.gl.o.NO_WRAP));
                }
                Bitmap bitmapA = fVar.a();
                if (bitmapA != null) {
                    fwVar.c(new h(bitmapA, com.google.android.libraries.geo.mapcore.internal.vector.gl.o.NO_WRAP));
                }
            }
            nn nnVarListIterator = fwVar.i().listIterator();
            while (nnVarListIterator.hasNext()) {
                C((gz) nnVarListIterator.next());
            }
        }
        ArrayList arrayList = new ArrayList(list.size());
        synchronized (this.e) {
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                com.google.android.libraries.navigation.internal.ol.f fVar2 = (com.google.android.libraries.navigation.internal.ol.f) it3.next();
                arrayList.add(new e(fVar2.d(), A(fVar2.b(), com.google.android.libraries.geo.mapcore.internal.vector.gl.o.WRAP_T), A(fVar2.c(), com.google.android.libraries.geo.mapcore.internal.vector.gl.o.NO_WRAP), A(fVar2.a(), com.google.android.libraries.geo.mapcore.internal.vector.gl.o.NO_WRAP)));
            }
        }
        return arrayList;
    }

    private final void C(gz gzVar) {
        com.google.android.libraries.geo.mapcore.renderer.i iVar;
        synchronized (this.e) {
            if (gzVar.b() == com.google.android.libraries.geo.mapcore.internal.vector.gl.o.WRAP_T) {
                Bitmap bitmapA = gzVar.a();
                if (!this.l) {
                    bitmapA = com.google.android.libraries.geo.mapcore.renderer.cs.e(bitmapA, Bitmap.Config.ARGB_8888, true);
                }
                iVar = new com.google.android.libraries.geo.mapcore.renderer.i(bitmapA);
            } else {
                iVar = new com.google.android.libraries.geo.mapcore.renderer.i(gzVar.a());
            }
            this.o.put(gzVar, this.o.containsKey(gzVar) ? this.d.b((com.google.android.libraries.geo.mapcore.internal.vector.gl.n) this.o.get(gzVar), iVar) : this.d.a(gzVar.b(), iVar));
        }
    }

    private final void D(com.google.android.libraries.navigation.internal.ol.av avVar) {
        synchronized (this.f527n) {
            this.f527n.remove(Integer.valueOf(avVar.a()));
        }
    }

    static long n(long j2, com.google.android.libraries.navigation.internal.agg.ez ezVar, com.google.android.libraries.geo.mapcore.internal.model.bd bdVar) {
        return ezVar.isEmpty() ? j2 : bdVar.a.a(j2, ezVar);
    }

    static final com.google.android.libraries.geo.mapcore.internal.model.bt z(int i, com.google.android.libraries.geo.mapcore.internal.model.v vVar, com.google.android.libraries.navigation.internal.agg.ez ezVar) {
        return vVar.c.d(i, ezVar, vVar.d.a);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ax
    public final com.google.android.libraries.navigation.internal.ol.s a(com.google.android.libraries.navigation.internal.adg.ga gaVar) {
        return this.f.b(gaVar);
    }

    @Override // com.google.android.libraries.navigation.internal.qq.aj
    public final void au() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("reload textures");
        try {
            synchronized (this.f527n) {
                for (com.google.android.libraries.navigation.internal.ol.av avVar : this.f527n.values()) {
                    if (avVar instanceof gx) {
                        gx gxVar = (gx) avVar;
                        com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("StyleNamespace.onContextChanged");
                        try {
                            synchronized (gxVar.a) {
                                try {
                                    for (dq dqVar : gxVar.a.values()) {
                                        if (dqVar instanceof az) {
                                            az azVar = (az) dqVar;
                                            com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("reloadTextures");
                                            try {
                                                synchronized (azVar) {
                                                    try {
                                                        azVar.f = false;
                                                        azVar.a.v(azVar, true);
                                                    } catch (Throwable th) {
                                                        throw th;
                                                    }
                                                }
                                                if (dVarB3 != null) {
                                                    Trace.endSection();
                                                }
                                            } catch (Throwable th2) {
                                                if (dVarB3 != null) {
                                                    try {
                                                        Trace.endSection();
                                                    } catch (Throwable th3) {
                                                        th2.addSuppressed(th3);
                                                    }
                                                }
                                                throw th2;
                                            }
                                        }
                                    }
                                } catch (Throwable th4) {
                                    throw th4;
                                }
                            }
                            if (dVarB2 != null) {
                                Trace.endSection();
                            }
                        } catch (Throwable th5) {
                            if (dVarB2 != null) {
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
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th7) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th8) {
                    th7.addSuppressed(th8);
                }
            }
            throw th7;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ax
    public final com.google.android.libraries.navigation.internal.ol.aq b(int i, int i2, com.google.android.libraries.navigation.internal.ol.aq aqVar) {
        return this.f.h(null, i, i2, aqVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ax
    public final com.google.android.libraries.navigation.internal.ol.aq c(Bitmap bitmap) {
        gx gxVar = this.f;
        int andIncrement = gxVar.b.getAndIncrement();
        com.google.android.libraries.geo.mapcore.internal.model.ai aiVar = com.google.android.libraries.geo.mapcore.internal.model.ai.c;
        com.google.android.libraries.geo.mapcore.internal.model.ah ahVar = new com.google.android.libraries.geo.mapcore.internal.model.ah();
        ahVar.p = new com.google.android.libraries.geo.mapcore.internal.model.ab(bitmap);
        return gxVar.e(new com.google.android.libraries.geo.mapcore.internal.model.ai(ahVar), andIncrement, mb.a);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ax
    public final com.google.android.libraries.navigation.internal.ol.aq d(int i, List list) {
        List listB = B(list);
        com.google.android.libraries.navigation.internal.yz.fw fwVar = new com.google.android.libraries.navigation.internal.yz.fw();
        gx gxVar = this.f;
        int andIncrement = gxVar.b.getAndIncrement();
        com.google.android.libraries.geo.mapcore.internal.model.bs[] bsVarArr = new com.google.android.libraries.geo.mapcore.internal.model.bs[listB.size()];
        for (int i2 = 0; i2 < listB.size(); i2++) {
            i iVar = (i) listB.get(i2);
            com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVarB = iVar.b();
            if (nVarB != null) {
                fwVar.c(nVarB);
            }
            com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVarC = iVar.c();
            if (nVarC != null) {
                fwVar.c(nVarC);
            }
            com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVarA = iVar.a();
            if (nVarA != null) {
                fwVar.c(nVarA);
            }
            bsVarArr[i2] = com.google.android.libraries.geo.mapcore.internal.model.bs.b(iVar.d(), null, nVarB, nVarC, nVarA);
        }
        com.google.android.libraries.geo.mapcore.internal.model.ai aiVar = com.google.android.libraries.geo.mapcore.internal.model.ai.c;
        com.google.android.libraries.geo.mapcore.internal.model.ah ahVar = new com.google.android.libraries.geo.mapcore.internal.model.ah();
        ahVar.k = bsVarArr;
        ahVar.v = i;
        dq dqVarE = gxVar.e(new com.google.android.libraries.geo.mapcore.internal.model.ai(ahVar), andIncrement, fwVar.i());
        dqVarE.k(true);
        return dqVarE;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ax
    public final com.google.android.libraries.navigation.internal.ol.aq e(int i, List list) {
        List listB = B(list);
        com.google.android.libraries.navigation.internal.yz.fw fwVar = new com.google.android.libraries.navigation.internal.yz.fw();
        gx gxVar = this.f;
        int andIncrement = gxVar.b.getAndIncrement();
        com.google.android.libraries.geo.mapcore.internal.model.bs[] bsVarArr = new com.google.android.libraries.geo.mapcore.internal.model.bs[listB.size()];
        for (int i2 = 0; i2 < listB.size(); i2++) {
            i iVar = (i) listB.get(i2);
            com.google.android.libraries.geo.mapcore.internal.model.bs bsVarA = com.google.android.libraries.geo.mapcore.internal.model.bs.a(iVar.d(), null);
            com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVarB = iVar.b();
            if (nVarB != null) {
                bsVarA.i = nVarB;
                fwVar.c(nVarB);
            }
            com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVarC = iVar.c();
            if (nVarC != null) {
                bsVarA.j = nVarC;
                fwVar.c(nVarC);
            }
            com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVarA = iVar.a();
            if (nVarA != null) {
                bsVarA.k = nVarA;
                fwVar.c(nVarA);
            }
            bsVarArr[i2] = bsVarA;
        }
        com.google.android.libraries.geo.mapcore.internal.model.ai aiVar = com.google.android.libraries.geo.mapcore.internal.model.ai.c;
        com.google.android.libraries.geo.mapcore.internal.model.ah ahVar = new com.google.android.libraries.geo.mapcore.internal.model.ah();
        ahVar.k = bsVarArr;
        ahVar.v = i;
        ahVar.y = 1;
        dq dqVarE = gxVar.e(new com.google.android.libraries.geo.mapcore.internal.model.ai(ahVar), andIncrement, fwVar.i());
        dqVarE.k(true);
        return dqVarE;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ax
    public final com.google.android.libraries.navigation.internal.ol.aq f(com.google.android.libraries.navigation.internal.adg.ex exVar) {
        return g(exVar.CG);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ax
    public final com.google.android.libraries.navigation.internal.ol.aq g(long j2) {
        return this.g.c(j2);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ax
    public final com.google.android.libraries.navigation.internal.ol.av h(String str) {
        int andIncrement = this.k.getAndIncrement();
        gx gxVar = new gx(this, str, andIncrement, this.m);
        synchronized (this.f527n) {
            this.f527n.put(Integer.valueOf(andIncrement), gxVar);
        }
        return gxVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ax
    public final com.google.android.libraries.navigation.internal.ol.av i() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ax
    public final void j(com.google.android.libraries.navigation.internal.ol.aq aqVar) {
        if (aqVar instanceof dq) {
            dq dqVar = (dq) aqVar;
            synchronized (this.e) {
                nn nnVarListIterator = dqVar.j(mb.a).listIterator();
                while (nnVarListIterator.hasNext()) {
                    com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar = (com.google.android.libraries.geo.mapcore.internal.vector.gl.n) nnVarListIterator.next();
                    if (this.d.i(nVar)) {
                        com.google.android.libraries.navigation.internal.yz.az azVar = this.o;
                        azVar.remove(azVar.d().get(nVar));
                    }
                }
            }
            gx gxVar = dqVar.d;
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("destroyStyle");
            try {
                if (aqVar instanceof dq) {
                    dq dqVar2 = (dq) aqVar;
                    gx gxVar2 = dqVar2.d;
                    com.google.android.libraries.navigation.internal.yx.ar.i(gxVar2 == gxVar, "[%s] was told to destroy a style from namespace [%s]", gxVar.c, gxVar2.c);
                    synchronized (gxVar.a) {
                        long jA = dqVar2.a();
                        if (gxVar.a.c(jA)) {
                            gxVar.a.b(jA);
                            dqVar2.h();
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
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x003d */
    @Override // com.google.android.libraries.navigation.internal.ol.ax
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(com.google.android.libraries.navigation.internal.ol.av avVar) {
        D(avVar);
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("destroyAllStyles");
        synchronized (((gx) avVar).a) {
            try {
                com.google.android.libraries.navigation.internal.agi.gi giVarListIterator = ((gx) avVar).a.values().listIterator();
                while (giVarListIterator.hasNext()) {
                    ((dq) giVarListIterator.next()).h();
                }
                ((gx) avVar).a.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (dVarB != null) {
            Trace.endSection();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ax
    public final com.google.android.libraries.navigation.internal.ol.aq l(Bitmap bitmap, int i) {
        C(new h(bitmap, com.google.android.libraries.geo.mapcore.internal.vector.gl.o.NO_WRAP));
        return this.f.g(A(bitmap, com.google.android.libraries.geo.mapcore.internal.vector.gl.o.NO_WRAP), i);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ax
    public final com.google.android.libraries.navigation.internal.ol.aq m(com.google.android.libraries.geo.mapcore.renderer.h hVar, int i) {
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVarA;
        synchronized (this.e) {
            nVarA = this.d.a(com.google.android.libraries.geo.mapcore.internal.vector.gl.o.NO_WRAP, hVar);
        }
        return this.f.g(nVarA, i);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.af
    public final com.google.android.libraries.navigation.internal.ol.av o(com.google.android.libraries.geo.mapcore.internal.model.bv bvVar) {
        int andIncrement = this.k.getAndIncrement();
        hc hcVar = new hc(andIncrement, bvVar);
        synchronized (this.f527n) {
            this.f527n.put(Integer.valueOf(andIncrement), hcVar);
        }
        return hcVar;
    }

    public final com.google.android.libraries.geo.mapcore.internal.model.v p() {
        return (com.google.android.libraries.geo.mapcore.internal.model.v) this.h.get();
    }

    final com.google.android.libraries.geo.mapcore.internal.model.be q(int i) {
        synchronized (this.f527n) {
            Map map = this.f527n;
            Integer numValueOf = Integer.valueOf(i);
            if (!map.containsKey(numValueOf)) {
                return c;
            }
            com.google.android.libraries.navigation.internal.ol.av avVar = (com.google.android.libraries.navigation.internal.ol.av) this.f527n.get(numValueOf);
            if (avVar instanceof com.google.android.libraries.geo.mapcore.internal.model.be) {
                return (com.google.android.libraries.geo.mapcore.internal.model.be) avVar;
            }
            return c;
        }
    }

    final com.google.android.libraries.geo.mapcore.internal.model.bt r(long j2) {
        com.google.android.libraries.geo.mapcore.internal.model.bv bvVarS = s();
        return bvVarS == null ? com.google.android.libraries.geo.mapcore.internal.model.bt.a : bvVarS.c(j2);
    }

    final com.google.android.libraries.geo.mapcore.internal.model.bv s() {
        com.google.android.libraries.geo.mapcore.internal.model.v vVar = (com.google.android.libraries.geo.mapcore.internal.model.v) this.h.get();
        if (vVar != null) {
            return vVar.c;
        }
        return null;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.vector.gl.p
    public final com.google.android.libraries.geo.mapcore.renderer.ek t(com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar) {
        com.google.android.libraries.geo.mapcore.renderer.ek ekVarC;
        synchronized (this.e) {
            ekVarC = this.d.c(nVar);
        }
        if (!nVar.c() && ekVarC == null) {
            synchronized (this.e) {
                this.d.d(nVar);
                ekVarC = this.d.c(nVar);
            }
        }
        return ekVarC;
    }

    public final void u(com.google.android.libraries.navigation.internal.ol.aw awVar) {
        com.google.android.libraries.navigation.internal.adi.bo boVar;
        com.google.android.libraries.geo.mapcore.internal.model.v vVar = (com.google.android.libraries.geo.mapcore.internal.model.v) this.h.get();
        if (vVar != null && (boVar = vVar.b.E) != null) {
            awVar.a(boVar);
        }
        this.i.add(awVar);
    }

    final void v(dq dqVar, boolean z) {
        com.google.android.libraries.navigation.internal.yz.fy fyVarI = dqVar.i();
        if (z) {
            dqVar.k(false);
        }
        if (fyVarI.isEmpty()) {
            dqVar.k(true);
            return;
        }
        hb hbVar = new hb(this, dqVar, fyVarI.size());
        synchronized (this.e) {
            nn nnVarListIterator = fyVarI.listIterator();
            while (nnVarListIterator.hasNext()) {
                com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar = (com.google.android.libraries.geo.mapcore.internal.vector.gl.n) nnVarListIterator.next();
                if (z) {
                    this.d.h(nVar);
                }
                this.d.e(nVar, hbVar);
            }
            nn nnVarListIterator2 = dqVar.j(fyVarI).listIterator();
            while (nnVarListIterator2.hasNext()) {
                this.d.i((com.google.android.libraries.geo.mapcore.internal.vector.gl.n) nnVarListIterator2.next());
            }
        }
    }

    public final void w() {
        synchronized (this.e) {
            hn hnVar = this.d;
            com.google.android.libraries.navigation.internal.aac.bl blVar = hnVar.b;
            if (blVar != null && !blVar.isCancelled()) {
                hnVar.b.cancel(false);
                if (hnVar.a.compareAndSet(false, true)) {
                    hnVar.g();
                    hnVar.a.set(false);
                }
            }
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.af
    public final void x(com.google.android.libraries.navigation.internal.ol.av avVar) {
        D(avVar);
    }

    public final void y(com.google.android.libraries.navigation.internal.ol.aw awVar) {
        this.i.remove(awVar);
    }

    private final com.google.android.libraries.geo.mapcore.internal.vector.gl.n A(Bitmap bitmap, com.google.android.libraries.geo.mapcore.internal.vector.gl.o oVar) {
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar;
        synchronized (this.e) {
            nVar = bitmap == null ? null : (com.google.android.libraries.geo.mapcore.internal.vector.gl.n) this.o.get(new h(bitmap, oVar));
        }
        return nVar;
    }
}
