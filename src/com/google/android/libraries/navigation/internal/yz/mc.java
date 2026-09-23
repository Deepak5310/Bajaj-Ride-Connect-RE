package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class mc extends gl {
    public static final mc c;
    final transient ev d;

    static {
        int i = ev.d;
        c = new mc(lv.a, lg.a);
    }

    public mc(ev evVar, Comparator comparator) {
        super(comparator);
        this.d = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.gl
    public final gl C(Object obj, boolean z) {
        return L(0, J(obj, z));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.gl
    public final gl E(Object obj, boolean z, Object obj2, boolean z2) {
        return G(obj, z).C(obj2, z2);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.gl
    public final gl G(Object obj, boolean z) {
        return L(K(obj, z), size());
    }

    @Override // com.google.android.libraries.navigation.internal.yz.gl, java.util.NavigableSet
    /* JADX INFO: renamed from: I */
    public final nn descendingIterator() {
        return this.d.h().iterator();
    }

    final int J(Object obj, boolean z) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        int iBinarySearch = Collections.binarySearch(this.d, obj, ((gl) this).a);
        if (iBinarySearch >= 0) {
            return z ? iBinarySearch + 1 : iBinarySearch;
        }
        return ~iBinarySearch;
    }

    final int K(Object obj, boolean z) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        int iBinarySearch = Collections.binarySearch(this.d, obj, ((gl) this).a);
        if (iBinarySearch >= 0) {
            return z ? iBinarySearch : iBinarySearch + 1;
        }
        return ~iBinarySearch;
    }

    final mc L(int i, int i2) {
        if (i == 0) {
            if (i2 == size()) {
                return this;
            }
            i = 0;
        }
        if (i >= i2) {
            return H(this.a);
        }
        ev evVar = this.d;
        return new mc(evVar.subList(i, i2), this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final int a(Object[] objArr, int i) {
        return this.d.a(objArr, i);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final int b() {
        return this.d.b();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final int c() {
        return this.d.c();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.gl, java.util.NavigableSet
    public final Object ceiling(Object obj) {
        int iK = K(obj, true);
        if (iK == size()) {
            return null;
        }
        return this.d.get(iK);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            try {
                if (Collections.binarySearch(this.d, obj, this.a) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        if (collection instanceof ku) {
            collection = ((ku) collection).l();
        }
        if (!ms.a(((gl) this).a, collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        nn nnVarListIterator = listIterator();
        Iterator it2 = collection.iterator();
        if (!nnVarListIterator.hasNext()) {
            return false;
        }
        Object next = it2.next();
        Object next2 = nnVarListIterator.next();
        while (true) {
            try {
                int iH = h(next2, next);
                if (iH < 0) {
                    if (!nnVarListIterator.hasNext()) {
                        return false;
                    }
                    next2 = nnVarListIterator.next();
                } else {
                    if (iH != 0) {
                        return false;
                    }
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fy, com.google.android.libraries.navigation.internal.yz.ek
    public final ev d() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.gl, com.google.android.libraries.navigation.internal.yz.fy, com.google.android.libraries.navigation.internal.yz.ek, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: e */
    public final nn listIterator() {
        return this.d.iterator();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fy, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!ms.a(this.a, set)) {
            return containsAll(set);
        }
        Iterator it2 = set.iterator();
        try {
            nn nnVarListIterator = listIterator();
            while (nnVarListIterator.hasNext()) {
                Object next = nnVarListIterator.next();
                Object next2 = it2.next();
                if (next2 == null || h(next, next2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final boolean f() {
        return this.d.f();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.gl, java.util.SortedSet
    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.d.get(0);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.gl, java.util.NavigableSet
    public final Object floor(Object obj) {
        int iJ = J(obj, true) - 1;
        if (iJ == -1) {
            return null;
        }
        return this.d.get(iJ);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final Object[] g() {
        return this.d.g();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.gl, java.util.NavigableSet
    public final Object higher(Object obj) {
        int iK = K(obj, false);
        if (iK == size()) {
            return null;
        }
        return this.d.get(iK);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.gl, java.util.SortedSet
    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.d.get(size() - 1);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.gl, java.util.NavigableSet
    public final Object lower(Object obj) {
        int iJ = J(obj, false) - 1;
        if (iJ == -1) {
            return null;
        }
        return this.d.get(iJ);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.d.size();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.gl, com.google.android.libraries.navigation.internal.yz.fy, com.google.android.libraries.navigation.internal.yz.ek
    public Object writeReplace() {
        return super.writeReplace();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.gl
    public final gl z() {
        Comparator comparatorReverseOrder = Collections.reverseOrder(this.a);
        return isEmpty() ? H(comparatorReverseOrder) : new mc(this.d.h(), comparatorReverseOrder);
    }
}
