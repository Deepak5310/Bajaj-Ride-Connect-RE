package com.google.android.libraries.navigation.internal.agh;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fv extends u implements RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = -7046029254386353130L;
    protected transient long[] a;
    protected int b;

    public fv() {
        this.a = fz.b;
    }

    private final void L(int i) {
        long[] jArr = this.a;
        int length = jArr.length;
        if (i <= length) {
            return;
        }
        if (jArr != fz.b) {
            i = (int) Math.max(Math.min(((long) length) + ((long) (length >> 1)), 2147483639L), i);
        } else if (i < 10) {
            i = 10;
        }
        long[] jArr2 = new long[i];
        System.arraycopy(jArr, 0, jArr2, 0, this.b);
        this.a = jArr2;
    }

    private static final long[] M(long[] jArr, int i) {
        return i == 0 ? fz.a : Arrays.copyOf(jArr, i);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.a = new long[this.b];
        for (int i = 0; i < this.b; i++) {
            this.a[i] = objectInputStream.readLong();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        for (int i = 0; i < this.b; i++) {
            objectOutputStream.writeLong(this.a[i]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.gy
    public final void H(gk gkVar) {
        if (gkVar == null) {
            fz.g(this.a, this.b);
        } else {
            fz.f(this.a, this.b, gkVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.gy
    public final void J() {
        fz.g(this.a, this.b);
    }

    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public final fv clone() {
        if (getClass() == fv.class) {
            fv fvVar = new fv(M(this.a, this.b));
            fvVar.b = this.b;
            return fvVar;
        }
        try {
            fv fvVar2 = (fv) super.clone();
            fvVar2.a = M(this.a, this.b);
            return fvVar2;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf, com.google.android.libraries.navigation.internal.agh.he
    /* JADX INFO: renamed from: b */
    public final hl spliterator() {
        return new fr(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf
    public final boolean c(long j) {
        L(this.b + 1);
        long[] jArr = this.a;
        int i = this.b;
        this.b = i + 1;
        jArr[i] = j;
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.b = 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((List) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof fv)) {
            return obj instanceof fu ? ((fu) obj).equals(this) : super.equals(obj);
        }
        fv fvVar = (fv) obj;
        if (fvVar == this) {
            return true;
        }
        int i = this.b;
        int i2 = fvVar.b;
        if (i == i2) {
            long[] jArr = this.a;
            long[] jArr2 = fvVar.a;
            if (jArr == jArr2 && i == i2) {
                return true;
            }
            while (i != 0) {
                i--;
                if (jArr[i] != jArr2[i]) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf
    public final boolean g(long j) {
        int iW = w(j);
        if (iW == -1) {
            return false;
        }
        n(iW);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n
    public final boolean h(gf gfVar) {
        int i;
        long[] jArr = this.a;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.b;
            if (i2 >= i) {
                break;
            }
            if (!gfVar.e(jArr[i2])) {
                jArr[i3] = jArr[i2];
                i3++;
            }
            i2++;
        }
        boolean z = i != i3;
        this.b = i3;
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.b == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u
    /* JADX INFO: renamed from: l */
    public final gy subList(int i, int i2) {
        if (i == 0) {
            if (i2 == this.b) {
                return this;
            }
            i = 0;
        }
        E(i);
        E(i2);
        if (i <= i2) {
            return new fu(this, i, i2);
        }
        throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Start index (", ") is greater than end index (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return listIterator(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gy
    public final long m(int i) {
        int i2 = this.b;
        if (i < i2) {
            return this.a[i];
        }
        throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Index (", ") is greater than or equal to list size (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.gy
    public final long n(int i) {
        int i2 = this.b;
        if (i >= i2) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Index (", ") is greater than or equal to list size (", ")"));
        }
        long[] jArr = this.a;
        long j = jArr[i];
        int i3 = i2 - 1;
        this.b = i3;
        if (i != i3) {
            System.arraycopy(jArr, i + 1, jArr, i, i3 - i);
        }
        return j;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.gy
    public final long o(int i, long j) {
        int i2 = this.b;
        if (i >= i2) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Index (", ") is greater than or equal to list size (", ")"));
        }
        long[] jArr = this.a;
        long j2 = jArr[i];
        jArr[i] = j;
        return j2;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.gy
    /* JADX INFO: renamed from: p */
    public final ha listIterator(int i) {
        E(i);
        return new fq(this, i);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.gy
    public final void q(int i, long j) {
        E(i);
        L(this.b + 1);
        int i2 = this.b;
        if (i != i2) {
            long[] jArr = this.a;
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        }
        this.a[i] = j;
        this.b++;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.gy
    public final void r(int i, long[] jArr, int i2, int i3) {
        fz.a(jArr, i2, i3);
        System.arraycopy(this.a, i, jArr, i2, i3);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.gy
    public final void s(int i, int i2) {
        com.google.android.libraries.navigation.internal.agc.a.a(this.b, i, i2);
        long[] jArr = this.a;
        System.arraycopy(jArr, i2, jArr, i, this.b - i2);
        this.b -= i2 - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.n, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Spliterator spliterator() {
        return new fr(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u
    public final boolean t(int i, gf gfVar) {
        if (gfVar instanceof gy) {
            gy gyVar = (gy) gfVar;
            E(i);
            int size = gyVar.size();
            if (size == 0) {
                return false;
            }
            L(this.b + size);
            long[] jArr = this.a;
            System.arraycopy(jArr, i, jArr, i + size, this.b - i);
            gyVar.r(0, this.a, i, size);
            this.b += size;
            return true;
        }
        E(i);
        int size2 = gfVar.size();
        if (size2 == 0) {
            return false;
        }
        L(this.b + size2);
        long[] jArr2 = this.a;
        System.arraycopy(jArr2, i, jArr2, i + size2, this.b - i);
        gs gsVarM = gfVar.m();
        this.b += size2;
        while (size2 != 0) {
            size2--;
            this.a[i] = gsVarM.nextLong();
            i++;
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.gy
    public final void u(int i, long[] jArr, int i2) {
        E(i);
        fz.a(jArr, 0, i2);
        int i3 = i + i2;
        int i4 = this.b;
        if (i3 > i4) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i4, i3, "End index (", ") is greater than list size (", ")"));
        }
        System.arraycopy(jArr, 0, this.a, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u
    /* JADX INFO: renamed from: v */
    public final int compareTo(List list) {
        if (!(list instanceof fv)) {
            return list instanceof fu ? -((fu) list).compareTo(this) : super.compareTo(list);
        }
        fv fvVar = (fv) list;
        int i = this.b;
        int i2 = fvVar.b;
        long[] jArr = this.a;
        long[] jArr2 = fvVar.a;
        if (jArr == jArr2 && i == i2) {
            return 0;
        }
        int i3 = 0;
        while (i3 < i && i3 < i2) {
            int iCompare = Long.compare(jArr[i3], jArr2[i3]);
            if (iCompare != 0) {
                return iCompare;
            }
            i3++;
        }
        if (i3 < i2) {
            return -1;
        }
        return i3 < i ? 1 : 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.gy
    public final int w(long j) {
        for (int i = 0; i < this.b; i++) {
            if (j == this.a[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.gy
    public final int x(long j) {
        int i = this.b;
        while (i != 0) {
            i--;
            if (j == this.a[i]) {
                return i;
            }
        }
        return -1;
    }

    public fv(int i) {
        this.a = new long[i];
    }

    protected fv(long[] jArr) {
        this.a = jArr;
    }
}
