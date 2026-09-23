package com.google.android.libraries.navigation.internal.agg;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class cu {
    int b;
    int c = -1;
    int d;
    boolean e;
    de f;
    final /* synthetic */ cy g;

    public cu(cy cyVar) {
        this.g = cyVar;
        this.b = cyVar.e;
        this.d = cyVar.h;
        this.e = cyVar.d;
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
        int[] iArr = this.g.a;
        do {
            i = this.b - 1;
            this.b = i;
            if (i < 0) {
                this.c = Integer.MIN_VALUE;
                int iN = this.f.n((-i) - 1);
                int iE = com.google.android.libraries.navigation.internal.agc.e.e(iN);
                int i3 = this.g.c;
                while (true) {
                    int i4 = iE & i3;
                    if (iN == iArr[i4]) {
                        return i4;
                    }
                    iE = i4 + 1;
                    i3 = this.g.c;
                }
            }
        } while (iArr[i] == 0);
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
        int[] iArr = this.g.a;
        while (this.d != 0) {
            int i3 = this.b - 1;
            this.b = i3;
            if (i3 < 0) {
                this.c = Integer.MIN_VALUE;
                int iN = this.f.n((-i3) - 1);
                int iE = com.google.android.libraries.navigation.internal.agc.e.e(iN);
                int i4 = this.g.c;
                while (true) {
                    i = iE & i4;
                    if (iN == iArr[i]) {
                        break;
                    }
                    iE = i + 1;
                    i4 = this.g.c;
                }
                a(obj, i);
                this.d--;
            } else if (iArr[i3] != 0) {
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
        int i2 = this.c;
        if (i2 == -1) {
            throw new IllegalStateException();
        }
        cy cyVar = this.g;
        int i3 = cyVar.e;
        if (i2 == i3) {
            cyVar.d = false;
            cyVar.b[i3] = null;
        } else {
            int i4 = this.b;
            if (i4 < 0) {
                cyVar.b(this.f.n((-i4) - 1));
                this.c = -1;
                return;
            }
            int[] iArr = cyVar.a;
            loop0: while (true) {
                int i5 = this.g.c & (i2 + 1);
                while (true) {
                    i = iArr[i5];
                    if (i != 0) {
                        cy cyVar2 = this.g;
                        int iE = com.google.android.libraries.navigation.internal.agc.e.e(i);
                        int i6 = cyVar2.c;
                        int i7 = iE & i6;
                        if (i2 > i5) {
                            if (i2 >= i7 && i7 > i5) {
                                break;
                            } else {
                                i5 = (i5 + 1) & i6;
                            }
                        } else if (i2 >= i7 || i7 > i5) {
                            break;
                        } else {
                            i5 = (i5 + 1) & i6;
                        }
                    } else {
                        break loop0;
                    }
                }
                if (i5 < i2) {
                    if (this.f == null) {
                        this.f = new de(2);
                    }
                    this.f.c(iArr[i5]);
                }
                iArr[i2] = i;
                Object[] objArr = this.g.b;
                objArr[i2] = objArr[i5];
                i2 = i5;
            }
            iArr[i2] = 0;
            this.g.b[i2] = null;
        }
        this.g.h--;
        this.c = -1;
    }
}
