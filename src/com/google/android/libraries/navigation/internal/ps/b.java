package com.google.android.libraries.navigation.internal.ps;

import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.navigation.internal.oe.ai;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.ma;
import com.google.android.libraries.navigation.internal.yz.mb;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public final h a;
    public y b;
    public final Map c = new HashMap();
    public final Set d = new HashSet();
    public boolean e;
    public boolean f;
    public volatile com.google.android.libraries.geo.mapcore.renderer.v g;
    private com.google.android.libraries.navigation.internal.pt.b h;
    private fy i;
    private fd j;
    private boolean k;

    public b(h hVar) {
        com.google.android.libraries.navigation.internal.pt.b bVar = com.google.android.libraries.navigation.internal.pt.b.a;
        this.j = ma.b;
        this.f = true;
        this.k = false;
        this.a = hVar;
    }

    public static boolean d(com.google.android.libraries.geo.mapcore.renderer.v vVar, int i) {
        return vVar.a.k >= ((float) i);
    }

    private final synchronized fd e() {
        if (this.f) {
            HashMap map = new HashMap();
            Iterator it2 = this.c.values().iterator();
            while (it2.hasNext()) {
                for (com.google.android.libraries.navigation.internal.pt.b bVar : (Collection) it2.next()) {
                    com.google.android.libraries.navigation.internal.pt.a aVar = bVar.b;
                    if (aVar != null) {
                        com.google.android.libraries.navigation.internal.oe.i iVar = aVar.a;
                        if (!map.containsKey(iVar)) {
                            map.put(iVar, bVar);
                        }
                    }
                }
            }
            this.j = new ez().b(map).d();
            this.f = false;
            this.k = true;
        }
        return this.j;
    }

    private final synchronized fy f(com.google.android.libraries.geo.mapcore.renderer.v vVar, fd fdVar) {
        try {
            if (vVar == null) {
                return mb.a;
            }
            if (!d(vVar, 17)) {
                return mb.a;
            }
            fy fyVar = this.i;
            if (!this.k && fyVar != null) {
                return fyVar;
            }
            fy fyVarO = fy.o(fdVar.values());
            this.k = false;
            return fyVarO;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void g(Collection collection) {
        this.d.clear();
        this.d.addAll(collection);
        HashSet hashSet = new HashSet();
        for (cd cdVar : this.c.keySet()) {
            if (!collection.contains(cdVar)) {
                hashSet.add(cdVar);
            }
        }
        this.c.keySet().removeAll(hashSet);
        if (!hashSet.isEmpty()) {
            this.f = true;
        }
        this.a.a.s(collection);
    }

    private final synchronized void h() {
        com.google.android.libraries.navigation.internal.pt.b bVar = com.google.android.libraries.navigation.internal.pt.b.a;
    }

    public final synchronized Collection a() {
        HashSet hashSet;
        hashSet = new HashSet();
        for (cd cdVar : this.d) {
            if (!this.c.containsKey(cdVar)) {
                hashSet.add(cdVar);
            }
        }
        return hashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(com.google.android.libraries.geo.mapcore.renderer.v vVar) {
        boolean zA;
        p pVar;
        com.google.android.libraries.navigation.internal.pt.b bVar;
        boolean zA2;
        com.google.android.libraries.navigation.internal.pt.c cVarA;
        com.google.android.libraries.navigation.internal.ia.e eVar;
        com.google.android.libraries.navigation.internal.oe.q qVar;
        fd fdVarE = e();
        fy fyVarF = f(vVar, fdVarE);
        synchronized (this) {
            if (!Objects.equals(fyVarF, this.i)) {
                this.i = fyVarF;
                h hVar = this.a;
                HashSet hashSet = new HashSet();
                HashSet hashSet2 = new HashSet();
                Iterator<E> it2 = fyVarF.iterator();
                while (it2.hasNext()) {
                    com.google.android.libraries.navigation.internal.pt.a aVar = ((com.google.android.libraries.navigation.internal.pt.b) it2.next()).b;
                    if (aVar != null) {
                        hashSet.add(aVar.a);
                        int i = 0;
                        while (true) {
                            ev evVar = aVar.b;
                            if (i < ((lv) evVar).c) {
                                hashSet2.add(((com.google.android.libraries.navigation.internal.pt.c) evVar.get(i)).a());
                                i++;
                            }
                        }
                    }
                }
                hVar.b.a.s((Collection) hashSet);
                hVar.c.a.s((Collection) hashSet2);
                y yVar = this.b;
                if (yVar != null) {
                    synchronized (yVar) {
                        com.google.android.libraries.navigation.internal.ia.e eVar2 = yVar.c;
                        if (eVar2 != null) {
                            eVar2.a(new com.google.android.libraries.navigation.internal.pr.a(fyVarF));
                        }
                        k kVar = yVar.a;
                        zA = am.a(kVar.c, fyVarF);
                        if (!zA) {
                            kVar.c.clear();
                            kVar.c.addAll(fyVarF);
                        }
                        if (!zA && (pVar = yVar.e) != null) {
                            pVar.b(yVar.a);
                        }
                    }
                    if (!zA) {
                        nn nnVarListIterator = yVar.l().listIterator();
                        while (nnVarListIterator.hasNext()) {
                            ((com.google.android.libraries.navigation.internal.pq.a) nnVarListIterator.next()).i();
                        }
                    }
                }
            }
        }
        h();
        if (vVar == null || !d(vVar, 18)) {
            bVar = com.google.android.libraries.navigation.internal.pt.b.a;
        } else {
            com.google.android.libraries.navigation.internal.pd.d dVar = vVar.a;
            double d = dVar.k;
            double dPow = d > 19.0d ? 8.0d / Math.pow(2.0d, d - 19.0d) : 8.0d;
            com.google.android.libraries.navigation.internal.oe.x xVar = dVar.j;
            ai aiVarH = ai.h(xVar, (int) (xVar.e() * dPow));
            bVar = com.google.android.libraries.navigation.internal.pt.b.a;
            nn nnVarListIterator2 = fdVarE.values().listIterator();
            float f = 0.0f;
            while (nnVarListIterator2.hasNext()) {
                com.google.android.libraries.navigation.internal.pt.b bVar2 = (com.google.android.libraries.navigation.internal.pt.b) nnVarListIterator2.next();
                if (bVar2.c.b(aiVarH)) {
                    if (bVar2.d == null) {
                        com.google.android.libraries.navigation.internal.pt.a aVar2 = bVar2.b;
                        com.google.android.libraries.navigation.internal.oe.q qVar2 = null;
                        if (aVar2 != null && (qVar = aVar2.e) != null) {
                            qVar2 = qVar;
                        }
                        if (qVar2 != null) {
                            bVar2.d = qVar2.a();
                        } else {
                            ai aiVarA = bVar2.c.a();
                            com.google.android.libraries.navigation.internal.oe.x xVar2 = new com.google.android.libraries.navigation.internal.oe.x();
                            aiVarA.q(xVar2);
                            bVar2.d = xVar2;
                        }
                    }
                    float fI = bVar2.d.i(vVar.a.j);
                    if (bVar == com.google.android.libraries.navigation.internal.pt.b.a || fI < f) {
                        bVar = bVar2;
                        f = fI;
                    }
                }
            }
        }
        synchronized (this) {
            com.google.android.libraries.navigation.internal.pt.b bVar3 = this.h;
            if (bVar3 != null) {
                if (Objects.equals(bVar.b, bVar3.b)) {
                    return;
                }
            }
            this.h = bVar;
            y yVar2 = this.b;
            if (yVar2 != null) {
                com.google.android.libraries.navigation.internal.pt.a aVar3 = bVar.b;
                if (yVar2.j()) {
                    synchronized (yVar2) {
                        k kVar2 = yVar2.a;
                        zA2 = am.a(kVar2.a, aVar3);
                        kVar2.a = aVar3;
                        cVarA = yVar2.a.a(aVar3);
                    }
                    if (!zA2) {
                        synchronized (yVar2) {
                            p pVar2 = yVar2.e;
                            if (pVar2 != null) {
                                pVar2.b(yVar2.a);
                            }
                        }
                        yVar2.q(cVarA);
                        nn nnVarListIterator3 = yVar2.l().listIterator();
                        while (nnVarListIterator3.hasNext()) {
                            ((com.google.android.libraries.navigation.internal.pq.a) nnVarListIterator3.next()).f();
                        }
                        if (aVar3 != null) {
                            yVar2.m(cVarA, aVar3, yVar2.b.a());
                        }
                    }
                    synchronized (yVar2) {
                        if (aVar3 != null) {
                            if (!aVar3.c && (eVar = yVar2.c) != null && yVar2.f != null) {
                                yVar2.f.o();
                                eVar.a(new com.google.android.libraries.navigation.internal.pi.d());
                            }
                        }
                    }
                }
            }
        }
    }

    public final void c(Collection collection, com.google.android.libraries.navigation.internal.pb.t tVar) {
        g(collection);
        b(tVar != null ? tVar.x() : null);
    }
}
