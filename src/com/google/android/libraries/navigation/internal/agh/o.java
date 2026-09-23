package com.google.android.libraries.navigation.internal.agh;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class o implements gs {
    protected o() {
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        gr.c(this, consumer);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public /* synthetic */ Long next() {
        return gr.a(this);
    }

    @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator, java.util.ListIterator
    public /* bridge */ /* synthetic */ Object next() {
        return next();
    }
}
