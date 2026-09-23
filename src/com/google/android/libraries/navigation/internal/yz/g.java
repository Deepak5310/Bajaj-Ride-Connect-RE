package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class g extends dl implements Serializable, az {
    private static final long serialVersionUID = 0;
    public transient Map a;
    public transient g b;
    private transient Set c;
    private transient Set d;
    private transient Set e;

    public g(Map map, g gVar) {
        this.a = map;
        this.b = gVar;
    }

    public g(Map map, Map map2) {
        i(map, map2);
    }

    public Object a(Object obj) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl, com.google.android.libraries.navigation.internal.yz.Cdo
    protected final /* synthetic */ Object aF() {
        return this.a;
    }

    public Object b(Object obj) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl, java.util.Map
    public final void clear() {
        this.a.clear();
        this.b.a.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl, java.util.Map
    public final boolean containsValue(Object obj) {
        return this.b.containsKey(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.az
    public final az d() {
        return this.b;
    }

    public final Object e(Object obj) {
        Object objRemove = this.a.remove(obj);
        h(objRemove);
        return objRemove;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl, java.util.Map
    public final Set entrySet() {
        Set set = this.e;
        if (set != null) {
            return set;
        }
        c cVar = new c(this);
        this.e = cVar;
        return cVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl
    protected final Map f() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl, java.util.Map
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final Set values() {
        Set set = this.d;
        if (set != null) {
            return set;
        }
        f fVar = new f(this);
        this.d = fVar;
        return fVar;
    }

    public final void h(Object obj) {
        this.b.a.remove(obj);
    }

    final void i(Map map, Map map2) {
        com.google.android.libraries.navigation.internal.yx.ar.k(this.a == null);
        com.google.android.libraries.navigation.internal.yx.ar.k(this.b == null);
        com.google.android.libraries.navigation.internal.yx.ar.a(map.isEmpty());
        com.google.android.libraries.navigation.internal.yx.ar.a(map2.isEmpty());
        com.google.android.libraries.navigation.internal.yx.ar.a(map != map2);
        this.a = map;
        this.b = new d(map2, this);
    }

    public final void j(Object obj, boolean z, Object obj2, Object obj3) {
        if (z) {
            h(obj2);
        }
        this.b.a.put(obj3, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl, java.util.Map
    public final Set keySet() {
        Set set = this.c;
        if (set != null) {
            return set;
        }
        e eVar = new e(this);
        this.c = eVar;
        return eVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl, java.util.Map
    public final Object put(Object obj, Object obj2) {
        a(obj);
        b(obj2);
        boolean zContainsKey = containsKey(obj);
        if (zContainsKey && com.google.android.libraries.navigation.internal.yx.am.a(obj2, get(obj))) {
            return obj2;
        }
        com.google.android.libraries.navigation.internal.yx.ar.f(!containsValue(obj2), "value already present: %s", obj2);
        Object objPut = this.a.put(obj, obj2);
        j(obj, zContainsKey, objPut, obj2);
        return objPut;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl, java.util.Map
    public final void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl, java.util.Map
    public final Object remove(Object obj) {
        if (containsKey(obj)) {
            return e(obj);
        }
        return null;
    }
}
