package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class o extends kb {
    final transient Map a;
    final /* synthetic */ ae b;

    public o(ae aeVar, Map map) {
        this.b = aeVar;
        this.a = map;
    }

    final Map.Entry a(Map.Entry entry) {
        Object key = entry.getKey();
        return new el(key, this.b.f(key, (Collection) entry.getValue()));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kb
    public final Set b() {
        return new m(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Map map = this.a;
        ae aeVar = this.b;
        if (map == aeVar.a) {
            aeVar.q();
        } else {
            hb.e(new n(this));
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return kc.l(this.a, obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        return this == obj || this.a.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        Collection collection = (Collection) kc.e(this.a, obj);
        if (collection == null) {
            return null;
        }
        return this.b.f(obj, collection);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kb, java.util.AbstractMap, java.util.Map
    public Set keySet() {
        return this.b.x();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        Collection collection = (Collection) this.a.remove(obj);
        if (collection == null) {
            return null;
        }
        Collection collectionA = this.b.a();
        collectionA.addAll(collection);
        this.b.b -= collection.size();
        collection.clear();
        return collectionA;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.a.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.a.toString();
    }
}
