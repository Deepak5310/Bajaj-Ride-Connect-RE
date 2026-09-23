package com.google.android.libraries.navigation.internal.age;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s implements q {
    protected final q a;

    public s(q qVar) {
        this.a = qVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // com.google.android.libraries.navigation.internal.age.q, java.util.PrimitiveIterator.OfDouble, java.util.Iterator
    public final /* synthetic */ Double next() {
        return p.a(this);
    }

    @Override // java.util.PrimitiveIterator.OfDouble, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // com.google.android.libraries.navigation.internal.age.q, java.util.PrimitiveIterator.OfDouble
    public final double nextDouble() {
        return this.a.nextDouble();
    }

    @Override // com.google.android.libraries.navigation.internal.age.q, java.util.PrimitiveIterator.OfDouble, java.util.Iterator
    @Deprecated
    public final void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(consumer);
    }

    @Override // java.util.PrimitiveIterator
    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.a.forEachRemaining(doubleConsumer);
    }
}
