package com.google.android.libraries.navigation.internal.cm;

import com.google.android.libraries.navigation.internal.adg.Cdo;
import com.google.android.libraries.navigation.internal.adg.c;
import com.google.android.libraries.navigation.internal.adg.d;
import com.google.android.libraries.navigation.internal.adg.dp;
import com.google.android.libraries.navigation.internal.adg.dq;
import com.google.android.libraries.navigation.internal.adg.dt;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.er;
import com.google.android.libraries.navigation.internal.adg.es;
import com.google.android.libraries.navigation.internal.adg.et;
import com.google.android.libraries.navigation.internal.adg.ex;
import com.google.android.libraries.navigation.internal.adg.h;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.adr.ei;
import com.google.android.libraries.navigation.internal.adr.ej;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.on.k;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public final synchronized ef a(ej ejVar, bg bgVar) {
        int i = ejVar.b;
        if ((i & 1) == 0 || (i & 2) == 0) {
            return ef.a;
        }
        bm bmVar = ejVar.c;
        if (bmVar == null) {
            bmVar = bm.a;
        }
        x xVarW = bgVar.w(bmVar.c);
        if (xVarW == null) {
            return ef.a;
        }
        Cdo cdo = (Cdo) dp.a.q();
        bh bhVar = et.e;
        er erVar = (er) es.a.q();
        ei eiVar = ejVar.d;
        if (eiVar == null) {
            eiVar = ei.a;
        }
        ex exVarB = ex.b(eiVar.b);
        if (exVarB == null) {
            exVarB = ex.LEGEND_STYLE_UNDEFINED;
        }
        if (!erVar.b.H()) {
            erVar.v();
        }
        int i2 = exVarB.CG;
        es esVar = (es) erVar.b;
        esVar.b |= 1;
        esVar.c = i2;
        cdo.C(bhVar, (es) erVar.t());
        dp dpVar = (dp) cdo.t();
        dy dyVar = (dy) ef.a.q();
        dq dqVar = (dq) dt.a.q();
        dqVar.e(dpVar);
        dt dtVar = (dt) dqVar.t();
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        ef efVar = (ef) dyVar.b;
        dtVar.getClass();
        efVar.c = dtVar;
        efVar.b |= 1;
        c cVar = (c) d.a.q();
        h hVarA = k.a(xVarW);
        if (!cVar.b.H()) {
            cVar.v();
        }
        d dVar = (d) cVar.b;
        hVarA.getClass();
        dVar.c = hVarA;
        dVar.b |= 1;
        com.google.android.libraries.navigation.internal.adg.b bVar = com.google.android.libraries.navigation.internal.adg.b.CENTER;
        if (!cVar.b.H()) {
            cVar.v();
        }
        d dVar2 = (d) cVar.b;
        dVar2.d = bVar.j;
        dVar2.b |= 2;
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        ef efVar2 = (ef) dyVar.b;
        d dVar3 = (d) cVar.t();
        dVar3.getClass();
        efVar2.e = dVar3;
        efVar2.b |= 8;
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        ef efVar3 = (ef) dyVar.b;
        efVar3.b |= 64;
        efVar3.h = 1;
        return (ef) dyVar.t();
    }
}
