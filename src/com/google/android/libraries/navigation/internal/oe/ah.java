package com.google.android.libraries.navigation.internal.oe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ah {
    public static double a(int i, int i2, int i3, int i4, int i5, int i6, double d, x xVar) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        double d2 = d;
        double d3 = 0.0d;
        while (true) {
            int i11 = (((i9 + i9) + i7) + i5) / 4;
            int i12 = (((i10 + i10) + i8) + i6) / 4;
            int i13 = ((i8 + i6) / 2) - i12;
            int i14 = ((i7 + i5) / 2) - i11;
            if ((i14 * i14) + (i13 * i13) <= 0) {
                double d4 = i5 - i7;
                double d5 = i6 - i8;
                double dHypot = Math.hypot(d4, d5);
                if (dHypot < d2) {
                    return d3 + dHypot;
                }
                double d6 = dHypot != 0.0d ? d2 / dHypot : 0.0d;
                xVar.J((int) (((double) i7) + (d6 * d4)), (int) (((double) i8) + (d5 * d6)));
                return -1.0d;
            }
            double dA = a(i7, i8, (i7 + i9) / 2, (i8 + i10) / 2, i11, i12, d2, xVar);
            if (dA < 0.0d) {
                return -1.0d;
            }
            d3 += dA;
            d2 -= dA;
            i9 = (i9 + i5) / 2;
            i10 = (i10 + i6) / 2;
            i7 = i11;
            i8 = i12;
        }
    }
}
