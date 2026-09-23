package com.google.android.libraries.navigation.internal.agf;

import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b extends a implements Cloneable, ai {
    protected b() {
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: a */
    public abstract v iterator();

    @Override // com.google.android.libraries.navigation.internal.agf.a, java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final /* synthetic */ boolean add(Object obj) {
        return k.a(this, (Float) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, com.google.android.libraries.navigation.internal.agf.l
    /* JADX INFO: renamed from: b */
    public /* synthetic */ ao spliterator() {
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
        return set instanceof ai ? f((ai) set) : containsAll(set);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, com.google.android.libraries.navigation.internal.agf.l
    @Deprecated
    public final boolean g(float f) {
        return k(f);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        v it2 = iterator();
        int iFloatToIntBits = 0;
        for (int size = size(); size != 0; size--) {
            iFloatToIntBits += Float.floatToIntBits(it2.a());
        }
        return iFloatToIntBits;
    }

    public boolean k(float f) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
