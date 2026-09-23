package com.google.android.libraries.navigation.internal.uy;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.libraries.navigation.internal.ms.ah;
import com.google.android.libraries.navigation.internal.ms.bs;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.bz;
import com.google.android.libraries.navigation.internal.ms.cg;
import com.google.android.libraries.navigation.internal.ms.ch;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.dd;
import com.google.android.libraries.navigation.internal.nc.ap;
import com.google.android.libraries.navigation.internal.va.b;
import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class k<T extends com.google.android.libraries.navigation.internal.va.b> extends bt<T> {
    public static final ap a = com.google.android.libraries.navigation.internal.nc.a.g(8);

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    public com.google.android.libraries.navigation.internal.mx.g a() {
        return c(false, Optional.empty());
    }

    protected final com.google.android.libraries.navigation.internal.mx.g c(boolean z, final Optional optional) {
        ap apVarF;
        boolean z2;
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr = new com.google.android.libraries.navigation.internal.mx.m[8];
        mVarArr[0] = ah.ag(-1);
        mVarArr[1] = ah.R(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.f
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                ((com.google.android.libraries.navigation.internal.va.b) csVar).m();
                return -2;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        });
        mVarArr[2] = ah.o(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.g
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                ap apVar = k.a;
                ((com.google.android.libraries.navigation.internal.va.b) csVar).n();
                return com.google.android.libraries.navigation.internal.w.d.b();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        });
        mVarArr[3] = com.google.android.libraries.navigation.internal.ad.a.b(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.h
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                ap apVar = k.a;
                return ((com.google.android.libraries.navigation.internal.va.b) csVar).c(optional);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        });
        mVarArr[4] = ah.an(com.google.android.libraries.navigation.internal.ce.d.a(new com.google.android.libraries.navigation.internal.ce.h() { // from class: com.google.android.libraries.navigation.internal.uy.i
            @Override // com.google.android.libraries.navigation.internal.ce.h
            public final void a(cs csVar, com.google.android.libraries.navigation.internal.jy.p pVar) {
                ((com.google.android.libraries.navigation.internal.va.b) csVar).a(pVar);
            }
        }));
        mVarArr[5] = ah.t(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.j
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.va.b) csVar).b();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        });
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr2 = new com.google.android.libraries.navigation.internal.mx.m[5];
        mVarArr2[0] = ah.ac(bz.q());
        mVarArr2[1] = ah.ay(z ? com.google.android.libraries.navigation.internal.w.c.d() : com.google.android.libraries.navigation.internal.w.c.k());
        mVarArr2[2] = ah.aA(com.google.android.libraries.navigation.internal.nc.a.g(16));
        mVarArr2[3] = ah.au(com.google.android.libraries.navigation.internal.nc.a.g(16));
        mVarArr2[4] = new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, ah.S(com.google.android.libraries.navigation.internal.w.c.l()), ah.af(com.google.android.libraries.navigation.internal.w.c.l()), ah.Z(a), ah.aI(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.a
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.va.b) csVar).d();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }));
        mVarArr[6] = new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, mVarArr2);
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr3 = new com.google.android.libraries.navigation.internal.mx.m[11];
        mVarArr3[0] = ah.ac(bz.q());
        mVarArr3[1] = ah.ag(-1);
        mVarArr3[2] = ah.T(-2);
        mVarArr3[3] = ah.aA(com.google.android.libraries.navigation.internal.nc.a.g(18));
        mVarArr3[4] = ah.au(com.google.android.libraries.navigation.internal.nc.a.g(18));
        if (z) {
            apVarF = com.google.android.libraries.navigation.internal.w.c.c();
            z2 = true;
        } else {
            apVarF = com.google.android.libraries.navigation.internal.w.c.f();
            z2 = false;
        }
        mVarArr3[5] = ah.ay(apVarF);
        mVarArr3[6] = ah.aw(z2 ? com.google.android.libraries.navigation.internal.w.c.d() : com.google.android.libraries.navigation.internal.w.c.k());
        mVarArr3[7] = ah.aq(0);
        mVarArr3[8] = ah.I(16);
        mVarArr3[9] = new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, ah.ad(Float.valueOf(1.0f)), ah.ag(-2), ah.T(-2), ah.aq(1), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, ah.ag(-2), ah.T(-2), ch.a(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.b
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.va.b) csVar).f();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{ah.aP(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.i.d)), ah.aR(com.google.android.libraries.navigation.internal.w.b.g())}), new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{ah.aP(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.i.d)), ah.aR(com.google.android.libraries.navigation.internal.w.b.g())})), ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.c
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.va.b) csVar).k();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), ah.z(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.d
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.va.b) csVar).j();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), ah.aO(5)), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, ah.ag(-2), ah.T(-2), new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{ah.aP(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.i.b)), ah.aR(com.google.android.libraries.navigation.internal.w.b.e())}), ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.e
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.va.b) csVar).i();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), ah.aO(5), ah.G(new cg(new dd() { // from class: com.google.android.libraries.navigation.internal.uy.e
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.va.b) csVar).i();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }))), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, ah.T(-2), ah.aq(1), ah.ah(e())));
        mVarArr3[10] = com.google.android.libraries.navigation.internal.mx.m.e;
        mVarArr[7] = new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, mVarArr3);
        return new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, mVarArr);
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected final /* bridge */ /* synthetic */ void d(int i, cs csVar, bs bsVar) {
        com.google.android.libraries.navigation.internal.va.b bVar = (com.google.android.libraries.navigation.internal.va.b) csVar;
        bVar.n();
        bsVar.c(new com.google.android.libraries.navigation.internal.bh.c(false), bVar.l());
    }
}
