package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cd implements dd {
    final /* synthetic */ cr a;

    public cd(cr crVar) {
        this.a = crVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aga.dd
    public final com.google.android.libraries.navigation.internal.afx.c a(com.google.android.libraries.navigation.internal.afx.c cVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.aga.dd
    public final void b(boolean z) {
        cr crVar = this.a;
        crVar.F.c(crVar.t, false);
    }

    @Override // com.google.android.libraries.navigation.internal.aga.dd
    public final void c() {
    }

    @Override // com.google.android.libraries.navigation.internal.aga.dd
    public final void d(com.google.android.libraries.navigation.internal.afx.cl clVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.aga.dd
    public final void e() {
        com.google.android.libraries.navigation.internal.yx.ar.l(this.a.u.get(), "Channel must have been shut down");
        cr crVar = this.a;
        crVar.v = true;
        crVar.g(false);
        this.a.e();
    }
}
