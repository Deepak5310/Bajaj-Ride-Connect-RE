package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class x implements Iterator {
    final Iterator a;
    final Collection b;
    final /* synthetic */ y c;

    public x(y yVar) {
        this.c = yVar;
        this.b = yVar.b;
        Collection collection = yVar.b;
        this.a = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    public x(y yVar, Iterator it2) {
        this.c = yVar;
        this.b = yVar.b;
        this.a = it2;
    }

    final void a() {
        this.c.b();
        if (this.c.b != this.b) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        a();
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        a();
        return this.a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.a.remove();
        y yVar = this.c;
        yVar.e.b--;
        yVar.c();
    }
}
