package com.google.android.libraries.navigation.internal.yz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gi extends fd implements NavigableMap {
    public static final Comparator b;
    private static final gi e;
    private static final long serialVersionUID = 0;
    public final transient mc c;
    public final transient ev d;
    private transient gi f;

    static {
        lg lgVar = lg.a;
        b = lgVar;
        mc mcVarH = gl.H(lgVar);
        int i = ev.d;
        e = new gi(mcVarH, lv.a);
    }

    public gi(mc mcVar, ev evVar) {
        this(mcVar, evVar, null);
    }

    public gi(mc mcVar, ev evVar, gi giVar) {
        this.c = mcVar;
        this.d = evVar;
        this.f = giVar;
    }

    public static gi a(Comparator comparator) {
        if (lg.a.equals(comparator)) {
            return e;
        }
        mc mcVarH = gl.H(comparator);
        int i = ev.d;
        return new gi(mcVarH, lv.a);
    }

    public static gi q(Comparable comparable, Object obj) {
        return r(lg.a, comparable, obj);
    }

    public static gi r(Comparator comparator, Object obj, Object obj2) {
        ev evVarQ = ev.q(obj);
        com.google.android.libraries.navigation.internal.yx.ar.q(comparator);
        return new gi(new mc(evVarQ, comparator), ev.q(obj2));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    private final gi u(int i, int i2) {
        if (i == 0) {
            if (i2 == size()) {
                return this;
            }
            i = 0;
        }
        if (i == i2) {
            return a(comparator());
        }
        return new gi(this.c.L(i, i2), this.d.subList(i, i2));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fd
    public final boolean c() {
        return this.c.f() || this.d.f();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry ceilingEntry(Object obj) {
        return tailMap(obj, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public final Object ceilingKey(Object obj) {
        return kc.d(ceilingEntry(obj));
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return ((gl) this.c).a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fd
    public final ek d() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    public final /* bridge */ /* synthetic */ NavigableSet descendingKeySet() {
        return this.c.descendingSet();
    }

    @Override // java.util.NavigableMap
    public final /* bridge */ /* synthetic */ NavigableMap descendingMap() {
        gi giVar = this.f;
        if (giVar != null) {
            return giVar;
        }
        if (!isEmpty()) {
            return new gi((mc) this.c.descendingSet(), this.d.h(), this);
        }
        Comparator comparator = comparator();
        return a((comparator instanceof lo ? (lo) comparator : new ch(comparator)).c());
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fd
    public final fy e() {
        return isEmpty() ? mb.a : new gf(this);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fd, java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fd
    public final fy f() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    public final Map.Entry firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().d().get(0);
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return this.c.first();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry floorEntry(Object obj) {
        return headMap(obj, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public final Object floorKey(Object obj) {
        return kc.d(floorEntry(obj));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fd
    /* JADX INFO: renamed from: g */
    public final ek values() {
        return this.d;
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry higherEntry(Object obj) {
        return tailMap(obj, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public final Object higherKey(Object obj) {
        return kc.d(higherEntry(obj));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fd, java.util.Map
    public final /* synthetic */ Set keySet() {
        return this.c;
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().d().get(size() - 1);
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return this.c.last();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lowerEntry(Object obj) {
        return headMap(obj, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public final Object lowerKey(Object obj) {
        return kc.d(lowerEntry(obj));
    }

    @Override // java.util.NavigableMap
    public final /* synthetic */ NavigableSet navigableKeySet() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fd
    /* JADX INFO: renamed from: o */
    public final /* synthetic */ fy keySet() {
        return this.c;
    }

    @Override // java.util.NavigableMap
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final gi headMap(Object obj, boolean z) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        return u(0, this.c.J(obj, z));
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final gi subMap(Object obj, boolean z, Object obj2, boolean z2) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        com.google.android.libraries.navigation.internal.yx.ar.q(obj2);
        com.google.android.libraries.navigation.internal.yx.ar.i(comparator().compare(obj, obj2) <= 0, "expected fromKey <= toKey but %s > %s", obj, obj2);
        return headMap(obj2, z2).tailMap(obj, z);
    }

    @Override // java.util.Map
    public final int size() {
        return this.d.size();
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final /* bridge */ /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    @Override // java.util.NavigableMap
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final gi tailMap(Object obj, boolean z) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        return u(this.c.K(obj, z), size());
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fd, java.util.Map
    public final /* synthetic */ Collection values() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fd
    public Object writeReplace() {
        return new gh(this);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0005  */
    @Override // com.google.android.libraries.navigation.internal.yz.fd, java.util.Map
    public final Object get(Object obj) {
        int iBinarySearch;
        mc mcVar = this.c;
        if (obj == null) {
            iBinarySearch = -1;
        } else {
            try {
                iBinarySearch = Collections.binarySearch(mcVar.d, obj, mcVar.a);
                if (iBinarySearch < 0) {
                    iBinarySearch = -1;
                }
            } catch (ClassCastException unused) {
            }
        }
        if (iBinarySearch == -1) {
            return null;
        }
        return this.d.get(iBinarySearch);
    }
}
