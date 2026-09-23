package com.google.android.libraries.navigation.internal.agd;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@FunctionalInterface
public interface ba extends Predicate, IntPredicate {
    ba a(ba baVar);

    ba b(IntPredicate intPredicate);

    ba c();

    ba d(ba baVar);

    ba e(IntPredicate intPredicate);

    boolean f(byte b);

    @Deprecated
    boolean g(Byte b);
}
