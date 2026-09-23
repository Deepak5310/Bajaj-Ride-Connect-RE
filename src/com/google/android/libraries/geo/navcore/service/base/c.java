package com.google.android.libraries.geo.navcore.service.base;

import android.content.Context;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.ace.hm;
import com.google.android.libraries.navigation.internal.add.av;
import com.google.android.libraries.navigation.internal.add.aw;
import com.google.android.libraries.navigation.internal.add.bc;
import com.google.android.libraries.navigation.internal.add.bd;
import com.google.android.libraries.navigation.internal.bp.bh;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements com.google.android.libraries.navigation.internal.so.c {
    public final Executor a;
    public final com.google.android.libraries.navigation.internal.we.a b;
    public final com.google.android.libraries.navigation.internal.so.b c;
    public final com.google.android.libraries.navigation.internal.wk.c d;
    public final com.google.android.libraries.navigation.internal.rw.f e;
    private final Context f;
    private final com.google.android.libraries.navigation.internal.hn.r g;

    public c(Context context, com.google.android.libraries.navigation.internal.hn.r rVar, Executor executor, com.google.android.libraries.navigation.internal.we.a aVar, com.google.android.libraries.navigation.internal.so.b bVar, com.google.android.libraries.navigation.internal.wk.c cVar, com.google.android.libraries.navigation.internal.rw.f fVar) {
        this.f = context;
        this.g = rVar;
        this.a = executor;
        this.b = aVar;
        this.c = bVar;
        this.d = cVar;
        this.e = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.so.c
    public final void a(com.google.android.libraries.navigation.internal.so.e eVar) {
        if (d().booleanValue()) {
            this.c.a(eVar);
            return;
        }
        if (eVar.a == com.google.android.libraries.navigation.internal.si.e.FREE_NAV) {
            this.c.a(eVar);
            return;
        }
        bh bhVarB = eVar.b();
        av avVar = (av) aw.a.q();
        for (int i = 0; i < bhVarB.d(); i++) {
            String str = bhVarB.e(i).Z;
            if (i == ((com.google.android.libraries.navigation.internal.bp.m) bhVarB).a) {
                com.google.android.libraries.navigation.internal.ade.o oVar = (com.google.android.libraries.navigation.internal.ade.o) com.google.android.libraries.navigation.internal.ade.p.a.q();
                if (!oVar.b.H()) {
                    oVar.v();
                }
                com.google.android.libraries.navigation.internal.ade.p pVar = (com.google.android.libraries.navigation.internal.ade.p) oVar.b;
                str.getClass();
                pVar.b = str;
                if (!avVar.b.H()) {
                    avVar.v();
                }
                aw awVar = (aw) avVar.b;
                com.google.android.libraries.navigation.internal.ade.p pVar2 = (com.google.android.libraries.navigation.internal.ade.p) oVar.t();
                pVar2.getClass();
                awVar.c = pVar2;
                awVar.b |= 1;
            } else {
                com.google.android.libraries.navigation.internal.ade.o oVar2 = (com.google.android.libraries.navigation.internal.ade.o) com.google.android.libraries.navigation.internal.ade.p.a.q();
                if (!oVar2.b.H()) {
                    oVar2.v();
                }
                com.google.android.libraries.navigation.internal.ade.p pVar3 = (com.google.android.libraries.navigation.internal.ade.p) oVar2.b;
                str.getClass();
                pVar3.b = str;
                avVar.d(oVar2);
            }
        }
        aw awVar2 = (aw) avVar.t();
        this.d.b(bhVarB, com.google.android.libraries.navigation.internal.ade.n.a);
        com.google.android.libraries.navigation.internal.we.a aVar = this.b;
        bc bcVar = (bc) bd.a.q();
        if (!bcVar.b.H()) {
            bcVar.v();
        }
        bd bdVar = (bd) bcVar.b;
        awVar2.getClass();
        bdVar.c = awVar2;
        bdVar.b |= 1;
        az.o(aVar.a((bd) bcVar.t()), new b(this, awVar2), this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.so.c
    public final void b(boolean z) {
        this.c.b(z);
    }

    @Override // com.google.android.libraries.navigation.internal.so.c
    public final void c(String str) {
        throw null;
    }

    public final Boolean d() {
        return Boolean.valueOf(!((hm) this.g.b()).o);
    }
}
