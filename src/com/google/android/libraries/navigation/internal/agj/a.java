package com.google.android.libraries.navigation.internal.agj;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a extends AbstractCollection implements u {
    protected a() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract aj iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        i(((Short) obj).shortValue());
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        return collection instanceof u ? c((u) collection) : super.addAll(collection);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.u
    public /* synthetic */ ay b() {
        throw null;
    }

    public boolean c(u uVar) {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        return d(((Short) obj).shortValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        if (!(collection instanceof u)) {
            return super.containsAll(collection);
        }
        aj it2 = ((u) collection).iterator();
        while (it2.hasNext()) {
            if (!d(it2.d())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.u
    public boolean d(short s) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.u
    public boolean e(short s) {
        throw null;
    }

    public boolean f(u uVar) {
        aj it2 = uVar.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (e(it2.d())) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.u
    public final /* synthetic */ boolean g(av avVar) {
        Objects.requireNonNull(avVar);
        aj it2 = iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (avVar.g(it2.d())) {
                it2.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.u
    public short[] h() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.u
    public void i(short s) {
        throw null;
    }

    @Override // java.util.Collection
    public final /* synthetic */ Stream parallelStream() {
        t.a();
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        if (obj == null) {
            return false;
        }
        return e(((Short) obj).shortValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        return collection instanceof u ? f((u) collection) : super.removeAll(collection);
    }

    @Override // java.util.Collection
    public final /* synthetic */ boolean removeIf(final Predicate predicate) {
        return g(predicate instanceof av ? (av) predicate : new av() { // from class: com.google.android.libraries.navigation.internal.agj.s
            @Override // com.google.android.libraries.navigation.internal.agj.av
            public final /* synthetic */ av a(av avVar) {
                return au.a(this, avVar);
            }

            @Override // java.util.function.IntPredicate
            public final /* bridge */ /* synthetic */ IntPredicate and(IntPredicate intPredicate) {
                return b(intPredicate);
            }

            @Override // java.util.function.Predicate
            public final /* synthetic */ Predicate and(Predicate predicate2) {
                au.l();
                return null;
            }

            @Override // com.google.android.libraries.navigation.internal.agj.av
            public final /* synthetic */ av b(IntPredicate intPredicate) {
                return au.b(this, intPredicate);
            }

            @Override // com.google.android.libraries.navigation.internal.agj.av
            public final /* synthetic */ av c() {
                return new as(this);
            }

            @Override // com.google.android.libraries.navigation.internal.agj.av
            public final /* synthetic */ av d(av avVar) {
                return au.c(this, avVar);
            }

            @Override // com.google.android.libraries.navigation.internal.agj.av
            public final /* synthetic */ av e(IntPredicate intPredicate) {
                return au.d(this, intPredicate);
            }

            @Override // com.google.android.libraries.navigation.internal.agj.av
            public final /* synthetic */ boolean f(Short sh) {
                return au.k(this, sh);
            }

            @Override // com.google.android.libraries.navigation.internal.agj.av
            public final boolean g(short s) {
                return predicate.test(Short.valueOf(com.google.android.libraries.navigation.internal.agc.g.c(s)));
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
                au.m();
                return null;
            }

            @Override // java.util.function.IntPredicate
            public final /* synthetic */ boolean test(int i) {
                return au.i(this, i);
            }

            @Override // java.util.function.Predicate
            public final /* bridge */ /* synthetic */ boolean test(Object obj) {
                return f((Short) obj);
            }
        });
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        if (!(collection instanceof u)) {
            return super.retainAll(collection);
        }
        u uVar = (u) collection;
        aj it2 = iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (!uVar.d(it2.d())) {
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
        t.a();
        return null;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        aj it2 = iterator();
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(String.valueOf((int) it2.d()));
            size--;
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
