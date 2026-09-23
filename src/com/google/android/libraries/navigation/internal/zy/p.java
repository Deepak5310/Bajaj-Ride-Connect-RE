package com.google.android.libraries.navigation.internal.zy;

import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p {
    public static int a(long j, long j2) {
        return Long.compare(d(j), d(j2));
    }

    public static long b(String str) {
        return c(str, 10);
    }

    public static long c(String str, int i) {
        ar.q(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        int i2 = o.c[i] - 1;
        long j = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            int iDigit = Character.digit(str.charAt(i3), i);
            if (iDigit == -1) {
                throw new NumberFormatException(str);
            }
            if (i3 > i2) {
                if (j >= 0) {
                    long j2 = o.a[i];
                    if (j >= j2 && (j > j2 || iDigit > o.b[i])) {
                    }
                }
                throw new NumberFormatException("Too large for unsigned long: ".concat(String.valueOf(str)));
            }
            j = (j * ((long) i)) + ((long) iDigit);
        }
        return j;
    }

    private static long d(long j) {
        return j ^ Long.MIN_VALUE;
    }
}
