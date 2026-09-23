package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class an<K, V> implements kd<K, V> {
    private transient Collection a;
    private transient Set b;
    private transient Collection c;
    private transient Map d;

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public boolean A() {
        return i() == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public boolean B(kd kdVar) {
        boolean zT = false;
        for (Map.Entry entry : kdVar.u()) {
            zT |= t(entry.getKey(), entry.getValue());
        }
        return zT;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public boolean C(Object obj, Object obj2) {
        Collection collection = (Collection) w().get(obj);
        return collection != null && collection.remove(obj2);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof kd) {
            return w().equals(((kd) obj).w());
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public final int hashCode() {
        return w().hashCode();
    }

    public abstract Collection j();

    public abstract Collection k();

    public abstract Iterator l();

    public Iterator m() {
        throw null;
    }

    public abstract Map o();

    public abstract Set p();

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public boolean t(Object obj, Object obj2) {
        throw null;
    }

    public final String toString() {
        return w().toString();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public Collection u() {
        Collection collection = this.a;
        if (collection != null) {
            return collection;
        }
        Collection collectionJ = j();
        this.a = collectionJ;
        return collectionJ;
    }

    public final Collection v() {
        Collection collection = this.c;
        if (collection != null) {
            return collection;
        }
        Collection collectionK = k();
        this.c = collectionK;
        return collectionK;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public Map w() {
        Map map = this.d;
        if (map != null) {
            return map;
        }
        Map mapO = o();
        this.d = mapO;
        return mapO;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public Set x() {
        Set set = this.b;
        if (set != null) {
            return set;
        }
        Set setP = p();
        this.b = setP;
        return setP;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public boolean y(Object obj, Object obj2) {
        Collection collection = (Collection) w().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean z(Object obj) {
        Iterator<V> it2 = w().values().iterator();
        while (it2.hasNext()) {
            if (((Collection) it2.next()).contains(obj)) {
                return true;
            }
        }
        return false;
    }
}
