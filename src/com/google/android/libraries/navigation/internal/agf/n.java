package com.google.android.libraries.navigation.internal.agf;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class n implements Serializable, l {
    private static final long serialVersionUID = -7046029254386353129L;
    protected final l a;

    protected n(l lVar) {
        this.a = (l) Objects.requireNonNull(lVar);
    }

    @Deprecated
    public static boolean d() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: a */
    public final v iterator() {
        return new x(this.a.iterator());
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return d();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final ao spliterator() {
        return this.a.spliterator();
    }

    public boolean c(float f) {
        throw null;
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agf.l, java.util.Collection
    @Deprecated
    public final boolean contains(Object obj) {
        return this.a.contains(obj);
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        return this.a.containsAll(collection);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.l
    public final boolean e(float f) {
        return this.a.e(f);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return this.a.equals(obj);
    }

    public boolean g(float f) {
        throw null;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.agf.l
    public final boolean i(ah ahVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

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
        return k.b(this, predicate);
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final int size() {
        return this.a.size();
    }

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
