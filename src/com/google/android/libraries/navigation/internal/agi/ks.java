package com.google.android.libraries.navigation.internal.agi;

import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ks extends af {
    private static final long serialVersionUID = -3185226345314976296L;
    final /* synthetic */ kt d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected ks(kt ktVar, int i, int i2) {
        super(ktVar, i, i2);
        this.d = ktVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ai, com.google.android.libraries.navigation.internal.agi.aj, com.google.android.libraries.navigation.internal.agi.ad, com.google.android.libraries.navigation.internal.agi.kx
    /* JADX INFO: renamed from: b */
    public final hj spliterator() {
        return new kr(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ai, com.google.android.libraries.navigation.internal.agi.aj, com.google.android.libraries.navigation.internal.agi.la
    /* JADX INFO: renamed from: d */
    public final gw listIterator(int i) {
        return new kq(this, i);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.aj, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof List)) {
            return false;
        }
        if (obj instanceof kt) {
            kt ktVar = (kt) obj;
            return o(ktVar.a, 0, ktVar.b);
        }
        if (!(obj instanceof ks)) {
            return super.equals(obj);
        }
        ks ksVar = (ks) obj;
        kt ktVar2 = ksVar.d;
        return o(ktVar2.a, ksVar.b, ksVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ai, java.util.List
    public final Object get(int i) {
        k(i);
        return this.d.a[i + this.b];
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ai, com.google.android.libraries.navigation.internal.agi.aj, java.util.List
    public final /* synthetic */ ListIterator listIterator(int i) {
        return new kq(this, i);
    }

    final boolean o(Object[] objArr, int i, int i2) {
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
            if (this.d.a[i3] != objArr[i]) {
                return false;
            }
            i = i5;
            i3 = i4;
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ai, com.google.android.libraries.navigation.internal.agi.aj, com.google.android.libraries.navigation.internal.agi.ad, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return new kr(this);
    }
}
