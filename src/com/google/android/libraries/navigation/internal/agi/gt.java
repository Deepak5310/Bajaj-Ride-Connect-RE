package com.google.android.libraries.navigation.internal.agi;

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
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gt extends v implements Serializable, Cloneable {
    public static final /* synthetic */ int l = 0;
    private static final long serialVersionUID = 0;
    protected transient Object[] a;
    protected transient int b;
    protected transient boolean c;
    protected transient long[] f;
    protected transient int g;
    protected transient int h;
    protected final transient int i;
    public int j;
    protected transient int d = -1;
    protected transient int e = -1;
    protected final float k = 0.75f;

    static {
        Collector.of(new Supplier() { // from class: com.google.android.libraries.navigation.internal.agi.gp
            @Override // java.util.function.Supplier
            public final Object get() {
                return new gt();
            }
        }, new BiConsumer() { // from class: com.google.android.libraries.navigation.internal.agi.gq
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((gt) obj).add(obj2);
            }
        }, new BinaryOperator() { // from class: com.google.android.libraries.navigation.internal.agi.gr
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                gt gtVar = (gt) obj;
                int i = gt.l;
                gtVar.addAll((gt) obj2);
                return gtVar;
            }
        }, new Collector.Characteristics[0]);
    }

    public gt() {
        int iA = com.google.android.libraries.navigation.internal.agc.e.a(16, 0.75f);
        this.g = iA;
        this.i = iA;
        this.b = iA - 1;
        this.h = com.google.android.libraries.navigation.internal.agc.e.d(iA, 0.75f);
        int i = iA + 1;
        this.a = new Object[i];
        this.f = new long[i];
    }

    private final void l(int i) {
        this.j--;
        h(i);
        k(i);
        int i2 = this.g;
        if (i2 <= this.i || this.j >= this.h / 4 || i2 <= 16) {
            return;
        }
        j(i2 >> 1);
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
        Object[] objArr = new Object[i];
        this.a = objArr;
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
            Object object = objectInputStream.readObject();
            if (object == null) {
                iE = this.g;
                this.c = r2;
            } else {
                iE = com.google.android.libraries.navigation.internal.agc.e.e(object.hashCode()) & this.b;
                if (objArr[iE] != null) {
                    do {
                        iE = (iE + r2) & this.b;
                    } while (objArr[iE] != null);
                }
            }
            objArr[iE] = object;
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
            objArr = objArr;
            r2 = 1;
        }
        this.e = i3;
        if (i3 != -1) {
            jArr[i3] = jArr[i3] | 4294967295L;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        gs gsVar = new gs(this);
        objectOutputStream.defaultWriteObject();
        for (int i = this.j; i != 0; i--) {
            objectOutputStream.writeObject(gsVar.next());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, com.google.android.libraries.navigation.internal.agi.hi
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ge listIterator() {
        return new gs(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: b */
    public final /* synthetic */ gi listIterator() {
        return new gs(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new hq(new gs(this), com.google.android.libraries.navigation.internal.agc.h.a(this), 81);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        if (this.j == 0) {
            return;
        }
        this.j = 0;
        this.c = false;
        Arrays.fill(this.a, (Object) null);
        this.e = -1;
        this.d = -1;
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Object obj2;
        if (obj == null) {
            return this.c;
        }
        Object[] objArr = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.b;
        Object obj3 = objArr[iE];
        if (obj3 == null) {
            return false;
        }
        if (!obj.equals(obj3)) {
            do {
                iE = (iE + 1) & this.b;
                obj2 = objArr[iE];
                if (obj2 == null) {
                    return false;
                }
            } while (!obj.equals(obj2));
        }
        return true;
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final gt clone() {
        try {
            gt gtVar = (gt) super.clone();
            gtVar.a = (Object[]) this.a.clone();
            gtVar.c = this.c;
            gtVar.f = (long[]) this.f.clone();
            return gtVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, java.util.SortedSet
    /* JADX INFO: renamed from: e */
    public final hi headSet(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, java.util.SortedSet
    /* JADX INFO: renamed from: f */
    public final hi subSet(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.SortedSet
    public final Object first() {
        if (this.j != 0) {
            return this.a[this.d];
        }
        throw new NoSuchElementException();
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        int i = this.d;
        while (i != -1) {
            int i2 = (int) this.f[i];
            consumer.accept(this.a[i]);
            i = i2;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, java.util.SortedSet
    /* JADX INFO: renamed from: g */
    public final hi tailSet(Object obj) {
        throw new UnsupportedOperationException();
    }

    protected final void h(int i) {
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

    @Override // com.google.android.libraries.navigation.internal.agi.u, java.util.Collection, java.util.Set
    public final int hashCode() {
        Object obj;
        int i = this.c ? this.j - 1 : this.j;
        int iHashCode = 0;
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i == 0) {
                return iHashCode;
            }
            do {
                obj = this.a[i2];
                i2++;
            } while (obj == null);
            if (this != obj) {
                iHashCode += obj.hashCode();
            }
            i = i3;
        }
    }

    protected final void i(int i, int i2) {
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.j == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: iterator */
    public final /* synthetic */ Iterator listIterator() {
        return new gs(this);
    }

    protected final void j(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        Object[] objArr = this.a;
        Object[] objArr2 = new Object[i4];
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
            Object obj = objArr[i5];
            if (obj != null) {
                int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode());
                while (true) {
                    i3 = iE & i2;
                    if (objArr2[i3] == null) {
                        break;
                    } else {
                        iE = i3 + 1;
                    }
                }
            } else {
                i3 = i;
            }
            objArr2[i3] = objArr[i5];
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
            objArr2 = objArr2;
            i5 = (int) jArr[i5];
            objArr = objArr;
        }
        Object[] objArr3 = objArr2;
        this.f = jArr2;
        this.e = i7;
        if (i7 != -1) {
            jArr2[i7] = jArr2[i7] | 4294967295L;
        }
        this.g = i;
        this.b = i2;
        this.h = com.google.android.libraries.navigation.internal.agc.e.d(i, this.k);
        this.a = objArr3;
    }

    protected final void k(int i) {
        Object obj;
        Object[] objArr = this.a;
        while (true) {
            int i2 = (i + 1) & this.b;
            while (true) {
                obj = objArr[i2];
                if (obj != null) {
                    int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode());
                    int i3 = this.b;
                    int i4 = iE & i3;
                    if (i > i2) {
                        if (i >= i4 && i4 > i2) {
                            break;
                        } else {
                            i2 = (i2 + 1) & i3;
                        }
                    } else if (i >= i4 || i4 > i2) {
                        break;
                    } else {
                        i2 = (i2 + 1) & i3;
                    }
                } else {
                    objArr[i] = null;
                    return;
                }
            }
            objArr[i] = obj;
            i(i2, i);
            i = i2;
        }
    }

    @Override // java.util.SortedSet
    public final Object last() {
        if (this.j != 0) {
            return this.a[this.e];
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Object obj2;
        if (obj == null) {
            if (!this.c) {
                return false;
            }
            this.c = false;
            Object[] objArr = this.a;
            int i = this.g;
            objArr[i] = null;
            this.j--;
            h(i);
            int i2 = this.g;
            if (i2 > this.i && this.j < this.h / 4 && i2 > 16) {
                j(i2 >> 1);
            }
            return true;
        }
        Object[] objArr2 = this.a;
        int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.b;
        Object obj3 = objArr2[iE];
        if (obj3 == null) {
            return false;
        }
        if (obj.equals(obj3)) {
            l(iE);
            return true;
        }
        do {
            iE = (iE + 1) & this.b;
            obj2 = objArr2[iE];
            if (obj2 == null) {
                return false;
            }
        } while (!obj.equals(obj2));
        l(iE);
        return true;
    }

    public final Object removeFirst() {
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
        Object[] objArr = this.a;
        Object obj = objArr[i2];
        this.j = i - 1;
        if (obj == null) {
            this.c = false;
            objArr[this.g] = null;
        } else {
            k(i2);
        }
        int i4 = this.g;
        if (i4 > this.i && this.j < this.h / 4 && i4 > 16) {
            j(i4 >> 1);
        }
        return obj;
    }

    public final Object removeLast() {
        int i = this.j;
        if (i == 0) {
            throw new NoSuchElementException();
        }
        int i2 = this.e;
        if (i == 1) {
            this.e = -1;
            this.d = -1;
        } else {
            long[] jArr = this.f;
            int i3 = (int) (jArr[i2] >>> 32);
            this.e = i3;
            if (i3 >= 0) {
                jArr[i3] = jArr[i3] | 4294967295L;
            }
        }
        Object[] objArr = this.a;
        Object obj = objArr[i2];
        this.j = i - 1;
        if (obj == null) {
            this.c = false;
            objArr[this.g] = null;
        } else {
            k(i2);
        }
        int i4 = this.g;
        if (i4 > this.i && this.j < this.h / 4 && i4 > 16) {
            j(i4 >> 1);
        }
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        if (this.k <= 0.5d) {
            int iA = com.google.android.libraries.navigation.internal.agc.e.a(collection.size(), this.k);
            if (iA > this.g) {
                j(iA);
            }
        } else {
            int iMin = (int) Math.min(1073741824L, Math.max(2L, com.google.android.libraries.navigation.internal.agc.e.h((long) Math.ceil((this.j + collection.size()) / this.k))));
            if (iMin > this.g) {
                j(iMin);
            }
        }
        return super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i;
        Object obj2;
        if (obj != null) {
            Object[] objArr = this.a;
            int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & this.b;
            Object obj3 = objArr[iE];
            if (obj3 != null) {
                if (!obj3.equals(obj)) {
                    do {
                        iE = (iE + 1) & this.b;
                        obj2 = objArr[iE];
                        if (obj2 != null) {
                        }
                    } while (!obj2.equals(obj));
                }
                return false;
            }
            objArr[iE] = obj;
            i = iE;
        } else {
            if (this.c) {
                return false;
            }
            i = this.g;
            this.c = true;
        }
        int i2 = this.j;
        if (i2 == 0) {
            this.e = i;
            this.d = i;
            this.f[i] = -1;
        } else {
            long[] jArr = this.f;
            int i3 = this.e;
            long j = jArr[i3];
            jArr[i3] = j ^ (((((long) i) & 4294967295L) ^ j) & 4294967295L);
            jArr[i] = ((((long) i3) & 4294967295L) << 32) | 4294967295L;
            this.e = i;
        }
        this.j = i2 + 1;
        if (i2 >= this.h) {
            j(com.google.android.libraries.navigation.internal.agc.e.a(i2 + 2, this.k));
        }
        return true;
    }
}
