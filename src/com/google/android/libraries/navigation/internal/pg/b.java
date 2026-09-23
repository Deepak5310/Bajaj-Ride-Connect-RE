package com.google.android.libraries.navigation.internal.pg;

import com.adobe.internal.xmp.options.PropertyOptions;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.ct;
import com.google.android.libraries.geo.mapcore.renderer.v;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.agi.hc;
import com.google.android.libraries.navigation.internal.oe.bc;
import com.google.android.libraries.navigation.internal.oe.l;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.pb.t;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends j {
    private final Set f;
    private final x g;
    private t h;
    private bc i;
    private float j;
    private final float k;
    private boolean l;

    public b(an anVar, int i, ct ctVar) {
        super(anVar, ctVar);
        this.f = new hc();
        this.g = new x();
        this.l = true;
        this.k = i * i;
    }

    private final void g(List list, cd cdVar, x xVar, boolean z) {
        ar.q(this.i);
        if (!z || this.i.k(cdVar.d())) {
            ar.q(this.h);
            int i = cdVar.a;
            int i2 = PropertyOptions.DELETE_EXISTING >> i;
            this.g.J(cdVar.e + i2, cdVar.f + i2);
            float fRound = Math.round((((i2 + i2) * this.h.j()) * this.h.r()) / this.h.m(this.g, true));
            if (Math.round(fRound * this.j * fRound) <= this.k || i >= 30) {
                list.add(cdVar);
                h(cdVar);
                return;
            }
            List listD = d(cdVar, xVar);
            if (listD.isEmpty()) {
                list.add(cdVar);
                h(cdVar);
            } else {
                Iterator it2 = listD.iterator();
                while (it2.hasNext()) {
                    g(list, (cd) it2.next(), xVar, true);
                }
            }
        }
    }

    private final void h(cd cdVar) {
        if (!this.l || this.f.contains(cdVar)) {
            return;
        }
        this.l = false;
        this.b++;
    }

    @Override // com.google.android.libraries.navigation.internal.pg.f
    public final synchronized long a(t tVar, List list) {
        list.clear();
        v vVarX = tVar.x();
        if (vVarX == this.d) {
            Set set = this.f;
            if (!set.isEmpty()) {
                list.addAll(set);
                return this.b;
            }
        }
        this.l = true;
        bc bcVarV = tVar.v();
        this.i = bcVarV;
        l lVar = bcVarV.c;
        int iA = e(tVar.t()).a(com.google.android.libraries.navigation.internal.pb.j.g(tVar.n(), lVar.e().h(lVar.f()), tVar.s()));
        this.h = tVar;
        this.j = (float) Math.cos(((double) tVar.w().l) * 0.017453292519943295d);
        ArrayList arrayList = new ArrayList();
        cd.j(this.i.d, iA, arrayList, null);
        for (int i = 0; i < arrayList.size(); i++) {
            g(list, (cd) arrayList.get(i), tVar.t(), false);
        }
        this.f.clear();
        this.f.addAll(list);
        f(list, tVar.w().j);
        this.d = vVarX;
        return this.b;
    }
}
