package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gd;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class dp extends h {
    protected dp() {
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ ei n() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    /* JADX INFO: renamed from: b */
    public final fh spliterator() {
        return fp.a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return collection.isEmpty();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    public final boolean e(Cdo cdo) {
        throw new UnsupportedOperationException();
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

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    public final boolean f(int i) {
        return false;
    }

    @Override // java.lang.Iterable
    @Deprecated
    public final void forEach(Consumer consumer) {
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h
    public final boolean g(Cdo cdo) {
        return cdo.isEmpty();
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h
    public final boolean i(Cdo cdo) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: iterator */
    public /* synthetic */ Iterator n() {
        return eo.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    public final boolean j(IntPredicate intPredicate) {
        Objects.requireNonNull(intPredicate);
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h
    public final boolean k(Cdo cdo) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    public final int[] l() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, java.util.Collection
    @Deprecated
    public final boolean removeIf(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return fp.a;
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
