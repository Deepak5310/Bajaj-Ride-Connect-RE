package com.google.android.libraries.navigation.internal.xd;

import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.ed;
import com.google.android.libraries.navigation.internal.yx.aq;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ag implements ae {
    public final com.google.android.libraries.navigation.internal.ky.o a;
    public final ab b;
    private final com.google.android.libraries.navigation.internal.xh.c c;
    private final com.google.android.libraries.navigation.internal.wx.c d;
    private final Executor e;

    public ag(com.google.android.libraries.navigation.internal.ky.o oVar, ab abVar, com.google.android.libraries.navigation.internal.xh.c cVar, com.google.android.libraries.navigation.internal.wx.c cVar2, Executor executor) {
        this.a = oVar;
        this.b = abVar;
        this.c = cVar;
        this.d = cVar2;
        this.e = executor;
    }

    private final void c(com.google.android.libraries.navigation.internal.aev.a aVar) {
        final com.google.android.libraries.navigation.internal.aev.g gVar = (com.google.android.libraries.navigation.internal.aev.g) com.google.android.libraries.navigation.internal.aev.h.a.q();
        if (!gVar.b.H()) {
            gVar.v();
        }
        com.google.android.libraries.navigation.internal.aev.h hVar = (com.google.android.libraries.navigation.internal.aev.h) gVar.b;
        com.google.android.libraries.navigation.internal.aev.d dVar = (com.google.android.libraries.navigation.internal.aev.d) aVar.t();
        dVar.getClass();
        hVar.d = dVar;
        hVar.c = 5;
        com.google.android.libraries.navigation.internal.xh.c cVar = this.c;
        com.google.android.libraries.navigation.internal.wx.c cVar2 = this.d;
        final bj bjVarB = cVar.b();
        final bj bjVarA = cVar2.a();
        az.a(bjVarA, bjVarB).b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xd.af
            @Override // java.lang.Runnable
            public final void run() {
                ed edVarC;
                com.google.android.libraries.navigation.internal.xh.b bVar = (com.google.android.libraries.navigation.internal.xh.b) com.google.android.libraries.navigation.internal.ww.a.a(bjVarB, null);
                String str = (String) com.google.android.libraries.navigation.internal.ww.a.a(bjVarA, null);
                com.google.android.libraries.navigation.internal.aev.g gVar2 = gVar;
                if (bVar != null && bVar.a() != 0) {
                    long jA = bVar.a();
                    if (!gVar2.b.H()) {
                        gVar2.v();
                    }
                    com.google.android.libraries.navigation.internal.aev.h hVar2 = (com.google.android.libraries.navigation.internal.aev.h) gVar2.b;
                    com.google.android.libraries.navigation.internal.aev.h hVar3 = com.google.android.libraries.navigation.internal.aev.h.a;
                    hVar2.b |= 4;
                    hVar2.g = jA;
                }
                if (!aq.c(str)) {
                    com.google.android.libraries.navigation.internal.aeu.a aVar2 = (com.google.android.libraries.navigation.internal.aeu.a) com.google.android.libraries.navigation.internal.aeu.b.a.q();
                    if (!aVar2.b.H()) {
                        aVar2.v();
                    }
                    com.google.android.libraries.navigation.internal.aeu.b bVar2 = (com.google.android.libraries.navigation.internal.aeu.b) aVar2.b;
                    str.getClass();
                    bVar2.b |= 4;
                    bVar2.c = str;
                    com.google.android.libraries.navigation.internal.aeu.b bVar3 = (com.google.android.libraries.navigation.internal.aeu.b) aVar2.t();
                    if (!gVar2.b.H()) {
                        gVar2.v();
                    }
                    com.google.android.libraries.navigation.internal.aev.h hVar4 = (com.google.android.libraries.navigation.internal.aev.h) gVar2.b;
                    com.google.android.libraries.navigation.internal.aev.h hVar5 = com.google.android.libraries.navigation.internal.aev.h.a;
                    bVar3.getClass();
                    hVar4.h = bVar3;
                    hVar4.b |= 8;
                }
                ag agVar = this.a;
                String strA = agVar.b.a();
                if (!gVar2.b.H()) {
                    gVar2.v();
                }
                com.google.android.libraries.navigation.internal.aev.h hVar6 = (com.google.android.libraries.navigation.internal.aev.h) gVar2.b;
                com.google.android.libraries.navigation.internal.aev.h hVar7 = com.google.android.libraries.navigation.internal.aev.h.a;
                strA.getClass();
                hVar6.b |= 2;
                hVar6.f = strA;
                Method method = com.google.android.libraries.navigation.internal.aen.d.a;
                if (method != null) {
                    try {
                        Object objInvoke = method.invoke(null, null);
                        edVarC = com.google.android.libraries.navigation.internal.aen.d.c(((Long) com.google.android.libraries.navigation.internal.aen.d.b.invoke(objInvoke, null)).longValue(), ((Integer) com.google.android.libraries.navigation.internal.aen.d.c.invoke(objInvoke, null)).intValue());
                    } catch (Throwable th) {
                        throw new AssertionError(th);
                    }
                } else {
                    edVarC = com.google.android.libraries.navigation.internal.aen.d.b(System.currentTimeMillis());
                }
                if (!gVar2.b.H()) {
                    gVar2.v();
                }
                com.google.android.libraries.navigation.internal.aev.h hVar8 = (com.google.android.libraries.navigation.internal.aev.h) gVar2.b;
                edVarC.getClass();
                hVar8.e = edVarC;
                hVar8.b |= 1;
                agVar.a.f((com.google.android.libraries.navigation.internal.aev.h) gVar2.t()).c();
            }
        }, this.e);
    }

    @Override // com.google.android.libraries.navigation.internal.xd.ae
    public final void a(com.google.android.libraries.navigation.internal.zp.n nVar, Boolean bool) {
        com.google.android.libraries.navigation.internal.aev.a aVar = (com.google.android.libraries.navigation.internal.aev.a) com.google.android.libraries.navigation.internal.aev.d.a.q();
        if (!aVar.b.H()) {
            aVar.v();
        }
        ((com.google.android.libraries.navigation.internal.aev.d) aVar.b).d = nVar.a;
        if (bool != null) {
            bool.booleanValue();
            if (!aVar.b.H()) {
                aVar.v();
            }
            com.google.android.libraries.navigation.internal.aev.d dVar = (com.google.android.libraries.navigation.internal.aev.d) aVar.b;
            dVar.b = 3;
            dVar.c = bool;
        }
        c(aVar);
    }

    @Override // com.google.android.libraries.navigation.internal.xd.ae
    public final void b(com.google.android.libraries.navigation.internal.zp.n nVar, List list) {
        com.google.android.libraries.navigation.internal.aev.a aVar = (com.google.android.libraries.navigation.internal.aev.a) com.google.android.libraries.navigation.internal.aev.d.a.q();
        if (!aVar.b.H()) {
            aVar.v();
        }
        ((com.google.android.libraries.navigation.internal.aev.d) aVar.b).d = nVar.a;
        com.google.android.libraries.navigation.internal.aev.b bVar = (com.google.android.libraries.navigation.internal.aev.b) com.google.android.libraries.navigation.internal.aev.c.a.q();
        if (!bVar.b.H()) {
            bVar.v();
        }
        com.google.android.libraries.navigation.internal.aev.c cVar = (com.google.android.libraries.navigation.internal.aev.c) bVar.b;
        bz bzVar = cVar.b;
        if (!bzVar.c()) {
            cVar.b = bi.A(bzVar);
        }
        com.google.android.libraries.navigation.internal.ael.b.m(list, cVar.b);
        if (!aVar.b.H()) {
            aVar.v();
        }
        com.google.android.libraries.navigation.internal.aev.d dVar = (com.google.android.libraries.navigation.internal.aev.d) aVar.b;
        com.google.android.libraries.navigation.internal.aev.c cVar2 = (com.google.android.libraries.navigation.internal.aev.c) bVar.t();
        cVar2.getClass();
        dVar.c = cVar2;
        dVar.b = 4;
        c(aVar);
    }
}
