package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ds extends dq implements com.google.android.libraries.navigation.internal.agh.gs {
    final /* synthetic */ du a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ds(du duVar) {
        super(duVar);
        this.a = duVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.dq
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        ((LongConsumer) obj).accept(this.a.c[i]);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        com.google.android.libraries.navigation.internal.agh.gr.c(this, consumer);
    }

    @Override // java.util.PrimitiveIterator.OfLong
    public final /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        super.forEachRemaining((Object) longConsumer);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public final /* synthetic */ Long next() {
        return com.google.android.libraries.navigation.internal.agh.gr.a(this);
    }

    @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong
    public final long nextLong() {
        return this.a.c[b()];
    }
}
