package com.drew.lang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class Iterables {
    public static <E> List<E> toList(Iterable<E> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<E> it2 = iterable.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next());
        }
        return arrayList;
    }

    public static <E> Set<E> toSet(Iterable<E> iterable) {
        HashSet hashSet = new HashSet();
        Iterator<E> it2 = iterable.iterator();
        while (it2.hasNext()) {
            hashSet.add(it2.next());
        }
        return hashSet;
    }
}
