package com.google.android.libraries.navigation.internal.oe;

import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ad {
    public static final ad a = new ad(new int[0], 0, 0, 0);
    public final int[] b;
    public final int c;
    public final int d;
    public final int e;
    public float f;
    private List g;
    private volatile ai h;
    private volatile float i;

    public ad(int[] iArr, int i, int i2, int i3) {
        this.f = 0.0f;
        this.b = iArr;
        this.e = i;
        this.c = i2;
        this.d = i3;
        this.i = -1.0f;
    }

    public ad(int[] iArr, int i, int i2, int i3, float f) {
        this(iArr, i, i2, i3);
        this.f = f;
    }

    public static ad m(com.google.android.libraries.navigation.internal.adr.ab abVar) {
        int iMin = Math.min(abVar.b.size(), abVar.c.size());
        int[] iArr = new int[iMin + iMin];
        x xVar = new x();
        int iD = 0;
        int iA = 0;
        for (int i = 0; i < iMin; i++) {
            iD += abVar.b.d(i);
            iA = g.a(iA, abVar.c.d(i));
            xVar.M(iD, iA);
            int i2 = i + i;
            iArr[i2] = xVar.a;
            iArr[i2 + 1] = xVar.b;
        }
        return new ad(iArr, 0, 0, 0);
    }

    public static ad n(List list) {
        int size = list.size();
        int[] iArr = new int[size + size];
        for (int i = 0; i < list.size(); i++) {
            int i2 = i + i;
            iArr[i2] = ((x) list.get(i)).a;
            iArr[i2 + 1] = ((x) list.get(i)).b;
        }
        return new ad(iArr, 0, 0, 0);
    }

    public static ad o(ad adVar, int i, int i2) {
        int i3 = i2 - i;
        int i4 = i3 + i3;
        int[] iArr = new int[i4];
        System.arraycopy(adVar.b, i + i, iArr, 0, i4);
        return new ad(iArr, adVar.e, adVar.c, adVar.d, adVar.f);
    }

    private static int v(int i, int i2, int i3) {
        return (i2 < 0 ? i >> (-i2) : i << i2) + i3;
    }

    public final float a() {
        float fC = 0.0f;
        if (this.i < 0.0f) {
            int iE = e() - 1;
            for (int i = 0; i < iE; i++) {
                fC += c(i);
            }
            this.i = fC;
        }
        return this.i;
    }

    public final float b(int i) {
        int[] iArr = this.b;
        int i2 = i + i;
        return y.b(iArr[i2 + 2] - iArr[i2], iArr[i2 + 3] - iArr[i2 + 1]);
    }

    public final float c(int i) {
        int[] iArr = this.b;
        int i2 = i + i;
        int i3 = iArr[i2] - iArr[i2 + 2];
        int i4 = iArr[i2 + 1] - iArr[i2 + 3];
        int i5 = this.e;
        return (float) Math.hypot(v(i3, i5, 0), v(i4, i5, 0));
    }

    public final float d(int i) {
        int[] iArr = this.b;
        int i2 = i + i;
        int i3 = iArr[i2] - iArr[i2 + 2];
        int i4 = iArr[i2 + 1];
        int i5 = iArr[i2 + 3];
        int i6 = i4 - i5;
        int i7 = (i4 + i5) / 2;
        int i8 = this.e;
        return (float) (Math.hypot(v(i3, i8, 0), v(i6, i8, 0)) / x.f(x.c(v(i7, i8, 0))));
    }

    public final int e() {
        return this.b.length >> 1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ad) {
            ad adVar = (ad) obj;
            if (this.e == adVar.e && this.c == adVar.c && this.d == adVar.d) {
                int[] iArr = this.b;
                int[] iArr2 = adVar.b;
                if (iArr.length == iArr2.length) {
                    for (int i = 0; i < iArr.length; i++) {
                        if (iArr[i] == iArr2[i]) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final int f(int i) {
        return v(this.b[i + i], this.e, this.c);
    }

    public final int g(int i) {
        return v(this.b[i + i + 1], this.e, this.d);
    }

    public final int h(int i) {
        return v(this.b[i + i + 1], this.e, this.d);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.b) + this.e + (this.c * 31) + (this.d * 961);
    }

    public final int i(float f, x xVar) {
        if (f <= 0.0f) {
            u(0, xVar);
            return 0;
        }
        int iE = e();
        int i = iE - 1;
        if (f >= 1.0f) {
            int i2 = iE - 2;
            u(i, xVar);
            return i2;
        }
        float fA = a() * f;
        int i3 = 0;
        while (i3 < i) {
            int i4 = i3 + 1;
            float fC = c(i3);
            if (fC >= fA) {
                float f2 = fA / fC;
                int iF = f(i3);
                int iG = g(i3);
                int iF2 = f(i4);
                int iG2 = g(i4);
                xVar.a = ((int) ((iF2 - iF) * f2)) + iF;
                xVar.b = ((int) (f2 * (iG2 - iG))) + iG;
                xVar.c = 0;
                return i3;
            }
            fA -= fC;
            i3 = i4;
        }
        int i5 = iE - 2;
        u(i, xVar);
        return i5;
    }

    public final int j(float f, int i, int i2, x xVar, x xVar2, x xVar3, x xVar4, boolean[] zArr) {
        int i3;
        u(i, xVar);
        u(i2, xVar2);
        int i4 = i + 1;
        float f2 = f;
        int i5 = -1;
        int i6 = i4;
        while (true) {
            i3 = i2 - 1;
            if (i6 > i3) {
                break;
            }
            u(i6, xVar4);
            float fK = x.k(xVar, xVar2, xVar4, xVar3);
            if (fK > f2) {
                f2 = fK;
            }
            if (fK > f2) {
                i5 = i6;
            }
            i6++;
        }
        if (i5 < 0) {
            return 0;
        }
        zArr[i5] = true;
        int iJ = i5 > i4 ? j(f, i, i5, xVar, xVar2, xVar3, xVar4, zArr) + 1 : 1;
        return i5 < i3 ? iJ + j(f, i5, i2, xVar, xVar2, xVar3, xVar4, zArr) : iJ;
    }

    public final x k() {
        int[] iArr = this.b;
        int length = iArr.length;
        int i = iArr[length - 2];
        int i2 = this.e;
        return new x(v(i, i2, this.c), v(iArr[length - 1], i2, this.d), 0);
    }

    public final x l(int i) {
        int[] iArr = this.b;
        int i2 = i + i;
        int i3 = iArr[i2];
        int i4 = this.e;
        return new x(v(i3, i4, this.c), v(iArr[i2 + 1], i4, this.d), 0);
    }

    public final ai p() {
        ai aiVar;
        if (this.h == null) {
            if (e() > 0) {
                aiVar = ai.m(this);
                com.google.android.libraries.navigation.internal.yx.ar.q(aiVar);
            } else {
                aiVar = new ai(new x(), new x());
            }
            this.h = aiVar;
        }
        return this.h;
    }

    public final synchronized List q() {
        if (this.g == null) {
            ArrayList arrayListE = hx.e(e());
            for (int i = 0; i < e(); i++) {
                arrayListE.add(l(i));
            }
            this.g = arrayListE;
        }
        return this.g;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00f3  */
    public final List r(int i) {
        int i2;
        boolean z;
        int i3 = 1073741824;
        com.google.android.libraries.navigation.internal.yx.ar.b(i <= p().a.a && i + 1073741824 >= p().b.a, "The entire polyline's x coordinates should lie in [splitX, splitX + Model.WORLD_WIDTH]");
        if (e() < 2) {
            return hx.d(this);
        }
        ArrayList arrayList = new ArrayList();
        ab abVar = new ab(e());
        x xVarL = l(0);
        abVar.c(xVarL);
        x xVar = new x();
        abVar.b = this.f;
        double dH = 0.0d;
        int i4 = 1;
        while (i4 < e()) {
            u(i4, xVar);
            int i5 = xVar.a;
            int i6 = xVarL.a;
            if (i5 < i6) {
                int i7 = (i5 - i6) + i3;
                if (i7 < i6 - i5) {
                    int i8 = i + LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                    int i9 = (i + i3) - i6;
                    int i10 = xVar.b;
                    int i11 = xVarL.b;
                    int iRound = i11 + ((int) Math.round((((double) (i10 - i11)) * ((double) i9)) / ((double) i7)));
                    x xVar2 = new x(i8, iRound);
                    abVar = abVar;
                    abVar.c(xVar2);
                    double dH2 = dH + ((double) xVarL.h(xVar2));
                    arrayList.add(abVar.a());
                    abVar.b();
                    abVar.b = (float) dH2;
                    x xVar3 = new x(i, iRound);
                    abVar.c(xVar3);
                    dH = dH2 + ((double) xVar3.h(xVar));
                    z = true;
                } else {
                    z = false;
                }
            } else if (i5 <= i6 || (i2 = (i6 - i5) + i3) >= i5 - i6) {
                z = false;
            } else {
                int i12 = i + LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                int i13 = xVar.b;
                int i14 = xVarL.b;
                int iRound2 = i14 + ((int) Math.round((((double) (i13 - i14)) * ((double) (i6 - i))) / ((double) i2)));
                x xVar4 = new x(i, iRound2);
                abVar.c(xVar4);
                double dH3 = dH + ((double) xVarL.h(xVar4));
                arrayList.add(abVar.a());
                abVar.b();
                abVar.b = (float) dH3;
                x xVar5 = new x(i12, iRound2);
                abVar.c(xVar5);
                dH = dH3 + ((double) xVar5.h(xVar));
                z = true;
            }
            if (!z) {
                dH += (double) xVarL.h(xVar);
            }
            xVarL.W(xVar);
            abVar.c(xVar);
            i4++;
            i3 = 1073741824;
        }
        arrayList.add(abVar.a());
        return arrayList;
    }

    public final void s(ac acVar) {
        List listQ = q();
        int size = listQ.size();
        int i = 0;
        double d = 0.0d;
        double d2 = 0.0d;
        while (i < size) {
            x xVar = (x) listQ.get(i);
            double dB = xVar.b() * 1.0E7d;
            double d3 = 1.0E7d * xVar.d();
            acVar.a((int) Math.round(dB - d), (int) Math.round(d3 - d2));
            i++;
            d = dB;
            d2 = d3;
        }
    }

    public final void t(float f, ay ayVar) {
        x xVarC;
        float fA = a();
        float fA2 = a() / 2.0f;
        if (fA2 < f) {
            xVarC = l(1).C(l(0));
        } else {
            float f2 = (fA2 + f) / fA;
            float f3 = (fA2 - f) / fA;
            x xVar = new x();
            x xVar2 = new x();
            i(f2, xVar);
            i(f3, xVar2);
            xVarC = xVar.C(xVar2);
        }
        ayVar.b = xVarC.a;
        ayVar.c = xVarC.b;
        ay.n(ayVar, ayVar);
        ay.o(ayVar, ayVar);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Polyline{");
        for (int i = 0; i < this.b.length; i += 2) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append("(");
            sb.append(this.b[i]);
            sb.append(", ");
            sb.append(this.b[i + 1]);
            sb.append(")");
        }
        sb.append('}');
        return sb.toString();
    }

    public final void u(int i, x xVar) {
        int[] iArr = this.b;
        int i2 = i + i;
        int i3 = iArr[i2];
        int i4 = this.e;
        xVar.a = v(i3, i4, this.c);
        xVar.b = v(iArr[i2 + 1], i4, this.d);
        xVar.c = 0;
    }
}
