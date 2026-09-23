package com.google.android.libraries.navigation.internal.yz;

import java.util.AbstractSequentialList;
import java.util.ListIterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class hh extends AbstractSequentialList {
    final /* synthetic */ hn a;

    public hh(hn hnVar) {
        this.a = hnVar;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        hl hlVar = new hl(this.a, i);
        return new hg(hlVar, hlVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.d;
    }
}
