package com.google.android.libraries.navigation.internal.agi;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class be {
    int b;
    int c = -1;
    int d;
    boolean e;
    fz f;
    final /* synthetic */ bi g;

    public be(bi biVar) {
        this.g = biVar;
        this.b = biVar.e;
        this.d = biVar.h;
        this.e = biVar.d;
    }

    public abstract void aS(Object obj, int i);

    public final int d() {
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
        Object[] objArr = this.g.a;
        do {
            i = this.b - 1;
            this.b = i;
            if (i < 0) {
                this.c = Integer.MIN_VALUE;
                Object obj = this.f.get((-i) - 1);
                int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode());
                int i3 = this.g.c;
                while (true) {
                    int i4 = iE & i3;
                    if (obj.equals(objArr[i4])) {
                        return i4;
                    }
                    iE = i4 + 1;
                    i3 = this.g.c;
                }
            }
        } while (objArr[i] == null);
        this.c = i;
        return i;
    }

    public final void forEachRemaining(Object obj) {
        int i;
        if (this.e) {
            this.e = false;
            int i2 = this.g.e;
            this.c = i2;
            aS(obj, i2);
            this.d--;
        }
        Object[] objArr = this.g.a;
        while (this.d != 0) {
            int i3 = this.b - 1;
            this.b = i3;
            if (i3 < 0) {
                this.c = Integer.MIN_VALUE;
                Object obj2 = this.f.get((-i3) - 1);
                int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj2.hashCode());
                int i4 = this.g.c;
                while (true) {
                    i = iE & i4;
                    if (obj2.equals(objArr[i])) {
                        break;
                    }
                    iE = i + 1;
                    i4 = this.g.c;
                }
                aS(obj, i);
                this.d--;
            } else if (objArr[i3] != null) {
                this.c = i3;
                aS(obj, i3);
                this.d--;
            }
        }
    }

    public final boolean hasNext() {
        return this.d != 0;
    }

    public void remove() {
        Object obj;
        int i = this.c;
        if (i == -1) {
            throw new IllegalStateException();
        }
        bi biVar = this.g;
        int i2 = biVar.e;
        if (i == i2) {
            biVar.d = false;
            biVar.a[i2] = null;
        } else {
            int i3 = this.b;
            if (i3 < 0) {
                biVar.b(this.f.set((-i3) - 1, null));
                this.c = -1;
                return;
            }
            Object[] objArr = biVar.a;
            loop0: while (true) {
                int i4 = this.g.c & (i + 1);
                while (true) {
                    obj = objArr[i4];
                    if (obj != null) {
                        int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode());
                        int i5 = this.g.c;
                        int i6 = iE & i5;
                        if (i > i4) {
                            if (i >= i6 && i6 > i4) {
                                break;
                            } else {
                                i4 = (i4 + 1) & i5;
                            }
                        } else if (i >= i6 || i6 > i4) {
                            break;
                        } else {
                            i4 = (i4 + 1) & i5;
                        }
                    } else {
                        break loop0;
                    }
                }
                if (i4 < i) {
                    if (this.f == null) {
                        this.f = new fz((byte[]) null);
                    }
                    this.f.add(objArr[i4]);
                }
                objArr[i] = obj;
                float[] fArr = this.g.b;
                fArr[i] = fArr[i4];
                i = i4;
            }
            objArr[i] = null;
        }
        this.g.h--;
        this.c = -1;
    }
}
