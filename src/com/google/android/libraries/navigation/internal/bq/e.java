package com.google.android.libraries.navigation.internal.bq;

import com.google.android.libraries.navigation.internal.adg.ex;
import com.google.android.libraries.navigation.internal.adg.ff;
import com.google.android.libraries.navigation.internal.adr.ee;
import com.google.android.libraries.navigation.internal.adr.fe;
import com.google.android.libraries.navigation.internal.adr.fg;
import com.google.android.libraries.navigation.internal.ol.aq;
import com.google.android.libraries.navigation.internal.ol.ax;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public final aq a;
    public final boolean b;
    public final boolean c;
    public final int d;

    private e(aq aqVar, int i) {
        this(aqVar, false, false, i);
    }

    private e(aq aqVar, boolean z, boolean z2, int i) {
        this.a = aqVar;
        this.b = z;
        this.c = z2;
        this.d = i;
    }

    public static e a(ee eeVar, ax axVar) {
        aq aqVarF = axVar.f(ex.LEGEND_STYLE_UNDEFINED);
        int i = ff.a;
        if ((eeVar.b & 1) != 0) {
            ex exVarB = ex.b(eeVar.c);
            if (exVarB == null) {
                exVarB = ex.LEGEND_STYLE_UNDEFINED;
            }
            if (exVarB != ex.LEGEND_STYLE_UNDEFINED) {
                if ((eeVar.b & 2) != 0) {
                    ex exVarB2 = ex.b(eeVar.d);
                    if (exVarB2 == null) {
                        exVarB2 = ex.LEGEND_STYLE_UNDEFINED;
                    }
                    if (exVarB2 != ex.LEGEND_STYLE_UNDEFINED) {
                        return new e(aqVarF, true, true, i);
                    }
                }
                return new e(aqVarF, true, false, i);
            }
        }
        return new e(aqVarF, i);
    }

    public static e b(fg fgVar, ax axVar) {
        if ((fgVar.b & 1) == 0) {
            return new e(axVar.f(ex.LEGEND_STYLE_PRIMARY_ROUTE_SLOW), ff.a);
        }
        fe feVar = fgVar.e;
        if (feVar == null) {
            feVar = fe.a;
        }
        ex exVarB = ex.b(feVar.c);
        if (exVarB == null) {
            exVarB = ex.LEGEND_STYLE_UNDEFINED;
        }
        aq aqVarF = axVar.f(exVarB);
        int i = (exVarB == ex.LEGEND_STYLE_JAMCIDENT || exVarB == ex.LEGEND_STYLE_ROAD_CLOSURE) ? ff.b : ff.a;
        if ((feVar.b & 2) != 0) {
            ex exVarB2 = ex.b(feVar.d);
            if (exVarB2 == null) {
                exVarB2 = ex.LEGEND_STYLE_UNDEFINED;
            }
            if (exVarB2 != ex.LEGEND_STYLE_UNDEFINED) {
                if ((feVar.b & 4) != 0) {
                    ex exVarB3 = ex.b(feVar.e);
                    if (exVarB3 == null) {
                        exVarB3 = ex.LEGEND_STYLE_UNDEFINED;
                    }
                    if (exVarB3 != ex.LEGEND_STYLE_UNDEFINED) {
                        return new e(aqVarF, true, true, i);
                    }
                }
                return new e(aqVarF, true, false, i);
            }
        }
        return new e(aqVarF, i);
    }
}
