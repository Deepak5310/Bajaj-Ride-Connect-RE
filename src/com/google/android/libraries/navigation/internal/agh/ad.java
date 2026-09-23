package com.google.android.libraries.navigation.internal.agh;

import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ad extends ho implements hl {
    final /* synthetic */ ae a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(ae aeVar, int i, int i2) {
        super(i, i2);
        this.a = aeVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hm
    protected final long b(int i) {
        return this.a.a.b[i];
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hm
    protected final /* bridge */ /* synthetic */ hl c(int i, int i2) {
        return new ad(this.a, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hm, java.util.Spliterator
    public final int characteristics() {
        return 16721;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hm, java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        forEachRemaining(longConsumer);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hm, java.util.Spliterator.OfLong
    /* JADX INFO: renamed from: forEachRemaining, reason: avoid collision after fix types in other method */
    public final void forEachRemaining2(LongConsumer longConsumer) {
        int i = this.a.a.d;
        while (true) {
            int i2 = this.b;
            if (i2 >= i) {
                return;
            }
            long[] jArr = this.a.a.b;
            this.b = i2 + 1;
            longConsumer.accept(jArr[i2]);
        }
    }
}
