package com.google.android.libraries.navigation.internal.age;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ad implements Serializable, Cloneable, aa {
    private static final long serialVersionUID = 8379247926738230492L;

    protected ad() {
    }

    private Object readResolve() {
        return ae.a;
    }

    @Override // com.google.android.libraries.navigation.internal.age.aa
    public final /* synthetic */ n a() {
        return z.d();
    }

    @Override // com.google.android.libraries.navigation.internal.age.aa
    /* JADX INFO: renamed from: b */
    public final aa trySplit() {
        throw null;
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return 16448;
    }

    public final Object clone() {
        return ae.a;
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return 0L;
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
    }

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator
    @Deprecated
    public final void forEachRemaining(Consumer consumer) {
    }

    @Override // java.util.Spliterator.OfDouble
    /* JADX INFO: renamed from: forEachRemaining, reason: avoid collision after fix types in other method */
    public final void forEachRemaining2(DoubleConsumer doubleConsumer) {
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Comparator getComparator() {
        return a();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return false;
    }

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator
    @Deprecated
    public final boolean tryAdvance(Consumer consumer) {
        return false;
    }

    @Override // java.util.Spliterator.OfDouble
    /* JADX INFO: renamed from: tryAdvance, reason: avoid collision after fix types in other method */
    public final boolean tryAdvance2(DoubleConsumer doubleConsumer) {
        return false;
    }

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator.OfDouble trySplit() {
        return null;
    }

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return null;
    }

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator trySplit() {
        return null;
    }
}
