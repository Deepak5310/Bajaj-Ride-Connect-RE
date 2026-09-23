package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class hw extends AbstractSequentialList implements Serializable {
    private static final long serialVersionUID = 0;
    final List a;
    final com.google.android.libraries.navigation.internal.yx.aa b;

    public hw(List list, com.google.android.libraries.navigation.internal.yx.aa aaVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(list);
        this.a = list;
        this.b = aaVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new hv(this, this.a.listIterator(i));
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        this.a.subList(i, i2).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.size();
    }
}
