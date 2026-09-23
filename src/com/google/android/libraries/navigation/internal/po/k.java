package com.google.android.libraries.navigation.internal.po;

import android.animation.TimeInterpolator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k implements com.google.android.libraries.navigation.internal.pb.b {
    final /* synthetic */ l a;

    public k(l lVar) {
        this.a = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pb.b
    public final int a() {
        return this.a.b.getHeight();
    }

    @Override // com.google.android.libraries.navigation.internal.pb.b
    public final int b() {
        return this.a.b.getWidth();
    }

    @Override // com.google.android.libraries.navigation.internal.pb.b
    public final com.google.android.libraries.navigation.internal.pb.t c() {
        com.google.android.libraries.navigation.internal.pb.t tVar = new com.google.android.libraries.navigation.internal.pb.t(this.a.c);
        com.google.android.libraries.navigation.internal.pd.d dVarW = tVar.w();
        com.google.android.libraries.navigation.internal.pd.d dVar = com.google.android.libraries.navigation.internal.pd.d.a;
        com.google.android.libraries.navigation.internal.pd.a aVar = new com.google.android.libraries.navigation.internal.pd.a(dVarW);
        if (this.a.a.h(aVar)) {
            tVar.B(aVar.a());
        }
        return tVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pb.b
    public final void d(com.google.android.libraries.navigation.internal.pd.d dVar, int i, TimeInterpolator timeInterpolator) {
        this.a.a.c(dVar, i, timeInterpolator);
    }
}
