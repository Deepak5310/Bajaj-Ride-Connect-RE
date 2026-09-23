package com.google.android.libraries.navigation.internal.agg;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class eq extends q implements Serializable, Cloneable {
    private static final long serialVersionUID = 0;
    protected transient int[] a;
    protected transient int b;
    protected transient boolean c;
    protected transient int d;
    protected transient int e;
    protected transient long[] f;
    protected transient int g;
    protected transient int h;
    protected final transient int i;
    public int j;
    protected final float k;

    public eq() {
        this(16);
    }

    private final void H(int i) {
        int i2;
        if (this.j == 1 || (i2 = this.e) == i) {
            return;
        }
        if (this.d == i) {
            long[] jArr = this.f;
            int i3 = (int) jArr[i];
            this.d = i3;
            jArr[i3] = (-4294967296L) | jArr[i3];
        } else {
            long[] jArr2 = this.f;
            long j = jArr2[i];
            int i4 = (int) j;
            int i5 = (int) (j >>> 32);
            long j2 = jArr2[i5];
            jArr2[i5] = j2 ^ ((j2 ^ (j & 4294967295L)) & 4294967295L);
            long j3 = jArr2[i4];
            jArr2[i4] = ((-4294967296L) & ((j & (-4294967296L)) ^ j3)) ^ j3;
        }
        long[] jArr3 = this.f;
        long j4 = jArr3[i2];
        jArr3[i2] = j4 ^ (((((long) i) & 4294967295L) ^ j4) & 4294967295L);
        jArr3[i] = ((((long) i2) & 4294967295L) << 32) | 4294967295L;
        this.e = i;
    }

    private final void I(long j) {
        int iMin = (int) Math.min(1073741824L, Math.max(2L, com.google.android.libraries.navigation.internal.agc.e.h((long) Math.ceil(j / this.k))));
        if (iMin > this.g) {
            C(iMin);
        }
    }

    private final void J(int i) {
        this.j--;
        A(i);
        D(i);
        int i2 = this.g;
        if (i2 <= this.i || this.j >= this.h / 4 || i2 <= 16) {
            return;
        }
        C(i2 >> 1);
    }

    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [boolean, int] */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        int iE;
        objectInputStream.defaultReadObject();
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(this.j, this.k);
        this.g = iA;
        this.h = com.google.android.libraries.navigation.internal.agc.e.d(iA, this.k);
        this.b = iA - 1;
        ?? r2 = 1;
        int i = iA + 1;
        int[] iArr = new int[i];
        this.a = iArr;
        long[] jArr = new long[i];
        this.f = jArr;
        this.e = -1;
        this.d = -1;
        int i2 = this.j;
        int i3 = -1;
        while (true) {
            int i4 = i2 - 1;
            if (i2 == 0) {
                break;
            }
            int i5 = objectInputStream.readInt();
            if (i5 == 0) {
                iE = this.g;
                this.c = r2;
            } else {
                iE = this.b & com.google.android.libraries.navigation.internal.agc.e.e(i5);
                if (iArr[iE] != 0) {
                    do {
                        iE = (iE + r2) & this.b;
                    } while (iArr[iE] != 0);
                }
            }
            iArr[iE] = i5;
            if (this.d != -1) {
                long j = jArr[i3];
                jArr[i3] = (((((long) iE) & 4294967295L) ^ j) & 4294967295L) ^ j;
                long j2 = jArr[iE];
                jArr[iE] = j2 ^ ((((4294967295L & ((long) i3)) << 32) ^ j2) & (-4294967296L));
            } else {
                this.d = iE;
                jArr[iE] = jArr[iE] | (-4294967296L);
            }
            i2 = i4;
            i3 = iE;
            iArr = iArr;
            r2 = 1;
        }
        this.e = i3;
        if (i3 != -1) {
            jArr[i3] = jArr[i3] | 4294967295L;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ep epVar = new ep(this);
        objectOutputStream.defaultWriteObject();
        for (int i = this.j; i != 0; i--) {
            objectOutputStream.writeInt(epVar.nextInt());
        }
    }

    protected final void A(int i) {
        if (this.j == 0) {
            this.e = -1;
            this.d = -1;
            return;
        }
        if (this.d == i) {
            long[] jArr = this.f;
            int i2 = (int) jArr[i];
            this.d = i2;
            if (i2 >= 0) {
                jArr[i2] = (-4294967296L) | jArr[i2];
                return;
            }
            return;
        }
        if (this.e == i) {
            long[] jArr2 = this.f;
            int i3 = (int) (jArr2[i] >>> 32);
            this.e = i3;
            if (i3 >= 0) {
                jArr2[i3] = jArr2[i3] | 4294967295L;
                return;
            }
            return;
        }
        long[] jArr3 = this.f;
        long j = jArr3[i];
        int i4 = (int) j;
        int i5 = (int) (j >>> 32);
        long j2 = jArr3[i5];
        jArr3[i5] = (4294967295L & ((j & 4294967295L) ^ j2)) ^ j2;
        long j3 = jArr3[i4];
        jArr3[i4] = ((-4294967296L) & ((j & (-4294967296L)) ^ j3)) ^ j3;
    }

    protected final void B(int i, int i2) {
        if (this.j == 1) {
            this.e = i2;
            this.d = i2;
            this.f[i2] = -1;
            return;
        }
        long j = i2;
        if (this.d == i) {
            this.d = i2;
            long[] jArr = this.f;
            int i3 = (int) jArr[i];
            long j2 = jArr[i3];
            jArr[i3] = ((((j & 4294967295L) << 32) ^ j2) & (-4294967296L)) ^ j2;
            jArr[i2] = jArr[i];
            return;
        }
        if (this.e == i) {
            this.e = i2;
            long[] jArr2 = this.f;
            int i4 = (int) (jArr2[i] >>> 32);
            long j3 = jArr2[i4];
            jArr2[i4] = (((j & 4294967295L) ^ j3) & 4294967295L) ^ j3;
            jArr2[i2] = jArr2[i];
            return;
        }
        long[] jArr3 = this.f;
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

    protected final void C(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        int[] iArr = this.a;
        int[] iArr2 = new int[i4];
        int i5 = this.d;
        long[] jArr = this.f;
        long[] jArr2 = new long[i4];
        this.d = -1;
        int i6 = this.j;
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
            if (i8 != -1) {
                long j = jArr2[i7];
                jArr2[i7] = (((((long) i3) & 4294967295L) ^ j) & 4294967295L) ^ j;
                long j2 = jArr2[i3];
                jArr2[i3] = j2 ^ ((((((long) i7) & 4294967295L) << 32) ^ j2) & (-4294967296L));
            } else {
                this.d = i3;
                jArr2[i3] = -1;
            }
            i8 = i5;
            i7 = i3;
            i6 = i9;
            iArr2 = iArr2;
            i5 = (int) jArr[i5];
            iArr = iArr;
        }
        int[] iArr3 = iArr2;
        this.f = jArr2;
        this.e = i7;
        if (i7 != -1) {
            jArr2[i7] = jArr2[i7] | 4294967295L;
        }
        this.g = i;
        this.b = i2;
        this.h = com.google.android.libraries.navigation.internal.agc.e.d(i, this.k);
        this.a = iArr3;
    }

    protected final void D(int i) {
        int i2;
        int[] iArr = this.a;
        while (true) {
            int i3 = (i + 1) & this.b;
            while (true) {
                i2 = iArr[i3];
                if (i2 != 0) {
                    int i4 = this.b;
                    int iE = com.google.android.libraries.navigation.internal.agc.e.e(i2) & i4;
                    if (i > i3) {
                        if (i >= iE && iE > i3) {
                            break;
                        } else {
                            i3 = (i3 + 1) & i4;
                        }
                    } else if (i >= iE || iE > i3) {
                        break;
                    } else {
                        i3 = (i3 + 1) & i4;
                    }
                } else {
                    iArr[i] = 0;
                    return;
                }
            }
            iArr[i] = i2;
            B(i3, i);
            i = i3;
        }
    }

    public final void E(int i) {
        int i2;
        if (i != 0) {
            int[] iArr = this.a;
            int i3 = this.b;
            int iE = com.google.android.libraries.navigation.internal.agc.e.e(i);
            while (true) {
                int i4 = i3 & iE;
                int i5 = iArr[i4];
                if (i5 == 0) {
                    i2 = i4;
                    break;
                } else if (i == i5) {
                    H(i4);
                    return;
                } else {
                    i3 = i4 + 1;
                    iE = this.b;
                }
            }
        } else if (this.c) {
            H(this.g);
            return;
        } else {
            this.c = true;
            i2 = this.g;
        }
        this.a[i2] = i;
        int i6 = this.j;
        if (i6 == 0) {
            this.e = i2;
            this.d = i2;
            this.f[i2] = -1;
        } else {
            long[] jArr = this.f;
            int i7 = this.e;
            long j = jArr[i7];
            jArr[i7] = j ^ (((((long) i2) & 4294967295L) ^ j) & 4294967295L);
            jArr[i2] = ((((long) i7) & 4294967295L) << 32) | 4294967295L;
            this.e = i2;
        }
        int i8 = i6 + 1;
        this.j = i8;
        if (i6 >= this.h) {
            C(com.google.android.libraries.navigation.internal.agc.e.a(i8, this.k));
        }
    }

    public final void F() {
        int i = this.j;
        if (i == 0) {
            throw new NoSuchElementException();
        }
        int i2 = this.d;
        if (i == 1) {
            this.e = -1;
            this.d = -1;
        } else {
            long[] jArr = this.f;
            int i3 = (int) jArr[i2];
            this.d = i3;
            if (i3 >= 0) {
                jArr[i3] = jArr[i3] | (-4294967296L);
            }
        }
        int[] iArr = this.a;
        int i4 = iArr[i2];
        this.j = i - 1;
        if (i4 == 0) {
            this.c = false;
            iArr[this.g] = 0;
        } else {
            D(i2);
        }
        int i5 = this.g;
        if (i5 <= this.i || this.j >= this.h / 4 || i5 <= 16) {
            return;
        }
        C(i5 >> 1);
    }

    public final void G(int i) {
        float f = this.k;
        int iF = com.google.android.libraries.navigation.internal.agc.e.f((int) Math.ceil(i / f));
        if (iF >= this.g || this.j > com.google.android.libraries.navigation.internal.agc.e.d(iF, f)) {
            return;
        }
        try {
            C(iF);
        } catch (OutOfMemoryError unused) {
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.q, com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ei n() {
        return new ep(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.q, com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public final /* synthetic */ boolean add(Object obj) {
        return dn.a(this, (Integer) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.q, com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    /* JADX INFO: renamed from: b */
    public final fh spliterator() {
        return new fo(new ep(this), com.google.android.libraries.navigation.internal.agc.h.a(this), 337);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        if (this.j == 0) {
            return;
        }
        this.j = 0;
        this.c = false;
        Arrays.fill(this.a, 0);
        this.e = -1;
        this.d = -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.q, java.util.SortedSet
    public final /* bridge */ /* synthetic */ Comparator comparator() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    public final boolean f(int i) {
        int i2;
        if (i == 0) {
            return this.c;
        }
        int[] iArr = this.a;
        int iE = this.b & com.google.android.libraries.navigation.internal.agc.e.e(i);
        int i3 = iArr[iE];
        if (i3 == 0) {
            return false;
        }
        if (i != i3) {
            do {
                iE = (iE + 1) & this.b;
                i2 = iArr[iE];
                if (i2 == 0) {
                    return false;
                }
            } while (i != i2);
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.p, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i;
        int i2 = this.c ? this.j - 1 : this.j;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i2 - 1;
            if (i2 == 0) {
                return i3;
            }
            do {
                i = this.a[i4];
                i4++;
            } while (i == 0);
            i3 += i;
            i2 = i5;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.j == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.q, com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: iterator */
    public final /* synthetic */ Iterator n() {
        return new ep(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.p
    public final boolean m(int i) {
        int i2;
        if (i == 0) {
            if (!this.c) {
                return false;
            }
            this.c = false;
            int[] iArr = this.a;
            int i3 = this.g;
            iArr[i3] = 0;
            this.j--;
            A(i3);
            int i4 = this.g;
            if (i4 > this.i && this.j < this.h / 4 && i4 > 16) {
                C(i4 >> 1);
            }
            return true;
        }
        int[] iArr2 = this.a;
        int iE = this.b & com.google.android.libraries.navigation.internal.agc.e.e(i);
        int i5 = iArr2[iE];
        if (i5 == 0) {
            return false;
        }
        if (i == i5) {
            J(iE);
            return true;
        }
        do {
            iE = (iE + 1) & this.b;
            i2 = iArr2[iE];
            if (i2 == 0) {
                return false;
            }
        } while (i != i2);
        J(iE);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.q
    public final /* synthetic */ dk n() {
        return new ep(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.q, com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, java.util.Collection, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fe
    public final int t() {
        if (this.j != 0) {
            return this.a[this.d];
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fe
    public final int u() {
        if (this.j != 0) {
            return this.a[this.e];
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public final eq clone() {
        try {
            eq eqVar = (eq) super.clone();
            eqVar.a = (int[]) this.a.clone();
            eqVar.c = this.c;
            eqVar.f = (long[]) this.f.clone();
            return eqVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fe
    public final fe w() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fe
    public final fe x() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fe
    public final fe y() {
        throw new UnsupportedOperationException();
    }

    public final void z(int i) {
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(i, this.k);
        if (iA > this.g) {
            C(iA);
        }
    }

    public eq(int i) {
        this.d = -1;
        this.e = -1;
        this.k = 0.75f;
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(i, 0.75f);
        this.g = iA;
        this.i = iA;
        this.b = iA - 1;
        this.h = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
        int i2 = iA + 1;
        this.a = new int[i2];
        this.f = new long[i2];
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        if (this.k <= 0.5d) {
            z(collection.size());
        } else {
            I(this.j + collection.size());
        }
        return super.addAll(collection);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    public final boolean e(Cdo cdo) {
        if (this.k <= 0.5d) {
            z(cdo.size());
        } else {
            I(this.j + cdo.size());
        }
        return super.e(cdo);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo, com.google.android.libraries.navigation.internal.agg.es
    public final boolean c(int i) {
        int i2;
        int i3;
        if (i != 0) {
            int[] iArr = this.a;
            int iE = this.b & com.google.android.libraries.navigation.internal.agc.e.e(i);
            int i4 = iArr[iE];
            if (i4 != 0) {
                if (i4 != i) {
                    do {
                        iE = (iE + 1) & this.b;
                        i3 = iArr[iE];
                        if (i3 != 0) {
                        }
                    } while (i3 != i);
                }
                return false;
            }
            iArr[iE] = i;
            i2 = iE;
        } else {
            if (this.c) {
                return false;
            }
            i2 = this.g;
            this.c = true;
        }
        int i5 = this.j;
        if (i5 == 0) {
            this.e = i2;
            this.d = i2;
            this.f[i2] = -1;
        } else {
            long[] jArr = this.f;
            int i6 = this.e;
            long j = jArr[i6];
            jArr[i6] = j ^ (((((long) i2) & 4294967295L) ^ j) & 4294967295L);
            jArr[i2] = ((((long) i6) & 4294967295L) << 32) | 4294967295L;
            this.e = i2;
        }
        this.j = i5 + 1;
        if (i5 >= this.h) {
            C(com.google.android.libraries.navigation.internal.agc.e.a(i5 + 2, this.k));
        }
        return true;
    }
}
