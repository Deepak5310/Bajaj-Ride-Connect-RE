package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class jx extends jv {
    final Map a;
    final js b;

    public jx(Map map, js jsVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(map);
        this.a = map;
        this.b = jsVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.jv
    public final Iterator a() {
        Iterator it2 = this.a.entrySet().iterator();
        js jsVar = this.b;
        com.google.android.libraries.navigation.internal.yx.ar.q(jsVar);
        return hb.d(it2, new jm(jsVar));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.jv, java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Object obj2 = this.a.get(obj);
        if (obj2 != null || this.a.containsKey(obj)) {
            return this.b.a(obj2);
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return this.a.keySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        if (this.a.containsKey(obj)) {
            return this.b.a(this.a.remove(obj));
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.a.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        return new ka(this);
    }
}
