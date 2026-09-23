package com.google.android.libraries.navigation.internal.agi;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class er {
    int d;
    final /* synthetic */ et g;
    int c = -1;
    int e = -1;
    int f = 0;

    protected er(et etVar) {
        this.g = etVar;
        this.d = etVar.e;
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

    public static final void f() {
        throw new UnsupportedOperationException();
    }

    public static final void g() {
        throw new UnsupportedOperationException();
    }

    public abstract void a(Object obj, int i);

    public final int c() {
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

    public final int d() {
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

    public final void e(Object obj) {
        while (hasNext()) {
            int i = this.d;
            this.e = i;
            this.d = (int) this.g.g[i];
            this.c = i;
            int i2 = this.f;
            if (i2 >= 0) {
                this.f = i2 + 1;
            }
            a(obj, i);
        }
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
        Object obj;
        et etVar;
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
        et etVar2 = this.g;
        etVar2.k--;
        if (i2 == -1) {
            etVar2.e = this.d;
        } else {
            long[] jArr = etVar2.g;
            long j = jArr[i2];
            jArr[i2] = j ^ (((((long) this.d) & 4294967295L) ^ j) & 4294967295L);
        }
        int i3 = this.d;
        if (i3 == -1) {
            etVar2.f = i2;
        } else {
            long[] jArr2 = etVar2.g;
            long j2 = jArr2[i3];
            jArr2[i3] = ((((4294967295L & ((long) i2)) << 32) ^ j2) & (-4294967296L)) ^ j2;
        }
        this.e = -1;
        int i4 = etVar2.h;
        if (i == i4) {
            etVar2.d = false;
            etVar2.a[i4] = null;
            etVar2.b[i4] = null;
            return;
        }
        Object[] objArr = etVar2.a;
        while (true) {
            int i5 = this.g.c & (i + 1);
            while (true) {
                obj = objArr[i5];
                if (obj != null) {
                    int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode());
                    etVar = this.g;
                    int i6 = etVar.c;
                    int i7 = iE & i6;
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
                    objArr[i] = null;
                    this.g.b[i] = null;
                    return;
                }
            }
            objArr[i] = obj;
            Object[] objArr2 = etVar.b;
            objArr2[i] = objArr2[i5];
            if (this.d == i5) {
                this.d = i;
            }
            if (this.c == i5) {
                this.c = i;
            }
            etVar.n(i5, i);
            i = i5;
        }
    }
}
