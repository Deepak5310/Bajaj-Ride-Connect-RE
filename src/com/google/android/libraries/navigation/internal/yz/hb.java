package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hb {
    public static nn a(Iterator it2) {
        com.google.android.libraries.navigation.internal.yx.ar.q(it2);
        return it2 instanceof nn ? (nn) it2 : new gt(it2);
    }

    public static Object b(Iterator it2, Object obj) {
        return it2.hasNext() ? it2.next() : obj;
    }

    static Object c(Iterator it2) {
        if (!it2.hasNext()) {
            return null;
        }
        Object next = it2.next();
        it2.remove();
        return next;
    }

    public static Iterator d(Iterator it2, com.google.android.libraries.navigation.internal.yx.aa aaVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(aaVar);
        return new gv(it2, aaVar);
    }

    static void e(Iterator it2) {
        com.google.android.libraries.navigation.internal.yx.ar.q(it2);
        while (it2.hasNext()) {
            it2.next();
            it2.remove();
        }
    }

    public static boolean f(Collection collection, Iterator it2) {
        com.google.android.libraries.navigation.internal.yx.ar.q(collection);
        com.google.android.libraries.navigation.internal.yx.ar.q(it2);
        boolean zAdd = false;
        while (it2.hasNext()) {
            zAdd |= collection.add(it2.next());
        }
        return zAdd;
    }

    public static boolean h(Iterator it2, Collection collection) {
        com.google.android.libraries.navigation.internal.yx.ar.q(collection);
        boolean z = false;
        while (it2.hasNext()) {
            if (collection.contains(it2.next())) {
                it2.remove();
                z = true;
            }
        }
        return z;
    }

    public static gz i(Iterator it2) {
        return it2 instanceof gz ? (gz) it2 : new gz(it2);
    }

    public static boolean g(Iterator it2, Object obj) {
        if (obj == null) {
            while (it2.hasNext()) {
                if (it2.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it2.hasNext()) {
            if (obj.equals(it2.next())) {
                return true;
            }
        }
        return false;
    }
}
