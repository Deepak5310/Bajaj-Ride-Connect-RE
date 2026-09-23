package com.google.android.libraries.navigation.internal.age;

import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b extends a implements Cloneable, u {
    protected b() {
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: a */
    public abstract q iterator();

    @Override // com.google.android.libraries.navigation.internal.age.a, java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final /* synthetic */ boolean add(Object obj) {
        return j.a(this, (Double) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, com.google.android.libraries.navigation.internal.age.k
    /* JADX INFO: renamed from: b */
    public /* synthetic */ aa spliterator() {
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
        return set instanceof u ? f((u) set) : containsAll(set);
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, com.google.android.libraries.navigation.internal.age.k
    @Deprecated
    public final boolean g(double d) {
        return k(d);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        q it2 = iterator();
        int iB = 0;
        for (int size = size(); size != 0; size--) {
            iB += com.google.android.libraries.navigation.internal.agc.e.b(it2.nextDouble());
        }
        return iB;
    }

    public boolean k(double d) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
