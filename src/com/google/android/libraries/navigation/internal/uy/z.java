package com.google.android.libraries.navigation.internal.uy;

import android.content.Context;
import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.libraries.geo.navcore.ui.header.views.ManeuverImageView;
import com.google.android.libraries.navigation.internal.ms.ah;
import com.google.android.libraries.navigation.internal.ms.bs;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.by;
import com.google.android.libraries.navigation.internal.ms.cg;
import com.google.android.libraries.navigation.internal.ms.ch;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.da;
import com.google.android.libraries.navigation.internal.ms.dd;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z extends bt<com.google.android.libraries.navigation.internal.uk.a> implements com.google.android.libraries.navigation.internal.yt.e {
    public static final /* synthetic */ int a = 0;
    private static final com.google.android.libraries.navigation.internal.xn.a b = com.google.android.libraries.navigation.internal.xn.a.d("NavFirstStepLayout");
    private static final dd c = da.b(new by() { // from class: com.google.android.libraries.navigation.internal.uy.q
        @Override // com.google.android.libraries.navigation.internal.ms.by
        public final Object a(cs csVar, Context context) {
            int i = z.a;
            Resources resources = context.getResources();
            int i2 = com.google.android.libraries.navigation.internal.dw.h.ao;
            CharSequence charSequenceZ = ((com.google.android.libraries.navigation.internal.uk.a) csVar).z();
            ar.q(charSequenceZ);
            return resources.getString(i2, charSequenceZ);
        }
    });

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected final com.google.android.libraries.navigation.internal.mx.g a() {
        return new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, ah.ag(-1), ah.T(-2), ah.aq(0), ah.I(8388627), ah.aA(com.google.android.libraries.navigation.internal.nc.a.g(16)), ah.au(com.google.android.libraries.navigation.internal.nc.a.g(16)), ah.p(com.google.android.libraries.navigation.internal.w.d.b()), ah.an(com.google.android.libraries.navigation.internal.ce.d.a(new com.google.android.libraries.navigation.internal.ce.h() { // from class: com.google.android.libraries.navigation.internal.uy.r
            @Override // com.google.android.libraries.navigation.internal.ce.h
            public final void a(cs csVar, com.google.android.libraries.navigation.internal.jy.p pVar) {
                int i = z.a;
                ar.q(((com.google.android.libraries.navigation.internal.uk.a) csVar).n());
            }
        })), ah.t(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.u
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                int i = z.a;
                com.google.android.libraries.navigation.internal.va.b bVarN = ((com.google.android.libraries.navigation.internal.uk.a) csVar).n();
                ar.q(bVarN);
                return bVarN.b();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, ah.T(-2), ah.af(com.google.android.libraries.navigation.internal.w.c.c()), new com.google.android.libraries.navigation.internal.mx.e(ManeuverImageView.class, com.google.android.libraries.navigation.internal.z.c.b(), ah.Z(com.google.android.libraries.navigation.internal.w.c.d()), ManeuverImageView.a(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.v
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).d();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), ch.f(com.google.android.libraries.geo.navcore.ui.header.views.b.MANEUVER_COLOR, com.google.android.libraries.navigation.internal.af.e.a(com.google.android.libraries.navigation.internal.f.b.s, com.google.android.libraries.navigation.internal.f.b.h), com.google.android.libraries.geo.navcore.ui.header.views.a.a), ah.H(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.w
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).p();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }))), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, ah.ag(-1), ah.X(com.google.android.libraries.navigation.internal.w.c.d()), ah.aq(1), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, ah.H(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.x
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).o();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), ah.ag(-2), ah.aM(c), ah.aO(5), new com.google.android.libraries.navigation.internal.mx.r(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.n
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).r();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, com.google.android.libraries.navigation.internal.w.e.k(), ah.aP(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.i.c))), ah.aQ(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.y
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                int i = z.a;
                return com.google.android.libraries.navigation.internal.w.b.g();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, ah.ag(-2), ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.o
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).F();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), ah.aO(5), ah.aP(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.i.f)), ah.aQ(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.p
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                int i = z.a;
                return com.google.android.libraries.navigation.internal.w.b.g();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, ah.ag(-2), ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.t
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).D();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), ah.aO(5), new com.google.android.libraries.navigation.internal.mx.r(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.n
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).r();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, com.google.android.libraries.navigation.internal.w.e.c(), ah.aP(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.i.b))), ah.aQ(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.s
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                int i = z.a;
                return com.google.android.libraries.navigation.internal.w.b.e();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), ah.G(new cg(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.t
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).D();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }))), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, ah.T(-2), ah.aq(1), ah.ah(e()))));
    }

    @Override // com.google.android.libraries.navigation.internal.yt.e
    public final com.google.android.libraries.navigation.internal.xn.a b() {
        return b;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected final /* bridge */ /* synthetic */ void d(int i, cs csVar, bs bsVar) {
        com.google.android.libraries.navigation.internal.bh.c cVar = new com.google.android.libraries.navigation.internal.bh.c(false);
        com.google.android.libraries.navigation.internal.va.b bVarN = ((com.google.android.libraries.navigation.internal.uk.a) csVar).n();
        ar.q(bVarN);
        bsVar.c(cVar, bVarN.l());
    }
}
