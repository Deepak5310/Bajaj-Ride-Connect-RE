package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.adg.ds;
import com.google.android.libraries.navigation.internal.adg.dx;
import com.google.android.libraries.navigation.internal.adg.ee;
import com.google.android.libraries.navigation.internal.adg.eo;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ak {
    public static ev a(eo eoVar) {
        int i = ev.d;
        eq eqVar = new eq();
        for (dx dxVar : eoVar.w) {
            ee eeVarB = ee.b(dxVar.b);
            if (eeVarB == null) {
                eeVarB = ee.CENTER_LEFT_TO_CENTER_RIGHT;
            }
            ds dsVarB = ds.b(dxVar.c);
            if (dsVarB == null) {
                dsVarB = ds.LEFT_JUSTIFY;
            }
            eqVar.h(new k(eeVarB, dsVarB));
        }
        return eqVar.g();
    }
}
