package com.google.android.libraries.navigation.internal.age;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class m implements Serializable, k {
    private static final long serialVersionUID = -7046029254386353129L;
    protected final k a;

    protected m(k kVar) {
        this.a = (k) Objects.requireNonNull(kVar);
    }

    @Deprecated
    public static boolean d() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: a */
    public final q iterator() {
        return new s(this.a.iterator());
    }

    @Override // java.util.Collection
    @Deprecated
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return d();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final aa spliterator() {
        return this.a.spliterator();
    }

    @Override // com.google.android.libraries.navigation.internal.age.k
    public boolean c(double d) {
        throw null;
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.age.k, java.util.Collection
    @Deprecated
    public final boolean contains(Object obj) {
        return this.a.contains(obj);
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        return this.a.containsAll(collection);
    }

    @Override // com.google.android.libraries.navigation.internal.age.k
    public final boolean e(double d) {
        return this.a.e(d);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return this.a.equals(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.age.k
    public boolean g(double d) {
        throw null;
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.age.k
    public final boolean i(DoublePredicate doublePredicate) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // com.google.android.libraries.navigation.internal.age.k
    @Deprecated
    public Stream parallelStream() {
        this.a.parallelStream();
        return null;
    }

    @Override // java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final /* synthetic */ boolean removeIf(Predicate predicate) {
        return j.b(this, predicate);
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final int size() {
        return this.a.size();
    }

    @Override // com.google.android.libraries.navigation.internal.age.k
    @Deprecated
    public Stream stream() {
        this.a.stream();
        return null;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return this.a.toArray();
    }

    public final String toString() {
        return this.a.toString();
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return this.a.toArray(objArr);
    }
}
