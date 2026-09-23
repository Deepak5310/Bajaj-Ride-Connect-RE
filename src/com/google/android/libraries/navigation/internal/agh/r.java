package com.google.android.libraries.navigation.internal.agh;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class r implements ha {
    final /* synthetic */ t a;
    private final ha b;

    public r(t tVar, ha haVar) {
        this.a = tVar;
        this.b = haVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gb
    public final long a() {
        if (hasPrevious()) {
            return this.b.a();
        }
        throw new NoSuchElementException();
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
        this.b.c(j);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha
    public final /* synthetic */ void d(Long l) {
        gz.c(this, l);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha
    public final void e(long j) {
        this.b.e(j);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha
    public final /* synthetic */ void f(Long l) {
        gz.e(this, l);
    }

    @Override // java.util.Iterator, com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        gr.c(this, consumer);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.b.nextIndex() < this.a.c;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final boolean hasPrevious() {
        return this.b.previousIndex() >= this.a.b;
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
        return this.b.nextIndex() - this.a.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong
    public final long nextLong() {
        if (hasNext()) {
            return this.b.nextLong();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final /* bridge */ /* synthetic */ Object previous() {
        return b();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b.previousIndex() - this.a.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha, java.util.ListIterator, java.util.Iterator
    public final void remove() {
        this.b.remove();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        f((Long) obj);
    }
}
