package com.google.android.libraries.navigation.internal.agi;

import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u extends m implements Cloneable, hd {
    protected u() {
    }

    @Override // com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b */
    public abstract gi iterator();

    @Override // com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public /* synthetic */ hj spliterator() {
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
        return containsAll(set);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        gi it2 = iterator();
        int iHashCode = 0;
        for (int size = size(); size != 0; size--) {
            Object next = it2.next();
            iHashCode += next == null ? 0 : next.hashCode();
        }
        return iHashCode;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.m, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
