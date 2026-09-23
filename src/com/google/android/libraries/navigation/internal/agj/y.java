package com.google.android.libraries.navigation.internal.agj;

import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class y implements x {
    final /* synthetic */ Comparator a;

    public y(Comparator comparator) {
        this.a = comparator;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compare(Short sh, Short sh2) {
        return this.a.compare(sh, sh2);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.x
    public final int b(short s, short s2) {
        return this.a.compare(Short.valueOf(s), Short.valueOf(s2));
    }

    @Override // com.google.android.libraries.navigation.internal.agj.x
    public final /* synthetic */ x c() {
        return ac.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.x
    public final /* synthetic */ x d(x xVar) {
        return new v(this, xVar);
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ Comparator reversed() {
        return c();
    }

    @Override // java.util.Comparator
    public final /* synthetic */ Comparator thenComparing(Comparator comparator) {
        return w.d(this, comparator);
    }
}
