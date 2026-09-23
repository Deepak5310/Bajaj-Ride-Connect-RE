package com.google.android.libraries.navigation.internal.sv;

import android.text.TextUtils;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.ace.hm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aq implements com.google.android.libraries.navigation.internal.sp.b {
    private final com.google.android.libraries.geo.navcore.guidance.impl.y a;
    private final com.google.android.libraries.navigation.internal.hn.r b;
    private com.google.android.libraries.navigation.internal.tj.i c = new com.google.android.libraries.navigation.internal.tj.i();

    public aq(com.google.android.libraries.geo.navcore.guidance.impl.y yVar, com.google.android.libraries.navigation.internal.hn.r rVar) {
        this.a = yVar;
        this.b = rVar;
    }

    private final void o(com.google.android.libraries.navigation.internal.sd.b bVar, com.google.android.libraries.navigation.internal.sd.a aVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("publishAggregatedGuidedNavState");
        try {
            this.a.a(new com.google.android.libraries.navigation.internal.tj.j(this.c), bVar, aVar);
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private final void p(com.google.android.libraries.navigation.internal.sd.b bVar, com.google.android.libraries.navigation.internal.sd.a aVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("publishGuidedNavState");
        try {
            this.a.c(new com.google.android.libraries.navigation.internal.tj.j(this.c), bVar, aVar);
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final synchronized void a(com.google.android.libraries.navigation.internal.sp.c cVar) {
        this.c = new com.google.android.libraries.navigation.internal.tj.i();
        com.google.android.libraries.navigation.internal.so.e eVar = cVar.c;
        if (eVar != null) {
            this.c.i = eVar.b;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final synchronized void b(boolean z) {
        this.c = new com.google.android.libraries.navigation.internal.tj.i();
    }

    final synchronized com.google.android.libraries.navigation.internal.db.r c() {
        return this.c.a;
    }

    final synchronized com.google.android.libraries.navigation.internal.tj.o d() {
        return this.c.j;
    }

    final synchronized void e(boolean z) {
        this.c.d = z;
    }

    public final synchronized void f(com.google.android.libraries.navigation.internal.sd.b bVar) {
        if (m()) {
            this.c.g = true;
            if (((hm) this.b.b()).f165n) {
                o(bVar, null);
            } else {
                p(bVar, null);
            }
        }
    }

    final synchronized void g(com.google.android.libraries.navigation.internal.tj.o oVar, com.google.android.libraries.navigation.internal.db.r rVar, com.google.android.libraries.navigation.internal.sd.b bVar) {
        j(oVar, rVar);
        if (((hm) this.b.b()).f165n) {
            o(bVar, null);
        } else {
            p(bVar, null);
        }
    }

    public final synchronized void h(com.google.android.libraries.navigation.internal.tj.o oVar, com.google.android.libraries.navigation.internal.db.r rVar, com.google.android.libraries.navigation.internal.sd.b bVar, com.google.android.libraries.navigation.internal.sd.a aVar) {
        String str;
        com.google.android.libraries.navigation.internal.tj.i iVar = this.c;
        iVar.j = oVar;
        iVar.a = rVar;
        iVar.a(rVar);
        com.google.android.libraries.navigation.internal.se.b bVarC = oVar.c();
        if (bVarC != null && ((str = this.c.b) == null || TextUtils.isEmpty(str))) {
            com.google.android.libraries.navigation.internal.bp.bs bsVarC = com.google.android.libraries.navigation.internal.bp.ca.c(bVarC.c);
            String strG = bsVarC == null ? null : bsVarC.g();
            if (strG != null) {
                this.c.b = strG;
            }
        }
        if (((hm) this.b.b()).f165n) {
            o(bVar, aVar);
        } else {
            p(bVar, aVar);
            o(bVar, aVar);
        }
    }

    final synchronized void i(boolean z) {
        if (m()) {
            com.google.android.libraries.navigation.internal.tj.i iVar = this.c;
            iVar.f = true;
            iVar.g = z;
        }
    }

    final synchronized void j(com.google.android.libraries.navigation.internal.tj.o oVar, com.google.android.libraries.navigation.internal.db.r rVar) {
        com.google.android.libraries.navigation.internal.tj.i iVar = this.c;
        iVar.j = oVar;
        if (rVar != null) {
            iVar.a = rVar;
        }
        iVar.f = false;
        iVar.g = false;
        iVar.h = false;
        if (oVar.a().Q == com.google.android.libraries.navigation.internal.bp.bf.ONLINE) {
            this.c.c = true;
        }
        this.c.e = false;
    }

    public final synchronized void k() {
        com.google.android.libraries.navigation.internal.tj.i iVar = this.c;
        iVar.f = false;
        iVar.g = false;
        iVar.h = true;
    }

    final void l(com.google.android.libraries.navigation.internal.tj.o oVar, com.google.android.libraries.navigation.internal.sd.b bVar, com.google.android.libraries.navigation.internal.sd.a aVar) {
        if (m()) {
            this.c.j = oVar;
            if (((hm) this.b.b()).f165n) {
                o(bVar, aVar);
            } else {
                p(bVar, aVar);
            }
        }
    }

    final synchronized boolean m() {
        return this.c.j != null;
    }

    final synchronized void n(int i, com.google.android.libraries.navigation.internal.tj.o oVar, com.google.android.libraries.navigation.internal.sd.b bVar) {
        if (m()) {
            this.c.j = oVar;
            if (i == com.google.android.libraries.geo.navcore.guidance.impl.as.b) {
                this.c.c = false;
            } else if (i == com.google.android.libraries.geo.navcore.guidance.impl.as.c) {
                this.c.e = true;
            }
            com.google.android.libraries.navigation.internal.tj.i iVar = this.c;
            iVar.f = false;
            iVar.g = false;
            if (((hm) this.b.b()).f165n) {
                o(bVar, null);
            } else {
                p(bVar, null);
            }
        }
    }
}
