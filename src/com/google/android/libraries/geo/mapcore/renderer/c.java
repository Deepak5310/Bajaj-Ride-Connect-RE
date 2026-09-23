package com.google.android.libraries.geo.mapcore.renderer;

import java.util.Arrays;
import java.util.BitSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    final int a;
    int b;
    BitSet c;
    BitSet d;
    int[] e;
    int f;
    int[] g;
    int[] h;
    int i;
    int[] j;
    int[] k;
    int l;
    int m;

    public c(int i, int i2) {
        com.google.android.libraries.navigation.internal.yx.ar.k(i > 0);
        com.google.android.libraries.navigation.internal.yx.ar.k(i2 > 0);
        this.a = i;
        this.b = i2;
        this.c = new BitSet(i2);
        this.d = new BitSet(i * i2);
        this.f = -1;
        int[] iArr = new int[1024];
        this.g = iArr;
        this.h = new int[1024];
        this.i = -1;
        this.j = new int[i2];
        this.l = -1;
        this.m = 0;
        Arrays.fill(iArr, -1);
        Arrays.fill(this.h, -1);
        Arrays.fill(this.j, -1);
        this.k = new int[a.f * 1024];
        for (int i3 = 0; i3 < 1024; i3++) {
            n(i3);
        }
        this.e = new int[b.g * 128];
        for (int i4 = 0; i4 < 128; i4++) {
            o(i4);
        }
    }

    public static final int B(BitSet bitSet, int i, int i2, int i3) {
        while (i >= 0 && i2 - i >= i3) {
            int iNextSetBit = bitSet.nextSetBit(i);
            if (iNextSetBit == -1 || iNextSetBit - i >= i3) {
                return i;
            }
            i = bitSet.nextClearBit(iNextSetBit);
        }
        return -1;
    }

    final void A(int i, int i2) {
        b.Y.b(this.e, i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x000f  */
    public final int a(int i, int i2) {
        int iB;
        int iK;
        int i3;
        int i4;
        int i5;
        boolean z = i2 > 0;
        com.google.android.libraries.navigation.internal.yx.ar.k(z);
        if (i <= this.a) {
            int iG = this.g[i2];
            if (iG >= 0) {
                iB = -1;
                iK = -1;
                i3 = -1;
                i4 = -1;
                while (iG != -1) {
                    i4 = i(iG);
                    if (i4 + i <= this.a && b.HOLE_LIMIT.a(this.e, iG) > i) {
                        iK = k(iG);
                        int i6 = this.a;
                        i3 = iK * i6;
                        iB = B(this.d, i3, i6 + i3, i);
                        if (iB != -1) {
                            break;
                        }
                        z(iG, i);
                    }
                    iG = g(iG);
                }
            } else {
                iB = -1;
                iK = -1;
                i3 = -1;
                i4 = -1;
            }
            if (iB == -1) {
                com.google.android.libraries.navigation.internal.yx.ar.k(z);
                int iB2 = B(this.c, 0, this.b, i2);
                if (iB2 == -1) {
                    iG = -1;
                } else {
                    if (this.f == -1) {
                        com.google.android.libraries.navigation.internal.yx.ar.k(true);
                        int length = this.e.length / b.g;
                        int i7 = length + 128;
                        this.e = Arrays.copyOf(this.e, b.g * i7);
                        while (length < i7) {
                            o(length);
                            length++;
                        }
                    }
                    iG = this.f;
                    this.f = g(iG);
                    v(iG, -1);
                    A(iG, iB2);
                    y(iG, i2);
                    this.c.set(iB2, iB2 + i2);
                    this.j[iB2] = iG;
                }
                if (iG == -1) {
                    i5 = -1;
                } else {
                    l(iG, i2);
                    iK = k(iG);
                    iB = iK * this.a;
                    i4 = 0;
                    i3 = iB;
                }
            }
            int i8 = i + iB;
            if (this.l == -1) {
                com.google.android.libraries.navigation.internal.yx.ar.k(true);
                int length2 = this.k.length / a.f;
                int i9 = length2 + 1024;
                this.k = Arrays.copyOf(this.k, a.f * i9);
                while (length2 < i9) {
                    n(length2);
                    length2++;
                }
            }
            int i10 = i8 - iB;
            i5 = this.l;
            this.l = a.NEXT.a(this.k, i5);
            u(i5, -1);
            s(i5, iB - i3);
            t(i5, iK);
            r(i5, i10);
            q(i5, i2);
            int i11 = i4 + i10;
            x(iG, i11);
            if (i11 == this.a) {
                p(iG, i2);
                com.google.android.libraries.navigation.internal.yx.ar.k(iG >= 0);
                com.google.android.libraries.navigation.internal.yx.ar.k(iG < j());
                com.google.android.libraries.navigation.internal.yx.ar.k(g(iG) == -1);
                com.google.android.libraries.navigation.internal.yx.ar.k(h(iG) == -1);
                int i12 = this.i;
                w(iG, -1);
                v(iG, i12);
                if (i12 != -1) {
                    w(i12, iG);
                }
                this.i = iG;
            }
            this.d.set(iB, i8);
        } else {
            i5 = -1;
        }
        if (i5 != -1) {
            this.m++;
        }
        return i5;
    }

    public final int b(int i) {
        return a.HEIGHT.a(this.k, i);
    }

    final int c() {
        return this.k.length / a.f;
    }

    public final int d(int i) {
        return a.WIDTH.a(this.k, i);
    }

    public final int e(int i) {
        return a.X.a(this.k, i);
    }

    public final int f(int i) {
        return a.Y.a(this.k, i);
    }

    final int g(int i) {
        return b.NEXT.a(this.e, i);
    }

    final int h(int i) {
        return b.PREV.a(this.e, i);
    }

    final int i(int i) {
        return b.CELL_COUNT.a(this.e, i);
    }

    final int j() {
        return this.e.length / b.g;
    }

    final int k(int i) {
        return b.Y.a(this.e, i);
    }

    final void l(int i, int i2) {
        com.google.android.libraries.navigation.internal.yx.ar.k(i >= 0);
        com.google.android.libraries.navigation.internal.yx.ar.k(i < j());
        com.google.android.libraries.navigation.internal.yx.ar.k(i2 > 0);
        com.google.android.libraries.navigation.internal.yx.ar.k(g(i) == -1);
        com.google.android.libraries.navigation.internal.yx.ar.k(h(i) == -1);
        int[] iArr = this.h;
        int i3 = iArr[i2];
        if (i3 == -1) {
            this.g[i2] = i;
            iArr[i2] = i;
        } else {
            w(i, i3);
            v(i, -1);
            v(i3, i);
            this.h[i2] = i;
        }
    }

    final void m(int i, int i2) {
        com.google.android.libraries.navigation.internal.yx.ar.k(i >= 0);
        com.google.android.libraries.navigation.internal.yx.ar.k(i < j());
        com.google.android.libraries.navigation.internal.yx.ar.k(i2 > 0);
        com.google.android.libraries.navigation.internal.yx.ar.k(i(i) == 0);
        int iK = k(i);
        this.j[iK] = -1;
        this.c.clear(iK, i2 + iK);
        o(i);
    }

    final void n(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.k(i >= 0);
        com.google.android.libraries.navigation.internal.yx.ar.k(i < c());
        s(i, 0);
        t(i, 0);
        r(i, 0);
        q(i, 0);
        u(i, this.l);
        this.l = i;
    }

    final void o(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.k(i >= 0);
        com.google.android.libraries.navigation.internal.yx.ar.k(i < j());
        A(i, 0);
        y(i, 0);
        x(i, 0);
        z(i, this.a);
        v(i, this.f);
        w(i, -1);
        this.f = i;
    }

    final void p(int i, int i2) {
        boolean z;
        boolean z2;
        com.google.android.libraries.navigation.internal.yx.ar.k(i >= 0);
        com.google.android.libraries.navigation.internal.yx.ar.k(i < j());
        com.google.android.libraries.navigation.internal.yx.ar.k(i2 > 0);
        int iH = h(i);
        int iG = g(i);
        if (iH == -1) {
            z = this.g[i2] == i;
            iH = -1;
        } else {
            z = true;
        }
        com.google.android.libraries.navigation.internal.yx.ar.k(z);
        if (iG == -1) {
            z2 = this.h[i2] == i;
            iG = -1;
        } else {
            z2 = true;
        }
        com.google.android.libraries.navigation.internal.yx.ar.k(z2);
        int[] iArr = this.g;
        if (i == iArr[i2]) {
            if (iG >= 0) {
                iArr[i2] = iG;
            } else {
                iArr[i2] = -1;
            }
        }
        int[] iArr2 = this.h;
        if (i == iArr2[i2]) {
            if (iH >= 0) {
                iArr2[i2] = iH;
            } else {
                iArr2[i2] = -1;
            }
        }
        if (iH != -1) {
            v(iH, iG);
        }
        if (iG != -1) {
            w(iG, iH);
        }
        w(i, -1);
        v(i, -1);
    }

    final void q(int i, int i2) {
        a.HEIGHT.b(this.k, i, i2);
    }

    final void r(int i, int i2) {
        a.WIDTH.b(this.k, i, i2);
    }

    final void s(int i, int i2) {
        a.X.b(this.k, i, i2);
    }

    final void t(int i, int i2) {
        a.Y.b(this.k, i, i2);
    }

    final void u(int i, int i2) {
        a.NEXT.b(this.k, i, i2);
    }

    final void v(int i, int i2) {
        b.NEXT.b(this.e, i, i2);
    }

    final void w(int i, int i2) {
        b.PREV.b(this.e, i, i2);
    }

    final void x(int i, int i2) {
        b.CELL_COUNT.b(this.e, i, i2);
    }

    final void y(int i, int i2) {
        b.HEIGHT.b(this.e, i, i2);
    }

    final void z(int i, int i2) {
        b.HOLE_LIMIT.b(this.e, i, i2);
    }
}
