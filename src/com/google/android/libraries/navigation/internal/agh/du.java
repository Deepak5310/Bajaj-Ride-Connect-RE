package com.google.android.libraries.navigation.internal.agh;

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

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class du extends k implements Serializable, Cloneable {
    private static final long serialVersionUID = 0;
    public transient long[] a;
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
    protected transient er l;
    protected transient hi m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected transient com.google.android.libraries.navigation.internal.agi.gf f338n;

    public du() {
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(16, 0.75f);
        this.h = iA;
        this.j = iA;
        this.c = iA - 1;
        this.i = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
        int i = iA + 1;
        this.a = new long[i];
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
        int i2 = iA + 1;
        long[] jArr = new long[i2];
        this.a = jArr;
        Object[] objArr = new Object[i2];
        this.b = objArr;
        long[] jArr2 = new long[i2];
        this.g = jArr2;
        this.f = -1;
        this.e = -1;
        int i3 = this.k;
        int i4 = -1;
        while (true) {
            int i5 = i3 - 1;
            if (i3 == 0) {
                break;
            }
            long j = objectInputStream.readLong();
            Object object = objectInputStream.readObject();
            if (j == 0) {
                i = this.h;
                this.d = true;
            } else {
                int iG = ((int) com.google.android.libraries.navigation.internal.agc.e.g(j)) & this.c;
                while (jArr[iG] != 0) {
                    iG = (iG + 1) & this.c;
                }
                i = iG;
            }
            jArr[i] = j;
            objArr[i] = object;
            if (this.e != -1) {
                long j2 = jArr2[i4];
                jArr2[i4] = j2 ^ (((((long) i) & 4294967295L) ^ j2) & 4294967295L);
                long j3 = jArr2[i];
                jArr2[i] = ((((((long) i4) & 4294967295L) << 32) ^ j3) & (-4294967296L)) ^ j3;
            } else {
                this.e = i;
                jArr2[i] = jArr2[i] | (-4294967296L);
            }
            i3 = i5;
            i4 = i;
        }
        this.f = i4;
        if (i4 != -1) {
            jArr2[i4] = jArr2[i4] | 4294967295L;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        long[] jArr = this.a;
        Object[] objArr = this.b;
        dm dmVar = new dm(this);
        objectOutputStream.defaultWriteObject();
        for (int i = this.k; i != 0; i--) {
            int iG = dmVar.g();
            objectOutputStream.writeLong(jArr[iG]);
            objectOutputStream.writeObject(objArr[iG]);
        }
    }

    public final void A(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        long[] jArr = this.a;
        Object[] objArr = this.b;
        long[] jArr2 = new long[i4];
        Object[] objArr2 = new Object[i4];
        int i5 = this.e;
        long[] jArr3 = this.g;
        long[] jArr4 = new long[i4];
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
            long j = jArr[i5];
            if (j != 0) {
                int iG = (int) com.google.android.libraries.navigation.internal.agc.e.g(j);
                while (true) {
                    i3 = iG & i2;
                    if (jArr2[i3] == 0) {
                        break;
                    } else {
                        iG = i3 + 1;
                    }
                }
            } else {
                i3 = i;
            }
            jArr2[i3] = jArr[i5];
            objArr2[i3] = objArr[i5];
            if (i8 != -1) {
                long j2 = jArr4[i7];
                jArr4[i7] = (((((long) i3) & 4294967295L) ^ j2) & 4294967295L) ^ j2;
                long j3 = jArr4[i3];
                jArr4[i3] = j3 ^ ((((((long) i7) & 4294967295L) << 32) ^ j3) & (-4294967296L));
            } else {
                this.e = i3;
                jArr4[i3] = -1;
            }
            i8 = i5;
            i7 = i3;
            objArr = objArr;
            i5 = (int) jArr3[i5];
            jArr = jArr;
            i6 = i9;
        }
        this.g = jArr4;
        this.f = i7;
        if (i7 != -1) {
            jArr4[i7] = jArr4[i7] | 4294967295L;
        }
        this.h = i;
        this.c = i2;
        this.i = com.google.android.libraries.navigation.internal.agc.e.d(i, 0.75f);
        this.a = jArr2;
        this.b = objArr2;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.es
    public final es B() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.es
    public final es C() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.es
    public final es D() {
        throw new UnsupportedOperationException();
    }

    public final void E(int i) {
        int iF = com.google.android.libraries.navigation.internal.agc.e.f((int) Math.ceil(i / 0.75f));
        if (iF >= this.h || this.k > com.google.android.libraries.navigation.internal.agc.e.d(iF, 0.75f)) {
            return;
        }
        try {
            A(iF);
        } catch (OutOfMemoryError unused) {
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.di
    public final Object aO(long j) {
        long j2;
        if (j == 0) {
            if (this.d) {
                return this.b[this.h];
            }
            return null;
        }
        long[] jArr = this.a;
        int iG = this.c & ((int) com.google.android.libraries.navigation.internal.agc.e.g(j));
        long j3 = jArr[iG];
        if (j3 == 0) {
            return null;
        }
        if (j == j3) {
            return this.b[iG];
        }
        do {
            iG = (iG + 1) & this.c;
            j2 = jArr[iG];
            if (j2 == 0) {
                return null;
            }
        } while (j != j2);
        return this.b[iG];
    }

    @Override // com.google.android.libraries.navigation.internal.agh.h, com.google.android.libraries.navigation.internal.agh.di
    public final Object b(long j) {
        long j2;
        if (j == 0) {
            if (this.d) {
                return v();
            }
            return null;
        }
        long[] jArr = this.a;
        int iG = this.c & ((int) com.google.android.libraries.navigation.internal.agc.e.g(j));
        long j3 = jArr[iG];
        if (j3 == 0) {
            return null;
        }
        if (j == j3) {
            return u(iG);
        }
        do {
            iG = (iG + 1) & this.c;
            j2 = jArr[iG];
            if (j2 == 0) {
                return null;
            }
        } while (j != j2);
        return u(iG);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, com.google.android.libraries.navigation.internal.agh.h, com.google.android.libraries.navigation.internal.agh.di
    public final boolean c(long j) {
        long j2;
        if (j == 0) {
            return this.d;
        }
        long[] jArr = this.a;
        int iG = this.c & ((int) com.google.android.libraries.navigation.internal.agc.e.g(j));
        long j3 = jArr[iG];
        if (j3 == 0) {
            return false;
        }
        if (j != j3) {
            do {
                iG = (iG + 1) & this.c;
                j2 = jArr[iG];
                if (j2 == 0) {
                    return false;
                }
            } while (j != j2);
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, com.google.android.libraries.navigation.internal.agh.ea, java.util.Map
    public final void clear() {
        if (this.k == 0) {
            return;
        }
        this.k = 0;
        this.d = false;
        Arrays.fill(this.a, 0L);
        Arrays.fill(this.b, (Object) null);
        this.f = -1;
        this.e = -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.k, java.util.SortedMap
    public final /* bridge */ /* synthetic */ Comparator comparator() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, java.util.Map
    public final boolean containsValue(Object obj) {
        Object[] objArr = this.b;
        long[] jArr = this.a;
        if (this.d && Objects.equals(objArr[this.h], obj)) {
            return true;
        }
        int i = this.h;
        while (i != 0) {
            i--;
            if (jArr[i] != 0 && Objects.equals(objArr[i], obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.k, com.google.android.libraries.navigation.internal.agh.j, com.google.android.libraries.navigation.internal.agh.ea
    /* JADX INFO: renamed from: d */
    public final /* bridge */ /* synthetic */ he keySet() {
        return keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.k, com.google.android.libraries.navigation.internal.agh.j, com.google.android.libraries.navigation.internal.agh.ea
    /* JADX INFO: renamed from: e */
    public final com.google.android.libraries.navigation.internal.agi.gf values() {
        if (this.f338n == null) {
            this.f338n = new dl(this);
        }
        return this.f338n;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, java.util.Map
    public final int hashCode() {
        long j;
        int i;
        int i2 = this.d ? this.k - 1 : this.k;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i2 - 1;
            if (i2 == 0) {
                break;
            }
            while (true) {
                j = this.a[i3];
                i = i3 + 1;
                if (j != 0) {
                    break;
                }
                i3 = i;
            }
            Object obj = this.b[i3];
            int iC = com.google.android.libraries.navigation.internal.agc.e.c(j);
            if (this != obj) {
                iC ^= obj == null ? 0 : obj.hashCode();
            }
            i4 += iC;
            i2 = i5;
            i3 = i;
        }
        if (!this.d) {
            return i4;
        }
        Object obj2 = this.b[this.h];
        return i4 + (obj2 != null ? obj2.hashCode() : 0);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, java.util.Map
    public final boolean isEmpty() {
        return this.k == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.k
    /* JADX INFO: renamed from: k */
    public final hi keySet() {
        if (this.m == null) {
            this.m = new dp(this);
        }
        return this.m;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.k, com.google.android.libraries.navigation.internal.agh.j, java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.es
    public final long p() {
        if (this.k != 0) {
            return this.a[this.e];
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, java.util.Map
    public final void putAll(Map map) {
        int iMin = (int) Math.min(1073741824L, Math.max(2L, com.google.android.libraries.navigation.internal.agc.e.h((long) Math.ceil((this.k + map.size()) / 0.75f))));
        if (iMin > this.h) {
            A(iMin);
        }
        super.putAll(map);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.es
    public final long q() {
        if (this.k != 0) {
            return this.a[this.f];
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public final du clone() {
        try {
            du duVar = (du) super.clone();
            duVar.m = null;
            duVar.f338n = null;
            duVar.l = null;
            duVar.d = this.d;
            duVar.a = (long[]) this.a.clone();
            duVar.b = (Object[]) this.b.clone();
            duVar.g = (long[]) this.g.clone();
            return duVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.es
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final er t() {
        if (this.l == null) {
            this.l = new dr(this);
        }
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.h, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return this.k;
    }

    public final Object u(int i) {
        long j;
        Object[] objArr = this.b;
        Object obj = objArr[i];
        objArr[i] = null;
        this.k--;
        x(i);
        long[] jArr = this.a;
        loop0: while (true) {
            int i2 = (i + 1) & this.c;
            while (true) {
                j = jArr[i2];
                if (j != 0) {
                    int i3 = this.c;
                    int iG = ((int) com.google.android.libraries.navigation.internal.agc.e.g(j)) & i3;
                    if (i > i2) {
                        if (i >= iG && iG > i2) {
                            break;
                        }
                        i2 = (i2 + 1) & i3;
                    } else {
                        if (i >= iG || iG > i2) {
                            break;
                        }
                        i2 = (i2 + 1) & i3;
                    }
                } else {
                    break loop0;
                }
            }
            jArr[i] = j;
            Object[] objArr2 = this.b;
            objArr2[i] = objArr2[i2];
            y(i2, i);
            i = i2;
        }
        jArr[i] = 0;
        this.b[i] = null;
        int i4 = this.h;
        if (i4 > this.j && this.k < this.i / 4 && i4 > 16) {
            A(i4 >> 1);
        }
        return obj;
    }

    public final Object v() {
        this.d = false;
        Object[] objArr = this.b;
        int i = this.h;
        Object obj = objArr[i];
        objArr[i] = null;
        this.k--;
        x(i);
        int i2 = this.h;
        if (i2 > this.j && this.k < this.i / 4 && i2 > 16) {
            A(i2 >> 1);
        }
        return obj;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.k, com.google.android.libraries.navigation.internal.agh.j, java.util.Map
    public final /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public final Object w(int i, Object obj) {
        Object[] objArr = this.b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    protected final void x(int i) {
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

    protected final void y(int i, int i2) {
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

    public final void z(int i) {
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

    @Override // com.google.android.libraries.navigation.internal.agh.h, com.google.android.libraries.navigation.internal.agh.di
    public final Object a(long j, Object obj) {
        int i;
        if (j == 0) {
            i = this.d ? this.h : -(this.h + 1);
        } else {
            long[] jArr = this.a;
            int iG = this.c & ((int) com.google.android.libraries.navigation.internal.agc.e.g(j));
            long j2 = jArr[iG];
            if (j2 != 0) {
                if (j != j2) {
                    while (true) {
                        iG = (iG + 1) & this.c;
                        long j3 = jArr[iG];
                        if (j3 == 0) {
                            i = -(iG + 1);
                        } else if (j == j3) {
                        }
                    }
                }
                i = iG;
            } else {
                i = -(iG + 1);
            }
        }
        if (i >= 0) {
            Object[] objArr = this.b;
            Object obj2 = objArr[i];
            objArr[i] = obj;
            return obj2;
        }
        int i2 = (-i) - 1;
        if (i2 == this.h) {
            this.d = true;
        }
        this.a[i2] = j;
        this.b[i2] = obj;
        int i3 = this.k;
        if (i3 == 0) {
            this.f = i2;
            this.e = i2;
            this.g[i2] = -1;
        } else {
            long[] jArr2 = this.g;
            int i4 = this.f;
            long j4 = jArr2[i4];
            jArr2[i4] = j4 ^ (((((long) i2) & 4294967295L) ^ j4) & 4294967295L);
            jArr2[i2] = ((((long) i4) & 4294967295L) << 32) | 4294967295L;
            this.f = i2;
        }
        this.k = i3 + 1;
        if (i3 < this.i) {
            return null;
        }
        A(com.google.android.libraries.navigation.internal.agc.e.a(i3 + 2, 0.75f));
        return null;
    }
}
