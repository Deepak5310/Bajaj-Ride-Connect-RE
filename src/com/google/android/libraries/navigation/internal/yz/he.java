package com.google.android.libraries.navigation.internal.yz;

import java.util.AbstractSequentialList;
import java.util.ListIterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class he extends AbstractSequentialList {
    final /* synthetic */ hn a;

    public he(hn hnVar) {
        this.a = hnVar;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new hl(this.a, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.d;
    }
}
