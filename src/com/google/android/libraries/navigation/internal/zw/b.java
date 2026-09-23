package com.google.android.libraries.navigation.internal.zw;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.math.RoundingMode;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    static double a(double d, RoundingMode roundingMode) {
        long j;
        if (!c.a(d)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (a.a[roundingMode.ordinal()]) {
            case 1:
                h.c(d(d));
                return d;
            case 2:
                if (d >= 0.0d || d(d)) {
                    return d;
                }
                j = -1;
                break;
            case 3:
                if (d <= 0.0d || d(d)) {
                    return d;
                }
                j = 1;
                break;
            case 4:
                return d;
            case 5:
                if (d(d)) {
                    return d;
                }
                return ((long) d) + ((long) (d > 0.0d ? 1 : -1));
            case 6:
                return Math.rint(d);
            case 7:
                double dRint = Math.rint(d);
                return Math.abs(d - dRint) == 0.5d ? d + Math.copySign(0.5d, d) : dRint;
            case 8:
                double dRint2 = Math.rint(d);
                return Math.abs(d - dRint2) == 0.5d ? d : dRint2;
            default:
                throw new AssertionError();
        }
        return ((long) d) + j;
    }

    public static int b(double d, RoundingMode roundingMode) {
        double dA = a(d, roundingMode);
        h.a((dA > -2.147483649E9d) & (dA < 2.147483648E9d), d, roundingMode);
        return (int) dA;
    }

    public static long c(double d, RoundingMode roundingMode) {
        double dA = a(d, roundingMode);
        h.a(((-9.223372036854776E18d) - dA < 1.0d) & (dA < 9.223372036854776E18d), d, roundingMode);
        return (long) dA;
    }

    public static boolean d(double d) {
        if (!c.a(d)) {
            return false;
        }
        if (d == 0.0d) {
            return true;
        }
        ar.b(c.a(d), "not a normal value");
        int exponent = Math.getExponent(d);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d) & 4503599627370495L;
        return 52 - Long.numberOfTrailingZeros(exponent == -1023 ? jDoubleToRawLongBits + jDoubleToRawLongBits : jDoubleToRawLongBits | 4503599627370496L) <= Math.getExponent(d);
    }
}
