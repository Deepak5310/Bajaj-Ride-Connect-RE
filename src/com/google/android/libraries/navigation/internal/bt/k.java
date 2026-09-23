package com.google.android.libraries.navigation.internal.bt;

import android.content.Context;
import com.google.android.libraries.navigation.internal.adq.ar;
import com.google.android.libraries.navigation.internal.adq.z;
import com.google.android.libraries.navigation.internal.adr.cs;
import com.google.android.libraries.navigation.internal.adr.le;
import com.google.android.libraries.navigation.internal.adr.lg;
import com.google.android.libraries.navigation.internal.adr.ls;
import com.google.android.libraries.navigation.internal.adr.lv;
import com.google.android.libraries.navigation.internal.adr.lx;
import com.google.android.libraries.navigation.internal.adr.lz;
import com.google.android.libraries.navigation.internal.adr.ma;
import com.google.android.libraries.navigation.internal.ady.ab;
import com.google.android.libraries.navigation.internal.bp.cj;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.bp.t;
import com.google.android.libraries.navigation.internal.oe.r;
import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k {
    public static ck a(String str, Context context, ck ckVar, ma maVar) {
        le leVar;
        com.google.android.libraries.navigation.internal.oe.j jVarE;
        int iA = lx.a(maVar.d);
        if (iA == 0) {
            iA = lx.a;
        }
        if (iA != lx.a) {
            int iA2 = lx.a(maVar.d);
            if (iA2 == 0) {
                iA2 = lx.a;
            }
            if (iA2 != lx.b) {
                return ckVar;
            }
        }
        if ((maVar.b & 1) == 0) {
            return c(b(ckVar));
        }
        lg lgVar = maVar.c;
        if (lgVar == null) {
            lgVar = lg.a;
        }
        if ((lgVar.b & 1) == 0) {
            return c(b(ckVar));
        }
        if (ckVar.Z()) {
            if ((maVar.b & 64) == 0) {
                return c(ckVar);
            }
            cj cjVarC = ckVar.c();
            lz lzVar = maVar.f;
            if (lzVar == null) {
                lzVar = lz.a;
            }
            return cjVarC.A(lzVar).B();
        }
        cj cjVarC2 = ckVar.c();
        t tVar = (t) cjVarC2;
        tVar.h = str;
        lg lgVar2 = maVar.c;
        if (lgVar2 == null) {
            lgVar2 = lg.a;
        }
        tVar.i = lgVar2.j;
        if ((maVar.b & 128) != 0) {
            int iA3 = lv.a(maVar.g);
            if (iA3 == 0) {
                iA3 = lv.a;
            }
            cjVarC2.m = iA3;
        }
        lg lgVar3 = maVar.c;
        if (lgVar3 == null) {
            lgVar3 = lg.a;
        }
        if ((lgVar3.b & 1) != 0) {
            lg lgVar4 = maVar.c;
            if (lgVar4 == null) {
                lgVar4 = lg.a;
            }
            ls lsVar = lgVar4.c;
            if (lsVar == null) {
                lsVar = ls.a;
            }
            if ((lsVar.b & 4) != 0 && (jVarE = com.google.android.libraries.navigation.internal.oe.j.e(lsVar.e)) != null) {
                tVar.b = jVarE;
            }
            int i = lsVar.b;
            if ((i & 256) != 0) {
                tVar.f = lsVar.j;
            }
            if ((i & 8) != 0) {
                z zVar = lsVar.f;
                if (zVar == null) {
                    zVar = z.a;
                }
                tVar.c = r.a(zVar);
            }
            if ((lsVar.b & 2097152) != 0) {
                cs csVar = lsVar.t;
                if (csVar == null) {
                    csVar = cs.a;
                }
                cjVarC2.E(csVar);
            }
        }
        lg lgVar5 = maVar.c;
        if (lgVar5 == null) {
            lgVar5 = lg.a;
        }
        lz lzVar2 = null;
        if ((lgVar5.b & 256) != 0) {
            lg lgVar6 = maVar.c;
            if (lgVar6 == null) {
                lgVar6 = lg.a;
            }
            leVar = lgVar6.e;
            if (leVar == null) {
                leVar = le.a;
            }
        } else {
            leVar = null;
        }
        cjVarC2.x(leVar);
        lg lgVar7 = maVar.c;
        if (lgVar7 == null) {
            lgVar7 = lg.a;
        }
        cjVarC2.y(lgVar7.f);
        lg lgVar8 = maVar.c;
        if (lgVar8 == null) {
            lgVar8 = lg.a;
        }
        if ((lgVar8.b & 2) != 0) {
            lg lgVar9 = maVar.c;
            if (lgVar9 == null) {
                lgVar9 = lg.a;
            }
            com.google.android.libraries.navigation.internal.adr.b bVar = lgVar9.d;
            if (bVar == null) {
                bVar = com.google.android.libraries.navigation.internal.adr.b.a;
            }
            cjVarC2.C(bVar);
        }
        if ((maVar.b & 64) != 0 && (lzVar2 = maVar.f) == null) {
            lzVar2 = lz.a;
        }
        cjVarC2.A(lzVar2);
        if (!ckVar.E()) {
            j.b(context, cjVarC2, maVar);
        }
        lg lgVar10 = maVar.c;
        if (lgVar10 == null) {
            lgVar10 = lg.a;
        }
        if ((lgVar10.b & 2048) != 0) {
            lg lgVar11 = maVar.c;
            if (lgVar11 == null) {
                lgVar11 = lg.a;
            }
            ar arVarB = ar.b(lgVar11.h);
            if (arVarB == null) {
                arVarB = ar.UNKNOWN_PARKING_DIFFICULTY;
            }
            cjVarC2.r(arVarB);
        }
        lg lgVar12 = maVar.c;
        if (lgVar12 == null) {
            lgVar12 = lg.a;
        }
        if ((lgVar12.b & 8192) != 0) {
            lg lgVar13 = maVar.c;
            if (lgVar13 == null) {
                lgVar13 = lg.a;
            }
            ab abVar = lgVar13.i;
            if (abVar == null) {
                abVar = ab.a;
            }
            cjVarC2.F(abVar);
        }
        lg lgVar14 = maVar.c;
        if (lgVar14 == null) {
            lgVar14 = lg.a;
        }
        cjVarC2.p(lgVar14.k);
        lg lgVar15 = maVar.c;
        if (lgVar15 == null) {
            lgVar15 = lg.a;
        }
        if ((lgVar15.b & 131072) != 0) {
            lg lgVar16 = maVar.c;
            if (lgVar16 == null) {
                lgVar16 = lg.a;
            }
            com.google.android.libraries.navigation.internal.adq.t tVar2 = lgVar16.l;
            if (tVar2 == null) {
                tVar2 = com.google.android.libraries.navigation.internal.adq.t.a;
            }
            cjVarC2.D(tVar2);
        }
        lg lgVar17 = maVar.c;
        if (lgVar17 == null) {
            lgVar17 = lg.a;
        }
        cjVarC2.l(lgVar17.g);
        ck ckVarB = cjVarC2.B();
        ckVarB.equals(ckVar);
        return ckVarB;
    }

    private static ck b(ck ckVar) {
        if (ckVar.S() == null && ckVar.P().isEmpty()) {
            return ckVar;
        }
        cj cjVarX = ckVar.c().x(null);
        int i = ev.d;
        return cjVarX.y(com.google.android.libraries.navigation.internal.yz.lv.a).B();
    }

    private static ck c(ck ckVar) {
        return ckVar.U() == null ? ckVar : ckVar.c().A(null).B();
    }
}
