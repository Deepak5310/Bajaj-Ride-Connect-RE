package com.google.android.libraries.navigation.internal.agh;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class ds {
    int d;
    final /* synthetic */ du g;
    int c = -1;
    int e = -1;
    int f = 0;

    protected ds(du duVar) {
        this.g = duVar;
        this.d = duVar.e;
    }

    private final void b() {
        int i;
        if (this.f >= 0) {
            return;
        }
        if (this.c == -1) {
            i = 0;
        } else {
            if (this.d != -1) {
                int i2 = this.g.e;
                this.f = 1;
                while (i2 != this.c) {
                    i2 = (int) this.g.g[i2];
                    this.f++;
                }
                return;
            }
            i = this.g.k;
        }
        this.f = i;
    }

    public static final void i() {
        throw new UnsupportedOperationException();
    }

    public static final void j() {
        throw new UnsupportedOperationException();
    }

    public abstract void aQ(Object obj, int i);

    public final void forEachRemaining(Object obj) {
        while (hasNext()) {
            int i = this.d;
            this.e = i;
            this.d = (int) this.g.g[i];
            this.c = i;
            int i2 = this.f;
            if (i2 >= 0) {
                this.f = i2 + 1;
            }
            aQ(obj, i);
        }
    }

    public final int g() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.d;
        this.e = i;
        this.d = (int) this.g.g[i];
        this.c = i;
        int i2 = this.f;
        if (i2 >= 0) {
            this.f = i2 + 1;
        }
        return i;
    }

    public final int h() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.c;
        this.e = i;
        this.c = (int) (this.g.g[i] >>> 32);
        this.d = i;
        int i2 = this.f;
        if (i2 >= 0) {
            this.f = i2 - 1;
        }
        return i;
    }

    public final boolean hasNext() {
        return this.d != -1;
    }

    public final boolean hasPrevious() {
        return this.c != -1;
    }

    public final int nextIndex() {
        b();
        return this.f;
    }

    public final int previousIndex() {
        b();
        return this.f - 1;
    }

    public void remove() {
        long j;
        du duVar;
        b();
        int i = this.e;
        if (i == -1) {
            throw new IllegalStateException();
        }
        int i2 = this.c;
        if (i == i2) {
            this.f--;
            i2 = (int) (this.g.g[i] >>> 32);
            this.c = i2;
        } else {
            this.d = (int) this.g.g[i];
        }
        du duVar2 = this.g;
        duVar2.k--;
        if (i2 == -1) {
            duVar2.e = this.d;
        } else {
            long[] jArr = duVar2.g;
            long j2 = jArr[i2];
            jArr[i2] = j2 ^ (((((long) this.d) & 4294967295L) ^ j2) & 4294967295L);
        }
        int i3 = this.d;
        if (i3 == -1) {
            duVar2.f = i2;
        } else {
            long[] jArr2 = duVar2.g;
            long j3 = jArr2[i3];
            jArr2[i3] = ((((4294967295L & ((long) i2)) << 32) ^ j3) & (-4294967296L)) ^ j3;
        }
        this.e = -1;
        int i4 = duVar2.h;
        if (i == i4) {
            duVar2.d = false;
            duVar2.b[i4] = null;
            return;
        }
        long[] jArr3 = duVar2.a;
        while (true) {
            int i5 = this.g.c & (i + 1);
            while (true) {
                j = jArr3[i5];
                if (j != 0) {
                    duVar = this.g;
                    int iG = (int) com.google.android.libraries.navigation.internal.agc.e.g(j);
                    int i6 = duVar.c;
                    int i7 = iG & i6;
                    if (i > i5) {
                        if (i >= i7 && i7 > i5) {
                            break;
                        } else {
                            i5 = (i5 + 1) & i6;
                        }
                    } else if (i >= i7 || i7 > i5) {
                        break;
                    } else {
                        i5 = (i5 + 1) & i6;
                    }
                } else {
                    jArr3[i] = 0;
                    this.g.b[i] = null;
                    return;
                }
            }
            jArr3[i] = j;
            Object[] objArr = duVar.b;
            objArr[i] = objArr[i5];
            if (this.d == i5) {
                this.d = i;
            }
            if (this.c == i5) {
                this.c = i;
            }
            duVar.y(i5, i);
            i = i5;
        }
    }
}
