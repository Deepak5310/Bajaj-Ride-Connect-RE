package com.google.android.libraries.navigation.internal.ck;

import com.google.android.libraries.navigation.internal.adr.Cdo;
import com.google.android.libraries.navigation.internal.adr.el;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bz implements com.google.android.libraries.navigation.internal.cq.z {
    final /* synthetic */ el a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.oe.ad b;
    final /* synthetic */ boolean c;
    final /* synthetic */ com.google.android.libraries.navigation.internal.pi.s d;
    final /* synthetic */ com.google.android.libraries.navigation.internal.bp.bg e;

    public bz(el elVar, com.google.android.libraries.navigation.internal.oe.ad adVar, boolean z, com.google.android.libraries.navigation.internal.pi.s sVar, com.google.android.libraries.navigation.internal.bp.bg bgVar) {
        this.a = elVar;
        this.b = adVar;
        this.c = z;
        this.d = sVar;
        this.e = bgVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.as
    public final /* bridge */ /* synthetic */ void C(Object obj) {
        com.google.android.libraries.navigation.internal.ol.o oVar = (com.google.android.libraries.navigation.internal.ol.o) obj;
        com.google.android.libraries.navigation.internal.yx.an anVarG = oVar.g();
        com.google.android.libraries.navigation.internal.oe.x xVarJ = oVar.j();
        com.google.android.libraries.navigation.internal.pf.c cVarA = com.google.android.libraries.navigation.internal.pf.c.a(this.a, this.b, anVarG);
        if (cVarA == null) {
            return;
        }
        if (this.c) {
            Cdo cdoB = Cdo.b(this.a.u);
            if (cdoB == null) {
                cdoB = Cdo.INCIDENT_OTHER;
            }
            int iOrdinal = cdoB.ordinal();
            if (iOrdinal != 25 && iOrdinal != 26) {
                this.d.g(new com.google.android.libraries.navigation.internal.pi.x(cVarA));
                return;
            }
        }
        this.d.f(com.google.android.libraries.navigation.internal.pi.y.a(1, xVarJ, this.e));
    }

    @Override // com.google.android.libraries.navigation.internal.ol.as
    public final /* bridge */ /* synthetic */ void D(Object obj) {
    }
}
