package com.google.android.libraries.navigation.internal.agh;

import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fg extends fl implements gs {
    final /* synthetic */ fp a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fg(fp fpVar) {
        super(fpVar);
        this.a = fpVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.fl
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        ((LongConsumer) obj).accept(this.a.a[i]);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        gr.c(this, consumer);
    }

    @Override // java.util.PrimitiveIterator.OfLong
    public final /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        super.forEachRemaining((Object) longConsumer);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public final /* synthetic */ Long next() {
        return gr.a(this);
    }

    @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong
    public final long nextLong() {
        return this.a.a[b()];
    }
}
