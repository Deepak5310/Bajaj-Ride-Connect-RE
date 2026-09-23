package com.google.android.libraries.navigation.internal.tt;

import com.google.android.libraries.navigation.internal.aap.r;
import com.google.android.libraries.navigation.internal.adq.ai;
import com.google.android.libraries.navigation.internal.adq.aj;
import com.google.android.libraries.navigation.internal.adr.Cdo;
import com.google.android.libraries.navigation.internal.adr.ag;
import com.google.android.libraries.navigation.internal.adr.ah;
import com.google.android.libraries.navigation.internal.adr.bk;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.eu;
import com.google.android.libraries.navigation.internal.adr.ex;
import com.google.android.libraries.navigation.internal.adr.ez;
import com.google.android.libraries.navigation.internal.adr.fb;
import com.google.android.libraries.navigation.internal.adr.fh;
import com.google.android.libraries.navigation.internal.adr.ft;
import com.google.android.libraries.navigation.internal.adr.gn;
import com.google.android.libraries.navigation.internal.adr.n;
import com.google.android.libraries.navigation.internal.ady.k;
import com.google.android.libraries.navigation.internal.ady.u;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.afl.nz;
import com.google.android.libraries.navigation.internal.afl.oa;
import com.google.android.libraries.navigation.internal.br.s;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.g;
import com.google.android.libraries.navigation.internal.zy.p;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class d implements Serializable {
    public static c G() {
        a aVar = new a();
        aVar.p(false);
        aVar.o(false);
        aVar.q(true);
        aVar.r(-1.0f);
        return aVar;
    }

    public static d H(oa oaVar) {
        c cVarG = G();
        cVarG.n(oaVar.c);
        String str = oaVar.f323n;
        a aVar = (a) cVarG;
        aVar.l = str;
        cVarG.m(str);
        aVar.a = oaVar.f323n;
        aVar.b = oaVar.i;
        aVar.c = oaVar.j;
        aVar.d = oaVar.o;
        aVar.e = oaVar.m;
        cVarG.q(true);
        ft ftVar = oaVar.p;
        if (ftVar == null) {
            ftVar = ft.a;
        }
        c cVarW = cVarG.w(ftVar);
        com.google.android.libraries.navigation.internal.aap.d dVar = oaVar.u;
        if (dVar == null) {
            dVar = com.google.android.libraries.navigation.internal.aap.d.a;
        }
        c cVarV = cVarW.v(dVar);
        com.google.android.libraries.navigation.internal.aap.d dVar2 = oaVar.v;
        if (dVar2 == null) {
            dVar2 = com.google.android.libraries.navigation.internal.aap.d.a;
        }
        c cVarX = cVarV.x(dVar2);
        com.google.android.libraries.navigation.internal.aap.d dVar3 = oaVar.w;
        if (dVar3 == null) {
            dVar3 = com.google.android.libraries.navigation.internal.aap.d.a;
        }
        if (dVar3 != null) {
            cVarX = cVarX.i(new com.google.android.libraries.navigation.internal.hc.a(dVar3));
        }
        c cVarD = cVarX.d(oaVar.k);
        int i = oaVar.b;
        if ((2097152 & i) != 0 || (i & 4194304) != 0) {
            cVarD.p(true);
            a aVar2 = (a) cVarD;
            aVar2.k = Long.valueOf(oaVar.y);
            aVar2.j = Long.valueOf(oaVar.x);
        }
        if ((oaVar.b & 16384) != 0) {
            ai aiVar = (ai) aj.a.q();
            com.google.android.libraries.navigation.internal.aat.b bVar = oaVar.q;
            if (bVar == null) {
                bVar = com.google.android.libraries.navigation.internal.aat.b.a;
            }
            String str2 = bVar.c;
            if (!aiVar.b.H()) {
                aiVar.v();
            }
            aj ajVar = (aj) aiVar.b;
            str2.getClass();
            ajVar.b |= 2;
            ajVar.d = str2;
            com.google.android.libraries.navigation.internal.aat.b bVar2 = oaVar.q;
            if (bVar2 == null) {
                bVar2 = com.google.android.libraries.navigation.internal.aat.b.a;
            }
            String str3 = bVar2.b;
            if (!aiVar.b.H()) {
                aiVar.v();
            }
            aj ajVar2 = (aj) aiVar.b;
            str3.getClass();
            ajVar2.b = 1 | ajVar2.b;
            ajVar2.c = str3;
            cVarD.y((aj) aiVar.t());
        }
        g gVar = e.c.b;
        nz nzVarB = nz.b(oaVar.d);
        if (nzVarB == null) {
            nzVarB = nz.INCIDENT_OTHER;
        }
        Cdo cdo = (Cdo) gVar.get(nzVarB);
        if (cdo != null) {
            ((a) cVarD).f = cdo;
        }
        float f = oaVar.t;
        if (f > 0.0f) {
            cVarD.r(f);
        }
        if ((oaVar.b & 16) != 0) {
            ((a) cVarD).g = Integer.valueOf(oaVar.g);
        }
        return cVarD.l();
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00e3 A[EDGE_INSN: B:57:0x00e3->B:58:0x00e4 BREAK  A[LOOP:0: B:36:0x0091->B:202:0x0091]] */
    public static d I(el elVar) {
        String strConcat;
        c cVarG = G();
        long jB = 1;
        if ((elVar.c == 22 ? (fh) elVar.d : fh.a).j.size() > 0) {
            try {
                jB = p.b((String) (elVar.c == 22 ? (fh) elVar.d : fh.a).j.get(0));
            } catch (NumberFormatException unused) {
            }
        }
        cVarG.n(jB);
        gn gnVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).o;
        if (gnVar == null) {
            gnVar = gn.a;
        }
        com.google.android.libraries.navigation.internal.adr.aj ajVar = gnVar.d;
        if (ajVar == null) {
            ajVar = com.google.android.libraries.navigation.internal.adr.aj.a;
        }
        a aVar = (a) cVarG;
        aVar.l = ajVar.c;
        cVarG.m(s.b(elVar.f221n));
        aVar.a = s.b(elVar.o);
        aVar.b = s.b(elVar.p);
        aj ajVar2 = null;
        if ((elVar.b & 131072) != 0) {
            ah ahVar = elVar.w;
            if (ahVar == null) {
                ahVar = ah.a;
            }
            if (ahVar.e.size() == 0) {
                strConcat = null;
                break;
            }
            ah ahVar2 = elVar.w;
            if (ahVar2 == null) {
                ahVar2 = ah.a;
            }
            Iterator it2 = ahVar2.e.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    strConcat = null;
                    break;
                }
                ag agVar = (ag) it2.next();
                com.google.android.libraries.navigation.internal.ady.s sVar = com.google.android.libraries.navigation.internal.ady.s.SVG;
                com.google.android.libraries.navigation.internal.ady.s sVarB = com.google.android.libraries.navigation.internal.ady.s.b(agVar.d);
                if (sVarB == null) {
                    sVarB = com.google.android.libraries.navigation.internal.ady.s.PNG;
                }
                if (sVar.equals(sVarB)) {
                    int iA = u.a(agVar.e);
                    if (iA == 0) {
                        iA = u.a;
                    }
                    if (iA == u.a && (agVar.b & 1) != 0) {
                        strConcat = agVar.c;
                        if (!strConcat.isEmpty()) {
                            if (!strConcat.startsWith("http:") && !strConcat.startsWith("https:")) {
                                strConcat = "https:".concat(String.valueOf(strConcat));
                                break;
                            }
                            break;
                            break;
                        }
                    }
                }
            }
        } else {
            strConcat = null;
            break;
        }
        aVar.e = strConcat;
        Cdo cdoB = Cdo.b(elVar.u);
        if (cdoB == null) {
            cdoB = Cdo.INCIDENT_OTHER;
        }
        aVar.f = cdoB;
        ft ftVar = elVar.y;
        if (ftVar == null) {
            ftVar = ft.a;
        }
        c cVarW = cVarG.w(ftVar);
        com.google.android.libraries.navigation.internal.aap.d dVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).f;
        if (dVar == null) {
            dVar = com.google.android.libraries.navigation.internal.aap.d.a;
        }
        c cVarV = cVarW.v(dVar);
        com.google.android.libraries.navigation.internal.aap.d dVar2 = (elVar.c == 22 ? (fh) elVar.d : fh.a).h;
        if (dVar2 == null) {
            dVar2 = com.google.android.libraries.navigation.internal.aap.d.a;
        }
        c cVarX = cVarV.x(dVar2);
        com.google.android.libraries.navigation.internal.aap.d dVar3 = (elVar.c == 22 ? (fh) elVar.d : fh.a).d;
        if (dVar3 == null) {
            dVar3 = com.google.android.libraries.navigation.internal.aap.d.a;
        }
        if (dVar3 != null) {
            cVarX = cVarX.g(new com.google.android.libraries.navigation.internal.hc.a(dVar3));
        }
        ez ezVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).f222n;
        if (ezVar == null) {
            ezVar = ez.a;
        }
        c cVarC = cVarX.c(ezVar.b);
        if ((elVar.b & 128) != 0 && (ajVar2 = elVar.k) == null) {
            ajVar2 = aj.a;
        }
        c cVarB = cVarC.y(ajVar2).b((elVar.c == 22 ? (fh) elVar.d : fh.a).c);
        a aVar2 = (a) cVarB;
        aVar2.h = elVar.e;
        if (((elVar.c == 22 ? (fh) elVar.d : fh.a).b & 256) != 0) {
            ex exVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).i;
            if (exVar == null) {
                exVar = ex.a;
            }
            aVar2.g = Integer.valueOf(exVar.c);
            bk bkVar = (bk) bm.a.q();
            ex exVar2 = (elVar.c == 22 ? (fh) elVar.d : fh.a).i;
            if (exVar2 == null) {
                exVar2 = ex.a;
            }
            int i = exVar2.c;
            if (!bkVar.b.H()) {
                bkVar.v();
            }
            bm bmVar = (bm) bkVar.b;
            bmVar.b |= 1;
            bmVar.c = i;
            bm bmVar2 = (elVar.c == 22 ? (fh) elVar.d : fh.a).e;
            if (bmVar2 == null) {
                bmVar2 = bm.a;
            }
            bm.a aVarB = bm.a.b(bmVar2.d);
            if (aVarB == null) {
                aVarB = bm.a.REGIONAL;
            }
            if (!bkVar.b.H()) {
                bkVar.v();
            }
            bm bmVar3 = (bm) bkVar.b;
            bmVar3.d = aVarB.e;
            bmVar3.b |= 4;
            bm bmVar4 = (bm) bkVar.t();
            if (bmVar4 != null) {
                cVarB.t(new com.google.android.libraries.navigation.internal.hc.a(bmVar4));
            }
        }
        Cdo cdo = Cdo.INCIDENT_SPEED_LIMIT;
        Cdo cdoB2 = Cdo.b(elVar.u);
        if (cdoB2 == null) {
            cdoB2 = Cdo.INCIDENT_OTHER;
        }
        cVarB.q(!cdo.equals(cdoB2));
        fh fhVar = elVar.c == 22 ? (fh) elVar.d : fh.a;
        if ((fhVar.b & 2048) != 0) {
            fb fbVar = fhVar.m;
            if (fbVar == null) {
                fbVar = fb.a;
            }
            if ((fbVar.b & 16) != 0) {
                aVar2.i = fbVar.g;
            }
            cVarB.p(true);
            r rVar = fbVar.d;
            if (rVar == null) {
                rVar = r.a;
            }
            ((a) (rVar == null ? cVarB : cVarB.h(new com.google.android.libraries.navigation.internal.hc.a(rVar))).a(Long.valueOf(fbVar.c))).k = Long.valueOf(fbVar.e);
        }
        if ((fhVar.b & 16384) != 0) {
            n nVar = fhVar.p;
            if (nVar == null) {
                nVar = n.a;
            }
            if (nVar != null) {
                cVarB.s(new com.google.android.libraries.navigation.internal.hc.a(nVar));
            }
        }
        if ((fhVar.b & 32768) != 0) {
            int iB = eu.b(fhVar.q);
            if (iB == 0) {
                iB = eu.a;
            }
            aVar2.m = iB;
        }
        if (fhVar.r.size() > 0) {
            cVarB.u((ev) com.google.android.libraries.navigation.internal.hc.a.c(ev.o(fhVar.r), new eq()));
        }
        if ((elVar.c == 22 ? (fh) elVar.d : fh.a).g > 0.0f) {
            cVarB.r((elVar.c == 22 ? (fh) elVar.d : fh.a).g);
        }
        return cVarB.l();
    }

    public abstract String A();

    public abstract String B();

    public abstract boolean C();

    public abstract boolean D();

    public abstract boolean E();

    public abstract int F();

    public final com.google.android.libraries.navigation.internal.aap.d J() {
        com.google.android.libraries.navigation.internal.hc.a aVarJ = j();
        return aVarJ == null ? com.google.android.libraries.navigation.internal.aap.d.a : (com.google.android.libraries.navigation.internal.aap.d) aVarJ.d((dg) com.google.android.libraries.navigation.internal.aap.d.a.aH(7, null), com.google.android.libraries.navigation.internal.aap.d.a);
    }

    public final bm K() {
        return (bm) com.google.android.libraries.navigation.internal.hc.a.e(g(), (dg) bm.a.aH(7, null), bm.a);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.libraries.navigation.internal.yz.ek, java.util.List] */
    public final List L() {
        return com.google.android.libraries.navigation.internal.hc.a.b(l(), new eq(), (dg) k.a.aH(7, null), k.a);
    }

    public abstract float a();

    public abstract long b();

    public abstract com.google.android.libraries.navigation.internal.hc.a c();

    public abstract com.google.android.libraries.navigation.internal.hc.a d();

    public abstract com.google.android.libraries.navigation.internal.hc.a e();

    public abstract com.google.android.libraries.navigation.internal.hc.a f();

    public abstract com.google.android.libraries.navigation.internal.hc.a g();

    public abstract com.google.android.libraries.navigation.internal.hc.a h();

    public abstract com.google.android.libraries.navigation.internal.hc.a i();

    public abstract com.google.android.libraries.navigation.internal.hc.a j();

    public abstract com.google.android.libraries.navigation.internal.hc.a k();

    public abstract ev l();

    public abstract Cdo m();

    public abstract Integer n();

    public abstract Long o();

    public abstract Long p();

    public abstract String q();

    public abstract String r();

    public abstract String s();

    public abstract String t();

    public abstract String u();

    public abstract String v();

    public abstract String w();

    public abstract String x();

    public abstract String y();

    public abstract String z();
}
