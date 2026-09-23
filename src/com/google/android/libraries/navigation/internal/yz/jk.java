package com.google.android.libraries.navigation.internal.yz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class jk extends AbstractMap implements ConcurrentMap, Serializable {
    static final jh a = new hz();
    private static final long serialVersionUID = 5;
    final transient int b;
    final transient int c;
    final transient il[] d;
    final int e;
    final com.google.android.libraries.navigation.internal.yx.y f;
    final transient ii g;
    transient Set h;
    transient Collection i;
    transient Set j;

    public jk(hy hyVar, ii iiVar) {
        this.e = Math.min(hyVar.a(), 65536);
        this.f = (com.google.android.libraries.navigation.internal.yx.y) com.google.android.libraries.navigation.internal.yx.al.c(hyVar.f, hyVar.d().a());
        this.g = iiVar;
        int iMin = Math.min(hyVar.b(), 1073741824);
        int i = 1;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i3 < this.e) {
            i4++;
            i3 += i3;
        }
        this.c = 32 - i4;
        this.b = i3 - 1;
        this.d = new il[i3];
        int i5 = iMin / i3;
        while (i < (i3 * i5 < iMin ? i5 + 1 : i5)) {
            i += i;
        }
        while (true) {
            il[] ilVarArr = this.d;
            if (i2 >= ilVarArr.length) {
                return;
            }
            ilVarArr[i2] = this.g.c(this, i);
            i2++;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializationProxy");
    }

    final int a(Object obj) {
        int iC = this.f.c(obj);
        int i = iC + ((iC << 15) ^ (-12931));
        int i2 = i ^ (i >>> 10);
        int i3 = i2 + (i2 << 3);
        int i4 = i3 ^ (i3 >>> 6);
        int i5 = i4 + (i4 << 2) + (i4 << 14);
        return i5 ^ (i5 >>> 16);
    }

    final com.google.android.libraries.navigation.internal.yx.y b() {
        return this.g.e().a();
    }

    final il c(int i) {
        return this.d[(i >>> this.c) & this.b];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        for (il ilVar : this.d) {
            if (ilVar.b != 0) {
                ilVar.lock();
                try {
                    AtomicReferenceArray atomicReferenceArray = ilVar.e;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        atomicReferenceArray.set(i, null);
                    }
                    ilVar.h();
                    ilVar.f.set(0);
                    ilVar.c++;
                    ilVar.b = 0;
                    ilVar.unlock();
                } catch (Throwable th) {
                    ilVar.unlock();
                    throw th;
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        ih ihVarB;
        boolean z = false;
        if (obj == null) {
            return false;
        }
        int iA = a(obj);
        il ilVarC = c(iA);
        try {
            if (ilVarC.b != 0 && (ihVarB = ilVarC.b(obj, iA)) != null && ihVarB.d() != null) {
                z = true;
            }
            return z;
        } finally {
            ilVarC.j();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.util.concurrent.atomic.AtomicReferenceArray] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Object objD;
        boolean z = false;
        if (obj == null) {
            return false;
        }
        il[] ilVarArr = this.d;
        long j = -1;
        int i = 0;
        while (i < 3) {
            int length = ilVarArr.length;
            long j2 = 0;
            for (?? r10 = z; r10 < length; r10++) {
                il ilVar = ilVarArr[r10];
                int i2 = ilVar.b;
                ?? r12 = ilVar.e;
                for (?? r13 = z; r13 < r12.length(); r13++) {
                    for (ih ihVarB = (ih) r12.get(r13); ihVarB != null; ihVarB = ihVarB.b()) {
                        if (ihVarB.c() == null || (objD = ihVarB.d()) == null) {
                            ilVar.m();
                            objD = null;
                        }
                        if (objD != null && b().d(obj, objD)) {
                            return true;
                        }
                    }
                }
                j2 += (long) ilVar.c;
                z = false;
            }
            if (j2 == j) {
                return false;
            }
            i++;
            j = j2;
            z = false;
        }
        return z;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.j;
        if (set != null) {
            return set;
        }
        Cif cif = new Cif(this);
        this.j = cif;
        return cif;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Object objD = null;
        if (obj == null) {
            return null;
        }
        int iA = a(obj);
        il ilVarC = c(iA);
        try {
            ih ihVarB = ilVarC.b(obj, iA);
            if (ihVarB != null && (objD = ihVarB.d()) == null) {
                ilVarC.m();
            }
            return objD;
        } finally {
            ilVarC.j();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        int i = 0;
        long j = 0;
        while (true) {
            il[] ilVarArr = this.d;
            if (i >= ilVarArr.length) {
                if (j == 0) {
                    return true;
                }
                for (int i2 = 0; i2 < ilVarArr.length; i2++) {
                    if (ilVarArr[i2].b != 0) {
                        return false;
                    }
                    j -= (long) ilVarArr[i2].c;
                }
                return j == 0;
            }
            if (ilVarArr[i].b != 0) {
                return false;
            }
            j += (long) ilVarArr[i].c;
            i++;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.h;
        if (set != null) {
            return set;
        }
        ik ikVar = new ik(this);
        this.h = ikVar;
        return ikVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        com.google.android.libraries.navigation.internal.yx.ar.q(obj2);
        int iA = a(obj);
        return c(iA).e(obj, iA, obj2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object putIfAbsent(Object obj, Object obj2) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        com.google.android.libraries.navigation.internal.yx.ar.q(obj2);
        int iA = a(obj);
        return c(iA).e(obj, iA, obj2, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Object obj2 = null;
        if (obj == null) {
            return null;
        }
        int iA = a(obj);
        il ilVarC = c(iA);
        ilVarC.lock();
        try {
            ilVarC.k();
            int i = ilVarC.b;
            AtomicReferenceArray atomicReferenceArray = ilVarC.e;
            int length = (atomicReferenceArray.length() - 1) & iA;
            ih ihVar = (ih) atomicReferenceArray.get(length);
            for (ih ihVarB = ihVar; ihVarB != null; ihVarB = ihVarB.b()) {
                Object objC = ihVarB.c();
                if (ihVarB.a() == iA && objC != null && ilVarC.a.f.d(obj, objC)) {
                    Object objD = ihVarB.d();
                    if (objD != null || il.n(ihVarB)) {
                        ilVarC.c++;
                        ih ihVarC = ilVarC.c(ihVar, ihVarB);
                        int i2 = ilVarC.b - 1;
                        atomicReferenceArray.set(length, ihVarC);
                        ilVarC.b = i2;
                        obj2 = objD;
                        break;
                    }
                    break;
                }
            }
            return obj2;
        } finally {
            ilVarC.unlock();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object replace(Object obj, Object obj2) {
        Object obj3;
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        com.google.android.libraries.navigation.internal.yx.ar.q(obj2);
        int iA = a(obj);
        il ilVarC = c(iA);
        ilVarC.lock();
        try {
            ilVarC.k();
            AtomicReferenceArray atomicReferenceArray = ilVarC.e;
            int length = (atomicReferenceArray.length() - 1) & iA;
            ih ihVar = (ih) atomicReferenceArray.get(length);
            ih ihVarB = ihVar;
            while (true) {
                obj3 = null;
                if (ihVarB == null) {
                    break;
                }
                Object objC = ihVarB.c();
                if (ihVarB.a() == iA && objC != null && ilVarC.a.f.d(obj, objC)) {
                    Object objD = ihVarB.d();
                    if (objD != null) {
                        ilVarC.c++;
                        ilVarC.l(ihVarB, obj2);
                        obj3 = objD;
                        break;
                    }
                    if (!il.n(ihVarB)) {
                        break;
                    }
                    int i = ilVarC.b;
                    ilVarC.c++;
                    ih ihVarC = ilVarC.c(ihVar, ihVarB);
                    int i2 = ilVarC.b - 1;
                    atomicReferenceArray.set(length, ihVarC);
                    ilVarC.b = i2;
                    break;
                }
                ihVarB = ihVarB.b();
            }
            return obj3;
        } finally {
            ilVarC.unlock();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        int i = 0;
        long j = 0;
        while (true) {
            il[] ilVarArr = this.d;
            if (i >= ilVarArr.length) {
                return com.google.android.libraries.navigation.internal.zy.i.e(j);
            }
            j += (long) ilVarArr[i].b;
            i++;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.i;
        if (collection != null) {
            return collection;
        }
        ix ixVar = new ix(this);
        this.i = ixVar;
        return ixVar;
    }

    Object writeReplace() {
        ii iiVar = this.g;
        return new im(iiVar.d(), iiVar.e(), this.f, iiVar.e().a(), this.e, this);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean remove(Object obj, Object obj2) {
        boolean z = false;
        if (obj == null || obj2 == null) {
            return false;
        }
        int iA = a(obj);
        il ilVarC = c(iA);
        ilVarC.lock();
        try {
            ilVarC.k();
            int i = ilVarC.b;
            AtomicReferenceArray atomicReferenceArray = ilVarC.e;
            int length = (atomicReferenceArray.length() - 1) & iA;
            ih ihVar = (ih) atomicReferenceArray.get(length);
            for (ih ihVarB = ihVar; ihVarB != null; ihVarB = ihVarB.b()) {
                Object objC = ihVarB.c();
                if (ihVarB.a() == iA && objC != null && ilVarC.a.f.d(obj, objC)) {
                    if (!ilVarC.a.b().d(obj2, ihVarB.d())) {
                        if (!il.n(ihVarB)) {
                            break;
                        }
                        break;
                    }
                    z = true;
                    ilVarC.c++;
                    ih ihVarC = ilVarC.c(ihVar, ihVarB);
                    int i2 = ilVarC.b - 1;
                    atomicReferenceArray.set(length, ihVarC);
                    ilVarC.b = i2;
                    break;
                }
            }
            return z;
        } finally {
            ilVarC.unlock();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        com.google.android.libraries.navigation.internal.yx.ar.q(obj3);
        boolean z = false;
        if (obj2 == null) {
            return false;
        }
        int iA = a(obj);
        il ilVarC = c(iA);
        ilVarC.lock();
        try {
            ilVarC.k();
            AtomicReferenceArray atomicReferenceArray = ilVarC.e;
            int length = (atomicReferenceArray.length() - 1) & iA;
            ih ihVar = (ih) atomicReferenceArray.get(length);
            for (ih ihVarB = ihVar; ihVarB != null; ihVarB = ihVarB.b()) {
                Object objC = ihVarB.c();
                if (ihVarB.a() == iA && objC != null && ilVarC.a.f.d(obj, objC)) {
                    Object objD = ihVarB.d();
                    if (objD == null) {
                        if (!il.n(ihVarB)) {
                            break;
                        }
                        int i = ilVarC.b;
                        ilVarC.c++;
                        ih ihVarC = ilVarC.c(ihVar, ihVarB);
                        int i2 = ilVarC.b - 1;
                        atomicReferenceArray.set(length, ihVarC);
                        ilVarC.b = i2;
                        break;
                    }
                    if (!ilVarC.a.b().d(obj2, objD)) {
                        break;
                    }
                    ilVarC.c++;
                    ilVarC.l(ihVarB, obj3);
                    z = true;
                    break;
                }
            }
            return z;
        } finally {
            ilVarC.unlock();
        }
    }
}
