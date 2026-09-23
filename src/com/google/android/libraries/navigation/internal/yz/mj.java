package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class mj extends mn {
    final /* synthetic */ Set a;
    final /* synthetic */ Set b;

    public mj(Set set, Set set2) {
        this.a = set;
        this.b = set2;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.mn, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: a */
    public final nn iterator() {
        return new mi(this.a, this.b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.a.contains(obj) || this.b.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.a.isEmpty() && this.b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        Set set = this.b;
        int size = this.a.size();
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (!this.a.contains(it2.next())) {
                size++;
            }
        }
        return size;
    }
}
