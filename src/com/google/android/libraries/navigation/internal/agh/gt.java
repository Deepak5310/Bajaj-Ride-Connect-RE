package com.google.android.libraries.navigation.internal.agh;

import java.util.NoSuchElementException;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class gt extends o {
    protected int b;
    protected int c;

    protected gt(int i) {
        this.b = i;
    }

    protected abstract int g();

    protected abstract long h(int i);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < g();
    }

    protected abstract void j(int i);

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong
    public long nextLong() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.b;
        this.b = i + 1;
        this.c = i;
        return h(i);
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
    public void forEachRemaining(LongConsumer longConsumer) {
        while (true) {
            int i = this.b;
            if (i >= g()) {
                return;
            }
            this.b = i + 1;
            this.c = i;
            longConsumer.accept(h(i));
        }
    }
}
