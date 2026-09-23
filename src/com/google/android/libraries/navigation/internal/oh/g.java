package com.google.android.libraries.navigation.internal.oh;

import com.google.android.libraries.geo.mapcore.internal.model.bn;
import com.google.android.libraries.geo.mapcore.internal.model.bp;
import com.google.android.libraries.navigation.internal.oe.ad;
import com.google.android.libraries.navigation.internal.oe.ai;
import com.google.android.libraries.navigation.internal.oe.an;
import com.google.android.libraries.navigation.internal.oe.ay;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.qk.s;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements a {
    private final ad a;
    private final List b;
    private final List c;
    private final float d;
    private final float e;
    private final com.google.android.libraries.navigation.internal.qa.a f = new com.google.android.libraries.navigation.internal.qa.a(0.0f, 0.0f, 0.0f, 0.0f);
    private final ay[] g = {new ay(), new ay(), new ay(), new ay()};
    private final ai h = new ai(new x(), new x());
    private final x i = new x();
    private final x j = new x();
    private final x k = new x();
    private final ay[] l = {new ay(), new ay()};
    private final ay m = new ay();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ay f497n = new ay();
    private final ay o = new ay();
    private final ay p = new ay();

    public g(ad adVar, List list, float f, float f2) {
        this.a = adVar;
        this.b = list;
        this.c = new ArrayList(list.size());
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            this.c.add(new bp((ad) it2.next()));
        }
        this.d = f;
        this.e = f2;
    }

    private final ay b(com.google.android.libraries.navigation.internal.rf.g gVar, x xVar, x xVar2, ay ayVar) {
        ay ayVar2 = new ay();
        for (int i = 0; i < 7; i++) {
            this.k.W(xVar.B(xVar2, 0.5f));
            ayVar2 = gVar.f(this.k);
            if (ayVar2 == null) {
                xVar2.W(this.k);
            } else {
                xVar.W(this.k);
            }
        }
        return ayVar2 == null ? ayVar : ayVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.oh.a
    public final float a(com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.qk.q qVar, x xVar, com.google.android.libraries.navigation.internal.adg.b bVar, s sVar) {
        int i;
        int i2;
        Iterator it2;
        com.google.android.libraries.navigation.internal.rf.g gVar2;
        ay ayVar;
        float f;
        int i3;
        int i4;
        float fB;
        com.google.android.libraries.navigation.internal.rf.g gVar3 = qVar.h;
        float fB2 = this.d * gVar3.b();
        ay ayVarF = gVar3.f(xVar);
        float fMin = 0.5f;
        if (ayVarF != null && m.a(qVar, gVar, xVar, bVar, this.f)) {
            int i5 = 0;
            while (true) {
                if (i5 >= 4) {
                    break;
                }
                this.f.c(i5, this.g[i5]);
                i5++;
            }
            float fS = com.google.android.libraries.navigation.internal.pb.j.s(gVar3) * fB2;
            com.google.android.libraries.navigation.internal.rf.g gVar4 = qVar.h;
            ay[] ayVarArr = this.g;
            ai aiVar = this.h;
            int iMax = Integer.MIN_VALUE;
            int iMin = Integer.MAX_VALUE;
            int iMin2 = Integer.MAX_VALUE;
            int i6 = 0;
            int iMax2 = Integer.MIN_VALUE;
            for (i = 4; i6 < i; i = 4) {
                ay ayVar2 = ayVarArr[i6];
                ay[] ayVarArr2 = ayVarArr;
                com.google.android.libraries.navigation.internal.oe.q qVarE = gVar4.e(ayVar2.b, ayVar2.c);
                if (qVarE == null) {
                    qVarE = new com.google.android.libraries.navigation.internal.oe.q(0, 0, 0);
                }
                int i7 = qVarE.a;
                iMin = Math.min(iMin, i7);
                iMax = Math.max(iMax, i7);
                int i8 = qVarE.b;
                iMin2 = Math.min(iMin2, i8);
                iMax2 = Math.max(iMax2, i8);
                i6++;
                ayVarArr = ayVarArr2;
            }
            aiVar.o(Math.round(iMin - fS), Math.round(iMin2 - fS), Math.round(iMax + fS), Math.round(iMax2 + fS));
            boolean z = false;
            float f2 = 0.0f;
            int i9 = 0;
            loop2: while (true) {
                if (i9 >= this.b.size()) {
                    ay[] ayVarArr3 = this.g;
                    float fB3 = ay.b(ayVarArr3[0], ayVarArr3[2]);
                    fMin = Math.min(0.99f, (fB3 > 0.0f ? f2 / fB3 : 0.0f) + (z ? this.e : 0.0f));
                    break;
                }
                bp bpVar = (bp) this.c.get(i9);
                ai aiVar2 = this.h;
                ArrayList arrayList = new ArrayList();
                bn bnVar = new bn(bpVar, aiVar2, bpVar.a(0));
                int i10 = -1;
                int i11 = -2;
                while (true) {
                    i2 = 1;
                    if (!bnVar.hasNext()) {
                        break;
                    }
                    int iIntValue = bnVar.next().intValue();
                    bn bnVar2 = bnVar;
                    if (iIntValue - i11 > 1) {
                        if (i10 >= 0) {
                            arrayList.add(new an(bpVar.c, bpVar.b(i10), Math.min(bpVar.b(i11) + 9, bpVar.c.e())));
                        }
                        i10 = iIntValue;
                    } else {
                        iIntValue = iIntValue;
                    }
                    bnVar = bnVar2;
                    i11 = iIntValue;
                }
                if (i10 >= 0) {
                    arrayList.add(new an(bpVar.c, bpVar.b(i10), Math.min(bpVar.b(i11) + 9, bpVar.c.e())));
                }
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    an anVar = (an) it3.next();
                    anVar.e(0, this.i);
                    ay ayVarF2 = gVar3.f(this.i);
                    int i12 = i2;
                    while (i12 < anVar.a()) {
                        this.j.W(this.i);
                        ay ayVar3 = ayVarF2 == null ? null : new ay(ayVarF2);
                        anVar.e(i12, this.i);
                        ay ayVarF3 = gVar3.f(this.i);
                        if (ayVar3 == null && ayVarF3 == null) {
                            it2 = it3;
                            gVar2 = gVar3;
                            ayVar = ayVarF;
                            f = fB2;
                            ayVarF2 = ayVarF3;
                            i4 = i2;
                        } else {
                            if (ayVar3 == null) {
                                x xVar2 = this.i;
                                x xVar3 = this.j;
                                ar.q(ayVarF3);
                                ayVar3 = new ay(b(gVar3, xVar2, xVar3, ayVarF3));
                            }
                            if (ayVarF3 == null) {
                                ayVarF3 = new ay(b(gVar3, this.j, this.i, ayVar3));
                            }
                            if (fB2 <= 0.0f || ((ad) this.b.get(i9)).equals(this.a)) {
                                it2 = it3;
                                gVar2 = gVar3;
                            } else {
                                if (ay.e(ayVarF, ayVarF3) <= fB2 * fB2) {
                                    it2 = it3;
                                    gVar2 = gVar3;
                                } else {
                                    ay ayVar4 = this.m;
                                    it2 = it3;
                                    gVar2 = gVar3;
                                    ayVar4.q(ayVar3.c - ayVarF3.c, ayVarF3.b - ayVar3.b);
                                    ay.n(ayVar4, ayVar4);
                                    ay.l(ayVar4, fB2, ayVar4);
                                    ay.j(ayVarF, this.m, this.f497n);
                                    ay.s(ayVarF, this.m, this.o);
                                    if (ay.h(ayVar3, ayVarF3, this.f497n, this.o, this.p)) {
                                    }
                                }
                                if (this.b.indexOf(this.a) > i9) {
                                    fMin = 1.0f;
                                    break loop2;
                                }
                                z = true;
                            }
                            com.google.android.libraries.navigation.internal.qa.a aVar = this.f;
                            ay[] ayVarArr4 = this.g;
                            ay[] ayVarArr5 = this.l;
                            if (aVar.e(ayVar3) && aVar.e(ayVarF3)) {
                                fB = ay.b(ayVar3, ayVarF3);
                                ayVar = ayVarF;
                                f = fB2;
                                z = z;
                                i4 = 1;
                            } else {
                                ayVar = ayVarF;
                                f = fB2;
                                int i13 = 0;
                                int i14 = 4;
                                int i15 = 0;
                                while (true) {
                                    if (i15 >= i14) {
                                        i3 = 2;
                                        break;
                                    }
                                    if (i13 >= 2) {
                                        i3 = 2;
                                        break;
                                    }
                                    ay ayVar5 = ayVarArr4[i15];
                                    i15++;
                                    boolean z2 = z;
                                    ay[] ayVarArr6 = ayVarArr4;
                                    if (ay.h(ayVar3, ayVarF3, ayVar5, ayVarArr4[i15 % 4], ayVarArr5[i13])) {
                                        i13++;
                                    }
                                    ayVarArr4 = ayVarArr6;
                                    z = z2;
                                    i14 = 4;
                                }
                                if (i13 == i3) {
                                    i4 = 1;
                                    fB = ay.b(ayVarArr5[0], ayVarArr5[1]);
                                } else {
                                    i4 = 1;
                                    if (i13 == 1) {
                                        ay ayVar6 = ayVarArr5[0];
                                        if (true != aVar.e(ayVar3)) {
                                            ayVar3 = ayVarF3;
                                        }
                                        fB = ay.b(ayVar6, ayVar3);
                                    } else {
                                        fB = 0.0f;
                                    }
                                }
                            }
                            f2 += fB;
                            ayVarF2 = ayVarF3;
                            z = z;
                        }
                        i12++;
                        i2 = i4;
                        ayVarF = ayVar;
                        it3 = it2;
                        gVar3 = gVar2;
                        fB2 = f;
                    }
                }
                i9++;
            }
        }
        if (sVar != null) {
            sVar.a(xVar, bVar, com.google.android.libraries.navigation.internal.b.b.h(fMin, "OverlapsAnyPolyline:"));
        }
        return fMin;
    }
}
