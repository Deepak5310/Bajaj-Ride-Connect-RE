package com.google.android.libraries.navigation.internal.agf;

import java.util.Collection;
import java.util.stream.Stream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface l extends Collection, Iterable {
    v a();

    ao b();

    boolean c(float f);

    @Override // java.util.Collection, com.google.android.libraries.navigation.internal.agf.l
    @Deprecated
    boolean contains(Object obj);

    boolean e(float f);

    boolean g(float f);

    boolean i(ah ahVar);

    @Override // com.google.android.libraries.navigation.internal.agf.l
    @Deprecated
    Stream parallelStream();

    @Override // com.google.android.libraries.navigation.internal.agf.l
    @Deprecated
    Stream stream();
}
