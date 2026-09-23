package com.google.android.libraries.navigation.internal.yz;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class ll {
    transient Object[] a;
    transient int[] b;
    transient int c;
    transient int d;
    public transient int[] e;
    transient long[] f;
    public transient float g;
    public transient int h;

    ll() {
        r();
    }

    public static int b(long j) {
        return (int) (j >>> 32);
    }

    public static long j(long j, int i) {
        return (j & (-4294967296L)) | (((long) i) & 4294967295L);
    }

    public static int[] q(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public int a() {
        return this.c == 0 ? -1 : 0;
    }

    final int c(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.p(i, this.c);
        return this.b[i];
    }

    public final int d() {
        return this.e.length - 1;
    }

    final int e(Object obj) {
        int iB = eh.b(obj);
        int i = this.e[d() & iB];
        while (i != -1) {
            long j = this.f[i];
            if (b(j) == iB && com.google.android.libraries.navigation.internal.yx.am.a(obj, this.a[i])) {
                return i;
            }
            i = (int) j;
        }
        return -1;
    }

    public int f(int i) {
        int i2 = i + 1;
        if (i2 < this.c) {
            return i2;
        }
        return -1;
    }

    public int g(int i, int i2) {
        return i - 1;
    }

    public final int h(Object obj, int i) {
        int iD = d() & i;
        int i2 = this.e[iD];
        if (i2 == -1) {
            return 0;
        }
        int i3 = -1;
        while (true) {
            if (b(this.f[i2]) == i && com.google.android.libraries.navigation.internal.yx.am.a(obj, this.a[i2])) {
                int i4 = this.b[i2];
                if (i3 == -1) {
                    this.e[iD] = (int) this.f[i2];
                } else {
                    long[] jArr = this.f;
                    jArr[i3] = j(jArr[i3], (int) jArr[i2]);
                }
                n(i2);
                this.c--;
                this.d++;
                return i4;
            }
            int i5 = (int) this.f[i2];
            if (i5 == -1) {
                return 0;
            }
            i3 = i2;
            i2 = i5;
        }
    }

    final int i(int i) {
        return h(this.a[i], b(this.f[i]));
    }

    final Object k(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.p(i, this.c);
        return this.a[i];
    }

    public void l() {
        this.d++;
        Arrays.fill(this.a, 0, this.c, (Object) null);
        Arrays.fill(this.b, 0, this.c, 0);
        Arrays.fill(this.e, -1);
        Arrays.fill(this.f, -1L);
        this.c = 0;
    }

    public void m(int i, Object obj, int i2, int i3) {
        this.f[i] = (((long) i3) << 32) | 4294967295L;
        this.a[i] = obj;
        this.b[i] = i2;
    }

    public void n(int i) {
        int i2 = this.c - 1;
        if (i >= i2) {
            this.a[i] = null;
            this.b[i] = 0;
            this.f[i] = -1;
            return;
        }
        Object[] objArr = this.a;
        objArr[i] = objArr[i2];
        int[] iArr = this.b;
        iArr[i] = iArr[i2];
        objArr[i2] = null;
        iArr[i2] = 0;
        long[] jArr = this.f;
        long j = jArr[i2];
        jArr[i] = j;
        jArr[i2] = -1;
        int iB = b(j) & d();
        int[] iArr2 = this.e;
        int i3 = iArr2[iB];
        if (i3 == i2) {
            iArr2[iB] = i;
            return;
        }
        while (true) {
            long[] jArr2 = this.f;
            long j2 = jArr2[i3];
            int i4 = (int) j2;
            if (i4 == i2) {
                jArr2[i3] = j(j2, i);
                return;
            }
            i3 = i4;
        }
    }

    public void o(int i) {
        this.a = Arrays.copyOf(this.a, i);
        this.b = Arrays.copyOf(this.b, i);
        long[] jArr = this.f;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(jArrCopyOf, length, i, -1L);
        }
        this.f = jArrCopyOf;
    }

    final void p(int i, int i2) {
        com.google.android.libraries.navigation.internal.yx.ar.p(i, this.c);
        this.b[i] = i2;
    }

    public void r() {
        com.google.android.libraries.navigation.internal.yx.ar.b(true, "Initial capacity must be non-negative");
        com.google.android.libraries.navigation.internal.yx.ar.b(true, "Illegal load factor");
        int iC = eh.c(3);
        this.e = q(iC);
        this.g = 1.0f;
        this.a = new Object[3];
        this.b = new int[3];
        long[] jArr = new long[3];
        Arrays.fill(jArr, -1L);
        this.f = jArr;
        this.h = Math.max(1, iC);
    }

    public ll(byte[] bArr) {
        r();
    }
}
