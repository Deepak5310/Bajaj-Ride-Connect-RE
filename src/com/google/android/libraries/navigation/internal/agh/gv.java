package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gv implements Serializable, Cloneable, ha {
    private static final long serialVersionUID = -7046029254386353129L;

    protected gv() {
    }

    private Object readResolve() {
        return gx.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gb
    public final long a() {
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
    public final /* synthetic */ void c(long j) {
        gz.g();
    }

    public final Object clone() {
        return gx.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha
    public final /* synthetic */ void d(Long l) {
        gz.c(this, l);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha
    public final /* synthetic */ void e(long j) {
        gz.h();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha
    public final /* synthetic */ void f(Long l) {
        gz.e(this, l);
    }

    @Override // java.util.PrimitiveIterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
    }

    @Override // java.util.Iterator, com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong
    @Deprecated
    public final void forEachRemaining(Consumer consumer) {
    }

    @Override // java.util.PrimitiveIterator.OfLong
    /* JADX INFO: renamed from: forEachRemaining, reason: avoid collision after fix types in other method */
    public final void forEachRemaining2(LongConsumer longConsumer) {
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return false;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final boolean hasPrevious() {
        return false;
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
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong
    public final long nextLong() {
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final /* bridge */ /* synthetic */ Object previous() {
        return b();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha, java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        f((Long) obj);
    }
}
