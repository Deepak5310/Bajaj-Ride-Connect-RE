package com.google.android.libraries.navigation.internal.vf;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.cc;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.dd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ai extends bt<com.google.android.libraries.navigation.internal.vj.c> implements com.google.android.libraries.navigation.internal.yt.e {
    public static final /* synthetic */ int k = 0;
    private static final com.google.android.libraries.navigation.internal.xn.a l = com.google.android.libraries.navigation.internal.xn.a.d("VotableButtonLayout");
    static final cc a = new cc();
    static final cc b = new cc();
    static final cc c = new cc();
    static final com.google.android.libraries.navigation.internal.nc.a d = com.google.android.libraries.navigation.internal.nc.a.g(140);
    static final com.google.android.libraries.navigation.internal.nc.a f = com.google.android.libraries.navigation.internal.nc.a.g(56);
    static final com.google.android.libraries.navigation.internal.nc.a g = com.google.android.libraries.navigation.internal.nc.a.g(28);
    static final com.google.android.libraries.navigation.internal.nc.a h = com.google.android.libraries.navigation.internal.nc.a.g(1);
    static final com.google.android.libraries.navigation.internal.nc.a i = com.google.android.libraries.navigation.internal.nc.a.g(24);
    static final com.google.android.libraries.navigation.internal.nc.a j = com.google.android.libraries.navigation.internal.nc.a.g(1);

    /* JADX INFO: compiled from: PG */
    final class a extends com.google.android.libraries.navigation.internal.nc.ah {
        private final com.google.android.libraries.navigation.internal.nc.x a;
        private final com.google.android.libraries.navigation.internal.nc.x b;

        public a(com.google.android.libraries.navigation.internal.nc.x xVar, com.google.android.libraries.navigation.internal.nc.x xVar2) {
            super(new Object[0]);
            this.a = xVar;
            this.b = xVar2;
        }

        @Override // com.google.android.libraries.navigation.internal.nc.ah
        public final Drawable a(Context context) {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{com.google.android.libraries.navigation.internal.ae.b.c(this.a, this.b, ai.h, ai.g).a(context), new com.google.android.libraries.navigation.internal.mu.f()});
            transitionDrawable.setCrossFadeEnabled(true);
            return transitionDrawable;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected final com.google.android.libraries.navigation.internal.mx.g a() {
        com.google.android.libraries.navigation.internal.nc.a aVar = i;
        com.google.android.libraries.navigation.internal.nc.a aVar2 = j;
        return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, new com.google.android.libraries.navigation.internal.mx.aa(a), com.google.android.libraries.navigation.internal.ms.ah.af(d), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.p(com.google.android.libraries.navigation.internal.af.e.d(new a(com.google.android.libraries.navigation.internal.w.a.r(), com.google.android.libraries.navigation.internal.w.a.i()), new a(com.google.android.libraries.navigation.internal.w.a.b(), com.google.android.libraries.navigation.internal.w.a.r()))), com.google.android.libraries.navigation.internal.ms.ah.w(true), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.S(f), com.google.android.libraries.navigation.internal.ms.ah.ao(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.ad
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.vj.c cVar = (com.google.android.libraries.navigation.internal.vj.c) csVar;
                int i2 = ai.k;
                return cVar.f().booleanValue() ? cVar.b() : cVar.c();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ad.a.b(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.ae
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.c) csVar).a();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.an(new com.google.android.libraries.navigation.internal.ms.o(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.af
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.c) csVar).d();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), com.google.android.libraries.navigation.internal.ms.ah.u(true), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.Q(17), new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, new com.google.android.libraries.navigation.internal.mx.aa(b), com.google.android.libraries.navigation.internal.ms.ah.af(aVar), com.google.android.libraries.navigation.internal.ms.ah.S(aVar), com.google.android.libraries.navigation.internal.ms.ah.Q(17), com.google.android.libraries.navigation.internal.ms.ah.X(aVar2), com.google.android.libraries.navigation.internal.ms.ah.l(Float.valueOf(0.0f))), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, new com.google.android.libraries.navigation.internal.mx.aa(c), com.google.android.libraries.navigation.internal.ms.ah.Q(17), com.google.android.libraries.navigation.internal.ms.ah.Z(aVar2), com.google.android.libraries.navigation.internal.w.e.h(), com.google.android.libraries.navigation.internal.ms.ah.C(TextUtils.TruncateAt.END), com.google.android.libraries.navigation.internal.ms.ah.aj(1), com.google.android.libraries.navigation.internal.ms.ah.aO(4), com.google.android.libraries.navigation.internal.ms.ah.aQ(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.ag
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                int i2 = ai.k;
                return ((com.google.android.libraries.navigation.internal.vj.c) csVar).f().booleanValue() ? com.google.android.libraries.navigation.internal.w.a.r() : com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.b(), com.google.android.libraries.navigation.internal.w.a.r());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.vf.ah
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.c) csVar).e();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })))));
    }

    @Override // com.google.android.libraries.navigation.internal.yt.e
    public final com.google.android.libraries.navigation.internal.xn.a b() {
        return l;
    }
}
