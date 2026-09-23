package com.google.android.libraries.navigation.internal.ub;

import android.animation.TimeInterpolator;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.afl.fd;
import com.google.android.libraries.navigation.internal.afl.ff;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.db.r;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.jy.t;
import com.google.android.libraries.navigation.internal.oe.an;
import com.google.android.libraries.navigation.internal.pi.ac;
import com.google.android.libraries.navigation.internal.pi.p;
import com.google.android.libraries.navigation.internal.pi.s;
import com.google.android.libraries.navigation.internal.xe.ah;
import com.google.android.libraries.navigation.internal.xe.bp;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.zs.aq;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class c implements com.google.android.libraries.navigation.internal.uh.c, p {
    static final AccelerateDecelerateInterpolator a = new AccelerateDecelerateInterpolator();
    static final LinearInterpolator b = new LinearInterpolator();
    static final Float c = Float.valueOf(15.5f);
    private final b A;
    private com.google.android.libraries.navigation.internal.uc.g B;
    private fd C;
    private boolean D;
    private final a E;
    protected final com.google.android.libraries.navigation.internal.oa.k d;
    protected final com.google.android.libraries.navigation.internal.og.b e;
    protected final com.google.android.libraries.navigation.internal.oq.d f;
    public final com.google.android.libraries.navigation.internal.p.a g;
    protected final Resources h;
    public final com.google.android.libraries.navigation.internal.dq.c i;
    protected final com.google.android.libraries.navigation.internal.uh.d j;
    public ev k;
    protected com.google.android.libraries.navigation.internal.uc.p l;
    protected final com.google.android.libraries.navigation.internal.uc.f m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected com.google.android.libraries.navigation.internal.uc.g f610n;
    public com.google.android.libraries.navigation.internal.ue.b o;
    public final i p;
    protected al q;
    protected r r;
    protected Float s;
    public boolean t;
    public boolean u;
    private final com.google.android.libraries.navigation.internal.afo.a v;
    private final com.google.android.libraries.navigation.internal.afo.a w;
    private final Executor x;
    private final s y;
    private final com.google.android.libraries.navigation.internal.ue.c z;

    public c(Resources resources, com.google.android.libraries.navigation.internal.oa.k kVar, com.google.android.libraries.navigation.internal.og.b bVar, com.google.android.libraries.navigation.internal.oq.d dVar, com.google.android.libraries.navigation.internal.p.a aVar, com.google.android.libraries.navigation.internal.dq.c cVar, Executor executor, s sVar, com.google.android.libraries.navigation.internal.ue.c cVar2, com.google.android.libraries.navigation.internal.uh.d dVar2, com.google.android.libraries.navigation.internal.uc.f fVar, com.google.android.libraries.navigation.internal.fz.d dVar3, t tVar, com.google.android.libraries.navigation.internal.si.e eVar, float f, b bVar2, com.google.android.libraries.navigation.internal.uc.t tVar2, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.afo.a aVar3) {
        int i = ev.d;
        this.k = lv.a;
        this.E = new a();
        this.u = true;
        this.f = dVar;
        this.e = bVar;
        this.d = kVar;
        this.g = aVar;
        this.i = cVar;
        this.x = executor;
        this.y = sVar;
        this.z = cVar2;
        this.j = dVar2;
        this.h = resources;
        this.m = fVar;
        this.A = bVar2;
        this.f610n = com.google.android.libraries.navigation.internal.uc.g.FREE_MOVEMENT;
        this.B = com.google.android.libraries.navigation.internal.uc.g.FREE_MOVEMENT;
        this.p = new i(dVar3, tVar, eVar, dVar.b(), tVar2, f);
        this.v = aVar2;
        this.w = aVar3;
    }

    @Override // com.google.android.libraries.navigation.internal.pi.p
    public final void aB(ac acVar) {
        int iOrdinal = acVar.a.ordinal();
        if (iOrdinal == 0) {
            this.D = true;
        } else if (iOrdinal == 1 || iOrdinal == 2) {
            this.D = false;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final /* synthetic */ void aC() {
    }

    protected final void ax() {
        this.i.e(com.google.android.libraries.navigation.internal.ql.a.OFF);
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void ay(Configuration configuration) {
        d(true);
    }

    final com.google.android.libraries.navigation.internal.pd.d b(boolean z, List list) {
        if (list.isEmpty()) {
            return null;
        }
        Point pointA = this.g.a();
        return c().d(z ? this.r : null, list, ((bp) this.g).e(), pointA.x, pointA.y, this.h.getDisplayMetrics().density);
    }

    protected final com.google.android.libraries.navigation.internal.uc.l c() {
        fd fdVar;
        boolean zC = ((com.google.android.libraries.navigation.internal.oo.b) this.w.a()).s().c() ? ((com.google.android.libraries.navigation.internal.ok.b) this.v.a()).c(com.google.android.libraries.navigation.internal.ob.h.SATELLITE) : this.d.J(com.google.android.libraries.navigation.internal.ob.h.SATELLITE);
        i iVar = this.p;
        if (this.t) {
            fdVar = fd.CAMERA_2D_HEADING_UP;
        } else if (t()) {
            fdVar = fd.CAMERA_2D_NORTH_UP;
        } else {
            fd fdVar2 = this.C;
            fdVar = (fdVar2 == null || fdVar2.equals(fd.UNKNOWN_CAMERA_TYPE)) ? fd.CAMERA_3D : this.C;
        }
        boolean z = this.q == al.WALK;
        com.google.android.libraries.navigation.internal.uc.a aVar = new com.google.android.libraries.navigation.internal.uc.a();
        aVar.b(fdVar);
        aVar.c(zC);
        aVar.d(z);
        com.google.android.libraries.navigation.internal.uc.l lVar = (com.google.android.libraries.navigation.internal.uc.l) iVar.a.get(aVar.a());
        ar.q(lVar);
        return lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized com.google.android.libraries.navigation.internal.uc.n d(boolean z) {
        com.google.android.libraries.navigation.internal.uc.n nVarE;
        com.google.android.libraries.navigation.internal.pd.d dVarB;
        com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("AbstractCameraController.updateCamera");
        try {
            if (this.D) {
                nVarE = com.google.android.libraries.navigation.internal.uc.n.b;
            } else {
                int i = this.d.c().a;
                int iOrdinal = this.f610n.ordinal();
                if (iOrdinal != 0) {
                    switch (iOrdinal) {
                        case 2:
                            if (i != 6 || this.B != com.google.android.libraries.navigation.internal.uc.g.OVERVIEW) {
                                q(z);
                            }
                            break;
                        case 3:
                            r(z);
                            break;
                        case 4:
                        case 5:
                            if (i != 6 && this.l != null) {
                                throw null;
                            }
                            break;
                        case 6:
                            y();
                            break;
                        case 7:
                            if (!this.k.isEmpty()) {
                                ArrayList arrayListE = hx.e(((lv) this.k).c);
                                ev evVar = this.k;
                                int i2 = ((lv) evVar).c;
                                for (int i3 = 0; i3 < i2; i3++) {
                                    com.google.android.libraries.navigation.internal.uc.r rVar = (com.google.android.libraries.navigation.internal.uc.r) evVar.get(i3);
                                    bg bgVar = rVar.a;
                                    an anVar = bgVar == null ? null : new an(bgVar.m, bgVar.h(rVar.b), bgVar.g(rVar.c) + 1);
                                    if (anVar != null) {
                                        arrayListE.add(anVar);
                                    }
                                }
                                dVarB = arrayListE.isEmpty() ? null : b(false, arrayListE);
                            }
                            if (dVarB == null) {
                                this.j.a();
                            } else {
                                v(z, dVarB, null);
                            }
                            break;
                    }
                    this.B = this.f610n;
                    com.google.android.libraries.navigation.internal.uc.m mVarE = com.google.android.libraries.navigation.internal.uc.n.e();
                    mVarE.b(h.c(this.f610n));
                    mVarE.c(ff.UNKNOWN_VIEW_MODE);
                    mVarE.e(new com.google.android.libraries.navigation.internal.pd.f().a());
                    mVarE.d(aq.UNKNOWN_CAMERA_TYPE);
                    nVarE = mVarE.a();
                } else {
                    this.B = this.f610n;
                    nVarE = e(z);
                }
            }
            if (dVarB2 != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB2 != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
        return nVarE;
    }

    protected abstract com.google.android.libraries.navigation.internal.uc.n e(boolean z);

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void h(Bundle bundle) {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void j(Bundle bundle) {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void k() {
        this.D = false;
        this.y.d(this, this.x);
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void l() {
        this.y.n(this);
        n();
    }

    public final void m(fd fdVar) {
        this.C = fdVar;
    }

    final void n() {
        this.f610n = com.google.android.libraries.navigation.internal.uc.g.FREE_MOVEMENT;
        this.o = null;
        ax();
    }

    public final void o(Float f) {
        this.s = f;
    }

    public final synchronized void p() {
        d(false);
    }

    protected void q(boolean z) {
        throw null;
    }

    protected void r(boolean z) {
        throw null;
    }

    protected void s(al alVar) {
        ((com.google.android.libraries.navigation.internal.dp.g) this.i).g.u(alVar == al.WALK ? 2 : 1);
    }

    public final boolean t() {
        com.google.android.libraries.navigation.internal.ue.b bVar = this.o;
        if (bVar != null) {
            return bVar == com.google.android.libraries.navigation.internal.ue.b.NORTH_UP || this.o == com.google.android.libraries.navigation.internal.ue.b.OVERVIEW;
        }
        com.google.android.libraries.navigation.internal.ue.c cVar = this.z;
        ap.UI_THREAD.f();
        ah ahVar = ((com.google.android.libraries.navigation.ar) cVar).a.i.a;
        com.google.android.libraries.navigation.internal.dq.c cVar2 = ahVar.g;
        ar.q(cVar2);
        return cVar2.a() == com.google.android.libraries.navigation.internal.ql.a.TRACKING && ahVar.a == fd.CAMERA_2D_NORTH_UP;
    }

    protected void u(com.google.android.libraries.navigation.internal.pb.c cVar) {
        this.e.d(cVar);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x007b  */
    final void v(boolean z, com.google.android.libraries.navigation.internal.pd.d dVar, TimeInterpolator timeInterpolator) {
        int i;
        if (z) {
            w(dVar, 0, null);
            return;
        }
        com.google.android.libraries.navigation.internal.pd.d dVarC = com.google.android.libraries.navigation.internal.pd.d.c(this.f.a());
        if (am.a(dVar, dVarC)) {
            timeInterpolator = b;
            i = 1600;
        } else {
            i = -1;
            if (Math.abs(dVar.k - dVarC.k) <= 0.3f && dVar.j.i(dVarC.j) <= 1000000.0f && Math.abs(dVar.l - dVarC.l) <= 5.0f && Math.abs(com.google.android.libraries.navigation.internal.nq.a.e(dVar.m - dVarC.m)) <= 5.0f) {
                com.google.android.libraries.navigation.internal.pd.e eVar = dVar.f515n;
                com.google.android.libraries.navigation.internal.pd.e eVar2 = dVarC.f515n;
                if (Math.abs(eVar.b - eVar2.b) <= 0.01f && Math.abs(eVar.c - eVar2.c) <= 0.01f) {
                    timeInterpolator = b;
                    i = 1600;
                }
            }
        }
        w(dVar, i, timeInterpolator);
    }

    public final void w(com.google.android.libraries.navigation.internal.pd.d dVar, int i, TimeInterpolator timeInterpolator) {
        if (dVar.equals(com.google.android.libraries.navigation.internal.pd.d.c(this.f.a()))) {
            return;
        }
        com.google.android.libraries.navigation.internal.pb.d dVar2 = new com.google.android.libraries.navigation.internal.pb.d(dVar);
        dVar2.a = i;
        dVar2.b = timeInterpolator;
        u(dVar2);
    }

    public final void x() {
    }

    protected void y() {
        throw null;
    }
}
