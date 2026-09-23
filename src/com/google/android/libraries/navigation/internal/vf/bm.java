package com.google.android.libraries.navigation.internal.vf;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.libraries.navigation.internal.ms.bs;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.by;
import com.google.android.libraries.navigation.internal.ms.bz;
import com.google.android.libraries.navigation.internal.ms.cc;
import com.google.android.libraries.navigation.internal.ms.cg;
import com.google.android.libraries.navigation.internal.ms.ch;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.da;
import com.google.android.libraries.navigation.internal.ms.dd;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.no;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bm extends bt<com.google.android.libraries.navigation.internal.vj.d> implements com.google.android.libraries.navigation.internal.yt.e {
    public final cc b = new cc();
    private final cc h = new cc();
    private final cc i = new cc();
    private final cc j = new cc();
    private static final com.google.android.libraries.navigation.internal.xn.a c = com.google.android.libraries.navigation.internal.xn.a.d("VotableTrafficIncidentPromptLayout");
    private static final com.google.android.libraries.navigation.internal.nc.a d = com.google.android.libraries.navigation.internal.nc.a.g(36);
    private static final com.google.android.libraries.navigation.internal.nc.a f = com.google.android.libraries.navigation.internal.nc.a.g(12);
    private static final com.google.android.libraries.navigation.internal.nc.a g = com.google.android.libraries.navigation.internal.nc.a.g(12);
    public static final dd a = da.b(new by() { // from class: com.google.android.libraries.navigation.internal.vf.bb
        @Override // com.google.android.libraries.navigation.internal.ms.by
        public final Object a(cs csVar, Context context) {
            com.google.android.libraries.navigation.internal.vj.d dVar = (com.google.android.libraries.navigation.internal.vj.d) csVar;
            dd ddVar = bm.a;
            boolean z = false;
            if (com.google.android.libraries.navigation.internal.ms.aq.b(context) && dVar.u().booleanValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    });

    /* JADX INFO: compiled from: PG */
    final class a extends bt<com.google.android.libraries.navigation.internal.ah.a> implements com.google.android.libraries.navigation.internal.yt.e {
        private static final com.google.android.libraries.navigation.internal.xn.a a = com.google.android.libraries.navigation.internal.xn.a.d("CircularProgressBarLayout");

        @Override // com.google.android.libraries.navigation.internal.ms.bt
        protected final com.google.android.libraries.navigation.internal.mx.g a() {
            com.google.android.libraries.navigation.internal.mx.e eVar = new com.google.android.libraries.navigation.internal.mx.e(ProgressBar.class, new com.google.android.libraries.navigation.internal.mx.o(com.google.android.libraries.navigation.internal.f.i.b), ch.e(com.google.android.libraries.navigation.internal.ms.e.PROGRESS_DRAWABLE, new com.google.android.libraries.navigation.internal.ur.n.a(com.google.android.libraries.navigation.internal.nc.j.h(com.google.android.libraries.navigation.internal.f.d.h, com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.n(), com.google.android.libraries.navigation.internal.w.a.h())), com.google.android.libraries.navigation.internal.nc.a.g(6), com.google.android.libraries.navigation.internal.nc.a.g(2), com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.k(), com.google.android.libraries.navigation.internal.w.a.h()))), com.google.android.libraries.navigation.internal.ms.ah.aB(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.bk
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ah.a) csVar).b();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), com.google.android.libraries.navigation.internal.ms.ah.ai(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.bl
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ah.a) csVar).a();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }));
            eVar.e(com.google.android.libraries.navigation.internal.ms.ah.as(0, 0, 0, 0));
            return eVar;
        }

        @Override // com.google.android.libraries.navigation.internal.yt.e
        public final com.google.android.libraries.navigation.internal.xn.a b() {
            return a;
        }
    }

    /* JADX INFO: compiled from: PG */
    final class b extends bt<com.google.android.libraries.navigation.internal.ut.d.b> implements com.google.android.libraries.navigation.internal.yt.e {
        private static final com.google.android.libraries.navigation.internal.xn.a a = com.google.android.libraries.navigation.internal.xn.a.d("DismissButtonLayout");

        @Override // com.google.android.libraries.navigation.internal.ms.bt
        protected final com.google.android.libraries.navigation.internal.mx.g a() {
            return new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, bm.c(), com.google.android.libraries.navigation.internal.ms.ah.aZ(com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.n(), com.google.android.libraries.navigation.internal.w.a.h())), com.google.android.libraries.navigation.internal.ms.ah.aD(ImageView.ScaleType.CENTER), com.google.android.libraries.navigation.internal.ms.ah.aK(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.c.y)));
        }

        @Override // com.google.android.libraries.navigation.internal.yt.e
        public final com.google.android.libraries.navigation.internal.xn.a b() {
            return a;
        }
    }

    /* JADX INFO: compiled from: PG */
    final class c extends bt<com.google.android.libraries.navigation.internal.ai.c> implements com.google.android.libraries.navigation.internal.yt.e {
        private static final com.google.android.libraries.navigation.internal.xn.a a = com.google.android.libraries.navigation.internal.xn.a.d("TertiaryTextItemLayout");

        @Override // com.google.android.libraries.navigation.internal.ms.bt
        protected final com.google.android.libraries.navigation.internal.mx.g a() {
            return new com.google.android.libraries.navigation.internal.mx.e(TextView.class, com.google.android.libraries.navigation.internal.w.e.b(), com.google.android.libraries.navigation.internal.w.e.i(), com.google.android.libraries.navigation.internal.ms.ah.aT(com.google.android.libraries.navigation.internal.nc.a.i(16)), com.google.android.libraries.navigation.internal.ms.ah.aj(2), com.google.android.libraries.navigation.internal.ms.ah.ab(com.google.android.libraries.navigation.internal.nc.a.g(6)), com.google.android.libraries.navigation.internal.ms.ah.C(TextUtils.TruncateAt.END), com.google.android.libraries.navigation.internal.ms.ah.M(false), com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.bn
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ai.c) csVar).a();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), com.google.android.libraries.navigation.internal.ms.ah.aO(5));
        }

        @Override // com.google.android.libraries.navigation.internal.yt.e
        public final com.google.android.libraries.navigation.internal.xn.a b() {
            return a;
        }
    }

    /* JADX INFO: compiled from: PG */
    final class d extends bt<com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d> implements com.google.android.libraries.navigation.internal.yt.e {
        private static final com.google.android.libraries.navigation.internal.xn.a a = com.google.android.libraries.navigation.internal.xn.a.d("TimeoutDismissButtonLayout");

        @Override // com.google.android.libraries.navigation.internal.ms.bt
        protected final com.google.android.libraries.navigation.internal.mx.g a() {
            return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, bm.c(), com.google.android.libraries.navigation.internal.ms.ah.c(new a(), new dd() { // from class: com.google.android.libraries.navigation.internal.vf.bo
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) csVar).b();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }, new com.google.android.libraries.navigation.internal.mx.m[0]));
        }

        @Override // com.google.android.libraries.navigation.internal.yt.e
        public final com.google.android.libraries.navigation.internal.xn.a b() {
            return a;
        }
    }

    public static com.google.android.libraries.navigation.internal.mx.k c() {
        int i = com.google.android.libraries.navigation.internal.w.d.a;
        return new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.af(com.google.android.libraries.navigation.internal.w.c.b()), com.google.android.libraries.navigation.internal.ms.ah.S(com.google.android.libraries.navigation.internal.w.c.b()), com.google.android.libraries.navigation.internal.ms.ah.X(com.google.android.libraries.navigation.internal.nc.a.g(26)), com.google.android.libraries.navigation.internal.ms.ah.an(new com.google.android.libraries.navigation.internal.ms.o(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.az
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d.b) csVar).c();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), com.google.android.libraries.navigation.internal.ad.a.a(com.google.android.libraries.navigation.internal.jy.aa.k(com.google.android.libraries.navigation.internal.afe.o.p)), com.google.android.libraries.navigation.internal.ms.ah.z(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.ba
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d.b) csVar).i();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.p(com.google.android.libraries.navigation.internal.m.b.c(com.google.android.libraries.navigation.internal.w.b.b(), com.google.android.libraries.navigation.internal.nc.ae.e(), com.google.android.libraries.navigation.internal.m.b.a))});
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected final com.google.android.libraries.navigation.internal.mx.g a() {
        com.google.android.libraries.navigation.internal.mx.e eVar = new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.aK(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.c.w)));
        eVar.e(com.google.android.libraries.navigation.internal.ms.ah.G(da.b(new by() { // from class: com.google.android.libraries.navigation.internal.vf.aj
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                boolean z = true;
                if (!((Boolean) bm.a.a((com.google.android.libraries.navigation.internal.vj.d) csVar)).booleanValue() && !com.google.android.libraries.navigation.internal.af.e.e(context)) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        })));
        by byVar = new by() { // from class: com.google.android.libraries.navigation.internal.vf.al
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                dd ddVar = bm.a;
                return Boolean.valueOf(!com.google.android.libraries.navigation.internal.ms.aq.b(context));
            }
        };
        dd ddVar = a;
        com.google.android.libraries.navigation.internal.mx.k kVar = new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.Z(com.google.android.libraries.navigation.internal.nc.a.g(8)), com.google.android.libraries.navigation.internal.ms.ah.X(com.google.android.libraries.navigation.internal.nc.a.g(8))});
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr = {com.google.android.libraries.navigation.internal.ms.ah.Z(com.google.android.libraries.navigation.internal.nc.a.g(0)), com.google.android.libraries.navigation.internal.ms.ah.X(com.google.android.libraries.navigation.internal.nc.a.g(0))};
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr2 = {new com.google.android.libraries.navigation.internal.mx.aa(this.b), com.google.android.libraries.navigation.internal.ms.ah.I(49), com.google.android.libraries.navigation.internal.ms.ah.af(com.google.android.libraries.navigation.internal.w.c.g()), com.google.android.libraries.navigation.internal.ms.ah.Q(17), com.google.android.libraries.navigation.internal.ms.ah.S(com.google.android.libraries.navigation.internal.nc.a.g(82))};
        com.google.android.libraries.navigation.internal.ms.c cVar = new com.google.android.libraries.navigation.internal.ms.c() { // from class: com.google.android.libraries.navigation.internal.vf.ay
            @Override // com.google.android.libraries.navigation.internal.ms.c
            public final void a(View view, boolean z) {
                View view2 = (View) view.getParent().getParent();
                View viewA = com.google.android.libraries.navigation.internal.ms.be.a(view2, this.a.b);
                if (viewA == null || view2 == null) {
                    return;
                }
                int height = view.getHeight() - viewA.getHeight();
                viewA.setVisibility(8);
                if (height > 0) {
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, "translationY", height, 0.0f);
                    objectAnimatorOfFloat.setDuration(250L);
                    objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                    objectAnimatorOfFloat.start();
                }
            }
        };
        by byVar2 = new by() { // from class: com.google.android.libraries.navigation.internal.vf.ax
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.vj.d dVar = (com.google.android.libraries.navigation.internal.vj.d) csVar;
                dd ddVar2 = bm.a;
                boolean z = true;
                if (!com.google.android.libraries.navigation.internal.ms.aq.c(context) && !dVar.u().booleanValue()) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        };
        com.google.android.libraries.navigation.internal.mx.w wVarAc = com.google.android.libraries.navigation.internal.ms.ah.ac(bz.j(), bz.i(), bz.t(this.j));
        bz[] bzVarArr = {bz.q(), bz.i(), bz.t(this.i)};
        com.google.android.libraries.navigation.internal.nc.a aVar = d;
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr3 = {new com.google.android.libraries.navigation.internal.mx.aa(this.h), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.aq(1), ch.b(byVar2, wVarAc, com.google.android.libraries.navigation.internal.ms.ah.ac(bzVarArr)), com.google.android.libraries.navigation.internal.ms.ah.Z(aVar), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, com.google.android.libraries.navigation.internal.ms.bk.a(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.au
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.d) csVar).ab();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.aP(2131821147), com.google.android.libraries.navigation.internal.w.e.j(), com.google.android.libraries.navigation.internal.ms.ah.aT(com.google.android.libraries.navigation.internal.nc.a.i(20)), com.google.android.libraries.navigation.internal.ms.ah.aj(2), com.google.android.libraries.navigation.internal.ms.ah.C(TextUtils.TruncateAt.END), com.google.android.libraries.navigation.internal.ms.ah.M(false), com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.bc
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.d) csVar).x();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aO(5)), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, com.google.android.libraries.navigation.internal.ms.bk.a(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.bd
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.vj.d dVar = (com.google.android.libraries.navigation.internal.vj.d) csVar;
                dd ddVar2 = bm.a;
                dVar.r().booleanValue();
                return Boolean.valueOf(ch.g(dVar.A()));
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.aa(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.be
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                dd ddVar2 = bm.a;
                return com.google.android.libraries.navigation.internal.nc.a.g(((com.google.android.libraries.navigation.internal.vj.d) csVar).ab().booleanValue() ? 0 : 6);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.w.e.b(), com.google.android.libraries.navigation.internal.w.e.i(), com.google.android.libraries.navigation.internal.ms.ah.aT(com.google.android.libraries.navigation.internal.nc.a.i(16)), com.google.android.libraries.navigation.internal.ms.ah.aj(2), com.google.android.libraries.navigation.internal.ms.ah.C(TextUtils.TruncateAt.END), com.google.android.libraries.navigation.internal.ms.ah.M(false), com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.bf
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.d) csVar).A();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aO(5)), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.aq(1), com.google.android.libraries.navigation.internal.ms.bk.a(new cg(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.bg
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.d) csVar).H();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.ah(e()))};
        by byVar3 = new by() { // from class: com.google.android.libraries.navigation.internal.vf.bi
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.vj.d dVar = (com.google.android.libraries.navigation.internal.vj.d) csVar;
                dd ddVar2 = bm.a;
                boolean z = true;
                if (!com.google.android.libraries.navigation.internal.ms.aq.c(context) && !dVar.u().booleanValue()) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        };
        com.google.android.libraries.navigation.internal.mx.w wVarAc2 = com.google.android.libraries.navigation.internal.ms.ah.ac(bz.m(this.h));
        bz[] bzVarArr2 = {bz.q(), bz.t(this.j)};
        ai aiVar = new ai();
        dd ddVar2 = new dd() { // from class: com.google.android.libraries.navigation.internal.vf.bj
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.d) csVar).Z();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        com.google.android.libraries.navigation.internal.nc.a aVar2 = g;
        Float fValueOf = Float.valueOf(1.0f);
        return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), eVar, ch.c(com.google.android.libraries.navigation.internal.ms.e.CLICKABLE, byVar), com.google.android.libraries.navigation.internal.ms.ah.x(false), com.google.android.libraries.navigation.internal.ms.ah.v(false), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ae(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.ap
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.d) csVar).E();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.x(false), com.google.android.libraries.navigation.internal.ms.ah.v(false), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ak(com.google.android.libraries.navigation.internal.nc.j.k(com.google.android.libraries.navigation.internal.dw.b.a)), com.google.android.libraries.navigation.internal.ms.ah.ab(com.google.android.libraries.navigation.internal.nc.a.g(5)), ch.a(ddVar, kVar, new com.google.android.libraries.navigation.internal.mx.k(mVarArr)), com.google.android.libraries.navigation.internal.ms.ah.ax(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.aq
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.d) csVar).D();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.av(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.ar
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.d) csVar).C();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.at(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.as
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.d) csVar).B();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.p(com.google.android.libraries.navigation.internal.ur.n.i(com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.r(), com.google.android.libraries.navigation.internal.w.a.b()))), com.google.android.libraries.navigation.internal.ms.ah.B(com.google.android.libraries.navigation.internal.vb.a.a), com.google.android.libraries.navigation.internal.ur.n.c(), com.google.android.libraries.navigation.internal.ur.n.h(), com.google.android.libraries.navigation.internal.ms.ah.E(true), com.google.android.libraries.navigation.internal.ms.ah.x(false), com.google.android.libraries.navigation.internal.ms.ah.v(false), new com.google.android.libraries.navigation.internal.mx.e(ProgressBar.class, mVarArr2), new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, com.google.android.libraries.navigation.internal.ms.bk.a(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.at
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.d) csVar).t();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), ch.e(com.google.android.libraries.navigation.internal.ms.e.ON_PRE_DRAW_APPLY_CALLBACK, cVar), com.google.android.libraries.navigation.internal.ad.a.b(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.av
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.d) csVar).j();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.v(false), com.google.android.libraries.navigation.internal.ms.ah.aa(da.b(new by() { // from class: com.google.android.libraries.navigation.internal.vf.aw
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.vj.d dVar = (com.google.android.libraries.navigation.internal.vj.d) csVar;
                dd ddVar3 = bm.a;
                return com.google.android.libraries.navigation.internal.nc.a.g((com.google.android.libraries.navigation.internal.ms.aq.c(context) || dVar.u().booleanValue()) ? 30 : 16);
            }
        })), com.google.android.libraries.navigation.internal.ms.ah.V(com.google.android.libraries.navigation.internal.nc.a.g(8)), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, mVarArr3), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, new com.google.android.libraries.navigation.internal.mx.aa(this.i), com.google.android.libraries.navigation.internal.ms.ah.ae(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.bh
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return Integer.valueOf(true != ((Boolean) bm.a.a((com.google.android.libraries.navigation.internal.vj.d) csVar)).booleanValue() ? -2 : -1);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ab(com.google.android.libraries.navigation.internal.w.c.d()), com.google.android.libraries.navigation.internal.ms.ah.V(com.google.android.libraries.navigation.internal.w.c.d()), com.google.android.libraries.navigation.internal.ms.ah.Z(aVar), com.google.android.libraries.navigation.internal.ms.ah.X(aVar), ch.b(byVar3, wVarAc2, com.google.android.libraries.navigation.internal.ms.ah.ac(bzVarArr2)), com.google.android.libraries.navigation.internal.ms.ah.d(aiVar, ddVar2, com.google.android.libraries.navigation.internal.ms.ah.X(aVar2), ch.a(ddVar, new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.af(com.google.android.libraries.navigation.internal.nc.a.g(0)), com.google.android.libraries.navigation.internal.ms.ah.ad(fValueOf)}), new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.af(ai.d), com.google.android.libraries.navigation.internal.ms.ah.ad(fValueOf)}))), com.google.android.libraries.navigation.internal.ms.ah.d(new ai(), new dd() { // from class: com.google.android.libraries.navigation.internal.vf.ak
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.d) csVar).aa();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, com.google.android.libraries.navigation.internal.ms.ah.Z(aVar2), ch.a(ddVar, new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.af(com.google.android.libraries.navigation.internal.nc.a.g(0)), com.google.android.libraries.navigation.internal.ms.ah.ad(fValueOf)}), new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.af(ai.d), com.google.android.libraries.navigation.internal.ms.ah.ad(fValueOf)})))), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, new com.google.android.libraries.navigation.internal.mx.aa(this.j), com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.Z(f), ch.b(new by() { // from class: com.google.android.libraries.navigation.internal.vf.am
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.vj.d dVar = (com.google.android.libraries.navigation.internal.vj.d) csVar;
                dd ddVar3 = bm.a;
                boolean z = true;
                if (!com.google.android.libraries.navigation.internal.ms.aq.c(context) && !dVar.u().booleanValue()) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }, com.google.android.libraries.navigation.internal.ms.ah.ac(bz.j(), bz.h()), com.google.android.libraries.navigation.internal.ms.ah.ac(bz.q(), bz.h())), com.google.android.libraries.navigation.internal.ms.ah.d(new d(), new dd() { // from class: com.google.android.libraries.navigation.internal.vf.an
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.d) csVar).p();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.c(new b(), new dd() { // from class: com.google.android.libraries.navigation.internal.vf.ao
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.d) csVar).o();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, com.google.android.libraries.navigation.internal.ms.ah.H(new cg(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.an
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.d) csVar).p();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }))))))));
    }

    @Override // com.google.android.libraries.navigation.internal.yt.e
    public final com.google.android.libraries.navigation.internal.xn.a b() {
        return c;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected final /* bridge */ /* synthetic */ void d(int i, cs csVar, bs bsVar) {
        no it2 = ((ev) ((com.google.android.libraries.navigation.internal.vj.d) csVar).H()).iterator();
        while (it2.hasNext()) {
            bsVar.b(new c(), (com.google.android.libraries.navigation.internal.ai.c) it2.next());
        }
    }
}
