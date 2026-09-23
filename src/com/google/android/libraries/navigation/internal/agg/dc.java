package com.google.android.libraries.navigation.internal.agg;

import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dc extends fm {
    final /* synthetic */ dd a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dc(dd ddVar) {
        super(ddVar.b);
        this.a = ddVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fi
    protected final int a(int i) {
        return this.a.d.a[i];
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fm
    protected final int b() {
        return this.a.c;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fi
    protected final /* bridge */ /* synthetic */ fh c(int i, int i2) {
        return new dc(this.a, i, i2);
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
    private dc(dd ddVar, int i, int i2) {
        super(i, i2);
        this.a = ddVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fi, java.util.Spliterator.OfInt
    /* JADX INFO: renamed from: forEachRemaining, reason: avoid collision after fix types in other method */
    public final void forEachRemaining2(IntConsumer intConsumer) {
        int iE = e();
        while (true) {
            int i = this.b;
            if (i >= iE) {
                return;
            }
            int[] iArr = this.a.d.a;
            this.b = i + 1;
            intConsumer.accept(iArr[i]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fi, java.util.Spliterator.OfInt
    /* JADX INFO: renamed from: tryAdvance, reason: avoid collision after fix types in other method */
    public final boolean tryAdvance2(IntConsumer intConsumer) {
        if (this.b >= e()) {
            return false;
        }
        int[] iArr = this.a.d.a;
        int i = this.b;
        this.b = i + 1;
        intConsumer.accept(iArr[i]);
        return true;
    }
}
