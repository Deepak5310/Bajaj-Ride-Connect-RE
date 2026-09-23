package com.google.android.libraries.navigation.internal.qg;

import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.aw;
import com.google.android.libraries.geo.mapcore.internal.model.ac;
import com.google.android.libraries.geo.mapcore.internal.model.ae;
import com.google.android.libraries.geo.mapcore.internal.model.aq;
import com.google.android.libraries.geo.mapcore.internal.model.ar;
import com.google.android.libraries.geo.mapcore.internal.model.br;
import com.google.android.libraries.geo.mapcore.internal.model.cc;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.geo.mapcore.internal.model.cn;
import com.google.android.libraries.geo.mapcore.internal.model.cp;
import com.google.android.libraries.geo.mapcore.internal.model.cq;
import com.google.android.libraries.geo.mapcore.internal.model.v;
import com.google.android.libraries.geo.mapcore.internal.model.x;
import com.google.android.libraries.geo.mapcore.renderer.ax;
import com.google.android.libraries.navigation.internal.abh.bj;
import com.google.android.libraries.navigation.internal.adf.l;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.eg;
import com.google.android.libraries.navigation.internal.adg.eh;
import com.google.android.libraries.navigation.internal.adg.jl;
import com.google.android.libraries.navigation.internal.adg.jn;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.dm.n;
import com.google.android.libraries.navigation.internal.dm.o;
import com.google.android.libraries.navigation.internal.dm.r;
import com.google.android.libraries.navigation.internal.dm.s;
import com.google.android.libraries.navigation.internal.oe.ap;
import com.google.android.libraries.navigation.internal.oe.at;
import com.google.android.libraries.navigation.internal.oe.bd;
import com.google.android.libraries.navigation.internal.ol.w;
import com.google.android.libraries.navigation.internal.ps.p;
import com.google.android.libraries.navigation.internal.ps.y;
import com.google.android.libraries.navigation.internal.qv.k;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fw;
import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.nn;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j implements com.google.android.libraries.navigation.internal.qv.i {
    private static final com.google.android.libraries.navigation.internal.qi.e l = new aw();
    private static final String m = ap.a().b;
    private final AtomicInteger A;
    private final AtomicInteger B;
    private final AtomicInteger C;
    private final com.google.android.libraries.navigation.internal.pq.b D;
    private final AtomicBoolean E;
    private final AtomicBoolean F;
    private final at G;
    private final com.google.android.libraries.navigation.internal.afo.a H;
    private w I;
    private volatile bj J;
    public com.google.android.libraries.navigation.internal.pg.f a;
    public volatile com.google.android.libraries.navigation.internal.qq.f b;
    public final Map c;
    public final ap d;
    public final boolean e;
    public final int f;
    public final boolean g;
    public final Executor h;
    public h i;
    public volatile boolean j;
    public final ax k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.qf.d f554n;
    private final Map o;
    private final k p;
    private final x q;
    private volatile com.google.android.libraries.navigation.internal.qi.f r;
    private final Set s;
    private final cg t;
    private final com.google.android.libraries.navigation.internal.mj.a u;
    private final Executor v;
    private int w;
    private int x;
    private final AtomicInteger y;
    private final AtomicInteger z;

    public j(ax axVar, com.google.android.libraries.navigation.internal.afo.a aVar, x xVar, ap apVar, cg cgVar, k kVar, boolean z, int i, com.google.android.libraries.navigation.internal.pq.b bVar, com.google.android.libraries.navigation.internal.qf.d dVar, com.google.android.libraries.navigation.internal.mj.a aVar2, Executor executor, at atVar, com.google.android.libraries.navigation.internal.qq.f fVar) {
        this(axVar, aVar, xVar, apVar, cgVar, kVar, z, i, false, bVar, dVar, aVar2, executor, atVar, fVar, null);
    }

    public static boolean v(ap apVar) {
        return m.equals(apVar.b);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0039 */
    /* JADX WARN: Code duplicated, block: B:10:0x0020 A[Catch: all -> 0x0036, LOOP:0: B:8:0x001a->B:10:0x0020, LOOP_END, TryCatch #1 {all -> 0x0036, blocks: (B:7:0x0010, B:8:0x001a, B:10:0x0020, B:11:0x002a, B:12:0x002f), top: B:28:0x0010, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x0032  */
    /* JADX WARN: Code duplicated, block: B:28:0x0010 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void y(com.google.android.libraries.navigation.internal.qi.f fVar) {
        Iterator it2;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("TileFetcher.clearCache");
        if (fVar == null) {
            synchronized (this.o) {
                it2 = this.o.values().iterator();
                while (it2.hasNext()) {
                    ((com.google.android.libraries.navigation.internal.qi.e) it2.next()).s();
                }
                this.o.clear();
                if (dVarB != null) {
                    Trace.endSection();
                    return;
                }
                return;
            }
        }
        this.f554n.e(fVar);
        synchronized (this.o) {
            try {
                it2 = this.o.values().iterator();
                while (it2.hasNext()) {
                    ((com.google.android.libraries.navigation.internal.qi.e) it2.next()).s();
                }
                this.o.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (dVarB != null) {
            Trace.endSection();
            return;
        }
        return;
        if (dVarB != null) {
            try {
                Trace.endSection();
            }
        }
        throw th;
    }

    private final boolean z() {
        return this.F.get() && !this.G.p(h());
    }

    /* JADX WARN: Code duplicated, block: B:120:0x0120 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x0148 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:? A[LOOP:2: B:78:0x010e->B:122:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0114 A[Catch: all -> 0x0172, TryCatch #0 {all -> 0x0172, blocks: (B:6:0x0017, B:7:0x0019, B:13:0x0028, B:20:0x0036, B:27:0x0056, B:28:0x0059, B:30:0x005d, B:90:0x0164, B:40:0x0073, B:39:0x0070, B:43:0x0077, B:45:0x0082, B:48:0x008a, B:50:0x0090, B:51:0x0095, B:53:0x009e, B:55:0x00a7, B:57:0x00b1, B:59:0x00b5, B:83:0x0126, B:85:0x0144, B:63:0x00bf, B:65:0x00c7, B:67:0x00d9, B:68:0x00e0, B:69:0x00e3, B:71:0x00e7, B:72:0x00ed, B:74:0x00f3, B:76:0x00ff, B:77:0x0106, B:78:0x010e, B:80:0x0114, B:82:0x0120, B:86:0x0148, B:87:0x014e, B:88:0x015c, B:95:0x016e, B:98:0x0171, B:21:0x003c, B:23:0x0042, B:25:0x0048, B:35:0x006a, B:8:0x001a, B:10:0x0024, B:12:0x0027), top: B:107:0x0017, inners: #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0144 A[Catch: all -> 0x0172, TryCatch #0 {all -> 0x0172, blocks: (B:6:0x0017, B:7:0x0019, B:13:0x0028, B:20:0x0036, B:27:0x0056, B:28:0x0059, B:30:0x005d, B:90:0x0164, B:40:0x0073, B:39:0x0070, B:43:0x0077, B:45:0x0082, B:48:0x008a, B:50:0x0090, B:51:0x0095, B:53:0x009e, B:55:0x00a7, B:57:0x00b1, B:59:0x00b5, B:83:0x0126, B:85:0x0144, B:63:0x00bf, B:65:0x00c7, B:67:0x00d9, B:68:0x00e0, B:69:0x00e3, B:71:0x00e7, B:72:0x00ed, B:74:0x00f3, B:76:0x00ff, B:77:0x0106, B:78:0x010e, B:80:0x0114, B:82:0x0120, B:86:0x0148, B:87:0x014e, B:88:0x015c, B:95:0x016e, B:98:0x0171, B:21:0x003c, B:23:0x0042, B:25:0x0048, B:35:0x006a, B:8:0x001a, B:10:0x0024, B:12:0x0027), top: B:107:0x0017, inners: #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x014e A[Catch: all -> 0x0172, TryCatch #0 {all -> 0x0172, blocks: (B:6:0x0017, B:7:0x0019, B:13:0x0028, B:20:0x0036, B:27:0x0056, B:28:0x0059, B:30:0x005d, B:90:0x0164, B:40:0x0073, B:39:0x0070, B:43:0x0077, B:45:0x0082, B:48:0x008a, B:50:0x0090, B:51:0x0095, B:53:0x009e, B:55:0x00a7, B:57:0x00b1, B:59:0x00b5, B:83:0x0126, B:85:0x0144, B:63:0x00bf, B:65:0x00c7, B:67:0x00d9, B:68:0x00e0, B:69:0x00e3, B:71:0x00e7, B:72:0x00ed, B:74:0x00f3, B:76:0x00ff, B:77:0x0106, B:78:0x010e, B:80:0x0114, B:82:0x0120, B:86:0x0148, B:87:0x014e, B:88:0x015c, B:95:0x016e, B:98:0x0171, B:21:0x003c, B:23:0x0042, B:25:0x0048, B:35:0x006a, B:8:0x001a, B:10:0x0024, B:12:0x0027), top: B:107:0x0017, inners: #1, #3, #4 }] */
    @Override // com.google.android.libraries.navigation.internal.qv.i
    public final void a(cd cdVar, com.google.android.libraries.navigation.internal.qv.h hVar, cc ccVar) {
        Iterator it2;
        if (ccVar != null) {
            this.y.incrementAndGet();
        }
        int i = hVar.j;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("handleTile");
        try {
            synchronized (this.c) {
                d dVar = (d) this.c.get(cdVar);
                if (dVar != null) {
                    boolean z = false;
                    boolean z2 = hVar.k == 1;
                    if (i == 0) {
                        throw null;
                    }
                    if (i == 3) {
                        com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("TileFetcher.handleNotExistTile");
                        try {
                            com.google.android.libraries.navigation.internal.qi.f fVarE = e();
                            if (fVarE != null && z()) {
                                this.B.incrementAndGet();
                                this.f554n.f(fVarE, cdVar, l);
                            }
                            if (dVarB2 != null) {
                                Trace.endSection();
                            }
                            if (hVar.k == 1) {
                                l(dVar, false, com.google.android.libraries.navigation.internal.rb.b.b());
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
                    } else if (i == 6) {
                        l(dVar, true, com.google.android.libraries.navigation.internal.rb.b.b());
                        h hVar2 = this.i;
                        if (hVar2 != null) {
                            hVar2.C();
                        }
                    } else {
                        if (i != 4) {
                            com.google.android.libraries.navigation.internal.qi.f fVarE2 = e();
                            if (fVarE2 == null) {
                                m(cdVar, z2);
                            } else {
                                aq aqVar = ((com.google.android.libraries.navigation.internal.qi.a) fVarE2).d;
                                if (ccVar instanceof cq) {
                                    cq cqVar = (cq) ccVar;
                                    int i2 = cqVar.b.c;
                                    if (i2 == 0 || !this.G.f(cqVar.m)) {
                                        r(cdVar, fVarE2, null, ccVar, z2);
                                    } else if (cqVar.t == null) {
                                        int i3 = 0;
                                        while (true) {
                                            if (i3 >= cqVar.f.size()) {
                                                jn jnVar = cqVar.i;
                                                if (jnVar != null) {
                                                    Iterator it3 = jnVar.b.iterator();
                                                    while (true) {
                                                        if (!it3.hasNext()) {
                                                            it2 = cqVar.g.b.iterator();
                                                            while (true) {
                                                                if (it2.hasNext()) {
                                                                    cqVar.t = false;
                                                                    r(cdVar, fVarE2, null, ccVar, z2);
                                                                } else if ((((ef) it2.next()).b & 8192) != 0) {
                                                                    cqVar.t = true;
                                                                }
                                                            }
                                                        } else if ((((jl) it3.next()).b & 32) != 0) {
                                                            cqVar.t = true;
                                                        }
                                                    }
                                                } else {
                                                    it2 = cqVar.g.b.iterator();
                                                    while (true) {
                                                        if (it2.hasNext()) {
                                                            cqVar.t = false;
                                                            r(cdVar, fVarE2, null, ccVar, z2);
                                                        } else if ((((ef) it2.next()).b & 8192) != 0) {
                                                            cqVar.t = true;
                                                        }
                                                    }
                                                }
                                            } else if (((br) cqVar.f.get(i3)).l().e()) {
                                                cqVar.t = true;
                                            } else {
                                                i3++;
                                            }
                                            this.C.incrementAndGet();
                                            if (!this.q.i(i2, aqVar, this.k.z, new g(this, cdVar, fVarE2, ccVar, z2))) {
                                                m(cdVar, z2);
                                            }
                                        }
                                    } else if (cqVar.t.booleanValue()) {
                                        this.C.incrementAndGet();
                                        if (!this.q.i(i2, aqVar, this.k.z, new g(this, cdVar, fVarE2, ccVar, z2))) {
                                            m(cdVar, z2);
                                        }
                                    } else {
                                        r(cdVar, fVarE2, null, ccVar, z2);
                                    }
                                } else {
                                    r(cdVar, fVarE2, null, ccVar, z2);
                                }
                            }
                        } else {
                            l(dVar, true, com.google.android.libraries.navigation.internal.rb.b.b());
                        }
                        m(cdVar, z);
                    }
                    z = z2;
                    m(cdVar, z);
                }
            }
            if (dVarB != null) {
                Trace.endSection();
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

    public final synchronized w b() {
        return this.I;
    }

    public final j c(cg cgVar, k kVar) {
        return new j(this.k, this.H, this.q, this.d, cgVar, kVar, this.e, this.f, this.g, this.D, this.f554n, this.u, this.v, this.G, this.b, null);
    }

    public final com.google.android.libraries.navigation.internal.qi.e d(cd cdVar, long j, com.google.android.libraries.navigation.internal.qi.f fVar) {
        com.google.android.libraries.navigation.internal.qi.e eVarC;
        if (fVar == null || (eVarC = this.f554n.c(fVar, cdVar, false, j)) == l) {
            return null;
        }
        if (eVarC == null) {
            synchronized (this.o) {
                eVarC = (com.google.android.libraries.navigation.internal.qi.e) this.o.get(cdVar);
            }
            if (eVarC == null) {
                return null;
            }
            if (eVarC.m() != fVar) {
                o(cdVar);
            }
            eVarC.p();
        }
        if (eVarC.z() && !eVarC.y(j)) {
            return eVarC;
        }
        eVarC.s();
        return null;
    }

    public final com.google.android.libraries.navigation.internal.qi.f e() {
        if (this.r == null) {
            synchronized (this) {
                if (this.r == null) {
                    t();
                }
            }
        }
        return this.r;
    }

    public final aq f() {
        return ((com.google.android.libraries.navigation.internal.qq.b) this.b).c;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    public final com.google.android.libraries.navigation.internal.qv.h g(d dVar, com.google.android.libraries.navigation.internal.adf.j jVar) {
        com.google.android.libraries.navigation.internal.qv.h hVar;
        boolean z;
        com.google.android.libraries.navigation.internal.qi.d dVar2;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("fetchFromCacheOrTileStore");
        try {
            com.google.android.libraries.navigation.internal.qi.f fVarE = e();
            com.google.android.libraries.navigation.internal.qi.d dVar3 = null;
            if (fVarE != null) {
                com.google.android.libraries.navigation.internal.qi.d dVarB2 = this.f554n.b(fVarE, dVar.a, true);
                if (dVarB2 == null) {
                    synchronized (this.o) {
                        dVar2 = (com.google.android.libraries.navigation.internal.qi.d) this.o.get(dVar.a);
                    }
                    dVarB2 = dVar2;
                }
                if (dVarB2 == null || !dVarB2.y(this.u.a())) {
                    dVar3 = dVarB2;
                }
            }
            if (dVar3 != null) {
                if (!this.G.o(dVar3.ab()) || dVar3.C()) {
                    z = dVar3.D(this.u);
                }
                if (dVar3.m() != fVarE || z) {
                    if (dVar.b) {
                        dVar = new d(dVar.a, false, dVar.c, dVar.d, dVar.e);
                    }
                    k(dVar, jVar);
                }
                hVar = dVar3 == l ? com.google.android.libraries.navigation.internal.qv.h.NOT_EXIST : com.google.android.libraries.navigation.internal.qv.h.OK;
            } else {
                k(dVar, jVar);
                hVar = com.google.android.libraries.navigation.internal.qv.h.NOT_FOUND_LOCALLY;
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            return hVar;
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

    public final an h() {
        return this.p.E();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0018 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("cancelFetching");
        synchronized (this.c) {
            try {
                this.c.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (dVarB != null) {
            Trace.endSection();
        }
    }

    public final void j() {
        y(e());
    }

    final void k(d dVar, com.google.android.libraries.navigation.internal.adf.j jVar) {
        d dVar2;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("dispatchRequest");
        try {
            synchronized (this.c) {
                dVar2 = (d) this.c.put(dVar.a, dVar);
            }
            if (dVar2 == null || (!dVar.b && dVar2.b)) {
                if (dVar.b) {
                    this.x++;
                    this.p.i(dVar.a, this, this.j);
                } else {
                    this.w++;
                    this.p.g(dVar.a, this, jVar);
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

    public final void l(d dVar, boolean z, com.google.android.libraries.navigation.internal.adf.j jVar) {
        int i;
        boolean z2;
        if (this.a != null) {
            cd cdVarC = dVar.a;
            if (cdVarC.a >= dVar.c) {
                do {
                    cdVarC = this.a.c(cdVarC, dVar.e);
                    if (cdVarC == null || cdVarC.a < (i = dVar.c)) {
                        return;
                    } else {
                        z2 = dVar.d || z;
                    }
                } while (g(new d(cdVarC, z2, i, z2, dVar.e), jVar) == com.google.android.libraries.navigation.internal.qv.h.NOT_EXIST);
            }
        }
    }

    public final void m(cd cdVar, boolean z) {
        if (z) {
            synchronized (this.c) {
                this.c.remove(cdVar);
            }
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x001f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("TileFetcher.onCacheInvalidated");
        com.google.android.libraries.navigation.internal.qi.f fVarE = e();
        if (fVarE != null) {
            synchronized (this.s) {
                try {
                    this.s.add(fVarE);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (dVarB != null) {
            Trace.endSection();
        }
    }

    public final void o(cd cdVar) {
        k(new d(cdVar, true), com.google.android.libraries.navigation.internal.rb.b.b());
    }

    public final void p(boolean z) {
        this.F.set(z);
    }

    public final void q(List list) {
        synchronized (this.o) {
            Iterator it2 = this.o.values().iterator();
            while (it2.hasNext()) {
                ((com.google.android.libraries.navigation.internal.qi.e) it2.next()).s();
            }
            this.o.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.google.android.libraries.navigation.internal.qi.e eVar = (com.google.android.libraries.navigation.internal.qi.e) list.get(i);
                eVar.p();
                com.google.android.libraries.navigation.internal.qi.e eVar2 = (com.google.android.libraries.navigation.internal.qi.e) this.o.put(eVar.a(), eVar);
                if (eVar2 != null) {
                    eVar2.s();
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0277 A[Catch: all -> 0x02ba, TRY_ENTER, TryCatch #9 {all -> 0x02ba, blocks: (B:67:0x0204, B:69:0x020a, B:73:0x0221, B:75:0x022b, B:77:0x0233, B:78:0x0235, B:80:0x023b, B:82:0x0243, B:83:0x0245, B:85:0x0249, B:86:0x024b, B:88:0x0251, B:90:0x0259, B:91:0x025b, B:93:0x025f, B:94:0x0261, B:96:0x0267, B:100:0x0277, B:101:0x0290, B:103:0x0296, B:104:0x02b1, B:51:0x0125, B:53:0x013e, B:54:0x0141, B:56:0x0155, B:57:0x0158, B:59:0x0179, B:61:0x0182, B:63:0x018b, B:65:0x0194, B:64:0x0192, B:60:0x0180, B:66:0x01d4), top: B:185:0x0125 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x0296 A[Catch: all -> 0x02ba, LOOP:3: B:101:0x0290->B:103:0x0296, LOOP_END, TryCatch #9 {all -> 0x02ba, blocks: (B:67:0x0204, B:69:0x020a, B:73:0x0221, B:75:0x022b, B:77:0x0233, B:78:0x0235, B:80:0x023b, B:82:0x0243, B:83:0x0245, B:85:0x0249, B:86:0x024b, B:88:0x0251, B:90:0x0259, B:91:0x025b, B:93:0x025f, B:94:0x0261, B:96:0x0267, B:100:0x0277, B:101:0x0290, B:103:0x0296, B:104:0x02b1, B:51:0x0125, B:53:0x013e, B:54:0x0141, B:56:0x0155, B:57:0x0158, B:59:0x0179, B:61:0x0182, B:63:0x018b, B:65:0x0194, B:64:0x0192, B:60:0x0180, B:66:0x01d4), top: B:185:0x0125 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x02f6 A[Catch: all -> 0x03d3, TryCatch #7 {all -> 0x03d3, blocks: (B:98:0x0272, B:123:0x02d1, B:124:0x02ef, B:126:0x02f6, B:127:0x030e, B:129:0x0314, B:157:0x03ca, B:118:0x02cb, B:117:0x02c8, B:131:0x032e, B:133:0x0334, B:135:0x033b, B:136:0x0347, B:139:0x0365, B:152:0x0396, B:154:0x039c, B:149:0x0376, B:148:0x0373, B:151:0x0378, B:155:0x03af), top: B:183:0x002c, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x0314 A[Catch: all -> 0x03d3, LOOP:2: B:127:0x030e->B:129:0x0314, LOOP_END, TryCatch #7 {all -> 0x03d3, blocks: (B:98:0x0272, B:123:0x02d1, B:124:0x02ef, B:126:0x02f6, B:127:0x030e, B:129:0x0314, B:157:0x03ca, B:118:0x02cb, B:117:0x02c8, B:131:0x032e, B:133:0x0334, B:135:0x033b, B:136:0x0347, B:139:0x0365, B:152:0x0396, B:154:0x039c, B:149:0x0376, B:148:0x0373, B:151:0x0378, B:155:0x03af), top: B:183:0x002c, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:173:0x02c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:0x03db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:202:? A[Catch: RuntimeException -> 0x02cc, all -> 0x03d3, SYNTHETIC, TRY_LEAVE, TryCatch #5 {RuntimeException -> 0x02cc, blocks: (B:98:0x0272, B:118:0x02cb, B:117:0x02c8), top: B:175:0x0038 }] */
    /* JADX WARN: Code duplicated, block: B:207:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x022b A[Catch: all -> 0x02ba, TryCatch #9 {all -> 0x02ba, blocks: (B:67:0x0204, B:69:0x020a, B:73:0x0221, B:75:0x022b, B:77:0x0233, B:78:0x0235, B:80:0x023b, B:82:0x0243, B:83:0x0245, B:85:0x0249, B:86:0x024b, B:88:0x0251, B:90:0x0259, B:91:0x025b, B:93:0x025f, B:94:0x0261, B:96:0x0267, B:100:0x0277, B:101:0x0290, B:103:0x0296, B:104:0x02b1, B:51:0x0125, B:53:0x013e, B:54:0x0141, B:56:0x0155, B:57:0x0158, B:59:0x0179, B:61:0x0182, B:63:0x018b, B:65:0x0194, B:64:0x0192, B:60:0x0180, B:66:0x01d4), top: B:185:0x0125 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0233 A[Catch: all -> 0x02ba, TryCatch #9 {all -> 0x02ba, blocks: (B:67:0x0204, B:69:0x020a, B:73:0x0221, B:75:0x022b, B:77:0x0233, B:78:0x0235, B:80:0x023b, B:82:0x0243, B:83:0x0245, B:85:0x0249, B:86:0x024b, B:88:0x0251, B:90:0x0259, B:91:0x025b, B:93:0x025f, B:94:0x0261, B:96:0x0267, B:100:0x0277, B:101:0x0290, B:103:0x0296, B:104:0x02b1, B:51:0x0125, B:53:0x013e, B:54:0x0141, B:56:0x0155, B:57:0x0158, B:59:0x0179, B:61:0x0182, B:63:0x018b, B:65:0x0194, B:64:0x0192, B:60:0x0180, B:66:0x01d4), top: B:185:0x0125 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x023b A[Catch: all -> 0x02ba, TryCatch #9 {all -> 0x02ba, blocks: (B:67:0x0204, B:69:0x020a, B:73:0x0221, B:75:0x022b, B:77:0x0233, B:78:0x0235, B:80:0x023b, B:82:0x0243, B:83:0x0245, B:85:0x0249, B:86:0x024b, B:88:0x0251, B:90:0x0259, B:91:0x025b, B:93:0x025f, B:94:0x0261, B:96:0x0267, B:100:0x0277, B:101:0x0290, B:103:0x0296, B:104:0x02b1, B:51:0x0125, B:53:0x013e, B:54:0x0141, B:56:0x0155, B:57:0x0158, B:59:0x0179, B:61:0x0182, B:63:0x018b, B:65:0x0194, B:64:0x0192, B:60:0x0180, B:66:0x01d4), top: B:185:0x0125 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0243 A[Catch: all -> 0x02ba, TryCatch #9 {all -> 0x02ba, blocks: (B:67:0x0204, B:69:0x020a, B:73:0x0221, B:75:0x022b, B:77:0x0233, B:78:0x0235, B:80:0x023b, B:82:0x0243, B:83:0x0245, B:85:0x0249, B:86:0x024b, B:88:0x0251, B:90:0x0259, B:91:0x025b, B:93:0x025f, B:94:0x0261, B:96:0x0267, B:100:0x0277, B:101:0x0290, B:103:0x0296, B:104:0x02b1, B:51:0x0125, B:53:0x013e, B:54:0x0141, B:56:0x0155, B:57:0x0158, B:59:0x0179, B:61:0x0182, B:63:0x018b, B:65:0x0194, B:64:0x0192, B:60:0x0180, B:66:0x01d4), top: B:185:0x0125 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0249 A[Catch: all -> 0x02ba, TryCatch #9 {all -> 0x02ba, blocks: (B:67:0x0204, B:69:0x020a, B:73:0x0221, B:75:0x022b, B:77:0x0233, B:78:0x0235, B:80:0x023b, B:82:0x0243, B:83:0x0245, B:85:0x0249, B:86:0x024b, B:88:0x0251, B:90:0x0259, B:91:0x025b, B:93:0x025f, B:94:0x0261, B:96:0x0267, B:100:0x0277, B:101:0x0290, B:103:0x0296, B:104:0x02b1, B:51:0x0125, B:53:0x013e, B:54:0x0141, B:56:0x0155, B:57:0x0158, B:59:0x0179, B:61:0x0182, B:63:0x018b, B:65:0x0194, B:64:0x0192, B:60:0x0180, B:66:0x01d4), top: B:185:0x0125 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0251 A[Catch: all -> 0x02ba, TryCatch #9 {all -> 0x02ba, blocks: (B:67:0x0204, B:69:0x020a, B:73:0x0221, B:75:0x022b, B:77:0x0233, B:78:0x0235, B:80:0x023b, B:82:0x0243, B:83:0x0245, B:85:0x0249, B:86:0x024b, B:88:0x0251, B:90:0x0259, B:91:0x025b, B:93:0x025f, B:94:0x0261, B:96:0x0267, B:100:0x0277, B:101:0x0290, B:103:0x0296, B:104:0x02b1, B:51:0x0125, B:53:0x013e, B:54:0x0141, B:56:0x0155, B:57:0x0158, B:59:0x0179, B:61:0x0182, B:63:0x018b, B:65:0x0194, B:64:0x0192, B:60:0x0180, B:66:0x01d4), top: B:185:0x0125 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0259 A[Catch: all -> 0x02ba, TryCatch #9 {all -> 0x02ba, blocks: (B:67:0x0204, B:69:0x020a, B:73:0x0221, B:75:0x022b, B:77:0x0233, B:78:0x0235, B:80:0x023b, B:82:0x0243, B:83:0x0245, B:85:0x0249, B:86:0x024b, B:88:0x0251, B:90:0x0259, B:91:0x025b, B:93:0x025f, B:94:0x0261, B:96:0x0267, B:100:0x0277, B:101:0x0290, B:103:0x0296, B:104:0x02b1, B:51:0x0125, B:53:0x013e, B:54:0x0141, B:56:0x0155, B:57:0x0158, B:59:0x0179, B:61:0x0182, B:63:0x018b, B:65:0x0194, B:64:0x0192, B:60:0x0180, B:66:0x01d4), top: B:185:0x0125 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x025f A[Catch: all -> 0x02ba, TryCatch #9 {all -> 0x02ba, blocks: (B:67:0x0204, B:69:0x020a, B:73:0x0221, B:75:0x022b, B:77:0x0233, B:78:0x0235, B:80:0x023b, B:82:0x0243, B:83:0x0245, B:85:0x0249, B:86:0x024b, B:88:0x0251, B:90:0x0259, B:91:0x025b, B:93:0x025f, B:94:0x0261, B:96:0x0267, B:100:0x0277, B:101:0x0290, B:103:0x0296, B:104:0x02b1, B:51:0x0125, B:53:0x013e, B:54:0x0141, B:56:0x0155, B:57:0x0158, B:59:0x0179, B:61:0x0182, B:63:0x018b, B:65:0x0194, B:64:0x0192, B:60:0x0180, B:66:0x01d4), top: B:185:0x0125 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x0267 A[Catch: all -> 0x02ba, TRY_LEAVE, TryCatch #9 {all -> 0x02ba, blocks: (B:67:0x0204, B:69:0x020a, B:73:0x0221, B:75:0x022b, B:77:0x0233, B:78:0x0235, B:80:0x023b, B:82:0x0243, B:83:0x0245, B:85:0x0249, B:86:0x024b, B:88:0x0251, B:90:0x0259, B:91:0x025b, B:93:0x025f, B:94:0x0261, B:96:0x0267, B:100:0x0277, B:101:0x0290, B:103:0x0296, B:104:0x02b1, B:51:0x0125, B:53:0x013e, B:54:0x0141, B:56:0x0155, B:57:0x0158, B:59:0x0179, B:61:0x0182, B:63:0x018b, B:65:0x0194, B:64:0x0192, B:60:0x0180, B:66:0x01d4), top: B:185:0x0125 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0272 A[Catch: RuntimeException -> 0x02cc, all -> 0x03d3, PHI: r1
      0x0272: PHI (r1v36 com.google.android.libraries.navigation.internal.qg.b) = 
      (r1v35 com.google.android.libraries.navigation.internal.qg.b)
      (r1v37 com.google.android.libraries.navigation.internal.qg.b)
     binds: [B:105:0x02b7, B:97:0x0270] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #5 {RuntimeException -> 0x02cc, blocks: (B:98:0x0272, B:118:0x02cb, B:117:0x02c8), top: B:175:0x0038 }] */
    public final void r(cd cdVar, com.google.android.libraries.navigation.internal.qi.f fVar, v vVar, cc ccVar, boolean z) throws Throwable {
        com.google.android.libraries.navigation.internal.nw.d dVar;
        Throwable th;
        b bVar;
        boolean z2;
        b bVar2;
        b bVar3;
        Throwable th2;
        ev evVar;
        cq cqVar;
        List arrayList;
        ArrayList arrayList2;
        Iterator it2;
        o oVar;
        o oVar2;
        com.google.android.libraries.navigation.internal.aeg.d dVar2;
        o oVar3;
        com.google.android.libraries.navigation.internal.aeg.d dVar3;
        cq cqVarA;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("TileFetcher.updateGLTileCache");
        try {
            if (z()) {
                this.z.incrementAndGet();
                try {
                    if (ccVar instanceof cq) {
                        cq cqVar2 = (cq) ccVar;
                        c cVar = (c) this.H.a();
                        try {
                            try {
                                com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("GLTilePrepper.prepVectorTile");
                                try {
                                    int i = ev.d;
                                    ev evVar2 = lv.a;
                                    if (cqVar2.m != an.GMM_VECTOR_BASE || cqVar2.h().a < 17) {
                                        evVar = evVar2;
                                        dVar = dVarB;
                                        cqVar = cqVar2;
                                    } else {
                                        HashMap map = new HashMap();
                                        HashMap map2 = new HashMap();
                                        cp cpVarK = cqVar2.k();
                                        while (cpVarK.hasNext()) {
                                            try {
                                                br next = cpVarK.next();
                                                ae.a(next, next.a() == 3 ? ((com.google.android.libraries.geo.mapcore.internal.model.g) next).o : next.a() == 8 ? ((ar) next).m : null, map2);
                                            } catch (Throwable th3) {
                                                th2 = th3;
                                                if (dVarB2 != null) {
                                                    throw th2;
                                                }
                                                try {
                                                    Trace.endSection();
                                                    throw th2;
                                                } catch (Throwable th4) {
                                                    th2.addSuppressed(th4);
                                                    throw th2;
                                                }
                                            }
                                        }
                                        HashMap map3 = new HashMap();
                                        byte[] bArr = cqVar2.h;
                                        for (ef efVar : cqVar2.g.b) {
                                            ae.a(efVar, com.google.android.libraries.navigation.internal.pt.f.a(com.google.android.libraries.navigation.internal.rb.a.b(efVar)), map3);
                                        }
                                        if (map2.isEmpty() && map3.isEmpty()) {
                                            cqVarA = cqVar2;
                                            evVar = evVar2;
                                            dVar = dVarB;
                                        } else {
                                            HashSet hashSet = new HashSet(cqVar2.f);
                                            HashSet hashSet2 = new HashSet(cqVar2.g.b);
                                            fw fwVar = new fw();
                                            fwVar.k(map2.keySet());
                                            fwVar.k(map3.keySet());
                                            nn nnVarListIterator = fwVar.i().listIterator();
                                            while (nnVarListIterator.hasNext()) {
                                                com.google.android.libraries.navigation.internal.pt.d dVar4 = (com.google.android.libraries.navigation.internal.pt.d) nnVarListIterator.next();
                                                nn nnVar = nnVarListIterator;
                                                s sVarB = cqVar2.b();
                                                ev evVar3 = evVar2;
                                                bb bbVar = (bb) sVarB.aH(5, null);
                                                bbVar.x(sVarB);
                                                r rVar = (r) bbVar;
                                                o oVar4 = cqVar2.b().c;
                                                if (oVar4 == null) {
                                                    oVar4 = o.a;
                                                }
                                                com.google.android.libraries.navigation.internal.nw.d dVar5 = dVarB;
                                                try {
                                                    bb bbVar2 = (bb) oVar4.aH(5, null);
                                                    bbVar2.x(oVar4);
                                                    n nVar = (n) bbVar2;
                                                    String strF = dVar4.b.f();
                                                    if (!nVar.b.H()) {
                                                        nVar.v();
                                                    }
                                                    o oVar5 = (o) nVar.b;
                                                    oVar5.b |= 32;
                                                    oVar5.g = strF;
                                                    if (!rVar.b.H()) {
                                                        rVar.v();
                                                    }
                                                    s sVar = (s) rVar.b;
                                                    o oVar6 = (o) nVar.t();
                                                    oVar6.getClass();
                                                    sVar.c = oVar6;
                                                    sVar.b |= 1;
                                                    s sVar2 = (s) rVar.t();
                                                    List list = map2.containsKey(dVar4) ? (List) map2.get(dVar4) : lv.a;
                                                    hashSet.removeAll(list);
                                                    Collection<?> collection = map3.containsKey(dVar4) ? (List) map3.get(dVar4) : lv.a;
                                                    hashSet2.removeAll(collection);
                                                    HashMap map4 = map3;
                                                    cn cnVar = new cn(cqVar2, sVar2, an.GMM_INDOOR, cqVar2.h().g(dVar4));
                                                    cnVar.b = list;
                                                    eg egVar = (eg) eh.a.q();
                                                    egVar.c(collection);
                                                    cnVar.c = (eh) egVar.t();
                                                    map.put(dVar4.b, cnVar.a());
                                                    nnVarListIterator = nnVar;
                                                    evVar2 = evVar3;
                                                    dVarB = dVar5;
                                                    map3 = map4;
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    th2 = th;
                                                    if (dVarB2 != null) {
                                                        throw th2;
                                                    }
                                                    Trace.endSection();
                                                    throw th2;
                                                }
                                            }
                                            evVar = evVar2;
                                            dVar = dVarB;
                                            cn cnVar2 = new cn(cqVar2, cqVar2.b(), cqVar2.m, cqVar2.h());
                                            cnVar2.b = hx.b(hashSet);
                                            eg egVar2 = (eg) eh.a.q();
                                            egVar2.c(hashSet2);
                                            cnVar2.c = (eh) egVar2.t();
                                            cqVarA = cnVar2.a();
                                        }
                                        if (map.isEmpty()) {
                                            cqVar = cqVarA;
                                        } else {
                                            arrayList = new ArrayList();
                                            arrayList.addAll(map.values());
                                            cqVar = cqVarA;
                                        }
                                        if ((cqVar2.b().b & 1) == 0) {
                                            com.google.android.libraries.navigation.internal.qi.e eVarB = cVar.c.b(cqVar, fVar, vVar, cVar.b, cVar.d, cVar.e);
                                            arrayList2 = new ArrayList();
                                            it2 = arrayList.iterator();
                                            while (it2.hasNext()) {
                                                arrayList2.add(cVar.c.b((cq) it2.next(), fVar, vVar, cVar.b, cVar.d, cVar.e));
                                            }
                                            bVar2 = new b(true, eVarB, arrayList2, FirebaseAnalytics.Param.SUCCESS);
                                            if (dVarB2 != null) {
                                                Trace.endSection();
                                            }
                                        } else {
                                            oVar = cqVar2.b().c;
                                            if (oVar == null) {
                                                oVar = o.a;
                                            }
                                            if ((oVar.b & 16) == 0) {
                                                com.google.android.libraries.navigation.internal.qi.e eVarB2 = cVar.c.b(cqVar, fVar, vVar, cVar.b, cVar.d, cVar.e);
                                                arrayList2 = new ArrayList();
                                                it2 = arrayList.iterator();
                                                while (it2.hasNext()) {
                                                    arrayList2.add(cVar.c.b((cq) it2.next(), fVar, vVar, cVar.b, cVar.d, cVar.e));
                                                }
                                                bVar2 = new b(true, eVarB2, arrayList2, FirebaseAnalytics.Param.SUCCESS);
                                                if (dVarB2 != null) {
                                                    Trace.endSection();
                                                }
                                            } else {
                                                oVar2 = cqVar2.b().c;
                                                if (oVar2 == null) {
                                                    oVar2 = o.a;
                                                }
                                                dVar2 = oVar2.f;
                                                if (dVar2 == null) {
                                                    dVar2 = com.google.android.libraries.navigation.internal.aeg.d.a;
                                                }
                                                if ((dVar2.b & 1) == 0) {
                                                    com.google.android.libraries.navigation.internal.qi.e eVarB3 = cVar.c.b(cqVar, fVar, vVar, cVar.b, cVar.d, cVar.e);
                                                    arrayList2 = new ArrayList();
                                                    it2 = arrayList.iterator();
                                                    while (it2.hasNext()) {
                                                        arrayList2.add(cVar.c.b((cq) it2.next(), fVar, vVar, cVar.b, cVar.d, cVar.e));
                                                    }
                                                    bVar2 = new b(true, eVarB3, arrayList2, FirebaseAnalytics.Param.SUCCESS);
                                                    if (dVarB2 != null) {
                                                        Trace.endSection();
                                                    }
                                                } else {
                                                    oVar3 = cqVar2.b().c;
                                                    if (oVar3 == null) {
                                                        oVar3 = o.a;
                                                    }
                                                    dVar3 = oVar3.f;
                                                    if (dVar3 == null) {
                                                        dVar3 = com.google.android.libraries.navigation.internal.aeg.d.a;
                                                    }
                                                    if (dVar3.c > 21) {
                                                        bVar2 = new b(false, null, null, "tile zoom greater than maximum zoom");
                                                        if (dVarB2 != null) {
                                                            Trace.endSection();
                                                        }
                                                    } else {
                                                        com.google.android.libraries.navigation.internal.qi.e eVarB4 = cVar.c.b(cqVar, fVar, vVar, cVar.b, cVar.d, cVar.e);
                                                        arrayList2 = new ArrayList();
                                                        it2 = arrayList.iterator();
                                                        while (it2.hasNext()) {
                                                            arrayList2.add(cVar.c.b((cq) it2.next(), fVar, vVar, cVar.b, cVar.d, cVar.e));
                                                        }
                                                        bVar2 = new b(true, eVarB4, arrayList2, FirebaseAnalytics.Param.SUCCESS);
                                                        if (dVarB2 != null) {
                                                            Trace.endSection();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        bVar3 = bVar2;
                                        if (bVar3.a()) {
                                            bVar3.a.p();
                                            s(bVar3.a, fVar, false, false, z);
                                            for (com.google.android.libraries.navigation.internal.qi.e eVar : bVar3.b) {
                                                eVar.p();
                                                s(eVar, fVar, true, false, false);
                                            }
                                            z2 = false;
                                        }
                                        m(cdVar, z2);
                                    }
                                    arrayList = evVar;
                                    if ((cqVar2.b().b & 1) == 0) {
                                        com.google.android.libraries.navigation.internal.qi.e eVarB5 = cVar.c.b(cqVar, fVar, vVar, cVar.b, cVar.d, cVar.e);
                                        arrayList2 = new ArrayList();
                                        it2 = arrayList.iterator();
                                        while (it2.hasNext()) {
                                            arrayList2.add(cVar.c.b((cq) it2.next(), fVar, vVar, cVar.b, cVar.d, cVar.e));
                                        }
                                        bVar2 = new b(true, eVarB5, arrayList2, FirebaseAnalytics.Param.SUCCESS);
                                        if (dVarB2 != null) {
                                            Trace.endSection();
                                        }
                                    } else {
                                        oVar = cqVar2.b().c;
                                        if (oVar == null) {
                                            oVar = o.a;
                                        }
                                        if ((oVar.b & 16) == 0) {
                                            com.google.android.libraries.navigation.internal.qi.e eVarB6 = cVar.c.b(cqVar, fVar, vVar, cVar.b, cVar.d, cVar.e);
                                            arrayList2 = new ArrayList();
                                            it2 = arrayList.iterator();
                                            while (it2.hasNext()) {
                                                arrayList2.add(cVar.c.b((cq) it2.next(), fVar, vVar, cVar.b, cVar.d, cVar.e));
                                            }
                                            bVar2 = new b(true, eVarB6, arrayList2, FirebaseAnalytics.Param.SUCCESS);
                                            if (dVarB2 != null) {
                                                Trace.endSection();
                                            }
                                        } else {
                                            oVar2 = cqVar2.b().c;
                                            if (oVar2 == null) {
                                                oVar2 = o.a;
                                            }
                                            dVar2 = oVar2.f;
                                            if (dVar2 == null) {
                                                dVar2 = com.google.android.libraries.navigation.internal.aeg.d.a;
                                            }
                                            if ((dVar2.b & 1) == 0) {
                                                com.google.android.libraries.navigation.internal.qi.e eVarB7 = cVar.c.b(cqVar, fVar, vVar, cVar.b, cVar.d, cVar.e);
                                                arrayList2 = new ArrayList();
                                                it2 = arrayList.iterator();
                                                while (it2.hasNext()) {
                                                    arrayList2.add(cVar.c.b((cq) it2.next(), fVar, vVar, cVar.b, cVar.d, cVar.e));
                                                }
                                                bVar2 = new b(true, eVarB7, arrayList2, FirebaseAnalytics.Param.SUCCESS);
                                                if (dVarB2 != null) {
                                                    Trace.endSection();
                                                }
                                            } else {
                                                oVar3 = cqVar2.b().c;
                                                if (oVar3 == null) {
                                                    oVar3 = o.a;
                                                }
                                                dVar3 = oVar3.f;
                                                if (dVar3 == null) {
                                                    dVar3 = com.google.android.libraries.navigation.internal.aeg.d.a;
                                                }
                                                if (dVar3.c > 21) {
                                                    bVar2 = new b(false, null, null, "tile zoom greater than maximum zoom");
                                                    if (dVarB2 != null) {
                                                        Trace.endSection();
                                                    }
                                                } else {
                                                    com.google.android.libraries.navigation.internal.qi.e eVarB8 = cVar.c.b(cqVar, fVar, vVar, cVar.b, cVar.d, cVar.e);
                                                    arrayList2 = new ArrayList();
                                                    it2 = arrayList.iterator();
                                                    while (it2.hasNext()) {
                                                        arrayList2.add(cVar.c.b((cq) it2.next(), fVar, vVar, cVar.b, cVar.d, cVar.e));
                                                    }
                                                    bVar2 = new b(true, eVarB8, arrayList2, FirebaseAnalytics.Param.SUCCESS);
                                                    if (dVarB2 != null) {
                                                        Trace.endSection();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    bVar3 = bVar2;
                                    if (bVar3.a()) {
                                        bVar3.a.p();
                                        s(bVar3.a, fVar, false, false, z);
                                        while (r0.hasNext()) {
                                            eVar.p();
                                            s(eVar, fVar, true, false, false);
                                        }
                                        z2 = false;
                                    }
                                    m(cdVar, z2);
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            } catch (RuntimeException e) {
                                e = e;
                                dVar = dVarB;
                                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) c.a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 1040)).o();
                                bVar2 = new b(false, null, null, "Runtime exception processing tile ".concat(String.valueOf(e.getMessage())));
                            }
                        } catch (RuntimeException e2) {
                            e = e2;
                            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) c.a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 1040)).o();
                            bVar2 = new b(false, null, null, "Runtime exception processing tile ".concat(String.valueOf(e.getMessage())));
                        }
                    } else {
                        dVar = dVarB;
                        if (ccVar instanceof ac) {
                            ac acVar = (ac) ccVar;
                            if (acVar.b != null) {
                                c cVar2 = (c) this.H.a();
                                w wVarB = b();
                                try {
                                    com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("GLTilePrepper.prepImageTile");
                                    try {
                                        com.google.android.libraries.navigation.internal.qi.e eVarA = cVar2.c.a(acVar, fVar, cVar2.b, wVarB, cVar2.e);
                                        int i2 = ev.d;
                                        bVar = new b(true, eVarA, lv.a, FirebaseAnalytics.Param.SUCCESS);
                                        if (dVarB3 != null) {
                                            Trace.endSection();
                                        }
                                        if (bVar.a()) {
                                            bVar.a.p();
                                            s(bVar.a, fVar, false, false, z);
                                        }
                                    } catch (Throwable th7) {
                                        if (dVarB3 == null) {
                                            throw th7;
                                        }
                                        try {
                                            Trace.endSection();
                                            throw th7;
                                        } catch (Throwable th8) {
                                            th7.addSuppressed(th8);
                                            throw th7;
                                        }
                                    }
                                } catch (RuntimeException e3) {
                                    ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) c.a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e3)).F((char) 1039)).o();
                                    bVar = new b(false, null, null, "exception prepping tile ".concat(String.valueOf(e3.getMessage())));
                                }
                            } else {
                                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.h(com.google.android.libraries.navigation.internal.zb.an.FULL)).F(1042)).p("Image tile fetched from server has null data");
                            }
                        }
                    }
                    z2 = z;
                    m(cdVar, z2);
                } catch (Throwable th9) {
                    th = th9;
                    th = th;
                    if (dVar != null) {
                        throw th;
                    }
                    Trace.endSection();
                    throw th;
                }
            } else {
                try {
                    m(cdVar, z);
                    dVar = dVarB;
                } catch (Throwable th10) {
                    th = th10;
                    dVar = dVarB;
                    if (dVar != null) {
                        throw th;
                    }
                    try {
                        Trace.endSection();
                        throw th;
                    } catch (Throwable th11) {
                        th.addSuppressed(th11);
                        throw th;
                    }
                }
            }
            if (dVar != null) {
                Trace.endSection();
            }
        } catch (Throwable th12) {
            th = th12;
            dVar = dVarB;
        }
    }

    public final void s(final com.google.android.libraries.navigation.internal.qi.e eVar, final com.google.android.libraries.navigation.internal.qi.f fVar, final boolean z, boolean z2, final boolean z3) {
        p pVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(eVar);
        if (!z2 || !eVar.z()) {
            this.k.q(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qg.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.s(eVar, fVar, z, true, z3);
                }
            });
            this.k.o();
            return;
        }
        if (z) {
            this.f554n.b(fVar, eVar.a(), true);
            this.f554n.f(fVar, eVar.a(), eVar);
            com.google.android.libraries.navigation.internal.pq.b bVar = this.D;
            if (bVar != null && (pVar = ((y) bVar).e) != null) {
                pVar.X(eVar);
            }
        } else {
            this.A.incrementAndGet();
            synchronized (this) {
                if (fVar == e()) {
                    synchronized (this.o) {
                        eVar.p();
                        com.google.android.libraries.navigation.internal.qi.e eVar2 = (com.google.android.libraries.navigation.internal.qi.e) this.o.put(eVar.a(), eVar);
                        if (eVar2 != null) {
                            eVar2.s();
                        }
                    }
                }
            }
            this.f554n.f(fVar, eVar.a(), eVar);
            h hVar = this.i;
            if (hVar != null) {
                hVar.X(eVar);
            }
        }
        m(eVar.a(), z3);
        eVar.s();
    }

    public final void t() {
        this.r = com.google.android.libraries.navigation.internal.qi.f.g(this.d, this.t, ((com.google.android.libraries.navigation.internal.qq.b) this.b).c, ((com.google.android.libraries.navigation.internal.qq.b) this.b).b, Integer.valueOf(System.identityHashCode(((c) this.H.a()).b.r)), null);
    }

    public final String toString() {
        String string;
        synchronized (this.c) {
            com.google.android.libraries.navigation.internal.qi.f fVar = this.r;
            ak akVarB = al.b(this);
            akVarB.g("drawMode", this.b);
            akVarB.g("legend", ((com.google.android.libraries.navigation.internal.qq.b) this.b).c);
            string = akVarB.e("enableNetworkRequests", this.j).e("allowEarlyFetching", this.E.get()).c("tileCacheKey hash", fVar == null ? 0 : fVar.hashCode()).e("tilePreppingEnabled", z()).c("requestsEmittedCount", this.w).c("requestsLocalEmittedCount", this.x).c("responsesReceivedCount", this.y.get()).c("prepsAttemptedCount", this.z.get()).c("prepsCompleteCount", this.A.get()).c("notExistsCount", this.B.get()).c("styleRequestsCount", this.C.get()).c("pendingTileLoadRequestsCount", this.c.size()).toString();
        }
        return string;
    }

    public final boolean u() {
        synchronized (this.s) {
            if (this.s.isEmpty()) {
                return false;
            }
            Iterator it2 = this.s.iterator();
            while (it2.hasNext()) {
                y((com.google.android.libraries.navigation.internal.qi.f) it2.next());
            }
            this.s.clear();
            return true;
        }
    }

    public final boolean w(final com.google.android.libraries.navigation.internal.oe.x xVar, List list, Set set, final bd bdVar, final int i, final boolean z, boolean z2, final com.google.android.libraries.navigation.internal.adf.j jVar) {
        boolean z3 = false;
        if (this.a == null) {
            return false;
        }
        com.google.android.libraries.navigation.internal.yt.a aVarC = com.google.android.libraries.navigation.internal.yt.d.c("startFetching ", h());
        try {
            int size = list.size();
            if (set != null) {
                size += set.size();
            }
            if (this.g && !z) {
                size += (int) Math.ceil(size * 0.35f);
            }
            com.google.android.libraries.navigation.internal.qi.f fVarE = e();
            if (fVarE != null) {
                this.f554n.i(fVarE, size);
            }
            if (z2) {
                if (!this.E.get()) {
                }
                aVarC.close();
                return z3;
            }
            this.E.set(false);
            final ArrayList arrayList = new ArrayList(list);
            final HashSet hashSet = new HashSet();
            if (set != null) {
                hashSet.addAll(set);
            }
            this.v.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qg.f
                /* JADX WARN: Bottom block not found for handler: all -> 0x02ec */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void run() throws Throwable {
                    Throwable th;
                    Set set2;
                    int i2;
                    com.google.android.libraries.navigation.internal.adf.j jVar2;
                    com.google.android.libraries.navigation.internal.oe.x xVar2;
                    com.google.android.libraries.navigation.internal.pg.f fVar;
                    boolean z4;
                    j jVar3;
                    int i3;
                    int i4;
                    int i5;
                    ArrayList arrayList2 = arrayList;
                    bd bdVar2 = bdVar;
                    int i6 = i;
                    j jVar4 = this.a;
                    boolean z5 = jVar4.g && !z;
                    com.google.android.libraries.navigation.internal.yt.a aVarC2 = com.google.android.libraries.navigation.internal.yt.d.c("beginFetching ", jVar4.h());
                    try {
                        synchronized (jVar4.c) {
                            try {
                                try {
                                    Iterator it2 = jVar4.c.entrySet().iterator();
                                    while (true) {
                                        boolean zHasNext = it2.hasNext();
                                        set2 = hashSet;
                                        if (!zHasNext) {
                                            break;
                                        }
                                        Map.Entry entry = (Map.Entry) it2.next();
                                        if (!set2.contains(entry.getKey()) && !bdVar2.k(((cd) entry.getKey()).e())) {
                                            it2.remove();
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    while (true) {
                                        throw th;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                th = th;
                            }
                        }
                        int size2 = arrayList2.size();
                        int i7 = 0;
                        while (true) {
                            i2 = jVar4.f;
                            jVar2 = jVar;
                            xVar2 = xVar;
                            if (i7 >= size2) {
                                break;
                            }
                            try {
                                cd cdVar = (cd) arrayList2.get(i7);
                                d dVar = new d(cdVar, !jVar4.j, cdVar.a - i2, (jVar4.j && jVar4.e) ? false : true, xVar2);
                                if (jVar4.g(dVar, jVar2) == com.google.android.libraries.navigation.internal.qv.h.NOT_EXIST) {
                                    jVar4.l(dVar, false, jVar2);
                                }
                                i7++;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                            th = th4;
                            try {
                                aVarC2.close();
                                throw th;
                            } catch (Throwable th5) {
                                th.addSuppressed(th5);
                                throw th;
                            }
                        }
                        Iterator it3 = set2.iterator();
                        while (it3.hasNext()) {
                            jVar4.g(new d((cd) it3.next(), true), jVar2);
                        }
                        if (!z5 || (fVar = jVar4.a) == null) {
                            aVarC2 = aVarC2;
                        } else {
                            LinkedHashSet linkedHashSet = new LinkedHashSet(arrayList2);
                            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                            if (linkedHashSet.isEmpty()) {
                                jVar3 = jVar4;
                            } else {
                                cd cdVar2 = (cd) linkedHashSet.iterator().next();
                                int i8 = cdVar2.a;
                                int i9 = 1 << i8;
                                int i10 = i9 - 1;
                                int i11 = i9 >> 1;
                                int iMin = cdVar2.b;
                                Iterator it4 = linkedHashSet.iterator();
                                while (it4.hasNext()) {
                                    iMin = Math.min(iMin, ((cd) it4.next()).b);
                                }
                                Iterator it5 = linkedHashSet.iterator();
                                while (true) {
                                    if (it5.hasNext()) {
                                        if (((cd) it5.next()).b - iMin >= i11) {
                                            z4 = true;
                                            break;
                                        }
                                    } else {
                                        z4 = false;
                                        break;
                                    }
                                }
                                Iterator it6 = linkedHashSet.iterator();
                                int iMin2 = i9;
                                int iMin3 = iMin2;
                                int iMax = 0;
                                int iMax2 = 0;
                                while (it6.hasNext()) {
                                    Iterator it7 = it6;
                                    cd cdVar3 = (cd) it6.next();
                                    j jVar5 = jVar4;
                                    int i12 = cdVar3.b;
                                    if (z4 && i12 < i11) {
                                        i12 += i9;
                                    }
                                    iMin3 = Math.min(iMin3, i12);
                                    iMax2 = Math.max(iMax2, i12);
                                    int i13 = cdVar3.c;
                                    iMin2 = Math.min(iMin2, i13);
                                    iMax = Math.max(iMax, i13);
                                    jVar4 = jVar5;
                                    it6 = it7;
                                }
                                jVar3 = jVar4;
                                com.google.android.libraries.navigation.internal.pt.d dVar2 = cdVar2.d;
                                int i14 = iMin3 & i10;
                                linkedHashSet2.add(new cd(i8, i14, iMin2, dVar2));
                                linkedHashSet2.add(new cd(i8, i14, iMax, dVar2));
                                int i15 = iMax2 & i10;
                                linkedHashSet2.add(new cd(i8, i15, iMin2, dVar2));
                                linkedHashSet2.add(new cd(i8, i15, iMax, dVar2));
                            }
                            Set<cd> setA = com.google.android.libraries.navigation.internal.pg.a.a(fVar, linkedHashSet, xVar2);
                            Set setA2 = com.google.android.libraries.navigation.internal.pg.a.a(fVar, linkedHashSet2, xVar2);
                            LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                            int i16 = i6;
                            int i17 = 0;
                            int i18 = 1;
                            while (!setA.isEmpty() && i16 > 0 && i18 <= i2 && i17 < 3) {
                                if (((cd) setA.iterator().next()).a <= 13 && ((i17 <= 0 && setA.size() <= 2) || ((i17 < 2 && i18 >= 4) || (i17 < 3 && i18 >= 6)))) {
                                    int i19 = i16;
                                    for (cd cdVar4 : setA) {
                                        if (i19 == 0) {
                                            break;
                                        } else if (linkedHashSet3.add(cdVar4)) {
                                            i19--;
                                        }
                                    }
                                    if (i16 != i19) {
                                        i17++;
                                    }
                                    i16 = i19;
                                }
                                if (setA2 != null && (setA.size() <= 2 || i18 >= 3)) {
                                    setA.addAll(setA2);
                                    setA2 = null;
                                }
                                if (setA.size() <= 2) {
                                    LinkedHashSet linkedHashSet4 = new LinkedHashSet();
                                    Iterator it8 = setA.iterator();
                                    while (it8.hasNext()) {
                                        cd cdVar5 = (cd) it8.next();
                                        int i20 = 1;
                                        int i21 = 1 << cdVar5.a;
                                        int i22 = i21 - 1;
                                        int i23 = -1;
                                        while (i23 <= i20) {
                                            int i24 = -1;
                                            while (i24 <= i20) {
                                                int i25 = cdVar5.c + i24;
                                                if (i25 >= 0 && i25 < i21) {
                                                    linkedHashSet4.add(new cd(cdVar5.a, (cdVar5.b + i23 + i21) & i22, i25, cdVar5.d));
                                                }
                                                i24++;
                                                it8 = it8;
                                                i16 = i16;
                                                i17 = i17;
                                                i2 = i2;
                                                i20 = 1;
                                            }
                                            i23++;
                                            i20 = 1;
                                        }
                                    }
                                    i3 = i16;
                                    i4 = i17;
                                    i5 = i2;
                                    setA = linkedHashSet4;
                                } else {
                                    i3 = i16;
                                    i4 = i17;
                                    i5 = i2;
                                }
                                if (setA2 != null) {
                                    setA2 = com.google.android.libraries.navigation.internal.pg.a.a(fVar, setA2, xVar2);
                                }
                                setA = com.google.android.libraries.navigation.internal.pg.a.a(fVar, setA, xVar2);
                                i18++;
                                i16 = i3;
                                i17 = i4;
                                i2 = i5;
                            }
                            Iterator it9 = linkedHashSet3.iterator();
                            while (it9.hasNext()) {
                                j jVar6 = jVar3;
                                d dVar3 = new d((cd) it9.next(), !jVar6.j);
                                com.google.android.libraries.navigation.internal.adf.i iVar = (com.google.android.libraries.navigation.internal.adf.i) com.google.android.libraries.navigation.internal.adf.j.a.q();
                                int i26 = l.d;
                                if (!iVar.b.H()) {
                                    iVar.v();
                                }
                                com.google.android.libraries.navigation.internal.adf.j jVar7 = (com.google.android.libraries.navigation.internal.adf.j) iVar.b;
                                int i27 = i26 - 1;
                                if (i26 == 0) {
                                    throw null;
                                }
                                jVar7.c = i27;
                                jVar7.b |= 1;
                                jVar6.g(dVar3, (com.google.android.libraries.navigation.internal.adf.j) iVar.t());
                                jVar3 = jVar6;
                            }
                        }
                        aVarC2.close();
                    } catch (Throwable th6) {
                        th = th6;
                    }
                }
            });
            z3 = true;
            aVarC.close();
            return z3;
        } catch (Throwable th) {
            try {
                aVarC.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public final synchronized boolean x(w wVar) {
        if (am.a(this.I, wVar)) {
            return false;
        }
        this.I = wVar;
        return true;
    }

    public j(ax axVar, com.google.android.libraries.navigation.internal.afo.a aVar, x xVar, ap apVar, cg cgVar, k kVar, boolean z, int i, boolean z2, com.google.android.libraries.navigation.internal.pq.b bVar, com.google.android.libraries.navigation.internal.qf.d dVar, com.google.android.libraries.navigation.internal.mj.a aVar2, Executor executor, at atVar, com.google.android.libraries.navigation.internal.qq.f fVar, bj bjVar) {
        this.o = new LinkedHashMap();
        this.r = null;
        this.s = new HashSet();
        this.c = new HashMap();
        this.w = 0;
        this.x = 0;
        this.y = new AtomicInteger(0);
        this.z = new AtomicInteger(0);
        this.A = new AtomicInteger(0);
        this.B = new AtomicInteger(0);
        this.C = new AtomicInteger(0);
        this.j = true;
        this.E = new AtomicBoolean(true);
        this.F = new AtomicBoolean(true);
        this.k = axVar;
        this.H = aVar;
        this.q = xVar;
        this.d = apVar;
        this.t = cgVar;
        this.p = kVar;
        this.e = z;
        this.f = i;
        this.g = z2;
        this.D = bVar;
        this.f554n = dVar;
        this.u = aVar2;
        this.v = executor;
        this.G = atVar;
        this.b = fVar;
        this.J = null;
        this.h = executor;
    }
}
