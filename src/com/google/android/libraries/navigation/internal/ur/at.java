package com.google.android.libraries.navigation.internal.ur;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.google.android.libraries.navigation.internal.ms.bz;
import com.google.android.libraries.navigation.internal.ms.cc;
import com.google.android.libraries.navigation.internal.ms.cg;
import com.google.android.libraries.navigation.internal.ms.ch;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.da;
import com.google.android.libraries.navigation.internal.ms.dd;
import com.google.android.libraries.navigation.internal.ut.d.b;
import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class at<T extends com.google.android.libraries.navigation.internal.ut.d.b> extends com.google.android.libraries.navigation.internal.ms.bt<T> implements com.google.android.libraries.navigation.internal.yt.e {
    public static final cc b = new cc();
    public static final cc c = new cc();
    public static final com.google.android.libraries.navigation.internal.nc.a d = com.google.android.libraries.navigation.internal.nc.a.g(28);
    public static final com.google.android.libraries.navigation.internal.nc.a f = com.google.android.libraries.navigation.internal.nc.a.g(32);
    public static final com.google.android.libraries.navigation.internal.nc.a g = com.google.android.libraries.navigation.internal.nc.a.g(56);

    /* JADX INFO: compiled from: PG */
    final class a extends at<com.google.android.libraries.navigation.internal.ut.d.b> implements com.google.android.libraries.navigation.internal.yt.e {
        private static final com.google.android.libraries.navigation.internal.xn.a a = com.google.android.libraries.navigation.internal.xn.a.d("DefaultPreferredPromptButtonWithoutTimeoutLayout");

        @Override // com.google.android.libraries.navigation.internal.ms.bt
        protected final com.google.android.libraries.navigation.internal.mx.g a() {
            return k(i(com.google.android.libraries.navigation.internal.ju.b.i, com.google.android.libraries.navigation.internal.ju.b.e, Optional.empty()), new com.google.android.libraries.navigation.internal.mx.aa(at.c));
        }

        @Override // com.google.android.libraries.navigation.internal.ur.at, com.google.android.libraries.navigation.internal.yt.e
        public final com.google.android.libraries.navigation.internal.xn.a b() {
            return a;
        }
    }

    /* JADX INFO: compiled from: PG */
    final class b extends com.google.android.libraries.navigation.internal.ms.bt<com.google.android.libraries.navigation.internal.ah.a> implements com.google.android.libraries.navigation.internal.yt.e {
        public static final /* synthetic */ int a = 0;
        private static final com.google.android.libraries.navigation.internal.xn.a b = com.google.android.libraries.navigation.internal.xn.a.d("DefaultPromptButtonProgressBarLayout");
        private final com.google.android.libraries.navigation.internal.nc.x c;
        private final com.google.android.libraries.navigation.internal.nc.x d;

        public b(com.google.android.libraries.navigation.internal.nc.x xVar, com.google.android.libraries.navigation.internal.nc.x xVar2) {
            super(xVar, xVar2);
            this.c = xVar;
            this.d = xVar2;
        }

        @Override // com.google.android.libraries.navigation.internal.ms.bt
        protected final com.google.android.libraries.navigation.internal.mx.g a() {
            com.google.android.libraries.navigation.internal.nc.x xVar = this.d;
            final dd ddVarA = da.a(this.c);
            final dd ddVarA2 = da.a(xVar);
            return new com.google.android.libraries.navigation.internal.mx.e(ProgressBar.class, new com.google.android.libraries.navigation.internal.mx.o(com.google.android.libraries.navigation.internal.f.i.b), com.google.android.libraries.navigation.internal.ms.ah.T(-1), com.google.android.libraries.navigation.internal.ms.ah.ac(bz.k(at.b), bz.e(at.b)), com.google.android.libraries.navigation.internal.ms.ah.aC(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.au
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    com.google.android.libraries.navigation.internal.ah.a aVar = (com.google.android.libraries.navigation.internal.ah.a) csVar;
                    int i = at.b.a;
                    return new com.google.android.libraries.navigation.internal.nc.ba((com.google.android.libraries.navigation.internal.nc.x) ddVarA.a(aVar), (com.google.android.libraries.navigation.internal.nc.x) ddVarA2.a(aVar), at.d);
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), com.google.android.libraries.navigation.internal.ms.ah.aB(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.av
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ah.a) csVar).b();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), com.google.android.libraries.navigation.internal.ms.ah.ai(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.aw
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ah.a) csVar).a();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }));
        }

        @Override // com.google.android.libraries.navigation.internal.yt.e
        public final com.google.android.libraries.navigation.internal.xn.a b() {
            return b;
        }
    }

    /* JADX INFO: compiled from: PG */
    class c extends at<com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d> implements com.google.android.libraries.navigation.internal.yt.e {
        private static final com.google.android.libraries.navigation.internal.xn.a h = com.google.android.libraries.navigation.internal.xn.a.d("DefaultPromptButtonWithTimeoutLayout");
        public static final dd a = da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.ur.be
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d interfaceC0038d = (com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) csVar;
                dd ddVar = at.c.a;
                boolean z = false;
                if (com.google.android.libraries.navigation.internal.ms.aq.b(context) && !interfaceC0038d.l().booleanValue()) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        });

        @Override // com.google.android.libraries.navigation.internal.ms.bt
        protected com.google.android.libraries.navigation.internal.mx.g a() {
            com.google.android.libraries.navigation.internal.af.a aVar = com.google.android.libraries.navigation.internal.ju.b.i;
            com.google.android.libraries.navigation.internal.nc.x xVarA = com.google.android.libraries.navigation.internal.nc.y.a(com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.b(), com.google.android.libraries.navigation.internal.w.a.r()), 0.3f);
            return c(new b(aVar, xVarA), com.google.android.libraries.navigation.internal.ju.b.e, aVar, da.a(xVarA));
        }

        @Override // com.google.android.libraries.navigation.internal.ur.at, com.google.android.libraries.navigation.internal.yt.e
        public com.google.android.libraries.navigation.internal.xn.a b() {
            return h;
        }

        final com.google.android.libraries.navigation.internal.mx.g c(com.google.android.libraries.navigation.internal.ms.bt btVar, com.google.android.libraries.navigation.internal.nc.x xVar, com.google.android.libraries.navigation.internal.nc.x xVar2, dd ddVar) {
            com.google.android.libraries.navigation.internal.mx.m[] mVarArr = {i(xVar2, xVar, Optional.of(btVar))};
            dd ddVar2 = a;
            Float fValueOf = Float.valueOf(0.0f);
            com.google.android.libraries.navigation.internal.mx.k kVar = new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.ad(fValueOf)});
            com.google.android.libraries.navigation.internal.mx.m[] mVarArr2 = {com.google.android.libraries.navigation.internal.ms.ah.ag(0), com.google.android.libraries.navigation.internal.ms.ah.ad(Float.valueOf(1.0f))};
            com.google.android.libraries.navigation.internal.mx.m[] mVarArr3 = {com.google.android.libraries.navigation.internal.ms.ah.J(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.d.x)), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-1), com.google.android.libraries.navigation.internal.ms.ah.r(ddVar)};
            dd ddVarA = da.a(xVar);
            dd ddVar3 = new dd() { // from class: com.google.android.libraries.navigation.internal.ur.az
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) csVar).h();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            };
            dd ddVar4 = new dd() { // from class: com.google.android.libraries.navigation.internal.ur.ba
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    ((com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) csVar).q();
                    return null;
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            };
            com.google.android.libraries.navigation.internal.mx.m[] mVarArr4 = {com.google.android.libraries.navigation.internal.ms.ah.J(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.d.y)), com.google.android.libraries.navigation.internal.ms.ah.l(fValueOf)};
            com.google.android.libraries.navigation.internal.mx.e eVar = new com.google.android.libraries.navigation.internal.mx.e(TextView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ac(bz.o()), com.google.android.libraries.navigation.internal.w.e.a(), com.google.android.libraries.navigation.internal.w.e.d(), com.google.android.libraries.navigation.internal.ms.ah.aT(com.google.android.libraries.navigation.internal.nc.a.g(18)), com.google.android.libraries.navigation.internal.ms.ah.M(false), com.google.android.libraries.navigation.internal.ms.ah.aQ(ddVarA), com.google.android.libraries.navigation.internal.ms.ah.aM(ddVar3));
            com.google.android.libraries.navigation.internal.mx.e eVar2 = new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, ch.c(com.google.android.libraries.navigation.internal.ms.e.LAYOUT_WIDTH, new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.ur.ag
                @Override // com.google.android.libraries.navigation.internal.ms.by
                public final Object a(cs csVar, Context context) {
                    com.google.android.libraries.navigation.internal.ut.d.b bVar = (com.google.android.libraries.navigation.internal.ut.d.b) csVar;
                    int i = -1;
                    if (com.google.android.libraries.navigation.internal.ms.aq.b(context) && !bVar.l().booleanValue()) {
                        i = -2;
                    }
                    return Integer.valueOf(i);
                }
            }), com.google.android.libraries.navigation.internal.ms.ah.T(-1), ch.a(at.h(), new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.ay(com.google.android.libraries.navigation.internal.nc.a.g(8)), com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.nc.a.g(8))}), new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.ay(com.google.android.libraries.navigation.internal.nc.a.g(2)), com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.nc.a.g(2))})), new com.google.android.libraries.navigation.internal.mx.aa(at.b), new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, com.google.android.libraries.navigation.internal.ms.ah.ac(new com.google.android.libraries.navigation.internal.ms.ak(0, eVar.d()), bz.d(eVar.d())), com.google.android.libraries.navigation.internal.ms.ah.af(at.f), com.google.android.libraries.navigation.internal.ms.ah.S(at.f), com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.nc.a.g(8)), com.google.android.libraries.navigation.internal.ms.ah.aY(ddVarA), com.google.android.libraries.navigation.internal.ms.ah.aI(new ar())), eVar, new com.google.android.libraries.navigation.internal.mx.e(TextView.class, com.google.android.libraries.navigation.internal.ms.bk.a(new cg(ddVar4), new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ac(bz.n(eVar), bz.o()), com.google.android.libraries.navigation.internal.w.e.a(), com.google.android.libraries.navigation.internal.w.e.d(), com.google.android.libraries.navigation.internal.ms.ah.aT(com.google.android.libraries.navigation.internal.nc.a.g(18)), com.google.android.libraries.navigation.internal.ms.ah.M(false), com.google.android.libraries.navigation.internal.ms.ah.aQ(ddVarA), com.google.android.libraries.navigation.internal.ms.ah.aM(ddVar4)));
            eVar2.e(mVarArr4);
            com.google.android.libraries.navigation.internal.mx.m[] mVarArr5 = {com.google.android.libraries.navigation.internal.ms.ah.v(false), com.google.android.libraries.navigation.internal.ms.ah.H(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.ay
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) csVar).m();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-1), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, mVarArr3), eVar2};
            com.google.android.libraries.navigation.internal.mx.e eVar3 = new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-1), com.google.android.libraries.navigation.internal.ms.ah.an(new com.google.android.libraries.navigation.internal.ms.o(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.bb
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) csVar).c();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            })), com.google.android.libraries.navigation.internal.ad.a.b(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.bc
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) csVar).d();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), ch.d(com.google.android.libraries.navigation.internal.ad.b.LOGGED_IMPRESSION_SINK, new dd() { // from class: com.google.android.libraries.navigation.internal.ur.bd
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) csVar).e();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }));
            eVar3.e(mVarArr);
            return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.v(false), com.google.android.libraries.navigation.internal.ms.ah.x(false), com.google.android.libraries.navigation.internal.ms.ah.S(at.g), ch.a(ddVar2, kVar, new com.google.android.libraries.navigation.internal.mx.k(mVarArr2)), com.google.android.libraries.navigation.internal.ms.ah.ax(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.ax
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((Boolean) at.c.a.a((com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) csVar)).booleanValue() ? com.google.android.libraries.navigation.internal.nc.a.g(0) : com.google.android.libraries.navigation.internal.w.c.d();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.w.c.d()), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, mVarArr5), eVar3);
        }
    }

    /* JADX INFO: compiled from: PG */
    final class d extends at<com.google.android.libraries.navigation.internal.ut.d.b> implements com.google.android.libraries.navigation.internal.yt.e {
        private static final com.google.android.libraries.navigation.internal.xn.a a = com.google.android.libraries.navigation.internal.xn.a.d("DefaultPromptButtonWithoutTimeoutLayout");

        @Override // com.google.android.libraries.navigation.internal.ms.bt
        protected final com.google.android.libraries.navigation.internal.mx.g a() {
            return k(new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ae(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.as
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return Integer.valueOf(true != ((Boolean) at.h().a((com.google.android.libraries.navigation.internal.ut.d.b) csVar)).booleanValue() ? -1 : -2);
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), com.google.android.libraries.navigation.internal.ms.ah.T(-1), com.google.android.libraries.navigation.internal.ms.ah.o(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.af
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    com.google.android.libraries.navigation.internal.nc.x xVarB;
                    com.google.android.libraries.navigation.internal.nc.x xVarB2;
                    com.google.android.libraries.navigation.internal.ut.d.b bVar = (com.google.android.libraries.navigation.internal.ut.d.b) csVar;
                    cc ccVar = at.b;
                    if (bVar.k() == null) {
                        xVarB = com.google.android.libraries.navigation.internal.nc.ae.e();
                        xVarB2 = com.google.android.libraries.navigation.internal.nc.ae.e();
                    } else if (bVar.k() == com.google.android.libraries.navigation.internal.ut.d.b.a.EXIT_NAV_AND_ETA_SHARING) {
                        xVarB = com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.p(), com.google.android.libraries.navigation.internal.w.a.o());
                        xVarB2 = com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.p(), com.google.android.libraries.navigation.internal.w.a.o());
                    } else {
                        xVarB = com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.r(), com.google.android.libraries.navigation.internal.w.a.b());
                        xVarB2 = com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.nc.j.f(com.google.android.libraries.navigation.internal.v.a.o), com.google.android.libraries.navigation.internal.w.a.f());
                    }
                    return com.google.android.libraries.navigation.internal.ae.b.c(xVarB, xVarB2, com.google.android.libraries.navigation.internal.nc.a.g(1), com.google.android.libraries.navigation.internal.nc.a.g(32));
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), at.j(null, new aq(), new com.google.android.libraries.navigation.internal.mx.m[0])), com.google.android.libraries.navigation.internal.ms.ah.p(com.google.android.libraries.navigation.internal.w.d.b()), new com.google.android.libraries.navigation.internal.mx.aa(at.c));
        }

        @Override // com.google.android.libraries.navigation.internal.ur.at, com.google.android.libraries.navigation.internal.yt.e
        public final com.google.android.libraries.navigation.internal.xn.a b() {
            return a;
        }
    }

    /* JADX INFO: compiled from: PG */
    final class e extends com.google.android.libraries.navigation.internal.ms.bt<com.google.android.libraries.navigation.internal.ut.d> implements com.google.android.libraries.navigation.internal.yt.e {
        public static final /* synthetic */ int a = 0;
        private static final com.google.android.libraries.navigation.internal.xn.a b = com.google.android.libraries.navigation.internal.xn.a.d("EmptySpacingButtonLayout");

        @Override // com.google.android.libraries.navigation.internal.ms.bt
        protected final com.google.android.libraries.navigation.internal.mx.g a() {
            return new com.google.android.libraries.navigation.internal.mx.e(View.class, com.google.android.libraries.navigation.internal.ms.ah.af(com.google.android.libraries.navigation.internal.nc.a.g(0)), com.google.android.libraries.navigation.internal.ms.ah.S(com.google.android.libraries.navigation.internal.nc.a.g(0)), com.google.android.libraries.navigation.internal.ms.ah.ad(Float.valueOf(1.0f)), com.google.android.libraries.navigation.internal.ms.ah.G(da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.ur.bf
                @Override // com.google.android.libraries.navigation.internal.ms.by
                public final Object a(cs csVar, Context context) {
                    com.google.android.libraries.navigation.internal.ut.d dVar = (com.google.android.libraries.navigation.internal.ut.d) csVar;
                    int i = at.e.a;
                    boolean z = false;
                    if (com.google.android.libraries.navigation.internal.ms.aq.b(context) && !dVar.u().booleanValue()) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            })));
        }

        @Override // com.google.android.libraries.navigation.internal.yt.e
        public final com.google.android.libraries.navigation.internal.xn.a b() {
            return b;
        }
    }

    /* JADX INFO: compiled from: PG */
    final class f extends c implements com.google.android.libraries.navigation.internal.yt.e {
        private static final com.google.android.libraries.navigation.internal.xn.a h = com.google.android.libraries.navigation.internal.xn.a.d("NavigationPromptButtonWithTimeoutLayout");

        @Override // com.google.android.libraries.navigation.internal.ur.at.c, com.google.android.libraries.navigation.internal.ms.bt
        protected final com.google.android.libraries.navigation.internal.mx.g a() {
            com.google.android.libraries.navigation.internal.af.a aVarB = com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.c(), com.google.android.libraries.navigation.internal.w.a.d());
            com.google.android.libraries.navigation.internal.af.a aVarB2 = com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.d(), com.google.android.libraries.navigation.internal.w.a.c());
            return c(new b(aVarB, aVarB2), com.google.android.libraries.navigation.internal.w.a.r(), aVarB, da.a(aVarB2));
        }

        @Override // com.google.android.libraries.navigation.internal.ur.at.c, com.google.android.libraries.navigation.internal.ur.at, com.google.android.libraries.navigation.internal.yt.e
        public final com.google.android.libraries.navigation.internal.xn.a b() {
            return h;
        }
    }

    public static dd h() {
        return da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.ur.ah
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.ut.d.b bVar = (com.google.android.libraries.navigation.internal.ut.d.b) csVar;
                cc ccVar = at.b;
                boolean z = false;
                if (com.google.android.libraries.navigation.internal.ms.aq.b(context) && !bVar.l().booleanValue()) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    public static final com.google.android.libraries.navigation.internal.mx.g j(com.google.android.libraries.navigation.internal.nc.x xVar, dd ddVar, com.google.android.libraries.navigation.internal.mx.m... mVarArr) {
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr2 = new com.google.android.libraries.navigation.internal.mx.m[7];
        mVarArr2[0] = com.google.android.libraries.navigation.internal.ms.ah.ae(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.ai
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return Integer.valueOf(true != ((Boolean) at.h().a((com.google.android.libraries.navigation.internal.ut.d.b) csVar)).booleanValue() ? -1 : -2);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        });
        mVarArr2[1] = com.google.android.libraries.navigation.internal.ms.ah.T(-1);
        mVarArr2[2] = ch.a(h(), new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.ay(com.google.android.libraries.navigation.internal.nc.a.g(8)), com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.nc.a.g(8))}), new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.ay(com.google.android.libraries.navigation.internal.nc.a.g(6)), com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.nc.a.g(6))}));
        mVarArr2[3] = com.google.android.libraries.navigation.internal.ms.ah.I(17);
        mVarArr2[4] = new com.google.android.libraries.navigation.internal.mx.aa(b);
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr3 = new com.google.android.libraries.navigation.internal.mx.m[7];
        mVarArr3[0] = com.google.android.libraries.navigation.internal.ms.bk.a(new cg(new ar()), new com.google.android.libraries.navigation.internal.mx.m[0]);
        com.google.android.libraries.navigation.internal.nc.a aVar = f;
        mVarArr3[1] = com.google.android.libraries.navigation.internal.ms.ah.af(aVar);
        mVarArr3[2] = com.google.android.libraries.navigation.internal.ms.ah.S(aVar);
        mVarArr3[3] = com.google.android.libraries.navigation.internal.ms.ah.ay(com.google.android.libraries.navigation.internal.nc.a.g(4));
        mVarArr3[4] = com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.nc.a.g(8));
        mVarArr3[5] = xVar == null ? com.google.android.libraries.navigation.internal.ms.ah.aY(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.aj
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.ut.d.b bVar = (com.google.android.libraries.navigation.internal.ut.d.b) csVar;
                cc ccVar = at.b;
                if (bVar.k() == null) {
                    return com.google.android.libraries.navigation.internal.nc.ae.e();
                }
                if (bVar.k() == com.google.android.libraries.navigation.internal.ut.d.b.a.EXIT) {
                    return com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.p(), com.google.android.libraries.navigation.internal.w.a.o());
                }
                return bVar.k() == com.google.android.libraries.navigation.internal.ut.d.b.a.EXIT_NAV_AND_ETA_SHARING ? com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.r(), com.google.android.libraries.navigation.internal.w.a.b()) : com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.b(), com.google.android.libraries.navigation.internal.w.a.r());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }) : com.google.android.libraries.navigation.internal.ms.ah.aZ(xVar);
        mVarArr3[6] = com.google.android.libraries.navigation.internal.ms.ah.aI(new ar());
        mVarArr2[5] = new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, mVarArr3);
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr4 = new com.google.android.libraries.navigation.internal.mx.m[10];
        mVarArr4[0] = com.google.android.libraries.navigation.internal.ms.ah.ag(-2);
        mVarArr4[1] = com.google.android.libraries.navigation.internal.ms.ah.T(-2);
        mVarArr4[2] = ch.e(com.google.android.libraries.navigation.internal.ms.e.MAX_WIDTH, com.google.android.libraries.navigation.internal.nc.p.b(new com.google.android.libraries.navigation.internal.nc.ab(), Float.valueOf(0.33f)));
        mVarArr4[3] = com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.nc.a.g(4));
        mVarArr4[4] = com.google.android.libraries.navigation.internal.w.e.a();
        mVarArr4[5] = com.google.android.libraries.navigation.internal.w.e.d();
        mVarArr4[6] = com.google.android.libraries.navigation.internal.ms.ah.aT(com.google.android.libraries.navigation.internal.nc.a.g(18));
        mVarArr4[7] = com.google.android.libraries.navigation.internal.ms.ah.M(false);
        mVarArr4[8] = xVar == null ? com.google.android.libraries.navigation.internal.ms.ah.aQ(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.aj
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.ut.d.b bVar = (com.google.android.libraries.navigation.internal.ut.d.b) csVar;
                cc ccVar = at.b;
                if (bVar.k() == null) {
                    return com.google.android.libraries.navigation.internal.nc.ae.e();
                }
                if (bVar.k() == com.google.android.libraries.navigation.internal.ut.d.b.a.EXIT) {
                    return com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.p(), com.google.android.libraries.navigation.internal.w.a.o());
                }
                return bVar.k() == com.google.android.libraries.navigation.internal.ut.d.b.a.EXIT_NAV_AND_ETA_SHARING ? com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.r(), com.google.android.libraries.navigation.internal.w.a.b()) : com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.b(), com.google.android.libraries.navigation.internal.w.a.r());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }) : com.google.android.libraries.navigation.internal.ms.ah.aR(xVar);
        mVarArr4[9] = com.google.android.libraries.navigation.internal.ms.ah.aM(ddVar);
        mVarArr2[6] = new com.google.android.libraries.navigation.internal.mx.e(TextView.class, mVarArr4);
        com.google.android.libraries.navigation.internal.mx.e eVar = new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, mVarArr2);
        eVar.e(mVarArr);
        return eVar;
    }

    static final com.google.android.libraries.navigation.internal.mx.g k(com.google.android.libraries.navigation.internal.mx.m... mVarArr) {
        dd ddVarH = h();
        com.google.android.libraries.navigation.internal.mx.k kVar = new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.ad(Float.valueOf(0.0f))});
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr2 = {com.google.android.libraries.navigation.internal.ms.ah.ag(0), com.google.android.libraries.navigation.internal.ms.ah.ad(Float.valueOf(1.0f))};
        com.google.android.libraries.navigation.internal.mx.e eVar = new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-1), com.google.android.libraries.navigation.internal.ms.ah.an(new com.google.android.libraries.navigation.internal.ms.o(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.ak
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d.b) csVar).c();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), com.google.android.libraries.navigation.internal.ad.a.b(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.al
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d.b) csVar).d();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }));
        eVar.e(mVarArr);
        return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.S(g), ch.a(ddVarH, kVar, new com.google.android.libraries.navigation.internal.mx.k(mVarArr2)), com.google.android.libraries.navigation.internal.ms.ah.ax(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.ae
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((Boolean) at.h().a((com.google.android.libraries.navigation.internal.ut.d.b) csVar)).booleanValue() ? com.google.android.libraries.navigation.internal.nc.a.g(0) : com.google.android.libraries.navigation.internal.w.c.d();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.w.c.d()), eVar);
    }

    public com.google.android.libraries.navigation.internal.xn.a b() {
        throw null;
    }

    final com.google.android.libraries.navigation.internal.mx.g i(com.google.android.libraries.navigation.internal.nc.x xVar, com.google.android.libraries.navigation.internal.nc.x xVar2, Optional optional) {
        com.google.android.libraries.navigation.internal.mx.m mVarC;
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr = new com.google.android.libraries.navigation.internal.mx.m[6];
        mVarArr[0] = com.google.android.libraries.navigation.internal.ms.ah.ae(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.am
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return Integer.valueOf(true != ((Boolean) at.h().a((com.google.android.libraries.navigation.internal.ut.d.b) csVar)).booleanValue() ? -1 : -2);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        });
        mVarArr[1] = com.google.android.libraries.navigation.internal.ms.ah.T(-1);
        mVarArr[2] = com.google.android.libraries.navigation.internal.mz.g.b(d);
        mVarArr[3] = ch.d(com.google.android.libraries.navigation.internal.mz.b.CARD_ELEVATION, new dd() { // from class: com.google.android.libraries.navigation.internal.ur.an
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                cc ccVar = at.b;
                return com.google.android.libraries.navigation.internal.nc.a.g(((com.google.android.libraries.navigation.internal.ut.d.b) csVar).m().booleanValue() ? 0 : 2);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        });
        mVarArr[4] = com.google.android.libraries.navigation.internal.mz.g.a(xVar);
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr2 = new com.google.android.libraries.navigation.internal.mx.m[4];
        mVarArr2[0] = com.google.android.libraries.navigation.internal.ms.ah.ae(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.ao
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return Integer.valueOf(true != ((Boolean) at.h().a((com.google.android.libraries.navigation.internal.ut.d.b) csVar)).booleanValue() ? -1 : -2);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        });
        mVarArr2[1] = com.google.android.libraries.navigation.internal.ms.ah.T(-1);
        if (optional.isPresent()) {
            mVarC = com.google.android.libraries.navigation.internal.ms.ah.c((com.google.android.libraries.navigation.internal.ms.bt) optional.get(), new dd() { // from class: com.google.android.libraries.navigation.internal.ur.ap
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    cc ccVar = at.b;
                    return ((com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) ((com.google.android.libraries.navigation.internal.ut.d.b) csVar)).b();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }, new com.google.android.libraries.navigation.internal.mx.m[0]);
        } else {
            mVarC = com.google.android.libraries.navigation.internal.mx.m.e;
        }
        mVarArr2[2] = mVarC;
        mVarArr2[3] = j(xVar2, new aq(), new com.google.android.libraries.navigation.internal.mx.m[0]);
        mVarArr[5] = new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, mVarArr2);
        return new com.google.android.libraries.navigation.internal.mx.e(CardView.class, mVarArr);
    }
}
