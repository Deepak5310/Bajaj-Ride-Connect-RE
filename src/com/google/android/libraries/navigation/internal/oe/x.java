package com.google.android.libraries.navigation.internal.oe;

import com.adobe.internal.xmp.options.PropertyOptions;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x implements Comparable, Serializable {
    public int a;
    public int b;
    public int c;

    public x() {
    }

    public x(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public x(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public x(x xVar) {
        this.a = xVar.a;
        this.b = xVar.b;
        this.c = xVar.c;
    }

    public static x A(double d, double d2) {
        x xVar = new x();
        xVar.L(d, d2);
        return xVar;
    }

    public static void F(x xVar, x xVar2, x xVar3) {
        xVar3.a = xVar.a + xVar2.a;
        xVar3.b = xVar.b + xVar2.b;
        xVar3.c = xVar.c + xVar2.c;
    }

    public static void H(x xVar, x xVar2, float f, x xVar3) {
        int i = xVar2.a;
        int i2 = xVar.a;
        xVar3.a = ((int) ((i - i2) * f)) + i2;
        int i3 = xVar2.b;
        int i4 = xVar.b;
        xVar3.b = ((int) ((i3 - i4) * f)) + i4;
        int i5 = xVar2.c;
        int i6 = xVar.c;
        xVar3.c = ((int) (f * (i5 - i6))) + i6;
    }

    public static void I(x xVar, float f, x xVar2) {
        float f2 = xVar.a;
        float f3 = xVar.b;
        float f4 = xVar.c;
        float fSqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
        xVar2.a = (int) ((f2 * f) / fSqrt);
        xVar2.b = (int) ((f3 * f) / fSqrt);
        xVar2.c = (int) ((f4 * f) / fSqrt);
    }

    public static void N(x xVar, x xVar2, x xVar3) {
        xVar3.a = xVar.a - xVar2.a;
        xVar3.b = xVar.b - xVar2.b;
        xVar3.c = xVar.c - xVar2.c;
    }

    public static int[] R(double d, double d2) {
        int iRound = (int) Math.round(d2 * 0.017453292519943295d * 1.708913188941079E8d);
        if (iRound == 536870912) {
            iRound = d2 < 180.0d ? 536870911 : 536870912;
        }
        return new int[]{iRound, (int) Math.min(Math.max(Math.round(Math.log(Math.tan((d * 0.017453292519943295d * 0.5d) + 0.7853981633974483d)) * 1.708913188941079E8d), -2147483648L), 2147483647L)};
    }

    public static void T(x xVar, x xVar2, x xVar3, x xVar4) {
        float fM = m(xVar, xVar2, xVar3);
        if (fM <= 0.0f) {
            xVar4.W(xVar);
        } else if (fM >= 1.0f) {
            xVar4.W(xVar2);
        } else {
            H(xVar, xVar2, fM, xVar4);
        }
    }

    public static double a(x xVar, x xVar2) {
        x xVarC = xVar2.C(xVar);
        double dAtan2 = Math.atan2(xVarC.a, xVarC.b) * 57.29577951308232d;
        return dAtan2 < 0.0d ? dAtan2 + 360.0d : dAtan2;
    }

    public static double c(int i) {
        double dAtan = Math.atan(Math.exp(((double) i) * 5.8516723170686385E-9d)) - 0.7853981633974483d;
        return (dAtan + dAtan) * 57.29577951308232d;
    }

    public static double f(double d) {
        return 5.36870912E8d / (Math.cos(d * 0.017453292519943295d) * 2.001511821194711E7d);
    }

    public static double g(x xVar, x xVar2) {
        return f(c((xVar.b + xVar2.b) / 2));
    }

    public static float j(x xVar, x xVar2, x xVar3, x xVar4) {
        T(xVar, xVar2, xVar3, xVar4);
        return xVar3.h(xVar4);
    }

    public static float k(x xVar, x xVar2, x xVar3, x xVar4) {
        T(xVar, xVar2, xVar3, xVar4);
        return xVar3.i(xVar4);
    }

    public static float m(x xVar, x xVar2, x xVar3) {
        int i = xVar2.a;
        int i2 = xVar.a;
        int i3 = i - i2;
        int i4 = xVar2.b;
        int i5 = xVar.b;
        int i6 = xVar2.c;
        int i7 = xVar.c;
        int i8 = xVar3.a - i2;
        int i9 = xVar3.b - i5;
        int i10 = xVar3.c - i7;
        float f = i6 - i7;
        float f2 = i4 - i5;
        float f3 = i3;
        return (((f3 * i8) + (f2 * i9)) + (f * i10)) / (((f3 * f3) + (f2 * f2)) + (f * f));
    }

    public static int n(int i) {
        if (i < -536870912) {
            return -536870912;
        }
        if (i >= 536870912) {
            return 536870911;
        }
        return i;
    }

    public static int s(int i) {
        while (i < -536870912) {
            i += 1073741824;
        }
        while (i >= 536870912) {
            i -= 1073741824;
        }
        return i;
    }

    public static x v(x xVar) {
        return new x(xVar.a, xVar.b, xVar.c);
    }

    public static x w(int i, int i2) {
        return A(((double) i) * 1.0E-6d, ((double) i2) * 1.0E-6d);
    }

    public static x x(int i, int i2) {
        return A(((double) i) * 1.0E-7d, ((double) i2) * 1.0E-7d);
    }

    public static x y(com.google.android.libraries.navigation.internal.aas.b bVar) {
        if (bVar == null) {
            return null;
        }
        return A(bVar.b, bVar.c);
    }

    public static x z(r rVar) {
        if (rVar == null) {
            return null;
        }
        return A(rVar.a, rVar.b);
    }

    public final x B(x xVar, float f) {
        x xVar2 = new x();
        H(this, xVar, f, xVar2);
        return xVar2;
    }

    public final x C(x xVar) {
        return new x(this.a - xVar.a, this.b - xVar.b, this.c - xVar.c);
    }

    public final x D(x xVar) {
        int i;
        int i2 = this.a;
        int i3 = i2 - xVar.a;
        if (i3 > 536870912) {
            i = -1073741824;
        } else {
            if (i3 >= -536870912) {
                return this;
            }
            i = 1073741824;
        }
        return new x(i2 + i, this.b);
    }

    public final String E() {
        DecimalFormat decimalFormat = new DecimalFormat("#.#######");
        return String.format(Locale.US, "%s,%s", decimalFormat.format(b()), decimalFormat.format(d()));
    }

    public final void G(x xVar) {
        xVar.a = n(this.a);
        xVar.b = n(this.b);
        xVar.c = this.c;
    }

    public final void J(int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = 0;
    }

    public final void K(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public final void L(double d, double d2) {
        int[] iArrR = R(d, d2);
        J(iArrR[0], iArrR[1]);
    }

    public final void M(int i, int i2) {
        L(((double) i) * 1.0E-7d, ((double) i2) * 1.0E-7d);
    }

    public final void O(x xVar) {
        xVar.a = s(this.a);
        xVar.b = n(this.b);
        xVar.c = this.c;
    }

    public final void P(x xVar, float f, float f2) {
        xVar.a = s(this.a);
        int iCeil = PropertyOptions.DELETE_EXISTING - ((int) Math.ceil((f2 * 0.5f) * w.a(f)));
        if (iCeil < 0) {
            iCeil = 0;
        }
        int i = this.b;
        if (i <= iCeil && i >= (iCeil = -iCeil)) {
            xVar.b = i;
        } else {
            xVar.b = iCeil;
        }
        xVar.c = this.c;
    }

    public final void Q(x xVar) {
        xVar.a = s(this.a);
        xVar.b = this.b;
        xVar.c = this.c;
    }

    public final void S(x xVar) {
        this.a += xVar.a;
        this.b += xVar.b;
        this.c += xVar.c;
    }

    public final void U(double d) {
        double dCos = Math.cos(d);
        double dSin = Math.sin(d);
        double d2 = this.a;
        double d3 = this.b;
        this.a = (int) Math.round((d2 * dCos) - (d3 * dSin));
        this.b = (int) Math.round((d2 * dSin) + (d3 * dCos));
    }

    public final void V(float f) {
        this.a = (int) (this.a * f);
        this.b = (int) (this.b * f);
        this.c = (int) (this.c * f);
    }

    public final void W(x xVar) {
        this.a = xVar.a;
        this.b = xVar.b;
        this.c = xVar.c;
    }

    public final double b() {
        return c(this.b);
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        x xVar = (x) obj;
        int i = this.a;
        int i2 = xVar.a;
        return (i == i2 && (i = this.b) == (i2 = xVar.b)) ? this.c - xVar.c : i - i2;
    }

    public final double d() {
        double d = ((double) this.a) * 5.8516723170686385E-9d * 57.29577951308232d;
        while (d > 180.0d) {
            d -= 360.0d;
        }
        while (d < -180.0d) {
            d += 360.0d;
        }
        return d;
    }

    public final double e() {
        return f(b());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof x) {
            x xVar = (x) obj;
            if (this.a == xVar.a && this.b == xVar.b && this.c == xVar.c) {
                return true;
            }
        }
        return false;
    }

    public final float h(x xVar) {
        return (float) Math.sqrt(i(xVar));
    }

    public final int hashCode() {
        int i = this.a;
        int i2 = this.b;
        int i3 = this.c;
        int i4 = i2 - i3;
        int i5 = ((i - i2) - i3) ^ (i3 >> 13);
        int i6 = (i4 - i5) ^ (i5 << 8);
        int i7 = ((i3 - i5) - i6) ^ (i6 >> 13);
        int i8 = ((i5 - i6) - i7) ^ (i7 >> 12);
        int i9 = ((i6 - i7) - i8) ^ (i8 << 16);
        int i10 = ((i7 - i8) - i9) ^ (i9 >> 5);
        int i11 = ((i8 - i9) - i10) ^ (i10 >> 3);
        int i12 = i10 - i11;
        int i13 = ((i9 - i10) - i11) ^ (i11 << 10);
        return (i13 >> 15) ^ (i12 - i13);
    }

    public final float i(x xVar) {
        int i = this.a - xVar.a;
        int i2 = this.b - xVar.b;
        int i3 = this.c - xVar.c;
        float f = i2;
        float f2 = i;
        float f3 = (f2 * f2) + (f * f);
        float f4 = i3;
        return f3 + (f4 * f4);
    }

    public final float l(x xVar) {
        return (float) (((double) h(xVar)) / g(this, xVar));
    }

    public final int o() {
        return (int) Math.round(b() * 1000000.0d);
    }

    public final int p() {
        return (int) Math.round(b() * 1.0E7d);
    }

    public final int q() {
        return (int) Math.round(d() * 1000000.0d);
    }

    public final int r() {
        return (int) Math.round(d() * 1.0E7d);
    }

    public final r t() {
        return new r(b(), d());
    }

    public final String toString() {
        return "(" + this.a + "," + this.b + "," + this.c + ")";
    }

    public final x u(x xVar) {
        return new x(this.a + xVar.a, this.b + xVar.b, this.c + xVar.c);
    }
}
