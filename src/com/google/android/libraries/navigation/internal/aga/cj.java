package com.google.android.libraries.navigation.internal.aga;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cj extends com.google.android.libraries.navigation.internal.afx.ar {
    c a;
    final /* synthetic */ cr b;

    public cj(cr crVar) {
        this.b = crVar;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.ar
    public final com.google.android.libraries.navigation.internal.afx.g a() {
        return this.b.y;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.ar
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.afx.aw b(com.google.android.libraries.navigation.internal.afx.ao aoVar) {
        this.b.j.d();
        com.google.android.libraries.navigation.internal.yx.ar.l(!this.b.v, "Channel is being terminated");
        return new cq(this.b, aoVar);
    }

    @Override // com.google.android.libraries.navigation.internal.afx.ar
    public final com.google.android.libraries.navigation.internal.afx.cq c() {
        return this.b.j;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.ar
    public final ScheduledExecutorService d() {
        return this.b.h;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.ar
    public final void e() {
        this.b.j.d();
        this.b.j.execute(new ch(this));
    }

    @Override // com.google.android.libraries.navigation.internal.afx.ar
    public final void f(com.google.android.libraries.navigation.internal.afx.r rVar, com.google.android.libraries.navigation.internal.afx.ax axVar) {
        this.b.j.d();
        com.google.android.libraries.navigation.internal.yx.ar.r(rVar, "newState");
        this.b.j.execute(new ci(this, axVar, rVar));
    }
}
