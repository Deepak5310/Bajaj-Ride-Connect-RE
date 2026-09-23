package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.geo.mapcore.renderer.ez;
import com.google.android.libraries.navigation.internal.afm.dh;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.mb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public abstract class cg {
    public static final cg s = x().a();

    public static cf x() {
        a aVar = new a();
        aVar.b(mb.a);
        return aVar;
    }

    public abstract cf a();

    public abstract ev b();

    public abstract ev c();

    public abstract ev d();

    public abstract ev e();

    public abstract fy f();

    public abstract com.google.android.libraries.navigation.internal.aai.f g();

    public abstract com.google.android.libraries.navigation.internal.aaj.b h();

    public abstract int hashCode();

    public abstract com.google.android.libraries.navigation.internal.aas.b i();

    public abstract com.google.android.libraries.navigation.internal.acy.b j();

    public abstract com.google.android.libraries.navigation.internal.adi.aj k();

    public abstract com.google.android.libraries.navigation.internal.aec.b l();

    public abstract com.google.android.libraries.navigation.internal.aep.c m();

    public abstract dh n();

    public abstract Boolean o();

    public abstract String p();

    public abstract String q();

    public abstract String r();

    public abstract String s();

    public abstract void t();

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.h();
        akVarB.g("highlightIdForRAP", null);
        akVarB.g("mapsEngineInfo", n());
        akVarB.g("entityForSpotlightHighlighting", null);
        akVarB.g("contextForSpotlightHighlighting", null);
        akVarB.g("spotlightClientType", null);
        akVarB.g("spotlightExperiments", d());
        akVarB.g("customRestyleDescription", p());
        akVarB.g("searchPipeMetadata", g());
        akVarB.g("buildingSelectionPipeMetadata", j());
        akVarB.g("selectedPoisForLoreRecBoosting", c());
        akVarB.g("placeViewsForLoreRecBoosting", b());
        akVarB.g("majorEventPaintRequest", k());
        akVarB.g("paintTemplateFingerprint", r());
        akVarB.g("mapviewStyleTableId", q());
        akVarB.g("travelHighlightInfo", l());
        akVarB.g("featuresForRestrictedZoneHighlighting", f());
        akVarB.g("currentUserLocation", i());
        akVarB.g("evcsVisualizationOptions", m());
        return akVarB.toString();
    }

    public abstract void u();

    public abstract void v();

    public abstract void w();

    /* JADX WARN: Code duplicated, block: B:13:0x0021  */
    public final cg y(String str, String str2, ez ezVar) {
        cf cfVarA = a();
        boolean z = ezVar == ez.DEFAULT;
        if (!z || com.google.android.libraries.navigation.internal.yx.aq.c(str)) {
            ((a) cfVarA).m = null;
            if (!z) {
                str2 = null;
            }
            ((a) cfVarA).f56n = str2;
            return cfVarA.a();
        }
        ((a) cfVarA).m = str;
        if (com.google.android.libraries.navigation.internal.yx.aq.c(str2)) {
            str2 = null;
        }
        ((a) cfVarA).f56n = str2;
        return cfVarA.a();
    }

    public final cg z(cg cgVar) {
        cf cfVarA = a();
        b bVar = (b) cgVar;
        String str = bVar.l;
        a aVar = (a) cfVarA;
        aVar.k = null;
        aVar.l = bVar.m;
        return cfVarA.a();
    }
}
