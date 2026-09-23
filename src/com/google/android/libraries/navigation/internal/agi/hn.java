package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hn implements Serializable, Cloneable, hj {
    private static final long serialVersionUID = 8379247926738230492L;

    protected hn() {
    }

    private Object readResolve() {
        return hr.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hj
    /* JADX INFO: renamed from: b */
    public final hj trySplit() {
        throw null;
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return 16448;
    }

    public final Object clone() {
        return hr.a;
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return 0L;
    }

    @Override // java.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
    }

    @Override // java.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        return false;
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator trySplit() {
        return null;
    }
}
