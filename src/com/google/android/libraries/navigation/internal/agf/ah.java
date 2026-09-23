package com.google.android.libraries.navigation.internal.agf;

import java.util.function.DoublePredicate;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@FunctionalInterface
public interface ah extends Predicate, DoublePredicate {
    ah a(ah ahVar);

    ah b(DoublePredicate doublePredicate);

    ah c();

    ah d(ah ahVar);

    ah e(DoublePredicate doublePredicate);

    boolean f(float f);

    @Deprecated
    boolean g(Float f);
}
