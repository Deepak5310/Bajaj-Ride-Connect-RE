package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class p implements Iterator {
    final Iterator a;
    Object b = null;
    Collection c = null;
    Iterator d = gy.INSTANCE;
    final /* synthetic */ ae e;

    public p(ae aeVar) {
        this.e = aeVar;
        this.a = aeVar.a.entrySet().iterator();
    }

    public abstract Object a(Object obj, Object obj2);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext() || this.d.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.d.hasNext()) {
            Map.Entry entry = (Map.Entry) this.a.next();
            this.b = entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.c = collection;
            this.d = collection.iterator();
        }
        return a(this.b, this.d.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.d.remove();
        if (((Collection) Objects.requireNonNull(this.c)).isEmpty()) {
            this.a.remove();
        }
        this.e.b--;
    }
}
