package com.google.android.libraries.navigation.internal.age;

import com.google.android.libraries.navigation.internal.agi.gd;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class l extends a {
    protected l() {
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, com.google.android.libraries.navigation.internal.age.k
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ q iterator() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, com.google.android.libraries.navigation.internal.age.k
    /* JADX INFO: renamed from: b */
    public final aa spliterator() {
        return ae.a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return collection.isEmpty();
    }

    @Override // com.google.android.libraries.navigation.internal.age.a
    public final boolean d(k kVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, com.google.android.libraries.navigation.internal.age.k
    public final boolean e(double d) {
        return false;
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.age.a
    public final boolean f(k kVar) {
        return kVar.isEmpty();
    }

    @Override // java.lang.Iterable
    @Deprecated
    public final void forEach(Consumer consumer) {
    }

    @Override // com.google.android.libraries.navigation.internal.age.a
    public final boolean h(k kVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, com.google.android.libraries.navigation.internal.age.k
    public final boolean i(DoublePredicate doublePredicate) {
        Objects.requireNonNull(doublePredicate);
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return t.a;
    }

    @Override // com.google.android.libraries.navigation.internal.age.a
    public final boolean j(k kVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, java.util.Collection
    @Deprecated
    public final boolean removeIf(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return ae.a;
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
