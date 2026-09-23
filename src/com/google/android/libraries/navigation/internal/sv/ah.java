package com.google.android.libraries.navigation.internal.sv;

import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ah implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ com.google.android.libraries.navigation.internal.wd.f a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.db.r b;
    final /* synthetic */ ak c;

    public ah(ak akVar, com.google.android.libraries.navigation.internal.wd.f fVar, com.google.android.libraries.navigation.internal.db.r rVar) {
        this.a = fVar;
        this.b = rVar;
        this.c = akVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        com.google.android.libraries.navigation.internal.vm.b.a(this.a, false);
        int i = ak.K;
        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1606)).p("Reroute failed");
        if (th instanceof com.google.android.libraries.navigation.internal.sx.am) {
            com.google.android.libraries.navigation.internal.sx.am amVar = (com.google.android.libraries.navigation.internal.sx.am) th;
            com.google.android.libraries.navigation.internal.sx.as asVarF = ak.f(amVar);
            this.c.r(asVarF, amVar.e);
            this.c.u(asVarF, this.b);
        }
        this.c.v = null;
        ak akVar = this.c;
        q qVar = (q) r.a.q();
        String strB = com.google.android.libraries.navigation.internal.yx.aq.b(th.getMessage());
        if (!qVar.b.H()) {
            qVar.v();
        }
        ((r) qVar.b).c = strB;
        akVar.m("com.google.android.libraries.geo.navcore.service.guider.MonitorRerouteFutureProto", qVar.t());
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        com.google.android.libraries.navigation.internal.sx.as asVar = (com.google.android.libraries.navigation.internal.sx.as) obj;
        com.google.android.libraries.navigation.internal.vm.b.a(this.a, asVar.b());
        this.c.r(asVar, null);
        this.c.u(asVar, this.b);
        this.c.v = null;
        q qVar = (q) r.a.q();
        ev evVarI = ak.I(asVar.b);
        if (!qVar.b.H()) {
            qVar.v();
        }
        r rVar = (r) qVar.b;
        com.google.android.libraries.navigation.internal.ael.bz bzVar = rVar.b;
        if (!bzVar.c()) {
            rVar.b = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
        }
        ak akVar = this.c;
        com.google.android.libraries.navigation.internal.ael.b.m(evVarI, rVar.b);
        akVar.m("com.google.android.libraries.geo.navcore.service.guider.MonitorRerouteFutureProto", qVar.t());
    }
}
