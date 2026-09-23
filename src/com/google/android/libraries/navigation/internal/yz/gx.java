package com.google.android.libraries.navigation.internal.yz;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class gx implements Iterator {
    private Iterator a;
    private Iterator b = gw.a;
    private Iterator c;
    private Deque d;

    public gx(Iterator it2) {
        this.c = it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Iterator it2;
        while (true) {
            Iterator it3 = this.b;
            com.google.android.libraries.navigation.internal.yx.ar.q(it3);
            if (it3.hasNext()) {
                return true;
            }
            while (true) {
                Iterator it4 = this.c;
                if (it4 != null && it4.hasNext()) {
                    it2 = this.c;
                    break;
                }
                Deque deque = this.d;
                if (deque == null || deque.isEmpty()) {
                    it2 = null;
                    break;
                }
                this.c = (Iterator) this.d.removeFirst();
            }
            this.c = it2;
            if (it2 == null) {
                return false;
            }
            Iterator it5 = (Iterator) it2.next();
            this.b = it5;
            if (it5 instanceof gx) {
                gx gxVar = (gx) it5;
                this.b = gxVar.b;
                if (this.d == null) {
                    this.d = new ArrayDeque();
                }
                this.d.addFirst(this.c);
                if (gxVar.d != null) {
                    while (!gxVar.d.isEmpty()) {
                        this.d.addFirst((Iterator) gxVar.d.removeLast());
                    }
                }
                this.c = gxVar.c;
            }
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Iterator it2 = this.b;
        this.a = it2;
        return it2.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        Iterator it2 = this.a;
        if (it2 == null) {
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }
        it2.remove();
        this.a = null;
    }
}
