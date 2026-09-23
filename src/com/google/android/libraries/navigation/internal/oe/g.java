package com.google.android.libraries.navigation.internal.oe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    public static int a(int i, int i2) {
        long j;
        long j2 = ((long) i) + ((long) i2);
        if (j2 > -1800000000) {
            j = j2 > 1800000000 ? -3600000000L : 3600000000L;
            return (int) j2;
        }
        j2 += j;
        return (int) j2;
    }
}
