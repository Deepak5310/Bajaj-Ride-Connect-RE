package com.google.android.libraries.navigation.internal.agg;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fl implements Serializable, Cloneable, fh {
    private static final long serialVersionUID = 8379247926738230492L;

    protected fl() {
    }

    private Object readResolve() {
        return fp.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fh
    /* JADX INFO: renamed from: aM */
    public final fh trySplit() {
        throw null;
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return 16448;
    }

    public final Object clone() {
        return fp.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fh
    public final /* synthetic */ void d() {
        fg.c();
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return 0L;
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator
    @Deprecated
    public final void forEachRemaining(Consumer consumer) {
    }

    @Override // java.util.Spliterator.OfInt
    /* JADX INFO: renamed from: forEachRemaining, reason: avoid collision after fix types in other method */
    public final void forEachRemaining2(IntConsumer intConsumer) {
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Comparator getComparator() {
        d();
        return null;
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return false;
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator
    @Deprecated
    public final boolean tryAdvance(Consumer consumer) {
        return false;
    }

    @Override // java.util.Spliterator.OfInt
    /* JADX INFO: renamed from: tryAdvance, reason: avoid collision after fix types in other method */
    public final boolean tryAdvance2(IntConsumer intConsumer) {
        return false;
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator.OfInt trySplit() {
        return null;
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return null;
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator trySplit() {
        return null;
    }
}
