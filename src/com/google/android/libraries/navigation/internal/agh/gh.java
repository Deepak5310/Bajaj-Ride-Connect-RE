package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class gh implements Serializable, gf {
    private static final long serialVersionUID = -7046029254386353129L;
    protected final gf a;

    protected gh(gf gfVar) {
        this.a = (gf) Objects.requireNonNull(gfVar);
    }

    @Deprecated
    public static boolean f() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: a */
    public final gs iterator() {
        return new gw(this.a.iterator());
    }

    @Override // java.util.Collection
    @Deprecated
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return f();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final hl spliterator() {
        return this.a.spliterator();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gf
    public boolean c(long j) {
        throw null;
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gf, java.util.Collection
    @Deprecated
    public final boolean contains(Object obj) {
        return this.a.contains(obj);
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        return this.a.containsAll(collection);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gf
    public boolean d(gf gfVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gf
    public final boolean e(long j) {
        return this.a.e(j);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return this.a.equals(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gf
    public boolean g(long j) {
        throw null;
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gf
    public final boolean i(LongPredicate longPredicate) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gf
    public long[] k() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gf, java.util.Collection
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
        return ge.b(this, predicate);
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final int size() {
        return this.a.size();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gf, java.util.Collection
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
