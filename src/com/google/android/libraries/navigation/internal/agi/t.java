package com.google.android.libraries.navigation.internal.agi;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class t extends m implements gu {
    protected t() {
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public gu subList(int i, int i2) {
        throw null;
    }

    public void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int i, Collection collection) {
        k(i);
        Iterator it2 = collection.iterator();
        boolean zHasNext = it2.hasNext();
        while (it2.hasNext()) {
            add(i, it2.next());
            i++;
        }
        return zHasNext;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public /* synthetic */ hj spliterator() {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        f(0, size());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public gw listIterator(int i) {
        throw null;
    }

    public void e(int i, Object[] objArr, int i2, int i3) {
        throw null;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        gw it2 = iterator();
        ListIterator listIterator = list.listIterator();
        while (size != 0) {
            if (!Objects.equals(it2.next(), listIterator.next())) {
                return false;
            }
            size--;
        }
        return true;
    }

    public void f(int i, int i2) {
        throw null;
    }

    public void forEach(Consumer consumer) {
        if (!(this instanceof RandomAccess)) {
            super.forEach(consumer);
            return;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            consumer.accept(get(i));
        }
    }

    public void g(int i, Object[] objArr, int i2) {
        throw null;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public int compareTo(List list) {
        int iCompareTo;
        if (list == this) {
            return 0;
        }
        if (!(list instanceof gu)) {
            gw it2 = iterator();
            ListIterator listIterator = list.listIterator();
            while (it2.hasNext() && listIterator.hasNext()) {
                iCompareTo = ((Comparable) it2.next()).compareTo(listIterator.next());
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            }
            if (!listIterator.hasNext()) {
                if (!it2.hasNext()) {
                    return 0;
                }
                return 1;
            }
            return -1;
        }
        gw it3 = iterator();
        gw it4 = ((gu) list).iterator();
        while (it3.hasNext() && it4.hasNext()) {
            iCompareTo = ((Comparable) it3.next()).compareTo(it4.next());
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        if (!it4.hasNext()) {
            if (!it3.hasNext()) {
                return 0;
            }
            return 1;
        }
        return -1;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        gw it2 = iterator();
        int iHashCode = 1;
        for (int size = size(); size != 0; size--) {
            E next = it2.next();
            iHashCode = (iHashCode * 31) + (next == 0 ? 0 : next.hashCode());
        }
        return iHashCode;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gu
    public final gw i() {
        return iterator();
    }

    public int indexOf(Object obj) {
        gw it2 = iterator();
        while (it2.hasNext()) {
            if (Objects.equals(obj, it2.next())) {
                return it2.previousIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final gw listIterator() {
        return listIterator(0);
    }

    protected final void k(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.j(i, "Index (", ") is negative"));
        }
        if (i <= size()) {
            return;
        }
        throw new IndexOutOfBoundsException("Index (" + i + ") is greater than list size (" + size() + ")");
    }

    protected final void l(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.j(i, "Index (", ") is negative"));
        }
        if (i < size()) {
            return;
        }
        throw new IndexOutOfBoundsException("Index (" + i + ") is greater than or equal to list size (" + size() + ")");
    }

    public int lastIndexOf(Object obj) {
        gw gwVarListIterator = listIterator(size());
        while (gwVarListIterator.hasPrevious()) {
            if (Objects.equals(obj, gwVarListIterator.previous())) {
                return gwVarListIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gu
    public final /* synthetic */ void m(Object[] objArr) {
        o(objArr);
    }

    public /* synthetic */ boolean n(int i, gu guVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gu
    public final /* synthetic */ void o(Object[] objArr) {
        g(0, objArr, objArr.length);
    }

    public Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    public Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ void sort(Comparator comparator) {
        Object[] array = toArray();
        if (comparator == null) {
            gd.b(array);
        } else {
            gd.c(array, comparator);
        }
        m(array);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.m, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        int size = size();
        if (size == 0) {
            return gd.a;
        }
        Object[] objArr = new Object[size];
        e(0, objArr, 0, size);
        return objArr;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        gw it2 = iterator();
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            size--;
            E next = it2.next();
            if (this == next) {
                sb.append("(this list)");
            } else {
                sb.append(String.valueOf(next));
            }
            z = false;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        add(size(), obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        int size = size();
        if (objArr.length < size) {
            objArr = Arrays.copyOf(objArr, size);
        }
        e(0, objArr, 0, size);
        if (objArr.length > size) {
            objArr[size] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
