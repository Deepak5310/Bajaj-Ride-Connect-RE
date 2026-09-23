package com.google.android.libraries.navigation.internal.po;

import android.content.Context;
import com.google.android.libraries.navigation.internal.adg.jh;
import com.google.android.libraries.navigation.internal.adg.jj;
import com.google.android.libraries.navigation.internal.adg.jr;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class d implements com.google.android.libraries.navigation.internal.ol.a, com.google.android.libraries.navigation.internal.qq.aj, com.google.android.libraries.navigation.internal.pi.n {
    private static final com.google.android.libraries.navigation.internal.zb.j j = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.po.d");
    public final hi a;
    public final Map b;
    public final com.google.android.libraries.geo.mapcore.renderer.ax c;
    public final com.google.android.libraries.navigation.internal.pi.s d;
    public final com.google.android.libraries.navigation.internal.pb.t e;
    public final com.google.android.libraries.geo.mapcore.internal.model.ce f;
    public final w g;
    public final com.google.android.libraries.navigation.internal.yx.br h;
    public final gr i;
    private final Set k;

    public d(hi hiVar, Cdo cdo, Map map, com.google.android.libraries.geo.mapcore.renderer.ax axVar, gr grVar, com.google.android.libraries.navigation.internal.pb.t tVar, com.google.android.libraries.navigation.internal.pi.s sVar, Context context, com.google.android.libraries.navigation.internal.yx.br brVar, com.google.android.libraries.navigation.internal.pm.d dVar) {
        com.google.android.libraries.geo.mapcore.internal.model.ce ceVar = new com.google.android.libraries.geo.mapcore.internal.model.ce(new com.google.android.libraries.geo.mapcore.internal.model.cd(0, 0, 0), new com.google.android.libraries.geo.mapcore.internal.model.s(), -1, jh.a, jj.a);
        c cVar = new c(dVar, cdo, axVar, grVar, sVar, tVar, context);
        this.k = new HashSet();
        this.a = hiVar;
        this.b = map;
        this.c = axVar;
        this.i = grVar;
        this.e = tVar;
        this.d = sVar;
        this.f = ceVar;
        this.g = cVar;
        this.h = brVar;
    }

    private static com.google.android.libraries.navigation.internal.pp.d g(com.google.android.libraries.navigation.internal.ol.g gVar) {
        com.google.android.libraries.navigation.internal.yx.ar.k(gVar instanceof com.google.android.libraries.navigation.internal.pp.d);
        return (com.google.android.libraries.navigation.internal.pp.d) gVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.a
    public final com.google.android.libraries.navigation.internal.ol.k a(com.google.android.libraries.navigation.internal.adg.aq aqVar, jr jrVar) {
        if (aqVar.j != -1) {
            ((com.google.android.libraries.navigation.internal.zb.h) j.d(com.google.android.libraries.navigation.internal.nl.a.a).F(851)).r("Client-injected area using global style %s; this won't work.", aqVar.j);
        }
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.b);
        aqVar.h(bhVarS);
        return b(aqVar, aqVar.w.n(bhVarS.d) ? this.a.g : this.a.f, jrVar);
    }

    @Override // com.google.android.libraries.navigation.internal.qq.aj
    public final void au() {
        synchronized (this.k) {
            Iterator it2 = this.k.iterator();
            while (it2.hasNext()) {
                ((com.google.android.libraries.navigation.internal.pp.d) it2.next()).w();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.ol.a
    public final com.google.android.libraries.navigation.internal.ol.k b(com.google.android.libraries.navigation.internal.adg.aq aqVar, com.google.android.libraries.navigation.internal.ol.av avVar, jr jrVar) {
        com.google.android.libraries.navigation.internal.ol.aq aqVarC;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.b);
        aqVar.h(bhVarS);
        if (aqVar.w.n(bhVarS.d)) {
            com.google.android.libraries.navigation.internal.ael.bh bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.b);
            aqVar.h(bhVarS2);
            Object objK = aqVar.w.k(bhVarS2.d);
            aqVarC = avVar.c(((com.google.android.libraries.navigation.internal.adg.es) (objK == null ? bhVarS2.b : bhVarS2.c(objK))).c);
        } else {
            aqVarC = (aqVar.b & 256) != 0 ? avVar.c(aqVar.j) : avVar.c(aqVar.i);
        }
        com.google.android.libraries.navigation.internal.ol.aq aqVar2 = aqVarC;
        boolean z = true;
        if (jrVar != jr.WORLD_ENCODING_LAT_LNG_E7 && jrVar != jr.WORLD_ENCODING_LAT_LNG_DOUBLE) {
            z = false;
        }
        com.google.android.libraries.navigation.internal.yx.ar.k(z);
        com.google.android.libraries.navigation.internal.oe.o oVar = (com.google.android.libraries.navigation.internal.oe.o) this.b.get(jrVar);
        com.google.android.libraries.navigation.internal.yx.ar.q(oVar);
        return new z(aqVar, (com.google.android.libraries.navigation.internal.oe.k) oVar, avVar, this.f, aqVar2, this.a, this.g, this.c, this.e, this.i, this.d, this, ((Boolean) this.h.a()).booleanValue());
    }

    @Override // com.google.android.libraries.navigation.internal.ol.a
    public final void c(com.google.android.libraries.navigation.internal.ol.g gVar) {
        Set set = this.k;
        com.google.android.libraries.navigation.internal.pp.d dVarG = g(gVar);
        synchronized (set) {
            this.k.remove(dVarG);
        }
        dVarG.x();
    }

    @Override // com.google.android.libraries.navigation.internal.ol.a
    public final void d(com.google.android.libraries.navigation.internal.ol.g gVar) {
        boolean zRemove;
        Set set = this.k;
        com.google.android.libraries.navigation.internal.pp.d dVarG = g(gVar);
        synchronized (set) {
            zRemove = this.k.remove(dVarG);
        }
        if (zRemove) {
            dVarG.y();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.a
    public final void e(com.google.android.libraries.navigation.internal.ol.g gVar) {
        boolean zAdd;
        Set set = this.k;
        com.google.android.libraries.navigation.internal.pp.d dVarG = g(gVar);
        synchronized (set) {
            zAdd = this.k.add(dVarG);
        }
        if (zAdd) {
            dVarG.z();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pi.n
    public final void i(com.google.android.libraries.navigation.internal.pi.w wVar) {
        if (wVar instanceof com.google.android.libraries.navigation.internal.pi.a) {
            com.google.android.libraries.navigation.internal.ol.au auVar = (com.google.android.libraries.navigation.internal.ol.g) ((com.google.android.libraries.navigation.internal.pi.a) wVar).a(com.google.android.libraries.navigation.internal.ol.g.class);
            if (auVar instanceof b) {
                ((b) auVar).u(1);
            }
        }
    }
}
