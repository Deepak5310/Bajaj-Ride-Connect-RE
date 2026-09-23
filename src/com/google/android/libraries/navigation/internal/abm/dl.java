package com.google.android.libraries.navigation.internal.abm;

import android.view.View;
import com.google.android.gms.maps.model.TileProvider;
import com.google.android.libraries.navigation.internal.abh.er;
import com.google.android.libraries.navigation.internal.abh.es;
import com.google.android.libraries.navigation.internal.abh.ey;
import com.google.android.libraries.navigation.internal.abh.fn;
import com.google.android.libraries.navigation.internal.abh.fo;
import com.google.android.libraries.navigation.internal.abh.fx;
import com.google.android.libraries.navigation.internal.abh.fy;
import com.google.android.libraries.navigation.internal.abh.fz;
import com.google.android.libraries.navigation.internal.abh.hn;
import com.google.android.libraries.navigation.internal.abh.ho;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.fw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dl implements fo, ey, com.google.android.libraries.navigation.internal.ol.am {
    public final View a;
    public final cz b;
    final Map c;
    final List d;
    int e;
    an f;
    de g;
    private final float h;
    private final com.google.android.libraries.navigation.internal.ol.z i;
    private final com.google.android.libraries.navigation.internal.on.h j;
    private final com.google.android.libraries.navigation.internal.abh.ac k;
    private final dk l;

    public dl(float f, View view, com.google.android.libraries.navigation.internal.ol.z zVar, com.google.android.libraries.navigation.internal.on.h hVar, com.google.android.libraries.navigation.internal.abh.ac acVar, cz czVar) {
        dk dkVar = dk.a;
        this.c = new HashMap();
        this.d = new ArrayList();
        this.h = f;
        com.google.android.libraries.navigation.internal.abf.s.k(view, "mapView");
        this.a = view;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "googleMapV2");
        this.i = zVar;
        this.j = hVar;
        this.k = acVar;
        this.b = czVar;
        this.l = dkVar;
        synchronized (this) {
            this.e = Integer.MIN_VALUE;
            this.f = null;
            this.g = null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.am
    public final synchronized void a(com.google.android.libraries.navigation.internal.px.ci ciVar) {
        com.google.android.libraries.navigation.internal.ol.ap apVarC;
        this.d.clear();
        for (com.google.android.libraries.navigation.internal.ol.ao aoVar : ciVar.a.values()) {
            if (aoVar != null && ((apVarC = aoVar.c()) == com.google.android.libraries.navigation.internal.ol.ap.PLACED_FULLY || apVarC == com.google.android.libraries.navigation.internal.ol.ap.SECONDARY_HIDDEN || apVarC == com.google.android.libraries.navigation.internal.ol.ap.TERTIARY_HIDDEN || apVarC == com.google.android.libraries.navigation.internal.ol.ap.SECONDARY_AND_TERTIARY_HIDDEN)) {
                ef efVarG = aoVar.g();
                if (!aoVar.i()) {
                    List list = this.d;
                    com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.U);
                    efVarG.h(bhVarS);
                    Object objK = efVarG.w.k(bhVarS.d);
                    list.add(((fw) (objK == null ? bhVarS.b : bhVarS.c(objK))).c);
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ey
    public final er b(es esVar) {
        return new de(this.i, this, esVar, this.k);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ey
    public final List c() {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            for (String str : this.d) {
                de deVar = (de) this.c.get(str);
                if (deVar != null) {
                    arrayList.add(new dj(str, deVar.a.c(), deVar.l(), Integer.parseInt(deVar.a.a.substring(1))));
                }
            }
        }
        Collections.sort(arrayList, dj.a);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            de deVar2 = (de) this.c.get(((dj) arrayList.get(i)).b);
            if (deVar2 != null) {
                arrayList2.add(deVar2.a);
            }
        }
        return arrayList2;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ey
    public final List d() {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator it2 = this.d.iterator();
            while (it2.hasNext()) {
                de deVar = (de) this.c.get((String) it2.next());
                if (deVar != null) {
                    arrayList.add(deVar.a);
                }
            }
        }
        return arrayList;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fo
    public final com.google.android.libraries.navigation.internal.abh.cq e(com.google.android.libraries.navigation.internal.abh.cr crVar) {
        ae aeVar = new ae(this.i, crVar, j());
        aeVar.f.a();
        boolean z = aeVar.j;
        boolean z2 = false;
        if (!z && !aeVar.k) {
            z2 = true;
        }
        com.google.android.libraries.navigation.internal.abf.s.e(z2, "isInitialized=%s isRemoved=%s", Boolean.valueOf(z), Boolean.valueOf(aeVar.k));
        com.google.android.libraries.navigation.internal.adg.ap apVar = aeVar.h;
        int i = aeVar.g;
        if (!apVar.b.H()) {
            apVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.aq aqVar = (com.google.android.libraries.navigation.internal.adg.aq) apVar.b;
        com.google.android.libraries.navigation.internal.adg.aq aqVar2 = com.google.android.libraries.navigation.internal.adg.aq.a;
        aqVar.b |= 512;
        aqVar.k = i;
        aeVar.e();
        com.google.android.libraries.navigation.internal.adg.ap apVar2 = aeVar.h;
        int iA = aeVar.e.a(aeVar.c, aeVar.d.C(), aeVar.d.B());
        if (!apVar2.b.H()) {
            apVar2.v();
        }
        com.google.android.libraries.navigation.internal.adg.aq aqVar3 = (com.google.android.libraries.navigation.internal.adg.aq) apVar2.b;
        aqVar3.b |= 128;
        aqVar3.i = iA;
        aeVar.i.c((com.google.android.libraries.navigation.internal.adg.aq) aeVar.h.t(), ae.a, aeVar.d(), aeVar.c());
        aeVar.j = true;
        return aeVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fo
    public final fn f(com.google.android.libraries.navigation.internal.abh.au auVar) {
        ds dsVar = new ds(this.h, this.i, auVar, j());
        dsVar.e();
        return dsVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fo
    public final fn g(fx fxVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(fxVar, "model");
        ds dsVar = new ds(this.h, this.i, fxVar, j());
        dsVar.e();
        return dsVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fo
    public final fy h(fz fzVar) {
        dx dxVar = new dx(this.h, this.i, fzVar, this.j, j());
        if (!dxVar.d) {
            dxVar.e();
            dxVar.f(null);
        }
        return dxVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fo
    public final hn i(ho hoVar) {
        ec ecVar = new ec(this.i, hoVar, j());
        ecVar.c.a();
        if (ecVar.f == null) {
            com.google.android.libraries.navigation.internal.ol.z zVar = ecVar.a;
            ho hoVar2 = ecVar.b;
            TileProvider tileProvider = hoVar2.c;
            com.google.android.libraries.navigation.internal.ol.aj ajVarC = zVar.c();
            com.google.android.libraries.navigation.internal.abf.s.k(tileProvider, "tileProvider");
            String strConcat = "mapview-tileoverlay-".concat(String.valueOf(hoVar2.a));
            com.google.android.libraries.navigation.internal.abf.s.k(strConcat, "tileProviderNameForPhoenix");
            d dVar = new d(strConcat, tileProvider);
            ho hoVar3 = ecVar.b;
            ecVar.f = ajVarC.a(dVar, hoVar3.p(), ecVar.e);
            ecVar.b();
            ecVar.a();
        }
        return ecVar;
    }

    final synchronized int j() {
        int i;
        i = this.e;
        if (i == 2147483644) {
            this.e = Integer.MIN_VALUE;
        } else {
            this.e = i + 1;
        }
        return i;
    }

    public final void k() {
        an anVar;
        de deVar;
        synchronized (this) {
            anVar = this.f;
            deVar = this.g;
        }
        if (anVar == null || anVar.c == null) {
            return;
        }
        l(anVar, deVar);
    }

    public final void l(final an anVar, de deVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(anVar, "infoWindowRenderer");
        com.google.android.libraries.navigation.internal.abf.s.k(deVar, "markerRenderer");
        anVar.d();
        anVar.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abm.al
            @Override // java.lang.Runnable
            public final void run() {
                es esVar = anVar.a;
                esVar.b.g(esVar);
            }
        });
        com.google.android.libraries.navigation.internal.adg.dy dyVar = deVar.e;
        if (((ef) dyVar.b).f186n != 2147483645) {
            if (!dyVar.b.H()) {
                dyVar.v();
            }
            ef efVar = (ef) dyVar.b;
            efVar.b |= 16384;
            efVar.f186n = 2147483645;
            deVar.n();
        }
        synchronized (this) {
            if (this.f == anVar) {
                this.f = null;
                this.g = null;
            } else {
                com.google.android.libraries.navigation.internal.abf.p.a(5, "closing unexpected info window", new Object[0]);
            }
        }
    }

    public final void m(an anVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(anVar, "infoWindowRenderer");
        View view = this.a;
        int width = view.getWidth();
        int height = view.getHeight();
        anVar.d();
        anVar.c(width, height);
        anVar.e();
    }

    public final synchronized boolean n(an anVar) {
        return anVar == this.f && anVar.c != null;
    }
}
