package com.google.android.libraries.navigation.internal.agg;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface ei extends PrimitiveIterator.OfInt {
    @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
    @Deprecated
    void forEachRemaining(Consumer consumer);

    @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
    @Deprecated
    Integer next();

    @Override // java.util.PrimitiveIterator.OfInt
    int nextInt();
}
