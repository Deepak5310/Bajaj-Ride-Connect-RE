package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.AlternateRoutesStrategy;
import com.google.android.libraries.navigation.RoutingOptions;
import com.google.android.libraries.navigation.internal.adr.ip;
import com.google.android.libraries.navigation.internal.adr.it;
import com.google.android.libraries.navigation.internal.adr.iu;
import com.google.android.libraries.navigation.internal.adr.ju;
import com.google.android.libraries.navigation.internal.adr.jw;
import com.google.android.libraries.navigation.internal.adr.ka;
import com.google.android.libraries.navigation.internal.afl.lo;
import com.google.android.libraries.navigation.internal.afl.lq;
import com.google.android.libraries.navigation.internal.afl.lr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gg {
    public static final com.google.android.libraries.navigation.internal.ady.v a;

    static {
        com.google.android.libraries.navigation.internal.ady.q qVar = (com.google.android.libraries.navigation.internal.ady.q) com.google.android.libraries.navigation.internal.ady.v.a.q();
        qVar.d(com.google.android.libraries.navigation.internal.ady.u.a);
        qVar.d(com.google.android.libraries.navigation.internal.ady.u.d);
        qVar.d(com.google.android.libraries.navigation.internal.ady.u.e);
        qVar.d(com.google.android.libraries.navigation.internal.ady.u.f);
        qVar.d(com.google.android.libraries.navigation.internal.ady.u.c);
        qVar.c(com.google.android.libraries.navigation.internal.ady.s.SVG);
        qVar.c(com.google.android.libraries.navigation.internal.ady.s.PNG);
        a = (com.google.android.libraries.navigation.internal.ady.v) qVar.t();
    }

    public static com.google.android.libraries.navigation.internal.adr.c a() {
        com.google.android.libraries.navigation.internal.adr.c cVar = (com.google.android.libraries.navigation.internal.adr.c) com.google.android.libraries.navigation.internal.adr.d.a.q();
        int i = com.google.android.libraries.navigation.internal.ady.af.a;
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.adr.d dVar = (com.google.android.libraries.navigation.internal.adr.d) cVar.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        dVar.c = i2;
        dVar.b |= 1;
        int i3 = com.google.android.libraries.navigation.internal.ady.ah.b;
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.adr.d dVar2 = (com.google.android.libraries.navigation.internal.adr.d) cVar.b;
        if (i3 == 0) {
            throw null;
        }
        dVar2.d = i3;
        dVar2.b |= 2;
        return cVar;
    }

    public static lr b(RoutingOptions routingOptions, boolean z, boolean z2, com.google.android.libraries.navigation.internal.bj.b bVar) {
        com.google.android.libraries.navigation.internal.ady.al alVar;
        int i;
        int travelMode = routingOptions.getTravelMode();
        if (travelMode == 0) {
            alVar = com.google.android.libraries.navigation.internal.ady.al.DRIVE;
        } else if (travelMode == 1) {
            alVar = com.google.android.libraries.navigation.internal.ady.al.BICYCLE;
        } else if (travelMode == 2) {
            alVar = com.google.android.libraries.navigation.internal.ady.al.WALK;
        } else if (travelMode == 3) {
            alVar = com.google.android.libraries.navigation.internal.ady.al.TWO_WHEELER;
        } else {
            if (travelMode != 4) {
                throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.b(travelMode, "Unsupported travel mode: "));
            }
            alVar = com.google.android.libraries.navigation.internal.ady.al.TAXICAB;
        }
        int routingStrategy = routingOptions.getRoutingStrategy();
        if (routingStrategy == 0) {
            i = lq.b;
        } else if (routingStrategy == 1) {
            i = lq.c;
        } else {
            if (routingStrategy != 2) {
                throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.b(routingStrategy, "Unsupported routing strategy: "));
            }
            i = lq.d;
        }
        int i2 = jw.c;
        lo loVar = (lo) lr.a.q();
        ka kaVarC = c(alVar, i2);
        if (!loVar.b.H()) {
            loVar.v();
        }
        lr lrVar = (lr) loVar.b;
        kaVarC.getClass();
        lrVar.f = kaVarC;
        lrVar.b |= 1;
        com.google.android.libraries.navigation.internal.adr.c cVarA = a();
        if (!loVar.b.H()) {
            loVar.v();
        }
        lr lrVar2 = (lr) loVar.b;
        com.google.android.libraries.navigation.internal.adr.d dVar = (com.google.android.libraries.navigation.internal.adr.d) cVarA.t();
        dVar.getClass();
        lrVar2.r = dVar;
        lrVar2.b |= 134217728;
        com.google.android.libraries.navigation.internal.adr.bt btVar = (com.google.android.libraries.navigation.internal.adr.bt) com.google.android.libraries.navigation.internal.adr.by.a.q();
        ip ipVar = (ip) iu.a.q();
        int i3 = it.c;
        if (!ipVar.b.H()) {
            ipVar.v();
        }
        iu iuVar = (iu) ipVar.b;
        int i4 = i3 - 1;
        if (i3 == 0) {
            throw null;
        }
        iuVar.d = i4;
        iuVar.b |= 64;
        if (!btVar.b.H()) {
            btVar.v();
        }
        com.google.android.libraries.navigation.internal.adr.by byVar = (com.google.android.libraries.navigation.internal.adr.by) btVar.b;
        iu iuVar2 = (iu) ipVar.t();
        iuVar2.getClass();
        byVar.e = iuVar2;
        byVar.b |= 512;
        if (!loVar.b.H()) {
            loVar.v();
        }
        lr lrVar3 = (lr) loVar.b;
        com.google.android.libraries.navigation.internal.adr.by byVar2 = (com.google.android.libraries.navigation.internal.adr.by) btVar.t();
        byVar2.getClass();
        lrVar3.h = byVar2;
        lrVar3.b |= 4;
        if (!loVar.b.H()) {
            loVar.v();
        }
        lr.i((lr) loVar.b);
        if (!loVar.b.H()) {
            loVar.v();
        }
        lr.h((lr) loVar.b);
        if (!loVar.b.H()) {
            loVar.v();
        }
        lr.e((lr) loVar.b);
        if (!loVar.b.H()) {
            loVar.v();
        }
        lr.g((lr) loVar.b);
        if (!loVar.b.H()) {
            loVar.v();
        }
        lr lrVar4 = (lr) loVar.b;
        lrVar4.b |= 4096;
        lrVar4.f320n = true;
        com.google.android.libraries.navigation.internal.ady.v vVar = a;
        if (!loVar.b.H()) {
            loVar.v();
        }
        lr lrVar5 = (lr) loVar.b;
        vVar.getClass();
        lrVar5.o = vVar;
        lrVar5.b |= 1048576;
        if (!loVar.b.H()) {
            loVar.v();
        }
        lr lrVar6 = (lr) loVar.b;
        int i5 = i - 1;
        if (i == 0) {
            throw null;
        }
        lrVar6.m = i5;
        lrVar6.b |= 2048;
        if (!loVar.b.H()) {
            loVar.v();
        }
        lr lrVar7 = (lr) loVar.b;
        lrVar7.c |= 131072;
        lrVar7.u = z;
        if (!loVar.b.H()) {
            loVar.v();
        }
        lr lrVar8 = (lr) loVar.b;
        lrVar8.c |= 262144;
        lrVar8.v = z2;
        boolean avoidFerries = routingOptions.getAvoidFerries();
        if (!loVar.b.H()) {
            loVar.v();
        }
        lr lrVar9 = (lr) loVar.b;
        lrVar9.b |= 4096;
        lrVar9.f320n = avoidFerries;
        if (i == lq.d) {
            int iIntValue = routingOptions.getTargetDistancesMeters().get(0).intValue();
            if (!loVar.b.H()) {
                loVar.v();
            }
            lr lrVar10 = (lr) loVar.b;
            lrVar10.b |= 1024;
            lrVar10.l = iIntValue;
        }
        if (alVar == com.google.android.libraries.navigation.internal.ady.al.DRIVE || alVar == com.google.android.libraries.navigation.internal.ady.al.TAXI || alVar == com.google.android.libraries.navigation.internal.ady.al.TAXICAB) {
            com.google.android.libraries.navigation.internal.adr.by byVar3 = ((lr) loVar.b).h;
            if (byVar3 == null) {
                byVar3 = com.google.android.libraries.navigation.internal.adr.by.a;
            }
            com.google.android.libraries.navigation.internal.adr.bt btVar2 = (com.google.android.libraries.navigation.internal.adr.bt) com.google.android.libraries.navigation.internal.adr.by.a.r(byVar3);
            boolean avoidHighways = routingOptions.getAvoidHighways();
            if (!btVar2.b.H()) {
                btVar2.v();
            }
            com.google.android.libraries.navigation.internal.adr.by byVar4 = (com.google.android.libraries.navigation.internal.adr.by) btVar2.b;
            byVar4.b |= 1;
            byVar4.c = avoidHighways;
            boolean avoidTolls = routingOptions.getAvoidTolls();
            if (!btVar2.b.H()) {
                btVar2.v();
            }
            com.google.android.libraries.navigation.internal.adr.by byVar5 = (com.google.android.libraries.navigation.internal.adr.by) btVar2.b;
            byVar5.b |= 2;
            byVar5.d = avoidTolls;
            if (!loVar.b.H()) {
                loVar.v();
            }
            lr lrVar11 = (lr) loVar.b;
            com.google.android.libraries.navigation.internal.adr.by byVar6 = (com.google.android.libraries.navigation.internal.adr.by) btVar2.t();
            byVar6.getClass();
            lrVar11.h = byVar6;
            lrVar11.b |= 4;
        } else if (alVar == com.google.android.libraries.navigation.internal.ady.al.TWO_WHEELER) {
            ka kaVar = ((lr) loVar.b).f;
            if (kaVar == null) {
                kaVar = ka.a;
            }
            ju juVar = (ju) ka.a.r(kaVar);
            if (!juVar.b.H()) {
                juVar.v();
            }
            ka kaVar2 = (ka) juVar.b;
            kaVar2.b |= 256;
            kaVar2.f = true;
            if (!loVar.b.H()) {
                loVar.v();
            }
            lr lrVar12 = (lr) loVar.b;
            ka kaVar3 = (ka) juVar.t();
            kaVar3.getClass();
            lrVar12.f = kaVar3;
            lrVar12.b |= 1;
        }
        if (!com.google.android.libraries.navigation.internal.bj.c.c(((com.google.android.libraries.navigation.internal.bj.a) bVar).a())) {
            com.google.android.libraries.navigation.internal.adr.by byVar7 = ((lr) loVar.b).h;
            if (byVar7 == null) {
                byVar7 = com.google.android.libraries.navigation.internal.adr.by.a;
            }
            com.google.android.libraries.navigation.internal.adr.bt btVar3 = (com.google.android.libraries.navigation.internal.adr.bt) com.google.android.libraries.navigation.internal.adr.by.a.r(byVar7);
            com.google.android.libraries.navigation.internal.adr.bu buVar = (com.google.android.libraries.navigation.internal.adr.bu) com.google.android.libraries.navigation.internal.adr.bx.a.q();
            com.google.android.libraries.navigation.internal.adr.bw bwVarA = bVar.a();
            if (!buVar.b.H()) {
                buVar.v();
            }
            com.google.android.libraries.navigation.internal.adr.bx bxVar = (com.google.android.libraries.navigation.internal.adr.bx) buVar.b;
            bxVar.c = bwVarA.t;
            bxVar.b |= 1;
            btVar3.c((com.google.android.libraries.navigation.internal.adr.bx) buVar.t());
            if (!loVar.b.H()) {
                loVar.v();
            }
            lr lrVar13 = (lr) loVar.b;
            com.google.android.libraries.navigation.internal.adr.by byVar8 = (com.google.android.libraries.navigation.internal.adr.by) btVar3.t();
            byVar8.getClass();
            lrVar13.h = byVar8;
            lrVar13.b |= 4;
        }
        if (routingOptions.getAlternateRoutesStrategy().equals(AlternateRoutesStrategy.SHOW_NONE)) {
            if (!loVar.b.H()) {
                loVar.v();
            }
            lr lrVar14 = (lr) loVar.b;
            lrVar14.b |= 256;
            lrVar14.k = 1;
        } else if (routingOptions.getAlternateRoutesStrategy().equals(AlternateRoutesStrategy.SHOW_ONE)) {
            if (!loVar.b.H()) {
                loVar.v();
            }
            lr lrVar15 = (lr) loVar.b;
            lrVar15.b |= 256;
            lrVar15.k = 2;
        }
        return (lr) loVar.t();
    }

    public static ka c(com.google.android.libraries.navigation.internal.ady.al alVar, int i) {
        ju juVar = (ju) ka.a.q();
        if (!juVar.b.H()) {
            juVar.v();
        }
        ka kaVar = (ka) juVar.b;
        kaVar.c = alVar.k;
        kaVar.b |= 1;
        if (!juVar.b.H()) {
            juVar.v();
        }
        ka kaVar2 = (ka) juVar.b;
        if (i == 0) {
            throw null;
        }
        kaVar2.d = i;
        kaVar2.b |= 2;
        if (!juVar.b.H()) {
            juVar.v();
        }
        ka kaVar3 = (ka) juVar.b;
        kaVar3.b |= 32;
        kaVar3.e = false;
        if (!juVar.b.H()) {
            juVar.v();
        }
        ka.c((ka) juVar.b);
        boolean zEquals = com.google.android.libraries.navigation.internal.ady.al.TWO_WHEELER.equals(alVar);
        if (!juVar.b.H()) {
            juVar.v();
        }
        ka kaVar4 = (ka) juVar.b;
        kaVar4.b |= 256;
        kaVar4.f = zEquals;
        return (ka) juVar.t();
    }
}
