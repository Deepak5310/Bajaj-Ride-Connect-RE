package com.google.android.libraries.navigation.internal.agh;

import java.util.Collection;
import java.util.function.LongPredicate;
import java.util.stream.Stream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface gf extends Collection, Iterable {
    gs a();

    hl b();

    boolean c(long j);

    @Override // java.util.Collection
    @Deprecated
    boolean contains(Object obj);

    boolean d(gf gfVar);

    boolean e(long j);

    boolean g(long j);

    boolean i(LongPredicate longPredicate);

    long[] k();

    @Override // java.util.Collection
    @Deprecated
    Stream parallelStream();

    @Override // java.util.Collection
    @Deprecated
    Stream stream();
}
