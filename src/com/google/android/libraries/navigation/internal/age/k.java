package com.google.android.libraries.navigation.internal.age;

import java.util.Collection;
import java.util.function.DoublePredicate;
import java.util.stream.Stream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface k extends Collection, Iterable {
    q a();

    aa b();

    boolean c(double d);

    @Override // java.util.Collection, com.google.android.libraries.navigation.internal.age.k
    @Deprecated
    boolean contains(Object obj);

    boolean e(double d);

    boolean g(double d);

    boolean i(DoublePredicate doublePredicate);

    @Override // com.google.android.libraries.navigation.internal.age.k
    @Deprecated
    Stream parallelStream();

    @Override // com.google.android.libraries.navigation.internal.age.k
    @Deprecated
    Stream stream();
}
