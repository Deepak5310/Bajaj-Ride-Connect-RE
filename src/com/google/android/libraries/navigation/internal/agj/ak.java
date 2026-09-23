package com.google.android.libraries.navigation.internal.agj;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ak extends b {
    protected int b;
    protected int c;

    protected ak(int i) {
        this.b = i;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.b, com.google.android.libraries.navigation.internal.agj.aj
    public void b(ag agVar) {
        while (true) {
            int i = this.b;
            if (i >= j()) {
                return;
            }
            this.b = i + 1;
            this.c = i;
            agVar.d(k(i));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agj.aj
    public short d() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.b;
        this.b = i + 1;
        this.c = i;
        return k(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.b, java.util.PrimitiveIterator
    public /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
        b((ag) obj);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < j();
    }

    protected abstract int j();

    protected abstract short k(int i);

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
