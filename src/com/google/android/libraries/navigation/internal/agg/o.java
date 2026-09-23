package com.google.android.libraries.navigation.internal.agg;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class o extends h implements es {
    protected o() {
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final eu listIterator() {
        return listIterator(0);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.es
    public final /* synthetic */ Integer B(int i) {
        return er.a(this, i);
    }

    public /* synthetic */ Integer C(int i) {
        return Integer.valueOf(o(i));
    }

    public /* synthetic */ Integer D(int i, Integer num) {
        return Integer.valueOf(p(i, num.intValue()));
    }

    public /* synthetic */ void E(int i, Integer num) {
        r(i, num.intValue());
    }

    protected final void F(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.j(i, "Index (", ") is negative"));
        }
        if (i <= size()) {
            return;
        }
        throw new IndexOutOfBoundsException("Index (" + i + ") is greater than list size (" + size() + ")");
    }

    protected final void G(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.j(i, "Index (", ") is negative"));
        }
        if (i < size()) {
            return;
        }
        throw new IndexOutOfBoundsException("Index (" + i + ") is greater than or equal to list size (" + size() + ")");
    }

    @Override // com.google.android.libraries.navigation.internal.agg.es
    public final /* synthetic */ void H(int[] iArr) {
        J(iArr);
    }

    public /* synthetic */ void I(dt dtVar) {
        if (dtVar == null) {
            K();
            return;
        }
        int[] iArrL = l();
        di.f(iArrL, iArrL.length, dtVar);
        H(iArrL);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.es
    public final /* synthetic */ void J(int[] iArr) {
        v(0, iArr, iArr.length);
    }

    public /* synthetic */ void K() {
        int[] iArrL = l();
        di.g(iArrL, iArrL.length);
        H(iArrL);
    }

    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        E(i, (Integer) obj);
    }

    public boolean addAll(int i, Collection collection) {
        if (collection instanceof Cdo) {
            return u(i, (Cdo) collection);
        }
        F(i);
        Iterator it2 = collection.iterator();
        boolean zHasNext = it2.hasNext();
        while (it2.hasNext()) {
            r(i, ((Integer) it2.next()).intValue());
            i++;
        }
        return zHasNext;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    /* JADX INFO: renamed from: b */
    public /* synthetic */ fh spliterator() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo, com.google.android.libraries.navigation.internal.agg.es
    public boolean c(int i) {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        t(0, size());
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    public boolean e(Cdo cdo) {
        return u(size(), cdo);
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
        if (list instanceof es) {
            eu it2 = iterator();
            eu it3 = ((es) list).iterator();
            while (true) {
                int i = size - 1;
                if (size == 0) {
                    return true;
                }
                if (it2.nextInt() != it3.nextInt()) {
                    return false;
                }
                size = i;
            }
        } else {
            eu it4 = iterator();
            ListIterator listIterator = list.listIterator();
            while (true) {
                int i2 = size - 1;
                if (size == 0) {
                    return true;
                }
                if (!Objects.equals(it4.next(), listIterator.next())) {
                    return false;
                }
                size = i2;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    public final boolean f(int i) {
        return x(i) >= 0;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return B(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    public boolean h(int i) {
        throw null;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        eu it2 = iterator();
        int size = size();
        int iNextInt = 1;
        while (size != 0) {
            size--;
            iNextInt = (iNextInt * 31) + it2.nextInt();
        }
        return iNextInt;
    }

    @Override // java.util.List
    public final /* synthetic */ int indexOf(Object obj) {
        return x(((Integer) obj).intValue());
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    public int[] l() {
        int size = size();
        if (size == 0) {
            return di.a;
        }
        int[] iArr = new int[size];
        s(0, iArr, 0, size);
        return iArr;
    }

    @Override // java.util.List
    public final /* synthetic */ int lastIndexOf(Object obj) {
        return y(((Integer) obj).intValue());
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public es subList(int i, int i2) {
        throw null;
    }

    public int o(int i) {
        throw null;
    }

    public int p(int i, int i2) {
        throw null;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public eu listIterator(int i) {
        throw null;
    }

    public void r(int i, int i2) {
        throw null;
    }

    public /* bridge */ /* synthetic */ Object remove(int i) {
        return C(i);
    }

    public void s(int i, int[] iArr, int i2, int i3) {
        throw null;
    }

    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        return D(i, (Integer) obj);
    }

    public /* synthetic */ void sort(Comparator comparator) {
        I((comparator == null || (comparator instanceof dt)) ? (dt) comparator : new du(comparator));
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    public void t(int i, int i2) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        eu it2 = iterator();
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
        sb.append("]");
        return sb.toString();
    }

    public boolean u(int i, Cdo cdo) {
        throw null;
    }

    public void v(int i, int[] iArr, int i2) {
        throw null;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public int compareTo(List list) {
        int iCompareTo;
        if (list == this) {
            return 0;
        }
        if (list instanceof es) {
            eu it2 = iterator();
            eu it3 = ((es) list).iterator();
            while (it2.hasNext() && it3.hasNext()) {
                iCompareTo = Integer.compare(it2.nextInt(), it3.nextInt());
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            }
            if (!it3.hasNext()) {
                if (!it2.hasNext()) {
                    return 0;
                }
                return 1;
            }
            return -1;
        }
        eu it4 = iterator();
        ListIterator listIterator = list.listIterator();
        while (it4.hasNext() && listIterator.hasNext()) {
            iCompareTo = ((Comparable) it4.next()).compareTo(listIterator.next());
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        if (!listIterator.hasNext()) {
            if (!it4.hasNext()) {
                return 0;
            }
            return 1;
        }
        return -1;
    }

    public int x(int i) {
        eu it2 = iterator();
        while (it2.hasNext()) {
            if (i == it2.nextInt()) {
                return it2.previousIndex();
            }
        }
        return -1;
    }

    public int y(int i) {
        eu euVarListIterator = listIterator(size());
        while (euVarListIterator.hasPrevious()) {
            if (i == euVarListIterator.a()) {
                return euVarListIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.es
    public final eu z() {
        return iterator();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
