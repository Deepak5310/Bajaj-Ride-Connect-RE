package com.google.android.libraries.navigation.internal.yz;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class by implements Iterator {
    int b;
    int c;
    int d = -1;
    final /* synthetic */ cc e;

    public by(cc ccVar) {
        this.e = ccVar;
        this.b = ccVar.e;
        this.c = ccVar.c();
    }

    private final void b() {
        if (this.e.e != this.b) {
            throw new ConcurrentModificationException();
        }
    }

    public abstract Object a(int i);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        b();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.c;
        this.d = i;
        Object objA = a(i);
        this.c = this.e.d(this.c);
        return objA;
    }

    @Override // java.util.Iterator
    public final void remove() {
        b();
        bs.c(this.d >= 0);
        this.b += 32;
        int i = this.d;
        cc ccVar = this.e;
        ccVar.remove(ccVar.g(i));
        this.c = this.e.a(this.c, this.d);
        this.d = -1;
    }
}
