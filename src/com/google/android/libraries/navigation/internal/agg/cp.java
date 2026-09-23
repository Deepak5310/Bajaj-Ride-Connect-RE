package com.google.android.libraries.navigation.internal.agg;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cp extends cu implements ei {
    final /* synthetic */ cy a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp(cy cyVar) {
        super(cyVar);
        this.a = cyVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.cu
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        ((IntConsumer) obj).accept(this.a.a[i]);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ei, java.util.PrimitiveIterator.OfInt, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        eh.c(this, consumer);
    }

    @Override // java.util.PrimitiveIterator.OfInt
    public final /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        super.forEachRemaining((Object) intConsumer);
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
        return this.a.a[b()];
    }
}
