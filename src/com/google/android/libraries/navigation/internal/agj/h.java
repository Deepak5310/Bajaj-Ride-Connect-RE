package com.google.android.libraries.navigation.internal.agj;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class h extends a implements am {
    protected h() {
    }

    @Override // com.google.android.libraries.navigation.internal.agj.am
    public final /* synthetic */ Short A(int i, Short sh) {
        return Short.valueOf(n(i, sh.shortValue()));
    }

    @Override // com.google.android.libraries.navigation.internal.agj.am
    public final /* synthetic */ void B(int i, Short sh) {
        o(i, sh.shortValue());
    }

    protected final void C(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.j(i, "Index (", ") is negative"));
        }
        if (i <= size()) {
            return;
        }
        throw new IndexOutOfBoundsException("Index (" + i + ") is greater than list size (" + size() + ")");
    }

    protected final void D(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.j(i, "Index (", ") is negative"));
        }
        if (i < size()) {
            return;
        }
        throw new IndexOutOfBoundsException("Index (" + i + ") is greater than or equal to list size (" + size() + ")");
    }

    @Override // com.google.android.libraries.navigation.internal.agj.am
    public final /* synthetic */ void E(short[] sArr) {
        G(sArr);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.am
    public /* synthetic */ void F(x xVar) {
        if (xVar == null) {
            H();
            return;
        }
        short[] sArrH = h();
        p.f(sArrH, sArrH.length, xVar);
        E(sArrH);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.am
    public final /* synthetic */ void G(short[] sArr) {
        s(0, sArr, sArr.length);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.am
    public /* synthetic */ void H() {
        short[] sArrH = h();
        p.g(sArrH, sArrH.length);
        E(sArrH);
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        B(i, (Short) obj);
    }

    public boolean addAll(int i, Collection collection) {
        if (collection instanceof u) {
            return r(i, (u) collection);
        }
        C(i);
        Iterator it2 = collection.iterator();
        boolean zHasNext = it2.hasNext();
        while (it2.hasNext()) {
            o(i, ((Short) it2.next()).shortValue());
            i++;
        }
        return zHasNext;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.a, com.google.android.libraries.navigation.internal.agj.u
    public /* synthetic */ ay b() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.a
    public final boolean c(u uVar) {
        return r(size(), uVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        q(0, size());
    }

    @Override // com.google.android.libraries.navigation.internal.agj.a, com.google.android.libraries.navigation.internal.agj.u
    public final boolean d(short s) {
        return u(s) >= 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.a, com.google.android.libraries.navigation.internal.agj.u
    public boolean e(short s) {
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
        if (list instanceof am) {
            ao it2 = iterator();
            ao it3 = ((am) list).iterator();
            while (true) {
                int i = size - 1;
                if (size == 0) {
                    return true;
                }
                if (it2.d() != it3.d()) {
                    return false;
                }
                size = i;
            }
        } else {
            ao it4 = iterator();
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

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return y(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.a, com.google.android.libraries.navigation.internal.agj.u
    public final short[] h() {
        int size = size();
        if (size == 0) {
            return p.a;
        }
        short[] sArr = new short[size];
        p(0, sArr, 0, size);
        return sArr;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        ao it2 = iterator();
        int size = size();
        int iD = 1;
        while (size != 0) {
            size--;
            iD = (iD * 31) + it2.d();
        }
        return iD;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.a, com.google.android.libraries.navigation.internal.agj.u
    public void i(short s) {
        throw null;
    }

    @Override // java.util.List
    public final /* synthetic */ int indexOf(Object obj) {
        return u(((Short) obj).shortValue());
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public am subList(int i, int i2) {
        throw null;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public ao listIterator(int i) {
        throw null;
    }

    @Override // java.util.List
    public final /* synthetic */ int lastIndexOf(Object obj) {
        return v(((Short) obj).shortValue());
    }

    public short m(int i) {
        throw null;
    }

    public short n(int i, short s) {
        throw null;
    }

    public void o(int i, short s) {
        throw null;
    }

    public void p(int i, short[] sArr, int i2, int i3) {
        throw null;
    }

    public void q(int i, int i2) {
        throw null;
    }

    public boolean r(int i, u uVar) {
        throw null;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        return z(i);
    }

    public void s(int i, short[] sArr, int i2) {
        throw null;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        return A(i, (Short) obj);
    }

    @Override // java.util.List
    public final /* synthetic */ void sort(Comparator comparator) {
        F((comparator == null || (comparator instanceof x)) ? (x) comparator : new y(comparator));
    }

    @Override // com.google.android.libraries.navigation.internal.agj.a, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return b();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public int compareTo(List list) {
        int iCompareTo;
        if (list == this) {
            return 0;
        }
        if (list instanceof am) {
            ao it2 = iterator();
            ao it3 = ((am) list).iterator();
            while (it2.hasNext() && it3.hasNext()) {
                iCompareTo = Short.compare(it2.d(), it3.d());
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
        ao it4 = iterator();
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

    @Override // com.google.android.libraries.navigation.internal.agj.a, java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        ao it2 = iterator();
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
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.android.libraries.navigation.internal.agj.am
    public int u(short s) {
        ao it2 = iterator();
        while (it2.hasNext()) {
            if (s == it2.d()) {
                return it2.previousIndex();
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.am
    public int v(short s) {
        ao aoVarListIterator = listIterator(size());
        while (aoVarListIterator.hasPrevious()) {
            if (s == aoVarListIterator.e()) {
                return aoVarListIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.am
    public final ao w() {
        return iterator();
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final ao listIterator() {
        return listIterator(0);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.am
    public final /* synthetic */ Short y(int i) {
        return Short.valueOf(l(i));
    }

    @Override // com.google.android.libraries.navigation.internal.agj.am
    public final /* synthetic */ Short z(int i) {
        return Short.valueOf(m(i));
    }

    @Override // com.google.android.libraries.navigation.internal.agj.a, java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
