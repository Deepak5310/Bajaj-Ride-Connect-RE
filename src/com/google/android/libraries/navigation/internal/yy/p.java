package com.google.android.libraries.navigation.internal.yy;

import java.util.AbstractSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class p extends AbstractSet {
    final /* synthetic */ bi a;

    public p(bi biVar) {
        this.a = biVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.size();
    }
}
