package com.google.android.libraries.navigation.internal.agg;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class bc {
    int d;
    final /* synthetic */ be g;
    int c = -1;
    int e = -1;
    int f = 0;

    protected bc(be beVar) {
        this.g = beVar;
        this.d = beVar.e;
    }

    private final void a() {
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

    public abstract void aN(Object obj, int i);

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
            aN(obj, i);
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
        a();
        return this.f;
    }

    public final int previousIndex() {
        a();
        return this.f - 1;
    }

    public void remove() {
        int i;
        be beVar;
        a();
        int i2 = this.e;
        if (i2 == -1) {
            throw new IllegalStateException();
        }
        int i3 = this.c;
        if (i2 == i3) {
            this.f--;
            i3 = (int) (this.g.g[i2] >>> 32);
            this.c = i3;
        } else {
            this.d = (int) this.g.g[i2];
        }
        be beVar2 = this.g;
        beVar2.k--;
        if (i3 == -1) {
            beVar2.e = this.d;
        } else {
            long[] jArr = beVar2.g;
            long j = jArr[i3];
            jArr[i3] = j ^ (((((long) this.d) & 4294967295L) ^ j) & 4294967295L);
        }
        int i4 = this.d;
        if (i4 == -1) {
            beVar2.f = i3;
        } else {
            long[] jArr2 = beVar2.g;
            long j2 = jArr2[i4];
            jArr2[i4] = ((((4294967295L & ((long) i3)) << 32) ^ j2) & (-4294967296L)) ^ j2;
        }
        this.e = -1;
        int i5 = beVar2.h;
        if (i2 == i5) {
            beVar2.d = false;
            beVar2.b[i5] = null;
            return;
        }
        int[] iArr = beVar2.a;
        while (true) {
            int i6 = this.g.c & (i2 + 1);
            while (true) {
                i = iArr[i6];
                if (i != 0) {
                    beVar = this.g;
                    int iE = com.google.android.libraries.navigation.internal.agc.e.e(i);
                    int i7 = beVar.c;
                    int i8 = iE & i7;
                    if (i2 > i6) {
                        if (i2 >= i8 && i8 > i6) {
                            break;
                        } else {
                            i6 = (i6 + 1) & i7;
                        }
                    } else if (i2 >= i8 || i8 > i6) {
                        break;
                    } else {
                        i6 = (i6 + 1) & i7;
                    }
                } else {
                    iArr[i2] = 0;
                    this.g.b[i2] = null;
                    return;
                }
            }
            iArr[i2] = i;
            Object[] objArr = beVar.b;
            objArr[i2] = objArr[i6];
            if (this.d == i6) {
                this.d = i2;
            }
            if (this.c == i6) {
                this.c = i2;
            }
            beVar.y(i6, i2);
            i2 = i6;
        }
    }
}
