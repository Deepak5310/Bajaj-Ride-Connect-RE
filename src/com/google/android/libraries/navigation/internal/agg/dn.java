package com.google.android.libraries.navigation.internal.agg;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class dn {
    @Deprecated
    public static boolean a(Cdo cdo, Integer num) {
        return cdo.c(num.intValue());
    }

    @Deprecated
    public static boolean b(Cdo cdo, final Predicate predicate) {
        return cdo.j(predicate instanceof IntPredicate ? (IntPredicate) predicate : new IntPredicate() { // from class: com.google.android.libraries.navigation.internal.agg.dl
            @Override // java.util.function.IntPredicate
            public final boolean test(int i) {
                return predicate.test(Integer.valueOf(i));
            }
        });
    }
}
