package com.google.android.libraries.navigation.internal.agh;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class em {
    int b;
    int c = -1;
    int d;
    boolean e;
    fv f;
    final /* synthetic */ eq g;

    public em(eq eqVar) {
        this.g = eqVar;
        this.b = eqVar.e;
        this.d = eqVar.h;
        this.e = eqVar.d;
    }

    public abstract void a(Object obj, int i);

    public final int b() {
        int i;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.d--;
        if (this.e) {
            this.e = false;
            int i2 = this.g.e;
            this.c = i2;
            return i2;
        }
        long[] jArr = this.g.a;
        do {
            i = this.b - 1;
            this.b = i;
            if (i < 0) {
                this.c = Integer.MIN_VALUE;
                long jM = this.f.m((-i) - 1);
                int iG = (int) com.google.android.libraries.navigation.internal.agc.e.g(jM);
                int i3 = this.g.c;
                while (true) {
                    int i4 = iG & i3;
                    if (jM == jArr[i4]) {
                        return i4;
                    }
                    iG = i4 + 1;
                    i3 = this.g.c;
                }
            }
        } while (jArr[i] == 0);
        this.c = i;
        return i;
    }

    public final void forEachRemaining(Object obj) {
        int i;
        if (this.e) {
            this.e = false;
            int i2 = this.g.e;
            this.c = i2;
            a(obj, i2);
            this.d--;
        }
        long[] jArr = this.g.a;
        while (this.d != 0) {
            int i3 = this.b - 1;
            this.b = i3;
            if (i3 < 0) {
                this.c = Integer.MIN_VALUE;
                long jM = this.f.m((-i3) - 1);
                int iG = (int) com.google.android.libraries.navigation.internal.agc.e.g(jM);
                int i4 = this.g.c;
                while (true) {
                    i = iG & i4;
                    if (jM == jArr[i]) {
                        break;
                    }
                    iG = i + 1;
                    i4 = this.g.c;
                }
                a(obj, i);
                this.d--;
            } else if (jArr[i3] != 0) {
                this.c = i3;
                a(obj, i3);
                this.d--;
            }
        }
    }

    public final boolean hasNext() {
        return this.d != 0;
    }

    public void remove() {
        int i;
        long j;
        int i2 = this.c;
        if (i2 == -1) {
            throw new IllegalStateException();
        }
        eq eqVar = this.g;
        int i3 = eqVar.e;
        if (i2 == i3) {
            eqVar.d = false;
            eqVar.b[i3] = null;
        } else {
            int i4 = this.b;
            if (i4 < 0) {
                eqVar.b(this.f.m((-i4) - 1));
                this.c = -1;
                return;
            }
            long[] jArr = eqVar.a;
            loop0: while (true) {
                int i5 = i2 + 1;
                int i6 = this.g.c;
                while (true) {
                    i = i6 & i5;
                    j = jArr[i];
                    if (j != 0) {
                        eq eqVar2 = this.g;
                        int iG = (int) com.google.android.libraries.navigation.internal.agc.e.g(j);
                        i5 = eqVar2.c;
                        int i7 = iG & i5;
                        if (i2 > i) {
                            if (i2 >= i7 && i7 > i) {
                                break;
                            } else {
                                i6 = i + 1;
                            }
                        } else if (i2 >= i7 || i7 > i) {
                            break;
                        } else {
                            i6 = i + 1;
                        }
                    } else {
                        break loop0;
                    }
                }
                if (i < i2) {
                    if (this.f == null) {
                        this.f = new fv(2);
                    }
                    this.f.c(jArr[i]);
                }
                jArr[i2] = j;
                Object[] objArr = this.g.b;
                objArr[i2] = objArr[i];
                i2 = i;
            }
            jArr[i2] = 0;
            this.g.b[i2] = null;
        }
        this.g.h--;
        this.c = -1;
    }
}
