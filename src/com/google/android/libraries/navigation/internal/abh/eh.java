package com.google.android.libraries.navigation.internal.abh;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.libraries.navigation.internal.afl.no;
import com.google.android.libraries.navigation.internal.afl.qj;
import org.joda.time.DateTimeConstants;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class eh implements com.google.android.libraries.navigation.internal.om.p {
    public qj a = qj.a;
    public com.google.android.libraries.navigation.internal.adi.af b = com.google.android.libraries.navigation.internal.adi.af.a;
    public final com.google.android.libraries.navigation.internal.om.v c;
    final /* synthetic */ ei d;

    public eh(ei eiVar) {
        this.d = eiVar;
        com.google.android.libraries.navigation.internal.om.t tVar = new com.google.android.libraries.navigation.internal.om.t();
        com.google.android.libraries.navigation.internal.yz.fw fwVar = new com.google.android.libraries.navigation.internal.yz.fw();
        com.google.android.libraries.navigation.internal.yz.fw fwVar2 = new com.google.android.libraries.navigation.internal.yz.fw();
        fwVar.c(com.google.android.libraries.navigation.internal.adi.bo.ROADMAP);
        fwVar2.c(com.google.android.libraries.navigation.internal.adi.bo.ROADMAP);
        if (com.google.android.libraries.navigation.internal.afu.j.a.a().c()) {
            fwVar.c(com.google.android.libraries.navigation.internal.adi.bo.ROADMAP_DARK);
        }
        if (com.google.android.libraries.navigation.internal.afu.j.a.a().a()) {
            fwVar.c(com.google.android.libraries.navigation.internal.adi.bo.NAVIGATION);
        }
        if (com.google.android.libraries.navigation.internal.afu.j.a.a().b()) {
            fwVar.c(com.google.android.libraries.navigation.internal.adi.bo.NAVIGATION_LOW_LIGHT);
        }
        if (com.google.android.libraries.navigation.internal.afu.j.a.a().e()) {
            fwVar2.c(com.google.android.libraries.navigation.internal.adi.bo.ROADMAP_DARK);
        }
        tVar.a = fwVar.i();
        tVar.b = fwVar2.i();
        tVar.c = com.google.android.libraries.navigation.internal.afu.j.a.a().d();
        this.c = new com.google.android.libraries.navigation.internal.om.v(tVar);
    }

    @Override // com.google.android.libraries.navigation.internal.om.p
    public final com.google.android.libraries.navigation.internal.om.j a() {
        com.google.android.libraries.navigation.internal.om.a aVar = new com.google.android.libraries.navigation.internal.om.a();
        aVar.c(65.0f);
        aVar.b(true);
        return aVar.a();
    }

    @Override // com.google.android.libraries.navigation.internal.om.p
    public final com.google.android.libraries.navigation.internal.om.l b() {
        com.google.android.libraries.navigation.internal.om.c cVar = new com.google.android.libraries.navigation.internal.om.c();
        cVar.R(true);
        cVar.Q(true);
        cVar.o(true);
        cVar.r(true);
        cVar.k(false);
        cVar.w(false);
        cVar.J(false);
        cVar.s(false);
        cVar.m(false);
        cVar.v(false);
        cVar.G(false);
        cVar.i(false);
        cVar.n(false);
        cVar.H(false);
        cVar.D(false);
        cVar.l(false);
        cVar.N(false);
        cVar.d(com.google.android.libraries.navigation.internal.ace.ff.SEND_PIPE_METADATA);
        cVar.L(false);
        cVar.M(false);
        cVar.O(false);
        cVar.u(false);
        cVar.g(false);
        cVar.P(PlaybackStateCompat.ACTION_PREPARE_FROM_URI);
        cVar.b(false);
        cVar.h(false);
        cVar.S();
        cVar.F();
        cVar.t(false);
        cVar.e(com.google.android.libraries.navigation.internal.yx.a.a);
        cVar.C(false);
        cVar.j(false);
        cVar.T(-1L);
        cVar.I(false);
        cVar.f(false);
        cVar.K(false);
        cVar.c(false);
        cVar.A(false);
        cVar.x(false);
        cVar.z(false);
        cVar.B(false);
        cVar.y(false);
        cVar.q(false);
        cVar.p(false);
        cVar.E(false);
        cVar.U(false);
        return cVar.a();
    }

    @Override // com.google.android.libraries.navigation.internal.om.p
    public final synchronized com.google.android.libraries.navigation.internal.om.n c() {
        com.google.android.libraries.navigation.internal.om.e eVar;
        eVar = new com.google.android.libraries.navigation.internal.om.e();
        eVar.k(this.a.h);
        eVar.l(false);
        eVar.d(false);
        eVar.c(com.google.android.libraries.navigation.internal.agg.fd.a);
        eVar.r(false);
        eVar.q(30);
        eVar.f(false);
        eVar.b(false);
        eVar.v(0);
        eVar.u(false);
        eVar.n(false);
        eVar.m(false);
        eVar.s(false);
        eVar.j(false);
        eVar.o(false);
        eVar.t(false);
        eVar.h(false);
        eVar.p(0);
        eVar.g(false);
        eVar.i(false);
        eVar.e(false);
        return eVar.a();
    }

    @Override // com.google.android.libraries.navigation.internal.om.p
    public final synchronized com.google.android.libraries.navigation.internal.om.v d() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.om.p
    public final synchronized com.google.android.libraries.navigation.internal.om.x e() {
        com.google.android.libraries.navigation.internal.om.g gVar;
        gVar = new com.google.android.libraries.navigation.internal.om.g();
        gVar.d(true);
        gVar.b(false);
        gVar.g(1.5f);
        gVar.i(0.0f);
        gVar.o(300);
        gVar.j(false);
        gVar.c(false);
        gVar.n(no.b);
        gVar.k(DateTimeConstants.MINUTES_PER_WEEK);
        gVar.m(43200);
        gVar.p(false);
        gVar.e(false);
        gVar.f(false);
        gVar.h(false);
        gVar.l(false);
        return gVar.a();
    }

    @Override // com.google.android.libraries.navigation.internal.om.p
    public final synchronized com.google.android.libraries.navigation.internal.adi.af f() {
        return this.b;
    }

    public final void g(com.google.android.libraries.navigation.internal.ace.gm gmVar) {
        boolean zE;
        synchronized (this) {
            zE = this.c.e(gmVar);
        }
        if (zE) {
            for (Runnable runnable : this.d.b.values()) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }
}
