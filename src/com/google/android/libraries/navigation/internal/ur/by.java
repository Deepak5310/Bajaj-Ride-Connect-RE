package com.google.android.libraries.navigation.internal.ur;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.apps.gmm.base.views.squeezedlabel.SqueezedLabelView;
import com.google.android.libraries.navigation.internal.ms.cg;
import com.google.android.libraries.navigation.internal.ms.ch;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.da;
import com.google.android.libraries.navigation.internal.ms.dd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class by extends n<com.google.android.libraries.navigation.internal.ut.d> implements com.google.android.libraries.navigation.internal.yt.e {
    private static final com.google.android.libraries.navigation.internal.xn.a i = com.google.android.libraries.navigation.internal.xn.a.d("DefaultPromptLayout");
    public static final dd g = da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.ur.bg
        @Override // com.google.android.libraries.navigation.internal.ms.by
        public final Object a(cs csVar, Context context) {
            com.google.android.libraries.navigation.internal.ut.d dVar = (com.google.android.libraries.navigation.internal.ut.d) csVar;
            dd ddVar = by.g;
            boolean z = false;
            if (com.google.android.libraries.navigation.internal.ms.aq.b(context) && dVar.u().booleanValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    });
    public static final dd h = da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.ur.bp
        @Override // com.google.android.libraries.navigation.internal.ms.by
        public final Object a(cs csVar, Context context) {
            com.google.android.libraries.navigation.internal.ut.d dVar = (com.google.android.libraries.navigation.internal.ut.d) csVar;
            dd ddVar = by.g;
            boolean z = false;
            if (com.google.android.libraries.navigation.internal.ms.aq.b(context) && !dVar.u().booleanValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    });

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected final com.google.android.libraries.navigation.internal.mx.g a() {
        dd ddVar = g;
        com.google.android.libraries.navigation.internal.mx.k kVar = new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.ay(com.google.android.libraries.navigation.internal.nc.a.g(8)), com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.nc.a.g(8))});
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr = {com.google.android.libraries.navigation.internal.ms.ah.ay(com.google.android.libraries.navigation.internal.nc.a.g(0)), com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.nc.a.g(0))};
        com.google.android.libraries.navigation.internal.mx.e eVar = new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.aK(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.c.w)));
        eVar.f(com.google.android.libraries.navigation.internal.ms.ah.G(da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.ur.bk
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                boolean z = true;
                if (!((Boolean) by.g.a((com.google.android.libraries.navigation.internal.ut.d) csVar)).booleanValue() && !com.google.android.libraries.navigation.internal.af.e.e(context)) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        })));
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr2 = {com.google.android.libraries.navigation.internal.ms.bk.a(new cg(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.bm
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).n();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.x(false), com.google.android.libraries.navigation.internal.ms.ah.v(false), com.google.android.libraries.navigation.internal.ms.ah.c(new ad(), new dd() { // from class: com.google.android.libraries.navigation.internal.ur.bn
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                dd ddVar2 = by.g;
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).n().j();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0])};
        com.google.android.libraries.navigation.internal.mx.e eVar2 = new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.S(com.google.android.libraries.navigation.internal.nc.a.g(137)), com.google.android.libraries.navigation.internal.ms.ah.p(n.i(com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.r(), com.google.android.libraries.navigation.internal.w.a.b()))), com.google.android.libraries.navigation.internal.ms.ah.B(com.google.android.libraries.navigation.internal.vb.a.a), n.c(), n.h(), com.google.android.libraries.navigation.internal.ms.ah.u(true), com.google.android.libraries.navigation.internal.ms.ah.x(false), com.google.android.libraries.navigation.internal.ms.ah.v(false), new com.google.android.libraries.navigation.internal.mx.e(ProgressBar.class, com.google.android.libraries.navigation.internal.ms.ah.Q(17), com.google.android.libraries.navigation.internal.z.c.a()));
        eVar2.e(com.google.android.libraries.navigation.internal.ms.bk.b(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.bo
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).t();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]));
        dd ddVar2 = new dd() { // from class: com.google.android.libraries.navigation.internal.ur.bq
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return Integer.valueOf(!((Boolean) by.h.a((com.google.android.libraries.navigation.internal.ut.d) csVar)).booleanValue() ? 1 : 0);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        dd ddVar3 = h;
        com.google.android.libraries.navigation.internal.mx.k kVar2 = new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.af(com.google.android.libraries.navigation.internal.nc.a.g(0)), com.google.android.libraries.navigation.internal.ms.ah.ad(Float.valueOf(1.0f))});
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr3 = {com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.ad(Float.valueOf(0.0f))};
        com.google.android.libraries.navigation.internal.mx.e eVar3 = new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, com.google.android.libraries.navigation.internal.ms.bk.a(new cg(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.i
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).k();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.ae(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.j
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                int i2 = n.f;
                ((com.google.android.libraries.navigation.internal.ut.d) csVar).w().booleanValue();
                return n.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.R(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.k
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                int i2 = n.f;
                ((com.google.android.libraries.navigation.internal.ut.d) csVar).w().booleanValue();
                return n.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.Z(com.google.android.libraries.navigation.internal.w.c.d()), com.google.android.libraries.navigation.internal.ms.ah.aI(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.i
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).k();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }));
        eVar3.e(com.google.android.libraries.navigation.internal.ms.ah.Q(8388659));
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr4 = {com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.aP(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.i.f)), com.google.android.libraries.navigation.internal.ms.ah.aR(com.google.android.libraries.navigation.internal.w.b.g()), com.google.android.libraries.navigation.internal.ms.ah.aj(4), com.google.android.libraries.navigation.internal.ms.ah.C(TextUtils.TruncateAt.END), com.google.android.libraries.navigation.internal.ms.ah.M(false), com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.d
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).x();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aO(5)};
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr5 = {com.google.android.libraries.navigation.internal.ms.bk.a(new cg(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.g
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                ((com.google.android.libraries.navigation.internal.ut.d) csVar).z();
                return null;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.ab(com.google.android.libraries.navigation.internal.nc.a.g(6)), new com.google.android.libraries.navigation.internal.mx.r(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.f
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).s();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, com.google.android.libraries.navigation.internal.w.e.h(), com.google.android.libraries.navigation.internal.ms.ah.aP(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.i.e))), com.google.android.libraries.navigation.internal.ms.ah.aR(com.google.android.libraries.navigation.internal.w.b.e()), com.google.android.libraries.navigation.internal.ms.ah.aT(com.google.android.libraries.navigation.internal.nc.a.i(18)), com.google.android.libraries.navigation.internal.ms.ah.aj(1), com.google.android.libraries.navigation.internal.ms.ah.C(TextUtils.TruncateAt.END), com.google.android.libraries.navigation.internal.ms.ah.M(false), com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.g
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                ((com.google.android.libraries.navigation.internal.ut.d) csVar).z();
                return null;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aO(5)};
        Float fValueOf = Float.valueOf(0.5f);
        int i2 = SqueezedLabelView.b;
        com.google.android.libraries.navigation.internal.mx.e eVar4 = new com.google.android.libraries.navigation.internal.mx.e(TextView.class, com.google.android.libraries.navigation.internal.ms.bk.a(new cg(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.e
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).A();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.ab(com.google.android.libraries.navigation.internal.nc.a.g(6)), new com.google.android.libraries.navigation.internal.mx.r(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.f
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).s();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, com.google.android.libraries.navigation.internal.w.e.h(), com.google.android.libraries.navigation.internal.ms.ah.aP(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.i.e))), com.google.android.libraries.navigation.internal.ms.ah.aR(com.google.android.libraries.navigation.internal.w.b.e()), ch.e(com.google.android.libraries.navigation.internal.ad.b.MIN_SCALE_X, fValueOf), SqueezedLabelView.b(com.google.android.libraries.navigation.internal.nc.a.i(18)), com.google.android.libraries.navigation.internal.ms.ah.aT(com.google.android.libraries.navigation.internal.nc.a.i(18)), com.google.android.libraries.navigation.internal.ms.ah.aj(2), com.google.android.libraries.navigation.internal.ms.ah.C(TextUtils.TruncateAt.END), com.google.android.libraries.navigation.internal.ms.ah.M(false), com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.e
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).A();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aO(5));
        eVar4.e(com.google.android.libraries.navigation.internal.ms.ah.G(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.a
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).r();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }));
        com.google.android.libraries.navigation.internal.mx.e eVar5 = new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.X(com.google.android.libraries.navigation.internal.w.c.d()), com.google.android.libraries.navigation.internal.ms.ah.aq(1), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, mVarArr4), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, mVarArr5), eVar4, new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.aq(1), com.google.android.libraries.navigation.internal.ms.bk.a(new cg(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.h
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).H();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.ah(new com.google.android.libraries.navigation.internal.ms.br(this, 1))));
        eVar5.e(com.google.android.libraries.navigation.internal.ms.ah.Y(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.bw
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.ut.d dVar = (com.google.android.libraries.navigation.internal.ut.d) csVar;
                dd ddVar4 = by.g;
                if (ch.g(dVar.k())) {
                    return com.google.android.libraries.navigation.internal.nc.a.g(16);
                }
                dVar.w().booleanValue();
                return com.google.android.libraries.navigation.internal.nc.a.g(64);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.ab(com.google.android.libraries.navigation.internal.nc.a.g(4)), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ag(-1));
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr6 = {com.google.android.libraries.navigation.internal.ms.ah.J(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.d.r)), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.Q(16), com.google.android.libraries.navigation.internal.ms.ah.ab(com.google.android.libraries.navigation.internal.nc.a.g(8)), com.google.android.libraries.navigation.internal.ms.ah.V(com.google.android.libraries.navigation.internal.nc.a.g(8)), ch.a(ddVar3, kVar2, new com.google.android.libraries.navigation.internal.mx.k(mVarArr3)), com.google.android.libraries.navigation.internal.ms.ah.z(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.bv
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                ((com.google.android.libraries.navigation.internal.ut.d) csVar).F();
                return null;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), eVar3, eVar5};
        com.google.android.libraries.navigation.internal.mx.e eVar6 = new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.v(false), com.google.android.libraries.navigation.internal.ms.ah.aq(0), com.google.android.libraries.navigation.internal.ms.ah.ah(new com.google.android.libraries.navigation.internal.ms.br(this, 0)));
        eVar6.e(com.google.android.libraries.navigation.internal.ms.ah.ae(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.bx
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return Integer.valueOf(true != ((Boolean) by.h.a((com.google.android.libraries.navigation.internal.ut.d) csVar)).booleanValue() ? -1 : -2);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aa(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.bh
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((Boolean) by.h.a((com.google.android.libraries.navigation.internal.ut.d) csVar)).booleanValue() ? com.google.android.libraries.navigation.internal.w.c.d() : com.google.android.libraries.navigation.internal.nc.a.g(8);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.V(com.google.android.libraries.navigation.internal.w.c.d()), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.G(new cg(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.bi
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).G();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), com.google.android.libraries.navigation.internal.ms.ah.Q(16));
        return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ae(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.bj
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).E();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.T(-2), ch.a(ddVar, kVar, new com.google.android.libraries.navigation.internal.mx.k(mVarArr)), eVar, com.google.android.libraries.navigation.internal.ms.ah.x(false), com.google.android.libraries.navigation.internal.ms.ah.v(false), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.x(false), com.google.android.libraries.navigation.internal.ms.ah.v(false), com.google.android.libraries.navigation.internal.ms.ah.ab(com.google.android.libraries.navigation.internal.nc.a.g(5)), com.google.android.libraries.navigation.internal.ms.ah.ao(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.bl
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.ut.d dVar = (com.google.android.libraries.navigation.internal.ut.d) csVar;
                return ((Boolean) by.c.a(dVar)).booleanValue() ? dVar.n().f() : by.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.u(true), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, mVarArr2), eVar2, new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.J(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.d.p)), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.G(b), ch.d(com.google.android.libraries.navigation.internal.ms.e.ORIENTATION, ddVar2), com.google.android.libraries.navigation.internal.ms.ah.ax(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.br
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).D();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.av(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.bs
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).C();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.at(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.bt
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).B();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ad.a.b(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.bu
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ut.d) csVar).j();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.ak(com.google.android.libraries.navigation.internal.nc.j.k(com.google.android.libraries.navigation.internal.dw.b.a)), com.google.android.libraries.navigation.internal.ms.ah.p(i(com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.r(), com.google.android.libraries.navigation.internal.w.a.b()))), com.google.android.libraries.navigation.internal.ms.ah.B(com.google.android.libraries.navigation.internal.vb.a.a), c(), h(), com.google.android.libraries.navigation.internal.ms.ah.E(true), com.google.android.libraries.navigation.internal.ms.ah.x(false), com.google.android.libraries.navigation.internal.ms.ah.v(false), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, mVarArr6), eVar6))));
    }

    @Override // com.google.android.libraries.navigation.internal.ur.n, com.google.android.libraries.navigation.internal.yt.e
    public final com.google.android.libraries.navigation.internal.xn.a b() {
        return i;
    }
}
