package com.google.android.libraries.navigation.internal.yz;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class eb implements Iterator {
    final /* synthetic */ ec a;
    private int b;
    private int c;
    private int d;
    private int e;

    public eb(ec ecVar) {
        this.a = ecVar;
        ed edVar = ecVar.b;
        this.b = edVar.e;
        this.c = -1;
        this.d = edVar.d;
        this.e = edVar.c;
    }

    private final void a() {
        if (this.a.b.d != this.d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        a();
        return this.b != -2 && this.e > 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objA = this.a.a(this.b);
        int i = this.b;
        this.c = i;
        this.b = this.a.b.f[i];
        this.e--;
        return objA;
    }

    @Override // java.util.Iterator
    public final void remove() {
        a();
        bs.c(this.c != -1);
        ed edVar = this.a.b;
        int i = this.c;
        edVar.j(i, eh.b(edVar.a[i]));
        int i2 = this.b;
        ed edVar2 = this.a.b;
        if (i2 == edVar2.c) {
            this.b = this.c;
        }
        this.c = -1;
        this.d = edVar2.d;
    }
}
