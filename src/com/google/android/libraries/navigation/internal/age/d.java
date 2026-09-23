package com.google.android.libraries.navigation.internal.age;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d implements q {
    int a = 0;
    final /* synthetic */ f b;

    public d(f fVar) {
        this.b = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.age.q, java.util.PrimitiveIterator.OfDouble, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        p.c(this, consumer);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b.b;
    }

    @Override // com.google.android.libraries.navigation.internal.age.q, java.util.PrimitiveIterator.OfDouble, java.util.Iterator
    public final /* synthetic */ Double next() {
        return p.a(this);
    }

    @Override // java.util.PrimitiveIterator.OfDouble, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // com.google.android.libraries.navigation.internal.age.q, java.util.PrimitiveIterator.OfDouble
    public final double nextDouble() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        double[] dArr = this.b.a;
        int i = this.a;
        this.a = i + 1;
        return dArr[i];
    }

    @Override // java.util.Iterator
    public final void remove() {
        f fVar = this.b;
        int i = fVar.b;
        fVar.b = i - 1;
        int i2 = this.a;
        int i3 = i2 - 1;
        this.a = i3;
        double[] dArr = fVar.a;
        System.arraycopy(dArr, i2, dArr, i3, i - i2);
    }
}
