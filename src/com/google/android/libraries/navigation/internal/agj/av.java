package com.google.android.libraries.navigation.internal.agj;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@FunctionalInterface
public interface av extends Predicate, IntPredicate {
    av a(av avVar);

    av b(IntPredicate intPredicate);

    av c();

    av d(av avVar);

    av e(IntPredicate intPredicate);

    @Deprecated
    boolean f(Short sh);

    boolean g(short s);
}
