package com.google.android.libraries.navigation.internal.agh;

import java.util.function.LongPredicate;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ge {
    @Deprecated
    public static boolean a(gf gfVar, Long l) {
        return gfVar.c(l.longValue());
    }

    @Deprecated
    public static boolean b(gf gfVar, final Predicate predicate) {
        return gfVar.i(predicate instanceof LongPredicate ? (LongPredicate) predicate : new LongPredicate() { // from class: com.google.android.libraries.navigation.internal.agh.gc
            @Override // java.util.function.LongPredicate
            public final boolean test(long j) {
                return predicate.test(Long.valueOf(j));
            }
        });
    }
}
