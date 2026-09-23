package com.google.android.libraries.navigation.internal.dz;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.apps.gmm.base.components.gmmrecyclerview.GmmRecyclerView;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.by;
import com.google.android.libraries.navigation.internal.ms.cg;
import com.google.android.libraries.navigation.internal.ms.ch;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.da;
import com.google.android.libraries.navigation.internal.ms.dd;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class be extends bt<com.google.android.libraries.navigation.internal.vj.b> implements com.google.android.libraries.navigation.internal.yt.e {
    private static final com.google.android.libraries.navigation.internal.xn.a d = com.google.android.libraries.navigation.internal.xn.a.d("ReportIncidentPromptLayoutV4");
    private static final com.google.android.libraries.navigation.internal.nc.a f = com.google.android.libraries.navigation.internal.nc.a.g(5);
    private static final com.google.android.libraries.navigation.internal.nc.a g = com.google.android.libraries.navigation.internal.nc.a.g(22);
    private static final com.google.android.libraries.navigation.internal.nc.a h = com.google.android.libraries.navigation.internal.nc.a.g(16);
    public static final com.google.android.libraries.navigation.internal.nc.a a = com.google.android.libraries.navigation.internal.nc.a.g(56);
    private static final com.google.android.libraries.navigation.internal.nc.a i = com.google.android.libraries.navigation.internal.nc.a.g(10);
    public static final dd b = da.b(new by() { // from class: com.google.android.libraries.navigation.internal.dz.as
        @Override // com.google.android.libraries.navigation.internal.ms.by
        public final Object a(cs csVar, Context context) {
            com.google.android.libraries.navigation.internal.nc.a aVar = be.a;
            boolean z = false;
            if (((com.google.android.libraries.navigation.internal.vj.b) csVar).u().booleanValue() && com.google.android.libraries.navigation.internal.ms.aq.b(context)) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    });
    public static final View.AccessibilityDelegate c = new ba();

    /* JADX INFO: compiled from: PG */
    final class a extends com.google.android.libraries.navigation.internal.ur.at<com.google.android.libraries.navigation.internal.ut.d.b> implements com.google.android.libraries.navigation.internal.yt.e {
        private static final com.google.android.libraries.navigation.internal.xn.a a = com.google.android.libraries.navigation.internal.xn.a.d("DismissButtonLayout");

        @Override // com.google.android.libraries.navigation.internal.ms.bt
        protected final com.google.android.libraries.navigation.internal.mx.g a() {
            com.google.android.libraries.navigation.internal.nc.a aVarG = com.google.android.libraries.navigation.internal.nc.a.g(0);
            return new com.google.android.libraries.navigation.internal.mx.e(ImageButton.class, com.google.android.libraries.navigation.internal.ms.ah.af(be.a), com.google.android.libraries.navigation.internal.ms.ah.S(be.a), com.google.android.libraries.navigation.internal.ms.ah.X(com.google.android.libraries.navigation.internal.nc.a.g(18)), com.google.android.libraries.navigation.internal.ad.a.b(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.bb
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ut.d.b) csVar).d();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), com.google.android.libraries.navigation.internal.ms.ah.z(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.bc
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ut.d.b) csVar).i();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), com.google.android.libraries.navigation.internal.ms.ah.p(com.google.android.libraries.navigation.internal.w.d.c()), com.google.android.libraries.navigation.internal.ms.ah.aJ(com.google.android.libraries.navigation.internal.ae.b.a(com.google.android.libraries.navigation.internal.nc.j.i(com.google.android.libraries.navigation.internal.f.d.i, com.google.android.libraries.navigation.internal.ju.b.d), 0.6f, com.google.android.libraries.navigation.internal.ju.b.a)), com.google.android.libraries.navigation.internal.ms.ah.aD(ImageView.ScaleType.FIT_CENTER), com.google.android.libraries.navigation.internal.ms.ah.ar(aVarG, aVarG, aVarG, aVarG), com.google.android.libraries.navigation.internal.ms.ah.an(new com.google.android.libraries.navigation.internal.ms.o(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.bd
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ut.d.b) csVar).c();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            })));
        }

        @Override // com.google.android.libraries.navigation.internal.ur.at, com.google.android.libraries.navigation.internal.yt.e
        public final com.google.android.libraries.navigation.internal.xn.a b() {
            return a;
        }
    }

    /* JADX INFO: compiled from: PG */
    final class b extends com.google.android.libraries.navigation.internal.ur.at<com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d> implements com.google.android.libraries.navigation.internal.yt.e {
        private static final com.google.android.libraries.navigation.internal.xn.a a = com.google.android.libraries.navigation.internal.xn.a.d("DismissButtonWithProgressLayout");

        @Override // com.google.android.libraries.navigation.internal.ms.bt
        protected final com.google.android.libraries.navigation.internal.mx.g a() {
            return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.af(be.a), com.google.android.libraries.navigation.internal.ms.ah.S(be.a), com.google.android.libraries.navigation.internal.ms.ah.X(com.google.android.libraries.navigation.internal.nc.a.g(18)), com.google.android.libraries.navigation.internal.ad.a.b(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.bf
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) csVar).d();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), com.google.android.libraries.navigation.internal.ms.ah.h(be.c), com.google.android.libraries.navigation.internal.ms.ah.z(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.bg
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) csVar).i();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), com.google.android.libraries.navigation.internal.ms.ah.p(com.google.android.libraries.navigation.internal.w.d.c()), com.google.android.libraries.navigation.internal.ms.ah.an(new com.google.android.libraries.navigation.internal.ms.o(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.bh
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) csVar).c();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            })), com.google.android.libraries.navigation.internal.ms.ah.c(new e(), new dd() { // from class: com.google.android.libraries.navigation.internal.dz.bi
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) csVar).b();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }, new com.google.android.libraries.navigation.internal.mx.m[0]), new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-1), com.google.android.libraries.navigation.internal.ms.ah.aJ(com.google.android.libraries.navigation.internal.nc.aj.d(com.google.android.libraries.navigation.internal.nc.j.i(com.google.android.libraries.navigation.internal.f.d.i, com.google.android.libraries.navigation.internal.ju.b.d), 0.6f)), com.google.android.libraries.navigation.internal.ms.ah.aD(ImageView.ScaleType.FIT_CENTER)));
        }

        @Override // com.google.android.libraries.navigation.internal.ur.at, com.google.android.libraries.navigation.internal.yt.e
        public final com.google.android.libraries.navigation.internal.xn.a b() {
            return a;
        }
    }

    /* JADX INFO: compiled from: PG */
    final class c extends bt<com.google.android.libraries.navigation.internal.ut.c> implements com.google.android.libraries.navigation.internal.yt.e {
        private static final com.google.android.libraries.navigation.internal.xn.a b = com.google.android.libraries.navigation.internal.xn.a.d("IncidentItemLayout");
        private static final com.google.android.libraries.navigation.internal.nc.a c = com.google.android.libraries.navigation.internal.nc.a.g(48);
        private static final com.google.android.libraries.navigation.internal.nc.a d = com.google.android.libraries.navigation.internal.nc.a.g(10);
        private static final com.google.android.libraries.navigation.internal.nc.a f = com.google.android.libraries.navigation.internal.nc.a.g(6);
        private static final com.google.android.libraries.navigation.internal.nc.a g = com.google.android.libraries.navigation.internal.nc.a.g(8);
        public static final com.google.android.libraries.navigation.internal.nc.a a = com.google.android.libraries.navigation.internal.nc.a.g(16);

        private static com.google.android.libraries.navigation.internal.mx.g c(com.google.android.libraries.navigation.internal.mx.m... mVarArr) {
            com.google.android.libraries.navigation.internal.mx.e eVar = new com.google.android.libraries.navigation.internal.mx.e(TextView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.Q(1), com.google.android.libraries.navigation.internal.ms.ah.I(1), com.google.android.libraries.navigation.internal.ms.ah.aA(f), com.google.android.libraries.navigation.internal.ms.ah.ay(com.google.android.libraries.navigation.internal.nc.a.g(4)), com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.nc.a.g(4)), com.google.android.libraries.navigation.internal.ms.ah.C(TextUtils.TruncateAt.END), com.google.android.libraries.navigation.internal.w.e.b(), com.google.android.libraries.navigation.internal.ms.ah.aj(2), com.google.android.libraries.navigation.internal.ms.ah.aG(false), com.google.android.libraries.navigation.internal.ms.ah.aX(com.google.android.libraries.navigation.internal.w.e.a), com.google.android.libraries.navigation.internal.ms.ah.aR(com.google.android.libraries.navigation.internal.ju.b.g), com.google.android.libraries.navigation.internal.ms.ah.aM(new bl()));
            eVar.e(mVarArr);
            return eVar;
        }

        private static com.google.android.libraries.navigation.internal.mx.g h() {
            com.google.android.libraries.navigation.internal.nc.a aVar = c;
            return new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, com.google.android.libraries.navigation.internal.ms.ah.af(aVar), com.google.android.libraries.navigation.internal.ms.ah.S(aVar), com.google.android.libraries.navigation.internal.ms.ah.Q(1), com.google.android.libraries.navigation.internal.ms.ah.aI(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.bn
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ut.c) csVar).d();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }));
        }

        @Override // com.google.android.libraries.navigation.internal.ms.bt
        protected final com.google.android.libraries.navigation.internal.mx.g a() {
            com.google.android.libraries.navigation.internal.nc.a aVar = d;
            return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ar(aVar, aVar, aVar, aVar), com.google.android.libraries.navigation.internal.ms.ah.U(g), com.google.android.libraries.navigation.internal.ms.ah.an(new com.google.android.libraries.navigation.internal.ms.o(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.bj
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ut.c) csVar).b();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            })), com.google.android.libraries.navigation.internal.ms.ah.o(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.bk
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    com.google.android.libraries.navigation.internal.nc.a aVar2 = be.c.a;
                    com.google.android.libraries.navigation.internal.af.a aVar3 = com.google.android.libraries.navigation.internal.ju.b.l;
                    com.google.android.libraries.navigation.internal.nc.ah[] ahVarArr = {new com.google.android.libraries.navigation.internal.nc.ax(new com.google.android.libraries.navigation.internal.nc.aw[]{new com.google.android.libraries.navigation.internal.nc.at(new Object[]{0}), new com.google.android.libraries.navigation.internal.nc.av(new Object[]{aVar2}, aVar2), new com.google.android.libraries.navigation.internal.nc.au(new Object[]{aVar3}, aVar3)}), com.google.android.libraries.navigation.internal.w.d.a(be.c.a)};
                    return new com.google.android.libraries.navigation.internal.nc.am(ahVarArr, ahVarArr);
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), com.google.android.libraries.navigation.internal.ms.ah.h(be.c), com.google.android.libraries.navigation.internal.ms.ah.z(new bl()), com.google.android.libraries.navigation.internal.ad.a.b(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.bm
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ut.c) csVar).a();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.aq(1), com.google.android.libraries.navigation.internal.ms.ah.bc(4), h(), c(ch.e(com.google.android.libraries.navigation.internal.ms.e.LINES, 2))), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.aq(1), com.google.android.libraries.navigation.internal.ms.ah.Q(16), h(), c(new com.google.android.libraries.navigation.internal.mx.m[0])), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.Q(8388629), new com.google.android.libraries.navigation.internal.mx.e(View.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2))));
        }

        @Override // com.google.android.libraries.navigation.internal.yt.e
        public final com.google.android.libraries.navigation.internal.xn.a b() {
            return b;
        }
    }

    /* JADX INFO: compiled from: PG */
    final class d extends bt<com.google.android.libraries.navigation.internal.ut.c> implements com.google.android.libraries.navigation.internal.yt.e {
        private static final com.google.android.libraries.navigation.internal.xn.a a = com.google.android.libraries.navigation.internal.xn.a.d("InvisibleIncidentItemLayout");

        @Override // com.google.android.libraries.navigation.internal.ms.bt
        protected final com.google.android.libraries.navigation.internal.mx.g a() {
            com.google.android.libraries.navigation.internal.mx.g gVarA = new c().a();
            gVarA.e(com.google.android.libraries.navigation.internal.ms.ah.bc(4));
            return gVarA;
        }

        @Override // com.google.android.libraries.navigation.internal.yt.e
        public final com.google.android.libraries.navigation.internal.xn.a b() {
            return a;
        }
    }

    /* JADX INFO: compiled from: PG */
    final class e extends bt<com.google.android.libraries.navigation.internal.ah.a> implements com.google.android.libraries.navigation.internal.yt.e {
        public static final /* synthetic */ int a = 0;
        private static final com.google.android.libraries.navigation.internal.xn.a b = com.google.android.libraries.navigation.internal.xn.a.d("ProgressBarLayout");

        @Override // com.google.android.libraries.navigation.internal.ms.bt
        protected final com.google.android.libraries.navigation.internal.mx.g a() {
            return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-1), com.google.android.libraries.navigation.internal.ms.ah.p(com.google.android.libraries.navigation.internal.nc.aj.a(com.google.android.libraries.navigation.internal.ju.b.a)), new com.google.android.libraries.navigation.internal.mx.e(ProgressBar.class, new com.google.android.libraries.navigation.internal.mx.o(com.google.android.libraries.navigation.internal.f.i.b), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-1), com.google.android.libraries.navigation.internal.ms.ah.aC(da.b(new by() { // from class: com.google.android.libraries.navigation.internal.dz.bo
                @Override // com.google.android.libraries.navigation.internal.ms.by
                public final Object a(cs csVar, Context context) {
                    int i = be.e.a;
                    return new com.google.android.libraries.navigation.internal.nc.ba(com.google.android.libraries.navigation.internal.nc.ae.e(), com.google.android.libraries.navigation.internal.ju.b.d, be.a);
                }
            })), com.google.android.libraries.navigation.internal.ms.ah.l(Float.valueOf(0.16f)), com.google.android.libraries.navigation.internal.ms.ah.aB(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.bp
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ah.a) csVar).b();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), com.google.android.libraries.navigation.internal.ms.ah.ai(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.bq
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
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr = {com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-1), com.google.android.libraries.navigation.internal.ms.bk.b(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.al
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.vj.b) csVar).ah());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.p(com.google.android.libraries.navigation.internal.nc.y.a(com.google.android.libraries.navigation.internal.w.a.b(), 0.6f))};
        com.google.android.libraries.navigation.internal.mx.e eVar = new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.aK(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.c.w))));
        eVar.e(com.google.android.libraries.navigation.internal.ms.bk.a(da.b(new by() { // from class: com.google.android.libraries.navigation.internal.dz.ao
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                boolean z = true;
                if (!((Boolean) be.b.a((com.google.android.libraries.navigation.internal.vj.b) csVar)).booleanValue() && !com.google.android.libraries.navigation.internal.af.e.e(context)) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }), new com.google.android.libraries.navigation.internal.mx.m[0]));
        dd ddVar = b;
        com.google.android.libraries.navigation.internal.mx.k kVar = new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.ab(com.google.android.libraries.navigation.internal.nc.a.g(8)), com.google.android.libraries.navigation.internal.ms.ah.Z(com.google.android.libraries.navigation.internal.nc.a.g(8)), com.google.android.libraries.navigation.internal.ms.ah.X(com.google.android.libraries.navigation.internal.nc.a.g(8))});
        com.google.android.libraries.navigation.internal.nc.a aVar = f;
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr2 = {com.google.android.libraries.navigation.internal.ms.ah.ab(aVar), com.google.android.libraries.navigation.internal.ms.ah.Z(com.google.android.libraries.navigation.internal.nc.a.g(0)), com.google.android.libraries.navigation.internal.ms.ah.X(com.google.android.libraries.navigation.internal.nc.a.g(0))};
        com.google.android.libraries.navigation.internal.ur.ad adVar = new com.google.android.libraries.navigation.internal.ur.ad();
        final dd ddVar2 = new dd() { // from class: com.google.android.libraries.navigation.internal.dz.aq
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.b) csVar).ab();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr3 = {com.google.android.libraries.navigation.internal.ms.bk.a(new cg(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.aq
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.b) csVar).ab();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), ch.a(ddVar, kVar, new com.google.android.libraries.navigation.internal.mx.k(mVarArr2)), com.google.android.libraries.navigation.internal.ms.ah.x(false), com.google.android.libraries.navigation.internal.ms.ah.v(false), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, new com.google.android.libraries.navigation.internal.mx.j(adVar, new by() { // from class: com.google.android.libraries.navigation.internal.ms.q
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                return ddVar2.a(csVar);
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.bk.a(new cg(ddVar2), new com.google.android.libraries.navigation.internal.mx.m[0]))};
        com.google.android.libraries.navigation.internal.mx.k kVar2 = new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.ab(com.google.android.libraries.navigation.internal.nc.a.g(8)), com.google.android.libraries.navigation.internal.ms.ah.Z(com.google.android.libraries.navigation.internal.nc.a.g(8)), com.google.android.libraries.navigation.internal.ms.ah.X(com.google.android.libraries.navigation.internal.nc.a.g(8))});
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr4 = {com.google.android.libraries.navigation.internal.ms.ah.ab(aVar), com.google.android.libraries.navigation.internal.ms.ah.Z(com.google.android.libraries.navigation.internal.nc.a.g(0)), com.google.android.libraries.navigation.internal.ms.ah.X(com.google.android.libraries.navigation.internal.nc.a.g(0))};
        com.google.android.libraries.navigation.internal.nc.a aVar2 = g;
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr5 = {com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.aq(0), com.google.android.libraries.navigation.internal.ms.ah.I(8388629), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.bk.b(new cg(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.ai
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.b) csVar).ac();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.af(com.google.android.libraries.navigation.internal.nc.a.g(0)), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ad(Float.valueOf(1.0f)), com.google.android.libraries.navigation.internal.ms.ah.aq(1), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.Z(aVar2), com.google.android.libraries.navigation.internal.ms.ah.aP(2131821132), com.google.android.libraries.navigation.internal.w.e.j(), com.google.android.libraries.navigation.internal.ms.ah.aT(com.google.android.libraries.navigation.internal.nc.a.i(22)), com.google.android.libraries.navigation.internal.ms.ah.aj(1), com.google.android.libraries.navigation.internal.ms.ah.C(TextUtils.TruncateAt.END), com.google.android.libraries.navigation.internal.ms.ah.M(false), com.google.android.libraries.navigation.internal.ms.ah.aO(5), com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.ag
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.b) csVar).x();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, com.google.android.libraries.navigation.internal.ms.bk.a(new cg(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.av
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.b) csVar).A();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.Z(aVar2), com.google.android.libraries.navigation.internal.ms.ah.ab(com.google.android.libraries.navigation.internal.nc.a.g(4)), com.google.android.libraries.navigation.internal.w.e.b(), com.google.android.libraries.navigation.internal.w.e.i(), com.google.android.libraries.navigation.internal.ms.ah.aT(com.google.android.libraries.navigation.internal.nc.a.i(14)), com.google.android.libraries.navigation.internal.ms.ah.aj(1), com.google.android.libraries.navigation.internal.ms.ah.C(TextUtils.TruncateAt.END), com.google.android.libraries.navigation.internal.ms.ah.M(false), com.google.android.libraries.navigation.internal.ms.ah.aO(5), com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.av
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.b) csVar).A();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }))), com.google.android.libraries.navigation.internal.ms.ah.b(new a(), new dd() { // from class: com.google.android.libraries.navigation.internal.dz.ax
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.b) csVar).o();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new dd() { // from class: com.google.android.libraries.navigation.internal.dz.ay
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                boolean z;
                com.google.android.libraries.navigation.internal.vj.b bVar = (com.google.android.libraries.navigation.internal.vj.b) csVar;
                com.google.android.libraries.navigation.internal.nc.a aVar3 = be.a;
                if (bVar.ac() == null || !bVar.ag()) {
                    bVar.ai();
                    z = false;
                } else {
                    z = true;
                }
                return Boolean.valueOf(z);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.b(new b(), new dd() { // from class: com.google.android.libraries.navigation.internal.dz.az
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.b) csVar).p();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new dd() { // from class: com.google.android.libraries.navigation.internal.dz.ah
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.vj.b bVar = (com.google.android.libraries.navigation.internal.vj.b) csVar;
                com.google.android.libraries.navigation.internal.nc.a aVar3 = be.a;
                if (bVar.ac() == null || !bVar.ag()) {
                    bVar.ai();
                }
                return true;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0])};
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr6 = {com.google.android.libraries.navigation.internal.ms.bk.b(new cg(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.ai
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.b) csVar).ac();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), new com.google.android.libraries.navigation.internal.mx.m[0])};
        com.google.android.libraries.navigation.internal.nc.a aVarG = com.google.android.libraries.navigation.internal.nc.a.g(8);
        com.google.android.libraries.navigation.internal.mx.g gVarA = GmmRecyclerView.a(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.at
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.vj.b bVar = (com.google.android.libraries.navigation.internal.vj.b) csVar;
                com.google.android.libraries.navigation.internal.nc.a aVar3 = be.a;
                int i2 = ev.d;
                eq eqVar = new eq();
                Iterator<com.google.android.libraries.navigation.internal.ut.c> it2 = bVar.ad().iterator();
                while (it2.hasNext()) {
                    eqVar.h(com.google.android.libraries.navigation.internal.ms.ah.a(new be.c(), it2.next()));
                }
                int iG = bVar.g();
                int i3 = iG + iG;
                if (i3 > bVar.ad().size()) {
                    int size = i3 - bVar.ad().size();
                    for (int i4 = 0; i4 < size; i4++) {
                        eqVar.h(com.google.android.libraries.navigation.internal.ms.ah.a(new be.d(), bVar.ad().get(0)));
                    }
                }
                return eqVar.g();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.aa(com.google.android.libraries.navigation.internal.vj.b.CI), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.ab(aVarG), com.google.android.libraries.navigation.internal.ms.ah.V(aVarG)}), com.google.android.libraries.navigation.internal.ms.ah.g(i), com.google.android.libraries.navigation.internal.mz.g.c(new com.google.android.libraries.navigation.internal.mz.f(2)), com.google.android.libraries.navigation.internal.ms.ah.ap(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.au
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.b) csVar).Z();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.v(false));
        gVarA.e(mVarArr6);
        return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-1), com.google.android.libraries.navigation.internal.ms.ah.an(new com.google.android.libraries.navigation.internal.ms.o(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.aw
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.b) csVar).aa();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), new com.google.android.libraries.navigation.internal.mx.e(View.class, mVarArr), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ae(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.an
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.b) csVar).E();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.Q(80), eVar, com.google.android.libraries.navigation.internal.ms.ah.aa(da.b(new by() { // from class: com.google.android.libraries.navigation.internal.dz.ap
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                if (com.google.android.libraries.navigation.internal.y.b.a == null) {
                    com.google.android.libraries.navigation.internal.y.b.a = new com.google.android.libraries.navigation.internal.y.b(com.google.android.libraries.navigation.internal.y.a.TOP);
                }
                return 0;
            }
        })), com.google.android.libraries.navigation.internal.ms.ah.x(false), com.google.android.libraries.navigation.internal.ms.ah.v(false), com.google.android.libraries.navigation.internal.ms.ah.u(true), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, mVarArr3), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.J(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.d.p)), com.google.android.libraries.navigation.internal.ms.bk.b(new cg(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.aq
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.b) csVar).ab();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ak(com.google.android.libraries.navigation.internal.nc.j.k(com.google.android.libraries.navigation.internal.dw.b.a)), ch.a(ddVar, kVar2, new com.google.android.libraries.navigation.internal.mx.k(mVarArr4)), com.google.android.libraries.navigation.internal.ad.a.b(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.ar
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.b) csVar).j();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.p(com.google.android.libraries.navigation.internal.ur.n.i(com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.r(), com.google.android.libraries.navigation.internal.w.a.b()))), com.google.android.libraries.navigation.internal.ms.ah.B(com.google.android.libraries.navigation.internal.vb.a.a), com.google.android.libraries.navigation.internal.ur.n.c(), com.google.android.libraries.navigation.internal.ur.n.h(), com.google.android.libraries.navigation.internal.ms.ah.E(true), com.google.android.libraries.navigation.internal.ms.ah.x(false), com.google.android.libraries.navigation.internal.ms.ah.v(false), com.google.android.libraries.navigation.internal.ms.ah.m(true), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.aq(1), com.google.android.libraries.navigation.internal.ms.ah.ab(h), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, mVarArr5), gVarA), com.google.android.libraries.navigation.internal.ms.ah.b(new n(), new dd() { // from class: com.google.android.libraries.navigation.internal.dz.ai
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.b) csVar).ac();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new dd() { // from class: com.google.android.libraries.navigation.internal.dz.aj
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.nc.a aVar3 = be.a;
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.vj.b) csVar).ag());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.b(new af(), new dd() { // from class: com.google.android.libraries.navigation.internal.dz.ai
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.b) csVar).ac();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new dd() { // from class: com.google.android.libraries.navigation.internal.dz.ak
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.nc.a aVar3 = be.a;
                return Boolean.valueOf(!((com.google.android.libraries.navigation.internal.vj.b) csVar).ag());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]))), com.google.android.libraries.navigation.internal.ms.ah.ap(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.au
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.b) csVar).Z();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.i(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.am
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.b) csVar).i();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }));
    }

    @Override // com.google.android.libraries.navigation.internal.yt.e
    public final com.google.android.libraries.navigation.internal.xn.a b() {
        return d;
    }
}
