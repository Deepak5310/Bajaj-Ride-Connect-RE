package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gf;
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
public final class be extends e implements Serializable, Cloneable {
    private static final long serialVersionUID = 0;
    protected transient int[] a;
    protected transient Object[] b;
    protected transient int c;
    protected transient boolean d;
    protected transient int e = -1;
    protected transient int f = -1;
    protected transient long[] g;
    protected transient int h;
    protected transient int i;
    protected final transient int j;
    protected int k;
    protected transient ca l;
    protected transient fe m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected transient gf f337n;

    public be() {
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(16, 0.75f);
        this.h = iA;
        this.j = iA;
        this.c = iA - 1;
        this.i = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
        int i = iA + 1;
        this.a = new int[i];
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
        int[] iArr = new int[i2];
        this.a = iArr;
        Object[] objArr = new Object[i2];
        this.b = objArr;
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
            int i6 = objectInputStream.readInt();
            Object object = objectInputStream.readObject();
            if (i6 != 0) {
                int i7 = this.c;
                int iE = com.google.android.libraries.navigation.internal.agc.e.e(i6);
                while (true) {
                    i = i7 & iE;
                    if (iArr[i] == 0) {
                        break;
                    }
                    i7 = i + 1;
                    iE = this.c;
                }
            } else {
                i = this.h;
                this.d = z;
            }
            iArr[i] = i6;
            objArr[i] = object;
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
            iArr = iArr;
            i4 = i;
            z = true;
        }
        this.f = i4;
        if (i4 != -1) {
            jArr[i4] = jArr[i4] | 4294967295L;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        int[] iArr = this.a;
        Object[] objArr = this.b;
        aw awVar = new aw(this);
        objectOutputStream.defaultWriteObject();
        for (int i = this.k; i != 0; i--) {
            int iG = awVar.g();
            objectOutputStream.writeInt(iArr[iG]);
            objectOutputStream.writeObject(objArr[iG]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.cb
    public final cb A() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.cb
    public final cb B() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.cb
    public final cb C() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.c, com.google.android.libraries.navigation.internal.agg.as
    public final Object b(int i) {
        int i2;
        if (i == 0) {
            if (this.d) {
                return w();
            }
            return null;
        }
        int[] iArr = this.a;
        int iE = this.c & com.google.android.libraries.navigation.internal.agc.e.e(i);
        int i3 = iArr[iE];
        if (i3 == 0) {
            return null;
        }
        if (i == i3) {
            return v(iE);
        }
        do {
            iE = (iE + 1) & this.c;
            i2 = iArr[iE];
            if (i2 == 0) {
                return null;
            }
        } while (i != i2);
        return v(iE);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.d, com.google.android.libraries.navigation.internal.agg.c, com.google.android.libraries.navigation.internal.agg.as
    public final boolean c(int i) {
        int i2;
        if (i == 0) {
            return this.d;
        }
        int[] iArr = this.a;
        int iE = this.c & com.google.android.libraries.navigation.internal.agc.e.e(i);
        int i3 = iArr[iE];
        if (i3 == 0) {
            return false;
        }
        if (i != i3) {
            do {
                iE = (iE + 1) & this.c;
                i2 = iArr[iE];
                if (i2 == 0) {
                    return false;
                }
            } while (i != i2);
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.d, com.google.android.libraries.navigation.internal.agg.bj, java.util.Map
    public final void clear() {
        if (this.k == 0) {
            return;
        }
        this.k = 0;
        this.d = false;
        Arrays.fill(this.a, 0);
        Arrays.fill(this.b, (Object) null);
        this.f = -1;
        this.e = -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.e, java.util.SortedMap
    public final /* bridge */ /* synthetic */ Comparator comparator() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.d, java.util.Map
    public final boolean containsValue(Object obj) {
        Object[] objArr = this.b;
        int[] iArr = this.a;
        if (this.d && Objects.equals(objArr[this.h], obj)) {
            return true;
        }
        int i = this.h;
        while (i != 0) {
            i--;
            if (iArr[i] != 0 && Objects.equals(objArr[i], obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.d
    /* JADX INFO: renamed from: d */
    public final /* bridge */ /* synthetic */ ez keySet() {
        return keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.e, com.google.android.libraries.navigation.internal.agg.d, com.google.android.libraries.navigation.internal.agg.bj
    /* JADX INFO: renamed from: e */
    public final gf values() {
        if (this.f337n == null) {
            this.f337n = new av(this);
        }
        return this.f337n;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.d, java.util.Map
    public final int hashCode() {
        int iHashCode;
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
                iHashCode = this.a[i3];
                i = i3 + 1;
                if (iHashCode != 0) {
                    break;
                }
                i3 = i;
            }
            Object obj = this.b[i3];
            if (this != obj) {
                iHashCode ^= obj == null ? 0 : obj.hashCode();
            }
            i4 += iHashCode;
            i2 = i5;
            i3 = i;
        }
        if (!this.d) {
            return i4;
        }
        Object obj2 = this.b[this.h];
        return i4 + (obj2 != null ? obj2.hashCode() : 0);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.d, java.util.Map
    public final boolean isEmpty() {
        return this.k == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.e
    /* JADX INFO: renamed from: k */
    public final fe keySet() {
        if (this.m == null) {
            this.m = new az(this);
        }
        return this.m;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.e, com.google.android.libraries.navigation.internal.agg.d, java.util.Map, java.util.SortedMap
    public final /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.as
    public final Object p(int i) {
        int i2;
        if (i == 0) {
            if (this.d) {
                return this.b[this.h];
            }
            return null;
        }
        int[] iArr = this.a;
        int iE = this.c & com.google.android.libraries.navigation.internal.agc.e.e(i);
        int i3 = iArr[iE];
        if (i3 == 0) {
            return null;
        }
        if (i == i3) {
            return this.b[iE];
        }
        do {
            iE = (iE + 1) & this.c;
            i2 = iArr[iE];
            if (i2 == 0) {
                return null;
            }
        } while (i != i2);
        return this.b[iE];
    }

    @Override // com.google.android.libraries.navigation.internal.agg.d, java.util.Map
    public final void putAll(Map map) {
        int iMin = (int) Math.min(1073741824L, Math.max(2L, com.google.android.libraries.navigation.internal.agc.e.h((long) Math.ceil((this.k + map.size()) / 0.75f))));
        if (iMin > this.h) {
            z(iMin);
        }
        super.putAll(map);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.cb
    public final int q() {
        if (this.k != 0) {
            return this.a[this.e];
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.cb
    public final int r() {
        if (this.k != 0) {
            return this.a[this.f];
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final be clone() {
        try {
            be beVar = (be) super.clone();
            beVar.m = null;
            beVar.f337n = null;
            beVar.l = null;
            beVar.d = this.d;
            beVar.a = (int[]) this.a.clone();
            beVar.b = (Object[]) this.b.clone();
            beVar.g = (long[]) this.g.clone();
            return beVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.c, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.cb
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final ca u() {
        if (this.l == null) {
            this.l = new bb(this);
        }
        return this.l;
    }

    public final Object v(int i) {
        int i2;
        Object[] objArr = this.b;
        Object obj = objArr[i];
        objArr[i] = null;
        this.k--;
        x(i);
        int[] iArr = this.a;
        loop0: while (true) {
            int i3 = (i + 1) & this.c;
            while (true) {
                i2 = iArr[i3];
                if (i2 != 0) {
                    int i4 = this.c;
                    int iE = com.google.android.libraries.navigation.internal.agc.e.e(i2) & i4;
                    if (i > i3) {
                        if (i >= iE && iE > i3) {
                            break;
                        }
                        i3 = (i3 + 1) & i4;
                    } else {
                        if (i >= iE || iE > i3) {
                            break;
                        }
                        i3 = (i3 + 1) & i4;
                    }
                } else {
                    break loop0;
                }
            }
            iArr[i] = i2;
            Object[] objArr2 = this.b;
            objArr2[i] = objArr2[i3];
            y(i3, i);
            i = i3;
        }
        iArr[i] = 0;
        this.b[i] = null;
        int i5 = this.h;
        if (i5 > this.j && this.k < this.i / 4 && i5 > 16) {
            z(i5 >> 1);
        }
        return obj;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.e, com.google.android.libraries.navigation.internal.agg.d, java.util.Map, java.util.SortedMap
    public final /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public final Object w() {
        this.d = false;
        Object[] objArr = this.b;
        int i = this.h;
        Object obj = objArr[i];
        objArr[i] = null;
        this.k--;
        x(i);
        int i2 = this.h;
        if (i2 > this.j && this.k < this.i / 4 && i2 > 16) {
            z(i2 >> 1);
        }
        return obj;
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

    protected final void z(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        int[] iArr = this.a;
        Object[] objArr = this.b;
        int[] iArr2 = new int[i4];
        Object[] objArr2 = new Object[i4];
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
            int i10 = iArr[i5];
            if (i10 != 0) {
                int iE = com.google.android.libraries.navigation.internal.agc.e.e(i10);
                while (true) {
                    i3 = iE & i2;
                    if (iArr2[i3] == 0) {
                        break;
                    } else {
                        iE = i3 + 1;
                    }
                }
            } else {
                i3 = i;
            }
            iArr2[i3] = iArr[i5];
            objArr2[i3] = objArr[i5];
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
            objArr = objArr;
            i5 = (int) jArr[i5];
            iArr = iArr;
        }
        this.g = jArr2;
        this.f = i7;
        if (i7 != -1) {
            jArr2[i7] = jArr2[i7] | 4294967295L;
        }
        this.h = i;
        this.c = i2;
        this.i = com.google.android.libraries.navigation.internal.agc.e.d(i, 0.75f);
        this.a = iArr2;
        this.b = objArr2;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.c, com.google.android.libraries.navigation.internal.agg.as
    public final Object a(int i, Object obj) {
        int i2;
        if (i == 0) {
            i2 = this.d ? this.h : -(this.h + 1);
        } else {
            int[] iArr = this.a;
            int iE = this.c & com.google.android.libraries.navigation.internal.agc.e.e(i);
            int i3 = iArr[iE];
            if (i3 != 0) {
                if (i != i3) {
                    while (true) {
                        iE = (iE + 1) & this.c;
                        int i4 = iArr[iE];
                        if (i4 == 0) {
                            i2 = -(iE + 1);
                        } else if (i == i4) {
                        }
                    }
                }
                i2 = iE;
            } else {
                i2 = -(iE + 1);
            }
        }
        if (i2 >= 0) {
            Object[] objArr = this.b;
            Object obj2 = objArr[i2];
            objArr[i2] = obj;
            return obj2;
        }
        int i5 = (-i2) - 1;
        if (i5 == this.h) {
            this.d = true;
        }
        this.a[i5] = i;
        this.b[i5] = obj;
        int i6 = this.k;
        if (i6 == 0) {
            this.f = i5;
            this.e = i5;
            this.g[i5] = -1;
        } else {
            long[] jArr = this.g;
            int i7 = this.f;
            long j = jArr[i7];
            jArr[i7] = j ^ (((((long) i5) & 4294967295L) ^ j) & 4294967295L);
            jArr[i5] = ((((long) i7) & 4294967295L) << 32) | 4294967295L;
            this.f = i5;
        }
        this.k = i6 + 1;
        if (i6 < this.i) {
            return null;
        }
        z(com.google.android.libraries.navigation.internal.agc.e.a(i6 + 2, 0.75f));
        return null;
    }
}
