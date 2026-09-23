package com.google.android.libraries.navigation.internal.agi;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fy extends p {
    private static final long serialVersionUID = -3185226345314976296L;
    final /* synthetic */ fz d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected fy(fz fzVar, int i, int i2) {
        super(fzVar, i, i2);
        this.d = fzVar;
    }

    private final Object[] r() {
        return this.d.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.s, com.google.android.libraries.navigation.internal.agi.t, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new fx(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.t, java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((List) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.s, com.google.android.libraries.navigation.internal.agi.t, com.google.android.libraries.navigation.internal.agi.gu
    /* JADX INFO: renamed from: d */
    public final gw listIterator(int i) {
        return new fw(this, i);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.t, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof List)) {
            return false;
        }
        if (obj instanceof fz) {
            fz fzVar = (fz) obj;
            return q(fzVar.a, 0, fzVar.b);
        }
        if (!(obj instanceof fy)) {
            return super.equals(obj);
        }
        fy fyVar = (fy) obj;
        return q(fyVar.r(), fyVar.b, fyVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.s, java.util.List
    public final Object get(int i) {
        l(i);
        return this.d.a[i + this.b];
    }

    @Override // com.google.android.libraries.navigation.internal.agi.t
    /* JADX INFO: renamed from: h */
    public final int compareTo(List list) {
        if (list instanceof fz) {
            fz fzVar = (fz) list;
            return p(fzVar.a, 0, fzVar.b);
        }
        if (!(list instanceof fy)) {
            return super.compareTo(list);
        }
        fy fyVar = (fy) list;
        return p(fyVar.r(), fyVar.b, fyVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.s, com.google.android.libraries.navigation.internal.agi.t, java.util.List
    public final /* synthetic */ ListIterator listIterator(int i) {
        return new fw(this, i);
    }

    final int p(Object[] objArr, int i, int i2) {
        int i3;
        int i4 = this.b;
        while (true) {
            i3 = this.c;
            if (i4 >= i3 || i4 >= i2) {
                break;
            }
            int iCompareTo = ((Comparable) this.d.a[i4]).compareTo(objArr[i]);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            i4++;
            i++;
        }
        if (i4 < i2) {
            return -1;
        }
        return i4 >= i3 ? 0 : 1;
    }

    final boolean q(Object[] objArr, int i, int i2) {
        if (this.d.a == objArr && this.b == i && this.c == i2) {
            return true;
        }
        if (i2 - i != size()) {
            return false;
        }
        int i3 = this.b;
        while (i3 < this.c) {
            int i4 = i3 + 1;
            int i5 = i + 1;
            if (!Objects.equals(this.d.a[i3], objArr[i])) {
                return false;
            }
            i = i5;
            i3 = i4;
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.s, com.google.android.libraries.navigation.internal.agi.t, com.google.android.libraries.navigation.internal.agi.m, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Spliterator spliterator() {
        return new fx(this);
    }
}
