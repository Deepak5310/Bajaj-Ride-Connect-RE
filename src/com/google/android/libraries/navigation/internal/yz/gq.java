package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class gq implements Iterator {
    boolean a = true;
    final /* synthetic */ Iterator b;

    public gq(Iterator it2) {
        this.b = it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object next = this.b.next();
        this.a = false;
        return next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        bs.c(!this.a);
        this.b.remove();
    }
}
