package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fn extends nn {
    final Iterator a;
    Iterator b = gw.a;
    final /* synthetic */ fs c;

    public fn(fs fsVar) {
        this.c = fsVar;
        this.a = fsVar.map.values().listIterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b.hasNext() || this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.b.hasNext()) {
            this.b = ((ek) this.a.next()).listIterator();
        }
        return this.b.next();
    }
}
