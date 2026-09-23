package com.google.android.libraries.navigation.internal.zy;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    private int[] a;
    private int b = 0;

    public d(int i) {
        this.a = new int[i];
    }

    public final e a() {
        return this.b == 0 ? e.a : new e(this.a, 0, this.b);
    }

    public final void b(int i) {
        int i2 = this.b;
        int i3 = i2 + 1;
        int[] iArr = this.a;
        int length = iArr.length;
        if (i3 > length) {
            int i4 = length + (length >> 1) + 1;
            if (i4 < i3) {
                int iHighestOneBit = Integer.highestOneBit(i2);
                i4 = iHighestOneBit + iHighestOneBit;
            }
            if (i4 < 0) {
                i4 = Integer.MAX_VALUE;
            }
            this.a = Arrays.copyOf(iArr, i4);
        }
        int[] iArr2 = this.a;
        int i5 = this.b;
        iArr2[i5] = i;
        this.b = i5 + 1;
    }
}
