package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class ae extends an implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    public transient Map a;
    public transient int b;

    protected ae(Map map) {
        com.google.android.libraries.navigation.internal.yx.ar.a(map.isEmpty());
        this.a = map;
    }

    public abstract Collection a();

    public Collection b() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public Collection c(Object obj) {
        Collection collectionA = (Collection) this.a.get(obj);
        if (collectionA == null) {
            collectionA = a();
        }
        return f(obj, collectionA);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public Collection d(Object obj) {
        Collection collection = (Collection) this.a.remove(obj);
        if (collection == null) {
            return b();
        }
        Collection collectionA = a();
        collectionA.addAll(collection);
        this.b -= collection.size();
        collection.clear();
        return e(collectionA);
    }

    public Collection e(Collection collection) {
        throw null;
    }

    public Collection f(Object obj, Collection collection) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public final int i() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an
    public final Collection j() {
        return this instanceof mh ? new al(this) : new ak(this);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an
    public final Collection k() {
        return new am(this);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an
    public final Iterator l() {
        return new l(this);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an
    public final Iterator m() {
        return new k(this);
    }

    final List n(Object obj, List list, y yVar) {
        return list instanceof RandomAccess ? new u(this, obj, list, yVar) : new aa(this, obj, list, yVar);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an
    public Map o() {
        return new o(this, this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an
    public Set p() {
        return new r(this, this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public final void q() {
        Iterator it2 = this.a.values().iterator();
        while (it2.hasNext()) {
            ((Collection) it2.next()).clear();
        }
        this.a.clear();
        this.b = 0;
    }

    final void r(Map map) {
        this.a = map;
        this.b = 0;
        for (Collection collection : map.values()) {
            com.google.android.libraries.navigation.internal.yx.ar.a(!collection.isEmpty());
            this.b += collection.size();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public final boolean s(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an, com.google.android.libraries.navigation.internal.yz.kd
    public final boolean t(Object obj, Object obj2) {
        Collection collection = (Collection) this.a.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.b++;
            return true;
        }
        Collection collectionA = a();
        if (!collectionA.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.b++;
        this.a.put(obj, collectionA);
        return true;
    }
}
