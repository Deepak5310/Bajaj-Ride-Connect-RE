package com.google.android.libraries.navigation.internal.bm;

import android.content.Context;
import com.google.android.libraries.navigation.environment.ct;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.cl.be;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.joda.time.Instant;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class o implements com.google.android.libraries.navigation.internal.az.b, com.google.android.libraries.navigation.internal.pq.a {
    private static final com.google.android.libraries.navigation.internal.zb.j x = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.bm.o");
    public final Context a;
    public final com.google.android.libraries.navigation.internal.oa.k b;
    public final com.google.android.libraries.navigation.internal.op.i c;
    public final com.google.android.libraries.navigation.internal.qk.w d;
    public final com.google.android.libraries.navigation.internal.s.b e;
    public final com.google.android.libraries.navigation.internal.ia.e f;
    public final am g;
    public final ap h;
    public final com.google.android.libraries.navigation.internal.ed.b i;
    public final com.google.android.libraries.navigation.internal.sf.b j;
    public final Executor k;
    public final com.google.android.libraries.navigation.internal.oi.c l;
    public final com.google.android.libraries.navigation.internal.hn.r m;
    public ar o;
    public boolean q;
    public com.google.android.libraries.navigation.internal.oe.al r;
    public boolean s;
    public final com.google.android.libraries.navigation.internal.cr.f u;
    public final ct v;
    private final b y;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f346n = new Object();
    public final List p = new ArrayList();
    public final com.google.android.libraries.navigation.internal.nt.t t = new l(this);
    final m w = new m(this);

    public o(Context context, com.google.android.libraries.navigation.internal.oa.k kVar, com.google.android.libraries.navigation.internal.op.i iVar, com.google.android.libraries.navigation.internal.qk.w wVar, com.google.android.libraries.navigation.internal.cr.f fVar, com.google.android.libraries.navigation.internal.s.b bVar, am amVar, ap apVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.ed.b bVar2, ct ctVar, com.google.android.libraries.navigation.internal.sf.b bVar3, b bVar4, Executor executor, com.google.android.libraries.navigation.internal.hn.r rVar, com.google.android.libraries.navigation.internal.oi.c cVar) {
        this.b = kVar;
        this.c = iVar;
        this.d = wVar;
        this.u = fVar;
        this.e = bVar;
        this.g = amVar;
        this.h = apVar;
        this.y = bVar4;
        this.f = eVar;
        this.a = context;
        this.i = bVar2;
        this.v = ctVar;
        this.j = bVar3;
        this.k = executor;
        this.m = rVar;
        this.l = cVar;
    }

    @Override // com.google.android.libraries.navigation.internal.az.b
    public final void a() {
        final ak akVar;
        com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
        com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
        if (this.b.d.isDone()) {
            am amVar = this.g;
            com.google.android.libraries.navigation.internal.nj.i.b();
            synchronized (amVar.U) {
                an anVar = amVar.V;
                anVar.a = null;
                anVar.b = null;
                anVar.c = true;
                amVar.f();
                synchronized (amVar.X) {
                    akVar = amVar.Y;
                    amVar.g();
                }
            }
            if (akVar != null) {
                com.google.android.libraries.navigation.internal.hx.ag agVar = amVar.h;
                Objects.requireNonNull(akVar);
                agVar.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.bm.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i = am.an;
                        akVar.a();
                    }
                });
            }
            this.h.a();
            if (this.s) {
                this.l.d(false);
                this.l.c(false);
                this.s = false;
            }
            this.e.d(this.p);
            this.p.clear();
            this.e.c();
            this.r = null;
            Instant.now();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.az.b
    public final void b(be beVar) {
        com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
        this.g.o(beVar);
    }

    @Override // com.google.android.libraries.navigation.internal.az.b
    public final void c(com.google.android.libraries.navigation.internal.bt.h hVar) {
        com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
        this.q = false;
        com.google.android.libraries.navigation.internal.nj.i.b();
        this.g.q(hVar, false, this.w);
        bg bgVarF = ((com.google.android.libraries.navigation.internal.bt.b) hVar).a.f();
        boolean z = bgVarF == null;
        ap apVar = this.h;
        long j = bgVarF != null ? bgVarF.Y : apVar.c;
        apVar.b = !z;
        apVar.c = j;
        ct ctVar = apVar.d;
        Instant.now();
    }

    @Override // com.google.android.libraries.navigation.internal.az.b
    public final void d() {
        com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
        synchronized (this.f346n) {
            ar arVar = this.o;
            if (arVar != null) {
                arVar.c();
            }
        }
    }

    public final void e(com.google.android.libraries.navigation.internal.oe.al alVar, boolean z) {
        com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
        this.y.b(alVar, z);
        this.q = false;
    }

    @Override // com.google.android.libraries.navigation.internal.pq.a
    public final void f() {
        this.k.execute(new j(this));
    }

    @Override // com.google.android.libraries.navigation.internal.pq.a
    public final void g(com.google.android.libraries.navigation.internal.pt.a aVar) {
        this.k.execute(new j(this));
    }

    @Override // com.google.android.libraries.navigation.internal.pq.a
    public final void h() {
    }

    @Override // com.google.android.libraries.navigation.internal.pq.a
    public final void i() {
        this.k.execute(new j(this));
    }

    final void j() {
        this.g.r(this.w);
        Instant.now();
    }
}
