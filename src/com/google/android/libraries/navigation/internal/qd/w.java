package com.google.android.libraries.navigation.internal.qd;

import android.util.LongSparseArray;
import android.view.animation.AnimationUtils;
import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.internal.model.aq;
import com.google.android.libraries.geo.mapcore.internal.model.be;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.geo.mapcore.renderer.ax;
import com.google.android.libraries.geo.mapcore.renderer.cc;
import com.google.android.libraries.geo.mapcore.renderer.dg;
import com.google.android.libraries.geo.mapcore.renderer.dp;
import com.google.android.libraries.geo.mapcore.renderer.eh;
import com.google.android.libraries.geo.mapcore.renderer.ez;
import com.google.android.libraries.navigation.internal.adg.bu;
import com.google.android.libraries.navigation.internal.adg.hg;
import com.google.android.libraries.navigation.internal.adg.ho;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.agh.hf;
import com.google.android.libraries.navigation.internal.agh.hh;
import com.google.android.libraries.navigation.internal.agi.gs;
import com.google.android.libraries.navigation.internal.agi.gt;
import com.google.android.libraries.navigation.internal.agi.hc;
import com.google.android.libraries.navigation.internal.oe.ai;
import com.google.android.libraries.navigation.internal.oe.ap;
import com.google.android.libraries.navigation.internal.oe.at;
import com.google.android.libraries.navigation.internal.oe.bd;
import com.google.android.libraries.navigation.internal.ol.ac;
import com.google.android.libraries.navigation.internal.po.dv;
import com.google.android.libraries.navigation.internal.px.bk;
import com.google.android.libraries.navigation.internal.px.cq;
import com.google.android.libraries.navigation.internal.px.cr;
import com.google.android.libraries.navigation.internal.px.er;
import com.google.android.libraries.navigation.internal.yr.aw;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.eg;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.ku;
import com.google.android.libraries.navigation.internal.yz.nn;
import com.google.android.libraries.navigation.internal.yz.no;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class w extends d implements com.google.android.libraries.navigation.internal.qg.h, ac, er, n {
    public final ax A;
    public final p B;
    public final ScheduledExecutorService C;
    protected final com.google.android.libraries.navigation.internal.qf.d D;
    public final com.google.android.libraries.navigation.internal.qv.k E;
    public final com.google.android.libraries.navigation.internal.kl.b F;
    protected final at G;
    protected final com.google.android.libraries.navigation.internal.pb.t H;
    public boolean I;
    protected final boolean J;
    protected final com.google.android.libraries.navigation.internal.afo.a K;
    protected final boolean L;
    public volatile dv M;
    protected final com.google.android.libraries.navigation.internal.qs.a N;
    private final an O;
    private final boolean R;
    private int S;
    private boolean T;
    private final AtomicBoolean U;
    private int V;
    private final com.google.android.libraries.navigation.internal.oe.x W;
    private final float[] X;
    private com.google.android.libraries.navigation.internal.pd.d Y;
    private boolean Z;
    private final boolean a;
    private volatile boolean aa;
    private boolean ab;
    private volatile boolean ac;
    private final boolean ad;
    private final com.google.android.libraries.navigation.internal.nt.p ae;
    private List af;
    private final Set ag;
    private volatile bk ah;
    private final p ai;
    private final be aj;
    private volatile boolean ak;
    private boolean al;
    private final com.google.android.libraries.navigation.internal.agl.a am;
    private List an;
    private List ao;
    private final u ap;
    final int b;
    public final com.google.android.libraries.navigation.internal.adi.an c;
    public final ap d;
    public final cg e;
    protected final com.google.android.libraries.navigation.internal.rc.f f;
    public final com.google.android.libraries.navigation.internal.qg.j g;
    protected final int i;
    protected boolean j;
    protected final com.google.android.libraries.navigation.internal.mj.a k;
    public long l;
    public long m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.google.android.libraries.navigation.internal.pg.f f548n;
    public volatile boolean o;
    public volatile boolean p;
    public long q;
    protected final boolean r;
    public volatile boolean s;
    public volatile boolean t;
    public volatile boolean u;
    protected final com.google.android.libraries.navigation.internal.pg.h v;
    public boolean w;
    final v x;
    public final List y;
    protected final k z;
    public final List h = new ArrayList();
    private final Set P = new gt();
    private final List Q = new ArrayList();

    protected w(ax axVar, com.google.android.libraries.navigation.internal.pb.t tVar, ap apVar, cg cgVar, com.google.android.libraries.navigation.internal.qv.k kVar, com.google.android.libraries.navigation.internal.qg.j jVar, k kVar2, com.google.android.libraries.navigation.internal.qf.d dVar, com.google.android.libraries.navigation.internal.mj.a aVar, ScheduledExecutorService scheduledExecutorService, com.google.android.libraries.navigation.internal.rc.f fVar, com.google.android.libraries.navigation.internal.pg.h hVar, be beVar, com.google.android.libraries.navigation.internal.kl.b bVar, int i, boolean z, int i2, boolean z2, boolean z3, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.qs.a aVar3, at atVar, boolean z4, com.google.android.libraries.navigation.internal.afo.a aVar4, boolean z5, boolean z6, boolean z7, an anVar) {
        com.google.android.libraries.navigation.internal.zy.g gVar = com.google.android.libraries.navigation.internal.zy.g.a;
        hf hfVar = hh.a;
        new AtomicBoolean(false);
        this.T = false;
        this.U = new AtomicBoolean(false);
        this.V = 0;
        this.W = new com.google.android.libraries.navigation.internal.oe.x();
        this.X = new float[3];
        this.q = 0L;
        this.Z = false;
        this.s = false;
        this.t = false;
        this.aa = false;
        this.u = false;
        this.ab = false;
        this.w = true;
        this.ac = false;
        this.y = new ArrayList();
        this.ae = new com.google.android.libraries.navigation.internal.nt.p(false);
        this.ag = new HashSet();
        this.I = false;
        this.an = new ArrayList();
        this.ao = new ArrayList();
        ar.q(axVar);
        this.A = axVar;
        this.H = tVar;
        this.d = apVar;
        this.c = apVar.c;
        this.e = cgVar;
        this.E = kVar;
        this.g = jVar;
        this.z = kVar2;
        this.D = dVar;
        this.k = aVar;
        this.C = scheduledExecutorService;
        this.f = fVar;
        this.v = hVar;
        this.aj = beVar;
        this.F = bVar;
        this.i = i;
        this.R = z;
        this.b = i2;
        this.a = z2;
        this.r = z3;
        this.am = aVar2;
        this.N = aVar3;
        this.G = atVar;
        this.x = new v(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qd.s
            @Override // java.lang.Runnable
            public final void run() {
                this.a.I();
            }
        });
        this.J = z4;
        this.K = aVar4;
        this.L = false;
        this.j = z6;
        this.ad = z7;
        this.O = anVar;
        this.S = 0;
        this.l = aVar.a();
        this.m = aVar.a();
        aq aqVarF = jVar.f();
        this.B = new p(aqVarF);
        this.ai = new p(aqVarF);
        u uVar = new u(this, jVar);
        this.ap = uVar;
        ar.k(jVar.i == null);
        jVar.i = this;
        kVar.k(uVar);
    }

    private static void L(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((com.google.android.libraries.navigation.internal.qi.e) list.get(i)).s();
        }
        list.clear();
    }

    private static void M(List list, List list2) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((com.google.android.libraries.navigation.internal.qi.e) list.get(i)).p();
        }
        list2.addAll(list);
    }

    private final void N(com.google.android.libraries.navigation.internal.qi.e eVar, Set set) {
        if (set.add(eVar)) {
            this.V++;
            eVar.p();
            if (this.h.contains(eVar)) {
                return;
            }
            eVar.t(this.I);
        }
    }

    private final synchronized void O() {
        if (this.s && this.j) {
            this.j = false;
            this.o = true;
            this.A.o();
        }
    }

    private final void P() {
        bk bkVar = this.ah;
        if (bkVar != null) {
            bkVar.l(this);
        }
    }

    private final void Q(boolean z) {
        this.s = z;
        this.ae.c(Boolean.valueOf(K()));
    }

    private final synchronized void R(com.google.android.libraries.navigation.internal.pb.t tVar, com.google.android.libraries.navigation.internal.pd.j jVar) {
        this.Z = true;
        com.google.android.libraries.navigation.internal.pb.t tVar2 = new com.google.android.libraries.navigation.internal.pb.t(jVar.a, tVar.s(), tVar.r(), tVar.n());
        ArrayList arrayList = new ArrayList();
        com.google.android.libraries.navigation.internal.pg.f fVar = this.f548n;
        if (fVar != null) {
            fVar.a(tVar2, arrayList);
        }
        if (this.w && this.f548n != null) {
            int i = (!this.ab || this.j) ? 0 : 8;
            com.google.android.libraries.navigation.internal.qg.j jVar2 = this.g;
            com.google.android.libraries.navigation.internal.oe.x xVarT = tVar2.t();
            bd bdVar = tVar2.v().d;
            com.google.android.libraries.navigation.internal.adf.i iVar = (com.google.android.libraries.navigation.internal.adf.i) com.google.android.libraries.navigation.internal.adf.j.a.q();
            int i2 = com.google.android.libraries.navigation.internal.adf.l.e;
            if (!iVar.b.H()) {
                iVar.v();
            }
            com.google.android.libraries.navigation.internal.adf.j jVar3 = (com.google.android.libraries.navigation.internal.adf.j) iVar.b;
            int i3 = i2 - 1;
            if (i2 == 0) {
                throw null;
            }
            jVar3.c = i3;
            jVar3.b = 1 | jVar3.b;
            jVar2.w(xVarT, arrayList, null, bdVar, i, true, false, (com.google.android.libraries.navigation.internal.adf.j) iVar.t());
        }
        this.af = arrayList;
        this.Y = jVar.a;
    }

    private final synchronized void S(com.google.android.libraries.navigation.internal.pb.t tVar, boolean z) {
        this.ag.clear();
        s(this.ag);
        if (this.w && this.f548n != null) {
            int i = 0;
            if (this.ab && !this.j) {
                i = true != z ? 8 : 4;
            }
            int i2 = i;
            com.google.android.libraries.navigation.internal.qg.j jVar = this.g;
            com.google.android.libraries.navigation.internal.oe.x xVarT = tVar.t();
            List list = this.y;
            Set set = this.ag;
            ai aiVar = tVar.v().d.a;
            jVar.w(xVarT, list, set, new bd(new ai(com.google.android.libraries.navigation.internal.oe.x.v(aiVar.a), com.google.android.libraries.navigation.internal.oe.x.v(aiVar.b))), i2, false, false, com.google.android.libraries.navigation.internal.rb.b.a());
            if (this.c == com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE && this.T && !this.U.get()) {
                this.z.g();
            }
        }
    }

    private final synchronized boolean T(com.google.android.libraries.navigation.internal.pb.t tVar, Set set) {
        boolean z;
        boolean zQ;
        ar.k(set.isEmpty());
        tVar.A(this.W);
        ax axVar = this.A;
        long jA = this.k.a();
        axVar.p(this.D.d);
        com.google.android.libraries.navigation.internal.oe.x xVar = this.W;
        List list = this.af;
        boolean z2 = true;
        if (list == null || list.isEmpty() || this.y.isEmpty() || ((cd) this.y.get(0)).a < ((cd) list.get(0)).a - 2) {
            z = false;
        } else {
            q(list, 0, xVar, jA, set);
            Q(this.S == list.size());
            z = true;
        }
        zQ = q(this.y, this.i, xVar, jA, set);
        if (!z) {
            if (this.S != this.y.size()) {
                z2 = false;
            }
            Q(z2);
        }
        return zQ;
    }

    private final synchronized boolean U(com.google.android.libraries.navigation.internal.pb.t tVar, int i, int i2) {
        tVar.c(this.X);
        float[] fArr = this.X;
        float f = fArr[0];
        float f2 = fArr[1];
        return ((double) (((f * f) / ((float) (i * i))) + ((f2 * f2) / ((float) (i2 * i2))))) < 9.0d && ((double) Math.abs(fArr[2])) < 4.0d;
    }

    private static void r(Collection collection) {
        gs gsVar = new gs((gt) collection);
        while (gsVar.hasNext()) {
            ((com.google.android.libraries.navigation.internal.qi.e) gsVar.next()).s();
        }
        collection.clear();
    }

    public final synchronized void A() {
        this.ab = true;
        this.o = true;
    }

    public final synchronized void B() {
        com.google.android.libraries.navigation.internal.qv.k kVar = this.E;
        if ((kVar instanceof com.google.android.libraries.navigation.internal.qu.aa) && ((com.google.android.libraries.navigation.internal.qu.aa) kVar).w()) {
            v();
        }
        this.u = this.G.p(this.c);
    }

    @Override // com.google.android.libraries.navigation.internal.qg.h
    public final void C() {
        if (this.p) {
            return;
        }
        this.p = true;
        this.C.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qd.q
            @Override // java.lang.Runnable
            public final void run() {
                w wVar = this.a;
                wVar.o = true;
                wVar.p = false;
                wVar.A.o();
            }
        }, 500L, TimeUnit.MILLISECONDS);
    }

    public final void D(boolean z) {
        this.g.j = z;
        if (z) {
            z();
        }
    }

    protected synchronized void E(com.google.android.libraries.navigation.internal.pb.t tVar, Set set) {
        boolean z;
        com.google.android.libraries.navigation.internal.yt.a aVarB = com.google.android.libraries.navigation.internal.yt.d.b("TileOverlay.updateCamera() - overlay ", com.google.android.libraries.navigation.internal.xn.a.e(this.c));
        try {
            ar.k(set.isEmpty());
            ar.q(this.f548n);
            this.t = true;
            long jA = this.f548n.a(tVar, this.y);
            boolean z2 = (this.q == jA || this.y.isEmpty()) ? false : true;
            if (this.c == com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE) {
                this.z.q(jA);
            }
            boolean zU = this.g.u();
            if (tVar.f()) {
                com.google.android.libraries.navigation.internal.pd.j jVar = tVar.d;
                boolean z3 = jVar != null;
                if (this.Z && !z3) {
                    this.Z = false;
                    this.af = null;
                }
                if (!zU) {
                    z = false;
                } else if (z3) {
                    R(tVar, jVar);
                } else {
                    z = true;
                }
                if (z3 && !jVar.a.equals(this.Y) && jVar.b - AnimationUtils.currentAnimationTimeMillis() >= 1000) {
                    R(tVar, jVar);
                } else if ((z || this.o) && !z3) {
                    S(tVar, true);
                    this.q = jA;
                } else if (!this.Z && z2 && U(tVar, tVar.s(), tVar.r())) {
                    S(tVar, true);
                    this.q = jA;
                }
            } else {
                if (z2 || this.o || zU) {
                    S(tVar, false);
                    this.q = jA;
                }
                this.Z = false;
                this.af = null;
            }
            this.o = false;
            this.aa = T(tVar, set);
            O();
            aVarB.close();
        } catch (Throwable th) {
            try {
                aVarB.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public final synchronized void F(com.google.android.libraries.navigation.internal.ol.w wVar) {
        if (this.g.x(wVar)) {
            z();
        }
    }

    public final void G() {
        this.B.a();
        J();
    }

    public final void H(aq aqVar) {
        this.B.b(aqVar);
        J();
    }

    /* JADX WARN: Code duplicated, block: B:238:0x03f9 A[Catch: all -> 0x0512, LOOP:9: B:236:0x03f3->B:238:0x03f9, LOOP_END, TryCatch #10 {all -> 0x0512, blocks: (B:6:0x0014, B:8:0x001d, B:9:0x0022, B:12:0x0032, B:14:0x0042, B:16:0x004b, B:18:0x004f, B:20:0x0055, B:21:0x0058, B:22:0x0061, B:25:0x006b, B:113:0x0202, B:114:0x0205, B:117:0x020b, B:120:0x0219, B:121:0x021d, B:123:0x0223, B:125:0x022d, B:127:0x0237, B:129:0x023d, B:130:0x0244, B:131:0x0246, B:143:0x0286, B:144:0x0287, B:146:0x0291, B:147:0x02a3, B:171:0x0303, B:175:0x030c, B:176:0x030d, B:177:0x0311, B:179:0x0317, B:181:0x0321, B:213:0x0395, B:215:0x039f, B:216:0x03a1, B:231:0x03e7, B:184:0x032c, B:185:0x0333, B:212:0x0392, B:234:0x03ea, B:235:0x03eb, B:236:0x03f3, B:238:0x03f9, B:240:0x0415, B:242:0x0422, B:244:0x0428, B:245:0x0430, B:247:0x0434, B:248:0x0437, B:250:0x043b, B:254:0x0442, B:255:0x0444, B:259:0x0454, B:260:0x0456, B:262:0x0458, B:264:0x045c, B:265:0x0465, B:267:0x046a, B:269:0x0479, B:273:0x048b, B:274:0x048c, B:276:0x049f, B:277:0x04a4, B:279:0x04ac, B:281:0x04bc, B:283:0x04c3, B:285:0x04cc, B:286:0x04dd, B:289:0x04e4, B:293:0x04f5, B:282:0x04bf, B:300:0x0500, B:309:0x050e, B:308:0x050b, B:312:0x0511, B:26:0x007b, B:27:0x0085, B:29:0x008b, B:31:0x0097, B:33:0x00a5, B:35:0x00bb, B:37:0x00c8, B:41:0x00d6, B:43:0x00dc, B:44:0x00e5, B:46:0x00ee, B:48:0x00f2, B:51:0x00f9, B:53:0x00fd, B:55:0x0105, B:57:0x010e, B:59:0x0116, B:60:0x011d, B:62:0x0125, B:63:0x012c, B:68:0x0138, B:69:0x0140, B:70:0x0147, B:72:0x0150, B:74:0x015b, B:76:0x0161, B:78:0x0167, B:79:0x016e, B:82:0x0174, B:87:0x0182, B:90:0x0187, B:92:0x0197, B:94:0x01a3, B:108:0x01d9, B:98:0x01af, B:100:0x01b3, B:102:0x01ba, B:105:0x01c4, B:107:0x01d2, B:110:0x01e4, B:73:0x0153, B:111:0x01f9, B:132:0x0247, B:133:0x024f, B:135:0x0255, B:137:0x0269, B:138:0x0279, B:139:0x0282, B:217:0x03a2, B:218:0x03ae, B:220:0x03b4, B:222:0x03c8, B:224:0x03d2, B:226:0x03d8, B:227:0x03e2, B:186:0x0334, B:187:0x0338, B:189:0x033e, B:191:0x0348, B:192:0x034a, B:194:0x0350, B:196:0x0356, B:197:0x0358, B:199:0x0362, B:201:0x036e, B:203:0x0372, B:204:0x0374, B:205:0x037d, B:207:0x0383, B:209:0x0389, B:210:0x038b, B:211:0x0391, B:304:0x0505, B:261:0x0457, B:148:0x02a4, B:149:0x02a8, B:151:0x02ae, B:153:0x02b8, B:154:0x02ba, B:156:0x02c0, B:158:0x02c6, B:160:0x02ca, B:161:0x02cc, B:163:0x02da, B:165:0x02e8, B:167:0x02f4, B:170:0x0302, B:23:0x0062, B:24:0x006a, B:287:0x04de, B:288:0x04e3, B:256:0x0445, B:257:0x0451), top: B:351:0x0014, outer: #14, inners: #0, #2, #3, #4, #5, #6, #7, #9, #11, #13 }] */
    /* JADX WARN: Code duplicated, block: B:240:0x0415 A[Catch: all -> 0x0512, TryCatch #10 {all -> 0x0512, blocks: (B:6:0x0014, B:8:0x001d, B:9:0x0022, B:12:0x0032, B:14:0x0042, B:16:0x004b, B:18:0x004f, B:20:0x0055, B:21:0x0058, B:22:0x0061, B:25:0x006b, B:113:0x0202, B:114:0x0205, B:117:0x020b, B:120:0x0219, B:121:0x021d, B:123:0x0223, B:125:0x022d, B:127:0x0237, B:129:0x023d, B:130:0x0244, B:131:0x0246, B:143:0x0286, B:144:0x0287, B:146:0x0291, B:147:0x02a3, B:171:0x0303, B:175:0x030c, B:176:0x030d, B:177:0x0311, B:179:0x0317, B:181:0x0321, B:213:0x0395, B:215:0x039f, B:216:0x03a1, B:231:0x03e7, B:184:0x032c, B:185:0x0333, B:212:0x0392, B:234:0x03ea, B:235:0x03eb, B:236:0x03f3, B:238:0x03f9, B:240:0x0415, B:242:0x0422, B:244:0x0428, B:245:0x0430, B:247:0x0434, B:248:0x0437, B:250:0x043b, B:254:0x0442, B:255:0x0444, B:259:0x0454, B:260:0x0456, B:262:0x0458, B:264:0x045c, B:265:0x0465, B:267:0x046a, B:269:0x0479, B:273:0x048b, B:274:0x048c, B:276:0x049f, B:277:0x04a4, B:279:0x04ac, B:281:0x04bc, B:283:0x04c3, B:285:0x04cc, B:286:0x04dd, B:289:0x04e4, B:293:0x04f5, B:282:0x04bf, B:300:0x0500, B:309:0x050e, B:308:0x050b, B:312:0x0511, B:26:0x007b, B:27:0x0085, B:29:0x008b, B:31:0x0097, B:33:0x00a5, B:35:0x00bb, B:37:0x00c8, B:41:0x00d6, B:43:0x00dc, B:44:0x00e5, B:46:0x00ee, B:48:0x00f2, B:51:0x00f9, B:53:0x00fd, B:55:0x0105, B:57:0x010e, B:59:0x0116, B:60:0x011d, B:62:0x0125, B:63:0x012c, B:68:0x0138, B:69:0x0140, B:70:0x0147, B:72:0x0150, B:74:0x015b, B:76:0x0161, B:78:0x0167, B:79:0x016e, B:82:0x0174, B:87:0x0182, B:90:0x0187, B:92:0x0197, B:94:0x01a3, B:108:0x01d9, B:98:0x01af, B:100:0x01b3, B:102:0x01ba, B:105:0x01c4, B:107:0x01d2, B:110:0x01e4, B:73:0x0153, B:111:0x01f9, B:132:0x0247, B:133:0x024f, B:135:0x0255, B:137:0x0269, B:138:0x0279, B:139:0x0282, B:217:0x03a2, B:218:0x03ae, B:220:0x03b4, B:222:0x03c8, B:224:0x03d2, B:226:0x03d8, B:227:0x03e2, B:186:0x0334, B:187:0x0338, B:189:0x033e, B:191:0x0348, B:192:0x034a, B:194:0x0350, B:196:0x0356, B:197:0x0358, B:199:0x0362, B:201:0x036e, B:203:0x0372, B:204:0x0374, B:205:0x037d, B:207:0x0383, B:209:0x0389, B:210:0x038b, B:211:0x0391, B:304:0x0505, B:261:0x0457, B:148:0x02a4, B:149:0x02a8, B:151:0x02ae, B:153:0x02b8, B:154:0x02ba, B:156:0x02c0, B:158:0x02c6, B:160:0x02ca, B:161:0x02cc, B:163:0x02da, B:165:0x02e8, B:167:0x02f4, B:170:0x0302, B:23:0x0062, B:24:0x006a, B:287:0x04de, B:288:0x04e3, B:256:0x0445, B:257:0x0451), top: B:351:0x0014, outer: #14, inners: #0, #2, #3, #4, #5, #6, #7, #9, #11, #13 }] */
    /* JADX WARN: Code duplicated, block: B:242:0x0422 A[Catch: all -> 0x0512, TryCatch #10 {all -> 0x0512, blocks: (B:6:0x0014, B:8:0x001d, B:9:0x0022, B:12:0x0032, B:14:0x0042, B:16:0x004b, B:18:0x004f, B:20:0x0055, B:21:0x0058, B:22:0x0061, B:25:0x006b, B:113:0x0202, B:114:0x0205, B:117:0x020b, B:120:0x0219, B:121:0x021d, B:123:0x0223, B:125:0x022d, B:127:0x0237, B:129:0x023d, B:130:0x0244, B:131:0x0246, B:143:0x0286, B:144:0x0287, B:146:0x0291, B:147:0x02a3, B:171:0x0303, B:175:0x030c, B:176:0x030d, B:177:0x0311, B:179:0x0317, B:181:0x0321, B:213:0x0395, B:215:0x039f, B:216:0x03a1, B:231:0x03e7, B:184:0x032c, B:185:0x0333, B:212:0x0392, B:234:0x03ea, B:235:0x03eb, B:236:0x03f3, B:238:0x03f9, B:240:0x0415, B:242:0x0422, B:244:0x0428, B:245:0x0430, B:247:0x0434, B:248:0x0437, B:250:0x043b, B:254:0x0442, B:255:0x0444, B:259:0x0454, B:260:0x0456, B:262:0x0458, B:264:0x045c, B:265:0x0465, B:267:0x046a, B:269:0x0479, B:273:0x048b, B:274:0x048c, B:276:0x049f, B:277:0x04a4, B:279:0x04ac, B:281:0x04bc, B:283:0x04c3, B:285:0x04cc, B:286:0x04dd, B:289:0x04e4, B:293:0x04f5, B:282:0x04bf, B:300:0x0500, B:309:0x050e, B:308:0x050b, B:312:0x0511, B:26:0x007b, B:27:0x0085, B:29:0x008b, B:31:0x0097, B:33:0x00a5, B:35:0x00bb, B:37:0x00c8, B:41:0x00d6, B:43:0x00dc, B:44:0x00e5, B:46:0x00ee, B:48:0x00f2, B:51:0x00f9, B:53:0x00fd, B:55:0x0105, B:57:0x010e, B:59:0x0116, B:60:0x011d, B:62:0x0125, B:63:0x012c, B:68:0x0138, B:69:0x0140, B:70:0x0147, B:72:0x0150, B:74:0x015b, B:76:0x0161, B:78:0x0167, B:79:0x016e, B:82:0x0174, B:87:0x0182, B:90:0x0187, B:92:0x0197, B:94:0x01a3, B:108:0x01d9, B:98:0x01af, B:100:0x01b3, B:102:0x01ba, B:105:0x01c4, B:107:0x01d2, B:110:0x01e4, B:73:0x0153, B:111:0x01f9, B:132:0x0247, B:133:0x024f, B:135:0x0255, B:137:0x0269, B:138:0x0279, B:139:0x0282, B:217:0x03a2, B:218:0x03ae, B:220:0x03b4, B:222:0x03c8, B:224:0x03d2, B:226:0x03d8, B:227:0x03e2, B:186:0x0334, B:187:0x0338, B:189:0x033e, B:191:0x0348, B:192:0x034a, B:194:0x0350, B:196:0x0356, B:197:0x0358, B:199:0x0362, B:201:0x036e, B:203:0x0372, B:204:0x0374, B:205:0x037d, B:207:0x0383, B:209:0x0389, B:210:0x038b, B:211:0x0391, B:304:0x0505, B:261:0x0457, B:148:0x02a4, B:149:0x02a8, B:151:0x02ae, B:153:0x02b8, B:154:0x02ba, B:156:0x02c0, B:158:0x02c6, B:160:0x02ca, B:161:0x02cc, B:163:0x02da, B:165:0x02e8, B:167:0x02f4, B:170:0x0302, B:23:0x0062, B:24:0x006a, B:287:0x04de, B:288:0x04e3, B:256:0x0445, B:257:0x0451), top: B:351:0x0014, outer: #14, inners: #0, #2, #3, #4, #5, #6, #7, #9, #11, #13 }] */
    /* JADX WARN: Code duplicated, block: B:244:0x0428 A[Catch: all -> 0x0512, LOOP:10: B:243:0x0426->B:244:0x0428, LOOP_END, TryCatch #10 {all -> 0x0512, blocks: (B:6:0x0014, B:8:0x001d, B:9:0x0022, B:12:0x0032, B:14:0x0042, B:16:0x004b, B:18:0x004f, B:20:0x0055, B:21:0x0058, B:22:0x0061, B:25:0x006b, B:113:0x0202, B:114:0x0205, B:117:0x020b, B:120:0x0219, B:121:0x021d, B:123:0x0223, B:125:0x022d, B:127:0x0237, B:129:0x023d, B:130:0x0244, B:131:0x0246, B:143:0x0286, B:144:0x0287, B:146:0x0291, B:147:0x02a3, B:171:0x0303, B:175:0x030c, B:176:0x030d, B:177:0x0311, B:179:0x0317, B:181:0x0321, B:213:0x0395, B:215:0x039f, B:216:0x03a1, B:231:0x03e7, B:184:0x032c, B:185:0x0333, B:212:0x0392, B:234:0x03ea, B:235:0x03eb, B:236:0x03f3, B:238:0x03f9, B:240:0x0415, B:242:0x0422, B:244:0x0428, B:245:0x0430, B:247:0x0434, B:248:0x0437, B:250:0x043b, B:254:0x0442, B:255:0x0444, B:259:0x0454, B:260:0x0456, B:262:0x0458, B:264:0x045c, B:265:0x0465, B:267:0x046a, B:269:0x0479, B:273:0x048b, B:274:0x048c, B:276:0x049f, B:277:0x04a4, B:279:0x04ac, B:281:0x04bc, B:283:0x04c3, B:285:0x04cc, B:286:0x04dd, B:289:0x04e4, B:293:0x04f5, B:282:0x04bf, B:300:0x0500, B:309:0x050e, B:308:0x050b, B:312:0x0511, B:26:0x007b, B:27:0x0085, B:29:0x008b, B:31:0x0097, B:33:0x00a5, B:35:0x00bb, B:37:0x00c8, B:41:0x00d6, B:43:0x00dc, B:44:0x00e5, B:46:0x00ee, B:48:0x00f2, B:51:0x00f9, B:53:0x00fd, B:55:0x0105, B:57:0x010e, B:59:0x0116, B:60:0x011d, B:62:0x0125, B:63:0x012c, B:68:0x0138, B:69:0x0140, B:70:0x0147, B:72:0x0150, B:74:0x015b, B:76:0x0161, B:78:0x0167, B:79:0x016e, B:82:0x0174, B:87:0x0182, B:90:0x0187, B:92:0x0197, B:94:0x01a3, B:108:0x01d9, B:98:0x01af, B:100:0x01b3, B:102:0x01ba, B:105:0x01c4, B:107:0x01d2, B:110:0x01e4, B:73:0x0153, B:111:0x01f9, B:132:0x0247, B:133:0x024f, B:135:0x0255, B:137:0x0269, B:138:0x0279, B:139:0x0282, B:217:0x03a2, B:218:0x03ae, B:220:0x03b4, B:222:0x03c8, B:224:0x03d2, B:226:0x03d8, B:227:0x03e2, B:186:0x0334, B:187:0x0338, B:189:0x033e, B:191:0x0348, B:192:0x034a, B:194:0x0350, B:196:0x0356, B:197:0x0358, B:199:0x0362, B:201:0x036e, B:203:0x0372, B:204:0x0374, B:205:0x037d, B:207:0x0383, B:209:0x0389, B:210:0x038b, B:211:0x0391, B:304:0x0505, B:261:0x0457, B:148:0x02a4, B:149:0x02a8, B:151:0x02ae, B:153:0x02b8, B:154:0x02ba, B:156:0x02c0, B:158:0x02c6, B:160:0x02ca, B:161:0x02cc, B:163:0x02da, B:165:0x02e8, B:167:0x02f4, B:170:0x0302, B:23:0x0062, B:24:0x006a, B:287:0x04de, B:288:0x04e3, B:256:0x0445, B:257:0x0451), top: B:351:0x0014, outer: #14, inners: #0, #2, #3, #4, #5, #6, #7, #9, #11, #13 }] */
    /* JADX WARN: Code duplicated, block: B:247:0x0434 A[Catch: all -> 0x0512, TryCatch #10 {all -> 0x0512, blocks: (B:6:0x0014, B:8:0x001d, B:9:0x0022, B:12:0x0032, B:14:0x0042, B:16:0x004b, B:18:0x004f, B:20:0x0055, B:21:0x0058, B:22:0x0061, B:25:0x006b, B:113:0x0202, B:114:0x0205, B:117:0x020b, B:120:0x0219, B:121:0x021d, B:123:0x0223, B:125:0x022d, B:127:0x0237, B:129:0x023d, B:130:0x0244, B:131:0x0246, B:143:0x0286, B:144:0x0287, B:146:0x0291, B:147:0x02a3, B:171:0x0303, B:175:0x030c, B:176:0x030d, B:177:0x0311, B:179:0x0317, B:181:0x0321, B:213:0x0395, B:215:0x039f, B:216:0x03a1, B:231:0x03e7, B:184:0x032c, B:185:0x0333, B:212:0x0392, B:234:0x03ea, B:235:0x03eb, B:236:0x03f3, B:238:0x03f9, B:240:0x0415, B:242:0x0422, B:244:0x0428, B:245:0x0430, B:247:0x0434, B:248:0x0437, B:250:0x043b, B:254:0x0442, B:255:0x0444, B:259:0x0454, B:260:0x0456, B:262:0x0458, B:264:0x045c, B:265:0x0465, B:267:0x046a, B:269:0x0479, B:273:0x048b, B:274:0x048c, B:276:0x049f, B:277:0x04a4, B:279:0x04ac, B:281:0x04bc, B:283:0x04c3, B:285:0x04cc, B:286:0x04dd, B:289:0x04e4, B:293:0x04f5, B:282:0x04bf, B:300:0x0500, B:309:0x050e, B:308:0x050b, B:312:0x0511, B:26:0x007b, B:27:0x0085, B:29:0x008b, B:31:0x0097, B:33:0x00a5, B:35:0x00bb, B:37:0x00c8, B:41:0x00d6, B:43:0x00dc, B:44:0x00e5, B:46:0x00ee, B:48:0x00f2, B:51:0x00f9, B:53:0x00fd, B:55:0x0105, B:57:0x010e, B:59:0x0116, B:60:0x011d, B:62:0x0125, B:63:0x012c, B:68:0x0138, B:69:0x0140, B:70:0x0147, B:72:0x0150, B:74:0x015b, B:76:0x0161, B:78:0x0167, B:79:0x016e, B:82:0x0174, B:87:0x0182, B:90:0x0187, B:92:0x0197, B:94:0x01a3, B:108:0x01d9, B:98:0x01af, B:100:0x01b3, B:102:0x01ba, B:105:0x01c4, B:107:0x01d2, B:110:0x01e4, B:73:0x0153, B:111:0x01f9, B:132:0x0247, B:133:0x024f, B:135:0x0255, B:137:0x0269, B:138:0x0279, B:139:0x0282, B:217:0x03a2, B:218:0x03ae, B:220:0x03b4, B:222:0x03c8, B:224:0x03d2, B:226:0x03d8, B:227:0x03e2, B:186:0x0334, B:187:0x0338, B:189:0x033e, B:191:0x0348, B:192:0x034a, B:194:0x0350, B:196:0x0356, B:197:0x0358, B:199:0x0362, B:201:0x036e, B:203:0x0372, B:204:0x0374, B:205:0x037d, B:207:0x0383, B:209:0x0389, B:210:0x038b, B:211:0x0391, B:304:0x0505, B:261:0x0457, B:148:0x02a4, B:149:0x02a8, B:151:0x02ae, B:153:0x02b8, B:154:0x02ba, B:156:0x02c0, B:158:0x02c6, B:160:0x02ca, B:161:0x02cc, B:163:0x02da, B:165:0x02e8, B:167:0x02f4, B:170:0x0302, B:23:0x0062, B:24:0x006a, B:287:0x04de, B:288:0x04e3, B:256:0x0445, B:257:0x0451), top: B:351:0x0014, outer: #14, inners: #0, #2, #3, #4, #5, #6, #7, #9, #11, #13 }] */
    /* JADX WARN: Code duplicated, block: B:253:0x0441  */
    /* JADX WARN: Code duplicated, block: B:259:0x0454 A[Catch: all -> 0x0512, TRY_ENTER, TryCatch #10 {all -> 0x0512, blocks: (B:6:0x0014, B:8:0x001d, B:9:0x0022, B:12:0x0032, B:14:0x0042, B:16:0x004b, B:18:0x004f, B:20:0x0055, B:21:0x0058, B:22:0x0061, B:25:0x006b, B:113:0x0202, B:114:0x0205, B:117:0x020b, B:120:0x0219, B:121:0x021d, B:123:0x0223, B:125:0x022d, B:127:0x0237, B:129:0x023d, B:130:0x0244, B:131:0x0246, B:143:0x0286, B:144:0x0287, B:146:0x0291, B:147:0x02a3, B:171:0x0303, B:175:0x030c, B:176:0x030d, B:177:0x0311, B:179:0x0317, B:181:0x0321, B:213:0x0395, B:215:0x039f, B:216:0x03a1, B:231:0x03e7, B:184:0x032c, B:185:0x0333, B:212:0x0392, B:234:0x03ea, B:235:0x03eb, B:236:0x03f3, B:238:0x03f9, B:240:0x0415, B:242:0x0422, B:244:0x0428, B:245:0x0430, B:247:0x0434, B:248:0x0437, B:250:0x043b, B:254:0x0442, B:255:0x0444, B:259:0x0454, B:260:0x0456, B:262:0x0458, B:264:0x045c, B:265:0x0465, B:267:0x046a, B:269:0x0479, B:273:0x048b, B:274:0x048c, B:276:0x049f, B:277:0x04a4, B:279:0x04ac, B:281:0x04bc, B:283:0x04c3, B:285:0x04cc, B:286:0x04dd, B:289:0x04e4, B:293:0x04f5, B:282:0x04bf, B:300:0x0500, B:309:0x050e, B:308:0x050b, B:312:0x0511, B:26:0x007b, B:27:0x0085, B:29:0x008b, B:31:0x0097, B:33:0x00a5, B:35:0x00bb, B:37:0x00c8, B:41:0x00d6, B:43:0x00dc, B:44:0x00e5, B:46:0x00ee, B:48:0x00f2, B:51:0x00f9, B:53:0x00fd, B:55:0x0105, B:57:0x010e, B:59:0x0116, B:60:0x011d, B:62:0x0125, B:63:0x012c, B:68:0x0138, B:69:0x0140, B:70:0x0147, B:72:0x0150, B:74:0x015b, B:76:0x0161, B:78:0x0167, B:79:0x016e, B:82:0x0174, B:87:0x0182, B:90:0x0187, B:92:0x0197, B:94:0x01a3, B:108:0x01d9, B:98:0x01af, B:100:0x01b3, B:102:0x01ba, B:105:0x01c4, B:107:0x01d2, B:110:0x01e4, B:73:0x0153, B:111:0x01f9, B:132:0x0247, B:133:0x024f, B:135:0x0255, B:137:0x0269, B:138:0x0279, B:139:0x0282, B:217:0x03a2, B:218:0x03ae, B:220:0x03b4, B:222:0x03c8, B:224:0x03d2, B:226:0x03d8, B:227:0x03e2, B:186:0x0334, B:187:0x0338, B:189:0x033e, B:191:0x0348, B:192:0x034a, B:194:0x0350, B:196:0x0356, B:197:0x0358, B:199:0x0362, B:201:0x036e, B:203:0x0372, B:204:0x0374, B:205:0x037d, B:207:0x0383, B:209:0x0389, B:210:0x038b, B:211:0x0391, B:304:0x0505, B:261:0x0457, B:148:0x02a4, B:149:0x02a8, B:151:0x02ae, B:153:0x02b8, B:154:0x02ba, B:156:0x02c0, B:158:0x02c6, B:160:0x02ca, B:161:0x02cc, B:163:0x02da, B:165:0x02e8, B:167:0x02f4, B:170:0x0302, B:23:0x0062, B:24:0x006a, B:287:0x04de, B:288:0x04e3, B:256:0x0445, B:257:0x0451), top: B:351:0x0014, outer: #14, inners: #0, #2, #3, #4, #5, #6, #7, #9, #11, #13 }] */
    /* JADX WARN: Code duplicated, block: B:264:0x045c A[Catch: all -> 0x0512, TryCatch #10 {all -> 0x0512, blocks: (B:6:0x0014, B:8:0x001d, B:9:0x0022, B:12:0x0032, B:14:0x0042, B:16:0x004b, B:18:0x004f, B:20:0x0055, B:21:0x0058, B:22:0x0061, B:25:0x006b, B:113:0x0202, B:114:0x0205, B:117:0x020b, B:120:0x0219, B:121:0x021d, B:123:0x0223, B:125:0x022d, B:127:0x0237, B:129:0x023d, B:130:0x0244, B:131:0x0246, B:143:0x0286, B:144:0x0287, B:146:0x0291, B:147:0x02a3, B:171:0x0303, B:175:0x030c, B:176:0x030d, B:177:0x0311, B:179:0x0317, B:181:0x0321, B:213:0x0395, B:215:0x039f, B:216:0x03a1, B:231:0x03e7, B:184:0x032c, B:185:0x0333, B:212:0x0392, B:234:0x03ea, B:235:0x03eb, B:236:0x03f3, B:238:0x03f9, B:240:0x0415, B:242:0x0422, B:244:0x0428, B:245:0x0430, B:247:0x0434, B:248:0x0437, B:250:0x043b, B:254:0x0442, B:255:0x0444, B:259:0x0454, B:260:0x0456, B:262:0x0458, B:264:0x045c, B:265:0x0465, B:267:0x046a, B:269:0x0479, B:273:0x048b, B:274:0x048c, B:276:0x049f, B:277:0x04a4, B:279:0x04ac, B:281:0x04bc, B:283:0x04c3, B:285:0x04cc, B:286:0x04dd, B:289:0x04e4, B:293:0x04f5, B:282:0x04bf, B:300:0x0500, B:309:0x050e, B:308:0x050b, B:312:0x0511, B:26:0x007b, B:27:0x0085, B:29:0x008b, B:31:0x0097, B:33:0x00a5, B:35:0x00bb, B:37:0x00c8, B:41:0x00d6, B:43:0x00dc, B:44:0x00e5, B:46:0x00ee, B:48:0x00f2, B:51:0x00f9, B:53:0x00fd, B:55:0x0105, B:57:0x010e, B:59:0x0116, B:60:0x011d, B:62:0x0125, B:63:0x012c, B:68:0x0138, B:69:0x0140, B:70:0x0147, B:72:0x0150, B:74:0x015b, B:76:0x0161, B:78:0x0167, B:79:0x016e, B:82:0x0174, B:87:0x0182, B:90:0x0187, B:92:0x0197, B:94:0x01a3, B:108:0x01d9, B:98:0x01af, B:100:0x01b3, B:102:0x01ba, B:105:0x01c4, B:107:0x01d2, B:110:0x01e4, B:73:0x0153, B:111:0x01f9, B:132:0x0247, B:133:0x024f, B:135:0x0255, B:137:0x0269, B:138:0x0279, B:139:0x0282, B:217:0x03a2, B:218:0x03ae, B:220:0x03b4, B:222:0x03c8, B:224:0x03d2, B:226:0x03d8, B:227:0x03e2, B:186:0x0334, B:187:0x0338, B:189:0x033e, B:191:0x0348, B:192:0x034a, B:194:0x0350, B:196:0x0356, B:197:0x0358, B:199:0x0362, B:201:0x036e, B:203:0x0372, B:204:0x0374, B:205:0x037d, B:207:0x0383, B:209:0x0389, B:210:0x038b, B:211:0x0391, B:304:0x0505, B:261:0x0457, B:148:0x02a4, B:149:0x02a8, B:151:0x02ae, B:153:0x02b8, B:154:0x02ba, B:156:0x02c0, B:158:0x02c6, B:160:0x02ca, B:161:0x02cc, B:163:0x02da, B:165:0x02e8, B:167:0x02f4, B:170:0x0302, B:23:0x0062, B:24:0x006a, B:287:0x04de, B:288:0x04e3, B:256:0x0445, B:257:0x0451), top: B:351:0x0014, outer: #14, inners: #0, #2, #3, #4, #5, #6, #7, #9, #11, #13 }] */
    /* JADX WARN: Code duplicated, block: B:267:0x046a A[Catch: all -> 0x0512, TryCatch #10 {all -> 0x0512, blocks: (B:6:0x0014, B:8:0x001d, B:9:0x0022, B:12:0x0032, B:14:0x0042, B:16:0x004b, B:18:0x004f, B:20:0x0055, B:21:0x0058, B:22:0x0061, B:25:0x006b, B:113:0x0202, B:114:0x0205, B:117:0x020b, B:120:0x0219, B:121:0x021d, B:123:0x0223, B:125:0x022d, B:127:0x0237, B:129:0x023d, B:130:0x0244, B:131:0x0246, B:143:0x0286, B:144:0x0287, B:146:0x0291, B:147:0x02a3, B:171:0x0303, B:175:0x030c, B:176:0x030d, B:177:0x0311, B:179:0x0317, B:181:0x0321, B:213:0x0395, B:215:0x039f, B:216:0x03a1, B:231:0x03e7, B:184:0x032c, B:185:0x0333, B:212:0x0392, B:234:0x03ea, B:235:0x03eb, B:236:0x03f3, B:238:0x03f9, B:240:0x0415, B:242:0x0422, B:244:0x0428, B:245:0x0430, B:247:0x0434, B:248:0x0437, B:250:0x043b, B:254:0x0442, B:255:0x0444, B:259:0x0454, B:260:0x0456, B:262:0x0458, B:264:0x045c, B:265:0x0465, B:267:0x046a, B:269:0x0479, B:273:0x048b, B:274:0x048c, B:276:0x049f, B:277:0x04a4, B:279:0x04ac, B:281:0x04bc, B:283:0x04c3, B:285:0x04cc, B:286:0x04dd, B:289:0x04e4, B:293:0x04f5, B:282:0x04bf, B:300:0x0500, B:309:0x050e, B:308:0x050b, B:312:0x0511, B:26:0x007b, B:27:0x0085, B:29:0x008b, B:31:0x0097, B:33:0x00a5, B:35:0x00bb, B:37:0x00c8, B:41:0x00d6, B:43:0x00dc, B:44:0x00e5, B:46:0x00ee, B:48:0x00f2, B:51:0x00f9, B:53:0x00fd, B:55:0x0105, B:57:0x010e, B:59:0x0116, B:60:0x011d, B:62:0x0125, B:63:0x012c, B:68:0x0138, B:69:0x0140, B:70:0x0147, B:72:0x0150, B:74:0x015b, B:76:0x0161, B:78:0x0167, B:79:0x016e, B:82:0x0174, B:87:0x0182, B:90:0x0187, B:92:0x0197, B:94:0x01a3, B:108:0x01d9, B:98:0x01af, B:100:0x01b3, B:102:0x01ba, B:105:0x01c4, B:107:0x01d2, B:110:0x01e4, B:73:0x0153, B:111:0x01f9, B:132:0x0247, B:133:0x024f, B:135:0x0255, B:137:0x0269, B:138:0x0279, B:139:0x0282, B:217:0x03a2, B:218:0x03ae, B:220:0x03b4, B:222:0x03c8, B:224:0x03d2, B:226:0x03d8, B:227:0x03e2, B:186:0x0334, B:187:0x0338, B:189:0x033e, B:191:0x0348, B:192:0x034a, B:194:0x0350, B:196:0x0356, B:197:0x0358, B:199:0x0362, B:201:0x036e, B:203:0x0372, B:204:0x0374, B:205:0x037d, B:207:0x0383, B:209:0x0389, B:210:0x038b, B:211:0x0391, B:304:0x0505, B:261:0x0457, B:148:0x02a4, B:149:0x02a8, B:151:0x02ae, B:153:0x02b8, B:154:0x02ba, B:156:0x02c0, B:158:0x02c6, B:160:0x02ca, B:161:0x02cc, B:163:0x02da, B:165:0x02e8, B:167:0x02f4, B:170:0x0302, B:23:0x0062, B:24:0x006a, B:287:0x04de, B:288:0x04e3, B:256:0x0445, B:257:0x0451), top: B:351:0x0014, outer: #14, inners: #0, #2, #3, #4, #5, #6, #7, #9, #11, #13 }] */
    /* JADX WARN: Code duplicated, block: B:269:0x0479 A[Catch: all -> 0x0512, TRY_LEAVE, TryCatch #10 {all -> 0x0512, blocks: (B:6:0x0014, B:8:0x001d, B:9:0x0022, B:12:0x0032, B:14:0x0042, B:16:0x004b, B:18:0x004f, B:20:0x0055, B:21:0x0058, B:22:0x0061, B:25:0x006b, B:113:0x0202, B:114:0x0205, B:117:0x020b, B:120:0x0219, B:121:0x021d, B:123:0x0223, B:125:0x022d, B:127:0x0237, B:129:0x023d, B:130:0x0244, B:131:0x0246, B:143:0x0286, B:144:0x0287, B:146:0x0291, B:147:0x02a3, B:171:0x0303, B:175:0x030c, B:176:0x030d, B:177:0x0311, B:179:0x0317, B:181:0x0321, B:213:0x0395, B:215:0x039f, B:216:0x03a1, B:231:0x03e7, B:184:0x032c, B:185:0x0333, B:212:0x0392, B:234:0x03ea, B:235:0x03eb, B:236:0x03f3, B:238:0x03f9, B:240:0x0415, B:242:0x0422, B:244:0x0428, B:245:0x0430, B:247:0x0434, B:248:0x0437, B:250:0x043b, B:254:0x0442, B:255:0x0444, B:259:0x0454, B:260:0x0456, B:262:0x0458, B:264:0x045c, B:265:0x0465, B:267:0x046a, B:269:0x0479, B:273:0x048b, B:274:0x048c, B:276:0x049f, B:277:0x04a4, B:279:0x04ac, B:281:0x04bc, B:283:0x04c3, B:285:0x04cc, B:286:0x04dd, B:289:0x04e4, B:293:0x04f5, B:282:0x04bf, B:300:0x0500, B:309:0x050e, B:308:0x050b, B:312:0x0511, B:26:0x007b, B:27:0x0085, B:29:0x008b, B:31:0x0097, B:33:0x00a5, B:35:0x00bb, B:37:0x00c8, B:41:0x00d6, B:43:0x00dc, B:44:0x00e5, B:46:0x00ee, B:48:0x00f2, B:51:0x00f9, B:53:0x00fd, B:55:0x0105, B:57:0x010e, B:59:0x0116, B:60:0x011d, B:62:0x0125, B:63:0x012c, B:68:0x0138, B:69:0x0140, B:70:0x0147, B:72:0x0150, B:74:0x015b, B:76:0x0161, B:78:0x0167, B:79:0x016e, B:82:0x0174, B:87:0x0182, B:90:0x0187, B:92:0x0197, B:94:0x01a3, B:108:0x01d9, B:98:0x01af, B:100:0x01b3, B:102:0x01ba, B:105:0x01c4, B:107:0x01d2, B:110:0x01e4, B:73:0x0153, B:111:0x01f9, B:132:0x0247, B:133:0x024f, B:135:0x0255, B:137:0x0269, B:138:0x0279, B:139:0x0282, B:217:0x03a2, B:218:0x03ae, B:220:0x03b4, B:222:0x03c8, B:224:0x03d2, B:226:0x03d8, B:227:0x03e2, B:186:0x0334, B:187:0x0338, B:189:0x033e, B:191:0x0348, B:192:0x034a, B:194:0x0350, B:196:0x0356, B:197:0x0358, B:199:0x0362, B:201:0x036e, B:203:0x0372, B:204:0x0374, B:205:0x037d, B:207:0x0383, B:209:0x0389, B:210:0x038b, B:211:0x0391, B:304:0x0505, B:261:0x0457, B:148:0x02a4, B:149:0x02a8, B:151:0x02ae, B:153:0x02b8, B:154:0x02ba, B:156:0x02c0, B:158:0x02c6, B:160:0x02ca, B:161:0x02cc, B:163:0x02da, B:165:0x02e8, B:167:0x02f4, B:170:0x0302, B:23:0x0062, B:24:0x006a, B:287:0x04de, B:288:0x04e3, B:256:0x0445, B:257:0x0451), top: B:351:0x0014, outer: #14, inners: #0, #2, #3, #4, #5, #6, #7, #9, #11, #13 }] */
    /* JADX WARN: Code duplicated, block: B:274:0x048c A[Catch: all -> 0x0512, TryCatch #10 {all -> 0x0512, blocks: (B:6:0x0014, B:8:0x001d, B:9:0x0022, B:12:0x0032, B:14:0x0042, B:16:0x004b, B:18:0x004f, B:20:0x0055, B:21:0x0058, B:22:0x0061, B:25:0x006b, B:113:0x0202, B:114:0x0205, B:117:0x020b, B:120:0x0219, B:121:0x021d, B:123:0x0223, B:125:0x022d, B:127:0x0237, B:129:0x023d, B:130:0x0244, B:131:0x0246, B:143:0x0286, B:144:0x0287, B:146:0x0291, B:147:0x02a3, B:171:0x0303, B:175:0x030c, B:176:0x030d, B:177:0x0311, B:179:0x0317, B:181:0x0321, B:213:0x0395, B:215:0x039f, B:216:0x03a1, B:231:0x03e7, B:184:0x032c, B:185:0x0333, B:212:0x0392, B:234:0x03ea, B:235:0x03eb, B:236:0x03f3, B:238:0x03f9, B:240:0x0415, B:242:0x0422, B:244:0x0428, B:245:0x0430, B:247:0x0434, B:248:0x0437, B:250:0x043b, B:254:0x0442, B:255:0x0444, B:259:0x0454, B:260:0x0456, B:262:0x0458, B:264:0x045c, B:265:0x0465, B:267:0x046a, B:269:0x0479, B:273:0x048b, B:274:0x048c, B:276:0x049f, B:277:0x04a4, B:279:0x04ac, B:281:0x04bc, B:283:0x04c3, B:285:0x04cc, B:286:0x04dd, B:289:0x04e4, B:293:0x04f5, B:282:0x04bf, B:300:0x0500, B:309:0x050e, B:308:0x050b, B:312:0x0511, B:26:0x007b, B:27:0x0085, B:29:0x008b, B:31:0x0097, B:33:0x00a5, B:35:0x00bb, B:37:0x00c8, B:41:0x00d6, B:43:0x00dc, B:44:0x00e5, B:46:0x00ee, B:48:0x00f2, B:51:0x00f9, B:53:0x00fd, B:55:0x0105, B:57:0x010e, B:59:0x0116, B:60:0x011d, B:62:0x0125, B:63:0x012c, B:68:0x0138, B:69:0x0140, B:70:0x0147, B:72:0x0150, B:74:0x015b, B:76:0x0161, B:78:0x0167, B:79:0x016e, B:82:0x0174, B:87:0x0182, B:90:0x0187, B:92:0x0197, B:94:0x01a3, B:108:0x01d9, B:98:0x01af, B:100:0x01b3, B:102:0x01ba, B:105:0x01c4, B:107:0x01d2, B:110:0x01e4, B:73:0x0153, B:111:0x01f9, B:132:0x0247, B:133:0x024f, B:135:0x0255, B:137:0x0269, B:138:0x0279, B:139:0x0282, B:217:0x03a2, B:218:0x03ae, B:220:0x03b4, B:222:0x03c8, B:224:0x03d2, B:226:0x03d8, B:227:0x03e2, B:186:0x0334, B:187:0x0338, B:189:0x033e, B:191:0x0348, B:192:0x034a, B:194:0x0350, B:196:0x0356, B:197:0x0358, B:199:0x0362, B:201:0x036e, B:203:0x0372, B:204:0x0374, B:205:0x037d, B:207:0x0383, B:209:0x0389, B:210:0x038b, B:211:0x0391, B:304:0x0505, B:261:0x0457, B:148:0x02a4, B:149:0x02a8, B:151:0x02ae, B:153:0x02b8, B:154:0x02ba, B:156:0x02c0, B:158:0x02c6, B:160:0x02ca, B:161:0x02cc, B:163:0x02da, B:165:0x02e8, B:167:0x02f4, B:170:0x0302, B:23:0x0062, B:24:0x006a, B:287:0x04de, B:288:0x04e3, B:256:0x0445, B:257:0x0451), top: B:351:0x0014, outer: #14, inners: #0, #2, #3, #4, #5, #6, #7, #9, #11, #13 }] */
    /* JADX WARN: Code duplicated, block: B:276:0x049f A[Catch: all -> 0x0512, TryCatch #10 {all -> 0x0512, blocks: (B:6:0x0014, B:8:0x001d, B:9:0x0022, B:12:0x0032, B:14:0x0042, B:16:0x004b, B:18:0x004f, B:20:0x0055, B:21:0x0058, B:22:0x0061, B:25:0x006b, B:113:0x0202, B:114:0x0205, B:117:0x020b, B:120:0x0219, B:121:0x021d, B:123:0x0223, B:125:0x022d, B:127:0x0237, B:129:0x023d, B:130:0x0244, B:131:0x0246, B:143:0x0286, B:144:0x0287, B:146:0x0291, B:147:0x02a3, B:171:0x0303, B:175:0x030c, B:176:0x030d, B:177:0x0311, B:179:0x0317, B:181:0x0321, B:213:0x0395, B:215:0x039f, B:216:0x03a1, B:231:0x03e7, B:184:0x032c, B:185:0x0333, B:212:0x0392, B:234:0x03ea, B:235:0x03eb, B:236:0x03f3, B:238:0x03f9, B:240:0x0415, B:242:0x0422, B:244:0x0428, B:245:0x0430, B:247:0x0434, B:248:0x0437, B:250:0x043b, B:254:0x0442, B:255:0x0444, B:259:0x0454, B:260:0x0456, B:262:0x0458, B:264:0x045c, B:265:0x0465, B:267:0x046a, B:269:0x0479, B:273:0x048b, B:274:0x048c, B:276:0x049f, B:277:0x04a4, B:279:0x04ac, B:281:0x04bc, B:283:0x04c3, B:285:0x04cc, B:286:0x04dd, B:289:0x04e4, B:293:0x04f5, B:282:0x04bf, B:300:0x0500, B:309:0x050e, B:308:0x050b, B:312:0x0511, B:26:0x007b, B:27:0x0085, B:29:0x008b, B:31:0x0097, B:33:0x00a5, B:35:0x00bb, B:37:0x00c8, B:41:0x00d6, B:43:0x00dc, B:44:0x00e5, B:46:0x00ee, B:48:0x00f2, B:51:0x00f9, B:53:0x00fd, B:55:0x0105, B:57:0x010e, B:59:0x0116, B:60:0x011d, B:62:0x0125, B:63:0x012c, B:68:0x0138, B:69:0x0140, B:70:0x0147, B:72:0x0150, B:74:0x015b, B:76:0x0161, B:78:0x0167, B:79:0x016e, B:82:0x0174, B:87:0x0182, B:90:0x0187, B:92:0x0197, B:94:0x01a3, B:108:0x01d9, B:98:0x01af, B:100:0x01b3, B:102:0x01ba, B:105:0x01c4, B:107:0x01d2, B:110:0x01e4, B:73:0x0153, B:111:0x01f9, B:132:0x0247, B:133:0x024f, B:135:0x0255, B:137:0x0269, B:138:0x0279, B:139:0x0282, B:217:0x03a2, B:218:0x03ae, B:220:0x03b4, B:222:0x03c8, B:224:0x03d2, B:226:0x03d8, B:227:0x03e2, B:186:0x0334, B:187:0x0338, B:189:0x033e, B:191:0x0348, B:192:0x034a, B:194:0x0350, B:196:0x0356, B:197:0x0358, B:199:0x0362, B:201:0x036e, B:203:0x0372, B:204:0x0374, B:205:0x037d, B:207:0x0383, B:209:0x0389, B:210:0x038b, B:211:0x0391, B:304:0x0505, B:261:0x0457, B:148:0x02a4, B:149:0x02a8, B:151:0x02ae, B:153:0x02b8, B:154:0x02ba, B:156:0x02c0, B:158:0x02c6, B:160:0x02ca, B:161:0x02cc, B:163:0x02da, B:165:0x02e8, B:167:0x02f4, B:170:0x0302, B:23:0x0062, B:24:0x006a, B:287:0x04de, B:288:0x04e3, B:256:0x0445, B:257:0x0451), top: B:351:0x0014, outer: #14, inners: #0, #2, #3, #4, #5, #6, #7, #9, #11, #13 }] */
    /* JADX WARN: Code duplicated, block: B:279:0x04ac A[Catch: all -> 0x0512, TryCatch #10 {all -> 0x0512, blocks: (B:6:0x0014, B:8:0x001d, B:9:0x0022, B:12:0x0032, B:14:0x0042, B:16:0x004b, B:18:0x004f, B:20:0x0055, B:21:0x0058, B:22:0x0061, B:25:0x006b, B:113:0x0202, B:114:0x0205, B:117:0x020b, B:120:0x0219, B:121:0x021d, B:123:0x0223, B:125:0x022d, B:127:0x0237, B:129:0x023d, B:130:0x0244, B:131:0x0246, B:143:0x0286, B:144:0x0287, B:146:0x0291, B:147:0x02a3, B:171:0x0303, B:175:0x030c, B:176:0x030d, B:177:0x0311, B:179:0x0317, B:181:0x0321, B:213:0x0395, B:215:0x039f, B:216:0x03a1, B:231:0x03e7, B:184:0x032c, B:185:0x0333, B:212:0x0392, B:234:0x03ea, B:235:0x03eb, B:236:0x03f3, B:238:0x03f9, B:240:0x0415, B:242:0x0422, B:244:0x0428, B:245:0x0430, B:247:0x0434, B:248:0x0437, B:250:0x043b, B:254:0x0442, B:255:0x0444, B:259:0x0454, B:260:0x0456, B:262:0x0458, B:264:0x045c, B:265:0x0465, B:267:0x046a, B:269:0x0479, B:273:0x048b, B:274:0x048c, B:276:0x049f, B:277:0x04a4, B:279:0x04ac, B:281:0x04bc, B:283:0x04c3, B:285:0x04cc, B:286:0x04dd, B:289:0x04e4, B:293:0x04f5, B:282:0x04bf, B:300:0x0500, B:309:0x050e, B:308:0x050b, B:312:0x0511, B:26:0x007b, B:27:0x0085, B:29:0x008b, B:31:0x0097, B:33:0x00a5, B:35:0x00bb, B:37:0x00c8, B:41:0x00d6, B:43:0x00dc, B:44:0x00e5, B:46:0x00ee, B:48:0x00f2, B:51:0x00f9, B:53:0x00fd, B:55:0x0105, B:57:0x010e, B:59:0x0116, B:60:0x011d, B:62:0x0125, B:63:0x012c, B:68:0x0138, B:69:0x0140, B:70:0x0147, B:72:0x0150, B:74:0x015b, B:76:0x0161, B:78:0x0167, B:79:0x016e, B:82:0x0174, B:87:0x0182, B:90:0x0187, B:92:0x0197, B:94:0x01a3, B:108:0x01d9, B:98:0x01af, B:100:0x01b3, B:102:0x01ba, B:105:0x01c4, B:107:0x01d2, B:110:0x01e4, B:73:0x0153, B:111:0x01f9, B:132:0x0247, B:133:0x024f, B:135:0x0255, B:137:0x0269, B:138:0x0279, B:139:0x0282, B:217:0x03a2, B:218:0x03ae, B:220:0x03b4, B:222:0x03c8, B:224:0x03d2, B:226:0x03d8, B:227:0x03e2, B:186:0x0334, B:187:0x0338, B:189:0x033e, B:191:0x0348, B:192:0x034a, B:194:0x0350, B:196:0x0356, B:197:0x0358, B:199:0x0362, B:201:0x036e, B:203:0x0372, B:204:0x0374, B:205:0x037d, B:207:0x0383, B:209:0x0389, B:210:0x038b, B:211:0x0391, B:304:0x0505, B:261:0x0457, B:148:0x02a4, B:149:0x02a8, B:151:0x02ae, B:153:0x02b8, B:154:0x02ba, B:156:0x02c0, B:158:0x02c6, B:160:0x02ca, B:161:0x02cc, B:163:0x02da, B:165:0x02e8, B:167:0x02f4, B:170:0x0302, B:23:0x0062, B:24:0x006a, B:287:0x04de, B:288:0x04e3, B:256:0x0445, B:257:0x0451), top: B:351:0x0014, outer: #14, inners: #0, #2, #3, #4, #5, #6, #7, #9, #11, #13 }] */
    /* JADX WARN: Code duplicated, block: B:281:0x04bc A[Catch: all -> 0x0512, TryCatch #10 {all -> 0x0512, blocks: (B:6:0x0014, B:8:0x001d, B:9:0x0022, B:12:0x0032, B:14:0x0042, B:16:0x004b, B:18:0x004f, B:20:0x0055, B:21:0x0058, B:22:0x0061, B:25:0x006b, B:113:0x0202, B:114:0x0205, B:117:0x020b, B:120:0x0219, B:121:0x021d, B:123:0x0223, B:125:0x022d, B:127:0x0237, B:129:0x023d, B:130:0x0244, B:131:0x0246, B:143:0x0286, B:144:0x0287, B:146:0x0291, B:147:0x02a3, B:171:0x0303, B:175:0x030c, B:176:0x030d, B:177:0x0311, B:179:0x0317, B:181:0x0321, B:213:0x0395, B:215:0x039f, B:216:0x03a1, B:231:0x03e7, B:184:0x032c, B:185:0x0333, B:212:0x0392, B:234:0x03ea, B:235:0x03eb, B:236:0x03f3, B:238:0x03f9, B:240:0x0415, B:242:0x0422, B:244:0x0428, B:245:0x0430, B:247:0x0434, B:248:0x0437, B:250:0x043b, B:254:0x0442, B:255:0x0444, B:259:0x0454, B:260:0x0456, B:262:0x0458, B:264:0x045c, B:265:0x0465, B:267:0x046a, B:269:0x0479, B:273:0x048b, B:274:0x048c, B:276:0x049f, B:277:0x04a4, B:279:0x04ac, B:281:0x04bc, B:283:0x04c3, B:285:0x04cc, B:286:0x04dd, B:289:0x04e4, B:293:0x04f5, B:282:0x04bf, B:300:0x0500, B:309:0x050e, B:308:0x050b, B:312:0x0511, B:26:0x007b, B:27:0x0085, B:29:0x008b, B:31:0x0097, B:33:0x00a5, B:35:0x00bb, B:37:0x00c8, B:41:0x00d6, B:43:0x00dc, B:44:0x00e5, B:46:0x00ee, B:48:0x00f2, B:51:0x00f9, B:53:0x00fd, B:55:0x0105, B:57:0x010e, B:59:0x0116, B:60:0x011d, B:62:0x0125, B:63:0x012c, B:68:0x0138, B:69:0x0140, B:70:0x0147, B:72:0x0150, B:74:0x015b, B:76:0x0161, B:78:0x0167, B:79:0x016e, B:82:0x0174, B:87:0x0182, B:90:0x0187, B:92:0x0197, B:94:0x01a3, B:108:0x01d9, B:98:0x01af, B:100:0x01b3, B:102:0x01ba, B:105:0x01c4, B:107:0x01d2, B:110:0x01e4, B:73:0x0153, B:111:0x01f9, B:132:0x0247, B:133:0x024f, B:135:0x0255, B:137:0x0269, B:138:0x0279, B:139:0x0282, B:217:0x03a2, B:218:0x03ae, B:220:0x03b4, B:222:0x03c8, B:224:0x03d2, B:226:0x03d8, B:227:0x03e2, B:186:0x0334, B:187:0x0338, B:189:0x033e, B:191:0x0348, B:192:0x034a, B:194:0x0350, B:196:0x0356, B:197:0x0358, B:199:0x0362, B:201:0x036e, B:203:0x0372, B:204:0x0374, B:205:0x037d, B:207:0x0383, B:209:0x0389, B:210:0x038b, B:211:0x0391, B:304:0x0505, B:261:0x0457, B:148:0x02a4, B:149:0x02a8, B:151:0x02ae, B:153:0x02b8, B:154:0x02ba, B:156:0x02c0, B:158:0x02c6, B:160:0x02ca, B:161:0x02cc, B:163:0x02da, B:165:0x02e8, B:167:0x02f4, B:170:0x0302, B:23:0x0062, B:24:0x006a, B:287:0x04de, B:288:0x04e3, B:256:0x0445, B:257:0x0451), top: B:351:0x0014, outer: #14, inners: #0, #2, #3, #4, #5, #6, #7, #9, #11, #13 }] */
    /* JADX WARN: Code duplicated, block: B:282:0x04bf A[Catch: all -> 0x0512, TryCatch #10 {all -> 0x0512, blocks: (B:6:0x0014, B:8:0x001d, B:9:0x0022, B:12:0x0032, B:14:0x0042, B:16:0x004b, B:18:0x004f, B:20:0x0055, B:21:0x0058, B:22:0x0061, B:25:0x006b, B:113:0x0202, B:114:0x0205, B:117:0x020b, B:120:0x0219, B:121:0x021d, B:123:0x0223, B:125:0x022d, B:127:0x0237, B:129:0x023d, B:130:0x0244, B:131:0x0246, B:143:0x0286, B:144:0x0287, B:146:0x0291, B:147:0x02a3, B:171:0x0303, B:175:0x030c, B:176:0x030d, B:177:0x0311, B:179:0x0317, B:181:0x0321, B:213:0x0395, B:215:0x039f, B:216:0x03a1, B:231:0x03e7, B:184:0x032c, B:185:0x0333, B:212:0x0392, B:234:0x03ea, B:235:0x03eb, B:236:0x03f3, B:238:0x03f9, B:240:0x0415, B:242:0x0422, B:244:0x0428, B:245:0x0430, B:247:0x0434, B:248:0x0437, B:250:0x043b, B:254:0x0442, B:255:0x0444, B:259:0x0454, B:260:0x0456, B:262:0x0458, B:264:0x045c, B:265:0x0465, B:267:0x046a, B:269:0x0479, B:273:0x048b, B:274:0x048c, B:276:0x049f, B:277:0x04a4, B:279:0x04ac, B:281:0x04bc, B:283:0x04c3, B:285:0x04cc, B:286:0x04dd, B:289:0x04e4, B:293:0x04f5, B:282:0x04bf, B:300:0x0500, B:309:0x050e, B:308:0x050b, B:312:0x0511, B:26:0x007b, B:27:0x0085, B:29:0x008b, B:31:0x0097, B:33:0x00a5, B:35:0x00bb, B:37:0x00c8, B:41:0x00d6, B:43:0x00dc, B:44:0x00e5, B:46:0x00ee, B:48:0x00f2, B:51:0x00f9, B:53:0x00fd, B:55:0x0105, B:57:0x010e, B:59:0x0116, B:60:0x011d, B:62:0x0125, B:63:0x012c, B:68:0x0138, B:69:0x0140, B:70:0x0147, B:72:0x0150, B:74:0x015b, B:76:0x0161, B:78:0x0167, B:79:0x016e, B:82:0x0174, B:87:0x0182, B:90:0x0187, B:92:0x0197, B:94:0x01a3, B:108:0x01d9, B:98:0x01af, B:100:0x01b3, B:102:0x01ba, B:105:0x01c4, B:107:0x01d2, B:110:0x01e4, B:73:0x0153, B:111:0x01f9, B:132:0x0247, B:133:0x024f, B:135:0x0255, B:137:0x0269, B:138:0x0279, B:139:0x0282, B:217:0x03a2, B:218:0x03ae, B:220:0x03b4, B:222:0x03c8, B:224:0x03d2, B:226:0x03d8, B:227:0x03e2, B:186:0x0334, B:187:0x0338, B:189:0x033e, B:191:0x0348, B:192:0x034a, B:194:0x0350, B:196:0x0356, B:197:0x0358, B:199:0x0362, B:201:0x036e, B:203:0x0372, B:204:0x0374, B:205:0x037d, B:207:0x0383, B:209:0x0389, B:210:0x038b, B:211:0x0391, B:304:0x0505, B:261:0x0457, B:148:0x02a4, B:149:0x02a8, B:151:0x02ae, B:153:0x02b8, B:154:0x02ba, B:156:0x02c0, B:158:0x02c6, B:160:0x02ca, B:161:0x02cc, B:163:0x02da, B:165:0x02e8, B:167:0x02f4, B:170:0x0302, B:23:0x0062, B:24:0x006a, B:287:0x04de, B:288:0x04e3, B:256:0x0445, B:257:0x0451), top: B:351:0x0014, outer: #14, inners: #0, #2, #3, #4, #5, #6, #7, #9, #11, #13 }] */
    /* JADX WARN: Code duplicated, block: B:285:0x04cc A[Catch: all -> 0x0512, TryCatch #10 {all -> 0x0512, blocks: (B:6:0x0014, B:8:0x001d, B:9:0x0022, B:12:0x0032, B:14:0x0042, B:16:0x004b, B:18:0x004f, B:20:0x0055, B:21:0x0058, B:22:0x0061, B:25:0x006b, B:113:0x0202, B:114:0x0205, B:117:0x020b, B:120:0x0219, B:121:0x021d, B:123:0x0223, B:125:0x022d, B:127:0x0237, B:129:0x023d, B:130:0x0244, B:131:0x0246, B:143:0x0286, B:144:0x0287, B:146:0x0291, B:147:0x02a3, B:171:0x0303, B:175:0x030c, B:176:0x030d, B:177:0x0311, B:179:0x0317, B:181:0x0321, B:213:0x0395, B:215:0x039f, B:216:0x03a1, B:231:0x03e7, B:184:0x032c, B:185:0x0333, B:212:0x0392, B:234:0x03ea, B:235:0x03eb, B:236:0x03f3, B:238:0x03f9, B:240:0x0415, B:242:0x0422, B:244:0x0428, B:245:0x0430, B:247:0x0434, B:248:0x0437, B:250:0x043b, B:254:0x0442, B:255:0x0444, B:259:0x0454, B:260:0x0456, B:262:0x0458, B:264:0x045c, B:265:0x0465, B:267:0x046a, B:269:0x0479, B:273:0x048b, B:274:0x048c, B:276:0x049f, B:277:0x04a4, B:279:0x04ac, B:281:0x04bc, B:283:0x04c3, B:285:0x04cc, B:286:0x04dd, B:289:0x04e4, B:293:0x04f5, B:282:0x04bf, B:300:0x0500, B:309:0x050e, B:308:0x050b, B:312:0x0511, B:26:0x007b, B:27:0x0085, B:29:0x008b, B:31:0x0097, B:33:0x00a5, B:35:0x00bb, B:37:0x00c8, B:41:0x00d6, B:43:0x00dc, B:44:0x00e5, B:46:0x00ee, B:48:0x00f2, B:51:0x00f9, B:53:0x00fd, B:55:0x0105, B:57:0x010e, B:59:0x0116, B:60:0x011d, B:62:0x0125, B:63:0x012c, B:68:0x0138, B:69:0x0140, B:70:0x0147, B:72:0x0150, B:74:0x015b, B:76:0x0161, B:78:0x0167, B:79:0x016e, B:82:0x0174, B:87:0x0182, B:90:0x0187, B:92:0x0197, B:94:0x01a3, B:108:0x01d9, B:98:0x01af, B:100:0x01b3, B:102:0x01ba, B:105:0x01c4, B:107:0x01d2, B:110:0x01e4, B:73:0x0153, B:111:0x01f9, B:132:0x0247, B:133:0x024f, B:135:0x0255, B:137:0x0269, B:138:0x0279, B:139:0x0282, B:217:0x03a2, B:218:0x03ae, B:220:0x03b4, B:222:0x03c8, B:224:0x03d2, B:226:0x03d8, B:227:0x03e2, B:186:0x0334, B:187:0x0338, B:189:0x033e, B:191:0x0348, B:192:0x034a, B:194:0x0350, B:196:0x0356, B:197:0x0358, B:199:0x0362, B:201:0x036e, B:203:0x0372, B:204:0x0374, B:205:0x037d, B:207:0x0383, B:209:0x0389, B:210:0x038b, B:211:0x0391, B:304:0x0505, B:261:0x0457, B:148:0x02a4, B:149:0x02a8, B:151:0x02ae, B:153:0x02b8, B:154:0x02ba, B:156:0x02c0, B:158:0x02c6, B:160:0x02ca, B:161:0x02cc, B:163:0x02da, B:165:0x02e8, B:167:0x02f4, B:170:0x0302, B:23:0x0062, B:24:0x006a, B:287:0x04de, B:288:0x04e3, B:256:0x0445, B:257:0x0451), top: B:351:0x0014, outer: #14, inners: #0, #2, #3, #4, #5, #6, #7, #9, #11, #13 }] */
    /* JADX WARN: Code duplicated, block: B:344:0x0457 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:352:0x04de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:356:0x0445 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:242:0x0422, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void I() {
        boolean z;
        boolean z2;
        long jA;
        dv dvVar;
        bk bkVar;
        dg dgVar;
        dp dpVar;
        int i;
        Iterator it2;
        ArrayList arrayList;
        bu[] buVarArr;
        int i2;
        com.google.android.libraries.navigation.internal.yr.ai aiVarA = com.google.android.libraries.navigation.internal.yu.f.a();
        try {
            cc.a();
            com.google.android.libraries.navigation.internal.pb.t tVar = this.H;
            com.google.android.libraries.navigation.internal.yt.a aVarC = com.google.android.libraries.navigation.internal.yt.d.c("TileUpdateBehavior ", this.c);
            try {
                r(this.P);
                if (this.ac) {
                    E(tVar, this.P);
                }
                int size = this.h.size();
                ArrayList<com.google.android.libraries.navigation.internal.oz.e> arrayList2 = new ArrayList();
                int i3 = 0;
                boolean z3 = false;
                while (true) {
                    z = true;
                    if (i3 >= size) {
                        break;
                    }
                    com.google.android.libraries.navigation.internal.qi.d dVar = (com.google.android.libraries.navigation.internal.qi.d) this.h.get(i3);
                    if (!this.P.contains(dVar)) {
                        dVar.E(ez.HIDDEN);
                        if (this.J && (dVar instanceof com.google.android.libraries.navigation.internal.oz.e)) {
                            arrayList2.add((com.google.android.libraries.navigation.internal.oz.e) dVar);
                        }
                        z3 = true;
                    }
                    i3++;
                    try {
                        aiVarA.close();
                        throw th;
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                        throw th;
                    }
                }
                L(this.h);
                p pVar = this.ai;
                p pVar2 = this.B;
                synchronized (pVar2) {
                    pVar.a = pVar2.a;
                    pVar.b = pVar2.b;
                }
                HashMap map = new HashMap();
                ArrayList arrayList3 = new ArrayList();
                com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("updating tiles");
                try {
                    gs gsVar = new gs((gt) this.P);
                    int i4 = 0;
                    while (gsVar.hasNext()) {
                        com.google.android.libraries.navigation.internal.qi.e eVar = (com.google.android.libraries.navigation.internal.qi.e) gsVar.next();
                        if (this.c == com.google.android.libraries.navigation.internal.adi.an.GMM_API_TILE_OVERLAY) {
                            arrayList = arrayList3;
                            if (this.ai.a != eVar.k()) {
                                com.google.android.libraries.navigation.internal.qi.c cVarL = eVar.l(this.aj, this.g.b());
                                com.google.android.libraries.navigation.internal.adi.an anVarAb = eVar.ab();
                                map.put(anVarAb, Integer.valueOf(map.containsKey(anVarAb) ? ((Integer) map.get(anVarAb)).intValue() + (z ? 1 : 0) : z ? 1 : 0));
                                i4 |= (cVarL == com.google.android.libraries.navigation.internal.qi.c.Z_ORDER ? 0 : z ? 1 : 0) ^ (z ? 1 : 0);
                                if (cVarL.e) {
                                    eVar.x(this.ai.a);
                                    z3 = z ? 1 : 0;
                                } else {
                                    eVar.q();
                                    this.o = z;
                                    z3 = z ? 1 : 0;
                                }
                                arrayList3 = arrayList;
                            }
                        } else {
                            arrayList = arrayList3;
                        }
                        com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.ac acVar = eVar instanceof com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.ac ? (com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.ac) eVar : null;
                        if (acVar != null) {
                            aq aqVar = acVar.d;
                            if (aqVar == null || aqVar == this.g.f()) {
                                ev evVarO = ev.o(acVar.a);
                                if (evVarO != null) {
                                    this.A.v.addAll(evVarO);
                                }
                                ev evVarO2 = ev.o(acVar.b);
                                if (evVarO2 != null) {
                                    this.A.w.addAll(evVarO2);
                                }
                                int iOrdinal = acVar.e.ordinal();
                                if (iOrdinal == z) {
                                    this.z.p(this.c);
                                } else if (iOrdinal == 2) {
                                    this.z.o(this.c);
                                }
                            } else {
                                this.g.f();
                                arrayList3 = arrayList;
                            }
                        }
                        eVar.w(tVar);
                        if (eVar.E(this.c == com.google.android.libraries.navigation.internal.adi.an.GMM_API_TILE_OVERLAY ? ez.DEFAULT : ((com.google.android.libraries.navigation.internal.qq.b) u()).a)) {
                            if (this.c == com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE) {
                                this.T = z;
                                this.z.e();
                            }
                            if (!this.J || acVar == null) {
                                arrayList3 = arrayList;
                            } else {
                                arrayList3 = arrayList;
                                arrayList3.add(acVar);
                            }
                            z3 = z ? 1 : 0;
                        } else {
                            arrayList3 = arrayList;
                        }
                        if (acVar != null && (buVarArr = acVar.f) != null) {
                            aq aqVar2 = acVar.d;
                            float f = this.H.w().k;
                            int length = buVarArr.length;
                            int i5 = 0;
                            while (i5 < length) {
                                Object[] objArr = z3 ? 1 : 0;
                                bu buVar = buVarArr[i5];
                                int i6 = length;
                                int i7 = buVar.b;
                                if ((i7 & 2) != 0) {
                                    i2 = i4;
                                    if (f < buVar.d) {
                                    }
                                    i5++;
                                    z3 = objArr == true ? 1 : 0;
                                    length = i6;
                                    i4 = i2;
                                } else {
                                    i2 = i4;
                                }
                                if ((i7 & 4) == 0 || f < buVar.e) {
                                    bq bqVar = buVar.f;
                                    if (bqVar.isEmpty() || (aqVar2 != null && bqVar.contains(Integer.valueOf(aqVar2.E.ab)))) {
                                        this.f.a(buVar.c);
                                    }
                                }
                                i5++;
                                z3 = objArr == true ? 1 : 0;
                                length = i6;
                                i4 = i2;
                            }
                        }
                        eVar.p();
                        this.h.add(eVar);
                        tVar = tVar;
                        z3 = z3 ? 1 : 0;
                        i4 = i4;
                        z = true;
                    }
                    this.g.q(this.h);
                    if (dVarB != null) {
                        Trace.endSection();
                    }
                    if (this.J && z3) {
                        com.google.android.libraries.navigation.internal.oz.d dVar2 = (com.google.android.libraries.navigation.internal.oz.d) this.K.a();
                        if (dVar2.f) {
                            Iterator it3 = arrayList3.iterator();
                            while (it3.hasNext()) {
                                com.google.android.libraries.navigation.internal.oz.e eVar2 = (com.google.android.libraries.navigation.internal.oz.e) it3.next();
                                if (dVar2.f) {
                                    fd fdVarC = eVar2.c();
                                    if (!fdVarC.isEmpty()) {
                                        if (dVar2.c(fdVarC)) {
                                            e(eVar2.a());
                                        }
                                        synchronized (dVar2.b) {
                                            nn nnVarListIterator = fdVarC.entrySet().listIterator();
                                            while (nnVarListIterator.hasNext()) {
                                                Map.Entry entry = (Map.Entry) nnVarListIterator.next();
                                                Set hashSet = (Set) dVar2.b.get(entry.getKey());
                                                if (hashSet == null) {
                                                    hashSet = new HashSet();
                                                    dVar2.b.put((Long) entry.getKey(), hashSet);
                                                }
                                                hashSet.add(new com.google.android.libraries.navigation.internal.oz.c(this, eVar2));
                                            }
                                        }
                                    }
                                    ev evVarB = eVar2.b();
                                    if (evVarB.isEmpty()) {
                                        continue;
                                    } else {
                                        ArrayList arrayList4 = new ArrayList();
                                        com.google.android.libraries.navigation.internal.om.n nVar = dVar2.d;
                                        dVar2.e.a();
                                        com.google.android.libraries.navigation.internal.agg.ez ezVar = ((com.google.android.libraries.navigation.internal.om.f) nVar).b;
                                        synchronized (dVar2.c) {
                                            no it4 = evVarB.iterator();
                                            while (it4.hasNext()) {
                                                hg hgVar = (hg) it4.next();
                                                ho hoVar = hgVar.c;
                                                if (hoVar == null) {
                                                    hoVar = ho.a;
                                                }
                                                if ((hoVar.b & 1) != 0 && com.google.android.libraries.navigation.internal.pa.a.c(hgVar, ezVar)) {
                                                    ho hoVar2 = hgVar.c;
                                                    if (hoVar2 == null) {
                                                        hoVar2 = ho.a;
                                                    }
                                                    long j = hoVar2.c;
                                                    Iterator it5 = it3;
                                                    eg egVarN = (eg) dVar2.c.get(j);
                                                    if (egVarN == null) {
                                                        egVarN = eg.n();
                                                        dVar2.c.put(j, egVarN);
                                                    }
                                                    if (egVarN.a(new com.google.android.libraries.navigation.internal.oz.b(hgVar), 1) == 0) {
                                                        arrayList4.add(Long.valueOf(j));
                                                    }
                                                    it3 = it5;
                                                    it4 = it4;
                                                }
                                            }
                                            it2 = it3;
                                        }
                                        dVar2.b(arrayList4);
                                        it3 = it2;
                                    }
                                }
                            }
                            for (com.google.android.libraries.navigation.internal.oz.e eVar3 : arrayList2) {
                                if (dVar2.f) {
                                    ev evVarB2 = eVar3.b();
                                    if (!evVarB2.isEmpty()) {
                                        ArrayList arrayList5 = new ArrayList();
                                        synchronized (dVar2.c) {
                                            no it6 = evVarB2.iterator();
                                            while (it6.hasNext()) {
                                                hg hgVar2 = (hg) it6.next();
                                                ho hoVar3 = hgVar2.c;
                                                if (hoVar3 == null) {
                                                    hoVar3 = ho.a;
                                                }
                                                if ((hoVar3.b & 1) != 0) {
                                                    LongSparseArray longSparseArray = dVar2.c;
                                                    ho hoVar4 = hgVar2.c;
                                                    if (hoVar4 == null) {
                                                        hoVar4 = ho.a;
                                                    }
                                                    ku kuVar = (ku) longSparseArray.get(hoVar4.c);
                                                    if (kuVar != null) {
                                                        if (kuVar.d(new com.google.android.libraries.navigation.internal.oz.b(hgVar2), 1) == 1) {
                                                            ho hoVar5 = hgVar2.c;
                                                            if (hoVar5 == null) {
                                                                hoVar5 = ho.a;
                                                            }
                                                            arrayList5.add(Long.valueOf(hoVar5.c));
                                                        }
                                                        if (kuVar.isEmpty()) {
                                                            LongSparseArray longSparseArray2 = dVar2.c;
                                                            ho hoVar6 = hgVar2.c;
                                                            if (hoVar6 == null) {
                                                                hoVar6 = ho.a;
                                                            }
                                                            longSparseArray2.remove(hoVar6.c);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        dVar2.b(arrayList5);
                                    }
                                    if (eVar3.c().isEmpty()) {
                                        continue;
                                    } else {
                                        synchronized (dVar2.b) {
                                            nn nnVarListIterator2 = eVar3.c().entrySet().listIterator();
                                            while (nnVarListIterator2.hasNext()) {
                                                Map.Entry entry2 = (Map.Entry) nnVarListIterator2.next();
                                                Set set = (Set) dVar2.b.get(entry2.getKey());
                                                if (set != null) {
                                                    set.remove(new com.google.android.libraries.navigation.internal.oz.c(this, eVar3));
                                                }
                                                if (set == null || set.isEmpty()) {
                                                    dVar2.b.remove(entry2.getKey());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        for (com.google.android.libraries.navigation.internal.adi.an anVar : map.keySet()) {
                            com.google.android.libraries.navigation.internal.nw.e.g(com.google.android.libraries.navigation.internal.xn.a.f("reused cache for ", anVar), ((Integer) map.get(anVar)).intValue());
                        }
                        if (i4 != 0) {
                            ax axVar = this.A;
                            axVar.i.h();
                            dgVar = axVar.j;
                            if (dgVar.a != null) {
                                for (eh ehVar : dgVar.b) {
                                    ehVar.h();
                                }
                            }
                            dpVar = axVar.q;
                            if (dpVar != null) {
                                dpVar.b();
                            }
                        }
                        if (this.T) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        synchronized (this.Q) {
                            L(this.Q);
                            M(this.h, this.Q);
                            if (z3) {
                                synchronized (this.Q) {
                                    dvVar = this.M;
                                    if (dvVar != null) {
                                        dvVar.a(ev.o(this.h));
                                    }
                                    P();
                                    if (z2) {
                                        this.U.set(true);
                                        this.z.d();
                                        bkVar = this.ah;
                                        if (bkVar != null) {
                                            final k kVar = this.z;
                                            Objects.requireNonNull(kVar);
                                            bkVar.m(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qd.r
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    kVar.c();
                                                }
                                            }, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
                                        }
                                    }
                                    this.al = !z3;
                                    this.ae.c(Boolean.valueOf(K()));
                                    if (z3) {
                                        this.A.o();
                                    }
                                    if (this.P.isEmpty()) {
                                        jA = this.k.a();
                                        this.m = jA;
                                        if (this.l < 0) {
                                            this.l = jA;
                                        }
                                    } else {
                                        this.l = -1L;
                                    }
                                    r(this.P);
                                    if (this.ak) {
                                        this.ak = false;
                                        L(this.h);
                                        this.g.q(this.h);
                                        synchronized (this.Q) {
                                            L(this.Q);
                                            this.A.h.remove(this.x);
                                            this.A.o();
                                        }
                                    }
                                    aVarC.close();
                                    aiVarA.close();
                                }
                            } else {
                                this.al = !z3;
                                this.ae.c(Boolean.valueOf(K()));
                                if (z3) {
                                    this.A.o();
                                }
                                if (this.P.isEmpty()) {
                                    jA = this.k.a();
                                    this.m = jA;
                                    if (this.l < 0) {
                                        this.l = jA;
                                    }
                                } else {
                                    this.l = -1L;
                                }
                                r(this.P);
                                if (this.ak) {
                                    this.ak = false;
                                    L(this.h);
                                    this.g.q(this.h);
                                    synchronized (this.Q) {
                                        L(this.Q);
                                        this.A.h.remove(this.x);
                                        this.A.o();
                                    }
                                }
                                aVarC.close();
                                aiVarA.close();
                            }
                        }
                    } else {
                        while (r0.hasNext()) {
                            com.google.android.libraries.navigation.internal.nw.e.g(com.google.android.libraries.navigation.internal.xn.a.f("reused cache for ", anVar), ((Integer) map.get(anVar)).intValue());
                        }
                        if (i4 != 0) {
                            ax axVar2 = this.A;
                            axVar2.i.h();
                            dgVar = axVar2.j;
                            if (dgVar.a != null) {
                                while (i < r5) {
                                    ehVar.h();
                                }
                            }
                            dpVar = axVar2.q;
                            if (dpVar != null) {
                                dpVar.b();
                            }
                        }
                        if (this.T || !this.s) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        synchronized (this.Q) {
                            L(this.Q);
                            M(this.h, this.Q);
                        }
                        if (z3) {
                            synchronized (this.Q) {
                            }
                            dvVar = this.M;
                            if (dvVar != null) {
                                dvVar.a(ev.o(this.h));
                            }
                            P();
                            if (z2) {
                                this.U.set(true);
                                this.z.d();
                                bkVar = this.ah;
                                if (bkVar != null) {
                                    final k kVar2 = this.z;
                                    Objects.requireNonNull(kVar2);
                                    bkVar.m(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qd.r
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            kVar2.c();
                                        }
                                    }, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
                                }
                            }
                            this.al = !z3;
                            this.ae.c(Boolean.valueOf(K()));
                            if (z3) {
                                this.A.o();
                            }
                            if (this.P.isEmpty()) {
                                jA = this.k.a();
                                this.m = jA;
                                if (this.l < 0) {
                                    this.l = jA;
                                }
                            } else {
                                this.l = -1L;
                            }
                            r(this.P);
                            if (this.ak) {
                                this.ak = false;
                                L(this.h);
                                this.g.q(this.h);
                                synchronized (this.Q) {
                                    L(this.Q);
                                }
                                this.A.h.remove(this.x);
                                this.A.o();
                            }
                            aVarC.close();
                            aiVarA.close();
                        } else {
                            this.al = !z3;
                            this.ae.c(Boolean.valueOf(K()));
                            if (z3) {
                                this.A.o();
                            }
                            if (this.P.isEmpty()) {
                                jA = this.k.a();
                                this.m = jA;
                                if (this.l < 0) {
                                    this.l = jA;
                                }
                            } else {
                                this.l = -1L;
                            }
                            r(this.P);
                            if (this.ak) {
                                this.ak = false;
                                L(this.h);
                                this.g.q(this.h);
                                synchronized (this.Q) {
                                    L(this.Q);
                                    this.A.h.remove(this.x);
                                    this.A.o();
                                }
                            }
                            aVarC.close();
                            aiVarA.close();
                        }
                    }
                } catch (Throwable th2) {
                    if (dVarB == null) {
                        throw th2;
                    }
                    try {
                        Trace.endSection();
                        throw th2;
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                        throw th2;
                    }
                    aiVarA.close();
                    throw th;
                }
            } catch (Throwable th4) {
                try {
                    aVarC.close();
                    throw th4;
                } catch (Throwable th5) {
                    th4.addSuppressed(th5);
                    throw th4;
                }
            }
        } catch (Throwable th6) {
            aiVarA.close();
            throw th6;
        }
        throw th;
    }

    public final void J() {
        if (this.ac) {
            this.A.o();
        }
    }

    public final boolean K() {
        return this.s && this.al;
    }

    @Override // com.google.android.libraries.navigation.internal.qg.h
    public final void X(com.google.android.libraries.navigation.internal.qi.e eVar) {
        if (eVar != null && this.ac) {
            if (!this.t) {
                synchronized (this.Q) {
                    eVar.p();
                    this.Q.add(eVar);
                }
                P();
            }
            this.A.o();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ac
    public final void Y() {
        if (this.aa && this.c == com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE) {
            this.z.h();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qd.d, com.google.android.libraries.navigation.internal.px.cr
    public final void aa(cq cqVar) {
        if (this.r) {
            synchronized (this.Q) {
                for (com.google.android.libraries.navigation.internal.qi.d dVar : this.Q) {
                    if (dVar != null && (dVar.B() || !this.t)) {
                        if (dVar instanceof cr) {
                            ((cr) dVar).aa(cqVar);
                        }
                    }
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qd.d, com.google.android.libraries.navigation.internal.px.cr
    public final com.google.android.libraries.navigation.internal.adi.an ab() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.qd.d, com.google.android.libraries.navigation.internal.px.cr
    public final void ac(bk bkVar) {
        this.ah = bkVar;
        bkVar.d(this);
    }

    @Override // com.google.android.libraries.navigation.internal.qd.d, com.google.android.libraries.navigation.internal.px.cr
    public final void d(bk bkVar) {
        bkVar.n(this);
    }

    @Override // com.google.android.libraries.navigation.internal.qd.n
    public final void e(cd cdVar) {
        if (this.ad) {
            this.g.o(cdVar);
            return;
        }
        com.google.android.libraries.navigation.internal.qi.f fVarT = t();
        if (fVarT == null || this.D.b(fVarT, cdVar, false) == null) {
            return;
        }
        this.g.o(cdVar);
    }

    @Override // com.google.android.libraries.navigation.internal.px.er
    public final boolean f() {
        return (this.u || this.s) ? false : true;
    }

    public w g(cg cgVar, com.google.android.libraries.navigation.internal.qv.k kVar) {
        com.google.android.libraries.navigation.internal.qg.j jVarC = this.g.c(cgVar, kVar);
        boolean z = this.j;
        boolean z2 = this.ad;
        an anVar = this.O;
        return new w(this.A, this.H, this.d, cgVar, kVar, jVarC, this.z, this.D, this.k, this.C, this.f, this.v, this.aj, this.F, this.i, this.R, this.b, this.a, this.r, this.am, this.N, this.G, this.J, this.K, false, z, z2, anVar);
    }

    public void h() {
    }

    public void i() {
    }

    @Override // com.google.android.libraries.navigation.internal.qd.d
    public void k() {
        this.ac = true;
        boolean zD = aw.d(com.google.android.libraries.navigation.internal.yr.ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
        v vVar = this.x;
        Runnable eVar = vVar.b;
        if (zD) {
            eVar = new com.google.android.libraries.navigation.internal.yu.e(eVar);
        }
        vVar.a = eVar;
        y();
        i();
        this.ak = false;
        ax axVar = this.A;
        axVar.h.add(this.x);
        this.A.o();
    }

    @Override // com.google.android.libraries.navigation.internal.qd.d
    public void l() {
        this.ac = false;
        v vVar = this.x;
        vVar.a = vVar.b;
        this.g.i();
        this.g.j();
        this.g.u();
        h();
        this.ak = true;
        z();
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    @Override // com.google.android.libraries.navigation.internal.qd.d
    public void m(com.google.android.libraries.navigation.internal.qq.f fVar, boolean z) {
        if (n(fVar)) {
            com.google.android.libraries.navigation.internal.qg.j jVar = this.g;
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("setDrawMode");
            try {
                if (!jVar.b.g(fVar)) {
                    jVar.i();
                    synchronized (jVar) {
                        jVar.n();
                        com.google.android.libraries.navigation.internal.qq.f fVar2 = jVar.b;
                        boolean z2 = true;
                        if (((com.google.android.libraries.navigation.internal.qq.b) fVar2).b.equals(((com.google.android.libraries.navigation.internal.qq.b) fVar).b) && ((com.google.android.libraries.navigation.internal.qq.b) fVar2).c == ((com.google.android.libraries.navigation.internal.qq.b) fVar).c) {
                            z2 = false;
                        }
                        jVar.b = fVar;
                        if (z2) {
                            jVar.t();
                        }
                    }
                    if (dVarB != null) {
                        Trace.endSection();
                    }
                } else if (dVarB != null) {
                    Trace.endSection();
                }
                if (!this.t) {
                    this.g.u();
                }
                this.A.o();
            } catch (Throwable th) {
                if (dVarB != null) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qd.d
    public final boolean n(com.google.android.libraries.navigation.internal.qq.f fVar) {
        return !u().g(fVar);
    }

    protected com.google.android.libraries.navigation.internal.qi.e o(cd cdVar, long j, com.google.android.libraries.navigation.internal.qi.f fVar) {
        return this.g.d(cdVar, j, fVar);
    }

    protected void p(com.google.android.libraries.navigation.internal.pg.f fVar) {
        this.f548n = fVar;
        this.g.a = fVar;
    }

    protected boolean q(List list, int i, com.google.android.libraries.navigation.internal.oe.x xVar, long j, Set set) {
        boolean z;
        cd cdVarC;
        int i2 = 0;
        this.S = 0;
        this.an.clear();
        this.ao.clear();
        synchronized (this.D) {
            com.google.android.libraries.navigation.internal.qi.f fVarT = t();
            int i3 = 1;
            List list2 = list;
            int i4 = 0;
            z = true;
            while (i4 <= i) {
                int size = list2.size();
                int i5 = i2;
                while (i5 < size) {
                    cd cdVar = (cd) list2.get(i5);
                    com.google.android.libraries.navigation.internal.qi.e eVarO = o(cdVar, j, fVarT);
                    if (eVarO != null) {
                        N(eVarO, set);
                        eVarO.s();
                        if (i4 == 0) {
                            this.S += i3;
                        }
                    } else {
                        com.google.android.libraries.navigation.internal.pg.f fVar = this.f548n;
                        if (fVar != null) {
                            List listD = fVar.d(cdVar, xVar);
                            int size2 = listD.size();
                            ArrayList arrayList = new ArrayList();
                            boolean z2 = z;
                            if (size2 == 4) {
                                int size3 = listD.size();
                                int i6 = 0;
                                while (true) {
                                    if (i6 < size3) {
                                        List list3 = listD;
                                        com.google.android.libraries.navigation.internal.qi.e eVarO2 = o((cd) listD.get(i6), j, fVarT);
                                        if (eVarO2 != null) {
                                            arrayList.add(eVarO2);
                                            i6++;
                                            listD = list3;
                                        } else if (i4 != i || (cdVarC = this.f548n.c(cdVar, xVar)) == null) {
                                            z = false;
                                        } else if (!this.an.contains(cdVarC)) {
                                            this.an.add(cdVarC);
                                        }
                                    } else {
                                        int size4 = arrayList.size();
                                        for (int i7 = 0; i7 < size4; i7++) {
                                            N((com.google.android.libraries.navigation.internal.qi.e) arrayList.get(i7), set);
                                        }
                                    }
                                    z = z2;
                                }
                            } else {
                                if (i4 != i) {
                                }
                                z = false;
                            }
                            L(arrayList);
                        } else {
                            z = false;
                        }
                    }
                    i5++;
                    list2 = list2;
                    i3 = 1;
                }
                boolean z3 = z;
                if (i4 == i || this.an.isEmpty()) {
                    z = z3;
                    break;
                }
                list2 = this.an;
                List list4 = this.ao;
                this.an = list4;
                this.ao = list2;
                list4.clear();
                i4++;
                z = z3;
                i2 = 0;
                i3 = 1;
            }
        }
        if (this.R && this.f548n != null && i > 0) {
            gt gtVar = (gt) set;
            hc hcVar = new hc(gtVar.j);
            gs gsVar = new gs(gtVar);
            while (gsVar.hasNext()) {
                hcVar.add(((com.google.android.libraries.navigation.internal.qi.d) gsVar.next()).a());
            }
            gs gsVar2 = new gs(gtVar);
            while (gsVar2.hasNext()) {
                com.google.android.libraries.navigation.internal.qi.e eVar = (com.google.android.libraries.navigation.internal.qi.e) gsVar2.next();
                cd cdVarC2 = this.f548n.c(eVar.a(), xVar);
                for (int i8 = 0; i8 < i && cdVarC2 != null; i8++) {
                    if (hcVar.contains(cdVarC2)) {
                        gsVar2.remove();
                        eVar.s();
                        break;
                    }
                    cdVarC2 = this.f548n.c(cdVarC2, xVar);
                }
            }
        }
        if (this.F != null && this.c.equals(com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE)) {
            com.google.android.libraries.navigation.internal.km.ab abVar = (com.google.android.libraries.navigation.internal.km.ab) this.F.a(com.google.android.libraries.navigation.internal.km.p.t);
            gs gsVar3 = new gs((gt) set);
            int i9 = Integer.MAX_VALUE;
            while (gsVar3.hasNext()) {
                int iH = ((com.google.android.libraries.navigation.internal.qi.d) gsVar3.next()).h();
                if (i9 == Integer.MAX_VALUE) {
                    i9 = iH;
                } else if (i9 != iH) {
                    if (!abVar.e()) {
                        abVar.b();
                    }
                }
            }
            if (abVar.e()) {
                abVar.c();
            }
        }
        return z;
    }

    protected void s(Set set) {
    }

    public final com.google.android.libraries.navigation.internal.qi.f t() {
        return this.g.e();
    }

    public final String toString() {
        ak akVarB = al.b(this);
        akVarB.g("paintTileType", this.c);
        akVarB.g("drawMode", u());
        akVarB.g("fetcher", this.g);
        return akVarB.e("allowMultiZoom", this.a).c("tileSize", 256).e("isContributingLabels", this.r).c("maxTileSize", this.b).toString();
    }

    public final com.google.android.libraries.navigation.internal.qq.f u() {
        return this.g.b;
    }

    public final synchronized void v() {
        this.g.j();
        z();
    }

    public final void w(w wVar) {
        ArrayList arrayList;
        com.google.android.libraries.navigation.internal.qi.f fVarT = wVar.t();
        com.google.android.libraries.navigation.internal.qi.f fVarT2 = t();
        if (fVarT == null || fVarT2 == null) {
            return;
        }
        Iterator it2 = this.D.d(fVarT, fVarT2, wVar.y).iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.qi.d dVarB = this.D.b(fVarT2, (cd) it2.next(), false);
            if (dVarB != null) {
                dVarB.v();
            }
        }
        synchronized (wVar.Q) {
            arrayList = new ArrayList();
            M(wVar.Q, arrayList);
        }
        synchronized (this.Q) {
            this.Q.addAll(arrayList);
            arrayList.clear();
        }
    }

    public final void x(boolean z) {
        this.w = z;
        this.o = z;
    }

    protected final void y() {
        if (this.f548n == null) {
            p(this.v.a(this.c, this.b, this.a, this.O));
        }
    }

    public final void z() {
        this.o = true;
        this.s = false;
        this.ae.c(Boolean.valueOf(K()));
        this.A.o();
    }
}
