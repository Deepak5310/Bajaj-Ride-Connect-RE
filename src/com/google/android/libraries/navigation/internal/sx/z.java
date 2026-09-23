package com.google.android.libraries.navigation.internal.sx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class z implements com.google.android.libraries.navigation.internal.gg.e {
    final /* synthetic */ ab a;

    public z(ab abVar) {
        this.a = abVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final void a(com.google.android.libraries.navigation.internal.gg.i iVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        int i = ab.f583n;
        com.google.android.libraries.navigation.internal.fw.g gVar = oVar.p;
        this.a.c(null, oVar);
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final /* bridge */ /* synthetic */ void b(com.google.android.libraries.navigation.internal.gg.i iVar, Object obj) {
        as asVar = (as) obj;
        int i = ab.f583n;
        com.google.android.libraries.navigation.internal.yx.ar.r(asVar.c, "Offline response must have directions");
        i iVar2 = this.a.m;
        if (iVar2 != null) {
            iVar2.c(asVar.c.a);
        }
        this.a.c(asVar, null);
    }
}
