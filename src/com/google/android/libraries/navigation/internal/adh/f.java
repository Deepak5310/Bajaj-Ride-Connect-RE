package com.google.android.libraries.navigation.internal.adh;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends d {
    public int b = 0;

    @Override // com.google.android.libraries.navigation.internal.adh.d
    public final void c() {
        this.b = 0;
    }

    public final void f(int i, int i2) {
        if (this.a == null) {
            this.a = new int[16];
            Arrays.fill(this.a, -1);
        }
        int i3 = this.b;
        int i4 = i3 + i3;
        int[] iArr = this.a;
        int length = iArr.length;
        if (i4 == length) {
            this.a = new int[length + length];
            System.arraycopy(iArr, 0, this.a, 0, length);
            int[] iArr2 = this.a;
            Arrays.fill(iArr2, length, iArr2.length, -1);
        }
        int[] iArr3 = this.a;
        int i5 = this.b;
        int i6 = i5 + i5;
        iArr3[i6] = i;
        iArr3[i6 + 1] = i2;
        this.b = i5 + 1;
    }
}
