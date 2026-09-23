package com.google.android.libraries.navigation.internal.sx;

import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e {
    private static final d a = new d();

    public static u a(int i, s sVar) {
        n nVar = (n) u.a.q();
        if (!nVar.b.H()) {
            nVar.v();
        }
        u uVar = (u) nVar.b;
        uVar.c = q.a(i);
        uVar.b |= 1;
        o oVar = (o) p.a.q();
        r rVar = (r) t.a.q();
        if (!rVar.b.H()) {
            rVar.v();
        }
        t tVar = (t) rVar.b;
        tVar.c = sVar.a();
        tVar.b |= 1;
        if (!oVar.b.H()) {
            oVar.v();
        }
        p pVar = (p) oVar.b;
        t tVar2 = (t) rVar.t();
        tVar2.getClass();
        pVar.c = tVar2;
        pVar.b |= 1;
        if (!nVar.b.H()) {
            nVar.v();
        }
        u uVar2 = (u) nVar.b;
        p pVar2 = (p) oVar.t();
        pVar2.getClass();
        uVar2.f = pVar2;
        uVar2.b |= 16;
        return (u) nVar.t();
    }

    public static u b(int i, com.google.android.libraries.navigation.internal.gg.o oVar) {
        o oVar2 = (o) p.a.q();
        if (oVar != null) {
            r rVar = (r) t.a.q();
            s sVar = (s) a.c(oVar.p);
            if (!rVar.b.H()) {
                rVar.v();
            }
            t tVar = (t) rVar.b;
            tVar.c = sVar.a();
            tVar.b |= 1;
            String str = oVar.q;
            if (str != null) {
                if (!rVar.b.H()) {
                    rVar.v();
                }
                t tVar2 = (t) rVar.b;
                tVar2.b |= 2;
                tVar2.d = str;
            }
            Integer num = oVar.s;
            if (num != null) {
                int iIntValue = num.intValue();
                if (!rVar.b.H()) {
                    rVar.v();
                }
                t tVar3 = (t) rVar.b;
                tVar3.b |= 4;
                tVar3.e = iIntValue;
            }
            t tVar4 = (t) rVar.t();
            if (!oVar2.b.H()) {
                oVar2.v();
            }
            p pVar = (p) oVar2.b;
            tVar4.getClass();
            pVar.c = tVar4;
            pVar.b |= 1;
            Throwable cause = oVar.r;
            if (cause != null) {
                com.google.android.libraries.navigation.internal.zt.ab abVar = (com.google.android.libraries.navigation.internal.zt.ab) com.google.android.libraries.navigation.internal.zt.ac.a.q();
                com.google.android.libraries.navigation.internal.zt.x xVarA = com.google.android.libraries.navigation.internal.zu.a.a(cause, true);
                if (!abVar.b.H()) {
                    abVar.v();
                }
                com.google.android.libraries.navigation.internal.zt.ac acVar = (com.google.android.libraries.navigation.internal.zt.ac) abVar.b;
                com.google.android.libraries.navigation.internal.zt.aa aaVar = (com.google.android.libraries.navigation.internal.zt.aa) xVarA.t();
                aaVar.getClass();
                acVar.c = aaVar;
                acVar.b |= 1;
                while (true) {
                    cause = cause.getCause();
                    if (cause == null) {
                        break;
                    }
                    com.google.android.libraries.navigation.internal.zt.x xVarA2 = com.google.android.libraries.navigation.internal.zu.a.a(cause, true);
                    if (!abVar.b.H()) {
                        abVar.v();
                    }
                    com.google.android.libraries.navigation.internal.zt.ac acVar2 = (com.google.android.libraries.navigation.internal.zt.ac) abVar.b;
                    com.google.android.libraries.navigation.internal.zt.aa aaVar2 = (com.google.android.libraries.navigation.internal.zt.aa) xVarA2.t();
                    aaVar2.getClass();
                    bz bzVar = acVar2.d;
                    if (!bzVar.c()) {
                        acVar2.d = bi.A(bzVar);
                    }
                    acVar2.d.add(aaVar2);
                }
                if (!oVar2.b.H()) {
                    oVar2.v();
                }
                p pVar2 = (p) oVar2.b;
                com.google.android.libraries.navigation.internal.zt.ac acVar3 = (com.google.android.libraries.navigation.internal.zt.ac) abVar.t();
                acVar3.getClass();
                pVar2.d = acVar3;
                pVar2.b |= 2;
            }
        }
        n nVar = (n) u.a.q();
        if (!nVar.b.H()) {
            nVar.v();
        }
        u uVar = (u) nVar.b;
        uVar.c = q.a(i);
        uVar.b |= 1;
        p pVar3 = (p) oVar2.t();
        if (!nVar.b.H()) {
            nVar.v();
        }
        u uVar2 = (u) nVar.b;
        pVar3.getClass();
        uVar2.f = pVar3;
        uVar2.b |= 16;
        return (u) nVar.t();
    }
}
