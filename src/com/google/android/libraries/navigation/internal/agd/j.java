package com.google.android.libraries.navigation.internal.agd;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class j implements be {
    protected j() {
    }

    @Override // com.google.android.libraries.navigation.internal.agd.be
    public final /* synthetic */ z d() {
        return bd.d();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        bd.b(this, consumer);
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Comparator getComparator() {
        return d();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return bd.c(this, consumer);
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return aL();
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public /* bridge */ /* synthetic */ Spliterator trySplit() {
        return aL();
    }
}
