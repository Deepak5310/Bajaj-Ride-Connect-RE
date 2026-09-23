package com.google.android.libraries.navigation.internal.xe;

import android.app.Activity;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ea implements dv {
    public final Activity a;
    public final com.google.android.libraries.navigation.environment.am b;
    public final gk c;
    public final com.google.android.libraries.navigation.internal.xf.b d;
    public final com.google.android.libraries.navigation.internal.xd.a e;
    private final com.google.android.libraries.navigation.internal.ct.a f;

    public ea(Activity activity, com.google.android.libraries.navigation.environment.am amVar, gk gkVar, com.google.android.libraries.navigation.internal.xf.b bVar, com.google.android.libraries.navigation.internal.ct.a aVar, com.google.android.libraries.navigation.internal.xd.a aVar2) {
        this.a = activity;
        com.google.android.libraries.navigation.internal.yx.ar.q(amVar);
        this.b = amVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(gkVar);
        this.c = gkVar;
        this.d = bVar;
        this.f = aVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(aVar2);
        this.e = aVar2;
    }

    public static dv a(com.google.android.libraries.navigation.environment.am amVar, gk gkVar) {
        return new ea(null, amVar, gkVar, new com.google.android.libraries.navigation.internal.xf.b(amVar.C(), amVar.H()), amVar.bf(), amVar.bw());
    }

    private static com.google.android.libraries.navigation.internal.fx.i d(com.google.android.libraries.navigation.environment.am amVar) {
        com.google.android.libraries.navigation.internal.yx.an anVarAT = amVar.aT();
        boolean z = false;
        if (anVarAT.g() && (anVarAT.c() instanceof com.google.android.libraries.navigation.internal.fx.i)) {
            z = true;
        }
        com.google.android.libraries.navigation.internal.yx.ar.k(z);
        return (com.google.android.libraries.navigation.internal.fx.i) anVarAT.c();
    }

    public final void b(ef efVar) {
        if (!this.f.a("android.permission.ACCESS_FINE_LOCATION")) {
            efVar.a(4);
            return;
        }
        com.google.android.libraries.navigation.internal.fx.i iVarD = d(this.b);
        iVarD.h(new dy(this, efVar));
        if (iVarD.c() != 0) {
            c(efVar, 1);
        } else {
            iVarD.b(new dz(this, efVar));
        }
    }

    public final void c(ef efVar, int i) {
        d(this.b).h(null);
        efVar.a(i);
    }
}
