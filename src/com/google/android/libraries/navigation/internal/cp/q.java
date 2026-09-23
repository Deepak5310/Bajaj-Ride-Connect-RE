package com.google.android.libraries.navigation.internal.cp;

import android.content.res.Resources;
import com.google.android.libraries.geo.mapcore.renderer.cn;
import com.google.android.libraries.navigation.internal.adg.ex;
import com.google.android.libraries.navigation.internal.ck.av;
import com.google.android.libraries.navigation.internal.ol.aq;
import com.google.android.libraries.navigation.internal.ol.ax;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q {
    public static final r a(ax axVar, Resources resources) {
        aq aqVarF = axVar.f(ex.LEGEND_STYLE_PRIMARY_ROUTE_CONSUMED);
        aq aqVarF2 = axVar.f(ex.LEGEND_STYLE_SECONDARY_ROUTE);
        aq aqVarF3 = axVar.f(ex.LEGEND_STYLE_BIKE_LANE_SECONDARY_ROUTE);
        aq aqVarA = av.a(resources, com.google.android.libraries.navigation.internal.qr.c.a, axVar, cn.POLYLINE, 1);
        aq aqVarF4 = axVar.f(ex.LEGEND_STYLE_SECONDARY_ROUTE_STOP_AND_GO);
        aq aqVarF5 = axVar.f(ex.LEGEND_STYLE_PRIMARY_ROUTE_INACTIVE);
        aq aqVarF6 = axVar.f(ex.LEGEND_STYLE_PRIMARY_ROUTE);
        aq aqVarF7 = axVar.f(ex.LEGEND_STYLE_BIKE_LANE_PRIMARY_ROUTE);
        aq aqVarF8 = axVar.f(ex.LEGEND_STYLE_MARKED_BIKE_LANE_PRIMARY_ROUTE);
        aq aqVarA2 = av.a(resources, com.google.android.libraries.navigation.internal.qr.c.c, axVar, cn.POLYLINE, 1);
        aq aqVarF9 = axVar.f(ex.LEGEND_STYLE_PRIMARY_ROUTE_STOP_AND_GO);
        return new r(axVar, aqVarF, axVar.f(ex.LEGEND_STYLE_PRIMARY_ROUTE_CONSUMED_STOP_AND_GO), axVar.f(ex.LEGEND_STYLE_PRIMARY_ROUTE_CONSUMED_SLOW), aqVarF2, aqVarF3, aqVarA, aqVarF4, axVar.f(ex.LEGEND_STYLE_SECONDARY_ROUTE_SLOW), axVar.f(ex.LEGEND_STYLE_SECONDARY_ROUTE_STOP_AND_GO), aqVarF5, aqVarF6, aqVarF7, aqVarF8, aqVarA2, aqVarF9, axVar.f(ex.LEGEND_STYLE_PRIMARY_ROUTE_SLOW), axVar.f(ex.LEGEND_STYLE_PRIMARY_ROUTE_STOP_AND_GO), axVar.f(ex.LEGEND_STYLE_PRIMARY_ROUTE_INACTIVE_SLOW), axVar.f(ex.LEGEND_STYLE_PRIMARY_ROUTE_INACTIVE_STOP_AND_GO));
    }
}
