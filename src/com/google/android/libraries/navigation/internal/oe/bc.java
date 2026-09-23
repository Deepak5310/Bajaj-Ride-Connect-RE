package com.google.android.libraries.navigation.internal.oe;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bc extends be {
    public final x[] a;
    public final x[] b;
    public final l c;
    public final bd d;
    public final ai e;
    private x[][] g;

    public bc(x[] xVarArr) {
        this.b = new x[xVarArr.length];
        for (int i = 0; i < 4; i++) {
            x[] xVarArr2 = this.b;
            x xVar = new x();
            xVarArr2[i] = xVar;
            xVarArr[i].Q(xVar);
        }
        this.a = xVarArr;
        l lVar = new l(xVarArr);
        this.c = lVar;
        ai aiVar = lVar.b;
        this.e = aiVar;
        bd bdVar = new bd(aiVar);
        this.d = bdVar;
        boolean z = bdVar.f;
        this.f = z;
        if (z) {
            j();
        }
    }

    public static final x[] h(x[] xVarArr) {
        x[] xVarArr2 = new x[xVarArr.length];
        for (int i = 0; i < xVarArr.length; i++) {
            xVarArr2[i] = new x(xVarArr[i]);
        }
        return xVarArr2;
    }

    private static void i(x xVar, x xVar2, int i, x[][] xVarArr) {
        int i2 = xVar2.a;
        int iAbs = Math.abs(i2);
        int i3 = xVar.a;
        int i4 = (iAbs > Math.abs(i3) ? i2 : i3) > 0 ? 536870913 : -536870913;
        int i5 = xVar2.b;
        int i6 = xVar.b;
        int i7 = i5 - i6;
        double d = i6;
        int i8 = i - 1;
        int i9 = (int) (((((double) (i4 - i3)) / ((double) (i2 - i3))) * ((double) i7)) + d);
        if (i3 > i2) {
            xVarArr[i8][1] = new x(-536870913, i9);
            xVarArr[i][0] = new x(536870913, i9);
        } else {
            xVarArr[i8][1] = new x(536870913, i9);
            xVarArr[i][0] = new x(-536870913, i9);
        }
    }

    private final void j() {
        if (this.g == null) {
            this.g = (x[][]) Array.newInstance((Class<?>) x.class, 6, 2);
        }
        x[][] xVarArr = this.g;
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < 4; i2++) {
            boolean z2 = !this.b[i2].equals(this.a[i2]);
            if (z2 != z) {
                if (i2 > 0 && i < 5) {
                    x[] xVarArr2 = this.a;
                    i(xVarArr2[i2 - 1], xVarArr2[i2], i, xVarArr);
                    i++;
                }
                z = z2;
            }
            if (i2 > 0) {
                xVarArr[i - 1][1] = this.b[i2];
            }
            xVarArr[i][0] = this.b[i2];
            i++;
        }
        if (i < 6) {
            x[] xVarArr3 = this.a;
            i(xVarArr3[3], xVarArr3[0], i, xVarArr);
        }
        xVarArr[5][1] = this.b[0];
    }

    @Override // com.google.android.libraries.navigation.internal.oe.be
    public final int a() {
        return this.f ? 6 : 4;
    }

    public final x b(int i) {
        return this.a[i];
    }

    @Override // com.google.android.libraries.navigation.internal.oe.be
    public final x c(int i) {
        return this.b[i];
    }

    @Override // com.google.android.libraries.navigation.internal.oe.be
    public final bd d() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof bc) {
            return Arrays.equals(this.a, ((bc) obj).a);
        }
        return false;
    }

    public final void f() {
        for (int i = 0; i < 4; i++) {
            this.a[i].Q(this.b[i]);
        }
        l lVar = this.c;
        x[] xVarArr = this.a;
        lVar.a = xVarArr;
        lVar.b.p(xVarArr);
        this.d.b(this.e);
        boolean z = this.d.f;
        this.f = z;
        if (z) {
            j();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oe.be
    public final boolean g(x xVar) {
        x xVar2;
        x[][] xVarArr = this.g;
        if (!this.f || xVarArr == null) {
            return this.c.k(xVar);
        }
        int i = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            x[] xVarArr2 = xVarArr[i2];
            x xVar3 = xVarArr2[0];
            if (xVar3 == null || (xVar2 = xVarArr2[1]) == null) {
                return false;
            }
            if (y.f(xVar3, xVar2, xVar)) {
                i++;
            }
        }
        return i == 1;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public final String toString() {
        x[] xVarArr = this.a;
        return "[" + String.valueOf(xVarArr[0]) + "," + String.valueOf(xVarArr[1]) + "," + String.valueOf(xVarArr[2]) + "," + String.valueOf(xVarArr[3]) + "]";
    }

    @Override // com.google.android.libraries.navigation.internal.oe.be
    public final void e(int i, x[] xVarArr) {
        x[][] xVarArr2 = this.g;
        if (!this.f || xVarArr2 == null) {
            xVarArr[0] = c(i);
            xVarArr[1] = c((i + 1) % 4);
        } else {
            xVarArr[0] = xVarArr2[i][0];
            xVarArr[1] = xVarArr2[i][1];
        }
    }
}
