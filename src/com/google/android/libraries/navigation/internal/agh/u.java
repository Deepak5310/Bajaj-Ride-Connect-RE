package com.google.android.libraries.navigation.internal.agh;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u extends n implements gy {
    protected u() {
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gy
    public final /* synthetic */ Long A(int i) {
        return Long.valueOf(m(i));
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gy
    public final /* synthetic */ Long B(int i) {
        return Long.valueOf(n(i));
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gy
    public final /* synthetic */ Long C(int i, Long l) {
        return Long.valueOf(o(i, l.longValue()));
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gy
    public final /* synthetic */ void D(int i, Long l) {
        q(i, l.longValue());
    }

    protected final void E(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.j(i, "Index (", ") is negative"));
        }
        if (i <= size()) {
            return;
        }
        throw new IndexOutOfBoundsException("Index (" + i + ") is greater than list size (" + size() + ")");
    }

    protected final void F(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.j(i, "Index (", ") is negative"));
        }
        if (i < size()) {
            return;
        }
        throw new IndexOutOfBoundsException("Index (" + i + ") is greater than or equal to list size (" + size() + ")");
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gy
    public final /* synthetic */ void G(long[] jArr) {
        I(jArr);
    }

    public /* synthetic */ void H(gk gkVar) {
        if (gkVar == null) {
            J();
            return;
        }
        long[] jArrK = k();
        fz.f(jArrK, jArrK.length, gkVar);
        G(jArrK);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gy
    public final /* synthetic */ void I(long[] jArr) {
        u(0, jArr, jArr.length);
    }

    public /* synthetic */ void J() {
        long[] jArrK = k();
        fz.g(jArrK, jArrK.length);
        G(jArrK);
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        D(i, (Long) obj);
    }

    public boolean addAll(int i, Collection collection) {
        if (collection instanceof gf) {
            return t(i, (gf) collection);
        }
        E(i);
        Iterator it2 = collection.iterator();
        boolean zHasNext = it2.hasNext();
        while (it2.hasNext()) {
            q(i, ((Long) it2.next()).longValue());
            i++;
        }
        return zHasNext;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf, com.google.android.libraries.navigation.internal.agh.he
    /* JADX INFO: renamed from: b */
    public /* synthetic */ hl spliterator() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf
    public boolean c(long j) {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        s(0, size());
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf
    public final boolean d(gf gfVar) {
        return t(size(), gfVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf
    public final boolean e(long j) {
        return w(j) >= 0;
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
        if (list instanceof gy) {
            ha haVarM = m();
            ha haVarM2 = ((gy) list).m();
            while (true) {
                int i = size - 1;
                if (size == 0) {
                    return true;
                }
                if (haVarM.nextLong() != haVarM2.nextLong()) {
                    return false;
                }
                size = i;
            }
        } else {
            ha haVarM3 = m();
            ListIterator listIterator = list.listIterator();
            while (true) {
                int i2 = size - 1;
                if (size == 0) {
                    return true;
                }
                if (!Objects.equals(haVarM3.next(), listIterator.next())) {
                    return false;
                }
                size = i2;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf
    public boolean g(long j) {
        throw null;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return A(i);
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        ha haVarM = m();
        int iC = 1;
        for (int size = size(); size != 0; size--) {
            iC = (iC * 31) + com.google.android.libraries.navigation.internal.agc.e.c(haVarM.nextLong());
        }
        return iC;
    }

    @Override // java.util.List
    public final /* synthetic */ int indexOf(Object obj) {
        return w(((Long) obj).longValue());
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf
    public final long[] k() {
        int size = size();
        if (size == 0) {
            return fz.a;
        }
        long[] jArr = new long[size];
        r(0, jArr, 0, size);
        return jArr;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public gy subList(int i, int i2) {
        throw null;
    }

    @Override // java.util.List
    public final /* synthetic */ int lastIndexOf(Object obj) {
        return x(((Long) obj).longValue());
    }

    public long n(int i) {
        throw null;
    }

    public long o(int i, long j) {
        throw null;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public ha listIterator(int i) {
        throw null;
    }

    public void q(int i, long j) {
        throw null;
    }

    public void r(int i, long[] jArr, int i2, int i3) {
        throw null;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        return B(i);
    }

    public void s(int i, int i2) {
        throw null;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        return C(i, (Long) obj);
    }

    @Override // java.util.List
    public final /* synthetic */ void sort(Comparator comparator) {
        H((comparator == null || (comparator instanceof gk)) ? (gk) comparator : new gl(comparator));
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    public boolean t(int i, gf gfVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        ha haVarM = m();
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(String.valueOf(haVarM.nextLong()));
            size--;
            z = false;
        }
        sb.append("]");
        return sb.toString();
    }

    public void u(int i, long[] jArr, int i2) {
        throw null;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public int compareTo(List list) {
        int iCompareTo;
        if (list == this) {
            return 0;
        }
        if (list instanceof gy) {
            ha haVarM = m();
            ha haVarM2 = ((gy) list).m();
            while (haVarM.hasNext() && haVarM2.hasNext()) {
                iCompareTo = Long.compare(haVarM.nextLong(), haVarM2.nextLong());
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            }
            if (!haVarM2.hasNext()) {
                if (!haVarM.hasNext()) {
                    return 0;
                }
                return 1;
            }
            return -1;
        }
        ha haVarM3 = m();
        ListIterator listIterator = list.listIterator();
        while (haVarM3.hasNext() && listIterator.hasNext()) {
            iCompareTo = ((Comparable) haVarM3.next()).compareTo(listIterator.next());
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        if (!listIterator.hasNext()) {
            if (!haVarM3.hasNext()) {
                return 0;
            }
            return 1;
        }
        return -1;
    }

    public int w(long j) {
        ha haVarM = m();
        while (haVarM.hasNext()) {
            if (j == haVarM.nextLong()) {
                return haVarM.previousIndex();
            }
        }
        return -1;
    }

    public int x(long j) {
        ha haVarListIterator = listIterator(size());
        while (haVarListIterator.hasPrevious()) {
            if (j == haVarListIterator.a()) {
                return haVarListIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gy
    public final ha y() {
        return m();
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final ha listIterator() {
        return listIterator(0);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
