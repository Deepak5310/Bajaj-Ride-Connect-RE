package com.google.android.libraries.navigation.internal.yz;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class lm extends ll {
    transient long[] i;
    private transient int j;
    private transient int k;

    lm() {
        this(null);
    }

    private final int s(int i) {
        return (int) (this.i[i] >>> 32);
    }

    private final int t(int i) {
        return (int) this.i[i];
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ll
    public final int a() {
        int i = this.j;
        if (i == -2) {
            return -1;
        }
        return i;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ll
    public final int f(int i) {
        int iT = t(i);
        if (iT == -2) {
            return -1;
        }
        return iT;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ll
    public final int g(int i, int i2) {
        return i == this.c ? i2 : i;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ll
    public final void l() {
        super.l();
        this.j = -2;
        this.k = -2;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ll
    public final void m(int i, Object obj, int i2, int i3) {
        super.m(i, obj, i2, i3);
        u(this.k, i);
        u(i, -2);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ll
    public final void n(int i) {
        int i2 = this.c - 1;
        u(s(i), t(i));
        if (i < i2) {
            u(s(i2), i);
            u(i, t(i2));
        }
        super.n(i);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ll
    public final void o(int i) {
        super.o(i);
        long[] jArr = this.i;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i);
        this.i = jArrCopyOf;
        Arrays.fill(jArrCopyOf, length, i, -1L);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ll
    public final void r() {
        super.r();
        this.j = -2;
        this.k = -2;
        long[] jArr = new long[3];
        this.i = jArr;
        Arrays.fill(jArr, -1L);
    }

    public lm(byte[] bArr) {
        super(null);
    }

    private final void u(int i, int i2) {
        if (i == -2) {
            this.j = i2;
            i = -2;
        } else {
            long[] jArr = this.i;
            jArr[i] = (jArr[i] & (-4294967296L)) | (((long) i2) & 4294967295L);
        }
        if (i2 == -2) {
            this.k = i;
        } else {
            long[] jArr2 = this.i;
            jArr2[i2] = (4294967295L & jArr2[i2]) | (((long) i) << 32);
        }
    }
}
