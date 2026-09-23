package com.google.android.libraries.navigation.internal.agh;

import java.util.NoSuchElementException;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fs extends gu {
    final /* synthetic */ fu a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fs(fu fuVar, int i) {
        super(i);
        this.a = fuVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gu, com.google.android.libraries.navigation.internal.agh.gb
    public final long a() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        fu fuVar = this.a;
        long[] jArr = fuVar.d.a;
        int i = this.b - 1;
        this.b = i;
        this.c = i;
        return jArr[fuVar.b + i];
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gt, java.util.PrimitiveIterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        forEachRemaining(longConsumer);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gt
    protected final int g() {
        fu fuVar = this.a;
        return fuVar.c - fuVar.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gt
    protected final long h(int i) {
        fu fuVar = this.a;
        return fuVar.d.a[fuVar.b + i];
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gu
    protected final void i(int i, long j) {
        this.a.q(i, j);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gt
    protected final void j(int i) {
        this.a.n(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gu
    protected final void k(int i, long j) {
        this.a.o(i, j);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gt, com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong
    public final long nextLong() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        fu fuVar = this.a;
        long[] jArr = fuVar.d.a;
        int i = this.b;
        this.b = i + 1;
        this.c = i;
        return jArr[fuVar.b + i];
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gt, java.util.PrimitiveIterator.OfLong
    /* JADX INFO: renamed from: forEachRemaining, reason: avoid collision after fix types in other method */
    public final void forEachRemaining2(LongConsumer longConsumer) {
        fu fuVar = this.a;
        int i = fuVar.c - fuVar.b;
        while (true) {
            int i2 = this.b;
            if (i2 >= i) {
                return;
            }
            fu fuVar2 = this.a;
            long[] jArr = fuVar2.d.a;
            this.b = i2 + 1;
            this.c = i2;
            longConsumer.accept(jArr[fuVar2.b + i2]);
        }
    }
}
