package com.google.android.libraries.navigation.internal.agg;

import java.util.Comparator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fn implements fh {
    private final int a;
    private boolean b = false;

    public fn(int i) {
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fh
    /* JADX INFO: renamed from: aM */
    public final fh trySplit() {
        throw null;
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return 17749;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fh
    public final void d() {
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return this.b ? 0L : 1L;
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        fg.a(this, consumer);
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final void forEachRemaining(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        if (this.b) {
            return;
        }
        this.b = true;
        intConsumer.accept(this.a);
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Comparator getComparator() {
        return null;
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return fg.b(this, consumer);
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final boolean tryAdvance(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        if (this.b) {
            return false;
        }
        this.b = true;
        intConsumer.accept(this.a);
        return true;
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
