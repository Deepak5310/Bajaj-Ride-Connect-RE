package com.google.android.libraries.navigation.internal.agg;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class em implements eu {
    private final int a;
    private byte b;

    public em(int i) {
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dk
    public final int a() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        this.b = (byte) 0;
        return this.a;
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
        Objects.requireNonNull(intConsumer);
        if (this.b == 0) {
            intConsumer.accept(this.a);
            this.b = (byte) 1;
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.b == 0;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final boolean hasPrevious() {
        return this.b == 1;
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
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ei, java.util.PrimitiveIterator.OfInt
    public final int nextInt() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.b = (byte) 1;
        return this.a;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final /* bridge */ /* synthetic */ Object previous() {
        return b();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b - 1;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.eu, java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ void remove() {
        et.h();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        f((Integer) obj);
    }
}
