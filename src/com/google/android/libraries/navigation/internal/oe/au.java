package com.google.android.libraries.navigation.internal.oe;

import com.drew.metadata.exif.makernotes.LeicaMakernoteDirectory;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.google.android.libraries.navigation.internal.ael.bs;
import com.google.android.libraries.navigation.internal.afl.no;
import com.google.android.libraries.navigation.internal.yz.fw;
import com.google.android.libraries.navigation.internal.yz.fy;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class au implements at {
    private static final fy c;
    private static final fy d;
    private static final fy e;
    private static final fy f;
    private static final fy g;
    private final com.google.android.libraries.navigation.internal.agl.a h;
    private final com.google.android.libraries.navigation.internal.ox.f i;
    private static final com.google.android.libraries.navigation.internal.zb.j b = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.oe.au");
    static final long a = TimeUnit.MINUTES.toMillis(1);

    static {
        fy fyVarU = fy.u(com.google.android.libraries.navigation.internal.adi.an.UNKNOWN, com.google.android.libraries.navigation.internal.adi.an.GMM_SATELLITE, com.google.android.libraries.navigation.internal.adi.an.GMM_TERRAIN, com.google.android.libraries.navigation.internal.adi.an.GMM_TERRAIN_DARK, com.google.android.libraries.navigation.internal.adi.an.GMM_ROAD_GRAPH, com.google.android.libraries.navigation.internal.adi.an.GMM_API_TILE_OVERLAY, new com.google.android.libraries.navigation.internal.adi.an[0]);
        c = fyVarU;
        d = fy.q(com.google.android.libraries.navigation.internal.adi.an.GMM_TRAFFIC_CAR, com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_TRAFFIC_V2);
        e = fy.s(com.google.android.libraries.navigation.internal.adi.an.GMM_SATELLITE, com.google.android.libraries.navigation.internal.adi.an.GMM_TERRAIN, com.google.android.libraries.navigation.internal.adi.an.GMM_TERRAIN_DARK, com.google.android.libraries.navigation.internal.adi.an.GMM_AIR_QUALITY_HEATMAP);
        fy.u(com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE, com.google.android.libraries.navigation.internal.adi.an.GMM_SATELLITE, com.google.android.libraries.navigation.internal.adi.an.GMM_TERRAIN, com.google.android.libraries.navigation.internal.adi.an.GMM_TERRAIN_DARK, com.google.android.libraries.navigation.internal.adi.an.GMM_LABELS_ONLY, com.google.android.libraries.navigation.internal.adi.an.GMM_BUILDING_3D, new com.google.android.libraries.navigation.internal.adi.an[0]);
        f = fy.u(com.google.android.libraries.navigation.internal.adi.an.DESTINATIONS, com.google.android.libraries.navigation.internal.adi.an.EVCS, com.google.android.libraries.navigation.internal.adi.an.UNKNOWN, com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_TRAFFIC_V2, com.google.android.libraries.navigation.internal.adi.an.GMM_TRAFFIC_CAR, com.google.android.libraries.navigation.internal.adi.an.GMM_ROAD_GRAPH, com.google.android.libraries.navigation.internal.adi.an.GMM_HIGHLIGHT_RAP, com.google.android.libraries.navigation.internal.adi.an.GMM_API_TILE_OVERLAY, com.google.android.libraries.navigation.internal.adi.an.GMM_BUSYNESS, com.google.android.libraries.navigation.internal.adi.an.GMM_AIR_QUALITY, com.google.android.libraries.navigation.internal.adi.an.GMM_CRISIS_WILDFIRES, com.google.android.libraries.navigation.internal.adi.an.GMM_CRISIS_OVERLAY, com.google.android.libraries.navigation.internal.adi.an.GMM_AREA_BUSYNESS, com.google.android.libraries.navigation.internal.adi.an.GMM_BASEMAP_PHOTOS);
        fw fwVar = new fw();
        fwVar.k(fyVarU);
        g = fwVar.c(com.google.android.libraries.navigation.internal.adi.an.GMM_MY_MAPS).i();
    }

    public au(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.ox.f fVar) {
        this.h = aVar;
        this.i = fVar;
    }

    public static final boolean w(com.google.android.libraries.navigation.internal.adi.an anVar) {
        return d.contains(anVar);
    }

    private final com.google.android.libraries.navigation.internal.om.x x() {
        return ((com.google.android.libraries.navigation.internal.om.p) this.h.a()).e();
    }

    private final List y() {
        com.google.android.libraries.navigation.internal.adi.ar arVar = this.i.a().c;
        if (arVar == null) {
            arVar = com.google.android.libraries.navigation.internal.adi.ar.a;
        }
        return arVar.c;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.at
    public final int a(com.google.android.libraries.navigation.internal.adi.an anVar) {
        if (q(anVar)) {
            return BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
        }
        return 256;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aw
    public final long b(com.google.android.libraries.navigation.internal.adi.an anVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        long epochMilli = aVar.f().toEpochMilli();
        long jU = u(anVar);
        if (jU == -1) {
            return -1L;
        }
        return ((com.google.android.libraries.navigation.internal.gz.a) aVar).a + ((epochMilli + jU) - aVar.f().toEpochMilli());
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aw
    public final long c(com.google.android.libraries.navigation.internal.adi.an anVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        long jU = u(anVar);
        if (jU == -1) {
            return -1L;
        }
        return aVar.f().toEpochMilli() + jU;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aw
    public final long d(com.google.android.libraries.navigation.internal.adi.an anVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        long epochMilli = aVar.f().toEpochMilli();
        if (r(anVar)) {
            long jV = v(anVar);
            if (jV != -1) {
                return ((com.google.android.libraries.navigation.internal.gz.a) aVar).a + ((epochMilli + jV) - aVar.f().toEpochMilli());
            }
        }
        return -1L;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aw
    public final String e(com.google.android.libraries.navigation.internal.adi.an anVar) {
        String strA = i(anVar).k;
        if (com.google.android.libraries.navigation.internal.yx.aq.c(strA)) {
            if (anVar == com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE) {
                return "m";
            }
            strA = com.google.android.libraries.navigation.internal.yx.c.a(anVar.name());
            if (strA.startsWith("gmm_")) {
                return strA.replaceFirst("gmm_", "");
            }
        }
        return strA;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aw
    public final boolean f(com.google.android.libraries.navigation.internal.adi.an anVar) {
        return !g.contains(anVar);
    }

    @Override // com.google.android.libraries.navigation.internal.oe.at
    public final long g(com.google.android.libraries.navigation.internal.adi.an anVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        if (r(anVar)) {
            long jV = v(anVar);
            if (jV != -1) {
                return aVar.f().toEpochMilli() + jV;
            }
        }
        return -1L;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.at
    public final com.google.android.libraries.navigation.internal.yx.an h(com.google.android.libraries.navigation.internal.adi.an anVar) {
        return Objects.equals(anVar, com.google.android.libraries.navigation.internal.adi.an.GMM_BUILDING_3D) ? ((com.google.android.libraries.navigation.internal.om.d) ((com.google.android.libraries.navigation.internal.om.p) this.h.a()).b()).g : com.google.android.libraries.navigation.internal.yx.a.a;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.at
    public final com.google.android.libraries.navigation.internal.adi.al i(com.google.android.libraries.navigation.internal.adi.an anVar) {
        for (com.google.android.libraries.navigation.internal.adi.al alVar : y()) {
            com.google.android.libraries.navigation.internal.adi.an anVarB = com.google.android.libraries.navigation.internal.adi.an.b(alVar.c);
            if (anVarB == null) {
                anVarB = com.google.android.libraries.navigation.internal.adi.an.UNKNOWN;
            }
            if (anVarB.equals(anVar)) {
                return alVar;
            }
        }
        com.google.android.libraries.navigation.internal.adi.ak akVar = (com.google.android.libraries.navigation.internal.adi.ak) com.google.android.libraries.navigation.internal.adi.al.a.q();
        if (!akVar.b.H()) {
            akVar.v();
        }
        com.google.android.libraries.navigation.internal.adi.al alVar2 = (com.google.android.libraries.navigation.internal.adi.al) akVar.b;
        alVar2.c = anVar.ah;
        alVar2.b |= 1;
        return (com.google.android.libraries.navigation.internal.adi.al) akVar.t();
    }

    @Override // com.google.android.libraries.navigation.internal.oe.at
    public final com.google.android.libraries.navigation.internal.adi.al j(String str) {
        for (com.google.android.libraries.navigation.internal.adi.al alVar : y()) {
            if (alVar.k.equals(str)) {
                return alVar;
            }
        }
        ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).F(LeicaMakernoteDirectory.TAG_CCD_BOARD_VERSION)).s("PaintRequestTemplate does not exist for %s", str);
        com.google.android.libraries.navigation.internal.adi.ak akVar = (com.google.android.libraries.navigation.internal.adi.ak) com.google.android.libraries.navigation.internal.adi.al.a.q();
        if (!akVar.b.H()) {
            akVar.v();
        }
        com.google.android.libraries.navigation.internal.adi.al alVar2 = (com.google.android.libraries.navigation.internal.adi.al) akVar.b;
        str.getClass();
        alVar2.b |= 64;
        alVar2.k = str;
        return (com.google.android.libraries.navigation.internal.adi.al) akVar.t();
    }

    @Override // com.google.android.libraries.navigation.internal.oe.at
    public final boolean k(com.google.android.libraries.navigation.internal.adi.an anVar) {
        return fy.s(com.google.android.libraries.navigation.internal.adi.an.GMM_TERRAIN, com.google.android.libraries.navigation.internal.adi.an.GMM_TERRAIN_DARK, com.google.android.libraries.navigation.internal.adi.an.GMM_SATELLITE, com.google.android.libraries.navigation.internal.adi.an.GMM_AIR_QUALITY_HEATMAP).contains(anVar);
    }

    @Override // com.google.android.libraries.navigation.internal.oe.at
    public final boolean l(com.google.android.libraries.navigation.internal.adi.an anVar) {
        return fy.u(com.google.android.libraries.navigation.internal.adi.an.GMM_REALTIME, com.google.android.libraries.navigation.internal.adi.an.GMM_TRANSIT, com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BICYCLING_OVERLAY, com.google.android.libraries.navigation.internal.adi.an.GMM_HIGHLIGHT_RAP, com.google.android.libraries.navigation.internal.adi.an.GMM_SPOTLIGHT_HIGHLIGHTING, com.google.android.libraries.navigation.internal.adi.an.GMM_SPOTLIT, com.google.android.libraries.navigation.internal.adi.an.GMM_MAJOR_EVENT, com.google.android.libraries.navigation.internal.adi.an.GMM_COVID19, com.google.android.libraries.navigation.internal.adi.an.GMM_CRISIS_OVERLAY, com.google.android.libraries.navigation.internal.adi.an.GMM_CRISIS_WILDFIRES, com.google.android.libraries.navigation.internal.adi.an.GMM_AIR_QUALITY_HEATMAP).contains(anVar);
    }

    @Override // com.google.android.libraries.navigation.internal.oe.at
    public final boolean m(com.google.android.libraries.navigation.internal.adi.an anVar) {
        return !fy.u(com.google.android.libraries.navigation.internal.adi.an.GMM_TERRAIN, com.google.android.libraries.navigation.internal.adi.an.GMM_TERRAIN_DARK, com.google.android.libraries.navigation.internal.adi.an.GMM_SATELLITE, com.google.android.libraries.navigation.internal.adi.an.GMM_API_TILE_OVERLAY, com.google.android.libraries.navigation.internal.adi.an.GMM_TRANSIT, com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BICYCLING_OVERLAY, com.google.android.libraries.navigation.internal.adi.an.GMM_HIGHLIGHT_RAP, com.google.android.libraries.navigation.internal.adi.an.GMM_AIR_QUALITY_HEATMAP).contains(anVar);
    }

    @Override // com.google.android.libraries.navigation.internal.oe.at
    public final boolean n(com.google.android.libraries.navigation.internal.adi.an anVar) {
        return fy.u(com.google.android.libraries.navigation.internal.adi.an.GMM_SATELLITE, com.google.android.libraries.navigation.internal.adi.an.GMM_API_TILE_OVERLAY, com.google.android.libraries.navigation.internal.adi.an.GMM_SPOTLIGHT_HIGHLIGHTING, com.google.android.libraries.navigation.internal.adi.an.GMM_SPOTLIT, com.google.android.libraries.navigation.internal.adi.an.GMM_MAJOR_EVENT, com.google.android.libraries.navigation.internal.adi.an.GMM_COVID19, com.google.android.libraries.navigation.internal.adi.an.GMM_CRISIS_OVERLAY, com.google.android.libraries.navigation.internal.adi.an.GMM_CRISIS_WILDFIRES, com.google.android.libraries.navigation.internal.adi.an.GMM_AIR_QUALITY_HEATMAP).contains(anVar);
    }

    @Override // com.google.android.libraries.navigation.internal.oe.at
    public final boolean o(com.google.android.libraries.navigation.internal.adi.an anVar) {
        return !f.contains(anVar);
    }

    @Override // com.google.android.libraries.navigation.internal.oe.at
    public final boolean p(com.google.android.libraries.navigation.internal.adi.an anVar) {
        for (com.google.android.libraries.navigation.internal.adi.al alVar : y()) {
            com.google.android.libraries.navigation.internal.adi.an anVarB = com.google.android.libraries.navigation.internal.adi.an.b(alVar.c);
            if (anVarB == null) {
                anVarB = com.google.android.libraries.navigation.internal.adi.an.UNKNOWN;
            }
            if (anVarB == anVar) {
                if ((alVar.b & 32) == 0) {
                    break;
                }
                com.google.android.libraries.navigation.internal.adi.p pVar = alVar.j;
                if (pVar == null) {
                    pVar = com.google.android.libraries.navigation.internal.adi.p.a;
                }
                if (pVar.b) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.at
    public final boolean q(com.google.android.libraries.navigation.internal.adi.an anVar) {
        return e.contains(anVar);
    }

    @Override // com.google.android.libraries.navigation.internal.oe.at
    public final boolean r(com.google.android.libraries.navigation.internal.adi.an anVar) {
        return !c.contains(anVar);
    }

    @Override // com.google.android.libraries.navigation.internal.oe.at
    public final boolean s(com.google.android.libraries.navigation.internal.adi.an anVar) {
        return q(anVar);
    }

    protected final long t(com.google.android.libraries.navigation.internal.adi.an anVar) {
        for (com.google.android.libraries.navigation.internal.adi.al alVar : y()) {
            if ((alVar.b & 8) != 0) {
                com.google.android.libraries.navigation.internal.adi.an anVarB = com.google.android.libraries.navigation.internal.adi.an.b(alVar.c);
                if (anVarB == null) {
                    anVarB = com.google.android.libraries.navigation.internal.adi.an.UNKNOWN;
                }
                if (anVarB == anVar) {
                    if (alVar.h != -1) {
                        return TimeUnit.SECONDS.toMillis(alVar.h);
                    }
                    return -1L;
                }
            }
        }
        no noVar = ((com.google.android.libraries.navigation.internal.om.h) x()).c;
        if (!new bs(noVar.d, no.a).contains(anVar)) {
            for (com.google.android.libraries.navigation.internal.afl.bc bcVar : noVar.e) {
                if (new bs(bcVar.d, com.google.android.libraries.navigation.internal.afl.bc.a).contains(anVar)) {
                    return TimeUnit.SECONDS.toMillis(bcVar.c);
                }
            }
            return TimeUnit.SECONDS.toMillis(noVar.c);
        }
        return -1L;
    }

    public final long u(com.google.android.libraries.navigation.internal.adi.an anVar) {
        long jT = t(anVar);
        return w(anVar) ? jT + a : jT;
    }

    public final long v(com.google.android.libraries.navigation.internal.adi.an anVar) {
        for (com.google.android.libraries.navigation.internal.adi.al alVar : y()) {
            if ((alVar.b & 16) != 0) {
                com.google.android.libraries.navigation.internal.adi.an anVarB = com.google.android.libraries.navigation.internal.adi.an.b(alVar.c);
                if (anVarB == null) {
                    anVarB = com.google.android.libraries.navigation.internal.adi.an.UNKNOWN;
                }
                if (anVarB == anVar) {
                    if (alVar.i != -1) {
                        return TimeUnit.SECONDS.toMillis(alVar.i);
                    }
                    return -1L;
                }
            }
        }
        if (r(anVar)) {
            return w(anVar) ? t(anVar) : TimeUnit.MINUTES.toMillis(((com.google.android.libraries.navigation.internal.om.h) x()).d);
        }
        return -1L;
    }
}
