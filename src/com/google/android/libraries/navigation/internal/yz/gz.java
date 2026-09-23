package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gz implements Iterator {
    private final Iterator a;
    private boolean b;
    private Object c;

    public gz(Iterator it2) {
        com.google.android.libraries.navigation.internal.yx.ar.q(it2);
        this.a = it2;
    }

    public final Object a() {
        if (!this.b) {
            this.c = this.a.next();
            this.b = true;
        }
        return this.c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b || this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.b) {
            return this.a.next();
        }
        Object obj = this.c;
        this.b = false;
        this.c = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        com.google.android.libraries.navigation.internal.yx.ar.l(!this.b, "Can't remove after you've peeked at next");
        this.a.remove();
    }
}
