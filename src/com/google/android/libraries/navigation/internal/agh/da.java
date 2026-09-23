package com.google.android.libraries.navigation.internal.agh;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class da implements gs {
    int a = 0;
    final /* synthetic */ dc b;

    public da(dc dcVar) {
        this.b = dcVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        gr.c(this, consumer);
    }

    @Override // java.util.PrimitiveIterator
    public final void forEachRemaining(LongConsumer longConsumer) {
        int i = this.b.a.c;
        while (true) {
            int i2 = this.a;
            if (i2 >= i) {
                return;
            }
            long[] jArr = this.b.a.a;
            this.a = i2 + 1;
            longConsumer.accept(jArr[i2]);
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b.a.c;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public final /* synthetic */ Long next() {
        return gr.a(this);
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
        long[] jArr = this.b.a.a;
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
        dg dgVar = this.b.a;
        int i2 = dgVar.c - i;
        long[] jArr = dgVar.a;
        System.arraycopy(jArr, i, jArr, i - 1, i2);
        Object[] objArr = this.b.a.b;
        int i3 = this.a;
        System.arraycopy(objArr, i3, objArr, i3 - 1, i2);
        dg dgVar2 = this.b.a;
        int i4 = dgVar2.c - 1;
        dgVar2.c = i4;
        this.a--;
        dgVar2.b[i4] = null;
    }
}
