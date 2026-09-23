package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class mw extends jv {
    final Object a;
    Map b;
    final /* synthetic */ nb c;

    public mw(nb nbVar, Object obj) {
        this.c = nbVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        this.a = obj;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.jv
    public final Iterator a() {
        c();
        Map map = this.b;
        return map == null ? gy.INSTANCE : new mu(this, map.entrySet().iterator());
    }

    final void b() {
        c();
        Map map = this.b;
        if (map == null || !map.isEmpty()) {
            return;
        }
        nb nbVar = this.c;
        nbVar.a.remove(this.a);
        this.b = null;
    }

    final void c() {
        Map map = this.b;
        if (map != null) {
            if (!map.isEmpty()) {
                return;
            }
            nb nbVar = this.c;
            if (!nbVar.a.containsKey(this.a)) {
                return;
            }
        }
        nb nbVar2 = this.c;
        this.b = (Map) nbVar2.a.get(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.jv, java.util.AbstractMap, java.util.Map
    public final void clear() {
        c();
        Map map = this.b;
        if (map != null) {
            map.clear();
        }
        b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map map;
        c();
        return (obj == null || (map = this.b) == null || !kc.l(map, obj)) ? false : true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map map;
        c();
        if (obj == null || (map = this.b) == null) {
            return null;
        }
        return kc.e(map, obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        com.google.android.libraries.navigation.internal.yx.ar.q(obj2);
        Map map = this.b;
        return (map == null || map.isEmpty()) ? this.c.b(this.a, obj, obj2) : this.b.put(obj, obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        c();
        Map map = this.b;
        if (map == null) {
            return null;
        }
        Object objF = kc.f(map, obj);
        b();
        return objF;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        c();
        Map map = this.b;
        if (map == null) {
            return 0;
        }
        return map.size();
    }
}
