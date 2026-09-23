package com.google.android.libraries.navigation.internal.agg;

import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dd extends k {
    private static final long serialVersionUID = -3185226345314976296L;
    final /* synthetic */ de d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected dd(de deVar, int i, int i2) {
        super(deVar, i, i2);
        this.d = deVar;
    }

    private final int[] N() {
        return this.d.a;
    }

    final int L(int[] iArr, int i, int i2) {
        int i3;
        if (this.d.a == iArr && this.b == i && this.c == i2) {
            return 0;
        }
        int i4 = this.b;
        while (true) {
            i3 = this.c;
            if (i4 >= i3 || i4 >= i2) {
                break;
            }
            int iCompare = Integer.compare(this.d.a[i4], iArr[i]);
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
        if (this.d.a == iArr && this.b == i && this.c == i2) {
            return true;
        }
        if (i2 - i != size()) {
            return false;
        }
        int i3 = this.b;
        while (i3 < this.c) {
            int i4 = i3 + 1;
            int i5 = i + 1;
            if (this.d.a[i3] != iArr[i]) {
                return false;
            }
            i = i5;
            i3 = i4;
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.n, com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    /* JADX INFO: renamed from: b */
    public final fh spliterator() {
        return new dc(this);
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
        if (obj instanceof de) {
            de deVar = (de) obj;
            return M(deVar.a, 0, deVar.b);
        }
        if (!(obj instanceof dd)) {
            return super.equals(obj);
        }
        dd ddVar = (dd) obj;
        return M(ddVar.N(), ddVar.b, ddVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.n, com.google.android.libraries.navigation.internal.agg.o, java.util.List
    public final /* synthetic */ ListIterator listIterator(int i) {
        return new db(this, i);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.n, com.google.android.libraries.navigation.internal.agg.es
    public final int n(int i) {
        G(i);
        return this.d.a[i + this.b];
    }

    @Override // com.google.android.libraries.navigation.internal.agg.n, com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.es
    /* JADX INFO: renamed from: q */
    public final eu listIterator(int i) {
        return new db(this, i);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.n, com.google.android.libraries.navigation.internal.agg.o, com.google.android.libraries.navigation.internal.agg.h, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return new dc(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.o
    /* JADX INFO: renamed from: w */
    public final int compareTo(List list) {
        if (list instanceof de) {
            de deVar = (de) list;
            return L(deVar.a, 0, deVar.b);
        }
        if (!(list instanceof dd)) {
            return super.compareTo(list);
        }
        dd ddVar = (dd) list;
        return L(ddVar.N(), ddVar.b, ddVar.c);
    }
}
