package com.google.android.libraries.navigation.internal.bo;

import com.google.android.libraries.navigation.internal.adr.Cdo;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class al implements com.google.android.libraries.navigation.internal.cq.z {
    final /* synthetic */ am a;
    final /* synthetic */ ao b;

    public al(ao aoVar, am amVar) {
        this.a = amVar;
        this.b = aoVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.as
    public final /* bridge */ /* synthetic */ void C(Object obj) {
        com.google.android.libraries.navigation.internal.ol.o oVar = (com.google.android.libraries.navigation.internal.ol.o) obj;
        com.google.android.libraries.navigation.internal.yx.an anVarG = oVar.g();
        com.google.android.libraries.navigation.internal.oe.x xVarJ = oVar.j();
        am amVar = this.a;
        com.google.android.libraries.navigation.internal.pf.c cVarA = com.google.android.libraries.navigation.internal.pf.c.a(amVar.a, amVar.c, anVarG);
        if (cVarA != null) {
            am amVar2 = this.a;
            if (!amVar2.e) {
                ao aoVar = this.b;
                aoVar.s.f(com.google.android.libraries.navigation.internal.pi.y.a(1, xVarJ, aoVar.q));
                return;
            }
            Cdo cdoB = Cdo.b(amVar2.a.u);
            if (cdoB == null) {
                cdoB = Cdo.INCIDENT_OTHER;
            }
            int i = ao.F;
            int iOrdinal = cdoB.ordinal();
            if (iOrdinal == 25 || iOrdinal == 26) {
                return;
            }
            ao aoVar2 = this.b;
            aoVar2.s.g(new com.google.android.libraries.navigation.internal.pi.x(cVarA));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.as
    public final /* bridge */ /* synthetic */ void D(Object obj) {
    }
}
