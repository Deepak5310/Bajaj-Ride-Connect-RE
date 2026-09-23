package com.google.android.libraries.navigation.internal.agj;

import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n extends d {
    private static final long serialVersionUID = -3185226345314976296L;
    final /* synthetic */ o d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected n(o oVar, int i, int i2) {
        super(oVar, i, i2);
        this.d = oVar;
    }

    private final short[] K() {
        return this.d.a;
    }

    final int I(short[] sArr, int i, int i2) {
        int i3;
        if (this.d.a == sArr && this.b == i && this.c == i2) {
            return 0;
        }
        int i4 = this.b;
        while (true) {
            i3 = this.c;
            if (i4 >= i3 || i4 >= i2) {
                break;
            }
            int iCompare = Short.compare(this.d.a[i4], sArr[i]);
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

    final boolean J(short[] sArr, int i, int i2) {
        if (this.d.a == sArr && this.b == i && this.c == i2) {
            return true;
        }
        if (i2 - i != size()) {
            return false;
        }
        int i3 = this.b;
        while (i3 < this.c) {
            int i4 = i3 + 1;
            int i5 = i + 1;
            if (this.d.a[i3] != sArr[i]) {
                return false;
            }
            i = i5;
            i3 = i4;
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.g, com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.a, com.google.android.libraries.navigation.internal.agj.u
    public final ay b() {
        return new m(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((List) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof List)) {
            return false;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            return J(oVar.a, 0, oVar.b);
        }
        if (!(obj instanceof n)) {
            return super.equals(obj);
        }
        n nVar = (n) obj;
        return J(nVar.K(), nVar.b, nVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.g, com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.am
    /* JADX INFO: renamed from: k */
    public final ao listIterator(int i) {
        return new l(this, i);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.g, com.google.android.libraries.navigation.internal.agj.am
    public final short l(int i) {
        D(i);
        return this.d.a[i + this.b];
    }

    @Override // com.google.android.libraries.navigation.internal.agj.g, com.google.android.libraries.navigation.internal.agj.h, java.util.List
    public final /* synthetic */ ListIterator listIterator(int i) {
        return new l(this, i);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.g, com.google.android.libraries.navigation.internal.agj.h, com.google.android.libraries.navigation.internal.agj.a, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return new m(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.h
    /* JADX INFO: renamed from: t */
    public final int compareTo(List list) {
        if (list instanceof o) {
            o oVar = (o) list;
            return I(oVar.a, 0, oVar.b);
        }
        if (!(list instanceof n)) {
            return super.compareTo(list);
        }
        n nVar = (n) list;
        return I(nVar.K(), nVar.b, nVar.c);
    }
}
