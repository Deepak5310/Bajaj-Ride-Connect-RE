package com.google.android.libraries.navigation.internal.db;

import com.google.android.libraries.navigation.internal.agh.dg;
import com.google.android.libraries.navigation.internal.agh.ea;
import com.google.android.libraries.navigation.internal.agh.fy;
import com.google.android.libraries.navigation.internal.agh.he;
import com.google.android.libraries.navigation.internal.agh.hf;
import com.google.android.libraries.navigation.internal.agh.hg;
import com.google.android.libraries.navigation.internal.agh.hh;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y {
    public static final y a;
    public final he b;
    public final com.google.android.libraries.navigation.internal.agh.as c;
    public final ea d;
    public final ev e;

    static {
        fy fyVar = new fy();
        com.google.android.libraries.navigation.internal.agh.ai aiVar = new com.google.android.libraries.navigation.internal.agh.ai();
        dg dgVar = new dg();
        int i = ev.d;
        a = new y(fyVar, aiVar, dgVar, lv.a);
    }

    public y(he heVar, com.google.android.libraries.navigation.internal.agh.as asVar, ea eaVar, List list) {
        fy fyVar = new fy(heVar);
        hf hfVar = hh.a;
        this.b = new hg(fyVar);
        com.google.android.libraries.navigation.internal.agh.ai aiVar = new com.google.android.libraries.navigation.internal.agh.ai(asVar);
        this.c = aiVar;
        aiVar.a = Double.NaN;
        this.d = new dg(eaVar);
        this.e = ev.o(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final double a() {
        ev evVar = this.e;
        int size = evVar.size();
        double d = 0.0d;
        for (int i = 0; i < size; i++) {
            c cVar = (c) evVar.get(i);
            if (cVar.g) {
                d += (double) cVar.a;
            }
        }
        return d;
    }

    /* JADX WARN: Code duplicated, block: B:6:0x001e  */
    /* JADX WARN: Multi-variable type inference failed */
    public final double b(long j, double d, double d2) {
        double dB;
        ev evVar = this.e;
        int size = evVar.size();
        double d3 = 0.0d;
        int i = 0;
        double d4 = 0.0d;
        while (i < size) {
            c cVar = (c) evVar.get(i);
            if (cVar.d.e(j)) {
                double dT = cVar.d.t(j);
                double d5 = d - dT;
                double d6 = d2 - dT;
                if (cVar.a == d3) {
                    dB = d3;
                } else {
                    double dA = cVar.a(d5);
                    double dA2 = cVar.a(d6);
                    double dB2 = c.b(cVar.b, cVar.e, cVar.f);
                    dB = 0.0d;
                    if (dB2 != 0.0d) {
                        dB = (((double) cVar.a) * c.b(cVar.b, dA, dA2)) / dB2;
                    }
                }
            } else {
                dB = d3;
            }
            d4 += dB;
            i++;
            d3 = 0.0d;
        }
        return d4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final double c(long j) {
        ev evVar = this.e;
        int size = evVar.size();
        double d = 0.0d;
        for (int i = 0; i < size; i++) {
            c cVar = (c) evVar.get(i);
            if (cVar.c().e(j)) {
                d += (double) cVar.a;
            }
        }
        return d;
    }

    public final double d(long j) {
        return this.c.t(j);
    }

    public final boolean e(long j) {
        return this.b.e(j);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return com.google.android.libraries.navigation.internal.yx.am.a(this.b, yVar.b) && com.google.android.libraries.navigation.internal.yx.am.a(this.c, yVar.c) && com.google.android.libraries.navigation.internal.yx.am.a(this.d, yVar.d) && com.google.android.libraries.navigation.internal.yx.am.a(this.e, yVar.e);
    }

    public final int hashCode() {
        ea eaVar = this.d;
        return ((eaVar.hashCode() ^ this.e.hashCode()) ^ this.c.hashCode()) ^ this.b.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        ev evVar = this.e;
        int size = evVar.size();
        double d = 0.0d;
        for (int i = 0; i < size; i++) {
            d += (double) ((c) evVar.get(i)).a;
        }
        com.google.android.libraries.navigation.internal.yx.ak akVarA = akVarB.a("totalProbability", d);
        akVarA.g("matchedRouteIds", this.b);
        akVarA.g("modalDistanceAlongRouteMeters", this.c);
        akVarA.g("OnSegment", this.e.toString());
        return akVarA.toString();
    }
}
