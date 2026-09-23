package com.google.android.libraries.navigation.internal.yz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ev<E> extends ek<E> implements List<E>, RandomAccess {
    private static final no a = new er(lv.a, 0);
    public static final /* synthetic */ int d = 0;
    private static final long serialVersionUID = -889275714;

    public static eq j(int i) {
        bs.d(i, "expectedSize");
        return new eq(i);
    }

    public static ev k(Object[] objArr) {
        return l(objArr, objArr.length);
    }

    static ev l(Object[] objArr, int i) {
        return i == 0 ? lv.a : new lv(objArr, i);
    }

    public static ev m(Object... objArr) {
        lj.c(objArr);
        return k(objArr);
    }

    public static ev n(Iterable iterable) {
        com.google.android.libraries.navigation.internal.yx.ar.q(iterable);
        if (iterable instanceof Collection) {
            return o((Collection) iterable);
        }
        Iterator it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return lv.a;
        }
        Object next = it2.next();
        if (!it2.hasNext()) {
            return q(next);
        }
        eq eqVar = new eq();
        eqVar.h(next);
        eqVar.k(it2);
        return eqVar.g();
    }

    public static ev o(Collection collection) {
        if (!(collection instanceof ek)) {
            return m(collection.toArray());
        }
        ev evVarD = ((ek) collection).d();
        return evVarD.f() ? k(evVarD.toArray()) : evVarD;
    }

    public static ev p(Object[] objArr) {
        return objArr.length == 0 ? lv.a : m((Object[]) objArr.clone());
    }

    public static ev q(Object obj) {
        return m(obj);
    }

    public static ev r(Object obj, Object obj2) {
        return m(obj, obj2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static ev s(Object obj, Object obj2, Object obj3) {
        return m(obj, obj2, obj3);
    }

    public static ev t(Object obj, Object obj2, Object obj3, Object obj4) {
        return m(obj, obj2, obj3, obj4);
    }

    public static ev u(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return m(obj, obj2, obj3, obj4, obj5);
    }

    @SafeVarargs
    public static ev v(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object... objArr) {
        com.google.android.libraries.navigation.internal.yx.ar.b(true, "the total number of elements must fit in an int");
        int length = objArr.length;
        Object[] objArr2 = new Object[length + 12];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        objArr2[6] = obj7;
        objArr2[7] = obj8;
        objArr2[8] = obj9;
        objArr2[9] = obj10;
        objArr2[10] = obj11;
        objArr2[11] = obj12;
        System.arraycopy(objArr, 0, objArr2, 12, length);
        return m(objArr2);
    }

    public static ev w(Comparator comparator, Iterable iterable) {
        Object[] objArrI = gs.i(iterable);
        lj.c(objArrI);
        Arrays.sort(objArrI, comparator);
        return k(objArrI);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public int a(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    @Deprecated
    public final ev d() {
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    /* JADX INFO: renamed from: e */
    public final nn listIterator() {
        return iterator();
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        return hx.i(this, obj);
    }

    public ev h() {
        return size() <= 1 ? this : new es(this);
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i = 0; i < size; i++) {
            iHashCode = (iHashCode * 31) + get(i).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public ev subList(int i, int i2) {
        com.google.android.libraries.navigation.internal.yx.ar.j(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        return i3 == 0 ? lv.a : new eu(this, i, i3);
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public Object writeReplace() {
        return new et(toArray());
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final no listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final no listIterator(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.u(i, size());
        return isEmpty() ? a : new er(this, i);
    }
}
