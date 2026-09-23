package com.google.android.libraries.navigation.internal.agg;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ed extends ev implements RandomAccess, Serializable {
    private static final long serialVersionUID = 7054639518438982401L;
    final ef a;
    final int b;
    final int c;
    final transient int[] d;

    public ed(ef efVar, int i, int i2) {
        this.a = efVar;
        this.b = i;
        this.c = i2;
        int i3 = ef.c;
        this.d = efVar.b;
    }

    private Object readResolve() throws ObjectStreamException {
        try {
            return this.a.subList(this.b, this.c);
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
        }
    }

    final int L(int[] iArr, int i, int i2) {
        int i3;
        if (this.d == iArr && this.b == i && this.c == i2) {
            return 0;
        }
        int i4 = this.b;
        while (true) {
            i3 = this.c;
            if (i4 >= i3 || i4 >= i2) {
                break;
            }
            int iCompare = Integer.compare(this.d[i4], iArr[i]);
            if (iCompare != 0) {
                return iCompare;
            }
            i4++;
            i++;
        }
        if (i4 < i2) {
            return -1;
        }
        return i4 >= i3 ? 0 : 1;
    }

    final boolean M(int[] iArr, int i, int i2) {
        if (this.d == iArr && this.b == i && this.c == i2) {
            return true;
        }
        if (i2 - i != size()) {
            return false;
        }
        int i3 = this.b;
        while (i3 < this.c) {
            int i4 = i3 + 1;
            int i5 = i + 1;
            if (this.d[i3] != iArr[i]) {
                return false;
            }
            i3 = i4;
            i = i5;
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    /* JADX INFO: renamed from: b */
    public final fh spliterator() {
        return new ec(this);
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
        if (obj instanceof ef) {
            ef efVar = (ef) obj;
            return M(efVar.b, 0, efVar.size());
        }
        if (!(obj instanceof ed)) {
            return super.equals(obj);
        }
        ed edVar = (ed) obj;
        return M(edVar.d, edVar.b, edVar.c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.c <= this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    public final int[] l() {
        return Arrays.copyOfRange(this.d, this.b, this.c);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return listIterator(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    /* JADX INFO: renamed from: m */
    public final es subList(int i, int i2) {
        F(i);
        F(i2);
        if (i == i2) {
            return ef.a;
        }
        if (i > i2) {
            throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.k(i2, i, "Start index (", ") is greater than end index (", ")"));
        }
        ef efVar = this.a;
        int i3 = this.b;
        return new ed(efVar, i + i3, i2 + i3);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.es
    public final int n(int i) {
        G(i);
        return this.d[i + this.b];
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    /* JADX INFO: renamed from: q */
    public final eu listIterator(int i) {
        G(this.b + i);
        return new eb(this, i);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final void s(int i, int[] iArr, int i2, int i3) {
        di.a(iArr, i2, i3);
        G(i);
        int i4 = this.b;
        int i5 = i4 + i3;
        if (i5 <= this.c) {
            System.arraycopy(this.d, i + i4, iArr, i2, i3);
            return;
        }
        throw new IndexOutOfBoundsException("Final index " + i5 + " (startingIndex: " + i4 + " + length: " + i3 + ") is greater then list length " + size());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c - this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.h, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return new ec(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o
    /* JADX INFO: renamed from: w */
    public final int compareTo(List list) {
        if (list instanceof ef) {
            ef efVar = (ef) list;
            int i = ef.c;
            return L(efVar.b, 0, efVar.size());
        }
        if (!(list instanceof ed)) {
            return super.compareTo(list);
        }
        ed edVar = (ed) list;
        return L(edVar.d, edVar.b, edVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final int x(int i) {
        for (int i2 = this.b; i2 < this.c; i2++) {
            if (i == this.d[i2]) {
                return i2 - this.b;
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    public final int y(int i) {
        int i2;
        int i3 = this.c;
        do {
            i2 = this.b;
            if (i3 == i2) {
                return -1;
            }
            i3--;
        } while (i != this.d[i3]);
        return i3 - i2;
    }
}
