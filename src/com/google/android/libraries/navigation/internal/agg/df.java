package com.google.android.libraries.navigation.internal.agg;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class df implements ei {
    int a = 0;
    final /* synthetic */ dh b;

    public df(dh dhVar) {
        this.b = dhVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ei, java.util.PrimitiveIterator.OfInt, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        eh.c(this, consumer);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ei, java.util.PrimitiveIterator.OfInt, java.util.Iterator
    public final /* synthetic */ Integer next() {
        return eh.a(this);
    }

    @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ei, java.util.PrimitiveIterator.OfInt
    public final int nextInt() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int[] iArr = this.b.a;
        int i = this.a;
        this.a = i + 1;
        return iArr[i];
    }

    @Override // java.util.Iterator
    public final void remove() {
        dh dhVar = this.b;
        int i = dhVar.b;
        dhVar.b = i - 1;
        int i2 = this.a;
        int i3 = i2 - 1;
        this.a = i3;
        int[] iArr = dhVar.a;
        System.arraycopy(iArr, i2, iArr, i3, i - i2);
    }
}
