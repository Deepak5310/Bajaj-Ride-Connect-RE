package com.google.android.libraries.navigation.internal.agg;

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
public final class de extends o implements RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = -7046029254386353130L;
    public transient int[] a;
    public int b;

    public de() {
        this.a = di.b;
    }

    private final void N(int i) {
        int[] iArr = this.a;
        int length = iArr.length;
        if (i <= length) {
            return;
        }
        if (iArr != di.b) {
            i = (int) Math.max(Math.min(((long) length) + ((long) (length >> 1)), 2147483639L), i);
        } else if (i < 10) {
            i = 10;
        }
        int[] iArr2 = new int[i];
        System.arraycopy(iArr, 0, iArr2, 0, this.b);
        this.a = iArr2;
    }

    private static final int[] O(int[] iArr, int i) {
        return i == 0 ? di.a : Arrays.copyOf(iArr, i);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.a = new int[this.b];
        for (int i = 0; i < this.b; i++) {
            this.a[i] = objectInputStream.readInt();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        for (int i = 0; i < this.b; i++) {
            objectOutputStream.writeInt(this.a[i]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final void I(dt dtVar) {
        if (dtVar == null) {
            di.g(this.a, this.b);
        } else {
            di.f(this.a, this.b, dtVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final void K() {
        di.g(this.a, this.b);
    }

    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public final de clone() {
        if (getClass() == de.class) {
            de deVar = new de(O(this.a, this.b));
            deVar.b = this.b;
            return deVar;
        }
        try {
            de deVar2 = (de) super.clone();
            deVar2.a = O(this.a, this.b);
            return deVar2;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    public final int[] M(int[] iArr) {
        int length = iArr.length;
        int i = this.b;
        if (length < i) {
            iArr = Arrays.copyOf(iArr, i);
        }
        System.arraycopy(this.a, 0, iArr, 0, this.b);
        return iArr;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    /* JADX INFO: renamed from: b */
    public final fh spliterator() {
        return new da(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo, com.google.android.libraries.navigation.internal.agg.es
    public final boolean c(int i) {
        N(this.b + 1);
        int[] iArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        iArr[i2] = i;
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.b = 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((List) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof de)) {
            return obj instanceof dd ? ((dd) obj).equals(this) : super.equals(obj);
        }
        de deVar = (de) obj;
        if (deVar == this) {
            return true;
        }
        int i = this.b;
        int i2 = deVar.b;
        if (i == i2) {
            int[] iArr = this.a;
            int[] iArr2 = deVar.a;
            if (iArr == iArr2 && i == i2) {
                return true;
            }
            while (i != 0) {
                i--;
                if (iArr[i] != iArr2[i]) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    public final boolean h(int i) {
        int iX = x(i);
        if (iX == -1) {
            return false;
        }
        o(iX);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h
    public final boolean i(Cdo cdo) {
        int i;
        int[] iArr = this.a;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.b;
            if (i2 >= i) {
                break;
            }
            if (!cdo.f(iArr[i2])) {
                iArr[i3] = iArr[i2];
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

    @Override // com.google.android.libraries.navigation.internal.agg.o, java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return listIterator(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    /* JADX INFO: renamed from: m */
    public final es subList(int i, int i2) {
        if (i == 0) {
            if (i2 == this.b) {
                return this;
            }
            i = 0;
        }
        F(i);
        F(i2);
        if (i <= i2) {
            return new dd(this, i, i2);
        }
        throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Start index (", ") is greater than end index (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agg.es
    public final int n(int i) {
        int i2 = this.b;
        if (i < i2) {
            return this.a[i];
        }
        throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Index (", ") is greater than or equal to list size (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final int o(int i) {
        int i2 = this.b;
        if (i >= i2) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Index (", ") is greater than or equal to list size (", ")"));
        }
        int[] iArr = this.a;
        int i3 = iArr[i];
        int i4 = i2 - 1;
        this.b = i4;
        if (i != i4) {
            System.arraycopy(iArr, i + 1, iArr, i, i4 - i);
        }
        return i3;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final int p(int i, int i2) {
        int i3 = this.b;
        if (i >= i3) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i3, i, "Index (", ") is greater than or equal to list size (", ")"));
        }
        int[] iArr = this.a;
        int i4 = iArr[i];
        iArr[i] = i2;
        return i4;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    /* JADX INFO: renamed from: q */
    public final eu listIterator(int i) {
        F(i);
        return new cz(this, i);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final void r(int i, int i2) {
        F(i);
        N(this.b + 1);
        int i3 = this.b;
        if (i != i3) {
            int[] iArr = this.a;
            System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
        }
        this.a[i] = i2;
        this.b++;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final void s(int i, int[] iArr, int i2, int i3) {
        di.a(iArr, i2, i3);
        System.arraycopy(this.a, i, iArr, i2, i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.h, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return new da(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final void t(int i, int i2) {
        com.google.android.libraries.navigation.internal.agc.a.a(this.b, i, i2);
        int[] iArr = this.a;
        System.arraycopy(iArr, i2, iArr, i, this.b - i2);
        this.b -= i2 - i;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o
    public final boolean u(int i, Cdo cdo) {
        if (cdo instanceof es) {
            es esVar = (es) cdo;
            F(i);
            int size = esVar.size();
            if (size == 0) {
                return false;
            }
            N(this.b + size);
            int[] iArr = this.a;
            System.arraycopy(iArr, i, iArr, i + size, this.b - i);
            esVar.s(0, this.a, i, size);
            this.b += size;
            return true;
        }
        F(i);
        int size2 = cdo.size();
        if (size2 == 0) {
            return false;
        }
        N(this.b + size2);
        int[] iArr2 = this.a;
        System.arraycopy(iArr2, i, iArr2, i + size2, this.b - i);
        ei it2 = cdo.iterator();
        this.b += size2;
        while (size2 != 0) {
            size2--;
            this.a[i] = it2.nextInt();
            i++;
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final void v(int i, int[] iArr, int i2) {
        F(i);
        di.a(iArr, 0, i2);
        int i3 = i + i2;
        int i4 = this.b;
        if (i3 > i4) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i4, i3, "End index (", ") is greater than list size (", ")"));
        }
        System.arraycopy(iArr, 0, this.a, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o
    /* JADX INFO: renamed from: w */
    public final int compareTo(List list) {
        if (!(list instanceof de)) {
            return list instanceof dd ? -((dd) list).compareTo(this) : super.compareTo(list);
        }
        de deVar = (de) list;
        int i = this.b;
        int i2 = deVar.b;
        int[] iArr = this.a;
        int[] iArr2 = deVar.a;
        if (iArr == iArr2 && i == i2) {
            return 0;
        }
        int i3 = 0;
        while (i3 < i && i3 < i2) {
            int iCompare = Integer.compare(iArr[i3], iArr2[i3]);
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

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final int x(int i) {
        for (int i2 = 0; i2 < this.b; i2++) {
            if (i == this.a[i2]) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final int y(int i) {
        int i2 = this.b;
        while (i2 != 0) {
            i2--;
            if (i == this.a[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public de(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.j(i, "Initial capacity (", ") is negative"));
        }
        if (i == 0) {
            this.a = di.a;
        } else {
            this.a = new int[i];
        }
    }

    protected de(int[] iArr) {
        this.a = iArr;
    }
}
