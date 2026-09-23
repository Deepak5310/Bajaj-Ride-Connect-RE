package com.google.android.libraries.navigation.internal.abt;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.abf.q;
import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.afm.am;
import com.google.android.libraries.navigation.internal.afm.an;
import com.google.android.libraries.navigation.internal.afm.aq;
import com.google.android.libraries.navigation.internal.afm.ay;
import com.google.android.libraries.navigation.internal.afm.bc;
import com.google.android.libraries.navigation.internal.afm.bd;
import com.google.android.libraries.navigation.internal.afm.z;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static final c a = new c();
    public final String b;
    public final e c;
    public final LatLng d;
    public final Boolean e;
    public final String f;
    public final Integer g;
    public final Integer h;
    public final Integer i;
    public final ev j;
    public final Float k;
    public final Float l;
    public final ev m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ev f152n;
    private final String o;
    private final Boolean p;
    private final Boolean q;
    private final Integer r;
    private final Integer s;
    private final n t;
    private final com.google.android.libraries.navigation.internal.abu.a u;

    private c() {
        this.b = null;
        this.o = null;
        this.c = null;
        this.p = null;
        this.q = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.r = null;
        this.h = null;
        this.i = null;
        this.s = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.t = null;
        this.m = null;
        this.f152n = null;
        this.u = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String str, bd bdVar, com.google.android.libraries.navigation.internal.abu.a aVar) {
        int i;
        int i2;
        s.k(aVar, "DepthMap");
        aq aqVar = bdVar.c;
        aqVar = aqVar == null ? aq.a : aqVar;
        ay ayVar = bdVar.d;
        ayVar = ayVar == null ? ay.a : ayVar;
        an anVar = bdVar.e;
        anVar = anVar == null ? an.a : anVar;
        this.b = str == null ? aqVar.j : str;
        this.o = aqVar.j;
        this.p = Boolean.valueOf(aqVar.c);
        bc bcVarB = bc.b(aqVar.s);
        this.q = Boolean.valueOf(r.a(bcVarB == null ? bc.OUTDOOR : bcVarB, bc.INDOOR));
        z zVar = aqVar.l;
        zVar = zVar == null ? z.a : zVar;
        s.k(zVar, "MapPointProto");
        this.d = new LatLng(com.google.android.libraries.navigation.internal.abw.k.c(zVar.c), com.google.android.libraries.navigation.internal.abw.k.c(zVar.d));
        this.e = Boolean.valueOf((aqVar.b & 1024) != 0);
        this.f = aqVar.m;
        Integer numValueOf = Integer.valueOf(aqVar.f);
        this.g = numValueOf;
        Integer numValueOf2 = Integer.valueOf(aqVar.g);
        this.r = numValueOf2;
        Integer numValueOf3 = Integer.valueOf(aqVar.h);
        this.h = numValueOf3;
        Integer numValueOf4 = Integer.valueOf(aqVar.i);
        this.i = numValueOf4;
        int iIntValue = numValueOf.intValue();
        int iIntValue2 = numValueOf2.intValue();
        int iIntValue3 = numValueOf3.intValue();
        int iIntValue4 = numValueOf4.intValue();
        s.b(iIntValue > 0, "panoramaWidthPx = %s", numValueOf);
        s.b(iIntValue2 > 0, "panoramaHeightPx = %s", numValueOf2);
        s.b(iIntValue3 > 0, "tileWidthPx = %s", numValueOf3);
        s.b(iIntValue4 > 0, "tileHeightPx = %s", numValueOf4);
        this.s = Integer.valueOf((iIntValue3 < iIntValue || iIntValue4 < iIntValue2) ? Math.max(0, (int) Math.ceil(com.google.android.libraries.navigation.internal.abw.k.k(Math.max(iIntValue / iIntValue3, iIntValue2 / iIntValue4)))) : 0);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            Integer num = this.s;
            if (i3 > num.intValue()) {
                break;
            }
            int iIntValue5 = num.intValue() - i3;
            arrayList.add(new q(Integer.valueOf(this.g.intValue() >> iIntValue5), Integer.valueOf(this.r.intValue() >> iIntValue5)));
            i3++;
        }
        ev evVarO = ev.o(arrayList);
        this.j = evVarO;
        q qVar = (q) evVarO.get(0);
        this.c = new e(this.b, 0, 0, 0, ((Integer) qVar.a).intValue(), ((Integer) qVar.b).intValue());
        int i4 = ayVar.b;
        float fC = -90.0f;
        if ((i4 & 64) != 0 && (i2 = ayVar.i) != 0) {
            fC = (float) com.google.android.libraries.navigation.internal.abw.k.c(i2);
        }
        float fC2 = 90.0f;
        if ((i4 & 128) != 0 && (i = ayVar.j) != 0) {
            fC2 = (float) com.google.android.libraries.navigation.internal.abw.k.c(i);
        }
        this.k = Float.valueOf(com.google.android.libraries.navigation.internal.abw.k.j(Math.min(fC, fC2)));
        this.l = Float.valueOf(com.google.android.libraries.navigation.internal.abw.k.j(Math.max(fC, fC2)));
        this.t = new n(this.b, (float) com.google.android.libraries.navigation.internal.abw.k.c(ayVar.c), (float) com.google.android.libraries.navigation.internal.abw.k.b(ayVar.d), com.google.android.libraries.navigation.internal.abw.k.j((float) com.google.android.libraries.navigation.internal.abw.k.c(ayVar.e)));
        bz bzVar = anVar.e;
        b[] bVarArr = new b[bzVar.size()];
        j[] jVarArr = new j[bzVar.size()];
        for (int i5 = 0; i5 < bzVar.size(); i5++) {
            am amVar = (am) bzVar.get(i5);
            String str2 = amVar.d;
            float fB = (float) com.google.android.libraries.navigation.internal.abw.k.b(amVar.c);
            bVarArr[i5] = new b(str2, fB, amVar.e);
            jVarArr[i5] = new j(amVar.f, fB);
        }
        this.m = ev.p(bVarArr);
        this.f152n = ev.p(jVarArr);
        this.u = aVar;
    }

    public final int a() {
        s.d(!i(), "NULL_TARGET");
        return this.r.intValue();
    }

    public final int b() {
        s.d(!i(), "NULL_TARGET");
        return this.s.intValue();
    }

    public final int c() {
        s.d(!i(), "NULL_TARGET");
        return this.i.intValue();
    }

    public final int d() {
        s.d(!i(), "NULL_TARGET");
        return this.h.intValue();
    }

    public final StreetViewPanoramaLocation e() {
        s.d(!i(), "NULL_TARGET");
        return new StreetViewPanoramaLocation((StreetViewPanoramaLink[]) this.m.toArray(new StreetViewPanoramaLink[0]), this.d, this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            return r.a(this.b, ((c) obj).b);
        }
        return false;
    }

    public final n f() {
        s.d(!i(), "NULL_TARGET");
        return this.t;
    }

    public final com.google.android.libraries.navigation.internal.abu.a g() {
        s.d(!i(), "NULL_TARGET");
        return this.u;
    }

    public final boolean h() {
        s.d(!i(), "NULL_TARGET");
        return this.q.booleanValue();
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b});
    }

    public final boolean i() {
        return this == a;
    }

    public final String toString() {
        if (i()) {
            return "StreetViewPanoTarget[NULL]";
        }
        aj ajVarF = aj.f(this);
        ajVarF.g("imageKey", null);
        ajVarF.g("panoId", this.b);
        ajVarF.g("protoPanoId", this.o);
        ajVarF.g("isDisabled", this.p);
        ajVarF.g("isIndoor", this.q);
        ajVarF.g("latLng", this.d);
        ajVarF.g("copyrightStr", this.f);
        ajVarF.g("originalImageWidthPx", this.g);
        ajVarF.g("originalImageHeightPx", this.r);
        ajVarF.g("tileWidthPx", this.h);
        ajVarF.g("tileHeightPx", this.i);
        ajVarF.g("originalImageMaxTileZoom", this.s);
        ajVarF.g("minTiltVisibleDeg", this.k);
        ajVarF.g("maxTiltVisibleDeg", this.l);
        ajVarF.g("worldSceneOrientation", this.t);
        ajVarF.g("links", this.m);
        ajVarF.g("roadLabels", this.f152n);
        ajVarF.g("zoomedImageWidthHeightPx", this.j);
        ajVarF.g("depthMap", this.u);
        return ajVarF.toString();
    }
}
