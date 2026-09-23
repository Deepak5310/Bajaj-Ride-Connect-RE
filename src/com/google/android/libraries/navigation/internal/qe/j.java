package com.google.android.libraries.navigation.internal.qe;

import android.view.View;
import com.google.android.libraries.geo.mapcore.renderer.bg;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.ol.z;
import com.google.android.libraries.navigation.internal.pb.t;
import com.google.android.libraries.navigation.internal.pn.l;
import com.google.android.libraries.navigation.internal.pn.n;
import com.google.android.libraries.navigation.internal.pn.o;
import com.google.android.libraries.navigation.internal.pn.u;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j implements com.google.android.libraries.navigation.internal.oy.a {
    public final View a;
    public l b;
    public com.google.android.libraries.navigation.internal.ql.a c;
    public boolean d = false;
    private final n e;
    private final com.google.android.libraries.navigation.internal.pn.j f;
    private final com.google.android.libraries.navigation.internal.pn.k g;
    private final t h;
    private final z i;

    public j(bg bgVar, t tVar, z zVar, com.google.android.libraries.navigation.internal.pn.j jVar, com.google.android.libraries.navigation.internal.pn.k kVar, boolean z) {
        View viewA = bgVar.a();
        this.a = viewA;
        this.h = tVar;
        this.i = zVar;
        this.f = jVar;
        this.g = kVar;
        n nVar = new n(jVar, bgVar.a(), z);
        this.e = nVar;
        viewA.setClickable(true);
        f fVar = new f(this, nVar);
        viewA.setOnTouchListener(new g(fVar));
        viewA.setOnHoverListener(new i(this, fVar));
    }

    private final x r(float f, float f2) {
        x xVarJ = com.google.android.libraries.navigation.internal.pb.j.j(new t(this.h), f, f2, new float[8]);
        ar.q(xVarJ);
        return xVarJ;
    }

    @Override // com.google.android.libraries.navigation.internal.oy.a
    public final u a() {
        return this.f.y();
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final int b() {
        return this.a.getHeight();
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final int c() {
        return this.a.getWidth();
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final n d() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void e() {
        l lVar = this.b;
        if (lVar != null) {
            lVar.g(o.FIRST_FINGER_DOWN, this.g);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void f() {
        l lVar = this.b;
        if (lVar != null) {
            lVar.g(o.LAST_FINGER_UP, this.g);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void g(float f, float f2) {
        l lVar = this.b;
        if (lVar != null) {
            lVar.b(this.i, com.google.android.libraries.navigation.internal.oe.h.a(r(f, f2)), this.g);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void h() {
        l lVar = this.b;
        if (lVar != null) {
            lVar.f();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void i(float f, float f2) {
        l lVar = this.b;
        if (lVar != null) {
            lVar.c(this.i, com.google.android.libraries.navigation.internal.oe.h.a(r(f, f2)), this.g);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void j() {
        l lVar = this.b;
        if (lVar != null) {
            lVar.g(o.FINGER_ACTION_CANCEL, this.g);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void k(float f, float f2) {
        l lVar = this.b;
        if (lVar != null) {
            com.google.android.libraries.navigation.internal.oe.h.a(r(f, f2));
            lVar.d(this.g);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void l(float f, float f2) {
        l lVar = this.b;
        if (lVar != null) {
            lVar.a(this.i, com.google.android.libraries.navigation.internal.oe.h.a(r(f, f2)), this.g);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void m() {
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void n() {
        l lVar = this.b;
        if (lVar != null) {
            this.a.getParent().requestDisallowInterceptTouchEvent(true);
            lVar.e(this.g);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void o() {
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void p(float f, float f2, float f3, boolean z) {
        l lVar = this.b;
        if (lVar != null) {
            lVar.h(f, z, this.g);
        }
    }

    public final void q() {
        com.google.android.libraries.navigation.internal.ql.a aVar;
        if (this.d || (aVar = this.c) == null) {
            return;
        }
        this.f.o(aVar);
    }
}
