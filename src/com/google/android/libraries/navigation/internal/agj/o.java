package com.google.android.libraries.navigation.internal.agj;

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
public final class o extends h implements RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = -7046029254386353130L;
    public transient short[] a;
    public int b;

    public o() {
        this.a = p.b;
    }

    private final void J(int i) {
        short[] sArr = this.a;
        int length = sArr.length;
        if (i <= length) {
            return;
        }
        if (sArr != p.b) {
            i = (int) Math.max(Math.min(((long) length) + ((long) (length >> 1)), 2147483639L), i);
        } else if (i < 10) {
            i = 10;
        }
        short[] sArr2 = new short[i];
        System.arraycopy(sArr, 0, sArr2, 0, this.b);
        this.a = sArr2;
    }

    private static final short[] K(short[] sArr, int i) {
        return i == 0 ? p.a : Arrays.copyOf(sArr, i);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.a = new short[this.b];
        for (int i = 0; i < this.b; i++) {
            this.a[i] = objectInputStream.readShort();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        for (int i = 0; i < this.b; i++) {
            objectOutputStream.writeShort(this.a[i]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.am
    public final void F(x xVar) {
        if (xVar == null) {
            p.g(this.a, this.b);
        } else {
            p.f(this.a, this.b, xVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.am
    public final void H() {
        p.g(this.a, this.b);
    }

    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public final o clone() {
        if (getClass() == o.class) {
            o oVar = new o(K(this.a, this.b));
            oVar.b = this.b;
            return oVar;
        }
        try {
            o oVar2 = (o) super.clone();
            oVar2.a = K(this.a, this.b);
            return oVar2;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.a, com.google.android.libraries.navigation.internal.agj.u
    public final ay b() {
        return new k(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.b = 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((List) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.a, com.google.android.libraries.navigation.internal.agj.u
    public final boolean e(short s) {
        int iU = u(s);
        if (iU == -1) {
            return false;
        }
        m(iU);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof o)) {
            return obj instanceof n ? ((n) obj).equals(this) : super.equals(obj);
        }
        o oVar = (o) obj;
        if (oVar == this) {
            return true;
        }
        int i = this.b;
        int i2 = oVar.b;
        if (i == i2) {
            short[] sArr = this.a;
            short[] sArr2 = oVar.a;
            if (sArr == sArr2 && i == i2) {
                return true;
            }
            while (i != 0) {
                i--;
                if (sArr[i] != sArr2[i]) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.a
    public final boolean f(u uVar) {
        int i;
        short[] sArr = this.a;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.b;
            if (i2 >= i) {
                break;
            }
            if (!uVar.d(sArr[i2])) {
                sArr[i3] = sArr[i2];
                i3++;
            }
            i2++;
        }
        boolean z = i != i3;
        this.b = i3;
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.a, com.google.android.libraries.navigation.internal.agj.u
    public final void i(short s) {
        J(this.b + 1);
        short[] sArr = this.a;
        int i = this.b;
        this.b = i + 1;
        sArr[i] = s;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.b == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h
    /* JADX INFO: renamed from: j */
    public final am subList(int i, int i2) {
        if (i == 0) {
            if (i2 == this.b) {
                return this;
            }
            i = 0;
        }
        C(i);
        C(i2);
        if (i <= i2) {
            return new n(this, i, i2);
        }
        throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Start index (", ") is greater than end index (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.am
    /* JADX INFO: renamed from: k */
    public final ao listIterator(int i) {
        C(i);
        return new j(this, i);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.am
    public final short l(int i) {
        int i2 = this.b;
        if (i < i2) {
            return this.a[i];
        }
        throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Index (", ") is greater than or equal to list size (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return listIterator(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.am
    public final short m(int i) {
        int i2 = this.b;
        if (i >= i2) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Index (", ") is greater than or equal to list size (", ")"));
        }
        short[] sArr = this.a;
        short s = sArr[i];
        int i3 = i2 - 1;
        this.b = i3;
        if (i != i3) {
            System.arraycopy(sArr, i + 1, sArr, i, i3 - i);
        }
        return s;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.am
    public final short n(int i, short s) {
        int i2 = this.b;
        if (i >= i2) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Index (", ") is greater than or equal to list size (", ")"));
        }
        short[] sArr = this.a;
        short s2 = sArr[i];
        sArr[i] = s;
        return s2;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.am
    public final void o(int i, short s) {
        C(i);
        J(this.b + 1);
        int i2 = this.b;
        if (i != i2) {
            short[] sArr = this.a;
            System.arraycopy(sArr, i, sArr, i + 1, i2 - i);
        }
        this.a[i] = s;
        this.b++;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.am
    public final void p(int i, short[] sArr, int i2, int i3) {
        p.a(sArr, i2, i3);
        System.arraycopy(this.a, i, sArr, i2, i3);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.am
    public final void q(int i, int i2) {
        com.google.android.libraries.navigation.internal.agc.a.a(this.b, i, i2);
        short[] sArr = this.a;
        System.arraycopy(sArr, i2, sArr, i, this.b - i2);
        this.b -= i2 - i;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h
    public final boolean r(int i, u uVar) {
        if (uVar instanceof am) {
            am amVar = (am) uVar;
            C(i);
            int size = amVar.size();
            if (size == 0) {
                return false;
            }
            J(this.b + size);
            short[] sArr = this.a;
            System.arraycopy(sArr, i, sArr, i + size, this.b - i);
            amVar.p(0, this.a, i, size);
            this.b += size;
            return true;
        }
        C(i);
        int size2 = uVar.size();
        if (size2 == 0) {
            return false;
        }
        J(this.b + size2);
        short[] sArr2 = this.a;
        System.arraycopy(sArr2, i, sArr2, i + size2, this.b - i);
        aj it2 = uVar.iterator();
        this.b += size2;
        while (size2 != 0) {
            size2--;
            this.a[i] = it2.d();
            i++;
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.am
    public final void s(int i, short[] sArr, int i2) {
        C(i);
        p.a(sArr, 0, i2);
        int i3 = i + i2;
        int i4 = this.b;
        if (i3 > i4) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i4, i3, "End index (", ") is greater than list size (", ")"));
        }
        System.arraycopy(sArr, 0, this.a, i, i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.a, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return new k(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h
    /* JADX INFO: renamed from: t */
    public final int compareTo(List list) {
        if (!(list instanceof o)) {
            return list instanceof n ? -((n) list).compareTo(this) : super.compareTo(list);
        }
        o oVar = (o) list;
        int i = this.b;
        int i2 = oVar.b;
        short[] sArr = this.a;
        short[] sArr2 = oVar.a;
        if (sArr == sArr2 && i == i2) {
            return 0;
        }
        int i3 = 0;
        while (i3 < i && i3 < i2) {
            int iCompare = Short.compare(sArr[i3], sArr2[i3]);
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

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.am
    public final int u(short s) {
        for (int i = 0; i < this.b; i++) {
            if (s == this.a[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.am
    public final int v(short s) {
        int i = this.b;
        while (i != 0) {
            i--;
            if (s == this.a[i]) {
                return i;
            }
        }
        return -1;
    }

    public o(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.j(i, "Initial capacity (", ") is negative"));
        }
        if (i == 0) {
            this.a = p.a;
        } else {
            this.a = new short[i];
        }
    }

    protected o(short[] sArr) {
        this.a = sArr;
    }
}
