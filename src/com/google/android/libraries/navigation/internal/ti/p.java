package com.google.android.libraries.navigation.internal.ti;

import android.content.Context;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.ael.am;
import com.google.android.libraries.navigation.internal.db.ap;
import com.google.android.libraries.navigation.internal.db.aq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.zs.bt;
import com.google.android.libraries.navigation.internal.zs.bx;
import com.google.android.libraries.navigation.internal.zs.cm;
import com.google.android.libraries.navigation.internal.zs.cn;
import com.google.android.libraries.navigation.internal.zs.cz;
import com.google.android.libraries.navigation.internal.zs.db;
import com.google.android.libraries.navigation.internal.zs.dt;
import com.google.android.libraries.navigation.internal.zs.eq;
import com.google.android.libraries.navigation.internal.zs.er;
import j$.time.Duration;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class p {
    private static final com.google.android.libraries.navigation.internal.zb.j K = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.ti.p");
    public static final long a = TimeUnit.MINUTES.toMillis(5);
    public static final fd b;
    public final AtomicReference A;
    public long B;
    public boolean C;
    public long D;
    com.google.android.libraries.navigation.internal.se.b E;
    public final m F;
    public final o G;
    public final com.google.android.libraries.navigation.internal.sj.a H;
    public final com.google.android.libraries.navigation.internal.aaa.c I;
    public final k J;
    private final com.google.android.libraries.navigation.internal.kl.b L;
    private final com.google.android.libraries.navigation.internal.cw.a M;
    private final com.google.android.libraries.navigation.internal.hn.p O;
    private final Optional P;
    private boolean Q;
    public final com.google.android.libraries.navigation.internal.rw.q c;
    public final Executor d;
    public final com.google.android.libraries.navigation.internal.ia.e e;
    public final com.google.android.libraries.navigation.internal.mj.a f;
    public final ad g;
    public final ac h;
    public final e i;
    public final af j;
    public final af k;
    public final d l;
    public bt m;
    public bx o;
    public final Optional s;
    public ev w;
    public final AtomicInteger x;
    public final ArrayList y;
    public final AtomicBoolean z;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f596n = Long.MIN_VALUE;
    public long p = Long.MIN_VALUE;
    public final ArrayDeque q = new ArrayDeque();
    public final ArrayDeque r = new ArrayDeque();
    public final AtomicBoolean t = new AtomicBoolean(false);
    private final w N = new w();
    public final com.google.android.libraries.navigation.internal.nt.t u = new l(this);
    public boolean v = false;

    static {
        ez ezVar = new ez();
        ezVar.f(0, com.google.android.libraries.navigation.internal.zs.q.IN_VEHICLE);
        ezVar.f(1, com.google.android.libraries.navigation.internal.zs.q.ON_BICYCLE);
        ezVar.f(2, com.google.android.libraries.navigation.internal.zs.q.ON_FOOT);
        ezVar.f(3, com.google.android.libraries.navigation.internal.zs.q.STILL);
        ezVar.f(4, com.google.android.libraries.navigation.internal.zs.q.UNKNOWN);
        ezVar.f(5, com.google.android.libraries.navigation.internal.zs.q.TILTING);
        ezVar.f(6, com.google.android.libraries.navigation.internal.zs.q.EXITING_VEHICLE);
        ezVar.f(7, com.google.android.libraries.navigation.internal.zs.q.WALKING);
        ezVar.f(8, com.google.android.libraries.navigation.internal.zs.q.RUNNING);
        ezVar.f(9, com.google.android.libraries.navigation.internal.zs.q.OFF_BODY);
        ezVar.f(15, com.google.android.libraries.navigation.internal.zs.q.SLEEPING);
        ezVar.f(16, com.google.android.libraries.navigation.internal.zs.q.IN_ROAD_VEHICLE);
        ezVar.f(17, com.google.android.libraries.navigation.internal.zs.q.IN_RAIL_VEHICLE);
        ezVar.f(18, com.google.android.libraries.navigation.internal.zs.q.IN_TWO_WHEELER_VEHICLE);
        ezVar.f(19, com.google.android.libraries.navigation.internal.zs.q.IN_FOUR_WHEELER_VEHICLE);
        ezVar.f(20, com.google.android.libraries.navigation.internal.zs.q.IN_CAR);
        ezVar.f(21, com.google.android.libraries.navigation.internal.zs.q.IN_BUS);
        b = ezVar.d();
    }

    public p(Context context, com.google.android.libraries.navigation.internal.fr.l lVar, com.google.android.libraries.navigation.internal.sl.l lVar2, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.gq.ab abVar, com.google.android.libraries.navigation.internal.rw.q qVar, com.google.android.libraries.navigation.internal.sj.a aVar, Executor executor, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.mj.a aVar2, bn bnVar, com.google.android.libraries.navigation.internal.kl.b bVar, com.google.android.libraries.navigation.internal.cw.a aVar3, com.google.android.libraries.navigation.internal.aq.m mVar, com.google.android.libraries.navigation.internal.au.c cVar, com.google.android.libraries.navigation.internal.hn.p pVar, ad adVar, com.google.android.libraries.navigation.internal.fz.d dVar, Optional optional, Optional optional2, com.google.android.libraries.navigation.internal.aaa.c cVar2, Optional optional3) {
        int i = ev.d;
        this.w = lv.a;
        this.y = new ArrayList();
        this.Q = false;
        this.z = new AtomicBoolean(false);
        this.A = new AtomicReference(null);
        this.B = Long.MIN_VALUE;
        this.C = false;
        this.D = 0L;
        this.c = qVar;
        this.H = aVar;
        this.d = executor;
        this.e = eVar;
        this.f = aVar2;
        this.L = bVar;
        this.M = aVar3;
        this.O = pVar;
        this.I = cVar2;
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.x = atomicInteger;
        this.g = adVar;
        this.s = optional;
        h hVar = new h(bVar, bnVar, adVar, abVar);
        af afVar = new af();
        this.k = afVar;
        af afVar2 = new af();
        this.j = afVar2;
        e eVar2 = new e(aVar2, adVar);
        this.i = eVar2;
        this.l = new d(fVar, lVar, context, lVar2, mVar, cVar, pVar, optional2);
        this.h = new ac(fVar, eVar, executor, aVar2, bnVar, adVar, afVar, afVar2, eVar2, hVar, atomicInteger, optional3);
        this.J = new k(context);
        this.F = new m(this);
        this.G = new o(this);
        this.P = Optional.empty();
    }

    public static am b(Duration duration) {
        try {
            return com.google.android.libraries.navigation.internal.aen.b.a(duration);
        } catch (IllegalArgumentException unused) {
            return com.google.android.libraries.navigation.internal.aen.a.a;
        }
    }

    public final n a(int i) {
        for (int i2 = 0; i2 < this.y.size(); i2++) {
            n nVar = (n) this.y.get(i2);
            if (nVar.a == i) {
                this.y.remove(i2);
                return nVar;
            }
        }
        return null;
    }

    public final void c(String str, com.google.android.libraries.navigation.internal.db.r rVar, boolean z) {
        u uVar;
        if (g(str)) {
            aq aqVar = rVar.l().D;
            long j = rVar.l().s;
            w wVar = this.N;
            if (aqVar == null) {
                uVar = new u(null, null);
            } else {
                dt dtVarA = w.a(wVar.b, aqVar, j, wVar.a, new v() { // from class: com.google.android.libraries.navigation.internal.ti.r
                    @Override // com.google.android.libraries.navigation.internal.ti.v
                    public final boolean a(ap apVar) {
                        return apVar.c;
                    }
                });
                dt dtVarA2 = w.a(wVar.b, aqVar, j, wVar.a, new v() { // from class: com.google.android.libraries.navigation.internal.ti.s
                    @Override // com.google.android.libraries.navigation.internal.ti.v
                    public final boolean a(ap apVar) {
                        return apVar.d;
                    }
                });
                long j2 = wVar.a + 1;
                wVar.a = j2;
                if (j2 == 2147483648L) {
                    wVar.a = 0L;
                }
                wVar.b = aqVar;
                uVar = new u(dtVarA, dtVarA2);
            }
            dt dtVar = uVar.a;
            if (dtVar != null) {
                ac acVar = this.h;
                cz czVar = (cz) db.a.q();
                if (!czVar.b.H()) {
                    czVar.v();
                }
                db dbVar = (db) czVar.b;
                dbVar.d = dtVar;
                dbVar.c = 46;
                acVar.c(czVar);
            }
            dt dtVar2 = uVar.b;
            if (dtVar2 != null) {
                ac acVar2 = this.h;
                cz czVar2 = (cz) db.a.q();
                if (!czVar2.b.H()) {
                    czVar2.v();
                }
                db dbVar2 = (db) czVar2.b;
                dbVar2.d = dtVar2;
                dbVar2.c = 47;
                acVar2.c(czVar2);
            }
            if (rVar.l().m || rVar.l().f385n || rVar.l().p) {
                cm cmVar = (cm) cn.a.q();
                boolean z2 = rVar.l().m;
                if (!cmVar.b.H()) {
                    cmVar.v();
                }
                cn cnVar = (cn) cmVar.b;
                cnVar.b |= 2;
                cnVar.d = z2;
                boolean z3 = rVar.l().f385n;
                if (!cmVar.b.H()) {
                    cmVar.v();
                }
                cn cnVar2 = (cn) cmVar.b;
                cnVar2.b |= 4;
                cnVar2.e = z3;
                boolean z4 = rVar.l().p;
                if (!cmVar.b.H()) {
                    cmVar.v();
                }
                cn cnVar3 = (cn) cmVar.b;
                cnVar3.b |= 8;
                cnVar3.f = z4;
                long j3 = rVar.l().s;
                if (j3 != -1) {
                    if (!cmVar.b.H()) {
                        cmVar.v();
                    }
                    cn cnVar4 = (cn) cmVar.b;
                    cnVar4.b |= 1;
                    cnVar4.c = j3;
                }
                cz czVar3 = (cz) db.a.q();
                if (!czVar3.b.H()) {
                    czVar3.v();
                }
                db dbVar3 = (db) czVar3.b;
                cn cnVar5 = (cn) cmVar.t();
                cnVar5.getClass();
                dbVar3.d = cnVar5;
                dbVar3.c = 5;
                this.h.d(czVar3, Long.valueOf(com.google.android.libraries.navigation.internal.ja.a.a(rVar.g)), false, null, null);
            }
            long jA = com.google.android.libraries.navigation.internal.ja.a.a(rVar.g);
            bt btVar = this.m;
            if (btVar != null) {
                if (jA - this.f596n <= this.g.a.f) {
                    cz czVar4 = (cz) db.a.q();
                    if (!czVar4.b.H()) {
                        czVar4.v();
                    }
                    db dbVar4 = (db) czVar4.b;
                    dbVar4.d = btVar;
                    dbVar4.c = 20;
                    this.h.c(czVar4);
                }
                this.m = null;
                this.f596n = Long.MIN_VALUE;
            }
            long jA2 = com.google.android.libraries.navigation.internal.ja.a.a(rVar.g);
            bx bxVar = this.o;
            if (bxVar != null) {
                if (jA2 - this.p <= this.g.a.f) {
                    cz czVar5 = (cz) db.a.q();
                    if (!czVar5.b.H()) {
                        czVar5.v();
                    }
                    db dbVar5 = (db) czVar5.b;
                    dbVar5.d = bxVar;
                    dbVar5.c = 19;
                    this.h.c(czVar5);
                }
                this.o = null;
                this.p = Long.MIN_VALUE;
            }
            Duration duration = rVar.g;
            ArrayDeque arrayDeque = this.q;
            long jA3 = com.google.android.libraries.navigation.internal.ja.a.a(duration);
            arrayDeque.size();
            if (!this.q.isEmpty()) {
                while (!this.q.isEmpty()) {
                    com.google.android.libraries.navigation.internal.sr.b bVar = (com.google.android.libraries.navigation.internal.sr.b) this.q.peekLast();
                    Long l = (Long) this.r.peekLast();
                    if (bVar != null && l != null) {
                        if (jA3 - l.longValue() > this.g.a.f) {
                            break;
                        }
                        this.q.removeLast();
                        this.r.removeLast();
                        h();
                    } else {
                        this.q.removeLast();
                        this.r.removeLast();
                    }
                }
            }
            com.google.android.libraries.navigation.internal.ja.a.a(rVar.g);
            this.h.e(rVar, false);
        }
        this.h.f(z);
    }

    public final void d(boolean z, Runnable runnable) {
        this.z.set(false);
        this.A.set(null);
        this.c.b(this.F);
        this.H.d(this.G);
        this.e.e(this);
        if (g("onSessionStop")) {
            eq eqVar = (eq) er.a.q();
            if (!eqVar.b.H()) {
                eqVar.v();
            }
            er erVar = (er) eqVar.b;
            erVar.b |= 1;
            erVar.c = z;
            cz czVar = (cz) db.a.q();
            if (!czVar.b.H()) {
                czVar.v();
            }
            db dbVar = (db) czVar.b;
            er erVar2 = (er) eqVar.t();
            erVar2.getClass();
            dbVar.d = erVar2;
            dbVar.c = 21;
            this.h.c(czVar);
            com.google.android.libraries.navigation.internal.db.r rVarB = this.M.b();
            if (rVarB != null) {
                this.h.e(rVarB, true);
            }
        }
        if (this.t.compareAndSet(true, false)) {
            this.s.isPresent();
        }
        ac acVar = this.h;
        if (acVar.d != Long.MAX_VALUE) {
            acVar.b(runnable, acVar.a(acVar.a.a()));
        }
        int i = ev.d;
        this.w = lv.a;
    }

    public final boolean e(int i) {
        return this.i.d() || i < this.g.e;
    }

    public final boolean f() {
        return this.z.get();
    }

    public final boolean g(String str) {
        al alVar = this.i.h;
        if (alVar != al.DRIVE && alVar != al.TAXICAB && alVar != al.TWO_WHEELER && alVar != al.TRANSIT && alVar != al.WALK && alVar != al.BICYCLE) {
            return false;
        }
        if (alVar == al.WALK) {
            boolean z = this.O.a.ax;
            return false;
        }
        if (alVar == al.BICYCLE) {
            boolean z2 = this.O.a.ay;
            return false;
        }
        if (!this.Q) {
            this.Q = true;
            com.google.android.libraries.navigation.internal.ia.e eVar = this.e;
            ad adVar = this.g;
            boolean z3 = adVar.f;
            eVar.a(new com.google.android.libraries.navigation.internal.sr.g(adVar.a()));
        }
        return true;
    }

    public final void h() {
        throw null;
    }
}
