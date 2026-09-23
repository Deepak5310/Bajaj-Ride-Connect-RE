package com.google.android.libraries.navigation.internal.agg;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class h extends AbstractCollection implements Cdo {
    protected h() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract ei iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        return collection instanceof Cdo ? e((Cdo) collection) : super.addAll(collection);
    }

    public /* synthetic */ fh b() {
        throw null;
    }

    public boolean c(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.android.libraries.navigation.internal.agg.Cdo
    @Deprecated
    public final boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        return f(((Integer) obj).intValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean containsAll(Collection collection) {
        return collection instanceof Cdo ? g((Cdo) collection) : super.containsAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean add(Integer num) {
        return dn.a(this, num);
    }

    public boolean e(Cdo cdo) {
        ei it2 = cdo.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (c(it2.nextInt())) {
                z = true;
            }
        }
        return z;
    }

    public boolean f(int i) {
        throw null;
    }

    public boolean g(Cdo cdo) {
        ei it2 = cdo.iterator();
        while (it2.hasNext()) {
            if (!f(it2.nextInt())) {
                return false;
            }
        }
        return true;
    }

    public boolean h(int i) {
        ei it2 = iterator();
        while (it2.hasNext()) {
            if (i == it2.nextInt()) {
                it2.remove();
                return true;
            }
        }
        return false;
    }

    public boolean i(Cdo cdo) {
        ei it2 = cdo.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (h(it2.nextInt())) {
                z = true;
            }
        }
        return z;
    }

    public /* synthetic */ boolean j(IntPredicate intPredicate) {
        Objects.requireNonNull(intPredicate);
        ei it2 = iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (intPredicate.test(it2.nextInt())) {
                it2.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean k(Cdo cdo) {
        ei it2 = iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (!cdo.f(it2.nextInt())) {
                it2.remove();
                z = true;
            }
        }
        return z;
    }

    public int[] l() {
        throw null;
    }

    @Override // java.util.Collection, com.google.android.libraries.navigation.internal.agg.Cdo
    public final /* synthetic */ Stream parallelStream() {
        dm.a();
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @Deprecated
    public boolean remove(Object obj) {
        if (obj == null) {
            return false;
        }
        return h(((Integer) obj).intValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        return collection instanceof Cdo ? i((Cdo) collection) : super.removeAll(collection);
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return dn.b(this, predicate);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        return collection instanceof Cdo ? k((Cdo) collection) : super.retainAll(collection);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return b();
    }

    @Override // java.util.Collection, com.google.android.libraries.navigation.internal.agg.Cdo
    public final /* synthetic */ Stream stream() {
        dm.a();
        return null;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        ei it2 = iterator();
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(String.valueOf(it2.nextInt()));
            size--;
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
