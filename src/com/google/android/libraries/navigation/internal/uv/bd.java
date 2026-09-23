package com.google.android.libraries.navigation.internal.uv;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.by;
import com.google.android.libraries.navigation.internal.ms.bz;
import com.google.android.libraries.navigation.internal.ms.ch;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.dd;
import java.util.Optional;
import kotlin.UByte$$ExternalSyntheticBackport0;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bd extends bt<com.google.android.libraries.navigation.internal.ux.e> implements com.google.android.libraries.navigation.internal.yt.e {
    public static final com.google.android.libraries.navigation.internal.nc.ap a;
    public static final com.google.android.libraries.navigation.internal.nc.ap b;
    public static final com.google.android.libraries.navigation.internal.nc.a c;
    public static final com.google.android.libraries.navigation.internal.nc.a d;
    public static final com.google.android.libraries.navigation.internal.nc.a f;
    public static final com.google.android.libraries.navigation.internal.nc.a g;
    public static final com.google.android.libraries.navigation.internal.nc.a h;
    public static final com.google.android.libraries.navigation.internal.nc.a i;
    private static final com.google.android.libraries.navigation.internal.xn.a j = com.google.android.libraries.navigation.internal.xn.a.d("SpeedLimitSignLayout");
    private static final com.google.android.libraries.navigation.internal.nc.a k;
    private static final com.google.android.libraries.navigation.internal.nc.a l;
    private static final com.google.android.libraries.navigation.internal.nc.a m;

    static {
        com.google.android.libraries.navigation.internal.nc.a aVarI = com.google.android.libraries.navigation.internal.nc.a.i(2);
        k = aVarI;
        com.google.android.libraries.navigation.internal.nc.a aVarI2 = com.google.android.libraries.navigation.internal.nc.a.i(3);
        l = aVarI2;
        a = com.google.android.libraries.navigation.internal.nc.p.c(com.google.android.libraries.navigation.internal.ux.c.b, new com.google.android.libraries.navigation.internal.nc.o(aVarI, aVarI));
        b = com.google.android.libraries.navigation.internal.nc.p.c(com.google.android.libraries.navigation.internal.ux.c.b, new com.google.android.libraries.navigation.internal.nc.o(aVarI2, aVarI2));
        c = com.google.android.libraries.navigation.internal.nc.a.i(28);
        d = com.google.android.libraries.navigation.internal.nc.a.i(24);
        f = com.google.android.libraries.navigation.internal.nc.a.i(27);
        g = com.google.android.libraries.navigation.internal.nc.a.i(22);
        h = com.google.android.libraries.navigation.internal.nc.a.i(13);
        i = com.google.android.libraries.navigation.internal.nc.a.i(2);
        m = com.google.android.libraries.navigation.internal.nc.a.i(5);
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected final com.google.android.libraries.navigation.internal.mx.g a() {
        dd ddVar = new dd() { // from class: com.google.android.libraries.navigation.internal.uv.ap
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.e) csVar).b();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        com.google.android.libraries.navigation.internal.nc.a aVar = k;
        com.google.android.libraries.navigation.internal.mx.k kVar = new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.ay(aVar), com.google.android.libraries.navigation.internal.ms.ah.aA(aVar), com.google.android.libraries.navigation.internal.ms.ah.au(aVar)});
        com.google.android.libraries.navigation.internal.nc.a aVar2 = l;
        return new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, com.google.android.libraries.navigation.internal.ms.ah.y(new by() { // from class: com.google.android.libraries.navigation.internal.uv.az
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.ux.e eVar = (com.google.android.libraries.navigation.internal.ux.e) csVar;
                String string = context.getResources().getString(com.google.android.libraries.navigation.internal.dw.h.bm);
                if (UByte$$ExternalSyntheticBackport0.m((Optional) eVar.h())) {
                    return string;
                }
                return String.format(string + StringUtils.SPACE + context.getResources().getQuantityString(eVar.e().intValue(), eVar.h().get().intValue()), eVar.h().get());
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.Q(8388611), com.google.android.libraries.navigation.internal.ms.ah.af(com.google.android.libraries.navigation.internal.ux.c.b), com.google.android.libraries.navigation.internal.ms.ah.T(-2), ch.a(ddVar, kVar, new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.ay(aVar2), com.google.android.libraries.navigation.internal.ms.ah.aA(aVar2), com.google.android.libraries.navigation.internal.ms.ah.au(aVar2)})), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ae(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.av
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.nc.ap apVar = bd.a;
                return ((com.google.android.libraries.navigation.internal.ux.e) csVar).b().booleanValue() ? bd.a : bd.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), new com.google.android.libraries.navigation.internal.mx.r(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.ap
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.e) csVar).b();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, com.google.android.libraries.navigation.internal.ms.ah.T(-1), com.google.android.libraries.navigation.internal.ms.ah.S(b)), com.google.android.libraries.navigation.internal.ms.ah.ac(bz.p()), com.google.android.libraries.navigation.internal.ms.ah.o(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.ax
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.nc.ap apVar = bd.a;
                return ((com.google.android.libraries.navigation.internal.ux.e) csVar).b().booleanValue() ? com.google.android.libraries.navigation.internal.af.e.c(com.google.android.libraries.navigation.internal.dw.c.z, com.google.android.libraries.navigation.internal.dw.c.A) : com.google.android.libraries.navigation.internal.af.e.c(com.google.android.libraries.navigation.internal.dw.c.B, com.google.android.libraries.navigation.internal.dw.c.C);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ac(bz.p()), com.google.android.libraries.navigation.internal.ms.ah.at(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.ay
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.ux.e eVar = (com.google.android.libraries.navigation.internal.ux.e) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bd.a;
                eVar.d().booleanValue();
                return eVar.b().booleanValue() ? bd.i : com.google.android.libraries.navigation.internal.nc.a.i(0);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.az(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.au
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.ux.e eVar = (com.google.android.libraries.navigation.internal.ux.e) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bd.a;
                eVar.d().booleanValue();
                if (eVar.b().booleanValue()) {
                    eVar.a().booleanValue();
                }
                return com.google.android.libraries.navigation.internal.nc.a.i(0);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), new com.google.android.libraries.navigation.internal.mx.r(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.bb
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.e) csVar).a();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, com.google.android.libraries.navigation.internal.w.e.g(), com.google.android.libraries.navigation.internal.ms.ah.aP(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.i.a))), new com.google.android.libraries.navigation.internal.mx.r(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.bb
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.e) csVar).a();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, com.google.android.libraries.navigation.internal.ms.ah.aR(com.google.android.libraries.navigation.internal.w.a.b()), com.google.android.libraries.navigation.internal.ms.ah.aR(com.google.android.libraries.navigation.internal.w.a.n())), com.google.android.libraries.navigation.internal.ms.ah.aU(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.bc
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return 1;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aS(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.aw
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.ux.e eVar = (com.google.android.libraries.navigation.internal.ux.e) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bd.a;
                if (eVar.b().booleanValue()) {
                    return eVar.c().booleanValue() ? bd.d : bd.c;
                }
                return eVar.c().booleanValue() ? bd.g : bd.f;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.L(2), com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.aq
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.e) csVar).g();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, com.google.android.libraries.navigation.internal.ms.ah.G(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.ar
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.ux.e eVar = (com.google.android.libraries.navigation.internal.ux.e) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bd.a;
                if (eVar.b().booleanValue()) {
                    eVar.d().booleanValue();
                }
                return true;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ac(bz.g(), bz.o()), com.google.android.libraries.navigation.internal.ms.ah.au(m), new com.google.android.libraries.navigation.internal.mx.r(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.bb
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.e) csVar).a();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, com.google.android.libraries.navigation.internal.w.e.g(), com.google.android.libraries.navigation.internal.ms.ah.aP(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.i.a))), new com.google.android.libraries.navigation.internal.mx.r(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.bb
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.e) csVar).a();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, com.google.android.libraries.navigation.internal.ms.ah.aR(com.google.android.libraries.navigation.internal.w.a.b()), com.google.android.libraries.navigation.internal.ms.ah.aR(com.google.android.libraries.navigation.internal.w.a.n())), com.google.android.libraries.navigation.internal.ms.ah.aU(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.as
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return 1;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aS(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.at
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return bd.h;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.L(2), com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.ba
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.e) csVar).f();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })));
    }

    @Override // com.google.android.libraries.navigation.internal.yt.e
    public final com.google.android.libraries.navigation.internal.xn.a b() {
        return j;
    }
}
