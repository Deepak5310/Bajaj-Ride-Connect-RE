package com.google.android.libraries.navigation.internal.agd;

import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class o extends c {
    private static final long serialVersionUID = -3185226345314976296L;
    final /* synthetic */ p d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected o(p pVar, int i, int i2) {
        super(pVar, i, i2);
        this.d = pVar;
    }

    private final byte[] L() {
        return this.d.a;
    }

    final int J(byte[] bArr, int i, int i2) {
        int i3;
        if (this.d.a == bArr && this.b == i && this.c == i2) {
            return 0;
        }
        int i4 = this.b;
        while (true) {
            i3 = this.c;
            if (i4 >= i3 || i4 >= i2) {
                break;
            }
            int iCompare = Byte.compare(this.d.a[i4], bArr[i]);
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

    final boolean K(byte[] bArr, int i, int i2) {
        if (this.d.a == bArr && this.b == i && this.c == i2) {
            return true;
        }
        if (i2 - i != size()) {
            return false;
        }
        int i3 = this.b;
        while (i3 < this.c) {
            int i4 = i3 + 1;
            int i5 = i + 1;
            if (this.d.a[i3] != bArr[i]) {
                return false;
            }
            i = i5;
            i3 = i4;
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.f, com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.a, com.google.android.libraries.navigation.internal.agd.w
    public final be b() {
        return new n(this);
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
        if (obj instanceof p) {
            p pVar = (p) obj;
            return K(pVar.a, 0, pVar.b);
        }
        if (!(obj instanceof o)) {
            return super.equals(obj);
        }
        o oVar = (o) obj;
        return K(oVar.L(), oVar.b, oVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.f, com.google.android.libraries.navigation.internal.agd.ao
    public final byte l(int i) {
        E(i);
        return this.d.a[i + this.b];
    }

    @Override // com.google.android.libraries.navigation.internal.agd.f, com.google.android.libraries.navigation.internal.agd.h, java.util.List
    public final /* synthetic */ ListIterator listIterator(int i) {
        return new m(this, i);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.f, com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.ao
    /* JADX INFO: renamed from: o */
    public final aq listIterator(int i) {
        return new m(this, i);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.f, com.google.android.libraries.navigation.internal.agd.h, com.google.android.libraries.navigation.internal.agd.a, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return new n(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.h
    /* JADX INFO: renamed from: u */
    public final int compareTo(List list) {
        if (list instanceof p) {
            p pVar = (p) list;
            return J(pVar.a, 0, pVar.b);
        }
        if (!(list instanceof o)) {
            return super.compareTo(list);
        }
        o oVar = (o) list;
        return J(oVar.L(), oVar.b, oVar.c);
    }
}
