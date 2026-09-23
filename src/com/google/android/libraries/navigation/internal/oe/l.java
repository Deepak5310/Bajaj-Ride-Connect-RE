package com.google.android.libraries.navigation.internal.oe;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l extends aj {
    public x[] a;
    public final ai b;

    public l(x[] xVarArr) {
        this.a = xVarArr;
        this.b = ai.i(xVarArr);
    }

    public static l d(x xVar, x xVar2, x xVar3, x xVar4) {
        return new l(new x[]{xVar, xVar2, xVar4, xVar3});
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aj, com.google.android.libraries.navigation.internal.oe.e
    public final ai a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aj
    public final int c() {
        return 4;
    }

    public final x e() {
        return this.a[3];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            return Arrays.equals(this.a, ((l) obj).a);
        }
        return false;
    }

    public final x f() {
        return this.a[2];
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aj
    public final x g() {
        return this.a[3];
    }

    public final x h() {
        return this.a[0];
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public final x i() {
        return this.a[1];
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aj
    public final x j(int i) {
        return this.a[i];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    @Override // com.google.android.libraries.navigation.internal.oe.aj
    public final boolean k(x xVar) {
        int i;
        for (x xVar2 : this.a) {
            if (xVar2.equals(xVar)) {
                return true;
            }
        }
        x[] xVarArr = this.a;
        ?? F = y.f(xVarArr[0], xVarArr[1], xVar);
        x[] xVarArr2 = this.a;
        int i2 = F;
        if (y.f(xVarArr2[1], xVarArr2[2], xVar)) {
            i2 = F + 1;
        }
        x[] xVarArr3 = this.a;
        int i3 = i2;
        if (y.f(xVarArr3[2], xVarArr3[3], xVar)) {
            i3 = i2 + 1;
        }
        x[] xVarArr4 = this.a;
        int i4 = i3;
        if (y.f(xVarArr4[3], xVarArr4[0], xVar)) {
            i = i3 + 1;
        }
        if (i4 == 1) {
            i4 = i;
            return true;
        }
        i4 = i;
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aj
    public final boolean l(aj ajVar) {
        if (!this.b.b(ajVar)) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (!k(ajVar.j(i))) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        x[] xVarArr = this.a;
        return "[" + String.valueOf(xVarArr[0]) + "," + String.valueOf(xVarArr[1]) + "," + String.valueOf(xVarArr[2]) + "," + String.valueOf(xVarArr[3]) + "]";
    }
}
