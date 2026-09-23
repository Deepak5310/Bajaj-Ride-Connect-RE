package com.google.android.libraries.navigation.internal.ael;

import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ck {
    static bz a(Object obj, long j) {
        return (bz) em.j(obj, j);
    }

    public static final void b(Object obj, long j) {
        a(obj, j).b();
    }

    public static final void c(Object obj, Object obj2, long j) {
        bz bzVarA = a(obj, j);
        bz bzVarA2 = a(obj2, j);
        int size = bzVarA.size();
        int size2 = bzVarA2.size();
        if (size > 0 && size2 > 0) {
            if (!bzVarA.c()) {
                bzVarA = bzVarA.e(size2 + size);
            }
            bzVarA.addAll(bzVarA2);
        }
        if (size > 0) {
            bzVarA2 = bzVarA;
        }
        em.w(obj, j, bzVarA2);
    }

    public static final List d(Object obj, long j) {
        bz bzVarA = a(obj, j);
        if (bzVarA.c()) {
            return bzVarA;
        }
        int size = bzVarA.size();
        bz bzVarE = bzVarA.e(size == 0 ? 10 : size + size);
        em.w(obj, j, bzVarE);
        return bzVarE;
    }
}
