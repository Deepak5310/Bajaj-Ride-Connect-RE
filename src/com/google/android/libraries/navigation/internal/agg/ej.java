package com.google.android.libraries.navigation.internal.agg;

import java.util.NoSuchElementException;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ej extends i {
    protected int b;
    protected int c;

    protected ej(int i) {
        this.b = i;
    }

    protected abstract int g(int i);

    protected abstract int h();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < h();
    }

    protected abstract void j(int i);

    @Override // com.google.android.libraries.navigation.internal.agg.ei, java.util.PrimitiveIterator.OfInt
    public int nextInt() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.b;
        this.b = i + 1;
        this.c = i;
        return g(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i = this.c;
        if (i == -1) {
            throw new IllegalStateException();
        }
        j(i);
        int i2 = this.c;
        int i3 = this.b;
        if (i2 < i3) {
            this.b = i3 - 1;
        }
        this.c = -1;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.PrimitiveIterator
    public void forEachRemaining(IntConsumer intConsumer) {
        while (true) {
            int i = this.b;
            if (i >= h()) {
                return;
            }
            this.b = i + 1;
            this.c = i;
            intConsumer.accept(g(i));
        }
    }
}
