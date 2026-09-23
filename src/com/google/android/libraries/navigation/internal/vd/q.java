package com.google.android.libraries.navigation.internal.vd;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adq.ad;
import com.google.android.libraries.navigation.internal.adq.ae;
import com.google.android.libraries.navigation.internal.adq.ah;
import com.google.android.libraries.navigation.internal.cl.t;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.ol.ai;
import com.google.android.libraries.navigation.internal.po.fk;
import com.google.android.libraries.navigation.internal.qk.ak;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.fz;
import j$.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q implements com.google.android.libraries.navigation.internal.uh.c, com.google.android.libraries.navigation.internal.uh.o {
    static final Duration a = Duration.ofMillis(3500);
    static final Duration b = Duration.ofSeconds(10);
    public static final com.google.android.libraries.navigation.internal.afd.a r = com.google.android.libraries.navigation.internal.afe.i.A;
    public final com.google.android.libraries.navigation.internal.oa.k c;
    public final com.google.android.libraries.navigation.internal.op.i d;
    public final Context e;
    public final ai f;
    public final com.google.android.libraries.navigation.internal.qk.i g;
    public final com.google.android.libraries.navigation.internal.ia.e i;
    public final com.google.android.libraries.navigation.internal.iv.f j;
    public final com.google.android.libraries.navigation.internal.fz.d k;
    public final com.google.android.libraries.navigation.internal.mj.a l;
    public final com.google.android.libraries.navigation.internal.dx.i m;
    public final boolean o;
    public t p;
    public boolean q;
    private final com.google.android.libraries.navigation.internal.dx.o s;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List f637n = new ArrayList();
    public final com.google.android.libraries.navigation.internal.qk.r h = com.google.android.libraries.navigation.internal.fv.b.c();

    public q(com.google.android.libraries.navigation.internal.oa.k kVar, com.google.android.libraries.navigation.internal.op.i iVar, Context context, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.dx.i iVar2, com.google.android.libraries.navigation.internal.dx.o oVar) {
        this.c = kVar;
        this.d = iVar;
        this.e = context;
        this.f = ((fk) kVar.b()).H;
        this.g = ((fk) kVar.b()).K;
        this.q = kVar.K();
        this.i = eVar;
        this.j = fVar;
        this.k = dVar;
        this.l = aVar;
        this.m = iVar2;
        this.s = oVar;
        boolean z = dVar.n().c;
        this.o = z;
        if (z) {
            ar.q(iVar);
            throw null;
        }
    }

    public static void a(dy dyVar, int i) {
        com.google.android.libraries.navigation.internal.ado.i iVar = (com.google.android.libraries.navigation.internal.ado.i) com.google.android.libraries.navigation.internal.ado.j.a.q();
        ae aeVar = (ae) ah.a.q();
        aeVar.e(ad.s);
        ah ahVar = (ah) aeVar.t();
        if (!iVar.b.H()) {
            iVar.v();
        }
        com.google.android.libraries.navigation.internal.ado.j jVar = (com.google.android.libraries.navigation.internal.ado.j) iVar.b;
        ahVar.getClass();
        jVar.c = ahVar;
        jVar.b |= 1;
        com.google.android.libraries.navigation.internal.rp.c.h(dyVar, (com.google.android.libraries.navigation.internal.ado.j) iVar.t());
        com.google.android.libraries.navigation.internal.adf.m mVar = (com.google.android.libraries.navigation.internal.adf.m) com.google.android.libraries.navigation.internal.adf.n.a.q();
        if (!mVar.b.H()) {
            mVar.v();
        }
        com.google.android.libraries.navigation.internal.adf.n nVar = (com.google.android.libraries.navigation.internal.adf.n) mVar.b;
        nVar.b |= 8;
        nVar.d = i;
        com.google.android.libraries.navigation.internal.rp.c.f(dyVar, (com.google.android.libraries.navigation.internal.adf.n) mVar.t());
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void aC() {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void ay(Configuration configuration) {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.o
    public final void f(com.google.android.libraries.navigation.internal.ui.a aVar, com.google.android.libraries.navigation.internal.ui.a aVar2) {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final /* synthetic */ void h(Bundle bundle) {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void j(Bundle bundle) {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void k() {
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.ve.a.class, new r(com.google.android.libraries.navigation.internal.ve.a.class, this, ap.UI_THREAD));
        this.i.c(this, fzVar.a());
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void l() {
        this.i.e(this);
        Iterator it2 = this.f637n.iterator();
        while (it2.hasNext()) {
            ((ak) it2.next()).c();
        }
        this.f637n.clear();
        t tVar = this.p;
        if (tVar != null) {
            tVar.d();
            this.p = null;
        }
    }
}
