package com.google.android.libraries.navigation.internal.agg;

import java.util.NoSuchElementException;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class db extends ek {
    final /* synthetic */ dd a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public db(dd ddVar, int i) {
        super(i);
        this.a = ddVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ek, com.google.android.libraries.navigation.internal.agg.dk
    public final int a() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        dd ddVar = this.a;
        int[] iArr = ddVar.d.a;
        int i = this.b - 1;
        this.b = i;
        this.c = i;
        return iArr[ddVar.b + i];
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ej, java.util.PrimitiveIterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        forEachRemaining(intConsumer);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ej
    protected final int g(int i) {
        dd ddVar = this.a;
        return ddVar.d.a[ddVar.b + i];
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ej
    protected final int h() {
        dd ddVar = this.a;
        return ddVar.c - ddVar.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ek
    protected final void i(int i, int i2) {
        this.a.r(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ej
    protected final void j(int i) {
        this.a.o(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ek
    protected final void k(int i, int i2) {
        this.a.p(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ej, com.google.android.libraries.navigation.internal.agg.ei, java.util.PrimitiveIterator.OfInt
    public final int nextInt() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        dd ddVar = this.a;
        int[] iArr = ddVar.d.a;
        int i = this.b;
        this.b = i + 1;
        this.c = i;
        return iArr[ddVar.b + i];
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ej, java.util.PrimitiveIterator.OfInt
    /* JADX INFO: renamed from: forEachRemaining, reason: avoid collision after fix types in other method */
    public final void forEachRemaining2(IntConsumer intConsumer) {
        dd ddVar = this.a;
        int i = ddVar.c - ddVar.b;
        while (true) {
            int i2 = this.b;
            if (i2 >= i) {
                return;
            }
            dd ddVar2 = this.a;
            int[] iArr = ddVar2.d.a;
            this.b = i2 + 1;
            this.c = i2;
            intConsumer.accept(iArr[ddVar2.b + i2]);
        }
    }
}
