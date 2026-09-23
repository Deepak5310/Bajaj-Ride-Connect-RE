package com.google.android.libraries.navigation.internal.oe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y {
    public static float a(float f, float f2) {
        float fAbs = Math.abs(f - f2);
        return fAbs > 180.0f ? 360.0f - fAbs : fAbs;
    }

    public static float b(double d, double d2) {
        float degrees = 90.0f - ((float) Math.toDegrees(Math.atan2(d2, d)));
        return degrees < 0.0f ? degrees + 360.0f : degrees;
    }

    public static float c(x xVar, x xVar2) {
        return b(xVar2.a - xVar.a, xVar2.b - xVar.b);
    }

    public static float d(float f, float f2) {
        float f3 = f2 - f;
        while (f3 > 180.0f) {
            f3 -= 360.0f;
        }
        while (f3 < -180.0f) {
            f3 += 360.0f;
        }
        return f3;
    }

    public static int e(x xVar, x xVar2, x xVar3) {
        int i = xVar3.a;
        int i2 = i - xVar.a;
        int i3 = xVar3.b;
        long j = (((long) i2) * ((long) (i3 - xVar2.b))) - (((long) (i3 - xVar.b)) * ((long) (i - xVar2.a)));
        return (int) (((long) (j != 0 ? 1 : 0)) | (j >> 63));
    }

    public static boolean f(x xVar, x xVar2, x xVar3) {
        int i = xVar.a;
        int i2 = xVar.b;
        int i3 = xVar2.a;
        int i4 = xVar2.b;
        int i5 = xVar3.a;
        int i6 = xVar3.b;
        if (i2 <= i6 && i4 <= i6) {
            return false;
        }
        if (i5 >= i && i5 >= i3) {
            return false;
        }
        if (i5 < i && i5 < i3) {
            return false;
        }
        int i7 = i5 - i;
        long j = i4 - i2;
        long j2 = i6 - i2;
        if (i3 >= i) {
            return ((long) i7) * j > j2 * ((long) (i3 - i));
        }
        return ((long) i7) * j < j2 * ((long) (i3 - i));
    }

    public static boolean g(x xVar, x xVar2, x xVar3, x xVar4) {
        int i = xVar2.a;
        int i2 = xVar.a;
        int i3 = i - i2;
        int i4 = xVar2.b;
        int i5 = xVar.b;
        int i6 = i4 - i5;
        int i7 = xVar4.a;
        int i8 = xVar3.a;
        int i9 = i7 - i8;
        int i10 = xVar4.b;
        int i11 = xVar3.b;
        int i12 = i10 - i11;
        int i13 = i8 - i2;
        int i14 = i11 - i5;
        long j = i12;
        long j2 = i3;
        long j3 = i9;
        long j4 = i6;
        long j5 = (j3 * j4) - (j * j2);
        if (j5 != 0) {
            long j6 = i14;
            double d = ((((long) (-i13)) * j4) + (j2 * j6)) / j5;
            if (d >= 0.0d && d <= 1.0d) {
                double d2 = ((((long) i13) * j) - (j6 * j3)) / (-j5);
                if (d2 >= 0.0d && d2 <= 1.0d) {
                    return true;
                }
            }
            return false;
        }
        if (i13 == 0) {
            if (i14 == 0) {
                return true;
            }
            i13 = 0;
        }
        if ((((long) i13) * j4) - (((long) i14) * j2) != 0) {
            return false;
        }
        if (i3 == 0 && i6 == 0) {
            return i(xVar3, xVar4, xVar);
        }
        if (i9 == 0 && i12 == 0) {
            return i(xVar, xVar2, xVar3);
        }
        return i(xVar, xVar2, xVar3) || i(xVar, xVar2, xVar4) || i(xVar3, xVar4, xVar) || i(xVar3, xVar4, xVar2);
    }

    public static void h(x xVar, x xVar2, x xVar3, x xVar4, x xVar5) {
        double d;
        int i = xVar.b;
        int i2 = i - xVar2.b;
        int i3 = xVar2.a;
        int i4 = xVar.a;
        int i5 = xVar4.a;
        int i6 = xVar3.a;
        int i7 = xVar4.b;
        int i8 = xVar3.b;
        long j = i3 - i4;
        long j2 = i2;
        long j3 = (((long) (i5 - i6)) * j2) + (((long) (i7 - i8)) * j);
        if (j3 != 0) {
            d = ((((long) (i4 - i6)) * j2) + (((long) (i - i8)) * j)) / j3;
        } else if (e(xVar, xVar2, xVar3) == 0) {
            d = 0.0d;
        } else {
            d = e(xVar, xVar2, xVar4) == 0 ? 1.0d : Double.NaN;
        }
        if (Double.isNaN(d) || d < 0.0d || d > 1.0d) {
            return;
        }
        int i9 = xVar3.a;
        xVar5.a = (int) (((double) i9) + (((double) (xVar4.a - i9)) * d));
        int i10 = xVar3.b;
        xVar5.b = (int) (((double) i10) + (((double) (xVar4.b - i10)) * d));
    }

    private static boolean i(x xVar, x xVar2, x xVar3) {
        int i;
        int i2 = xVar.a;
        int i3 = xVar2.a;
        int iMin = Math.min(i2, i3);
        int iMax = Math.max(i2, i3);
        int i4 = xVar.b;
        int i5 = xVar2.b;
        int iMin2 = Math.min(i4, i5);
        int iMax2 = Math.max(i4, i5);
        int i6 = xVar3.a;
        return i6 <= iMax && i6 >= iMin && (i = xVar3.b) <= iMax2 && i >= iMin2 && (i5 - i4) * (i6 - i2) == (i - i4) * (i3 - i2);
    }
}
