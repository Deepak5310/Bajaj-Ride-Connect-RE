package com.google.android.libraries.navigation.internal.bt;

import com.google.android.libraries.navigation.internal.adg.ex;
import com.google.android.libraries.navigation.internal.adq.z;
import com.google.android.libraries.navigation.internal.adr.jk;
import com.google.android.libraries.navigation.internal.adr.ll;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.bp.av;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.bp.bt;
import com.google.android.libraries.navigation.internal.bp.cf;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.bp.cm;
import com.google.android.libraries.navigation.internal.ob.p;
import com.google.android.libraries.navigation.internal.ob.u;
import com.google.android.libraries.navigation.internal.oe.r;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.yz.lv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class d {
    private static void J(eq eqVar, jk jkVar) {
        if ((jkVar.b & 128) != 0) {
            z zVar = jkVar.d;
            if (zVar == null) {
                zVar = z.a;
            }
            double d = zVar.c;
            z zVar2 = jkVar.d;
            if (zVar2 == null) {
                zVar2 = z.a;
            }
            eqVar.h(new r(d, zVar2.d));
        }
    }

    public abstract void A(boolean z);

    public abstract void B(boolean z);

    public abstract void C(boolean z);

    public abstract void D(boolean z);

    public abstract void E(com.google.android.libraries.navigation.internal.bn.f fVar);

    protected abstract void F(ev evVar);

    public abstract void G(boolean z);

    public abstract void H();

    /* JADX WARN: Multi-variable type inference failed */
    public final h I() {
        ev evVarG;
        com.google.android.libraries.navigation.internal.ob.r rVarJ;
        ev evVarG2;
        ev evVarG3 = g();
        u uVarE = e();
        e eVarC = c();
        an anVarF = f();
        if (eVarC == e.NONE) {
            evVarG = lv.a;
        } else if (evVarG3.isEmpty()) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.h(com.google.android.libraries.navigation.internal.zb.an.SMALL)).F(96)).s("b/167643823: Cannot provide empty destinations with pinDisplayMode %s", eVarC);
            evVarG = lv.a;
        } else {
            int iOrdinal = eVarC.ordinal();
            if (iOrdinal == 1) {
                evVarG3 = ev.q((cm) evVarG3.get(0));
            } else if (iOrdinal == 2) {
                evVarG3 = ev.q((cm) gs.d(evVarG3));
            } else if (iOrdinal == 3) {
                if (anVarF.g()) {
                    lv lvVar = (lv) evVarG3;
                    if (((Integer) anVarF.c()).intValue() >= lvVar.c || ((Integer) anVarF.c()).intValue() < 0) {
                        ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.h(com.google.android.libraries.navigation.internal.zb.an.SMALL)).F(94)).w("pinDisplayDestinationIndex %s is out of bound with destinations list size %s.", anVarF.c(), lvVar.c);
                        evVarG = lv.a;
                    } else {
                        evVarG3 = ev.q((cm) evVarG3.get(((Integer) anVarF.c()).intValue()));
                    }
                } else {
                    ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.h(com.google.android.libraries.navigation.internal.zb.an.SMALL)).F(95)).p("pinDisplayDestinationIndex is not available");
                    evVarG = lv.a;
                }
            }
            eq eqVar = new eq();
            boolean z = uVarE == u.NORMAL && ((lv) evVarG3).c > 1;
            for (int i = 0; i < ((lv) evVarG3).c; i++) {
                cm cmVar = (cm) evVarG3.get(i);
                int i2 = ll.b;
                boolean z2 = i2 == cmVar.d();
                if (i2 == 0) {
                    throw null;
                }
                if (z2) {
                    r rVarC = cmVar.c();
                    int iA = cmVar.a();
                    p pVarR = com.google.android.libraries.navigation.internal.ob.r.r();
                    pVarR.i(rVarC);
                    pVarR.h(u.NAMED_STYLE);
                    pVarR.f(ex.LEGEND_STYLE_SPOTLIGHT_LODGING_IMPRECISION_PIN_LABEL_LAYOUT.CG);
                    pVarR.c(ex.LEGEND_STYLE_SPOTLIGHT_LODGING_IMPRECISION_PIN_ICON.CG);
                    pVarR.d(iA);
                    pVarR.e(ex.LEGEND_STYLE_LODGING_IMPRECISION_REGION_POLYGON.CG);
                    rVarJ = pVarR.j();
                } else {
                    p pVarR2 = com.google.android.libraries.navigation.internal.ob.r.r();
                    pVarR2.i(cmVar.c());
                    pVarR2.b(cmVar.b());
                    if (z) {
                        pVarR2.g(i);
                    } else {
                        pVarR2.h(uVarE);
                    }
                    rVarJ = pVarR2.j();
                }
                eqVar.h(rVarJ);
            }
            evVarG = eqVar.g();
        }
        p(evVarG);
        bh bhVarB = b();
        j();
        eq eqVar2 = new eq();
        int i3 = 0;
        while (i3 < bhVarB.d()) {
            al alVar = bhVarB.e(i3).j;
            int iA2 = bhVarB.a();
            eqVar2.h((alVar == al.DRIVE || alVar == al.TWO_WHEELER || alVar == al.TAXI || alVar == al.TAXICAB) ? i3 == iA2 ? com.google.android.libraries.navigation.internal.bn.e.SELECTED_WITH_TRAFFIC : com.google.android.libraries.navigation.internal.bn.e.UNSELECTED_WITH_TRAFFIC : i3 == iA2 ? com.google.android.libraries.navigation.internal.bn.e.SELECTED_UNIFORM : com.google.android.libraries.navigation.internal.bn.e.UNSELECTED_UNIFORM);
            i3++;
        }
        F(eqVar2.g());
        ev evVarG4 = g();
        h();
        bh bhVarB2 = b();
        i();
        int iA3 = a();
        eq eqVar3 = new eq();
        eq eqVar4 = new eq();
        if (!evVarG4.isEmpty() && iA3 == -1 && ((lv) evVarG4).c > 0) {
            eqVar4.h(((cm) evVarG4.get(0)).c());
        }
        eqVar3.j(eqVar4.g());
        if (bhVarB2.k()) {
            bg bgVarF = bhVarB2.f();
            cf cfVar = bgVarF.g;
            if (iA3 == -1 || bgVarF.j != al.TRANSIT) {
                evVarG2 = lv.a;
            } else {
                eq eqVar5 = new eq();
                av avVarC = cfVar.c(0);
                bt btVarB = avVarC.b(0);
                al alVarB = al.b(btVarB.g().c);
                if (alVarB == null) {
                    alVarB = al.DRIVE;
                }
                if (alVarB == al.TRANSIT) {
                    jk jkVar = btVarB.h().c;
                    if (jkVar == null) {
                        jkVar = jk.a;
                    }
                    J(eqVar5, jkVar);
                    jk jkVar2 = btVarB.h().d;
                    if (jkVar2 == null) {
                        jkVar2 = jk.a;
                    }
                    J(eqVar5, jkVar2);
                } else {
                    ck ckVarV = bgVarF.v(0);
                    if (ckVarV.n() != null) {
                        eqVar5.h(ckVarV.n());
                    }
                    if (avVarC.a() - 1 > 0) {
                        jk jkVar3 = avVarC.b(1).h().c;
                        if (jkVar3 == null) {
                            jkVar3 = jk.a;
                        }
                        J(eqVar5, jkVar3);
                    } else {
                        ck ckVarV2 = bgVarF.v(1);
                        if (ckVarV2.n() != null) {
                            eqVar5.h(ckVarV2.n());
                        }
                    }
                }
                evVarG2 = eqVar5.g();
            }
        } else {
            evVarG2 = lv.a;
        }
        eqVar3.j(evVarG2);
        u(eqVar3.g());
        return d();
    }

    protected abstract int a();

    protected abstract bh b();

    protected abstract e c();

    protected abstract h d();

    protected abstract u e();

    protected abstract an f();

    protected abstract ev g();

    protected abstract void h();

    protected abstract void i();

    protected abstract void j();

    public abstract void k();

    public abstract void l(br brVar);

    public abstract void m(br brVar);

    public abstract void n(ev evVar);

    public abstract void o();

    protected abstract void p(ev evVar);

    public abstract void q(boolean z);

    public abstract void r(boolean z);

    public abstract void s(an anVar);

    public abstract void t(e eVar);

    protected abstract void u(ev evVar);

    public abstract void v(bh bhVar);

    public abstract void w(boolean z);

    public abstract void x();

    public abstract void y(boolean z);

    public abstract void z(boolean z);
}
