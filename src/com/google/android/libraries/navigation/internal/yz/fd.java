package com.google.android.libraries.navigation.internal.yz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.SortedMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class fd<K, V> implements Map<K, V>, Serializable {
    public static final Map.Entry[] a = new Map.Entry[0];
    private static final long serialVersionUID = 912559;
    private transient fy b;
    private transient fy c;
    private transient ek d;

    public static ez h(int i) {
        bs.d(i, "expectedSize");
        return new ez(i);
    }

    public static fd i(Iterable iterable) {
        ez ezVar = new ez(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        ezVar.a(iterable);
        return ezVar.d();
    }

    public static fd j(Map map) {
        if ((map instanceof fd) && !(map instanceof SortedMap)) {
            fd fdVar = (fd) map;
            if (!fdVar.c()) {
                return fdVar;
            }
        }
        return i(map.entrySet());
    }

    public static fd k(Object obj, Object obj2) {
        bs.a(obj, obj2);
        return ma.a(1, new Object[]{obj, obj2});
    }

    public static fd l(Object obj, Object obj2, Object obj3, Object obj4) {
        bs.a(obj, obj2);
        bs.a(obj3, obj4);
        return ma.a(2, new Object[]{obj, obj2, obj3, obj4});
    }

    public static fd m(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        bs.a(obj, obj2);
        bs.a(obj3, obj4);
        bs.a(obj5, obj6);
        return ma.a(3, new Object[]{obj, obj2, obj3, obj4, obj5, obj6});
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public nn b() {
        throw null;
    }

    public abstract boolean c();

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public abstract ek d();

    public abstract fy e();

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return kc.k(this, obj);
    }

    public abstract fy f();

    @Override // java.util.Map
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public ek values() {
        ek ekVar = this.d;
        if (ekVar != null) {
            return ekVar;
        }
        ek ekVarD = d();
        this.d = ekVarD;
        return ekVarD;
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return mp.a(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public final fy entrySet() {
        fy fyVar = this.b;
        if (fyVar != null) {
            return fyVar;
        }
        fy fyVarE = e();
        this.b = fyVarE;
        return fyVarE;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public fy keySet() {
        fy fyVar = this.c;
        if (fyVar != null) {
            return fyVar;
        }
        fy fyVarF = f();
        this.c = fyVarF;
        return fyVarF;
    }

    @Override // java.util.Map
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        StringBuilder sbA = bt.a(size());
        sbA.append('{');
        boolean z = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z) {
                sbA.append(", ");
            }
            sbA.append(entry.getKey());
            sbA.append('=');
            sbA.append(entry.getValue());
            z = false;
        }
        sbA.append('}');
        return sbA.toString();
    }

    public Object writeReplace() {
        return new fc(this);
    }
}
