package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.text.Typography;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gs {
    public static Iterable a(Iterable iterable, com.google.android.libraries.navigation.internal.yx.as asVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(iterable);
        com.google.android.libraries.navigation.internal.yx.ar.q(asVar);
        return new go(iterable, asVar);
    }

    public static Iterable b(Iterable iterable, com.google.android.libraries.navigation.internal.yx.aa aaVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(iterable);
        return new gp(iterable, aaVar);
    }

    public static Object c(Iterable iterable, Object obj) {
        return hb.b(iterable.iterator(), obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object d(Iterable iterable) {
        Object next;
        if (iterable instanceof List) {
            if (iterable.isEmpty()) {
                throw new NoSuchElementException();
            }
            return iterable.get(iterable.size() - 1);
        }
        Iterator it2 = iterable.iterator();
        do {
            next = it2.next();
        } while (it2.hasNext());
        return next;
    }

    public static Object e(Iterable iterable) {
        Iterator it2 = iterable.iterator();
        Object next = it2.next();
        if (!it2.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder("expected one element but was: <");
        sb.append(next);
        for (int i = 0; i < 4 && it2.hasNext(); i++) {
            sb.append(", ");
            sb.append(it2.next());
        }
        if (it2.hasNext()) {
            sb.append(", ...");
        }
        sb.append(Typography.greater);
        throw new IllegalArgumentException(sb.toString());
    }

    public static boolean f(Collection collection, Iterable iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        com.google.android.libraries.navigation.internal.yx.ar.q(iterable);
        return hb.f(collection, iterable.iterator());
    }

    public static boolean g(Iterable iterable, com.google.android.libraries.navigation.internal.yx.as asVar) {
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            if (!asVar.a(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(Iterable iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    static Object[] i(Iterable iterable) {
        return k(iterable).toArray();
    }

    public static Object[] j(Iterable iterable, Object[] objArr) {
        return k(iterable).toArray(objArr);
    }

    private static Collection k(Iterable iterable) {
        return iterable instanceof Collection ? (Collection) iterable : hx.c(iterable.iterator());
    }
}
