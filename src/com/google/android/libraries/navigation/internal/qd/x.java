package com.google.android.libraries.navigation.internal.qd;

import android.util.DisplayMetrics;
import com.google.android.libraries.geo.mapcore.internal.model.be;
import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.geo.mapcore.internal.model.ct;
import com.google.android.libraries.geo.mapcore.renderer.ax;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.oe.ap;
import com.google.android.libraries.navigation.internal.oe.aq;
import com.google.android.libraries.navigation.internal.oe.at;
import com.google.android.libraries.navigation.internal.ol.ai;
import com.google.android.libraries.navigation.internal.qu.cf;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.lr;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    private static final com.google.android.libraries.navigation.internal.zb.j x = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.qd.x");
    private final boolean A;
    private final DisplayMetrics B;
    public final ax a;
    public final com.google.android.libraries.navigation.internal.afo.a b;
    public final com.google.android.libraries.geo.mapcore.internal.model.x c;
    public final k d;
    public final com.google.android.libraries.navigation.internal.qf.d e;
    public final cf f;
    public final com.google.android.libraries.navigation.internal.mj.a g;
    public final com.google.android.libraries.navigation.internal.hp.e h;
    public final ScheduledExecutorService i;
    public final Executor j;
    public final com.google.android.libraries.navigation.internal.pg.g k;
    public final ct l;
    public final com.google.android.libraries.navigation.internal.pb.t m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.libraries.navigation.internal.pq.b f549n;
    public final ap o;
    public final ai p;
    public final at q;
    public final aq r;
    public final com.google.android.libraries.navigation.internal.agl.a s;
    public final br t;
    public final com.google.android.libraries.navigation.internal.afo.a u;
    public final boolean v = false;
    public final com.google.android.libraries.navigation.internal.qs.a w;
    private final com.google.android.libraries.navigation.internal.kg.c y;
    private final com.google.android.libraries.navigation.internal.kl.b z;

    public x(ax axVar, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.geo.mapcore.internal.model.x xVar, com.google.android.libraries.navigation.internal.pb.t tVar, ap apVar, cf cfVar, com.google.android.libraries.navigation.internal.pq.b bVar, k kVar, com.google.android.libraries.navigation.internal.qf.d dVar, com.google.android.libraries.navigation.internal.mj.a aVar2, com.google.android.libraries.navigation.internal.hp.e eVar, ScheduledExecutorService scheduledExecutorService, Executor executor, com.google.android.libraries.navigation.internal.pg.g gVar, ct ctVar, com.google.android.libraries.navigation.internal.kg.c cVar, com.google.android.libraries.navigation.internal.kl.b bVar2, boolean z, ai aiVar, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.qs.a aVar4, at atVar, br brVar, com.google.android.libraries.navigation.internal.afo.a aVar5, boolean z2, DisplayMetrics displayMetrics) {
        this.a = axVar;
        this.b = aVar;
        this.c = xVar;
        this.m = tVar;
        this.o = apVar;
        this.f = cfVar;
        this.f549n = bVar;
        this.d = kVar;
        this.e = dVar;
        this.g = aVar2;
        this.h = eVar;
        this.i = scheduledExecutorService;
        this.j = executor;
        this.k = gVar;
        this.l = ctVar;
        this.y = cVar;
        this.z = bVar2;
        this.A = z;
        this.p = aiVar;
        this.s = aVar3;
        this.w = aVar4;
        this.q = atVar;
        this.r = new aq(atVar);
        this.t = brVar;
        this.u = aVar5;
        this.B = displayMetrics;
    }

    public final w a(ap apVar, cg cgVar, com.google.android.libraries.navigation.internal.qq.f fVar) {
        br brVar = this.t;
        com.google.android.libraries.navigation.internal.qv.k kVarB = this.f.b(apVar, cgVar);
        boolean zBooleanValue = ((Boolean) brVar.a()).booleanValue();
        com.google.android.libraries.navigation.internal.qf.d dVar = this.e;
        com.google.android.libraries.navigation.internal.mj.a aVar = this.g;
        Executor executor = this.j;
        at atVar = this.q;
        ax axVar = this.a;
        com.google.android.libraries.navigation.internal.qg.j jVar = new com.google.android.libraries.navigation.internal.qg.j(axVar, this.b, this.c, apVar, cgVar, kVarB, false, 8, null, dVar, aVar, executor, atVar, fVar);
        com.google.android.libraries.navigation.internal.rc.f fVar2 = new com.google.android.libraries.navigation.internal.rc.f(this.h, aVar);
        com.google.android.libraries.navigation.internal.afo.a aVar2 = this.u;
        com.google.android.libraries.navigation.internal.qs.a aVar3 = this.w;
        ScheduledExecutorService scheduledExecutorService = this.i;
        com.google.android.libraries.navigation.internal.pg.g gVar = this.k;
        return new c(axVar, this.m, apVar, cgVar, kVarB, jVar, this.d, dVar, aVar, scheduledExecutorService, gVar, fVar2, 8, true, aVar3, atVar, zBooleanValue, aVar2, false);
    }

    public final w b(ap apVar, cg cgVar, com.google.android.libraries.navigation.internal.qq.f fVar, boolean z) {
        return e(apVar, cgVar, this.f.b(apVar, cgVar), null, z, -1, fVar);
    }

    public final w c(an anVar, cg cgVar, com.google.android.libraries.navigation.internal.qq.f fVar, boolean z) {
        return b(this.r.a(anVar), cgVar, fVar, z);
    }

    public final w d(ap apVar, cg cgVar, com.google.android.libraries.navigation.internal.qv.k kVar, be beVar, boolean z) {
        return e(apVar, cgVar, kVar, beVar, z, -1, com.google.android.libraries.navigation.internal.qq.g.a.a(false));
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0100  */
    /* JADX WARN: Code duplicated, block: B:46:0x0103  */
    /* JADX WARN: Code duplicated, block: B:75:0x01a6  */
    public final w e(ap apVar, cg cgVar, com.google.android.libraries.navigation.internal.qv.k kVar, be beVar, boolean z, int i, com.google.android.libraries.navigation.internal.qq.f fVar) {
        int i2;
        int iRound;
        boolean z2;
        boolean z3;
        if (apVar.c.equals(an.EVCS)) {
            ((com.google.android.libraries.navigation.internal.zb.h) x.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1036)).p("EVCS tiles should use EvcsTileOverlay instead of TileOverlay.");
        }
        at atVar = this.q;
        an anVar = apVar.c;
        boolean z4 = this.A;
        boolean zQ = atVar.q(anVar);
        boolean z5 = z4 && zQ;
        com.google.android.libraries.navigation.internal.qq.f fVarF = fVar.f(((com.google.android.libraries.navigation.internal.qq.b) fVar).d && zQ);
        ax axVar = this.a;
        com.google.android.libraries.navigation.internal.afo.a aVar = this.b;
        com.google.android.libraries.geo.mapcore.internal.model.x xVar = this.c;
        com.google.android.libraries.navigation.internal.pb.t tVar = this.m;
        DisplayMetrics displayMetrics = this.B;
        com.google.android.libraries.navigation.internal.pq.b bVar = this.f549n;
        k kVar2 = this.d;
        com.google.android.libraries.navigation.internal.qf.d dVar = this.e;
        com.google.android.libraries.navigation.internal.mj.a aVar2 = this.g;
        com.google.android.libraries.navigation.internal.hp.e eVar = this.h;
        ScheduledExecutorService scheduledExecutorService = this.i;
        Executor executor = this.j;
        com.google.android.libraries.navigation.internal.pg.g gVar = this.k;
        com.google.android.libraries.navigation.internal.kl.b bVar2 = this.z;
        com.google.android.libraries.navigation.internal.agl.a aVar3 = this.s;
        com.google.android.libraries.navigation.internal.qs.a aVar4 = this.w;
        at atVar2 = this.q;
        boolean zBooleanValue = ((Boolean) this.t.a()).booleanValue();
        com.google.android.libraries.navigation.internal.afo.a aVar5 = this.u;
        an anVar2 = apVar.c;
        int iA = atVar2.a(anVar2);
        boolean zN = atVar2.n(anVar2);
        boolean zL = atVar2.l(anVar2);
        boolean zK = atVar2.k(anVar2);
        boolean zM = atVar2.m(anVar2);
        com.google.android.libraries.navigation.internal.yx.an anVarJ = com.google.android.libraries.navigation.internal.yx.a.a;
        com.google.android.libraries.navigation.internal.yx.an anVarH = atVar2.h(anVar2);
        if (anVarH.g()) {
            anVarJ = com.google.android.libraries.navigation.internal.yx.an.j((Float) ((lr) anVarH.c()).f());
        }
        com.google.android.libraries.navigation.internal.yx.an anVar3 = anVarJ;
        int iOrdinal = anVar2.ordinal();
        int i3 = 2;
        if (iOrdinal == 3) {
            i2 = 4;
        } else if (iOrdinal == 22 || iOrdinal == 24) {
            i2 = i3;
        } else if (iOrdinal != 26) {
            i2 = 8;
            if (iOrdinal != 40) {
                if (iOrdinal == 5) {
                    ar.a(false);
                    i3 = 30;
                } else if (iOrdinal == 6) {
                    i3 = 0;
                } else if (iOrdinal == 9) {
                    i2 = 4;
                } else {
                    if (iOrdinal == 10) {
                        throw new IllegalArgumentException("You are creating a TileOverlay for indoor, you should be creating an IndoorTileOverlay instead.");
                    }
                    switch (iOrdinal) {
                        default:
                            switch (iOrdinal) {
                                case 31:
                                case 32:
                                case 33:
                                case 34:
                                    i3 = i;
                                    break;
                            }
                        case 16:
                        case 17:
                        case 18:
                            i3 = 8;
                            break;
                    }
                }
                i2 = i3;
            } else {
                i3 = 0;
            }
        } else {
            i3 = i;
            i2 = i3;
        }
        ar.q(aVar3);
        com.google.android.libraries.navigation.internal.om.x xVar2 = (com.google.android.libraries.navigation.internal.om.x) aVar3.a();
        if (anVar2 != an.GMM_VECTOR_BASE) {
            if (anVar2 != an.GMM_SATELLITE && anVar2 != an.GMM_AIR_QUALITY_HEATMAP) {
                z2 = z;
            } else {
                if (aVar3 == null) {
                    throw new IllegalArgumentException("TileFetchingConfigSettings can't be null for satellite or AQ heat map tiles.");
                }
                float f = displayMetrics.density;
                float fMax = Math.max(1.0f, (xVar2.b() > 0.0f ? xVar2.b() : 1.0f) * f);
                if (z5) {
                    fMax = Math.max(1.0f, f);
                }
                iRound = Math.round(fMax * 256.0f);
                z2 = z;
            }
            com.google.android.libraries.navigation.internal.qg.j jVar = new com.google.android.libraries.navigation.internal.qg.j(axVar, aVar, xVar, apVar, cgVar, kVar, zN, i2, z2, bVar, dVar, aVar2, executor, atVar2, fVarF, null);
            com.google.android.libraries.navigation.internal.rc.f fVar2 = new com.google.android.libraries.navigation.internal.rc.f(eVar, aVar2);
            if (z2 || !xVar2.i()) {
                z3 = false;
            } else {
                z3 = true;
            }
            return new w(axVar, tVar, apVar, cgVar, kVar, jVar, kVar2, dVar, aVar2, scheduledExecutorService, fVar2, gVar, beVar, bVar2, i3, zL, iRound, zK, zM, aVar3, aVar4, atVar2, zBooleanValue, aVar5, false, z3, xVar2.n(), anVar3);
        }
        z2 = ((com.google.android.libraries.navigation.internal.qq.b) fVarF).e != com.google.android.libraries.navigation.internal.qq.e.r;
        iRound = iA;
        com.google.android.libraries.navigation.internal.qg.j jVar2 = new com.google.android.libraries.navigation.internal.qg.j(axVar, aVar, xVar, apVar, cgVar, kVar, zN, i2, z2, bVar, dVar, aVar2, executor, atVar2, fVarF, null);
        com.google.android.libraries.navigation.internal.rc.f fVar3 = new com.google.android.libraries.navigation.internal.rc.f(eVar, aVar2);
        if (z2) {
            z3 = false;
        } else {
            z3 = false;
        }
        return new w(axVar, tVar, apVar, cgVar, kVar, jVar2, kVar2, dVar, aVar2, scheduledExecutorService, fVar3, gVar, beVar, bVar2, i3, zL, iRound, zK, zM, aVar3, aVar4, atVar2, zBooleanValue, aVar5, false, z3, xVar2.n(), anVar3);
    }

    public final w f(an anVar, cg cgVar) {
        cf cfVar = this.f;
        ap apVarA = this.r.a(anVar);
        return d(apVarA, cgVar, cfVar.b(apVarA, cgVar), null, true);
    }
}
