package com.google.android.libraries.navigation.internal.zw;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.math.RoundingMode;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    public static int a(long j, int i) {
        long j2 = i;
        long j3 = j % j2;
        if (j3 < 0) {
            j3 += j2;
        }
        return (int) j3;
    }

    public static long b(long j, long j2) {
        long j3 = j + j2;
        h.b(((j ^ j2) < 0) | ((j ^ j3) >= 0), "checkedAdd", j, j2);
        return j3;
    }

    public static long c(long j, long j2) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j2);
        long j3 = j * j2;
        if (iNumberOfLeadingZeros > 65) {
            return j3;
        }
        h.b(iNumberOfLeadingZeros >= 64, "checkedMultiply", j, j2);
        h.b(true, "checkedMultiply", j, j2);
        h.b(j == 0 || j3 / j == j2, "checkedMultiply", j, j2);
        return j3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        if (r8 > 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
    
        if (r8 < 0) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long d(long j, long j2, RoundingMode roundingMode) {
        ar.q(roundingMode);
        long j3 = j / j2;
        long j4 = j - (j2 * j3);
        if (j4 != 0) {
            int i = ((int) ((j ^ j2) >> 63)) | 1;
            switch (f.a[roundingMode.ordinal()]) {
                case 1:
                    h.c(false);
                case 2:
                case 3:
                    break;
                case 4:
                    return j3 + ((long) i);
                case 5:
                    break;
                case 6:
                case 7:
                case 8:
                    long jAbs = Math.abs(j4);
                    long jAbs2 = jAbs - (Math.abs(j2) - jAbs);
                    return jAbs2 != 0 ? j3 : j3;
                default:
                    throw new AssertionError();
            }
        }
    }

    public static long e(long j, long j2) {
        boolean z = (j ^ j2) < 0;
        long j3 = j2 + j;
        return z | ((j ^ j3) >= 0) ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
    }
}
