package com.google.android.libraries.navigation.internal.age;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a extends AbstractCollection implements k {
    protected a() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract q iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public /* synthetic */ boolean add(Object obj) {
        return j.a(this, (Double) obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        return collection instanceof k ? d((k) collection) : super.addAll(collection);
    }

    @Override // com.google.android.libraries.navigation.internal.age.k
    public /* synthetic */ aa b() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.age.k
    public boolean c(double d) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.android.libraries.navigation.internal.age.k
    @Deprecated
    public final boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        return e(((Double) obj).doubleValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean containsAll(Collection collection) {
        return collection instanceof k ? f((k) collection) : super.containsAll(collection);
    }

    public boolean d(k kVar) {
        q it2 = kVar.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (c(it2.nextDouble())) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.age.k
    public boolean e(double d) {
        throw null;
    }

    public boolean f(k kVar) {
        q it2 = kVar.iterator();
        while (it2.hasNext()) {
            if (!e(it2.nextDouble())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.age.k
    public boolean g(double d) {
        q it2 = iterator();
        while (it2.hasNext()) {
            if (d == it2.nextDouble()) {
                it2.remove();
                return true;
            }
        }
        return false;
    }

    public boolean h(k kVar) {
        q it2 = kVar.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (g(it2.nextDouble())) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.age.k
    public /* synthetic */ boolean i(DoublePredicate doublePredicate) {
        Objects.requireNonNull(doublePredicate);
        q it2 = iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (doublePredicate.test(it2.nextDouble())) {
                it2.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean j(k kVar) {
        q it2 = iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (!kVar.e(it2.nextDouble())) {
                it2.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, com.google.android.libraries.navigation.internal.age.k
    public final /* synthetic */ Stream parallelStream() {
        i.a();
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        if (obj == null) {
            return false;
        }
        return g(((Double) obj).doubleValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        return collection instanceof k ? h((k) collection) : super.removeAll(collection);
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return j.b(this, predicate);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        return collection instanceof k ? j((k) collection) : super.retainAll(collection);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return b();
    }

    @Override // java.util.Collection, com.google.android.libraries.navigation.internal.age.k
    public final /* synthetic */ Stream stream() {
        i.a();
        return null;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        q it2 = iterator();
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(String.valueOf(it2.nextDouble()));
            size--;
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
