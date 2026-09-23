package com.google.android.libraries.navigation.internal.uv;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.google.android.libraries.navigation.internal.ms.bk;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.by;
import com.google.android.libraries.navigation.internal.ms.ch;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.dd;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class am extends bt<com.google.android.libraries.navigation.internal.ux.f> implements com.google.android.libraries.navigation.internal.yt.e {
    public static final com.google.android.libraries.navigation.internal.nc.a i;
    public static final com.google.android.libraries.navigation.internal.nc.a j;
    public static final com.google.android.libraries.navigation.internal.nc.a k;
    public static final com.google.android.libraries.navigation.internal.nc.a l;
    public static final com.google.android.libraries.navigation.internal.nc.a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final com.google.android.libraries.navigation.internal.nc.a f630n;
    public static final com.google.android.libraries.navigation.internal.nc.a o;
    public static final com.google.android.libraries.navigation.internal.nc.a p;
    public static final com.google.android.libraries.navigation.internal.nc.a q;
    public static final com.google.android.libraries.navigation.internal.nc.a r;
    public static final com.google.android.libraries.navigation.internal.nc.a s;
    public static final com.google.android.libraries.navigation.internal.nc.a t;
    public static final com.google.android.libraries.navigation.internal.nc.a u;
    public static final com.google.android.libraries.navigation.internal.nc.a v;
    private static final com.google.android.libraries.navigation.internal.xn.a w = com.google.android.libraries.navigation.internal.xn.a.d("RedesignedSpeedLimitLayout");
    public static final com.google.android.libraries.navigation.internal.nc.a a = com.google.android.libraries.navigation.internal.nc.a.i(60);
    public static final com.google.android.libraries.navigation.internal.nc.a b = com.google.android.libraries.navigation.internal.nc.a.i(55);
    public static final com.google.android.libraries.navigation.internal.nc.a c = com.google.android.libraries.navigation.internal.nc.a.i(2);
    public static final com.google.android.libraries.navigation.internal.nc.a d = com.google.android.libraries.navigation.internal.nc.a.i(3);
    public static final com.google.android.libraries.navigation.internal.nc.a f = com.google.android.libraries.navigation.internal.nc.a.i(10);
    public static final com.google.android.libraries.navigation.internal.nc.a g = com.google.android.libraries.navigation.internal.nc.a.h(27.5d);
    public static final com.google.android.libraries.navigation.internal.nc.x h = com.google.android.libraries.navigation.internal.nc.ae.d(1120284);

    static {
        com.google.android.libraries.navigation.internal.nc.ae.d(14906368);
        com.google.android.libraries.navigation.internal.nc.ae.d(15898880);
        com.google.android.libraries.navigation.internal.nc.ae.d(14233637);
        i = com.google.android.libraries.navigation.internal.nc.a.i(50);
        j = com.google.android.libraries.navigation.internal.nc.a.i(55);
        k = com.google.android.libraries.navigation.internal.nc.a.i(13);
        l = com.google.android.libraries.navigation.internal.nc.a.i(11);
        m = com.google.android.libraries.navigation.internal.nc.a.i(26);
        f630n = com.google.android.libraries.navigation.internal.nc.a.i(25);
        o = com.google.android.libraries.navigation.internal.nc.a.i(9);
        p = com.google.android.libraries.navigation.internal.nc.a.i(0);
        q = com.google.android.libraries.navigation.internal.nc.a.i(7);
        r = com.google.android.libraries.navigation.internal.nc.a.i(0);
        s = com.google.android.libraries.navigation.internal.nc.a.i(14);
        t = com.google.android.libraries.navigation.internal.nc.a.i(10);
        u = com.google.android.libraries.navigation.internal.nc.a.i(8);
        v = com.google.android.libraries.navigation.internal.nc.a.i(6);
    }

    private static com.google.android.libraries.navigation.internal.mx.w c() {
        return com.google.android.libraries.navigation.internal.ms.ah.av(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.ae
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.ux.f fVar = (com.google.android.libraries.navigation.internal.ux.f) csVar;
                com.google.android.libraries.navigation.internal.nc.a aVar = am.a;
                if (fVar.k().booleanValue()) {
                    return fVar.j().booleanValue() ? am.q : am.r;
                }
                return com.google.android.libraries.navigation.internal.nc.a.i(0);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        });
    }

    private static com.google.android.libraries.navigation.internal.mx.w h() {
        return com.google.android.libraries.navigation.internal.ms.ah.ax(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.af
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.ux.f fVar = (com.google.android.libraries.navigation.internal.ux.f) csVar;
                com.google.android.libraries.navigation.internal.nc.a aVar = am.a;
                if (fVar.k().booleanValue()) {
                    return fVar.j().booleanValue() ? am.o : am.p;
                }
                return com.google.android.libraries.navigation.internal.nc.a.i(0);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected final com.google.android.libraries.navigation.internal.mx.g a() {
        dd ddVar = new dd() { // from class: com.google.android.libraries.navigation.internal.uv.g
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).a();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        dd ddVar2 = new dd() { // from class: com.google.android.libraries.navigation.internal.uv.k
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).d();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        final dd ddVar3 = new dd() { // from class: com.google.android.libraries.navigation.internal.uv.t
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.nc.a aVar = am.a;
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).j().booleanValue() ? am.f : am.g;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        com.google.android.libraries.navigation.internal.mx.w wVarN = com.google.android.libraries.navigation.internal.ms.ah.n(new by() { // from class: com.google.android.libraries.navigation.internal.uv.w
            /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.libraries.navigation.internal.nc.ap, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v3, types: [com.google.android.libraries.navigation.internal.nc.ap, java.lang.Object] */
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.ux.f fVar = (com.google.android.libraries.navigation.internal.ux.f) csVar;
                com.google.android.libraries.navigation.internal.nc.a aVar = am.a;
                dd ddVar4 = ddVar3;
                return com.google.android.libraries.navigation.internal.af.e.d(com.google.android.libraries.navigation.internal.z.a.a(ddVar4.a(fVar), com.google.android.libraries.navigation.internal.nc.ae.d(fVar.q().intValue())), com.google.android.libraries.navigation.internal.z.a.b(ddVar4.a(fVar), com.google.android.libraries.navigation.internal.nc.ae.d(fVar.r().intValue())));
            }
        });
        com.google.android.libraries.navigation.internal.mx.w wVarN2 = com.google.android.libraries.navigation.internal.ms.ah.n(new by() { // from class: com.google.android.libraries.navigation.internal.uv.x
            /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.libraries.navigation.internal.nc.ap, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v3, types: [com.google.android.libraries.navigation.internal.nc.ap, java.lang.Object] */
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.ux.f fVar = (com.google.android.libraries.navigation.internal.ux.f) csVar;
                com.google.android.libraries.navigation.internal.nc.a aVar = am.a;
                dd ddVar4 = ddVar3;
                return com.google.android.libraries.navigation.internal.af.e.d(com.google.android.libraries.navigation.internal.z.a.a(ddVar4.a(fVar), com.google.android.libraries.navigation.internal.nc.ae.d(fVar.u().intValue())), com.google.android.libraries.navigation.internal.z.a.b(ddVar4.a(fVar), com.google.android.libraries.navigation.internal.nc.ae.d(fVar.v().intValue())));
            }
        });
        com.google.android.libraries.navigation.internal.mx.w wVarO = com.google.android.libraries.navigation.internal.ms.ah.o(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.y
            /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.libraries.navigation.internal.nc.ap, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r3v2, types: [com.google.android.libraries.navigation.internal.nc.ap, java.lang.Object] */
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.ux.f fVar = (com.google.android.libraries.navigation.internal.ux.f) csVar;
                com.google.android.libraries.navigation.internal.nc.a aVar = am.a;
                dd ddVar4 = ddVar3;
                return com.google.android.libraries.navigation.internal.af.e.d(com.google.android.libraries.navigation.internal.z.a.d(ddVar4.a(fVar)), com.google.android.libraries.navigation.internal.z.a.c(ddVar4.a(fVar)));
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        });
        return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.H(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.ai
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).p();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.ab(com.google.android.libraries.navigation.internal.nc.a.i(4)), com.google.android.libraries.navigation.internal.ms.ah.af(com.google.android.libraries.navigation.internal.ux.c.b), com.google.android.libraries.navigation.internal.ms.ah.R(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.a
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.nc.a aVar = am.a;
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).j().booleanValue() ? am.a : am.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), ch.d(com.google.android.libraries.navigation.internal.ms.e.ON_ATTACH_STATE_CHANGE_LISTENER, ddVar), ch.d(com.google.android.libraries.navigation.internal.ms.e.ON_PRE_DRAW_CALLBACK, ddVar2), new com.google.android.libraries.navigation.internal.mx.r(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.aa
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.nc.a aVar = am.a;
                return true;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.r(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.al
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).o();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.r(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.ab
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).i();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, wVarN, new com.google.android.libraries.navigation.internal.mx.r(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.ac
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).m();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, wVarN2, wVarO)), com.google.android.libraries.navigation.internal.ms.ah.o(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.z
            /* JADX WARN: Type inference failed for: r5v2, types: [com.google.android.libraries.navigation.internal.nc.ap, java.lang.Object] */
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.nc.a aVar = am.a;
                return com.google.android.libraries.navigation.internal.ae.b.c(com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.r(), am.h), com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.r(), am.h), com.google.android.libraries.navigation.internal.nc.a.i(0), ddVar3.a((com.google.android.libraries.navigation.internal.ux.f) csVar));
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), wVarO), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.J(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.d.z)), bk.b(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.m
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.nc.a aVar = am.a;
                Boolean boolK = ((com.google.android.libraries.navigation.internal.ux.f) csVar).k();
                boolK.booleanValue();
                return boolK;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.av(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.r
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.ux.f fVar = (com.google.android.libraries.navigation.internal.ux.f) csVar;
                com.google.android.libraries.navigation.internal.nc.a aVar = am.a;
                if (fVar.o().booleanValue()) {
                    return com.google.android.libraries.navigation.internal.nc.a.i(0);
                }
                return fVar.j().booleanValue() ? am.c : am.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.D(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.n
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).h();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.an(new com.google.android.libraries.navigation.internal.ms.o(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.b
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).e();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), com.google.android.libraries.navigation.internal.ms.ah.t(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.o
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).g();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ad.a.b(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.p
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).b();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.c(new bd(), new dd() { // from class: com.google.android.libraries.navigation.internal.uv.q
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).f();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0])), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.D(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.n
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).h();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.K(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.aj
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return Integer.valueOf(true == ((com.google.android.libraries.navigation.internal.ux.f) csVar).k().booleanValue() ? 2 : 1);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.y(new by() { // from class: com.google.android.libraries.navigation.internal.uv.ak
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.ux.f fVar = (com.google.android.libraries.navigation.internal.ux.f) csVar;
                return String.format(Locale.US, context.getResources().getString(com.google.android.libraries.navigation.internal.dw.h.bk) + StringUtils.SPACE + context.getResources().getQuantityString(fVar.y().intValue(), fVar.z().intValue()), fVar.B());
            }
        }), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.J(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.d.A)), bk.b(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.al
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).o();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.an(new com.google.android.libraries.navigation.internal.ms.o(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.b
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).e();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), com.google.android.libraries.navigation.internal.ms.ah.t(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.al
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).o();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.K(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.c
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return Integer.valueOf(true != ((com.google.android.libraries.navigation.internal.ux.f) csVar).k().booleanValue() ? 2 : 1);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.y(new by() { // from class: com.google.android.libraries.navigation.internal.uv.ak
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.ux.f fVar = (com.google.android.libraries.navigation.internal.ux.f) csVar;
                return String.format(Locale.US, context.getResources().getString(com.google.android.libraries.navigation.internal.dw.h.bk) + StringUtils.SPACE + context.getResources().getQuantityString(fVar.y().intValue(), fVar.z().intValue()), fVar.B());
            }
        }), com.google.android.libraries.navigation.internal.ad.a.b(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.d
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).c();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-1), com.google.android.libraries.navigation.internal.ms.ah.Y(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.u
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.ux.f fVar = (com.google.android.libraries.navigation.internal.ux.f) csVar;
                if (fVar.k().booleanValue()) {
                    return fVar.j().booleanValue() ? com.google.android.libraries.navigation.internal.nc.p.b(am.o, Float.valueOf(-1.0f)) : com.google.android.libraries.navigation.internal.nc.p.b(am.p, Float.valueOf(-1.0f));
                }
                return com.google.android.libraries.navigation.internal.nc.a.i(0);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.Q(Integer.valueOf(GravityCompat.END)), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, com.google.android.libraries.navigation.internal.ms.ah.T(-1), com.google.android.libraries.navigation.internal.ms.ah.Q(17), com.google.android.libraries.navigation.internal.ms.ah.I(17), com.google.android.libraries.navigation.internal.ms.ah.al(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.s
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.ux.f fVar = (com.google.android.libraries.navigation.internal.ux.f) csVar;
                com.google.android.libraries.navigation.internal.nc.a aVar = am.a;
                if (fVar.k().booleanValue() && fVar.j().booleanValue()) {
                    return fVar.l().booleanValue() ? am.j : am.i;
                }
                return com.google.android.libraries.navigation.internal.ux.c.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), h(), c(), com.google.android.libraries.navigation.internal.ms.ah.at(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.ah
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.nc.a aVar = am.a;
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).j().booleanValue() ? am.s : am.t;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aP(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.i.g)), com.google.android.libraries.navigation.internal.ms.ah.aS(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.v
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.nc.a aVar = am.a;
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).j().booleanValue() ? am.m : am.f630n;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aQ(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.ad
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.ux.f fVar = (com.google.android.libraries.navigation.internal.ux.f) csVar;
                com.google.android.libraries.navigation.internal.nc.a aVar = am.a;
                if (fVar.m().booleanValue()) {
                    return fVar.i().booleanValue() ? com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.nc.ae.d(fVar.s().intValue()), com.google.android.libraries.navigation.internal.nc.ae.d(fVar.t().intValue())) : com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.nc.ae.d(fVar.w().intValue()), com.google.android.libraries.navigation.internal.nc.ae.d(fVar.x().intValue()));
                }
                return com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.n(), com.google.android.libraries.navigation.internal.w.a.f());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.L(2), com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.e
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).B();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.Q(81), com.google.android.libraries.navigation.internal.ms.ah.I(17), h(), c(), com.google.android.libraries.navigation.internal.ms.ah.at(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.ag
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.nc.a aVar = am.a;
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).j().booleanValue() ? am.u : am.v;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aP(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.i.a)), com.google.android.libraries.navigation.internal.ms.ah.aS(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.l
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.nc.a aVar = am.a;
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).j().booleanValue() ? am.k : am.l;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aU(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.f
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return 1;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), new com.google.android.libraries.navigation.internal.mx.r(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.h
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.nc.a aVar = am.a;
                Boolean boolI = ((com.google.android.libraries.navigation.internal.ux.f) csVar).i();
                boolI.booleanValue();
                return boolI;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, ch.c(com.google.android.libraries.navigation.internal.ms.e.TEXT_COLOR, new by() { // from class: com.google.android.libraries.navigation.internal.uv.i
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.ux.f fVar = (com.google.android.libraries.navigation.internal.ux.f) csVar;
                com.google.android.libraries.navigation.internal.nc.a aVar = am.a;
                return com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.nc.ae.d(fVar.s().intValue()), com.google.android.libraries.navigation.internal.nc.ae.d(fVar.t().intValue()));
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aR(com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.n(), com.google.android.libraries.navigation.internal.w.a.f()))), com.google.android.libraries.navigation.internal.ms.ah.L(2), com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.uv.j
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.f) csVar).A();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })))));
    }

    @Override // com.google.android.libraries.navigation.internal.yt.e
    public final com.google.android.libraries.navigation.internal.xn.a b() {
        return w;
    }
}
