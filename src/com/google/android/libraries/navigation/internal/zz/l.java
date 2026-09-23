package com.google.android.libraries.navigation.internal.zz;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.md;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class l {
    static final l a = new i();
    static final l b = new j();

    /* JADX WARN: Multi-variable type inference failed */
    private final int e(Object obj, Map map) {
        Integer num = (Integer) map.get(obj);
        if (num != null) {
            return num.intValue();
        }
        boolean zIsInterface = a(obj).isInterface();
        Iterator it2 = b(obj).iterator();
        int iMax = zIsInterface;
        while (it2.hasNext()) {
            iMax = Math.max(iMax, e(it2.next(), map));
        }
        Object objC = c(obj);
        int iMax2 = iMax;
        if (objC != null) {
            iMax2 = Math.max(iMax, e(objC, map));
        }
        int i = iMax2 + 1;
        map.put(obj, Integer.valueOf(i));
        return i;
    }

    public abstract Class a(Object obj);

    public abstract Iterable b(Object obj);

    public abstract Object c(Object obj);

    final ev d(Iterable iterable) {
        HashMap map = new HashMap();
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            e(it2.next(), map);
        }
        return ev.w(new k(md.a, map), map.keySet());
    }
}
