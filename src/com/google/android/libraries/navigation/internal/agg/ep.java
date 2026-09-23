package com.google.android.libraries.navigation.internal.agg;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ep implements eu {
    int b;
    final /* synthetic */ eq e;
    int a = -1;
    int c = -1;
    int d = 0;

    public ep(eq eqVar) {
        this.e = eqVar;
        this.b = eqVar.d;
    }

    private final void g() {
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

    @Override // com.google.android.libraries.navigation.internal.agg.dk
    public final int a() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.a;
        this.c = i;
        eq eqVar = this.e;
        this.a = (int) (eqVar.f[i] >>> 32);
        this.b = i;
        int i2 = this.d;
        if (i2 >= 0) {
            this.d = i2 - 1;
        }
        return eqVar.a[i];
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        d((Integer) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.eu
    public final /* synthetic */ Integer b() {
        return dj.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.eu
    public final /* synthetic */ void c(int i) {
        et.g();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.eu
    public final /* synthetic */ void d(Integer num) {
        et.c(this, num);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.eu
    public final /* synthetic */ void e(int i) {
        et.i();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.eu
    public final /* synthetic */ void f(Integer num) {
        et.e(this, num);
    }

    @Override // java.util.Iterator, com.google.android.libraries.navigation.internal.agg.ei, java.util.PrimitiveIterator.OfInt
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        eh.c(this, consumer);
    }

    @Override // java.util.PrimitiveIterator
    public final void forEachRemaining(IntConsumer intConsumer) {
        eq eqVar = this.e;
        int[] iArr = eqVar.a;
        long[] jArr = eqVar.f;
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
            intConsumer.accept(iArr[i]);
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

    @Override // com.google.android.libraries.navigation.internal.agg.eu, java.util.ListIterator, java.util.Iterator, com.google.android.libraries.navigation.internal.agg.ei, java.util.PrimitiveIterator.OfInt
    public final /* synthetic */ Integer next() {
        return eh.a(this);
    }

    @Override // java.util.ListIterator, java.util.Iterator, java.util.PrimitiveIterator.OfInt
    public final /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        g();
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ei, java.util.PrimitiveIterator.OfInt
    public final int nextInt() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.b;
        this.c = i;
        eq eqVar = this.e;
        this.b = (int) eqVar.f[i];
        this.a = i;
        int i2 = this.d;
        if (i2 >= 0) {
            this.d = i2 + 1;
        }
        return eqVar.a[i];
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final /* bridge */ /* synthetic */ Object previous() {
        return b();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        g();
        return this.d - 1;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.eu, java.util.ListIterator, java.util.Iterator
    public final void remove() {
        int i;
        eq eqVar;
        g();
        int i2 = this.c;
        if (i2 == -1) {
            throw new IllegalStateException();
        }
        int i3 = this.a;
        if (i2 == i3) {
            this.d--;
            i3 = (int) (this.e.f[i2] >>> 32);
            this.a = i3;
        } else {
            this.b = (int) this.e.f[i2];
        }
        eq eqVar2 = this.e;
        eqVar2.j--;
        if (i3 == -1) {
            eqVar2.d = this.b;
        } else {
            long[] jArr = eqVar2.f;
            long j = jArr[i3];
            jArr[i3] = j ^ (((((long) this.b) & 4294967295L) ^ j) & 4294967295L);
        }
        int i4 = this.b;
        if (i4 == -1) {
            eqVar2.e = i3;
        } else {
            long[] jArr2 = eqVar2.f;
            long j2 = jArr2[i4];
            jArr2[i4] = ((((4294967295L & ((long) i3)) << 32) ^ j2) & (-4294967296L)) ^ j2;
        }
        this.c = -1;
        int i5 = eqVar2.g;
        if (i2 == i5) {
            eqVar2.c = false;
            eqVar2.a[i5] = 0;
            return;
        }
        int[] iArr = eqVar2.a;
        while (true) {
            int i6 = this.e.b & (i2 + 1);
            while (true) {
                i = iArr[i6];
                if (i != 0) {
                    eqVar = this.e;
                    int iE = com.google.android.libraries.navigation.internal.agc.e.e(i);
                    int i7 = eqVar.b;
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
                    return;
                }
            }
            iArr[i2] = i;
            if (this.b == i6) {
                this.b = i2;
            }
            if (this.a == i6) {
                this.a = i2;
            }
            eqVar.B(i6, i2);
            i2 = i6;
        }
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        f((Integer) obj);
    }
}
