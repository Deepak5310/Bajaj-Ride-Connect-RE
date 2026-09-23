package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a implements Iterator {
    Map.Entry a;
    final /* synthetic */ Iterator b;
    final /* synthetic */ g c;

    public a(g gVar, Iterator it2) {
        this.b = it2;
        this.c = gVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.b.next();
        this.a = entry;
        return new b(this.c, entry);
    }

    @Override // java.util.Iterator
    public final void remove() {
        Map.Entry entry = this.a;
        if (entry == null) {
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }
        Iterator it2 = this.b;
        Object value = entry.getValue();
        it2.remove();
        this.c.h(value);
        this.a = null;
    }
}
