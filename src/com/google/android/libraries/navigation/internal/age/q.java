package com.google.android.libraries.navigation.internal.age;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface q extends PrimitiveIterator.OfDouble {
    @Override // java.util.PrimitiveIterator.OfDouble, java.util.Iterator
    @Deprecated
    void forEachRemaining(Consumer consumer);

    @Override // java.util.PrimitiveIterator.OfDouble, java.util.Iterator
    @Deprecated
    Double next();

    @Override // java.util.PrimitiveIterator.OfDouble
    double nextDouble();
}
