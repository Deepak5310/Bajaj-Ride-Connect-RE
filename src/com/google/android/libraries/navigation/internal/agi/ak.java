package com.google.android.libraries.navigation.internal.agi;

import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ak extends ad implements Cloneable, lb {
    protected ak() {
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ad, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: a */
    public abstract gi iterator();

    @Override // com.google.android.libraries.navigation.internal.agi.ad, com.google.android.libraries.navigation.internal.agi.kx
    /* JADX INFO: renamed from: b */
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
    public final int hashCode() {
        gi it2 = iterator();
        int iIdentityHashCode = 0;
        for (int size = size(); size != 0; size--) {
            iIdentityHashCode += System.identityHashCode(it2.next());
        }
        return iIdentityHashCode;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ad, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
