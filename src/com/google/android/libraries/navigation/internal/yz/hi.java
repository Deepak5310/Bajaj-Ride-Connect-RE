package com.google.android.libraries.navigation.internal.yz;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class hi implements Iterator {
    final Set a;
    hk b;
    hk c;
    int d;
    final /* synthetic */ hn e;

    public hi(hn hnVar) {
        this.e = hnVar;
        this.a = mp.g(hnVar.x().size());
        this.b = hnVar.a;
        this.d = hnVar.e;
    }

    private final void a() {
        if (this.e.e != this.d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        a();
        return this.b != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        hk hkVar;
        a();
        hk hkVar2 = this.b;
        if (hkVar2 == null) {
            throw new NoSuchElementException();
        }
        this.c = hkVar2;
        this.a.add(hkVar2.a);
        do {
            hkVar = this.b.c;
            this.b = hkVar;
            if (hkVar == null) {
                break;
            }
        } while (!this.a.add(hkVar.a));
        return this.c.a;
    }

    @Override // java.util.Iterator
    public final void remove() {
        a();
        com.google.android.libraries.navigation.internal.yx.ar.l(this.c != null, "no calls to next() since the last call to remove()");
        this.e.e(this.c.a);
        this.c = null;
        this.d = this.e.e;
    }
}
