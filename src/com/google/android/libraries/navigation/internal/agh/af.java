package com.google.android.libraries.navigation.internal.agh;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class af implements com.google.android.libraries.navigation.internal.age.q {
    int a = 0;
    final /* synthetic */ ah b;

    public af(ah ahVar) {
        this.b = ahVar;
    }

    @Override // com.google.android.libraries.navigation.internal.age.q, java.util.PrimitiveIterator.OfDouble, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        com.google.android.libraries.navigation.internal.age.p.c(this, consumer);
    }

    @Override // java.util.PrimitiveIterator
    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        int i = this.b.a.d;
        while (true) {
            int i2 = this.a;
            if (i2 >= i) {
                return;
            }
            double[] dArr = this.b.a.c;
            this.a = i2 + 1;
            doubleConsumer.accept(dArr[i2]);
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b.a.d;
    }

    @Override // com.google.android.libraries.navigation.internal.age.q, java.util.PrimitiveIterator.OfDouble, java.util.Iterator
    public final /* synthetic */ Double next() {
        return com.google.android.libraries.navigation.internal.age.p.a(this);
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
        double[] dArr = this.b.a.c;
        int i = this.a;
        this.a = i + 1;
        return dArr[i];
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i = this.a;
        if (i == 0) {
            throw new IllegalStateException();
        }
        ai aiVar = this.b.a;
        int i2 = aiVar.d - i;
        long[] jArr = aiVar.b;
        System.arraycopy(jArr, i, jArr, i - 1, i2);
        double[] dArr = this.b.a.c;
        int i3 = this.a;
        System.arraycopy(dArr, i3, dArr, i3 - 1, i2);
        this.b.a.d--;
        this.a--;
    }
}
