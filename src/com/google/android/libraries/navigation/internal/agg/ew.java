package com.google.android.libraries.navigation.internal.agg;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ew implements ei {
    int a;
    int b = -1;
    int c;
    boolean d;
    de e;
    final /* synthetic */ ey f;

    public ew(ey eyVar) {
        this.f = eyVar;
        this.a = eyVar.d;
        this.c = eyVar.g;
        this.d = eyVar.c;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ei, java.util.PrimitiveIterator.OfInt, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        eh.c(this, consumer);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c != 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ei, java.util.PrimitiveIterator.OfInt, java.util.Iterator
    public final /* synthetic */ Integer next() {
        return eh.a(this);
    }

    @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ei, java.util.PrimitiveIterator.OfInt
    public final int nextInt() {
        int i;
        int i2;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.c--;
        if (this.d) {
            this.d = false;
            ey eyVar = this.f;
            int i3 = eyVar.d;
            this.b = i3;
            return eyVar.a[i3];
        }
        int[] iArr = this.f.a;
        do {
            i = this.a - 1;
            this.a = i;
            if (i < 0) {
                this.b = Integer.MIN_VALUE;
                return this.e.n((-i) - 1);
            }
            i2 = iArr[i];
        } while (i2 == 0);
        this.b = i;
        return i2;
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i;
        int i2 = this.b;
        if (i2 == -1) {
            throw new IllegalStateException();
        }
        ey eyVar = this.f;
        int i3 = eyVar.d;
        if (i2 == i3) {
            eyVar.c = false;
            eyVar.a[i3] = 0;
        } else {
            int i4 = this.a;
            if (i4 < 0) {
                eyVar.m(this.e.n((-i4) - 1));
                this.b = -1;
                return;
            }
            int[] iArr = eyVar.a;
            loop0: while (true) {
                int i5 = this.f.b & (i2 + 1);
                while (true) {
                    i = iArr[i5];
                    if (i != 0) {
                        ey eyVar2 = this.f;
                        int iE = com.google.android.libraries.navigation.internal.agc.e.e(i);
                        int i6 = eyVar2.b;
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
                    if (this.e == null) {
                        this.e = new de(2);
                    }
                    this.e.c(iArr[i5]);
                }
                iArr[i2] = i;
                i2 = i5;
            }
            iArr[i2] = 0;
        }
        this.f.g--;
        this.b = -1;
    }

    @Override // java.util.PrimitiveIterator
    public final void forEachRemaining(IntConsumer intConsumer) {
        ey eyVar = this.f;
        int[] iArr = eyVar.a;
        if (this.d) {
            this.d = false;
            int i = eyVar.d;
            this.b = i;
            intConsumer.accept(iArr[i]);
            this.c--;
        }
        while (this.c != 0) {
            int i2 = this.a - 1;
            this.a = i2;
            if (i2 < 0) {
                this.b = Integer.MIN_VALUE;
                intConsumer.accept(this.e.n((-i2) - 1));
                this.c--;
            } else {
                int i3 = iArr[i2];
                if (i3 != 0) {
                    this.b = i2;
                    intConsumer.accept(i3);
                    this.c--;
                }
            }
        }
    }
}
