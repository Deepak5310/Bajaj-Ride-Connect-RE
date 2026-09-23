package com.google.android.libraries.navigation.internal.agi;

import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cs extends com.google.android.libraries.navigation.internal.agh.ho implements com.google.android.libraries.navigation.internal.agh.hl {
    final /* synthetic */ ct a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cs(ct ctVar, int i, int i2) {
        super(i, i2);
        this.a = ctVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hm
    protected final long b(int i) {
        return this.a.a.c[i];
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hm
    protected final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.agh.hl c(int i, int i2) {
        return new cs(this.a, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hm, java.util.Spliterator
    public final int characteristics() {
        return 16720;
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
            long[] jArr = this.a.a.c;
            this.b = i2 + 1;
            longConsumer.accept(jArr[i2]);
        }
    }
}
