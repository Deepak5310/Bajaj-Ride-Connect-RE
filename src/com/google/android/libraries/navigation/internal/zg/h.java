package com.google.android.libraries.navigation.internal.zg;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h implements Iterator {
    final /* synthetic */ i a;
    private int b = 0;

    public h(i iVar) {
        this.a = iVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.a.size();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.b;
        if (i >= this.a.size()) {
            throw new NoSuchElementException();
        }
        i iVar = this.a;
        Object obj = iVar.b.b[iVar.b() + i];
        this.b = i + 1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
