package com.google.android.libraries.navigation.internal.zy;

import java.math.BigInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class o {
    static final long[] a = new long[37];
    static final int[] b = new int[37];
    static final int[] c = new int[37];

    static {
        long j;
        BigInteger bigInteger = new BigInteger("10000000000000000", 16);
        for (int i = 2; i <= 36; i++) {
            long j2 = i;
            long j3 = -1;
            if (j2 < 0) {
                j = p.a(-1L, j2) < 0 ? 0L : 1L;
            } else {
                long j4 = Long.MAX_VALUE / j2;
                long j5 = j4 + j4;
                j = j5 + ((long) (p.a((-1) - (j5 * j2), j2) >= 0 ? 1 : 0));
            }
            a[i] = j;
            if (j2 < 0) {
                if (p.a(-1L, j2) < 0) {
                }
                b[i] = (int) j3;
                c[i] = bigInteger.toString(i).length() - 1;
            } else {
                long j6 = Long.MAX_VALUE / j2;
                j3 = (-1) - ((j6 + j6) * j2);
                if (p.a(j3, j2) < 0) {
                    j2 = 0;
                }
            }
            j3 -= j2;
            b[i] = (int) j3;
            c[i] = bigInteger.toString(i).length() - 1;
        }
    }
}
