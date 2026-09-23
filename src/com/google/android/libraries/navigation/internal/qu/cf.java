package com.google.android.libraries.navigation.internal.qu;

import android.content.res.Resources;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.afl.ee;
import com.google.android.libraries.navigation.internal.afl.fs;
import com.google.android.libraries.navigation.internal.afm.dd;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cf implements com.google.android.libraries.navigation.internal.qv.j {
    private final ee A;
    private final HashSet B;
    private final br C;
    private final com.google.android.libraries.navigation.internal.ox.f D;
    public final Map a;
    public final com.google.android.libraries.navigation.internal.oe.aq b;
    public final com.google.android.libraries.navigation.internal.qv.a c;
    public final com.google.android.libraries.navigation.internal.fq.f d;
    public final com.google.android.libraries.navigation.internal.agl.a e;
    public final com.google.android.libraries.navigation.internal.mj.a f;
    public final com.google.android.libraries.navigation.internal.aac.bn g;
    public final com.google.android.libraries.navigation.internal.aac.bn h;
    public final com.google.android.libraries.navigation.internal.yx.br i;
    public final com.google.android.libraries.navigation.internal.hn.p j;
    public final List k;
    private final Map l;
    private final AtomicInteger m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Map f564n;
    private final com.google.android.libraries.navigation.internal.oe.at o;
    private final com.google.android.libraries.navigation.internal.qp.ai p;
    private final Resources q;
    private final com.google.android.libraries.navigation.internal.afo.a r;
    private final com.google.android.libraries.navigation.internal.afo.a s;
    private final com.google.android.libraries.navigation.internal.afo.a t;
    private final com.google.android.libraries.navigation.internal.kl.b u;
    private final Runnable v;
    private final com.google.android.libraries.navigation.internal.pm.d w;
    private final com.google.android.libraries.navigation.internal.yx.br x;
    private final com.google.android.libraries.navigation.internal.ace.bk y;
    private final com.google.android.libraries.navigation.internal.ace.ao z;

    public cf(Resources resources, com.google.android.libraries.navigation.internal.oe.at atVar, com.google.android.libraries.navigation.internal.qv.a aVar, Map map, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.fq.f fVar, com.google.android.libraries.navigation.internal.kl.b bVar, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.ox.f fVar2, Runnable runnable, com.google.android.libraries.navigation.internal.pm.d dVar, com.google.android.libraries.navigation.internal.mj.a aVar4, com.google.android.libraries.navigation.internal.aac.bn bnVar, com.google.android.libraries.navigation.internal.aac.bn bnVar2, com.google.android.libraries.navigation.internal.yx.br brVar, com.google.android.libraries.navigation.internal.yx.br brVar2, com.google.android.libraries.navigation.internal.afo.a aVar5, com.google.android.libraries.navigation.internal.afo.a aVar6, br brVar3, com.google.android.libraries.navigation.internal.ace.bk bkVar, com.google.android.libraries.navigation.internal.ace.ao aoVar, ee eeVar, com.google.android.libraries.navigation.internal.hn.p pVar) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(com.google.android.libraries.navigation.internal.adi.an.values().length);
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap(com.google.android.libraries.navigation.internal.adi.an.values().length);
        this.m = new AtomicInteger(0);
        this.p = new com.google.android.libraries.navigation.internal.qp.ai();
        this.k = new ArrayList();
        this.B = new HashSet();
        this.q = resources;
        this.o = atVar;
        this.b = new com.google.android.libraries.navigation.internal.oe.aq(atVar);
        this.c = aVar;
        this.r = aVar2;
        this.d = fVar;
        this.u = bVar;
        this.e = aVar3;
        this.D = fVar2;
        this.v = runnable;
        this.w = dVar;
        this.f = aVar4;
        this.g = bnVar;
        this.h = bnVar2;
        this.s = aVar5;
        this.t = aVar6;
        this.C = brVar3;
        this.y = bkVar;
        this.z = aoVar;
        this.A = eeVar;
        this.x = brVar;
        this.i = brVar2;
        this.a = concurrentHashMap;
        this.l = concurrentHashMap2;
        this.j = pVar;
        this.f564n = map;
    }

    public static int a(com.google.android.libraries.navigation.internal.yx.br brVar, com.google.android.libraries.navigation.internal.adi.an anVar, boolean z, com.google.android.libraries.navigation.internal.hn.p pVar) {
        fs fsVar = pVar.a;
        if (fsVar.aD) {
            return fsVar.aC;
        }
        if (z && anVar == com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE) {
            return 0;
        }
        return com.google.android.libraries.navigation.internal.zy.i.a((((Integer) brVar.a()).intValue() >> 3) * 16, 32, 128);
    }

    private final com.google.android.libraries.navigation.internal.qp.w h(com.google.android.libraries.navigation.internal.adi.an anVar, com.google.android.libraries.geo.mapcore.internal.model.cg cgVar, ev evVar, com.google.android.libraries.navigation.internal.aac.bn bnVar) {
        com.google.android.libraries.navigation.internal.adi.al alVarI = this.o.i(anVar);
        com.google.android.libraries.navigation.internal.qn.a aVar = (alVarI.b & 4) != 0 ? new com.google.android.libraries.navigation.internal.qn.a(alVarI.e) : null;
        if (aVar == null) {
            aVar = new com.google.android.libraries.navigation.internal.qn.a(8);
        }
        return new com.google.android.libraries.navigation.internal.qp.w((com.google.android.libraries.navigation.internal.iv.f) this.s.a(), bnVar, (com.google.android.libraries.navigation.internal.gg.f) this.r.a(), new com.google.android.libraries.navigation.internal.qp.o(aVar, new com.google.android.libraries.navigation.internal.qp.z(this.e, this.D, cgVar), evVar, this.t), com.google.android.libraries.navigation.internal.gd.k.a, this.u, this.e);
    }

    private static com.google.android.libraries.navigation.internal.qv.g i(com.google.android.libraries.navigation.internal.oe.ap apVar, com.google.android.libraries.navigation.internal.fq.f fVar, com.google.android.libraries.navigation.internal.yx.br brVar, boolean z, com.google.android.libraries.navigation.internal.hn.p pVar) {
        return new com.google.android.libraries.navigation.internal.qw.b(fVar, apVar, a(brVar, apVar.c, z, pVar));
    }

    public final com.google.android.libraries.navigation.internal.qv.k b(com.google.android.libraries.navigation.internal.oe.ap apVar, com.google.android.libraries.geo.mapcore.internal.model.cg cgVar) {
        return c(apVar, cgVar, true);
    }

    /* JADX WARN: Code duplicated, block: B:71:0x0221 A[Catch: all -> 0x0401, FALL_THROUGH, TryCatch #0 {all -> 0x0401, blocks: (B:19:0x0047, B:113:0x03d4, B:118:0x03e0, B:119:0x03f7, B:22:0x0050, B:24:0x0059, B:26:0x0094, B:27:0x00af, B:29:0x0131, B:31:0x013b, B:34:0x0145, B:36:0x014d, B:38:0x0182, B:41:0x018d, B:43:0x01ab, B:61:0x01f1, B:62:0x01f4, B:63:0x01f7, B:64:0x01fa, B:87:0x0281, B:88:0x0284, B:90:0x02ad, B:91:0x02b3, B:66:0x01ff, B:67:0x0206, B:68:0x020d, B:69:0x0214, B:70:0x021b, B:71:0x0221, B:72:0x0227, B:73:0x0231, B:74:0x0237, B:75:0x023d, B:76:0x0243, B:77:0x0249, B:78:0x024f, B:79:0x0257, B:80:0x025f, B:81:0x0265, B:82:0x026b, B:83:0x0271, B:84:0x0277, B:85:0x027d, B:92:0x02d8, B:94:0x0310, B:97:0x031b, B:99:0x0339, B:101:0x034e, B:103:0x0353, B:105:0x035b, B:107:0x0365, B:109:0x037c, B:110:0x0384, B:120:0x03f8, B:102:0x0351, B:121:0x03f9, B:122:0x0400), top: B:135:0x0047, outer: #2 }] */
    public final com.google.android.libraries.navigation.internal.qv.k c(com.google.android.libraries.navigation.internal.oe.ap apVar, com.google.android.libraries.geo.mapcore.internal.model.cg cgVar, boolean z) {
        boolean z2;
        String str;
        com.google.android.libraries.geo.mapcore.internal.store.diskcache.a aVar;
        aa aaVar;
        com.google.android.libraries.geo.mapcore.internal.store.diskcache.a aVar2;
        com.google.android.libraries.navigation.internal.qv.k kVar = (com.google.android.libraries.navigation.internal.qv.k) this.a.get(apVar);
        if (kVar != null) {
            if (z && !cgVar.equals(kVar.D())) {
                z2 = true;
            }
            return kVar;
        }
        z2 = z;
        synchronized (e(apVar)) {
            com.google.android.libraries.navigation.internal.qv.k kVar2 = (com.google.android.libraries.navigation.internal.qv.k) this.a.get(apVar);
            if (kVar2 == null || (z2 && !cgVar.equals(kVar2.D()))) {
                com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("TileStoreFactory.createTileStore");
                try {
                    com.google.android.libraries.navigation.internal.adi.an anVar = apVar.c;
                    Object kVar3 = null;
                    kVar2 = null;
                    com.google.android.libraries.geo.mapcore.internal.store.diskcache.a aVar3 = null;
                    kVar2 = null;
                    if (anVar == null) {
                        str = "Unable to create TileStore for tile layer id: ";
                    } else {
                        if (anVar.equals(com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE)) {
                            com.google.android.libraries.navigation.internal.qv.g gVarI = i(this.b.a(com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE), this.d, this.i, ((com.google.android.libraries.navigation.internal.om.h) ((com.google.android.libraries.navigation.internal.om.p) this.e.a()).e()).b, this.j);
                            ci ciVar = new ci(this.u, this, false);
                            com.google.android.libraries.navigation.internal.afo.a aVar4 = (com.google.android.libraries.navigation.internal.afo.a) this.f564n.get(com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE);
                            com.google.android.libraries.navigation.internal.qv.d dVarC = this.c.c(apVar, cgVar, ciVar);
                            if (aVar4 != null) {
                                String str2 = ((com.google.android.libraries.geo.mapcore.internal.model.b) cgVar).l;
                                aVar3 = new com.google.android.libraries.geo.mapcore.internal.store.diskcache.a(apVar, this.u, (com.google.android.libraries.navigation.internal.ey.b) aVar4.a());
                                ((com.google.android.libraries.navigation.internal.ey.b) aVar4.a()).c();
                            }
                            ce ceVar = new ce(com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE, gVarI, dVarC, aVar3, this.h);
                            eq eqVar = new eq();
                            eqVar.h(new com.google.android.libraries.navigation.internal.qp.h(this.x));
                            eqVar.h(new com.google.android.libraries.navigation.internal.qp.g(cgVar));
                            com.google.android.libraries.navigation.internal.aac.bn bnVar = this.g;
                            str = "Unable to create TileStore for tile layer id: ";
                            aaVar = new aa(apVar, cgVar, ceVar, new cj(this.u, this.e, this, false), ciVar, h(com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE, cgVar, eqVar.g(), bnVar), this.o, this.u, this.e, this.D, this.v, this.f, bnVar, this.h, this.m.get(), this.C, new ch(this.f, com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE));
                        } else {
                            str = "Unable to create TileStore for tile layer id: ";
                            if (anVar.equals(com.google.android.libraries.navigation.internal.adi.an.GMM_API_TILE_OVERLAY)) {
                                throw new IllegalStateException("Unable to create TileStore for API_TILE_OVERLAY without a TileProvider.");
                            }
                            if (!anVar.equals(com.google.android.libraries.navigation.internal.adi.an.GMM_ROAD_GRAPH)) {
                                if (this.o.r(anVar)) {
                                    com.google.android.libraries.navigation.internal.adi.an anVar2 = apVar.c;
                                    com.google.android.libraries.navigation.internal.qv.g gVarI2 = i(apVar, this.d, this.i, ((com.google.android.libraries.navigation.internal.om.h) ((com.google.android.libraries.navigation.internal.om.p) this.e.a()).e()).b, this.j);
                                    ci ciVar2 = new ci(this.u, this, false);
                                    com.google.android.libraries.navigation.internal.afo.a aVar5 = (com.google.android.libraries.navigation.internal.afo.a) this.f564n.get(anVar2);
                                    com.google.android.libraries.navigation.internal.qv.d dVarC2 = this.o.o(anVar2) ? this.c.c(apVar, cgVar, ciVar2) : null;
                                    if (aVar5 != null) {
                                        String str3 = ((com.google.android.libraries.geo.mapcore.internal.model.b) cgVar).l;
                                        com.google.android.libraries.geo.mapcore.internal.store.diskcache.a aVar6 = new com.google.android.libraries.geo.mapcore.internal.store.diskcache.a(apVar, this.u, (com.google.android.libraries.navigation.internal.ey.b) aVar5.a());
                                        ((com.google.android.libraries.navigation.internal.ey.b) aVar5.a()).c();
                                        aVar2 = aVar6;
                                    } else {
                                        aVar2 = null;
                                    }
                                    ce ceVar2 = new ce(anVar2, gVarI2, dVarC2, aVar2, this.h);
                                    eq eqVar2 = new eq();
                                    eqVar2.h(new com.google.android.libraries.navigation.internal.qp.h(this.x));
                                    eqVar2.h(new com.google.android.libraries.navigation.internal.qp.g(cgVar));
                                    int iOrdinal = anVar2.ordinal();
                                    if (iOrdinal == 2) {
                                        kVar3 = this.p;
                                    } else if (iOrdinal == 6) {
                                        kVar3 = new com.google.android.libraries.navigation.internal.qp.k(cgVar);
                                    } else if (iOrdinal == 22) {
                                        kVar3 = new com.google.android.libraries.navigation.internal.qp.ag(cgVar);
                                    } else if (iOrdinal == 38) {
                                        kVar3 = new com.google.android.libraries.navigation.internal.qp.a();
                                    } else if (iOrdinal == 58) {
                                        kVar3 = new com.google.android.libraries.navigation.internal.qp.i(cgVar);
                                    } else if (iOrdinal == 28) {
                                        kVar3 = new com.google.android.libraries.navigation.internal.qp.ak(cgVar);
                                    } else if (iOrdinal == 29) {
                                        kVar3 = new com.google.android.libraries.navigation.internal.qp.e(cgVar, "lore-rec");
                                    } else if (iOrdinal == 54) {
                                        kVar3 = new com.google.android.libraries.navigation.internal.qp.e(cgVar, "maps-wayfinding");
                                    } else if (iOrdinal != 55) {
                                        switch (iOrdinal) {
                                            case 9:
                                                kVar3 = new com.google.android.libraries.navigation.internal.qp.aj();
                                                break;
                                            case 10:
                                                kVar3 = new com.google.android.libraries.navigation.internal.qp.l();
                                                break;
                                            case 11:
                                                kVar3 = new com.google.android.libraries.navigation.internal.qp.n(cgVar);
                                                break;
                                            default:
                                                switch (iOrdinal) {
                                                    case 24:
                                                        kVar3 = new com.google.android.libraries.navigation.internal.qp.m(cgVar);
                                                        break;
                                                    case 25:
                                                        kVar3 = new com.google.android.libraries.navigation.internal.qp.ah(this.y, this.A);
                                                        break;
                                                    default:
                                                        switch (iOrdinal) {
                                                            default:
                                                                switch (iOrdinal) {
                                                                    case 42:
                                                                        kVar3 = new com.google.android.libraries.navigation.internal.qp.f();
                                                                        break;
                                                                    case 43:
                                                                        kVar3 = new com.google.android.libraries.navigation.internal.qp.al();
                                                                        break;
                                                                    case 44:
                                                                        kVar3 = new com.google.android.libraries.navigation.internal.qp.b();
                                                                        break;
                                                                    case 45:
                                                                        kVar3 = new com.google.android.libraries.navigation.internal.qp.d(cgVar);
                                                                        break;
                                                                    case 46:
                                                                        kVar3 = new com.google.android.libraries.navigation.internal.qp.ad(cgVar);
                                                                        break;
                                                                }
                                                            case 31:
                                                            case 32:
                                                            case 33:
                                                            case 34:
                                                                kVar3 = new com.google.android.libraries.navigation.internal.qp.af(cgVar);
                                                                break;
                                                        }
                                                    case 26:
                                                        kVar3 = new com.google.android.libraries.navigation.internal.qp.af(cgVar);
                                                        break;
                                                }
                                                break;
                                        }
                                    } else {
                                        kVar3 = new com.google.android.libraries.navigation.internal.qp.j(cgVar);
                                    }
                                    if (kVar3 != null) {
                                        eqVar2.h(kVar3);
                                    }
                                    com.google.android.libraries.navigation.internal.aac.bn bnVar2 = this.g;
                                    com.google.android.libraries.navigation.internal.qp.w wVarH = h(anVar2, cgVar, eqVar2.g(), bnVar2);
                                    cj cjVar = new cj(this.u, this.e, this, false);
                                    com.google.android.libraries.navigation.internal.oe.at atVar = this.o;
                                    aaVar = new aa(apVar, cgVar, ceVar2, cjVar, ciVar2, wVarH, atVar, this.u, this.e, this.D, this.v, this.f, bnVar2, this.h, atVar.f(anVar2) ? this.m.get() : 0, this.C, new ch(this.f, anVar2));
                                } else {
                                    com.google.android.libraries.navigation.internal.adi.an anVar3 = apVar.c;
                                    com.google.android.libraries.navigation.internal.qv.g gVarI3 = i(apVar, this.d, this.i, ((com.google.android.libraries.navigation.internal.om.h) ((com.google.android.libraries.navigation.internal.om.p) this.e.a()).e()).b, this.j);
                                    bm bmVar = new bm(new ab());
                                    com.google.android.libraries.navigation.internal.afo.a aVar7 = (com.google.android.libraries.navigation.internal.afo.a) this.f564n.get(anVar3);
                                    com.google.android.libraries.navigation.internal.qv.d dVarC3 = this.o.o(anVar3) ? this.c.c(apVar, cgVar, bmVar) : null;
                                    if (aVar7 != null) {
                                        String str4 = ((com.google.android.libraries.geo.mapcore.internal.model.b) cgVar).l;
                                        com.google.android.libraries.geo.mapcore.internal.store.diskcache.a aVar8 = new com.google.android.libraries.geo.mapcore.internal.store.diskcache.a(apVar, this.u, (com.google.android.libraries.navigation.internal.ey.b) aVar7.a());
                                        ((com.google.android.libraries.navigation.internal.ey.b) aVar7.a()).c();
                                        aVar = aVar8;
                                    } else {
                                        aVar = null;
                                    }
                                    ce ceVar3 = new ce(anVar3, gVarI3, dVarC3, aVar, this.h);
                                    int i = this.q.getDisplayMetrics().densityDpi > 160 ? dd.d : dd.b;
                                    if (this.o.s(anVar3)) {
                                        float f = this.q.getDisplayMetrics().density;
                                    }
                                    if (i == 0) {
                                        throw null;
                                    }
                                    eq eqVar3 = new eq();
                                    eqVar3.h(new com.google.android.libraries.navigation.internal.qp.h(this.x));
                                    if (!anVar3.equals(com.google.android.libraries.navigation.internal.adi.an.GMM_SATELLITE)) {
                                        eqVar3.h(new com.google.android.libraries.navigation.internal.qp.g(cgVar));
                                    }
                                    com.google.android.libraries.navigation.internal.aac.bn bnVar3 = this.g;
                                    aaVar = new aa(apVar, cgVar, ceVar3, new bn(new bp()), bmVar, h(anVar3, cgVar, eqVar3.g(), bnVar3), this.o, this.u, this.e, this.D, this.v, this.f, bnVar3, this.h, 0, this.C, new ch(this.f, anVar3));
                                }
                            }
                        }
                        kVar2 = aaVar;
                    }
                    if (kVar2 == null) {
                        throw new IllegalStateException(str + String.valueOf(apVar));
                    }
                    f(apVar, kVar2);
                    if (dVarB != null) {
                        Trace.endSection();
                    }
                } catch (Throwable th) {
                    if (dVarB == null) {
                        throw th;
                    }
                    try {
                        Trace.endSection();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            }
            kVar = kVar2;
        }
        return kVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.j
    public final Iterable d() {
        return this.B;
    }

    public final synchronized Object e(com.google.android.libraries.navigation.internal.oe.ap apVar) {
        Object obj = this.l.get(apVar);
        if (obj != null) {
            return obj;
        }
        Object obj2 = new Object();
        this.l.put(apVar, obj2);
        return obj2;
    }

    public final void f(com.google.android.libraries.navigation.internal.oe.ap apVar, com.google.android.libraries.navigation.internal.qv.k kVar) {
        this.d.c(kVar, com.google.android.libraries.navigation.internal.xn.a.e(apVar.c));
        this.a.put(apVar, kVar);
    }

    public final synchronized void g(int i) {
        this.m.set(i);
        for (com.google.android.libraries.navigation.internal.oe.ap apVar : this.l.keySet()) {
            com.google.android.libraries.navigation.internal.adi.an anVar = apVar.c;
            if (anVar == null || this.o.f(anVar)) {
                synchronized (e(apVar)) {
                    com.google.android.libraries.navigation.internal.qv.k kVar = (com.google.android.libraries.navigation.internal.qv.k) this.a.get(apVar);
                    if (kVar instanceof aa) {
                        ((aa) kVar).i = i;
                    }
                }
            }
        }
    }
}
