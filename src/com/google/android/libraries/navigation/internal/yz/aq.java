package com.google.android.libraries.navigation.internal.yz;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class aq<E> extends AbstractCollection<E> implements ku<E> {
    private transient Set a;
    private transient Set b;

    public int a(Object obj, int i) {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.android.libraries.navigation.internal.yz.ku
    public final boolean add(Object obj) {
        a(obj, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        com.google.android.libraries.navigation.internal.yx.ar.q(collection);
        if (!(collection instanceof ku)) {
            if (collection.isEmpty()) {
                return false;
            }
            return hb.f(this, collection.iterator());
        }
        ku kuVar = (ku) collection;
        if (kuVar instanceof ai) {
            ai aiVar = (ai) kuVar;
            if (aiVar.isEmpty()) {
                return false;
            }
            for (int iA = aiVar.a.a(); iA >= 0; iA = aiVar.a.f(iA)) {
                a(aiVar.a.k(iA), aiVar.a.c(iA));
            }
        } else {
            if (kuVar.isEmpty()) {
                return false;
            }
            for (kt ktVar : kuVar.m()) {
                a(ktVar.b(), ktVar.a());
            }
        }
        return true;
    }

    public abstract int c();

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.android.libraries.navigation.internal.yz.ku
    public final boolean contains(Object obj) {
        return b(obj) > 0;
    }

    public int d(Object obj, int i) {
        throw null;
    }

    public abstract Iterator e();

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ku) {
            ku kuVar = (ku) obj;
            if (size() == kuVar.size() && m().size() == kuVar.m().size()) {
                for (kt ktVar : kuVar.m()) {
                    if (b(ktVar.b()) != ktVar.a()) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public abstract Iterator f();

    public void h(Object obj) {
        throw null;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return m().hashCode();
    }

    public boolean i(Object obj, int i) {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return m().isEmpty();
    }

    public Set j() {
        return new ao(this);
    }

    public Set k() {
        return new ap(this);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ku
    public final Set l() {
        Set set = this.a;
        if (set != null) {
            return set;
        }
        Set setJ = j();
        this.a = setJ;
        return setJ;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ku
    public final Set m() {
        Set set = this.b;
        if (set != null) {
            return set;
        }
        Set setK = k();
        this.b = setK;
        return setK;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.android.libraries.navigation.internal.yz.ku
    public final boolean remove(Object obj) {
        return d(obj, 1) > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        if (collection instanceof ku) {
            collection = ((ku) collection).l();
        }
        return l().removeAll(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        com.google.android.libraries.navigation.internal.yx.ar.q(collection);
        if (collection instanceof ku) {
            collection = ((ku) collection).l();
        }
        return l().retainAll(collection);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return m().toString();
    }
}
