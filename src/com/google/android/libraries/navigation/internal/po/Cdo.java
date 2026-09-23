package com.google.android.libraries.navigation.internal.po;

import android.content.Context;
import com.google.android.libraries.navigation.internal.adg.jr;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.google.android.libraries.navigation.internal.po.do, reason: invalid class name */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class Cdo implements com.google.android.libraries.navigation.internal.ol.ak, com.google.android.libraries.navigation.internal.qq.aj, com.google.android.libraries.navigation.internal.pi.n {
    public final hi b;
    public final Map c;
    public final com.google.android.libraries.geo.mapcore.renderer.ax d;
    public final com.google.android.libraries.navigation.internal.pb.t e;
    public final com.google.android.libraries.navigation.internal.pi.s f;
    public final Context g;
    public final gr h;
    private final Set j = new HashSet();
    private final Set k = new HashSet();
    private static final com.google.android.libraries.navigation.internal.zb.j i = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.po.do");
    public static final com.google.android.libraries.navigation.internal.pp.c a = new dn();

    public Cdo(com.google.android.libraries.geo.mapcore.renderer.ax axVar, hi hiVar, Map map, gr grVar, com.google.android.libraries.navigation.internal.pb.t tVar, com.google.android.libraries.navigation.internal.pi.s sVar, Context context) {
        this.b = hiVar;
        this.c = map;
        this.d = axVar;
        this.h = grVar;
        this.e = tVar;
        this.f = sVar;
        this.g = context;
    }

    private static com.google.android.libraries.navigation.internal.pp.b l(com.google.android.libraries.navigation.internal.ol.p pVar) {
        com.google.android.libraries.navigation.internal.yx.ar.k(pVar instanceof com.google.android.libraries.navigation.internal.pp.b);
        return (com.google.android.libraries.navigation.internal.pp.b) pVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static com.google.android.libraries.navigation.internal.pp.c m(com.google.android.libraries.navigation.internal.ol.r rVar) {
        com.google.android.libraries.navigation.internal.yx.ar.k(true);
        return rVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ak
    public final com.google.android.libraries.navigation.internal.ol.p a(com.google.android.libraries.navigation.internal.adg.fg fgVar, jr jrVar) {
        return b(fgVar, jrVar, k(fgVar));
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ak
    public final void at(com.google.android.libraries.navigation.internal.ol.p pVar) {
        Set set = this.j;
        com.google.android.libraries.navigation.internal.pp.b bVarL = l(pVar);
        synchronized (set) {
            this.j.add(bVarL);
        }
        bVarL.z();
    }

    @Override // com.google.android.libraries.navigation.internal.qq.aj
    public final void au() {
        synchronized (this.j) {
            Iterator it2 = this.j.iterator();
            while (it2.hasNext()) {
                ((com.google.android.libraries.navigation.internal.pp.d) it2.next()).w();
            }
        }
        synchronized (this.k) {
            Iterator it3 = this.k.iterator();
            while (it3.hasNext()) {
                ((com.google.android.libraries.navigation.internal.pp.d) it3.next()).w();
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ak
    public final com.google.android.libraries.navigation.internal.ol.p b(com.google.android.libraries.navigation.internal.adg.fg fgVar, jr jrVar, com.google.android.libraries.navigation.internal.ol.av avVar) {
        return h(fgVar, jrVar, avVar, com.google.android.libraries.geo.mapcore.renderer.cg.CLIENT_INJECTED_DRAW_ORDER, com.google.android.libraries.navigation.internal.agg.fd.a);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ak
    public final void c(com.google.android.libraries.navigation.internal.ol.p pVar) {
        Set set = this.j;
        com.google.android.libraries.navigation.internal.pp.b bVarL = l(pVar);
        synchronized (set) {
            this.j.remove(bVarL);
        }
        bVarL.x();
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ak
    public final void d(com.google.android.libraries.navigation.internal.ol.r rVar) {
        Set set = this.k;
        com.google.android.libraries.navigation.internal.pp.c cVarM = m(rVar);
        synchronized (set) {
            this.k.remove(cVarM);
        }
        cVarM.x();
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ak
    public final void e(com.google.android.libraries.navigation.internal.ol.p pVar) {
        Set set = this.j;
        com.google.android.libraries.navigation.internal.pp.b bVarL = l(pVar);
        synchronized (set) {
            this.j.remove(bVarL);
        }
        bVarL.y();
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ak
    public final void g(com.google.android.libraries.navigation.internal.ol.r rVar) {
        Set set = this.k;
        com.google.android.libraries.navigation.internal.pp.c cVarM = m(rVar);
        synchronized (set) {
            this.k.add(cVarM);
        }
        cVarM.z();
    }

    public final com.google.android.libraries.navigation.internal.ol.p h(com.google.android.libraries.navigation.internal.adg.fg fgVar, jr jrVar, com.google.android.libraries.navigation.internal.ol.av avVar, com.google.android.libraries.geo.mapcore.renderer.af afVar, com.google.android.libraries.navigation.internal.agg.ez ezVar) {
        return j(fgVar, jrVar, avVar, afVar, ezVar, false);
    }

    @Override // com.google.android.libraries.navigation.internal.pi.n
    public final void i(com.google.android.libraries.navigation.internal.pi.w wVar) {
        if (wVar instanceof com.google.android.libraries.navigation.internal.pi.b) {
            com.google.android.libraries.navigation.internal.ol.au auVar = (com.google.android.libraries.navigation.internal.ol.p) ((com.google.android.libraries.navigation.internal.pi.b) wVar).a(com.google.android.libraries.navigation.internal.ol.p.class);
            if (auVar instanceof b) {
                ((b) auVar).u(1);
                return;
            }
            return;
        }
        if (wVar instanceof com.google.android.libraries.navigation.internal.pi.c) {
            com.google.android.libraries.navigation.internal.ol.au auVar2 = (com.google.android.libraries.navigation.internal.ol.r) ((com.google.android.libraries.navigation.internal.pi.c) wVar).a(com.google.android.libraries.navigation.internal.ol.r.class);
            if (auVar2 instanceof b) {
                ((b) auVar2).u(1);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.google.android.libraries.navigation.internal.ol.p j(final com.google.android.libraries.navigation.internal.adg.fg fgVar, final jr jrVar, final com.google.android.libraries.navigation.internal.ol.av avVar, com.google.android.libraries.geo.mapcore.renderer.af afVar, final com.google.android.libraries.navigation.internal.agg.ez ezVar, boolean z) {
        if (jrVar == jr.WORLD_ENCODING_UNKNOWN) {
            throw new IllegalArgumentException("Attempting to create a client-inject polyline with an unknown vertex encoding");
        }
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.g);
        fgVar.h(bhVarS);
        Object objK = fgVar.w.k(bhVarS.d);
        List list = (List) (objK == null ? bhVarS.b : bhVarS.c(objK));
        com.google.android.libraries.navigation.internal.ael.bh bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.h);
        fgVar.h(bhVarS2);
        Object objK2 = fgVar.w.k(bhVarS2.d);
        List list2 = (List) (objK2 == null ? bhVarS2.b : bhVarS2.c(objK2));
        ArrayList arrayList = new ArrayList();
        com.google.android.libraries.navigation.internal.ael.bh bhVarS3 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.f);
        fgVar.h(bhVarS3);
        if (fgVar.w.n(bhVarS3.d)) {
            if (!(avVar instanceof hh)) {
                ((com.google.android.libraries.navigation.internal.zb.h) i.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 881)).p("We are trying to access a global style from a non-global style namespace.");
            }
            com.google.android.libraries.navigation.internal.ael.bh bhVarS4 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.f);
            fgVar.h(bhVarS4);
            Object objK3 = fgVar.w.k(bhVarS4.d);
            arrayList.add(avVar.c(((com.google.android.libraries.navigation.internal.adg.es) (objK3 == null ? bhVarS4.b : bhVarS4.c(objK3))).c));
        } else if (list.isEmpty()) {
            int i2 = fgVar.b;
            if ((i2 & 512) != 0) {
                if (!(avVar instanceof hh)) {
                    ((com.google.android.libraries.navigation.internal.zb.h) i.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 879)).p("We are trying to access a global style from a non-global style namespace.");
                }
                arrayList.add(avVar.c(fgVar.f197n));
            } else if ((i2 & 256) != 0) {
                arrayList.add(avVar.c(fgVar.m));
            } else if (fgVar.f.size() != 0) {
                Iterator it2 = fgVar.f.iterator();
                while (it2.hasNext()) {
                    arrayList.add(avVar.c(((Long) it2.next()).longValue()));
                }
            }
        } else {
            if (!(avVar instanceof hh)) {
                ((com.google.android.libraries.navigation.internal.zb.h) i.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 880)).p("We are trying to access a global style from a non-global style namespace.");
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                arrayList.add(avVar.c(((com.google.android.libraries.navigation.internal.adg.es) it3.next()).c));
            }
            Iterator it4 = list2.iterator();
            while (it4.hasNext()) {
                arrayList.add(avVar.c(((com.google.android.libraries.navigation.internal.adg.es) it4.next()).c));
            }
        }
        final an anVar = new an(this, this.b, this.d, this.c, this.h, this.f, this.g, afVar, z);
        if (!arrayList.isEmpty()) {
            final com.google.android.libraries.navigation.internal.hx.d dVar = new com.google.android.libraries.navigation.internal.hx.d(arrayList.size(), new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.dl
                @Override // java.lang.Runnable
                public final void run() {
                    anVar.B(fgVar, jrVar, avVar, ezVar);
                }
            });
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((com.google.android.libraries.navigation.internal.ol.aq) arrayList.get(i3)).f(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.dm
                    @Override // java.lang.Runnable
                    public final void run() {
                        dVar.a();
                    }
                });
            }
        }
        return anVar;
    }

    public final com.google.android.libraries.navigation.internal.pp.h k(com.google.android.libraries.navigation.internal.adg.fg fgVar) {
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.f);
        fgVar.h(bhVarS);
        if (!fgVar.w.n(bhVarS.d)) {
            com.google.android.libraries.navigation.internal.ael.bh bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.g);
            fgVar.h(bhVarS2);
            Object objK = fgVar.w.k(bhVarS2.d);
            if (((List) (objK == null ? bhVarS2.b : bhVarS2.c(objK))).isEmpty()) {
                if (fgVar.f197n != -1) {
                    ((com.google.android.libraries.navigation.internal.zb.h) i.d(com.google.android.libraries.navigation.internal.nl.a.a).F(882)).r("Client-injected line using global style %s; this won't work.", fgVar.f197n);
                }
                return this.b.f;
            }
        }
        return this.b.g;
    }
}
