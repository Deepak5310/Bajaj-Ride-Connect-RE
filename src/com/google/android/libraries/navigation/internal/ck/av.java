package com.google.android.libraries.navigation.internal.ck;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import com.google.android.libraries.navigation.internal.adg.da;
import com.google.android.libraries.navigation.internal.adg.db;
import com.google.android.libraries.navigation.internal.adg.fj;
import com.google.android.libraries.navigation.internal.adg.fk;
import com.google.android.libraries.navigation.internal.adg.fx;
import com.google.android.libraries.navigation.internal.adg.ga;
import com.google.android.libraries.navigation.internal.adg.ib;
import com.google.android.libraries.navigation.internal.adg.ic;
import com.google.android.libraries.navigation.internal.adg.id;
import com.google.android.libraries.navigation.internal.agg.ez;
import com.google.android.libraries.navigation.internal.agg.fa;
import com.google.android.libraries.navigation.internal.agg.fb;
import com.google.android.libraries.navigation.internal.agg.fd;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class av {
    public static com.google.android.libraries.navigation.internal.ol.aq a(Resources resources, int i, com.google.android.libraries.navigation.internal.ol.ax axVar, com.google.android.libraries.geo.mapcore.renderer.cn cnVar, int i2) {
        String strA = com.google.android.libraries.navigation.internal.ks.a.a(BitmapFactory.decodeResource(resources, i));
        List<com.google.android.libraries.navigation.internal.br.e> listB = com.google.android.libraries.navigation.internal.br.f.b(com.google.android.libraries.navigation.internal.br.f.b, 1.0f, com.google.android.libraries.navigation.internal.br.f.a);
        fx fxVar = (fx) ga.a.q();
        for (com.google.android.libraries.navigation.internal.br.e eVar : listB) {
            fj fjVar = (fj) fk.a.q();
            int i3 = ib.a;
            if (i3 == 0) {
                throw null;
            }
            if (!fjVar.b.H()) {
                fjVar.v();
            }
            fk fkVar = (fk) fjVar.b;
            fkVar.b |= 1024;
            fkVar.m = i3;
            ic icVar = (ic) id.a.q();
            int iA = (eVar.a() * 8) / i2;
            if (!icVar.b.H()) {
                icVar.v();
            }
            id idVar = (id) icVar.b;
            idVar.b |= 8;
            idVar.e = iA;
            int i4 = 16 / i2;
            if (!icVar.b.H()) {
                icVar.v();
            }
            id idVar2 = (id) icVar.b;
            idVar2.b |= 256;
            idVar2.i = i4;
            if (!icVar.b.H()) {
                icVar.v();
            }
            id idVar3 = (id) icVar.b;
            strA.getClass();
            idVar3.b |= 64;
            idVar3.h = strA;
            fjVar.c(icVar);
            int i5 = cnVar.k;
            if (!fjVar.b.H()) {
                fjVar.v();
            }
            fk fkVar2 = (fk) fjVar.b;
            fkVar2.b |= 4;
            fkVar2.g = i5;
            fk fkVar3 = (fk) fjVar.t();
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
            fkVar3.getClass();
            dbVar2.f = fkVar3;
            dbVar2.b |= 8;
            fxVar.c(daVar);
        }
        return axVar.a((ga) fxVar.t());
    }

    public static com.google.android.libraries.navigation.internal.aac.bj b(final com.google.android.libraries.navigation.internal.ol.aq aqVar) {
        final com.google.android.libraries.navigation.internal.aac.ca caVar = new com.google.android.libraries.navigation.internal.aac.ca();
        aqVar.f(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ck.at
            @Override // java.lang.Runnable
            public final void run() {
                caVar.d(aqVar);
            }
        });
        return caVar;
    }

    public static Set c(List list) {
        HashSet hashSet = new HashSet();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            hashSet.addAll(((com.google.android.libraries.navigation.internal.ol.p) it2.next()).a());
        }
        return hashSet;
    }

    public static ez d(int i) {
        if (i != 2) {
            return fd.a;
        }
        fa faVar = fd.a;
        return new fb(61);
    }
}
