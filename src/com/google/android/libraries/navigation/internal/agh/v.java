package com.google.android.libraries.navigation.internal.agh;

import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class v extends n implements Cloneable, he {
    protected v() {
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: a */
    public abstract gs m();

    @Override // com.google.android.libraries.navigation.internal.agh.n, java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public /* synthetic */ boolean add(Object obj) {
        return ge.a(this, (Long) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf, com.google.android.libraries.navigation.internal.agh.he
    /* JADX INFO: renamed from: b */
    public /* synthetic */ hl spliterator() {
        throw null;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (set.size() != size()) {
            return false;
        }
        return set instanceof he ? f((he) set) : containsAll(set);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf
    @Deprecated
    public final boolean g(long j) {
        return l(j);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        gs it2 = m();
        int iC = 0;
        for (int size = size(); size != 0; size--) {
            iC += com.google.android.libraries.navigation.internal.agc.e.c(it2.nextLong());
        }
        return iC;
    }

    public boolean l(long j) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
