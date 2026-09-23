package com.google.android.libraries.navigation.internal.agg;

import java.util.Collection;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

/* JADX INFO: renamed from: com.google.android.libraries.navigation.internal.agg.do, reason: invalid class name */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface Cdo extends Collection, Iterable {
    ei a();

    fh b();

    boolean c(int i);

    @Override // java.util.Collection
    @Deprecated
    boolean contains(Object obj);

    boolean e(Cdo cdo);

    boolean f(int i);

    boolean h(int i);

    boolean j(IntPredicate intPredicate);

    int[] l();

    @Override // java.util.Collection
    @Deprecated
    Stream parallelStream();

    @Override // java.util.Collection
    @Deprecated
    Stream stream();
}
