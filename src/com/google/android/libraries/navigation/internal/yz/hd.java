package com.google.android.libraries.navigation.internal.yz;

import java.util.AbstractSequentialList;
import java.util.ListIterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class hd extends AbstractSequentialList {
    final /* synthetic */ Object a;
    final /* synthetic */ hn b;

    public hd(hn hnVar, Object obj) {
        this.a = obj;
        this.b = hnVar;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new hm(this.b, this.a, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        hj hjVar = (hj) this.b.c.get(this.a);
        if (hjVar == null) {
            return 0;
        }
        return hjVar.c;
    }
}
