package com.google.android.libraries.navigation.internal.ael;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends f implements RandomAccess, bk, dh {
    public static final m a;
    private static final boolean[] c;
    public int b;
    private boolean[] d;

    static {
        boolean[] zArr = new boolean[0];
        c = zArr;
        a = new m(zArr, 0, false);
    }

    m() {
        this(c, 0, true);
    }

    private static int h(int i) {
        return Math.max(((i * 3) / 2) + 1, 10);
    }

    private final String i(int i) {
        return "Index:" + i + ", Size:" + this.b;
    }

    private final void j(int i) {
        if (i < 0 || i >= this.b) {
            throw new IndexOutOfBoundsException(i(i));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.f, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        aK();
        if (i < 0 || i > (i2 = this.b)) {
            throw new IndexOutOfBoundsException(i(i));
        }
        int i3 = i + 1;
        boolean[] zArr = this.d;
        int length = zArr.length;
        if (i2 < length) {
            System.arraycopy(zArr, i, zArr, i3, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[h(length)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.d, i, zArr2, i3, this.b - i);
            this.d = zArr2;
        }
        this.d[i] = zBooleanValue;
        this.b++;
        this.modCount++;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.f, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        aK();
        ca.e(collection);
        if (!(collection instanceof m)) {
            return super.addAll(collection);
        }
        m mVar = (m) collection;
        int i = mVar.b;
        if (i == 0) {
            return false;
        }
        int i2 = this.b;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        boolean[] zArr = this.d;
        if (i3 > zArr.length) {
            this.d = Arrays.copyOf(zArr, i3);
        }
        System.arraycopy(mVar.d, 0, this.d, this.b, mVar.b);
        this.b = i3;
        this.modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bz
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final bk e(int i) {
        if (i >= this.b) {
            return new m(i == 0 ? c : Arrays.copyOf(this.d, i), this.b, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.f, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return super.equals(obj);
        }
        m mVar = (m) obj;
        if (this.b != mVar.b) {
            return false;
        }
        boolean[] zArr = mVar.d;
        for (int i = 0; i < this.b; i++) {
            if (this.d[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final void f(boolean z) {
        aK();
        int i = this.b;
        boolean[] zArr = this.d;
        int length = zArr.length;
        if (i == length) {
            boolean[] zArr2 = new boolean[h(length)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.d = zArr2;
        }
        boolean[] zArr3 = this.d;
        int i2 = this.b;
        this.b = i2 + 1;
        zArr3[i2] = z;
    }

    public final boolean g(int i) {
        j(i);
        return this.d[i];
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return Boolean.valueOf(g(i));
    }

    @Override // com.google.android.libraries.navigation.internal.ael.f, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iA = 1;
        for (int i = 0; i < this.b; i++) {
            iA = (iA * 31) + ca.a(this.d[i]);
        }
        return iA;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i = this.b;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.d[i2] == zBooleanValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.f, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        aK();
        j(i);
        boolean[] zArr = this.d;
        boolean z = zArr[i];
        int i2 = this.b;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.b--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        aK();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.d;
        System.arraycopy(zArr, i2, zArr, i, this.b - i2);
        this.b -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.f, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        aK();
        j(i);
        boolean[] zArr = this.d;
        boolean z = zArr[i];
        zArr[i] = zBooleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    private m(boolean[] zArr, int i, boolean z) {
        super(z);
        this.d = zArr;
        this.b = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.f, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        f(((Boolean) obj).booleanValue());
        return true;
    }
}
