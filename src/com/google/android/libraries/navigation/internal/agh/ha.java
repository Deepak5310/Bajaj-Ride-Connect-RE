package com.google.android.libraries.navigation.internal.agh;

import java.util.ListIterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface ha extends ListIterator, gb {
    @Deprecated
    Long b();

    void c(long j);

    @Deprecated
    void d(Long l);

    void e(long j);

    @Deprecated
    void f(Long l);

    @Override // java.util.ListIterator, java.util.Iterator, com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong
    @Deprecated
    Long next();

    @Override // java.util.ListIterator, java.util.Iterator
    void remove();
}
