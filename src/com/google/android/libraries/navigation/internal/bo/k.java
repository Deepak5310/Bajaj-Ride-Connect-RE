package com.google.android.libraries.navigation.internal.bo;

import com.google.android.libraries.geo.mapcore.renderer.cl;
import com.google.android.libraries.geo.mapcore.renderer.cn;
import com.google.android.libraries.navigation.internal.adg.bv;
import com.google.android.libraries.navigation.internal.adg.bw;
import com.google.android.libraries.navigation.internal.adg.cz;
import com.google.android.libraries.navigation.internal.adg.da;
import com.google.android.libraries.navigation.internal.adg.db;
import com.google.android.libraries.navigation.internal.adg.fd;
import com.google.android.libraries.navigation.internal.adg.fg;
import com.google.android.libraries.navigation.internal.adg.fj;
import com.google.android.libraries.navigation.internal.adg.fk;
import com.google.android.libraries.navigation.internal.adg.fx;
import com.google.android.libraries.navigation.internal.adg.ga;
import com.google.android.libraries.navigation.internal.adg.ic;
import com.google.android.libraries.navigation.internal.adg.id;
import com.google.android.libraries.navigation.internal.adg.jr;
import com.google.android.libraries.navigation.internal.po.Cdo;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.no;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k {
    public static final /* synthetic */ int e = 0;
    private static final int[] f = {6, 10, 14, 20};
    private static final int[] g = {2, 3, 5, 8, 14, 20};
    private static final int[] h = {0, 4, 8, 16, 18, 21};
    public final com.google.android.libraries.navigation.internal.ol.z a;
    public final com.google.android.libraries.navigation.internal.ol.s b;
    public final com.google.android.libraries.navigation.internal.ol.s c;
    public final List d = new ArrayList();

    public k(com.google.android.libraries.navigation.internal.ol.z zVar, List list, com.google.android.libraries.navigation.internal.ol.s sVar, com.google.android.libraries.navigation.internal.ol.s sVar2) {
        this.a = zVar;
        this.b = sVar;
        this.c = sVar2;
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            double[] dArrA = com.google.android.libraries.navigation.internal.on.h.a(((com.google.android.libraries.navigation.internal.oe.ad) it2.next()).q());
            this.d.add(new j(c(zVar, dArrA, 1, this.b), c(zVar, dArrA, 0, this.c)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static com.google.android.libraries.navigation.internal.ol.s a(com.google.android.libraries.navigation.internal.ol.z zVar, int i, String str, String str2, boolean z) {
        if (z) {
            ar.a(true);
        }
        List<com.google.android.libraries.navigation.internal.br.e> listB = com.google.android.libraries.navigation.internal.br.f.b(z ? g : f, true != z ? 1.0f : 2.8f, z ? h : com.google.android.libraries.navigation.internal.br.f.a);
        bv bvVar = (bv) bw.a.q();
        ic icVar = (ic) id.a.q();
        if (!icVar.b.H()) {
            icVar.v();
        }
        id idVar = (id) icVar.b;
        idVar.b |= 1;
        idVar.c = i;
        if (!bvVar.b.H()) {
            bvVar.v();
        }
        bw bwVar = (bw) bvVar.b;
        bwVar.b |= 1;
        bwVar.c = str;
        if (!icVar.b.H()) {
            icVar.v();
        }
        id idVar2 = (id) icVar.b;
        bw bwVar2 = (bw) bvVar.t();
        bwVar2.getClass();
        idVar2.k = bwVar2;
        idVar2.b |= 1024;
        if (!bvVar.b.H()) {
            bvVar.v();
        }
        bw bwVar3 = (bw) bvVar.b;
        bwVar3.b |= 1;
        bwVar3.c = str2;
        if (!icVar.b.H()) {
            icVar.v();
        }
        id idVar3 = (id) icVar.b;
        bw bwVar4 = (bw) bvVar.t();
        bwVar4.getClass();
        idVar3.l = bwVar4;
        idVar3.b |= 2048;
        ev evVarQ = ev.q(icVar);
        cn cnVar = cn.STEP_ARROW_OVERLAY;
        fx fxVar = (fx) ga.a.q();
        for (com.google.android.libraries.navigation.internal.br.e eVar : listB) {
            fj fjVar = (fj) fk.a.q();
            no it2 = evVarQ.iterator();
            while (it2.hasNext()) {
                ic icVar2 = (ic) it2.next();
                int iA = eVar.a() * 8;
                if (!icVar2.b.H()) {
                    icVar2.v();
                }
                id idVar4 = (id) icVar2.b;
                idVar4.b |= 8;
                idVar4.e = iA;
                fjVar.c(icVar2);
            }
            int i2 = cnVar.k;
            if (!fjVar.b.H()) {
                fjVar.v();
            }
            fk fkVar = (fk) fjVar.b;
            fkVar.b |= 4;
            fkVar.g = i2;
            da daVar = (da) db.a.q();
            int iB = eVar.b();
            if (!daVar.b.H()) {
                daVar.v();
            }
            db dbVar = (db) daVar.b;
            dbVar.b |= 1;
            dbVar.c = iB;
            if (!daVar.b.H()) {
                daVar.v();
            }
            db dbVar2 = (db) daVar.b;
            fk fkVar2 = (fk) fjVar.t();
            fkVar2.getClass();
            dbVar2.f = fkVar2;
            dbVar2.b |= 8;
            fxVar.c(daVar);
        }
        return zVar.e().a((ga) fxVar.t());
    }

    private static com.google.android.libraries.navigation.internal.ol.p c(com.google.android.libraries.navigation.internal.ol.z zVar, double[] dArr, int i, com.google.android.libraries.navigation.internal.ol.s sVar) {
        fd fdVar = (fd) fg.a.q();
        com.google.android.libraries.navigation.internal.ael.x xVarB = com.google.android.libraries.navigation.internal.on.k.b(dArr);
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        fg fgVar = (fg) fdVar.b;
        fgVar.b |= 1;
        fgVar.c = xVarB;
        int length = dArr.length;
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        fg fgVar2 = (fg) fdVar.b;
        fgVar2.b |= 2;
        fgVar2.d = length >> 1;
        int i2 = cz.c;
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        fg fgVar3 = (fg) fdVar.b;
        int i3 = i2 - 1;
        if (i2 == 0) {
            throw null;
        }
        fgVar3.i = i3;
        fgVar3.b |= 16;
        int iOrdinal = cn.STEP_ARROW_OVERLAY.ordinal();
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        fg fgVar4 = (fg) fdVar.b;
        fgVar4.b |= 1024;
        fgVar4.o = iOrdinal;
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        fg fgVar5 = (fg) fdVar.b;
        fgVar5.b |= 2048;
        fgVar5.p = i;
        int iA = sVar.a();
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        fg fgVar6 = (fg) fdVar.b;
        fgVar6.b |= 256;
        fgVar6.m = iA;
        fg fgVar7 = (fg) fdVar.t();
        Cdo cdo = (Cdo) zVar.d();
        return cdo.h(fgVar7, jr.WORLD_ENCODING_LAT_LNG_DOUBLE, cdo.k(fgVar7), cl.NAV_POLYLINE, com.google.android.libraries.navigation.internal.agg.fd.a);
    }

    public final void b() {
        for (j jVar : this.d) {
            com.google.android.libraries.navigation.internal.ol.z zVar = this.a;
            zVar.d().at(jVar.a);
            com.google.android.libraries.navigation.internal.ol.z zVar2 = this.a;
            zVar2.d().at(jVar.b);
        }
    }
}
