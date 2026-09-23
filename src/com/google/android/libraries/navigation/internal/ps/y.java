package com.google.android.libraries.navigation.internal.ps;

import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.renderer.ax;
import com.google.android.libraries.geo.mapcore.renderer.az;
import com.google.android.libraries.navigation.internal.po.es;
import com.google.android.libraries.navigation.internal.po.gr;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.mb;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y implements com.google.android.libraries.navigation.internal.pq.b {
    public final k a;
    public com.google.android.libraries.navigation.internal.ia.e c;
    public h d;
    public p e;
    public com.google.android.libraries.navigation.internal.pb.t f;
    private boolean g;
    private ax h;
    private b i;
    private x j;
    private gr m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private es f530n;
    public final com.google.android.libraries.navigation.internal.rq.j b = new com.google.android.libraries.navigation.internal.rq.j();
    private fy k = mb.a;
    private final Set l = new HashSet();

    public y(k kVar) {
        this.a = kVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pq.b
    public final int a(com.google.android.libraries.navigation.internal.oe.i iVar) {
        int i;
        synchronized (this) {
            j jVar = (j) this.a.b.f(iVar);
            i = jVar == null ? -1 : jVar.b;
        }
        return i;
    }

    @Override // com.google.android.libraries.navigation.internal.pq.b
    public final com.google.android.libraries.navigation.internal.pt.a b() {
        com.google.android.libraries.navigation.internal.pt.a aVar;
        synchronized (this) {
            aVar = this.a.a;
        }
        return aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pq.b
    public final Map c() {
        HashMap map;
        synchronized (this) {
            k kVar = this.a;
            map = new HashMap();
            for (j jVar : kVar.b.i()) {
                map.put(jVar.a.f(), Integer.valueOf(jVar.b));
            }
        }
        return map;
    }

    @Override // com.google.android.libraries.navigation.internal.pq.b
    public final synchronized void d(com.google.android.libraries.navigation.internal.pq.a aVar) {
        this.l.add(aVar);
    }

    @Override // com.google.android.libraries.navigation.internal.pq.b
    public final void e(com.google.android.libraries.navigation.internal.oe.i iVar) {
        if (j()) {
            final long jA = this.b.a();
            synchronized (this) {
                h hVar = this.d;
                if (hVar == null) {
                    return;
                }
                hVar.c(iVar, new e() { // from class: com.google.android.libraries.navigation.internal.ps.u
                    @Override // com.google.android.libraries.navigation.internal.ps.r
                    public final void a(Object obj) {
                        this.a.m(null, (com.google.android.libraries.navigation.internal.pt.a) obj, jA);
                    }
                });
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pq.b
    public final synchronized void f(com.google.android.libraries.navigation.internal.pq.a aVar) {
        this.l.remove(aVar);
    }

    @Override // com.google.android.libraries.navigation.internal.pq.b
    public final void g(Map map) {
        synchronized (this) {
            k kVar = this.a;
            for (String str : map.keySet()) {
                com.google.android.libraries.navigation.internal.oe.i iVarA = com.google.android.libraries.navigation.internal.oe.i.a(str);
                if (iVarA != null) {
                    kVar.b.m(iVarA, new j(iVarA, ((Integer) map.get(str)).intValue()));
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pq.b
    public final synchronized void h(com.google.android.libraries.navigation.internal.oe.i iVar) {
        h hVar;
        if (j() && (hVar = this.d) != null) {
            hVar.c.a(iVar, new r() { // from class: com.google.android.libraries.navigation.internal.ps.w
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.libraries.navigation.internal.ps.r
                public final void a(Object obj) {
                    h hVar2;
                    final y yVar = this.a;
                    final com.google.android.libraries.navigation.internal.pt.c cVar = (com.google.android.libraries.navigation.internal.pt.c) obj;
                    synchronized (yVar) {
                        hVar2 = yVar.d;
                    }
                    if (hVar2 == null) {
                        return;
                    }
                    com.google.android.libraries.navigation.internal.rq.j jVar = yVar.b;
                    ev evVar = cVar.b;
                    int i = ((lv) evVar).c;
                    final long jA = jVar.a();
                    for (int i2 = 0; i2 < i; i2++) {
                        hVar2.c((com.google.android.libraries.navigation.internal.oe.i) evVar.get(i2), new e() { // from class: com.google.android.libraries.navigation.internal.ps.v
                            @Override // com.google.android.libraries.navigation.internal.ps.r
                            public final void a(Object obj2) {
                                yVar.m(cVar, (com.google.android.libraries.navigation.internal.pt.a) obj2, jA);
                            }
                        });
                    }
                }
            });
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pq.b
    public final void i(Set set) {
        if (!j() || set.equals(this.k)) {
            return;
        }
        this.k = fy.o(set);
    }

    @Override // com.google.android.libraries.navigation.internal.pq.b
    public final synchronized boolean j() {
        return this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.google.android.libraries.navigation.internal.pt.c k(com.google.android.libraries.navigation.internal.pt.c cVar, com.google.android.libraries.navigation.internal.pt.a aVar) {
        synchronized (this) {
            com.google.android.libraries.navigation.internal.pt.c cVarA = this.a.a(aVar);
            int i = -1;
            if (cVar != null) {
                com.google.android.libraries.navigation.internal.oe.i iVarA = cVar.a();
                int i2 = 0;
                while (true) {
                    ev evVar = aVar.b;
                    if (i2 < ((lv) evVar).c) {
                        if (iVarA.equals(((com.google.android.libraries.navigation.internal.pt.c) evVar.get(i2)).a())) {
                            i = i2;
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            }
            k kVar = this.a;
            com.google.android.libraries.navigation.internal.oe.i iVar = aVar.a;
            j jVar = (j) kVar.b.e(iVar);
            if (jVar != null && jVar.b == i) {
                return null;
            }
            kVar.b.m(iVar, new j(iVar, i));
            boolean zEquals = aVar.equals(this.a.a);
            nn nnVarListIterator = l().listIterator();
            while (nnVarListIterator.hasNext()) {
                ((com.google.android.libraries.navigation.internal.pq.a) nnVarListIterator.next()).g(aVar);
            }
            synchronized (this) {
                p pVar = this.e;
                if (pVar != null) {
                    pVar.b(this.a);
                }
            }
            es esVar = this.f530n;
            if (esVar != null) {
                esVar.a.r();
            }
            if (zEquals) {
                q(cVar);
            }
            return cVarA;
        }
    }

    public final synchronized fy l() {
        return fy.o(this.l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void m(com.google.android.libraries.navigation.internal.pt.c cVar, com.google.android.libraries.navigation.internal.pt.a aVar, long j) {
        com.google.android.libraries.navigation.internal.rq.j jVar = this.b;
        Map map = jVar.a;
        com.google.android.libraries.navigation.internal.oe.i iVar = aVar.a;
        synchronized (map) {
            if (!jVar.a.containsKey(iVar) || ((Long) jVar.a.get(iVar)).longValue() <= j) {
                jVar.a.put(iVar, Long.valueOf(j));
                final com.google.android.libraries.navigation.internal.pt.c cVarK = k(cVar, aVar);
                if (cVarK != null) {
                    synchronized (this) {
                        h hVar = this.d;
                        if (hVar != null) {
                            int i = 0;
                            while (true) {
                                ev evVar = cVarK.b;
                                if (i >= ((lv) evVar).c) {
                                    break;
                                }
                                com.google.android.libraries.navigation.internal.oe.i iVar2 = (com.google.android.libraries.navigation.internal.oe.i) evVar.get(i);
                                if (!iVar2.equals(aVar.a)) {
                                    hVar.c(iVar2, new e() { // from class: com.google.android.libraries.navigation.internal.ps.t
                                        @Override // com.google.android.libraries.navigation.internal.ps.r
                                        public final void a(Object obj) {
                                            com.google.android.libraries.navigation.internal.pt.c cVarA;
                                            y yVar = this.a;
                                            com.google.android.libraries.navigation.internal.pt.a aVar2 = (com.google.android.libraries.navigation.internal.pt.a) obj;
                                            synchronized (yVar) {
                                                cVarA = yVar.a.a(aVar2);
                                            }
                                            if (cVarA != null) {
                                                if (cVarA.a().equals(cVarK.a())) {
                                                    yVar.k(null, aVar2);
                                                }
                                            }
                                        }
                                    });
                                }
                                i++;
                            }
                        }
                    }
                }
            }
        }
    }

    public final synchronized void n(com.google.android.libraries.navigation.internal.ia.e eVar, h hVar, b bVar) {
        this.c = eVar;
        this.d = hVar;
        this.i = bVar;
    }

    final synchronized void o(com.google.android.libraries.navigation.internal.pb.t tVar) {
        b bVar;
        try {
            if (j() && (tVar.a & 4) == 0 && (bVar = this.i) != null && this.e != null) {
                synchronized (bVar) {
                    if (!bVar.e) {
                        return;
                    }
                    bVar.g = tVar.x();
                    if (!b.d(bVar.g, 17)) {
                        bVar.c(mb.a, null);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    cd.j(tVar.v().d, 14, arrayList, null);
                    bVar.c(arrayList, tVar);
                    com.google.android.libraries.geo.mapcore.renderer.v vVar = bVar.g;
                    final h hVar = bVar.a;
                    Collection collectionA = bVar.a();
                    a aVar = new a(bVar, vVar);
                    HashSet<cd> hashSet = new HashSet();
                    Iterator it2 = collectionA.iterator();
                    while (it2.hasNext()) {
                        hashSet.add(((cd) it2.next()).h(14));
                    }
                    for (final cd cdVar : hashSet) {
                        boolean z = false;
                        if (cdVar.a < 14) {
                            int i = ev.d;
                            aVar.a(cdVar, 0, lv.a);
                            return;
                        }
                        synchronized (hVar) {
                            List arrayList2 = (List) hVar.e.get(cdVar);
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                                hVar.e.put(cdVar, arrayList2);
                                z = true;
                            }
                            arrayList2.add(aVar);
                        }
                        if (z) {
                            hVar.d.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ps.c
                                @Override // java.lang.Runnable
                                public final void run() {
                                    hVar.b(cdVar);
                                }
                            });
                        }
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void p() {
        gr grVar;
        com.google.android.libraries.navigation.internal.ra.c.b.f();
        if (this.g) {
            b bVar = this.i;
            if (bVar != null) {
                bVar.c(mb.a, null);
                this.i.b = null;
            }
            x xVar = this.j;
            if (xVar != null && (grVar = this.m) != null) {
                grVar.e(xVar);
            }
            this.j = null;
            h hVar = this.d;
            if (hVar != null) {
                hVar.a.k();
                hVar.b.a.k();
                hVar.c.a.k();
            }
            this.g = false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0038  */
    public final void q(com.google.android.libraries.navigation.internal.pt.c cVar) {
        ax axVar = this.h;
        if (axVar != null) {
            if (cVar != null && cVar.e.c < 0) {
                axVar.x.b(axVar.y.a(), 500L);
                axVar.o();
                return;
            }
            com.google.android.libraries.navigation.internal.ni.a aVar = axVar.y;
            az azVar = axVar.x;
            long jA = aVar.a();
            long j = azVar.a;
            if (j >= 0) {
                long j2 = azVar.b;
                if (j2 < 0 || j < j2) {
                    long jMax = jA - Math.max(azVar.b - jA, 0L);
                    azVar.b = jMax;
                    azVar.a = jMax + 500;
                }
            } else {
                long jMax2 = jA - Math.max(azVar.b - jA, 0L);
                azVar.b = jMax2;
                azVar.a = jMax2 + 500;
            }
            axVar.o();
        }
    }

    public final synchronized void r(p pVar, ax axVar, gr grVar, com.google.android.libraries.navigation.internal.pb.t tVar, es esVar) {
        com.google.android.libraries.navigation.internal.ra.c.b.f();
        if (!this.g) {
            this.e = pVar;
            this.m = grVar;
            this.f = tVar;
            this.f530n = esVar;
            this.h = axVar;
            b bVar = this.i;
            if (bVar != null) {
                bVar.b = this;
            }
            if (this.j == null) {
                x xVar = new x(this, tVar, grVar);
                this.j = xVar;
                xVar.c.a(xVar);
                xVar.c.d(xVar);
            }
            this.g = true;
            o(new com.google.android.libraries.navigation.internal.pb.t(this.j.a));
            nn nnVarListIterator = l().listIterator();
            while (nnVarListIterator.hasNext()) {
                ((com.google.android.libraries.navigation.internal.pq.a) nnVarListIterator.next()).h();
            }
        }
    }
}
