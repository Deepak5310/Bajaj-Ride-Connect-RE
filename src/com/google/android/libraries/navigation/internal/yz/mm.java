package com.google.android.libraries.navigation.internal.yz;

import java.util.AbstractSet;
import java.util.Collection;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class mm extends AbstractSet {
    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        return mp.k(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        com.google.android.libraries.navigation.internal.yx.ar.q(collection);
        return super.retainAll(collection);
    }
}
