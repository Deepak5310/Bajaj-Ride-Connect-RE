package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class mt implements Iterator {
    final Iterator a;
    Map.Entry b;
    Iterator c = gy.INSTANCE;
    final /* synthetic */ nb d;

    public mt(nb nbVar) {
        this.d = nbVar;
        this.a = nbVar.a.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext() || this.c.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        if (!this.c.hasNext()) {
            Map.Entry entry = (Map.Entry) this.a.next();
            this.b = entry;
            this.c = ((Map) entry.getValue()).entrySet().iterator();
        }
        Objects.requireNonNull(this.b);
        Map.Entry entry2 = (Map.Entry) this.c.next();
        return new nf(this.b.getKey(), entry2.getKey(), entry2.getValue());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.c.remove();
        if (((Map) ((Map.Entry) Objects.requireNonNull(this.b)).getValue()).isEmpty()) {
            this.a.remove();
            this.b = null;
        }
    }
}
