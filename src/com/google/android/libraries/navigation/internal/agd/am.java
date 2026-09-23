package com.google.android.libraries.navigation.internal.agd;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class am extends b {
    protected int b;
    protected int c;

    protected am(int i) {
        this.b = i;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.b, com.google.android.libraries.navigation.internal.agd.al
    public void b(ai aiVar) {
        while (true) {
            int i = this.b;
            if (i >= k()) {
                return;
            }
            this.b = i + 1;
            this.c = i;
            aiVar.c(j(i));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agd.al
    public byte c() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.b;
        this.b = i + 1;
        this.c = i;
        return j(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.b, java.util.PrimitiveIterator
    public /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
        b((ai) obj);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < k();
    }

    protected abstract byte j(int i);

    protected abstract int k();

    protected abstract void m(int i);

    @Override // java.util.Iterator
    public final void remove() {
        int i = this.c;
        if (i == -1) {
            throw new IllegalStateException();
        }
        m(i);
        int i2 = this.c;
        int i3 = this.b;
        if (i2 < i3) {
            this.b = i3 - 1;
        }
        this.c = -1;
    }
}
