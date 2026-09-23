package com.google.android.libraries.navigation.internal.agi;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class gj extends n {
    protected int b;
    protected int c;

    protected gj(int i) {
        this.b = i;
    }

    protected abstract int a();

    protected abstract Object b(int i);

    protected abstract void d(int i);

    @Override // java.util.Iterator
    public void forEachRemaining(Consumer consumer) {
        while (true) {
            int i = this.b;
            if (i >= a()) {
                return;
            }
            this.b = i + 1;
            this.c = i;
            consumer.accept(b(i));
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < a();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.b;
        this.b = i + 1;
        this.c = i;
        return b(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i = this.c;
        if (i == -1) {
            throw new IllegalStateException();
        }
        d(i);
        int i2 = this.c;
        int i3 = this.b;
        if (i2 < i3) {
            this.b = i3 - 1;
        }
        this.c = -1;
    }
}
