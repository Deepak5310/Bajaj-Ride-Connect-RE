package com.google.android.libraries.navigation.internal.zy;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    private int b = 0;
    private long[] a = new long[10];

    public f(int i) {
    }

    public final g a() {
        return this.b == 0 ? g.a : new g(this.a, this.b);
    }

    public final void b(long j) {
        int i = this.b;
        int i2 = i + 1;
        long[] jArr = this.a;
        int length = jArr.length;
        if (i2 > length) {
            int i3 = length + (length >> 1) + 1;
            if (i3 < i2) {
                int iHighestOneBit = Integer.highestOneBit(i);
                i3 = iHighestOneBit + iHighestOneBit;
            }
            if (i3 < 0) {
                i3 = Integer.MAX_VALUE;
            }
            this.a = Arrays.copyOf(jArr, i3);
        }
        long[] jArr2 = this.a;
        int i4 = this.b;
        jArr2[i4] = j;
        this.b = i4 + 1;
    }
}
