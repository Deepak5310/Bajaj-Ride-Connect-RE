package com.google.android.libraries.navigation.internal.agf;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ap implements Serializable, Cloneable, ao {
    private static final long serialVersionUID = 8379247926738230492L;

    protected ap() {
    }

    private Object readResolve() {
        return aq.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.ao
    public final /* synthetic */ o a() {
        return an.d();
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return 16448;
    }

    public final Object clone() {
        return aq.a;
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return 0L;
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
    }

    @Override // java.util.Spliterator
    @Deprecated
    public final void forEachRemaining(Consumer consumer) {
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Comparator getComparator() {
        return a();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        return false;
    }

    @Override // java.util.Spliterator
    @Deprecated
    public final boolean tryAdvance(Consumer consumer) {
        return false;
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return null;
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator trySplit() {
        return null;
    }
}
