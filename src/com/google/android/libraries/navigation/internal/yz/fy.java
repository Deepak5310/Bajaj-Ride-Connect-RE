package com.google.android.libraries.navigation.internal.yz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class fy<E> extends ek<E> implements Set<E> {
    private static final long serialVersionUID = 912559;
    private transient ev a;

    static int j(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            com.google.android.libraries.navigation.internal.yx.ar.b(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static fw l(int i) {
        bs.d(i, "expectedSize");
        return new fw(i, true);
    }

    public static fy n(Iterable iterable) {
        if (iterable instanceof Collection) {
            return o((Collection) iterable);
        }
        Iterator it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return mb.a;
        }
        Object next = it2.next();
        if (!it2.hasNext()) {
            return new mq(next);
        }
        fw fwVar = new fw();
        fwVar.c(next);
        fwVar.l(it2);
        return fwVar.i();
    }

    public static fy o(Collection collection) {
        if ((collection instanceof fy) && !(collection instanceof SortedSet)) {
            fy fyVar = (fy) collection;
            if (!fyVar.f()) {
                return fyVar;
            }
        }
        Object[] array = collection.toArray();
        return m(array.length, array);
    }

    public static fy p(Object[] objArr) {
        int length = objArr.length;
        if (length != 0) {
            return length != 1 ? m(length, (Object[]) objArr.clone()) : new mq(objArr[0]);
        }
        return mb.a;
    }

    public static fy q(Object obj, Object obj2) {
        return m(2, obj, obj2);
    }

    public static fy r(Object obj, Object obj2, Object obj3) {
        return m(3, obj, obj2, obj3);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static fy s(Object obj, Object obj2, Object obj3, Object obj4) {
        return m(4, obj, obj2, obj3, obj4);
    }

    public static fy t(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return m(5, obj, obj2, obj3, obj4, obj5);
    }

    @SafeVarargs
    public static fy u(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        com.google.android.libraries.navigation.internal.yx.ar.b(true, "the total number of elements must fit in an int");
        int length = objArr.length;
        int i = length + 6;
        Object[] objArr2 = new Object[i];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, length);
        return m(i, objArr2);
    }

    public static boolean v(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    public static void w() {
        mb mbVar = mb.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public ev d() {
        ev evVar = this.a;
        if (evVar != null) {
            return evVar;
        }
        ev evVarK = k();
        this.a = evVarK;
        return evVarK;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: e */
    public abstract nn listIterator();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof fy) && i() && ((fy) obj).i() && hashCode() != obj.hashCode()) {
            return false;
        }
        return mp.j(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return mp.a(this);
    }

    public boolean i() {
        return false;
    }

    public ev k() {
        return ev.k(toArray());
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public Object writeReplace() {
        return new fx(toArray());
    }

    public static fy m(int i, Object... objArr) {
        if (i == 0) {
            return mb.a;
        }
        if (i == 1) {
            return new mq(Objects.requireNonNull(objArr[0]));
        }
        int iJ = j(i);
        Object[] objArr2 = new Object[iJ];
        int i2 = iJ - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj = objArr[i5];
            lj.b(obj, i5);
            int iHashCode = obj.hashCode();
            int iA = eh.a(iHashCode);
            while (true) {
                int i6 = iA & i2;
                Object obj2 = objArr2[i6];
                if (obj2 == null) {
                    objArr[i4] = obj;
                    objArr2[i6] = obj;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (obj2.equals(obj)) {
                    break;
                }
                iA++;
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            return new mq(Objects.requireNonNull(objArr[0]));
        }
        if (j(i4) < iJ / 2) {
            return m(i4, objArr);
        }
        if (v(i4, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new mb(objArr, i3, objArr2, i2, i4);
    }
}
