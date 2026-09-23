package com.google.android.libraries.navigation.internal.oe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class al extends aj {
    protected final x a;
    public final int b;
    public final int c;
    public final float d;

    public al(x xVar, int i, int i2, float f) {
        this.a = xVar;
        this.b = i;
        this.c = i2;
        this.d = f;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aj
    public final int c() {
        return 4;
    }

    public final void d(x xVar) {
        xVar.W(this.a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof al) {
            al alVar = (al) obj;
            if (alVar.a.equals(this.a) && alVar.b == this.b && alVar.c == this.c && alVar.d == this.d) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aj
    public final x g() {
        return j(3);
    }

    public final int hashCode() {
        return ((((((this.a.hashCode() + 31) * 31) + this.b) * 31) + this.c) * 31) + ((int) (this.d * 1000.0f));
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aj
    public final x j(int i) {
        if (i > 3) {
            throw new ArrayIndexOutOfBoundsException();
        }
        x xVar = new x();
        if (i == 0) {
            xVar.J((-this.b) / 2, (-this.c) / 2);
        } else if (i == 1) {
            xVar.J((-this.b) / 2, this.c / 2);
        } else if (i == 2) {
            xVar.J(this.b / 2, this.c / 2);
        } else if (i == 3) {
            xVar.J(this.b / 2, (-this.c) / 2);
        }
        x xVar2 = this.a;
        xVar.U(Math.toRadians(-this.d));
        return xVar2.u(xVar);
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aj
    public final boolean k(x xVar) {
        int i;
        x xVar2 = new x();
        xVar2.W(this.a);
        xVar2.U(Math.toRadians(this.d));
        int i2 = xVar2.a;
        int i3 = this.b / 2;
        int i4 = i2 - i3;
        int i5 = i2 + i3;
        int i6 = xVar2.b;
        int i7 = this.c / 2;
        int i8 = i6 + i7;
        int i9 = i6 - i7;
        xVar.U(Math.toRadians(this.d));
        int i10 = xVar.a;
        return i10 >= i4 && i10 <= i5 && (i = xVar.b) <= i8 && i >= i9;
    }

    public final String toString() {
        return "Center: " + String.valueOf(this.a) + " Bearing: " + this.d + " Dimensions: " + this.b + "x" + this.c;
    }
}
