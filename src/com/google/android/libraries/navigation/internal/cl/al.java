package com.google.android.libraries.navigation.internal.cl;

import com.google.android.libraries.navigation.internal.adg.Cdo;
import com.google.android.libraries.navigation.internal.adg.dp;
import com.google.android.libraries.navigation.internal.adg.dq;
import com.google.android.libraries.navigation.internal.adg.dt;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.bp.bq;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class al {
    public final bq a;
    public final com.google.android.libraries.navigation.internal.op.i b;
    private final String c;

    protected al(com.google.android.libraries.navigation.internal.bp.bg bgVar, bq bqVar, String str, com.google.android.libraries.navigation.internal.op.i iVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(bgVar);
        com.google.android.libraries.navigation.internal.yx.ar.q(bqVar);
        this.a = bqVar;
        this.c = str;
        this.b = iVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(com.google.android.libraries.navigation.internal.oj.c cVar, Object obj, Object obj2, Object obj3, Object obj4) {
        Cdo cdoA = cVar.a(obj4);
        if (!cdoA.b.H()) {
            cdoA.v();
        }
        dp dpVar = (dp) cdoA.b;
        dp dpVar2 = dp.a;
        dpVar.b |= 1;
        dpVar.c = StringUtils.SPACE;
        dp dpVar3 = (dp) cdoA.t();
        dq dqVarB = cVar.b(obj);
        boolean zC = com.google.android.libraries.navigation.internal.yx.aq.c(this.c);
        if (obj3 != null) {
            if (zC) {
                dqVarB.e(dpVar3);
            }
            dqVarB.e((dp) cVar.a(obj3).t());
            dqVarB.e(dpVar3);
        }
        if (!zC) {
            com.google.android.libraries.navigation.internal.yx.ar.q(this.c);
            Cdo cdoA2 = cVar.a(obj2);
            String str = this.c;
            if (!cdoA2.b.H()) {
                cdoA2.v();
            }
            dp dpVar4 = (dp) cdoA2.b;
            str.getClass();
            dpVar4.b |= 1;
            dpVar4.c = str;
            dqVarB.d(cdoA2);
        }
        dy dyVarC = cVar.c();
        bq bqVar = this.a;
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        com.google.android.libraries.navigation.internal.oe.x xVar = bqVar.c;
        ef efVar = (ef) dyVarC.b;
        dt dtVar = (dt) dqVarB.t();
        ef efVar2 = ef.a;
        dtVar.getClass();
        efVar.c = dtVar;
        efVar.b |= 1;
        com.google.android.libraries.navigation.internal.adg.c cVar2 = (com.google.android.libraries.navigation.internal.adg.c) com.google.android.libraries.navigation.internal.adg.d.a.q();
        com.google.android.libraries.navigation.internal.adg.h hVarA = com.google.android.libraries.navigation.internal.on.k.a(xVar);
        if (!cVar2.b.H()) {
            cVar2.v();
        }
        com.google.android.libraries.navigation.internal.adg.d dVar = (com.google.android.libraries.navigation.internal.adg.d) cVar2.b;
        hVarA.getClass();
        dVar.c = hVarA;
        dVar.b |= 1;
        com.google.android.libraries.navigation.internal.adg.b bVar = (com.google.android.libraries.navigation.internal.adg.b) av.e.get(0);
        if (!cVar2.b.H()) {
            cVar2.v();
        }
        com.google.android.libraries.navigation.internal.adg.d dVar2 = (com.google.android.libraries.navigation.internal.adg.d) cVar2.b;
        dVar2.d = bVar.j;
        dVar2.b |= 2;
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        ef efVar3 = (ef) dyVarC.b;
        com.google.android.libraries.navigation.internal.adg.d dVar3 = (com.google.android.libraries.navigation.internal.adg.d) cVar2.t();
        dVar3.getClass();
        efVar3.e = dVar3;
        efVar3.b |= 8;
        return true;
    }
}
