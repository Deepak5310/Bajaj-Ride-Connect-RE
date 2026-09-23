package com.google.android.libraries.geo.mapcore.internal.model;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class cj implements com.google.android.libraries.navigation.internal.oe.e {
    public final int[] c;
    public final float[] d;
    public final float[] e;
    public final int[] f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    private volatile com.google.android.libraries.navigation.internal.oe.ai l = null;
    private static final int[] k = {0, 2, 1, 0, 3, 2};
    public static final boolean[] a = new boolean[1];
    public static final float[] b = new float[0];

    public cj(int[] iArr, float[] fArr, float[] fArr2, int[] iArr2, int i, int i2, int i3, int i4) {
        this.c = iArr;
        this.d = fArr;
        this.e = fArr2;
        this.f = iArr2;
        this.g = i;
        this.h = i2;
        this.i = i3;
        this.j = i4;
    }

    static int[] g(int i, int i2) {
        if (i2 < 3) {
            return new int[0];
        }
        if (i2 == 4) {
            if (i == 0) {
                return k;
            }
            i2 = 4;
        }
        int i3 = i2 - 2;
        int[] iArr = new int[i3 * 3];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            iArr[i4] = i;
            int i6 = i + i5;
            iArr[i4 + 1] = (i6 + 2) % i2;
            iArr[i4 + 2] = (i6 + 1) % i2;
            i4 += 3;
        }
        return iArr;
    }

    private static int h(int i, int i2, int i3) {
        int i4 = i - i3;
        return i2 < 0 ? i4 << (-i2) : i4 >> i2;
    }

    private static int i(int i, int i2, int i3) {
        return (i2 < 0 ? i >> (-i2) : i << i2) + i3;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.e
    public final com.google.android.libraries.navigation.internal.oe.ai a() {
        if (this.l != null) {
            return this.l;
        }
        int[] iArr = this.c;
        if (iArr.length < 2) {
            this.l = new com.google.android.libraries.navigation.internal.oe.ai(new com.google.android.libraries.navigation.internal.oe.x(0, 0), new com.google.android.libraries.navigation.internal.oe.x(0, 0));
            return this.l;
        }
        int i = iArr[0];
        int i2 = this.j;
        int i3 = i(i, i2, this.h);
        int i4 = i(iArr[1], i2, this.i);
        int iMax = i3;
        int i5 = 2;
        int iMax2 = i4;
        int iMin = iMax;
        while (true) {
            int[] iArr2 = this.c;
            if (i5 >= iArr2.length) {
                this.l = new com.google.android.libraries.navigation.internal.oe.ai(new com.google.android.libraries.navigation.internal.oe.x(iMin, i4), new com.google.android.libraries.navigation.internal.oe.x(iMax, iMax2));
                return this.l;
            }
            int i6 = this.j;
            int i7 = i(iArr2[i5], i6, this.h);
            iMin = Math.min(iMin, i7);
            iMax = Math.max(iMax, i7);
            int i8 = i(iArr2[i5 + 1], i6, this.i);
            i4 = Math.min(i4, i8);
            iMax2 = Math.max(iMax2, i8);
            i5 += 2;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oe.e
    public final boolean b(com.google.android.libraries.navigation.internal.oe.aj ajVar) {
        int i = 0;
        if (!a().b(ajVar)) {
            return false;
        }
        int[] iArr = this.c;
        int i2 = iArr[0];
        int i3 = this.j;
        int i4 = 1;
        if (ajVar.k(new com.google.android.libraries.navigation.internal.oe.x(i(i2, i3, this.h), i(iArr[1], i3, this.i), 0))) {
            return true;
        }
        com.google.android.libraries.navigation.internal.oe.x xVarJ = ajVar.j(0);
        if (this.c.length != 0 && a().k(xVarJ)) {
            int i5 = xVarJ.a;
            int i6 = this.j;
            int iH = h(i5, i6, this.h);
            int iH2 = h(xVarJ.b, i6, this.i);
            int i7 = 0;
            while (i7 < d()) {
                int iC = c(i7, i);
                int iC2 = c(i7, i4);
                int iC3 = c(i7, 2);
                int[] iArr2 = this.c;
                int i8 = iArr2[iC];
                int i9 = iArr2[iC + i4];
                int i10 = iArr2[iC2];
                int i11 = iArr2[iC2 + i4];
                int i12 = iArr2[iC3];
                int i13 = iArr2[iC3 + i4];
                int i14 = i11 - i13;
                int i15 = i8 - i12;
                int i16 = i12 - i10;
                int i17 = i9 - i13;
                int i18 = iH - i12;
                int i19 = iH2 - i13;
                int i20 = i13 - i9;
                int i21 = iH;
                double d = (i14 * i15) + (i17 * i16);
                double d2 = (i14 * i18) + (i16 * i19);
                double d3 = (i20 * i18) + (i15 * i19);
                double d4 = (d - d2) - d3;
                if (d < 0.0d) {
                    d = -d;
                    d2 = -d2;
                    d3 = -d3;
                    d4 = -d4;
                }
                if (d2 >= 0.0d && d2 <= d && d3 >= 0.0d && d3 <= d && d4 >= 0.0d && d4 <= d) {
                    return true;
                }
                i7++;
                iH = i21;
                i = 0;
                i4 = 1;
            }
        }
        com.google.android.libraries.navigation.internal.oe.x xVar = new com.google.android.libraries.navigation.internal.oe.x();
        com.google.android.libraries.navigation.internal.oe.x xVar2 = new com.google.android.libraries.navigation.internal.oe.x();
        com.google.android.libraries.navigation.internal.oe.x xVar3 = new com.google.android.libraries.navigation.internal.oe.x();
        com.google.android.libraries.navigation.internal.oe.x xVar4 = ((com.google.android.libraries.navigation.internal.oe.ai) ajVar).a;
        int i22 = 0;
        while (i22 < 4) {
            com.google.android.libraries.navigation.internal.oe.x xVarJ2 = ajVar.j(i22);
            for (int i23 = 0; i23 < d(); i23++) {
                f(i23, xVar, xVar2, xVar3);
                if (com.google.android.libraries.navigation.internal.oe.y.g(xVar, xVar2, xVar4, xVarJ2) || com.google.android.libraries.navigation.internal.oe.y.g(xVar2, xVar3, xVar4, xVarJ2) || com.google.android.libraries.navigation.internal.oe.y.g(xVar3, xVar, xVar4, xVarJ2)) {
                    return true;
                }
            }
            i22++;
            xVar4 = xVarJ2;
        }
        return false;
    }

    public final int c(int i, int i2) {
        int i3 = i * 3;
        int[] iArr = this.f;
        int i4 = (iArr == null || iArr.length <= 0) ? i3 + i2 : iArr[i3 + i2];
        return i4 + i4;
    }

    public final int d() {
        int i;
        int length;
        int[] iArr = this.f;
        if (iArr == null || (length = iArr.length) <= 0) {
            int length2 = this.c.length;
            i = length2 > 0 ? length2 / 6 : 0;
        } else {
            i = length / 3;
        }
        return i == 0 ? this.d.length / 6 : i;
    }

    final com.google.android.libraries.navigation.internal.oe.x e(int i) {
        int[] iArr = this.c;
        int i2 = i + i;
        return new com.google.android.libraries.navigation.internal.oe.x(iArr[i2], iArr[i2 + 1], 0);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof cj) {
            cj cjVar = (cj) obj;
            if (Arrays.equals(this.c, cjVar.c) && Arrays.equals(this.f, cjVar.f)) {
                return true;
            }
        }
        return false;
    }

    public final void f(int i, com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.oe.x xVar2, com.google.android.libraries.navigation.internal.oe.x xVar3) {
        int[] iArr = this.c;
        int iC = c(i, 0);
        int iC2 = c(i, 1);
        int iC3 = c(i, 2);
        if (iArr.length > 0) {
            int i2 = iC + 1;
            int i3 = iArr[iC];
            int i4 = this.j;
            int i5 = this.h;
            xVar.a = i(i3, i4, i5);
            int i6 = this.i;
            xVar.b = i(iArr[i2], i4, i6);
            xVar.c = 0;
            xVar2.a = i(iArr[iC2], i4, i5);
            xVar2.b = i(iArr[iC2 + 1], i4, i6);
            xVar2.c = 0;
            xVar3.a = i(iArr[iC3], i4, i5);
            xVar3.b = i(iArr[iC3 + 1], i4, i6);
            xVar3.c = 0;
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(this.c) + Arrays.hashCode(this.f);
    }
}
