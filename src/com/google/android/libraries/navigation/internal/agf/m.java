package com.google.android.libraries.navigation.internal.agf;

import com.google.android.libraries.navigation.internal.agi.gd;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class m extends a {
    protected m() {
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, com.google.android.libraries.navigation.internal.agf.l
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ v iterator() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, com.google.android.libraries.navigation.internal.agf.l
    /* JADX INFO: renamed from: b */
    public final ao spliterator() {
        return aq.a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return collection.isEmpty();
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a
    public final boolean d(l lVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, com.google.android.libraries.navigation.internal.agf.l
    public final boolean e(float f) {
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a
    public final boolean f(l lVar) {
        return lVar.isEmpty();
    }

    @Override // java.lang.Iterable
    @Deprecated
    public final void forEach(Consumer consumer) {
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a
    public final boolean h(l lVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, com.google.android.libraries.navigation.internal.agf.l
    public final boolean i(ah ahVar) {
        Objects.requireNonNull(ahVar);
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return y.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a
    public final boolean j(l lVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, java.util.Collection
    @Deprecated
    public final boolean removeIf(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return aq.a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return gd.a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        if (objArr.length > 0) {
            objArr[0] = null;
        }
        return objArr;
    }
}
