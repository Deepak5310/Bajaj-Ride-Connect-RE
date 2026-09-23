package com.google.android.libraries.navigation.internal.sv;

import com.google.android.libraries.navigation.internal.afl.oa;
import com.google.android.libraries.navigation.internal.afl.ob;
import com.google.android.libraries.navigation.internal.afl.oc;
import com.google.android.libraries.navigation.internal.afl.oe;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bf extends a implements com.google.android.libraries.navigation.internal.gg.e {
    private final com.google.android.libraries.navigation.internal.tj.ab b;
    private final Executor c;
    private final com.google.android.libraries.navigation.internal.gs.b d;

    public bf(com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.gs.b bVar, com.google.android.libraries.navigation.internal.so.a aVar, Executor executor, com.google.android.libraries.navigation.internal.tj.ac acVar, aw awVar, com.google.android.libraries.navigation.internal.sr.p pVar) {
        super(awVar, eVar);
        this.d = bVar;
        this.c = executor;
        com.google.android.libraries.navigation.internal.tt.d dVar = pVar.a;
        boolean z = false;
        if (aVar != null && aVar.f(dVar)) {
            z = true;
        }
        com.google.android.libraries.navigation.internal.dx.o oVar = (com.google.android.libraries.navigation.internal.dx.o) acVar.a.a();
        oVar.getClass();
        this.b = new com.google.android.libraries.navigation.internal.tj.ab(oVar, dVar, z, false, null);
    }

    private final void g(oe oeVar, com.google.android.libraries.navigation.internal.fw.g gVar) {
        if (oeVar == null || gVar != null) {
            c().a = 2;
            this.a.a(new com.google.android.libraries.navigation.internal.sr.m(c()));
        } else if (oeVar.b.isEmpty()) {
            this.b.d = true;
            e();
        } else {
            oa oaVar = (oa) oeVar.b.get(0);
            this.b.c = com.google.android.libraries.navigation.internal.tt.d.H(oaVar);
            e();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final void a(com.google.android.libraries.navigation.internal.gg.i iVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        g(null, oVar.p);
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final /* bridge */ /* synthetic */ void b(com.google.android.libraries.navigation.internal.gg.i iVar, Object obj) {
        g((oe) obj, null);
    }

    @Override // com.google.android.libraries.navigation.internal.sv.a
    protected final /* synthetic */ com.google.android.libraries.navigation.internal.tj.w c() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.sv.a
    protected final void d() {
        ob obVar = (ob) oc.a.q();
        obVar.c(this.b.c.b());
        if (!obVar.b.H()) {
            obVar.v();
        }
        oc.e((oc) obVar.b);
        this.d.a((oc) obVar.t(), this, this.c);
    }
}
