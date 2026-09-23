package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bt {
    static StringBuilder a(int i) {
        bs.d(i, "size");
        return new StringBuilder((int) Math.min(((long) i) * 8, 1073741824L));
    }

    public static boolean b(Collection collection, Collection collection2) {
        Iterator it2 = collection2.iterator();
        while (it2.hasNext()) {
            if (!collection.contains(it2.next())) {
                return false;
            }
        }
        return true;
    }

    static boolean c(Collection collection, Object obj) {
        com.google.android.libraries.navigation.internal.yx.ar.q(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static boolean d(Collection collection, Object obj) {
        com.google.android.libraries.navigation.internal.yx.ar.q(collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }
}
