package com.google.android.libraries.navigation.internal.agh;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fq implements ha {
    int a;
    int b = -1;
    final /* synthetic */ int c;
    final /* synthetic */ fv d;

    public fq(fv fvVar, int i) {
        this.c = i;
        this.d = fvVar;
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gb
    public final long a() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        long[] jArr = this.d.a;
        int i = this.a - 1;
        this.a = i;
        this.b = i;
        return jArr[i];
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        d((Long) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha
    public final /* synthetic */ Long b() {
        return ga.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha
    public final void c(long j) {
        int i = this.a;
        this.a = i + 1;
        this.d.q(i, j);
        this.b = -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha
    public final /* synthetic */ void d(Long l) {
        gz.c(this, l);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha
    public final void e(long j) {
        int i = this.b;
        if (i == -1) {
            throw new IllegalStateException();
        }
        this.d.o(i, j);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha
    public final /* synthetic */ void f(Long l) {
        gz.e(this, l);
    }

    @Override // java.util.Iterator, com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        gr.c(this, consumer);
    }

    @Override // java.util.PrimitiveIterator
    public final void forEachRemaining(LongConsumer longConsumer) {
        while (true) {
            int i = this.a;
            fv fvVar = this.d;
            if (i >= fvVar.b) {
                return;
            }
            long[] jArr = fvVar.a;
            this.a = i + 1;
            this.b = i;
            longConsumer.accept(jArr[i]);
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

    @Override // com.google.android.libraries.navigation.internal.agh.ha, java.util.ListIterator, java.util.Iterator, com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong
    public final /* synthetic */ Long next() {
        return gr.a(this);
    }

    @Override // java.util.ListIterator, java.util.Iterator, java.util.PrimitiveIterator.OfLong
    public final /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong
    public final long nextLong() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        long[] jArr = this.d.a;
        int i = this.a;
        this.a = i + 1;
        this.b = i;
        return jArr[i];
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final /* bridge */ /* synthetic */ Object previous() {
        return b();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.a - 1;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha, java.util.ListIterator, java.util.Iterator
    public final void remove() {
        int i = this.b;
        if (i == -1) {
            throw new IllegalStateException();
        }
        this.d.n(i);
        int i2 = this.b;
        int i3 = this.a;
        if (i2 < i3) {
            this.a = i3 - 1;
        }
        this.b = -1;
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        f((Long) obj);
    }
}
