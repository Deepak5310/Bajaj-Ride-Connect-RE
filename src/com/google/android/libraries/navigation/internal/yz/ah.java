package com.google.android.libraries.navigation.internal.yz;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class ah implements Iterator {
    int b;
    int c = -1;
    int d;
    final /* synthetic */ ai e;

    public ah(ai aiVar) {
        this.e = aiVar;
        this.b = aiVar.a.a();
        this.d = aiVar.a.d;
    }

    private final void b() {
        if (this.e.a.d != this.d) {
            throw new ConcurrentModificationException();
        }
    }

    public abstract Object a(int i);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        b();
        return this.b >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objA = a(this.b);
        int i = this.b;
        this.c = i;
        this.b = this.e.a.f(i);
        return objA;
    }

    @Override // java.util.Iterator
    public final void remove() {
        b();
        bs.c(this.c != -1);
        ai aiVar = this.e;
        aiVar.b -= (long) aiVar.a.i(this.c);
        this.b = this.e.a.g(this.b, this.c);
        this.c = -1;
        this.d = this.e.a.d;
    }
}
