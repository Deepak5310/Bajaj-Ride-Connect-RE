package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class kz implements Iterator {
    private final ku a;
    private final Iterator b;
    private kt c;
    private int d;
    private int e;
    private boolean f;

    public kz(ku kuVar, Iterator it2) {
        this.a = kuVar;
        this.b = it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.d > 0 || this.b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int iA = this.d;
        if (iA == 0) {
            kt ktVar = (kt) this.b.next();
            this.c = ktVar;
            iA = ktVar.a();
            this.e = iA;
        }
        this.d = iA - 1;
        this.f = true;
        return ((kt) Objects.requireNonNull(this.c)).b();
    }

    @Override // java.util.Iterator
    public final void remove() {
        bs.c(this.f);
        if (this.e == 1) {
            this.b.remove();
        } else {
            this.a.remove(((kt) Objects.requireNonNull(this.c)).b());
        }
        this.e--;
        this.f = false;
    }
}
