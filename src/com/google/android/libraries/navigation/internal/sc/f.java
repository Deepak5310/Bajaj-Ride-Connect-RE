package com.google.android.libraries.navigation.internal.sc;

import com.google.android.libraries.geo.navcore.guider.jni.RouteGuiderJni;
import com.google.android.libraries.navigation.internal.acj.ao;
import com.google.android.libraries.navigation.internal.acj.l;
import com.google.android.libraries.navigation.internal.acj.o;
import com.google.android.libraries.navigation.internal.acj.s;
import com.google.android.libraries.navigation.internal.acj.w;
import com.google.android.libraries.navigation.internal.acu.ai;
import com.google.android.libraries.navigation.internal.acu.aj;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.bp.bw;
import com.google.android.libraries.navigation.internal.bp.j;
import com.google.android.libraries.navigation.internal.db.r;
import com.google.android.libraries.navigation.internal.db.y;
import com.google.android.libraries.navigation.internal.hn.p;
import com.google.android.libraries.navigation.internal.kk.k;
import com.google.android.libraries.navigation.internal.km.af;
import com.google.android.libraries.navigation.internal.oe.ag;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.yz.br;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import j$.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToLongFunction;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    public r a;
    public com.google.android.libraries.navigation.internal.se.b b;
    public boolean c;
    public final RouteGuiderJni d;
    public final bg e;
    private y f;
    private final ev g;
    private final ev h;
    private final com.google.android.libraries.navigation.internal.kl.a i;

    /* JADX WARN: Multi-variable type inference failed */
    public f(bg bgVar, p pVar, r rVar, com.google.android.libraries.navigation.internal.kl.a aVar) {
        this.e = bgVar;
        this.d = new RouteGuiderJni(bgVar, rVar, pVar.a());
        ev evVarP = ev.p(bgVar.ab());
        this.g = evVarP;
        ArrayList arrayList = new ArrayList();
        int i = ((lv) evVarP).c;
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.addAll(((bq) evVarP.get(i2)).A);
        }
        this.h = ev.o(arrayList);
        this.i = aVar;
        this.c = true;
        this.b = m(this.d.b(), bgVar, this.g, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final d l(s sVar) {
        a aVar;
        Iterator it2;
        ev evVar;
        com.google.android.libraries.navigation.internal.acj.b bVar;
        f fVar = this;
        y yVar = fVar.f;
        a aVar2 = new a();
        Iterator it3 = sVar.b.iterator();
        while (it3.hasNext()) {
            ev evVar2 = fVar.h;
            com.google.android.libraries.navigation.internal.acj.p pVar = (com.google.android.libraries.navigation.internal.acj.p) it3.next();
            if (o.a(pVar.b) == 2) {
                com.google.android.libraries.navigation.internal.acj.f fVar2 = pVar.b == 1 ? (com.google.android.libraries.navigation.internal.acj.f) pVar.c : com.google.android.libraries.navigation.internal.acj.f.a;
                aVar2.a = new com.google.android.libraries.navigation.internal.sd.b((bw) evVar2.get(fVar2.b), fVar2.c, fVar2.d, fVar2.e, yVar, fVar2.f);
            } else {
                if (o.a(pVar.b) == 3) {
                    com.google.android.libraries.navigation.internal.acj.b bVar2 = pVar.b == 2 ? (com.google.android.libraries.navigation.internal.acj.b) pVar.c : com.google.android.libraries.navigation.internal.acj.b.a;
                    if (yVar != null) {
                        double d = bVar2.e;
                        ArrayList arrayList = new ArrayList();
                        ev evVar3 = yVar.e;
                        int size = evVar3.size();
                        int i = 0;
                        while (i < size) {
                            com.google.android.libraries.navigation.internal.db.c cVar = (com.google.android.libraries.navigation.internal.db.c) evVar3.get(i);
                            double d2 = ((double) cVar.c) * d;
                            com.google.android.libraries.navigation.internal.db.p pVar2 = cVar.b;
                            arrayList.add(new com.google.android.libraries.navigation.internal.db.c(cVar.a, new com.google.android.libraries.navigation.internal.db.p(pVar2.a + d2, pVar2.b), cVar.c, cVar.d, (float) (((double) cVar.e) + d2), (float) (((double) cVar.f) + d2), cVar.g, cVar.h));
                            i++;
                            evVar3 = evVar3;
                            d = d;
                            size = size;
                            aVar2 = aVar2;
                            it3 = it3;
                            evVar2 = evVar2;
                            bVar2 = bVar2;
                        }
                        aVar = aVar2;
                        it2 = it3;
                        evVar = evVar2;
                        bVar = bVar2;
                        yVar = new y(yVar.b, yVar.c, yVar.d, arrayList);
                    } else {
                        aVar = aVar2;
                        it2 = it3;
                        evVar = evVar2;
                        bVar = bVar2;
                    }
                    com.google.android.libraries.navigation.internal.acj.b bVar3 = bVar;
                    aVar2 = aVar;
                    aVar2.b = new com.google.android.libraries.navigation.internal.sd.a((bw) evVar.get(bVar3.b), bVar3.c, yVar, bVar3.d);
                }
                fVar = this;
                it3 = it2;
            }
            it2 = it3;
            fVar = this;
            it3 = it2;
        }
        return aVar2.a();
    }

    private static com.google.android.libraries.navigation.internal.se.b m(ao aoVar, bg bgVar, List list, y yVar) {
        Duration duration = com.google.android.libraries.navigation.internal.se.b.a;
        com.google.android.libraries.navigation.internal.se.a aVar = new com.google.android.libraries.navigation.internal.se.a();
        aVar.a = bgVar;
        aVar.f571n = aoVar.h;
        aVar.o = aoVar.i;
        aVar.p = aoVar.g;
        int i = aoVar.b;
        aVar.d = (i & 2) != 0 ? aoVar.c : -1;
        aVar.e = (i & 8) != 0 ? aoVar.e : -1;
        aVar.j = aoVar.m;
        int i2 = (i & 16) != 0 ? aoVar.f : -1;
        if ((i & 4) != 0) {
            bq bqVar = (bq) list.get(aoVar.d);
            aVar.b = bqVar;
            boolean z = true;
            int i3 = i2 + 1;
            bw bwVarD = bqVar.d();
            if (bwVarD != null && i3 <= bwVarD.f) {
                z = false;
            }
            aVar.c = z;
            aVar.f = aoVar.j;
            aVar.h = aoVar.k;
            if ((aoVar.b & 1024) != 0) {
                aVar.i = aoVar.l;
            } else {
                aVar.i = Double.MAX_VALUE;
            }
            aVar.k = (aoVar.f169n + bgVar.J) - bgVar.i();
            aVar.g = aoVar.o;
            com.google.android.libraries.navigation.internal.acj.d dVar = aoVar.p;
            if (dVar == null) {
                dVar = com.google.android.libraries.navigation.internal.acj.d.a;
            }
            j jVar = new j();
            jVar.b(com.google.android.libraries.navigation.internal.aaa.a.b(dVar.b));
            double d = dVar.c;
            if (d >= 0.0d) {
                jVar.a = com.google.android.libraries.navigation.internal.aaa.a.b(d);
            }
            aVar.m = jVar.a();
            int i4 = bgVar.i() - aoVar.o;
            com.google.android.libraries.navigation.internal.bp.ao aoVar2 = bgVar.s;
            com.google.android.libraries.navigation.internal.bp.ao aoVar3 = bgVar.t;
            j jVar2 = new j();
            double d2 = i4;
            jVar2.b(aoVar2 != null ? aoVar2.c(d2) : Duration.ZERO);
            if (aoVar3 != null) {
                jVar2.a = aoVar3.c(d2);
            }
            aVar.l = jVar2.a();
        }
        if (yVar != null) {
            aVar.q = yVar;
        }
        if ((aoVar.b & 262144) != 0) {
            w wVar = aoVar.q;
            if (wVar == null) {
                wVar = w.a;
            }
            com.google.android.libraries.navigation.internal.afj.b bVar = wVar.c;
            if (bVar == null) {
                bVar = com.google.android.libraries.navigation.internal.afj.b.a;
            }
            double d3 = bVar.b;
            com.google.android.libraries.navigation.internal.afj.b bVar2 = wVar.c;
            if (bVar2 == null) {
                bVar2 = com.google.android.libraries.navigation.internal.afj.b.a;
            }
            aVar.r = new ag(x.A(d3, bVar2.c), (wVar.b & 2) != 0 ? wVar.d : 0.0d, wVar.e, wVar.f);
        }
        return new com.google.android.libraries.navigation.internal.se.b(aVar);
    }

    private static void n(com.google.android.libraries.navigation.internal.kl.a aVar, s sVar) {
        if (aVar == null) {
            return;
        }
        com.google.android.libraries.navigation.internal.km.x xVar = null;
        for (com.google.android.libraries.navigation.internal.acj.j jVar : sVar.c) {
            int iA = l.a(jVar.b);
            if (iA == 0) {
                iA = l.a;
            }
            if (iA == 0) {
                throw null;
            }
            if (iA - 1 == 1) {
                xVar = af.z;
            }
            if (xVar != null) {
                ((k) aVar.a(xVar)).b(jVar.c, jVar.d);
            }
        }
    }

    public final double a() {
        return this.b.i;
    }

    public final double b() {
        return this.b.k;
    }

    public final double c() {
        return this.b.b();
    }

    public final double d() {
        return this.b.c();
    }

    public final int e() {
        bq bqVar = this.b.c;
        if (bqVar == null) {
            return -1;
        }
        return bqVar.i;
    }

    public final ag f() {
        return this.b.q;
    }

    public final void finalize() {
        this.d.d();
    }

    public final d g() {
        RouteGuiderJni routeGuiderJni = this.d;
        routeGuiderJni.c();
        s sVarA = RouteGuiderJni.a(routeGuiderJni.nativeResumeGeneratingGuidanceEvents(routeGuiderJni.a));
        n(this.i, sVarA);
        return l(sVarA);
    }

    public final com.google.android.libraries.navigation.internal.se.b h(ao aoVar) {
        return m(aoVar, this.e, this.g, this.f);
    }

    public final boolean i() {
        return this.b.o;
    }

    public final boolean j() {
        RouteGuiderJni routeGuiderJni = this.d;
        routeGuiderJni.c();
        return routeGuiderJni.nativeIsOnRouteWithConfidenceThreshold(routeGuiderJni.a, 0.8d, 35.0d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final d k(r rVar) {
        ev evVarQ = ev.q(this);
        if (evVarQ.isEmpty()) {
            return new a().a();
        }
        y yVar = rVar.l().i;
        int i = 0;
        while (true) {
            y yVar2 = null;
            if (i >= evVarQ.size()) {
                break;
            }
            f fVar = (f) evVarQ.get(i);
            if (true != yVar.e.isEmpty()) {
                yVar2 = yVar;
            }
            fVar.f = yVar2;
            fVar.a = rVar;
            i++;
        }
        List list = (List) evVarQ.stream().map(new Function() { // from class: com.google.android.libraries.navigation.internal.sc.e
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((f) obj).d;
            }
        }).collect(br.a);
        int i2 = RouteGuiderJni.b;
        aj ajVar = rVar.l().I;
        if (ajVar == null) {
            x xVarN = rVar.n();
            ai aiVar = (ai) aj.a.q();
            int i3 = xVarN.a;
            if (!aiVar.b.H()) {
                aiVar.v();
            }
            aj ajVar2 = (aj) aiVar.b;
            ajVar2.b = 1 | ajVar2.b;
            ajVar2.c = i3;
            int i4 = xVarN.b;
            if (!aiVar.b.H()) {
                aiVar.v();
            }
            aj ajVar3 = (aj) aiVar.b;
            ajVar3.b |= 2;
            ajVar3.d = i4;
            float f = rVar.d;
            if (!aiVar.b.H()) {
                aiVar.v();
            }
            aj ajVar4 = (aj) aiVar.b;
            ajVar4.b |= 4;
            ajVar4.e = f;
            boolean z = rVar.l().c;
            if (!aiVar.b.H()) {
                aiVar.v();
            }
            aj ajVar5 = (aj) aiVar.b;
            ajVar5.b |= 128;
            ajVar5.j = z;
            com.google.android.libraries.navigation.internal.pt.d dVar = rVar.f387n;
            if (dVar != null) {
                com.google.android.libraries.navigation.internal.aci.b bVarC = dVar.c();
                if (!aiVar.b.H()) {
                    aiVar.v();
                }
                aj ajVar6 = (aj) aiVar.b;
                bVarC.getClass();
                ajVar6.m = bVarC;
                ajVar6.b |= 1024;
            }
            if (rVar.x()) {
                float f2 = rVar.f;
                if (!aiVar.b.H()) {
                    aiVar.v();
                }
                aj ajVar7 = (aj) aiVar.b;
                ajVar7.b |= 8;
                ajVar7.f = f2;
                float fH = rVar.h();
                if (!aiVar.b.H()) {
                    aiVar.v();
                }
                aj ajVar8 = (aj) aiVar.b;
                ajVar8.b |= 16;
                ajVar8.g = fH;
            } else {
                if (!aiVar.b.H()) {
                    aiVar.v();
                }
                aj ajVar9 = (aj) aiVar.b;
                ajVar9.b |= 8;
                ajVar9.f = 0.0f;
            }
            if (rVar.t()) {
                float f3 = rVar.f();
                if (!aiVar.b.H()) {
                    aiVar.v();
                }
                aj ajVar10 = (aj) aiVar.b;
                ajVar10.b |= 32;
                ajVar10.h = f3;
                float fG = rVar.g();
                if (!aiVar.b.H()) {
                    aiVar.v();
                }
                aj ajVar11 = (aj) aiVar.b;
                ajVar11.b |= 64;
                ajVar11.i = fG;
            } else {
                if (!aiVar.b.H()) {
                    aiVar.v();
                }
                aj ajVar12 = (aj) aiVar.b;
                ajVar12.b |= 64;
                ajVar12.i = 10.0f;
            }
            ajVar = (aj) aiVar.t();
        }
        s sVarA = RouteGuiderJni.a(RouteGuiderJni.nativeOnLocationChanged(list.stream().mapToLong(new ToLongFunction() { // from class: com.google.android.libraries.geo.navcore.guider.jni.a
            @Override // java.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                int i5 = RouteGuiderJni.b;
                return ((RouteGuiderJni) obj).a;
            }
        }).toArray(), 0, ajVar.m(), rVar.k().b));
        if (!sVarA.d.isEmpty()) {
            return new a().a();
        }
        for (int i5 = 0; i5 < evVarQ.size(); i5++) {
            f fVar2 = (f) evVarQ.get(i5);
            com.google.android.libraries.navigation.internal.acj.r rVar2 = (com.google.android.libraries.navigation.internal.acj.r) sVarA.e.get(i5);
            if (rVar2.d) {
                fVar2.f = null;
            }
            ao aoVar = rVar2.c;
            if (aoVar == null) {
                aoVar = ao.a;
            }
            fVar2.b = fVar2.h(aoVar);
            fVar2.c = rVar2.b;
        }
        n(((f) evVarQ.get(0)).i, sVarA);
        return evVarQ.size() > 0 ? ((f) evVarQ.get(0)).l(sVarA) : new a().a();
    }
}
