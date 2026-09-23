package com.google.android.libraries.navigation.internal.yz;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class cc extends AbstractMap implements Serializable {
    public static final Object a = new Object();
    transient int[] b;
    transient Object[] c;
    transient Object[] d;
    public transient int e;
    public transient int f;
    private transient Object g;
    private transient Set h;
    private transient Set i;
    private transient Collection j;

    public cc() {
        p(3);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        if (i < 0) {
            throw new InvalidObjectException(com.google.android.libraries.navigation.internal.b.b.b(i, "Invalid size: "));
        }
        p(i);
        for (int i2 = 0; i2 < i; i2++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator itK = k();
        while (itK.hasNext()) {
            Map.Entry entry = (Map.Entry) itK.next();
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    private final int y(int i, int i2, int i3, int i4) {
        int i5 = i2 - 1;
        Object objG = cf.g(i2);
        if (i4 != 0) {
            cf.i(objG, i3 & i5, i4 + 1);
        }
        Object objI = i();
        int[] iArrV = v();
        for (int i6 = 0; i6 <= i; i6++) {
            int iE = cf.e(objI, i6);
            while (iE != 0) {
                int i7 = iE - 1;
                int i8 = iArrV[i7];
                int iA = cf.a(i8, i) | i6;
                int i9 = iA & i5;
                int iE2 = cf.e(objG, i9);
                cf.i(objG, i9, iE);
                iArrV[i7] = cf.b(iA, iE2, i5);
                iE = i8 & i;
            }
        }
        this.g = objG;
        z(i5);
        return i5;
    }

    private final void z(int i) {
        this.e = cf.b(this.e, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    public int a(int i, int i2) {
        return i - 1;
    }

    public int b() {
        com.google.android.libraries.navigation.internal.yx.ar.l(u(), "Arrays already allocated");
        int i = this.e;
        int iF = cf.f(i);
        this.g = cf.g(iF);
        z(iF - 1);
        this.b = new int[i];
        this.c = new Object[i];
        this.d = new Object[i];
        return i;
    }

    public int c() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (u()) {
            return;
        }
        o();
        Map mapN = n();
        if (mapN != null) {
            this.e = com.google.android.libraries.navigation.internal.zy.i.a(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
            mapN.clear();
            this.g = null;
            this.f = 0;
            return;
        }
        Arrays.fill(w(), 0, this.f, (Object) null);
        Arrays.fill(x(), 0, this.f, (Object) null);
        cf.h(i());
        Arrays.fill(v(), 0, this.f, 0);
        this.f = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map mapN = n();
        if (mapN != null) {
            return mapN.containsKey(obj);
        }
        return f(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map mapN = n();
        if (mapN != null) {
            return mapN.containsValue(obj);
        }
        for (int i = 0; i < this.f; i++) {
            if (com.google.android.libraries.navigation.internal.yx.am.a(obj, j(i))) {
                return true;
            }
        }
        return false;
    }

    public int d(int i) {
        int i2 = i + 1;
        if (i2 < this.f) {
            return i2;
        }
        return -1;
    }

    public final int e() {
        return (1 << (this.e & 31)) - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.i;
        if (set != null) {
            return set;
        }
        bx bxVar = new bx(this);
        this.i = bxVar;
        return bxVar;
    }

    public final int f(Object obj) {
        if (u()) {
            return -1;
        }
        int iB = eh.b(obj);
        int iE = e();
        int iE2 = cf.e(i(), iB & iE);
        if (iE2 == 0) {
            return -1;
        }
        int iA = cf.a(iB, iE);
        do {
            int i = iE2 - 1;
            int i2 = v()[i];
            if (cf.a(i2, iE) == iA && com.google.android.libraries.navigation.internal.yx.am.a(obj, g(i))) {
                return i;
            }
            iE2 = i2 & iE;
        } while (iE2 != 0);
        return -1;
    }

    public final Object g(int i) {
        return w()[i];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map mapN = n();
        if (mapN != null) {
            return mapN.get(obj);
        }
        int iF = f(obj);
        if (iF == -1) {
            return null;
        }
        return j(iF);
    }

    public final Object h(Object obj) {
        if (!u()) {
            int iE = e();
            int iD = cf.d(obj, null, iE, i(), v(), w(), null);
            if (iD != -1) {
                Object objJ = j(iD);
                r(iD, iE);
                this.f--;
                o();
                return objJ;
            }
        }
        return a;
    }

    public final Object i() {
        return Objects.requireNonNull(this.g);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    public final Object j(int i) {
        return x()[i];
    }

    final Iterator k() {
        Map mapN = n();
        return mapN != null ? mapN.entrySet().iterator() : new bv(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.h;
        if (set != null) {
            return set;
        }
        bz bzVar = new bz(this);
        this.h = bzVar;
        return bzVar;
    }

    public Map l() {
        Map mapM = m(e() + 1);
        int iC = c();
        while (iC >= 0) {
            mapM.put(g(iC), j(iC));
            iC = d(iC);
        }
        this.g = mapM;
        this.b = null;
        this.c = null;
        this.d = null;
        o();
        return mapM;
    }

    public Map m(int i) {
        return new LinkedHashMap(i, 1.0f);
    }

    final Map n() {
        Object obj = this.g;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    final void o() {
        this.e += 32;
    }

    public void p(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.b(i >= 0, "Expected size must be >= 0");
        this.e = com.google.android.libraries.navigation.internal.zy.i.a(i, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int iY;
        int iMin;
        if (u()) {
            b();
        }
        Map mapN = n();
        if (mapN != null) {
            return mapN.put(obj, obj2);
        }
        int[] iArrV = v();
        Object[] objArrW = w();
        Object[] objArrX = x();
        int i = this.f;
        int i2 = i + 1;
        int iB = eh.b(obj);
        int iE = e();
        int i3 = iB & iE;
        int iE2 = cf.e(i(), i3);
        if (iE2 != 0) {
            int iA = cf.a(iB, iE);
            int i4 = 0;
            while (true) {
                int i5 = iE2 - 1;
                int i6 = iArrV[i5];
                if (cf.a(i6, iE) == iA && com.google.android.libraries.navigation.internal.yx.am.a(obj, objArrW[i5])) {
                    Object obj3 = objArrX[i5];
                    objArrX[i5] = obj2;
                    return obj3;
                }
                int i7 = i6 & iE;
                i4++;
                if (i7 == 0) {
                    if (i4 < 9) {
                        if (i2 <= iE) {
                            iArrV[i5] = cf.b(i6, i2, iE);
                            iY = iE;
                            break;
                        }
                        iY = y(iE, cf.c(iE), iB, i);
                        break;
                    }
                    return l().put(obj, obj2);
                }
                iE2 = i7;
            }
        } else {
            if (i2 <= iE) {
                cf.i(i(), i3, i2);
                iY = iE;
                break;
            }
            iY = y(iE, cf.c(iE), iB, i);
        }
        int length = v().length;
        if (i2 > length && (iMin = Math.min(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            s(iMin);
        }
        q(i, obj, obj2, iB, iY);
        this.f = i2;
        o();
        return null;
    }

    public void q(int i, Object obj, Object obj2, int i2, int i3) {
        v()[i] = cf.b(i2, 0, i3);
        w()[i] = obj;
        t(i, obj2);
    }

    public void r(int i, int i2) {
        Object objI = i();
        int[] iArrV = v();
        Object[] objArrW = w();
        Object[] objArrX = x();
        int size = size();
        int i3 = size - 1;
        if (i >= i3) {
            objArrW[i] = null;
            objArrX[i] = null;
            iArrV[i] = 0;
            return;
        }
        int i4 = i + 1;
        Object obj = objArrW[i3];
        objArrW[i] = obj;
        objArrX[i] = objArrX[i3];
        objArrW[i3] = null;
        objArrX[i3] = null;
        iArrV[i] = iArrV[i3];
        iArrV[i3] = 0;
        int iB = eh.b(obj) & i2;
        int iE = cf.e(objI, iB);
        if (iE == size) {
            cf.i(objI, iB, i4);
            return;
        }
        while (true) {
            int i5 = iE - 1;
            int i6 = iArrV[i5];
            int i7 = i6 & i2;
            if (i7 == size) {
                iArrV[i5] = cf.b(i6, i4, i2);
                return;
            }
            iE = i7;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map mapN = n();
        if (mapN != null) {
            return mapN.remove(obj);
        }
        Object objH = h(obj);
        if (objH == a) {
            return null;
        }
        return objH;
    }

    public void s(int i) {
        this.b = Arrays.copyOf(v(), i);
        this.c = Arrays.copyOf(w(), i);
        this.d = Arrays.copyOf(x(), i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map mapN = n();
        return mapN != null ? mapN.size() : this.f;
    }

    public final void t(int i, Object obj) {
        x()[i] = obj;
    }

    final boolean u() {
        return this.g == null;
    }

    public final int[] v() {
        return (int[]) Objects.requireNonNull(this.b);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.j;
        if (collection != null) {
            return collection;
        }
        cb cbVar = new cb(this);
        this.j = cbVar;
        return cbVar;
    }

    public final Object[] w() {
        return (Object[]) Objects.requireNonNull(this.c);
    }

    public final Object[] x() {
        return (Object[]) Objects.requireNonNull(this.d);
    }

    public cc(int i) {
        p(i);
    }
}
