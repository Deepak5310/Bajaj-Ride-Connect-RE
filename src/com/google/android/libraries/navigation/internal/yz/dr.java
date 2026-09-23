package com.google.android.libraries.navigation.internal.yz;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class dr extends dq implements SortedSet {
    protected dr() {
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dq
    protected /* bridge */ /* synthetic */ Set b() {
        throw null;
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return h().comparator();
    }

    @Override // java.util.SortedSet
    public final Object first() {
        return h().first();
    }

    protected abstract SortedSet h();

    @Override // java.util.SortedSet
    public final SortedSet headSet(Object obj) {
        return h().headSet(obj);
    }

    @Override // java.util.SortedSet
    public final Object last() {
        return h().last();
    }

    @Override // java.util.SortedSet
    public final SortedSet subSet(Object obj, Object obj2) {
        return h().subSet(obj, obj2);
    }

    @Override // java.util.SortedSet
    public final SortedSet tailSet(Object obj) {
        return h().tailSet(obj);
    }
}
