package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hp implements Serializable, Cloneable, hl {
    private static final long serialVersionUID = 8379247926738230492L;

    protected hp() {
    }

    private Object readResolve() {
        return hs.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hl
    /* JADX INFO: renamed from: aP */
    public final hl trySplit() {
        throw null;
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return 16448;
    }

    public final Object clone() {
        return hs.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hl
    public final /* synthetic */ gk d() {
        return hk.d();
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return 0L;
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator
    @Deprecated
    public final void forEachRemaining(Consumer consumer) {
    }

    @Override // java.util.Spliterator.OfLong
    /* JADX INFO: renamed from: forEachRemaining, reason: avoid collision after fix types in other method */
    public final void forEachRemaining2(LongConsumer longConsumer) {
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Comparator getComparator() {
        return d();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return false;
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator
    @Deprecated
    public final boolean tryAdvance(Consumer consumer) {
        return false;
    }

    @Override // java.util.Spliterator.OfLong
    /* JADX INFO: renamed from: tryAdvance, reason: avoid collision after fix types in other method */
    public final boolean tryAdvance2(LongConsumer longConsumer) {
        return false;
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator.OfLong trySplit() {
        return null;
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return null;
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator trySplit() {
        return null;
    }
}
