package com.google.android.libraries.navigation.internal.yz;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ce extends AbstractSet implements Serializable {
    transient Object[] a;
    public transient int b;
    private transient Object c;
    private transient int[] d;
    private transient int e;

    ce() {
        f(3);
    }

    private final int h() {
        return (1 << (this.b & 31)) - 1;
    }

    private final int i(int i, int i2, int i3, int i4) {
        int i5 = i2 - 1;
        Object objG = cf.g(i2);
        if (i4 != 0) {
            cf.i(objG, i3 & i5, i4 + 1);
        }
        Object objJ = j();
        int[] iArrL = l();
        for (int i6 = 0; i6 <= i; i6++) {
            int iE = cf.e(objJ, i6);
            while (iE != 0) {
                int i7 = iE - 1;
                int i8 = iArrL[i7];
                int iA = cf.a(i8, i) | i6;
                int i9 = iA & i5;
                int iE2 = cf.e(objG, i9);
                cf.i(objG, i9, iE);
                iArrL[i7] = cf.b(iA, iE2, i5);
                iE = i8 & i;
            }
        }
        this.c = objG;
        k(i5);
        return i5;
    }

    private final Object j() {
        return Objects.requireNonNull(this.c);
    }

    private final void k(int i) {
        this.b = cf.b(this.b, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    private final int[] l() {
        return (int[]) Objects.requireNonNull(this.d);
    }

    private final Object[] m() {
        return (Object[]) Objects.requireNonNull(this.a);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        if (i < 0) {
            throw new InvalidObjectException(com.google.android.libraries.navigation.internal.b.b.b(i, "Invalid size: "));
        }
        f(i);
        for (int i2 = 0; i2 < i; i2++) {
            add(objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            objectOutputStream.writeObject(it2.next());
        }
    }

    final int a() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int iMin;
        if (g()) {
            com.google.android.libraries.navigation.internal.yx.ar.l(g(), "Arrays already allocated");
            int i = this.b;
            int iF = cf.f(i);
            this.c = cf.g(iF);
            k(iF - 1);
            this.d = new int[i];
            this.a = new Object[i];
        }
        Set setD = d();
        if (setD != null) {
            return setD.add(obj);
        }
        int[] iArrL = l();
        Object[] objArrM = m();
        int i2 = this.e;
        int i3 = i2 + 1;
        int iB = eh.b(obj);
        int iH = h();
        int i4 = iB & iH;
        int iE = cf.e(j(), i4);
        if (iE != 0) {
            int iA = cf.a(iB, iH);
            int i5 = 0;
            while (true) {
                int i6 = iE - 1;
                int i7 = iArrL[i6];
                if (cf.a(i7, iH) == iA && com.google.android.libraries.navigation.internal.yx.am.a(obj, objArrM[i6])) {
                    return false;
                }
                int i8 = i7 & iH;
                i5++;
                if (i8 == 0) {
                    if (i5 < 9) {
                        if (i3 <= iH) {
                            iArrL[i6] = cf.b(i7, i3, iH);
                            break;
                        }
                        iH = i(iH, cf.c(iH), iB, i2);
                        break;
                    }
                    LinkedHashSet linkedHashSet = new LinkedHashSet(h() + 1, 1.0f);
                    int iA2 = a();
                    while (iA2 >= 0) {
                        linkedHashSet.add(c(iA2));
                        iA2 = b(iA2);
                    }
                    this.c = linkedHashSet;
                    this.d = null;
                    this.a = null;
                    e();
                    return linkedHashSet.add(obj);
                }
                iE = i8;
            }
        } else if (i3 > iH) {
            iH = i(iH, cf.c(iH), iB, i2);
        } else {
            cf.i(j(), i4, i3);
        }
        int length = l().length;
        if (i3 > length && (iMin = Math.min(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            this.d = Arrays.copyOf(l(), iMin);
            this.a = Arrays.copyOf(m(), iMin);
        }
        l()[i2] = cf.b(iB, 0, iH);
        m()[i2] = obj;
        this.e = i3;
        e();
        return true;
    }

    final int b(int i) {
        int i2 = i + 1;
        if (i2 < this.e) {
            return i2;
        }
        return -1;
    }

    public final Object c(int i) {
        return m()[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        if (g()) {
            return;
        }
        e();
        Set setD = d();
        if (setD != null) {
            this.b = com.google.android.libraries.navigation.internal.zy.i.a(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
            setD.clear();
            this.c = null;
            this.e = 0;
            return;
        }
        Arrays.fill(m(), 0, this.e, (Object) null);
        cf.h(j());
        Arrays.fill(l(), 0, this.e, 0);
        this.e = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (g()) {
            return false;
        }
        Set setD = d();
        if (setD != null) {
            return setD.contains(obj);
        }
        int iB = eh.b(obj);
        int iH = h();
        int iE = cf.e(j(), iB & iH);
        if (iE == 0) {
            return false;
        }
        int iA = cf.a(iB, iH);
        do {
            int i = iE - 1;
            int i2 = l()[i];
            if (cf.a(i2, iH) == iA && com.google.android.libraries.navigation.internal.yx.am.a(obj, c(i))) {
                return true;
            }
            iE = i2 & iH;
        } while (iE != 0);
        return false;
    }

    final Set d() {
        Object obj = this.c;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    final void e() {
        this.b += 32;
    }

    final void f(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.b(true, "Expected size must be >= 0");
        this.b = com.google.android.libraries.navigation.internal.zy.i.a(i, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }

    final boolean g() {
        return this.c == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        Set setD = d();
        return setD != null ? setD.iterator() : new cd(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int i;
        int i2;
        if (!g()) {
            Set setD = d();
            if (setD != null) {
                return setD.remove(obj);
            }
            int iH = h();
            int iD = cf.d(obj, null, iH, j(), l(), m(), null);
            if (iD != -1) {
                Object objJ = j();
                int[] iArrL = l();
                Object[] objArrM = m();
                int size = size();
                int i3 = size - 1;
                if (iD < i3) {
                    int i4 = iD + 1;
                    Object obj2 = objArrM[i3];
                    objArrM[iD] = obj2;
                    objArrM[i3] = null;
                    iArrL[iD] = iArrL[i3];
                    iArrL[i3] = 0;
                    int iB = eh.b(obj2) & iH;
                    int iE = cf.e(objJ, iB);
                    if (iE == size) {
                        cf.i(objJ, iB, i4);
                    } else {
                        while (true) {
                            i = iE - 1;
                            i2 = iArrL[i];
                            int i5 = i2 & iH;
                            if (i5 == size) {
                                break;
                            }
                            iE = i5;
                        }
                        iArrL[i] = cf.b(i2, i4, iH);
                    }
                } else {
                    objArrM[iD] = null;
                    iArrL[iD] = 0;
                }
                this.e--;
                e();
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        Set setD = d();
        return setD != null ? setD.size() : this.e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        if (g()) {
            return new Object[0];
        }
        Set setD = d();
        return setD != null ? setD.toArray() : Arrays.copyOf(m(), this.e);
    }

    public ce(int i) {
        f(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        if (g()) {
            if (objArr.length > 0) {
                objArr[0] = null;
            }
            return objArr;
        }
        Set setD = d();
        if (setD != null) {
            return setD.toArray(objArr);
        }
        Object[] objArrM = m();
        int i = this.e;
        com.google.android.libraries.navigation.internal.yx.ar.j(0, i, objArrM.length);
        int length = objArr.length;
        if (length < i) {
            objArr = lp.a(objArr, i);
        } else if (length > i) {
            objArr[i] = null;
        }
        System.arraycopy(objArrM, 0, objArr, 0, i);
        return objArr;
    }
}
