package com.google.android.libraries.navigation.environment;

import android.app.Service;
import com.google.android.libraries.geo.navcore.service.base.NavigationService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class s implements com.google.android.libraries.geo.navcore.service.base.u {
    private final m a;
    private com.google.android.libraries.navigation.internal.afr.k b;
    private com.google.android.libraries.navigation.internal.afr.k c;
    private com.google.android.libraries.navigation.internal.afr.k d;
    private com.google.android.libraries.navigation.internal.afr.k e;
    private com.google.android.libraries.navigation.internal.afr.k f;
    private com.google.android.libraries.navigation.internal.afr.k g;
    private com.google.android.libraries.navigation.internal.afr.k h;
    private com.google.android.libraries.navigation.internal.afr.k i;
    private com.google.android.libraries.navigation.internal.afr.k j;
    private com.google.android.libraries.navigation.internal.afr.k k;
    private com.google.android.libraries.navigation.internal.afr.k l;
    private com.google.android.libraries.navigation.internal.afr.k m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.google.android.libraries.navigation.internal.afr.k f103n;
    private com.google.android.libraries.navigation.internal.afr.k o;
    private com.google.android.libraries.navigation.internal.afr.k p;
    private com.google.android.libraries.navigation.internal.afr.k q;
    private com.google.android.libraries.navigation.internal.afr.k r;
    private com.google.android.libraries.navigation.internal.afr.k s;
    private com.google.android.libraries.navigation.internal.afr.k t;
    private com.google.android.libraries.navigation.internal.afr.k u;
    private com.google.android.libraries.navigation.internal.afr.k v;
    private com.google.android.libraries.navigation.internal.afr.k w;

    public s(m mVar, Service service) {
        this.a = mVar;
        this.b = com.google.android.libraries.navigation.internal.afr.g.b(service);
        this.c = new com.google.android.libraries.navigation.internal.ta.s(mVar.c);
        this.d = new com.google.android.libraries.navigation.internal.tp.e(mVar.au, mVar.av);
        this.e = new com.google.android.libraries.navigation.internal.wa.d(mVar.ab);
        this.f = com.google.android.libraries.navigation.internal.afr.e.d(new com.google.android.libraries.navigation.internal.wa.h(this.b, mVar.af, mVar.ae));
        com.google.android.libraries.navigation.internal.afr.k kVar = this.c;
        com.google.android.libraries.navigation.internal.afr.k kVar2 = this.d;
        com.google.android.libraries.navigation.internal.afr.k kVar3 = this.b;
        this.g = new com.google.android.libraries.navigation.internal.tn.h(kVar, kVar2, kVar3, this.e, com.google.android.libraries.navigation.internal.tn.j.a, this.f, mVar.aw, com.google.android.libraries.navigation.internal.tn.r.a, mVar.Q, mVar.e);
        this.h = new com.google.android.libraries.navigation.internal.tn.f(kVar3, mVar.at, this.g, mVar.m, mVar.T);
        this.i = com.google.android.libraries.navigation.internal.afr.e.d(new com.google.android.libraries.navigation.internal.tm.h(mVar.c, mVar.ae));
        com.google.android.libraries.navigation.internal.afr.k kVar4 = this.b;
        com.google.android.libraries.navigation.internal.afr.k kVar5 = mVar.ab;
        com.google.android.libraries.navigation.internal.wa.b bVar = new com.google.android.libraries.navigation.internal.wa.b(kVar4, kVar5);
        this.j = bVar;
        com.google.android.libraries.navigation.internal.afr.k kVar6 = this.c;
        com.google.android.libraries.navigation.internal.afr.k kVar7 = this.i;
        com.google.android.libraries.navigation.internal.afr.k kVar8 = this.d;
        com.google.android.libraries.navigation.internal.afr.k kVar9 = this.f;
        com.google.android.libraries.navigation.internal.afr.k kVar10 = mVar.X;
        com.google.android.libraries.navigation.internal.tm.f fVar = new com.google.android.libraries.navigation.internal.tm.f(kVar6, kVar7, bVar, kVar8, kVar9, kVar10, kVar4);
        this.k = fVar;
        com.google.android.libraries.navigation.internal.afr.k kVar11 = mVar.z;
        this.l = new com.google.android.libraries.navigation.internal.tm.d(fVar, kVar11);
        com.google.android.libraries.navigation.internal.wa.f fVar2 = new com.google.android.libraries.navigation.internal.wa.f(kVar5);
        this.m = fVar2;
        com.google.android.libraries.navigation.internal.to.d dVar = new com.google.android.libraries.navigation.internal.to.d(fVar2, kVar8, kVar9, kVar4);
        this.f103n = dVar;
        this.o = new com.google.android.libraries.navigation.internal.to.c(kVar11, dVar);
        this.p = com.google.android.libraries.navigation.internal.afr.e.d(new com.google.android.libraries.navigation.internal.tk.d(kVar4, mVar.e, kVar10, this.h, this.l, this.o, kVar9, mVar.h, kVar5));
        this.q = com.google.android.libraries.navigation.internal.afr.e.d(new com.google.android.libraries.navigation.internal.ta.t(mVar.c));
        com.google.android.libraries.navigation.internal.afr.k kVar12 = mVar.k;
        com.google.android.libraries.navigation.internal.afr.k kVar13 = mVar.q;
        com.google.android.libraries.navigation.internal.afr.k kVar14 = mVar.W;
        com.google.android.libraries.navigation.internal.afr.k kVar15 = mVar.V;
        com.google.android.libraries.navigation.internal.afr.k kVar16 = mVar.e;
        com.google.android.libraries.navigation.internal.afr.k kVar17 = mVar.s;
        com.google.android.libraries.navigation.internal.afr.k kVar18 = mVar.v;
        com.google.android.libraries.navigation.internal.afr.k kVar19 = mVar.P;
        com.google.android.libraries.navigation.internal.afr.k kVar20 = mVar.f102n;
        com.google.android.libraries.navigation.internal.afr.k kVar21 = mVar.f;
        com.google.android.libraries.navigation.internal.afr.k kVar22 = this.q;
        com.google.android.libraries.navigation.internal.afr.k kVar23 = mVar.U;
        com.google.android.libraries.navigation.internal.ch.d dVar2 = com.google.android.libraries.navigation.internal.ch.c.a;
        this.r = new com.google.android.libraries.navigation.internal.us.an(kVar12, kVar13, kVar14, kVar15, kVar16, kVar17, kVar18, kVar19, kVar20, kVar21, kVar22, kVar23, dVar2);
        this.s = new com.google.android.libraries.navigation.internal.us.ae(kVar12, kVar13, kVar14, kVar15, kVar16, kVar17, kVar18, kVar20, kVar21, kVar22, dVar2, mVar.ai, mVar.aj);
        com.google.android.libraries.navigation.internal.afr.k kVar24 = mVar.X;
        com.google.android.libraries.navigation.internal.us.d dVar3 = new com.google.android.libraries.navigation.internal.us.d(kVar12, kVar14, kVar15, kVar16, kVar13, kVar17, kVar18, kVar24, kVar20, kVar21, kVar22, kVar19, dVar2, mVar.g);
        this.t = dVar3;
        this.u = new com.google.android.libraries.navigation.internal.uq.b(this.r, this.s, dVar3, com.google.android.libraries.navigation.internal.ta.u.a);
        this.v = com.google.android.libraries.navigation.internal.afr.e.d(new com.google.android.libraries.navigation.internal.tk.r(mVar.aw, this.u, kVar24, this.b, mVar.au, mVar.av, mVar.ab));
        this.w = com.google.android.libraries.navigation.internal.afr.e.d(new com.google.android.libraries.navigation.internal.tk.n(com.google.android.libraries.navigation.internal.av.b.a, mVar.k, mVar.R, mVar.Y, mVar.f102n, this.p, this.v, mVar.ab, mVar.Z, mVar.S));
    }

    @Override // com.google.android.libraries.geo.navcore.service.base.u
    public final void a(NavigationService navigationService) {
        navigationService.a = (com.google.android.libraries.navigation.internal.tk.l) this.w.a();
        navigationService.b = this.a.bt();
        navigationService.c = (com.google.android.libraries.navigation.internal.kl.b) this.a.h.a();
        navigationService.d = (com.google.android.libraries.navigation.internal.tl.a) this.w.a();
        navigationService.e = com.google.android.libraries.navigation.internal.afr.e.b(this.a.X);
        navigationService.g = (com.google.android.libraries.geo.navcore.service.base.q) this.a.ak.a();
        navigationService.f = (com.google.android.libraries.navigation.internal.so.g) this.a.aa.a();
    }
}
