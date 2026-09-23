package com.google.android.libraries.navigation.internal.agh;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class n extends AbstractCollection implements gf {
    protected n() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract gs iterator();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public /* synthetic */ boolean add(Object obj) {
        return ge.a(this, (Long) obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        return collection instanceof gf ? d((gf) collection) : super.addAll(collection);
    }

    public /* synthetic */ hl b() {
        throw null;
    }

    public boolean c(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.android.libraries.navigation.internal.agh.gf
    @Deprecated
    public final boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        return e(((Long) obj).longValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean containsAll(Collection collection) {
        return collection instanceof gf ? f((gf) collection) : super.containsAll(collection);
    }

    public boolean d(gf gfVar) {
        gs it2 = gfVar.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (c(it2.nextLong())) {
                z = true;
            }
        }
        return z;
    }

    public boolean e(long j) {
        throw null;
    }

    public boolean f(gf gfVar) {
        gs it2 = gfVar.iterator();
        while (it2.hasNext()) {
            if (!e(it2.nextLong())) {
                return false;
            }
        }
        return true;
    }

    public boolean g(long j) {
        gs it2 = iterator();
        while (it2.hasNext()) {
            if (j == it2.nextLong()) {
                it2.remove();
                return true;
            }
        }
        return false;
    }

    public boolean h(gf gfVar) {
        gs it2 = gfVar.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (g(it2.nextLong())) {
                z = true;
            }
        }
        return z;
    }

    public /* synthetic */ boolean i(LongPredicate longPredicate) {
        Objects.requireNonNull(longPredicate);
        gs it2 = iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (longPredicate.test(it2.nextLong())) {
                it2.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean j(gf gfVar) {
        gs it2 = iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (!gfVar.e(it2.nextLong())) {
                it2.remove();
                z = true;
            }
        }
        return z;
    }

    public long[] k() {
        throw null;
    }

    @Override // java.util.Collection, com.google.android.libraries.navigation.internal.agh.gf
    public final /* synthetic */ Stream parallelStream() {
        gd.a();
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        if (obj == null) {
            return false;
        }
        return g(((Long) obj).longValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        return collection instanceof gf ? h((gf) collection) : super.removeAll(collection);
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return ge.b(this, predicate);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        return collection instanceof gf ? j((gf) collection) : super.retainAll(collection);
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return b();
    }

    @Override // java.util.Collection, com.google.android.libraries.navigation.internal.agh.gf
    public final /* synthetic */ Stream stream() {
        gd.a();
        return null;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        gs it2 = iterator();
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(String.valueOf(it2.nextLong()));
            size--;
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
