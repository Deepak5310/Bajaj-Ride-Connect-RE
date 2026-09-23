package com.google.android.libraries.navigation.internal.agh;

import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fu extends q {
    private static final long serialVersionUID = -3185226345314976296L;
    final /* synthetic */ fv d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected fu(fv fvVar, int i, int i2) {
        super(fvVar, i, i2);
        this.d = fvVar;
    }

    private final long[] M() {
        return this.d.a;
    }

    final int K(long[] jArr, int i, int i2) {
        int i3;
        if (this.d.a == jArr && this.b == i && this.c == i2) {
            return 0;
        }
        int i4 = this.b;
        while (true) {
            i3 = this.c;
            if (i4 >= i3 || i4 >= i2) {
                break;
            }
            int iCompare = Long.compare(this.d.a[i4], jArr[i]);
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

    final boolean L(long[] jArr, int i, int i2) {
        if (this.d.a == jArr && this.b == i && this.c == i2) {
            return true;
        }
        if (i2 - i != size()) {
            return false;
        }
        int i3 = this.b;
        while (i3 < this.c) {
            int i4 = i3 + 1;
            long j = this.d.a[i3];
            int i5 = i + 1;
            if (j != jArr[i]) {
                return false;
            }
            i = i5;
            i3 = i4;
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.t, com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf, com.google.android.libraries.navigation.internal.agh.he
    /* JADX INFO: renamed from: b */
    public final hl spliterator() {
        return new ft(this);
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
        if (obj instanceof fv) {
            fv fvVar = (fv) obj;
            return L(fvVar.a, 0, fvVar.b);
        }
        if (!(obj instanceof fu)) {
            return super.equals(obj);
        }
        fu fuVar = (fu) obj;
        return L(fuVar.M(), fuVar.b, fuVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.t, com.google.android.libraries.navigation.internal.agh.u, java.util.List
    public final /* synthetic */ ListIterator listIterator(int i) {
        return new fs(this, i);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.t, com.google.android.libraries.navigation.internal.agh.gy
    public final long m(int i) {
        F(i);
        return this.d.a[i + this.b];
    }

    @Override // com.google.android.libraries.navigation.internal.agh.t, com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.gy
    /* JADX INFO: renamed from: p */
    public final ha listIterator(int i) {
        return new fs(this, i);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.t, com.google.android.libraries.navigation.internal.agh.u, com.google.android.libraries.navigation.internal.agh.n, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Spliterator spliterator() {
        return new ft(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.u
    /* JADX INFO: renamed from: v */
    public final int compareTo(List list) {
        if (list instanceof fv) {
            fv fvVar = (fv) list;
            return K(fvVar.a, 0, fvVar.b);
        }
        if (!(list instanceof fu)) {
            return super.compareTo(list);
        }
        fu fuVar = (fu) list;
        return K(fuVar.M(), fuVar.b, fuVar.c);
    }
}
