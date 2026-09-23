package com.google.android.libraries.navigation.internal.agh;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class bq {
    int b;
    int c = -1;
    int d;
    boolean e;
    fv f;
    final /* synthetic */ bu g;

    public bq(bu buVar) {
        this.g = buVar;
        this.b = buVar.e;
        this.d = buVar.h;
        this.e = buVar.d;
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
        bu buVar = this.g;
        if (i2 == buVar.e) {
            buVar.d = false;
        } else {
            int i3 = this.b;
            if (i3 < 0) {
                buVar.b(this.f.m((-i3) - 1));
                this.c = -1;
                return;
            }
            long[] jArr = buVar.a;
            loop0: while (true) {
                int i4 = i2 + 1;
                int i5 = this.g.c;
                while (true) {
                    i = i5 & i4;
                    j = jArr[i];
                    if (j != 0) {
                        bu buVar2 = this.g;
                        int iG = (int) com.google.android.libraries.navigation.internal.agc.e.g(j);
                        i4 = buVar2.c;
                        int i6 = iG & i4;
                        if (i2 > i) {
                            if (i2 >= i6 && i6 > i) {
                                break;
                            } else {
                                i5 = i + 1;
                            }
                        } else if (i2 >= i6 || i6 > i) {
                            break;
                        } else {
                            i5 = i + 1;
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
                int[] iArr = this.g.b;
                iArr[i2] = iArr[i];
                i2 = i;
            }
            jArr[i2] = 0;
        }
        this.g.h--;
        this.c = -1;
    }
}
