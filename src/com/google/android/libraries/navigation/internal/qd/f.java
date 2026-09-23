package com.google.android.libraries.navigation.internal.qd;

import com.google.android.libraries.geo.mapcore.internal.model.ar;
import com.google.android.libraries.geo.mapcore.renderer.af;
import com.google.android.libraries.geo.mapcore.renderer.ax;
import com.google.android.libraries.geo.mapcore.renderer.cc;
import com.google.android.libraries.navigation.internal.ol.au;
import com.google.android.libraries.navigation.internal.po.gr;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends d {
    private final j a;
    private final aa b;
    private final l c;
    private final Runnable d;
    private boolean e;
    private final af f;
    private final ax g;
    private final gr h;

    public f(ar[] arVarArr, o oVar, ax axVar, gr grVar, af afVar, boolean z) {
        j jVar = new j();
        this.a = jVar;
        this.d = new Runnable() { // from class: com.google.android.libraries.navigation.internal.qd.e
            @Override // java.lang.Runnable
            public final void run() {
                this.a.i();
            }
        };
        this.e = false;
        this.c = oVar;
        this.g = axVar;
        this.h = grVar;
        this.f = afVar;
        this.b = new ab(oVar, arVarArr);
        jVar.c = z;
    }

    public final synchronized void f() {
        com.google.android.libraries.geo.mapcore.renderer.u uVar = this.g.l;
        com.google.android.libraries.navigation.internal.yx.ar.q(uVar);
        this.c.f();
        this.c.j((com.google.android.libraries.navigation.internal.pb.t) uVar, this.a.a);
        this.c.a();
        this.h.c(this.d);
        this.h.b();
    }

    public final synchronized void g() {
        this.c.d();
        this.e = false;
    }

    public final synchronized void h() {
        this.c.i();
        this.h.b();
    }

    public final synchronized void i() {
        if (this.e) {
            com.google.android.libraries.geo.mapcore.renderer.u uVar = this.g.l;
            com.google.android.libraries.navigation.internal.yx.ar.q(uVar);
            if (this.a.a((com.google.android.libraries.navigation.internal.pb.t) uVar)) {
                this.b.a((com.google.android.libraries.navigation.internal.pb.t) uVar, this.a);
                this.h.b();
            }
            this.c.j((com.google.android.libraries.navigation.internal.pb.t) uVar, this.a.a);
            this.h.c(this.d);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qd.d
    public final synchronized void j() {
        this.c.g(this.f);
        ArrayList arrayList = new ArrayList();
        aa aaVar = this.b;
        for (a aVar : ((ab) aaVar).b) {
            arrayList.add(aVar.a);
        }
        o oVar = ((ab) aaVar).a;
        com.google.android.libraries.navigation.internal.yx.ar.q(oVar.k);
        com.google.android.libraries.navigation.internal.qq.p pVar = new com.google.android.libraries.navigation.internal.qq.p(oVar.t, arrayList);
        synchronized (oVar.l) {
            au auVar = oVar.i;
            com.google.android.libraries.navigation.internal.pi.s sVar = oVar.u;
            oVar.m = new com.google.android.libraries.navigation.internal.qq.u(pVar);
            if (oVar.f547n) {
                oVar.k.f74n = oVar.m;
            }
        }
        this.e = true;
        com.google.android.libraries.geo.mapcore.renderer.u tVar = this.g.l;
        if (tVar != null) {
            if (!cc.b()) {
                tVar = new com.google.android.libraries.navigation.internal.pb.t((com.google.android.libraries.navigation.internal.pb.t) tVar);
            }
            if (this.a.a((com.google.android.libraries.navigation.internal.pb.t) tVar)) {
                this.b.a((com.google.android.libraries.navigation.internal.pb.t) tVar, this.a);
            }
            this.c.j((com.google.android.libraries.navigation.internal.pb.t) tVar, this.a.a);
        }
        this.h.c(this.d);
        this.h.b();
    }

    @Override // com.google.android.libraries.navigation.internal.qd.d
    public final void k() {
        this.h.b();
    }

    @Override // com.google.android.libraries.navigation.internal.qd.d
    public final void l() {
        g();
    }
}
