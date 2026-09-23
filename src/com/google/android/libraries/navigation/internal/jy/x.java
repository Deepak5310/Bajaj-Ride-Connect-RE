package com.google.android.libraries.navigation.internal.jy;

import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.afl.hv;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.zp.bh;
import com.google.android.libraries.navigation.internal.zp.bi;
import com.google.android.libraries.navigation.internal.zp.bj;
import com.google.android.libraries.navigation.internal.zp.bk;
import com.google.android.libraries.navigation.internal.zp.ca;
import com.google.android.libraries.navigation.internal.zr.bm;
import com.google.android.libraries.navigation.internal.zt.ag;
import com.google.android.libraries.navigation.internal.zt.ap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x {
    public ap a;
    public String b;
    public hv d;
    public com.google.android.libraries.navigation.internal.zy.n e;
    public boolean f;
    public com.google.android.libraries.navigation.internal.aeb.b h;
    public com.google.android.libraries.navigation.internal.afd.a i;
    private String j;
    private boolean k;
    public bj c = (bj) bk.a.q();
    public final y g = z.g();

    public final x a(String str) {
        e(str, true);
        return this;
    }

    public final aa b() {
        aa aaVar = new aa(this.a, this.j, this.k, this.b, this.i, (bk) this.c.t(), this.d, null, false, this.g.a(), this.h, null);
        if (!aaVar.j()) {
            ((com.google.android.libraries.navigation.internal.zb.h) aa.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 756)).p("Attempted to build invalid UE3 params, see http://go/gmm-logging-errors#general-validity");
        }
        return aaVar;
    }

    @Deprecated
    public final aa c() {
        return new aa(this.a, this.j, this.k, this.b, this.i, (bk) this.c.t(), this.d, null, false, this.g.a(), this.h, null);
    }

    public final bi d() {
        return (bi) com.google.android.libraries.navigation.internal.hc.a.e(((e) this.g).d, (dg) bi.a.aH(7, null), bi.a);
    }

    public final void e(String str, boolean z) {
        boolean zC = aq.c(str);
        if (true == zC) {
            str = null;
        }
        this.j = str;
        this.k = (!zC) & z;
    }

    public final void f(com.google.android.libraries.navigation.internal.zq.l lVar) {
        bi biVarD = d();
        if (biVarD == null) {
            biVarD = bi.a;
        }
        bb bbVar = (bb) biVarD.aH(5, null);
        bbVar.x(biVarD);
        bh bhVar = (bh) bbVar;
        if (!bhVar.b.H()) {
            bhVar.v();
        }
        bi biVar = (bi) bhVar.b;
        lVar.getClass();
        biVar.h = lVar;
        biVar.e |= 128;
        j((bi) bhVar.t());
    }

    public final void g(com.google.android.libraries.navigation.internal.zp.r rVar) {
        ((e) this.g).a = com.google.android.libraries.navigation.internal.hc.a.a(rVar);
    }

    public final void h(bm bmVar) {
        bj bjVar = this.c;
        if (!bjVar.b.H()) {
            bjVar.v();
        }
        bk bkVar = (bk) bjVar.b;
        bk bkVar2 = bk.a;
        bmVar.getClass();
        bkVar.c = bmVar;
        bkVar.b |= 8;
    }

    public final void i(ag agVar) {
        ((e) this.g).b = com.google.android.libraries.navigation.internal.hc.a.a(agVar);
    }

    public final void j(bi biVar) {
        ((e) this.g).d = com.google.android.libraries.navigation.internal.hc.a.a(biVar);
    }

    public final void k(ca caVar) {
        this.g.c(caVar);
    }
}
