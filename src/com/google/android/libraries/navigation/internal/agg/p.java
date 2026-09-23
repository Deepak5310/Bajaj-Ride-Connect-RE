package com.google.android.libraries.navigation.internal.agg;

import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class p extends h implements Cloneable, ez {
    protected p() {
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: a */
    public abstract ei n();

    @Override // com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public /* synthetic */ boolean add(Object obj) {
        return dn.a(this, (Integer) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    /* JADX INFO: renamed from: b */
    public /* synthetic */ fh spliterator() {
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
        return set instanceof ez ? g((ez) set) : containsAll(set);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    @Deprecated
    public final boolean h(int i) {
        return m(i);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        ei it2 = n();
        int iNextInt = 0;
        for (int size = size(); size != 0; size--) {
            iNextInt += it2.nextInt();
        }
        return iNextInt;
    }

    public boolean m(int i) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
