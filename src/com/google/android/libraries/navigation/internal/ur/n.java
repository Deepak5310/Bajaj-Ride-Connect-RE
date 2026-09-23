package com.google.android.libraries.navigation.internal.ur;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.libraries.navigation.internal.ms.cc;
import com.google.android.libraries.navigation.internal.ms.ch;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.da;
import com.google.android.libraries.navigation.internal.ms.dd;
import com.google.android.libraries.navigation.internal.ut.d;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.no;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class n<T extends com.google.android.libraries.navigation.internal.ut.d> extends com.google.android.libraries.navigation.internal.ms.bt<T> implements com.google.android.libraries.navigation.internal.yt.e {
    static final com.google.android.libraries.navigation.internal.nc.ap a = com.google.android.libraries.navigation.internal.nc.a.i(32);
    static final dd b = new dd() { // from class: com.google.android.libraries.navigation.internal.ur.l
        @Override // com.google.android.libraries.navigation.internal.ms.dd
        public final Object a(cs csVar) {
            com.google.android.libraries.navigation.internal.ut.d dVar = (com.google.android.libraries.navigation.internal.ut.d) csVar;
            int i = n.f;
            com.google.android.libraries.navigation.internal.ut.d.b bVarN = dVar.n();
            com.google.android.libraries.navigation.internal.ut.b bVarJ = bVarN != null ? bVarN.j() : null;
            boolean z = true;
            if (!dVar.t().booleanValue() && (bVarJ == null || !bVarJ.g().booleanValue())) {
                z = false;
            }
            return Boolean.valueOf(z);
        }

        @Override // com.google.android.libraries.navigation.internal.ms.dd
        public final /* synthetic */ boolean b() {
            return false;
        }
    };
    protected static final dd c = new dd() { // from class: com.google.android.libraries.navigation.internal.ur.b
        @Override // com.google.android.libraries.navigation.internal.ms.dd
        public final Object a(cs csVar) {
            int i = n.f;
            com.google.android.libraries.navigation.internal.ut.d.b bVarN = ((com.google.android.libraries.navigation.internal.ut.d) csVar).n();
            boolean z = false;
            if (bVarN != null && bVarN.m().booleanValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }

        @Override // com.google.android.libraries.navigation.internal.ms.dd
        public final /* synthetic */ boolean b() {
            return false;
        }
    };
    protected static final com.google.android.libraries.navigation.internal.ms.c d = new com.google.android.libraries.navigation.internal.ms.c() { // from class: com.google.android.libraries.navigation.internal.ur.c
        @Override // com.google.android.libraries.navigation.internal.ms.c
        public final void a(View view, boolean z) {
            int i = n.f;
        }
    };
    public static final /* synthetic */ int f = 0;

    /* JADX INFO: compiled from: PG */
    public final class a extends com.google.android.libraries.navigation.internal.nc.ah {
        private final com.google.android.libraries.navigation.internal.nc.ah a;
        private final com.google.android.libraries.navigation.internal.nc.a b;
        private final com.google.android.libraries.navigation.internal.nc.a c;
        private final com.google.android.libraries.navigation.internal.nc.x d;

        public a(com.google.android.libraries.navigation.internal.nc.ah ahVar, com.google.android.libraries.navigation.internal.nc.a aVar, com.google.android.libraries.navigation.internal.nc.a aVar2, com.google.android.libraries.navigation.internal.nc.x xVar) {
            super(new Object[]{ahVar, aVar, aVar2, xVar});
            this.a = ahVar;
            this.b = aVar;
            this.c = aVar2;
            this.d = xVar;
        }

        @Override // com.google.android.libraries.navigation.internal.nc.ah
        public final Drawable a(Context context) {
            m mVar = new m(this.c.e(context), this.d.b(context));
            com.google.android.libraries.navigation.internal.nc.ah ahVar = this.a;
            int iD = this.b.d(context);
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{ahVar.a(context), mVar});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.progress);
            layerDrawable.setLayerInset(0, iD, iD, iD, iD);
            return layerDrawable;
        }
    }

    /* JADX INFO: compiled from: PG */
    final class b extends com.google.android.libraries.navigation.internal.ms.bt<com.google.android.libraries.navigation.internal.ai.c> implements com.google.android.libraries.navigation.internal.yt.e {
        private static final com.google.android.libraries.navigation.internal.xn.a a = com.google.android.libraries.navigation.internal.xn.a.d("TertiaryTextItemLayout");
        private final Boolean b;

        public b(Boolean bool) {
            super(bool);
            this.b = bool;
        }

        @Override // com.google.android.libraries.navigation.internal.ms.bt
        protected final com.google.android.libraries.navigation.internal.mx.g a() {
            return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, new com.google.android.libraries.navigation.internal.mx.e(TextView.class, new com.google.android.libraries.navigation.internal.mx.r(da.a(this.b), com.google.android.libraries.navigation.internal.w.e.h(), com.google.android.libraries.navigation.internal.ms.ah.aP(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.i.e))), com.google.android.libraries.navigation.internal.ms.ah.aR(com.google.android.libraries.navigation.internal.w.b.e()), com.google.android.libraries.navigation.internal.ms.ah.aj(4), com.google.android.libraries.navigation.internal.ms.ah.ab(com.google.android.libraries.navigation.internal.nc.a.g(6)), com.google.android.libraries.navigation.internal.ms.ah.C(TextUtils.TruncateAt.END), com.google.android.libraries.navigation.internal.ms.ah.M(false), com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.ur.o
                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final Object a(cs csVar) {
                    return ((com.google.android.libraries.navigation.internal.ai.c) csVar).a();
                }

                @Override // com.google.android.libraries.navigation.internal.ms.dd
                public final /* synthetic */ boolean b() {
                    return false;
                }
            }), com.google.android.libraries.navigation.internal.ms.ah.aO(5)));
        }

        @Override // com.google.android.libraries.navigation.internal.yt.e
        public final com.google.android.libraries.navigation.internal.xn.a b() {
            return a;
        }
    }

    public static com.google.android.libraries.navigation.internal.mx.m c() {
        if (Build.VERSION.SDK_INT < 28) {
            return com.google.android.libraries.navigation.internal.mx.m.e;
        }
        return ch.e(com.google.android.libraries.navigation.internal.ms.e.OUTLINE_AMBIENT_SHADOW_COLOR, com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.b(), com.google.android.libraries.navigation.internal.w.a.r()));
    }

    public static com.google.android.libraries.navigation.internal.mx.m h() {
        if (Build.VERSION.SDK_INT < 28) {
            return com.google.android.libraries.navigation.internal.mx.m.e;
        }
        return ch.e(com.google.android.libraries.navigation.internal.ms.e.OUTLINE_SPOT_SHADOW_COLOR, com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.b(), com.google.android.libraries.navigation.internal.w.a.q()));
    }

    public static com.google.android.libraries.navigation.internal.nc.ah i(com.google.android.libraries.navigation.internal.nc.x xVar) {
        return com.google.android.libraries.navigation.internal.ae.b.e(xVar, xVar, com.google.android.libraries.navigation.internal.nc.a.g(0), com.google.android.libraries.navigation.internal.vb.a.b);
    }

    public com.google.android.libraries.navigation.internal.xn.a b() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected final /* bridge */ /* synthetic */ void d(int i, cs csVar, com.google.android.libraries.navigation.internal.ms.bs bsVar) {
        com.google.android.libraries.navigation.internal.ut.d dVar = (com.google.android.libraries.navigation.internal.ut.d) csVar;
        dVar.O();
        if (i != 0) {
            no it2 = ((ev) dVar.H()).iterator();
            while (it2.hasNext()) {
                bsVar.b(new b(dVar.s()), (com.google.android.libraries.navigation.internal.ai.c) it2.next());
            }
            return;
        }
        if (dVar.G().size() < 2) {
            dVar.v().booleanValue();
            cc ccVar = at.b;
            bsVar.b(new at.e(), dVar);
        }
        for (com.google.android.libraries.navigation.internal.ut.d.b bVar : dVar.G()) {
            cc ccVar2 = at.b;
            if (bVar instanceof com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) {
                com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d interfaceC0038d = (com.google.android.libraries.navigation.internal.ut.d.InterfaceC0038d) bVar;
                if (interfaceC0038d.p().booleanValue()) {
                    bsVar.b(new at.f(), interfaceC0038d);
                } else {
                    bsVar.b(new at.c(), interfaceC0038d);
                }
            } else if (bVar.o().booleanValue()) {
                bsVar.b(new at.a(), bVar);
            } else {
                bsVar.b(new at.d(), bVar);
            }
        }
    }
}
