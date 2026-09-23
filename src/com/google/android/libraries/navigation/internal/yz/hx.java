package com.google.android.libraries.navigation.internal.yz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hx {
    static int a(int i) {
        bs.d(i, "arraySize");
        return com.google.android.libraries.navigation.internal.zy.i.e(((long) i) + 5 + ((long) (i / 10)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ArrayList b(Iterable iterable) {
        com.google.android.libraries.navigation.internal.yx.ar.q(iterable);
        return iterable instanceof Collection ? new ArrayList((Collection) iterable) : c(iterable.iterator());
    }

    public static ArrayList c(Iterator it2) {
        ArrayList arrayList = new ArrayList();
        hb.f(arrayList, it2);
        return arrayList;
    }

    @SafeVarargs
    public static ArrayList d(Object... objArr) {
        com.google.android.libraries.navigation.internal.yx.ar.q(objArr);
        ArrayList arrayList = new ArrayList(a(objArr.length));
        Collections.addAll(arrayList, objArr);
        return arrayList;
    }

    public static ArrayList e(int i) {
        bs.d(i, "initialArraySize");
        return new ArrayList(i);
    }

    public static ArrayList f(int i) {
        return new ArrayList(a(i));
    }

    public static List g(List list) {
        if (list instanceof ev) {
            return ((ev) list).h();
        }
        if (list instanceof hs) {
            return ((hs) list).a;
        }
        return list instanceof RandomAccess ? new hq(list) : new hs(list);
    }

    public static List h(List list, com.google.android.libraries.navigation.internal.yx.aa aaVar) {
        return list instanceof RandomAccess ? new hu(list, aaVar) : new hw(list, aaVar);
    }

    public static boolean i(List list, Object obj) {
        if (obj == list) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (list2 instanceof RandomAccess) {
            for (int i = 0; i < size; i++) {
                if (!com.google.android.libraries.navigation.internal.yx.am.a(list.get(i), list2.get(i))) {
                    return false;
                }
            }
            return true;
        }
        Iterator it2 = list.iterator();
        Iterator it3 = list2.iterator();
        while (it2.hasNext()) {
            if (it3.hasNext() && com.google.android.libraries.navigation.internal.yx.am.a(it2.next(), it3.next())) {
            }
        }
        return !it3.hasNext();
    }
}
