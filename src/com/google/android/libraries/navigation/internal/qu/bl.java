package com.google.android.libraries.navigation.internal.qu;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class bl implements com.google.android.libraries.geo.mapcore.internal.model.x, ca, bz {
    private final com.google.android.libraries.navigation.internal.ox.f A;
    public final com.google.android.libraries.navigation.internal.afo.a b;
    private final com.google.android.libraries.navigation.internal.agl.a e;
    private final Runnable f;
    private final com.google.android.libraries.navigation.internal.afo.a g;
    private final com.google.android.libraries.navigation.internal.afo.a h;
    private final com.google.android.libraries.navigation.internal.aac.bn i;
    private final Set m;
    private volatile com.google.android.libraries.geo.mapcore.internal.model.aq v;
    private final AtomicInteger w;
    private long x;
    private final AtomicLong y;
    private final com.google.android.libraries.navigation.internal.mj.a z;
    private static final com.google.android.libraries.navigation.internal.zb.j d = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.qu.bl");
    public static final com.google.android.libraries.geo.mapcore.internal.model.aq[] a = {null, null, null, null, com.google.android.libraries.geo.mapcore.internal.model.aq.d, com.google.android.libraries.geo.mapcore.internal.model.aq.k, com.google.android.libraries.geo.mapcore.internal.model.aq.f59n, null, com.google.android.libraries.geo.mapcore.internal.model.aq.a, null, null, com.google.android.libraries.geo.mapcore.internal.model.aq.s, null, null, null, com.google.android.libraries.geo.mapcore.internal.model.aq.q, com.google.android.libraries.geo.mapcore.internal.model.aq.r, null, com.google.android.libraries.geo.mapcore.internal.model.aq.z, null, com.google.android.libraries.geo.mapcore.internal.model.aq.t, null, com.google.android.libraries.geo.mapcore.internal.model.aq.h, com.google.android.libraries.geo.mapcore.internal.model.aq.j, null, com.google.android.libraries.geo.mapcore.internal.model.aq.c, null, com.google.android.libraries.geo.mapcore.internal.model.aq.b, com.google.android.libraries.geo.mapcore.internal.model.aq.u, null, com.google.android.libraries.geo.mapcore.internal.model.aq.A, com.google.android.libraries.geo.mapcore.internal.model.aq.v, com.google.android.libraries.geo.mapcore.internal.model.aq.w, null, null, null, null, com.google.android.libraries.geo.mapcore.internal.model.aq.i, com.google.android.libraries.geo.mapcore.internal.model.aq.m, null, null, null, null, com.google.android.libraries.geo.mapcore.internal.model.aq.p, com.google.android.libraries.geo.mapcore.internal.model.aq.x, com.google.android.libraries.geo.mapcore.internal.model.aq.y, com.google.android.libraries.geo.mapcore.internal.model.aq.f, com.google.android.libraries.geo.mapcore.internal.model.aq.g, com.google.android.libraries.geo.mapcore.internal.model.aq.B, com.google.android.libraries.geo.mapcore.internal.model.aq.C, com.google.android.libraries.geo.mapcore.internal.model.aq.e, com.google.android.libraries.geo.mapcore.internal.model.aq.l, com.google.android.libraries.geo.mapcore.internal.model.aq.o};
    private final AtomicInteger j = new AtomicInteger(-1);
    private final Object k = new Object();
    private final Set l = new HashSet();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f563n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private int s = 0;
    private int t = 0;
    private final AtomicInteger u = new AtomicInteger(0);
    final Map c = new ConcurrentHashMap();

    public bl(Runnable runnable, com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.ox.f fVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.aac.bn bnVar, com.google.android.libraries.navigation.internal.afo.a aVar4, com.google.android.libraries.navigation.internal.mj.a aVar5) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.w = atomicInteger;
        new AtomicInteger(0);
        this.x = 0L;
        this.y = new AtomicLong(0L);
        this.f = runnable;
        this.e = aVar;
        this.A = fVar;
        this.g = aVar2;
        this.h = aVar3;
        this.i = bnVar;
        this.b = aVar4;
        this.v = null;
        atomicInteger.set(-1);
        this.m = new HashSet();
        this.z = aVar5;
    }

    private final bj l(int i) {
        bj bjVar = (bj) this.c.get(Integer.valueOf(i));
        if (bjVar == null) {
            com.google.android.libraries.navigation.internal.adi.d dVarA = ((cb) this.b.a()).a(i);
            if (dVarA != null) {
                bjVar = new bj(dVarA);
            } else {
                try {
                    ((com.google.android.libraries.navigation.internal.qy.f) this.g.a()).c(com.google.android.libraries.navigation.internal.b.b.b(i, "paint-parameters-epoch-"));
                } catch (IOException e) {
                    ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) d.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 1169)).p("Error reading offline epoch resources %s");
                    this.u.incrementAndGet();
                }
                bjVar = null;
            }
            if (bjVar != null) {
                this.c.put(Integer.valueOf(i), bjVar);
            }
        }
        if (bjVar != null || i == -1) {
            return bjVar;
        }
        ((com.google.android.libraries.navigation.internal.kk.j) ((com.google.android.libraries.navigation.internal.kl.b) this.h.a()).a(com.google.android.libraries.navigation.internal.km.p.i)).a();
        return null;
    }

    private final Map m() {
        HashMap map = new HashMap();
        for (String str : ((com.google.android.libraries.navigation.internal.om.p) this.e.a()).d().c().keySet()) {
            EnumMap enumMap = new EnumMap(com.google.android.libraries.geo.mapcore.internal.model.aq.class);
            Map mapC = ((com.google.android.libraries.navigation.internal.om.p) this.e.a()).d().c();
            if (mapC.containsKey(str)) {
                for (Map.Entry entry : ((com.google.android.libraries.navigation.internal.om.u) mapC.get(str)).b.entrySet()) {
                    int i = ((com.google.android.libraries.navigation.internal.adi.bo) entry.getKey()).ab;
                    com.google.android.libraries.geo.mapcore.internal.model.aq[] aqVarArr = a;
                    int length = aqVarArr.length;
                    com.google.android.libraries.geo.mapcore.internal.model.aq aqVar = aqVarArr[i];
                    if (aqVar != null) {
                        com.google.android.libraries.navigation.internal.yx.ar.q(aqVar);
                        enumMap.put(aqVar, (String) entry.getValue());
                    }
                }
            }
            map.put(str, enumMap);
        }
        return map;
    }

    private final void n(bj bjVar, int i) {
        ((cb) this.b.a()).d(bjVar, i, this);
    }

    private final void o(bj bjVar, int i, com.google.android.libraries.geo.mapcore.internal.model.aq aqVar, com.google.android.libraries.navigation.internal.adi.c cVar, String str) {
        p(((com.google.android.libraries.navigation.internal.om.d) ((com.google.android.libraries.navigation.internal.om.p) this.e.a()).b()).e ? ((cb) this.b.a()).v(bjVar, i, cVar, aqVar, this, str) : ((cb) this.b.a()).v(bjVar, i, cVar, aqVar, this, ""));
    }

    private final void p(int i) {
        com.google.android.libraries.navigation.internal.kl.b bVar = (com.google.android.libraries.navigation.internal.kl.b) this.h.a();
        com.google.android.libraries.navigation.internal.km.v vVar = com.google.android.libraries.navigation.internal.km.v.AUTO_PAN_MODE_ENABLED;
        bVar.l();
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.x
    public final void a(com.google.android.libraries.geo.mapcore.internal.model.u uVar) {
        synchronized (this.k) {
            this.l.add(uVar);
        }
        int i = this.j.get();
        if (i != -1) {
            uVar.w(i);
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.x
    public final void b() {
        if (this.j.get() != -1) {
            p(com.google.android.libraries.navigation.internal.zt.p.e);
        }
        if (this.e.a() != null) {
            ((cb) this.b.a()).m((com.google.android.libraries.navigation.internal.om.p) this.e.a());
            f();
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.x
    public final void c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.geo.mapcore.internal.model.x
    public final synchronized void d() {
        for (com.google.android.libraries.navigation.internal.aac.bj bjVar : ((cb) this.b.a()).b()) {
            if (bjVar.isDone()) {
                try {
                    ((com.google.android.libraries.navigation.internal.kk.l) ((com.google.android.libraries.navigation.internal.kl.b) this.h.a()).a(com.google.android.libraries.navigation.internal.km.p.p)).a(((com.google.android.libraries.geo.mapcore.internal.model.bv) bjVar.get()).a());
                } catch (InterruptedException | ExecutionException unused) {
                }
            }
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.x
    public final void e() {
        bj bjVarL;
        if (!((com.google.android.libraries.navigation.internal.om.d) ((com.google.android.libraries.navigation.internal.om.p) this.e.a()).b()).e || (bjVarL = l(this.j.get())) == null) {
            return;
        }
        bjVarL.g = m();
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.x
    public final void f() {
        bj bjVar;
        fy fyVarO;
        int iN;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("GlobalStyleTablesImpl.onParametersChanged");
        try {
            this.y.set(0L);
            final com.google.android.libraries.navigation.internal.adi.d dVar = this.A.a().d;
            if (dVar == null) {
                dVar = com.google.android.libraries.navigation.internal.adi.d.a;
            }
            com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("GlobalStyleTablesImpl.updateFromLatestEpochResources");
            try {
                int i = dVar.b;
                if (i > 0) {
                    boolean z = this.j.getAndSet(i) != i;
                    if (z) {
                        bjVar = null;
                    } else {
                        bj bjVarL = l(i);
                        if (bjVarL != null) {
                            int i2 = bjVarL.e;
                            if (dVar.H()) {
                                iN = dVar.n();
                            } else {
                                iN = dVar.ak;
                                if (iN == 0) {
                                    iN = dVar.n();
                                    dVar.ak = iN;
                                }
                            }
                            if (i2 != iN) {
                                bjVar = bjVarL;
                                z = true;
                            } else {
                                bjVar = bjVarL;
                                z = false;
                            }
                        } else {
                            bjVar = bjVarL;
                            z = true;
                        }
                    }
                    if (z) {
                        final int i3 = dVar.b;
                        bjVar = new bj(dVar);
                        this.c.put(Integer.valueOf(i3), bjVar);
                        this.i.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.bh
                            @Override // java.lang.Runnable
                            public final void run() {
                                ((cb) this.a.b.a()).o(i3, dVar);
                            }
                        });
                        synchronized (this.k) {
                            fyVarO = fy.o(this.l);
                        }
                        nn nnVarListIterator = fyVarO.listIterator();
                        while (nnVarListIterator.hasNext()) {
                            ((com.google.android.libraries.geo.mapcore.internal.model.u) nnVarListIterator.next()).w(i);
                        }
                    }
                    ArrayList<bi> arrayList = new ArrayList();
                    ArrayList<bi> arrayList2 = new ArrayList();
                    synchronized (this.m) {
                        Iterator it2 = this.m.iterator();
                        while (it2.hasNext()) {
                            bi biVar = (bi) it2.next();
                            if (biVar.c) {
                                if (biVar.a.a == i) {
                                    if (bjVar == null) {
                                        bjVar = new bj(dVar);
                                    }
                                    bk bkVar = biVar.a;
                                    bkVar.g = bjVar.c;
                                    bkVar.h = bjVar.d;
                                    arrayList2.add(biVar);
                                    biVar.c = false;
                                } else {
                                    it2.remove();
                                    arrayList.add(biVar);
                                }
                            }
                        }
                    }
                    for (bi biVar2 : arrayList) {
                        this.t++;
                        biVar2.b.x(null);
                    }
                    if (!arrayList2.isEmpty()) {
                        if (bjVar == null) {
                            bjVar = new bj(dVar);
                        }
                        bj bjVar2 = bjVar;
                        for (bi biVar3 : arrayList2) {
                            this.f563n++;
                            n(bjVar2, i);
                            bk bkVar2 = biVar3.a;
                            o(bjVar2, i, bkVar2.b, bjVar2.f, bkVar2.c);
                        }
                    }
                }
                if (dVarB2 != null) {
                    Trace.endSection();
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

    @Override // com.google.android.libraries.geo.mapcore.internal.model.x
    public final void g(com.google.android.libraries.geo.mapcore.internal.model.u uVar) {
        synchronized (this.k) {
            this.l.remove(uVar);
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.x
    public final void h() {
        int i = this.j.get();
        bj bjVarL = l(i);
        if (bjVarL != null) {
            bjVarL.g = m();
            cb cbVar = (cb) this.b.a();
            bj bjVarL2 = l(i);
            com.google.android.libraries.navigation.internal.yx.ar.q(bjVarL2);
            cbVar.n(i, bjVarL2.f, bjVarL);
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0122 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:61:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.geo.mapcore.internal.model.x
    public final boolean i(int i, com.google.android.libraries.geo.mapcore.internal.model.aq aqVar, String str, com.google.android.libraries.geo.mapcore.internal.model.w wVar) {
        String str2;
        String str3;
        this.v = aqVar;
        int i2 = i;
        if (i2 == -1) {
            i2 = this.j.get();
        }
        this.w.set(i2);
        bj bjVarL = l(i2);
        if (bjVarL != null) {
            bj bjVarL2 = l(i2);
            if (bjVarL2 == null) {
                ((com.google.android.libraries.navigation.internal.zb.h) d.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1170)).u("Legend urls not found (getTableUrl) for epoch = %s, legend = %s", i2, aqVar);
            } else {
                if (bjVarL2.g.isEmpty() || !bjVarL2.g.containsKey(str)) {
                    bjVarL2.g = m();
                }
                if (bjVarL2.g.containsKey(str) && ((Map) bjVarL2.g.get(str)).containsKey(aqVar)) {
                    str2 = (String) ((Map) bjVarL2.g.get(str)).get(aqVar);
                } else {
                    com.google.android.libraries.navigation.internal.om.v vVarD = ((com.google.android.libraries.navigation.internal.om.p) this.e.a()).d();
                    if (vVarD.f(str) || Objects.equals(str, "") || bjVarL2.g.containsKey(str) || !vVarD.g(aqVar.E)) {
                        str2 = (String) bjVarL2.a.get(aqVar);
                    }
                    String str4 = bjVarL.b;
                    if (str3 != null && str4 != null) {
                        synchronized (this.m) {
                            this.f563n++;
                            this.m.add(new bi(new bk(i2, aqVar, str, str3, bjVarL.c, bjVarL.d), wVar, false));
                        }
                        n(bjVarL, i2);
                        o(bjVarL, i2, aqVar, bjVarL.f, str);
                        return true;
                    }
                }
                str3 = str2;
                String str5 = bjVarL.b;
                if (str3 != null) {
                    synchronized (this.m) {
                        this.f563n++;
                        this.m.add(new bi(new bk(i2, aqVar, str, str3, bjVarL.c, bjVarL.d), wVar, false));
                        n(bjVarL, i2);
                        o(bjVarL, i2, aqVar, bjVarL.f, str);
                        return true;
                    }
                }
            }
            str3 = null;
            String str6 = bjVarL.b;
            if (str3 != null) {
                synchronized (this.m) {
                    this.f563n++;
                    this.m.add(new bi(new bk(i2, aqVar, str, str3, bjVarL.c, bjVarL.d), wVar, false));
                    n(bjVarL, i2);
                    o(bjVarL, i2, aqVar, bjVarL.f, str);
                    return true;
                }
            }
        } else if (i2 != -1) {
            aqVar.name();
            this.j.get();
            synchronized (this.m) {
                this.o++;
                this.m.add(new bi(new bk(i2, aqVar, str, null, null, null), wVar, true));
            }
            com.google.android.libraries.navigation.internal.mj.a aVar = this.z;
            AtomicLong atomicLong = this.y;
            long jA = aVar.a();
            long j = atomicLong.get();
            if (jA >= this.x + j) {
                this.x = jA;
                if (this.y.compareAndSet(j, Math.min(180000L, Math.max(j + j, 5000L)))) {
                    this.f.run();
                }
            }
            return true;
        }
        this.p++;
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.qu.bz
    public final void j(int i, com.google.android.libraries.geo.mapcore.internal.model.bd bdVar, String str) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.m) {
            this.r++;
            Iterator it2 = this.m.iterator();
            while (it2.hasNext()) {
                bi biVar = (bi) it2.next();
                bk bkVar = biVar.a;
                if (bkVar.a == i) {
                    if (str == null) {
                        bkVar.f = bdVar;
                    } else {
                        bkVar.e = null;
                        bkVar.f = null;
                        this.t++;
                    }
                    bk bkVar2 = biVar.a;
                    if ((bkVar2.e != null && bkVar2.f != null) || str != null) {
                        it2.remove();
                        arrayList.add(biVar);
                        this.s++;
                    }
                }
            }
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            bi biVar2 = (bi) arrayList.get(i2);
            biVar2.b.x(biVar2.a.a());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qu.ca
    public final void k(int i, com.google.android.libraries.geo.mapcore.internal.model.aq aqVar, com.google.android.libraries.geo.mapcore.internal.model.bv bvVar, String str, String str2, String str3) {
        int i2;
        String str4;
        ArrayList arrayList = new ArrayList();
        synchronized (this.m) {
            this.q++;
            Iterator it2 = this.m.iterator();
            while (true) {
                i2 = 0;
                if (!it2.hasNext()) {
                    break;
                }
                bi biVar = (bi) it2.next();
                bk bkVar = biVar.a;
                if (bkVar.b == aqVar && bkVar.a == i) {
                    i2 = 1;
                }
                if (((com.google.android.libraries.navigation.internal.om.d) ((com.google.android.libraries.navigation.internal.om.p) this.e.a()).b()).e && (str4 = biVar.a.d) != null) {
                    i2 &= str4.equals(str3) ? 1 : 0;
                }
                if (i2 != 0) {
                    if (str == null) {
                        bk bkVar2 = biVar.a;
                        bkVar2.c = str2;
                        bkVar2.e = bvVar;
                    } else {
                        bk bkVar3 = biVar.a;
                        bkVar3.c = "";
                        bkVar3.e = null;
                        bkVar3.f = null;
                        this.t++;
                    }
                    bk bkVar4 = biVar.a;
                    if ((bkVar4.e != null && bkVar4.f != null) || str != null) {
                        it2.remove();
                        arrayList.add(biVar);
                        this.s++;
                    }
                }
            }
        }
        int size = arrayList.size();
        while (i2 < size) {
            bi biVar2 = (bi) arrayList.get(i2);
            biVar2.b.x(biVar2.a.a());
            i2++;
        }
    }
}
