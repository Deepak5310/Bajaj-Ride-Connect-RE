package com.google.android.libraries.navigation.internal.agg;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cz implements eu {
    int a;
    int b = -1;
    final /* synthetic */ int c;
    final /* synthetic */ de d;

    public cz(de deVar, int i) {
        this.c = i;
        this.d = deVar;
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dk
    public final int a() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int[] iArr = this.d.a;
        int i = this.a - 1;
        this.a = i;
        this.b = i;
        return iArr[i];
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
    public final void c(int i) {
        int i2 = this.a;
        this.a = i2 + 1;
        this.d.r(i2, i);
        this.b = -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.eu
    public final /* synthetic */ void d(Integer num) {
        et.c(this, num);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.eu
    public final void e(int i) {
        int i2 = this.b;
        if (i2 == -1) {
            throw new IllegalStateException();
        }
        this.d.p(i2, i);
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
        while (true) {
            int i = this.a;
            de deVar = this.d;
            if (i >= deVar.b) {
                return;
            }
            int[] iArr = deVar.a;
            this.a = i + 1;
            this.b = i;
            intConsumer.accept(iArr[i]);
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.d.b;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final boolean hasPrevious() {
        return this.a > 0;
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
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ei, java.util.PrimitiveIterator.OfInt
    public final int nextInt() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int[] iArr = this.d.a;
        int i = this.a;
        this.a = i + 1;
        this.b = i;
        return iArr[i];
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final /* bridge */ /* synthetic */ Object previous() {
        return b();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.a - 1;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.eu, java.util.ListIterator, java.util.Iterator
    public final void remove() {
        int i = this.b;
        if (i == -1) {
            throw new IllegalStateException();
        }
        this.d.o(i);
        int i2 = this.b;
        int i3 = this.a;
        if (i2 < i3) {
            this.a = i3 - 1;
        }
        this.b = -1;
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        f((Integer) obj);
    }
}
