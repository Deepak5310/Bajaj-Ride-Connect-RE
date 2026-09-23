package com.google.android.libraries.navigation.internal.pu;

import android.graphics.Point;
import android.view.View;
import com.google.android.libraries.navigation.internal.po.fk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements com.google.android.libraries.navigation.internal.oo.a, com.google.android.libraries.navigation.internal.oo.b {
    public final Runnable a = null;
    private final com.google.android.libraries.navigation.internal.afo.a b;
    private final com.google.android.libraries.navigation.internal.afo.a c;
    private final com.google.android.libraries.navigation.internal.afo.a d;
    private final com.google.android.libraries.navigation.internal.afo.a e;
    private final com.google.android.libraries.navigation.internal.afo.a f;
    private final com.google.android.libraries.navigation.internal.afo.a g;
    private final com.google.android.libraries.navigation.internal.afo.a h;
    private final com.google.android.libraries.navigation.internal.afo.a i;
    private final com.google.android.libraries.navigation.internal.afo.a j;
    private final com.google.android.libraries.navigation.internal.afo.a k;
    private final com.google.android.libraries.navigation.internal.afo.a l;
    private final com.google.android.libraries.navigation.internal.yx.an m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.afo.a f534n;
    private final com.google.android.libraries.navigation.internal.afo.a o;
    private final com.google.android.libraries.navigation.internal.afo.a p;
    private final bq q;
    private final com.google.android.libraries.navigation.internal.pm.d r;
    private final com.google.android.libraries.navigation.internal.afo.a s;

    public c(com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.afo.a aVar4, com.google.android.libraries.navigation.internal.afo.a aVar5, com.google.android.libraries.navigation.internal.afo.a aVar6, com.google.android.libraries.navigation.internal.afo.a aVar7, com.google.android.libraries.navigation.internal.afo.a aVar8, com.google.android.libraries.navigation.internal.afo.a aVar9, com.google.android.libraries.navigation.internal.afo.a aVar10, com.google.android.libraries.navigation.internal.afo.a aVar11, com.google.android.libraries.navigation.internal.afo.a aVar12, com.google.android.libraries.navigation.internal.afo.a aVar13, com.google.android.libraries.navigation.internal.afo.a aVar14, com.google.android.libraries.navigation.internal.yx.an anVar, bq bqVar, com.google.android.libraries.navigation.internal.pm.d dVar, com.google.android.libraries.navigation.internal.afo.a aVar15) {
        this.b = aVar;
        this.c = aVar2;
        this.d = aVar3;
        this.e = aVar4;
        this.f = aVar5;
        this.g = aVar6;
        this.h = aVar7;
        this.i = aVar8;
        this.j = aVar9;
        this.k = aVar10;
        this.l = aVar11;
        this.f534n = aVar12;
        this.o = aVar13;
        this.p = aVar14;
        this.m = anVar;
        this.q = bqVar;
        this.r = dVar;
        this.s = aVar15;
    }

    @Override // com.google.android.libraries.navigation.internal.oo.a
    public final com.google.android.libraries.navigation.internal.u.d a() {
        return (com.google.android.libraries.navigation.internal.u.d) this.i.a();
    }

    @Override // com.google.android.libraries.navigation.internal.oo.a
    public final com.google.android.libraries.navigation.internal.oa.k b() {
        return (com.google.android.libraries.navigation.internal.oa.k) this.b.a();
    }

    @Override // com.google.android.libraries.navigation.internal.oo.a
    public final com.google.android.libraries.navigation.internal.ob.f c() {
        return (com.google.android.libraries.navigation.internal.ob.f) this.d.a();
    }

    @Override // com.google.android.libraries.navigation.internal.oo.a
    public final com.google.android.libraries.navigation.internal.pi.s d() {
        return (com.google.android.libraries.navigation.internal.pi.s) this.j.a();
    }

    @Override // com.google.android.libraries.navigation.internal.oo.a
    public final com.google.android.libraries.navigation.internal.rc.c e() {
        return (com.google.android.libraries.navigation.internal.rc.c) this.e.a();
    }

    @Override // com.google.android.libraries.navigation.internal.oo.b
    public final View f() {
        return ((com.google.android.libraries.navigation.internal.oa.k) this.b.a()).a();
    }

    @Override // com.google.android.libraries.navigation.internal.oo.b
    public final com.google.android.libraries.navigation.internal.op.i g() {
        return (com.google.android.libraries.navigation.internal.op.i) this.g.a();
    }

    @Override // com.google.android.libraries.navigation.internal.oo.b
    public final com.google.android.libraries.navigation.internal.oq.d h() {
        return (com.google.android.libraries.navigation.internal.oq.d) this.k.a();
    }

    @Override // com.google.android.libraries.navigation.internal.oo.b
    public final com.google.android.libraries.navigation.internal.ot.h i() {
        return (com.google.android.libraries.navigation.internal.ot.h) this.f.a();
    }

    @Override // com.google.android.libraries.navigation.internal.oo.b
    public final com.google.android.libraries.navigation.internal.ou.c j() {
        return (com.google.android.libraries.navigation.internal.ou.c) this.o.a();
    }

    @Override // com.google.android.libraries.navigation.internal.oo.b
    public final void k(com.google.android.libraries.navigation.internal.ot.k kVar) {
        com.google.android.libraries.navigation.internal.yx.an anVar = (com.google.android.libraries.navigation.internal.yx.an) this.l.a();
        if (!anVar.g()) {
            ((com.google.android.libraries.navigation.internal.ol.ai) this.c.a()).f(kVar.a());
        } else {
            com.google.android.libraries.navigation.internal.pm.f.b();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oo.b
    public final void l() {
        ((com.google.android.libraries.navigation.internal.oa.k) this.b.a()).l(new Point());
        ((com.google.android.libraries.navigation.internal.oa.k) this.b.a()).k();
        ((com.google.android.libraries.navigation.internal.u.d) this.i.a()).a();
    }

    @Override // com.google.android.libraries.navigation.internal.oo.b
    public final void m() {
        ((com.google.android.libraries.navigation.internal.u.d) this.i.a()).b();
        ((com.google.android.libraries.navigation.internal.oa.k) this.b.a()).m();
    }

    @Override // com.google.android.libraries.navigation.internal.oo.b
    public final void n() {
        ((com.google.android.libraries.navigation.internal.oa.k) this.b.a()).q();
        if (s().a()) {
            ((com.google.android.libraries.navigation.internal.pb.t) this.h.a()).c = (com.google.android.libraries.navigation.internal.pb.a) this.p.a();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oo.b
    public final void o() {
        ((com.google.android.libraries.navigation.internal.oa.k) this.b.a()).r();
    }

    @Override // com.google.android.libraries.navigation.internal.oo.b
    public final void p(com.google.android.libraries.navigation.internal.ot.k kVar) {
        com.google.android.libraries.navigation.internal.yx.an anVar = (com.google.android.libraries.navigation.internal.yx.an) this.l.a();
        if (!anVar.g()) {
            ((com.google.android.libraries.navigation.internal.ol.ai) this.c.a()).k(kVar.a());
        } else {
            com.google.android.libraries.navigation.internal.pm.f.c();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oo.b
    public final void q(com.google.android.libraries.navigation.internal.pb.k kVar) {
        ((fk) b().b()).K.h = kVar;
    }

    @Override // com.google.android.libraries.navigation.internal.oo.b
    public final void r(com.google.android.libraries.navigation.internal.adi.bo boVar) {
        ((com.google.android.libraries.navigation.internal.rl.a) this.f534n.a()).a(boVar);
    }

    @Override // com.google.android.libraries.navigation.internal.oo.b
    public final k s() {
        return (k) this.s.a();
    }
}
