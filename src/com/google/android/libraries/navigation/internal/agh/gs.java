package com.google.android.libraries.navigation.internal.agh;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface gs extends PrimitiveIterator.OfLong {
    @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
    @Deprecated
    void forEachRemaining(Consumer consumer);

    @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
    @Deprecated
    Long next();

    @Override // java.util.PrimitiveIterator.OfLong
    long nextLong();
}
