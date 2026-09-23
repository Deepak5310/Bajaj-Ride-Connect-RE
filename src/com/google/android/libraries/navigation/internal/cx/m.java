package com.google.android.libraries.navigation.internal.cx;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import androidx.tracing.Trace;
import com.drew.metadata.avi.AviDirectory;
import com.google.android.apps.gmm.jni.util.NativeHelper;
import com.google.android.apps.gmm.location.navigation.aj;
import com.google.android.apps.gmm.location.navigation.ak;
import com.google.android.apps.gmm.location.navigation.al;
import com.google.android.apps.gmm.location.navigation.cb;
import com.google.android.libraries.navigation.environment.df;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.acu.ch;
import com.google.android.libraries.navigation.internal.afl.cy;
import com.google.android.libraries.navigation.internal.afl.dr;
import com.google.android.libraries.navigation.internal.afl.ds;
import com.google.android.libraries.navigation.internal.db.t;
import com.google.android.libraries.navigation.internal.dh.ab;
import com.google.android.libraries.navigation.internal.dh.af;
import com.google.android.libraries.navigation.internal.dh.am;
import com.google.android.libraries.navigation.internal.dh.aq;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.nt.ac;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fz;
import com.google.maps.android.BuildConfig;
import j$.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.time.DurationKt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m implements com.google.android.libraries.navigation.internal.cw.a, aj, ak {
    public boolean A;
    public boolean B;
    public final l C;
    public final com.google.android.libraries.navigation.internal.ct.a D;
    public final com.google.android.libraries.navigation.internal.hm.j E;
    private final com.google.android.libraries.navigation.internal.rw.f F;
    private final com.google.android.libraries.navigation.internal.ia.b G;
    private final ac H;
    private final ac I;
    private final com.google.android.libraries.navigation.internal.afo.a J;
    private final com.google.android.libraries.navigation.internal.afo.a K;
    private volatile boolean L;
    private volatile boolean M;
    private volatile boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private final boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private volatile boolean X;
    private boolean Y;
    private final AtomicInteger Z;
    public final Context a;
    private com.google.android.libraries.navigation.internal.cy.h aa;
    private final ConcurrentLinkedQueue ab;
    private final df ac;
    public final bn b;
    public final bn c;
    public final com.google.android.libraries.navigation.internal.ia.e d;
    public final com.google.android.libraries.navigation.internal.afo.a e;
    public final com.google.android.libraries.navigation.internal.afo.a f;
    public final com.google.android.libraries.navigation.internal.iv.f g;
    public final com.google.android.libraries.navigation.internal.agl.a h;
    public al i;
    public final List j;
    public final com.google.android.libraries.navigation.internal.cy.h k;
    public com.google.android.libraries.navigation.internal.dh.ac l;
    public am m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public af f383n;
    public com.google.android.libraries.navigation.internal.dh.k o;
    public com.google.android.libraries.navigation.internal.dh.h p;
    public r q;
    public final com.google.android.libraries.navigation.internal.mj.a r;
    public boolean s;
    public boolean t;
    public com.google.android.libraries.navigation.internal.ady.al u;
    public boolean v;
    public cy w;
    public ab x;
    public volatile com.google.android.libraries.navigation.internal.db.r y;
    public volatile com.google.android.libraries.navigation.internal.cw.c z;

    public m(Context context, bn bnVar, bn bnVar2, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.rw.f fVar, com.google.android.libraries.navigation.internal.ia.b bVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.iv.f fVar2, com.google.android.libraries.navigation.internal.ct.a aVar3, com.google.android.libraries.navigation.internal.mj.a aVar4, com.google.android.libraries.navigation.internal.afo.a aVar5, com.google.android.libraries.navigation.internal.afo.a aVar6, df dfVar, com.google.android.libraries.navigation.internal.agl.a aVar7, final com.google.android.apps.gmm.location.navigation.am amVar, final com.google.android.libraries.navigation.internal.agl.a aVar8, com.google.android.libraries.navigation.internal.iz.n nVar, com.google.android.libraries.navigation.internal.hm.j jVar, an anVar) {
        com.google.android.libraries.navigation.internal.np.a aVar9;
        ch chVar = ch.a;
        Duration duration = Duration.ZERO;
        this.k = new com.google.android.libraries.navigation.internal.cy.h();
        this.H = new ac(new br() { // from class: com.google.android.libraries.navigation.internal.cx.g
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return null;
            }
        });
        this.I = new ac(new br() { // from class: com.google.android.libraries.navigation.internal.cx.h
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return this.a.k;
            }
        });
        this.L = false;
        this.M = false;
        this.N = false;
        this.s = false;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.t = false;
        this.X = false;
        this.u = com.google.android.libraries.navigation.internal.ady.al.WALK;
        this.Y = false;
        this.v = false;
        this.Z = new AtomicInteger(0);
        this.x = ab.GPS_AND_NETWORK;
        final Location location = null;
        this.aa = null;
        this.z = new com.google.android.libraries.navigation.internal.cw.c();
        this.A = true;
        this.ab = new ConcurrentLinkedQueue();
        this.r = aVar4;
        this.a = context;
        this.b = bnVar;
        this.h = aVar7;
        this.c = bnVar2;
        this.d = eVar;
        this.e = aVar;
        this.F = fVar;
        this.G = bVar;
        this.f = aVar2;
        this.g = fVar2;
        this.D = aVar3;
        this.J = aVar5;
        this.K = aVar6;
        this.ac = dfVar;
        this.j = new ArrayList();
        this.E = jVar;
        this.C = new l(this);
        aVar.a();
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("GmmLocationControllerImpl.init");
        try {
            if (!com.google.android.apps.gmm.location.navigation.m.a(context) && (aVar9 = (com.google.android.libraries.navigation.internal.np.a) ((an) aVar7.a()).f()) != null) {
                try {
                    Location locationC = aVar9.c("gps");
                    Location locationC2 = aVar9.c("fused");
                    location = (locationC == null || (locationC2 != null && locationC.getTime() <= locationC2.getTime())) ? locationC2 : locationC;
                    if (location != null) {
                        this.y = t.c(location);
                        if (locationC != null || locationC2 != null) {
                            this.z.a = com.google.android.libraries.navigation.internal.cw.b.c;
                        }
                    }
                } catch (SecurityException unused) {
                } catch (RuntimeException unused2) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(157)).p("Exception getting last known location. Ignoring.");
                }
            }
            if (this.y != null) {
                this.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.cx.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        m mVar = this.a;
                        Location location2 = location;
                        if (location2 != null) {
                            mVar.d.a(new com.google.android.libraries.navigation.internal.dh.a(location2));
                        }
                        mVar.d.a(new com.google.android.libraries.navigation.internal.db.s(mVar.y));
                        mVar.g();
                    }
                });
            }
            Runnable runnable = new Runnable() { // from class: com.google.android.libraries.navigation.internal.cx.f
                @Override // java.lang.Runnable
                public final void run() {
                    final m mVar = this.a;
                    com.google.android.apps.gmm.location.navigation.am amVar2 = amVar;
                    com.google.android.libraries.navigation.internal.agl.a aVar10 = aVar8;
                    com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("GmmLocationControllerImpl.setup");
                    try {
                        ap.LOCATION_SENSORS.f();
                        com.google.android.libraries.navigation.internal.np.a aVar11 = (com.google.android.libraries.navigation.internal.np.a) ((an) mVar.h.a()).f();
                        if (aVar11 != null) {
                            mVar.q = ((s) aVar10).a();
                            r rVar = mVar.q;
                            rVar.e.a(aVar11);
                            rVar.c = rVar.a.getPackageManager().resolveActivity(new Intent("com.google.android.gsf.GOOGLE_APPS_LOCATION_SETTINGS"), 65536) != null;
                            mVar.j.add(new com.google.android.libraries.navigation.internal.dh.f(mVar.a, mVar.d, mVar.g, aVar11, mVar.r, mVar.c, mVar.b));
                            mVar.m = new am(mVar.d, aVar11, mVar.r, mVar.c);
                        }
                        SensorManager sensorManager = (SensorManager) mVar.a.getSystemService("sensor");
                        if (sensorManager != null) {
                            mVar.f383n = new af(mVar.d, sensorManager, mVar.c, mVar.r);
                            mVar.p = new com.google.android.libraries.navigation.internal.dh.h(mVar.d, sensorManager, mVar.r);
                            if (mVar.a.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                                BluetoothManager bluetoothManager = (BluetoothManager) mVar.a.getSystemService("bluetooth");
                                BluetoothAdapter adapter = bluetoothManager == null ? null : bluetoothManager.getAdapter();
                                if (adapter != null) {
                                    mVar.o = new com.google.android.libraries.navigation.internal.dh.k(mVar.d, mVar.c, mVar.a, mVar.D, adapter);
                                }
                            }
                        }
                        Context context2 = (Context) amVar2.a.a();
                        context2.getClass();
                        com.google.android.libraries.navigation.internal.agl.a aVar12 = amVar2.b;
                        com.google.android.libraries.navigation.internal.fz.d dVar = (com.google.android.libraries.navigation.internal.fz.d) amVar2.c.a();
                        dVar.getClass();
                        ((com.google.android.libraries.navigation.internal.hm.j) amVar2.d.a()).getClass();
                        an anVar2 = (an) amVar2.e.a();
                        anVar2.getClass();
                        com.google.android.libraries.navigation.internal.rw.q qVar = (com.google.android.libraries.navigation.internal.rw.q) amVar2.f.a();
                        qVar.getClass();
                        com.google.android.libraries.navigation.internal.rw.f fVar3 = (com.google.android.libraries.navigation.internal.rw.f) amVar2.g.a();
                        fVar3.getClass();
                        com.google.android.libraries.navigation.internal.bf.d dVar2 = (com.google.android.libraries.navigation.internal.bf.d) amVar2.h.a();
                        dVar2.getClass();
                        com.google.android.libraries.navigation.internal.sf.b bVar2 = (com.google.android.libraries.navigation.internal.sf.b) amVar2.i.a();
                        bVar2.getClass();
                        com.google.android.libraries.navigation.internal.sf.d dVar3 = (com.google.android.libraries.navigation.internal.sf.d) amVar2.j.a();
                        dVar3.getClass();
                        com.google.android.libraries.navigation.internal.ia.e eVar2 = (com.google.android.libraries.navigation.internal.ia.e) amVar2.k.a();
                        eVar2.getClass();
                        com.google.android.libraries.navigation.internal.ia.b bVar3 = (com.google.android.libraries.navigation.internal.ia.b) amVar2.l.a();
                        bVar3.getClass();
                        com.google.android.libraries.navigation.internal.mj.a aVar13 = (com.google.android.libraries.navigation.internal.mj.a) amVar2.m.a();
                        aVar13.getClass();
                        bn bnVar3 = (bn) amVar2.f40n.a();
                        bnVar3.getClass();
                        Executor executor = (Executor) amVar2.o.a();
                        executor.getClass();
                        Looper looper = (Looper) amVar2.p.a();
                        looper.getClass();
                        Executor executor2 = (Executor) amVar2.q.a();
                        executor2.getClass();
                        com.google.android.libraries.navigation.internal.kl.a aVar14 = (com.google.android.libraries.navigation.internal.kl.a) amVar2.r.a();
                        aVar14.getClass();
                        an anVar3 = (an) amVar2.s.a();
                        anVar3.getClass();
                        ((com.google.android.libraries.navigation.internal.kc.a) amVar2.t.a()).getClass();
                        com.google.android.libraries.navigation.internal.gq.p pVar = (com.google.android.libraries.navigation.internal.gq.p) amVar2.u.a();
                        com.google.android.libraries.navigation.internal.iv.f fVar4 = (com.google.android.libraries.navigation.internal.iv.f) amVar2.v.a();
                        fVar4.getClass();
                        com.google.android.libraries.navigation.internal.fu.a aVar15 = (com.google.android.libraries.navigation.internal.fu.a) amVar2.w.a();
                        aVar15.getClass();
                        df dfVar2 = (df) amVar2.x.a();
                        dfVar2.getClass();
                        com.google.android.libraries.navigation.internal.dd.d dVar4 = (com.google.android.libraries.navigation.internal.dd.d) amVar2.y.a();
                        dVar4.getClass();
                        mVar.i = new al(context2, aVar12, mVar, mVar, dVar, anVar2, qVar, fVar3, dVar2, bVar2, dVar3, eVar2, bVar3, aVar13, bnVar3, executor, looper, executor2, aVar14, anVar3, pVar, fVar4, aVar15, dfVar2, dVar4);
                        com.google.android.libraries.navigation.internal.ia.e eVar3 = mVar.d;
                        fd fdVarK = fd.k(ap.LOCATION_SENSORS, mVar.c);
                        fz fzVar = new fz();
                        fzVar.b(com.google.android.libraries.navigation.internal.cw.f.class, new o(0, com.google.android.libraries.navigation.internal.cw.f.class, mVar, ap.LOCATION_SENSORS, o.b(ap.LOCATION_SENSORS, fdVarK)));
                        ap apVar = ap.LOCATION_SENSORS;
                        fzVar.b(com.google.android.libraries.navigation.internal.jm.a.class, new o(1, com.google.android.libraries.navigation.internal.jm.a.class, mVar, apVar, o.b(apVar, fdVarK)));
                        ap apVar2 = ap.LOCATION_SENSORS;
                        fzVar.b(com.google.android.libraries.navigation.internal.aq.k.class, new o(2, com.google.android.libraries.navigation.internal.aq.k.class, mVar, apVar2, o.b(apVar2, fdVarK)));
                        ap apVar3 = ap.LOCATION_SENSORS;
                        fzVar.b(com.google.android.libraries.navigation.internal.sq.a.class, new o(3, com.google.android.libraries.navigation.internal.sq.a.class, mVar, apVar3, o.b(apVar3, fdVarK)));
                        ap apVar4 = ap.LOCATION_SENSORS;
                        fzVar.b(com.google.android.libraries.navigation.internal.n.b.class, new o(4, com.google.android.libraries.navigation.internal.n.b.class, mVar, apVar4, o.b(apVar4, fdVarK)));
                        eVar3.c(mVar, fzVar.a());
                        ((com.google.android.libraries.navigation.internal.rw.q) mVar.e.a()).a(mVar.C, mVar.c);
                        mVar.E.a().e(new com.google.android.libraries.navigation.internal.nt.t() { // from class: com.google.android.libraries.navigation.internal.cx.a
                            @Override // com.google.android.libraries.navigation.internal.nt.t
                            public final void a(com.google.android.libraries.navigation.internal.nt.m mVar2) {
                                com.google.android.libraries.navigation.internal.fz.d dVar5 = (com.google.android.libraries.navigation.internal.fz.d) mVar2.c();
                                if (dVar5 != null) {
                                    m mVar3 = mVar;
                                    com.google.android.libraries.navigation.internal.hn.p pVarB = dVar5.b();
                                    ds dsVarF = dVar5.F();
                                    mVar3.v = pVarB.a.aN;
                                    mVar3.w = pVarB.h();
                                    boolean z = pVarB.j().b;
                                    dr drVar = dsVarF.e;
                                    if (drVar == null) {
                                        drVar = dr.a;
                                    }
                                    boolean z2 = drVar.f;
                                    mVar3.t = false;
                                    mVar3.j();
                                    if ((dsVarF.b & 8192) != 0) {
                                        mVar3.g.r(com.google.android.libraries.navigation.internal.iv.ab.bj, dsVarF.i);
                                    } else {
                                        mVar3.g.m(com.google.android.libraries.navigation.internal.iv.ab.bj);
                                    }
                                }
                            }
                        }, mVar.c);
                        mVar.B = true;
                        mVar.j();
                        if (dVarB2 != null) {
                            Trace.endSection();
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
                }
            };
            if (this.y != null) {
                nVar.d(runnable, this.c, com.google.android.libraries.navigation.internal.iz.m.ON_STARTUP_FULLY_COMPLETE);
            } else {
                this.c.execute(runnable);
            }
            this.H.b(new br() { // from class: com.google.android.libraries.navigation.internal.cx.j
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return this.a.b();
                }
            });
            this.I.b(new br() { // from class: com.google.android.libraries.navigation.internal.cx.b
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    m mVar = this.a;
                    al alVar = mVar.i;
                    return alVar == null ? mVar.k : alVar.a();
                }
            });
            this.F.c(new k(this), this.c);
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

    @Override // com.google.android.libraries.navigation.internal.cw.a
    public final com.google.android.libraries.navigation.internal.cw.c a() {
        return this.z;
    }

    @Override // com.google.android.libraries.navigation.internal.cw.a
    public final com.google.android.libraries.navigation.internal.db.r b() {
        int i = com.google.android.libraries.navigation.internal.km.l.a;
        int i2 = com.google.android.libraries.navigation.internal.fp.a.a;
        if (l()) {
            return this.y;
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.cw.a
    public final void c() {
        this.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.cx.c
            @Override // java.lang.Runnable
            public final void run() {
                m mVar = this.a;
                mVar.j();
                com.google.android.libraries.navigation.internal.dh.ac acVar = mVar.l;
                if (acVar != null) {
                    acVar.a();
                }
                am amVar = mVar.m;
                if (amVar == null || !mVar.s) {
                    return;
                }
                amVar.a();
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.cw.a
    public final void d() {
        this.N = true;
        k();
    }

    @Override // com.google.android.libraries.navigation.internal.cw.a
    public final void e() {
        this.N = false;
        k();
    }

    @Override // com.google.android.libraries.navigation.internal.cw.a
    public final int f() {
        if (this.D.a("android.permission.ACCESS_FINE_LOCATION")) {
            return 3;
        }
        return this.D.a("android.permission.ACCESS_COARSE_LOCATION") ? 2 : 1;
    }

    public final void g() {
        com.google.android.libraries.navigation.internal.cy.h hVarA;
        this.H.a();
        al alVar = this.i;
        if (alVar == null || (hVarA = alVar.a()) == null || hVarA == this.aa) {
            return;
        }
        this.aa = hVarA;
        this.I.a();
    }

    @Override // com.google.android.apps.gmm.location.navigation.aj
    public final void h(com.google.android.libraries.navigation.internal.db.r rVar) {
        ap.LOCATION_DISPATCHER.f();
        if (l()) {
            this.y = rVar;
            if (this.G.e()) {
                this.G.c(new com.google.android.libraries.navigation.internal.dh.r(rVar));
                if (rVar.l().J != null) {
                    this.G.c(new aq(rVar));
                }
                this.r.a();
                cb cbVar = rVar.l().H;
            }
            this.d.a(new com.google.android.libraries.navigation.internal.db.s(rVar));
            g();
        }
    }

    @Override // com.google.android.apps.gmm.location.navigation.ak
    public final void i(final ab abVar) {
        ap.LOCATION_DISPATCHER.f();
        this.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.cx.i
            @Override // java.lang.Runnable
            public final void run() {
                m mVar = this.a;
                mVar.x = abVar;
                com.google.android.libraries.navigation.internal.dh.ac acVar = mVar.l;
                if (acVar != null) {
                    acVar.g(mVar.x);
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0188  */
    /* JADX WARN: Code duplicated, block: B:103:0x018d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:108:0x01a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x01aa A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:112:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:115:0x01bb A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:121:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:124:0x01d0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:125:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:127:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:129:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:130:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:132:0x0200  */
    /* JADX WARN: Code duplicated, block: B:133:0x0201 A[DONT_INVERT, PHI: r2
      0x0201: PHI (r2v26 boolean) = (r2v25 boolean), (r2v35 boolean) binds: [B:123:0x01ce, B:132:0x0200] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:134:0x0203 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:137:0x0209  */
    /* JADX WARN: Code duplicated, block: B:141:0x0214 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:146:0x0220  */
    /* JADX WARN: Code duplicated, block: B:149:0x0225 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:150:0x0227  */
    /* JADX WARN: Code duplicated, block: B:151:0x022a  */
    /* JADX WARN: Code duplicated, block: B:152:0x022b A[DONT_INVERT, PHI: r2
      0x022b: PHI (r2v31 boolean) = (r2v30 boolean), (r2v32 boolean) binds: [B:148:0x0223, B:151:0x022a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:153:0x022d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:156:0x0233 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:162:0x0243  */
    /* JADX WARN: Code duplicated, block: B:165:0x0248 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:166:0x024a  */
    /* JADX WARN: Code duplicated, block: B:168:0x0252  */
    /* JADX WARN: Code duplicated, block: B:170:0x0260  */
    /* JADX WARN: Code duplicated, block: B:171:0x0261 A[DONT_INVERT, PHI: r0
      0x0261: PHI (r0v9 boolean) = (r0v8 boolean), (r0v16 boolean) binds: [B:164:0x0246, B:170:0x0260] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:172:0x0263 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:175:0x026d  */
    /* JADX WARN: Code duplicated, block: B:179:0x0278  */
    /* JADX WARN: Code duplicated, block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x005f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0062 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:37:0x0066  */
    /* JADX WARN: Code duplicated, block: B:39:0x0069  */
    /* JADX WARN: Code duplicated, block: B:44:0x0081  */
    /* JADX WARN: Code duplicated, block: B:46:0x0085 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:49:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x009d  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:73:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:76:0x0108  */
    /* JADX WARN: Code duplicated, block: B:79:0x011c  */
    /* JADX WARN: Code duplicated, block: B:84:0x014f  */
    /* JADX WARN: Code duplicated, block: B:86:0x0153 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:89:0x015d  */
    /* JADX WARN: Code duplicated, block: B:92:0x0174  */
    /* JADX WARN: Code duplicated, block: B:94:0x0178 A[ADDED_TO_REGION] */
    public final void j() {
        boolean z;
        boolean z2;
        com.google.android.libraries.navigation.internal.afo.a aVar;
        final al alVar;
        com.google.android.libraries.navigation.internal.dh.ac acVar;
        am amVar;
        boolean z3;
        boolean z4;
        af afVar;
        boolean z5;
        boolean z6;
        com.google.android.libraries.navigation.internal.dh.h hVar;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        com.google.android.libraries.navigation.internal.dh.k kVar;
        com.google.android.libraries.navigation.internal.dh.k kVar2;
        com.google.android.libraries.navigation.internal.dh.h hVar2;
        com.google.android.libraries.navigation.internal.kl.a aVar2;
        ap.LOCATION_SENSORS.f();
        if (this.B) {
            while (true) {
                com.google.android.libraries.navigation.internal.cw.i iVar = (com.google.android.libraries.navigation.internal.cw.i) this.ab.poll();
                if (iVar == null) {
                    break;
                }
                al alVar2 = this.i;
                if (alVar2 != null) {
                    synchronized (alVar2.K) {
                        alVar2.K.add(iVar);
                    }
                }
            }
            com.google.android.libraries.navigation.internal.rw.f fVar = this.F;
            AtomicInteger atomicInteger = this.Z;
            boolean zE = fVar.e();
            int i = atomicInteger.get();
            l();
            boolean z11 = this.N || zE || i > 0;
            r rVar = this.q;
            if (rVar == null) {
                if (z11) {
                    if (l()) {
                        z = true;
                    }
                }
                if (z) {
                    z2 = false;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    if (this.O) {
                        int i2 = com.google.android.libraries.navigation.internal.km.l.a;
                        int i3 = com.google.android.libraries.navigation.internal.fp.a.a;
                        aVar = this.J;
                        if (aVar != null) {
                            ((com.google.android.libraries.navigation.internal.cw.k) aVar.a()).b();
                            this.O = false;
                        }
                    }
                } else if (this.O) {
                    int i4 = com.google.android.libraries.navigation.internal.km.l.a;
                    int i5 = com.google.android.libraries.navigation.internal.fp.a.a;
                    aVar = this.J;
                    if (aVar != null) {
                        ((com.google.android.libraries.navigation.internal.cw.k) aVar.a()).b();
                        this.O = false;
                    }
                }
                com.google.android.libraries.navigation.internal.dh.ac acVar2 = null;
                if (!z) {
                    if (this.P) {
                        int i6 = com.google.android.libraries.navigation.internal.km.l.a;
                        int i7 = com.google.android.libraries.navigation.internal.fp.a.a;
                        alVar = this.i;
                        if (alVar != null) {
                            alVar.p.execute(new Runnable() { // from class: com.google.android.apps.gmm.location.navigation.af
                                @Override // java.lang.Runnable
                                public final void run() {
                                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                    al alVar3 = alVar;
                                    if (alVar3.D) {
                                        return;
                                    }
                                    alVar3.D = true;
                                    com.google.android.libraries.navigation.internal.dd.d dVar = alVar3.M;
                                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                    if (dVar.b != alVar3) {
                                        com.google.android.libraries.navigation.internal.zb.h hVar3 = (com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.dd.d.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(321);
                                        Object obj = dVar.b;
                                        if (obj == null) {
                                            obj = BuildConfig.TRAVIS;
                                        }
                                        hVar3.x("Invalid unsubscription current:%s unsubscribed:%s", obj, alVar3);
                                    }
                                    dVar.b = null;
                                    alVar3.k.b(alVar3.N);
                                    alVar3.l.d(alVar3.O);
                                    alVar3.F.cancel(false);
                                    n nVar = alVar3.e;
                                    nVar.a = -1L;
                                    nVar.b = 0.0d;
                                    alVar3.d.a();
                                    alVar3.f.e(null);
                                    alVar3.u.a(null);
                                    alVar3.m.e(alVar3.u);
                                    alVar3.v.d(null);
                                    alVar3.m.e(alVar3.v);
                                    alVar3.w.a(null);
                                    alVar3.m.e(alVar3.w);
                                    alVar3.x.a(null);
                                    alVar3.m.e(alVar3.x);
                                    alVar3.y.a(null);
                                    alVar3.m.e(alVar3.y);
                                    alVar3.z.h(null);
                                    alVar3.m.e(alVar3.b);
                                    alVar3.m.e(alVar3.d);
                                    alVar3.m.e(alVar3.f);
                                    alVar3.f.a();
                                    alVar3.m.e(alVar3.z);
                                    alVar3.z.g();
                                    alVar3.m.e(alVar3);
                                    bu buVar = alVar3.q;
                                    if (buVar != null) {
                                        buVar.b();
                                        bu buVar2 = alVar3.q;
                                        com.google.android.libraries.navigation.internal.ia.e eVar = alVar3.m;
                                        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                        if (buVar2.i != null) {
                                            eVar.e(buVar2);
                                            buVar2.e.d(buVar2.h);
                                            buVar2.f.b(buVar2.h);
                                            buVar2.i.a();
                                        }
                                    }
                                    alVar3.g.k(alVar3.r, false, false);
                                    alVar3.g(false, true, false);
                                    alVar3.s = false;
                                }
                            });
                        }
                        acVar = this.l;
                        if (acVar != null) {
                            acVar.e();
                            this.l = null;
                        }
                        this.P = false;
                        ((com.google.android.libraries.navigation.internal.fr.e) this.f.a()).b(false);
                    }
                } else if (this.P) {
                    int i8 = com.google.android.libraries.navigation.internal.km.l.a;
                    int i9 = com.google.android.libraries.navigation.internal.fp.a.a;
                    alVar = this.i;
                    if (alVar != null) {
                        alVar.p.execute(new Runnable() { // from class: com.google.android.apps.gmm.location.navigation.af
                            @Override // java.lang.Runnable
                            public final void run() {
                                com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                al alVar3 = alVar;
                                if (alVar3.D) {
                                    return;
                                }
                                alVar3.D = true;
                                com.google.android.libraries.navigation.internal.dd.d dVar = alVar3.M;
                                com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                if (dVar.b != alVar3) {
                                    com.google.android.libraries.navigation.internal.zb.h hVar3 = (com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.dd.d.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(321);
                                    Object obj = dVar.b;
                                    if (obj == null) {
                                        obj = BuildConfig.TRAVIS;
                                    }
                                    hVar3.x("Invalid unsubscription current:%s unsubscribed:%s", obj, alVar3);
                                }
                                dVar.b = null;
                                alVar3.k.b(alVar3.N);
                                alVar3.l.d(alVar3.O);
                                alVar3.F.cancel(false);
                                n nVar = alVar3.e;
                                nVar.a = -1L;
                                nVar.b = 0.0d;
                                alVar3.d.a();
                                alVar3.f.e(null);
                                alVar3.u.a(null);
                                alVar3.m.e(alVar3.u);
                                alVar3.v.d(null);
                                alVar3.m.e(alVar3.v);
                                alVar3.w.a(null);
                                alVar3.m.e(alVar3.w);
                                alVar3.x.a(null);
                                alVar3.m.e(alVar3.x);
                                alVar3.y.a(null);
                                alVar3.m.e(alVar3.y);
                                alVar3.z.h(null);
                                alVar3.m.e(alVar3.b);
                                alVar3.m.e(alVar3.d);
                                alVar3.m.e(alVar3.f);
                                alVar3.f.a();
                                alVar3.m.e(alVar3.z);
                                alVar3.z.g();
                                alVar3.m.e(alVar3);
                                bu buVar = alVar3.q;
                                if (buVar != null) {
                                    buVar.b();
                                    bu buVar2 = alVar3.q;
                                    com.google.android.libraries.navigation.internal.ia.e eVar = alVar3.m;
                                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                    if (buVar2.i != null) {
                                        eVar.e(buVar2);
                                        buVar2.e.d(buVar2.h);
                                        buVar2.f.b(buVar2.h);
                                        buVar2.i.a();
                                    }
                                }
                                alVar3.g.k(alVar3.r, false, false);
                                alVar3.g(false, true, false);
                                alVar3.s = false;
                            }
                        });
                    }
                    acVar = this.l;
                    if (acVar != null) {
                        acVar.e();
                        this.l = null;
                    }
                    this.P = false;
                    ((com.google.android.libraries.navigation.internal.fr.e) this.f.a()).b(false);
                }
                if (!z) {
                    if (this.s) {
                        int i10 = com.google.android.libraries.navigation.internal.km.l.a;
                        int i11 = com.google.android.libraries.navigation.internal.fp.a.a;
                        amVar = this.m;
                        if (amVar != null) {
                            ap.LOCATION_SENSORS.f();
                            amVar.e = false;
                            amVar.f.cancel(false);
                            amVar.a.c();
                            this.s = false;
                        }
                    }
                } else if (this.s) {
                    int i12 = com.google.android.libraries.navigation.internal.km.l.a;
                    int i13 = com.google.android.libraries.navigation.internal.fp.a.a;
                    amVar = this.m;
                    if (amVar != null) {
                        ap.LOCATION_SENSORS.f();
                        amVar.e = false;
                        amVar.f.cancel(false);
                        amVar.a.c();
                        this.s = false;
                    }
                }
                if (this.Q) {
                    this.Q = false;
                }
                if (!z) {
                    z3 = false;
                } else {
                    z3 = false;
                }
                z4 = this.R;
                if (!z4) {
                    if (z4) {
                        int i14 = com.google.android.libraries.navigation.internal.km.l.a;
                        int i15 = com.google.android.libraries.navigation.internal.fp.a.a;
                        afVar = this.f383n;
                        if (afVar != null) {
                            afVar.a();
                        }
                        this.R = false;
                    }
                } else if (z4) {
                    int i16 = com.google.android.libraries.navigation.internal.km.l.a;
                    int i17 = com.google.android.libraries.navigation.internal.fp.a.a;
                    afVar = this.f383n;
                    if (afVar != null) {
                        afVar.a();
                    }
                    this.R = false;
                }
                if (!z) {
                    z5 = false;
                } else {
                    z5 = false;
                }
                z6 = this.V;
                if (z6) {
                    if (z6) {
                        hVar = this.p;
                        if (hVar != null) {
                            hVar.a.unregisterListener(hVar);
                        }
                        this.V = false;
                    }
                } else if (z5) {
                    hVar2 = this.p;
                    if (hVar2 != null) {
                        aVar2 = (com.google.android.libraries.navigation.internal.kl.a) this.K.a();
                        hVar2.c = aVar2;
                        if (hVar2.b == null) {
                            com.google.android.apps.gmm.location.navigation.ap.a(aVar2, 13, false);
                        } else {
                            com.google.android.apps.gmm.location.navigation.ap.a(aVar2, 13, hVar2.a.registerListener(hVar2, hVar2.b, DurationKt.NANOS_IN_MILLIS, new Handler()));
                        }
                    }
                    this.V = true;
                } else {
                    z5 = false;
                    if (z6) {
                        hVar = this.p;
                        if (hVar != null) {
                            hVar.a.unregisterListener(hVar);
                        }
                        this.V = false;
                    }
                }
                if (!this.v) {
                    z7 = false;
                } else {
                    z7 = false;
                }
                z8 = this.Y;
                if (z8) {
                    if (z8) {
                        this.Y = false;
                    }
                } else if (z7) {
                    this.Y = true;
                } else {
                    z7 = false;
                    if (z8) {
                        this.Y = false;
                    }
                }
                if (!z) {
                    z9 = false;
                } else {
                    z9 = false;
                }
                z10 = this.W;
                if (z10) {
                    if (z10) {
                        int i18 = com.google.android.libraries.navigation.internal.km.l.a;
                        int i19 = com.google.android.libraries.navigation.internal.fp.a.a;
                        kVar = this.o;
                        if (kVar != null) {
                            kVar.c();
                        }
                        this.W = false;
                    }
                } else if (z9) {
                    int i20 = com.google.android.libraries.navigation.internal.km.l.a;
                    int i21 = com.google.android.libraries.navigation.internal.fp.a.a;
                    kVar2 = this.o;
                    if (kVar2 != null) {
                        kVar2.b((com.google.android.libraries.navigation.internal.kl.a) this.K.a());
                    }
                    this.W = true;
                } else {
                    z9 = false;
                    if (z10) {
                        int i110 = com.google.android.libraries.navigation.internal.km.l.a;
                        int i111 = com.google.android.libraries.navigation.internal.fp.a.a;
                        kVar = this.o;
                        if (kVar != null) {
                            kVar.c();
                        }
                        this.W = false;
                    }
                }
                if (l()) {
                }
                this.g.m(com.google.android.libraries.navigation.internal.iv.ab.bi);
                this.H.a();
            }
            if (z11) {
                if (!rVar.d) {
                    rVar.d = true;
                    rVar.b.execute(rVar);
                }
                if (l()) {
                    z = true;
                }
                if (z || zE) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2 && !this.O) {
                    int i22 = com.google.android.libraries.navigation.internal.km.l.a;
                    int i23 = com.google.android.libraries.navigation.internal.fp.a.a;
                    com.google.android.libraries.navigation.internal.afo.a aVar3 = this.J;
                    if (aVar3 != null) {
                        ((com.google.android.libraries.navigation.internal.cw.k) aVar3.a()).a();
                        this.O = true;
                    }
                } else if (this.O && !z2) {
                    int i24 = com.google.android.libraries.navigation.internal.km.l.a;
                    int i25 = com.google.android.libraries.navigation.internal.fp.a.a;
                    aVar = this.J;
                    if (aVar != null) {
                        ((com.google.android.libraries.navigation.internal.cw.k) aVar.a()).b();
                        this.O = false;
                    }
                }
                com.google.android.libraries.navigation.internal.dh.ac acVar3 = null;
                if (!z && !this.P) {
                    int i26 = com.google.android.libraries.navigation.internal.km.l.a;
                    int i27 = com.google.android.libraries.navigation.internal.fp.a.a;
                    final al alVar3 = this.i;
                    if (alVar3 != null) {
                        alVar3.p.execute(new Runnable() { // from class: com.google.android.apps.gmm.location.navigation.ac
                            @Override // java.lang.Runnable
                            public final void run() {
                                Location location;
                                com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                al alVar4 = alVar3;
                                if (alVar4.C || !alVar4.D) {
                                    return;
                                }
                                alVar4.D = false;
                                if (!alVar4.L) {
                                    synchronized (alVar4.K) {
                                        alVar4.K.add(new bp(alVar4.o));
                                        alVar4.K.add(new ba(alVar4.o, alVar4.m, alVar4.i, alVar4.j));
                                    }
                                    alVar4.L = true;
                                }
                                alVar4.B = -4611686018427387904L;
                                alVar4.f.e(alVar4);
                                alVar4.u.a(alVar4);
                                alVar4.v.d(alVar4);
                                alVar4.w.a(alVar4);
                                alVar4.x.a(alVar4);
                                alVar4.y.a(alVar4);
                                alVar4.z.h(alVar4);
                                alVar4.f.a();
                                alVar4.z.f(null);
                                alVar4.j();
                                bu buVar = alVar4.q;
                                if (buVar != null) {
                                    com.google.android.libraries.navigation.internal.ia.e eVar = alVar4.m;
                                    SnappingTracerJni snappingTracerJni = buVar.i;
                                    if (snappingTracerJni != null && !snappingTracerJni.c()) {
                                        SnappingTracerJni snappingTracerJni2 = buVar.i;
                                        float f = buVar.a;
                                        float f2 = buVar.b;
                                        long j = buVar.c;
                                        if (snappingTracerJni2.c()) {
                                            ((com.google.android.libraries.navigation.internal.zb.h) SnappingTracerJni.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 299)).p("SnappingTracerJni called onStart() when already started");
                                        } else {
                                            NativeHelper.b(SnappingTracerJni.b);
                                            snappingTracerJni2.c = SnappingTracerJni.nativeCreateSnappingTracer(-1, f, f2, j);
                                        }
                                        fz fzVar = new fz();
                                        fzVar.b(com.google.android.libraries.navigation.internal.sq.a.class, new bw(0, com.google.android.libraries.navigation.internal.sq.a.class, buVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                        fzVar.b(com.google.android.libraries.navigation.internal.sm.d.class, new bw(1, com.google.android.libraries.navigation.internal.sm.d.class, buVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                        fzVar.b(com.google.android.libraries.navigation.internal.sm.e.class, new bw(2, com.google.android.libraries.navigation.internal.sm.e.class, buVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                        fzVar.b(com.google.android.libraries.navigation.internal.sm.c.class, new bw(3, com.google.android.libraries.navigation.internal.sm.c.class, buVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                        fzVar.b(com.google.android.libraries.navigation.internal.tl.b.class, new bw(4, com.google.android.libraries.navigation.internal.tl.b.class, buVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                        fzVar.b(com.google.android.libraries.navigation.internal.aq.k.class, new bw(5, com.google.android.libraries.navigation.internal.aq.k.class, buVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                        eVar.c(buVar, fzVar.a());
                                        buVar.e.c(buVar.h, buVar.g);
                                        buVar.f.a(buVar.h, buVar.g);
                                    }
                                }
                                com.google.android.libraries.navigation.internal.ia.e eVar2 = alVar4.m;
                                o oVar = alVar4.v;
                                fz fzVar2 = new fz();
                                fzVar2.b(com.google.android.libraries.navigation.internal.aq.h.class, new p(0, com.google.android.libraries.navigation.internal.aq.h.class, oVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar2.b(com.google.android.libraries.navigation.internal.dh.ai.class, new p(1, com.google.android.libraries.navigation.internal.dh.ai.class, oVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                eVar2.c(oVar, fzVar2.a());
                                com.google.android.libraries.navigation.internal.ia.e eVar3 = alVar4.m;
                                ar arVar = alVar4.b;
                                fz fzVar3 = new fz();
                                fzVar3.b(com.google.android.libraries.navigation.internal.aq.k.class, new as(com.google.android.libraries.navigation.internal.aq.k.class, arVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                eVar3.c(arVar, fzVar3.a());
                                com.google.android.libraries.navigation.internal.ia.e eVar4 = alVar4.m;
                                bn bnVar = alVar4.d;
                                fz fzVar4 = new fz();
                                fzVar4.b(com.google.android.libraries.navigation.internal.dh.ai.class, new bo(com.google.android.libraries.navigation.internal.dh.ai.class, bnVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                eVar4.c(bnVar, fzVar4.a());
                                com.google.android.libraries.navigation.internal.ia.e eVar5 = alVar4.m;
                                b bVar = alVar4.u;
                                fz fzVar5 = new fz();
                                fzVar5.b(com.google.android.libraries.navigation.internal.dh.i.class, new c(com.google.android.libraries.navigation.internal.dh.i.class, bVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                eVar5.c(bVar, fzVar5.a());
                                com.google.android.libraries.navigation.internal.ia.e eVar6 = alVar4.m;
                                g gVar = alVar4.f;
                                fz fzVar6 = new fz();
                                fzVar6.b(com.google.android.libraries.navigation.internal.aq.k.class, new h(0, com.google.android.libraries.navigation.internal.aq.k.class, gVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar6.b(com.google.android.libraries.navigation.internal.aq.h.class, new h(1, com.google.android.libraries.navigation.internal.aq.h.class, gVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                eVar6.c(gVar, fzVar6.a());
                                com.google.android.libraries.navigation.internal.ia.e eVar7 = alVar4.m;
                                cd cdVar = alVar4.w;
                                fz fzVar7 = new fz();
                                fzVar7.b(com.google.android.libraries.navigation.internal.aq.i.class, new ce(0, com.google.android.libraries.navigation.internal.aq.i.class, cdVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar7.b(com.google.android.libraries.navigation.internal.aq.k.class, new ce(1, com.google.android.libraries.navigation.internal.aq.k.class, cdVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                eVar7.c(cdVar, fzVar7.a());
                                com.google.android.libraries.navigation.internal.ia.e eVar8 = alVar4.m;
                                e eVar9 = alVar4.x;
                                fz fzVar8 = new fz();
                                fzVar8.b(com.google.android.libraries.navigation.internal.aq.c.class, new f(0, com.google.android.libraries.navigation.internal.aq.c.class, eVar9, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar8.b(com.google.android.libraries.navigation.internal.aq.k.class, new f(1, com.google.android.libraries.navigation.internal.aq.k.class, eVar9, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                eVar8.c(eVar9, fzVar8.a());
                                com.google.android.libraries.navigation.internal.ia.e eVar10 = alVar4.m;
                                i iVar2 = alVar4.y;
                                fz fzVar9 = new fz();
                                fzVar9.b(com.google.android.libraries.navigation.internal.aq.e.class, new j(0, com.google.android.libraries.navigation.internal.aq.e.class, iVar2, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar9.b(com.google.android.libraries.navigation.internal.aq.k.class, new j(1, com.google.android.libraries.navigation.internal.aq.k.class, iVar2, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                eVar10.c(iVar2, fzVar9.a());
                                com.google.android.libraries.navigation.internal.ia.e eVar11 = alVar4.m;
                                s sVar = alVar4.z;
                                fz fzVar10 = new fz();
                                fzVar10.b(com.google.android.libraries.navigation.internal.dh.ad.class, new u(0, com.google.android.libraries.navigation.internal.dh.ad.class, sVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar10.b(com.google.android.libraries.navigation.internal.dh.p.class, new u(1, com.google.android.libraries.navigation.internal.dh.p.class, sVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar10.b(com.google.android.libraries.navigation.internal.dh.v.class, new u(2, com.google.android.libraries.navigation.internal.dh.v.class, sVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar10.b(com.google.android.libraries.navigation.internal.db.s.class, new u(3, com.google.android.libraries.navigation.internal.db.s.class, sVar, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                eVar11.c(sVar, fzVar10.a());
                                com.google.android.libraries.navigation.internal.ia.e eVar12 = alVar4.m;
                                fz fzVar11 = new fz();
                                fzVar11.b(com.google.android.libraries.navigation.internal.dh.q.class, new aq(0, com.google.android.libraries.navigation.internal.dh.q.class, alVar4, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar11.b(com.google.android.libraries.navigation.internal.dh.a.class, new aq(1, com.google.android.libraries.navigation.internal.dh.a.class, alVar4, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar11.b(com.google.android.libraries.navigation.internal.dh.t.class, new aq(2, com.google.android.libraries.navigation.internal.dh.t.class, alVar4, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar11.b(com.google.android.libraries.navigation.internal.dh.aw.class, new aq(3, com.google.android.libraries.navigation.internal.dh.aw.class, alVar4, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar11.b(com.google.android.libraries.navigation.internal.dh.o.class, new aq(4, com.google.android.libraries.navigation.internal.dh.o.class, alVar4, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar11.b(com.google.android.libraries.navigation.internal.dh.s.class, new aq(5, com.google.android.libraries.navigation.internal.dh.s.class, alVar4, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar11.b(com.google.android.libraries.navigation.internal.dh.y.class, new aq(6, com.google.android.libraries.navigation.internal.dh.y.class, alVar4, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar11.b(com.google.android.libraries.navigation.internal.dh.ai.class, new aq(7, com.google.android.libraries.navigation.internal.dh.ai.class, alVar4, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar11.b(com.google.android.libraries.navigation.internal.dh.at.class, new aq(8, com.google.android.libraries.navigation.internal.dh.at.class, alVar4, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar11.b(com.google.android.libraries.navigation.internal.dh.au.class, new aq(9, com.google.android.libraries.navigation.internal.dh.au.class, alVar4, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar11.b(com.google.android.libraries.navigation.internal.dh.av.class, new aq(10, com.google.android.libraries.navigation.internal.dh.av.class, alVar4, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar11.b(com.google.android.libraries.navigation.internal.dh.as.class, new aq(11, com.google.android.libraries.navigation.internal.dh.as.class, alVar4, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar11.b(com.google.android.libraries.navigation.internal.dh.g.class, new aq(12, com.google.android.libraries.navigation.internal.dh.g.class, alVar4, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar11.b(com.google.android.libraries.navigation.internal.cy.a.class, new aq(13, com.google.android.libraries.navigation.internal.cy.a.class, alVar4, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar11.b(com.google.android.libraries.navigation.internal.dh.w.class, new aq(14, com.google.android.libraries.navigation.internal.dh.w.class, alVar4, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar11.b(com.google.android.libraries.navigation.internal.dh.aa.class, new aq(15, com.google.android.libraries.navigation.internal.dh.aa.class, alVar4, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar11.b(com.google.android.libraries.navigation.internal.sq.a.class, new aq(16, com.google.android.libraries.navigation.internal.sq.a.class, alVar4, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar11.b(com.google.android.libraries.navigation.internal.jm.a.class, new aq(17, com.google.android.libraries.navigation.internal.jm.a.class, alVar4, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar11.b(com.google.android.libraries.navigation.internal.aq.f.class, new aq(18, com.google.android.libraries.navigation.internal.aq.f.class, alVar4, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                fzVar11.b(com.google.android.libraries.navigation.internal.bk.a.class, new aq(19, com.google.android.libraries.navigation.internal.bk.a.class, alVar4, com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER));
                                eVar12.c(alVar4, fzVar11.a());
                                if (alVar4.H == null) {
                                    com.google.android.libraries.navigation.internal.np.a aVar4 = (com.google.android.libraries.navigation.internal.np.a) ((com.google.android.libraries.navigation.internal.yx.an) alVar4.P.a()).f();
                                    if (aVar4 == null) {
                                        location = null;
                                    } else {
                                        try {
                                            Location locationC = aVar4.c("gps");
                                            Location locationC2 = aVar4.c("network");
                                            location = (locationC == null || (locationC2 != null && locationC.getTime() <= locationC2.getTime())) ? locationC2 : locationC;
                                        } catch (SecurityException unused) {
                                            location = null;
                                        } catch (RuntimeException unused2) {
                                            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 235)).p("Exception getting last known location. Ignoring.");
                                            location = null;
                                        }
                                    }
                                    if (location != null) {
                                        alVar4.m.a(new com.google.android.libraries.navigation.internal.dh.a(location));
                                    }
                                }
                                alVar4.l.c(alVar4.O, alVar4.p);
                                alVar4.O.a(alVar4.l.a());
                                alVar4.k.a(alVar4.N, alVar4.p);
                                com.google.android.libraries.navigation.internal.dd.d dVar = alVar4.M;
                                com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                if (dVar.b != null) {
                                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.dd.d.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(AviDirectory.TAG_DATETIME_ORIGINAL)).x("Duplicate subscription current:%s subscribed:%s", dVar.b, alVar4);
                                }
                                dVar.b = alVar4;
                            }
                        });
                    }
                    ap.LOCATION_SENSORS.f();
                    Iterator it2 = this.j.iterator();
                    if (it2.hasNext()) {
                        acVar3 = (com.google.android.libraries.navigation.internal.dh.ac) it2.next();
                        acVar3.h();
                    }
                    if (acVar3 != null && acVar3 != this.l) {
                        acVar3.c(this.x, (com.google.android.libraries.navigation.internal.kl.a) this.K.a());
                        com.google.android.libraries.navigation.internal.dh.ac acVar4 = this.l;
                        if (acVar4 != null) {
                            acVar4.e();
                        }
                        this.l = acVar3;
                    }
                    this.P = true;
                } else if (this.P && !z) {
                    int i28 = com.google.android.libraries.navigation.internal.km.l.a;
                    int i29 = com.google.android.libraries.navigation.internal.fp.a.a;
                    alVar = this.i;
                    if (alVar != null) {
                        alVar.p.execute(new Runnable() { // from class: com.google.android.apps.gmm.location.navigation.af
                            @Override // java.lang.Runnable
                            public final void run() {
                                com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                al alVar4 = alVar;
                                if (alVar4.D) {
                                    return;
                                }
                                alVar4.D = true;
                                com.google.android.libraries.navigation.internal.dd.d dVar = alVar4.M;
                                com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                if (dVar.b != alVar4) {
                                    com.google.android.libraries.navigation.internal.zb.h hVar3 = (com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.dd.d.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(321);
                                    Object obj = dVar.b;
                                    if (obj == null) {
                                        obj = BuildConfig.TRAVIS;
                                    }
                                    hVar3.x("Invalid unsubscription current:%s unsubscribed:%s", obj, alVar4);
                                }
                                dVar.b = null;
                                alVar4.k.b(alVar4.N);
                                alVar4.l.d(alVar4.O);
                                alVar4.F.cancel(false);
                                n nVar = alVar4.e;
                                nVar.a = -1L;
                                nVar.b = 0.0d;
                                alVar4.d.a();
                                alVar4.f.e(null);
                                alVar4.u.a(null);
                                alVar4.m.e(alVar4.u);
                                alVar4.v.d(null);
                                alVar4.m.e(alVar4.v);
                                alVar4.w.a(null);
                                alVar4.m.e(alVar4.w);
                                alVar4.x.a(null);
                                alVar4.m.e(alVar4.x);
                                alVar4.y.a(null);
                                alVar4.m.e(alVar4.y);
                                alVar4.z.h(null);
                                alVar4.m.e(alVar4.b);
                                alVar4.m.e(alVar4.d);
                                alVar4.m.e(alVar4.f);
                                alVar4.f.a();
                                alVar4.m.e(alVar4.z);
                                alVar4.z.g();
                                alVar4.m.e(alVar4);
                                bu buVar = alVar4.q;
                                if (buVar != null) {
                                    buVar.b();
                                    bu buVar2 = alVar4.q;
                                    com.google.android.libraries.navigation.internal.ia.e eVar = alVar4.m;
                                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                    if (buVar2.i != null) {
                                        eVar.e(buVar2);
                                        buVar2.e.d(buVar2.h);
                                        buVar2.f.b(buVar2.h);
                                        buVar2.i.a();
                                    }
                                }
                                alVar4.g.k(alVar4.r, false, false);
                                alVar4.g(false, true, false);
                                alVar4.s = false;
                            }
                        });
                    }
                    acVar = this.l;
                    if (acVar != null) {
                        acVar.e();
                        this.l = null;
                    }
                    this.P = false;
                    ((com.google.android.libraries.navigation.internal.fr.e) this.f.a()).b(false);
                }
                if (!z && !this.s) {
                    int i30 = com.google.android.libraries.navigation.internal.km.l.a;
                    int i31 = com.google.android.libraries.navigation.internal.fp.a.a;
                    am amVar2 = this.m;
                    if (amVar2 != null) {
                        com.google.android.libraries.navigation.internal.kl.a aVar4 = (com.google.android.libraries.navigation.internal.kl.a) this.K.a();
                        ap.LOCATION_SENSORS.f();
                        amVar2.e = true;
                        amVar2.c = aVar4;
                        amVar2.b.a(new com.google.android.libraries.navigation.internal.ds.c(amVar2.a.e(aVar4)));
                        amVar2.b();
                        this.s = true;
                    }
                } else if (this.s && !z) {
                    int i112 = com.google.android.libraries.navigation.internal.km.l.a;
                    int i113 = com.google.android.libraries.navigation.internal.fp.a.a;
                    amVar = this.m;
                    if (amVar != null) {
                        ap.LOCATION_SENSORS.f();
                        amVar.e = false;
                        amVar.f.cancel(false);
                        amVar.a.c();
                        this.s = false;
                    }
                }
                if (this.Q) {
                    this.Q = false;
                }
                if (!z && zE && (this.u == com.google.android.libraries.navigation.internal.ady.al.DRIVE || this.u == com.google.android.libraries.navigation.internal.ady.al.TWO_WHEELER)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z4 = this.R;
                if (!z4 && z3) {
                    int i32 = com.google.android.libraries.navigation.internal.km.l.a;
                    int i33 = com.google.android.libraries.navigation.internal.fp.a.a;
                    af afVar2 = this.f383n;
                    if (afVar2 != null) {
                        this.S = afVar2.b((com.google.android.libraries.navigation.internal.kl.a) this.K.a());
                    }
                    this.R = true;
                } else if (z4 && !z3) {
                    int i114 = com.google.android.libraries.navigation.internal.km.l.a;
                    int i115 = com.google.android.libraries.navigation.internal.fp.a.a;
                    afVar = this.f383n;
                    if (afVar != null) {
                        afVar.a();
                    }
                    this.R = false;
                }
                if (!z && zE && (this.u == com.google.android.libraries.navigation.internal.ady.al.DRIVE || this.u == com.google.android.libraries.navigation.internal.ady.al.TWO_WHEELER)) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = this.V;
                if (z6) {
                    if (z6 && !z5) {
                        hVar = this.p;
                        if (hVar != null) {
                            hVar.a.unregisterListener(hVar);
                        }
                        this.V = false;
                    }
                } else if (z5) {
                    hVar2 = this.p;
                    if (hVar2 != null) {
                        aVar2 = (com.google.android.libraries.navigation.internal.kl.a) this.K.a();
                        hVar2.c = aVar2;
                        if (hVar2.b == null) {
                            com.google.android.apps.gmm.location.navigation.ap.a(aVar2, 13, false);
                        } else {
                            com.google.android.apps.gmm.location.navigation.ap.a(aVar2, 13, hVar2.a.registerListener(hVar2, hVar2.b, DurationKt.NANOS_IN_MILLIS, new Handler()));
                        }
                    }
                    this.V = true;
                } else {
                    z5 = false;
                    if (z6) {
                        hVar = this.p;
                        if (hVar != null) {
                            hVar.a.unregisterListener(hVar);
                        }
                        this.V = false;
                    }
                }
                if (!this.v && z && zE && this.u == com.google.android.libraries.navigation.internal.ady.al.DRIVE) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = this.Y;
                if (z8) {
                    if (z8 && !z7) {
                        this.Y = false;
                    }
                } else if (z7) {
                    this.Y = true;
                } else {
                    z7 = false;
                    if (z8) {
                        this.Y = false;
                    }
                }
                if (!z && zE && (this.u == com.google.android.libraries.navigation.internal.ady.al.DRIVE || this.u == com.google.android.libraries.navigation.internal.ady.al.TWO_WHEELER)) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                z10 = this.W;
                if (z10) {
                    if (z10 && !z9) {
                        int i116 = com.google.android.libraries.navigation.internal.km.l.a;
                        int i117 = com.google.android.libraries.navigation.internal.fp.a.a;
                        kVar = this.o;
                        if (kVar != null) {
                            kVar.c();
                        }
                        this.W = false;
                    }
                } else if (z9) {
                    int i210 = com.google.android.libraries.navigation.internal.km.l.a;
                    int i211 = com.google.android.libraries.navigation.internal.fp.a.a;
                    kVar2 = this.o;
                    if (kVar2 != null) {
                        kVar2.b((com.google.android.libraries.navigation.internal.kl.a) this.K.a());
                    }
                    this.W = true;
                } else {
                    z9 = false;
                    if (z10) {
                        int i118 = com.google.android.libraries.navigation.internal.km.l.a;
                        int i119 = com.google.android.libraries.navigation.internal.fp.a.a;
                        kVar = this.o;
                        if (kVar != null) {
                            kVar.c();
                        }
                        this.W = false;
                    }
                }
                if (l()) {
                    this.g.m(com.google.android.libraries.navigation.internal.iv.ab.bi);
                    this.H.a();
                }
            }
            rVar.d = false;
            z = false;
            if (z) {
                z2 = false;
            } else {
                z2 = false;
            }
            if (!z2) {
                if (this.O) {
                    int i212 = com.google.android.libraries.navigation.internal.km.l.a;
                    int i213 = com.google.android.libraries.navigation.internal.fp.a.a;
                    aVar = this.J;
                    if (aVar != null) {
                        ((com.google.android.libraries.navigation.internal.cw.k) aVar.a()).b();
                        this.O = false;
                    }
                }
            } else if (this.O) {
                int i214 = com.google.android.libraries.navigation.internal.km.l.a;
                int i215 = com.google.android.libraries.navigation.internal.fp.a.a;
                aVar = this.J;
                if (aVar != null) {
                    ((com.google.android.libraries.navigation.internal.cw.k) aVar.a()).b();
                    this.O = false;
                }
            }
            com.google.android.libraries.navigation.internal.dh.ac acVar5 = null;
            if (!z) {
                if (this.P) {
                    int i216 = com.google.android.libraries.navigation.internal.km.l.a;
                    int i217 = com.google.android.libraries.navigation.internal.fp.a.a;
                    alVar = this.i;
                    if (alVar != null) {
                        alVar.p.execute(new Runnable() { // from class: com.google.android.apps.gmm.location.navigation.af
                            @Override // java.lang.Runnable
                            public final void run() {
                                com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                al alVar4 = alVar;
                                if (alVar4.D) {
                                    return;
                                }
                                alVar4.D = true;
                                com.google.android.libraries.navigation.internal.dd.d dVar = alVar4.M;
                                com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                if (dVar.b != alVar4) {
                                    com.google.android.libraries.navigation.internal.zb.h hVar3 = (com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.dd.d.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(321);
                                    Object obj = dVar.b;
                                    if (obj == null) {
                                        obj = BuildConfig.TRAVIS;
                                    }
                                    hVar3.x("Invalid unsubscription current:%s unsubscribed:%s", obj, alVar4);
                                }
                                dVar.b = null;
                                alVar4.k.b(alVar4.N);
                                alVar4.l.d(alVar4.O);
                                alVar4.F.cancel(false);
                                n nVar = alVar4.e;
                                nVar.a = -1L;
                                nVar.b = 0.0d;
                                alVar4.d.a();
                                alVar4.f.e(null);
                                alVar4.u.a(null);
                                alVar4.m.e(alVar4.u);
                                alVar4.v.d(null);
                                alVar4.m.e(alVar4.v);
                                alVar4.w.a(null);
                                alVar4.m.e(alVar4.w);
                                alVar4.x.a(null);
                                alVar4.m.e(alVar4.x);
                                alVar4.y.a(null);
                                alVar4.m.e(alVar4.y);
                                alVar4.z.h(null);
                                alVar4.m.e(alVar4.b);
                                alVar4.m.e(alVar4.d);
                                alVar4.m.e(alVar4.f);
                                alVar4.f.a();
                                alVar4.m.e(alVar4.z);
                                alVar4.z.g();
                                alVar4.m.e(alVar4);
                                bu buVar = alVar4.q;
                                if (buVar != null) {
                                    buVar.b();
                                    bu buVar2 = alVar4.q;
                                    com.google.android.libraries.navigation.internal.ia.e eVar = alVar4.m;
                                    com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                    if (buVar2.i != null) {
                                        eVar.e(buVar2);
                                        buVar2.e.d(buVar2.h);
                                        buVar2.f.b(buVar2.h);
                                        buVar2.i.a();
                                    }
                                }
                                alVar4.g.k(alVar4.r, false, false);
                                alVar4.g(false, true, false);
                                alVar4.s = false;
                            }
                        });
                    }
                    acVar = this.l;
                    if (acVar != null) {
                        acVar.e();
                        this.l = null;
                    }
                    this.P = false;
                    ((com.google.android.libraries.navigation.internal.fr.e) this.f.a()).b(false);
                }
            } else if (this.P) {
                int i218 = com.google.android.libraries.navigation.internal.km.l.a;
                int i219 = com.google.android.libraries.navigation.internal.fp.a.a;
                alVar = this.i;
                if (alVar != null) {
                    alVar.p.execute(new Runnable() { // from class: com.google.android.apps.gmm.location.navigation.af
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                            al alVar4 = alVar;
                            if (alVar4.D) {
                                return;
                            }
                            alVar4.D = true;
                            com.google.android.libraries.navigation.internal.dd.d dVar = alVar4.M;
                            com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                            if (dVar.b != alVar4) {
                                com.google.android.libraries.navigation.internal.zb.h hVar3 = (com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.dd.d.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(321);
                                Object obj = dVar.b;
                                if (obj == null) {
                                    obj = BuildConfig.TRAVIS;
                                }
                                hVar3.x("Invalid unsubscription current:%s unsubscribed:%s", obj, alVar4);
                            }
                            dVar.b = null;
                            alVar4.k.b(alVar4.N);
                            alVar4.l.d(alVar4.O);
                            alVar4.F.cancel(false);
                            n nVar = alVar4.e;
                            nVar.a = -1L;
                            nVar.b = 0.0d;
                            alVar4.d.a();
                            alVar4.f.e(null);
                            alVar4.u.a(null);
                            alVar4.m.e(alVar4.u);
                            alVar4.v.d(null);
                            alVar4.m.e(alVar4.v);
                            alVar4.w.a(null);
                            alVar4.m.e(alVar4.w);
                            alVar4.x.a(null);
                            alVar4.m.e(alVar4.x);
                            alVar4.y.a(null);
                            alVar4.m.e(alVar4.y);
                            alVar4.z.h(null);
                            alVar4.m.e(alVar4.b);
                            alVar4.m.e(alVar4.d);
                            alVar4.m.e(alVar4.f);
                            alVar4.f.a();
                            alVar4.m.e(alVar4.z);
                            alVar4.z.g();
                            alVar4.m.e(alVar4);
                            bu buVar = alVar4.q;
                            if (buVar != null) {
                                buVar.b();
                                bu buVar2 = alVar4.q;
                                com.google.android.libraries.navigation.internal.ia.e eVar = alVar4.m;
                                com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
                                if (buVar2.i != null) {
                                    eVar.e(buVar2);
                                    buVar2.e.d(buVar2.h);
                                    buVar2.f.b(buVar2.h);
                                    buVar2.i.a();
                                }
                            }
                            alVar4.g.k(alVar4.r, false, false);
                            alVar4.g(false, true, false);
                            alVar4.s = false;
                        }
                    });
                }
                acVar = this.l;
                if (acVar != null) {
                    acVar.e();
                    this.l = null;
                }
                this.P = false;
                ((com.google.android.libraries.navigation.internal.fr.e) this.f.a()).b(false);
            }
            if (!z) {
                if (this.s) {
                    int i1110 = com.google.android.libraries.navigation.internal.km.l.a;
                    int i1111 = com.google.android.libraries.navigation.internal.fp.a.a;
                    amVar = this.m;
                    if (amVar != null) {
                        ap.LOCATION_SENSORS.f();
                        amVar.e = false;
                        amVar.f.cancel(false);
                        amVar.a.c();
                        this.s = false;
                    }
                }
            } else if (this.s) {
                int i1112 = com.google.android.libraries.navigation.internal.km.l.a;
                int i1113 = com.google.android.libraries.navigation.internal.fp.a.a;
                amVar = this.m;
                if (amVar != null) {
                    ap.LOCATION_SENSORS.f();
                    amVar.e = false;
                    amVar.f.cancel(false);
                    amVar.a.c();
                    this.s = false;
                }
            }
            if (this.Q) {
                this.Q = false;
            }
            if (!z) {
                z3 = false;
            } else {
                z3 = false;
            }
            z4 = this.R;
            if (!z4) {
                if (z4) {
                    int i1114 = com.google.android.libraries.navigation.internal.km.l.a;
                    int i1115 = com.google.android.libraries.navigation.internal.fp.a.a;
                    afVar = this.f383n;
                    if (afVar != null) {
                        afVar.a();
                    }
                    this.R = false;
                }
            } else if (z4) {
                int i1116 = com.google.android.libraries.navigation.internal.km.l.a;
                int i1117 = com.google.android.libraries.navigation.internal.fp.a.a;
                afVar = this.f383n;
                if (afVar != null) {
                    afVar.a();
                }
                this.R = false;
            }
            if (!z) {
                z5 = false;
            } else {
                z5 = false;
            }
            z6 = this.V;
            if (z6) {
                if (z6) {
                    hVar = this.p;
                    if (hVar != null) {
                        hVar.a.unregisterListener(hVar);
                    }
                    this.V = false;
                }
            } else if (z5) {
                hVar2 = this.p;
                if (hVar2 != null) {
                    aVar2 = (com.google.android.libraries.navigation.internal.kl.a) this.K.a();
                    hVar2.c = aVar2;
                    if (hVar2.b == null) {
                        com.google.android.apps.gmm.location.navigation.ap.a(aVar2, 13, false);
                    } else {
                        com.google.android.apps.gmm.location.navigation.ap.a(aVar2, 13, hVar2.a.registerListener(hVar2, hVar2.b, DurationKt.NANOS_IN_MILLIS, new Handler()));
                    }
                }
                this.V = true;
            } else {
                z5 = false;
                if (z6) {
                    hVar = this.p;
                    if (hVar != null) {
                        hVar.a.unregisterListener(hVar);
                    }
                    this.V = false;
                }
            }
            if (!this.v) {
                z7 = false;
            } else {
                z7 = false;
            }
            z8 = this.Y;
            if (z8) {
                if (z8) {
                    this.Y = false;
                }
            } else if (z7) {
                this.Y = true;
            } else {
                z7 = false;
                if (z8) {
                    this.Y = false;
                }
            }
            if (!z) {
                z9 = false;
            } else {
                z9 = false;
            }
            z10 = this.W;
            if (z10) {
                if (z10) {
                    int i1118 = com.google.android.libraries.navigation.internal.km.l.a;
                    int i1119 = com.google.android.libraries.navigation.internal.fp.a.a;
                    kVar = this.o;
                    if (kVar != null) {
                        kVar.c();
                    }
                    this.W = false;
                }
            } else if (z9) {
                int i2110 = com.google.android.libraries.navigation.internal.km.l.a;
                int i2111 = com.google.android.libraries.navigation.internal.fp.a.a;
                kVar2 = this.o;
                if (kVar2 != null) {
                    kVar2.b((com.google.android.libraries.navigation.internal.kl.a) this.K.a());
                }
                this.W = true;
            } else {
                z9 = false;
                if (z10) {
                    int i11110 = com.google.android.libraries.navigation.internal.km.l.a;
                    int i11111 = com.google.android.libraries.navigation.internal.fp.a.a;
                    kVar = this.o;
                    if (kVar != null) {
                        kVar.c();
                    }
                    this.W = false;
                }
            }
            if (l()) {
                this.g.m(com.google.android.libraries.navigation.internal.iv.ab.bi);
                this.H.a();
            }
        }
    }

    public final void k() {
        this.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.cx.d
            @Override // java.lang.Runnable
            public final void run() {
                this.a.j();
            }
        });
    }

    public final boolean l() {
        return this.z.b();
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarE = com.google.android.libraries.navigation.internal.yx.al.b(this).e("isActivityAttached", this.N).e("isEnabled()", l());
        akVarE.g("currentTravelMode", this.u);
        com.google.android.libraries.navigation.internal.yx.ak akVarE2 = akVarE.e("isTransitGuiding", false).e("isCarConnected", false).e("isSemanticLocationScanningStarted", false);
        akVarE2.g("genericClientCount", this.Z);
        com.google.android.libraries.navigation.internal.yx.ak akVarE3 = akVarE2.e("areLocationSensorsStarted", this.P).e("areInertialSensorsStarted", this.R).e("inertialSensorsWorking", this.S).e("isCarBearingEventPosterStarted", false).e("areBleBeaconSensorsStarted", this.W).e("isPressureSensorStarted", this.V);
        akVarE3.g("lastLocation", this.y);
        return akVarE3.toString();
    }
}
