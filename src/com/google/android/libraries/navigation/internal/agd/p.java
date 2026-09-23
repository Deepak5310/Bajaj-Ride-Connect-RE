package com.google.android.libraries.navigation.internal.agd;

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
public final class p extends h implements RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = -7046029254386353130L;
    protected transient byte[] a;
    protected int b;

    public p() {
        this.a = q.b;
    }

    private final void K(int i) {
        byte[] bArr = this.a;
        int length = bArr.length;
        if (i <= length) {
            return;
        }
        if (bArr != q.b) {
            i = (int) Math.max(Math.min(((long) length) + ((long) (length >> 1)), 2147483639L), i);
        } else if (i < 10) {
            i = 10;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, this.b);
        this.a = bArr2;
    }

    private static final byte[] L(byte[] bArr, int i) {
        return i == 0 ? q.a : Arrays.copyOf(bArr, i);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.a = new byte[this.b];
        for (int i = 0; i < this.b; i++) {
            this.a[i] = objectInputStream.readByte();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        for (int i = 0; i < this.b; i++) {
            objectOutputStream.writeByte(this.a[i]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.ao
    public final void G(z zVar) {
        if (zVar == null) {
            q.d(this.a, this.b);
        } else {
            q.c(this.a, this.b, zVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.ao
    public final void I() {
        q.d(this.a, this.b);
    }

    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final p clone() {
        if (getClass() == p.class) {
            p pVar = new p(L(this.a, this.b), null);
            pVar.b = this.b;
            return pVar;
        }
        try {
            p pVar2 = (p) super.clone();
            pVar2.a = L(this.a, this.b);
            return pVar2;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.a, com.google.android.libraries.navigation.internal.agd.w
    public final be b() {
        return new l(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.a, com.google.android.libraries.navigation.internal.agd.w
    public final boolean c(byte b) {
        K(this.b + 1);
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b;
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.b = 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((List) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof p)) {
            return obj instanceof o ? ((o) obj).equals(this) : super.equals(obj);
        }
        p pVar = (p) obj;
        if (pVar == this) {
            return true;
        }
        int i = this.b;
        int i2 = pVar.b;
        if (i == i2) {
            byte[] bArr = this.a;
            byte[] bArr2 = pVar.a;
            if (bArr == bArr2 && i == i2) {
                return true;
            }
            while (i != 0) {
                i--;
                if (bArr[i] != bArr2[i]) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.a, com.google.android.libraries.navigation.internal.agd.w
    public final boolean g(byte b) {
        int iV = v(b);
        if (iV == -1) {
            return false;
        }
        m(iV);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.a
    public final boolean h(w wVar) {
        int i;
        byte[] bArr = this.a;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.b;
            if (i2 >= i) {
                break;
            }
            if (!wVar.e(bArr[i2])) {
                bArr[i3] = bArr[i2];
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

    @Override // com.google.android.libraries.navigation.internal.agd.h
    /* JADX INFO: renamed from: k */
    public final ao subList(int i, int i2) {
        if (i == 0) {
            if (i2 == this.b) {
                return this;
            }
            i = 0;
        }
        D(i);
        D(i2);
        if (i <= i2) {
            return new o(this, i, i2);
        }
        throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Start index (", ") is greater than end index (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agd.ao
    public final byte l(int i) {
        int i2 = this.b;
        if (i < i2) {
            return this.a[i];
        }
        throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Index (", ") is greater than or equal to list size (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return listIterator(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.ao
    public final byte m(int i) {
        int i2 = this.b;
        if (i >= i2) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Index (", ") is greater than or equal to list size (", ")"));
        }
        byte[] bArr = this.a;
        byte b = bArr[i];
        int i3 = i2 - 1;
        this.b = i3;
        if (i != i3) {
            System.arraycopy(bArr, i + 1, bArr, i, i3 - i);
        }
        return b;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.ao
    public final byte n(int i, byte b) {
        int i2 = this.b;
        if (i >= i2) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Index (", ") is greater than or equal to list size (", ")"));
        }
        byte[] bArr = this.a;
        byte b2 = bArr[i];
        bArr[i] = b;
        return b2;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.ao
    /* JADX INFO: renamed from: o */
    public final aq listIterator(int i) {
        D(i);
        return new k(this, i);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.ao
    public final void p(int i, byte b) {
        D(i);
        K(this.b + 1);
        int i2 = this.b;
        if (i != i2) {
            byte[] bArr = this.a;
            System.arraycopy(bArr, i, bArr, i + 1, i2 - i);
        }
        this.a[i] = b;
        this.b++;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.ao
    public final void q(int i, byte[] bArr, int i2, int i3) {
        q.a(bArr, i2, i3);
        System.arraycopy(this.a, i, bArr, i2, i3);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.ao
    public final void r(int i, int i2) {
        com.google.android.libraries.navigation.internal.agc.a.a(this.b, i, i2);
        byte[] bArr = this.a;
        System.arraycopy(bArr, i2, bArr, i, this.b - i2);
        this.b -= i2 - i;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h
    public final boolean s(int i, w wVar) {
        if (wVar instanceof ao) {
            ao aoVar = (ao) wVar;
            D(i);
            int size = aoVar.size();
            if (size == 0) {
                return false;
            }
            K(this.b + size);
            byte[] bArr = this.a;
            System.arraycopy(bArr, i, bArr, i + size, this.b - i);
            aoVar.q(0, this.a, i, size);
            this.b += size;
            return true;
        }
        D(i);
        int size2 = wVar.size();
        if (size2 == 0) {
            return false;
        }
        K(this.b + size2);
        byte[] bArr2 = this.a;
        System.arraycopy(bArr2, i, bArr2, i + size2, this.b - i);
        al it2 = wVar.iterator();
        this.b += size2;
        while (size2 != 0) {
            size2--;
            this.a[i] = it2.c();
            i++;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.a, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return new l(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.ao
    public final void t(int i, byte[] bArr, int i2) {
        D(i);
        q.a(bArr, 0, i2);
        int i3 = i + i2;
        int i4 = this.b;
        if (i3 > i4) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i4, i3, "End index (", ") is greater than list size (", ")"));
        }
        System.arraycopy(bArr, 0, this.a, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h
    /* JADX INFO: renamed from: u */
    public final int compareTo(List list) {
        if (!(list instanceof p)) {
            return list instanceof o ? -((o) list).compareTo(this) : super.compareTo(list);
        }
        p pVar = (p) list;
        int i = this.b;
        int i2 = pVar.b;
        byte[] bArr = this.a;
        byte[] bArr2 = pVar.a;
        if (bArr == bArr2 && i == i2) {
            return 0;
        }
        int i3 = 0;
        while (i3 < i && i3 < i2) {
            int iCompare = Byte.compare(bArr[i3], bArr2[i3]);
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

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.ao
    public final int v(byte b) {
        for (int i = 0; i < this.b; i++) {
            if (b == this.a[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.ao
    public final int w(byte b) {
        int i = this.b;
        while (i != 0) {
            i--;
            if (b == this.a[i]) {
                return i;
            }
        }
        return -1;
    }

    public p(byte[] bArr) {
        this.a = new byte[2];
    }

    protected p(byte[] bArr, byte[] bArr2) {
        this.a = bArr;
    }
}
