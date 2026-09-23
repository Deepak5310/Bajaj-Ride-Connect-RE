package com.google.android.libraries.navigation.internal.agd;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a extends AbstractCollection implements w {
    protected a() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract al iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public /* synthetic */ boolean add(Object obj) {
        return v.a(this, (Byte) obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        return collection instanceof w ? d((w) collection) : super.addAll(collection);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.w
    public /* synthetic */ be b() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.w
    public boolean c(byte b) {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        return e(((Byte) obj).byteValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return collection instanceof w ? f((w) collection) : super.containsAll(collection);
    }

    public boolean d(w wVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.w
    public boolean e(byte b) {
        throw null;
    }

    public final boolean f(w wVar) {
        al it2 = wVar.iterator();
        while (it2.hasNext()) {
            if (!e(it2.c())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.w
    public boolean g(byte b) {
        throw null;
    }

    public boolean h(w wVar) {
        al it2 = wVar.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (g(it2.c())) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.w
    public final /* synthetic */ boolean i(ba baVar) {
        Objects.requireNonNull(baVar);
        al it2 = iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (baVar.f(it2.c())) {
                it2.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.w
    public byte[] j() {
        throw null;
    }

    @Override // java.util.Collection
    public final /* synthetic */ Stream parallelStream() {
        u.a();
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        if (obj == null) {
            return false;
        }
        return g(((Byte) obj).byteValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        return collection instanceof w ? h((w) collection) : super.removeAll(collection);
    }

    @Override // java.util.Collection
    public final /* synthetic */ boolean removeIf(final Predicate predicate) {
        return i(predicate instanceof ba ? (ba) predicate : new ba() { // from class: com.google.android.libraries.navigation.internal.agd.t
            @Override // com.google.android.libraries.navigation.internal.agd.ba
            public final /* synthetic */ ba a(ba baVar) {
                return az.a(this, baVar);
            }

            @Override // java.util.function.IntPredicate
            public final /* bridge */ /* synthetic */ IntPredicate and(IntPredicate intPredicate) {
                return b(intPredicate);
            }

            @Override // java.util.function.Predicate
            public final /* synthetic */ Predicate and(Predicate predicate2) {
                az.l();
                return null;
            }

            @Override // com.google.android.libraries.navigation.internal.agd.ba
            public final /* synthetic */ ba b(IntPredicate intPredicate) {
                return az.b(this, intPredicate);
            }

            @Override // com.google.android.libraries.navigation.internal.agd.ba
            public final /* synthetic */ ba c() {
                return new av(this);
            }

            @Override // com.google.android.libraries.navigation.internal.agd.ba
            public final /* synthetic */ ba d(ba baVar) {
                return az.c(this, baVar);
            }

            @Override // com.google.android.libraries.navigation.internal.agd.ba
            public final /* synthetic */ ba e(IntPredicate intPredicate) {
                return az.d(this, intPredicate);
            }

            @Override // com.google.android.libraries.navigation.internal.agd.ba
            public final boolean f(byte b) {
                return predicate.test(Byte.valueOf(com.google.android.libraries.navigation.internal.agc.g.a(b)));
            }

            @Override // com.google.android.libraries.navigation.internal.agd.ba
            public final /* synthetic */ boolean g(Byte b) {
                return az.j(this, b);
            }

            @Override // java.util.function.Predicate, java.util.function.IntPredicate
            public final /* bridge */ /* synthetic */ IntPredicate negate() {
                return c();
            }

            @Override // java.util.function.Predicate, java.util.function.IntPredicate
            public final /* bridge */ /* synthetic */ Predicate negate() {
                return c();
            }

            @Override // java.util.function.IntPredicate
            public final /* bridge */ /* synthetic */ IntPredicate or(IntPredicate intPredicate) {
                return e(intPredicate);
            }

            @Override // java.util.function.Predicate
            public final /* synthetic */ Predicate or(Predicate predicate2) {
                az.m();
                return null;
            }

            @Override // java.util.function.IntPredicate
            public final /* synthetic */ boolean test(int i) {
                return az.i(this, i);
            }

            @Override // java.util.function.Predicate
            public final /* bridge */ /* synthetic */ boolean test(Object obj) {
                return g((Byte) obj);
            }
        });
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        if (!(collection instanceof w)) {
            return super.retainAll(collection);
        }
        w wVar = (w) collection;
        al it2 = iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (!wVar.e(it2.c())) {
                it2.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return b();
    }

    @Override // java.util.Collection
    public final /* synthetic */ Stream stream() {
        u.a();
        return null;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        al it2 = iterator();
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(String.valueOf((int) it2.c()));
            size--;
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
