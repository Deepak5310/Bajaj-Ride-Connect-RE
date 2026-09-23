package com.google.android.libraries.navigation.internal.abj;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    private final int[] a;
    private volatile e b;
    private volatile float c = -1.0f;

    public d(int[] iArr) {
        this.a = iArr;
    }

    public final float a() {
        int iD = d();
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i2 >= iD) {
                throw new IllegalStateException("all segments are degenerate");
            }
            if (!h(i, i2)) {
                return c(i);
            }
            i = i2;
        }
    }

    public final float b() {
        for (int iD = d() - 2; iD >= 0; iD--) {
            if (!h(iD, iD + 1)) {
                return c(iD);
            }
        }
        throw new IllegalStateException("all segments are degenerate");
    }

    public final float c(int i) {
        int[] iArr = this.a;
        int i2 = i + i;
        return (float) Math.atan2(iArr[i2 + 3] - iArr[i2 + 1], iArr[i2 + 2] - iArr[i2]);
    }

    public final int d() {
        return this.a.length >> 1;
    }

    public final c e() {
        int[] iArr = this.a;
        int length = iArr.length;
        return new c(iArr[length - 2], iArr[length - 1]);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return Arrays.equals(this.a, ((d) obj).a);
        }
        return false;
    }

    public final c f(int i) {
        int[] iArr = this.a;
        int i2 = i + i;
        return new c(iArr[i2], iArr[i2 + 1]);
    }

    public final void g(int i, c cVar) {
        int[] iArr = this.a;
        int i2 = i + i;
        cVar.a = iArr[i2];
        cVar.b = iArr[i2 + 1];
    }

    public final boolean h(int i, int i2) {
        int[] iArr = this.a;
        int i3 = i2 + i2;
        int i4 = i3 + 1;
        int i5 = i + i;
        int i6 = i5 + 1;
        return iArr[i5] == iArr[i3] && iArr[i6] == iArr[i4];
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public final boolean i() {
        int[] iArr = this.a;
        int length = iArr.length;
        return length > 0 && iArr[0] == iArr[length + (-2)] && iArr[1] == iArr[length + (-1)];
    }

    public final boolean j(c cVar) {
        int i;
        int iD;
        c cVarE;
        if (d() > 1) {
            if (this.b == null) {
                if (d() > 0) {
                    c cVarF = f(0);
                    int i2 = cVarF.a;
                    int i3 = cVarF.b;
                    int i4 = i3;
                    int i5 = i2;
                    for (int i6 = 1; i6 < d(); i6++) {
                        g(i6, cVarF);
                        int i7 = cVarF.a;
                        if (i7 < i2) {
                            i2 = i7;
                        }
                        if (i7 > i5) {
                            i5 = i7;
                        }
                        int i8 = cVarF.b;
                        if (i8 < i3) {
                            i3 = i8;
                        }
                        if (i8 > i4) {
                            i4 = i8;
                        }
                    }
                    cVarF.d(i2, i3);
                    this.b = new e(cVarF, new c(i5, i4));
                } else {
                    this.b = new e(new c(), new c());
                }
            }
            e eVar = this.b;
            int i9 = cVar.a;
            c cVar2 = eVar.a;
            if (i9 >= cVar2.a) {
                c cVar3 = eVar.b;
                if (i9 <= cVar3.a && (i = cVar.b) >= cVar2.b && i <= cVar3.b) {
                    if (i()) {
                        int iD2 = d();
                        iD = iD2 - 1;
                        cVarE = f(iD2 - 2);
                    } else {
                        iD = d();
                        cVarE = e();
                    }
                    c cVar4 = new c();
                    int i10 = 0;
                    for (int i11 = 0; i11 < iD; i11++) {
                        g(i11, cVar4);
                        if (c.e(cVarE, cVar4, cVar)) {
                            i10++;
                        }
                        cVarE.c(cVar4);
                    }
                    if ((i10 & 1) == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
