package com.google.android.apps.gmm.location.navigation;

import android.app.ActivityManager;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.environment.df;
import com.google.android.libraries.navigation.internal.agg.es;
import j$.time.Duration;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public class al implements bg, com.google.android.libraries.navigation.internal.dd.c {
    private static final com.google.android.libraries.navigation.internal.zb.j S = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.apps.gmm.location.navigation.al");
    private static final com.google.android.libraries.navigation.internal.ady.al T = com.google.android.libraries.navigation.internal.ady.al.WALK;
    ao A;
    public volatile boolean C;
    long E;
    public Location G;
    public com.google.android.libraries.navigation.internal.db.r H;
    public com.google.android.libraries.navigation.internal.db.r I;
    public final com.google.android.libraries.navigation.internal.dd.d M;
    public final ai N;
    public final ah O;
    public final com.google.android.libraries.navigation.internal.agl.a P;
    public com.google.android.libraries.navigation.internal.acu.ax Q;
    public final df R;
    private long U;
    private es V;
    private long W;
    private final bf X;
    private final br Y;
    private final aj Z;
    public final Context a;
    private final ak aa;
    private final com.google.android.libraries.navigation.internal.bf.d ab;
    private final com.google.android.libraries.navigation.internal.sf.b ac;
    private final l ad;
    private com.google.android.libraries.navigation.internal.dh.ab ae;
    private boolean af;
    private com.google.android.libraries.navigation.internal.cw.d ag;
    private int ah;
    private long ai;
    private com.google.android.libraries.navigation.internal.db.r ak;
    private boolean al;
    private final SecureRandom am;
    private long an;
    private com.google.android.libraries.navigation.internal.zr.d ao;
    public final ar b;
    public final cc c;
    public final bn d;
    public final n e;
    public final g f;
    final y g;
    public final bi h;
    public final com.google.android.libraries.navigation.internal.kl.a i;
    public final com.google.android.libraries.navigation.internal.mj.a j;
    public final com.google.android.libraries.navigation.internal.rw.q k;
    public final com.google.android.libraries.navigation.internal.rw.f l;
    public final com.google.android.libraries.navigation.internal.ia.e m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.libraries.navigation.internal.ia.b f39n;
    public final com.google.android.libraries.navigation.internal.fz.d o;
    public final com.google.android.libraries.navigation.internal.aac.bn p;
    public final bu q;
    public com.google.android.libraries.navigation.internal.bp.bh t;
    public final b u;
    public final o v;
    public final cd w;
    public final e x;
    public final i y;
    public final s z;
    public com.google.android.libraries.navigation.internal.ady.al r = T;
    public boolean s = false;
    public long B = -4611686018427387904L;
    public boolean D = true;
    public Future F = com.google.android.libraries.navigation.internal.aac.az.f();
    private long aj = -3000;
    public final boolean J = false;
    public final List K = new ArrayList();
    public boolean L = false;

    public al(Context context, com.google.android.libraries.navigation.internal.agl.a aVar, aj ajVar, ak akVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.yx.an anVar, com.google.android.libraries.navigation.internal.rw.q qVar, com.google.android.libraries.navigation.internal.rw.f fVar, com.google.android.libraries.navigation.internal.bf.d dVar2, com.google.android.libraries.navigation.internal.sf.b bVar, com.google.android.libraries.navigation.internal.sf.d dVar3, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.ia.b bVar2, com.google.android.libraries.navigation.internal.mj.a aVar2, com.google.android.libraries.navigation.internal.aac.bn bnVar, Executor executor, Looper looper, Executor executor2, com.google.android.libraries.navigation.internal.kl.a aVar3, com.google.android.libraries.navigation.internal.yx.an anVar2, com.google.android.libraries.navigation.internal.gq.p pVar, com.google.android.libraries.navigation.internal.iv.f fVar2, com.google.android.libraries.navigation.internal.fu.a aVar4, df dfVar, com.google.android.libraries.navigation.internal.dd.d dVar4) {
        this.C = true;
        SecureRandom secureRandom = new SecureRandom();
        this.am = secureRandom;
        this.an = 0L;
        this.Q = (com.google.android.libraries.navigation.internal.acu.ax) com.google.android.libraries.navigation.internal.acu.ay.a.q();
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("LocationPipeline - constructor");
        try {
            this.Z = ajVar;
            this.a = context;
            this.P = aVar;
            this.aa = akVar;
            this.k = qVar;
            this.l = fVar;
            this.ab = dVar2;
            this.ac = bVar;
            this.m = eVar;
            this.f39n = bVar2;
            this.o = dVar;
            this.p = bnVar;
            this.i = aVar3;
            this.j = aVar2;
            this.u = new b();
            this.R = dfVar;
            this.M = dVar4;
            l lVar = new l(dVar.b().a.aM ? secureRandom.nextLong() : 0L);
            this.ad = lVar;
            bu buVar = (bu) anVar2.f();
            this.q = buVar;
            this.N = new ai(this);
            this.O = new ah(this);
            if (pVar != null) {
                this.c = new cc(context, fVar2, pVar, executor2);
            } else {
                this.c = null;
            }
            this.d = new bn(aVar2, aVar3, lVar);
            this.e = new n(aVar2);
            this.f = new g(aVar2, aVar3, lVar);
            this.b = new ar(aVar2);
            this.X = new bf(aVar3);
            this.Y = new br(aVar2);
            this.h = new bi();
            this.C = m.a(context);
            this.g = new v(aVar2, aVar3, eVar, buVar, dVar, new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.apps.gmm.location.navigation.ad
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return com.google.android.libraries.navigation.internal.acu.p.a;
                }
            }, qVar, Locale.getDefault().toLanguageTag(), aVar4.b(), bVar2, bnVar, dVar2, dVar3, executor, lVar, anVar);
            this.U = com.google.android.libraries.navigation.internal.zw.b.c(lVar.a("location_pipeline_gps_timeout_ms", 1300.0d, 50.0d), RoundingMode.HALF_EVEN);
            this.v = new o(aVar2);
            this.w = new cd(aVar2, eVar, aVar3);
            this.x = new e(aVar2);
            this.y = new i(aVar2);
            this.z = new s(aVar2, eVar, bVar2, aVar3, dVar);
            dVar.p();
            new k();
            try {
                context.getContentResolver().registerContentObserver(m.a, true, new ag(this, new Handler(looper), context));
            } catch (RuntimeException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(203)).p("Failed to register a content observer for 'Use My Location' setting");
            }
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

    /* JADX WARN: Code duplicated, block: B:100:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:103:0x0208 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:107:0x0213  */
    /* JADX WARN: Code duplicated, block: B:110:0x021b  */
    /* JADX WARN: Code duplicated, block: B:125:0x024c  */
    /* JADX WARN: Code duplicated, block: B:127:0x0256  */
    /* JADX WARN: Code duplicated, block: B:129:0x0267  */
    /* JADX WARN: Code duplicated, block: B:130:0x026e  */
    /* JADX WARN: Code duplicated, block: B:133:0x0273  */
    /* JADX WARN: Code duplicated, block: B:136:0x027f  */
    /* JADX WARN: Code duplicated, block: B:143:0x029c  */
    /* JADX WARN: Code duplicated, block: B:145:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:151:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:155:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:157:0x02da  */
    /* JADX WARN: Code duplicated, block: B:160:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:163:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:166:0x030e  */
    /* JADX WARN: Code duplicated, block: B:169:0x034e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:170:0x0350  */
    /* JADX WARN: Code duplicated, block: B:172:0x0356  */
    /* JADX WARN: Code duplicated, block: B:173:0x0358 A[Catch: all -> 0x03e4, TRY_ENTER, TryCatch #0 {all -> 0x03e4, blocks: (B:167:0x0314, B:173:0x0358, B:175:0x0360, B:176:0x0363, B:178:0x0370, B:183:0x03aa, B:179:0x037c, B:181:0x0396, B:182:0x03a2), top: B:215:0x0314 }] */
    /* JADX WARN: Code duplicated, block: B:178:0x0370 A[Catch: all -> 0x03e4, TryCatch #0 {all -> 0x03e4, blocks: (B:167:0x0314, B:173:0x0358, B:175:0x0360, B:176:0x0363, B:178:0x0370, B:183:0x03aa, B:179:0x037c, B:181:0x0396, B:182:0x03a2), top: B:215:0x0314 }] */
    /* JADX WARN: Code duplicated, block: B:179:0x037c A[Catch: all -> 0x03e4, TryCatch #0 {all -> 0x03e4, blocks: (B:167:0x0314, B:173:0x0358, B:175:0x0360, B:176:0x0363, B:178:0x0370, B:183:0x03aa, B:179:0x037c, B:181:0x0396, B:182:0x03a2), top: B:215:0x0314 }] */
    /* JADX WARN: Code duplicated, block: B:181:0x0396 A[Catch: all -> 0x03e4, TryCatch #0 {all -> 0x03e4, blocks: (B:167:0x0314, B:173:0x0358, B:175:0x0360, B:176:0x0363, B:178:0x0370, B:183:0x03aa, B:179:0x037c, B:181:0x0396, B:182:0x03a2), top: B:215:0x0314 }] */
    /* JADX WARN: Code duplicated, block: B:182:0x03a2 A[Catch: all -> 0x03e4, TryCatch #0 {all -> 0x03e4, blocks: (B:167:0x0314, B:173:0x0358, B:175:0x0360, B:176:0x0363, B:178:0x0370, B:183:0x03aa, B:179:0x037c, B:181:0x0396, B:182:0x03a2), top: B:215:0x0314 }] */
    /* JADX WARN: Code duplicated, block: B:185:0x03df  */
    /* JADX WARN: Code duplicated, block: B:195:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:197:0x03f5  */
    /* JADX WARN: Code duplicated, block: B:198:0x03f9  */
    /* JADX WARN: Code duplicated, block: B:200:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:208:0x0426  */
    /* JADX WARN: Code duplicated, block: B:210:0x0429  */
    /* JADX WARN: Code duplicated, block: B:212:0x0442  */
    /* JADX WARN: Code duplicated, block: B:40:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:53:0x011c  */
    /* JADX WARN: Code duplicated, block: B:60:0x0148  */
    /* JADX WARN: Code duplicated, block: B:62:0x0169  */
    /* JADX WARN: Code duplicated, block: B:63:0x016c  */
    /* JADX WARN: Code duplicated, block: B:66:0x017d  */
    /* JADX WARN: Code duplicated, block: B:67:0x018b  */
    /* JADX WARN: Code duplicated, block: B:70:0x0193  */
    /* JADX WARN: Code duplicated, block: B:72:0x019b  */
    /* JADX WARN: Code duplicated, block: B:75:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:77:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:79:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:86:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:89:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:94:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:97:0x01e8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:98:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:99:0x01f7 A[DONT_INVERT] */
    private final void p(com.google.android.libraries.navigation.internal.db.q qVar, Location location) {
        n nVar;
        long jA;
        String str;
        long j;
        double d;
        double dExp;
        com.google.android.libraries.navigation.internal.db.q qVar2;
        com.google.android.libraries.navigation.internal.db.r rVarA;
        bu buVar;
        com.google.android.libraries.navigation.internal.db.q qVarB;
        Object objA;
        com.google.android.libraries.navigation.internal.nw.d dVarB;
        com.google.android.libraries.navigation.internal.pt.d dVar;
        br brVar;
        long millis;
        ar arVar;
        String str2;
        String str3;
        boolean z;
        boolean z2;
        o oVar;
        long jA2;
        int i;
        cd cdVar;
        e eVar;
        if (qVar.l()) {
            long jA3 = this.j.a();
            if (qVar.k() && com.google.android.libraries.navigation.internal.ja.a.a(qVar.g()) > jA3) {
                this.j.a();
                com.google.android.libraries.navigation.internal.ja.a.a(qVar.g());
                this.j.a();
                qVar.k = Duration.ofMillis(jA3);
            }
            com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
            if (this.D || this.C) {
                return;
            }
            boolean z3 = false;
            if (location.getElapsedRealtimeNanos() != 0 && !location.isFromMockProvider()) {
                long jA4 = this.j.a();
                long millis2 = jA4 - TimeUnit.NANOSECONDS.toMillis(location.getElapsedRealtimeNanos());
                if (millis2 > 4000 && millis2 < 60000 && jA4 - this.E < 333) {
                    Double dValueOf = Double.valueOf(millis2 * 0.001d);
                    int i2 = this.ah + 2;
                    this.ah = i2;
                    if (i2 <= 50 || this.ai <= 500) {
                        return;
                    }
                    ((com.google.android.libraries.navigation.internal.zb.h) S.d(com.google.android.libraries.navigation.internal.nl.a.a).F(244)).y("Location processing backlogged by %f sec, and last snap took %f sec (last output %f sec ago).", dValueOf, Double.valueOf(this.ai * 0.001d), Double.valueOf((jA4 - this.E) * 0.001d));
                    return;
                }
                this.ah = Math.max(0, this.ah - 1);
            }
            String provider = location.getProvider();
            cc ccVar = this.c;
            if (ccVar != null) {
                ccVar.a(qVar);
            }
            if (!"gps".equals(provider) && !"Car-GPS".equals(provider)) {
                str = "Car-GPS";
                arVar = this.b;
                str2 = qVar.a;
                if ("geoa".equals(str2)) {
                    arVar.a("geoa");
                    arVar.a("Any GPS");
                    qVar.r(true);
                    qVar.q();
                } else if (arVar.b("geoa")) {
                    if (!"network".equals(str2)) {
                        if ("gps".equals(str2)) {
                            str3 = str;
                        } else {
                            str3 = str;
                            if (str3.equals(str2)) {
                            }
                            if (z) {
                                z2 = false;
                            } else {
                                z2 = false;
                            }
                            if ("bluewave".equals(str2)) {
                                if (z) {
                                    arVar.a("Any GPS");
                                    qVar.r(z2);
                                    qVar.q();
                                }
                                if (str3.equals(str2)) {
                                    arVar.a(str3);
                                }
                                if (!str3.equals(str2)) {
                                }
                            } else if (z2) {
                                arVar.a("bluewave");
                                arVar.a("Any GPS");
                                qVar.r(true);
                                qVar.q();
                            }
                        }
                        z = true;
                        if (z) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        if ("bluewave".equals(str2)) {
                            if (z) {
                                arVar.a("Any GPS");
                                qVar.r(z2);
                                qVar.q();
                            }
                            if (str3.equals(str2)) {
                                arVar.a(str3);
                            }
                            if (!str3.equals(str2)) {
                            }
                        } else if (z2) {
                            arVar.a("bluewave");
                            arVar.a("Any GPS");
                            qVar.r(true);
                            qVar.q();
                        }
                    } else if (!arVar.b("Any GPS")) {
                    }
                    if (qVar2 != null) {
                        if (qVar2.u) {
                            this.aj = this.j.a();
                        }
                        rVarA = qVar2.a();
                        this.H = rVarA;
                        buVar = this.q;
                        if (buVar != null) {
                            buVar.d(rVarA);
                        }
                        if (q(qVar2)) {
                            this.B = this.j.e().toMillis();
                            this.af = true;
                            j();
                        }
                        if (this.g.i()) {
                            dVarB = com.google.android.libraries.navigation.internal.nw.e.b("LocationPipeline snapping");
                            br brVar2 = this.Y;
                            com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                            brVar2.c = brVar2.b.d().toMillis();
                            bh.a(qVar2, q(qVar2), this.r, this.Q);
                            dVar = qVar2.s;
                            this.j.a();
                            com.google.android.libraries.navigation.internal.ja.a.a(qVar2.g());
                            qVarB = b(com.google.android.libraries.navigation.internal.ja.a.a(qVar2.g()));
                            if (qVarB == null) {
                                if (dVarB != null) {
                                    Trace.endSection();
                                }
                                qVarB = null;
                            } else {
                                if (dVar != null) {
                                    qVarB.t(dVar);
                                }
                                f(qVarB);
                                brVar = this.Y;
                                if (brVar.c < 0) {
                                    ((com.google.android.libraries.navigation.internal.zb.h) br.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 286)).p("Cannot get snapping duration without starting timing.");
                                } else {
                                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                    millis = brVar.b.d().toMillis() - brVar.c;
                                    brVar.c = 0L;
                                    if (millis < 0) {
                                        ((com.google.android.libraries.navigation.internal.zb.h) br.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 285)).p("Negative snapping duration.");
                                    } else {
                                        com.google.android.libraries.navigation.internal.db.ak akVarD = qVarB.d();
                                        com.google.android.libraries.navigation.internal.db.ak akVar = com.google.android.libraries.navigation.internal.db.ak.a;
                                        akVarD.l = millis;
                                    }
                                }
                                this.ai = qVarB.e().l;
                                ((com.google.android.libraries.navigation.internal.kk.l) this.i.a(com.google.android.libraries.navigation.internal.km.af.t)).a(this.ai);
                                ((com.google.android.libraries.navigation.internal.kk.l) this.i.a(com.google.android.libraries.navigation.internal.km.af.u)).a(this.j.a() - com.google.android.libraries.navigation.internal.ja.a.a(qVarB.g()));
                                if (dVarB != null) {
                                    Trace.endSection();
                                }
                            }
                            z3 = true;
                        } else {
                            qVarB = null;
                        }
                        if (qVarB == null) {
                            i(qVar2);
                        } else if (this.r != com.google.android.libraries.navigation.internal.ady.al.TRANSIT) {
                            objA = qVarB;
                        } else {
                            objA = qVarB;
                        }
                        if (z3) {
                            objA = qVar2;
                            this.I = ((com.google.android.libraries.navigation.internal.db.q) objA).a();
                        }
                        objA = qVar2;
                        com.google.android.libraries.navigation.internal.db.q qVar3 = (com.google.android.libraries.navigation.internal.db.q) objA;
                        qVar3.v(com.google.android.libraries.navigation.internal.db.t.c(location));
                        e(qVar3);
                        this.G = null;
                    } else {
                        this.G = location;
                    }
                    k();
                    d();
                    this.E = this.j.a();
                }
                if (this.g.i()) {
                    oVar = this.v;
                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                    jA2 = oVar.a.a();
                    if (qVar.w) {
                        oVar.d = jA2;
                        i = qVar.x;
                        oVar.b = true;
                    } else {
                        i = -1;
                    }
                    if (qVar.y) {
                        oVar.g = jA2;
                    }
                    long j2 = oVar.f;
                    if (o.f(jA2, -5000L)) {
                        oVar.c(jA2, i);
                    }
                    cdVar = this.w;
                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                    if (qVar.c().b) {
                        cdVar.e = cdVar.a.a();
                        if (qVar.m()) {
                            cdVar.j++;
                        }
                        boolean z4 = cdVar.i;
                        cdVar.i = false;
                    }
                    eVar = this.x;
                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                    if (qVar.c().b) {
                        eVar.g = true;
                        boolean z5 = eVar.c;
                    }
                    this.z.b(qVar);
                } else {
                    oVar = this.v;
                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                    jA2 = oVar.a.a();
                    if (qVar.w) {
                        oVar.d = jA2;
                        i = qVar.x;
                        oVar.b = true;
                    } else {
                        i = -1;
                    }
                    if (qVar.y) {
                        oVar.g = jA2;
                    }
                    long j3 = oVar.f;
                    if (o.f(jA2, -5000L)) {
                        oVar.c(jA2, i);
                    }
                    cdVar = this.w;
                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                    if (qVar.c().b) {
                        cdVar.e = cdVar.a.a();
                        if (qVar.m()) {
                            cdVar.j++;
                        }
                        boolean z6 = cdVar.i;
                        cdVar.i = false;
                    }
                    eVar = this.x;
                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                    if (qVar.c().b) {
                        eVar.g = true;
                        boolean z7 = eVar.c;
                    }
                    this.z.b(qVar);
                }
                qVar2 = qVar;
                if (qVar2 != null) {
                    if (qVar2.u) {
                        this.aj = this.j.a();
                    }
                    rVarA = qVar2.a();
                    this.H = rVarA;
                    buVar = this.q;
                    if (buVar != null) {
                        buVar.d(rVarA);
                    }
                    if (q(qVar2)) {
                        this.B = this.j.e().toMillis();
                        this.af = true;
                        j();
                    }
                    if (this.g.i()) {
                        dVarB = com.google.android.libraries.navigation.internal.nw.e.b("LocationPipeline snapping");
                        br brVar3 = this.Y;
                        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                        brVar3.c = brVar3.b.d().toMillis();
                        bh.a(qVar2, q(qVar2), this.r, this.Q);
                        dVar = qVar2.s;
                        this.j.a();
                        com.google.android.libraries.navigation.internal.ja.a.a(qVar2.g());
                        qVarB = b(com.google.android.libraries.navigation.internal.ja.a.a(qVar2.g()));
                        if (qVarB == null) {
                            if (dVarB != null) {
                                Trace.endSection();
                            }
                            qVarB = null;
                        } else {
                            if (dVar != null) {
                                qVarB.t(dVar);
                            }
                            f(qVarB);
                            brVar = this.Y;
                            if (brVar.c < 0) {
                                ((com.google.android.libraries.navigation.internal.zb.h) br.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 286)).p("Cannot get snapping duration without starting timing.");
                            } else {
                                com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                millis = brVar.b.d().toMillis() - brVar.c;
                                brVar.c = 0L;
                                if (millis < 0) {
                                    ((com.google.android.libraries.navigation.internal.zb.h) br.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 285)).p("Negative snapping duration.");
                                } else {
                                    com.google.android.libraries.navigation.internal.db.ak akVarD2 = qVarB.d();
                                    com.google.android.libraries.navigation.internal.db.ak akVar2 = com.google.android.libraries.navigation.internal.db.ak.a;
                                    akVarD2.l = millis;
                                }
                            }
                            this.ai = qVarB.e().l;
                            ((com.google.android.libraries.navigation.internal.kk.l) this.i.a(com.google.android.libraries.navigation.internal.km.af.t)).a(this.ai);
                            ((com.google.android.libraries.navigation.internal.kk.l) this.i.a(com.google.android.libraries.navigation.internal.km.af.u)).a(this.j.a() - com.google.android.libraries.navigation.internal.ja.a.a(qVarB.g()));
                            if (dVarB != null) {
                                Trace.endSection();
                            }
                        }
                        z3 = true;
                    } else {
                        qVarB = null;
                    }
                    if (qVarB == null) {
                        i(qVar2);
                    } else if (this.r != com.google.android.libraries.navigation.internal.ady.al.TRANSIT) {
                        objA = qVarB;
                    } else {
                        objA = qVarB;
                    }
                    if (z3) {
                        objA = qVar2;
                        this.I = ((com.google.android.libraries.navigation.internal.db.q) objA).a();
                    }
                    objA = qVar2;
                    com.google.android.libraries.navigation.internal.db.q qVar4 = (com.google.android.libraries.navigation.internal.db.q) objA;
                    qVar4.v(com.google.android.libraries.navigation.internal.db.t.c(location));
                    e(qVar4);
                    this.G = null;
                } else {
                    this.G = location;
                }
                k();
                d();
                this.E = this.j.a();
            }
            if (!"gps".equals(provider)) {
                nVar = this.e;
                if (qVar.d <= 96.0f) {
                    jA = nVar.d.a();
                    str = "Car-GPS";
                    j = nVar.a;
                    if (j > 0) {
                        float f = qVar.d;
                        nVar.b = Math.min(60.0f, f + f);
                        nVar.c = jA;
                    }
                    nVar.a = jA;
                    d = nVar.b;
                    if (d > 0.0d) {
                        dExp = d * Math.exp((Math.log(0.5d) * ((jA - nVar.c) / 1000.0d)) / 10.0d);
                        if (dExp < qVar.d) {
                            nVar.b = 0.0d;
                        } else {
                            qVar.d = (float) dExp;
                        }
                    }
                } else {
                    str = "Car-GPS";
                }
                arVar = this.b;
                str2 = qVar.a;
                if ("geoa".equals(str2)) {
                    arVar.a("geoa");
                    arVar.a("Any GPS");
                    qVar.r(true);
                    qVar.q();
                } else if (arVar.b("geoa")) {
                    if (!"network".equals(str2)) {
                        if ("gps".equals(str2)) {
                            str3 = str;
                            if (str3.equals(str2)) {
                            }
                            if (z) {
                                z2 = false;
                            } else {
                                z2 = false;
                            }
                            if ("bluewave".equals(str2)) {
                                if (z) {
                                    arVar.a("Any GPS");
                                    qVar.r(z2);
                                    qVar.q();
                                }
                                if (str3.equals(str2)) {
                                    arVar.a(str3);
                                }
                                if (!str3.equals(str2)) {
                                }
                            } else if (z2) {
                                arVar.a("bluewave");
                                arVar.a("Any GPS");
                                qVar.r(true);
                                qVar.q();
                            }
                        } else {
                            str3 = str;
                        }
                        z = true;
                        if (z) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        if ("bluewave".equals(str2)) {
                            if (z) {
                                arVar.a("Any GPS");
                                qVar.r(z2);
                                qVar.q();
                            }
                            if (str3.equals(str2)) {
                                arVar.a(str3);
                            }
                            if (!str3.equals(str2)) {
                            }
                        } else if (z2) {
                            arVar.a("bluewave");
                            arVar.a("Any GPS");
                            qVar.r(true);
                            qVar.q();
                        }
                    } else if (!arVar.b("Any GPS")) {
                    }
                    if (qVar2 != null) {
                        if (qVar2.u) {
                            this.aj = this.j.a();
                        }
                        rVarA = qVar2.a();
                        this.H = rVarA;
                        buVar = this.q;
                        if (buVar != null) {
                            buVar.d(rVarA);
                        }
                        if (q(qVar2)) {
                            this.B = this.j.e().toMillis();
                            this.af = true;
                            j();
                        }
                        if (this.g.i()) {
                            dVarB = com.google.android.libraries.navigation.internal.nw.e.b("LocationPipeline snapping");
                            br brVar4 = this.Y;
                            com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                            brVar4.c = brVar4.b.d().toMillis();
                            bh.a(qVar2, q(qVar2), this.r, this.Q);
                            dVar = qVar2.s;
                            this.j.a();
                            com.google.android.libraries.navigation.internal.ja.a.a(qVar2.g());
                            qVarB = b(com.google.android.libraries.navigation.internal.ja.a.a(qVar2.g()));
                            if (qVarB == null) {
                                if (dVarB != null) {
                                    Trace.endSection();
                                }
                                qVarB = null;
                            } else {
                                if (dVar != null) {
                                    qVarB.t(dVar);
                                }
                                f(qVarB);
                                brVar = this.Y;
                                if (brVar.c < 0) {
                                    ((com.google.android.libraries.navigation.internal.zb.h) br.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 286)).p("Cannot get snapping duration without starting timing.");
                                } else {
                                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                    millis = brVar.b.d().toMillis() - brVar.c;
                                    brVar.c = 0L;
                                    if (millis < 0) {
                                        ((com.google.android.libraries.navigation.internal.zb.h) br.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 285)).p("Negative snapping duration.");
                                    } else {
                                        com.google.android.libraries.navigation.internal.db.ak akVarD3 = qVarB.d();
                                        com.google.android.libraries.navigation.internal.db.ak akVar3 = com.google.android.libraries.navigation.internal.db.ak.a;
                                        akVarD3.l = millis;
                                    }
                                }
                                this.ai = qVarB.e().l;
                                ((com.google.android.libraries.navigation.internal.kk.l) this.i.a(com.google.android.libraries.navigation.internal.km.af.t)).a(this.ai);
                                ((com.google.android.libraries.navigation.internal.kk.l) this.i.a(com.google.android.libraries.navigation.internal.km.af.u)).a(this.j.a() - com.google.android.libraries.navigation.internal.ja.a.a(qVarB.g()));
                                if (dVarB != null) {
                                    Trace.endSection();
                                }
                            }
                            z3 = true;
                        } else {
                            qVarB = null;
                        }
                        if (qVarB == null) {
                            i(qVar2);
                        } else if (this.r != com.google.android.libraries.navigation.internal.ady.al.TRANSIT) {
                            objA = qVarB;
                        } else {
                            objA = qVarB;
                        }
                        if (z3) {
                            objA = qVar2;
                            this.I = ((com.google.android.libraries.navigation.internal.db.q) objA).a();
                        }
                        objA = qVar2;
                        com.google.android.libraries.navigation.internal.db.q qVar5 = (com.google.android.libraries.navigation.internal.db.q) objA;
                        qVar5.v(com.google.android.libraries.navigation.internal.db.t.c(location));
                        e(qVar5);
                        this.G = null;
                    } else {
                        this.G = location;
                    }
                    k();
                    d();
                    this.E = this.j.a();
                }
                if (this.g.i()) {
                    oVar = this.v;
                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                    jA2 = oVar.a.a();
                    if (qVar.w) {
                        oVar.d = jA2;
                        i = qVar.x;
                        oVar.b = true;
                    } else {
                        i = -1;
                    }
                    if (qVar.y) {
                        oVar.g = jA2;
                    }
                    long j4 = oVar.f;
                    if (o.f(jA2, -5000L)) {
                        oVar.c(jA2, i);
                    }
                    cdVar = this.w;
                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                    if (qVar.c().b) {
                        cdVar.e = cdVar.a.a();
                        if (qVar.m()) {
                            cdVar.j++;
                        }
                        boolean z8 = cdVar.i;
                        cdVar.i = false;
                    }
                    eVar = this.x;
                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                    if (qVar.c().b) {
                        eVar.g = true;
                        boolean z9 = eVar.c;
                    }
                    this.z.b(qVar);
                } else {
                    oVar = this.v;
                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                    jA2 = oVar.a.a();
                    if (qVar.w) {
                        oVar.d = jA2;
                        i = qVar.x;
                        oVar.b = true;
                    } else {
                        i = -1;
                    }
                    if (qVar.y) {
                        oVar.g = jA2;
                    }
                    long j5 = oVar.f;
                    if (o.f(jA2, -5000L)) {
                        oVar.c(jA2, i);
                    }
                    cdVar = this.w;
                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                    if (qVar.c().b) {
                        cdVar.e = cdVar.a.a();
                        if (qVar.m()) {
                            cdVar.j++;
                        }
                        boolean z10 = cdVar.i;
                        cdVar.i = false;
                    }
                    eVar = this.x;
                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                    if (qVar.c().b) {
                        eVar.g = true;
                        boolean z11 = eVar.c;
                    }
                    this.z.b(qVar);
                }
                qVar2 = qVar;
                if (qVar2 != null) {
                    if (qVar2.u) {
                        this.aj = this.j.a();
                    }
                    rVarA = qVar2.a();
                    this.H = rVarA;
                    buVar = this.q;
                    if (buVar != null) {
                        buVar.d(rVarA);
                    }
                    if (q(qVar2)) {
                        this.B = this.j.e().toMillis();
                        this.af = true;
                        j();
                    }
                    if (this.g.i()) {
                        dVarB = com.google.android.libraries.navigation.internal.nw.e.b("LocationPipeline snapping");
                        br brVar5 = this.Y;
                        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                        brVar5.c = brVar5.b.d().toMillis();
                        bh.a(qVar2, q(qVar2), this.r, this.Q);
                        dVar = qVar2.s;
                        this.j.a();
                        com.google.android.libraries.navigation.internal.ja.a.a(qVar2.g());
                        qVarB = b(com.google.android.libraries.navigation.internal.ja.a.a(qVar2.g()));
                        if (qVarB == null) {
                            if (dVarB != null) {
                                Trace.endSection();
                            }
                            qVarB = null;
                        } else {
                            if (dVar != null) {
                                qVarB.t(dVar);
                            }
                            f(qVarB);
                            brVar = this.Y;
                            if (brVar.c < 0) {
                                ((com.google.android.libraries.navigation.internal.zb.h) br.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 286)).p("Cannot get snapping duration without starting timing.");
                            } else {
                                com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                millis = brVar.b.d().toMillis() - brVar.c;
                                brVar.c = 0L;
                                if (millis < 0) {
                                    ((com.google.android.libraries.navigation.internal.zb.h) br.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 285)).p("Negative snapping duration.");
                                } else {
                                    com.google.android.libraries.navigation.internal.db.ak akVarD4 = qVarB.d();
                                    com.google.android.libraries.navigation.internal.db.ak akVar4 = com.google.android.libraries.navigation.internal.db.ak.a;
                                    akVarD4.l = millis;
                                }
                            }
                            this.ai = qVarB.e().l;
                            ((com.google.android.libraries.navigation.internal.kk.l) this.i.a(com.google.android.libraries.navigation.internal.km.af.t)).a(this.ai);
                            ((com.google.android.libraries.navigation.internal.kk.l) this.i.a(com.google.android.libraries.navigation.internal.km.af.u)).a(this.j.a() - com.google.android.libraries.navigation.internal.ja.a.a(qVarB.g()));
                            if (dVarB != null) {
                                Trace.endSection();
                            }
                        }
                        z3 = true;
                    } else {
                        qVarB = null;
                    }
                    if (qVarB == null) {
                        i(qVar2);
                    } else if (this.r != com.google.android.libraries.navigation.internal.ady.al.TRANSIT) {
                        objA = qVarB;
                    } else {
                        objA = qVarB;
                    }
                    if (z3) {
                        objA = qVar2;
                        this.I = ((com.google.android.libraries.navigation.internal.db.q) objA).a();
                    }
                    objA = qVar2;
                    com.google.android.libraries.navigation.internal.db.q qVar6 = (com.google.android.libraries.navigation.internal.db.q) objA;
                    qVar6.v(com.google.android.libraries.navigation.internal.db.t.c(location));
                    e(qVar6);
                    this.G = null;
                } else {
                    this.G = location;
                }
                k();
                d();
                this.E = this.j.a();
            }
            nVar = this.e;
            if (qVar.d <= 96.0f) {
                jA = nVar.d.a();
                str = "Car-GPS";
                j = nVar.a;
                if (j > 0 && jA - j > 60000) {
                    float f2 = qVar.d;
                    nVar.b = Math.min(60.0f, f2 + f2);
                    nVar.c = jA;
                }
                nVar.a = jA;
                d = nVar.b;
                if (d > 0.0d) {
                    dExp = d * Math.exp((Math.log(0.5d) * ((jA - nVar.c) / 1000.0d)) / 10.0d);
                    if (dExp < qVar.d) {
                        nVar.b = 0.0d;
                    } else {
                        qVar.d = (float) dExp;
                    }
                }
            } else {
                str = "Car-GPS";
            }
            arVar = this.b;
            str2 = qVar.a;
            if ("geoa".equals(str2)) {
                arVar.a("geoa");
                arVar.a("Any GPS");
                qVar.r(true);
                qVar.q();
            } else if (arVar.b("geoa")) {
                if (!"network".equals(str2)) {
                    if ("gps".equals(str2)) {
                        str3 = str;
                        if (str3.equals(str2) && !"bluewave".equals(str2)) {
                            String str4 = qVar.a;
                            int i3 = qVar.t;
                            int i4 = com.google.android.libraries.navigation.internal.db.r.r;
                            if (!com.google.android.libraries.navigation.internal.yx.am.a(str4, "fused") || i3 != 1) {
                                z = false;
                            }
                        }
                        if (z || !qVar.h() || qVar.d > 96.0f) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if ("bluewave".equals(str2)) {
                            if (z) {
                                arVar.a("Any GPS");
                                qVar.r(z2);
                                qVar.q();
                            }
                            if (str3.equals(str2) && z2) {
                                arVar.a(str3);
                            }
                            if ((!str3.equals(str2) || arVar.b("bluewave")) && (((str3.equals(str2) || arVar.b(str3)) && (!str3.equals(str2) || arVar.b("bluewave"))) || (qVar.m() && qVar.i >= 3.0d))) {
                            }
                        } else if (z2) {
                            arVar.a("bluewave");
                            arVar.a("Any GPS");
                            qVar.r(true);
                            qVar.q();
                        }
                    } else {
                        str3 = str;
                    }
                    z = true;
                    if (z) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    if ("bluewave".equals(str2)) {
                        if (z) {
                            arVar.a("Any GPS");
                            qVar.r(z2);
                            qVar.q();
                        }
                        if (str3.equals(str2)) {
                            arVar.a(str3);
                        }
                        if (!str3.equals(str2)) {
                        }
                    } else if (z2) {
                        arVar.a("bluewave");
                        arVar.a("Any GPS");
                        qVar.r(true);
                        qVar.q();
                    }
                } else if (!arVar.b("Any GPS")) {
                }
                if (qVar2 != null) {
                    if (qVar2.u) {
                        this.aj = this.j.a();
                    }
                    rVarA = qVar2.a();
                    this.H = rVarA;
                    buVar = this.q;
                    if (buVar != null) {
                        buVar.d(rVarA);
                    }
                    if (q(qVar2)) {
                        this.B = this.j.e().toMillis();
                        this.af = true;
                        j();
                    }
                    if (this.g.i()) {
                        dVarB = com.google.android.libraries.navigation.internal.nw.e.b("LocationPipeline snapping");
                        try {
                            br brVar6 = this.Y;
                            com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                            brVar6.c = brVar6.b.d().toMillis();
                            bh.a(qVar2, q(qVar2), this.r, this.Q);
                            dVar = qVar2.s;
                            this.j.a();
                            com.google.android.libraries.navigation.internal.ja.a.a(qVar2.g());
                            qVarB = b(com.google.android.libraries.navigation.internal.ja.a.a(qVar2.g()));
                            if (qVarB == null) {
                                if (dVarB != null) {
                                    Trace.endSection();
                                }
                                qVarB = null;
                            } else {
                                if (dVar != null && com.google.android.libraries.navigation.internal.pt.e.a(this.r)) {
                                    qVarB.t(dVar);
                                }
                                f(qVarB);
                                brVar = this.Y;
                                if (brVar.c < 0) {
                                    ((com.google.android.libraries.navigation.internal.zb.h) br.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 286)).p("Cannot get snapping duration without starting timing.");
                                } else {
                                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                    millis = brVar.b.d().toMillis() - brVar.c;
                                    brVar.c = 0L;
                                    if (millis < 0) {
                                        ((com.google.android.libraries.navigation.internal.zb.h) br.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 285)).p("Negative snapping duration.");
                                    } else {
                                        com.google.android.libraries.navigation.internal.db.ak akVarD5 = qVarB.d();
                                        com.google.android.libraries.navigation.internal.db.ak akVar5 = com.google.android.libraries.navigation.internal.db.ak.a;
                                        akVarD5.l = millis;
                                    }
                                }
                                this.ai = qVarB.e().l;
                                ((com.google.android.libraries.navigation.internal.kk.l) this.i.a(com.google.android.libraries.navigation.internal.km.af.t)).a(this.ai);
                                ((com.google.android.libraries.navigation.internal.kk.l) this.i.a(com.google.android.libraries.navigation.internal.km.af.u)).a(this.j.a() - com.google.android.libraries.navigation.internal.ja.a.a(qVarB.g()));
                                if (dVarB != null) {
                                    Trace.endSection();
                                }
                            }
                            z3 = true;
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
                    } else {
                        qVarB = null;
                    }
                    if (qVarB == null) {
                        i(qVar2);
                    } else if (this.r != com.google.android.libraries.navigation.internal.ady.al.TRANSIT || m()) {
                        objA = qVarB;
                    } else {
                        i(qVar2);
                        if (this.r == com.google.android.libraries.navigation.internal.ady.al.TRANSIT) {
                            com.google.android.libraries.navigation.internal.db.ak akVar6 = qVarB.m;
                            if (akVar6 != null) {
                                objA = qVar2;
                                qVar2.m = akVar6.a();
                                objA = qVar2;
                            }
                        } else {
                            qVarB.s(qVar2.b, qVar2.c);
                            objA = com.google.android.libraries.navigation.internal.db.ai.a(qVarB, null);
                        }
                    }
                    if (z3) {
                        objA = qVar2;
                        this.I = ((com.google.android.libraries.navigation.internal.db.q) objA).a();
                    }
                    objA = qVar2;
                    com.google.android.libraries.navigation.internal.db.q qVar7 = (com.google.android.libraries.navigation.internal.db.q) objA;
                    qVar7.v(com.google.android.libraries.navigation.internal.db.t.c(location));
                    e(qVar7);
                    this.G = null;
                } else {
                    this.G = location;
                }
                k();
                d();
                this.E = this.j.a();
            }
            if (this.g.i() || this.o.F().k) {
                oVar = this.v;
                com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                jA2 = oVar.a.a();
                if (qVar.w) {
                    oVar.d = jA2;
                    i = qVar.x;
                    oVar.b = true;
                } else {
                    i = -1;
                }
                if (qVar.y) {
                    oVar.g = jA2;
                }
                long j6 = oVar.f;
                if (o.f(jA2, -5000L) && o.f(jA2, oVar.e) && i != -1) {
                    oVar.c(jA2, i);
                }
                cdVar = this.w;
                com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                if (qVar.c().b) {
                    cdVar.e = cdVar.a.a();
                    if (qVar.m() && qVar.i > 10.0f) {
                        cdVar.j++;
                    }
                    boolean z12 = cdVar.i;
                    cdVar.i = false;
                }
                eVar = this.x;
                com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                if (qVar.c().b) {
                    eVar.g = true;
                    boolean z13 = eVar.c;
                }
                this.z.b(qVar);
            }
            qVar2 = qVar;
            if (qVar2 != null) {
                if (qVar2.u) {
                    this.aj = this.j.a();
                }
                rVarA = qVar2.a();
                this.H = rVarA;
                buVar = this.q;
                if (buVar != null) {
                    buVar.d(rVarA);
                }
                if (q(qVar2)) {
                    this.B = this.j.e().toMillis();
                    this.af = true;
                    j();
                }
                if (this.g.i()) {
                    dVarB = com.google.android.libraries.navigation.internal.nw.e.b("LocationPipeline snapping");
                    br brVar7 = this.Y;
                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                    brVar7.c = brVar7.b.d().toMillis();
                    bh.a(qVar2, q(qVar2), this.r, this.Q);
                    dVar = qVar2.s;
                    this.j.a();
                    com.google.android.libraries.navigation.internal.ja.a.a(qVar2.g());
                    qVarB = b(com.google.android.libraries.navigation.internal.ja.a.a(qVar2.g()));
                    if (qVarB == null) {
                        if (dVarB != null) {
                            Trace.endSection();
                        }
                        qVarB = null;
                    } else {
                        if (dVar != null) {
                            qVarB.t(dVar);
                        }
                        f(qVarB);
                        brVar = this.Y;
                        if (brVar.c < 0) {
                            ((com.google.android.libraries.navigation.internal.zb.h) br.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 286)).p("Cannot get snapping duration without starting timing.");
                        } else {
                            com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                            millis = brVar.b.d().toMillis() - brVar.c;
                            brVar.c = 0L;
                            if (millis < 0) {
                                ((com.google.android.libraries.navigation.internal.zb.h) br.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 285)).p("Negative snapping duration.");
                            } else {
                                com.google.android.libraries.navigation.internal.db.ak akVarD6 = qVarB.d();
                                com.google.android.libraries.navigation.internal.db.ak akVar7 = com.google.android.libraries.navigation.internal.db.ak.a;
                                akVarD6.l = millis;
                            }
                        }
                        this.ai = qVarB.e().l;
                        ((com.google.android.libraries.navigation.internal.kk.l) this.i.a(com.google.android.libraries.navigation.internal.km.af.t)).a(this.ai);
                        ((com.google.android.libraries.navigation.internal.kk.l) this.i.a(com.google.android.libraries.navigation.internal.km.af.u)).a(this.j.a() - com.google.android.libraries.navigation.internal.ja.a.a(qVarB.g()));
                        if (dVarB != null) {
                            Trace.endSection();
                        }
                    }
                    z3 = true;
                } else {
                    qVarB = null;
                }
                if (qVarB == null) {
                    i(qVar2);
                } else if (this.r != com.google.android.libraries.navigation.internal.ady.al.TRANSIT) {
                    objA = qVarB;
                } else {
                    objA = qVarB;
                }
                if (z3) {
                    objA = qVar2;
                    this.I = ((com.google.android.libraries.navigation.internal.db.q) objA).a();
                }
                objA = qVar2;
                com.google.android.libraries.navigation.internal.db.q qVar8 = (com.google.android.libraries.navigation.internal.db.q) objA;
                qVar8.v(com.google.android.libraries.navigation.internal.db.t.c(location));
                e(qVar8);
                this.G = null;
            } else {
                this.G = location;
            }
            k();
            d();
            this.E = this.j.a();
            qVar2 = null;
            if (qVar2 != null) {
                if (qVar2.u) {
                    this.aj = this.j.a();
                }
                rVarA = qVar2.a();
                this.H = rVarA;
                buVar = this.q;
                if (buVar != null) {
                    buVar.d(rVarA);
                }
                if (q(qVar2)) {
                    this.B = this.j.e().toMillis();
                    this.af = true;
                    j();
                }
                if (this.g.i()) {
                    dVarB = com.google.android.libraries.navigation.internal.nw.e.b("LocationPipeline snapping");
                    br brVar8 = this.Y;
                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                    brVar8.c = brVar8.b.d().toMillis();
                    bh.a(qVar2, q(qVar2), this.r, this.Q);
                    dVar = qVar2.s;
                    this.j.a();
                    com.google.android.libraries.navigation.internal.ja.a.a(qVar2.g());
                    qVarB = b(com.google.android.libraries.navigation.internal.ja.a.a(qVar2.g()));
                    if (qVarB == null) {
                        if (dVarB != null) {
                            Trace.endSection();
                        }
                        qVarB = null;
                    } else {
                        if (dVar != null) {
                            qVarB.t(dVar);
                        }
                        f(qVarB);
                        brVar = this.Y;
                        if (brVar.c < 0) {
                            ((com.google.android.libraries.navigation.internal.zb.h) br.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 286)).p("Cannot get snapping duration without starting timing.");
                        } else {
                            com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                            millis = brVar.b.d().toMillis() - brVar.c;
                            brVar.c = 0L;
                            if (millis < 0) {
                                ((com.google.android.libraries.navigation.internal.zb.h) br.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 285)).p("Negative snapping duration.");
                            } else {
                                com.google.android.libraries.navigation.internal.db.ak akVarD7 = qVarB.d();
                                com.google.android.libraries.navigation.internal.db.ak akVar8 = com.google.android.libraries.navigation.internal.db.ak.a;
                                akVarD7.l = millis;
                            }
                        }
                        this.ai = qVarB.e().l;
                        ((com.google.android.libraries.navigation.internal.kk.l) this.i.a(com.google.android.libraries.navigation.internal.km.af.t)).a(this.ai);
                        ((com.google.android.libraries.navigation.internal.kk.l) this.i.a(com.google.android.libraries.navigation.internal.km.af.u)).a(this.j.a() - com.google.android.libraries.navigation.internal.ja.a.a(qVarB.g()));
                        if (dVarB != null) {
                            Trace.endSection();
                        }
                    }
                    z3 = true;
                } else {
                    qVarB = null;
                }
                if (qVarB == null) {
                    i(qVar2);
                } else if (this.r != com.google.android.libraries.navigation.internal.ady.al.TRANSIT) {
                    objA = qVarB;
                } else {
                    objA = qVarB;
                }
                if (z3) {
                    objA = qVar2;
                    this.I = ((com.google.android.libraries.navigation.internal.db.q) objA).a();
                }
                objA = qVar2;
                com.google.android.libraries.navigation.internal.db.q qVar9 = (com.google.android.libraries.navigation.internal.db.q) objA;
                qVar9.v(com.google.android.libraries.navigation.internal.db.t.c(location));
                e(qVar9);
                this.G = null;
            } else {
                this.G = location;
            }
            k();
            d();
            this.E = this.j.a();
        }
    }

    private final boolean q(com.google.android.libraries.navigation.internal.db.q qVar) {
        if (!qVar.c().b && !qVar.c().d) {
            if (m()) {
                return false;
            }
            if (this.r == com.google.android.libraries.navigation.internal.ady.al.TRANSIT) {
                return this.o.V().b;
            }
        }
        return true;
    }

    public final com.google.android.libraries.navigation.internal.cy.h a() {
        return this.g.a();
    }

    public final com.google.android.libraries.navigation.internal.db.q b(long j) {
        if (((com.google.android.libraries.navigation.internal.acu.ay) this.Q.b).b.size() > 0) {
            this.g.c((com.google.android.libraries.navigation.internal.acu.ay) this.Q.t());
            this.Q = (com.google.android.libraries.navigation.internal.acu.ax) com.google.android.libraries.navigation.internal.acu.ay.a.q();
        }
        long jMax = Math.max(this.an, j);
        com.google.android.libraries.navigation.internal.db.q qVarB = this.g.b(jMax);
        this.an = jMax;
        if (qVarB == null) {
            return null;
        }
        return qVarB;
    }

    @Override // com.google.android.apps.gmm.location.navigation.bg
    public final void c(com.google.android.libraries.navigation.internal.acu.aw awVar) {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        this.Q.d(awVar);
    }

    public final void d() {
        ar arVar = this.b;
        com.google.android.libraries.navigation.internal.dh.ab abVar = (arVar.b("Car-GPS") && arVar.b("Any GPS")) ? com.google.android.libraries.navigation.internal.dh.ab.GPS_AND_NETWORK : com.google.android.libraries.navigation.internal.dh.ab.GPS;
        if (this.ae != abVar) {
            this.ae = abVar;
            this.aa.i(abVar);
        }
    }

    public final void e(com.google.android.libraries.navigation.internal.db.q qVar) {
        if (this.j.a() < this.aj + 3000) {
            qVar.u = true;
        }
        com.google.android.libraries.navigation.internal.db.r rVarA = qVar.a();
        if (rVarA.p) {
            com.google.android.libraries.navigation.internal.kk.k kVar = (com.google.android.libraries.navigation.internal.kk.k) this.i.a(com.google.android.libraries.navigation.internal.km.af.p);
            int i = com.google.android.libraries.navigation.internal.acu.ak.s;
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            kVar.a(i2);
        }
        if (rVarA.l().b()) {
            this.ao = rVarA.l().y;
        }
        bu buVar = this.q;
        if (buVar != null) {
            buVar.c();
        }
        com.google.android.libraries.navigation.internal.db.r rVar = this.ak;
        if (rVar == null) {
            this.ak = rVarA;
        } else if (rVar.n().l(rVarA.n()) > 500.0f) {
            this.al = true;
        }
        if (rVarA.B() && rVarA.r() && rVarA.d < 50.0f) {
            this.B = this.j.e().toMillis();
        }
        this.Z.h(rVarA);
        this.g.e(com.google.android.libraries.navigation.internal.ja.a.a(rVarA.g));
    }

    public final void f(com.google.android.libraries.navigation.internal.db.q qVar) {
        com.google.android.libraries.navigation.internal.acm.e eVar = this.ab.a().b;
        if (eVar == null) {
            eVar = com.google.android.libraries.navigation.internal.acm.e.b;
        }
        if (com.google.android.libraries.navigation.internal.bf.g.a(eVar)) {
            com.google.android.libraries.navigation.internal.db.m mVar = qVar.e().A;
            if (mVar != null) {
                qVar.d().B = mVar;
            }
            if (((com.google.android.libraries.navigation.internal.sg.a) this.ac.a().c()) != null) {
                long j = qVar.e().j;
            }
        }
    }

    public final void g(boolean z, boolean z2, boolean z3) {
        com.google.android.libraries.navigation.internal.cw.d dVar = this.ag;
        Duration duration = com.google.android.libraries.navigation.internal.cw.d.a;
        if (dVar == null || dVar.c != z || dVar.d != z2 || dVar.e != z3) {
            dVar = new com.google.android.libraries.navigation.internal.cw.d(z, z2, z3);
        }
        if (dVar != this.ag) {
            this.ag = dVar;
            this.m.a(dVar);
        }
    }

    public final void h(Location location) {
        p(com.google.android.libraries.navigation.internal.db.t.b(location), location);
    }

    public final void i(com.google.android.libraries.navigation.internal.db.q qVar) {
        bf bfVar = this.X;
        com.google.android.libraries.navigation.internal.db.r rVar = bfVar.b;
        bfVar.b = qVar.a();
        if (rVar != null && !qVar.m() && rVar.r() && rVar.d > 0.0f && qVar.h() && qVar.d > 0.0f) {
            float fL = rVar.n().l(qVar.f());
            double dA = com.google.android.libraries.navigation.internal.aaa.a.a(qVar.g().minus(rVar.g));
            if (dA > 0.0d && dA < 2.0d) {
                com.google.android.libraries.navigation.internal.db.p pVar = new com.google.android.libraries.navigation.internal.db.p(((double) fL) / dA, ((double) (rVar.d + qVar.d)) / dA);
                if (rVar.x()) {
                    com.google.android.libraries.navigation.internal.db.p pVar2 = new com.google.android.libraries.navigation.internal.db.p(rVar.f, (com.google.android.libraries.navigation.internal.dc.a.d.b * dA) + 1.0d);
                    double d = pVar2.b;
                    double d2 = pVar.b;
                    double d3 = pVar2.a;
                    double d4 = d2 * d2;
                    double d5 = d * d;
                    pVar = new com.google.android.libraries.navigation.internal.db.p(d3 + (((pVar.a - d3) * d5) / (d5 + d4)), Math.sqrt(1.0d / ((1.0d / d5) + (1.0d / d4))));
                }
                double d6 = pVar.a;
                double d7 = pVar.b;
                if (d7 < 3.0d * d6 && d7 < 5.0d) {
                    qVar.i = (float) d6;
                    ((com.google.android.libraries.navigation.internal.kk.k) bfVar.a.a(com.google.android.libraries.navigation.internal.km.af.o)).a(16);
                }
            }
        }
        synchronized (this.K) {
            Iterator it2 = this.K.iterator();
            while (it2.hasNext()) {
                ((com.google.android.libraries.navigation.internal.cw.i) it2.next()).a(qVar);
            }
        }
    }

    protected final void j() {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        this.F.cancel(false);
        this.F = this.p.schedule(new Runnable() { // from class: com.google.android.apps.gmm.location.navigation.ae
            @Override // java.lang.Runnable
            public final void run() {
                boolean z;
                al alVar = this.a;
                if (alVar.C) {
                    return;
                }
                com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("LocationPipeline lackOfGps");
                try {
                    bu buVar = alVar.q;
                    if (buVar != null) {
                        buVar.e();
                    }
                    try {
                        Context context = alVar.a;
                        z = !com.google.android.libraries.navigation.internal.iu.b.b(context, (ActivityManager) context.getSystemService("activity"));
                    } catch (com.google.android.libraries.navigation.internal.iu.a unused) {
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(239)).p("Can't check for foreground process status.");
                        z = false;
                    }
                    alVar.f39n.c(new com.google.android.libraries.navigation.internal.dh.y(z));
                    if (alVar.g.i()) {
                        long jA = alVar.j.a();
                        o oVar = alVar.v;
                        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                        long jA2 = oVar.a.a();
                        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                        if (o.e(jA2, oVar.d) && o.e(jA2, oVar.e)) {
                            long j = oVar.f;
                            if (o.e(jA2, -5000L)) {
                                com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                oVar.a(jA2, 0, Double.NaN);
                            }
                        }
                        com.google.android.libraries.navigation.internal.kk.k kVar = (com.google.android.libraries.navigation.internal.kk.k) alVar.i.a(com.google.android.libraries.navigation.internal.km.af.p);
                        int i = com.google.android.libraries.navigation.internal.acu.ak.i;
                        int i2 = i - 1;
                        if (i == 0) {
                            throw null;
                        }
                        kVar.a(i2);
                        if (z) {
                            com.google.android.libraries.navigation.internal.kk.k kVar2 = (com.google.android.libraries.navigation.internal.kk.k) alVar.i.a(com.google.android.libraries.navigation.internal.km.af.p);
                            int i3 = com.google.android.libraries.navigation.internal.acu.ak.j;
                            int i4 = i3 - 1;
                            if (i3 == 0) {
                                throw null;
                            }
                            kVar2.a(i4);
                        }
                        com.google.android.libraries.navigation.internal.db.q qVarB = alVar.b(jA);
                        if (qVarB != null) {
                            alVar.f(qVarB);
                            alVar.I = qVarB.a();
                            qVarB.v(null);
                            alVar.e(qVarB);
                            alVar.G = null;
                        } else {
                            com.google.android.libraries.navigation.internal.db.r rVar = alVar.I;
                            if (rVar != null && !com.google.android.libraries.navigation.internal.db.ar.b(rVar, alVar.j)) {
                                alVar.e(com.google.android.libraries.navigation.internal.db.r.j(alVar.I));
                                alVar.G = null;
                            }
                        }
                    }
                    Location location = alVar.G;
                    if (location != null) {
                        com.google.android.libraries.navigation.internal.db.q qVarB2 = com.google.android.libraries.navigation.internal.db.t.b(location);
                        cc ccVar = alVar.c;
                        if (ccVar != null) {
                            ccVar.a(qVarB2);
                        }
                        if (alVar.g.i()) {
                            bi biVar = alVar.h;
                            if (!qVarB2.e().b && !qVarB2.i() && biVar.b) {
                                qVarB2.g = biVar.a;
                            }
                            if (qVarB2.i()) {
                                biVar.a = qVarB2.g;
                                biVar.b = true;
                            }
                            if (alVar.m() && qVarB2.i() && (!qVarB2.m() || !com.google.android.libraries.navigation.internal.db.r.C(qVarB2.i(), qVarB2.i, qVarB2.e().b))) {
                                qVarB2.o();
                            }
                        } else {
                            alVar.i(qVarB2);
                        }
                        Location location2 = alVar.G;
                        qVarB2.v(location2 != null ? com.google.android.libraries.navigation.internal.db.t.c(location2) : null);
                        alVar.e(qVarB2);
                        alVar.G = null;
                    }
                    alVar.j();
                    alVar.k();
                    alVar.d();
                    if (dVarB != null) {
                        Trace.endSection();
                    }
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
        }, this.U, TimeUnit.MILLISECONDS);
    }

    public final void k() {
        long millis = this.j.e().toMillis();
        long j = millis - this.B;
        long millis2 = com.google.android.libraries.navigation.internal.cw.d.a.toMillis();
        long j2 = millis - this.B;
        long millis3 = com.google.android.libraries.navigation.internal.cw.d.b.toMillis();
        boolean z = this.af;
        boolean z2 = j2 >= millis3;
        if (!z) {
            z2 = this.al;
        }
        com.google.android.libraries.navigation.internal.db.r rVar = this.I;
        g(j < millis2, z2, rVar != null && rVar.l().d());
    }

    public final void l() {
        com.google.android.libraries.navigation.internal.bp.bh bhVar;
        com.google.android.libraries.navigation.internal.db.r rVar;
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        if (this.D) {
            return;
        }
        if (!this.s) {
            if (this.g.i()) {
                this.g.k(this.r, false, false);
                this.V = null;
                this.W = -1L;
                bu buVar = this.q;
                if (buVar != null) {
                    buVar.b();
                    return;
                }
                return;
            }
            return;
        }
        com.google.android.libraries.navigation.internal.mj.a aVar = this.j;
        y yVar = this.g;
        long jA = aVar.a();
        if (!yVar.i()) {
            this.af = false;
            this.al = false;
            this.ak = null;
        }
        if (this.g.k(this.r, true, false) && (rVar = this.H) != null) {
            com.google.android.libraries.navigation.internal.db.q qVarJ = com.google.android.libraries.navigation.internal.db.r.j(rVar);
            bh.a(qVarJ, q(qVarJ), this.r, this.Q);
        }
        if (!this.g.i() || (bhVar = this.t) == null) {
            return;
        }
        this.g.h(jA, bhVar);
        this.t = null;
    }

    public final boolean m() {
        return v.j(this.r);
    }

    @Override // com.google.android.libraries.navigation.internal.dd.c
    public final void n() {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        cd cdVar = this.w;
        cdVar.h = new ao(cdVar.b, 24);
        this.A = new ao(this.i, 26);
    }

    @Override // com.google.android.libraries.navigation.internal.dd.c
    public final void o() {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        cd cdVar = this.w;
        ao aoVar = cdVar.h;
        if (aoVar != null) {
            aoVar.a();
            cdVar.h = null;
        }
        ao aoVar2 = this.A;
        if (aoVar2 != null) {
            aoVar2.a();
            this.A = null;
        }
        com.google.android.libraries.navigation.internal.zr.d dVar = this.ao;
        if (dVar != null) {
            com.google.android.libraries.navigation.internal.kk.l lVar = (com.google.android.libraries.navigation.internal.kk.l) this.i.a(com.google.android.libraries.navigation.internal.km.af.r);
            Iterator it2 = dVar.b.iterator();
            while (it2.hasNext()) {
                lVar.a(((Long) it2.next()).longValue());
            }
            com.google.android.libraries.navigation.internal.kk.l lVar2 = (com.google.android.libraries.navigation.internal.kk.l) this.i.a(com.google.android.libraries.navigation.internal.km.af.s);
            Iterator it3 = dVar.c.iterator();
            while (it3.hasNext()) {
                lVar2.a(((Long) it3.next()).longValue());
            }
            this.ao = null;
        }
    }
}
