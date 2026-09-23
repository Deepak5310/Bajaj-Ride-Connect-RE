package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class nb extends av implements Serializable {
    private static final long serialVersionUID = 0;
    public final Map a;
    final com.google.android.libraries.navigation.internal.yx.br b;
    private transient Map c;

    public nb(Map map, com.google.android.libraries.navigation.internal.yx.br brVar) {
        this.a = map;
        this.b = brVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.av, com.google.android.libraries.navigation.internal.yz.nd
    public final Object a(Object obj, Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) kc.e(j(), obj)) == null) {
            return null;
        }
        return kc.e(map, obj2);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.av, com.google.android.libraries.navigation.internal.yz.nd
    public final Object b(Object obj, Object obj2, Object obj3) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        com.google.android.libraries.navigation.internal.yx.ar.q(obj2);
        com.google.android.libraries.navigation.internal.yx.ar.q(obj3);
        Map map = (Map) this.a.get(obj);
        if (map == null) {
            Map map2 = this.a;
            Map mapB = ds.b();
            map2.put(obj, mapB);
            map = mapB;
        }
        return map.put(obj2, obj3);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.av
    public final Iterator c() {
        return new mt(this);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.av
    public final void e() {
        this.a.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.av, com.google.android.libraries.navigation.internal.yz.nd
    public final boolean f(Object obj, Object obj2) {
        Map map;
        return (obj == null || obj2 == null || (map = (Map) kc.e(j(), obj)) == null || !kc.l(map, obj2)) ? false : true;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.nd
    public final int h() {
        Iterator it2 = this.a.values().iterator();
        int size = 0;
        while (it2.hasNext()) {
            size += ((Map) it2.next()).size();
        }
        return size;
    }

    public final Map i(Object obj) {
        return new mw(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.nd
    public final Map j() {
        Map map = this.c;
        if (map != null) {
            return map;
        }
        mz mzVar = new mz(this);
        this.c = mzVar;
        return mzVar;
    }

    public final boolean k(Object obj) {
        return obj != null && kc.l(this.a, obj);
    }
}
