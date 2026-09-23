package com.google.android.libraries.navigation.internal.sv;

import com.google.android.libraries.navigation.internal.zr.cu;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ag implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ ak a;

    public ag(ak akVar) {
        this.a = akVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        this.a.S = null;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        com.google.android.libraries.navigation.internal.db.r rVar;
        final com.google.android.libraries.navigation.internal.sx.as asVar = (com.google.android.libraries.navigation.internal.sx.as) obj;
        final ak akVar = this.a;
        akVar.I.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sv.ab
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.libraries.navigation.internal.tc.u uVar;
                cu cuVar = asVar.d;
                if (cuVar == null || (uVar = akVar.H.b) == null) {
                    return;
                }
                uVar.d.add(cuVar);
            }
        });
        if (asVar.d == cu.OKAY) {
            akVar.z = -1L;
            if (!asVar.b.l() && akVar.K(asVar.b, false, false, com.google.android.libraries.navigation.internal.rw.z.a, null) && akVar.h.f165n && (rVar = akVar.D) != null) {
                akVar.w(rVar);
            }
        } else {
            com.google.android.libraries.navigation.internal.adr.at atVar = asVar.a;
            if (akVar.z == -1) {
                akVar.J(com.google.android.libraries.geo.navcore.guidance.impl.as.c, null);
            }
            akVar.z = akVar.c.a();
        }
        this.a.S = null;
    }
}
