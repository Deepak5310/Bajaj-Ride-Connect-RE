package com.google.android.libraries.navigation.internal.uh;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.ace.hm;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.afl.qj;
import com.google.android.libraries.navigation.internal.bm.ak;
import com.google.android.libraries.navigation.internal.bm.am;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.cl.bd;
import com.google.android.libraries.navigation.internal.cl.be;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fz;
import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Executor;
import org.joda.time.Instant;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l extends m {
    private ii A;
    private boolean B;
    private final com.google.android.libraries.navigation.internal.afo.a C;
    private final Executor D;
    private final e E;
    private final com.google.android.libraries.navigation.internal.cv.e F;
    private final com.google.android.libraries.navigation.internal.cv.e G;
    private final com.google.android.libraries.navigation.internal.cu.d H;
    protected final com.google.android.libraries.navigation.internal.ub.l a;
    public final com.google.android.libraries.navigation.internal.afo.a b;
    public final com.google.android.libraries.navigation.internal.oa.k c;
    public final com.google.android.libraries.navigation.internal.rw.n d;
    public final com.google.android.libraries.navigation.internal.so.c e;
    public final com.google.android.libraries.navigation.internal.ia.e f;
    public final com.google.android.libraries.navigation.internal.iv.f g;
    public final com.google.android.libraries.navigation.internal.jy.t h;
    public bd i;
    public be j;
    public final com.google.android.libraries.navigation.internal.az.b k;
    public final br l;
    public final com.google.android.libraries.navigation.internal.iv.p m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f612n;
    public com.google.android.libraries.navigation.internal.ui.a o;
    public final com.google.android.libraries.navigation.internal.afo.a p;
    public final com.google.android.libraries.navigation.internal.afo.a q;
    public final com.google.android.libraries.navigation.internal.afo.a r;
    public final com.google.android.libraries.navigation.internal.afo.a s;
    private final com.google.android.libraries.navigation.internal.kl.b u;
    private final f v;
    private final com.google.android.libraries.navigation.internal.s.b w;
    private final Optional x;
    private final br y;
    private final com.google.android.libraries.navigation.internal.nt.t z;

    public l(n nVar, com.google.android.libraries.navigation.internal.pi.s sVar, com.google.android.libraries.navigation.internal.rw.n nVar2, com.google.android.libraries.navigation.internal.so.c cVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.jy.t tVar, p pVar, com.google.android.libraries.navigation.internal.ub.l lVar, com.google.android.libraries.navigation.internal.kl.b bVar, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.oa.k kVar, com.google.android.libraries.navigation.internal.oq.d dVar, com.google.android.libraries.navigation.internal.s.b bVar2, com.google.android.libraries.navigation.internal.az.b bVar3, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.afo.a aVar4, com.google.android.libraries.navigation.internal.afo.a aVar5, com.google.android.libraries.navigation.internal.iv.p pVar2, com.google.android.libraries.navigation.internal.cv.e eVar2, com.google.android.libraries.navigation.internal.cv.e eVar3, Executor executor, com.google.android.libraries.navigation.internal.cu.d dVar2, com.google.android.libraries.navigation.internal.afo.a aVar6) {
        super(nVar, pVar);
        this.x = Optional.empty();
        Optional.empty();
        this.y = new i(this);
        this.l = new j(this);
        this.z = new com.google.android.libraries.navigation.internal.nt.t() { // from class: com.google.android.libraries.navigation.internal.uh.h
            @Override // com.google.android.libraries.navigation.internal.nt.t
            public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
                l lVar2 = this.a;
                if (((qj) lVar2.r.a()).o) {
                    ((com.google.android.libraries.navigation.internal.cv.c) lVar2.b.a()).d(com.google.android.libraries.navigation.internal.cv.a.THREE_DIMENSIONAL, lVar2.g.y(lVar2.m, lVar2.f612n));
                }
            }
        };
        k kVar2 = new k(this);
        this.E = kVar2;
        this.d = nVar2;
        this.e = cVar;
        this.f = eVar;
        this.h = tVar;
        this.u = bVar;
        this.a = lVar;
        this.b = aVar;
        this.v = new f(nVar, dVar, sVar, executor, kVar2);
        this.k = bVar3;
        this.c = kVar;
        this.w = bVar2;
        this.p = aVar2;
        this.r = aVar4;
        this.C = aVar5;
        this.g = fVar;
        this.m = pVar2;
        this.f612n = true;
        this.q = aVar3;
        this.F = eVar2;
        this.G = eVar3;
        this.D = executor;
        this.H = dVar2;
        this.s = aVar6;
        if (!dVar2.a() && ((qj) aVar4.a()).o && ((com.google.android.libraries.navigation.internal.cv.c) aVar.a()).b(com.google.android.libraries.navigation.internal.cv.a.SATELLITE)) {
            fVar.n(pVar2, false);
        }
    }

    private static ii c(com.google.android.libraries.navigation.internal.tj.j jVar) {
        if (jVar == null || jVar.c() == null) {
            return null;
        }
        bg bgVar = jVar.c().b;
        return jVar.c().b.u;
    }

    private static boolean d(com.google.android.libraries.navigation.internal.ui.a aVar) {
        return aVar.e != com.google.android.libraries.navigation.internal.ea.d.NO_SEARCH;
    }

    public final void a() {
        bd bdVarA = ((i) this.y).a();
        ap.UI_THREAD.f();
        am amVar = ((com.google.android.libraries.navigation.internal.bm.o) this.k).g;
        synchronized (amVar.X) {
            ak akVar = amVar.Y;
            if (akVar != null) {
                akVar.a.d(bdVarA);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.m, com.google.android.libraries.navigation.internal.uh.c
    public final void aC() {
        this.v.a = null;
        com.google.android.libraries.navigation.internal.ui.a aVar = this.o;
        if (aVar != null && d(aVar) && this.B && !((com.google.android.libraries.navigation.internal.cv.c) this.b.a()).b(com.google.android.libraries.navigation.internal.cv.a.TRAFFIC)) {
            if (this.H.a()) {
                com.google.android.libraries.navigation.internal.cv.e.c(com.google.android.libraries.navigation.internal.cv.a.TRAFFIC);
                com.google.android.libraries.navigation.internal.cv.e.c(com.google.android.libraries.navigation.internal.cv.a.TRAFFIC);
            } else {
                ((com.google.android.libraries.navigation.internal.cv.c) this.b.a()).d(com.google.android.libraries.navigation.internal.cv.a.TRAFFIC, this.B);
            }
        }
        super.aC();
    }

    /* JADX WARN: Code duplicated, block: B:109:0x018f  */
    /* JADX WARN: Code duplicated, block: B:144:0x0214 A[Catch: all -> 0x0020, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0020, blocks: (B:4:0x000e, B:6:0x0014, B:8:0x001a, B:14:0x002c, B:16:0x0032, B:18:0x0036, B:20:0x0046, B:22:0x004e, B:23:0x0059, B:29:0x0075, B:31:0x007b, B:33:0x0093, B:50:0x00f4, B:60:0x0108, B:66:0x0114, B:73:0x0122, B:80:0x0130, B:87:0x0142, B:93:0x014e, B:102:0x0164, B:104:0x0168, B:127:0x01ce, B:136:0x01e8, B:144:0x0214, B:149:0x0227, B:153:0x023a, B:34:0x009e, B:36:0x00ae, B:39:0x00b6, B:41:0x00bc, B:43:0x00c0, B:45:0x00d0, B:47:0x00d8, B:48:0x00e3), top: B:215:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:146:0x021d A[Catch: all -> 0x0366, TRY_ENTER, TryCatch #3 {all -> 0x0366, blocks: (B:12:0x0026, B:25:0x006c, B:98:0x015c, B:110:0x0190, B:120:0x01ac, B:122:0x01b6, B:125:0x01bc, B:134:0x01e2, B:142:0x020e, B:147:0x0221, B:156:0x023f, B:151:0x0231, B:155:0x023d, B:146:0x021d, B:130:0x01db), top: B:218:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x0227 A[Catch: all -> 0x0020, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0020, blocks: (B:4:0x000e, B:6:0x0014, B:8:0x001a, B:14:0x002c, B:16:0x0032, B:18:0x0036, B:20:0x0046, B:22:0x004e, B:23:0x0059, B:29:0x0075, B:31:0x007b, B:33:0x0093, B:50:0x00f4, B:60:0x0108, B:66:0x0114, B:73:0x0122, B:80:0x0130, B:87:0x0142, B:93:0x014e, B:102:0x0164, B:104:0x0168, B:127:0x01ce, B:136:0x01e8, B:144:0x0214, B:149:0x0227, B:153:0x023a, B:34:0x009e, B:36:0x00ae, B:39:0x00b6, B:41:0x00bc, B:43:0x00c0, B:45:0x00d0, B:47:0x00d8, B:48:0x00e3), top: B:215:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:151:0x0231 A[Catch: all -> 0x0366, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0366, blocks: (B:12:0x0026, B:25:0x006c, B:98:0x015c, B:110:0x0190, B:120:0x01ac, B:122:0x01b6, B:125:0x01bc, B:134:0x01e2, B:142:0x020e, B:147:0x0221, B:156:0x023f, B:151:0x0231, B:155:0x023d, B:146:0x021d, B:130:0x01db), top: B:218:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x023a A[Catch: all -> 0x0020, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0020, blocks: (B:4:0x000e, B:6:0x0014, B:8:0x001a, B:14:0x002c, B:16:0x0032, B:18:0x0036, B:20:0x0046, B:22:0x004e, B:23:0x0059, B:29:0x0075, B:31:0x007b, B:33:0x0093, B:50:0x00f4, B:60:0x0108, B:66:0x0114, B:73:0x0122, B:80:0x0130, B:87:0x0142, B:93:0x014e, B:102:0x0164, B:104:0x0168, B:127:0x01ce, B:136:0x01e8, B:144:0x0214, B:149:0x0227, B:153:0x023a, B:34:0x009e, B:36:0x00ae, B:39:0x00b6, B:41:0x00bc, B:43:0x00c0, B:45:0x00d0, B:47:0x00d8, B:48:0x00e3), top: B:215:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:155:0x023d A[Catch: all -> 0x0366, TRY_ENTER, TryCatch #3 {all -> 0x0366, blocks: (B:12:0x0026, B:25:0x006c, B:98:0x015c, B:110:0x0190, B:120:0x01ac, B:122:0x01b6, B:125:0x01bc, B:134:0x01e2, B:142:0x020e, B:147:0x0221, B:156:0x023f, B:151:0x0231, B:155:0x023d, B:146:0x021d, B:130:0x01db), top: B:218:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:165:0x029e  */
    /* JADX WARN: Code duplicated, block: B:168:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:169:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:172:0x02d0 A[Catch: all -> 0x0364, TryCatch #2 {all -> 0x0364, blocks: (B:195:0x034f, B:198:0x035b, B:158:0x0243, B:160:0x0290, B:162:0x0294, B:166:0x029f, B:170:0x02ac, B:172:0x02d0, B:173:0x02d4, B:175:0x02dd, B:177:0x02e3, B:178:0x02ec, B:180:0x02f0, B:182:0x0300, B:186:0x0315, B:185:0x0313, B:187:0x032c, B:189:0x0330, B:190:0x0338, B:192:0x033c, B:193:0x0340), top: B:216:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x02dd A[Catch: all -> 0x0364, TryCatch #2 {all -> 0x0364, blocks: (B:195:0x034f, B:198:0x035b, B:158:0x0243, B:160:0x0290, B:162:0x0294, B:166:0x029f, B:170:0x02ac, B:172:0x02d0, B:173:0x02d4, B:175:0x02dd, B:177:0x02e3, B:178:0x02ec, B:180:0x02f0, B:182:0x0300, B:186:0x0315, B:185:0x0313, B:187:0x032c, B:189:0x0330, B:190:0x0338, B:192:0x033c, B:193:0x0340), top: B:216:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:177:0x02e3 A[Catch: all -> 0x0364, TryCatch #2 {all -> 0x0364, blocks: (B:195:0x034f, B:198:0x035b, B:158:0x0243, B:160:0x0290, B:162:0x0294, B:166:0x029f, B:170:0x02ac, B:172:0x02d0, B:173:0x02d4, B:175:0x02dd, B:177:0x02e3, B:178:0x02ec, B:180:0x02f0, B:182:0x0300, B:186:0x0315, B:185:0x0313, B:187:0x032c, B:189:0x0330, B:190:0x0338, B:192:0x033c, B:193:0x0340), top: B:216:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:178:0x02ec A[Catch: all -> 0x0364, TryCatch #2 {all -> 0x0364, blocks: (B:195:0x034f, B:198:0x035b, B:158:0x0243, B:160:0x0290, B:162:0x0294, B:166:0x029f, B:170:0x02ac, B:172:0x02d0, B:173:0x02d4, B:175:0x02dd, B:177:0x02e3, B:178:0x02ec, B:180:0x02f0, B:182:0x0300, B:186:0x0315, B:185:0x0313, B:187:0x032c, B:189:0x0330, B:190:0x0338, B:192:0x033c, B:193:0x0340), top: B:216:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:180:0x02f0 A[Catch: all -> 0x0364, TryCatch #2 {all -> 0x0364, blocks: (B:195:0x034f, B:198:0x035b, B:158:0x0243, B:160:0x0290, B:162:0x0294, B:166:0x029f, B:170:0x02ac, B:172:0x02d0, B:173:0x02d4, B:175:0x02dd, B:177:0x02e3, B:178:0x02ec, B:180:0x02f0, B:182:0x0300, B:186:0x0315, B:185:0x0313, B:187:0x032c, B:189:0x0330, B:190:0x0338, B:192:0x033c, B:193:0x0340), top: B:216:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:182:0x0300 A[Catch: all -> 0x0364, TryCatch #2 {all -> 0x0364, blocks: (B:195:0x034f, B:198:0x035b, B:158:0x0243, B:160:0x0290, B:162:0x0294, B:166:0x029f, B:170:0x02ac, B:172:0x02d0, B:173:0x02d4, B:175:0x02dd, B:177:0x02e3, B:178:0x02ec, B:180:0x02f0, B:182:0x0300, B:186:0x0315, B:185:0x0313, B:187:0x032c, B:189:0x0330, B:190:0x0338, B:192:0x033c, B:193:0x0340), top: B:216:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:184:0x0310  */
    /* JADX WARN: Code duplicated, block: B:185:0x0313 A[Catch: all -> 0x0364, TryCatch #2 {all -> 0x0364, blocks: (B:195:0x034f, B:198:0x035b, B:158:0x0243, B:160:0x0290, B:162:0x0294, B:166:0x029f, B:170:0x02ac, B:172:0x02d0, B:173:0x02d4, B:175:0x02dd, B:177:0x02e3, B:178:0x02ec, B:180:0x02f0, B:182:0x0300, B:186:0x0315, B:185:0x0313, B:187:0x032c, B:189:0x0330, B:190:0x0338, B:192:0x033c, B:193:0x0340), top: B:216:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:189:0x0330 A[Catch: all -> 0x0364, TryCatch #2 {all -> 0x0364, blocks: (B:195:0x034f, B:198:0x035b, B:158:0x0243, B:160:0x0290, B:162:0x0294, B:166:0x029f, B:170:0x02ac, B:172:0x02d0, B:173:0x02d4, B:175:0x02dd, B:177:0x02e3, B:178:0x02ec, B:180:0x02f0, B:182:0x0300, B:186:0x0315, B:185:0x0313, B:187:0x032c, B:189:0x0330, B:190:0x0338, B:192:0x033c, B:193:0x0340), top: B:216:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:192:0x033c A[Catch: all -> 0x0364, TryCatch #2 {all -> 0x0364, blocks: (B:195:0x034f, B:198:0x035b, B:158:0x0243, B:160:0x0290, B:162:0x0294, B:166:0x029f, B:170:0x02ac, B:172:0x02d0, B:173:0x02d4, B:175:0x02dd, B:177:0x02e3, B:178:0x02ec, B:180:0x02f0, B:182:0x0300, B:186:0x0315, B:185:0x0313, B:187:0x032c, B:189:0x0330, B:190:0x0338, B:192:0x033c, B:193:0x0340), top: B:216:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:193:0x0340 A[Catch: all -> 0x0364, TryCatch #2 {all -> 0x0364, blocks: (B:195:0x034f, B:198:0x035b, B:158:0x0243, B:160:0x0290, B:162:0x0294, B:166:0x029f, B:170:0x02ac, B:172:0x02d0, B:173:0x02d4, B:175:0x02dd, B:177:0x02e3, B:178:0x02ec, B:180:0x02f0, B:182:0x0300, B:186:0x0315, B:185:0x0313, B:187:0x032c, B:189:0x0330, B:190:0x0338, B:192:0x033c, B:193:0x0340), top: B:216:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:213:0x036c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:221:? A[SYNTHETIC] */
    @Override // com.google.android.libraries.navigation.internal.uh.o
    public final void f(com.google.android.libraries.navigation.internal.ui.a aVar, com.google.android.libraries.navigation.internal.ui.a aVar2) throws Throwable {
        com.google.android.libraries.navigation.internal.nw.d dVar;
        Throwable th;
        boolean z;
        com.google.android.libraries.navigation.internal.tj.j jVar;
        boolean z2;
        boolean z3;
        boolean z4;
        ev evVarC;
        Optional optionalEmpty;
        com.google.android.libraries.navigation.internal.bt.e eVar;
        com.google.android.libraries.navigation.internal.bt.d dVarQ;
        boolean z5;
        boolean z6;
        com.google.android.libraries.navigation.internal.tj.j jVar2;
        ck ckVarU;
        com.google.android.libraries.navigation.internal.afo.a aVar3;
        com.google.android.libraries.navigation.internal.oe.j jVarM;
        long j;
        com.google.android.libraries.navigation.internal.tj.j jVar3;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("NavigationMapController.onNavigationUiStateChanged");
        if (aVar2 != null) {
            try {
                if (!aVar.c() && aVar2.c()) {
                    this.k.d();
                }
            } catch (Throwable th2) {
                th = th2;
                dVar = dVarB;
                if (dVar != null) {
                    throw th;
                }
                try {
                    Trace.endSection();
                    throw th;
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                    throw th;
                }
            }
        }
        try {
            if (aVar.c()) {
                if (d(aVar) && aVar2 != null && !d(aVar2)) {
                    this.B = ((com.google.android.libraries.navigation.internal.cv.c) this.b.a()).b(com.google.android.libraries.navigation.internal.cv.a.TRAFFIC);
                    if (this.H.a()) {
                        com.google.android.libraries.navigation.internal.cv.e.c(com.google.android.libraries.navigation.internal.cv.a.TRAFFIC);
                        com.google.android.libraries.navigation.internal.cv.e.c(com.google.android.libraries.navigation.internal.cv.a.TRAFFIC);
                    } else {
                        ((com.google.android.libraries.navigation.internal.cv.c) this.b.a()).d(com.google.android.libraries.navigation.internal.cv.a.TRAFFIC, false);
                    }
                } else if (aVar != null && !d(aVar) && aVar2 != null && d(aVar2) && this.B && !((com.google.android.libraries.navigation.internal.cv.c) this.b.a()).b(com.google.android.libraries.navigation.internal.cv.a.TRAFFIC)) {
                    if (this.H.a()) {
                        com.google.android.libraries.navigation.internal.cv.e.c(com.google.android.libraries.navigation.internal.cv.a.TRAFFIC);
                        com.google.android.libraries.navigation.internal.cv.e.c(com.google.android.libraries.navigation.internal.cv.a.TRAFFIC);
                    } else {
                        ((com.google.android.libraries.navigation.internal.cv.c) this.b.a()).d(com.google.android.libraries.navigation.internal.cv.a.TRAFFIC, this.B);
                    }
                }
                boolean z7 = aVar2 != null && aVar2.c();
                boolean z8 = aVar2 == null || !z7;
                boolean z9 = (aVar2 != null && z7 && aVar.j == aVar2.j) ? false : true;
                boolean z10 = aVar2 == null || aVar.i != aVar2.i;
                boolean z11 = (aVar2 != null && z7 && aVar.d == aVar2.d) ? false : true;
                boolean z12 = (aVar2 != null && z7 && com.google.android.libraries.navigation.internal.yx.am.a(aVar.e, aVar2.e)) ? false : true;
                boolean z13 = (aVar2 != null && z7 && aVar.g == aVar2.g) ? false : true;
                boolean z14 = aVar2 == null || aVar.c.a != aVar2.c.a;
                com.google.android.libraries.navigation.internal.tj.j jVar4 = aVar.h;
                if (z7) {
                    if (jVar4 != null && aVar2 != null && (jVar3 = aVar2.h) != null) {
                        z = (jVar4.c().b == jVar3.c().b && hx.i(jVar4.b().b(), jVar3.b().b())) ? false : true;
                    }
                }
                boolean zA = com.google.android.libraries.navigation.internal.yx.am.a(c(jVar4), this.A);
                if ((z || z8 || z9 || !zA || z10 || z11 || z12 || z13 || z14) && az().c() && (jVar = aVar.h) != null) {
                    bh bhVarB = jVar.b();
                    com.google.android.libraries.navigation.internal.ea.d dVar2 = aVar.e;
                    com.google.android.libraries.navigation.internal.ea.d dVar3 = com.google.android.libraries.navigation.internal.ea.d.NO_SEARCH;
                    com.google.android.libraries.navigation.internal.ea.g gVar = aVar.d;
                    boolean z15 = ((aVar.b() == al.WALK && ((com.google.android.libraries.navigation.internal.afl.bh) this.p.a()).d) || aVar.g) ? false : true;
                    Optional optionalEmpty2 = Optional.empty();
                    try {
                        if (gVar != null) {
                            bhVarB = ((com.google.android.libraries.navigation.internal.ea.b) gVar).a;
                            z2 = ((com.google.android.libraries.navigation.internal.ea.b) gVar).f;
                            z3 = ((com.google.android.libraries.navigation.internal.ea.b) gVar).e;
                            ((com.google.android.libraries.navigation.internal.ea.b) gVar).g.isPresent();
                            optionalEmpty2 = ((com.google.android.libraries.navigation.internal.ea.b) gVar).h;
                        } else {
                            if (dVar2 != dVar3) {
                                z2 = true;
                                z3 = true;
                                z4 = false;
                            } else {
                                z2 = true;
                                z3 = true;
                            }
                            if (bhVarB.k()) {
                                evVarC = bhVarB.f().C();
                            } else {
                                int i = ev.d;
                                evVarC = lv.a;
                            }
                            optionalEmpty = Optional.empty();
                            if (gVar != null) {
                                eVar = ((com.google.android.libraries.navigation.internal.ea.b) gVar).c;
                                optionalEmpty = ((com.google.android.libraries.navigation.internal.ea.b) gVar).d;
                            } else {
                                this.x.isPresent();
                                if (jVar.i) {
                                    eVar = com.google.android.libraries.navigation.internal.bt.e.NONE;
                                } else {
                                    eVar = com.google.android.libraries.navigation.internal.bt.e.FIRST_DESTINATION;
                                }
                            }
                            bq bqVar = aVar.j;
                            dVar = dVarB;
                            dVarQ = com.google.android.libraries.navigation.internal.bt.h.Q();
                            dVarQ.o();
                            dVarQ.H();
                            dVarQ.A(z3);
                            dVarQ.v(bhVarB);
                            dVarQ.E(com.google.android.libraries.navigation.internal.bq.d.a);
                            dVarQ.k();
                            dVarQ.y(z15);
                            dVarQ.z(z2);
                            dVarQ.B(z4);
                            dVarQ.n(evVarC);
                            dVarQ.t(eVar);
                            dVarQ.s(an.h(optionalEmpty));
                            z5 = true;
                            dVarQ.r(true);
                            ((com.google.android.libraries.navigation.internal.bt.a) dVarQ).b = bqVar;
                            dVarQ.q(true);
                            dVarQ.l(this.y);
                            dVarQ.m(this.l);
                            dVarQ.w(true);
                            if (aVar.c() || aVar.g || this.a.t()) {
                                z6 = false;
                            } else {
                                z6 = true;
                            }
                            dVarQ.C(z6);
                            if (aVar.b() == al.DRIVE) {
                                z5 = false;
                            }
                            dVarQ.D(z5);
                            an anVarH = an.h(optionalEmpty2);
                            Objects.requireNonNull(anVarH);
                            ((com.google.android.libraries.navigation.internal.bt.a) dVarQ).h = anVarH;
                            ((com.google.android.libraries.navigation.internal.bt.a) dVarQ).i = an.j(aVar.c.a);
                            if (aVar.b() == al.WALK) {
                                dVarQ.G(false);
                            }
                            ap.UI_THREAD.f();
                            jVar2 = aVar.h;
                            if (jVar2 != null) {
                                if (jVar2.c() == null) {
                                    this.k.a();
                                    Instant.now();
                                } else if (jVar2.h) {
                                    ckVarU = jVar2.c().b.u();
                                    if (ckVarU.n() != null) {
                                        com.google.android.libraries.navigation.internal.s.b bVar = this.w;
                                        jVarM = ckVarU.m();
                                        com.google.android.libraries.navigation.internal.oe.x xVarZ = com.google.android.libraries.navigation.internal.oe.x.z(ckVarU.n());
                                        if (jVarM == null) {
                                            j = 0;
                                        } else {
                                            j = jVarM.c;
                                        }
                                        com.google.android.libraries.navigation.internal.ob.p pVarR = com.google.android.libraries.navigation.internal.ob.r.r();
                                        pVarR.i(xVarZ.t());
                                        pVarR.b(j);
                                        ((com.google.android.libraries.navigation.internal.r.m) bVar).e(pVarR.j());
                                    }
                                    aVar3 = this.C;
                                    if (aVar3 != null) {
                                        boolean z16 = ((hm) aVar3.a()).e;
                                    }
                                    if (aVar.o) {
                                        aVar.b();
                                    }
                                } else {
                                    this.k.c(dVarQ.I());
                                    Instant.now();
                                }
                            }
                        }
                        dVarQ = com.google.android.libraries.navigation.internal.bt.h.Q();
                        dVarQ.o();
                        dVarQ.H();
                        dVarQ.A(z3);
                        dVarQ.v(bhVarB);
                        dVarQ.E(com.google.android.libraries.navigation.internal.bq.d.a);
                        dVarQ.k();
                        dVarQ.y(z15);
                        dVarQ.z(z2);
                        dVarQ.B(z4);
                        dVarQ.n(evVarC);
                        dVarQ.t(eVar);
                        dVarQ.s(an.h(optionalEmpty));
                        z5 = true;
                        dVarQ.r(true);
                        ((com.google.android.libraries.navigation.internal.bt.a) dVarQ).b = bqVar;
                        dVarQ.q(true);
                        dVarQ.l(this.y);
                        dVarQ.m(this.l);
                        dVarQ.w(true);
                        if (aVar.c()) {
                            z6 = false;
                        } else {
                            z6 = false;
                        }
                        dVarQ.C(z6);
                        if (aVar.b() == al.DRIVE) {
                            z5 = false;
                        }
                        dVarQ.D(z5);
                        an anVarH2 = an.h(optionalEmpty2);
                        Objects.requireNonNull(anVarH2);
                        ((com.google.android.libraries.navigation.internal.bt.a) dVarQ).h = anVarH2;
                        ((com.google.android.libraries.navigation.internal.bt.a) dVarQ).i = an.j(aVar.c.a);
                        if (aVar.b() == al.WALK) {
                            dVarQ.G(false);
                        }
                        ap.UI_THREAD.f();
                        jVar2 = aVar.h;
                        if (jVar2 != null) {
                            if (jVar2.c() == null) {
                                this.k.a();
                                Instant.now();
                            } else if (jVar2.h) {
                                ckVarU = jVar2.c().b.u();
                                if (ckVarU.n() != null) {
                                    com.google.android.libraries.navigation.internal.s.b bVar2 = this.w;
                                    jVarM = ckVarU.m();
                                    com.google.android.libraries.navigation.internal.oe.x xVarZ2 = com.google.android.libraries.navigation.internal.oe.x.z(ckVarU.n());
                                    if (jVarM == null) {
                                        j = 0;
                                    } else {
                                        j = jVarM.c;
                                    }
                                    com.google.android.libraries.navigation.internal.ob.p pVarR2 = com.google.android.libraries.navigation.internal.ob.r.r();
                                    pVarR2.i(xVarZ2.t());
                                    pVarR2.b(j);
                                    ((com.google.android.libraries.navigation.internal.r.m) bVar2).e(pVarR2.j());
                                }
                                aVar3 = this.C;
                                if (aVar3 != null) {
                                    boolean z17 = ((hm) aVar3.a()).e;
                                }
                                if (aVar.o) {
                                    aVar.b();
                                }
                            } else {
                                this.k.c(dVarQ.I());
                                Instant.now();
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        th = th;
                        if (dVar != null) {
                            throw th;
                        }
                        Trace.endSection();
                        throw th;
                    }
                    z4 = true;
                    if (bhVarB.k()) {
                        evVarC = bhVarB.f().C();
                    } else {
                        int i2 = ev.d;
                        evVarC = lv.a;
                    }
                    optionalEmpty = Optional.empty();
                    if (gVar != null) {
                        eVar = ((com.google.android.libraries.navigation.internal.ea.b) gVar).c;
                        optionalEmpty = ((com.google.android.libraries.navigation.internal.ea.b) gVar).d;
                    } else {
                        this.x.isPresent();
                        if (jVar.i) {
                            eVar = com.google.android.libraries.navigation.internal.bt.e.NONE;
                        } else {
                            eVar = com.google.android.libraries.navigation.internal.bt.e.FIRST_DESTINATION;
                        }
                    }
                    bq bqVar2 = aVar.j;
                    dVar = dVarB;
                } else {
                    dVar = dVarB;
                }
                this.o = aVar;
                this.A = c(jVar4);
                if (aVar2 == null || z14) {
                    a();
                }
            } else {
                if (d(aVar) && this.B && !((com.google.android.libraries.navigation.internal.cv.c) this.b.a()).b(com.google.android.libraries.navigation.internal.cv.a.TRAFFIC)) {
                    if (this.H.a()) {
                        com.google.android.libraries.navigation.internal.cv.e.c(com.google.android.libraries.navigation.internal.cv.a.TRAFFIC);
                        com.google.android.libraries.navigation.internal.cv.e.c(com.google.android.libraries.navigation.internal.cv.a.TRAFFIC);
                    } else {
                        ((com.google.android.libraries.navigation.internal.cv.c) this.b.a()).d(com.google.android.libraries.navigation.internal.cv.a.TRAFFIC, this.B);
                    }
                }
                dVar = dVarB;
            }
            if (dVar != null) {
                Trace.endSection();
            }
        } catch (Throwable th5) {
            th = th5;
            dVar = dVarB;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.m, com.google.android.libraries.navigation.internal.uh.c
    public final void k() {
        f fVar = this.v;
        fVar.b.a.b(fVar, ac.INSTANCE);
        fVar.b.d(fVar, fVar.c);
        fVar.b.c.b(fVar, fVar.c);
        fVar.b.a(fVar, fVar.c);
        fVar.b.b(fVar, fVar.c);
        fVar.b.c(fVar);
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.sr.e.class, new g(0, com.google.android.libraries.navigation.internal.sr.e.class, fVar, ap.UI_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.si.f.class, new g(1, com.google.android.libraries.navigation.internal.si.f.class, fVar, ap.UI_THREAD));
        this.f.c(fVar, fzVar.a());
        if (!this.H.a()) {
            com.google.android.libraries.navigation.internal.iv.f fVar2 = this.g;
            com.google.android.libraries.navigation.internal.iv.p pVar = this.m;
            fVar2.d(pVar).e(this.z, this.D);
        }
        if (this.H.a()) {
            ((com.google.android.libraries.navigation.internal.cv.c) this.b.a()).c(this.F);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.m, com.google.android.libraries.navigation.internal.uh.c
    public final void l() {
        if (this.H.a()) {
            ((com.google.android.libraries.navigation.internal.cv.c) this.b.a()).c(this.G);
        }
        if (!this.H.a()) {
            com.google.android.libraries.navigation.internal.iv.f fVar = this.g;
            com.google.android.libraries.navigation.internal.iv.p pVar = this.m;
            fVar.d(pVar).h(this.z);
        }
        f fVar2 = this.v;
        com.google.android.libraries.navigation.internal.ia.e eVar = this.f;
        fVar2.b.a.e(fVar2);
        fVar2.b.n(fVar2);
        fVar2.b.c.e(fVar2);
        fVar2.b.k(fVar2);
        fVar2.b.l(fVar2);
        fVar2.b.m(fVar2);
        eVar.e(fVar2);
    }
}
