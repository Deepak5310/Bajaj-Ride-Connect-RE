package com.google.android.libraries.navigation.internal.agg;

import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ec extends fk {
    final /* synthetic */ ed a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ec(ed edVar) {
        super(edVar.b, edVar.c);
        this.a = edVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fi
    protected final int a(int i) {
        return this.a.d[i];
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fi
    protected final /* bridge */ /* synthetic */ fh c(int i, int i2) {
        return new ec(this.a, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fi, java.util.Spliterator
    public final int characteristics() {
        return 17744;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fi, java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        forEachRemaining(intConsumer);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fi, java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return tryAdvance(intConsumer);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private ec(ed edVar, int i, int i2) {
        super(i, i2);
        this.a = edVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fi, java.util.Spliterator.OfInt
    /* JADX INFO: renamed from: forEachRemaining, reason: avoid collision after fix types in other method */
    public final void forEachRemaining2(IntConsumer intConsumer) {
        while (true) {
            int i = this.c;
            int i2 = this.b;
            if (i2 >= i) {
                return;
            }
            ed edVar = this.a;
            this.b = i2 + 1;
            intConsumer.accept(edVar.d[i2]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fi, java.util.Spliterator.OfInt
    /* JADX INFO: renamed from: tryAdvance, reason: avoid collision after fix types in other method */
    public final boolean tryAdvance2(IntConsumer intConsumer) {
        int i = this.b;
        if (i >= this.c) {
            return false;
        }
        ed edVar = this.a;
        this.b = i + 1;
        intConsumer.accept(edVar.d[i]);
        return true;
    }
}
