package com.google.android.libraries.navigation.internal.agh;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class gu extends gt implements ha {
    protected gu(int i) {
        super(i);
    }

    public long a() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.b - 1;
        this.b = i;
        this.c = i;
        return h(i);
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
        int i = this.b;
        this.b = i + 1;
        i(i, j);
        this.c = -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha
    public final /* synthetic */ void d(Long l) {
        gz.c(this, l);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha
    public final void e(long j) {
        int i = this.c;
        if (i == -1) {
            throw new IllegalStateException();
        }
        k(i, j);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha
    public final /* synthetic */ void f(Long l) {
        gz.e(this, l);
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    protected abstract void i(int i, long j);

    protected abstract void k(int i, long j);

    @Override // com.google.android.libraries.navigation.internal.agh.o, com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public final /* synthetic */ Long next() {
        return gr.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.o, java.util.PrimitiveIterator.OfLong, java.util.Iterator, java.util.ListIterator
    public final /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.b;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final /* bridge */ /* synthetic */ Object previous() {
        return b();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b - 1;
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        f((Long) obj);
    }
}
