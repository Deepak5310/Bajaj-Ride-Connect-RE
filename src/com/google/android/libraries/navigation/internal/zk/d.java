package com.google.android.libraries.navigation.internal.zk;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements Comparable, Serializable {
    public static final d[] a;
    private static final int[] c = new int[1024];
    private static final int[] d = new int[1024];
    public final long b;

    static {
        p(0, 0, 0, 0, 0, 0);
        p(0, 0, 0, 1, 0, 1);
        p(0, 0, 0, 2, 0, 2);
        p(0, 0, 0, 3, 0, 3);
        a = new d[6];
        for (int i = 0; i < 6; i++) {
            a[i] = new d((((long) i) << 61) + f(0));
        }
    }

    public d() {
        this(0L);
    }

    public d(long j) {
        this.b = j;
    }

    static int b(long j) {
        return (int) (j >>> 33);
    }

    static int c(long j) {
        return (int) ((j >>> 2) & 2147483647L);
    }

    public static long f(int i) {
        int i2 = 30 - i;
        return 1 << (i2 + i2);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0052  */
    /* JADX WARN: Code duplicated, block: B:18:0x0056  */
    /* JADX WARN: Code duplicated, block: B:19:0x0058  */
    public static d h(e eVar) {
        int i;
        double d2 = eVar.a;
        double dCos = Math.cos(d2);
        double d3 = eVar.b;
        f fVar = new f(Math.cos(d3) * dCos, dCos * Math.sin(d3), Math.sin(d2));
        double d4 = fVar.g;
        double d5 = fVar.h;
        double d6 = fVar.i;
        double dAbs = Math.abs(d4);
        double dAbs2 = Math.abs(d5);
        double dAbs3 = Math.abs(d6);
        if (dAbs > dAbs2) {
            if (dAbs > dAbs3) {
                i = d4 < 0.0d ? 3 : 0;
            } else if (d6 < 0.0d) {
                i = 5;
            } else {
                i = 2;
            }
        } else if (dAbs2 > dAbs3) {
            i = d5 < 0.0d ? 4 : 1;
        } else if (d6 < 0.0d) {
            i = 5;
        } else {
            i = 2;
        }
        s sVar = u.a[i];
        int iE = u.e(u.d(sVar.a(fVar.g, fVar.h, fVar.i)));
        int iE2 = u.e(u.d(sVar.b(fVar.g, fVar.h, fVar.i)));
        int iN = i & 1;
        long jO = ((long) i) << 28;
        for (int i2 = 7; i2 >= 4; i2--) {
            int iM = m(iE, iE2, i2, iN);
            jO = o(jO, i2, iM);
            iN = n(iM);
        }
        long jO2 = 0;
        for (int i3 = 3; i3 >= 0; i3--) {
            int iM2 = m(iE, iE2, i3, iN);
            jO2 = o(jO2, i3, iM2);
            iN = n(iM2);
        }
        long j = (jO << 32) + jO2;
        return new d(j + j + 1);
    }

    private static final int m(int i, int i2, int i3, int i4) {
        int i5 = i3 * 4;
        return c[i4 + (((i >> i5) & 15) << 6) + (((i2 >> i5) & 15) << 2)];
    }

    private static final int n(int i) {
        return i & 3;
    }

    private static final long o(long j, int i, int i2) {
        int i3 = i & 3;
        return j | ((((long) i2) >> 2) << ((i3 + i3) * 4));
    }

    private static void p(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i5 << 2;
        if (i == 4) {
            int i8 = ((i2 << 4) + i3) << 2;
            c[i8 + i4] = i7 + i6;
            d[i7 + i4] = i8 + i6;
            return;
        }
        int i9 = i + 1;
        int i10 = i2 + i2;
        int i11 = i3 + i3;
        int i12 = 0;
        while (i12 < 4) {
            int i13 = b.d[i6][i12];
            ar.a(i12 >= 0 && i12 < 4);
            p(i9, (i13 >>> 1) + i10, i11 + (i13 & 1), i4, i7 + i12, i6 ^ b.c[i12]);
            i12++;
        }
    }

    public final int a() {
        return (int) (this.b >>> 61);
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        long j = ((d) obj).b - Long.MIN_VALUE;
        long j2 = this.b - Long.MIN_VALUE;
        if (j2 < j) {
            return -1;
        }
        return j2 <= j ? 0 : 1;
    }

    public final int d() {
        if (l()) {
            return 30;
        }
        return 30 - (Long.numberOfTrailingZeros(this.b) >> 1);
    }

    public final long e() {
        return Long.lowestOneBit(this.b);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof d) && this.b == ((d) obj).b;
    }

    final long g() {
        int iA = a() & 1;
        int i = 0;
        int i2 = 7;
        int i3 = 0;
        while (i2 >= 0) {
            int i4 = i2 == 7 ? 2 : 4;
            int i5 = d[iA + ((((1 << (i4 + i4)) - 1) & ((int) (this.b >>> (((i2 + i2) * 4) + 1)))) << 2)];
            int i6 = i2 * 4;
            i += (i5 >> 6) << i6;
            i3 += ((i5 >> 2) & 15) << i6;
            iA = n(i5);
            i2--;
        }
        if ((e() & 1229782938247303440L) != 0) {
            iA ^= 1;
        }
        return (((long) i) << 33) | (((long) i3) << 2) | ((long) iA);
    }

    public final int hashCode() {
        long j = this.b;
        return (int) ((j >>> 32) + j);
    }

    public final d i(int i) {
        long jF = f(i);
        return new d(jF | (this.b & (-jF)));
    }

    public final e j() {
        return new e(k());
    }

    public final f k() {
        long jG = g();
        int iB = b(jG);
        int iC = c(jG);
        int i = 1;
        if (!l()) {
            i = (((((int) this.b) >>> 2) ^ iB) & 1) != 0 ? 2 : 0;
        }
        long j = (((long) (iC + iC + i)) & 4294967295L) | (((long) ((iB + iB) + i)) << 32);
        return u.f(a(), u.c(u.b((int) (j >> 32))), u.c(u.b((int) j)));
    }

    public final boolean l() {
        return (((int) this.b) & 1) != 0;
    }

    public final String toString() {
        long j = this.b & 2305843009213693951L;
        return "(face=" + a() + ", pos=" + Long.toHexString(j) + ", level=" + d() + ")";
    }
}
