package com.google.android.libraries.navigation.internal.agd;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class h extends a implements ao {
    protected h() {
    }

    @Override // com.google.android.libraries.navigation.internal.agd.ao
    public final /* synthetic */ Byte A(int i) {
        return Byte.valueOf(m(i));
    }

    @Override // com.google.android.libraries.navigation.internal.agd.ao
    public final /* synthetic */ Byte B(int i, Byte b) {
        return Byte.valueOf(n(i, b.byteValue()));
    }

    @Override // com.google.android.libraries.navigation.internal.agd.ao
    public final /* synthetic */ void C(int i, Byte b) {
        p(i, b.byteValue());
    }

    protected final void D(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.j(i, "Index (", ") is negative"));
        }
        if (i <= size()) {
            return;
        }
        throw new IndexOutOfBoundsException("Index (" + i + ") is greater than list size (" + size() + ")");
    }

    protected final void E(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.j(i, "Index (", ") is negative"));
        }
        if (i < size()) {
            return;
        }
        throw new IndexOutOfBoundsException("Index (" + i + ") is greater than or equal to list size (" + size() + ")");
    }

    @Override // com.google.android.libraries.navigation.internal.agd.ao
    public final /* synthetic */ void F(byte[] bArr) {
        H(bArr);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.ao
    public /* synthetic */ void G(z zVar) {
        if (zVar == null) {
            I();
            return;
        }
        byte[] bArrJ = j();
        q.c(bArrJ, bArrJ.length, zVar);
        F(bArrJ);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.ao
    public final /* synthetic */ void H(byte[] bArr) {
        t(0, bArr, bArr.length);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.ao
    public /* synthetic */ void I() {
        byte[] bArrJ = j();
        q.d(bArrJ, bArrJ.length);
        F(bArrJ);
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        C(i, (Byte) obj);
    }

    public boolean addAll(int i, Collection collection) {
        if (collection instanceof w) {
            return s(i, (w) collection);
        }
        D(i);
        Iterator it2 = collection.iterator();
        boolean zHasNext = it2.hasNext();
        while (it2.hasNext()) {
            p(i, ((Byte) it2.next()).byteValue());
            i++;
        }
        return zHasNext;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.a, com.google.android.libraries.navigation.internal.agd.w
    public /* synthetic */ be b() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.a, com.google.android.libraries.navigation.internal.agd.w
    public boolean c(byte b) {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        r(0, size());
    }

    @Override // com.google.android.libraries.navigation.internal.agd.a
    public final boolean d(w wVar) {
        return s(size(), wVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.a, com.google.android.libraries.navigation.internal.agd.w
    public final boolean e(byte b) {
        return v(b) >= 0;
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
        if (list instanceof ao) {
            aq it2 = iterator();
            aq it3 = ((ao) list).iterator();
            while (true) {
                int i = size - 1;
                if (size == 0) {
                    return true;
                }
                if (it2.c() != it3.c()) {
                    return false;
                }
                size = i;
            }
        } else {
            aq it4 = iterator();
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

    @Override // com.google.android.libraries.navigation.internal.agd.a, com.google.android.libraries.navigation.internal.agd.w
    public boolean g(byte b) {
        throw null;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return z(i);
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        aq it2 = iterator();
        int size = size();
        int iC = 1;
        while (size != 0) {
            size--;
            iC = (iC * 31) + it2.c();
        }
        return iC;
    }

    @Override // java.util.List
    public final /* synthetic */ int indexOf(Object obj) {
        return v(((Byte) obj).byteValue());
    }

    @Override // com.google.android.libraries.navigation.internal.agd.a, com.google.android.libraries.navigation.internal.agd.w
    public final byte[] j() {
        int size = size();
        if (size == 0) {
            return q.a;
        }
        byte[] bArr = new byte[size];
        q(0, bArr, 0, size);
        return bArr;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public ao subList(int i, int i2) {
        throw null;
    }

    @Override // java.util.List
    public final /* synthetic */ int lastIndexOf(Object obj) {
        return w(((Byte) obj).byteValue());
    }

    public byte m(int i) {
        throw null;
    }

    public byte n(int i, byte b) {
        throw null;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public aq listIterator(int i) {
        throw null;
    }

    public void p(int i, byte b) {
        throw null;
    }

    public void q(int i, byte[] bArr, int i2, int i3) {
        throw null;
    }

    public void r(int i, int i2) {
        throw null;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        return A(i);
    }

    public boolean s(int i, w wVar) {
        throw null;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        return B(i, (Byte) obj);
    }

    @Override // java.util.List
    public final /* synthetic */ void sort(Comparator comparator) {
        G((comparator == null || (comparator instanceof z)) ? (z) comparator : new aa(comparator));
    }

    @Override // com.google.android.libraries.navigation.internal.agd.a, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return b();
    }

    public void t(int i, byte[] bArr, int i2) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.a, java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        aq it2 = iterator();
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
        sb.append("]");
        return sb.toString();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public int compareTo(List list) {
        int iCompareTo;
        if (list == this) {
            return 0;
        }
        if (list instanceof ao) {
            aq it2 = iterator();
            aq it3 = ((ao) list).iterator();
            while (it2.hasNext() && it3.hasNext()) {
                iCompareTo = Byte.compare(it2.c(), it3.c());
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
        aq it4 = iterator();
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

    @Override // com.google.android.libraries.navigation.internal.agd.ao
    public int v(byte b) {
        aq it2 = iterator();
        while (it2.hasNext()) {
            if (b == it2.c()) {
                return it2.previousIndex();
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.ao
    public int w(byte b) {
        aq aqVarListIterator = listIterator(size());
        while (aqVarListIterator.hasPrevious()) {
            if (b == aqVarListIterator.d()) {
                return aqVarListIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.ao
    public final aq x() {
        return iterator();
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final aq listIterator() {
        return listIterator(0);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.ao
    public final /* synthetic */ Byte z(int i) {
        return Byte.valueOf(l(i));
    }

    @Override // com.google.android.libraries.navigation.internal.agd.a, java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
