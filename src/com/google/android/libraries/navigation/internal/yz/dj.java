package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class dj extends dh implements ListIterator {
    protected dj() {
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dh
    protected /* bridge */ /* synthetic */ Iterator a() {
        throw null;
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        b().add(obj);
    }

    protected abstract ListIterator b();

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return b().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return b().nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return b().previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return b().previousIndex();
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        b().set(obj);
    }
}
