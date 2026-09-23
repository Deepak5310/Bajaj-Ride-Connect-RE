package com.google.android.libraries.navigation.internal.ck;

import android.content.Context;
import android.content.res.Resources;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.android.libraries.navigation.internal.adg.ex;
import com.google.android.libraries.navigation.internal.adr.im;
import com.google.android.libraries.navigation.internal.afl.qj;
import com.google.android.libraries.navigation.internal.yz.de;
import java.util.EnumMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ar {
    private static final com.google.android.libraries.navigation.internal.zb.j r = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.ck.ar");
    public final com.google.android.libraries.navigation.internal.yx.br a;
    public final com.google.android.libraries.navigation.internal.ed.b b;
    public final com.google.android.libraries.navigation.internal.afo.a c;
    public final boolean d;
    public final boolean e;
    public final com.google.android.libraries.navigation.internal.yx.br f;
    public final com.google.android.libraries.navigation.internal.yx.br g;
    public final com.google.android.libraries.navigation.internal.yx.br h;
    public final com.google.android.libraries.navigation.internal.yx.br i;
    public final com.google.android.libraries.navigation.internal.yx.br j;
    public final com.google.android.libraries.navigation.internal.yx.br k;
    public final com.google.android.libraries.navigation.internal.yx.br l;
    public final com.google.android.libraries.navigation.internal.yx.br m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.libraries.navigation.internal.yx.br f366n;
    public final com.google.android.libraries.navigation.internal.yx.an o;
    public final k p;
    public final bp q;

    public ar(final com.google.android.libraries.navigation.internal.afo.a aVar, final com.google.android.libraries.navigation.internal.afo.a aVar2, final Context context, com.google.android.libraries.navigation.internal.ed.b bVar, bp bpVar, com.google.android.libraries.navigation.internal.fz.d dVar, final com.google.android.libraries.navigation.internal.yx.an anVar) {
        this.b = bVar;
        this.c = aVar2;
        this.q = bpVar;
        this.d = dVar.D() != null && dVar.D().d;
        this.e = false;
        qj qjVarW = dVar.W();
        final boolean z = qjVarW != null ? qjVarW.J : false;
        this.f = new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.ck.ae
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                boolean z2 = z;
                return ar.c(z2 ? com.google.android.libraries.navigation.internal.qr.c.f : com.google.android.libraries.navigation.internal.qr.c.c, ar.a(z2), com.google.android.libraries.navigation.internal.qr.c.a, context.getResources(), (com.google.android.libraries.navigation.internal.ol.ax) aVar2.a(), 1);
            }
        };
        this.g = new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.ck.ah
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                com.google.android.libraries.navigation.internal.afo.a aVar3 = aVar2;
                Context context2 = context;
                boolean z2 = z;
                return ar.c(ar.b(z2), ar.b(z2), com.google.android.libraries.navigation.internal.qr.c.b, context2.getResources(), (com.google.android.libraries.navigation.internal.ol.ax) aVar3.a(), 1);
            }
        };
        this.h = new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.ck.ai
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                com.google.android.libraries.navigation.internal.afo.a aVar3 = aVar2;
                return ar.c(com.google.android.libraries.navigation.internal.qr.c.s, com.google.android.libraries.navigation.internal.qr.c.t, com.google.android.libraries.navigation.internal.qr.c.q, context.getResources(), (com.google.android.libraries.navigation.internal.ol.ax) aVar3.a(), 2);
            }
        };
        this.i = new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.ck.aj
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                com.google.android.libraries.navigation.internal.afo.a aVar3 = aVar2;
                Context context2 = context;
                boolean z2 = z;
                return ar.c(ar.a(z2), ar.a(z2), com.google.android.libraries.navigation.internal.qr.c.a, context2.getResources(), (com.google.android.libraries.navigation.internal.ol.ax) aVar3.a(), 1);
            }
        };
        this.j = new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.ck.ak
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                com.google.android.libraries.navigation.internal.afo.a aVar3 = aVar2;
                return ar.c(com.google.android.libraries.navigation.internal.qr.c.s, com.google.android.libraries.navigation.internal.qr.c.t, com.google.android.libraries.navigation.internal.qr.c.r, context.getResources(), (com.google.android.libraries.navigation.internal.ol.ax) aVar3.a(), 2);
            }
        };
        this.k = new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.ck.al
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                com.google.android.libraries.navigation.internal.afo.a aVar3 = aVar2;
                Context context2 = context;
                boolean z2 = z;
                return ar.c(ar.b(z2), ar.b(z2), com.google.android.libraries.navigation.internal.qr.c.b, context2.getResources(), (com.google.android.libraries.navigation.internal.ol.ax) aVar3.a(), 1);
            }
        };
        this.l = new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.ck.am
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                com.google.android.libraries.navigation.internal.afo.a aVar3 = aVar2;
                return ci.c(((com.google.android.libraries.navigation.internal.ol.ax) aVar3.a()).f(ex.LEGEND_STYLE_PRIMARY_ROUTE), ((com.google.android.libraries.navigation.internal.ol.ax) aVar3.a()).f(ex.LEGEND_STYLE_PRIMARY_ROUTE_INACTIVE), ((com.google.android.libraries.navigation.internal.ol.ax) aVar3.a()).f(ex.LEGEND_STYLE_SECONDARY_ROUTE));
            }
        };
        this.m = new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.ck.an
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                com.google.android.libraries.navigation.internal.ol.ax axVar = (com.google.android.libraries.navigation.internal.ol.ax) aVar2.a();
                ex exVar = cp.a;
                com.google.android.libraries.navigation.internal.aac.ca caVar = new com.google.android.libraries.navigation.internal.aac.ca();
                EnumMap enumMap = new EnumMap(im.class);
                EnumMap enumMap2 = new EnumMap(im.class);
                EnumMap enumMap3 = new EnumMap(im.class);
                EnumMap enumMap4 = new EnumMap(im.class);
                com.google.android.libraries.navigation.internal.ol.aq aqVarF = axVar.f(cp.a);
                enumMap.put(im.UNKNOWN_STYLE, aqVarF);
                enumMap.put(im.TRAFFIC_JAM, axVar.f(cp.b));
                enumMap.put(im.SLOWER_TRAFFIC, axVar.f(cp.c));
                com.google.android.libraries.navigation.internal.ol.aq aqVarF2 = axVar.f(cp.d);
                enumMap2.put(im.UNKNOWN_STYLE, aqVarF2);
                enumMap2.put(im.TRAFFIC_JAM, axVar.f(cp.e));
                enumMap2.put(im.SLOWER_TRAFFIC, axVar.f(cp.f));
                com.google.android.libraries.navigation.internal.ol.aq aqVarF3 = axVar.f(cp.g);
                enumMap3.put(im.UNKNOWN_STYLE, aqVarF3);
                enumMap3.put(im.TRAFFIC_JAM, axVar.f(cp.h));
                enumMap3.put(im.SLOWER_TRAFFIC, axVar.f(cp.i));
                com.google.android.libraries.navigation.internal.ol.aq aqVarF4 = axVar.f(cp.j);
                enumMap4.put(im.UNKNOWN_STYLE, aqVarF4);
                enumMap4.put(im.TRAFFIC_JAM, axVar.f(cp.k));
                enumMap4.put(im.SLOWER_TRAFFIC, axVar.f(cp.l));
                com.google.android.libraries.navigation.internal.yu.c.d(com.google.android.libraries.navigation.internal.aac.az.e(av.b(aqVarF), av.b(aqVarF2), av.b(aqVarF3), av.b(aqVarF4)), new co(caVar, enumMap, aqVarF, enumMap2, aqVarF2, enumMap3, aqVarF3, enumMap4, aqVarF4), com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
                return caVar;
            }
        };
        this.f366n = new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.ck.ao
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return com.google.android.libraries.navigation.internal.aac.az.h(new ct((com.google.android.libraries.navigation.internal.ol.ax) aVar2.a()));
            }
        };
        this.o = com.google.android.libraries.navigation.internal.yx.an.j(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.ck.af
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                final com.google.android.libraries.navigation.internal.cp.r rVarA = com.google.android.libraries.navigation.internal.cp.q.a((com.google.android.libraries.navigation.internal.ol.ax) aVar2.a(), context.getResources());
                return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: com.google.android.libraries.navigation.internal.ck.bt
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                        com.google.android.libraries.navigation.internal.cp.r rVar = rVarA;
                        com.google.android.libraries.navigation.internal.yu.c.d(com.google.android.libraries.navigation.internal.aac.az.d(de.d(rVar.b()).e(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.ck.bu
                            @Override // com.google.android.libraries.navigation.internal.yx.aa
                            public final Object ak(Object obj) {
                                return av.b((com.google.android.libraries.navigation.internal.ol.aq) obj);
                            }
                        }).f()), new bv(completer, rVar), com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
                        return "RouteDecorationPolylineStylesImpl future";
                    }
                });
            }
        });
        this.p = new p((com.google.android.libraries.navigation.internal.ol.ax) aVar2.a());
        this.a = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.ck.ag
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return new com.google.android.libraries.navigation.internal.on.h((com.google.android.libraries.navigation.internal.ol.z) aVar.a());
            }
        });
    }

    public static int a(boolean z) {
        return z ? com.google.android.libraries.navigation.internal.qr.c.e : com.google.android.libraries.navigation.internal.qr.c.d;
    }

    public static int b(boolean z) {
        return z ? com.google.android.libraries.navigation.internal.qr.c.h : com.google.android.libraries.navigation.internal.qr.c.g;
    }

    public static com.google.android.libraries.navigation.internal.aac.bj c(int i, int i2, int i3, Resources resources, com.google.android.libraries.navigation.internal.ol.ax axVar, int i4) {
        return ci.c(av.a(resources, i, axVar, com.google.android.libraries.geo.mapcore.renderer.cn.POLYLINE, i4), av.a(resources, i2, axVar, com.google.android.libraries.geo.mapcore.renderer.cn.POLYLINE_DIMMED, i4), av.a(resources, i3, axVar, com.google.android.libraries.geo.mapcore.renderer.cn.POLYLINE_DEACTIVATED_WITH_STAMPS, i4));
    }
}
