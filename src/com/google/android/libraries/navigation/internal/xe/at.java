package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.internal.abh.ht;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class at extends com.google.android.libraries.navigation.internal.abh.fe {
    public final com.google.android.libraries.navigation.environment.am a;
    public boolean b;
    private boolean j;

    public at(com.google.android.libraries.navigation.internal.abh.be beVar, com.google.android.libraries.navigation.internal.abh.ac acVar, com.google.android.libraries.navigation.internal.abh.fc fcVar, com.google.android.libraries.navigation.internal.abh.fg fgVar, com.google.android.libraries.navigation.internal.ly.o oVar, ht htVar, com.google.android.libraries.navigation.internal.yx.br brVar, com.google.android.libraries.navigation.internal.abh.bq bqVar, com.google.android.libraries.navigation.environment.am amVar) {
        super(beVar, acVar, fcVar, fgVar, oVar, htVar, brVar, bqVar);
        this.j = true;
        this.b = false;
        this.a = amVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fe
    public final void b() {
        if (this.f) {
            this.a.B().e(this);
        }
        super.b();
        this.j = false;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fe
    public final void c() {
        if (!this.f) {
            com.google.android.libraries.navigation.internal.ia.e eVarB = this.a.B();
            com.google.android.libraries.navigation.internal.yz.fz fzVar = new com.google.android.libraries.navigation.internal.yz.fz();
            fzVar.b(com.google.android.libraries.navigation.internal.db.s.class, new au(0, com.google.android.libraries.navigation.internal.db.s.class, this, com.google.android.libraries.navigation.internal.hx.ap.DANGEROUS_PUBLISHER_THREAD));
            fzVar.b(com.google.android.libraries.navigation.internal.cw.f.class, new au(1, com.google.android.libraries.navigation.internal.cw.f.class, this, com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD));
            eVarB.c(this, fzVar.a());
        }
        super.c();
        this.j = true;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fe
    public final void d(boolean z) {
        this.d.c(z);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fe
    public final void e(boolean z) {
        this.d.f(z);
        if (this.d.i() || !z) {
            return;
        }
        if (this.j) {
            c();
        } else {
            this.d.b();
        }
    }
}
