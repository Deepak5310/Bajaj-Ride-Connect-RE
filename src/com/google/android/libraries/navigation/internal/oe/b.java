package com.google.android.libraries.navigation.internal.oe;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    double a;
    double b;
    double c;
    double d;

    public b(double d) {
        this.d = d;
        this.c = d;
        this.b = d;
        this.a = d;
    }

    public static double a(double d, double d2, double d3, double d4) {
        return (((((-d) * 5.0d) / 6.0d) + (d2 * 3.0d)) - ((d3 * 3.0d) / 2.0d)) + (d4 / 3.0d);
    }

    public static double b(double d, double d2, double d3, double d4) {
        return (((d / 3.0d) - ((d2 * 3.0d) / 2.0d)) + (d3 * 3.0d)) - ((d4 * 5.0d) / 6.0d);
    }

    public static double d(double d, double d2, double d3, double d4, double d5) {
        double dMin = Math.min(1.0d, Math.max(0.0d, d));
        double d6 = 1.0d - dMin;
        double d7 = d5 - d4;
        return (d6 * d6 * 3.0d * (d3 - d2)) + (6.0d * d6 * dMin * (d4 - d3)) + (dMin * dMin * 3.0d * d7);
    }

    public static double f(double d, double d2, double d3, double d4, double d5) {
        if (d > 1.0d) {
            return d5 + (d(1.0d, d2, d3, d4, d5) * ((-1.0d) + d));
        }
        if (d < 0.0d) {
            return (d(0.0d, d2, d3, d4, d5) * d) + d2;
        }
        double d6 = 1.0d - d;
        double d7 = d6 * d6;
        double d8 = d * d;
        return (d7 * d6 * d2) + (d7 * 3.0d * d * d3) + (d6 * 3.0d * d8 * d4) + (d8 * d * d5);
    }

    public final double c(double d) {
        return d(d, this.a, this.b, this.c, this.d);
    }

    public final double e(double d) {
        return f(d, this.a, this.b, this.c, this.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d) {
                return true;
            }
        }
        return false;
    }

    public final void g(double d, double d2, double d3) {
        double dE = e(d);
        while (dE < (-180.0d) + d2) {
            d2 -= 360.0d;
        }
        double d4 = d2;
        while (dE > 180.0d + d4) {
            d4 += 360.0d;
        }
        h(d, d4, d3);
    }

    public final void h(double d, double d2, double d3) {
        i(e(d), c(d), d2, d3);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Double.valueOf(this.a), Double.valueOf(this.b), Double.valueOf(this.c), Double.valueOf(this.d)});
    }

    public final void i(double d, double d2, double d3, double d4) {
        this.a = d;
        this.d = d3;
        this.b = d + (d2 / 3.0d);
        this.c = d3 - (d4 / 3.0d);
    }
}
