package com.google.android.libraries.navigation.internal.px;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.renderer.LayeredLabelRenderer;
import com.google.android.libraries.navigation.internal.adg.go;
import com.google.android.libraries.navigation.internal.adg.gq;
import com.google.android.libraries.navigation.internal.adg.hg;
import com.google.android.libraries.navigation.internal.agg.ey;
import com.google.android.libraries.navigation.internal.agi.ge;
import com.google.android.libraries.navigation.internal.agi.gi;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ed implements cs {
    public static final /* synthetic */ int g = 0;
    private long A;
    private final cu B;
    private boolean C;
    private final boolean D;
    private com.google.android.libraries.geo.mapcore.internal.model.aq E;
    private int F;
    private final AtomicReference G;
    private final com.google.android.libraries.navigation.internal.po.dg I;
    private final cv J;
    private final dk K;
    public final eh a;
    public final bj b;
    public final ds c;
    public final cz d;
    public final cd e;
    public volatile boolean f;
    private final by k;
    private final bh l;
    private final ee m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List f544n;
    private final ArrayList o;
    private final eq p;
    private final ca q;
    private final float[] r;
    private final Set s;
    private final ArrayList t;
    private final com.google.android.libraries.navigation.internal.agl.a u;
    private final cf v;
    private final com.google.android.libraries.navigation.internal.pq.b w;
    private final cn x;
    private final com.google.android.libraries.navigation.internal.nt.p y;
    private final aa z;
    private static final da h = di.a;
    private static final dq H = new dq();
    private static final com.google.android.libraries.navigation.internal.qb.f i = new com.google.android.libraries.navigation.internal.qb.f() { // from class: com.google.android.libraries.navigation.internal.px.dn
        /* JADX WARN: Type inference failed for: r2v2, types: [com.google.android.libraries.navigation.internal.px.ek, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v2, types: [com.google.android.libraries.navigation.internal.px.ek, java.lang.Object] */
        @Override // com.google.android.libraries.navigation.internal.qb.f
        public final com.google.android.libraries.navigation.internal.qb.e a(Object obj, Object obj2) {
            int i2 = ed.g;
            ?? r2 = ((com.google.android.libraries.navigation.internal.qb.d) obj).a;
            ?? r3 = ((com.google.android.libraries.navigation.internal.qb.d) obj2).a;
            if (!ei.b(r3, r2)) {
                return com.google.android.libraries.navigation.internal.qb.e.IGNORE;
            }
            ej ejVarI = r3.i();
            com.google.android.libraries.navigation.internal.yx.ar.q(ejVarI);
            ej ejVarI2 = r2.i();
            com.google.android.libraries.navigation.internal.yx.ar.q(ejVarI2);
            return ((z) ejVarI).b > ((z) ejVarI2).b ? com.google.android.libraries.navigation.internal.qb.e.IGNORE : com.google.android.libraries.navigation.internal.qb.e.ENFORCE;
        }
    };
    private static final com.google.android.libraries.navigation.internal.qb.f j = new com.google.android.libraries.navigation.internal.qb.f() { // from class: com.google.android.libraries.navigation.internal.px.do
        @Override // com.google.android.libraries.navigation.internal.qb.f
        public final com.google.android.libraries.navigation.internal.qb.e a(Object obj, Object obj2) {
            return ed.d((com.google.android.libraries.navigation.internal.qb.d) obj, (com.google.android.libraries.navigation.internal.qb.d) obj2);
        }
    };

    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.libraries.navigation.internal.px.dk] */
    public ed(cz czVar, cd cdVar, ca caVar, com.google.android.libraries.navigation.internal.pq.b bVar, bj bjVar, eq eqVar, com.google.android.libraries.navigation.internal.po.dg dgVar, cn cnVar, com.google.android.libraries.navigation.internal.agl.a aVar, bh bhVar, cv cvVar, com.google.android.libraries.navigation.internal.nt.p pVar, com.google.android.libraries.geo.mapcore.internal.model.aq aqVar) {
        ?? r1 = new Object() { // from class: com.google.android.libraries.navigation.internal.px.dk
        };
        this.k = new by();
        this.a = new eh();
        this.m = new ee();
        this.f544n = new ArrayList();
        this.o = new ArrayList();
        this.r = new float[8];
        this.s = new HashSet();
        this.t = new ArrayList();
        this.c = new ds();
        this.v = new cf();
        this.A = -1L;
        boolean z = false;
        this.F = 0;
        this.G = new AtomicReference();
        this.f = false;
        this.d = czVar;
        this.q = caVar;
        this.w = bVar;
        this.u = aVar;
        this.x = cnVar;
        this.e = cdVar;
        this.E = aqVar;
        this.K = r1;
        this.B = new cu();
        this.C = ((com.google.android.libraries.navigation.internal.om.n) aVar.a()).r();
        if (((com.google.android.libraries.navigation.internal.om.n) aVar.a()).f() && LayeredLabelRenderer.b()) {
            z = true;
        }
        this.D = z;
        this.b = bjVar;
        this.p = eqVar;
        this.I = dgVar;
        this.l = bhVar;
        this.J = cvVar;
        this.z = new et();
        this.y = pVar;
    }

    static int c(com.google.android.libraries.navigation.internal.adg.ef efVar, int i2, com.google.android.libraries.geo.mapcore.internal.model.aq aqVar, com.google.android.libraries.navigation.internal.pz.d dVar, boolean z) {
        int iN;
        if (efVar.H()) {
            iN = efVar.n();
        } else {
            int iN2 = efVar.ak;
            if (iN2 == 0) {
                iN2 = efVar.n();
                efVar.ak = iN2;
            }
            iN = iN2;
        }
        if (true == z) {
            i2 = 0;
        }
        return ((((((iN + 31) * 31) + i2) * 31) + aqVar.ordinal()) * 31) + System.identityHashCode(dVar);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.libraries.navigation.internal.px.ek, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.google.android.libraries.navigation.internal.px.ek, java.lang.Object] */
    static /* synthetic */ com.google.android.libraries.navigation.internal.qb.e d(com.google.android.libraries.navigation.internal.qb.d dVar, com.google.android.libraries.navigation.internal.qb.d dVar2) {
        ?? r2 = dVar2.a;
        ?? r1 = dVar.a;
        if (!ei.b(r2, r1)) {
            return com.google.android.libraries.navigation.internal.qb.e.ENFORCE;
        }
        ej ejVarI = r2.i();
        com.google.android.libraries.navigation.internal.yx.ar.q(ejVarI);
        ej ejVarI2 = r1.i();
        com.google.android.libraries.navigation.internal.yx.ar.q(ejVarI2);
        return ((z) ejVarI).b > ((z) ejVarI2).b ? com.google.android.libraries.navigation.internal.qb.e.IGNORE : com.google.android.libraries.navigation.internal.qb.e.ENFORCE;
    }

    /* JADX WARN: Type inference failed for: r9v5, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    private final ai e(int i2) {
        eh ehVar = this.a;
        com.google.android.libraries.navigation.internal.yx.an anVarA = eh.a(i2, 0L, "", ehVar.a, ehVar.b, ehVar.c);
        if (!anVarA.g()) {
            return this.b.m(i2);
        }
        ?? C = ((eb) anVarA.c()).d().c();
        C.C(1);
        return C;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    private final du g(dy dyVar, ek ekVar) {
        int iC = c(ekVar.o(), dyVar.h(), ekVar.k() != null ? ekVar.k().b : ((s) dyVar).c, ((s) dyVar).d, ekVar.J());
        com.google.android.libraries.navigation.internal.yx.an anVarB = this.a.b(iC, ekVar.e(), ekVar.u());
        if (anVarB.g()) {
            eb ebVar = (eb) anVarB.c();
            if (ebVar.d().c().z() == iC) {
                ekVar.o();
                t tVar = new t();
                tVar.f(dz.RENDER_ID_COLLISION);
                tVar.c(ekVar);
                return du.a(iC, tVar.a());
            }
            if (ekVar.e() != 0 && ekVar.e() == ebVar.c().e() && !ei.b(ekVar, ebVar.c()) && !ekVar.N() && !com.google.android.libraries.navigation.internal.rb.a.h(ekVar.W(), 32) && !ebVar.c().N()) {
                t tVar2 = new t();
                tVar2.f(dz.DISALLOWED_DUPLICATE_LABEL);
                tVar2.c(ekVar);
                return du.a(iC, tVar2.a());
            }
        }
        return new du(iC, com.google.android.libraries.navigation.internal.yx.a.a);
    }

    private final eb h(dy dyVar, ai aiVar) {
        eb ebVarI = i(dyVar, aiVar);
        u uVar = (u) ebVarI;
        if (uVar.b.e) {
            aiVar.k();
            aiVar.F(((s) dyVar).b - 1.0f);
        }
        if (!uVar.b.e || !((s) dyVar).e) {
            this.b.k(aiVar);
        }
        return ebVarI;
    }

    /* JADX WARN: Code duplicated, block: B:107:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:113:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:33:0x0081  */
    private final eb i(dy dyVar, ai aiVar) {
        dt dtVarF;
        dv dvVar;
        s sVar = (s) dyVar;
        if (!aiVar.u(this.B, sVar.a)) {
            t tVar = new t();
            tVar.f(dz.LABEL_GEOMETRY_UPDATE_FAILED);
            tVar.c(aiVar.A());
            return tVar.a();
        }
        if (!(aiVar instanceof ah)) {
            int i2 = ((b) aiVar.A()).j ? 2 : 1;
            ek ekVarA = aiVar.A();
            com.google.android.libraries.navigation.internal.qb.d dVar = new com.google.android.libraries.navigation.internal.qb.d(aiVar.A(), aiVar.f());
            com.google.android.libraries.navigation.internal.yx.an anVarI = n(aiVar) ? com.google.android.libraries.navigation.internal.yx.an.i(aiVar.g()) : com.google.android.libraries.navigation.internal.yx.a.a;
            boolean zO = o(aiVar);
            if (anVarI.g()) {
                boolean zV = false;
                if (!ekVarA.am()) {
                    boolean z = ekVarA.an() && !ekVarA.ap();
                    if (!zO && u(dyVar, aiVar, z, i2)) {
                        zV = true;
                    }
                    boolean zT = t(dyVar, aiVar, i2);
                    if (zV || zT) {
                        dtVarF = f(true, zV, zT);
                    } else {
                        dtVarF = ekVarA.ap() ? dt.ONLY_PRIMARY_PLACED : dt.NOTHING_PLACED;
                    }
                } else if (ekVarA.an()) {
                    v(sVar.g, dVar, i, i2);
                    if (!zO && u(dyVar, aiVar, !ekVarA.ap(), i2)) {
                        zV = true;
                    }
                    dtVarF = f(true, zV, t(dyVar, aiVar, i2));
                } else {
                    com.google.android.libraries.navigation.internal.qb.d dVar2 = new com.google.android.libraries.navigation.internal.qb.d(aiVar.A(), (com.google.android.libraries.navigation.internal.qa.b) anVarI.c());
                    boolean z2 = aiVar instanceof ax;
                    boolean zR = z2 ? r(dyVar, (ax) aiVar, false, i2) : sVar.g.b(dVar2, j, i2);
                    boolean zS = z2 ? s(dyVar, (ax) aiVar, i2) : false;
                    com.google.android.libraries.navigation.internal.yx.an anVarI2 = com.google.android.libraries.navigation.internal.yx.an.i(aiVar.h());
                    boolean zV2 = (zR || ekVarA.ap()) ? v(sVar.g, dVar, j, i2) : false;
                    boolean zV3 = (zV2 && zR) ? v(sVar.g, dVar2, i, i2) : false;
                    if (zV2 && zS && anVarI2.g()) {
                        zV = v(sVar.g, new com.google.android.libraries.navigation.internal.qb.d(aiVar.A(), (com.google.android.libraries.navigation.internal.qa.b) anVarI2.c()), i, i2);
                    }
                    dtVarF = f(zV2, zV3, zV);
                }
            } else if (ekVarA.am()) {
                if (v(sVar.g, dVar, ekVarA.an() ? i : j, i2)) {
                    dtVarF = dt.ONLY_PRIMARY_PLACED;
                } else {
                    dtVarF = dt.NOTHING_PLACED;
                }
            } else {
                dtVarF = dt.ONLY_PRIMARY_PLACED;
            }
        } else if (aiVar.h() != null) {
            dtVarF = dt.PRIMARY_SECONDARY_AND_TERTIARY_PLACED;
        } else {
            dtVarF = aiVar.g() != null ? dt.PRIMARY_AND_SECONDARY_PLACED : dt.ONLY_PRIMARY_PLACED;
        }
        if (aiVar.g() != null && !o(aiVar)) {
            aiVar.m(dtVarF.g);
        }
        if (aiVar.h() != null) {
            aiVar.n(dtVarF.h);
        }
        if (dtVarF.f) {
            com.google.android.libraries.navigation.internal.qb.c cVar = sVar.g;
            boolean z3 = dtVarF.g;
            boolean z4 = dtVarF.h;
            com.google.android.libraries.navigation.internal.qa.b bVarF = aiVar.f();
            com.google.android.libraries.navigation.internal.qa.b bVarG = aiVar.g();
            com.google.android.libraries.navigation.internal.qa.b bVarH = aiVar instanceof ax ? ((ax) aiVar).h() : null;
            if (bVarF.e(cVar.b)) {
                dvVar = dv.PLACED_IN_IMPRESSED_AREA;
            } else if (z3) {
                com.google.android.libraries.navigation.internal.yx.ar.q(bVarG);
                if (bVarG.e(cVar.b)) {
                    dvVar = dv.PLACED_IN_IMPRESSED_AREA;
                } else if (z4 || bVarH == null || !bVarH.e(cVar.b)) {
                    dvVar = dv.PLACED_OUTSIDE_IMPRESSED_AREA;
                } else {
                    dvVar = dv.PLACED_IN_IMPRESSED_AREA;
                }
            } else {
                if (z4) {
                }
                dvVar = dv.PLACED_OUTSIDE_IMPRESSED_AREA;
            }
        } else {
            dvVar = dv.TRUMPED;
        }
        com.google.android.libraries.navigation.internal.yx.an anVarJ = dvVar.e ? com.google.android.libraries.navigation.internal.yx.an.j(aiVar) : com.google.android.libraries.navigation.internal.yx.a.a;
        t tVar2 = new t();
        tVar2.c(aiVar.A());
        tVar2.e(dvVar);
        tVar2.d(dz.PLACEMENT_FULLY_DETERMINED);
        tVar2.b(anVarJ);
        eb ebVarA = tVar2.a();
        if (((u) ebVarA).b.e) {
            return ebVarA;
        }
        t tVar3 = new t(ebVarA);
        tVar3.e(dv.TRUMPED);
        return tVar3.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
    
        if (r0.b >= r0.a.c()) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final eb j(dy dyVar, ek ekVar, aa aaVar) throws Throwable {
        int iB = et.b(ekVar.o());
        if (iB != 0) {
            et etVar = (et) aaVar;
            if (etVar.a.c(iB)) {
                es esVarC = etVar.c(ekVar);
                if (esVarC != null) {
                    eu euVar = (eu) etVar.a.p(iB);
                    if (!euVar.c.contains(esVarC)) {
                    }
                }
                t tVar = new t();
                tVar.f(dz.FAILED_BUCKET_RESTRICTIONS_CHECK);
                tVar.c(ekVar);
                return tVar.a();
            }
        }
        eb ebVarK = k(dyVar, ekVar);
        if (ebVarK.a().e) {
            int i2 = com.google.android.libraries.navigation.internal.ph.a.a;
            aaVar.a(ekVar);
        }
        return ebVarK;
    }

    /* JADX WARN: Code duplicated, block: B:113:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:115:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:116:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:118:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:121:0x02ee A[Catch: all -> 0x0466, TryCatch #2 {all -> 0x0466, blocks: (B:119:0x02e0, B:121:0x02ee, B:122:0x02f0, B:125:0x0308, B:129:0x031f), top: B:228:0x02e0 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0302  */
    /* JADX WARN: Code duplicated, block: B:125:0x0308 A[Catch: all -> 0x0466, TRY_LEAVE, TryCatch #2 {all -> 0x0466, blocks: (B:119:0x02e0, B:121:0x02ee, B:122:0x02f0, B:125:0x0308, B:129:0x031f), top: B:228:0x02e0 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x0340 A[Catch: all -> 0x0446, TryCatch #1 {all -> 0x0446, blocks: (B:127:0x0319, B:132:0x0326, B:135:0x032f, B:137:0x0340, B:139:0x0346, B:142:0x034d, B:144:0x0355, B:145:0x0357, B:147:0x0367, B:159:0x037f, B:164:0x03a0, B:167:0x03aa, B:168:0x03b0, B:170:0x03b6, B:176:0x03ce, B:178:0x03d6, B:180:0x03dc, B:189:0x0409, B:173:0x03c7, B:190:0x0445), top: B:227:0x0319 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0346 A[Catch: all -> 0x0446, TryCatch #1 {all -> 0x0446, blocks: (B:127:0x0319, B:132:0x0326, B:135:0x032f, B:137:0x0340, B:139:0x0346, B:142:0x034d, B:144:0x0355, B:145:0x0357, B:147:0x0367, B:159:0x037f, B:164:0x03a0, B:167:0x03aa, B:168:0x03b0, B:170:0x03b6, B:176:0x03ce, B:178:0x03d6, B:180:0x03dc, B:189:0x0409, B:173:0x03c7, B:190:0x0445), top: B:227:0x0319 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x034d A[Catch: all -> 0x0446, TryCatch #1 {all -> 0x0446, blocks: (B:127:0x0319, B:132:0x0326, B:135:0x032f, B:137:0x0340, B:139:0x0346, B:142:0x034d, B:144:0x0355, B:145:0x0357, B:147:0x0367, B:159:0x037f, B:164:0x03a0, B:167:0x03aa, B:168:0x03b0, B:170:0x03b6, B:176:0x03ce, B:178:0x03d6, B:180:0x03dc, B:189:0x0409, B:173:0x03c7, B:190:0x0445), top: B:227:0x0319 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0355 A[Catch: all -> 0x0446, TryCatch #1 {all -> 0x0446, blocks: (B:127:0x0319, B:132:0x0326, B:135:0x032f, B:137:0x0340, B:139:0x0346, B:142:0x034d, B:144:0x0355, B:145:0x0357, B:147:0x0367, B:159:0x037f, B:164:0x03a0, B:167:0x03aa, B:168:0x03b0, B:170:0x03b6, B:176:0x03ce, B:178:0x03d6, B:180:0x03dc, B:189:0x0409, B:173:0x03c7, B:190:0x0445), top: B:227:0x0319 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x0367 A[Catch: all -> 0x0446, TryCatch #1 {all -> 0x0446, blocks: (B:127:0x0319, B:132:0x0326, B:135:0x032f, B:137:0x0340, B:139:0x0346, B:142:0x034d, B:144:0x0355, B:145:0x0357, B:147:0x0367, B:159:0x037f, B:164:0x03a0, B:167:0x03aa, B:168:0x03b0, B:170:0x03b6, B:176:0x03ce, B:178:0x03d6, B:180:0x03dc, B:189:0x0409, B:173:0x03c7, B:190:0x0445), top: B:227:0x0319 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x036b  */
    /* JADX WARN: Code duplicated, block: B:151:0x0370  */
    /* JADX WARN: Code duplicated, block: B:153:0x0373  */
    /* JADX WARN: Code duplicated, block: B:155:0x0376  */
    /* JADX WARN: Code duplicated, block: B:156:0x0377  */
    /* JADX WARN: Code duplicated, block: B:157:0x037a  */
    /* JADX WARN: Code duplicated, block: B:158:0x037d  */
    /* JADX WARN: Code duplicated, block: B:161:0x0399  */
    /* JADX WARN: Code duplicated, block: B:162:0x039c  */
    /* JADX WARN: Code duplicated, block: B:164:0x03a0 A[Catch: all -> 0x0446, TryCatch #1 {all -> 0x0446, blocks: (B:127:0x0319, B:132:0x0326, B:135:0x032f, B:137:0x0340, B:139:0x0346, B:142:0x034d, B:144:0x0355, B:145:0x0357, B:147:0x0367, B:159:0x037f, B:164:0x03a0, B:167:0x03aa, B:168:0x03b0, B:170:0x03b6, B:176:0x03ce, B:178:0x03d6, B:180:0x03dc, B:189:0x0409, B:173:0x03c7, B:190:0x0445), top: B:227:0x0319 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x03b6 A[Catch: all -> 0x0446, TryCatch #1 {all -> 0x0446, blocks: (B:127:0x0319, B:132:0x0326, B:135:0x032f, B:137:0x0340, B:139:0x0346, B:142:0x034d, B:144:0x0355, B:145:0x0357, B:147:0x0367, B:159:0x037f, B:164:0x03a0, B:167:0x03aa, B:168:0x03b0, B:170:0x03b6, B:176:0x03ce, B:178:0x03d6, B:180:0x03dc, B:189:0x0409, B:173:0x03c7, B:190:0x0445), top: B:227:0x0319 }] */
    /* JADX WARN: Code duplicated, block: B:172:0x03c6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:173:0x03c7 A[Catch: all -> 0x0446, TryCatch #1 {all -> 0x0446, blocks: (B:127:0x0319, B:132:0x0326, B:135:0x032f, B:137:0x0340, B:139:0x0346, B:142:0x034d, B:144:0x0355, B:145:0x0357, B:147:0x0367, B:159:0x037f, B:164:0x03a0, B:167:0x03aa, B:168:0x03b0, B:170:0x03b6, B:176:0x03ce, B:178:0x03d6, B:180:0x03dc, B:189:0x0409, B:173:0x03c7, B:190:0x0445), top: B:227:0x0319 }] */
    /* JADX WARN: Code duplicated, block: B:178:0x03d6 A[Catch: all -> 0x0446, TryCatch #1 {all -> 0x0446, blocks: (B:127:0x0319, B:132:0x0326, B:135:0x032f, B:137:0x0340, B:139:0x0346, B:142:0x034d, B:144:0x0355, B:145:0x0357, B:147:0x0367, B:159:0x037f, B:164:0x03a0, B:167:0x03aa, B:168:0x03b0, B:170:0x03b6, B:176:0x03ce, B:178:0x03d6, B:180:0x03dc, B:189:0x0409, B:173:0x03c7, B:190:0x0445), top: B:227:0x0319 }] */
    /* JADX WARN: Code duplicated, block: B:187:0x0405 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:190:0x0445 A[Catch: all -> 0x0446, TRY_LEAVE, TryCatch #1 {all -> 0x0446, blocks: (B:127:0x0319, B:132:0x0326, B:135:0x032f, B:137:0x0340, B:139:0x0346, B:142:0x034d, B:144:0x0355, B:145:0x0357, B:147:0x0367, B:159:0x037f, B:164:0x03a0, B:167:0x03aa, B:168:0x03b0, B:170:0x03b6, B:176:0x03ce, B:178:0x03d6, B:180:0x03dc, B:189:0x0409, B:173:0x03c7, B:190:0x0445), top: B:227:0x0319 }] */
    /* JADX WARN: Code duplicated, block: B:193:0x044a  */
    /* JADX WARN: Code duplicated, block: B:196:0x0450  */
    /* JADX WARN: Code duplicated, block: B:198:0x0455  */
    /* JADX WARN: Code duplicated, block: B:199:0x0460  */
    /* JADX WARN: Code duplicated, block: B:209:0x0475  */
    /* JADX WARN: Code duplicated, block: B:211:0x047a  */
    /* JADX WARN: Code duplicated, block: B:212:0x048c  */
    /* JADX WARN: Code duplicated, block: B:214:0x0496  */
    /* JADX WARN: Code duplicated, block: B:215:0x049d  */
    /* JADX WARN: Code duplicated, block: B:218:0x04af  */
    /* JADX WARN: Code duplicated, block: B:220:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:227:0x0319 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:234:0x03ff A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:236:0x03fb A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:29:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:32:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:34:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:37:0x0131  */
    /* JADX WARN: Code duplicated, block: B:40:0x0138  */
    /* JADX WARN: Code duplicated, block: B:41:0x0141  */
    /* JADX WARN: Code duplicated, block: B:43:0x0149  */
    /* JADX WARN: Code duplicated, block: B:54:0x0163  */
    /* JADX WARN: Code duplicated, block: B:57:0x0169  */
    /* JADX WARN: Code duplicated, block: B:58:0x017f  */
    /* JADX WARN: Code duplicated, block: B:60:0x018b  */
    /* JADX WARN: Code duplicated, block: B:64:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:66:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:67:0x01be  */
    /* JADX WARN: Code duplicated, block: B:70:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:73:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:75:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:78:0x01da  */
    /* JADX WARN: Code duplicated, block: B:80:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:83:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:86:0x0203 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:89:0x0220  */
    /* JADX WARN: Code duplicated, block: B:91:0x0226  */
    /* JADX WARN: Code duplicated, block: B:92:0x022e  */
    /* JADX WARN: Code duplicated, block: B:95:0x023e  */
    private final eb k(dy dyVar, ek ekVar) throws Throwable {
        du duVarG;
        com.google.android.libraries.navigation.internal.yx.an anVar;
        ai aiVarE;
        ed edVar;
        int i2;
        eb ebVarH;
        Object objA;
        com.google.android.libraries.navigation.internal.pz.d dVar;
        int i3;
        int iH;
        cu cuVar;
        com.google.android.libraries.navigation.internal.nw.d dVarB;
        as asVar;
        Integer numValueOf;
        com.google.android.libraries.navigation.internal.adg.dt dtVar;
        com.google.android.libraries.navigation.internal.qc.g gVar;
        com.google.android.libraries.navigation.internal.qe.b bVar;
        com.google.android.libraries.geo.mapcore.internal.model.ai aiVarA;
        com.google.android.libraries.geo.mapcore.internal.model.ai aiVarA2;
        gq gqVar;
        float fA;
        int iA;
        int i4;
        float fA2;
        String str;
        String str2;
        Iterator it2;
        com.google.android.libraries.navigation.internal.adg.dp dpVar;
        com.google.android.libraries.navigation.internal.qc.e eVar;
        com.google.android.libraries.geo.mapcore.internal.model.ai aiVarA3;
        Object objC;
        ai aiVarE2;
        ax axVar;
        s sVar;
        int i5;
        ax axVar2;
        com.google.android.libraries.navigation.internal.ol.bd bdVarA;
        com.google.android.libraries.navigation.internal.adg.ef efVarO;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS;
        eb ebVarH2;
        boolean z;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS2;
        Object objK;
        Object objC2;
        com.google.android.libraries.navigation.internal.adl.x xVar;
        com.google.android.libraries.navigation.internal.adl.s sVar2;
        com.google.android.libraries.navigation.internal.adl.s sVar3;
        boolean zU;
        com.google.android.libraries.navigation.internal.qa.b bVarG;
        int i6;
        com.google.android.libraries.navigation.internal.nw.d dVarB2;
        ek ekVar2 = ekVar;
        if (ekVar.h().h()) {
            s sVar4 = (s) dyVar;
            if (p(sVar4.a.w().l) && com.google.android.libraries.geo.mapcore.internal.model.ay.f(4, ekVar.o().h)) {
                ekVar.o();
                t tVar = new t();
                tVar.f(dz.FAILED_TILT_RENDER_THRESHOLD_CHECK);
                tVar.c(ekVar2);
                objC = tVar.a();
            } else {
                du duVarG2 = g(dyVar, ekVar);
                com.google.android.libraries.navigation.internal.yx.an anVar2 = duVarG2.b;
                if (anVar2.g()) {
                    objC = anVar2.c();
                } else {
                    com.google.android.libraries.geo.mapcore.internal.model.c cVar = ((m) ekVar.h()).a;
                    com.google.android.libraries.navigation.internal.yx.ar.q(cVar);
                    cu cuVar2 = this.B;
                    if (ekVar.an() || !ekVar.h().h()) {
                        aiVarE2 = e(duVarG2.a);
                        if (aiVarE2 != null || (aiVarE2 instanceof ax)) {
                            axVar = (ax) aiVarE2;
                            if (axVar == null) {
                                ca caVar = this.q;
                                com.google.android.libraries.navigation.internal.pz.d dVar2 = sVar4.d;
                                int iH2 = dyVar.h();
                                int i7 = duVarG2.a;
                                boolean z2 = this.D;
                                dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("LabelFactory.createPointLabel");
                                try {
                                    sVar = sVar4;
                                    i5 = 1;
                                    bz bzVarA = caVar.f.a(ekVar, iH2, i7, caVar.c, caVar.b, caVar.d, caVar.e, caVar.a, dVar2, z2);
                                    if (dVarB2 != null) {
                                        Trace.endSection();
                                    }
                                    axVar2 = bzVarA.c;
                                    if (axVar2 != null) {
                                        this.F++;
                                        axVar2.C(1);
                                    } else if (sVar.f.o() && bzVarA == bz.b) {
                                        this.p.c(duVarG2.a);
                                    }
                                    if (axVar2 == null) {
                                        ekVar.o();
                                        t tVar2 = new t();
                                        tVar2.f(dz.GL_LABEL_INIT_FAILURE);
                                        tVar2.c(ekVar2);
                                        objC = tVar2.a();
                                    } else {
                                        bdVarA = this.I.a(ekVar.o());
                                        if (bdVarA != null) {
                                            axVar2.x(bdVarA, false);
                                        }
                                        efVarO = ekVar.o();
                                        bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                                        efVarO.h(bhVarS);
                                        if (efVarO.w.n(bhVarS.d)) {
                                            bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                                            efVarO.h(bhVarS2);
                                            objK = efVarO.w.k(bhVarS2.d);
                                            if (objK == null) {
                                                objC2 = bhVarS2.b;
                                            } else {
                                                objC2 = bhVarS2.c(objK);
                                            }
                                            xVar = (com.google.android.libraries.navigation.internal.adl.x) objC2;
                                            sVar2 = xVar.h;
                                            if (sVar2 == null) {
                                                sVar2 = com.google.android.libraries.navigation.internal.adl.s.a;
                                            }
                                            if ((sVar2.b & 2) == 0) {
                                                if (ekVar.C()) {
                                                    ebVarH2 = i(dyVar, axVar2);
                                                } else {
                                                    ebVarH2 = h(dyVar, axVar2);
                                                }
                                                z = ((u) ebVarH2).b.e;
                                                objC = ebVarH2;
                                                if (!z) {
                                                    axVar2.D(i5);
                                                    return ebVarH2;
                                                }
                                            } else {
                                                sVar3 = xVar.h;
                                                if (sVar3 == null) {
                                                    sVar3 = com.google.android.libraries.navigation.internal.adl.s.a;
                                                }
                                                if (sVar3.c != 0) {
                                                    zU = axVar2.u(this.B, sVar.a);
                                                    bVarG = axVar2.g();
                                                    if (bVarG == null && bVarG.e(sVar.g.b)) {
                                                        i6 = i5;
                                                    } else {
                                                        i6 = 0;
                                                    }
                                                    boolean zE = axVar2.r.e(sVar.g.b);
                                                    if (zU || zE || i6 != 0) {
                                                        if (ekVar.C()) {
                                                            ebVarH2 = i(dyVar, axVar2);
                                                        } else {
                                                            ebVarH2 = h(dyVar, axVar2);
                                                        }
                                                        z = ((u) ebVarH2).b.e;
                                                        objC = ebVarH2;
                                                        if (!z) {
                                                            axVar2.D(i5);
                                                            return ebVarH2;
                                                        }
                                                    } else {
                                                        axVar2.D(i5);
                                                        ekVar.o();
                                                        t tVar3 = new t();
                                                        tVar3.f(dz.OUTSIDE_IMPRESSED_AREA);
                                                        tVar3.c(ekVar2);
                                                        objC = tVar3.a();
                                                    }
                                                } else {
                                                    if (ekVar.C()) {
                                                        ebVarH2 = i(dyVar, axVar2);
                                                    } else {
                                                        ebVarH2 = h(dyVar, axVar2);
                                                    }
                                                    z = ((u) ebVarH2).b.e;
                                                    objC = ebVarH2;
                                                    if (!z) {
                                                        axVar2.D(i5);
                                                        return ebVarH2;
                                                    }
                                                }
                                            }
                                        } else {
                                            if (ekVar.C()) {
                                                ebVarH2 = i(dyVar, axVar2);
                                            } else {
                                                ebVarH2 = h(dyVar, axVar2);
                                            }
                                            z = ((u) ebVarH2).b.e;
                                            objC = ebVarH2;
                                            if (!z) {
                                                axVar2.D(i5);
                                                return ebVarH2;
                                            }
                                        }
                                    }
                                } catch (Throwable th) {
                                    if (dVarB2 == null) {
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
                            } else {
                                sVar = sVar4;
                                i5 = 1;
                            }
                            axVar2 = axVar;
                            if (axVar2 == null) {
                                ekVar.o();
                                t tVar4 = new t();
                                tVar4.f(dz.GL_LABEL_INIT_FAILURE);
                                tVar4.c(ekVar2);
                                objC = tVar4.a();
                            } else {
                                bdVarA = this.I.a(ekVar.o());
                                if (bdVarA != null) {
                                    axVar2.x(bdVarA, false);
                                }
                                efVarO = ekVar.o();
                                bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                                efVarO.h(bhVarS);
                                if (efVarO.w.n(bhVarS.d)) {
                                    if (ekVar.C()) {
                                        ebVarH2 = i(dyVar, axVar2);
                                    } else {
                                        ebVarH2 = h(dyVar, axVar2);
                                    }
                                    z = ((u) ebVarH2).b.e;
                                    objC = ebVarH2;
                                    if (!z) {
                                        axVar2.D(i5);
                                        return ebVarH2;
                                    }
                                } else {
                                    bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                                    efVarO.h(bhVarS2);
                                    objK = efVarO.w.k(bhVarS2.d);
                                    if (objK == null) {
                                        objC2 = bhVarS2.b;
                                    } else {
                                        objC2 = bhVarS2.c(objK);
                                    }
                                    xVar = (com.google.android.libraries.navigation.internal.adl.x) objC2;
                                    sVar2 = xVar.h;
                                    if (sVar2 == null) {
                                        sVar2 = com.google.android.libraries.navigation.internal.adl.s.a;
                                    }
                                    if ((sVar2.b & 2) == 0) {
                                        if (ekVar.C()) {
                                            ebVarH2 = i(dyVar, axVar2);
                                        } else {
                                            ebVarH2 = h(dyVar, axVar2);
                                        }
                                        z = ((u) ebVarH2).b.e;
                                        objC = ebVarH2;
                                        if (!z) {
                                            axVar2.D(i5);
                                            return ebVarH2;
                                        }
                                    } else {
                                        sVar3 = xVar.h;
                                        if (sVar3 == null) {
                                            sVar3 = com.google.android.libraries.navigation.internal.adl.s.a;
                                        }
                                        if (sVar3.c != 0) {
                                            zU = axVar2.u(this.B, sVar.a);
                                            bVarG = axVar2.g();
                                            if (bVarG == null) {
                                                i6 = 0;
                                            } else {
                                                i6 = 0;
                                            }
                                            boolean zE2 = axVar2.r.e(sVar.g.b);
                                            if (zU) {
                                                if (ekVar.C()) {
                                                    ebVarH2 = i(dyVar, axVar2);
                                                } else {
                                                    ebVarH2 = h(dyVar, axVar2);
                                                }
                                                z = ((u) ebVarH2).b.e;
                                                objC = ebVarH2;
                                                if (!z) {
                                                    axVar2.D(i5);
                                                    return ebVarH2;
                                                }
                                            } else {
                                                if (ekVar.C()) {
                                                    ebVarH2 = i(dyVar, axVar2);
                                                } else {
                                                    ebVarH2 = h(dyVar, axVar2);
                                                }
                                                z = ((u) ebVarH2).b.e;
                                                objC = ebVarH2;
                                                if (!z) {
                                                    axVar2.D(i5);
                                                    return ebVarH2;
                                                }
                                            }
                                        } else {
                                            if (ekVar.C()) {
                                                ebVarH2 = i(dyVar, axVar2);
                                            } else {
                                                ebVarH2 = h(dyVar, axVar2);
                                            }
                                            z = ((u) ebVarH2).b.e;
                                            objC = ebVarH2;
                                            if (!z) {
                                                axVar2.D(i5);
                                                return ebVarH2;
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            aiVarE2.D(1);
                            ekVar.o();
                            t tVar5 = new t();
                            tVar5.f(dz.RENDER_ID_COLLISION);
                            tVar5.c(ekVar2);
                            objC = tVar5.a();
                        }
                    } else {
                        float[] fArr = cuVar2.j;
                        if (com.google.android.libraries.navigation.internal.pb.j.m(sVar4.a, cVar.a, fArr)) {
                            float f = fArr[0];
                            float f2 = fArr[1];
                            float fN = sVar4.a.n() * 0.5f;
                            com.google.android.libraries.navigation.internal.qa.b bVar2 = new com.google.android.libraries.navigation.internal.qa.b();
                            bVar2.g(f, f2, 0.0d, fN, fN);
                            if (sVar4.g.b(new com.google.android.libraries.navigation.internal.qb.d(ekVar2, bVar2), j, ekVar.C() ? 2 : 1)) {
                                aiVarE2 = e(duVarG2.a);
                                if (aiVarE2 != null) {
                                    axVar = (ax) aiVarE2;
                                    if (axVar == null) {
                                        ca caVar2 = this.q;
                                        com.google.android.libraries.navigation.internal.pz.d dVar3 = sVar4.d;
                                        int iH3 = dyVar.h();
                                        int i8 = duVarG2.a;
                                        boolean z3 = this.D;
                                        dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("LabelFactory.createPointLabel");
                                        sVar = sVar4;
                                        i5 = 1;
                                        bz bzVarA2 = caVar2.f.a(ekVar, iH3, i8, caVar2.c, caVar2.b, caVar2.d, caVar2.e, caVar2.a, dVar3, z3);
                                        if (dVarB2 != null) {
                                            Trace.endSection();
                                        }
                                        axVar2 = bzVarA2.c;
                                        if (axVar2 != null) {
                                            this.F++;
                                            axVar2.C(1);
                                        } else if (sVar.f.o()) {
                                            this.p.c(duVarG2.a);
                                        }
                                        if (axVar2 == null) {
                                            ekVar.o();
                                            t tVar6 = new t();
                                            tVar6.f(dz.GL_LABEL_INIT_FAILURE);
                                            tVar6.c(ekVar2);
                                            objC = tVar6.a();
                                        } else {
                                            bdVarA = this.I.a(ekVar.o());
                                            if (bdVarA != null) {
                                                axVar2.x(bdVarA, false);
                                            }
                                            efVarO = ekVar.o();
                                            bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                                            efVarO.h(bhVarS);
                                            if (efVarO.w.n(bhVarS.d)) {
                                                if (ekVar.C()) {
                                                    ebVarH2 = i(dyVar, axVar2);
                                                } else {
                                                    ebVarH2 = h(dyVar, axVar2);
                                                }
                                                z = ((u) ebVarH2).b.e;
                                                objC = ebVarH2;
                                                if (!z) {
                                                    axVar2.D(i5);
                                                    return ebVarH2;
                                                }
                                            } else {
                                                bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                                                efVarO.h(bhVarS2);
                                                objK = efVarO.w.k(bhVarS2.d);
                                                if (objK == null) {
                                                    objC2 = bhVarS2.b;
                                                } else {
                                                    objC2 = bhVarS2.c(objK);
                                                }
                                                xVar = (com.google.android.libraries.navigation.internal.adl.x) objC2;
                                                sVar2 = xVar.h;
                                                if (sVar2 == null) {
                                                    sVar2 = com.google.android.libraries.navigation.internal.adl.s.a;
                                                }
                                                if ((sVar2.b & 2) == 0) {
                                                    if (ekVar.C()) {
                                                        ebVarH2 = i(dyVar, axVar2);
                                                    } else {
                                                        ebVarH2 = h(dyVar, axVar2);
                                                    }
                                                    z = ((u) ebVarH2).b.e;
                                                    objC = ebVarH2;
                                                    if (!z) {
                                                        axVar2.D(i5);
                                                        return ebVarH2;
                                                    }
                                                } else {
                                                    sVar3 = xVar.h;
                                                    if (sVar3 == null) {
                                                        sVar3 = com.google.android.libraries.navigation.internal.adl.s.a;
                                                    }
                                                    if (sVar3.c != 0) {
                                                        zU = axVar2.u(this.B, sVar.a);
                                                        bVarG = axVar2.g();
                                                        if (bVarG == null) {
                                                            i6 = 0;
                                                        } else {
                                                            i6 = 0;
                                                        }
                                                        boolean zE3 = axVar2.r.e(sVar.g.b);
                                                        if (zU) {
                                                            if (ekVar.C()) {
                                                                ebVarH2 = i(dyVar, axVar2);
                                                            } else {
                                                                ebVarH2 = h(dyVar, axVar2);
                                                            }
                                                            z = ((u) ebVarH2).b.e;
                                                            objC = ebVarH2;
                                                            if (!z) {
                                                                axVar2.D(i5);
                                                                return ebVarH2;
                                                            }
                                                        } else {
                                                            if (ekVar.C()) {
                                                                ebVarH2 = i(dyVar, axVar2);
                                                            } else {
                                                                ebVarH2 = h(dyVar, axVar2);
                                                            }
                                                            z = ((u) ebVarH2).b.e;
                                                            objC = ebVarH2;
                                                            if (!z) {
                                                                axVar2.D(i5);
                                                                return ebVarH2;
                                                            }
                                                        }
                                                    } else {
                                                        if (ekVar.C()) {
                                                            ebVarH2 = i(dyVar, axVar2);
                                                        } else {
                                                            ebVarH2 = h(dyVar, axVar2);
                                                        }
                                                        z = ((u) ebVarH2).b.e;
                                                        objC = ebVarH2;
                                                        if (!z) {
                                                            axVar2.D(i5);
                                                            return ebVarH2;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        sVar = sVar4;
                                        i5 = 1;
                                    }
                                    axVar2 = axVar;
                                    if (axVar2 == null) {
                                        ekVar.o();
                                        t tVar7 = new t();
                                        tVar7.f(dz.GL_LABEL_INIT_FAILURE);
                                        tVar7.c(ekVar2);
                                        objC = tVar7.a();
                                    } else {
                                        bdVarA = this.I.a(ekVar.o());
                                        if (bdVarA != null) {
                                            axVar2.x(bdVarA, false);
                                        }
                                        efVarO = ekVar.o();
                                        bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                                        efVarO.h(bhVarS);
                                        if (efVarO.w.n(bhVarS.d)) {
                                            if (ekVar.C()) {
                                                ebVarH2 = i(dyVar, axVar2);
                                            } else {
                                                ebVarH2 = h(dyVar, axVar2);
                                            }
                                            z = ((u) ebVarH2).b.e;
                                            objC = ebVarH2;
                                            if (!z) {
                                                axVar2.D(i5);
                                                return ebVarH2;
                                            }
                                        } else {
                                            bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                                            efVarO.h(bhVarS2);
                                            objK = efVarO.w.k(bhVarS2.d);
                                            if (objK == null) {
                                                objC2 = bhVarS2.b;
                                            } else {
                                                objC2 = bhVarS2.c(objK);
                                            }
                                            xVar = (com.google.android.libraries.navigation.internal.adl.x) objC2;
                                            sVar2 = xVar.h;
                                            if (sVar2 == null) {
                                                sVar2 = com.google.android.libraries.navigation.internal.adl.s.a;
                                            }
                                            if ((sVar2.b & 2) == 0) {
                                                if (ekVar.C()) {
                                                    ebVarH2 = i(dyVar, axVar2);
                                                } else {
                                                    ebVarH2 = h(dyVar, axVar2);
                                                }
                                                z = ((u) ebVarH2).b.e;
                                                objC = ebVarH2;
                                                if (!z) {
                                                    axVar2.D(i5);
                                                    return ebVarH2;
                                                }
                                            } else {
                                                sVar3 = xVar.h;
                                                if (sVar3 == null) {
                                                    sVar3 = com.google.android.libraries.navigation.internal.adl.s.a;
                                                }
                                                if (sVar3.c != 0) {
                                                    zU = axVar2.u(this.B, sVar.a);
                                                    bVarG = axVar2.g();
                                                    if (bVarG == null) {
                                                        i6 = 0;
                                                    } else {
                                                        i6 = 0;
                                                    }
                                                    boolean zE4 = axVar2.r.e(sVar.g.b);
                                                    if (zU) {
                                                        if (ekVar.C()) {
                                                            ebVarH2 = i(dyVar, axVar2);
                                                        } else {
                                                            ebVarH2 = h(dyVar, axVar2);
                                                        }
                                                        z = ((u) ebVarH2).b.e;
                                                        objC = ebVarH2;
                                                        if (!z) {
                                                            axVar2.D(i5);
                                                            return ebVarH2;
                                                        }
                                                    } else {
                                                        if (ekVar.C()) {
                                                            ebVarH2 = i(dyVar, axVar2);
                                                        } else {
                                                            ebVarH2 = h(dyVar, axVar2);
                                                        }
                                                        z = ((u) ebVarH2).b.e;
                                                        objC = ebVarH2;
                                                        if (!z) {
                                                            axVar2.D(i5);
                                                            return ebVarH2;
                                                        }
                                                    }
                                                } else {
                                                    if (ekVar.C()) {
                                                        ebVarH2 = i(dyVar, axVar2);
                                                    } else {
                                                        ebVarH2 = h(dyVar, axVar2);
                                                    }
                                                    z = ((u) ebVarH2).b.e;
                                                    objC = ebVarH2;
                                                    if (!z) {
                                                        axVar2.D(i5);
                                                        return ebVarH2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    axVar = (ax) aiVarE2;
                                    if (axVar == null) {
                                        ca caVar3 = this.q;
                                        com.google.android.libraries.navigation.internal.pz.d dVar4 = sVar4.d;
                                        int iH4 = dyVar.h();
                                        int i9 = duVarG2.a;
                                        boolean z4 = this.D;
                                        dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("LabelFactory.createPointLabel");
                                        sVar = sVar4;
                                        i5 = 1;
                                        bz bzVarA3 = caVar3.f.a(ekVar, iH4, i9, caVar3.c, caVar3.b, caVar3.d, caVar3.e, caVar3.a, dVar4, z4);
                                        if (dVarB2 != null) {
                                            Trace.endSection();
                                        }
                                        axVar2 = bzVarA3.c;
                                        if (axVar2 != null) {
                                            this.F++;
                                            axVar2.C(1);
                                        } else if (sVar.f.o()) {
                                            this.p.c(duVarG2.a);
                                        }
                                        if (axVar2 == null) {
                                            ekVar.o();
                                            t tVar8 = new t();
                                            tVar8.f(dz.GL_LABEL_INIT_FAILURE);
                                            tVar8.c(ekVar2);
                                            objC = tVar8.a();
                                        } else {
                                            bdVarA = this.I.a(ekVar.o());
                                            if (bdVarA != null) {
                                                axVar2.x(bdVarA, false);
                                            }
                                            efVarO = ekVar.o();
                                            bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                                            efVarO.h(bhVarS);
                                            if (efVarO.w.n(bhVarS.d)) {
                                                if (ekVar.C()) {
                                                    ebVarH2 = i(dyVar, axVar2);
                                                } else {
                                                    ebVarH2 = h(dyVar, axVar2);
                                                }
                                                z = ((u) ebVarH2).b.e;
                                                objC = ebVarH2;
                                                if (!z) {
                                                    axVar2.D(i5);
                                                    return ebVarH2;
                                                }
                                            } else {
                                                bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                                                efVarO.h(bhVarS2);
                                                objK = efVarO.w.k(bhVarS2.d);
                                                if (objK == null) {
                                                    objC2 = bhVarS2.b;
                                                } else {
                                                    objC2 = bhVarS2.c(objK);
                                                }
                                                xVar = (com.google.android.libraries.navigation.internal.adl.x) objC2;
                                                sVar2 = xVar.h;
                                                if (sVar2 == null) {
                                                    sVar2 = com.google.android.libraries.navigation.internal.adl.s.a;
                                                }
                                                if ((sVar2.b & 2) == 0) {
                                                    if (ekVar.C()) {
                                                        ebVarH2 = i(dyVar, axVar2);
                                                    } else {
                                                        ebVarH2 = h(dyVar, axVar2);
                                                    }
                                                    z = ((u) ebVarH2).b.e;
                                                    objC = ebVarH2;
                                                    if (!z) {
                                                        axVar2.D(i5);
                                                        return ebVarH2;
                                                    }
                                                } else {
                                                    sVar3 = xVar.h;
                                                    if (sVar3 == null) {
                                                        sVar3 = com.google.android.libraries.navigation.internal.adl.s.a;
                                                    }
                                                    if (sVar3.c != 0) {
                                                        zU = axVar2.u(this.B, sVar.a);
                                                        bVarG = axVar2.g();
                                                        if (bVarG == null) {
                                                            i6 = 0;
                                                        } else {
                                                            i6 = 0;
                                                        }
                                                        boolean zE5 = axVar2.r.e(sVar.g.b);
                                                        if (zU) {
                                                            if (ekVar.C()) {
                                                                ebVarH2 = i(dyVar, axVar2);
                                                            } else {
                                                                ebVarH2 = h(dyVar, axVar2);
                                                            }
                                                            z = ((u) ebVarH2).b.e;
                                                            objC = ebVarH2;
                                                            if (!z) {
                                                                axVar2.D(i5);
                                                                return ebVarH2;
                                                            }
                                                        } else {
                                                            if (ekVar.C()) {
                                                                ebVarH2 = i(dyVar, axVar2);
                                                            } else {
                                                                ebVarH2 = h(dyVar, axVar2);
                                                            }
                                                            z = ((u) ebVarH2).b.e;
                                                            objC = ebVarH2;
                                                            if (!z) {
                                                                axVar2.D(i5);
                                                                return ebVarH2;
                                                            }
                                                        }
                                                    } else {
                                                        if (ekVar.C()) {
                                                            ebVarH2 = i(dyVar, axVar2);
                                                        } else {
                                                            ebVarH2 = h(dyVar, axVar2);
                                                        }
                                                        z = ((u) ebVarH2).b.e;
                                                        objC = ebVarH2;
                                                        if (!z) {
                                                            axVar2.D(i5);
                                                            return ebVarH2;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        sVar = sVar4;
                                        i5 = 1;
                                    }
                                    axVar2 = axVar;
                                    if (axVar2 == null) {
                                        ekVar.o();
                                        t tVar9 = new t();
                                        tVar9.f(dz.GL_LABEL_INIT_FAILURE);
                                        tVar9.c(ekVar2);
                                        objC = tVar9.a();
                                    } else {
                                        bdVarA = this.I.a(ekVar.o());
                                        if (bdVarA != null) {
                                            axVar2.x(bdVarA, false);
                                        }
                                        efVarO = ekVar.o();
                                        bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                                        efVarO.h(bhVarS);
                                        if (efVarO.w.n(bhVarS.d)) {
                                            if (ekVar.C()) {
                                                ebVarH2 = i(dyVar, axVar2);
                                            } else {
                                                ebVarH2 = h(dyVar, axVar2);
                                            }
                                            z = ((u) ebVarH2).b.e;
                                            objC = ebVarH2;
                                            if (!z) {
                                                axVar2.D(i5);
                                                return ebVarH2;
                                            }
                                        } else {
                                            bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                                            efVarO.h(bhVarS2);
                                            objK = efVarO.w.k(bhVarS2.d);
                                            if (objK == null) {
                                                objC2 = bhVarS2.b;
                                            } else {
                                                objC2 = bhVarS2.c(objK);
                                            }
                                            xVar = (com.google.android.libraries.navigation.internal.adl.x) objC2;
                                            sVar2 = xVar.h;
                                            if (sVar2 == null) {
                                                sVar2 = com.google.android.libraries.navigation.internal.adl.s.a;
                                            }
                                            if ((sVar2.b & 2) == 0) {
                                                if (ekVar.C()) {
                                                    ebVarH2 = i(dyVar, axVar2);
                                                } else {
                                                    ebVarH2 = h(dyVar, axVar2);
                                                }
                                                z = ((u) ebVarH2).b.e;
                                                objC = ebVarH2;
                                                if (!z) {
                                                    axVar2.D(i5);
                                                    return ebVarH2;
                                                }
                                            } else {
                                                sVar3 = xVar.h;
                                                if (sVar3 == null) {
                                                    sVar3 = com.google.android.libraries.navigation.internal.adl.s.a;
                                                }
                                                if (sVar3.c != 0) {
                                                    zU = axVar2.u(this.B, sVar.a);
                                                    bVarG = axVar2.g();
                                                    if (bVarG == null) {
                                                        i6 = 0;
                                                    } else {
                                                        i6 = 0;
                                                    }
                                                    boolean zE6 = axVar2.r.e(sVar.g.b);
                                                    if (zU) {
                                                        if (ekVar.C()) {
                                                            ebVarH2 = i(dyVar, axVar2);
                                                        } else {
                                                            ebVarH2 = h(dyVar, axVar2);
                                                        }
                                                        z = ((u) ebVarH2).b.e;
                                                        objC = ebVarH2;
                                                        if (!z) {
                                                            axVar2.D(i5);
                                                            return ebVarH2;
                                                        }
                                                    } else {
                                                        if (ekVar.C()) {
                                                            ebVarH2 = i(dyVar, axVar2);
                                                        } else {
                                                            ebVarH2 = h(dyVar, axVar2);
                                                        }
                                                        z = ((u) ebVarH2).b.e;
                                                        objC = ebVarH2;
                                                        if (!z) {
                                                            axVar2.D(i5);
                                                            return ebVarH2;
                                                        }
                                                    }
                                                } else {
                                                    if (ekVar.C()) {
                                                        ebVarH2 = i(dyVar, axVar2);
                                                    } else {
                                                        ebVarH2 = h(dyVar, axVar2);
                                                    }
                                                    z = ((u) ebVarH2).b.e;
                                                    objC = ebVarH2;
                                                    if (!z) {
                                                        axVar2.D(i5);
                                                        return ebVarH2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                ekVar.o();
                                t tVar10 = new t();
                                tVar10.f(dz.ANCHOR_POINT_OBSCURED);
                                tVar10.e(dv.TRUMPED);
                                tVar10.c(ekVar2);
                                objC = tVar10.a();
                            }
                        } else {
                            aiVarE2 = e(duVarG2.a);
                            if (aiVarE2 != null) {
                                axVar = (ax) aiVarE2;
                                if (axVar == null) {
                                    ca caVar4 = this.q;
                                    com.google.android.libraries.navigation.internal.pz.d dVar5 = sVar4.d;
                                    int iH5 = dyVar.h();
                                    int i10 = duVarG2.a;
                                    boolean z5 = this.D;
                                    dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("LabelFactory.createPointLabel");
                                    sVar = sVar4;
                                    i5 = 1;
                                    bz bzVarA4 = caVar4.f.a(ekVar, iH5, i10, caVar4.c, caVar4.b, caVar4.d, caVar4.e, caVar4.a, dVar5, z5);
                                    if (dVarB2 != null) {
                                        Trace.endSection();
                                    }
                                    axVar2 = bzVarA4.c;
                                    if (axVar2 != null) {
                                        this.F++;
                                        axVar2.C(1);
                                    } else if (sVar.f.o()) {
                                        this.p.c(duVarG2.a);
                                    }
                                    if (axVar2 == null) {
                                        ekVar.o();
                                        t tVar11 = new t();
                                        tVar11.f(dz.GL_LABEL_INIT_FAILURE);
                                        tVar11.c(ekVar2);
                                        objC = tVar11.a();
                                    } else {
                                        bdVarA = this.I.a(ekVar.o());
                                        if (bdVarA != null) {
                                            axVar2.x(bdVarA, false);
                                        }
                                        efVarO = ekVar.o();
                                        bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                                        efVarO.h(bhVarS);
                                        if (efVarO.w.n(bhVarS.d)) {
                                            if (ekVar.C()) {
                                                ebVarH2 = i(dyVar, axVar2);
                                            } else {
                                                ebVarH2 = h(dyVar, axVar2);
                                            }
                                            z = ((u) ebVarH2).b.e;
                                            objC = ebVarH2;
                                            if (!z) {
                                                axVar2.D(i5);
                                                return ebVarH2;
                                            }
                                        } else {
                                            bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                                            efVarO.h(bhVarS2);
                                            objK = efVarO.w.k(bhVarS2.d);
                                            if (objK == null) {
                                                objC2 = bhVarS2.b;
                                            } else {
                                                objC2 = bhVarS2.c(objK);
                                            }
                                            xVar = (com.google.android.libraries.navigation.internal.adl.x) objC2;
                                            sVar2 = xVar.h;
                                            if (sVar2 == null) {
                                                sVar2 = com.google.android.libraries.navigation.internal.adl.s.a;
                                            }
                                            if ((sVar2.b & 2) == 0) {
                                                if (ekVar.C()) {
                                                    ebVarH2 = i(dyVar, axVar2);
                                                } else {
                                                    ebVarH2 = h(dyVar, axVar2);
                                                }
                                                z = ((u) ebVarH2).b.e;
                                                objC = ebVarH2;
                                                if (!z) {
                                                    axVar2.D(i5);
                                                    return ebVarH2;
                                                }
                                            } else {
                                                sVar3 = xVar.h;
                                                if (sVar3 == null) {
                                                    sVar3 = com.google.android.libraries.navigation.internal.adl.s.a;
                                                }
                                                if (sVar3.c != 0) {
                                                    zU = axVar2.u(this.B, sVar.a);
                                                    bVarG = axVar2.g();
                                                    if (bVarG == null) {
                                                        i6 = 0;
                                                    } else {
                                                        i6 = 0;
                                                    }
                                                    boolean zE7 = axVar2.r.e(sVar.g.b);
                                                    if (zU) {
                                                        if (ekVar.C()) {
                                                            ebVarH2 = i(dyVar, axVar2);
                                                        } else {
                                                            ebVarH2 = h(dyVar, axVar2);
                                                        }
                                                        z = ((u) ebVarH2).b.e;
                                                        objC = ebVarH2;
                                                        if (!z) {
                                                            axVar2.D(i5);
                                                            return ebVarH2;
                                                        }
                                                    } else {
                                                        if (ekVar.C()) {
                                                            ebVarH2 = i(dyVar, axVar2);
                                                        } else {
                                                            ebVarH2 = h(dyVar, axVar2);
                                                        }
                                                        z = ((u) ebVarH2).b.e;
                                                        objC = ebVarH2;
                                                        if (!z) {
                                                            axVar2.D(i5);
                                                            return ebVarH2;
                                                        }
                                                    }
                                                } else {
                                                    if (ekVar.C()) {
                                                        ebVarH2 = i(dyVar, axVar2);
                                                    } else {
                                                        ebVarH2 = h(dyVar, axVar2);
                                                    }
                                                    z = ((u) ebVarH2).b.e;
                                                    objC = ebVarH2;
                                                    if (!z) {
                                                        axVar2.D(i5);
                                                        return ebVarH2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    sVar = sVar4;
                                    i5 = 1;
                                }
                                axVar2 = axVar;
                                if (axVar2 == null) {
                                    ekVar.o();
                                    t tVar12 = new t();
                                    tVar12.f(dz.GL_LABEL_INIT_FAILURE);
                                    tVar12.c(ekVar2);
                                    objC = tVar12.a();
                                } else {
                                    bdVarA = this.I.a(ekVar.o());
                                    if (bdVarA != null) {
                                        axVar2.x(bdVarA, false);
                                    }
                                    efVarO = ekVar.o();
                                    bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                                    efVarO.h(bhVarS);
                                    if (efVarO.w.n(bhVarS.d)) {
                                        if (ekVar.C()) {
                                            ebVarH2 = i(dyVar, axVar2);
                                        } else {
                                            ebVarH2 = h(dyVar, axVar2);
                                        }
                                        z = ((u) ebVarH2).b.e;
                                        objC = ebVarH2;
                                        if (!z) {
                                            axVar2.D(i5);
                                            return ebVarH2;
                                        }
                                    } else {
                                        bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                                        efVarO.h(bhVarS2);
                                        objK = efVarO.w.k(bhVarS2.d);
                                        if (objK == null) {
                                            objC2 = bhVarS2.b;
                                        } else {
                                            objC2 = bhVarS2.c(objK);
                                        }
                                        xVar = (com.google.android.libraries.navigation.internal.adl.x) objC2;
                                        sVar2 = xVar.h;
                                        if (sVar2 == null) {
                                            sVar2 = com.google.android.libraries.navigation.internal.adl.s.a;
                                        }
                                        if ((sVar2.b & 2) == 0) {
                                            if (ekVar.C()) {
                                                ebVarH2 = i(dyVar, axVar2);
                                            } else {
                                                ebVarH2 = h(dyVar, axVar2);
                                            }
                                            z = ((u) ebVarH2).b.e;
                                            objC = ebVarH2;
                                            if (!z) {
                                                axVar2.D(i5);
                                                return ebVarH2;
                                            }
                                        } else {
                                            sVar3 = xVar.h;
                                            if (sVar3 == null) {
                                                sVar3 = com.google.android.libraries.navigation.internal.adl.s.a;
                                            }
                                            if (sVar3.c != 0) {
                                                zU = axVar2.u(this.B, sVar.a);
                                                bVarG = axVar2.g();
                                                if (bVarG == null) {
                                                    i6 = 0;
                                                } else {
                                                    i6 = 0;
                                                }
                                                boolean zE8 = axVar2.r.e(sVar.g.b);
                                                if (zU) {
                                                    if (ekVar.C()) {
                                                        ebVarH2 = i(dyVar, axVar2);
                                                    } else {
                                                        ebVarH2 = h(dyVar, axVar2);
                                                    }
                                                    z = ((u) ebVarH2).b.e;
                                                    objC = ebVarH2;
                                                    if (!z) {
                                                        axVar2.D(i5);
                                                        return ebVarH2;
                                                    }
                                                } else {
                                                    if (ekVar.C()) {
                                                        ebVarH2 = i(dyVar, axVar2);
                                                    } else {
                                                        ebVarH2 = h(dyVar, axVar2);
                                                    }
                                                    z = ((u) ebVarH2).b.e;
                                                    objC = ebVarH2;
                                                    if (!z) {
                                                        axVar2.D(i5);
                                                        return ebVarH2;
                                                    }
                                                }
                                            } else {
                                                if (ekVar.C()) {
                                                    ebVarH2 = i(dyVar, axVar2);
                                                } else {
                                                    ebVarH2 = h(dyVar, axVar2);
                                                }
                                                z = ((u) ebVarH2).b.e;
                                                objC = ebVarH2;
                                                if (!z) {
                                                    axVar2.D(i5);
                                                    return ebVarH2;
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                axVar = (ax) aiVarE2;
                                if (axVar == null) {
                                    ca caVar5 = this.q;
                                    com.google.android.libraries.navigation.internal.pz.d dVar6 = sVar4.d;
                                    int iH6 = dyVar.h();
                                    int i11 = duVarG2.a;
                                    boolean z6 = this.D;
                                    dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("LabelFactory.createPointLabel");
                                    sVar = sVar4;
                                    i5 = 1;
                                    bz bzVarA5 = caVar5.f.a(ekVar, iH6, i11, caVar5.c, caVar5.b, caVar5.d, caVar5.e, caVar5.a, dVar6, z6);
                                    if (dVarB2 != null) {
                                        Trace.endSection();
                                    }
                                    axVar2 = bzVarA5.c;
                                    if (axVar2 != null) {
                                        this.F++;
                                        axVar2.C(1);
                                    } else if (sVar.f.o()) {
                                        this.p.c(duVarG2.a);
                                    }
                                    if (axVar2 == null) {
                                        ekVar.o();
                                        t tVar13 = new t();
                                        tVar13.f(dz.GL_LABEL_INIT_FAILURE);
                                        tVar13.c(ekVar2);
                                        objC = tVar13.a();
                                    } else {
                                        bdVarA = this.I.a(ekVar.o());
                                        if (bdVarA != null) {
                                            axVar2.x(bdVarA, false);
                                        }
                                        efVarO = ekVar.o();
                                        bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                                        efVarO.h(bhVarS);
                                        if (efVarO.w.n(bhVarS.d)) {
                                            if (ekVar.C()) {
                                                ebVarH2 = i(dyVar, axVar2);
                                            } else {
                                                ebVarH2 = h(dyVar, axVar2);
                                            }
                                            z = ((u) ebVarH2).b.e;
                                            objC = ebVarH2;
                                            if (!z) {
                                                axVar2.D(i5);
                                                return ebVarH2;
                                            }
                                        } else {
                                            bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                                            efVarO.h(bhVarS2);
                                            objK = efVarO.w.k(bhVarS2.d);
                                            if (objK == null) {
                                                objC2 = bhVarS2.b;
                                            } else {
                                                objC2 = bhVarS2.c(objK);
                                            }
                                            xVar = (com.google.android.libraries.navigation.internal.adl.x) objC2;
                                            sVar2 = xVar.h;
                                            if (sVar2 == null) {
                                                sVar2 = com.google.android.libraries.navigation.internal.adl.s.a;
                                            }
                                            if ((sVar2.b & 2) == 0) {
                                                if (ekVar.C()) {
                                                    ebVarH2 = i(dyVar, axVar2);
                                                } else {
                                                    ebVarH2 = h(dyVar, axVar2);
                                                }
                                                z = ((u) ebVarH2).b.e;
                                                objC = ebVarH2;
                                                if (!z) {
                                                    axVar2.D(i5);
                                                    return ebVarH2;
                                                }
                                            } else {
                                                sVar3 = xVar.h;
                                                if (sVar3 == null) {
                                                    sVar3 = com.google.android.libraries.navigation.internal.adl.s.a;
                                                }
                                                if (sVar3.c != 0) {
                                                    zU = axVar2.u(this.B, sVar.a);
                                                    bVarG = axVar2.g();
                                                    if (bVarG == null) {
                                                        i6 = 0;
                                                    } else {
                                                        i6 = 0;
                                                    }
                                                    boolean zE9 = axVar2.r.e(sVar.g.b);
                                                    if (zU) {
                                                        if (ekVar.C()) {
                                                            ebVarH2 = i(dyVar, axVar2);
                                                        } else {
                                                            ebVarH2 = h(dyVar, axVar2);
                                                        }
                                                        z = ((u) ebVarH2).b.e;
                                                        objC = ebVarH2;
                                                        if (!z) {
                                                            axVar2.D(i5);
                                                            return ebVarH2;
                                                        }
                                                    } else {
                                                        if (ekVar.C()) {
                                                            ebVarH2 = i(dyVar, axVar2);
                                                        } else {
                                                            ebVarH2 = h(dyVar, axVar2);
                                                        }
                                                        z = ((u) ebVarH2).b.e;
                                                        objC = ebVarH2;
                                                        if (!z) {
                                                            axVar2.D(i5);
                                                            return ebVarH2;
                                                        }
                                                    }
                                                } else {
                                                    if (ekVar.C()) {
                                                        ebVarH2 = i(dyVar, axVar2);
                                                    } else {
                                                        ebVarH2 = h(dyVar, axVar2);
                                                    }
                                                    z = ((u) ebVarH2).b.e;
                                                    objC = ebVarH2;
                                                    if (!z) {
                                                        axVar2.D(i5);
                                                        return ebVarH2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    sVar = sVar4;
                                    i5 = 1;
                                }
                                axVar2 = axVar;
                                if (axVar2 == null) {
                                    ekVar.o();
                                    t tVar14 = new t();
                                    tVar14.f(dz.GL_LABEL_INIT_FAILURE);
                                    tVar14.c(ekVar2);
                                    objC = tVar14.a();
                                } else {
                                    bdVarA = this.I.a(ekVar.o());
                                    if (bdVarA != null) {
                                        axVar2.x(bdVarA, false);
                                    }
                                    efVarO = ekVar.o();
                                    bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                                    efVarO.h(bhVarS);
                                    if (efVarO.w.n(bhVarS.d)) {
                                        if (ekVar.C()) {
                                            ebVarH2 = i(dyVar, axVar2);
                                        } else {
                                            ebVarH2 = h(dyVar, axVar2);
                                        }
                                        z = ((u) ebVarH2).b.e;
                                        objC = ebVarH2;
                                        if (!z) {
                                            axVar2.D(i5);
                                            return ebVarH2;
                                        }
                                    } else {
                                        bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                                        efVarO.h(bhVarS2);
                                        objK = efVarO.w.k(bhVarS2.d);
                                        if (objK == null) {
                                            objC2 = bhVarS2.b;
                                        } else {
                                            objC2 = bhVarS2.c(objK);
                                        }
                                        xVar = (com.google.android.libraries.navigation.internal.adl.x) objC2;
                                        sVar2 = xVar.h;
                                        if (sVar2 == null) {
                                            sVar2 = com.google.android.libraries.navigation.internal.adl.s.a;
                                        }
                                        if ((sVar2.b & 2) == 0) {
                                            if (ekVar.C()) {
                                                ebVarH2 = i(dyVar, axVar2);
                                            } else {
                                                ebVarH2 = h(dyVar, axVar2);
                                            }
                                            z = ((u) ebVarH2).b.e;
                                            objC = ebVarH2;
                                            if (!z) {
                                                axVar2.D(i5);
                                                return ebVarH2;
                                            }
                                        } else {
                                            sVar3 = xVar.h;
                                            if (sVar3 == null) {
                                                sVar3 = com.google.android.libraries.navigation.internal.adl.s.a;
                                            }
                                            if (sVar3.c != 0) {
                                                zU = axVar2.u(this.B, sVar.a);
                                                bVarG = axVar2.g();
                                                if (bVarG == null) {
                                                    i6 = 0;
                                                } else {
                                                    i6 = 0;
                                                }
                                                boolean zE10 = axVar2.r.e(sVar.g.b);
                                                if (zU) {
                                                    if (ekVar.C()) {
                                                        ebVarH2 = i(dyVar, axVar2);
                                                    } else {
                                                        ebVarH2 = h(dyVar, axVar2);
                                                    }
                                                    z = ((u) ebVarH2).b.e;
                                                    objC = ebVarH2;
                                                    if (!z) {
                                                        axVar2.D(i5);
                                                        return ebVarH2;
                                                    }
                                                } else {
                                                    if (ekVar.C()) {
                                                        ebVarH2 = i(dyVar, axVar2);
                                                    } else {
                                                        ebVarH2 = h(dyVar, axVar2);
                                                    }
                                                    z = ((u) ebVarH2).b.e;
                                                    objC = ebVarH2;
                                                    if (!z) {
                                                        axVar2.D(i5);
                                                        return ebVarH2;
                                                    }
                                                }
                                            } else {
                                                if (ekVar.C()) {
                                                    ebVarH2 = i(dyVar, axVar2);
                                                } else {
                                                    ebVarH2 = h(dyVar, axVar2);
                                                }
                                                z = ((u) ebVarH2).b.e;
                                                objC = ebVarH2;
                                                if (!z) {
                                                    axVar2.D(i5);
                                                    return ebVarH2;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (!ekVar.h().g()) {
                t tVar15 = new t();
                tVar15.f(dz.UNSUPPORTED_LABEL_TYPE);
                tVar15.c(ekVar2);
                return tVar15.a();
            }
            if ((ekVar.o().b & 1) != 0 || (ekVar.o().b & 2) != 0) {
                com.google.android.libraries.geo.mapcore.renderer.af afVar = com.google.android.libraries.geo.mapcore.renderer.ci.LABELS;
                if (ekVar.F()) {
                    afVar = com.google.android.libraries.geo.mapcore.renderer.ck.MY_MAPS_LABELS;
                }
                com.google.android.libraries.geo.mapcore.renderer.af afVar2 = afVar;
                s sVar5 = (s) dyVar;
                if (p(sVar5.a.w().l)) {
                    com.google.android.libraries.navigation.internal.adg.ef efVarO2 = ekVar.o();
                    int i12 = com.google.android.libraries.navigation.internal.rb.a.a;
                    if (com.google.android.libraries.navigation.internal.rb.a.h(4, efVarO2.h)) {
                        ekVar.o();
                        t tVar16 = new t();
                        tVar16.f(dz.FAILED_TILT_RENDER_THRESHOLD_CHECK);
                        tVar16.c(ekVar2);
                        objC = tVar16.a();
                    } else {
                        duVarG = g(dyVar, ekVar);
                        anVar = duVarG.b;
                        if (anVar.g()) {
                            objC = anVar.c();
                        } else {
                            aiVarE = e(duVarG.a);
                            if (aiVarE == null) {
                                ca caVar6 = this.q;
                                dVar = sVar5.d;
                                i3 = duVarG.a;
                                iH = dyVar.h();
                                cuVar = this.B;
                                dVarB = com.google.android.libraries.navigation.internal.nw.e.b("LabelFactory.createLineLabel");
                                try {
                                    asVar = caVar6.g;
                                    numValueOf = Integer.valueOf(i3);
                                    dtVar = ekVar.o().c;
                                    if (dtVar == null) {
                                        dtVar = com.google.android.libraries.navigation.internal.adg.dt.a;
                                    }
                                    gVar = caVar6.d;
                                    bVar = caVar6.b;
                                    com.google.android.libraries.navigation.internal.pz.a aVar = caVar6.c;
                                    com.google.android.libraries.navigation.internal.qz.g gVar2 = caVar6.e;
                                    if (dtVar.c.size() == 0) {
                                        ekVar2 = ekVar2;
                                        aiVarE = null;
                                        i2 = 1;
                                    } else {
                                        aiVarA = gVar.a((com.google.android.libraries.navigation.internal.adg.dp) dtVar.c.get(0), ekVar2, iH);
                                        if (!aiVarA.f) {
                                            i2 = 1;
                                            aiVarE = null;
                                        } else {
                                            try {
                                                if ((!aiVarA.q() || aiVarA.i()) && dtVar.c.size() > 0) {
                                                    aiVarA2 = gVar.a((com.google.android.libraries.navigation.internal.adg.dp) dtVar.c.get(0), ekVar2, iH);
                                                    if (aiVarA2.f) {
                                                        i2 = 1;
                                                    } else {
                                                        if (aiVarA2.q() || aiVarA2.i()) {
                                                            gqVar = ekVar.o().f;
                                                            if (gqVar == null) {
                                                                gqVar = gq.a;
                                                            }
                                                            fA = com.google.android.libraries.geo.mapcore.internal.model.ay.a(gqVar.d);
                                                            iA = go.a(gqVar.e);
                                                            if (iA == 0) {
                                                                iA = go.a;
                                                            }
                                                            if (iA == 0) {
                                                                throw null;
                                                            }
                                                            if (iA == 1) {
                                                                i4 = 2;
                                                            } else if (iA == 2) {
                                                                i4 = 1;
                                                            } else if (iA != 3) {
                                                                i4 = 2;
                                                            } else {
                                                                i4 = 3;
                                                            }
                                                            fA2 = com.google.android.libraries.geo.mapcore.internal.model.ay.a(gqVar.f);
                                                            str = ((com.google.android.libraries.navigation.internal.adg.dp) dtVar.c.get(0)).c;
                                                            if (true == TextUtils.isEmpty(str)) {
                                                                str2 = null;
                                                            } else {
                                                                str2 = str;
                                                            }
                                                            if (str2 != null || ar.p(bVar, str2, aiVarA)) {
                                                                it2 = dtVar.c.iterator();
                                                                while (true) {
                                                                    if (it2.hasNext()) {
                                                                        dpVar = (com.google.android.libraries.navigation.internal.adg.dp) it2.next();
                                                                        Iterator it3 = it2;
                                                                        int i13 = dpVar.b;
                                                                        aiVarA3 = ((i13 & 4) != 0 && (i13 & 2) == 0) ? null : gVar.a(dpVar, ekVar2, iH);
                                                                        if (aiVarA3 == null && aiVarA3.i()) {
                                                                            com.google.android.libraries.navigation.internal.qc.e eVarB = com.google.android.libraries.navigation.internal.qc.e.b(aVar, ev.o(ekVar.o().t), dpVar, aiVarA3, dVar, gVar2, false);
                                                                            if (eVarB != null) {
                                                                                eVar = eVarB;
                                                                            }
                                                                        } else {
                                                                            it2 = it3;
                                                                        }
                                                                    } else {
                                                                        dpVar = null;
                                                                        eVar = null;
                                                                    }
                                                                    if (str2 == null || dpVar != null) {
                                                                        com.google.android.libraries.navigation.internal.oe.x xVar2 = cuVar.h;
                                                                        com.google.android.libraries.navigation.internal.oe.ad adVar = ((m) ekVar.h()).b;
                                                                        com.google.android.libraries.navigation.internal.yx.ar.q(adVar);
                                                                        int i14 = adVar.i(0.5f, xVar2);
                                                                        at atVar = (at) asVar.c();
                                                                        numValueOf.getClass();
                                                                        i2 = 1;
                                                                        ekVar2 = ekVar2;
                                                                        atVar.b(ekVar, i3, str2, aiVarA, fA, i4, fA2, xVar2, i14, afVar2, dVar, bVar, eVar, ekVar.ah());
                                                                        aiVarE = atVar;
                                                                    }
                                                                }
                                                            } else {
                                                                i2 = 1;
                                                            }
                                                        }
                                                        ekVar2 = ekVar2;
                                                        aiVarE = null;
                                                        i2 = 1;
                                                    }
                                                    aiVarE = null;
                                                } else {
                                                    ekVar2 = ekVar2;
                                                    aiVarE = null;
                                                    i2 = 1;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                Throwable th4 = th;
                                                if (dVarB == null) {
                                                    throw th4;
                                                }
                                                try {
                                                    Trace.endSection();
                                                    throw th4;
                                                } catch (Throwable th5) {
                                                    th4.addSuppressed(th5);
                                                    throw th4;
                                                }
                                            }
                                        }
                                    }
                                    if (dVarB != null) {
                                        Trace.endSection();
                                    }
                                    if (aiVarE != null) {
                                        edVar = this;
                                        edVar.F += i2;
                                        aiVarE.C(i2);
                                    } else {
                                        edVar = this;
                                        ekVar.o();
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            } else {
                                edVar = this;
                                i2 = 1;
                                ekVar2 = ekVar2;
                            }
                            if (aiVarE == null) {
                                t tVar17 = new t();
                                tVar17.f(dz.GL_LABEL_INIT_FAILURE);
                                tVar17.c(ekVar2);
                                objA = tVar17.a();
                            } else {
                                if (((b) aiVarE.A()).j) {
                                    ebVarH = edVar.i(dyVar, aiVarE);
                                } else {
                                    ebVarH = edVar.h(dyVar, aiVarE);
                                }
                                ekVar.o();
                                if (!((u) ebVarH).b.e) {
                                    aiVarE.D(i2);
                                    return ebVarH;
                                }
                                objA = ebVarH;
                            }
                        }
                    }
                } else {
                    duVarG = g(dyVar, ekVar);
                    anVar = duVarG.b;
                    if (anVar.g()) {
                        objC = anVar.c();
                    } else {
                        aiVarE = e(duVarG.a);
                        if (aiVarE == null) {
                            ca caVar7 = this.q;
                            dVar = sVar5.d;
                            i3 = duVarG.a;
                            iH = dyVar.h();
                            cuVar = this.B;
                            dVarB = com.google.android.libraries.navigation.internal.nw.e.b("LabelFactory.createLineLabel");
                            asVar = caVar7.g;
                            numValueOf = Integer.valueOf(i3);
                            dtVar = ekVar.o().c;
                            if (dtVar == null) {
                                dtVar = com.google.android.libraries.navigation.internal.adg.dt.a;
                            }
                            gVar = caVar7.d;
                            bVar = caVar7.b;
                            com.google.android.libraries.navigation.internal.pz.a aVar2 = caVar7.c;
                            com.google.android.libraries.navigation.internal.qz.g gVar3 = caVar7.e;
                            if (dtVar.c.size() == 0) {
                                ekVar2 = ekVar2;
                                aiVarE = null;
                                i2 = 1;
                            } else {
                                aiVarA = gVar.a((com.google.android.libraries.navigation.internal.adg.dp) dtVar.c.get(0), ekVar2, iH);
                                if (!aiVarA.f) {
                                    i2 = 1;
                                    aiVarE = null;
                                } else if (aiVarA.q()) {
                                    aiVarA2 = gVar.a((com.google.android.libraries.navigation.internal.adg.dp) dtVar.c.get(0), ekVar2, iH);
                                    if (aiVarA2.f) {
                                        i2 = 1;
                                    } else if (aiVarA2.q()) {
                                        gqVar = ekVar.o().f;
                                        if (gqVar == null) {
                                            gqVar = gq.a;
                                        }
                                        fA = com.google.android.libraries.geo.mapcore.internal.model.ay.a(gqVar.d);
                                        iA = go.a(gqVar.e);
                                        if (iA == 0) {
                                            iA = go.a;
                                        }
                                        if (iA == 0) {
                                            throw null;
                                        }
                                        if (iA == 1) {
                                            i4 = 2;
                                        } else if (iA == 2) {
                                            i4 = 1;
                                        } else if (iA != 3) {
                                            i4 = 2;
                                        } else {
                                            i4 = 3;
                                        }
                                        fA2 = com.google.android.libraries.geo.mapcore.internal.model.ay.a(gqVar.f);
                                        str = ((com.google.android.libraries.navigation.internal.adg.dp) dtVar.c.get(0)).c;
                                        if (true == TextUtils.isEmpty(str)) {
                                            str2 = null;
                                        } else {
                                            str2 = str;
                                        }
                                        if (str2 != null) {
                                        }
                                        it2 = dtVar.c.iterator();
                                        while (true) {
                                            if (it2.hasNext()) {
                                                dpVar = (com.google.android.libraries.navigation.internal.adg.dp) it2.next();
                                                Iterator it4 = it2;
                                                int i15 = dpVar.b;
                                                if ((i15 & 4) != 0) {
                                                    if (aiVarA3 == null) {
                                                    }
                                                    it2 = it4;
                                                }
                                                if (aiVarA3 == null) {
                                                }
                                                it2 = it4;
                                            } else {
                                                dpVar = null;
                                                eVar = null;
                                            }
                                            if (str2 == null) {
                                            }
                                            com.google.android.libraries.navigation.internal.oe.x xVar3 = cuVar.h;
                                            com.google.android.libraries.navigation.internal.oe.ad adVar2 = ((m) ekVar.h()).b;
                                            com.google.android.libraries.navigation.internal.yx.ar.q(adVar2);
                                            int i16 = adVar2.i(0.5f, xVar3);
                                            at atVar2 = (at) asVar.c();
                                            numValueOf.getClass();
                                            i2 = 1;
                                            ekVar2 = ekVar2;
                                            atVar2.b(ekVar, i3, str2, aiVarA, fA, i4, fA2, xVar3, i16, afVar2, dVar, bVar, eVar, ekVar.ah());
                                            aiVarE = atVar2;
                                        }
                                    } else {
                                        gqVar = ekVar.o().f;
                                        if (gqVar == null) {
                                            gqVar = gq.a;
                                        }
                                        fA = com.google.android.libraries.geo.mapcore.internal.model.ay.a(gqVar.d);
                                        iA = go.a(gqVar.e);
                                        if (iA == 0) {
                                            iA = go.a;
                                        }
                                        if (iA == 0) {
                                            throw null;
                                        }
                                        if (iA == 1) {
                                            i4 = 2;
                                        } else if (iA == 2) {
                                            i4 = 1;
                                        } else if (iA != 3) {
                                            i4 = 2;
                                        } else {
                                            i4 = 3;
                                        }
                                        fA2 = com.google.android.libraries.geo.mapcore.internal.model.ay.a(gqVar.f);
                                        str = ((com.google.android.libraries.navigation.internal.adg.dp) dtVar.c.get(0)).c;
                                        if (true == TextUtils.isEmpty(str)) {
                                            str2 = null;
                                        } else {
                                            str2 = str;
                                        }
                                        if (str2 != null) {
                                        }
                                        it2 = dtVar.c.iterator();
                                        while (true) {
                                            if (it2.hasNext()) {
                                                dpVar = (com.google.android.libraries.navigation.internal.adg.dp) it2.next();
                                                Iterator it5 = it2;
                                                int i17 = dpVar.b;
                                                if ((i17 & 4) != 0) {
                                                    if (aiVarA3 == null) {
                                                    }
                                                    it2 = it5;
                                                }
                                                if (aiVarA3 == null) {
                                                }
                                                it2 = it5;
                                            } else {
                                                dpVar = null;
                                                eVar = null;
                                            }
                                            if (str2 == null) {
                                            }
                                            com.google.android.libraries.navigation.internal.oe.x xVar4 = cuVar.h;
                                            com.google.android.libraries.navigation.internal.oe.ad adVar3 = ((m) ekVar.h()).b;
                                            com.google.android.libraries.navigation.internal.yx.ar.q(adVar3);
                                            int i18 = adVar3.i(0.5f, xVar4);
                                            at atVar3 = (at) asVar.c();
                                            numValueOf.getClass();
                                            i2 = 1;
                                            ekVar2 = ekVar2;
                                            atVar3.b(ekVar, i3, str2, aiVarA, fA, i4, fA2, xVar4, i18, afVar2, dVar, bVar, eVar, ekVar.ah());
                                            aiVarE = atVar3;
                                        }
                                    }
                                    aiVarE = null;
                                } else {
                                    aiVarA2 = gVar.a((com.google.android.libraries.navigation.internal.adg.dp) dtVar.c.get(0), ekVar2, iH);
                                    if (aiVarA2.f) {
                                        i2 = 1;
                                    } else if (aiVarA2.q()) {
                                        gqVar = ekVar.o().f;
                                        if (gqVar == null) {
                                            gqVar = gq.a;
                                        }
                                        fA = com.google.android.libraries.geo.mapcore.internal.model.ay.a(gqVar.d);
                                        iA = go.a(gqVar.e);
                                        if (iA == 0) {
                                            iA = go.a;
                                        }
                                        if (iA == 0) {
                                            throw null;
                                        }
                                        if (iA == 1) {
                                            i4 = 2;
                                        } else if (iA == 2) {
                                            i4 = 1;
                                        } else if (iA != 3) {
                                            i4 = 2;
                                        } else {
                                            i4 = 3;
                                        }
                                        fA2 = com.google.android.libraries.geo.mapcore.internal.model.ay.a(gqVar.f);
                                        str = ((com.google.android.libraries.navigation.internal.adg.dp) dtVar.c.get(0)).c;
                                        if (true == TextUtils.isEmpty(str)) {
                                            str2 = null;
                                        } else {
                                            str2 = str;
                                        }
                                        if (str2 != null) {
                                        }
                                        it2 = dtVar.c.iterator();
                                        while (true) {
                                            if (it2.hasNext()) {
                                                dpVar = (com.google.android.libraries.navigation.internal.adg.dp) it2.next();
                                                Iterator it6 = it2;
                                                int i19 = dpVar.b;
                                                if ((i19 & 4) != 0) {
                                                    if (aiVarA3 == null) {
                                                    }
                                                    it2 = it6;
                                                }
                                                if (aiVarA3 == null) {
                                                }
                                                it2 = it6;
                                            } else {
                                                dpVar = null;
                                                eVar = null;
                                            }
                                            if (str2 == null) {
                                            }
                                            com.google.android.libraries.navigation.internal.oe.x xVar5 = cuVar.h;
                                            com.google.android.libraries.navigation.internal.oe.ad adVar4 = ((m) ekVar.h()).b;
                                            com.google.android.libraries.navigation.internal.yx.ar.q(adVar4);
                                            int i110 = adVar4.i(0.5f, xVar5);
                                            at atVar4 = (at) asVar.c();
                                            numValueOf.getClass();
                                            i2 = 1;
                                            ekVar2 = ekVar2;
                                            atVar4.b(ekVar, i3, str2, aiVarA, fA, i4, fA2, xVar5, i110, afVar2, dVar, bVar, eVar, ekVar.ah());
                                            aiVarE = atVar4;
                                        }
                                    } else {
                                        gqVar = ekVar.o().f;
                                        if (gqVar == null) {
                                            gqVar = gq.a;
                                        }
                                        fA = com.google.android.libraries.geo.mapcore.internal.model.ay.a(gqVar.d);
                                        iA = go.a(gqVar.e);
                                        if (iA == 0) {
                                            iA = go.a;
                                        }
                                        if (iA == 0) {
                                            throw null;
                                        }
                                        if (iA == 1) {
                                            i4 = 2;
                                        } else if (iA == 2) {
                                            i4 = 1;
                                        } else if (iA != 3) {
                                            i4 = 2;
                                        } else {
                                            i4 = 3;
                                        }
                                        fA2 = com.google.android.libraries.geo.mapcore.internal.model.ay.a(gqVar.f);
                                        str = ((com.google.android.libraries.navigation.internal.adg.dp) dtVar.c.get(0)).c;
                                        if (true == TextUtils.isEmpty(str)) {
                                            str2 = null;
                                        } else {
                                            str2 = str;
                                        }
                                        if (str2 != null) {
                                        }
                                        it2 = dtVar.c.iterator();
                                        while (true) {
                                            if (it2.hasNext()) {
                                                dpVar = (com.google.android.libraries.navigation.internal.adg.dp) it2.next();
                                                Iterator it7 = it2;
                                                int i111 = dpVar.b;
                                                if ((i111 & 4) != 0) {
                                                    if (aiVarA3 == null) {
                                                    }
                                                    it2 = it7;
                                                }
                                                if (aiVarA3 == null) {
                                                }
                                                it2 = it7;
                                            } else {
                                                dpVar = null;
                                                eVar = null;
                                            }
                                            if (str2 == null) {
                                            }
                                            com.google.android.libraries.navigation.internal.oe.x xVar6 = cuVar.h;
                                            com.google.android.libraries.navigation.internal.oe.ad adVar5 = ((m) ekVar.h()).b;
                                            com.google.android.libraries.navigation.internal.yx.ar.q(adVar5);
                                            int i112 = adVar5.i(0.5f, xVar6);
                                            at atVar5 = (at) asVar.c();
                                            numValueOf.getClass();
                                            i2 = 1;
                                            ekVar2 = ekVar2;
                                            atVar5.b(ekVar, i3, str2, aiVarA, fA, i4, fA2, xVar6, i112, afVar2, dVar, bVar, eVar, ekVar.ah());
                                            aiVarE = atVar5;
                                        }
                                    }
                                    aiVarE = null;
                                }
                            }
                            if (dVarB != null) {
                                Trace.endSection();
                            }
                            if (aiVarE != null) {
                                edVar = this;
                                edVar.F += i2;
                                aiVarE.C(i2);
                            } else {
                                edVar = this;
                                ekVar.o();
                            }
                        } else {
                            edVar = this;
                            i2 = 1;
                            ekVar2 = ekVar2;
                        }
                        if (aiVarE == null) {
                            t tVar18 = new t();
                            tVar18.f(dz.GL_LABEL_INIT_FAILURE);
                            tVar18.c(ekVar2);
                            objA = tVar18.a();
                        } else {
                            if (((b) aiVarE.A()).j) {
                                ebVarH = edVar.i(dyVar, aiVarE);
                            } else {
                                ebVarH = edVar.h(dyVar, aiVarE);
                            }
                            ekVar.o();
                            if (!((u) ebVarH).b.e) {
                                aiVarE.D(i2);
                                return ebVarH;
                            }
                            objA = ebVarH;
                        }
                    }
                }
                return (eb) objA;
            }
            t tVar19 = new t();
            tVar19.f(dz.NOTHING_TO_RENDER);
            tVar19.c(ekVar2);
            objC = tVar19.a();
        }
        objA = objC;
        return (eb) objA;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    private static void l(eb ebVar) {
        if (ebVar.a().e && ebVar.d().g() && !ebVar.c().C()) {
            ebVar.d().c().D(1);
        }
    }

    private final void m(ai aiVar) {
        int iZ = aiVar.z();
        if (aiVar.G()) {
            if (aiVar.r()) {
                this.e.c(aiVar);
            }
            this.d.c(aiVar);
            this.x.e(iZ);
            aiVar.E(false);
        }
        this.b.l(iZ);
    }

    private final boolean n(ai aiVar) {
        return this.C || !((b) aiVar.A()).i;
    }

    private static boolean o(ai aiVar) {
        ek ekVarA = aiVar.A();
        if (ekVarA.an() && ekVarA.ap() && (((b) ekVarA).a.b & 2) != 0) {
            return true;
        }
        if (aiVar instanceof ax) {
            return aiVar.A().an() && !((ax) aiVar).F.isEmpty();
        }
        return false;
    }

    private static boolean p(float f) {
        return Math.abs(f) > 20.0f;
    }

    private final boolean q(ek ekVar, com.google.android.libraries.navigation.internal.oe.bd bdVar, com.google.android.libraries.navigation.internal.oe.x xVar) {
        if (bdVar == null) {
            return true;
        }
        if (!ekVar.h().h()) {
            if (!ekVar.h().g()) {
                return false;
            }
            com.google.android.libraries.navigation.internal.oe.ad adVar = ((m) ekVar.h()).b;
            com.google.android.libraries.navigation.internal.yx.ar.q(adVar);
            return bdVar.k(adVar.p());
        }
        com.google.android.libraries.navigation.internal.ol.bd bdVarA = this.I.a(ekVar.o());
        if (bdVarA == null || (1 & bdVarA.b) == 0) {
            com.google.android.libraries.geo.mapcore.internal.model.c cVar = ((m) ekVar.h()).a;
            com.google.android.libraries.navigation.internal.yx.ar.q(cVar);
            return bdVar.g(cVar.a);
        }
        com.google.android.libraries.navigation.internal.acc.d dVar = bdVarA.c;
        if (dVar == null) {
            dVar = com.google.android.libraries.navigation.internal.acc.d.a;
        }
        double d = dVar.d;
        com.google.android.libraries.navigation.internal.acc.d dVar2 = bdVarA.c;
        if (dVar2 == null) {
            dVar2 = com.google.android.libraries.navigation.internal.acc.d.a;
        }
        xVar.L(d, dVar2.c);
        return bdVar.g(xVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean r(dy dyVar, ax axVar, boolean z, int i2) {
        dp dpVar = new dp(z);
        com.google.android.libraries.navigation.internal.qa.b bVarG = axVar.g();
        boolean z2 = bVarG != null && ((s) dyVar).g.b(new com.google.android.libraries.navigation.internal.qb.d(axVar.c, bVarG), dpVar, i2);
        if (axVar.F.isEmpty()) {
            return z2;
        }
        if (z2) {
            return true;
        }
        au auVar = axVar.z;
        if (auVar == null) {
            auVar = ax.a;
        }
        ar arVar = axVar.s;
        com.google.android.libraries.navigation.internal.adg.ds dsVar = arVar == null ? ax.p : arVar.d;
        ev evVar = axVar.F;
        int size = evVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            com.google.android.libraries.geo.mapcore.internal.model.aj ajVar = (com.google.android.libraries.geo.mapcore.internal.model.aj) evVar.get(i3);
            au auVarB = ax.b(ajVar.b());
            if (!auVar.equals(auVarB)) {
                axVar.z = auVarB;
                axVar.l(ajVar.a());
                s sVar = (s) dyVar;
                axVar.u(this.B, sVar.a);
                com.google.android.libraries.navigation.internal.qa.b bVarG2 = axVar.g();
                if (bVarG2 != null && sVar.g.b(new com.google.android.libraries.navigation.internal.qb.d(axVar.c, bVarG2), dpVar, i2)) {
                    return true;
                }
            }
        }
        axVar.z = auVar;
        axVar.l(dsVar);
        axVar.u(this.B, ((s) dyVar).a);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean s(dy dyVar, ax axVar, int i2) {
        dp dpVar = new dp(false);
        com.google.android.libraries.navigation.internal.qa.b bVarG = axVar.g();
        com.google.android.libraries.navigation.internal.qa.b bVarH = axVar.h();
        boolean z = (bVarH == null || (bVarG != null && bVarH != null && bVarH.f(bVarG)) || !((s) dyVar).g.b(new com.google.android.libraries.navigation.internal.qb.d(axVar.c, bVarH), dpVar, i2)) ? false : true;
        if (axVar.G.isEmpty()) {
            return z;
        }
        if (z) {
            return true;
        }
        au auVar = axVar.A;
        if (auVar == null) {
            auVar = ax.a;
        }
        ar arVar = axVar.t;
        com.google.android.libraries.navigation.internal.adg.ds dsVar = arVar == null ? ax.p : arVar.d;
        ev evVar = axVar.G;
        int size = evVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            com.google.android.libraries.geo.mapcore.internal.model.aj ajVar = (com.google.android.libraries.geo.mapcore.internal.model.aj) evVar.get(i3);
            au auVarB = ax.b(ajVar.b());
            if (!auVar.equals(auVarB)) {
                axVar.A = auVarB;
                axVar.t(ajVar.a());
                s sVar = (s) dyVar;
                axVar.u(this.B, sVar.a);
                com.google.android.libraries.navigation.internal.qa.b bVarH2 = axVar.h();
                boolean z2 = (bVarG == null || bVarH2 == null || !bVarH2.f(bVarG)) ? false : true;
                if (bVarH2 != null && !z2 && sVar.g.b(new com.google.android.libraries.navigation.internal.qb.d(axVar.c, bVarH2), dpVar, i2)) {
                    return true;
                }
            }
        }
        axVar.A = auVar;
        axVar.t(dsVar);
        axVar.u(this.B, ((s) dyVar).a);
        return false;
    }

    private final boolean t(dy dyVar, ai aiVar, int i2) {
        com.google.android.libraries.navigation.internal.qa.b bVarH;
        ax axVar = aiVar instanceof ax ? (ax) aiVar : null;
        return (axVar == null || axVar.h() == null || !s(dyVar, axVar, i2) || (bVarH = axVar.h()) == null || !((s) dyVar).g.a(new com.google.android.libraries.navigation.internal.qb.d(axVar.c, bVarH), new dp(false), i2)) ? false : true;
    }

    private final boolean u(dy dyVar, ai aiVar, boolean z, int i2) {
        com.google.android.libraries.navigation.internal.qa.b bVarG;
        boolean z2 = aiVar instanceof ax;
        ax axVar = z2 ? (ax) aiVar : null;
        return (!z2 || (axVar != null ? r(dyVar, axVar, z, i2) : false)) && (bVarG = aiVar.g()) != null && ((s) dyVar).g.a(new com.google.android.libraries.navigation.internal.qb.d(aiVar.A(), bVarG), new dp(z), i2);
    }

    private static boolean v(com.google.android.libraries.navigation.internal.qb.c cVar, com.google.android.libraries.navigation.internal.qb.d dVar, com.google.android.libraries.navigation.internal.qb.f fVar, int i2) {
        return cVar.a(dVar, fVar, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    @Override // com.google.android.libraries.navigation.internal.px.cs
    public final void a() {
        Iterator it2 = Collections.unmodifiableCollection(this.a.d.values()).iterator();
        while (it2.hasNext()) {
            m(((eb) it2.next()).d().c());
        }
        Iterator it3 = Collections.unmodifiableCollection(this.a.a.values()).iterator();
        while (it3.hasNext()) {
            m(((eb) it3.next()).d().c());
        }
        this.a.c();
        this.d.e();
    }

    /* JADX WARN: Code duplicated, block: B:152:0x03bf A[Catch: all -> 0x0b4c, TryCatch #21 {all -> 0x0b4c, blocks: (B:140:0x0375, B:141:0x037c, B:143:0x0382, B:145:0x0390, B:147:0x03a0, B:149:0x03a9, B:151:0x03b9, B:148:0x03a7, B:152:0x03bf, B:154:0x03c5, B:156:0x03cd, B:158:0x03d3, B:160:0x03d9, B:162:0x03e6, B:161:0x03e1), top: B:578:0x0375, outer: #15 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x03c5 A[Catch: all -> 0x0b4c, TryCatch #21 {all -> 0x0b4c, blocks: (B:140:0x0375, B:141:0x037c, B:143:0x0382, B:145:0x0390, B:147:0x03a0, B:149:0x03a9, B:151:0x03b9, B:148:0x03a7, B:152:0x03bf, B:154:0x03c5, B:156:0x03cd, B:158:0x03d3, B:160:0x03d9, B:162:0x03e6, B:161:0x03e1), top: B:578:0x0375, outer: #15 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x03cd A[Catch: all -> 0x0b4c, TryCatch #21 {all -> 0x0b4c, blocks: (B:140:0x0375, B:141:0x037c, B:143:0x0382, B:145:0x0390, B:147:0x03a0, B:149:0x03a9, B:151:0x03b9, B:148:0x03a7, B:152:0x03bf, B:154:0x03c5, B:156:0x03cd, B:158:0x03d3, B:160:0x03d9, B:162:0x03e6, B:161:0x03e1), top: B:578:0x0375, outer: #15 }] */
    /* JADX WARN: Code duplicated, block: B:157:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:160:0x03d9 A[Catch: all -> 0x0b4c, TryCatch #21 {all -> 0x0b4c, blocks: (B:140:0x0375, B:141:0x037c, B:143:0x0382, B:145:0x0390, B:147:0x03a0, B:149:0x03a9, B:151:0x03b9, B:148:0x03a7, B:152:0x03bf, B:154:0x03c5, B:156:0x03cd, B:158:0x03d3, B:160:0x03d9, B:162:0x03e6, B:161:0x03e1), top: B:578:0x0375, outer: #15 }] */
    /* JADX WARN: Code duplicated, block: B:161:0x03e1 A[Catch: all -> 0x0b4c, TryCatch #21 {all -> 0x0b4c, blocks: (B:140:0x0375, B:141:0x037c, B:143:0x0382, B:145:0x0390, B:147:0x03a0, B:149:0x03a9, B:151:0x03b9, B:148:0x03a7, B:152:0x03bf, B:154:0x03c5, B:156:0x03cd, B:158:0x03d3, B:160:0x03d9, B:162:0x03e6, B:161:0x03e1), top: B:578:0x0375, outer: #15 }] */
    /* JADX WARN: Code duplicated, block: B:164:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:576:0x0bc8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:613:0x03ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:719:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v14, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v11, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v9, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v5, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.libraries.navigation.internal.px.ed] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v56 */
    /* JADX WARN: Type inference failed for: r1v60 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.google.android.libraries.navigation.internal.px.ed] */
    /* JADX WARN: Type inference failed for: r29v0, types: [com.google.android.libraries.navigation.internal.px.dq] */
    /* JADX WARN: Type inference failed for: r29v1 */
    /* JADX WARN: Type inference failed for: r29v2 */
    /* JADX WARN: Type inference failed for: r29v3 */
    /* JADX WARN: Type inference failed for: r29v4 */
    /* JADX WARN: Type inference failed for: r29v5 */
    /* JADX WARN: Type inference failed for: r5v64, types: [com.google.android.libraries.navigation.internal.px.cd] */
    /* JADX WARN: Type inference failed for: r5v68, types: [com.google.android.libraries.navigation.internal.px.cn] */
    /* JADX WARN: Type inference failed for: r5v71, types: [com.google.android.libraries.navigation.internal.px.cd] */
    /* JADX WARN: Type inference failed for: r5v73, types: [com.google.android.libraries.navigation.internal.px.cd] */
    /* JADX WARN: Type inference failed for: r5v77, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v41, types: [com.google.android.libraries.navigation.internal.px.cz] */
    /* JADX WARN: Type inference failed for: r6v43, types: [com.google.android.libraries.navigation.internal.px.cn] */
    /* JADX WARN: Type inference failed for: r6v47, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v52, types: [com.google.android.libraries.navigation.internal.px.cn] */
    /* JADX WARN: Type inference failed for: r7v48, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v51, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v59, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v23, types: [com.google.android.libraries.navigation.internal.px.cd] */
    /* JADX WARN: Type inference failed for: r8v25, types: [com.google.android.libraries.navigation.internal.px.cz] */
    /* JADX WARN: Type inference failed for: r8v28, types: [com.google.android.libraries.navigation.internal.px.cd] */
    /* JADX WARN: Type inference failed for: r8v43, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.libraries.navigation.internal.px.cs
    public final void b(com.google.android.libraries.navigation.internal.pb.t tVar, cq cqVar, com.google.android.libraries.navigation.internal.pz.d dVar, com.google.android.libraries.geo.mapcore.internal.model.aq aqVar, boolean z, dq dqVar, com.google.android.libraries.navigation.internal.ol.ah ahVar) throws Throwable {
        Throwable th;
        s sVar;
        com.google.android.libraries.navigation.internal.oe.bd bdVar;
        boolean z2;
        eb ebVarI;
        hg hgVar;
        ev evVarQ;
        int i2;
        com.google.android.libraries.navigation.internal.ol.ag agVarB;
        com.google.android.libraries.navigation.internal.oe.bd bdVar2;
        HashSet hashSet;
        s sVar2;
        ?? r1 = this;
        com.google.android.libraries.navigation.internal.yx.ar.q(dVar);
        com.google.android.libraries.navigation.internal.yx.ar.q(aqVar);
        int size = cqVar.b.size();
        String[] strArr = com.google.android.libraries.navigation.internal.nw.e.a;
        Trace.setCounter("numInputLabels", size);
        q qVar = new q();
        qVar.h(cqVar.b.size());
        qVar.g(cqVar.f.size());
        qVar.d(SystemClock.elapsedRealtime());
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("Labeler.placeLabels");
        try {
            r1.x.h.getAndIncrement();
            com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("Labeler.placeLabels - prepareArea");
            try {
                try {
                    boolean z3 = dVar.f;
                    cw cwVarA = cv.a(tVar);
                    cn cnVar = r1.x;
                    com.google.android.libraries.navigation.internal.qa.a aVar = cwVarA.b;
                    cnVar.i = aVar;
                    com.google.android.libraries.navigation.internal.qb.c cVar = new com.google.android.libraries.navigation.internal.qb.c(cwVarA.a, aVar);
                    com.google.android.libraries.navigation.internal.qa.a aVar2 = cVar.a;
                    if (dVarB2 != null) {
                        Trace.endSection();
                    }
                    dqVar = dVarB;
                    s sVar3 = sVar;
                    com.google.android.libraries.navigation.internal.qa.a aVar3 = aVar2;
                    try {
                        sVar = new s(tVar, tVar.w().k, aqVar, dVar, cVar, r1.d.a, (com.google.android.libraries.navigation.internal.om.n) r1.u.a());
                        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar2 = r1.E;
                        r1.E = aqVar;
                        com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("Labeler.placeLabels - clientParams");
                        try {
                            r1.C = sVar3.f.r();
                            if (dVarB3 != null) {
                                Trace.endSection();
                            }
                            com.google.android.libraries.navigation.internal.nw.d dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("Labeler.placeLabels - destroyInvalid");
                            if (aqVar2 != aqVar || z) {
                                try {
                                    a();
                                    r1.b.j();
                                    r1.l.b();
                                    r1.p.b();
                                } catch (Throwable th2) {
                                    if (dVarB4 == null) {
                                        throw th2;
                                    }
                                    try {
                                        Trace.endSection();
                                        throw th2;
                                    } catch (Throwable th3) {
                                        th2.addSuppressed(th3);
                                        throw th2;
                                    }
                                }
                            }
                            if (dVarB4 != null) {
                                Trace.endSection();
                            }
                            com.google.android.libraries.navigation.internal.nw.d dVarB5 = com.google.android.libraries.navigation.internal.nw.e.b("Labeler.placeLabels - clearUnplacedLogs");
                            try {
                                r1.x.f();
                                if (dVarB5 != null) {
                                    Trace.endSection();
                                }
                                long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
                                if (r1.A < 0) {
                                    r1.A = jCurrentThreadTimeMillis;
                                }
                                aa aaVar = r1.z;
                                com.google.android.libraries.navigation.internal.om.n nVar = sVar3.f;
                                com.google.android.libraries.navigation.internal.qa.a aVar4 = cVar.b;
                                com.google.android.libraries.navigation.internal.agg.bz bzVar = new com.google.android.libraries.navigation.internal.agg.bz(((com.google.android.libraries.navigation.internal.agg.bz) cqVar.e).h);
                                gi it2 = ((com.google.android.libraries.navigation.internal.agg.bz) cqVar.e).l().listIterator();
                                r1 = r1;
                                while (it2.hasNext()) {
                                    try {
                                        com.google.android.libraries.navigation.internal.agg.bh bhVar = (com.google.android.libraries.navigation.internal.agg.bh) it2.next();
                                        int iA = bhVar.a();
                                        com.google.android.libraries.navigation.internal.ol.ab abVar = (com.google.android.libraries.navigation.internal.ol.ab) bhVar.getValue();
                                        eu euVar = (eu) ((et) aaVar).a.p(iA);
                                        int iB = nVar.b();
                                        if (euVar != null) {
                                            hashSet = new HashSet(euVar.d);
                                            hashSet.addAll(euVar.c);
                                        } else {
                                            hashSet = new HashSet();
                                        }
                                        HashSet hashSet2 = euVar != null ? new HashSet(euVar.e) : new HashSet();
                                        HashSet hashSet3 = new HashSet();
                                        gi giVar = it2;
                                        HashSet hashSet4 = new HashSet();
                                        Iterator it3 = hashSet.iterator();
                                        while (it3.hasNext()) {
                                            Iterator it4 = it3;
                                            es esVar = (es) it3.next();
                                            if (((et) aaVar).d(esVar.b, aVar4, tVar, iB)) {
                                                hashSet4.add(esVar);
                                            } else {
                                                hashSet3.add(esVar);
                                            }
                                            it3 = it4;
                                        }
                                        HashSet hashSet5 = new HashSet();
                                        int iA2 = abVar.a();
                                        int iB2 = abVar.b();
                                        com.google.android.libraries.navigation.internal.qa.a aVar5 = aVar3;
                                        int iC = abVar.c() + iB2;
                                        if (iA2 <= 0 || iB2 < 0 || iB2 > iA2) {
                                            sVar2 = sVar3;
                                            break;
                                        }
                                        hashSet2.addAll(hashSet3);
                                        ArrayList arrayList = new ArrayList(hashSet2);
                                        Collections.sort(arrayList, Collections.reverseOrder());
                                        int size2 = arrayList.size();
                                        int i3 = 0;
                                        while (true) {
                                            if (i3 >= size2) {
                                                sVar2 = sVar3;
                                                break;
                                                break;
                                            }
                                            int i4 = size2;
                                            es esVar2 = (es) arrayList.get(i3);
                                            ArrayList arrayList2 = arrayList;
                                            sVar2 = sVar3;
                                            if (((et) aaVar).d(esVar2.b, aVar4, tVar, iB) && hashSet4.size() < iC) {
                                                hashSet4.add(esVar2);
                                            } else {
                                                if (iA2 <= 0) {
                                                    break;
                                                }
                                                hashSet5.add(esVar2);
                                                iA2--;
                                            }
                                            i3++;
                                            arrayList = arrayList2;
                                            size2 = i4;
                                            sVar3 = sVar2;
                                        }
                                        bzVar.a(iA, new eu(abVar, hashSet4, hashSet5));
                                        r1 = this;
                                        nVar = nVar;
                                        it2 = giVar;
                                        aVar3 = aVar5;
                                        sVar3 = sVar2;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        th = th;
                                        if (dqVar != 0) {
                                            throw th;
                                        }
                                        try {
                                            Trace.endSection();
                                            throw th;
                                        } catch (Throwable th5) {
                                            th.addSuppressed(th5);
                                            throw th;
                                        }
                                    }
                                }
                                com.google.android.libraries.navigation.internal.qa.a aVar6 = aVar3;
                                final s sVar4 = sVar3;
                                ((et) aaVar).a = bzVar;
                                com.google.android.libraries.navigation.internal.nw.d dVarB6 = com.google.android.libraries.navigation.internal.nw.e.b("Labeler.placeLabels - cameraSetup");
                                try {
                                    try {
                                        com.google.android.libraries.navigation.internal.oe.l lVarH = com.google.android.libraries.navigation.internal.pb.j.h(sVar4.a, aVar6.a, aVar6.c, aVar6.b, aVar6.d, this.r);
                                        com.google.android.libraries.navigation.internal.oe.ai aiVar = lVarH != null ? lVarH.b : null;
                                        com.google.android.libraries.navigation.internal.oe.bd bdVar3 = aiVar != null ? new com.google.android.libraries.navigation.internal.oe.bd(aiVar) : null;
                                        if (dVarB6 != null) {
                                            Trace.endSection();
                                        }
                                        this.s.clear();
                                        com.google.android.libraries.navigation.internal.nw.d dVarB7 = com.google.android.libraries.navigation.internal.nw.e.b("Labeler.placeLabels - placeCallouts");
                                        try {
                                            List<ag> list = cqVar.f;
                                            if (!list.isEmpty()) {
                                                for (ag agVar : list) {
                                                    synchronized (agVar.b) {
                                                        try {
                                                            if (agVar.a != null) {
                                                                synchronized (agVar.b) {
                                                                    try {
                                                                        ah ahVar2 = agVar.a;
                                                                        com.google.android.libraries.navigation.internal.yx.ar.q(ahVar2);
                                                                        com.google.android.libraries.navigation.internal.adg.ef efVar = ((b) ahVar2.A()).a;
                                                                        bdVar = bdVar3;
                                                                        if (this.a.b(ahVar2.z(), 0L, "").g()) {
                                                                            t tVar2 = new t();
                                                                            tVar2.f(dz.RENDER_ID_COLLISION);
                                                                            tVar2.c(ahVar2.c);
                                                                            ebVarI = tVar2.a();
                                                                        } else if (ahVar2.A().ad(sVar4.b)) {
                                                                            ai aiVarE = e(ahVar2.z());
                                                                            if (aiVarE == null || aiVarE == ahVar2) {
                                                                                if (aiVarE == null) {
                                                                                    ahVar2.C(1);
                                                                                }
                                                                                if (agVar.c) {
                                                                                    this.B.i.a(agVar.d);
                                                                                    agVar.c = false;
                                                                                    z2 = true;
                                                                                } else {
                                                                                    z2 = false;
                                                                                }
                                                                                if (z2) {
                                                                                    com.google.android.libraries.navigation.internal.ol.m mVar = this.B.i;
                                                                                    ahVar2.y(mVar.a, mVar.b);
                                                                                }
                                                                                ebVarI = ((b) ahVar2.c).j ? i(sVar4, ahVar2) : h(sVar4, ahVar2);
                                                                                if (!((u) ebVarI).b.e) {
                                                                                    ahVar2.D(1);
                                                                                }
                                                                            } else {
                                                                                aiVarE.D(1);
                                                                                t tVar3 = new t();
                                                                                tVar3.f(dz.RENDER_ID_COLLISION);
                                                                                tVar3.c(ahVar2.c);
                                                                                ebVarI = tVar3.a();
                                                                            }
                                                                        } else {
                                                                            t tVar4 = new t();
                                                                            tVar4.f(dz.FAILED_ZOOM_CHECK);
                                                                            tVar4.c(ahVar2.c);
                                                                            ebVarI = tVar4.a();
                                                                        }
                                                                    } catch (Throwable th6) {
                                                                        throw th6;
                                                                    }
                                                                }
                                                                w(ebVarI, sVar4);
                                                                l(ebVarI);
                                                                bdVar3 = bdVar;
                                                            }
                                                        } catch (Throwable th7) {
                                                            throw th7;
                                                        }
                                                    }
                                                }
                                            }
                                            com.google.android.libraries.navigation.internal.oe.bd bdVar4 = bdVar3;
                                            if (dVarB7 != null) {
                                                Trace.endSection();
                                            }
                                            com.google.android.libraries.navigation.internal.oe.x xVar = new com.google.android.libraries.navigation.internal.oe.x();
                                            dq dqVar2 = H;
                                            this.m.a.clear();
                                            this.f544n.clear();
                                            int i5 = com.google.android.libraries.navigation.internal.ph.a.a;
                                            com.google.android.libraries.navigation.internal.nw.d dVarB8 = com.google.android.libraries.navigation.internal.nw.e.b("Labeler.placeLabels - apply styled-off and viewport bound filters");
                                            try {
                                                int i6 = 0;
                                                for (ek ekVar : cqVar.b) {
                                                    if (!sVar4.f.o()) {
                                                        if (ekVar.R()) {
                                                            bdVar2 = bdVar4;
                                                            if (!q(ekVar, bdVar2, xVar)) {
                                                                ekVar.o();
                                                            }
                                                        } else {
                                                            bdVar2 = bdVar4;
                                                        }
                                                        if (ekVar.aj()) {
                                                            this.m.a.add(ekVar);
                                                        } else {
                                                            this.f544n.add(ekVar);
                                                        }
                                                        if (ekVar.an()) {
                                                            i6++;
                                                        }
                                                    } else if (this.p.d(c(ekVar.o(), sVar4.h(), ekVar.k() != null ? ekVar.k().b : sVar4.c, sVar4.d, ekVar.J()))) {
                                                        ekVar.o();
                                                        bdVar2 = bdVar4;
                                                    } else {
                                                        if (ekVar.R()) {
                                                            bdVar2 = bdVar4;
                                                        } else {
                                                            bdVar2 = bdVar4;
                                                            if (!q(ekVar, bdVar2, xVar)) {
                                                                ekVar.o();
                                                            }
                                                        }
                                                        if (ekVar.aj()) {
                                                            this.m.a.add(ekVar);
                                                        } else {
                                                            this.f544n.add(ekVar);
                                                        }
                                                        if (ekVar.an()) {
                                                            i6++;
                                                        }
                                                    }
                                                    bdVar4 = bdVar2;
                                                }
                                                if (dVarB8 != null) {
                                                    Trace.endSection();
                                                }
                                                com.google.android.libraries.navigation.internal.nw.d dVarB9 = com.google.android.libraries.navigation.internal.nw.e.b("Labeler.placeLabels - apply deduping rules");
                                                try {
                                                    this.o.clear();
                                                    this.o.ensureCapacity(this.f544n.size());
                                                    this.k.a(dqVar2, this.f544n, this.o);
                                                    if (dVarB9 != null) {
                                                        Trace.endSection();
                                                    }
                                                    com.google.android.libraries.navigation.internal.nw.d dVarB10 = com.google.android.libraries.navigation.internal.nw.e.b("Labeler.expandMultiRepresentationInstances");
                                                    try {
                                                        ArrayList arrayList3 = this.o;
                                                        int size3 = arrayList3.size();
                                                        for (int i7 = 0; i7 < size3; i7++) {
                                                            ev evVarM = ((ek) arrayList3.get(i7)).m();
                                                            if (!evVarM.isEmpty()) {
                                                                arrayList3.set(i7, (ek) evVarM.get(0));
                                                                for (int i8 = 1; i8 < ((lv) evVarM).c; i8++) {
                                                                    arrayList3.add((ek) evVarM.get(i8));
                                                                }
                                                            }
                                                        }
                                                        if (dVarB10 != null) {
                                                            Trace.endSection();
                                                        }
                                                        com.google.android.libraries.navigation.internal.nw.d dVarB11 = com.google.android.libraries.navigation.internal.nw.e.b("Labeler.placeLabels - apply label annotations");
                                                        if (ahVar != null) {
                                                            try {
                                                                hgVar = ((com.google.android.libraries.navigation.internal.po.cj) ahVar).d;
                                                            } catch (Throwable th8) {
                                                                if (dVarB11 == null) {
                                                                    throw th8;
                                                                }
                                                                try {
                                                                    Trace.endSection();
                                                                    throw th8;
                                                                } catch (Throwable th9) {
                                                                    th8.addSuppressed(th9);
                                                                    throw th8;
                                                                }
                                                            }
                                                        } else {
                                                            hgVar = null;
                                                        }
                                                        bh bhVar2 = this.l;
                                                        ArrayList arrayList4 = this.o;
                                                        float fH = sVar4.h();
                                                        g gVar = cqVar.a;
                                                        if (hgVar == null) {
                                                            int i9 = ev.d;
                                                            evVarQ = lv.a;
                                                        } else {
                                                            evVarQ = ev.q(hgVar);
                                                        }
                                                        bhVar2.a(arrayList4, fH, new f(gVar, evVarQ));
                                                        if (dVarB11 != null) {
                                                            Trace.endSection();
                                                        }
                                                        com.google.android.libraries.navigation.internal.nw.d dVarB12 = com.google.android.libraries.navigation.internal.nw.e.b("Labeler.placeLabels - apply styled-off and zoom filters");
                                                        int i10 = 0;
                                                        while (i10 < this.o.size()) {
                                                            try {
                                                                if (((ek) this.o.get(i10)).ad(sVar4.b)) {
                                                                    if (sVar4.f.o()) {
                                                                        if (this.p.d(c(((ek) this.o.get(i10)).o(), sVar4.h(), ((ek) this.o.get(i10)).k() != null ? ((ek) this.o.get(i10)).k().b : sVar4.c, sVar4.d, ((ek) this.o.get(i10)).J()))) {
                                                                        }
                                                                    }
                                                                    i10++;
                                                                }
                                                                int size4 = this.o.size() - 1;
                                                                ArrayList arrayList5 = this.o;
                                                                arrayList5.set(i10, (ek) arrayList5.get(size4));
                                                                this.o.remove(size4);
                                                            } catch (Throwable th10) {
                                                                if (dVarB12 == null) {
                                                                    throw th10;
                                                                }
                                                                try {
                                                                    Trace.endSection();
                                                                    throw th10;
                                                                } catch (Throwable th11) {
                                                                    th10.addSuppressed(th11);
                                                                    throw th10;
                                                                }
                                                            }
                                                        }
                                                        if (dVarB12 != null) {
                                                            Trace.endSection();
                                                        }
                                                        ArrayList arrayList6 = this.o;
                                                        Collections.sort(arrayList6, Collections.reverseOrder(new ch(arrayList6, new com.google.android.libraries.navigation.internal.yx.as() { // from class: com.google.android.libraries.navigation.internal.px.dm
                                                            @Override // com.google.android.libraries.navigation.internal.yx.as
                                                            public final boolean a(Object obj) {
                                                                ek ekVar2 = (ek) obj;
                                                                int i11 = ed.g;
                                                                return ((s) sVar4).f.n() && !ekVar2.ai();
                                                            }
                                                        })));
                                                        com.google.android.libraries.navigation.internal.nw.d dVarB13 = com.google.android.libraries.navigation.internal.nw.e.b("Labeler.placeLabels - iterateFeatures");
                                                        try {
                                                            ArrayList<ek> arrayList7 = new ArrayList(this.o.size());
                                                            ArrayList arrayList8 = new ArrayList((int) (((double) i6) * 1.3d));
                                                            ek ekVar2 = null;
                                                            for (int i11 = 0; i11 < this.o.size(); i11++) {
                                                                ek ekVar3 = (ek) this.o.get(i11);
                                                                if (ekVar3.ad(sVar4.b)) {
                                                                    com.google.android.libraries.navigation.internal.adg.ef efVarO = ekVar3.o();
                                                                    Iterator it5 = cqVar.d.iterator();
                                                                    do {
                                                                        if (!it5.hasNext()) {
                                                                            boolean z4 = ahVar != null && ((com.google.android.libraries.navigation.internal.po.cj) ahVar).a.a(ekVar3);
                                                                            boolean z5 = ekVar2 == null && ekVar3.M();
                                                                            if (!z4) {
                                                                                if (ekVar3.an()) {
                                                                                    arrayList8.add(new ec(ekVar3));
                                                                                    break;
                                                                                } else {
                                                                                    arrayList7.add(ekVar3);
                                                                                    break;
                                                                                }
                                                                            }
                                                                            if (!z5) {
                                                                                break;
                                                                            }
                                                                            com.google.android.libraries.navigation.internal.yx.ar.q(ahVar);
                                                                            com.google.android.libraries.navigation.internal.ol.ag agVarA = ahVar.a(ekVar3, sVar4.b);
                                                                            ek ekVar4 = agVarA.a;
                                                                            if (agVarA.b) {
                                                                                ekVar4.o();
                                                                                eb ebVarJ = j(sVar4, ekVar4, this.z);
                                                                                w(ebVarJ, sVar4);
                                                                                l(ebVarJ);
                                                                            } else {
                                                                                ekVar4.o();
                                                                                if (ekVar4.an()) {
                                                                                    arrayList8.add(new ec(ekVar4));
                                                                                } else {
                                                                                    arrayList7.add(ekVar4);
                                                                                }
                                                                            }
                                                                            ekVar2 = ekVar3;
                                                                            break;
                                                                        }
                                                                    } while (!((com.google.android.libraries.navigation.internal.yx.as) it5.next()).a(efVarO));
                                                                }
                                                            }
                                                            com.google.android.libraries.navigation.internal.agg.bz bzVar2 = new com.google.android.libraries.navigation.internal.agg.bz();
                                                            qVar.e(arrayList8.size() + arrayList7.size());
                                                            Iterator it6 = arrayList8.iterator();
                                                            while (it6.hasNext()) {
                                                                ec ecVar = (ec) it6.next();
                                                                Iterator it7 = it6;
                                                                int iC2 = c(ecVar.a.o(), sVar4.h(), ecVar.a.k() != null ? ecVar.a.k().b : sVar4.c, sVar4.d, ecVar.a.J());
                                                                if (bzVar2.c(iC2)) {
                                                                    t tVar5 = new t();
                                                                    tVar5.f(dz.RENDER_ID_COLLISION);
                                                                    tVar5.c(ecVar.a);
                                                                    ecVar.b = com.google.android.libraries.navigation.internal.yx.an.j(tVar5.a());
                                                                } else {
                                                                    eb ebVarJ2 = j(sVar4, ecVar.a, this.z);
                                                                    ecVar.b = com.google.android.libraries.navigation.internal.yx.an.j(ebVarJ2);
                                                                    bzVar2.a(iC2, ebVarJ2);
                                                                }
                                                                it6 = it7;
                                                            }
                                                            Iterator it8 = arrayList8.iterator();
                                                            while (it8.hasNext()) {
                                                                ec ecVar2 = (ec) it8.next();
                                                                if (!ecVar2.b.g()) {
                                                                    break;
                                                                }
                                                                Object objC = ecVar2.b.c();
                                                                if (((eb) objC).a().e) {
                                                                    ?? C = ((eb) objC).d().c();
                                                                    if (C instanceof ax) {
                                                                        ax axVar = (ax) C;
                                                                        if (o(axVar) && n(C) && axVar.g() != null) {
                                                                            axVar.B = u(sVar4, axVar, !C.A().ap(), 1);
                                                                        }
                                                                    }
                                                                }
                                                                Object objC2 = ecVar2.b.c();
                                                                w((eb) objC2, sVar4);
                                                                l((eb) objC2);
                                                            }
                                                            int iA3 = sVar4.f.a();
                                                            if (sVar4.a.w().l <= 0.0f || iA3 <= 0) {
                                                                Iterator it9 = arrayList7.iterator();
                                                                while (it9.hasNext()) {
                                                                    eb ebVarJ3 = j(sVar4, (ek) it9.next(), this.z);
                                                                    w(ebVarJ3, sVar4);
                                                                    l(ebVarJ3);
                                                                }
                                                            } else {
                                                                com.google.android.libraries.navigation.internal.agg.aq aqVar3 = new com.google.android.libraries.navigation.internal.agg.aq();
                                                                for (ek ekVar5 : arrayList7) {
                                                                    int iS = aqVar3.s(ekVar5.U());
                                                                    if (iS < iA3) {
                                                                        eb ebVarJ4 = j(sVar4, ekVar5, this.z);
                                                                        w(ebVarJ4, sVar4);
                                                                        if (ebVarJ4.a().e) {
                                                                            aqVar3.a(ekVar5.U(), iS + 1);
                                                                        }
                                                                        l(ebVarJ4);
                                                                    }
                                                                }
                                                            }
                                                            while (it8.hasNext()) {
                                                                com.google.android.libraries.navigation.internal.yx.an anVar = ((ec) it8.next()).b;
                                                                if (anVar.g()) {
                                                                    l((eb) anVar.c());
                                                                }
                                                            }
                                                            if (ekVar2 != null && ahVar != null && (agVarB = ahVar.b()) != null) {
                                                                eb ebVarK = k(sVar4, agVarB.a);
                                                                w(ebVarK, sVar4);
                                                                l(ebVarK);
                                                                if (ebVarK.a().e) {
                                                                    this.z.a(agVarB.a);
                                                                }
                                                            }
                                                            if (dVarB13 != null) {
                                                                Trace.endSection();
                                                            }
                                                            this.w.i(this.s);
                                                            Trace.setCounter("numLabelsCreated", this.F);
                                                            this.F = 0;
                                                            eh ehVar = this.a;
                                                            com.google.android.libraries.navigation.internal.yz.eq eqVar = new com.google.android.libraries.navigation.internal.yz.eq();
                                                            com.google.android.libraries.navigation.internal.yz.eq eqVar2 = new com.google.android.libraries.navigation.internal.yz.eq();
                                                            com.google.android.libraries.navigation.internal.yz.eq eqVar3 = new com.google.android.libraries.navigation.internal.yz.eq();
                                                            ey eyVar = new ey();
                                                            ge geVarA = ((com.google.android.libraries.navigation.internal.agg.bb) ((com.google.android.libraries.navigation.internal.agg.be) ehVar.a).l()).listIterator();
                                                            while (geVarA.hasNext()) {
                                                                eb ebVar = (eb) ((com.google.android.libraries.navigation.internal.agg.bh) geVarA.next()).getValue();
                                                                int iZ = ebVar.d().c().z();
                                                                eb ebVar2 = (eb) ehVar.d.p(iZ);
                                                                if (ebVar2 != null) {
                                                                    eqVar3.h(new w(ebVar, ebVar2));
                                                                    eyVar.c(iZ);
                                                                    geVarA.remove();
                                                                }
                                                            }
                                                            ge geVarA2 = ((com.google.android.libraries.navigation.internal.agg.bb) ((com.google.android.libraries.navigation.internal.agg.be) ehVar.a).l()).listIterator();
                                                            while (geVarA2.hasNext()) {
                                                                eb ebVar3 = (eb) ((com.google.android.libraries.navigation.internal.agg.bh) geVarA2.next()).getValue();
                                                                ?? C2 = ebVar3.d().c();
                                                                if (!((b) C2.A()).h) {
                                                                    long j2 = ((b) C2.A()).c;
                                                                    String str = ((b) C2.A()).e;
                                                                    if (j2 == 0) {
                                                                        if (!str.isEmpty()) {
                                                                            j2 = 0;
                                                                        }
                                                                    }
                                                                    eb ebVar4 = j2 != 0 ? (eb) ehVar.e.aO(j2) : (eb) ehVar.f.get(str);
                                                                    if (ebVar4 != null && !eyVar.f(ebVar4.d().c().z())) {
                                                                        eqVar3.h(new w(ebVar3, ebVar4));
                                                                        eyVar.c(ebVar4.d().c().z());
                                                                        geVarA2.remove();
                                                                        C2.D(2);
                                                                    }
                                                                }
                                                            }
                                                            ge geVarA3 = ((com.google.android.libraries.navigation.internal.agg.bb) ((com.google.android.libraries.navigation.internal.agg.be) ehVar.a).l()).listIterator();
                                                            while (geVarA3.hasNext()) {
                                                                com.google.android.libraries.navigation.internal.agg.bh bhVar3 = (com.google.android.libraries.navigation.internal.agg.bh) geVarA3.next();
                                                                ?? C3 = ((eb) bhVar3.getValue()).d().c();
                                                                eqVar.h((eb) bhVar3.getValue());
                                                                C3.D(2);
                                                            }
                                                            ge geVarA4 = ((com.google.android.libraries.navigation.internal.agg.bb) ((com.google.android.libraries.navigation.internal.agg.be) ehVar.d).l()).listIterator();
                                                            while (geVarA4.hasNext()) {
                                                                com.google.android.libraries.navigation.internal.agg.bh bhVar4 = (com.google.android.libraries.navigation.internal.agg.bh) geVarA4.next();
                                                                if (!eyVar.f(((eb) bhVar4.getValue()).d().c().z())) {
                                                                    eqVar2.h((eb) bhVar4.getValue());
                                                                }
                                                            }
                                                            com.google.android.libraries.navigation.internal.agh.ea eaVar = ehVar.b;
                                                            ehVar.b = ehVar.e;
                                                            ehVar.e = eaVar;
                                                            ehVar.e.clear();
                                                            com.google.android.libraries.navigation.internal.agi.ey eyVar2 = ehVar.c;
                                                            ehVar.c = ehVar.f;
                                                            ehVar.f = eyVar2;
                                                            ehVar.f.clear();
                                                            ehVar.g.clear();
                                                            com.google.android.libraries.navigation.internal.agg.bj bjVar = ehVar.a;
                                                            ehVar.a = ehVar.d;
                                                            ehVar.d = bjVar;
                                                            ehVar.d.clear();
                                                            v vVar = new v(eqVar.g(), eqVar2.g(), eqVar3.g());
                                                            qVar.b(((lv) vVar.b).c);
                                                            qVar.i(((lv) vVar.c).c);
                                                            qVar.f(((lv) vVar.a).c);
                                                            if (sVar4.e) {
                                                                ev evVar = vVar.a;
                                                                int i12 = ((lv) evVar).c;
                                                                for (int i13 = 0; i13 < i12; i13++) {
                                                                    m(((eb) evVar.get(i13)).d().c());
                                                                }
                                                                ev evVar2 = vVar.c;
                                                                int i14 = ((lv) evVar2).c;
                                                                for (int i15 = 0; i15 < i14; i15++) {
                                                                    eg egVar = (eg) evVar2.get(i15);
                                                                    ?? C4 = egVar.b().d().c();
                                                                    ?? C5 = egVar.a().d().c();
                                                                    boolean z6 = egVar.a().a().f;
                                                                    if (C4 == C5) {
                                                                        boolean zG = this.x.g(C5.z());
                                                                        if (z6) {
                                                                            this.e.d(C5, this.x.b(C5));
                                                                        } else if (zG) {
                                                                            this.x.e(C5.z());
                                                                            this.e.d(C5, com.google.android.libraries.navigation.internal.yx.a.a);
                                                                        }
                                                                    } else {
                                                                        if (!C5.G()) {
                                                                            com.google.android.libraries.navigation.internal.yx.an anVarB = z6 ? this.x.b(C5) : com.google.android.libraries.navigation.internal.yx.a.a;
                                                                            if (C5.r()) {
                                                                                this.e.a(C5, anVarB);
                                                                            }
                                                                            C5.E(true);
                                                                        }
                                                                        if (C4.G()) {
                                                                            if (C4.r()) {
                                                                                this.e.c(C4);
                                                                            }
                                                                            this.x.e(C4.z());
                                                                            C4.E(false);
                                                                        }
                                                                        this.d.d(C4, C5);
                                                                    }
                                                                }
                                                                i2 = 0;
                                                                ev evVar3 = vVar.b;
                                                                int i16 = ((lv) evVar3).c;
                                                                for (int i17 = 0; i17 < i16; i17++) {
                                                                    eb ebVar5 = (eb) evVar3.get(i17);
                                                                    ?? C6 = ebVar5.d().c();
                                                                    com.google.android.libraries.navigation.internal.yx.an anVarB2 = ebVar5.a().f ? this.x.b(C6) : com.google.android.libraries.navigation.internal.yx.a.a;
                                                                    if (!C6.G()) {
                                                                        if (C6.r()) {
                                                                            this.e.a(C6, anVarB2);
                                                                        }
                                                                        this.d.a(C6);
                                                                        C6.E(true);
                                                                    }
                                                                }
                                                                this.c.b(vVar);
                                                                Trace.setCounter("numLabelsPlaced", ((lv) vVar.b).c + ((lv) vVar.c).c);
                                                            } else {
                                                                i2 = 0;
                                                            }
                                                            for (int i18 = i2; i18 < this.t.size(); i18++) {
                                                                ((ai) this.t.get(i18)).D(1);
                                                            }
                                                            this.t.clear();
                                                            long jCurrentThreadTimeMillis2 = SystemClock.currentThreadTimeMillis();
                                                            long j3 = this.A;
                                                            long j4 = jCurrentThreadTimeMillis2 - j3;
                                                            if (j3 > 0 && j4 > TimeUnit.SECONDS.toMillis(20L)) {
                                                                TimeUnit.MILLISECONDS.toSeconds(j4);
                                                            }
                                                            this.A = -1L;
                                                            this.y.b(this.v.a());
                                                            this.v.b();
                                                            qVar.c(SystemClock.elapsedRealtime());
                                                            this.G.set(qVar.a());
                                                            if (dqVar != 0) {
                                                                Trace.endSection();
                                                            }
                                                        } catch (Throwable th12) {
                                                            if (dVarB13 == null) {
                                                                throw th12;
                                                            }
                                                            try {
                                                                Trace.endSection();
                                                                throw th12;
                                                            } catch (Throwable th13) {
                                                                th12.addSuppressed(th13);
                                                                throw th12;
                                                            }
                                                        }
                                                    } catch (Throwable th14) {
                                                        if (dVarB10 == null) {
                                                            throw th14;
                                                        }
                                                        try {
                                                            Trace.endSection();
                                                            throw th14;
                                                        } catch (Throwable th15) {
                                                            th14.addSuppressed(th15);
                                                            throw th14;
                                                        }
                                                    }
                                                } catch (Throwable th16) {
                                                    if (dVarB9 == null) {
                                                        throw th16;
                                                    }
                                                    try {
                                                        Trace.endSection();
                                                        throw th16;
                                                    } catch (Throwable th17) {
                                                        th16.addSuppressed(th17);
                                                        throw th16;
                                                    }
                                                }
                                            } catch (Throwable th18) {
                                                if (dVarB8 == null) {
                                                    throw th18;
                                                }
                                                try {
                                                    Trace.endSection();
                                                    throw th18;
                                                } catch (Throwable th19) {
                                                    th18.addSuppressed(th19);
                                                    throw th18;
                                                }
                                            }
                                        } catch (Throwable th20) {
                                            if (dVarB7 == null) {
                                                throw th20;
                                            }
                                            try {
                                                Trace.endSection();
                                                throw th20;
                                            } catch (Throwable th21) {
                                                th20.addSuppressed(th21);
                                                throw th20;
                                            }
                                        }
                                    } catch (Throwable th22) {
                                        th = th22;
                                        Throwable th23 = th;
                                        if (dVarB6 == null) {
                                            throw th23;
                                        }
                                        try {
                                            Trace.endSection();
                                            throw th23;
                                        } catch (Throwable th24) {
                                            th23.addSuppressed(th24);
                                            throw th23;
                                        }
                                    }
                                } catch (Throwable th25) {
                                    th = th25;
                                }
                            } catch (Throwable th26) {
                                if (dVarB5 == null) {
                                    throw th26;
                                }
                                try {
                                    Trace.endSection();
                                    throw th26;
                                } catch (Throwable th27) {
                                    th26.addSuppressed(th27);
                                    throw th26;
                                }
                            }
                        } catch (Throwable th28) {
                            if (dVarB3 == null) {
                                throw th28;
                            }
                            try {
                                Trace.endSection();
                                throw th28;
                            } catch (Throwable th29) {
                                th28.addSuppressed(th29);
                                throw th28;
                            }
                        }
                    } catch (Throwable th30) {
                        th = th30;
                    }
                } catch (Throwable th31) {
                    dqVar = dVarB;
                    if (dVarB2 == null) {
                        throw th31;
                    }
                    try {
                        Trace.endSection();
                        throw th31;
                    } catch (Throwable th32) {
                        th31.addSuppressed(th32);
                        throw th31;
                    }
                }
            } catch (Throwable th33) {
                th = th33;
                th = th;
                if (dqVar != 0) {
                    throw th;
                }
                Trace.endSection();
                throw th;
            }
        } catch (Throwable th34) {
            th = th34;
            dqVar = dVarB;
        }
    }

    private static dt f(boolean z, boolean z2, boolean z3) throws IllegalArgumentException {
        if (z2 && !z) {
            throw new IllegalArgumentException("Secondary label cannot be placed without primary.");
        }
        if (z3 && !z) {
            throw new IllegalArgumentException("Tertiary label cannot be placed without primary.");
        }
        if (!z) {
            return dt.NOTHING_PLACED;
        }
        if (z2) {
            return z3 ? dt.PRIMARY_SECONDARY_AND_TERTIARY_PLACED : dt.PRIMARY_AND_SECONDARY_PLACED;
        }
        return z3 ? dt.PRIMARY_AND_TERTIARY_PLACED : dt.ONLY_PRIMARY_PLACED;
    }

    /* JADX WARN: Type inference failed for: r0v34, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v40, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v3, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v21, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v12, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v16, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    private final void w(eb ebVar, dy dyVar) {
        com.google.android.libraries.navigation.internal.yx.an anVar;
        com.google.android.libraries.navigation.internal.yx.an anVar2;
        s sVar = (s) dyVar;
        if (sVar.e) {
            eh ehVar = this.a;
            if (!ebVar.a().e || ebVar.c().C()) {
                anVar = com.google.android.libraries.navigation.internal.yx.a.a;
            } else {
                ?? C = ebVar.d().c();
                if (ehVar.d.p(C.z()) != null) {
                    anVar = com.google.android.libraries.navigation.internal.yx.a.a;
                } else {
                    com.google.android.libraries.navigation.internal.adg.ef efVar = ((b) C.A()).b;
                    if (efVar == null) {
                        anVar2 = com.google.android.libraries.navigation.internal.yx.a.a;
                    } else {
                        com.google.android.libraries.navigation.internal.yx.an anVarI = com.google.android.libraries.navigation.internal.yx.an.i((eb) ehVar.g.get(efVar));
                        if (anVarI.g()) {
                            eb ebVar2 = (eb) anVarI.c();
                            ehVar.d.b(ebVar2.d().c().z());
                            if (ebVar2.c().e() != 0) {
                                ehVar.e.b(ebVar2.c().e());
                            } else if (!ebVar2.c().u().isEmpty()) {
                                ehVar.f.remove(ebVar2.c().u());
                            }
                            ehVar.g.remove(efVar);
                            ((eb) anVarI.c()).d().c().C(1);
                        }
                        anVar2 = anVarI;
                    }
                    if (anVar2.g()) {
                        ?? C2 = ((eb) anVar2.c()).d().c();
                        if (!ehVar.a.c(C2.z())) {
                            C2.D(2);
                        }
                    }
                    ehVar.d.a(C.z(), ebVar);
                    long j2 = ((b) C.A()).c;
                    String str = ((b) C.A()).e;
                    boolean z = ((b) C.A()).h;
                    if (j2 != 0 && !z) {
                        ehVar.e.a(j2, ebVar);
                    }
                    if (j2 == 0 && !str.isEmpty() && !z) {
                        ehVar.f.put(str, ebVar);
                    }
                    com.google.android.libraries.navigation.internal.adg.ef efVar2 = ((b) C.A()).b;
                    if (efVar2 != null) {
                        ehVar.g.put(efVar2, ebVar);
                    }
                    if (!ehVar.a.c(C.z())) {
                        C.C(2);
                    }
                    anVar = anVar2;
                }
            }
            boolean z2 = false;
            if (anVar.g()) {
                ?? C3 = ((eb) anVar.c()).d().c();
                com.google.android.libraries.navigation.internal.qb.c cVar = sVar.g;
                ek ekVarA = C3.A();
                for (com.google.android.libraries.navigation.internal.qb.b bVar : cVar.c) {
                    if (bVar != null) {
                        int i2 = 0;
                        while (i2 < bVar.a.size()) {
                            if (((com.google.android.libraries.navigation.internal.qb.d) bVar.a.get(i2)).a == ekVarA) {
                                int size = bVar.a.size() - 1;
                                ArrayList arrayList = bVar.a;
                                arrayList.set(i2, (com.google.android.libraries.navigation.internal.qb.d) arrayList.get(size));
                                bVar.a.remove(size);
                            } else {
                                i2++;
                            }
                        }
                    }
                }
                C3.D(1);
            }
            boolean zH = ebVar.c().h().h();
            if (ebVar.d().g() && (ebVar.d().c() instanceof ah)) {
                z2 = true;
            }
            if (ebVar.c().C()) {
                ek ekVarC = ebVar.c();
                if (!ebVar.a().e) {
                    if (ebVar.a().g && ekVarC.z()) {
                        this.x.h(ekVarC, ck.a);
                        this.v.c(ekVarC, 7);
                        return;
                    }
                    return;
                }
                ?? C4 = ebVar.d().c();
                this.t.add(C4);
                if (ebVar.a().f) {
                    this.x.h(C4.A(), ck.b);
                    this.v.c(ekVarC, 5);
                    return;
                }
                return;
            }
            if (!zH || z2) {
                return;
            }
            float f = sVar.b;
            ek ekVarC2 = ebVar.c();
            if (f >= 14.0f && ekVarC2.h().h() && this.w.j() && ekVarC2.L()) {
                com.google.android.libraries.navigation.internal.adg.ef efVarO = ekVarC2.o();
                com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.W);
                efVarO.h(bhVarS);
                Object objK = efVarO.w.k(bhVarS.d);
                ev evVarF = com.google.android.libraries.navigation.internal.yz.de.d(((com.google.android.libraries.navigation.internal.acw.j) (objK == null ? bhVarS.b : bhVarS.c(objK))).b).e(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.px.dl
                    @Override // com.google.android.libraries.navigation.internal.yx.aa
                    public final Object ak(Object obj) {
                        com.google.android.libraries.navigation.internal.pt.d dVarB = com.google.android.libraries.navigation.internal.pt.d.b((com.google.android.libraries.navigation.internal.acw.h) obj);
                        return dVarB != null ? dVarB : com.google.android.libraries.navigation.internal.pt.d.a;
                    }
                }).f();
                if (!evVarF.isEmpty()) {
                    this.s.addAll(evVarF);
                }
            }
            if (!ebVar.c().C()) {
                ek ekVarC3 = ebVar.c();
                if (ebVar.a().g && ekVarC3.z()) {
                    this.x.h(ekVarC3, ck.a);
                    this.v.c(ekVarC3, 7);
                }
            }
            ek ekVarC4 = ebVar.c();
            if (ebVar.a().g && ekVarC4.z()) {
                this.x.h(ekVarC4, ck.a);
                this.v.c(ekVarC4, 7);
                return;
            }
            if (ebVar.a().e) {
                ax axVar = (ax) ebVar.d().c();
                if (!ebVar.a().f) {
                    this.v.c(ekVarC4, 6);
                    return;
                }
                if (axVar.C) {
                    if (axVar.H()) {
                        this.v.c(ekVarC4, 3);
                        return;
                    } else {
                        this.v.c(ekVarC4, 1);
                        return;
                    }
                }
                if (axVar.H()) {
                    this.v.c(ekVarC4, 4);
                } else {
                    this.v.c(ekVarC4, 2);
                }
            }
        }
    }
}
