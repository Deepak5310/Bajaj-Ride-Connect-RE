package com.google.android.libraries.navigation.internal.vf;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.by;
import com.google.android.libraries.navigation.internal.ms.bz;
import com.google.android.libraries.navigation.internal.ms.ch;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.da;
import com.google.android.libraries.navigation.internal.ms.dd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v extends bt<com.google.android.libraries.navigation.internal.ut.d> implements com.google.android.libraries.navigation.internal.yt.e {
    private static final com.google.android.libraries.navigation.internal.xn.a g = com.google.android.libraries.navigation.internal.xn.a.d("IncidentCalloutPromptLayout");
    public static final com.google.android.libraries.navigation.internal.nc.ap a = com.google.android.libraries.navigation.internal.w.c.i();
    public static final com.google.android.libraries.navigation.internal.nc.a b = com.google.android.libraries.navigation.internal.nc.a.g(56);
    private static final com.google.android.libraries.navigation.internal.nc.a h = com.google.android.libraries.navigation.internal.nc.a.g(32);
    public static final dd c = da.b(new by() { // from class: com.google.android.libraries.navigation.internal.vf.a
        @Override // com.google.android.libraries.navigation.internal.ms.by
        public final Object a(cs csVar, Context context) {
            com.google.android.libraries.navigation.internal.ut.d dVar = (com.google.android.libraries.navigation.internal.ut.d) csVar;
            com.google.android.libraries.navigation.internal.nc.ap apVar = v.a;
            boolean z = false;
            if (com.google.android.libraries.navigation.internal.ms.aq.b(context) && dVar.u().booleanValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    });
    public static final dd d = da.b(new by() { // from class: com.google.android.libraries.navigation.internal.vf.i
        @Override // com.google.android.libraries.navigation.internal.ms.by
        public final Object a(cs csVar, Context context) {
            com.google.android.libraries.navigation.internal.ut.d dVar = (com.google.android.libraries.navigation.internal.ut.d) csVar;
            com.google.android.libraries.navigation.internal.nc.ap apVar = v.a;
            boolean z = true;
            if (!com.google.android.libraries.navigation.internal.ms.aq.c(context) && !dVar.u().booleanValue()) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    });
    public static final View.AccessibilityDelegate f = new r();

    /* JADX INFO: compiled from: PG */
    final class a extends bt<com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d> implements com.google.android.libraries.navigation.internal.yt.e {
        private static final com.google.android.libraries.navigation.internal.xn.a a = com.google.android.libraries.navigation.internal.xn.a.d("DismissButtonWithProgressLayout");

        @Override // com.google.android.libraries.navigation.internal.ms.bt
        protected final com.google.android.libraries.navigation.internal.mx.g a() {
            return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.af(v.b), com.google.android.libraries.navigation.internal.ms.ah.S(v.b), com.google.android.libraries.navigation.internal.ms.ah.X(v.a), com.google.android.libraries.navigation.internal.ad.a.a(com.google.android.libraries.navigation.internal.jy.aa.k(com.google.android.libraries.navigation.internal.afe.o.p)), com.google.android.libraries.navigation.internal.ms.ah.h(v.f), com.google.android.libraries.navigation.internal.ms.ah.z(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.s
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) csVar).i();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), com.google.android.libraries.navigation.internal.ms.ah.p(com.google.android.libraries.navigation.internal.w.d.c()), com.google.android.libraries.navigation.internal.ms.ah.an(new com.google.android.libraries.navigation.internal.ms.o(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.t
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) csVar).c();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            })), com.google.android.libraries.navigation.internal.ms.ah.c(new b(), new dd() { // from class: com.google.android.libraries.navigation.internal.vf.u
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) csVar).b();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }, new com.google.android.libraries.navigation.internal.mx.m[0]), new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-1), com.google.android.libraries.navigation.internal.ms.ah.aJ(com.google.android.libraries.navigation.internal.nc.aj.d(com.google.android.libraries.navigation.internal.nc.j.i(com.google.android.libraries.navigation.internal.f.d.i, com.google.android.libraries.navigation.internal.w.b.h()), 0.6f)), com.google.android.libraries.navigation.internal.ms.ah.aD(ImageView.ScaleType.FIT_CENTER)));
        }

        @Override // com.google.android.libraries.navigation.internal.yt.e
        public final com.google.android.libraries.navigation.internal.xn.a b() {
            return a;
        }
    }

    /* JADX INFO: compiled from: PG */
    final class b extends bt<com.google.android.libraries.navigation.internal.ah.a> implements com.google.android.libraries.navigation.internal.yt.e {
        public static final /* synthetic */ int a = 0;
        private static final com.google.android.libraries.navigation.internal.xn.a b = com.google.android.libraries.navigation.internal.xn.a.d("ProgressBarLayout");

        @Override // com.google.android.libraries.navigation.internal.ms.bt
        protected final com.google.android.libraries.navigation.internal.mx.g a() {
            return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-1), com.google.android.libraries.navigation.internal.ms.ah.p(com.google.android.libraries.navigation.internal.nc.aj.a(com.google.android.libraries.navigation.internal.w.b.a())), new com.google.android.libraries.navigation.internal.mx.e(ProgressBar.class, new com.google.android.libraries.navigation.internal.mx.o(com.google.android.libraries.navigation.internal.f.i.b), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-1), com.google.android.libraries.navigation.internal.ms.ah.aC(da.b(new by() { // from class: com.google.android.libraries.navigation.internal.vf.w
                @Override // com.google.android.libraries.navigation.internal.ms.by
                public final Object a(cs csVar, Context context) {
                    int i = v.b.a;
                    return new com.google.android.libraries.navigation.internal.nc.ba(com.google.android.libraries.navigation.internal.nc.ae.e(), com.google.android.libraries.navigation.internal.w.b.g(), v.b);
                }
            })), com.google.android.libraries.navigation.internal.ms.ah.l(Float.valueOf(0.16f)), com.google.android.libraries.navigation.internal.ms.ah.aB(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.x
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ah.a) csVar).b();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), com.google.android.libraries.navigation.internal.ms.ah.ai(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.y
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ah.a) csVar).a();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            })));
        }

        @Override // com.google.android.libraries.navigation.internal.yt.e
        public final com.google.android.libraries.navigation.internal.xn.a b() {
            return b;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected final com.google.android.libraries.navigation.internal.mx.g a() {
        com.google.android.libraries.navigation.internal.mx.e eVar = new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.aK(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.c.w)));
        eVar.e(com.google.android.libraries.navigation.internal.ms.ah.G(da.b(new by() { // from class: com.google.android.libraries.navigation.internal.vf.j
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                boolean z = true;
                if (!((Boolean) v.c.a((com.google.android.libraries.navigation.internal.ut.d) csVar)).booleanValue() && !com.google.android.libraries.navigation.internal.af.e.e(context)) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        })));
        dd ddVar = c;
        com.google.android.libraries.navigation.internal.mx.k kVar = new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.Z(com.google.android.libraries.navigation.internal.nc.a.g(8)), com.google.android.libraries.navigation.internal.ms.ah.X(com.google.android.libraries.navigation.internal.nc.a.g(8))});
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr = {com.google.android.libraries.navigation.internal.ms.ah.Z(com.google.android.libraries.navigation.internal.nc.a.g(0)), com.google.android.libraries.navigation.internal.ms.ah.X(com.google.android.libraries.navigation.internal.nc.a.g(0))};
        com.google.android.libraries.navigation.internal.ms.ag agVarA = com.google.android.libraries.navigation.internal.ab.d.a();
        agVarA.a = Float.valueOf(1.0f);
        agVarA.b(600);
        agVarA.g = new com.google.android.libraries.navigation.internal.ms.af() { // from class: com.google.android.libraries.navigation.internal.vf.h
            @Override // com.google.android.libraries.navigation.internal.ms.af
            public final void a(View view, cs csVar) {
                com.google.android.libraries.navigation.internal.nc.ap apVar = v.a;
                view.sendAccessibilityEvent(8);
            }
        };
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr2 = {com.google.android.libraries.navigation.internal.ms.ah.l(0), agVarA.a()};
        com.google.android.libraries.navigation.internal.nc.ap apVar = a;
        by byVar = new by() { // from class: com.google.android.libraries.navigation.internal.vf.f
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                return (Boolean) v.d.a((com.google.android.libraries.navigation.internal.ut.d) csVar);
            }
        };
        com.google.android.libraries.navigation.internal.mx.w wVarAc = com.google.android.libraries.navigation.internal.ms.ah.ac(bz.j(), bz.i());
        bz[] bzVarArr = {bz.q(), bz.i()};
        com.google.android.libraries.navigation.internal.nc.a aVar = h;
        return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), eVar, com.google.android.libraries.navigation.internal.ms.ah.t(da.b(new by() { // from class: com.google.android.libraries.navigation.internal.vf.o
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.nc.ap apVar2 = v.a;
                return Boolean.valueOf(!com.google.android.libraries.navigation.internal.ms.aq.b(context));
            }
        })), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ae(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.p
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).E();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.T(-2), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ak(com.google.android.libraries.navigation.internal.nc.j.k(com.google.android.libraries.navigation.internal.dw.b.a)), com.google.android.libraries.navigation.internal.ms.ah.ab(com.google.android.libraries.navigation.internal.nc.a.g(5)), ch.a(ddVar, kVar, new com.google.android.libraries.navigation.internal.mx.k(mVarArr)), com.google.android.libraries.navigation.internal.ms.ah.ax(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.q
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).D();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.av(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.b
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).C();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.at(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.c
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).B();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.p(com.google.android.libraries.navigation.internal.ur.n.i(com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.r(), com.google.android.libraries.navigation.internal.w.a.b()))), com.google.android.libraries.navigation.internal.ms.ah.B(com.google.android.libraries.navigation.internal.vb.a.a), com.google.android.libraries.navigation.internal.ur.n.c(), com.google.android.libraries.navigation.internal.ur.n.h(), com.google.android.libraries.navigation.internal.ms.ah.E(true), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ad.a.b(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.d
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).j();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.m(true), new com.google.android.libraries.navigation.internal.mx.k(mVarArr2), com.google.android.libraries.navigation.internal.ms.ah.aa(da.b(new by() { // from class: com.google.android.libraries.navigation.internal.vf.e
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                return ((Boolean) v.d.a((com.google.android.libraries.navigation.internal.ut.d) csVar)).booleanValue() ? v.a : com.google.android.libraries.navigation.internal.w.c.k();
            }
        })), com.google.android.libraries.navigation.internal.ms.ah.V(apVar), new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.aq(1), ch.b(byVar, wVarAc, com.google.android.libraries.navigation.internal.ms.ah.ac(bzVarArr)), com.google.android.libraries.navigation.internal.ms.ah.Z(apVar), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.Q(1), new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, com.google.android.libraries.navigation.internal.ms.ah.af(aVar), com.google.android.libraries.navigation.internal.ms.ah.S(aVar), com.google.android.libraries.navigation.internal.ms.ah.X(com.google.android.libraries.navigation.internal.nc.a.g(12)), com.google.android.libraries.navigation.internal.ms.ah.aI(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.g
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).k();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.w.e.j(), com.google.android.libraries.navigation.internal.w.e.g(), com.google.android.libraries.navigation.internal.ms.ah.aV(1), com.google.android.libraries.navigation.internal.ms.ah.aj(2), com.google.android.libraries.navigation.internal.ms.ah.C(TextUtils.TruncateAt.END), com.google.android.libraries.navigation.internal.ms.ah.M(false), com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.k
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).x();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aO(5))), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.Z(com.google.android.libraries.navigation.internal.nc.a.g(44)), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.w.e.b(), com.google.android.libraries.navigation.internal.w.e.i(), com.google.android.libraries.navigation.internal.ms.ah.aj(2), com.google.android.libraries.navigation.internal.ms.ah.C(TextUtils.TruncateAt.END), com.google.android.libraries.navigation.internal.ms.ah.M(false), com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.l
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).A();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aO(5)))), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), ch.b(new by() { // from class: com.google.android.libraries.navigation.internal.vf.m
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                return (Boolean) v.d.a((com.google.android.libraries.navigation.internal.ut.d) csVar);
            }
        }, com.google.android.libraries.navigation.internal.ms.ah.ac(bz.j(), bz.h()), com.google.android.libraries.navigation.internal.ms.ah.ac(bz.q(), bz.h())), com.google.android.libraries.navigation.internal.ms.ah.d(new a(), new dd() { // from class: com.google.android.libraries.navigation.internal.vf.n
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).p();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0])))))));
    }

    @Override // com.google.android.libraries.navigation.internal.yt.e
    public final com.google.android.libraries.navigation.internal.xn.a b() {
        return g;
    }
}
