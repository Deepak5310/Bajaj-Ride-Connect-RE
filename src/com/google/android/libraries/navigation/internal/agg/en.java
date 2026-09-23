package com.google.android.libraries.navigation.internal.agg;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class en implements ei {
    protected final ei a;

    public en(ei eiVar) {
        this.a = eiVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ei, java.util.PrimitiveIterator.OfInt, java.util.Iterator
    public final /* synthetic */ Integer next() {
        return eh.a(this);
    }

    @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ei, java.util.PrimitiveIterator.OfInt
    public final int nextInt() {
        return this.a.nextInt();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ei, java.util.PrimitiveIterator.OfInt, java.util.Iterator
    @Deprecated
    public final void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(consumer);
    }

    @Override // java.util.PrimitiveIterator
    public final void forEachRemaining(IntConsumer intConsumer) {
        this.a.forEachRemaining(intConsumer);
    }
}
