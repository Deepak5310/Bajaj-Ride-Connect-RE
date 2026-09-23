package com.google.android.libraries.navigation.internal.xd;

import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.zr.cf;
import com.google.android.libraries.navigation.internal.zr.cg;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements a {
    public final com.google.android.libraries.navigation.internal.jy.af a;
    public final ae b;
    private final Executor c;

    public d(com.google.android.libraries.navigation.internal.jy.af afVar, ae aeVar, Executor executor) {
        this.a = afVar;
        this.b = aeVar;
        this.c = executor;
    }

    @Override // com.google.android.libraries.navigation.internal.xd.a
    public final void a(com.google.android.libraries.navigation.internal.zp.n nVar) {
        com.google.android.libraries.navigation.internal.kd.d dVar = new com.google.android.libraries.navigation.internal.kd.d();
        dVar.b(nVar);
        this.a.n(dVar.a());
        if (com.google.android.libraries.navigation.internal.afw.m.c()) {
            this.b.a(nVar, null);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.xd.a
    public final void b(final com.google.android.libraries.navigation.internal.zp.n nVar) {
        this.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xd.b
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(nVar);
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.xd.a
    public final void c(final com.google.android.libraries.navigation.internal.zp.n nVar, final Boolean bool) {
        this.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xd.c
            @Override // java.lang.Runnable
            public final void run() {
                cg cgVar;
                Boolean bool2 = bool;
                if (bool2 != null) {
                    cf cfVar = (cf) cg.a.q();
                    bool2.booleanValue();
                    if (!cfVar.b.H()) {
                        cfVar.v();
                    }
                    cg cgVar2 = (cg) cfVar.b;
                    cgVar2.c = 3;
                    cgVar2.d = bool2;
                    cgVar = (cg) cfVar.t();
                } else {
                    cgVar = cg.a;
                }
                com.google.android.libraries.navigation.internal.zp.n nVar2 = nVar;
                d dVar = this.a;
                com.google.android.libraries.navigation.internal.kd.d dVar2 = new com.google.android.libraries.navigation.internal.kd.d();
                dVar2.b(nVar2);
                dVar2.a = cgVar;
                dVar.a.n(dVar2.a());
                if (com.google.android.libraries.navigation.internal.afw.m.c()) {
                    dVar.b.a(nVar2, bool2);
                }
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.xd.a
    public final void d(com.google.android.libraries.navigation.internal.zp.n nVar, List list) {
        cf cfVar = (cf) cg.a.q();
        if (!cfVar.b.H()) {
            cfVar.v();
        }
        cg cgVar = (cg) cfVar.b;
        bz bzVar = cgVar.e;
        if (!bzVar.c()) {
            cgVar.e = bi.A(bzVar);
        }
        com.google.android.libraries.navigation.internal.ael.b.m(list, cgVar.e);
        cg cgVar2 = (cg) cfVar.t();
        com.google.android.libraries.navigation.internal.jy.af afVar = this.a;
        com.google.android.libraries.navigation.internal.kd.d dVar = new com.google.android.libraries.navigation.internal.kd.d();
        dVar.b(nVar);
        dVar.a = cgVar2;
        afVar.n(dVar.a());
        if (com.google.android.libraries.navigation.internal.afw.m.c()) {
            this.b.b(nVar, list);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.xd.a
    public final void e() {
    }
}
