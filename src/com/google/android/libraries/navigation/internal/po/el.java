package com.google.android.libraries.navigation.internal.po;

import android.animation.TimeInterpolator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class el implements com.google.android.libraries.navigation.internal.pb.b {
    final /* synthetic */ com.google.android.libraries.geo.mapcore.renderer.bg a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.qe.e b;
    final /* synthetic */ fk c;

    public el(fk fkVar, com.google.android.libraries.geo.mapcore.renderer.bg bgVar, com.google.android.libraries.navigation.internal.qe.e eVar) {
        this.a = bgVar;
        this.b = eVar;
        this.c = fkVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pb.b
    public final int a() {
        return this.a.a().getHeight();
    }

    @Override // com.google.android.libraries.navigation.internal.pb.b
    public final int b() {
        return this.a.a().getWidth();
    }

    @Override // com.google.android.libraries.navigation.internal.pb.b
    public final com.google.android.libraries.navigation.internal.pb.t c() {
        return new com.google.android.libraries.navigation.internal.pb.t(this.c.i);
    }

    @Override // com.google.android.libraries.navigation.internal.pb.b
    public final void d(com.google.android.libraries.navigation.internal.pd.d dVar, int i, TimeInterpolator timeInterpolator) {
        com.google.android.libraries.navigation.internal.pb.t tVar = this.c.i;
        tVar.g = false;
        tVar.B(dVar);
        fk fkVar = this.c;
        fkVar.i.g = true;
        fkVar.l(true);
        com.google.android.libraries.navigation.internal.qe.e eVar = this.b;
        if (eVar.d) {
            eVar.o(eVar.c.a());
        }
        this.c.l.c(dVar, 0, null);
    }
}
