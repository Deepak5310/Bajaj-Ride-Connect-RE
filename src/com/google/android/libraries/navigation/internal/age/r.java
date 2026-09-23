package com.google.android.libraries.navigation.internal.age;

import com.google.android.libraries.navigation.internal.agi.ge;
import java.io.Serializable;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r implements Serializable, Cloneable, ListIterator, q, ge {
    private static final long serialVersionUID = -7046029254386353129L;

    protected r() {
    }

    public static final /* synthetic */ void d() {
        throw new UnsupportedOperationException();
    }

    public static final double e() {
        throw new NoSuchElementException();
    }

    public static final /* synthetic */ void f() {
        throw new UnsupportedOperationException();
    }

    private Object readResolve() {
        return t.a;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ Double previous() {
        return Double.valueOf(e());
    }

    @Override // java.util.ListIterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void add(Double d) {
        d();
    }

    @Override // java.util.ListIterator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void set(Double d) {
        f();
    }

    public final Object clone() {
        return t.a;
    }

    @Override // java.util.PrimitiveIterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
    }

    @Override // java.util.Iterator, com.google.android.libraries.navigation.internal.age.q, java.util.PrimitiveIterator.OfDouble
    @Deprecated
    public final void forEachRemaining(Consumer consumer) {
    }

    @Override // java.util.PrimitiveIterator.OfDouble
    /* JADX INFO: renamed from: forEachRemaining, reason: avoid collision after fix types in other method */
    public final void forEachRemaining2(DoubleConsumer doubleConsumer) {
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return false;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final boolean hasPrevious() {
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator, java.util.PrimitiveIterator.OfDouble
    public final /* synthetic */ Double next() {
        return p.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.age.q, java.util.PrimitiveIterator.OfDouble
    public final double nextDouble() {
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return 0;
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return -1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ void remove() {
        throw new UnsupportedOperationException();
    }
}
