package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class lj {
    public static Object[] a(Collection collection, Object[] objArr) {
        int size = collection.size();
        if (objArr.length < size) {
            objArr = lp.a(objArr, size);
        }
        Iterator it2 = collection.iterator();
        int i = 0;
        while (it2.hasNext()) {
            objArr[i] = it2.next();
            i++;
        }
        if (objArr.length > size) {
            objArr[size] = null;
        }
        return objArr;
    }

    static void b(Object obj, int i) {
        if (obj == null) {
            throw new NullPointerException(com.google.android.libraries.navigation.internal.b.b.b(i, "at index "));
        }
    }

    static void c(Object... objArr) {
        d(objArr, objArr.length);
    }

    static void d(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            b(objArr[i2], i2);
        }
    }
}
