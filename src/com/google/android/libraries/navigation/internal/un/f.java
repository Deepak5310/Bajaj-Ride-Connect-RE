package com.google.android.libraries.navigation.internal.un;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.android.apps.gmm.base.views.squeezedlabel.SqueezedLabelView;
import com.google.android.libraries.navigation.internal.ms.ad;
import com.google.android.libraries.navigation.internal.ms.ah;
import com.google.android.libraries.navigation.internal.ms.aq;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.by;
import com.google.android.libraries.navigation.internal.ms.bz;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.da;
import com.google.android.libraries.navigation.internal.ms.dd;
import com.google.android.libraries.navigation.internal.mx.g;
import com.google.android.libraries.navigation.internal.mx.m;
import com.google.android.libraries.navigation.internal.nc.bg;
import com.google.android.libraries.navigation.internal.nc.j;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class f extends bt<com.google.android.libraries.navigation.internal.vk.b> implements com.google.android.libraries.navigation.internal.yt.e {
    public static final /* synthetic */ int a = 0;
    private static final com.google.android.libraries.navigation.internal.xn.a b = com.google.android.libraries.navigation.internal.xn.a.d("NavFooterView");

    @SafeVarargs
    private static g c(m... mVarArr) {
        m[] mVarArr2 = {ah.ag(-2), ah.T(-2), ah.aX(new bg(ad.e)), ah.aR(com.google.android.libraries.navigation.internal.w.b.e())};
        int i = SqueezedLabelView.b;
        com.google.android.libraries.navigation.internal.mx.e eVar = new com.google.android.libraries.navigation.internal.mx.e(SqueezedLabelView.class, mVarArr2);
        eVar.e(mVarArr);
        return eVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected final g a() {
        return new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, ah.ag(-1), ah.T(-2), new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, ah.R(da.b(new by() { // from class: com.google.android.libraries.navigation.internal.un.c
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                int i = f.a;
                return !aq.c(context) ? j.k(com.google.android.libraries.navigation.internal.dw.b.b) : j.k(com.google.android.libraries.navigation.internal.dw.b.c);
            }
        })), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, ah.T(-2), ah.ag(-2), ah.ac(bz.i(), bz.q()), ah.Z(com.google.android.libraries.navigation.internal.nc.a.g(20)), ah.H(da.b(new by() { // from class: com.google.android.libraries.navigation.internal.ms.ap
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                return Boolean.valueOf(aq.c(context));
            }
        })), ah.aq(1), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, ah.T(-2), ah.ag(-2), c(ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.un.a
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vk.b) csVar).d();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), SqueezedLabelView.b(com.google.android.libraries.navigation.internal.nc.a.i(26)))), c(ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.un.b
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vk.b) csVar).e();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), SqueezedLabelView.b(com.google.android.libraries.navigation.internal.nc.a.i(18)))), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, ah.T(-2), ah.ag(-2), ah.ac(bz.p()), ah.Z(com.google.android.libraries.navigation.internal.nc.a.g(0)), ah.H(da.b(aq.a())), c(ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.un.e
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vk.b) csVar).c();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), SqueezedLabelView.b(com.google.android.libraries.navigation.internal.nc.a.i(24)))), ah.z(new dd() { // from class: com.google.android.libraries.navigation.internal.un.d
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vk.b) csVar).b();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), ah.s(com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.r(), com.google.android.libraries.navigation.internal.w.a.b())), ah.ag(-1), ah.u(true)));
    }

    @Override // com.google.android.libraries.navigation.internal.yt.e
    public final com.google.android.libraries.navigation.internal.xn.a b() {
        return b;
    }
}
