package com.google.android.libraries.navigation.internal.agh;

import java.util.function.DoubleConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ag extends com.google.android.libraries.navigation.internal.age.ac implements com.google.android.libraries.navigation.internal.age.aa {
    final /* synthetic */ ah c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(ah ahVar, int i, int i2) {
        super(i, i2);
        this.c = ahVar;
    }

    @Override // com.google.android.libraries.navigation.internal.age.ab
    protected final double c(int i) {
        return this.c.a.c[i];
    }

    @Override // com.google.android.libraries.navigation.internal.age.ab, java.util.Spliterator
    public final int characteristics() {
        return 16720;
    }

    @Override // com.google.android.libraries.navigation.internal.age.ab
    protected final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.age.aa e(int i, int i2) {
        return new ag(this.c, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.age.ab, java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        forEachRemaining(doubleConsumer);
    }

    @Override // com.google.android.libraries.navigation.internal.age.ab, java.util.Spliterator.OfDouble
    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        int i = this.c.a.d;
        while (true) {
            int i2 = this.a;
            if (i2 >= i) {
                return;
            }
            double[] dArr = this.c.a.c;
            this.a = i2 + 1;
            doubleConsumer.accept(dArr[i2]);
        }
    }
}
