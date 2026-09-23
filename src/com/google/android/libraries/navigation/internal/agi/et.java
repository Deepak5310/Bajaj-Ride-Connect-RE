package com.google.android.libraries.navigation.internal.agi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class et extends l implements Serializable, Cloneable {
    private static final long serialVersionUID = 0;
    public transient Object[] a;
    public transient Object[] b;
    public transient int c;
    public transient boolean d;
    public transient int e = -1;
    public transient int f = -1;
    public transient long[] g;
    public transient int h;
    public transient int i;
    protected final transient int j;
    public int k;
    protected transient fp l;
    protected transient hi m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected transient gf f339n;

    public et() {
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(16, 0.75f);
        this.h = iA;
        this.j = iA;
        this.c = iA - 1;
        this.i = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
        int i = iA + 1;
        this.a = new Object[i];
        this.b = new Object[i];
        this.g = new long[i];
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        int i;
        objectInputStream.defaultReadObject();
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(this.k, 0.75f);
        this.h = iA;
        this.i = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
        this.c = iA - 1;
        boolean z = true;
        int i2 = iA + 1;
        Object[] objArr = new Object[i2];
        this.a = objArr;
        Object[] objArr2 = new Object[i2];
        this.b = objArr2;
        long[] jArr = new long[i2];
        this.g = jArr;
        this.f = -1;
        this.e = -1;
        int i3 = this.k;
        int i4 = -1;
        while (true) {
            int i5 = i3 - 1;
            if (i3 == 0) {
                break;
            }
            Object object = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            if (object != null) {
                int iE = com.google.android.libraries.navigation.internal.agc.e.e(object.hashCode());
                int i6 = this.c;
                while (true) {
                    i = iE & i6;
                    if (objArr[i] == null) {
                        break;
                    }
                    iE = i + 1;
                    i6 = this.c;
                }
            } else {
                i = this.h;
                this.d = z;
            }
            objArr[i] = object;
            objArr2[i] = object2;
            if (this.e != -1) {
                long j = jArr[i4];
                jArr[i4] = (((((long) i) & 4294967295L) ^ j) & 4294967295L) ^ j;
                long j2 = jArr[i];
                jArr[i] = j2 ^ ((((((long) i4) & 4294967295L) << 32) ^ j2) & (-4294967296L));
            } else {
                this.e = i;
                jArr[i] = jArr[i] | (-4294967296L);
            }
            i3 = i5;
            objArr = objArr;
            i4 = i;
            z = true;
        }
        this.f = i4;
        if (i4 != -1) {
            jArr[i4] = jArr[i4] | 4294967295L;
        }
    }

    private final int u(Object obj) {
        Object obj2;
        if (obj == null) {
            return this.d ? this.h : -(this.h + 1);
        }
        Object[] objArr = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.c;
        Object obj3 = objArr[iE];
        if (obj3 != null) {
            if (!obj.equals(obj3)) {
                do {
                    iE = (iE + 1) & this.c;
                    obj2 = objArr[iE];
                    if (obj2 == null) {
                    }
                } while (!obj.equals(obj2));
            }
            return iE;
        }
        return -(iE + 1);
    }

    private final void v(int i, Object obj, Object obj2) {
        if (i == this.h) {
            this.d = true;
        }
        this.a[i] = obj;
        this.b[i] = obj2;
        int i2 = this.k;
        if (i2 == 0) {
            this.f = i;
            this.e = i;
            this.g[i] = -1;
        } else {
            long[] jArr = this.g;
            int i3 = this.f;
            long j = jArr[i3];
            jArr[i3] = j ^ (((((long) i) & 4294967295L) ^ j) & 4294967295L);
            jArr[i] = ((((long) i3) & 4294967295L) << 32) | 4294967295L;
            this.f = i;
        }
        this.k = i2 + 1;
        if (i2 >= this.i) {
            p(com.google.android.libraries.navigation.internal.agc.e.a(i2 + 2, 0.75f));
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Object[] objArr = this.a;
        Object[] objArr2 = this.b;
        el elVar = new el(this);
        objectOutputStream.defaultWriteObject();
        for (int i = this.k; i != 0; i--) {
            int iC = elVar.c();
            objectOutputStream.writeObject(objArr[iC]);
            objectOutputStream.writeObject(objArr2[iC]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k
    /* JADX INFO: renamed from: a */
    public final gf values() {
        if (this.f339n == null) {
            this.f339n = new ek(this);
        }
        return this.f339n;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k
    /* JADX INFO: renamed from: c */
    public final /* bridge */ /* synthetic */ hd keySet() {
        return keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, com.google.android.libraries.navigation.internal.agi.ey, java.util.Map
    public final void clear() {
        if (this.k == 0) {
            return;
        }
        this.k = 0;
        this.d = false;
        Arrays.fill(this.a, (Object) null);
        Arrays.fill(this.b, (Object) null);
        this.f = -1;
        this.e = -1;
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, java.util.Map
    public final Object compute(Object obj, BiFunction biFunction) {
        Objects.requireNonNull(biFunction);
        int iU = u(obj);
        Object objApply = biFunction.apply(obj, iU >= 0 ? this.b[iU] : null);
        if (objApply == null) {
            if (iU >= 0) {
                if (obj == null) {
                    k();
                } else {
                    j(iU);
                }
            }
            return null;
        }
        if (iU < 0) {
            v((-iU) - 1, obj, objApply);
            return objApply;
        }
        this.b[iU] = objApply;
        return objApply;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, java.util.Map
    public final Object computeIfPresent(Object obj, BiFunction biFunction) {
        Object obj2;
        Objects.requireNonNull(biFunction);
        int iU = u(obj);
        if (iU < 0 || (obj2 = this.b[iU]) == null) {
            return null;
        }
        Object objApply = biFunction.apply(obj, obj2);
        if (objApply != null) {
            this.b[iU] = objApply;
            return objApply;
        }
        if (obj == null) {
            k();
            return null;
        }
        j(iU);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, com.google.android.libraries.navigation.internal.agi.i, com.google.android.libraries.navigation.internal.agc.d
    public final boolean containsKey(Object obj) {
        Object obj2;
        if (obj == null) {
            return this.d;
        }
        Object[] objArr = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.c;
        Object obj3 = objArr[iE];
        if (obj3 == null) {
            return false;
        }
        if (!obj.equals(obj3)) {
            do {
                iE = (iE + 1) & this.c;
                obj2 = objArr[iE];
                if (obj2 == null) {
                    return false;
                }
            } while (!obj.equals(obj2));
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, java.util.Map
    public final boolean containsValue(Object obj) {
        Object[] objArr = this.b;
        Object[] objArr2 = this.a;
        if (this.d && Objects.equals(objArr[this.h], obj)) {
            return true;
        }
        int i = this.h;
        while (i != 0) {
            i--;
            if (objArr2[i] != null && Objects.equals(objArr[i], obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.l
    /* JADX INFO: renamed from: f */
    public final hi keySet() {
        if (this.m == null) {
            this.m = new eo(this);
        }
        return this.m;
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        if (this.k != 0) {
            return this.a[this.e];
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final et clone() {
        try {
            et etVar = (et) super.clone();
            etVar.m = null;
            etVar.f339n = null;
            etVar.l = null;
            etVar.d = this.d;
            etVar.a = (Object[]) this.a.clone();
            etVar.b = (Object[]) this.b.clone();
            etVar.g = (long[]) this.g.clone();
            return etVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.eh, com.google.android.libraries.navigation.internal.agc.d
    public final Object get(Object obj) {
        Object obj2;
        if (obj == null) {
            if (this.d) {
                return this.b[this.h];
            }
            return null;
        }
        Object[] objArr = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.c;
        Object obj3 = objArr[iE];
        if (obj3 == null) {
            return null;
        }
        if (obj.equals(obj3)) {
            return this.b[iE];
        }
        do {
            iE = (iE + 1) & this.c;
            obj2 = objArr[iE];
            if (obj2 == null) {
                return null;
            }
        } while (!obj.equals(obj2));
        return this.b[iE];
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3;
        if (obj != null) {
            Object[] objArr = this.a;
            int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.c;
            Object obj4 = objArr[iE];
            if (obj4 != null) {
                if (obj.equals(obj4)) {
                    return this.b[iE];
                }
                do {
                    iE = (iE + 1) & this.c;
                    obj3 = objArr[iE];
                    if (obj3 != null) {
                    }
                } while (!obj.equals(obj3));
                return this.b[iE];
            }
        } else if (this.d) {
            return this.b[this.h];
        }
        return obj2;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.fq
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final fp i() {
        if (this.l == null) {
            this.l = new eq(this);
        }
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, java.util.Map
    public final int hashCode() {
        Object obj;
        int i;
        int i2 = this.d ? this.k - 1 : this.k;
        int i3 = 0;
        int i4 = 0;
        int iHashCode = 0;
        while (true) {
            int i5 = i2 - 1;
            if (i2 == 0) {
                break;
            }
            while (true) {
                obj = this.a[i3];
                i = i3 + 1;
                if (obj != null) {
                    break;
                }
                i3 = i;
            }
            if (this != obj) {
                iHashCode = obj.hashCode();
            }
            Object obj2 = this.b[i3];
            if (this != obj2) {
                iHashCode = (obj2 == null ? 0 : obj2.hashCode()) ^ iHashCode;
            }
            i4 += iHashCode;
            i2 = i5;
            i3 = i;
        }
        if (!this.d) {
            return i4;
        }
        Object obj3 = this.b[this.h];
        return i4 + (obj3 != null ? obj3.hashCode() : 0);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.l, java.util.SortedMap
    public final /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
        return q();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, java.util.Map
    public final boolean isEmpty() {
        return this.k == 0;
    }

    public final Object j(int i) {
        Object obj;
        Object[] objArr = this.b;
        Object obj2 = objArr[i];
        objArr[i] = null;
        this.k--;
        m(i);
        Object[] objArr2 = this.a;
        loop0: while (true) {
            int i2 = (i + 1) & this.c;
            while (true) {
                obj = objArr2[i2];
                if (obj != null) {
                    int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode());
                    int i3 = this.c;
                    int i4 = iE & i3;
                    if (i > i2) {
                        if (i >= i4 && i4 > i2) {
                            break;
                        }
                        i2 = (i2 + 1) & i3;
                    } else {
                        if (i >= i4 || i4 > i2) {
                            break;
                        }
                        i2 = (i2 + 1) & i3;
                    }
                } else {
                    break loop0;
                }
            }
            objArr2[i] = obj;
            Object[] objArr3 = this.b;
            objArr3[i] = objArr3[i2];
            n(i2, i);
            i = i2;
        }
        objArr2[i] = null;
        this.b[i] = null;
        int i5 = this.h;
        if (i5 > this.j && this.k < this.i / 4 && i5 > 16) {
            p(i5 >> 1);
        }
        return obj2;
    }

    public final Object k() {
        this.d = false;
        Object[] objArr = this.a;
        int i = this.h;
        objArr[i] = null;
        Object[] objArr2 = this.b;
        Object obj = objArr2[i];
        objArr2[i] = null;
        this.k--;
        m(i);
        int i2 = this.h;
        if (i2 > this.j && this.k < this.i / 4 && i2 > 16) {
            p(i2 >> 1);
        }
        return obj;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.l, com.google.android.libraries.navigation.internal.agi.k, java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    public final Object l(int i, Object obj) {
        Object[] objArr = this.b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        if (this.k != 0) {
            return this.a[this.f];
        }
        throw new NoSuchElementException();
    }

    protected final void m(int i) {
        if (this.k == 0) {
            this.f = -1;
            this.e = -1;
            return;
        }
        if (this.e == i) {
            long[] jArr = this.g;
            int i2 = (int) jArr[i];
            this.e = i2;
            if (i2 >= 0) {
                jArr[i2] = (-4294967296L) | jArr[i2];
                return;
            }
            return;
        }
        if (this.f == i) {
            long[] jArr2 = this.g;
            int i3 = (int) (jArr2[i] >>> 32);
            this.f = i3;
            if (i3 >= 0) {
                jArr2[i3] = jArr2[i3] | 4294967295L;
                return;
            }
            return;
        }
        long[] jArr3 = this.g;
        long j = jArr3[i];
        int i4 = (int) j;
        int i5 = (int) (j >>> 32);
        long j2 = jArr3[i5];
        jArr3[i5] = (4294967295L & ((j & 4294967295L) ^ j2)) ^ j2;
        long j3 = jArr3[i4];
        jArr3[i4] = ((-4294967296L) & ((j & (-4294967296L)) ^ j3)) ^ j3;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, java.util.Map
    public final Object merge(Object obj, Object obj2, BiFunction biFunction) {
        Object obj3;
        Objects.requireNonNull(biFunction);
        Objects.requireNonNull(obj2);
        int iU = u(obj);
        if (iU < 0 || (obj3 = this.b[iU]) == null) {
            if (iU < 0) {
                v((-iU) - 1, obj, obj2);
            } else {
                this.b[iU] = obj2;
            }
            return obj2;
        }
        Object objApply = biFunction.apply(obj3, obj2);
        if (objApply != null) {
            this.b[iU] = objApply;
            return objApply;
        }
        if (obj == null) {
            k();
            return null;
        }
        j(iU);
        return null;
    }

    protected final void n(int i, int i2) {
        if (this.k == 1) {
            this.f = i2;
            this.e = i2;
            this.g[i2] = -1;
            return;
        }
        long j = i2;
        if (this.e == i) {
            this.e = i2;
            long[] jArr = this.g;
            int i3 = (int) jArr[i];
            long j2 = jArr[i3];
            jArr[i3] = ((((j & 4294967295L) << 32) ^ j2) & (-4294967296L)) ^ j2;
            jArr[i2] = jArr[i];
            return;
        }
        if (this.f == i) {
            this.f = i2;
            long[] jArr2 = this.g;
            int i4 = (int) (jArr2[i] >>> 32);
            long j3 = jArr2[i4];
            jArr2[i4] = (((j & 4294967295L) ^ j3) & 4294967295L) ^ j3;
            jArr2[i2] = jArr2[i];
            return;
        }
        long[] jArr3 = this.g;
        long j4 = jArr3[i];
        int i5 = (int) j4;
        int i6 = (int) (j4 >>> 32);
        long j5 = jArr3[i6];
        long j6 = j & 4294967295L;
        long j7 = j6 << 32;
        jArr3[i6] = ((j6 ^ j5) & 4294967295L) ^ j5;
        long j8 = jArr3[i5];
        jArr3[i5] = j8 ^ ((-4294967296L) & (j8 ^ j7));
        jArr3[i2] = j4;
    }

    public final void o(int i) {
        int i2;
        if (this.k == 1 || (i2 = this.f) == i) {
            return;
        }
        if (this.e == i) {
            long[] jArr = this.g;
            int i3 = (int) jArr[i];
            this.e = i3;
            jArr[i3] = (-4294967296L) | jArr[i3];
        } else {
            long[] jArr2 = this.g;
            long j = jArr2[i];
            int i4 = (int) j;
            int i5 = (int) (j >>> 32);
            long j2 = jArr2[i5];
            jArr2[i5] = j2 ^ ((j2 ^ (j & 4294967295L)) & 4294967295L);
            long j3 = jArr2[i4];
            jArr2[i4] = ((-4294967296L) & ((j & (-4294967296L)) ^ j3)) ^ j3;
        }
        long[] jArr3 = this.g;
        long j4 = jArr3[i2];
        jArr3[i2] = j4 ^ (((((long) i) & 4294967295L) ^ j4) & 4294967295L);
        jArr3[i] = ((((long) i2) & 4294967295L) << 32) | 4294967295L;
        this.f = i;
    }

    public final void p(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        Object[] objArr = this.a;
        Object[] objArr2 = this.b;
        Object[] objArr3 = new Object[i4];
        Object[] objArr4 = new Object[i4];
        int i5 = this.e;
        long[] jArr = this.g;
        long[] jArr2 = new long[i4];
        this.e = -1;
        int i6 = this.k;
        int i7 = -1;
        int i8 = -1;
        while (true) {
            i2 = i - 1;
            int i9 = i6 - 1;
            if (i6 == 0) {
                break;
            }
            Object obj = objArr[i5];
            if (obj != null) {
                int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode());
                while (true) {
                    i3 = iE & i2;
                    if (objArr3[i3] == null) {
                        break;
                    } else {
                        iE = i3 + 1;
                    }
                }
            } else {
                i3 = i;
            }
            objArr3[i3] = objArr[i5];
            objArr4[i3] = objArr2[i5];
            if (i8 != -1) {
                long j = jArr2[i7];
                jArr2[i7] = (((((long) i3) & 4294967295L) ^ j) & 4294967295L) ^ j;
                long j2 = jArr2[i3];
                jArr2[i3] = j2 ^ ((((((long) i7) & 4294967295L) << 32) ^ j2) & (-4294967296L));
            } else {
                this.e = i3;
                jArr2[i3] = -1;
            }
            i8 = i5;
            i7 = i3;
            i6 = i9;
            objArr2 = objArr2;
            i5 = (int) jArr[i5];
            objArr = objArr;
        }
        this.g = jArr2;
        this.f = i7;
        if (i7 != -1) {
            jArr2[i7] = jArr2[i7] | 4294967295L;
        }
        this.h = i;
        this.c = i2;
        this.i = com.google.android.libraries.navigation.internal.agc.e.d(i, 0.75f);
        this.a = objArr3;
        this.b = objArr4;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, com.google.android.libraries.navigation.internal.agi.ey, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int iU = u(obj);
        if (iU < 0) {
            v((-iU) - 1, obj, obj2);
            return null;
        }
        Object[] objArr = this.b;
        Object obj3 = objArr[iU];
        objArr[iU] = obj2;
        return obj3;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, java.util.Map
    public final void putAll(Map map) {
        int iMin = (int) Math.min(1073741824L, Math.max(2L, com.google.android.libraries.navigation.internal.agc.e.h((long) Math.ceil((this.k + map.size()) / 0.75f))));
        if (iMin > this.h) {
            p(iMin);
        }
        super.putAll(map);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, java.util.Map
    public final Object putIfAbsent(Object obj, Object obj2) {
        int iU = u(obj);
        if (iU >= 0) {
            return this.b[iU];
        }
        v((-iU) - 1, obj, obj2);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.fq
    public final fq q() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.fq
    public final fq r() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, com.google.android.libraries.navigation.internal.agi.ey, java.util.Map
    public final Object remove(Object obj) {
        Object obj2;
        if (obj == null) {
            if (this.d) {
                return k();
            }
            return null;
        }
        Object[] objArr = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.c;
        Object obj3 = objArr[iE];
        if (obj3 == null) {
            return null;
        }
        if (obj.equals(obj3)) {
            return j(iE);
        }
        do {
            iE = (iE + 1) & this.c;
            obj2 = objArr[iE];
            if (obj2 == null) {
                return null;
            }
        } while (!obj.equals(obj2));
        return j(iE);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, java.util.Map
    public final Object replace(Object obj, Object obj2) {
        int iU = u(obj);
        if (iU < 0) {
            return null;
        }
        Object[] objArr = this.b;
        Object obj3 = objArr[iU];
        objArr[iU] = obj2;
        return obj3;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.fq
    public final fq s() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.i, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.l, java.util.SortedMap
    public final /* bridge */ /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
        return r();
    }

    public final void t(int i) {
        int iF = com.google.android.libraries.navigation.internal.agc.e.f((int) Math.ceil(i / 0.75f));
        if (iF >= this.h || this.k > com.google.android.libraries.navigation.internal.agc.e.d(iF, 0.75f)) {
            return;
        }
        try {
            p(iF);
        } catch (OutOfMemoryError unused) {
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.l, java.util.SortedMap
    public final /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
        return s();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.l, com.google.android.libraries.navigation.internal.agi.k, java.util.Map
    public final /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, java.util.Map
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iU = u(obj);
        if (iU < 0 || !Objects.equals(obj2, this.b[iU])) {
            return false;
        }
        this.b[iU] = obj3;
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.k, java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        if (obj == null) {
            if (!this.d || !Objects.equals(obj2, this.b[this.h])) {
                return false;
            }
            k();
            return true;
        }
        Object[] objArr = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.c;
        Object obj3 = objArr[iE];
        if (obj3 == null) {
            return false;
        }
        if (obj.equals(obj3) && Objects.equals(obj2, this.b[iE])) {
            j(iE);
            return true;
        }
        while (true) {
            iE = (iE + 1) & this.c;
            Object obj4 = objArr[iE];
            if (obj4 == null) {
                return false;
            }
            if (obj.equals(obj4) && Objects.equals(obj2, this.b[iE])) {
                j(iE);
                return true;
            }
        }
    }
}
