package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ml extends mn {
    final /* synthetic */ Set a;
    final /* synthetic */ Set b;

    public ml(Set set, Set set2) {
        this.a = set;
        this.b = set2;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.mn, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: a */
    public final nn iterator() {
        return new mk(this.a, this.b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.a.contains(obj) && !this.b.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.b.containsAll(this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        Iterator it2 = this.a.iterator();
        int i = 0;
        while (it2.hasNext()) {
            if (!this.b.contains(it2.next())) {
                i++;
            }
        }
        return i;
    }
}
