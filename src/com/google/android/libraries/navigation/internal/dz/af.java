package com.google.android.libraries.navigation.internal.dz;

import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.bz;
import com.google.android.libraries.navigation.internal.ms.cc;
import com.google.android.libraries.navigation.internal.ms.ch;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.dd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class af extends bt<com.google.android.libraries.navigation.internal.vj.a> implements com.google.android.libraries.navigation.internal.yt.e {
    public static final com.google.android.libraries.navigation.internal.nc.x a = com.google.android.libraries.navigation.internal.nc.ae.d(1797875);
    private static final com.google.android.libraries.navigation.internal.nc.x f = com.google.android.libraries.navigation.internal.nc.ae.d(16777215);
    private static final com.google.android.libraries.navigation.internal.nc.x g = com.google.android.libraries.navigation.internal.nc.ae.d(15528958);
    private static final com.google.android.libraries.navigation.internal.nc.x h = com.google.android.libraries.navigation.internal.nc.ae.d(743376);
    public static final com.google.android.libraries.navigation.internal.nc.x b = com.google.android.libraries.navigation.internal.nc.ae.d(2039583);
    public static final com.google.android.libraries.navigation.internal.zb.j c = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.dz.af");
    private static final com.google.android.libraries.navigation.internal.xn.a i = com.google.android.libraries.navigation.internal.xn.a.d("ReportIncidentPromptConfirmationLayoutV2");
    private static final com.google.android.libraries.navigation.internal.nc.ap j = com.google.android.libraries.navigation.internal.nc.z.b(20.0d);
    private static final com.google.android.libraries.navigation.internal.nc.ap k = com.google.android.libraries.navigation.internal.nc.a.g(32);
    private static final View.AccessibilityDelegate l = new ab();
    public static final com.google.android.libraries.navigation.internal.nc.ap d = com.google.android.libraries.navigation.internal.nc.a.g(28);

    /* JADX INFO: compiled from: PG */
    final class a extends bt<com.google.android.libraries.navigation.internal.ah.a> implements com.google.android.libraries.navigation.internal.yt.e {
        public static final /* synthetic */ int a = 0;
        private static final com.google.android.libraries.navigation.internal.xn.a b = com.google.android.libraries.navigation.internal.xn.a.d("ProgressBarLayout");

        @Override // com.google.android.libraries.navigation.internal.ms.bt
        protected final com.google.android.libraries.navigation.internal.mx.g a() {
            return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-1), com.google.android.libraries.navigation.internal.ms.ah.p(com.google.android.libraries.navigation.internal.ae.b.b(af.a, af.d)), new com.google.android.libraries.navigation.internal.mx.e(ProgressBar.class, new com.google.android.libraries.navigation.internal.mx.o(com.google.android.libraries.navigation.internal.f.i.b), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-1), com.google.android.libraries.navigation.internal.ms.ah.aC(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.ac
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    int i = af.a.a;
                    return new com.google.android.libraries.navigation.internal.nc.ba(com.google.android.libraries.navigation.internal.nc.ae.e(), af.b, af.d);
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), com.google.android.libraries.navigation.internal.ms.ah.l(Float.valueOf(0.16f)), com.google.android.libraries.navigation.internal.ms.ah.aB(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.ad
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ah.a) csVar).b();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), com.google.android.libraries.navigation.internal.ms.ah.ai(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.ae
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

    private static com.google.android.libraries.navigation.internal.mx.g c(com.google.android.libraries.navigation.internal.mx.m... mVarArr) {
        com.google.android.libraries.navigation.internal.mx.e eVar = new com.google.android.libraries.navigation.internal.mx.e(TextView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.Z(com.google.android.libraries.navigation.internal.w.c.k()), com.google.android.libraries.navigation.internal.ms.ah.X(com.google.android.libraries.navigation.internal.w.c.k()), ch.e(com.google.android.libraries.navigation.internal.ms.e.TEXT_APPEARANCE, new com.google.android.libraries.navigation.internal.ms.b(com.google.android.libraries.navigation.internal.f.a.b)), com.google.android.libraries.navigation.internal.w.e.j());
        eVar.e(mVarArr);
        return eVar;
    }

    private static com.google.android.libraries.navigation.internal.mx.k h(dd ddVar) {
        com.google.android.libraries.navigation.internal.ms.ag agVarA = com.google.android.libraries.navigation.internal.ab.d.a();
        agVarA.a = Float.valueOf(1.0f);
        agVarA.b(300);
        agVarA.g = new com.google.android.libraries.navigation.internal.ms.af() { // from class: com.google.android.libraries.navigation.internal.dz.o
            @Override // com.google.android.libraries.navigation.internal.ms.af
            public final void a(View view, cs csVar) {
                com.google.android.libraries.navigation.internal.nc.x xVar = af.a;
                view.sendAccessibilityEvent(8);
                ((com.google.android.libraries.navigation.internal.vj.a) csVar).e();
            }
        };
        com.google.android.libraries.navigation.internal.mx.w wVarA = agVarA.a();
        com.google.android.libraries.navigation.internal.ms.ag agVarA2 = com.google.android.libraries.navigation.internal.ab.d.a();
        agVarA2.a = Float.valueOf(0.0f);
        agVarA2.b(0);
        return new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.l(0), new com.google.android.libraries.navigation.internal.mx.r(ddVar, wVarA, agVarA2.a())});
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected final com.google.android.libraries.navigation.internal.mx.g a() {
        com.google.android.libraries.navigation.internal.nc.ap apVar = j;
        com.google.android.libraries.navigation.internal.nc.ap apVar2 = k;
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr = {com.google.android.libraries.navigation.internal.ms.ah.aq(0), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.I(16), com.google.android.libraries.navigation.internal.ms.ah.V(com.google.android.libraries.navigation.internal.nc.a.g(12)), new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, com.google.android.libraries.navigation.internal.ms.ah.af(apVar2), com.google.android.libraries.navigation.internal.ms.ah.S(apVar2), com.google.android.libraries.navigation.internal.ms.ah.Q(1), com.google.android.libraries.navigation.internal.ms.ah.aI(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.x
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.a) csVar).j();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), c(com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.y
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.a) csVar).i();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }))};
        Float fValueOf = Float.valueOf(1.0f);
        com.google.android.libraries.navigation.internal.nc.x xVar = g;
        com.google.android.libraries.navigation.internal.nc.ap apVar3 = d;
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr2 = {com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ak(com.google.android.libraries.navigation.internal.w.c.b()), com.google.android.libraries.navigation.internal.ms.ah.I(17), com.google.android.libraries.navigation.internal.ms.ah.Q(16), com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.nc.a.g(4)), com.google.android.libraries.navigation.internal.w.e.a(), com.google.android.libraries.navigation.internal.w.e.d(), com.google.android.libraries.navigation.internal.ms.ah.aT(com.google.android.libraries.navigation.internal.nc.a.g(18)), com.google.android.libraries.navigation.internal.ms.ah.M(false), com.google.android.libraries.navigation.internal.ms.ah.aR(h), com.google.android.libraries.navigation.internal.ms.ah.aN(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.be))};
        View.AccessibilityDelegate accessibilityDelegate = l;
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr3 = {com.google.android.libraries.navigation.internal.ms.bk.b(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.s
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.a) csVar).k();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.aq(1), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.I(17), com.google.android.libraries.navigation.internal.ms.ah.ar(apVar, apVar, apVar, apVar), com.google.android.libraries.navigation.internal.ms.ah.E(true), com.google.android.libraries.navigation.internal.ms.ah.v(false), h(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.s
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.a) csVar).k();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, mVarArr), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.aq(0), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.af(com.google.android.libraries.navigation.internal.nc.a.g(0)), com.google.android.libraries.navigation.internal.ms.ah.S(com.google.android.libraries.navigation.internal.nc.a.g(56)), com.google.android.libraries.navigation.internal.ms.ah.ad(fValueOf), com.google.android.libraries.navigation.internal.ms.ah.X(com.google.android.libraries.navigation.internal.nc.a.g(6)), com.google.android.libraries.navigation.internal.ms.ah.p(com.google.android.libraries.navigation.internal.ae.b.b(xVar, apVar3)), com.google.android.libraries.navigation.internal.ms.ah.F(com.google.android.libraries.navigation.internal.w.d.a(apVar3)), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, mVarArr2), com.google.android.libraries.navigation.internal.ad.a.b(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.z
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.a) csVar).c();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.h(accessibilityDelegate), com.google.android.libraries.navigation.internal.ms.ah.A(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.be)), com.google.android.libraries.navigation.internal.ms.ah.an(new com.google.android.libraries.navigation.internal.ms.o(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.aa
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.a) csVar).f();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }))), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.af(com.google.android.libraries.navigation.internal.nc.a.g(0)), com.google.android.libraries.navigation.internal.ms.ah.S(com.google.android.libraries.navigation.internal.nc.a.g(56)), com.google.android.libraries.navigation.internal.ms.ah.ad(fValueOf), com.google.android.libraries.navigation.internal.ms.ah.Z(com.google.android.libraries.navigation.internal.nc.a.g(6)), com.google.android.libraries.navigation.internal.ms.ah.F(com.google.android.libraries.navigation.internal.w.d.a(apVar3)), com.google.android.libraries.navigation.internal.ms.ah.c(new a(), new dd() { // from class: com.google.android.libraries.navigation.internal.dz.p
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.a) csVar).a();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ak(com.google.android.libraries.navigation.internal.w.c.b()), com.google.android.libraries.navigation.internal.ms.ah.I(17), com.google.android.libraries.navigation.internal.ms.ah.Q(16), com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.nc.a.g(4)), com.google.android.libraries.navigation.internal.w.e.a(), com.google.android.libraries.navigation.internal.w.e.d(), com.google.android.libraries.navigation.internal.ms.ah.aT(com.google.android.libraries.navigation.internal.nc.a.g(18)), com.google.android.libraries.navigation.internal.ms.ah.M(false), com.google.android.libraries.navigation.internal.ms.ah.aR(f), com.google.android.libraries.navigation.internal.ms.ah.aN(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.P))), com.google.android.libraries.navigation.internal.ad.a.b(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.q
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.a) csVar).b();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.h(accessibilityDelegate), com.google.android.libraries.navigation.internal.ms.ah.A(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.P)), com.google.android.libraries.navigation.internal.ms.ah.an(new com.google.android.libraries.navigation.internal.ms.o(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.r
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.a) csVar).d();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }))))};
        cc ccVar = new cc();
        cc ccVar2 = new cc();
        cc ccVar3 = new cc();
        bz[] bzVarArr = {new com.google.android.libraries.navigation.internal.ms.ak(6, ccVar2), bz.d(ccVar2)};
        com.google.android.libraries.navigation.internal.nc.a aVarG = com.google.android.libraries.navigation.internal.nc.a.g(8);
        dd ddVar = new dd() { // from class: com.google.android.libraries.navigation.internal.dz.u
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.nc.x xVar2 = af.a;
                return Boolean.valueOf(!((com.google.android.libraries.navigation.internal.vj.a) csVar).k().booleanValue());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        com.google.android.libraries.navigation.internal.ms.af afVar = new com.google.android.libraries.navigation.internal.ms.af() { // from class: com.google.android.libraries.navigation.internal.dz.v
            @Override // com.google.android.libraries.navigation.internal.ms.af
            public final void a(View view, cs csVar) {
                com.google.android.libraries.navigation.internal.nc.x xVar2 = af.a;
                AnimatedVectorDrawableCompat animatedVectorDrawableCompatCreate = AnimatedVectorDrawableCompat.create(view.getContext(), com.google.android.libraries.navigation.internal.dw.c.a);
                if (animatedVectorDrawableCompatCreate == null) {
                    ((com.google.android.libraries.navigation.internal.zb.h) af.c.d(com.google.android.libraries.navigation.internal.nl.a.a).F(426)).p("Animated drawable not found. Cannot perform animation.");
                } else {
                    ((ImageView) view).setImageDrawable(animatedVectorDrawableCompatCreate);
                    animatedVectorDrawableCompatCreate.start();
                }
            }
        };
        Float fValueOf2 = Float.valueOf(0.0f);
        com.google.android.libraries.navigation.internal.ms.ag agVar = new com.google.android.libraries.navigation.internal.ms.ag();
        agVar.e = fValueOf;
        agVar.f = fValueOf;
        agVar.c(400L);
        agVar.b(300);
        agVar.b = new OvershootInterpolator();
        agVar.g = afVar;
        com.google.android.libraries.navigation.internal.mx.w wVarA = agVar.a();
        com.google.android.libraries.navigation.internal.ms.ag agVarA = com.google.android.libraries.navigation.internal.ab.d.a();
        agVarA.e = fValueOf2;
        agVarA.f = fValueOf2;
        agVarA.b(0);
        return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ad.a.a(com.google.android.libraries.navigation.internal.jy.aa.k(com.google.android.libraries.navigation.internal.afe.i.i)), com.google.android.libraries.navigation.internal.ms.ah.m(true), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, mVarArr3), new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, com.google.android.libraries.navigation.internal.ms.bk.a(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.s
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.a) csVar).k();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ar(apVar, apVar, apVar, apVar), com.google.android.libraries.navigation.internal.ms.ah.E(true), com.google.android.libraries.navigation.internal.ms.ah.v(false), com.google.android.libraries.navigation.internal.ms.ah.x(false), h(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.t
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.nc.x xVar2 = af.a;
                return Boolean.valueOf(!((com.google.android.libraries.navigation.internal.vj.a) csVar).k().booleanValue());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, new com.google.android.libraries.navigation.internal.mx.aa(ccVar), com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ac(bzVarArr), new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, com.google.android.libraries.navigation.internal.ms.ah.S(apVar2), com.google.android.libraries.navigation.internal.ms.ah.af(apVar2), com.google.android.libraries.navigation.internal.ms.ah.Q(16), com.google.android.libraries.navigation.internal.ms.ah.ar(aVarG, aVarG, aVarG, aVarG), new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.aE(fValueOf2), com.google.android.libraries.navigation.internal.ms.ah.aF(fValueOf2), new com.google.android.libraries.navigation.internal.mx.r(ddVar, wVarA, agVarA.a())}), com.google.android.libraries.navigation.internal.ms.ah.p(com.google.android.libraries.navigation.internal.nc.aj.a(com.google.android.libraries.navigation.internal.w.a.c())))), c(new com.google.android.libraries.navigation.internal.mx.aa(ccVar2), com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.w
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.a) csVar).h();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.ac(bz.r(ccVar))), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, new com.google.android.libraries.navigation.internal.mx.aa(ccVar3), com.google.android.libraries.navigation.internal.ms.ah.ac(bz.r(ccVar), bz.m(ccVar2)), com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.e(com.google.android.libraries.navigation.internal.w.c.k()), com.google.android.libraries.navigation.internal.w.e.b(), com.google.android.libraries.navigation.internal.w.e.i(), com.google.android.libraries.navigation.internal.ms.ah.aN(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.bc)))));
    }

    @Override // com.google.android.libraries.navigation.internal.yt.e
    public final com.google.android.libraries.navigation.internal.xn.a b() {
        return i;
    }
}
