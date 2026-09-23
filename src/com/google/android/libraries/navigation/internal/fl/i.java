package com.google.android.libraries.navigation.internal.fl;

import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.agg.bz;
import com.google.android.libraries.navigation.internal.gq.w;
import com.google.android.libraries.navigation.internal.qp.ae;
import com.google.android.libraries.navigation.internal.qp.z;
import com.google.android.libraries.navigation.internal.qu.br;
import com.google.android.libraries.navigation.internal.qu.ce;
import com.google.android.libraries.navigation.internal.yz.eq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements c, r {
    public int a;
    public final com.google.android.libraries.navigation.internal.ia.e b;
    public final bn c;
    public final Runnable d;
    public boolean e;
    private final com.google.android.libraries.navigation.internal.iv.f f;
    private final com.google.android.libraries.navigation.internal.afo.a g;
    private final w h;
    private final bz i;
    private int j;
    private final List k;
    private final Set l;
    private q m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final l f428n;
    private final com.google.android.libraries.navigation.internal.fq.f o;
    private final com.google.android.libraries.navigation.internal.kl.a p;
    private final com.google.android.libraries.navigation.internal.mj.a q;
    private final com.google.android.libraries.navigation.internal.fu.a r;
    private final bn s;
    private final com.google.android.apps.gmm.offline.tilefetcher.d t;
    private final com.google.android.libraries.navigation.internal.agl.a u;
    private final Runnable v;
    private long w;
    private final br x;

    public i(com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.afo.a aVar, w wVar, l lVar, com.google.android.libraries.navigation.internal.fq.f fVar2, com.google.android.libraries.navigation.internal.kl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, Runnable runnable, Runnable runnable2, com.google.android.libraries.navigation.internal.mj.a aVar4, com.google.android.libraries.navigation.internal.fu.a aVar5, com.google.android.libraries.navigation.internal.ia.e eVar, bn bnVar, bn bnVar2, br brVar, com.google.android.apps.gmm.offline.tilefetcher.d dVar) {
        new bz();
        this.i = new bz();
        new HashSet();
        this.j = d.F;
        this.a = d.F;
        this.k = new ArrayList();
        this.l = new HashSet();
        this.w = 0L;
        this.e = false;
        this.f = fVar;
        this.g = aVar;
        this.h = wVar;
        this.f428n = lVar;
        this.d = runnable2;
        this.o = fVar2;
        this.p = aVar2;
        this.u = aVar3;
        this.v = runnable;
        this.q = aVar4;
        this.r = aVar5;
        this.b = eVar;
        this.s = bnVar;
        this.c = bnVar2;
        this.x = brVar;
        this.t = dVar;
    }

    private final void h(int i, boolean z) {
        List listG;
        synchronized (this) {
            try {
                if (z) {
                    this.l.add(Integer.valueOf(i));
                } else {
                    this.l.remove(Integer.valueOf(i));
                }
                listG = g();
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it2 = listG.iterator();
        while (it2.hasNext()) {
            ((Runnable) it2.next()).run();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.fl.c, com.google.android.libraries.navigation.internal.fl.r
    public final synchronized int a() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.fl.c
    public final void b(int i) {
        h(i, false);
    }

    @Override // com.google.android.libraries.navigation.internal.fl.c
    public final void c(int i) {
        h(i, true);
    }

    @Override // com.google.android.libraries.navigation.internal.fl.r
    public final long d() {
        return this.t.a();
    }

    public final q e() {
        if (this.m == null) {
            this.m = new q((com.google.android.apps.gmm.offline.routing.a) this.g.a(), this.c, this.q);
        }
        return this.m;
    }

    @Override // com.google.android.libraries.navigation.internal.fl.r
    public final s f(int i) {
        WeakReference weakReference = (WeakReference) this.i.p(i);
        e eVar = weakReference != null ? (e) weakReference.get() : null;
        if (eVar != null) {
            return eVar;
        }
        v vVar = new v((com.google.android.apps.gmm.offline.routing.a) this.g.a(), i, e(), this.f428n, this.r.b());
        ce ceVar = new ce(an.GMM_ROAD_GRAPH, new t(), vVar, null, this.c);
        ae aeVar = new ae(!vVar.i(), i, false);
        eq eqVar = new eq();
        eqVar.h(aeVar);
        e eVar2 = new e(i, ceVar, vVar, this, new com.google.android.libraries.navigation.internal.qp.w(this.f, this.s, this.h, new com.google.android.libraries.navigation.internal.qp.o(new com.google.android.libraries.navigation.internal.qn.a(8), new z(this.u, null, cg.s), eqVar.g(), com.google.android.libraries.navigation.internal.ih.a.c(this.r)), com.google.android.libraries.navigation.internal.gd.k.a, this.p, this.u), aeVar, this.f428n, this.p, this.u, this.v, this.q, this.s, this.c, this.x);
        this.o.c(eVar2, com.google.android.libraries.navigation.internal.xn.a.e(eVar2.f));
        this.i.a(i, new WeakReference(eVar2));
        return eVar2;
    }

    public final List g() {
        int i = this.a;
        boolean z = i != this.j;
        this.j = i;
        if (!this.l.contains(Integer.valueOf(i))) {
            this.w = 0L;
        } else if (!this.e) {
            this.e = true;
            this.c.schedule(new h(this), this.w, TimeUnit.MILLISECONDS);
            long j = this.w;
            if (j == 0) {
                this.w = 100L;
            } else {
                this.w = j + j;
            }
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            Iterator it2 = this.k.iterator();
            while (it2.hasNext()) {
                Runnable runnable = (Runnable) ((WeakReference) it2.next()).get();
                if (runnable == null) {
                    it2.remove();
                } else {
                    arrayList.add(runnable);
                }
            }
        }
        return arrayList;
    }
}
