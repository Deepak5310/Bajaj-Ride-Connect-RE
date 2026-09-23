package com.google.android.libraries.navigation.internal.kf;

import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.dj;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.kf.d");

    static void a(com.google.android.libraries.navigation.internal.jy.aa aaVar) {
        com.google.android.libraries.navigation.internal.zt.ag agVarH = aaVar.h();
        if (agVarH != null) {
            bb bbVar = (bb) agVarH.aH(5, null);
            bbVar.x(agVarH);
            com.google.android.libraries.navigation.internal.zt.af afVar = (com.google.android.libraries.navigation.internal.zt.af) bbVar;
            if (!afVar.b.H()) {
                afVar.v();
            }
            com.google.android.libraries.navigation.internal.zt.ag agVar = (com.google.android.libraries.navigation.internal.zt.ag) afVar.b;
            agVar.f = null;
            agVar.c &= -16777217;
            if (!afVar.b.H()) {
                afVar.v();
            }
            com.google.android.libraries.navigation.internal.zt.ag agVar2 = (com.google.android.libraries.navigation.internal.zt.ag) afVar.b;
            agVar2.h = null;
            agVar2.c &= Integer.MAX_VALUE;
            if (!afVar.b.H()) {
                afVar.v();
            }
            com.google.android.libraries.navigation.internal.zt.ag agVar3 = (com.google.android.libraries.navigation.internal.zt.ag) afVar.b;
            agVar3.j = null;
            agVar3.d &= -5;
            if (!afVar.b.H()) {
                afVar.v();
            }
            com.google.android.libraries.navigation.internal.zt.ag agVar4 = (com.google.android.libraries.navigation.internal.zt.ag) afVar.b;
            agVar4.g = null;
            agVar4.c &= -536870913;
            if (!afVar.b.H()) {
                afVar.v();
            }
            ((com.google.android.libraries.navigation.internal.zt.ag) afVar.b).e = dj.b;
            if (!afVar.b.H()) {
                afVar.v();
            }
            com.google.android.libraries.navigation.internal.zt.ag agVar5 = (com.google.android.libraries.navigation.internal.zt.ag) afVar.b;
            agVar5.k = null;
            agVar5.d &= -9;
            if (!afVar.b.H()) {
                afVar.v();
            }
            com.google.android.libraries.navigation.internal.zt.ag agVar6 = (com.google.android.libraries.navigation.internal.zt.ag) afVar.b;
            agVar6.i = null;
            agVar6.d &= -2;
            if (((com.google.android.libraries.navigation.internal.zt.ag) afVar.t()).k().A()) {
                return;
            }
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(760)).s("MapsData incorrectly attached to impression - this data will be dropped on the server-side. Only allowlisted fields are kept - all new data should be logged via either go/geo-metadata-logging or go/geo-impression-metadata-logging. UserEvent3Params: %s.\n See also http://go/gmm-logging-errors#mapsdata-on-impression.", aaVar);
        }
    }
}
