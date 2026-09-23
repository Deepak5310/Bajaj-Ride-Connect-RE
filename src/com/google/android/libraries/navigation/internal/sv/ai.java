package com.google.android.libraries.navigation.internal.sv;

import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ai implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ com.google.android.libraries.navigation.internal.bp.bg a;
    final /* synthetic */ ak b;

    public ai(ak akVar, com.google.android.libraries.navigation.internal.bp.bg bgVar) {
        this.a = bgVar;
        this.b = akVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        int i = ak.K;
        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1607)).p("Trip update failed");
        if (th instanceof com.google.android.libraries.navigation.internal.sx.am) {
            com.google.android.libraries.navigation.internal.sx.am amVar = (com.google.android.libraries.navigation.internal.sx.am) th;
            com.google.android.libraries.navigation.internal.sx.as asVarF = ak.f(amVar);
            this.b.r(asVarF, amVar.e);
            this.b.v(asVarF, this.a);
        }
        this.b.R = null;
        ak akVar = this.b;
        s sVar = (s) t.a.q();
        String strB = com.google.android.libraries.navigation.internal.yx.aq.b(th.getMessage());
        if (!sVar.b.H()) {
            sVar.v();
        }
        ((t) sVar.b).c = strB;
        akVar.m("com.google.android.libraries.geo.navcore.service.guider.MonitorTripUpdateFutureProto", sVar.t());
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        com.google.android.libraries.navigation.internal.sx.as asVar = (com.google.android.libraries.navigation.internal.sx.as) obj;
        this.b.r(asVar, null);
        this.b.v(asVar, this.a);
        this.b.R = null;
        s sVar = (s) t.a.q();
        ev evVarI = ak.I(asVar.b);
        if (!sVar.b.H()) {
            sVar.v();
        }
        t tVar = (t) sVar.b;
        com.google.android.libraries.navigation.internal.ael.bz bzVar = tVar.b;
        if (!bzVar.c()) {
            tVar.b = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
        }
        ak akVar = this.b;
        com.google.android.libraries.navigation.internal.ael.b.m(evVarI, tVar.b);
        akVar.m("com.google.android.libraries.geo.navcore.service.guider.MonitorTripUpdateFutureProto", sVar.t());
    }
}
