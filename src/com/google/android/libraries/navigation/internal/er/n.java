package com.google.android.libraries.navigation.internal.er;

import com.google.android.libraries.navigation.internal.aac.as;
import com.google.android.libraries.navigation.internal.acd.qp;
import com.google.android.libraries.navigation.internal.acd.rh;
import com.google.android.libraries.navigation.internal.adr.at;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.afl.lh;
import com.google.android.libraries.navigation.internal.afl.ll;
import com.google.android.libraries.navigation.internal.afl.mf;
import com.google.android.libraries.navigation.internal.afl.mp;
import com.google.android.libraries.navigation.internal.afl.mr;
import com.google.android.libraries.navigation.internal.afl.mt;
import com.google.android.libraries.navigation.internal.afl.mz;
import com.google.android.libraries.navigation.internal.km.am;
import com.google.android.libraries.navigation.internal.yx.bx;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n implements as {
    final /* synthetic */ cy a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.gg.e b;
    final /* synthetic */ com.google.android.libraries.navigation.internal.gg.i c;
    final /* synthetic */ String d = "getDirections";
    final /* synthetic */ com.google.android.libraries.navigation.internal.wt.m e;
    final /* synthetic */ q f;

    public n(q qVar, cy cyVar, com.google.android.libraries.navigation.internal.gg.e eVar, com.google.android.libraries.navigation.internal.gg.i iVar, com.google.android.libraries.navigation.internal.wt.m mVar) {
        this.a = cyVar;
        this.b = eVar;
        this.c = iVar;
        this.e = mVar;
        this.f = qVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(final Throwable th) {
        if (th instanceof CancellationException) {
            this.f.b.a(4, 71);
            this.b.a(this.c, com.google.android.libraries.navigation.internal.gg.o.b(th));
            return;
        }
        if (th instanceof p) {
            this.f.b.a(4, 72);
            this.b.a(this.c, com.google.android.libraries.navigation.internal.gg.o.b(th));
            return;
        }
        if (th instanceof com.google.android.libraries.navigation.internal.wt.i) {
            this.f.b.a(4, 73);
            this.b.a(this.c, com.google.android.libraries.navigation.internal.gg.o.j.c(th));
            return;
        }
        if (th instanceof Error) {
            com.google.android.libraries.navigation.internal.wt.m mVar = this.e;
            mVar.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.er.k
                @Override // java.lang.Runnable
                public final void run() {
                    Throwable th2 = th;
                    bx.c(th2);
                    throw new RuntimeException(th2);
                }
            });
        }
        this.f.b.a(4, 0);
        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 438)).p("Unexpected Throwable from offline backend");
        this.b.a(this.c, com.google.android.libraries.navigation.internal.gg.o.j.c(th));
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        cy cyVar = (cy) obj;
        boolean z = cyVar instanceof mf;
        com.google.android.libraries.navigation.internal.eu.a aVar = this.f.b;
        if (z) {
            aVar.a(4, -1);
            com.google.android.libraries.navigation.internal.kk.k kVar = (com.google.android.libraries.navigation.internal.kk.k) aVar.a.a(am.i);
            ll llVar = ((mf) cyVar).c;
            if (llVar == null) {
                llVar = ll.a;
            }
            lh lhVar = llVar.c;
            if (lhVar == null) {
                lhVar = lh.a;
            }
            at atVarB = at.b(lhVar.g);
            if (atVarB == null) {
                atVarB = at.SUCCESS;
            }
            kVar.a(atVarB.i);
        } else if (cyVar instanceof qp) {
            aVar.a(5, -1);
        } else if (cyVar instanceof rh) {
            aVar.a(6, -1);
        } else if (cyVar instanceof mr) {
            if (((mp) this.a).b == 0) {
                aVar.a(7, -1);
                ((com.google.android.libraries.navigation.internal.kk.k) aVar.a.a(am.j)).a(((mr) cyVar).b.size());
            }
        } else if (cyVar instanceof mz) {
            aVar.a(8, -1);
            com.google.android.libraries.navigation.internal.kk.k kVar2 = (com.google.android.libraries.navigation.internal.kk.k) aVar.a.a(am.k);
            mt mtVar = ((mz) cyVar).b;
            if (mtVar == null) {
                mtVar = mt.a;
            }
            kVar2.a(mtVar.b.size());
        }
        this.b.b(this.c, cyVar);
    }
}
