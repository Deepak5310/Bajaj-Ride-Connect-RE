package com.google.android.libraries.navigation.internal.bm;

import android.graphics.Rect;
import com.google.android.libraries.navigation.internal.adg.jr;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.fg;
import com.google.android.libraries.navigation.internal.adr.fh;
import com.google.android.libraries.navigation.internal.ck.cd;
import com.google.android.libraries.navigation.internal.po.dh;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fw;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.ma;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ak {
    public final com.google.android.libraries.navigation.internal.bo.e a;
    public final ev b;
    public final com.google.android.libraries.navigation.internal.bo.z c;
    public final ev d;

    public ak(com.google.android.libraries.navigation.internal.bo.e eVar, ev evVar, com.google.android.libraries.navigation.internal.bo.z zVar, ev evVar2) {
        this.a = eVar;
        this.b = evVar;
        this.c = zVar;
        this.d = evVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        com.google.android.libraries.navigation.internal.bo.e eVar = this.a;
        eVar.c();
        final com.google.android.libraries.navigation.internal.bo.t tVar = eVar.c;
        if (tVar != null) {
            tVar.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.bo.p
                @Override // java.lang.Runnable
                public final void run() {
                    tVar.a();
                }
            });
        }
        eVar.f = false;
        ev evVar = this.b;
        int size = evVar.size();
        for (int i = 0; i < size; i++) {
            com.google.android.libraries.navigation.internal.bo.ao aoVar = (com.google.android.libraries.navigation.internal.bo.ao) evVar.get(i);
            aoVar.g();
            if (aoVar.C != null) {
                ev evVar2 = aoVar.C;
                int i2 = ((lv) evVar2).c;
                for (int i3 = 0; i3 < i2; i3++) {
                    aoVar.v.p((com.google.android.libraries.navigation.internal.ot.k) evVar2.get(i3));
                }
                aoVar.C = null;
            }
            aoVar.a.c();
        }
        com.google.android.libraries.navigation.internal.bo.z zVar = this.c;
        if (zVar != null) {
            zVar.b = ma.b;
            zVar.a();
            com.google.android.libraries.navigation.internal.ot.k kVar = zVar.e;
            zVar.e = null;
            if (kVar != null) {
                zVar.f.p(kVar);
            }
        }
        ev evVar3 = this.d;
        int size2 = evVar3.size();
        for (int i4 = 0; i4 < size2; i4++) {
            ((com.google.android.libraries.navigation.internal.bo.l) evVar3.get(i4)).a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        com.google.android.libraries.navigation.internal.bo.e eVar = this.a;
        com.google.android.libraries.navigation.internal.bo.k kVar = eVar.e;
        if (kVar != null) {
            for (com.google.android.libraries.navigation.internal.bo.j jVar : kVar.d) {
                kVar.a.d().e(jVar.a);
                kVar.a.d().e(jVar.b);
            }
            com.google.android.libraries.navigation.internal.bo.k kVar2 = eVar.e;
            for (com.google.android.libraries.navigation.internal.bo.j jVar2 : kVar2.d) {
                kVar2.a.d().c(jVar2.a);
                kVar2.a.d().c(jVar2.b);
            }
            kVar2.a.e().j(kVar2.b);
            kVar2.a.e().j(kVar2.c);
        }
        eVar.b = true;
        synchronized (eVar.d) {
            eVar.b();
            com.google.android.libraries.navigation.internal.cl.av avVar = eVar.g;
            if (avVar != null) {
                avVar.h();
                eVar.g = null;
            }
        }
        ev evVar = this.b;
        int size = evVar.size();
        for (int i = 0; i < size; i++) {
            ((com.google.android.libraries.navigation.internal.bo.ao) evVar.get(i)).f();
        }
        com.google.android.libraries.navigation.internal.bo.z zVar = this.c;
        if (zVar != null) {
            zVar.b = ma.b;
            zVar.a();
            zVar.c.d();
            ev evVar2 = zVar.l;
            int i2 = ((lv) evVar2).c;
            for (int i3 = 0; i3 < i2; i3++) {
                com.google.android.libraries.navigation.internal.ol.p pVar = (com.google.android.libraries.navigation.internal.ol.p) evVar2.get(i3);
                zVar.h.e(pVar);
                zVar.h.c(pVar);
            }
            zVar.l = lv.a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        com.google.android.libraries.navigation.internal.cl.u uVar;
        ev evVarO;
        com.google.android.libraries.navigation.internal.bo.e eVar = this.a;
        final com.google.android.libraries.navigation.internal.bo.t tVar = eVar.c;
        if (tVar != null) {
            tVar.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.bo.r
                @Override // java.lang.Runnable
                public final void run() {
                    t tVar2 = tVar;
                    tVar2.a();
                    while (tVar2.e.size() < 3 && tVar2.d()) {
                    }
                    if (tVar2.e()) {
                        tVar2.c();
                    }
                }
            });
        }
        eVar.f = true;
        synchronized (eVar.d) {
            eVar.c();
            eVar.a();
        }
        ev evVar = this.b;
        int size = evVar.size();
        for (int i = 0; i < size; i++) {
            com.google.android.libraries.navigation.internal.bo.ao aoVar = (com.google.android.libraries.navigation.internal.bo.ao) evVar.get(i);
            aoVar.e();
            int i2 = ev.d;
            eq eqVar = new eq();
            boolean z = aoVar.d;
            com.google.android.libraries.navigation.internal.ot.k kVar = aoVar.f348n;
            if (kVar != null) {
                eqVar.h(kVar);
            }
            aoVar.C = eqVar.g();
            ev evVar2 = aoVar.C;
            int i3 = ((lv) evVar2).c;
            for (int i4 = 0; i4 < i3; i4++) {
                aoVar.v.k((com.google.android.libraries.navigation.internal.ot.k) evVar2.get(i4));
            }
            cd cdVar = aoVar.a;
            synchronized (cdVar) {
                evVarO = ev.o(cdVar.c);
                cdVar.c.clear();
            }
            int size2 = evVarO.size();
            for (int i5 = 0; i5 < size2; i5++) {
                ((com.google.android.libraries.navigation.internal.ot.q) evVarO.get(i5)).d();
            }
            synchronized (cdVar) {
                cdVar.d.addAll(evVarO);
            }
        }
        com.google.android.libraries.navigation.internal.bo.z zVar = this.c;
        if (zVar != null) {
            ez ezVar = new ez();
            List<el> list = zVar.m;
            int size3 = list.size();
            int i6 = 0;
            for (el elVar : list) {
                if (i6 == size3) {
                    break;
                }
                fg fgVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).k;
                if (fgVar == null) {
                    fgVar = fg.a;
                }
                com.google.android.libraries.navigation.internal.oe.ad adVarM = com.google.android.libraries.navigation.internal.oe.ad.m(fgVar.c == 1 ? (com.google.android.libraries.navigation.internal.adr.ab) fgVar.d : com.google.android.libraries.navigation.internal.adr.ab.a);
                if (zVar.c(elVar)) {
                    ezVar.f(elVar, new com.google.android.libraries.navigation.internal.cl.u(adVarM));
                    i6++;
                }
            }
            zVar.b = ezVar.d();
            fw fwVar = new fw();
            nn nnVarListIterator = zVar.b.keySet().listIterator();
            while (nnVarListIterator.hasNext()) {
                fwVar.k(com.google.android.libraries.navigation.internal.br.l.c((el) nnVarListIterator.next()));
            }
            com.google.android.libraries.navigation.internal.ot.k kVarC = com.google.android.libraries.navigation.internal.ot.k.c(com.google.android.libraries.navigation.internal.cl.u.a(fwVar.i()));
            zVar.f.k(kVarC);
            zVar.e = kVarC;
            zVar.a();
            int i7 = ev.d;
            eq eqVar2 = new eq();
            for (el elVar2 : zVar.m) {
                if (zVar.c(elVar2) && (uVar = (com.google.android.libraries.navigation.internal.cl.u) zVar.b.get(elVar2)) != null) {
                    com.google.android.libraries.navigation.internal.cl.az azVar = new com.google.android.libraries.navigation.internal.cl.az(!zVar.o.B().c, uVar, lv.a, new com.google.android.libraries.navigation.internal.cl.aq(new Rect(), lv.a), com.google.android.libraries.navigation.internal.cl.p.a);
                    fg fgVar2 = (elVar2.c == 22 ? (fh) elVar2.d : fh.a).k;
                    if (fgVar2 == null) {
                        fgVar2 = fg.a;
                    }
                    int iA = com.google.android.libraries.navigation.internal.cl.t.a(elVar2, com.google.android.libraries.navigation.internal.bq.e.b(fgVar2, zVar.i).c, false);
                    if (zVar.q) {
                        com.google.android.libraries.navigation.internal.oj.c cVarB = zVar.c.b();
                        if (cVarB != null && zVar.b(cVarB, elVar2)) {
                            com.google.android.libraries.navigation.internal.cs.a aVar = new com.google.android.libraries.navigation.internal.cs.a() { // from class: com.google.android.libraries.navigation.internal.bo.u
                            };
                            com.google.android.libraries.navigation.internal.qk.u uVarJ = com.google.android.libraries.navigation.internal.qk.v.j();
                            uVarJ.d(((com.google.android.libraries.navigation.internal.oj.b) cVarB).e());
                            uVarJ.f(azVar);
                            uVarJ.i(com.google.android.libraries.navigation.internal.qk.t.JAMCIDENTS);
                            uVarJ.g(iA);
                            uVarJ.h(com.google.android.libraries.navigation.internal.cl.aj.b);
                            uVarJ.e((com.google.android.libraries.navigation.internal.adg.b) com.google.android.libraries.navigation.internal.cl.aj.b.get(0));
                            com.google.android.libraries.navigation.internal.qk.v vVarJ = uVarJ.j();
                            com.google.android.libraries.navigation.internal.qk.w wVar = zVar.g;
                            com.google.android.libraries.navigation.internal.yx.ar.q(wVar);
                            com.google.android.libraries.navigation.internal.cr.f fVar = zVar.r;
                            com.google.android.libraries.navigation.internal.yx.ar.q(fVar);
                            eqVar2.h(new com.google.android.libraries.navigation.internal.qk.aj(wVar, vVarJ, fVar, aVar));
                        }
                    } else {
                        com.google.android.libraries.navigation.internal.oj.c cVarC = zVar.c.c();
                        if (cVarC != null && zVar.b(cVarC, elVar2)) {
                            com.google.android.libraries.navigation.internal.po.aa aaVarN = ((dh) zVar.j).n(((com.google.android.libraries.navigation.internal.oj.a) cVarC).e(), jr.WORLD_ENCODING_LAT_LNG_E7);
                            aaVarN.k(new com.google.android.libraries.navigation.internal.bo.w(zVar, elVar2, aaVarN));
                            com.google.android.libraries.navigation.internal.qk.g gVarG = com.google.android.libraries.navigation.internal.qk.h.g();
                            gVarG.b(aaVarN);
                            gVarG.c(azVar);
                            gVarG.f(com.google.android.libraries.navigation.internal.qk.t.JAMCIDENTS);
                            gVarG.d(iA);
                            gVarG.e(com.google.android.libraries.navigation.internal.cl.aj.b);
                            eqVar2.h(new com.google.android.libraries.navigation.internal.qk.ai(zVar.k, gVarG.g()));
                        }
                    }
                }
            }
            zVar.d = eqVar2.g();
            ev evVar3 = zVar.d;
            int i8 = ((lv) evVar3).c;
            for (int i9 = 0; i9 < i8; i9++) {
                ((com.google.android.libraries.navigation.internal.qk.ak) evVar3.get(i9)).f();
            }
        }
        ev evVar4 = this.d;
        int size4 = evVar4.size();
        for (int i10 = 0; i10 < size4; i10++) {
            ((com.google.android.libraries.navigation.internal.bo.l) evVar4.get(i10)).b();
        }
    }
}
