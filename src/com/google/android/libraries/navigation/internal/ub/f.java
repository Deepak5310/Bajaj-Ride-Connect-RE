package com.google.android.libraries.navigation.internal.ub;

import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.afl.fd;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.nt.p;
import com.google.android.libraries.navigation.internal.oe.al;
import com.google.android.libraries.navigation.internal.uh.o;
import com.google.android.libraries.navigation.internal.uh.w;
import com.google.android.libraries.navigation.internal.xe.bp;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class f implements com.google.android.libraries.navigation.internal.uh.c, o {
    public Float b;
    public float c;
    public float d;
    public com.google.android.libraries.navigation.internal.ia.e e;
    public p f;
    public com.google.android.libraries.navigation.internal.dq.c g;
    public com.google.android.libraries.navigation.internal.az.b h;
    public com.google.android.libraries.navigation.internal.uh.p i;
    public l j;
    public com.google.android.libraries.navigation.internal.ua.a k;
    public com.google.android.libraries.navigation.internal.oa.k l;
    public Executor m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.google.android.libraries.navigation.internal.og.b f611n;
    public boolean o;
    public boolean q;
    public com.google.android.libraries.navigation.internal.pd.d r;
    public com.google.android.libraries.navigation.internal.ui.a s;
    public boolean t;
    public boolean u;
    public boolean v;
    private Float w;
    protected fd a = fd.CAMERA_3D;
    public boolean p = true;
    private boolean x = true;
    private final com.google.android.libraries.navigation.internal.dq.f y = new com.google.android.libraries.navigation.internal.dq.f() { // from class: com.google.android.libraries.navigation.internal.ub.e
        @Override // com.google.android.libraries.navigation.internal.dq.f
        public final void a() {
            final f fVar = this.a;
            if (fVar.u) {
                return;
            }
            Executor executor = fVar.m;
            ar.q(executor);
            executor.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ub.d
                @Override // java.lang.Runnable
                public final void run() {
                    f fVar2 = fVar;
                    if (fVar2.v) {
                        return;
                    }
                    fVar2.o(true);
                    com.google.android.libraries.navigation.internal.dq.c cVar = fVar2.g;
                    ar.q(cVar);
                    ((com.google.android.libraries.navigation.internal.dp.g) cVar).g.u(1);
                    com.google.android.libraries.navigation.internal.ua.a aVar = fVar2.k;
                    ar.q(aVar);
                    aVar.c();
                    fVar2.p();
                }
            });
            fVar.u = true;
        }
    };

    protected void a(com.google.android.libraries.navigation.internal.pb.c cVar) {
        com.google.android.libraries.navigation.internal.og.b bVar = this.f611n;
        ar.q(bVar);
        bVar.a(cVar);
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void aC() {
        ap.UI_THREAD.f();
        com.google.android.libraries.navigation.internal.dq.c cVar = this.g;
        ar.q(cVar);
        ((com.google.android.libraries.navigation.internal.dp.g) cVar).g.g(this.y);
        com.google.android.libraries.navigation.internal.ia.e eVar = this.e;
        ar.q(eVar);
        eVar.e(this);
        this.v = true;
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final /* synthetic */ void ay(Configuration configuration) {
    }

    public final void b() {
        if (this.t) {
            com.google.android.libraries.navigation.internal.uh.p pVar = this.i;
            ar.q(pVar);
            pVar.b();
            this.q = false;
            this.p = false;
            n(false);
        }
    }

    public final void c(fd fdVar, Float f, Float f2) {
        this.a = fdVar;
        this.b = f;
        this.w = f2;
        this.q = false;
        this.r = null;
        this.x = false;
        d(false);
    }

    public final void e() {
        ap.UI_THREAD.f();
        if (this.o) {
            c(this.a == fd.CAMERA_3D ? fd.CAMERA_2D_NORTH_UP : fd.CAMERA_3D, this.b, this.w);
        } else {
            m();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.o
    public final void f(com.google.android.libraries.navigation.internal.ui.a aVar, com.google.android.libraries.navigation.internal.ui.a aVar2) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("CameraImpl.onNavigationUiStateChanged");
        try {
            ap.UI_THREAD.f();
            if (this.t) {
                this.s = aVar;
                if (aVar.c() != (aVar2 != null && aVar2.c())) {
                    o(false);
                }
                p();
            }
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

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void h(Bundle bundle) {
        ap.UI_THREAD.f();
        if (this.x && bundle != null) {
            fd fdVar = (fd) bundle.get("navcore_camera_perspective");
            if (fdVar == null) {
                fdVar = fd.UNKNOWN_CAMERA_TYPE;
            }
            this.a = fdVar;
            this.b = (Float) bundle.get("navcore_camera_zoom_override");
            this.w = (Float) bundle.get("navcore_camera_tilt_override");
            this.q = bundle.getByte("navcore_camera_showing_route_overview") != 0;
            this.p = bundle.getByte("navcore_camera_following") != 0;
            this.r = (com.google.android.libraries.navigation.internal.pd.d) bundle.getSerializable("navcore_camera_position");
        }
        com.google.android.libraries.navigation.internal.dq.c cVar = this.g;
        ar.q(cVar);
        ((com.google.android.libraries.navigation.internal.dp.g) cVar).g.c(this.y);
        com.google.android.libraries.navigation.internal.ia.e eVar = this.e;
        ar.q(eVar);
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.ds.a.class, new g(0, com.google.android.libraries.navigation.internal.ds.a.class, this, ap.UI_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.ql.b.class, new g(1, com.google.android.libraries.navigation.internal.ql.b.class, this, ap.UI_THREAD));
        eVar.c(this, fzVar.a());
        com.google.android.libraries.navigation.internal.ua.a aVar = this.k;
        ar.q(aVar);
        aVar.c();
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void j(Bundle bundle) {
        ap.UI_THREAD.f();
        bundle.putSerializable("navcore_camera_perspective", this.a);
        bundle.putSerializable("navcore_camera_zoom_override", this.b);
        bundle.putSerializable("navcore_camera_tilt_override", this.w);
        bundle.putByte("navcore_camera_showing_route_overview", this.q ? (byte) 1 : (byte) 0);
        bundle.putByte("navcore_camera_following", this.o ? (byte) 1 : (byte) 0);
        com.google.android.libraries.navigation.internal.pd.d dVar = this.r;
        if (dVar != null) {
            bundle.putSerializable("navcore_camera_position", dVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final /* synthetic */ void k() {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.c
    public final void l() {
        ap.UI_THREAD.f();
        this.s = null;
    }

    public final void m() {
        com.google.android.libraries.navigation.internal.oa.k kVar = this.l;
        ar.q(kVar);
        com.google.android.libraries.navigation.internal.pd.a aVar = new com.google.android.libraries.navigation.internal.pd.a(kVar.d());
        aVar.d = 0.0f;
        aVar.e = 0.0f;
        a(new com.google.android.libraries.navigation.internal.pb.d(aVar.a()));
    }

    public final void n(boolean z) {
        if (z != this.o) {
            this.o = z;
            if (z) {
                this.p = false;
                this.q = false;
            }
            if (this.t) {
                p pVar = this.f;
                ar.q(pVar);
                pVar.b(Boolean.valueOf(this.o));
            }
        }
    }

    public final boolean q() {
        com.google.android.libraries.navigation.internal.ui.a aVar = this.s;
        return aVar != null && aVar.c();
    }

    public final void p() {
        com.google.android.libraries.navigation.internal.dq.c cVar;
        if (this.q) {
            return;
        }
        boolean z = true;
        if (!q() ? (cVar = this.g) == null || (cVar.a() != com.google.android.libraries.navigation.internal.ql.a.COMPASS && this.g.a() != com.google.android.libraries.navigation.internal.ql.a.TRACKING) : this.s.c.a != com.google.android.libraries.navigation.internal.uc.g.FOLLOWING) {
            z = false;
        }
        n(z);
    }

    public final void o(boolean z) {
        if (this.t) {
            if (this.r != null && !q()) {
                com.google.android.libraries.navigation.internal.pb.d dVar = new com.google.android.libraries.navigation.internal.pb.d(this.r);
                if (z) {
                    dVar.a = 0;
                }
                a(dVar);
                return;
            }
            if (!this.q) {
                if (this.o || q() || this.p) {
                    d(z);
                    return;
                }
                return;
            }
            if (q()) {
                com.google.android.libraries.navigation.internal.uh.p pVar = this.i;
                ar.q(pVar);
                pVar.c();
                return;
            }
            com.google.android.libraries.navigation.internal.az.b bVar = this.h;
            ar.q(bVar);
            ap.UI_THREAD.f();
            com.google.android.libraries.navigation.internal.bm.o oVar = (com.google.android.libraries.navigation.internal.bm.o) bVar;
            al alVar = oVar.r;
            if (alVar != null) {
                oVar.e(alVar, true);
            } else {
                oVar.q = true;
            }
        }
    }

    public final void d(boolean z) {
        com.google.android.libraries.navigation.internal.tj.j jVar;
        if (this.t) {
            com.google.android.libraries.navigation.internal.ui.a aVar = this.s;
            if (aVar == null || (jVar = aVar.h) == null || jVar.h) {
                com.google.android.libraries.navigation.internal.dq.c cVar = this.g;
                ar.q(cVar);
                if (!((com.google.android.libraries.navigation.internal.dp.g) cVar).g.s(null)) {
                    this.p = true;
                    return;
                }
                com.google.android.libraries.navigation.internal.dq.c cVar2 = this.g;
                ar.q(cVar2);
                fd fdVar = this.a;
                com.google.android.libraries.navigation.internal.pd.f fVar = new com.google.android.libraries.navigation.internal.pd.f();
                if (fdVar == fd.CAMERA_3D) {
                    Float f = this.b;
                    float fFloatValue = f == null ? this.c : f.floatValue();
                    Float f2 = this.w;
                    float fFloatValue2 = f2 == null ? 45.0f : f2.floatValue();
                    fVar.f = com.google.android.libraries.navigation.internal.pd.h.LOCATION_AND_BEARING;
                    fVar.b = fFloatValue;
                    fVar.c = fFloatValue2;
                } else if (fdVar == fd.CAMERA_2D_NORTH_UP || fdVar == fd.CAMERA_2D_HEADING_UP) {
                    Float f3 = this.b;
                    float fFloatValue3 = f3 == null ? this.d : f3.floatValue();
                    fVar.f = com.google.android.libraries.navigation.internal.pd.h.LOCATION_ONLY;
                    fVar.b = fFloatValue3;
                    fVar.c = 0.0f;
                    fVar.d = 0.0f;
                }
                com.google.android.libraries.navigation.internal.ua.a aVar2 = this.k;
                if (aVar2 != null) {
                    Rect rectE = ((bp) aVar2).e();
                    Point pointA = this.k.a();
                    fVar.e = com.google.android.libraries.navigation.internal.pd.e.c(rectE.centerX(), rectE.centerY(), pointA.x, pointA.y);
                }
                cVar2.f(fVar.a(), z);
            } else {
                l lVar = this.j;
                ar.q(lVar);
                lVar.m(this.a);
                if (this.b != null) {
                    com.google.android.libraries.navigation.internal.uh.p pVar = this.i;
                    ar.q(pVar);
                    pVar.m(this.b);
                } else {
                    com.google.android.libraries.navigation.internal.uh.p pVar2 = this.i;
                    ar.q(pVar2);
                    w wVar = (w) pVar2;
                    com.google.android.libraries.navigation.internal.ea.c cVar3 = wVar.b;
                    com.google.android.libraries.navigation.internal.uc.j jVarA = cVar3.c.a();
                    jVarA.d();
                    ((com.google.android.libraries.navigation.internal.ui.a.C0035a) cVar3).b(jVarA.a());
                    wVar.c = ((com.google.android.libraries.navigation.internal.ui.a.C0035a) wVar.b).a();
                }
                if (this.w != null) {
                    com.google.android.libraries.navigation.internal.uh.p pVar3 = this.i;
                    ar.q(pVar3);
                    pVar3.e(this.w);
                } else {
                    com.google.android.libraries.navigation.internal.uh.p pVar4 = this.i;
                    ar.q(pVar4);
                    w wVar2 = (w) pVar4;
                    com.google.android.libraries.navigation.internal.ea.c cVar4 = wVar2.b;
                    com.google.android.libraries.navigation.internal.uc.j jVarA2 = cVar4.c.a();
                    jVarA2.c();
                    ((com.google.android.libraries.navigation.internal.ui.a.C0035a) cVar4).b(jVarA2.a());
                    wVar2.c = ((com.google.android.libraries.navigation.internal.ui.a.C0035a) wVar2.b).a();
                }
            }
            com.google.android.libraries.navigation.internal.uh.p pVar5 = this.i;
            ar.q(pVar5);
            w wVar3 = (w) pVar5;
            wVar3.p();
            wVar3.q();
            this.q = false;
            this.p = false;
            n(true);
        }
    }
}
