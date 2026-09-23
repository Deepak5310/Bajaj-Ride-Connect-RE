package com.google.android.libraries.navigation.internal.agi;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gs implements gw {
    int b;
    final /* synthetic */ gt e;
    int a = -1;
    int c = -1;
    int d = 0;

    public gs(gt gtVar) {
        this.e = gtVar;
        this.b = gtVar.d;
    }

    private final void a() {
        int i;
        if (this.d >= 0) {
            return;
        }
        if (this.a == -1) {
            i = 0;
        } else {
            if (this.b != -1) {
                int i2 = this.e.d;
                this.d = 1;
                while (i2 != this.a) {
                    i2 = (int) this.e.f[i2];
                    this.d++;
                }
                return;
            }
            i = this.e.j;
        }
        this.d = i;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final /* synthetic */ void add(Object obj) {
        gv.a();
    }

    @Override // java.util.Iterator
    public final void forEachRemaining(Consumer consumer) {
        gt gtVar = this.e;
        Object[] objArr = gtVar.a;
        long[] jArr = gtVar.f;
        while (true) {
            int i = this.b;
            if (i == -1) {
                return;
            }
            this.c = i;
            this.b = (int) jArr[i];
            this.a = i;
            int i2 = this.d;
            if (i2 >= 0) {
                this.d = i2 + 1;
            }
            consumer.accept(objArr[i]);
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.b != -1;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final boolean hasPrevious() {
        return this.a != -1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.b;
        this.c = i;
        gt gtVar = this.e;
        this.b = (int) gtVar.f[i];
        this.a = i;
        int i2 = this.d;
        if (i2 >= 0) {
            this.d = i2 + 1;
        }
        return gtVar.a[i];
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        a();
        return this.d;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.a;
        this.c = i;
        gt gtVar = this.e;
        this.a = (int) (gtVar.f[i] >>> 32);
        this.b = i;
        int i2 = this.d;
        if (i2 >= 0) {
            this.d = i2 - 1;
        }
        return gtVar.a[i];
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        a();
        return this.d - 1;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator, java.util.Iterator
    public final void remove() {
        Object obj;
        gt gtVar;
        a();
        int i = this.c;
        if (i == -1) {
            throw new IllegalStateException();
        }
        int i2 = this.a;
        if (i == i2) {
            this.d--;
            i2 = (int) (this.e.f[i] >>> 32);
            this.a = i2;
        } else {
            this.b = (int) this.e.f[i];
        }
        gt gtVar2 = this.e;
        gtVar2.j--;
        if (i2 == -1) {
            gtVar2.d = this.b;
        } else {
            long[] jArr = gtVar2.f;
            long j = jArr[i2];
            jArr[i2] = j ^ (((((long) this.b) & 4294967295L) ^ j) & 4294967295L);
        }
        int i3 = this.b;
        if (i3 == -1) {
            gtVar2.e = i2;
        } else {
            long[] jArr2 = gtVar2.f;
            long j2 = jArr2[i3];
            jArr2[i3] = ((((4294967295L & ((long) i2)) << 32) ^ j2) & (-4294967296L)) ^ j2;
        }
        this.c = -1;
        int i4 = gtVar2.g;
        if (i == i4) {
            gtVar2.c = false;
            gtVar2.a[i4] = null;
            return;
        }
        Object[] objArr = gtVar2.a;
        while (true) {
            int i5 = this.e.b & (i + 1);
            while (true) {
                obj = objArr[i5];
                if (obj != null) {
                    int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode());
                    gtVar = this.e;
                    int i6 = gtVar.b;
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
                    return;
                }
            }
            objArr[i] = obj;
            if (this.b == i5) {
                this.b = i;
            }
            if (this.a == i5) {
                this.a = i;
            }
            gtVar.i(i5, i);
            i = i5;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final /* synthetic */ void set(Object obj) {
        gv.c();
    }
}
