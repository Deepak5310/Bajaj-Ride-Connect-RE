package com.google.android.libraries.navigation.internal.pm;

import com.google.android.libraries.navigation.internal.adg.bj;
import com.google.android.libraries.navigation.internal.adg.cw;
import com.google.android.libraries.navigation.internal.adg.cx;
import com.google.android.libraries.navigation.internal.adg.fr;
import com.google.android.libraries.navigation.internal.adg.fs;
import com.google.android.libraries.navigation.internal.adg.fu;
import com.google.android.libraries.navigation.internal.adl.k;
import com.google.android.libraries.navigation.internal.ael.ap;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.be;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bm;
import com.google.android.libraries.navigation.internal.ael.cy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    public final fs a;
    public fr b = null;
    private final be c;

    public g(be beVar, fs fsVar) {
        this.c = beVar;
        this.a = fsVar;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x015c  */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.android.libraries.navigation.internal.adg.ei, com.google.android.libraries.navigation.internal.ael.be] */
    public static void b(g gVar) {
        Object objC;
        gVar.c(bj.C, fu.c);
        gVar.c(bj.T, fu.s);
        gVar.c(bj.E, fu.e);
        gVar.c(bj.S, fu.r);
        gVar.c(bj.ac, fu.D);
        gVar.c(bj.af, fu.G);
        gVar.c(bj.ae, fu.F);
        gVar.c(bj.R, fu.q);
        gVar.c(bj.F, fu.f);
        gVar.c(bj.Y, fu.z);
        bh bhVar = bj.Z;
        bh bhVar2 = fu.A;
        bh bhVarS = bi.s(bhVar);
        be beVar = gVar.c;
        beVar.h(bhVarS);
        if (beVar.w.n(bhVarS.d)) {
            fr frVarA = gVar.a();
            be beVar2 = gVar.c;
            bh bhVarS2 = bi.s(bhVar);
            beVar2.h(bhVarS2);
            Object objK = beVar2.w.k(bhVarS2.d);
            frVarA.C(bhVar2, (bm) (objK == null ? bhVarS2.b : bhVarS2.c(objK)));
        }
        gVar.c(bj.G, fu.g);
        gVar.c(bj.K, fu.k);
        gVar.c(bj.J, fu.j);
        gVar.c(bj.W, fu.x);
        gVar.c(bj.V, fu.w);
        gVar.c(bj.aa, fu.B);
        gVar.c(bj.ab, fu.C);
        gVar.c(k.a, fu.P);
        gVar.c(bj.M, fu.l);
        gVar.c(bj.Q, fu.p);
        gVar.c(bj.U, fu.v);
        gVar.c(bj.O, fu.f199n);
        gVar.c(bj.P, fu.o);
        gVar.c(bj.ad, fu.E);
        gVar.c(bj.H, fu.h);
        gVar.c(bj.X, fu.y);
        gVar.c(bj.L, fu.N);
        gVar.c(bj.D, fu.d);
        gVar.c(bj.I, fu.i);
        gVar.c(bj.N, fu.m);
        gVar.c(bj.B, fu.b);
        gVar.c(com.google.android.libraries.navigation.internal.acv.b.b, fu.U);
        bh bhVar3 = fu.w;
        fr frVar = gVar.b;
        if (frVar == null) {
            fs fsVar = gVar.a;
            bh bhVarS3 = bi.s(bhVar3);
            fsVar.h(bhVarS3);
            if (fsVar.w.n(bhVarS3.d)) {
                fs fsVar2 = gVar.a;
                bh bhVarS4 = bi.s(bhVar3);
                fsVar2.h(bhVarS4);
                Object objK2 = fsVar2.w.k(bhVarS4.d);
                objC = objK2 == null ? bhVarS4.b : bhVarS4.c(objK2);
            } else {
                objC = null;
            }
        } else if (frVar.z(bhVar3)) {
            objC = gVar.b.y(bhVar3);
        } else {
            objC = null;
        }
        cx cxVar = (cx) objC;
        if (cxVar == null || (cxVar.b & 512) != 0) {
            return;
        }
        fr frVarA2 = gVar.a();
        bh bhVar4 = fu.w;
        bb bbVar = (bb) cxVar.aH(5, null);
        bbVar.x(cxVar);
        cw cwVar = (cw) bbVar;
        String strC = com.google.android.libraries.navigation.internal.rp.c.c(gVar.c);
        if (!cwVar.b.H()) {
            cwVar.v();
        }
        cx cxVar2 = (cx) cwVar.b;
        strC.getClass();
        cxVar2.b |= 512;
        cxVar2.i = strC;
        frVarA2.C(bhVar4, (cx) cwVar.t());
    }

    private final void c(ap apVar, ap apVar2) {
        be beVar = this.c;
        bh bhVarS = bi.s(apVar);
        beVar.h(bhVarS);
        if (beVar.w.n(bhVarS.d)) {
            fr frVarA = a();
            be beVar2 = this.c;
            bh bhVarS2 = bi.s(apVar);
            beVar2.h(bhVarS2);
            Object objK = beVar2.w.k(bhVarS2.d);
            frVarA.C(apVar2, (cy) (objK == null ? bhVarS2.b : bhVarS2.c(objK)));
        }
    }

    public final fr a() {
        if (this.b == null) {
            fs fsVar = this.a;
            bb bbVar = (bb) fsVar.aH(5, null);
            bbVar.x(fsVar);
            this.b = (fr) bbVar;
        }
        return this.b;
    }
}
