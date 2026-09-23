package com.google.android.libraries.navigation.internal.po;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class gc implements com.google.android.libraries.navigation.internal.yx.br {
    final /* synthetic */ com.google.android.libraries.navigation.internal.om.p a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.iv.f b;
    final /* synthetic */ com.google.android.libraries.navigation.internal.hp.e c;
    final /* synthetic */ com.google.android.libraries.navigation.internal.mj.a d;

    public gc(com.google.android.libraries.navigation.internal.om.p pVar, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.hp.e eVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.a = pVar;
        this.b = fVar;
        this.c = eVar;
        this.d = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.br
    public final /* bridge */ /* synthetic */ Object a() {
        final com.google.android.libraries.navigation.internal.iv.f fVar = this.b;
        com.google.android.libraries.navigation.internal.agl.a aVar = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.po.gb
            @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
            public final Object a() {
                return fVar.i(com.google.android.libraries.navigation.internal.iv.ab.B, "");
            }
        };
        com.google.android.libraries.navigation.internal.ih.a aVarC = com.google.android.libraries.navigation.internal.ih.a.c(new com.google.android.libraries.navigation.internal.rc.f(this.c, this.d));
        com.google.android.libraries.navigation.internal.yz.fy fyVar = com.google.android.libraries.navigation.internal.oz.d.a;
        com.google.android.libraries.navigation.internal.om.p pVar = this.a;
        boolean z = false;
        if (((com.google.android.libraries.navigation.internal.om.d) pVar.b()).c && !((com.google.android.libraries.navigation.internal.om.f) pVar.c()).a) {
            z = true;
        }
        return new com.google.android.libraries.navigation.internal.oz.d(z, pVar.c(), aVar, aVarC);
    }
}
