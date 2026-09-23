package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fm extends nn {
    final Iterator a;
    Object b = null;
    Iterator c = gw.a;
    final /* synthetic */ fs d;

    public fm(fs fsVar) {
        this.d = fsVar;
        this.a = fsVar.map.entrySet().listIterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c.hasNext() || this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        if (!this.c.hasNext()) {
            Map.Entry entry = (Map.Entry) this.a.next();
            this.b = entry.getKey();
            this.c = ((ek) entry.getValue()).listIterator();
        }
        return new el(Objects.requireNonNull(this.b), this.c.next());
    }
}
