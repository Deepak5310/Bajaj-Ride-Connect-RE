package com.google.android.libraries.navigation.internal.agi;

import java.util.Comparator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class hp implements hj {
    private final Object a;
    private boolean b = false;

    public hp(Object obj) {
        this.a = obj;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hj
    /* JADX INFO: renamed from: b */
    public final hj trySplit() {
        throw null;
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return (this.a != null ? 256 : 0) | 17493;
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return this.b ? 0L : 1L;
    }

    @Override // java.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        if (this.b) {
            return;
        }
        this.b = true;
        consumer.accept(this.a);
    }

    @Override // java.util.Spliterator
    public final Comparator getComparator() {
        return null;
    }

    @Override // java.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        if (this.b) {
            return false;
        }
        this.b = true;
        consumer.accept(this.a);
        return true;
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator trySplit() {
        return null;
    }
}
