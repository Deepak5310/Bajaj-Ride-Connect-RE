package com.google.android.libraries.navigation.internal.agi;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cr implements com.google.android.libraries.navigation.internal.agh.gs {
    int a = 0;
    final /* synthetic */ ct b;

    public cr(ct ctVar) {
        this.b = ctVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        com.google.android.libraries.navigation.internal.agh.gr.c(this, consumer);
    }

    @Override // java.util.PrimitiveIterator
    public final void forEachRemaining(LongConsumer longConsumer) {
        int i = this.b.a.d;
        while (true) {
            int i2 = this.a;
            if (i2 >= i) {
                return;
            }
            long[] jArr = this.b.a.c;
            this.a = i2 + 1;
            longConsumer.accept(jArr[i2]);
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b.a.d;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public final /* synthetic */ Long next() {
        return com.google.android.libraries.navigation.internal.agh.gr.a(this);
    }

    @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong
    public final long nextLong() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        long[] jArr = this.b.a.c;
        int i = this.a;
        this.a = i + 1;
        return jArr[i];
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i = this.a;
        if (i == 0) {
            throw new IllegalStateException();
        }
        cu cuVar = this.b.a;
        int i2 = cuVar.d - i;
        Object[] objArr = cuVar.b;
        System.arraycopy(objArr, i, objArr, i - 1, i2);
        long[] jArr = this.b.a.c;
        int i3 = this.a;
        System.arraycopy(jArr, i3, jArr, i3 - 1, i2);
        cu cuVar2 = this.b.a;
        int i4 = cuVar2.d - 1;
        cuVar2.d = i4;
        this.a--;
        cuVar2.b[i4] = null;
    }
}
