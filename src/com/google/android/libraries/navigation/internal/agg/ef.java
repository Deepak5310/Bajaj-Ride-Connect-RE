package com.google.android.libraries.navigation.internal.agg;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ef extends ev implements RandomAccess, Cloneable, Serializable, es {
    static final ef a = new ef(di.a);
    public static final /* synthetic */ int c = 0;
    private static final long serialVersionUID = 0;
    public final int[] b;

    public ef(int[] iArr) {
        this.b = iArr;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    /* JADX INFO: renamed from: b */
    public final fh spliterator() {
        return new ee(this);
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this;
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
        if (!(obj instanceof ef)) {
            return obj instanceof ed ? ((ed) obj).equals(this) : super.equals(obj);
        }
        ef efVar = (ef) obj;
        if (efVar == this || this.b == efVar.b) {
            return true;
        }
        if (size() != efVar.size()) {
            return false;
        }
        return Arrays.equals(this.b, efVar.b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.b.length == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    public final int[] l() {
        int[] iArr = this.b;
        return iArr.length == 0 ? di.a : (int[]) iArr.clone();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return listIterator(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    /* JADX INFO: renamed from: m */
    public final es subList(int i, int i2) {
        if (i == 0) {
            if (i2 == size()) {
                return this;
            }
            i = 0;
        }
        F(i);
        F(i2);
        if (i == i2) {
            return a;
        }
        if (i <= i2) {
            return new ed(this, i, i2);
        }
        throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Start index (", ") is greater than end index (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agg.es
    public final int n(int i) {
        int[] iArr = this.b;
        int length = iArr.length;
        if (i < length) {
            return iArr[i];
        }
        throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(length, i, "Index (", ") is greater than or equal to list size (", ")"));
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    /* JADX INFO: renamed from: q */
    public final eu listIterator(int i) {
        F(i);
        return new ea(this, i);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final void s(int i, int[] iArr, int i2, int i3) {
        di.a(iArr, i2, i3);
        System.arraycopy(this.b, i, iArr, i2, i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b.length;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.h, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return new ee(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o
    /* JADX INFO: renamed from: w */
    public final int compareTo(List list) {
        if (!(list instanceof ef)) {
            return list instanceof ed ? -((ed) list).compareTo(this) : super.compareTo(list);
        }
        ef efVar = (ef) list;
        if (this.b == efVar.b) {
            return 0;
        }
        int size = size();
        int size2 = efVar.size();
        int[] iArr = this.b;
        int[] iArr2 = efVar.b;
        int i = 0;
        while (i < size && i < size2) {
            int iCompare = Integer.compare(iArr[i], iArr2[i]);
            if (iCompare != 0) {
                return iCompare;
            }
            i++;
        }
        if (i < size2) {
            return -1;
        }
        return i < size ? 1 : 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final int x(int i) {
        int length = this.b.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i == this.b[i2]) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final int y(int i) {
        int length = this.b.length;
        while (length != 0) {
            length--;
            if (i == this.b[length]) {
                return length;
            }
        }
        return -1;
    }
}
