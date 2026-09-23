package com.google.android.libraries.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.libraries.geo.mapcore.internal.ui.CompassButtonView;
import com.google.android.libraries.navigation.environment.NavApiEnvironmentManager;
import com.google.android.libraries.navigation.environment.ct;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.abh.be;
import com.google.android.libraries.navigation.internal.abh.bi;
import com.google.android.libraries.navigation.internal.abh.cm;
import com.google.android.libraries.navigation.internal.ace.fj;
import com.google.android.libraries.navigation.internal.afl.fd;
import com.google.android.libraries.navigation.internal.bp.bk;
import com.google.android.libraries.navigation.internal.ck.ce;
import com.google.android.libraries.navigation.internal.cl.ba;
import com.google.android.libraries.navigation.internal.cl.bb;
import com.google.android.libraries.navigation.internal.cl.bd;
import com.google.android.libraries.navigation.internal.ly.cs;
import com.google.android.libraries.navigation.internal.ms.bg;
import com.google.android.libraries.navigation.internal.ms.cq;
import com.google.android.libraries.navigation.internal.ms.cr;
import com.google.android.libraries.navigation.internal.ms.cy;
import com.google.android.libraries.navigation.internal.po.dh;
import com.google.android.libraries.navigation.internal.po.gr;
import com.google.android.libraries.navigation.internal.po.hi;
import com.google.android.libraries.navigation.internal.xe.bh;
import com.google.android.libraries.navigation.internal.xe.bp;
import com.google.android.libraries.navigation.internal.xe.dk;
import com.google.android.libraries.navigation.internal.xe.dn;
import com.google.android.libraries.navigation.internal.xe.ds;
import com.google.android.libraries.navigation.internal.xe.ej;
import com.google.android.libraries.navigation.internal.xe.ek;
import com.google.android.libraries.navigation.internal.xe.fi;
import com.google.android.libraries.navigation.internal.xe.fk;
import com.google.android.libraries.navigation.internal.xe.gp;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class NavigationView extends RelativeLayout {
    private be A;
    private cm B;
    private GoogleMap C;
    private com.google.android.libraries.navigation.environment.aa D;
    private final GoogleMapOptions E;
    private com.google.android.libraries.navigation.internal.vu.x F;
    private gp G;
    private final Map H;
    private final com.google.android.libraries.navigation.internal.nt.p I;
    private boolean J;
    private boolean K;
    private final com.google.android.libraries.navigation.internal.nt.p L;
    private bd M;
    private com.google.android.libraries.navigation.internal.cl.be N;
    private ej O;
    private final Map P;
    private final com.google.android.libraries.navigation.internal.wb.f Q;
    private final com.google.android.libraries.navigation.internal.pi.n R;
    private com.google.android.libraries.navigation.environment.v S;
    public bp a;
    public com.google.android.libraries.navigation.internal.xe.v b;
    public com.google.android.libraries.navigation.environment.am c;
    public final com.google.android.libraries.navigation.internal.wb.t d;
    public com.google.android.libraries.navigation.internal.xe.w e;
    public com.google.android.libraries.navigation.internal.vu.r f;
    public com.google.android.libraries.navigation.internal.xe.as g;
    public com.google.android.libraries.navigation.internal.xe.ak h;
    public final com.google.android.libraries.navigation.internal.xe.ai i;
    public fi j;
    public final List k;
    public final List l;
    private com.google.android.libraries.navigation.internal.wb.q m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.google.android.libraries.navigation.internal.wb.n f91n;
    private final ds o;
    private com.google.android.libraries.navigation.internal.az.b p;
    private com.google.android.libraries.navigation.internal.jy.af q;
    private final com.google.android.libraries.navigation.internal.wb.s r;
    private com.google.android.libraries.navigation.internal.wb.d s;
    private com.google.android.libraries.navigation.internal.afo.a t;
    private com.google.android.libraries.navigation.internal.xl.c u;
    private com.google.android.libraries.navigation.internal.vd.m v;
    private final com.google.android.libraries.navigation.internal.xe.k w;
    private final as x;
    private final dn y;
    private com.google.android.libraries.navigation.internal.xd.a z;

    /* JADX INFO: compiled from: PG */
    public interface OnNightModeChangedListener {
        void onNightModeChanged(NightModeChangedEvent nightModeChangedEvent);
    }

    /* JADX INFO: compiled from: PG */
    public interface OnRecenterButtonClickedListener {
        void onRecenterButtonClick();
    }

    public NavigationView(Context context) {
        this(context, (AttributeSet) null, (GoogleMapOptions) null);
    }

    public static /* synthetic */ Boolean a() {
        return false;
    }

    private final synchronized void d(com.google.android.libraries.navigation.internal.zp.n nVar) {
        e(nVar, null);
    }

    private final synchronized void e(com.google.android.libraries.navigation.internal.zp.n nVar, Boolean bool) {
        com.google.android.libraries.navigation.internal.xd.a aVar = this.z;
        if (aVar != null) {
            aVar.c(nVar, bool);
        } else {
            this.P.put(nVar, bool);
        }
    }

    private final void f() {
        if (this.j != null) {
            bp bpVar = this.a;
            com.google.android.libraries.navigation.internal.oo.b bVar = bpVar.d.c;
            if (bVar != null) {
                CompassButtonView compassButtonView = bpVar.j;
                com.google.android.libraries.navigation.internal.oq.d dVarH = bVar.h();
                com.google.android.libraries.navigation.internal.oa.k kVar = bpVar.d.d;
                gr grVar = kVar == null ? null : kVar.p;
                compassButtonView.f = grVar;
                compassButtonView.c = new com.google.android.libraries.geo.mapcore.internal.ui.h(compassButtonView, dVarH, grVar);
                grVar.a(compassButtonView.c);
                grVar.d(compassButtonView.c);
                grVar.b();
                com.google.android.libraries.navigation.internal.oq.f fVarA = dVarH.a();
                compassButtonView.a(fVarA.a(), fVarA.b());
            }
            com.google.android.libraries.navigation.internal.wb.t tVar = this.d;
            com.google.android.libraries.navigation.internal.pi.s sVar = tVar.a;
            com.google.android.libraries.navigation.internal.yx.ar.q(sVar);
            Executor executor = tVar.b;
            com.google.android.libraries.navigation.internal.yx.ar.q(executor);
            sVar.b(tVar, executor);
            com.google.android.libraries.navigation.internal.pi.s sVar2 = tVar.a;
            com.google.android.libraries.navigation.internal.yx.ar.q(sVar2);
            sVar2.c(tVar);
            com.google.android.libraries.navigation.internal.wb.d dVar = this.s;
            dVar.d.e(dVar.g, dVar.e);
            dVar.c.g(dVar.f, dVar.e);
            try {
                this.j.g();
            } catch (IllegalStateException unused) {
                com.google.android.libraries.navigation.internal.gz.f.b("Error: Couldn't start the navigation service since the app wasn't in the foreground.");
            }
        }
    }

    private final void g() {
        this.f91n.k();
    }

    public void addOnNightModeChangedListener(OnNightModeChangedListener onNightModeChangedListener) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            d(com.google.android.libraries.navigation.internal.zp.n.Dg);
            if (this.k.isEmpty() && onNightModeChangedListener != null) {
                this.r.c(new com.google.android.libraries.navigation.internal.xe.y(new OnNightModeChangedListener() { // from class: com.google.android.libraries.navigation.af
                    @Override // com.google.android.libraries.navigation.NavigationView.OnNightModeChangedListener
                    public final void onNightModeChanged(NightModeChangedEvent nightModeChangedEvent) {
                        Iterator it2 = this.a.k.iterator();
                        while (it2.hasNext()) {
                            ((NavigationView.OnNightModeChangedListener) it2.next()).onNightModeChanged(nightModeChangedEvent);
                        }
                    }
                }));
            }
            this.k.add(onNightModeChangedListener);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void addOnRecenterButtonClickedListener(OnRecenterButtonClickedListener onRecenterButtonClickedListener) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            d(com.google.android.libraries.navigation.internal.zp.n.Dh);
            if (this.l.isEmpty() && onRecenterButtonClickedListener != null) {
                this.o.P(new OnRecenterButtonClickedListener() { // from class: com.google.android.libraries.navigation.ag
                    @Override // com.google.android.libraries.navigation.NavigationView.OnRecenterButtonClickedListener
                    public final void onRecenterButtonClick() {
                        Iterator it2 = this.a.l.iterator();
                        while (it2.hasNext()) {
                            ((NavigationView.OnRecenterButtonClickedListener) it2.next()).onRecenterButtonClick();
                        }
                    }
                });
            }
            this.l.add(onRecenterButtonClickedListener);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0c8b */
    /* JADX WARN: Code duplicated, block: B:28:0x03e9  */
    /* JADX WARN: Type inference failed for: r14v3, types: [com.google.android.libraries.navigation.ao] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void b(Bundle bundle, Navigator navigator, final com.google.android.libraries.navigation.environment.am amVar) throws Throwable {
        NavigationView navigationView;
        boolean z;
        Serializable serializable;
        this.j = (fi) navigator;
        if (this.J) {
            this.q = amVar.E();
            Context context = getContext();
            final com.google.android.libraries.navigation.internal.afo.a aVar = new com.google.android.libraries.navigation.internal.afo.a() { // from class: com.google.android.libraries.navigation.w
                @Override // com.google.android.libraries.navigation.internal.afo.a
                public final Object a() {
                    return this.a.d;
                }
            };
            Objects.requireNonNull(amVar);
            com.google.android.libraries.navigation.internal.agl.a aVar2 = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.p
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return amVar.f();
                }
            };
            com.google.android.libraries.navigation.internal.agl.a aVar3 = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.x
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return aVar;
                }
            };
            com.google.android.libraries.navigation.internal.agl.a aVar4 = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.y
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return new m();
                }
            };
            com.google.android.libraries.navigation.internal.agl.a aVar5 = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.z
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return new m();
                }
            };
            Objects.requireNonNull(amVar);
            com.google.android.libraries.navigation.internal.agl.a aVar6 = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.aa
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return amVar.E();
                }
            };
            Objects.requireNonNull(amVar);
            com.google.android.libraries.navigation.internal.agl.a aVar7 = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.ab
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return amVar.au();
                }
            };
            Objects.requireNonNull(amVar);
            com.google.android.libraries.navigation.internal.agl.a aVar8 = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.ac
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return amVar.p();
                }
            };
            Objects.requireNonNull(amVar);
            com.google.android.libraries.navigation.internal.agl.a aVar9 = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.ad
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return amVar.bh();
                }
            };
            Objects.requireNonNull(amVar);
            com.google.android.libraries.navigation.internal.agl.a aVar10 = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.ae
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return amVar.bi();
                }
            };
            com.google.android.libraries.navigation.internal.agl.a aVar11 = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.ah
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return new com.google.android.libraries.navigation.internal.ms.at();
                }
            };
            Objects.requireNonNull(amVar);
            com.google.android.libraries.navigation.internal.agl.a aVar12 = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.aj
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return amVar.bb();
                }
            };
            Objects.requireNonNull(amVar);
            com.google.android.libraries.navigation.internal.jj.g gVar = new com.google.android.libraries.navigation.internal.jj.g(aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12, new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.ak
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return amVar.ar();
                }
            }, new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.al
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return null;
                }
            }, new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.am
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return null;
                }
            }, new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.an
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return null;
                }
            });
            com.google.android.libraries.navigation.internal.jy.af afVarE = amVar.E();
            com.google.android.libraries.navigation.internal.iv.f fVarC = amVar.C();
            com.google.android.libraries.navigation.internal.vu.r rVar = this.f;
            com.google.android.libraries.navigation.internal.ab.a aVarAg = amVar.ag();
            final com.google.android.libraries.navigation.internal.hn.r rVarBq = amVar.bq();
            bp bpVar = new bp(context, new com.google.android.libraries.navigation.internal.ru.a(context, new bg(), afVarE, fVarC, aVarAg, bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.xe.bi
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return Boolean.valueOf(((com.google.android.libraries.navigation.internal.afl.fv) rVarBq.b()).h);
                }
            })), this, rVar, gVar);
            this.a = bpVar;
            cr crVarL = bpVar.b.l();
            bpVar.b.d();
            bpVar.o = crVarL.d(new dk(), bpVar.c, false);
            bpVar.e = com.google.android.libraries.navigation.internal.ms.be.a(bpVar.o.a(), dk.c);
            bpVar.f = com.google.android.libraries.navigation.internal.ms.be.a(bpVar.o.a(), dk.d);
            bpVar.g = com.google.android.libraries.navigation.internal.ms.be.a(bpVar.o.a(), dk.m);
            bpVar.h = (ViewGroup) cy.b(bpVar.o.a(), dk.g, ViewGroup.class);
            bpVar.i = (ViewGroup) cy.b(bpVar.o.a(), dk.f, ViewGroup.class);
            bpVar.j = (CompassButtonView) cy.b(bpVar.o.a(), dk.a, CompassButtonView.class);
            this.B.aU(new fk(this.a, this.z));
            com.google.android.libraries.navigation.internal.ec.c cVarAq = amVar.aq();
            com.google.android.libraries.navigation.internal.nj.i.b();
            int i = cVarAq.k + 1;
            cVarAq.k = i;
            if (i <= 1) {
                cVarAq.i = (com.google.android.libraries.navigation.internal.ed.a) cVarAq.b.g(com.google.android.libraries.navigation.internal.ec.c.a, com.google.android.libraries.navigation.internal.ed.a.class, com.google.android.libraries.navigation.internal.ed.a.AUTO);
                cVarAq.b.e(com.google.android.libraries.navigation.internal.ec.c.a, com.google.android.libraries.navigation.internal.ed.a.class).g(cVarAq.l, cVarAq.e);
                com.google.android.libraries.navigation.internal.ia.e eVar = cVarAq.c;
                com.google.android.libraries.navigation.internal.ec.b bVar = cVarAq.m;
                fz fzVar = new fz();
                fzVar.b(com.google.android.libraries.navigation.internal.db.s.class, new com.google.android.libraries.navigation.internal.ec.f(com.google.android.libraries.navigation.internal.db.s.class, bVar, com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD));
                eVar.c(bVar, fzVar.a());
                cVarAq.b();
            }
            com.google.android.libraries.navigation.internal.wb.s sVar = this.r;
            com.google.android.libraries.navigation.internal.ec.c cVarAq2 = amVar.aq();
            sVar.a = cVarAq2;
            com.google.android.libraries.navigation.internal.ed.a aVar13 = sVar.c;
            if (aVar13 != null) {
                sVar.b(aVar13);
            }
            cVarAq2.a().e(sVar.d, sVar.b);
            com.google.android.libraries.navigation.internal.wb.s sVar2 = this.r;
            if (bundle != null && (serializable = bundle.getSerializable("force_night_mode")) != null) {
                sVar2.b((com.google.android.libraries.navigation.internal.ed.a) serializable);
            }
            this.B.aP();
            final com.google.android.libraries.navigation.internal.wb.d dVar = new com.google.android.libraries.navigation.internal.wb.d(this.a.j, this.i.a, this.I.a, amVar.c().a(), amVar.W());
            this.s = dVar;
            dVar.a();
            dVar.a.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.navigation.internal.wb.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dVar.b.e();
                }
            });
            dVar.a.setVisibilityMode(com.google.android.libraries.geo.mapcore.internal.ui.a.ALWAYS_ON);
            CompassButtonView compassButtonView = (CompassButtonView) dVar.a;
            compassButtonView.e = 3;
            compassButtonView.b();
            Resources resources = getContext().getResources();
            final com.google.android.libraries.navigation.internal.oo.b bVarF = this.D.f();
            this.t = com.google.android.libraries.navigation.internal.ih.a.c(new bb(com.google.android.libraries.navigation.internal.ih.a.c(((com.google.android.libraries.navigation.internal.po.fk) this.f.a()).I), amVar.bo(), context, amVar.f(), new Object() { // from class: com.google.android.libraries.navigation.ao
            }, amVar.ar(), amVar.as(), bVarF.g()));
            final com.google.android.libraries.navigation.internal.oa.k kVar = this.f.d;
            com.google.android.libraries.navigation.internal.ih.a aVarB = com.google.android.libraries.navigation.internal.ih.a.b(new br() { // from class: com.google.android.libraries.navigation.ap
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return this.a.f.i;
                }
            });
            Executor executorBa = amVar.ba();
            kVar.I();
            Objects.requireNonNull(kVar);
            com.google.android.libraries.navigation.internal.qk.ae aeVar = new com.google.android.libraries.navigation.internal.qk.ae(new com.google.android.libraries.navigation.internal.afo.a() { // from class: com.google.android.libraries.navigation.internal.qk.af
                @Override // com.google.android.libraries.navigation.internal.afo.a
                public final Object a() {
                    return kVar.c();
                }
            }, aVarB, executorBa, new Runnable() { // from class: com.google.android.libraries.navigation.internal.qk.ag
                @Override // java.lang.Runnable
                public final void run() {
                    ((com.google.android.libraries.navigation.internal.po.fk) kVar.b()).K.b.h();
                }
            });
            Objects.requireNonNull(bVarF);
            com.google.android.libraries.navigation.internal.ck.u uVar = new com.google.android.libraries.navigation.internal.ck.u(com.google.android.libraries.navigation.internal.ih.a.b(new br() { // from class: com.google.android.libraries.navigation.n
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return bVarF.i();
                }
            }));
            bVarF.g().a(aeVar.c);
            com.google.android.libraries.navigation.internal.xe.u uVar2 = new com.google.android.libraries.navigation.internal.xe.u(this.C, this.f.d, amVar.bq());
            com.google.android.libraries.navigation.internal.vu.r rVar2 = this.f;
            com.google.android.libraries.navigation.internal.xe.b bVar2 = new com.google.android.libraries.navigation.internal.xe.b(rVar2.d, rVar2.f, bVarF.h(), this.a, uVar2, this.f.s);
            com.google.android.libraries.navigation.internal.oa.k kVar2 = this.f.d;
            com.google.android.libraries.navigation.internal.bm.ap apVar = new com.google.android.libraries.navigation.internal.bm.ap(amVar.bd());
            com.google.android.libraries.navigation.internal.um.d dVarC = com.google.android.libraries.navigation.internal.ul.a.c(context.getApplicationContext(), amVar.cc(), amVar.cb());
            com.google.android.libraries.navigation.internal.vb.l lVar = new com.google.android.libraries.navigation.internal.vb.l(context.getApplicationContext());
            this.m = new com.google.android.libraries.navigation.internal.wb.q(amVar.az(), amVar.bb());
            com.google.android.libraries.navigation.internal.wb.t tVar = this.d;
            com.google.android.libraries.navigation.internal.pi.s sVarC = this.f.c();
            Executor executorBb = amVar.bb();
            bp bpVar2 = this.a;
            tVar.a = sVarC;
            tVar.b = executorBb;
            tVar.c = bpVar2;
            com.google.android.libraries.navigation.internal.wb.t tVar2 = this.d;
            if (tVar2.d == null) {
                if (bundle != null) {
                    tVar2.d = Boolean.valueOf(bundle.getBoolean("TrafficIncidentController.clickedEventEnabled", true));
                } else {
                    tVar2.d = true;
                }
            }
            com.google.android.libraries.navigation.internal.vb.d dVar2 = new com.google.android.libraries.navigation.internal.vb.d();
            com.google.android.libraries.navigation.internal.vb.g gVar2 = new com.google.android.libraries.navigation.internal.vb.g();
            com.google.android.libraries.navigation.internal.vb.k kVar3 = new com.google.android.libraries.navigation.internal.vb.k();
            bh bhVar = new bh(this.L.a, new WeakReference(this.a), amVar.B(), amVar.bu());
            com.google.android.libraries.navigation.internal.uh.w wVarA = amVar.aM().a(bhVar, this.m);
            wVarA.o(bundle);
            this.v = new com.google.android.libraries.navigation.internal.vd.m(amVar.az(), this.f.c(), amVar.bp(), amVar.W(), (com.google.android.libraries.navigation.internal.vd.g) amVar.aY().a());
            this.u = new com.google.android.libraries.navigation.internal.xl.c(context, amVar.B(), amVar.av(), new o(bhVar), (com.google.android.libraries.navigation.internal.vd.g) amVar.aY().a(), amVar.c(), this.v, amVar.bb(), amVar.bp());
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isInMultiWindowMode() || activity.isInPictureInPictureMode()) {
                    z = false;
                } else {
                    z = true;
                }
            } else {
                z = true;
            }
            this.u.n(z);
            this.u.y();
            this.o.S(this.u);
            ar arVar = new ar(this);
            com.google.android.libraries.navigation.internal.uc.f fVarAL = amVar.aL();
            com.google.android.libraries.navigation.internal.fz.d dVarAr = amVar.ar();
            com.google.android.libraries.navigation.internal.jy.t tVarAu = amVar.au();
            com.google.android.libraries.navigation.internal.ni.a aVarI = amVar.I();
            com.google.android.libraries.navigation.internal.vu.r rVar3 = this.f;
            com.google.android.libraries.navigation.internal.xe.x xVar = new com.google.android.libraries.navigation.internal.xe.x(fVarAL, dVarAr, tVarAu, aVarI, resources, rVar3.d, rVar3.s, this.a, wVarA, this.g, amVar.bb(), this.f.c(), arVar, uVar2, com.google.android.libraries.navigation.internal.ih.a.c(this.f.e), amVar.at(), com.google.android.libraries.navigation.internal.ih.a.c(bVarF));
            amVar.bn();
            this.e = xVar;
            com.google.android.libraries.navigation.internal.ni.a aVarI2 = amVar.I();
            com.google.android.libraries.navigation.internal.bn.d dVarBZ = amVar.bZ();
            com.google.android.libraries.navigation.internal.ci.a aVarCa = amVar.ca();
            com.google.android.libraries.navigation.internal.pi.s sVarC2 = this.f.c();
            com.google.android.libraries.navigation.internal.rw.f fVarAz = amVar.az();
            com.google.android.libraries.navigation.internal.ia.e eVarB = amVar.B();
            Executor executorBb2 = amVar.bb();
            bn bnVarS = amVar.S();
            amVar.U();
            com.google.android.libraries.navigation.internal.oa.k kVar4 = this.f.d;
            com.google.android.libraries.navigation.internal.cr.f fVarJ = this.D.j();
            com.google.android.libraries.navigation.internal.s.b bVar3 = this.f.f;
            com.google.android.libraries.navigation.internal.up.g gVarAN = amVar.aN();
            com.google.android.libraries.navigation.internal.afo.a aVar14 = this.t;
            com.google.android.libraries.navigation.internal.ck.ar arVar2 = new com.google.android.libraries.navigation.internal.ck.ar(com.google.android.libraries.navigation.internal.ih.a.b(new br() { // from class: com.google.android.libraries.navigation.q
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return ((com.google.android.libraries.navigation.internal.po.fk) this.a.f.d.b()).J;
                }
            }), com.google.android.libraries.navigation.internal.ih.a.b(new br() { // from class: com.google.android.libraries.navigation.r
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return ((com.google.android.libraries.navigation.internal.po.fk) this.a.f.d.b()).I;
                }
            }), context, amVar.c(), amVar.be(), amVar.ar(), amVar.aV());
            com.google.android.libraries.navigation.internal.ih.a aVarB2 = com.google.android.libraries.navigation.internal.ih.a.b(new br() { // from class: com.google.android.libraries.navigation.s
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return ((com.google.android.libraries.navigation.internal.po.fk) this.a.f.d.b()).F;
                }
            });
            com.google.android.libraries.navigation.internal.oa.l lVar2 = this.f.u;
            com.google.android.libraries.navigation.internal.yx.ar.q(lVar2);
            ce ceVar = new ce(aVarB2, uVar, lVar2, new com.google.android.libraries.navigation.internal.ck.ac(com.google.android.libraries.navigation.internal.ih.a.b(new br() { // from class: com.google.android.libraries.navigation.t
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return ((com.google.android.libraries.navigation.internal.po.fk) this.a.f.d.b()).I;
                }
            }), this.f.d, context), context, amVar.at());
            com.google.android.libraries.navigation.internal.jy.af afVar = this.q;
            com.google.android.libraries.navigation.internal.jy.t tVarAu2 = amVar.au();
            com.google.android.libraries.navigation.internal.ed.b bVarC = amVar.c();
            com.google.android.libraries.navigation.internal.ih.a aVarB3 = com.google.android.libraries.navigation.internal.ih.a.b(new br() { // from class: com.google.android.libraries.navigation.u
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return ((com.google.android.libraries.navigation.internal.po.fk) this.a.f.d.b()).I;
                }
            });
            com.google.android.libraries.navigation.internal.mj.a aVarH = amVar.H();
            com.google.android.libraries.navigation.internal.fz.d dVarAr2 = amVar.ar();
            com.google.android.libraries.navigation.internal.hn.r rVarAt = amVar.at();
            com.google.android.libraries.geo.navcore.decoration.impl.b bVarBk = amVar.bk();
            com.google.android.libraries.navigation.internal.rr.a aVarAy = amVar.ay();
            com.google.android.libraries.navigation.internal.yx.an anVarAU = amVar.aU();
            com.google.android.libraries.navigation.internal.iv.f fVarC2 = amVar.C();
            com.google.android.libraries.navigation.internal.rw.q qVarAB = amVar.aB();
            ct ctVarBd = amVar.bd();
            com.google.android.libraries.navigation.internal.bf.d dVarAi = amVar.ai();
            com.google.android.libraries.navigation.internal.ba.b bVarBc = amVar.bc();
            com.google.android.libraries.navigation.internal.hf.c cVarF = amVar.f();
            ev evVarAW = amVar.aW();
            com.google.android.libraries.navigation.internal.dx.i iVarAn = amVar.an();
            com.google.android.libraries.navigation.internal.cn.o oVarAk = amVar.ak();
            com.google.android.libraries.navigation.internal.vu.r rVar4 = this.f;
            com.google.android.libraries.navigation.internal.bm.am amVar2 = new com.google.android.libraries.navigation.internal.bm.am(aVarI2, dVarBZ, aVarCa, sVarC2, fVarAz, eVarB, executorBb2, bnVarS, kVar4, bVarF, aeVar, fVarJ, bVar3, context, gVarAN, aVar14, arVar2, ceVar, afVar, tVarAu2, bVarC, aVarB3, aVarH, dVarAr2, rVarAt, bVarBk, aVarAy, anVarAU, fVarC2, qVarAB, ctVarBd, dVarAi, bVarBc, cVarF, evVarAW, iVarAn, oVarAk, rVar4.s, null, null, com.google.android.libraries.navigation.internal.ih.a.c(rVar4.b()), com.google.android.libraries.navigation.internal.ih.a.c(this.f.e), new br() { // from class: com.google.android.libraries.navigation.v
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return NavigationView.a();
                }
            });
            com.google.android.libraries.navigation.internal.oa.k kVar5 = this.f.d;
            com.google.android.libraries.navigation.internal.op.i iVarG = bVarF.g();
            com.google.android.libraries.navigation.internal.cr.f fVarJ2 = this.D.j();
            com.google.android.libraries.navigation.internal.s.b bVar4 = this.f.f;
            com.google.android.libraries.navigation.internal.ia.e eVarB2 = amVar.B();
            com.google.android.libraries.navigation.internal.ed.b bVarC2 = amVar.c();
            ct ctVarBd2 = amVar.bd();
            com.google.android.libraries.navigation.internal.sf.b bVarAC = amVar.aC();
            amVar.aD();
            com.google.android.libraries.navigation.internal.bm.o oVar = new com.google.android.libraries.navigation.internal.bm.o(context, kVar5, iVarG, aeVar, fVarJ2, bVar4, amVar2, apVar, eVarB2, bVarC2, ctVarBd2, bVarAC, bVar2, amVar.bb(), amVar.at(), this.f.b());
            this.p = oVar;
            com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
            oVar.i.a().g(oVar.t, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
            oVar.b.l.d(oVar);
            synchronized (oVar.f346n) {
                try {
                    oVar.o = new com.google.android.libraries.navigation.internal.bm.ar(oVar.b.b(), oVar.c, oVar.d, oVar.u, oVar.a, ((fj) oVar.m.b()).c);
                } catch (Throwable th) {
                    th = th;
                    while (true) {
                        throw th;
                    }
                }
            }
            ct ctVar = oVar.h.d;
            ct ctVar2 = oVar.v;
            ct ctVar3 = oVar.v;
            com.google.android.libraries.navigation.internal.bm.am amVar3 = oVar.g;
            if (!amVar3.T.getAndSet(true)) {
                com.google.android.libraries.navigation.internal.ia.e eVar2 = amVar3.e;
                fz fzVar2 = new fz();
                fzVar2.b(bk.class, new com.google.android.libraries.navigation.internal.bm.ao(0, bk.class, amVar3, com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD));
                fzVar2.b(com.google.android.libraries.navigation.internal.db.s.class, new com.google.android.libraries.navigation.internal.bm.ao(1, com.google.android.libraries.navigation.internal.db.s.class, amVar3, com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD));
                eVar2.c(amVar3, fzVar2.a());
                amVar3.F.a().e(amVar3.W, amVar3.f);
                amVar3.d.c(amVar3, amVar3.f);
                amVar3.p.a(amVar3, amVar3.f);
                amVar3.aa.a(amVar3, amVar3.f);
                com.google.android.libraries.navigation.internal.afo.a aVar15 = amVar3.q;
            }
            this.e.m(fd.CAMERA_2D_HEADING_UP);
            com.google.android.libraries.navigation.internal.xe.ai aiVar = this.i;
            com.google.android.libraries.navigation.internal.ia.e eVarB3 = amVar.B();
            com.google.android.libraries.navigation.internal.nt.p pVar = this.I;
            Executor executorBb3 = amVar.bb();
            com.google.android.libraries.navigation.internal.xe.as asVar = this.g;
            com.google.android.libraries.navigation.internal.az.b bVar5 = this.p;
            com.google.android.libraries.navigation.internal.xe.w wVar = this.e;
            bp bpVar3 = this.a;
            com.google.android.libraries.navigation.internal.oa.k kVar6 = this.f.d;
            com.google.android.libraries.navigation.internal.xd.a aVarBw = amVar.bw();
            com.google.android.libraries.navigation.internal.og.b bVar6 = this.f.s;
            amVar.bn();
            com.google.android.libraries.navigation.internal.xe.ah ahVar = aiVar.a;
            ahVar.e = eVarB3;
            ahVar.f = pVar;
            ahVar.m = executorBb3;
            ahVar.g = asVar;
            ahVar.h = bVar5;
            ahVar.i = wVarA;
            ahVar.j = wVar;
            ahVar.k = bpVar3;
            ahVar.l = kVar6;
            ahVar.c = 18.0f;
            ahVar.d = 16.0f;
            ahVar.f611n = bVar6;
            ahVar.t = true;
            ahVar.w = uVar2;
            aiVar.b = aVarBw;
            com.google.android.libraries.navigation.internal.oa.k kVar7 = this.f.d;
            com.google.android.libraries.navigation.internal.op.i iVarG2 = bVarF.g();
            com.google.android.libraries.navigation.internal.oq.d dVarH = bVarF.h();
            com.google.android.libraries.navigation.internal.s.b bVar7 = this.f.f;
            com.google.android.libraries.navigation.internal.az.b bVar8 = this.p;
            com.google.android.libraries.navigation.internal.xe.ai aiVar2 = this.i;
            com.google.android.libraries.navigation.internal.xe.w wVar2 = this.e;
            com.google.android.libraries.navigation.internal.kl.b bVarG = amVar.G();
            Intrinsics.checkNotNullParameter(context, "context");
            com.google.android.libraries.navigation.internal.ch.b bVar9 = new com.google.android.libraries.navigation.internal.ch.b();
            com.google.android.libraries.navigation.internal.cu.d dVarBg = amVar.bg();
            com.google.android.libraries.navigation.internal.ok.b bVar10 = this.f.e;
            com.google.android.libraries.navigation.internal.yx.ar.q(bVar10);
            com.google.android.libraries.navigation.internal.cu.b bVar11 = new com.google.android.libraries.navigation.internal.cu.b(new com.google.android.libraries.navigation.internal.wb.m(), amVar.C(), kVar7, amVar.E(), amVar.H(), amVar.ar(), com.google.android.libraries.navigation.internal.cu.b.h, dVarBg, amVar.at(), com.google.android.libraries.navigation.internal.ih.a.c(bVar10), com.google.android.libraries.navigation.internal.ih.a.c(this.f.b()));
            com.google.android.libraries.navigation.internal.pi.s sVar3 = kVar7.h;
            com.google.android.libraries.navigation.internal.rw.n nVarAA = amVar.aA();
            com.google.android.libraries.navigation.internal.so.c cVarAG = amVar.aG();
            com.google.android.libraries.navigation.internal.ia.e eVarB4 = amVar.B();
            com.google.android.libraries.navigation.internal.iv.f fVarC3 = amVar.C();
            com.google.android.libraries.navigation.internal.jy.t tVarAu3 = amVar.au();
            com.google.android.libraries.navigation.internal.ih.a aVarC = com.google.android.libraries.navigation.internal.ih.a.c(bVar11);
            com.google.android.libraries.navigation.internal.ih.a aVarB4 = com.google.android.libraries.navigation.internal.ih.a.b(new br() { // from class: com.google.android.libraries.navigation.internal.wb.g
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return amVar.ar().C();
                }
            });
            com.google.android.libraries.navigation.internal.ih.a aVarB5 = com.google.android.libraries.navigation.internal.ih.a.b(new br() { // from class: com.google.android.libraries.navigation.internal.wb.h
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return amVar.ar().h();
                }
            });
            com.google.android.libraries.navigation.internal.ih.a aVarB6 = com.google.android.libraries.navigation.internal.ih.a.b(new br() { // from class: com.google.android.libraries.navigation.internal.wb.i
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return amVar.ar().W();
                }
            });
            com.google.android.libraries.navigation.internal.ih.a aVarB7 = com.google.android.libraries.navigation.internal.ih.a.b(new br() { // from class: com.google.android.libraries.navigation.internal.wb.j
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return amVar.ar().p();
                }
            });
            com.google.android.libraries.navigation.internal.iv.p pVar2 = com.google.android.libraries.navigation.internal.iv.ab.bd;
            com.google.android.libraries.navigation.internal.cv.e eVar3 = new com.google.android.libraries.navigation.internal.cv.e();
            com.google.android.libraries.navigation.internal.cv.e eVar4 = new com.google.android.libraries.navigation.internal.cv.e();
            Executor executorBb4 = amVar.bb();
            Objects.requireNonNull(amVar);
            com.google.android.libraries.navigation.internal.uh.l lVar3 = new com.google.android.libraries.navigation.internal.uh.l(bhVar, sVar3, nVarAA, cVarAG, eVarB4, fVarC3, tVarAu3, wVarA, wVar2, bVarG, aVarC, kVar7, dVarH, bVar7, bVar8, aVarB4, aVarB5, aVarB6, aVarB7, pVar2, eVar3, eVar4, executorBb4, dVarBg, com.google.android.libraries.navigation.internal.ih.a.b(new br() { // from class: com.google.android.libraries.navigation.internal.wb.k
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return amVar.al();
                }
            }));
            com.google.android.libraries.navigation.internal.zm.a aVar16 = new com.google.android.libraries.navigation.internal.zm.a(amVar.aN());
            Context contextT = amVar.t();
            contextT.getResources().getColor(com.google.android.libraries.navigation.internal.dw.a.a);
            contextT.getResources().getColor(com.google.android.libraries.navigation.internal.dw.a.a);
            com.google.android.libraries.navigation.internal.zm.a aVar17 = new com.google.android.libraries.navigation.internal.zm.a(com.google.android.libraries.navigation.internal.vb.n.a(amVar.t()));
            com.google.android.libraries.navigation.internal.zm.a aVar18 = new com.google.android.libraries.navigation.internal.zm.a((com.google.android.libraries.navigation.internal.sl.d) amVar.aX().a());
            com.google.android.libraries.navigation.internal.zm.a aVar19 = new com.google.android.libraries.navigation.internal.zm.a((com.google.android.libraries.navigation.internal.sn.h) amVar.aZ().a());
            com.google.android.libraries.navigation.internal.zm.a aVar20 = new com.google.android.libraries.navigation.internal.zm.a(amVar.ar());
            com.google.android.libraries.navigation.internal.zm.a aVar21 = new com.google.android.libraries.navigation.internal.zm.a(amVar.H());
            com.google.android.libraries.navigation.internal.zm.a aVar22 = new com.google.android.libraries.navigation.internal.zm.a(amVar.bZ());
            com.google.android.libraries.navigation.internal.zm.a aVar23 = new com.google.android.libraries.navigation.internal.zm.a(amVar.f());
            com.google.android.libraries.navigation.internal.zm.a aVar24 = new com.google.android.libraries.navigation.internal.zm.a(amVar.B());
            com.google.android.libraries.navigation.internal.zm.a aVar25 = new com.google.android.libraries.navigation.internal.zm.a(amVar.aF());
            com.google.android.libraries.navigation.internal.zm.a aVar26 = new com.google.android.libraries.navigation.internal.zm.a(dVarC);
            com.google.android.libraries.navigation.internal.zm.a aVar27 = new com.google.android.libraries.navigation.internal.zm.a(amVar.ah());
            com.google.android.libraries.navigation.internal.zm.a aVar28 = new com.google.android.libraries.navigation.internal.zm.a(amVar.p());
            com.google.android.libraries.navigation.internal.zm.a aVar29 = new com.google.android.libraries.navigation.internal.zm.a(amVar.C());
            com.google.android.libraries.navigation.internal.zm.a aVar30 = new com.google.android.libraries.navigation.internal.zm.a(Optional.of(wVarA));
            com.google.android.libraries.navigation.internal.zm.a aVar31 = new com.google.android.libraries.navigation.internal.zm.a(amVar.E());
            com.google.android.libraries.navigation.internal.zm.a aVar32 = new com.google.android.libraries.navigation.internal.zm.a(amVar.au());
            com.google.android.libraries.navigation.internal.zm.a aVar33 = new com.google.android.libraries.navigation.internal.zm.a(amVar.W());
            com.google.android.libraries.navigation.internal.zm.a aVar34 = new com.google.android.libraries.navigation.internal.zm.a(amVar.S());
            com.google.android.libraries.navigation.internal.zm.a aVar35 = new com.google.android.libraries.navigation.internal.zm.a(amVar.av());
            com.google.android.libraries.navigation.internal.zm.a aVar36 = new com.google.android.libraries.navigation.internal.zm.a(amVar.aw());
            com.google.android.libraries.navigation.internal.zm.a aVar37 = new com.google.android.libraries.navigation.internal.zm.a(amVar.aE());
            com.google.android.libraries.navigation.internal.zm.a aVar38 = new com.google.android.libraries.navigation.internal.zm.a(bVar9);
            com.google.android.libraries.navigation.internal.zm.a aVar39 = new com.google.android.libraries.navigation.internal.zm.a(amVar.aB());
            com.google.android.libraries.navigation.internal.zm.a aVar40 = new com.google.android.libraries.navigation.internal.zm.a(com.google.android.libraries.navigation.internal.ih.a.b(new br() { // from class: com.google.android.libraries.navigation.internal.wb.l
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return amVar.al();
                }
            }));
            com.google.android.libraries.navigation.internal.zm.a aVar41 = new com.google.android.libraries.navigation.internal.zm.a(amVar.an());
            com.google.android.libraries.navigation.internal.zm.a aVar42 = new com.google.android.libraries.navigation.internal.zm.a(amVar.ap());
            com.google.android.libraries.navigation.internal.zm.a aVar43 = new com.google.android.libraries.navigation.internal.zm.a(amVar.aF());
            com.google.android.libraries.navigation.internal.zm.a aVar44 = new com.google.android.libraries.navigation.internal.zm.a(amVar.aY());
            com.google.android.libraries.navigation.internal.zm.a aVar45 = new com.google.android.libraries.navigation.internal.zm.a(amVar.aP());
            com.google.android.libraries.navigation.internal.zm.a aVar46 = new com.google.android.libraries.navigation.internal.zm.a(amVar.ao());
            com.google.android.libraries.navigation.internal.zm.a aVar47 = new com.google.android.libraries.navigation.internal.zm.a(amVar.aH());
            com.google.android.libraries.navigation.internal.zm.a aVar48 = new com.google.android.libraries.navigation.internal.zm.a(amVar.az());
            com.google.android.libraries.navigation.internal.zm.a aVar49 = new com.google.android.libraries.navigation.internal.zm.a(amVar.aJ());
            com.google.android.libraries.navigation.internal.uj.d dVar3 = new com.google.android.libraries.navigation.internal.uj.d(bhVar, wVarA, context, new com.google.android.libraries.navigation.internal.uj.b(aVar16, aVar23, aVar22, aVar17, dVar2, gVar2, kVar3, aVar26, lVar, new com.google.android.libraries.navigation.internal.zm.a(null), aVar20, new com.google.android.libraries.navigation.internal.zm.a(null)), amVar.aX(), amVar.aZ(), (com.google.android.libraries.navigation.internal.ms.at) aVar35.a);
            amVar.t();
            com.google.android.libraries.navigation.internal.zm.a aVar50 = new com.google.android.libraries.navigation.internal.zm.a(new com.google.android.libraries.navigation.internal.uq.n());
            com.google.android.libraries.navigation.internal.uq.c cVar = new com.google.android.libraries.navigation.internal.uq.c(new com.google.android.libraries.navigation.internal.uq.a(new com.google.android.libraries.navigation.internal.us.am(aVar24, aVar20, aVar18, aVar19, aVar21, aVar31, aVar32, aVar22, aVar33, aVar34, aVar50, aVar37, aVar38), new com.google.android.libraries.navigation.internal.us.ad(aVar24, aVar20, aVar18, aVar19, aVar21, aVar31, aVar32, aVar33, aVar34, aVar50, aVar38, aVar47, aVar49), new com.google.android.libraries.navigation.internal.us.c(aVar24, aVar18, aVar19, aVar21, aVar20, aVar31, aVar32, aVar27, aVar33, aVar34, aVar50, aVar22, aVar38, aVar29), (Optional) aVar30.a), new com.google.android.libraries.navigation.internal.uq.j(new com.google.android.libraries.navigation.internal.vi.c(aVar22, aVar24, aVar20, aVar18, aVar19, aVar21, aVar31, aVar32, aVar33, aVar34, aVar50, aVar35, aVar38, aVar46), new com.google.android.libraries.navigation.internal.vi.m(aVar42, aVar44, aVar24, aVar29, aVar18, aVar19, aVar21, aVar31, aVar32, aVar33, aVar34, aVar50, aVar45, aVar20, aVar43, aVar38, aVar46, aVar41, aVar35, aVar36), new com.google.android.libraries.navigation.internal.us.ai(aVar24, aVar18, aVar19, aVar21, aVar31, aVar32, aVar33, aVar34, aVar50, aVar28, aVar23, aVar35, aVar20, aVar38, aVar39, aVar41, aVar47, aVar49), new com.google.android.libraries.navigation.internal.vi.v(aVar24, aVar18, aVar19, aVar21, aVar31, aVar32, aVar33, aVar34, aVar50, aVar35, aVar25, aVar20, aVar29, aVar38, aVar40, aVar28, aVar39, aVar48, aVar41, aVar46, aVar47, aVar49), amVar.ao()));
            com.google.android.libraries.navigation.internal.uq.k kVar8 = new com.google.android.libraries.navigation.internal.uq.k(new com.google.android.libraries.navigation.internal.uq.g(wVarA, amVar.bl(), amVar.bb(), amVar.B()), amVar.aI());
            com.google.android.libraries.navigation.internal.hf.n.a aVar51 = new com.google.android.libraries.navigation.internal.hf.n.a();
            aVar51.c();
            com.google.android.libraries.navigation.internal.vl.c cVar2 = new com.google.android.libraries.navigation.internal.vl.c(bhVar, wVarA, context, amVar.au(), amVar.B(), amVar.f(), dVar3, cVar, (Executor) aVar33.a, new com.google.android.libraries.navigation.internal.uz.d(context, new com.google.android.libraries.navigation.internal.uz.i(context, amVar.H(), context.getResources(), new com.google.android.libraries.navigation.internal.hf.n(context.getResources()), new com.google.android.libraries.navigation.internal.vb.m(aVar51).a, amVar.aA())));
            com.google.android.libraries.navigation.internal.wb.n nVar = new com.google.android.libraries.navigation.internal.wb.n(ev.m(wVarA, wVar2, lVar3, kVar8, cVar2, aiVar2.a, new com.google.android.libraries.navigation.internal.vd.q(kVar7, iVarG2, context, amVar.B(), amVar.C(), amVar.ar(), amVar.H(), amVar.an(), amVar.ao())), wVarA, cVar2, wVar2, lVar3);
            navigationView = this;
            navigationView.f91n = nVar;
            nVar.c(navigationView.M);
            navigationView.f91n.d(navigationView.N);
            amVar.C().n(com.google.android.libraries.navigation.internal.iv.ab.aN, true);
            navigationView.o.J(navigationView.j, amVar.av(), navigationView.i, navigationView.I.a, lVar, dVar2, gVar2, kVar3, amVar.aK(), amVar.c(), amVar.W(), navigationView.f91n, amVar.bu(), amVar.bq(), amVar.ao());
            navigationView.a.f(navigationView.o);
            for (Map.Entry entry : navigationView.H.entrySet()) {
                navigationView.a.g((View) entry.getValue(), (CustomControlPosition) entry.getKey());
            }
            navigationView.H.clear();
            navigationView.f91n.h(bundle);
            com.google.android.libraries.navigation.internal.vu.x xVar2 = new com.google.android.libraries.navigation.internal.vu.x(navigationView.p, amVar.az(), navigationView.j.b().a, amVar.bb());
            navigationView.F = xVar2;
            xVar2.f.e(xVar2.i, xVar2.g);
            xVar2.e.c(xVar2.h, xVar2.g);
            xVar2.h.a(xVar2.e.a());
            navigationView.F.b(navigationView.N);
            com.google.android.libraries.navigation.internal.wb.q qVar = navigationView.m;
            com.google.android.libraries.navigation.internal.wb.n nVar2 = navigationView.f91n;
            bp bpVar4 = navigationView.a;
            qVar.c = nVar2;
            qVar.d = bpVar4;
            qVar.a.c(qVar.e, qVar.b);
            if (qVar.a.b() == com.google.android.libraries.navigation.internal.rw.p.GUIDING) {
                qVar.b();
            }
            gp gpVar = new gp(navigationView.j, navigationView.o.i(), amVar.W(), amVar.S());
            navigationView.G = gpVar;
            gpVar.a.addArrivalListener(gpVar);
            gpVar.a.addNavigationSessionListener(gpVar);
            gpVar.a.addReroutingListener(gpVar);
            gpVar.a.addRemainingTimeOrDistanceChangedListener(10000, 20, gpVar);
            gpVar.a.e(gpVar);
            gpVar.a.addTrafficUpdatedListener(gpVar);
            dn dnVar = navigationView.y;
            Boolean bool = dnVar.d;
            boolean z2 = bool == null || bool.booleanValue();
            dnVar.d = null;
            dnVar.b(z2, !dnVar.b);
            dnVar.b = true;
            dnVar.c = true;
        } else {
            navigationView = this;
        }
        if (navigationView.K) {
            g();
        }
        if (((Boolean) navigationView.L.a.c()).booleanValue()) {
            f();
        }
    }

    final synchronized void c(com.google.android.libraries.navigation.internal.xd.a aVar) {
        if (this.z == null && aVar != null) {
            this.z = aVar;
            for (Map.Entry entry : this.P.entrySet()) {
                e((com.google.android.libraries.navigation.internal.zp.n) entry.getKey(), (Boolean) entry.getValue());
            }
            this.P.clear();
        }
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            d(com.google.android.libraries.navigation.internal.zp.n.G);
            this.w.a(onMapReadyCallback);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public boolean isNavigationUiEnabled() {
        try {
            return this.y.e;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        com.google.android.libraries.navigation.internal.pz.d dVarC;
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            d(com.google.android.libraries.navigation.internal.zp.n.H);
            com.google.android.libraries.navigation.internal.vu.r rVar = this.f;
            if (rVar != null) {
                com.google.android.libraries.navigation.internal.oa.k kVar = rVar.d;
                com.google.android.libraries.navigation.internal.yx.ar.q(kVar);
                kVar.i.a(new Point(0, 0));
                com.google.android.libraries.navigation.internal.oa.e eVarB = kVar.b();
                if (((com.google.android.libraries.navigation.internal.po.fk) eVarB).V && (dVarC = ((com.google.android.libraries.navigation.internal.po.fk) eVarB).m.c()) != null) {
                    ((com.google.android.libraries.navigation.internal.po.fk) eVarB).g(dVarC.b);
                }
            }
            if (this.j != null) {
                this.f91n.ay(configuration);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onCreate(final Bundle bundle) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            String strA = this.Q.a(com.google.android.libraries.navigation.internal.wb.e.ON_CREATE);
            com.google.android.libraries.navigation.internal.abf.t.b(strA == null, strA);
            if (bundle != null) {
                this.M = (bd) bundle.getSerializable("callout_display_mode_override");
                this.N = (com.google.android.libraries.navigation.internal.cl.be) bundle.getSerializable("callout_format_override");
                this.o.G(bundle);
            }
            this.J = true;
            com.google.android.libraries.navigation.environment.am orCreate = NavApiEnvironmentManager.getOrCreate(com.google.android.libraries.navigation.internal.abf.b.a(getContext()));
            this.c = orCreate;
            c(orCreate.bw());
            d(com.google.android.libraries.navigation.internal.zp.n.I);
            Context context = getContext();
            this.A = new be(context, context.getResources());
            com.google.android.libraries.navigation.internal.xe.an anVar = new com.google.android.libraries.navigation.internal.xe.an(this.c, this.y, this.i, this.x);
            com.google.android.libraries.navigation.internal.abh.m mVarBB = this.c.bB();
            GoogleMapOptions googleMapOptions = this.E;
            if (googleMapOptions == null) {
                googleMapOptions = new GoogleMapOptions();
            }
            if (this.B == null) {
                this.B = cm.ay(googleMapOptions, true, this.A, mVarBB, anVar, new com.google.android.libraries.navigation.internal.ly.ct(cs.a, anVar));
                this.D = anVar.b;
            }
            this.B.aG(bundle);
            final com.google.android.libraries.navigation.internal.oo.b bVarF = this.D.f();
            MapsInitializer.initialize(context);
            this.C = new GoogleMap(this.B);
            final com.google.android.libraries.navigation.internal.vu.r rVar = new com.google.android.libraries.navigation.internal.vu.r(context.getResources());
            this.f = rVar;
            com.google.android.libraries.navigation.environment.am amVar = this.c;
            final com.google.android.libraries.navigation.internal.oa.k kVarAw = this.B.aw();
            com.google.android.libraries.navigation.internal.ra.c.b = amVar.P();
            com.google.android.libraries.navigation.internal.ra.c.c = amVar.M();
            com.google.android.libraries.navigation.internal.ra.c.d = amVar.R();
            com.google.android.libraries.navigation.internal.ra.c.e = amVar.N();
            com.google.android.libraries.navigation.internal.ra.c.f = amVar.Q();
            com.google.android.libraries.navigation.internal.ra.c.g = amVar.O();
            if (kVarAw == null || bVarF == null) {
                com.google.android.libraries.navigation.internal.pu.m mVarC = amVar.ax().c();
                mVarC.a = amVar.t();
                mVarC.b = com.google.android.libraries.navigation.internal.ob.n.g().b();
                mVarC.c = com.google.android.libraries.navigation.internal.pz.c.PHONES_AND_TABLETS;
                mVarC.g = com.google.android.libraries.navigation.internal.vu.r.a;
                final com.google.android.libraries.navigation.internal.vu.t tVar = (com.google.android.libraries.navigation.internal.vu.t) ((com.google.android.libraries.navigation.internal.yx.aw) amVar.b()).a;
                mVarC.d = new com.google.android.libraries.navigation.internal.oo.c() { // from class: com.google.android.libraries.navigation.internal.vu.k
                    @Override // com.google.android.libraries.navigation.internal.oo.c
                    public final com.google.android.libraries.navigation.internal.pn.l a(com.google.android.libraries.navigation.internal.pi.s sVar) {
                        return t.a(sVar);
                    }
                };
                bVarF = mVarC.a();
                rVar.c = bVarF;
                rVar.o = true;
                bVarF.l();
                kVarAw = ((com.google.android.libraries.navigation.internal.oo.a) bVarF).b();
                rVar.d = kVarAw;
            } else {
                rVar.d = kVarAw;
                rVar.c = bVarF;
                rVar.o = false;
            }
            com.google.android.libraries.navigation.internal.po.d dVar = ((com.google.android.libraries.navigation.internal.po.fk) kVarAw.b()).F;
            dh dhVar = ((com.google.android.libraries.navigation.internal.po.fk) kVarAw.b()).H;
            hi hiVar = ((com.google.android.libraries.navigation.internal.po.fk) kVarAw.b()).I;
            com.google.android.libraries.navigation.internal.on.h hVarA = kVarAw.b().a();
            rVar.h = amVar.w();
            rVar.u = amVar.bj();
            Executor executorBa = amVar.ba();
            Resources resources = rVar.b;
            com.google.android.libraries.navigation.internal.oa.l lVar = rVar.u;
            com.google.android.libraries.navigation.internal.yx.ar.q(lVar);
            rVar.f = new com.google.android.libraries.navigation.internal.r.m(executorBa, resources, lVar, kVarAw.h, new com.google.android.libraries.navigation.internal.vu.n(dVar), new com.google.android.libraries.navigation.internal.vu.o(dhVar), new com.google.android.libraries.navigation.internal.vu.p(hiVar), new com.google.android.libraries.navigation.internal.afo.a() { // from class: com.google.android.libraries.navigation.internal.vu.b
                @Override // com.google.android.libraries.navigation.internal.afo.a
                public final Object a() {
                    return com.google.android.libraries.navigation.internal.yx.a.a;
                }
            }, new com.google.android.libraries.navigation.internal.vu.c(hVarA));
            rVar.g = new com.google.android.libraries.navigation.internal.u.d(amVar.B(), kVarAw, Optional.of(amVar.ax()));
            rVar.g.a();
            rVar.q = com.google.android.libraries.navigation.internal.hx.u.a(kVarAw.d, new com.google.android.libraries.navigation.internal.hx.q() { // from class: com.google.android.libraries.navigation.internal.vu.d
                @Override // com.google.android.libraries.navigation.internal.hx.q
                public final void a(Object obj) {
                    r rVar2 = rVar;
                    com.google.android.libraries.navigation.internal.oa.k kVar = rVar2.d;
                    ar.q(kVar);
                    rVar2.p = kVar.a();
                    if (rVar2.p.getParent() != null) {
                        ((ViewGroup) rVar2.p.getParent()).removeView(rVar2.p);
                    }
                    this.addView(rVar2.p, 0);
                    ar.k(!rVar2.f643n);
                    if (rVar2.m) {
                        rVar2.f643n = true;
                    }
                    kVar.o = true;
                    kVar.M();
                }
            }, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
            rVar.r = amVar.c();
            rVar.r.a().e(rVar.t, amVar.W());
            rVar.s = new com.google.android.libraries.navigation.internal.og.d(new com.google.android.libraries.navigation.internal.vu.a(kVarAw), new com.google.android.libraries.navigation.internal.vu.h(new com.google.android.libraries.navigation.internal.og.a(new com.google.android.libraries.navigation.internal.og.p(bVarF.h(), amVar.I(), amVar.J()))), new com.google.android.libraries.navigation.internal.vu.i(bVarF), new com.google.android.libraries.navigation.internal.vu.j(amVar.bb()));
            com.google.android.libraries.navigation.internal.ok.b bVar = new com.google.android.libraries.navigation.internal.ok.b(bVarF.j(), com.google.android.libraries.navigation.internal.vu.r.a, amVar.h());
            rVar.e = bVar;
            com.google.android.libraries.navigation.internal.afo.a aVar = new com.google.android.libraries.navigation.internal.afo.a() { // from class: com.google.android.libraries.navigation.internal.vu.e
                @Override // com.google.android.libraries.navigation.internal.afo.a
                public final Object a() {
                    return bVarF;
                }
            };
            com.google.android.libraries.navigation.internal.afo.a aVar2 = new com.google.android.libraries.navigation.internal.afo.a() { // from class: com.google.android.libraries.navigation.internal.vu.f
                @Override // com.google.android.libraries.navigation.internal.afo.a
                public final Object a() {
                    return kVarAw;
                }
            };
            final com.google.android.libraries.navigation.internal.om.p pVarJ = amVar.J();
            Objects.requireNonNull(pVarJ);
            com.google.android.libraries.navigation.internal.agl.a aVar3 = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.vu.g
                @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
                public final Object a() {
                    return pVarJ.e();
                }
            };
            boolean zI = kVarAw.k.i();
            amVar.J().b();
            amVar.J().b();
            com.google.android.libraries.navigation.internal.vu.l lVar2 = new com.google.android.libraries.navigation.internal.vu.l(bVar);
            amVar.ax().b();
            com.google.android.libraries.navigation.internal.oi.e eVar = new com.google.android.libraries.navigation.internal.oi.e(aVar, aVar2, aVar3, false, zI, false, lVar2);
            rVar.k = eVar;
            rVar.j = new com.google.android.libraries.navigation.internal.oi.b(eVar);
            DisplayMetrics displayMetrics = rVar.b.getDisplayMetrics();
            rVar.i = new com.google.android.libraries.navigation.internal.pb.k(displayMetrics.widthPixels, displayMetrics.heightPixels);
            bn bnVarS = amVar.S();
            com.google.android.libraries.navigation.internal.yx.ar.q(bnVarS);
            bnVarS.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.vu.m
                @Override // java.lang.Runnable
                public final void run() {
                    rVar.a();
                }
            });
            com.google.android.libraries.navigation.internal.xe.as asVar = this.g;
            com.google.android.libraries.navigation.internal.oa.k kVarAw2 = this.B.aw();
            com.google.android.libraries.navigation.internal.og.b bVar2 = this.f.s;
            com.google.android.libraries.navigation.internal.oo.b bVarF2 = this.D.f();
            com.google.android.libraries.navigation.internal.cr.f fVarJ = this.D.j();
            com.google.android.libraries.navigation.internal.ih.a aVarC = com.google.android.libraries.navigation.internal.ih.a.c(this.f.e);
            com.google.android.libraries.navigation.internal.ih.a aVarC2 = com.google.android.libraries.navigation.internal.ih.a.c(this.f.b());
            Resources resources2 = getResources();
            com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
            asVar.s = bVarF2.h();
            asVar.g.v(kVarAw2, bVarF2, fVarJ, aVarC, aVarC2, resources2);
            asVar.f403n = new com.google.android.libraries.navigation.internal.dp.ab(asVar.c, asVar.d, bVarF2.h(), asVar.v);
            asVar.k = kVarAw2;
            asVar.l = bVar2;
            boolean zA = bVarF2.s().a();
            asVar.j = zA;
            if (zA) {
                asVar.p = new com.google.android.libraries.navigation.internal.dp.n(asVar.f, asVar.e, asVar.u, bVarF2.h());
            } else {
                asVar.o = new com.google.android.libraries.navigation.internal.dp.m(asVar.f, kVarAw2.c(), asVar.e, asVar.u, Optional.of(bVarF2.h()));
            }
            synchronized (asVar.b) {
                asVar.q = asVar.i.e();
            }
            if (this.f.c() != null) {
                this.f.c().a(this.R, this.c.bb());
            }
            this.B.aT(new com.google.android.libraries.navigation.internal.xe.a(this.o, this.z));
            if (googleMapOptions.getCompassEnabled() != null) {
                this.o.L(googleMapOptions.getCompassEnabled().booleanValue());
            }
            this.b = new com.google.android.libraries.navigation.internal.xe.v(this, this.B);
            dn dnVar = this.y;
            if (bundle != null && dnVar.d == null && bundle.containsKey("navigation_ui_enabled")) {
                dnVar.d = Boolean.valueOf(bundle.getBoolean("navigation_ui_enabled"));
            }
            Boolean bool = dnVar.d;
            if (!(bool == null ? ek.a().f() : bool.booleanValue())) {
                dnVar.b(false, true);
                dnVar.b = true;
            }
            this.S = this.c.bD();
            this.O = new ej() { // from class: com.google.android.libraries.navigation.ai
                @Override // com.google.android.libraries.navigation.internal.xe.ej
                public final void a(Navigator navigator, com.google.android.libraries.navigation.environment.am amVar2) throws Throwable {
                    this.a.b(bundle, navigator, amVar2);
                }
            };
            ek.a().d(this.O);
            this.w.b(this.C);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v44, types: [com.google.android.libraries.navigation.internal.az.b, com.google.android.libraries.navigation.internal.pq.a] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void onDestroy() {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            String strA = this.Q.a(com.google.android.libraries.navigation.internal.wb.e.ON_DESTROY);
            boolean z = true;
            com.google.android.libraries.navigation.internal.abf.t.b(strA == null, strA);
            d(com.google.android.libraries.navigation.internal.zp.n.J);
            ek.a().e(this.O);
            this.H.clear();
            removeAllViews();
            if (this.j != null) {
                gp gpVar = this.G;
                gpVar.a.removeArrivalListener(gpVar);
                gpVar.a.removeNavigationSessionListener(gpVar);
                gpVar.a.removeReroutingListener(gpVar);
                gpVar.a.removeRemainingTimeOrDistanceChangedListener(gpVar);
                gpVar.a.h(gpVar);
                gpVar.a.removeTrafficUpdatedListener(gpVar);
                gpVar.b.h(null);
                this.f91n.aC();
                this.o.H();
                com.google.android.libraries.navigation.internal.xe.v vVar = this.b;
                if (com.google.android.libraries.navigation.internal.afw.g.c()) {
                    ViewParent parent = vVar.c.getParent();
                    NavigationView navigationView = vVar.a;
                    if (parent == navigationView) {
                        navigationView.removeView(vVar.c);
                    }
                    ViewParent parent2 = vVar.b.getParent();
                    NavigationView navigationView2 = vVar.a;
                    if (parent2 == navigationView2) {
                        navigationView2.removeView(vVar.b);
                    }
                }
                bp bpVar = this.a;
                bpVar.o.e();
                cq cqVar = bpVar.q;
                if (cqVar != null) {
                    cqVar.e();
                }
                cq cqVar2 = bpVar.p;
                if (cqVar2 != null) {
                    cqVar2.e();
                }
                ((ba) this.t.a()).d();
                this.c.w().h(0.0f);
                com.google.android.libraries.navigation.internal.wb.q qVar = this.m;
                qVar.a.d(qVar.e);
                com.google.android.libraries.navigation.internal.vu.x xVar = this.F;
                xVar.f.h(xVar.i);
                xVar.e.d(xVar.h);
                com.google.android.libraries.navigation.internal.ec.c cVarAq = this.c.aq();
                com.google.android.libraries.navigation.internal.nj.i.b();
                if (cVarAq.k <= 0) {
                    z = false;
                }
                com.google.android.libraries.navigation.internal.yx.ar.b(z, "Please call onCreate to initialize this class!");
                int i = cVarAq.k - 1;
                cVarAq.k = i;
                if (i <= 0) {
                    cVarAq.b.e(com.google.android.libraries.navigation.internal.ec.c.a, com.google.android.libraries.navigation.internal.ed.a.class).h(cVarAq.l);
                    cVarAq.c.e(cVarAq.m);
                }
                com.google.android.libraries.navigation.internal.wb.s sVar = this.r;
                com.google.android.libraries.navigation.internal.ec.c cVar = sVar.a;
                com.google.android.libraries.navigation.internal.yx.ar.q(cVar);
                cVar.a().h(sVar.d);
                com.google.android.libraries.navigation.internal.wb.d dVar = this.s;
                dVar.a.setNorthDrawableId(-1);
                dVar.a.setNeedleDrawableId(-1);
                dVar.a.setBackgroundDrawableId(-1);
                this.p.a();
                ?? r0 = this.p;
                com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
                ((com.google.android.libraries.navigation.internal.bm.o) r0).g.h();
                ct ctVar = ((com.google.android.libraries.navigation.internal.bm.o) r0).v;
                ct ctVar2 = ((com.google.android.libraries.navigation.internal.bm.o) r0).v;
                com.google.android.libraries.navigation.internal.bm.ap apVar = ((com.google.android.libraries.navigation.internal.bm.o) r0).h;
                apVar.a();
                com.google.android.libraries.navigation.internal.bo.f fVar = apVar.a;
                synchronized (((com.google.android.libraries.navigation.internal.bm.o) r0).f346n) {
                    com.google.android.libraries.navigation.internal.bm.ar arVar = ((com.google.android.libraries.navigation.internal.bm.o) r0).o;
                    if (arVar != null) {
                        arVar.a();
                        ((com.google.android.libraries.navigation.internal.bm.o) r0).o = null;
                    }
                }
                ((com.google.android.libraries.navigation.internal.bm.o) r0).b.l.f(r0);
                ((com.google.android.libraries.navigation.internal.bm.o) r0).i.a().h(((com.google.android.libraries.navigation.internal.bm.o) r0).t);
            }
            if (this.f.c() != null) {
                this.f.c().k(this.R);
            }
            this.y.a.c();
            com.google.android.libraries.navigation.internal.vu.r rVar = this.f;
            if (rVar.p != null) {
                rVar.p = null;
                if (rVar.o) {
                    com.google.android.libraries.navigation.internal.oa.k kVar = rVar.d;
                    com.google.android.libraries.navigation.internal.yx.ar.q(kVar);
                    kVar.m();
                    com.google.android.libraries.navigation.internal.fq.f fVar2 = rVar.h;
                    com.google.android.libraries.navigation.internal.yx.ar.q(fVar2);
                    fVar2.h(0.0f);
                }
                rVar.d = null;
            }
            rVar.c = null;
            com.google.android.libraries.navigation.internal.ws.a aVar = rVar.q;
            com.google.android.libraries.navigation.internal.yx.ar.q(aVar);
            aVar.c();
            rVar.q = null;
            com.google.android.libraries.navigation.internal.ed.b bVar = rVar.r;
            if (bVar != null) {
                bVar.a().h(rVar.t);
            }
            com.google.android.libraries.navigation.internal.yx.ar.q(rVar.g);
            rVar.g.b();
            this.B.aU(null);
            this.B.aT(null);
            this.B.aH();
            this.g.m();
            this.J = false;
            this.b = null;
            this.A.o();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onPause() {
        com.google.android.libraries.geo.mapcore.internal.ui.h hVar;
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            String strA = this.Q.a(com.google.android.libraries.navigation.internal.wb.e.ON_PAUSE);
            com.google.android.libraries.navigation.internal.abf.t.b(strA == null, strA);
            d(com.google.android.libraries.navigation.internal.zp.n.K);
            fi fiVar = this.j;
            if (fiVar != null) {
                fiVar.f();
                com.google.android.libraries.navigation.internal.wb.t tVar = this.d;
                com.google.android.libraries.navigation.internal.pi.s sVar = tVar.a;
                com.google.android.libraries.navigation.internal.yx.ar.q(sVar);
                sVar.l(tVar);
                com.google.android.libraries.navigation.internal.pi.s sVar2 = tVar.a;
                com.google.android.libraries.navigation.internal.yx.ar.q(sVar2);
                sVar2.m(tVar);
                com.google.android.libraries.navigation.internal.wb.d dVar = this.s;
                dVar.d.h(dVar.g);
                dVar.c.h(dVar.f);
                CompassButtonView compassButtonView = this.a.j;
                gr grVar = compassButtonView.f;
                if (grVar != null && (hVar = compassButtonView.c) != null) {
                    grVar.e(hVar);
                }
                compassButtonView.c = null;
                compassButtonView.f = null;
            }
            com.google.android.libraries.navigation.internal.vu.r rVar = this.f;
            if (rVar.f643n) {
                rVar.f643n = false;
            }
            rVar.m = false;
            this.B.aJ();
            this.g.b();
            this.L.b(Boolean.FALSE);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onResume() {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            String strA = this.Q.a(com.google.android.libraries.navigation.internal.wb.e.ON_RESUME);
            com.google.android.libraries.navigation.internal.abf.t.b(strA == null, strA);
            d(com.google.android.libraries.navigation.internal.zp.n.L);
            f();
            this.B.aK();
            this.g.g();
            com.google.android.libraries.navigation.internal.vu.r rVar = this.f;
            rVar.m = true;
            com.google.android.libraries.navigation.internal.yx.ar.k(!rVar.f643n);
            com.google.android.libraries.navigation.internal.oa.k kVar = rVar.d;
            com.google.android.libraries.navigation.internal.yx.ar.q(kVar);
            if (rVar.o) {
                kVar.h().o();
            }
            if (kVar.d.isDone()) {
                rVar.f643n = true;
            }
            this.L.b(Boolean.TRUE);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            d(com.google.android.libraries.navigation.internal.zp.n.M);
            com.google.android.libraries.navigation.internal.wb.n nVar = this.f91n;
            if (nVar != null) {
                nVar.j(bundle);
            }
            this.o.K(bundle);
            Boolean bool = this.d.d;
            if (bool != null) {
                bundle.putBoolean("TrafficIncidentController.clickedEventEnabled", bool.booleanValue());
            }
            this.B.aL(bundle);
            com.google.android.libraries.navigation.internal.ed.a aVar = this.r.c;
            if (aVar != null) {
                bundle.putSerializable("force_night_mode", aVar);
            }
            bundle.putSerializable("callout_display_mode_override", this.M);
            bundle.putSerializable("callout_format_override", this.N);
            bundle.putBoolean("navigation_ui_enabled", this.y.e);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onStart() {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            String strA = this.Q.a(com.google.android.libraries.navigation.internal.wb.e.ON_START);
            com.google.android.libraries.navigation.internal.abf.t.b(strA == null, strA);
            d(com.google.android.libraries.navigation.internal.zp.n.N);
            this.B.aM();
            com.google.android.libraries.navigation.internal.vu.r rVar = this.f;
            com.google.android.libraries.navigation.internal.yx.ar.k(!rVar.l);
            rVar.l = true;
            if (rVar.o) {
                com.google.android.libraries.navigation.internal.oa.k kVar = rVar.d;
                com.google.android.libraries.navigation.internal.yx.ar.q(kVar);
                kVar.q();
            }
            com.google.android.libraries.navigation.internal.oo.b bVarF = this.D.f();
            com.google.android.libraries.navigation.internal.pb.k kVar2 = this.f.i;
            com.google.android.libraries.navigation.internal.yx.ar.q(kVar2);
            bVarF.q(kVar2);
            this.g.h();
            this.S.a();
            if (this.j != null) {
                g();
            }
            this.K = true;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onStop() {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            String strA = this.Q.a(com.google.android.libraries.navigation.internal.wb.e.ON_STOP);
            com.google.android.libraries.navigation.internal.abf.t.b(strA == null, strA);
            d(com.google.android.libraries.navigation.internal.zp.n.O);
            this.S.b();
            if (this.j != null) {
                this.f91n.l();
            }
            com.google.android.libraries.navigation.internal.vu.r rVar = this.f;
            com.google.android.libraries.navigation.internal.yx.ar.k(rVar.l);
            if (rVar.o) {
                com.google.android.libraries.navigation.internal.oa.k kVar = rVar.d;
                com.google.android.libraries.navigation.internal.yx.ar.q(kVar);
                kVar.r();
            }
            rVar.l = false;
            this.B.aN();
            this.g.c();
            com.google.android.libraries.navigation.internal.xl.c cVar = this.u;
            if (cVar != null) {
                cVar.z();
            }
            this.K = false;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onTrimMemory(int i) {
        try {
            d(com.google.android.libraries.navigation.internal.zp.n.P);
            bp bpVar = this.a;
            if (bpVar != null) {
                bg bgVarF = bpVar.b.f();
                synchronized (bgVarF.c) {
                    bgVarF.b.a.clear();
                    bgVarF.a.q();
                }
                com.google.android.libraries.navigation.internal.nc.j.a.evictAll();
                com.google.android.libraries.navigation.internal.nc.j.b.evictAll();
                com.google.android.libraries.navigation.internal.nc.j.c.evictAll();
                com.google.android.libraries.navigation.internal.nc.j.d.evictAll();
                com.google.android.libraries.navigation.internal.nc.j.e.evictAll();
                com.google.android.libraries.navigation.internal.nc.j.f.evictAll();
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void removeOnNightModeChangedListener(OnNightModeChangedListener onNightModeChangedListener) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            d(com.google.android.libraries.navigation.internal.zp.n.Q);
            this.k.remove(onNightModeChangedListener);
            if (this.k.isEmpty()) {
                this.r.c(null);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void removeOnRecenterButtonClickedListener(OnRecenterButtonClickedListener onRecenterButtonClickedListener) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            d(com.google.android.libraries.navigation.internal.zp.n.R);
            this.l.remove(onRecenterButtonClickedListener);
            if (this.l.isEmpty()) {
                this.o.P(null);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setCalloutInfoDisplayModeOverride(NavigationCalloutDisplayMode navigationCalloutDisplayMode) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            NavigationCalloutDisplayMode navigationCalloutDisplayMode2 = NavigationCalloutDisplayMode.SHOW_NONE;
            bd bdVar = null;
            if (navigationCalloutDisplayMode != null) {
                int iOrdinal = navigationCalloutDisplayMode.ordinal();
                if (iOrdinal == 0) {
                    bdVar = bd.SHOW_NONE;
                } else if (iOrdinal == 1) {
                    bdVar = bd.SHOW_ALTERNATES_ONLY;
                } else if (iOrdinal == 2) {
                    bdVar = bd.SHOW_ALL;
                }
            }
            this.M = bdVar;
            com.google.android.libraries.navigation.internal.wb.n nVar = this.f91n;
            if (nVar != null) {
                nVar.c(bdVar);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setCalloutInfoFormatOverride(RouteCalloutInfoFormat routeCalloutInfoFormat) {
        com.google.android.libraries.navigation.internal.cl.be beVar;
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            RouteCalloutInfoFormat routeCalloutInfoFormat2 = RouteCalloutInfoFormat.DEFAULT;
            int iOrdinal = routeCalloutInfoFormat.ordinal();
            if (iOrdinal != 1) {
                beVar = iOrdinal != 2 ? null : com.google.android.libraries.navigation.internal.cl.be.DISTANCE;
            } else {
                beVar = com.google.android.libraries.navigation.internal.cl.be.TIME;
            }
            this.N = beVar;
            com.google.android.libraries.navigation.internal.wb.n nVar = this.f91n;
            if (nVar != null) {
                nVar.d(beVar);
            }
            com.google.android.libraries.navigation.internal.vu.x xVar = this.F;
            if (xVar != null) {
                xVar.b(this.N);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setCustomControl(View view, CustomControlPosition customControlPosition) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            d(com.google.android.libraries.navigation.internal.zp.n.T);
            bp bpVar = this.a;
            if (bpVar != null) {
                bpVar.g(view, customControlPosition);
                return;
            }
            if (view == null) {
                this.H.remove(customControlPosition);
                return;
            }
            if (this.H.get(customControlPosition) == view) {
                return;
            }
            if (this.H.containsValue(view)) {
                com.google.android.libraries.navigation.internal.gz.f.b("Error: Custom control has already been set at a different position.");
            } else if (view.getParent() != null) {
                com.google.android.libraries.navigation.internal.gz.f.b("Error: Custom control already has a parent view.");
            } else {
                this.H.put(customControlPosition, view);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setEtaCardEnabled(boolean z) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            e(com.google.android.libraries.navigation.internal.zp.n.U, Boolean.valueOf(z));
            this.o.N(z);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setForceNightMode(int i) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            d(com.google.android.libraries.navigation.internal.zp.n.V);
            this.r.b(com.google.android.libraries.navigation.internal.xe.z.a(i));
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setHeaderEnabled(boolean z) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            e(com.google.android.libraries.navigation.internal.zp.n.W, Boolean.valueOf(z));
            this.o.O(z);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setNavigationUiEnabled(boolean z) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            cm cmVar = this.B;
            if (cmVar != null && z) {
                cmVar.aP();
            }
            this.y.a(z);
            cm cmVar2 = this.B;
            if (cmVar2 == null || z) {
                return;
            }
            try {
                cmVar2.h.a();
                if (cmVar2.m != cmVar2.b.a()) {
                    cmVar2.b.A(cmVar2.m);
                }
            } catch (Throwable th) {
                bi.a(th);
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (!(th instanceof Error)) {
                    throw new RuntimeException(th);
                }
                throw ((Error) th);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setRecenterButtonEnabled(boolean z) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            e(com.google.android.libraries.navigation.internal.zp.n.X, Boolean.valueOf(z));
            this.o.R(z);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setSpeedLimitIconEnabled(boolean z) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            e(com.google.android.libraries.navigation.internal.zp.n.Y, Boolean.valueOf(z));
            this.o.T(z);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setSpeedometerEnabled(boolean z) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            e(com.google.android.libraries.navigation.internal.zp.n.Z, Boolean.valueOf(z));
            this.o.U(z);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setSpeedometerUiOptions(SpeedometerUiOptions speedometerUiOptions) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            d(com.google.android.libraries.navigation.internal.zp.n.aa);
            this.o.V(speedometerUiOptions);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setStylingOptions(StylingOptions stylingOptions) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            d(com.google.android.libraries.navigation.internal.zp.n.ab);
            this.o.W(stylingOptions.a);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setTrafficIncidentCardsEnabled(boolean z) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            e(com.google.android.libraries.navigation.internal.zp.n.ac, Boolean.valueOf(z));
            this.d.a(z);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setTrafficPromptsEnabled(boolean z) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            e(com.google.android.libraries.navigation.internal.zp.n.ad, Boolean.valueOf(z));
            this.o.Y(z);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setTripProgressBarEnabled(boolean z) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            e(com.google.android.libraries.navigation.internal.zp.n.ae, Boolean.valueOf(z));
            this.o.Z(z);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void showRouteOverview() {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            d(com.google.android.libraries.navigation.internal.zp.n.af);
            com.google.android.libraries.navigation.internal.xe.ai aiVar = this.i;
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            if (aiVar.d()) {
                aiVar.b.a(com.google.android.libraries.navigation.internal.zp.n.CZ);
            }
            com.google.android.libraries.navigation.internal.xe.ah ahVar = aiVar.a;
            ahVar.q = true;
            ahVar.r = null;
            ahVar.p = false;
            ahVar.o(false);
            ahVar.n(false);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void addOnNavigationUiChangedListener(OnNavigationUiChangedListener onNavigationUiChangedListener) {
        try {
            this.y.a.b(onNavigationUiChangedListener, com.google.android.libraries.navigation.internal.vq.c.a);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void removeOnNavigationUiChangedListener(OnNavigationUiChangedListener onNavigationUiChangedListener) {
        try {
            this.y.a.e(onNavigationUiChangedListener);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i, GoogleMapOptions googleMapOptions) {
        this(context, attributeSet, i, new com.google.android.libraries.navigation.internal.xe.ai(), new ds(), new com.google.android.libraries.navigation.internal.wb.t(), new com.google.android.libraries.navigation.internal.wb.s(com.google.android.libraries.navigation.internal.vq.c.a), googleMapOptions);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i, com.google.android.libraries.navigation.internal.xe.ai aiVar, ds dsVar, com.google.android.libraries.navigation.internal.wb.t tVar, com.google.android.libraries.navigation.internal.wb.s sVar, GoogleMapOptions googleMapOptions) {
        super(context, attributeSet, i);
        this.w = new com.google.android.libraries.navigation.internal.xe.k();
        as asVar = new as(this);
        this.x = asVar;
        this.y = new dn(asVar);
        this.H = new EnumMap(CustomControlPosition.class);
        this.I = new com.google.android.libraries.navigation.internal.nt.p();
        this.J = false;
        this.K = false;
        this.L = new com.google.android.libraries.navigation.internal.nt.p(Boolean.FALSE);
        this.P = new HashMap();
        this.Q = new com.google.android.libraries.navigation.internal.wb.f();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.R = new aq(this);
        this.i = aiVar;
        this.o = dsVar;
        this.d = tVar;
        this.r = sVar;
        this.E = googleMapOptions;
    }

    public NavigationView(Context context, AttributeSet attributeSet, GoogleMapOptions googleMapOptions) {
        this(context, attributeSet, 0, googleMapOptions);
    }

    public NavigationView(Context context, GoogleMapOptions googleMapOptions) {
        this(context, (AttributeSet) null, googleMapOptions);
    }
}
