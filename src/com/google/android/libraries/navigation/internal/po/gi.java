package com.google.android.libraries.navigation.internal.po;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class gi implements com.google.android.libraries.navigation.internal.yx.br {
    final /* synthetic */ gm a;

    public gi(gm gmVar) {
        this.a = gmVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.br
    public final /* bridge */ /* synthetic */ Object a() {
        com.google.android.libraries.geo.mapcore.renderer.ax axVar = (com.google.android.libraries.geo.mapcore.renderer.ax) this.a.j.a();
        com.google.android.libraries.navigation.internal.yx.br brVarA = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.gf
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.l) this.a.a.a.a()).h());
            }
        });
        com.google.android.libraries.navigation.internal.yx.br brVarA2 = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.gg
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.l) this.a.a.a.a()).I());
            }
        });
        com.google.android.libraries.navigation.internal.yx.br brVarA3 = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.gh
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.l) this.a.a.a.a()).K());
            }
        });
        gm gmVar = this.a;
        return new com.google.android.libraries.navigation.internal.qg.c(axVar, new com.google.android.libraries.navigation.internal.qg.a(gmVar.g, gmVar.d, gmVar.w, gmVar.f525n, gmVar.u, gmVar.p, gmVar.q, gmVar.v, false, brVarA, brVarA2, brVarA3), this.a.l(), this.a.m);
    }
}
