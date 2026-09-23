package com.google.android.libraries.navigation.internal.yz;

import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ms {
    public static boolean a(Comparator comparator, Iterable iterable) {
        Comparator comparator2;
        com.google.android.libraries.navigation.internal.yx.ar.q(comparator);
        com.google.android.libraries.navigation.internal.yx.ar.q(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = ((SortedSet) iterable).comparator();
            if (comparator2 == null) {
                comparator2 = lg.a;
            }
        } else {
            if (!(iterable instanceof mr)) {
                return false;
            }
            comparator2 = ((mr) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
