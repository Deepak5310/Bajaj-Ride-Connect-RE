package com.google.android.libraries.navigation.internal.abh;

import com.google.android.gms.maps.model.FeatureType;
import com.google.android.libraries.navigation.internal.yz.mb;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dw extends com.google.android.libraries.navigation.internal.lz.m {
    public String c;
    private final int f;
    private final bm e = null;
    public final boolean a = false;
    public final boolean b = false;
    final ArrayList d = new ArrayList();

    public dw(int i, bm bmVar) {
        this.f = i;
        if (!com.google.android.libraries.navigation.internal.afu.v.a.a().b()) {
            return;
        }
        com.google.android.libraries.navigation.internal.zp.ah ahVar = (com.google.android.libraries.navigation.internal.zp.ah) com.google.android.libraries.navigation.internal.zp.ai.a.q();
        if (!ahVar.b.H()) {
            ahVar.v();
        }
        com.google.android.libraries.navigation.internal.zp.ai aiVar = (com.google.android.libraries.navigation.internal.zp.ai) ahVar.b;
        aiVar.b |= 1;
        aiVar.c = false;
        if (!ahVar.b.H()) {
            ahVar.v();
        }
        com.google.android.libraries.navigation.internal.zp.ai aiVar2 = (com.google.android.libraries.navigation.internal.zp.ai) ahVar.b;
        aiVar2.b |= 2;
        aiVar2.d = false;
    }

    public final Set a() {
        return mb.a;
    }

    public final Set b() {
        return mb.a;
    }

    final void c(com.google.android.libraries.navigation.internal.ly.at atVar) {
        this.d.add(atVar);
    }

    final boolean e(String str) {
        return false;
    }

    final boolean f(String str) {
        return false;
    }

    final void d(String str, String str2, String str3) {
        String strConcat;
        if (this.f != 3) {
            strConcat = "%s: The map is initialized without a valid Map ID, that will prevent use of data-driven styling.";
        } else if (a().isEmpty() && b().isEmpty()) {
            strConcat = "%s: The Map Style does not have any Datasets or FeatureLayers configured for data-driven styling.";
        } else if (str2 == null || e(str2)) {
            strConcat = (str.equals(FeatureType.DATASET) || f(str)) ? "" : "%s: The Map Style does not have the following FeatureLayer configured for data-driven styling: ".concat(String.valueOf(str));
        } else {
            strConcat = "%s: The Map Style does not have the following Dataset ID associated with it: ".concat(str2);
        }
        if (strConcat.isEmpty()) {
            return;
        }
        com.google.android.libraries.navigation.internal.abf.p.c(String.format(strConcat, "FeatureLayer"));
    }
}
