package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.ki;
import com.google.android.libraries.navigation.internal.adr.ma;
import com.google.android.libraries.navigation.internal.afl.la;
import com.google.android.libraries.navigation.internal.afl.le;
import com.google.android.libraries.navigation.internal.afl.lh;
import com.google.android.libraries.navigation.internal.afl.ll;
import com.google.android.libraries.navigation.internal.afl.me;
import com.google.android.libraries.navigation.internal.afl.mf;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.UUID;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class af {
    public final mf a;
    public final lh b;
    public final String c;
    private final cf[] d;
    private final com.google.android.libraries.navigation.internal.oe.ad[] e;

    public af(mf mfVar) {
        this(mfVar, UUID.randomUUID().toString());
    }

    public static void o(mf mfVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(mfVar);
        com.google.android.libraries.navigation.internal.yx.ar.k(1 == (mfVar.b & 1));
        ll llVar = mfVar.c;
        if (llVar == null) {
            llVar = ll.a;
        }
        com.google.android.libraries.navigation.internal.yx.ar.k(1 == (llVar.b & 1));
    }

    private static boolean p(mf mfVar) {
        int iA = me.a(mfVar.e);
        if (iA == 0) {
            iA = me.a;
        }
        return iA == me.c;
    }

    public final int a() {
        for (int i = 0; i < this.b.d.size(); i++) {
            if (((ki) this.b.d.get(i)).p) {
                return i;
            }
        }
        return -1;
    }

    public final int b() {
        return this.b.f;
    }

    public final int c() {
        return this.b.d.size();
    }

    public final int d() {
        return this.b.c.size();
    }

    public final cf e(int i) {
        if (i < 0) {
            return null;
        }
        cf[] cfVarArr = this.d;
        if (cfVarArr.length <= i) {
            return null;
        }
        return cfVarArr[i];
    }

    public final boolean equals(Object obj) {
        return (obj instanceof af) && this.a == ((af) obj).a;
    }

    public final com.google.android.libraries.navigation.internal.oe.ad f(cf cfVar) {
        if (!cfVar.j()) {
            return null;
        }
        int iA = cfVar.a();
        com.google.android.libraries.navigation.internal.oe.ad[] adVarArr = this.e;
        if (iA >= adVarArr.length) {
            return null;
        }
        if (adVarArr[iA] == null) {
            la laVar = (la) this.b.i.get(iA);
            int iMin = Math.min(laVar.c.size(), laVar.d.size());
            int[] iArr = new int[iMin + iMin];
            com.google.android.libraries.navigation.internal.oe.x xVar = new com.google.android.libraries.navigation.internal.oe.x();
            int iD = 0;
            int iA2 = 0;
            for (int i = 0; i < iMin; i++) {
                iD += laVar.c.d(i);
                iA2 = com.google.android.libraries.navigation.internal.oe.g.a(iA2, laVar.d.d(i));
                xVar.M(iD, iA2);
                int i2 = i + i;
                iArr[i2] = xVar.a;
                iArr[i2 + 1] = xVar.b;
            }
            adVarArr[iA] = new com.google.android.libraries.navigation.internal.oe.ad(iArr, 0, 0, 0);
        }
        return this.e[iA];
    }

    public final com.google.android.libraries.navigation.internal.adr.at g() {
        com.google.android.libraries.navigation.internal.adr.at atVarB = com.google.android.libraries.navigation.internal.adr.at.b(this.b.g);
        return atVarB == null ? com.google.android.libraries.navigation.internal.adr.at.SUCCESS : atVarB;
    }

    public final ma h(int i) {
        return (ma) this.b.c.get(i);
    }

    public final int hashCode() {
        return System.identityHashCode(this.a);
    }

    public final le i() {
        le leVar = this.b.m;
        return leVar == null ? le.a : leVar;
    }

    public final ll j() {
        ll llVar = this.a.c;
        return llVar == null ? ll.a : llVar;
    }

    public final String k() {
        ll llVar = this.a.c;
        if (llVar == null) {
            llVar = ll.a;
        }
        return llVar.e;
    }

    public final boolean l() {
        return (this.b.b & 2) != 0;
    }

    public final boolean m() {
        com.google.android.libraries.navigation.internal.adr.at atVarB = com.google.android.libraries.navigation.internal.adr.at.b(this.b.g);
        if (atVarB == null) {
            atVarB = com.google.android.libraries.navigation.internal.adr.at.SUCCESS;
        }
        return atVarB == com.google.android.libraries.navigation.internal.adr.at.SUCCESS;
    }

    public final byte[] n() {
        return this.b.l.B();
    }

    public af(mf mfVar, String str) {
        o(mfVar);
        this.a = mfVar;
        ll llVar = mfVar.c;
        lh lhVar = (llVar == null ? ll.a : llVar).c;
        lhVar = lhVar == null ? lh.a : lhVar;
        this.b = lhVar;
        this.e = new com.google.android.libraries.navigation.internal.oe.ad[lhVar.i.size()];
        int size = lhVar.d.size();
        cf[] cfVarArr = new cf[size];
        for (int i = 0; i < size; i++) {
            cfVarArr[i] = new cf((ki) lhVar.d.get(i), p(mfVar));
        }
        this.d = cfVarArr;
        this.c = str == null ? UUID.randomUUID().toString() : str;
        int i2 = ev.d;
        eq eqVar = new eq();
        for (int i3 = 0; i3 < lhVar.h.size(); i3++) {
            eqVar.h((el) lhVar.h.get(i3));
        }
        eqVar.g();
    }
}
