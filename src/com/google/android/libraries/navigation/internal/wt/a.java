package com.google.android.libraries.navigation.internal.wt;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a implements Iterator {
    final int a;
    final /* synthetic */ c b;
    private b c;

    public a(c cVar) {
        this.b = cVar;
        this.a = cVar.b;
        this.c = cVar.c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        b bVar = this.c;
        if (bVar == null) {
            throw new NoSuchElementException();
        }
        c cVar = this.b;
        if (cVar.b != this.a) {
            throw new ConcurrentModificationException();
        }
        Object obj = bVar.a;
        this.c = bVar.b;
        return obj;
    }
}
