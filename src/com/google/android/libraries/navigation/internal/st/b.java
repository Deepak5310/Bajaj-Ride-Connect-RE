package com.google.android.libraries.navigation.internal.st;

import com.google.android.libraries.geo.navcore.guidance.impl.y;
import com.google.android.libraries.navigation.internal.aq.m;
import com.google.android.libraries.navigation.internal.bp.au;
import com.google.android.libraries.navigation.internal.db.r;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.ia.e;
import com.google.android.libraries.navigation.internal.sr.i;
import com.google.android.libraries.navigation.internal.sr.p;
import com.google.android.libraries.navigation.internal.sv.aw;
import com.google.android.libraries.navigation.internal.sv.bg;
import com.google.android.libraries.navigation.internal.sv.o;
import com.google.android.libraries.navigation.internal.tj.g;
import com.google.android.libraries.navigation.internal.tj.h;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements a {
    public final g a = new g();
    public final aw b;
    public final m c;
    public final bg d;
    private final e e;
    private final Executor f;
    private final y g;
    private final o h;

    public b(e eVar, Executor executor, y yVar, o oVar, aw awVar, m mVar, bg bgVar) {
        this.e = eVar;
        this.f = executor;
        this.g = yVar;
        this.h = oVar;
        this.b = awVar;
        this.c = mVar;
        this.d = bgVar;
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void a(com.google.android.libraries.navigation.internal.sp.c cVar) {
        fd fdVarK = fd.k(ap.NAVIGATION_INTERNAL, this.f);
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.cw.d.class, new d(0, com.google.android.libraries.navigation.internal.cw.d.class, this, ap.NAVIGATION_INTERNAL, d.b(ap.NAVIGATION_INTERNAL, fdVarK)));
        ap apVar = ap.NAVIGATION_INTERNAL;
        fzVar.b(p.class, new d(1, p.class, this, apVar, d.b(apVar, fdVarK)));
        ap apVar2 = ap.NAVIGATION_INTERNAL;
        fzVar.b(i.class, new d(2, i.class, this, apVar2, d.b(apVar2, fdVarK)));
        this.e.c(this, fzVar.a());
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void b(boolean z) {
        this.e.e(this);
    }

    @Override // com.google.android.libraries.navigation.internal.st.a
    public final void c(r rVar) {
        ap.NAVIGATION_INTERNAL.f();
        g gVar = this.a;
        gVar.a = rVar;
        gVar.a(rVar);
        f();
    }

    @Override // com.google.android.libraries.navigation.internal.st.a
    public final void d(com.google.android.libraries.navigation.internal.su.d dVar) {
        this.h.c();
        this.a.e = dVar.a();
        this.a.c = true;
        f();
        this.e.a(new com.google.android.libraries.navigation.internal.sq.a(dVar));
    }

    @Override // com.google.android.libraries.navigation.internal.st.a
    public final au e() {
        return au.a;
    }

    public final void f() {
        this.g.b(new h(this.a));
    }
}
