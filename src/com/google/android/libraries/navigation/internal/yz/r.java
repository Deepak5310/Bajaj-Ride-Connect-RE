package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class r extends jw {
    final /* synthetic */ ae a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(ae aeVar, Map map) {
        super(map);
        this.a = aeVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.jw, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        hb.e(iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        return this.d.keySet().containsAll(collection);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        return this == obj || this.d.keySet().equals(obj);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.d.keySet().hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.jw, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new q(this, this.d.entrySet().iterator());
    }

    @Override // com.google.android.libraries.navigation.internal.yz.jw, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Collection collection = (Collection) this.d.remove(obj);
        if (collection == null) {
            return false;
        }
        int size = collection.size();
        collection.clear();
        this.a.b -= size;
        return size > 0;
    }
}
