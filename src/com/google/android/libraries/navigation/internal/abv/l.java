package com.google.android.libraries.navigation.internal.abv;

import com.google.android.libraries.navigation.internal.abf.s;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.afm.be;
import com.google.android.libraries.navigation.internal.afm.bh;
import com.google.android.libraries.navigation.internal.afm.bi;
import com.google.android.libraries.navigation.internal.afm.bk;
import com.google.android.libraries.navigation.internal.afm.bt;
import com.google.android.libraries.navigation.internal.afm.bu;
import com.google.android.libraries.navigation.internal.afm.bv;
import com.google.android.libraries.navigation.internal.afm.bw;
import com.google.android.libraries.navigation.internal.afm.bx;
import com.google.android.libraries.navigation.internal.afm.cj;
import com.google.android.libraries.navigation.internal.afm.ck;
import com.google.android.libraries.navigation.internal.afm.cl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l {
    public static final String a = "l";
    public static final l b = new l();
    public static final com.google.android.libraries.navigation.internal.afm.n c;
    public static final bi d;

    static {
        com.google.android.libraries.navigation.internal.afm.k kVar = (com.google.android.libraries.navigation.internal.afm.k) com.google.android.libraries.navigation.internal.afm.n.a.q();
        com.google.android.libraries.navigation.internal.afm.m mVar = com.google.android.libraries.navigation.internal.afm.m.CJPEG;
        if (!kVar.b.H()) {
            kVar.v();
        }
        com.google.android.libraries.navigation.internal.afm.n nVar = (com.google.android.libraries.navigation.internal.afm.n) kVar.b;
        mVar.getClass();
        bq bqVar = nVar.f;
        if (!bqVar.c()) {
            nVar.f = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar);
        }
        nVar.f.i(mVar.e);
        c = (com.google.android.libraries.navigation.internal.afm.n) kVar.t();
        bh bhVar = (bh) bi.a.q();
        if (!bhVar.b.H()) {
            bhVar.v();
        }
        bi biVar = (bi) bhVar.b;
        biVar.b |= 2;
        biVar.d = true;
        if (!bhVar.b.H()) {
            bhVar.v();
        }
        bi biVar2 = (bi) bhVar.b;
        biVar2.b |= 4;
        biVar2.e = true;
        d = (bi) bhVar.t();
    }

    private l() {
    }

    public final be a(int i, int i2, int i3) {
        bt btVar = (bt) bw.a.q();
        bu buVar = (bu) bv.a.q();
        if (!buVar.b.H()) {
            buVar.v();
        }
        bv bvVar = (bv) buVar.b;
        bvVar.b |= 1;
        bvVar.c = i;
        if (!buVar.b.H()) {
            buVar.v();
        }
        bv bvVar2 = (bv) buVar.b;
        bvVar2.b |= 2;
        bvVar2.d = i2;
        if (!btVar.b.H()) {
            btVar.v();
        }
        bw bwVar = (bw) btVar.b;
        bv bvVar3 = (bv) buVar.t();
        bvVar3.getClass();
        bz bzVar = bwVar.f;
        if (!bzVar.c()) {
            bwVar.f = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
        }
        bwVar.f.add(bvVar3);
        if (!btVar.b.H()) {
            btVar.v();
        }
        bw bwVar2 = (bw) btVar.b;
        bwVar2.b |= 4;
        bwVar2.e = i3;
        com.google.android.libraries.navigation.internal.afm.n nVar = c;
        if (!btVar.b.H()) {
            btVar.v();
        }
        bw bwVar3 = (bw) btVar.b;
        nVar.getClass();
        bwVar3.c = nVar;
        bwVar3.b |= 1;
        if (!btVar.b.H()) {
            btVar.v();
        }
        bw bwVar4 = (bw) btVar.b;
        bwVar4.b |= 2;
        bwVar4.d = 512;
        bw bwVar5 = (bw) btVar.t();
        be beVar = (be) bx.a.q();
        if (!beVar.b.H()) {
            beVar.v();
        }
        bx bxVar = (bx) beVar.b;
        bwVar5.getClass();
        bxVar.j = bwVar5;
        bxVar.b |= 128;
        if (!beVar.b.H()) {
            beVar.v();
        }
        bx bxVar2 = (bx) beVar.b;
        bxVar2.b |= 4096;
        bxVar2.o = 4;
        if (!beVar.b.H()) {
            beVar.v();
        }
        bx bxVar3 = (bx) beVar.b;
        bxVar3.b |= 2048;
        bxVar3.f327n = true;
        bk bkVar = bk.SPHERICAL;
        if (!beVar.b.H()) {
            beVar.v();
        }
        bx bxVar4 = (bx) beVar.b;
        bkVar.getClass();
        bq bqVar = bxVar4.p;
        if (!bqVar.c()) {
            bxVar4.p = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar);
        }
        bxVar4.p.i(bkVar.c);
        return beVar;
    }

    public final Map b(cl clVar) {
        s.k(clVar, "responseProto");
        HashMap map = new HashMap();
        String str = clVar.c;
        ck ckVar = clVar.f;
        if (ckVar == null) {
            ckVar = ck.a;
        }
        int i = ckVar.b;
        for (cj cjVar : ckVar.e) {
            map.put(new com.google.android.libraries.navigation.internal.abt.d(str, cjVar.c, cjVar.d, i), cjVar.f.B());
        }
        return map;
    }
}
