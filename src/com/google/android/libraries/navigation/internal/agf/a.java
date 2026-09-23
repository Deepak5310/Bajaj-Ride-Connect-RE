package com.google.android.libraries.navigation.internal.agf;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a extends AbstractCollection implements l {
    protected a() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract v iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public /* synthetic */ boolean add(Object obj) {
        return k.a(this, (Float) obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        return collection instanceof l ? d((l) collection) : super.addAll(collection);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.l
    public /* synthetic */ ao b() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.l
    public boolean c(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.android.libraries.navigation.internal.agf.l
    @Deprecated
    public final boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        return e(((Float) obj).floatValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean containsAll(Collection collection) {
        return collection instanceof l ? f((l) collection) : super.containsAll(collection);
    }

    public boolean d(l lVar) {
        v it2 = lVar.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (c(it2.a())) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.l
    public boolean e(float f) {
        throw null;
    }

    public boolean f(l lVar) {
        v it2 = lVar.iterator();
        while (it2.hasNext()) {
            if (!e(it2.a())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.l
    public boolean g(float f) {
        v it2 = iterator();
        while (it2.hasNext()) {
            if (f == it2.a()) {
                it2.remove();
                return true;
            }
        }
        return false;
    }

    public boolean h(l lVar) {
        v it2 = lVar.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (g(it2.a())) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.l
    public /* synthetic */ boolean i(ah ahVar) {
        Objects.requireNonNull(ahVar);
        v it2 = iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (ahVar.f(it2.a())) {
                it2.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean j(l lVar) {
        v it2 = iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (!lVar.e(it2.a())) {
                it2.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, com.google.android.libraries.navigation.internal.agf.l
    public final /* synthetic */ Stream parallelStream() {
        j.a();
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        if (obj == null) {
            return false;
        }
        return g(((Float) obj).floatValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        return collection instanceof l ? h((l) collection) : super.removeAll(collection);
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return k.b(this, predicate);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        return collection instanceof l ? j((l) collection) : super.retainAll(collection);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return b();
    }

    @Override // java.util.Collection, com.google.android.libraries.navigation.internal.agf.l
    public final /* synthetic */ Stream stream() {
        j.a();
        return null;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        v it2 = iterator();
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(String.valueOf(it2.a()));
            size--;
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
