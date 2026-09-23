package com.google.android.libraries.navigation.internal.agh;

import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ft extends hq {
    final /* synthetic */ fu a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ft(fu fuVar) {
        super(fuVar.b);
        this.a = fuVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hq
    protected final int a() {
        return this.a.c;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hm
    protected final long b(int i) {
        return this.a.d.a[i];
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hm
    protected final /* bridge */ /* synthetic */ hl c(int i, int i2) {
        return new ft(this.a, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hm, java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        forEachRemaining(longConsumer);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hm, java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return tryAdvance(longConsumer);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private ft(fu fuVar, int i, int i2) {
        super(i, i2);
        this.a = fuVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hm, java.util.Spliterator.OfLong
    /* JADX INFO: renamed from: forEachRemaining, reason: avoid collision after fix types in other method */
    public final void forEachRemaining2(LongConsumer longConsumer) {
        int iE = e();
        while (true) {
            int i = this.b;
            if (i >= iE) {
                return;
            }
            long[] jArr = this.a.d.a;
            this.b = i + 1;
            longConsumer.accept(jArr[i]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hm, java.util.Spliterator.OfLong
    /* JADX INFO: renamed from: tryAdvance, reason: avoid collision after fix types in other method */
    public final boolean tryAdvance2(LongConsumer longConsumer) {
        if (this.b >= e()) {
            return false;
        }
        long[] jArr = this.a.d.a;
        int i = this.b;
        this.b = i + 1;
        longConsumer.accept(jArr[i]);
        return true;
    }
}
