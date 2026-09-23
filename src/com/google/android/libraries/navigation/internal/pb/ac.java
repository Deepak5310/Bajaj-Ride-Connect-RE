package com.google.android.libraries.navigation.internal.pb;

import com.google.android.libraries.navigation.internal.oe.ad;
import com.google.android.libraries.navigation.internal.oe.ay;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac {
    public final ay c;
    public final ay d;
    public final ay e;
    public final ay f;
    public final com.google.android.libraries.navigation.internal.qa.a g;
    public ad h;
    private final ay[][] l;
    private final com.google.android.libraries.navigation.internal.oe.x i = new com.google.android.libraries.navigation.internal.oe.x(0, 0);
    public final ay a = new ay(0.0f, 0.0f);
    public final ay b = new ay(0.0f, 0.0f);
    private final com.google.android.libraries.navigation.internal.qa.a j = new com.google.android.libraries.navigation.internal.qa.a(0.0f, 0.0f, 0.0f, 0.0f);
    private final ay k = new ay(0.0f, 0.0f);

    public ac(com.google.android.libraries.navigation.internal.qa.a aVar, ad adVar) {
        this.g = aVar;
        this.h = adVar;
        ar.a(adVar.e() > 0);
        float f = aVar.a;
        float f2 = aVar.b;
        ay ayVar = new ay(f, f2);
        this.c = ayVar;
        float f3 = aVar.d;
        ay ayVar2 = new ay(f, f3);
        this.d = ayVar2;
        float f4 = aVar.c;
        ay ayVar3 = new ay(f4, f2);
        this.e = ayVar3;
        ay ayVar4 = new ay(f4, f3);
        this.f = ayVar4;
        this.l = new ay[][]{new ay[]{ayVar, ayVar2}, new ay[]{ayVar2, ayVar4}, new ay[]{ayVar4, ayVar3}, new ay[]{ayVar3, ayVar}};
    }

    public final boolean a(ay ayVar, ay ayVar2, ay ayVar3) {
        float f = ayVar.b;
        float f2 = ayVar2.b;
        float fMin = Math.min(f, f2);
        float f3 = ayVar.c;
        float f4 = ayVar2.c;
        this.j.d(fMin, Math.min(f3, f4), Math.max(f, f2), Math.max(f3, f4));
        return this.g.f(this.j) && b(ayVar, ayVar2, false, ayVar3);
    }

    public final boolean b(ay ayVar, ay ayVar2, boolean z, ay ayVar3) {
        float f = Float.MAX_VALUE;
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            ay[] ayVarArr = this.l[i2];
            if (ay.h(ayVar, ayVar2, ayVarArr[0], ayVarArr[1], this.k)) {
                if (z) {
                    ayVar3.r(this.k);
                    return true;
                }
                float fE = ay.e(this.k, ayVar2);
                if (i == 0 || fE < f) {
                    ayVar3.r(this.k);
                    f = fE;
                }
                i++;
                if (i == 2) {
                    break;
                }
            }
        }
        return i > 0;
    }

    public final int c(com.google.android.libraries.navigation.internal.rf.g gVar, int i, ay ayVar, ay ayVar2) {
        if (i == this.h.e() - 1) {
            ayVar2.r(ayVar);
            return i;
        }
        ay ayVar3 = this.b;
        int i2 = 0;
        while (i2 < 10) {
            int i3 = i + 1;
            if (!d(gVar, i3, ayVar3)) {
                return -1;
            }
            if (!this.g.e(ayVar3)) {
                if (a(ayVar, ayVar3, ayVar2)) {
                    return i;
                }
                return -1;
            }
            if (i3 == this.h.e() - 1) {
                ayVar2.r(ayVar3);
                return i3;
            }
            ayVar.r(ayVar3);
            i2++;
            i = i3;
        }
        return -1;
    }

    public final boolean d(com.google.android.libraries.navigation.internal.rf.g gVar, int i, ay ayVar) {
        this.h.u(i, this.i);
        ay ayVarF = gVar.f(this.i);
        if (ayVarF == null) {
            return false;
        }
        ayVar.q(ayVarF.b, ayVarF.c);
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ac)) {
            return false;
        }
        ac acVar = (ac) obj;
        return this.g.equals(acVar.g) && this.h == acVar.h;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.g, this.h});
    }
}
