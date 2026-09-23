package com.google.android.libraries.navigation.internal.gz;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class e {
    public int a;
    private int[] b;

    public e() {
        this(16);
    }

    public e(int i) {
        this.b = new int[i];
    }

    public final void a(int i) {
        int i2 = this.a;
        int[] iArr = this.b;
        int length = iArr.length;
        if (i2 >= length) {
            int[] iArr2 = new int[length + length];
            System.arraycopy(iArr, 0, iArr2, 0, length);
            this.b = iArr2;
        }
        int[] iArr3 = this.b;
        int i3 = this.a;
        this.a = i3 + 1;
        iArr3[i3] = i;
    }

    public final void b(int i) {
        while (true) {
            int[] iArr = this.b;
            int length = iArr.length;
            if (i <= length) {
                return;
            } else {
                this.b = Arrays.copyOf(iArr, length + length);
            }
        }
    }

    public final boolean c() {
        return this.a == 0;
    }

    public final int[] d() {
        int i = this.a;
        int[] iArr = new int[i];
        System.arraycopy(this.b, 0, iArr, 0, i);
        return iArr;
    }
}
