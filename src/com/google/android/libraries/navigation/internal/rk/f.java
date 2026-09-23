package com.google.android.libraries.navigation.internal.rk;

import com.google.android.libraries.geo.mapcore.internal.model.cf;
import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.navigation.internal.aah.i;
import com.google.android.libraries.navigation.internal.adi.ag;
import com.google.android.libraries.navigation.internal.adi.aj;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.adi.t;
import com.google.android.libraries.navigation.internal.adi.x;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.afm.dg;
import com.google.android.libraries.navigation.internal.afm.dh;
import com.google.android.libraries.navigation.internal.afm.di;
import com.google.android.libraries.navigation.internal.afm.dj;
import com.google.android.libraries.navigation.internal.oa.k;
import com.google.android.libraries.navigation.internal.oe.j;
import com.google.android.libraries.navigation.internal.yz.br;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements com.google.android.libraries.navigation.internal.ou.b {
    public final com.google.android.libraries.navigation.internal.afo.a a;
    public final com.google.android.libraries.navigation.internal.ou.d b;
    public an c = null;

    public f(com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.ou.d dVar) {
        this.a = aVar;
        this.b = dVar;
    }

    public static cg b(com.google.android.libraries.navigation.internal.adf.b bVar) {
        cf cfVarX = cg.x();
        bh bhVarS = bi.s(com.google.android.libraries.navigation.internal.aai.f.b);
        bVar.h(bhVarS);
        if (bVar.w.n(bhVarS.d)) {
            bh bhVarS2 = bi.s(com.google.android.libraries.navigation.internal.aai.f.b);
            bVar.h(bhVarS2);
            Object objK = bVar.w.k(bhVarS2.d);
            ((com.google.android.libraries.geo.mapcore.internal.model.a) cfVarX).a = (com.google.android.libraries.navigation.internal.aai.f) (objK == null ? bhVarS2.b : bhVarS2.c(objK));
        }
        bh bhVarS3 = bi.s(com.google.android.libraries.navigation.internal.acy.b.b);
        bVar.h(bhVarS3);
        if (bVar.w.n(bhVarS3.d)) {
            bh bhVarS4 = bi.s(com.google.android.libraries.navigation.internal.acy.b.b);
            bVar.h(bhVarS4);
            Object objK2 = bVar.w.k(bhVarS4.d);
            ((com.google.android.libraries.geo.mapcore.internal.model.a) cfVarX).b = (com.google.android.libraries.navigation.internal.acy.b) (objK2 == null ? bhVarS4.b : bhVarS4.c(objK2));
        }
        bh bhVarS5 = bi.s(com.google.android.libraries.navigation.internal.aey.b.b);
        bVar.h(bhVarS5);
        if (bVar.w.n(bhVarS5.d)) {
            bh bhVarS6 = bi.s(com.google.android.libraries.navigation.internal.aey.b.b);
            bVar.h(bhVarS6);
            Object objK3 = bVar.w.k(bhVarS6.d);
            if ((((com.google.android.libraries.navigation.internal.aey.b) (objK3 == null ? bhVarS6.b : bhVarS6.c(objK3))).c & 1) != 0) {
                ag agVar = (ag) aj.a.q();
                bh bhVarS7 = bi.s(com.google.android.libraries.navigation.internal.aey.b.b);
                bVar.h(bhVarS7);
                Object objK4 = bVar.w.k(bhVarS7.d);
                x xVar = ((com.google.android.libraries.navigation.internal.aey.b) (objK4 == null ? bhVarS7.b : bhVarS7.c(objK4))).d;
                if (xVar == null) {
                    xVar = x.a;
                }
                agVar.d(xVar);
                ((com.google.android.libraries.geo.mapcore.internal.model.a) cfVarX).j = (aj) agVar.t();
            }
        }
        bh bhVarS8 = bi.s(com.google.android.libraries.navigation.internal.aey.d.b);
        bVar.h(bhVarS8);
        if (bVar.w.n(bhVarS8.d)) {
            bh bhVarS9 = bi.s(com.google.android.libraries.navigation.internal.aey.d.b);
            bVar.h(bhVarS9);
            Object objK5 = bVar.w.k(bhVarS9.d);
            com.google.android.libraries.navigation.internal.aey.d dVar = (com.google.android.libraries.navigation.internal.aey.d) (objK5 == null ? bhVarS9.b : bhVarS9.c(objK5));
            dg dgVar = (dg) dh.a.q();
            String str = dVar.c;
            if (!dgVar.b.H()) {
                dgVar.v();
            }
            dh dhVar = (dh) dgVar.b;
            str.getClass();
            dhVar.b |= 1;
            dhVar.c = str;
            for (t tVar : dVar.d) {
                di diVar = (di) dj.a.q();
                String str2 = tVar.c;
                if (!diVar.b.H()) {
                    diVar.v();
                }
                dj djVar = (dj) diVar.b;
                str2.getClass();
                djVar.b |= 1;
                djVar.c = str2;
                String str3 = tVar.d;
                if (!diVar.b.H()) {
                    diVar.v();
                }
                dj djVar2 = (dj) diVar.b;
                str3.getClass();
                djVar2.b |= 2;
                djVar2.d = str3;
                if (!dgVar.b.H()) {
                    dgVar.v();
                }
                dh dhVar2 = (dh) dgVar.b;
                dj djVar3 = (dj) diVar.t();
                djVar3.getClass();
                bz bzVar = dhVar2.d;
                if (!bzVar.c()) {
                    dhVar2.d = bi.A(bzVar);
                }
                dhVar2.d.add(djVar3);
            }
            ((com.google.android.libraries.geo.mapcore.internal.model.a) cfVarX).i = (dh) dgVar.t();
        }
        bh bhVarS10 = bi.s(com.google.android.libraries.navigation.internal.afi.b.b);
        bVar.h(bhVarS10);
        if (bVar.w.n(bhVarS10.d)) {
            bh bhVarS11 = bi.s(com.google.android.libraries.navigation.internal.afi.b.b);
            bVar.h(bhVarS11);
            Object objK6 = bVar.w.k(bhVarS11.d);
            com.google.android.libraries.navigation.internal.aec.b bVar2 = ((com.google.android.libraries.navigation.internal.afi.b) (objK6 == null ? bhVarS11.b : bhVarS11.c(objK6))).d;
            if (bVar2 == null) {
                bVar2 = com.google.android.libraries.navigation.internal.aec.b.a;
            }
            ((com.google.android.libraries.geo.mapcore.internal.model.a) cfVarX).o = bVar2;
        }
        bh bhVarS12 = bi.s(com.google.android.libraries.navigation.internal.aca.b.b);
        bVar.h(bhVarS12);
        if (bVar.w.n(bhVarS12.d)) {
            bh bhVarS13 = bi.s(com.google.android.libraries.navigation.internal.aca.b.b);
            bVar.h(bhVarS13);
            Object objK7 = bVar.w.k(bhVarS13.d);
            cfVarX.b((fy) ((com.google.android.libraries.navigation.internal.aca.b) (objK7 == null ? bhVarS13.b : bhVarS13.c(objK7))).c.stream().map(new Function() { // from class: com.google.android.libraries.navigation.internal.rk.a
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    com.google.android.libraries.navigation.internal.aax.b bVar3 = (com.google.android.libraries.navigation.internal.aax.b) obj;
                    if (bVar3 == null) {
                        return null;
                    }
                    return new j(bVar3.c, bVar3.d);
                }
            }).collect(br.b));
        }
        bh bhVarS14 = bi.s(com.google.android.libraries.navigation.internal.aah.d.b);
        bVar.h(bhVarS14);
        if (bVar.w.n(bhVarS14.d)) {
            bh bhVarS15 = bi.s(com.google.android.libraries.navigation.internal.aah.d.b);
            bVar.h(bhVarS15);
            Object objK8 = bVar.w.k(bhVarS15.d);
            com.google.android.libraries.navigation.internal.aah.d dVar2 = (com.google.android.libraries.navigation.internal.aah.d) (objK8 == null ? bhVarS15.b : bhVarS15.c(objK8));
            com.google.android.libraries.navigation.internal.aah.e eVar = (com.google.android.libraries.navigation.internal.aah.e) com.google.android.libraries.navigation.internal.aah.j.a.q();
            int i = com.google.android.libraries.navigation.internal.aah.g.d;
            if (!eVar.b.H()) {
                eVar.v();
            }
            com.google.android.libraries.navigation.internal.aah.j jVar = (com.google.android.libraries.navigation.internal.aah.j) eVar.b;
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            jVar.d = i2;
            jVar.b |= 2;
            int i3 = i.f;
            if (!eVar.b.H()) {
                eVar.v();
            }
            com.google.android.libraries.navigation.internal.aah.j jVar2 = (com.google.android.libraries.navigation.internal.aah.j) eVar.b;
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            }
            jVar2.c = i4;
            jVar2.b |= 1;
            final com.google.android.libraries.navigation.internal.aah.j jVar3 = (com.google.android.libraries.navigation.internal.aah.j) eVar.t();
            ev evVar = (ev) dVar2.c.stream().filter(new Predicate() { // from class: com.google.android.libraries.navigation.internal.rk.b
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    com.google.android.libraries.navigation.internal.aah.j jVar4 = ((com.google.android.libraries.navigation.internal.aah.c) obj).c;
                    if (jVar4 == null) {
                        jVar4 = com.google.android.libraries.navigation.internal.aah.j.a;
                    }
                    return jVar4.equals(jVar3);
                }
            }).findFirst().map(new Function() { // from class: com.google.android.libraries.navigation.internal.rk.c
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ev.o(((com.google.android.libraries.navigation.internal.aah.c) obj).d);
                }
            }).orElse(null);
            if (evVar != null) {
                ((com.google.android.libraries.geo.mapcore.internal.model.a) cfVarX).c = evVar;
            }
            com.google.android.libraries.navigation.internal.aah.e eVar2 = (com.google.android.libraries.navigation.internal.aah.e) com.google.android.libraries.navigation.internal.aah.j.a.q();
            int i5 = com.google.android.libraries.navigation.internal.aah.g.b;
            if (!eVar2.b.H()) {
                eVar2.v();
            }
            com.google.android.libraries.navigation.internal.aah.j jVar4 = (com.google.android.libraries.navigation.internal.aah.j) eVar2.b;
            int i6 = i5 - 1;
            if (i5 == 0) {
                throw null;
            }
            jVar4.d = i6;
            jVar4.b |= 2;
            int i7 = i.b;
            if (!eVar2.b.H()) {
                eVar2.v();
            }
            com.google.android.libraries.navigation.internal.aah.j jVar5 = (com.google.android.libraries.navigation.internal.aah.j) eVar2.b;
            int i8 = i7 - 1;
            if (i7 == 0) {
                throw null;
            }
            jVar5.c = i8;
            jVar5.b |= 1;
            final com.google.android.libraries.navigation.internal.aah.j jVar6 = (com.google.android.libraries.navigation.internal.aah.j) eVar2.t();
            ev evVar2 = (ev) dVar2.c.stream().filter(new Predicate() { // from class: com.google.android.libraries.navigation.internal.rk.d
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    com.google.android.libraries.navigation.internal.aah.j jVar7 = ((com.google.android.libraries.navigation.internal.aah.c) obj).c;
                    if (jVar7 == null) {
                        jVar7 = com.google.android.libraries.navigation.internal.aah.j.a;
                    }
                    return jVar7.equals(jVar6);
                }
            }).findFirst().map(new Function() { // from class: com.google.android.libraries.navigation.internal.rk.e
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ev.o(((com.google.android.libraries.navigation.internal.aah.c) obj).d);
                }
            }).orElse(null);
            if (evVar2 != null) {
                ((com.google.android.libraries.geo.mapcore.internal.model.a) cfVarX).d = evVar2;
            }
        }
        bh bhVarS16 = bi.s(com.google.android.libraries.navigation.internal.aep.h.b);
        bVar.h(bhVarS16);
        if (bVar.w.n(bhVarS16.d)) {
            bh bhVarS17 = bi.s(com.google.android.libraries.navigation.internal.aep.h.b);
            bVar.h(bhVarS17);
            Object objK9 = bVar.w.k(bhVarS17.d);
            com.google.android.libraries.navigation.internal.aep.h hVar = (com.google.android.libraries.navigation.internal.aep.h) (objK9 == null ? bhVarS17.b : bhVarS17.c(objK9));
            if ((hVar.c & 2) != 0) {
                com.google.android.libraries.navigation.internal.aas.b bVar3 = hVar.e;
                if (bVar3 == null) {
                    bVar3 = com.google.android.libraries.navigation.internal.aas.b.a;
                }
                ((com.google.android.libraries.geo.mapcore.internal.model.a) cfVarX).e = bVar3;
            }
            if ((hVar.c & 1) != 0) {
                ((com.google.android.libraries.geo.mapcore.internal.model.a) cfVarX).f = Boolean.valueOf(hVar.d);
            }
            if ((hVar.c & 4) != 0) {
                com.google.android.libraries.navigation.internal.aep.g gVar = hVar.f;
                if (gVar == null) {
                    gVar = com.google.android.libraries.navigation.internal.aep.g.a;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it2 = gVar.b.iterator();
                while (it2.hasNext()) {
                    arrayList.add(Long.valueOf(((com.google.android.libraries.navigation.internal.aep.f) it2.next()).c));
                }
                if (!arrayList.isEmpty()) {
                    ((com.google.android.libraries.geo.mapcore.internal.model.a) cfVarX).g = ev.o(arrayList);
                }
            }
            if ((hVar.c & 8) != 0) {
                com.google.android.libraries.navigation.internal.aaj.b bVar4 = hVar.g;
                if (bVar4 == null) {
                    bVar4 = com.google.android.libraries.navigation.internal.aaj.b.a;
                }
                ((com.google.android.libraries.geo.mapcore.internal.model.a) cfVarX).h = bVar4;
            }
            if ((hVar.c & 16) != 0) {
                com.google.android.libraries.navigation.internal.aep.c cVar = hVar.h;
                if (cVar == null) {
                    cVar = com.google.android.libraries.navigation.internal.aep.c.a;
                }
                ((com.google.android.libraries.geo.mapcore.internal.model.a) cfVarX).p = cVar;
            }
        }
        bh bhVarS18 = bi.s(com.google.android.libraries.navigation.internal.acz.b.b);
        bVar.h(bhVarS18);
        if (bVar.w.n(bhVarS18.d)) {
            bh bhVarS19 = bi.s(com.google.android.libraries.navigation.internal.acz.b.b);
            bVar.h(bhVarS19);
            Object objK10 = bVar.w.k(bhVarS19.d);
            ((com.google.android.libraries.geo.mapcore.internal.model.a) cfVarX).f = Boolean.valueOf(((com.google.android.libraries.navigation.internal.acz.b) (objK10 == null ? bhVarS19.b : bhVarS19.c(objK10))).e);
        }
        return cfVarX.a();
    }

    public static final boolean c(an anVar) {
        int iOrdinal = anVar.ordinal();
        if (iOrdinal == 29 || iOrdinal == 30 || iOrdinal == 36 || iOrdinal == 42 || iOrdinal == 58 || iOrdinal == 44 || iOrdinal == 45) {
            return true;
        }
        switch (iOrdinal) {
            case 54:
            case 55:
            case 56:
                return true;
            default:
                return false;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ou.b
    public final void a() {
        an anVar = this.c;
        if (anVar == null) {
            return;
        }
        com.google.android.libraries.navigation.internal.ob.h hVarA = com.google.android.libraries.navigation.internal.ob.h.a(anVar);
        if (hVarA != null) {
            ((k) this.a.a()).x(hVarA, false);
        }
        if (c(anVar)) {
            ((k) this.a.a()).b().j(anVar, false);
        }
        if (anVar == an.GMM_INDOOR) {
            ((k) this.a.a()).b().e();
        }
        ((k) this.a.a()).t("OverlayId:" + ((com.google.android.libraries.navigation.internal.ou.a) this.b).a);
        this.c = null;
    }
}
