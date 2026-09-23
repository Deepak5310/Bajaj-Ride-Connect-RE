package com.google.android.libraries.navigation.internal.yz;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class kc {
    public static int a(int i) {
        if (i < 3) {
            bs.d(i, "expectedSize");
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) Math.ceil(((double) i) / 0.75d);
        }
        return Integer.MAX_VALUE;
    }

    public static fd b(Map map) {
        if (map instanceof en) {
            return (en) map;
        }
        Iterator it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return ma.b;
        }
        Map.Entry entry = (Map.Entry) it2.next();
        Enum r1 = (Enum) entry.getKey();
        Object value = entry.getValue();
        bs.a(r1, value);
        EnumMap enumMap = new EnumMap(Collections.singletonMap(r1, value));
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            Enum r2 = (Enum) entry2.getKey();
            Object value2 = entry2.getValue();
            bs.a(r2, value2);
            enumMap.put(r2, value2);
        }
        int size = enumMap.size();
        if (size == 0) {
            return ma.b;
        }
        if (size != 1) {
            return new en(enumMap);
        }
        Map.Entry entry3 = (Map.Entry) gs.e(enumMap.entrySet());
        return fd.k((Enum) entry3.getKey(), entry3.getValue());
    }

    public static fd c(Iterator it2, com.google.android.libraries.navigation.internal.yx.aa aaVar, ez ezVar) {
        while (it2.hasNext()) {
            Object next = it2.next();
            ezVar.f(aaVar.ak(next), next);
        }
        try {
            return ezVar.d();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.valueOf(e.getMessage()).concat(". To index multiple values under a key, use Multimaps.index."));
        }
    }

    static Object d(Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    public static Object e(Map map, Object obj) {
        com.google.android.libraries.navigation.internal.yx.ar.q(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static Object f(Map map, Object obj) {
        com.google.android.libraries.navigation.internal.yx.ar.q(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static EnumMap g(Class cls) {
        return new EnumMap(cls);
    }

    static Iterator h(Set set, com.google.android.libraries.navigation.internal.yx.aa aaVar) {
        return new jp(set.iterator(), aaVar);
    }

    public static LinkedHashMap i(int i) {
        return new LinkedHashMap(a(i));
    }

    static Map.Entry j(Map.Entry entry) {
        com.google.android.libraries.navigation.internal.yx.ar.q(entry);
        return new jq(entry);
    }

    public static boolean k(Map map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    static boolean l(Map map, Object obj) {
        com.google.android.libraries.navigation.internal.yx.ar.q(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }
}
