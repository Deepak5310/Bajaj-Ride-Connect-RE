package com.google.android.libraries.navigation.internal.xe;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.libraries.geo.mapcore.internal.ui.CompassButtonView;
import com.google.android.libraries.navigation.CustomControlPosition;
import com.google.android.libraries.navigation.NavigationView;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bp implements com.google.android.libraries.navigation.internal.ua.a {
    public final Context a;
    public final com.google.android.libraries.navigation.internal.ms.ax b;
    public final NavigationView c;
    public final com.google.android.libraries.navigation.internal.vu.r d;
    public View e;
    public View f;
    public View g;
    public ViewGroup h;
    public ViewGroup i;
    public CompassButtonView j;
    public boolean k;
    public ds l;
    public com.google.android.libraries.navigation.internal.ut.d m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.google.android.libraries.navigation.internal.tt.d f647n;
    public com.google.android.libraries.navigation.internal.ms.cq o;
    public com.google.android.libraries.navigation.internal.ms.cq p;
    public com.google.android.libraries.navigation.internal.ms.cq q;
    private final com.google.android.libraries.navigation.internal.ms.at r = new com.google.android.libraries.navigation.internal.ms.at();
    private final com.google.android.libraries.navigation.internal.jj.g s;

    public bp(Context context, com.google.android.libraries.navigation.internal.ms.ax axVar, NavigationView navigationView, com.google.android.libraries.navigation.internal.vu.r rVar, com.google.android.libraries.navigation.internal.jj.g gVar) {
        this.a = context;
        this.b = axVar;
        this.c = navigationView;
        this.d = rVar;
        this.s = gVar;
    }

    private final boolean i() {
        return this.a.getResources().getConfiguration().orientation == 2;
    }

    @Override // com.google.android.libraries.navigation.internal.p.a
    public final Point a() {
        com.google.android.libraries.navigation.internal.oo.b bVar = this.d.c;
        if (bVar == null) {
            return new Point(1, 1);
        }
        com.google.android.libraries.navigation.internal.rf.g gVarC = bVar.h().c();
        return new Point(gVarC.d(), gVarC.c());
    }

    @Override // com.google.android.libraries.navigation.internal.ua.a
    public final void b() {
        if (this.f647n == null) {
            return;
        }
        this.l.X(false);
        h(null);
    }

    @Override // com.google.android.libraries.navigation.internal.ua.a
    public final void c() {
        com.google.android.libraries.navigation.internal.ms.cy.a(this.l);
    }

    @Override // com.google.android.libraries.navigation.internal.ua.a
    public final boolean d() {
        return this.l.C().booleanValue();
    }

    public final Rect e() {
        int iIntValue;
        int iIntValue2;
        com.google.android.libraries.navigation.internal.oo.b bVar = this.d.c;
        if (bVar == null) {
            return new Rect(0, 0, 1, 1);
        }
        int dimensionPixelOffset = this.a.getResources().getDimensionPixelOffset(com.google.android.libraries.navigation.internal.f.c.d);
        com.google.android.libraries.navigation.internal.rf.g gVarC = bVar.h().c();
        int iD = gVarC.d();
        int iC = gVarC.c();
        if (com.google.android.libraries.navigation.internal.kj.c.b(this.o.a())) {
            iIntValue = this.l.w().intValue();
            iIntValue2 = this.l.x().intValue();
        } else {
            iIntValue = this.l.x().intValue();
            iIntValue2 = this.l.w().intValue();
        }
        Rect rect = new Rect(iIntValue, this.l.y().intValue(), iD - iIntValue2, iC - this.l.v().intValue());
        if (this.e.isShown()) {
            rect.top = Math.max(rect.top, this.e.getBottom());
            if (i()) {
                if (com.google.android.libraries.navigation.internal.kj.c.b(this.o.a())) {
                    rect.right = Math.min(rect.right, iD - this.e.getMeasuredWidth());
                } else {
                    rect.left = Math.max(rect.left, this.e.getMeasuredWidth());
                }
            }
        }
        if (!i() && this.f.isShown() && this.f.getTop() != 0) {
            rect.bottom = Math.min(rect.bottom, this.f.getTop());
        }
        if (!i() && this.g.isShown() && this.g.getTop() != 0) {
            rect.bottom = Math.min(rect.bottom, this.g.getTop());
        }
        if (this.p != null && this.h.getTop() != 0) {
            rect.bottom = Math.min(rect.bottom, this.h.getTop());
        }
        rect.inset(dimensionPixelOffset, dimensionPixelOffset);
        return rect;
    }

    public final void f(ds dsVar) {
        this.l = dsVar;
        if (this.e != null && dsVar.f() != null) {
            this.e.post(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xe.bj
                @Override // java.lang.Runnable
                public final void run() {
                    bp bpVar = this.a;
                    bpVar.l.f().m(bpVar.e.getMeasuredHeight());
                }
            });
        }
        this.o.c(this.l);
        this.r.a(this.l);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0048 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x0049 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x004b  */
    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    /* JADX WARN: Code duplicated, block: B:33:0x006a  */
    /* JADX WARN: Code duplicated, block: B:35:0x0077  */
    /* JADX WARN: Code duplicated, block: B:37:0x007b  */
    /* JADX WARN: Code duplicated, block: B:40:? A[RETURN, SYNTHETIC] */
    public final void g(View view, final CustomControlPosition customControlPosition) {
        com.google.android.libraries.navigation.internal.ms.cc ccVar;
        final int i;
        final ViewGroup viewGroup;
        if (view != null && view.getParent() != null) {
            com.google.android.libraries.navigation.internal.gz.f.b("Error: Custom control already has a parent view.");
            return;
        }
        CustomControlPosition customControlPosition2 = CustomControlPosition.BOTTOM_START_BELOW;
        int iOrdinal = customControlPosition.ordinal();
        if (iOrdinal == 0) {
            ccVar = dk.k;
        } else {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    ccVar = iOrdinal != 3 ? null : dk.m;
                } else {
                    if (i()) {
                        return;
                    }
                    ccVar = dk.o;
                    i = -1;
                }
                this.b.d();
                viewGroup = (ViewGroup) com.google.android.libraries.navigation.internal.ms.be.a(this.o.a(), ccVar);
                if (viewGroup == null) {
                    return;
                }
                if (view != null) {
                    if (customControlPosition == CustomControlPosition.FOOTER) {
                        com.google.android.libraries.navigation.internal.yx.ar.q(this.l);
                        this.l.M(0);
                    }
                    viewGroup.animate().setInterpolator(com.google.android.libraries.navigation.internal.k.a.a).setDuration(330L).translationY(i * (viewGroup.getMeasuredHeight() + this.e.getMeasuredHeight())).setListener(new bn(this, viewGroup, customControlPosition)).start();
                    return;
                }
                viewGroup.removeAllViews();
                viewGroup.addView(view);
                if (customControlPosition == CustomControlPosition.SECONDARY_HEADER) {
                    com.google.android.libraries.navigation.internal.yx.ar.q(this.l);
                    this.l.F(true);
                }
                if (viewGroup.getVisibility() != 0) {
                    return;
                }
                viewGroup.setVisibility(4);
                viewGroup.post(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xe.bk
                    @Override // java.lang.Runnable
                    public final void run() {
                        CustomControlPosition customControlPosition3 = customControlPosition;
                        ViewGroup viewGroup2 = viewGroup;
                        if (customControlPosition3 == CustomControlPosition.FOOTER) {
                            this.a.l.M(viewGroup2.getMeasuredHeight());
                        }
                        viewGroup2.setTranslationY(i * viewGroup2.getMeasuredHeight());
                        viewGroup2.animate().setStartDelay(500L).setInterpolator(com.google.android.libraries.navigation.internal.k.a.a).setDuration(330L).translationY(0.0f).setListener(new bm(viewGroup2)).start();
                    }
                });
            }
            ccVar = dk.l;
        }
        i = 1;
        this.b.d();
        viewGroup = (ViewGroup) com.google.android.libraries.navigation.internal.ms.be.a(this.o.a(), ccVar);
        if (viewGroup == null) {
            return;
        }
        if (view != null) {
            if (customControlPosition == CustomControlPosition.FOOTER) {
                com.google.android.libraries.navigation.internal.yx.ar.q(this.l);
                this.l.M(0);
            }
            viewGroup.animate().setInterpolator(com.google.android.libraries.navigation.internal.k.a.a).setDuration(330L).translationY(i * (viewGroup.getMeasuredHeight() + this.e.getMeasuredHeight())).setListener(new bn(this, viewGroup, customControlPosition)).start();
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        if (customControlPosition == CustomControlPosition.SECONDARY_HEADER) {
            com.google.android.libraries.navigation.internal.yx.ar.q(this.l);
            this.l.F(true);
        }
        if (viewGroup.getVisibility() != 0) {
            return;
        }
        viewGroup.setVisibility(4);
        viewGroup.post(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xe.bk
            @Override // java.lang.Runnable
            public final void run() {
                CustomControlPosition customControlPosition3 = customControlPosition;
                ViewGroup viewGroup2 = viewGroup;
                if (customControlPosition3 == CustomControlPosition.FOOTER) {
                    this.a.l.M(viewGroup2.getMeasuredHeight());
                }
                viewGroup2.setTranslationY(i * viewGroup2.getMeasuredHeight());
                viewGroup2.animate().setStartDelay(500L).setInterpolator(com.google.android.libraries.navigation.internal.k.a.a).setDuration(330L).translationY(0.0f).setListener(new bm(viewGroup2)).start();
            }
        });
    }

    public final void h(com.google.android.libraries.navigation.internal.tt.d dVar) {
        com.google.android.libraries.navigation.internal.ms.cq cqVar = this.q;
        if (cqVar != null) {
            cqVar.e();
            this.q = null;
            this.i.removeAllViews();
        }
        if (dVar != null) {
            com.google.android.libraries.navigation.internal.ms.cq cqVarC = this.b.l().c(new com.google.android.libraries.navigation.internal.jh.i(com.google.android.libraries.navigation.internal.afe.m.o), this.i);
            this.q = cqVarC;
            bl blVar = new bl(this, ((com.google.android.libraries.navigation.internal.tt.b) dVar).a);
            com.google.android.libraries.navigation.internal.jj.g gVar = this.s;
            Context context = this.a;
            com.google.android.libraries.navigation.internal.hf.c cVar = (com.google.android.libraries.navigation.internal.hf.c) gVar.a.a();
            cVar.getClass();
            com.google.android.libraries.navigation.internal.afo.a aVar = (com.google.android.libraries.navigation.internal.afo.a) gVar.b.a();
            aVar.getClass();
            ((com.google.android.libraries.navigation.internal.afo.a) gVar.c.a()).getClass();
            com.google.android.libraries.navigation.internal.afo.a aVar2 = (com.google.android.libraries.navigation.internal.afo.a) gVar.d.a();
            aVar2.getClass();
            ((com.google.android.libraries.navigation.internal.jy.af) gVar.e.a()).getClass();
            com.google.android.libraries.navigation.internal.jy.t tVar = (com.google.android.libraries.navigation.internal.jy.t) gVar.f.a();
            tVar.getClass();
            com.google.android.libraries.navigation.internal.qy.h hVar = (com.google.android.libraries.navigation.internal.qy.h) gVar.g.a();
            hVar.getClass();
            com.google.android.libraries.navigation.internal.gs.b bVar = (com.google.android.libraries.navigation.internal.gs.b) gVar.h.a();
            bVar.getClass();
            com.google.android.libraries.navigation.internal.gs.f fVar = (com.google.android.libraries.navigation.internal.gs.f) gVar.i.a();
            fVar.getClass();
            com.google.android.libraries.navigation.internal.ms.at atVar = (com.google.android.libraries.navigation.internal.ms.at) gVar.j.a();
            atVar.getClass();
            Executor executor = (Executor) gVar.k.a();
            executor.getClass();
            com.google.android.libraries.navigation.internal.fz.d dVar2 = (com.google.android.libraries.navigation.internal.fz.d) gVar.l.a();
            dVar2.getClass();
            com.google.android.libraries.navigation.internal.eb.a aVar3 = (com.google.android.libraries.navigation.internal.eb.a) gVar.m.a();
            com.google.android.libraries.navigation.internal.jo.a aVar4 = (com.google.android.libraries.navigation.internal.jo.a) gVar.f457n.a();
            com.google.android.libraries.navigation.internal.eb.b bVar2 = (com.google.android.libraries.navigation.internal.eb.b) gVar.o.a();
            context.getClass();
            cqVarC.c(new com.google.android.libraries.navigation.internal.jj.f(cVar, aVar, aVar2, tVar, hVar, bVar, fVar, atVar, executor, dVar2, aVar3, aVar4, bVar2, blVar, context, dVar));
        }
        this.f647n = dVar;
    }
}
