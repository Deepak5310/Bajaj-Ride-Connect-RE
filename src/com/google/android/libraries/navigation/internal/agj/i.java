package com.google.android.libraries.navigation.internal.agj;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class i implements ay {
    protected i() {
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ay
    public final /* synthetic */ x d() {
        return ax.d();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        ax.b(this, consumer);
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Comparator getComparator() {
        return d();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return ax.c(this, consumer);
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return aV();
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public /* bridge */ /* synthetic */ Spliterator trySplit() {
        return aV();
    }
}
