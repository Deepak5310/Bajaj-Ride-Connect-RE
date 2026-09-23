package com.google.android.libraries.navigation.internal.yz;

import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class ad extends y implements SortedSet {
    final /* synthetic */ ae g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(ae aeVar, Object obj, SortedSet sortedSet, y yVar) {
        super(aeVar, obj, sortedSet, yVar);
        this.g = aeVar;
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return e().comparator();
    }

    public SortedSet e() {
        return (SortedSet) this.b;
    }

    @Override // java.util.SortedSet
    public final Object first() {
        b();
        return e().first();
    }

    @Override // java.util.SortedSet
    public final SortedSet headSet(Object obj) {
        b();
        SortedSet sortedSetHeadSet = e().headSet(obj);
        y yVar = this.c;
        if (yVar == null) {
            yVar = this;
        }
        return new ad(this.g, this.a, sortedSetHeadSet, yVar);
    }

    @Override // java.util.SortedSet
    public final Object last() {
        b();
        return e().last();
    }

    @Override // java.util.SortedSet
    public final SortedSet subSet(Object obj, Object obj2) {
        b();
        SortedSet sortedSetSubSet = e().subSet(obj, obj2);
        y yVar = this.c;
        if (yVar == null) {
            yVar = this;
        }
        return new ad(this.g, this.a, sortedSetSubSet, yVar);
    }

    @Override // java.util.SortedSet
    public final SortedSet tailSet(Object obj) {
        b();
        SortedSet sortedSetTailSet = e().tailSet(obj);
        y yVar = this.c;
        if (yVar == null) {
            yVar = this;
        }
        return new ad(this.g, this.a, sortedSetTailSet, yVar);
    }
}
