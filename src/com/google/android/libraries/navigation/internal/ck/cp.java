package com.google.android.libraries.navigation.internal.ck;

import com.google.android.libraries.navigation.internal.adg.ex;
import com.google.android.libraries.navigation.internal.adr.fe;
import com.google.android.libraries.navigation.internal.adr.fg;
import com.google.android.libraries.navigation.internal.adr.im;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class cp implements cn {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Map f368n;
    private final com.google.android.libraries.navigation.internal.ol.aq o;
    private final Map p;
    private final com.google.android.libraries.navigation.internal.ol.aq q;
    private final Map r;
    private final com.google.android.libraries.navigation.internal.ol.aq s;
    private final Map t;
    private final com.google.android.libraries.navigation.internal.ol.aq u;
    private static final com.google.android.libraries.navigation.internal.zb.j m = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.ck.cp");
    public static final ex a = ex.LEGEND_STYLE_PRIMARY_ROUTE;
    public static final ex b = ex.LEGEND_STYLE_PRIMARY_ROUTE_STOP_AND_GO;
    public static final ex c = ex.LEGEND_STYLE_PRIMARY_ROUTE_SLOW;
    public static final ex d = ex.LEGEND_STYLE_PRIMARY_ROUTE_INACTIVE;
    public static final ex e = ex.LEGEND_STYLE_PRIMARY_ROUTE_INACTIVE_STOP_AND_GO;
    public static final ex f = ex.LEGEND_STYLE_PRIMARY_ROUTE_INACTIVE_SLOW;
    public static final ex g = ex.LEGEND_STYLE_SECONDARY_ROUTE;
    public static final ex h = ex.LEGEND_STYLE_SECONDARY_ROUTE_STOP_AND_GO;
    public static final ex i = ex.LEGEND_STYLE_SECONDARY_ROUTE_SLOW;
    public static final ex j = ex.LEGEND_STYLE_PRIMARY_ROUTE_CONSUMED;
    public static final ex k = ex.LEGEND_STYLE_PRIMARY_ROUTE_CONSUMED_STOP_AND_GO;
    public static final ex l = ex.LEGEND_STYLE_PRIMARY_ROUTE_CONSUMED_SLOW;

    public cp(Map map, com.google.android.libraries.navigation.internal.ol.aq aqVar, Map map2, com.google.android.libraries.navigation.internal.ol.aq aqVar2, Map map3, com.google.android.libraries.navigation.internal.ol.aq aqVar3, Map map4, com.google.android.libraries.navigation.internal.ol.aq aqVar4) {
        this.f368n = map;
        this.o = aqVar;
        this.p = map2;
        this.q = aqVar2;
        this.r = map3;
        this.s = aqVar3;
        this.t = map4;
        this.u = aqVar4;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.as
    public final void a(com.google.android.libraries.navigation.internal.ol.ax axVar) {
        axVar.j(this.o);
        axVar.j(this.q);
        axVar.j(this.s);
        axVar.j(this.u);
    }

    @Override // com.google.android.libraries.navigation.internal.ck.as
    public final cm b(aq aqVar) {
        return new bk(this, aqVar.a, aqVar.b, new cq(aqVar.c, this));
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cn
    public final com.google.android.libraries.navigation.internal.ol.aq c(im imVar) {
        return this.t.containsKey(imVar) ? (com.google.android.libraries.navigation.internal.ol.aq) this.t.get(imVar) : this.u;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cn
    public final com.google.android.libraries.navigation.internal.ol.aq d(im imVar) {
        return this.f368n.containsKey(imVar) ? (com.google.android.libraries.navigation.internal.ol.aq) this.f368n.get(imVar) : this.o;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cn
    public final com.google.android.libraries.navigation.internal.ol.aq e(im imVar) {
        return this.p.containsKey(imVar) ? (com.google.android.libraries.navigation.internal.ol.aq) this.p.get(imVar) : this.q;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cn
    public final com.google.android.libraries.navigation.internal.ol.aq f(im imVar) {
        return this.r.containsKey(imVar) ? (com.google.android.libraries.navigation.internal.ol.aq) this.r.get(imVar) : this.s;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cn
    public final ex g(fg fgVar) {
        fe feVar = fgVar.e;
        if (feVar == null) {
            feVar = fe.a;
        }
        ex exVarB = ex.b(feVar.c);
        if (exVarB == null) {
            exVarB = ex.LEGEND_STYLE_UNDEFINED;
        }
        return exVarB == ex.LEGEND_STYLE_UNDEFINED ? ex.LEGEND_STYLE_JAMCIDENT_PRIMARY_ROUTE : exVarB;
    }
}
