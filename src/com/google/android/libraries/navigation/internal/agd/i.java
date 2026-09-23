package com.google.android.libraries.navigation.internal.agd;

import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class i extends a implements Cloneable, bb {
    protected i() {
    }

    @Override // com.google.android.libraries.navigation.internal.agd.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: a */
    public abstract al iterator();

    @Override // com.google.android.libraries.navigation.internal.agd.a, java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final /* synthetic */ boolean add(Object obj) {
        return v.a(this, (Byte) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.a, com.google.android.libraries.navigation.internal.agd.w
    public /* synthetic */ be b() {
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
        return set instanceof bb ? f((bb) set) : containsAll(set);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.a, com.google.android.libraries.navigation.internal.agd.w
    @Deprecated
    public final boolean g(byte b) {
        return k(b);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        al it2 = iterator();
        int iC = 0;
        for (int size = size(); size != 0; size--) {
            iC += it2.c();
        }
        return iC;
    }

    public boolean k(byte b) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.a, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return b();
    }
}
