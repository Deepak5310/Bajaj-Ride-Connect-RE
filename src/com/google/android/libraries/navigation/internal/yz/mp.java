package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class mp {
    public static int a(Set set) {
        Iterator it2 = set.iterator();
        int iHashCode = 0;
        while (it2.hasNext()) {
            Object next = it2.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static fy b(Iterable iterable) {
        if (iterable instanceof Collection) {
            return iterable.isEmpty() ? mb.a : ep.h(EnumSet.copyOf((Collection) iterable));
        }
        Iterator it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return mb.a;
        }
        EnumSet enumSetOf = EnumSet.of((Enum) it2.next());
        hb.f(enumSetOf, it2);
        return ep.h(enumSetOf);
    }

    public static fy c(Enum r0, Enum... enumArr) {
        return ep.h(EnumSet.of(r0, enumArr));
    }

    public static mn d(Set set, Set set2) {
        com.google.android.libraries.navigation.internal.yx.ar.r(set, "set1");
        com.google.android.libraries.navigation.internal.yx.ar.r(set2, "set2");
        return new ml(set, set2);
    }

    public static mn e(Set set, Set set2) {
        com.google.android.libraries.navigation.internal.yx.ar.r(set, "set1");
        com.google.android.libraries.navigation.internal.yx.ar.r(set2, "set2");
        return new mj(set, set2);
    }

    public static HashSet f(Object... objArr) {
        HashSet hashSetG = g(objArr.length);
        Collections.addAll(hashSetG, objArr);
        return hashSetG;
    }

    public static HashSet g(int i) {
        return new HashSet(kc.a(i));
    }

    public static NavigableSet h(NavigableSet navigableSet) {
        return ((navigableSet instanceof ek) || (navigableSet instanceof mo)) ? navigableSet : new mo(navigableSet);
    }

    public static Set i() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    static boolean j(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size() && set.containsAll(set2)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    static boolean k(Set set, Collection collection) {
        com.google.android.libraries.navigation.internal.yx.ar.q(collection);
        if (collection instanceof ku) {
            collection = ((ku) collection).l();
        }
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? l(set, collection.iterator()) : hb.h(set.iterator(), collection);
    }

    static boolean l(Set set, Iterator it2) {
        boolean zRemove = false;
        while (it2.hasNext()) {
            zRemove |= set.remove(it2.next());
        }
        return zRemove;
    }
}
