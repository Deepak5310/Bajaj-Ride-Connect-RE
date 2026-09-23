package com.google.android.libraries.navigation.internal.ti;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.acd.ma;
import com.google.android.libraries.navigation.internal.acd.mb;
import com.google.android.libraries.navigation.internal.acd.me;
import com.google.android.libraries.navigation.internal.acd.mf;
import com.google.android.libraries.navigation.internal.acd.mg;
import com.google.android.libraries.navigation.internal.acd.mh;
import com.google.android.libraries.navigation.internal.acd.om;
import com.google.android.libraries.navigation.internal.acd.on;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.ael.am;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.ed;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.zs.cp;
import com.google.android.libraries.navigation.internal.zs.cr;
import com.google.android.libraries.navigation.internal.zs.cw;
import com.google.android.libraries.navigation.internal.zs.cz;
import com.google.android.libraries.navigation.internal.zs.da;
import com.google.android.libraries.navigation.internal.zs.db;
import com.google.android.libraries.navigation.internal.zs.dc;
import com.google.android.libraries.navigation.internal.zs.dd;
import com.google.android.libraries.navigation.internal.zs.de;
import com.google.android.libraries.navigation.internal.zs.df;
import com.google.android.libraries.navigation.internal.zs.dg;
import com.google.android.libraries.navigation.internal.zs.di;
import com.google.android.libraries.navigation.internal.zs.dl;
import com.google.android.libraries.navigation.internal.zs.ev;
import com.google.android.libraries.navigation.internal.zs.fa;
import com.google.android.libraries.navigation.internal.zs.fb;
import com.google.android.libraries.navigation.internal.zs.fh;
import com.google.android.libraries.navigation.internal.zs.fm;
import com.google.android.libraries.navigation.internal.zs.fn;
import j$.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac {
    public static final /* synthetic */ int e = 0;
    private static final long f = TimeUnit.HOURS.toMillis(1);
    private final Optional A;
    public final com.google.android.libraries.navigation.internal.mj.a a;
    public final ad b;
    public final long c;
    private final com.google.android.libraries.navigation.internal.iv.f g;
    private final bn h;
    private final e i;
    private final h j;
    private final long k;
    private final i q;
    private final ae r;
    private int v;
    private int w;
    private final AtomicInteger y;
    private boolean z;
    public long d = Long.MAX_VALUE;
    private int l = 0;
    private long m = Long.MIN_VALUE;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f592n = Long.MIN_VALUE;
    private boolean p = false;
    private final Map x = new HashMap();
    private final List s = new ArrayList();
    private final List u = new ArrayList();
    private boolean o = false;
    private final List t = new ArrayList();

    public ac(com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.ia.e eVar, Executor executor, com.google.android.libraries.navigation.internal.mj.a aVar, bn bnVar, ad adVar, af afVar, af afVar2, e eVar2, h hVar, AtomicInteger atomicInteger, Optional optional) {
        this.g = fVar;
        this.a = aVar;
        this.h = bnVar;
        this.b = adVar;
        this.i = eVar2;
        this.j = hVar;
        this.y = atomicInteger;
        this.c = adVar.g;
        this.k = adVar.h;
        this.q = new i(eVar, executor, adVar, afVar, afVar2, eVar2);
        this.r = new ae(adVar, eVar2, afVar);
        this.A = optional;
    }

    private final long h() {
        long j = this.f592n;
        if (j == Long.MIN_VALUE) {
            return 0L;
        }
        return j - this.k;
    }

    private final void i(cz czVar, long j, boolean z, bg bgVar, bq bqVar) {
        int iO;
        int iB = da.b(((db) czVar.b).c);
        String strA = da.a(iB);
        if (iB == 0) {
            throw null;
        }
        if (z) {
            if (!czVar.b.H()) {
                czVar.v();
            }
            db dbVar = (db) czVar.b;
            dbVar.b |= 1;
            dbVar.e = true;
        }
        fh fhVarA = this.r.a(bgVar, bqVar);
        if (fhVarA != null) {
            if (!czVar.b.H()) {
                czVar.v();
            }
            db dbVar2 = (db) czVar.b;
            dbVar2.g = fhVarA;
            dbVar2.b |= 4;
        }
        ed edVarB = com.google.android.libraries.navigation.internal.aen.d.b(a(j));
        if (!czVar.b.H()) {
            czVar.v();
        }
        db dbVar3 = (db) czVar.b;
        edVarB.getClass();
        dbVar3.f = edVarB;
        dbVar3.b |= 2;
        db dbVar4 = (db) czVar.t();
        this.s.add(dbVar4);
        if (this.A.isPresent()) {
            int i = aa.a;
        }
        if (dbVar4.H()) {
            iO = dbVar4.o(null);
            if (iO < 0) {
                throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(iO, "serialized size must be non-negative, was "));
            }
        } else {
            int iO2 = dbVar4.am & Integer.MAX_VALUE;
            if (iO2 == Integer.MAX_VALUE) {
                iO2 = dbVar4.o(null);
                if (iO2 < 0) {
                    throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(iO2, "serialized size must be non-negative, was "));
                }
                dbVar4.am = (dbVar4.am & Integer.MIN_VALUE) | iO2;
            }
            iO = iO2;
        }
        this.f592n = Math.max(this.f592n, j);
        this.w++;
        this.v += iO;
        l(strA, iO);
    }

    private final void j(long j, boolean z) {
        cz czVar = (cz) db.a.q();
        if (!czVar.b.H()) {
            czVar.v();
        }
        ad adVar = this.b;
        db dbVar = (db) czVar.b;
        fb fbVar = adVar.a;
        fbVar.getClass();
        dbVar.d = fbVar;
        dbVar.c = 22;
        this.A.ifPresent(new Consumer() { // from class: com.google.android.libraries.navigation.internal.ti.y
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                int i = ac.e;
                int i2 = z.a;
            }
        });
        i(czVar, j, z, null, null);
    }

    private static void k(StringBuilder sb, long j, String str, int i, int i2) {
        sb.append(", ");
        sb.append(str);
        sb.append(" bytes: ");
        sb.append(i);
        sb.append(" (");
        long j2 = f;
        sb.append((((long) i) * j2) / j);
        sb.append(" per hour), ");
        sb.append(str);
        sb.append(" events: ");
        sb.append(i2);
        sb.append(" (");
        sb.append((((long) i2) * j2) / j);
        sb.append(" per hour)");
    }

    private final void l(String str, int i) {
        ab abVar = (ab) this.x.get(str);
        if (abVar == null) {
            abVar = ab.a;
        }
        this.x.put(str, new a(abVar.a() + i, abVar.b() + 1));
    }

    private final boolean m() {
        if (this.d == Long.MAX_VALUE) {
            ad adVar = this.b;
            com.google.android.libraries.navigation.internal.mj.a aVar = this.a;
            int i = adVar.a.f;
            this.d = aVar.f().toEpochMilli() + TimeUnit.SECONDS.toMillis(this.b.a.h);
            this.l = this.b.a.g * i;
        }
        if (this.o) {
            return false;
        }
        this.o = true;
        return true;
    }

    private final boolean n(com.google.android.libraries.navigation.internal.db.r rVar) {
        return this.b.a.u > 0 && !this.i.e(rVar);
    }

    public final long a(long j) {
        ar.k(this.c != Long.MAX_VALUE);
        return this.c + (j - this.k);
    }

    final void c(cz czVar) {
        d(czVar, null, false, null, null);
    }

    final void d(cz czVar, Long l, boolean z, bg bgVar, bq bqVar) {
        if (!this.b.a.e) {
            int i = ((db) czVar.b).c;
            return;
        }
        boolean z2 = true;
        if (!this.i.d() && !z) {
            z2 = false;
        }
        boolean z3 = z2;
        long jA = l == null ? this.a.a() : l.longValue();
        if (m()) {
            j(jA, z3);
        }
        i(czVar, jA, z3, bgVar, bqVar);
        fb fbVar = this.b.a;
        int i2 = fbVar.f;
        int i3 = fbVar.p * i2;
        if (i3 <= 0) {
            return;
        }
        long j = this.m;
        if (j != Long.MIN_VALUE) {
            long j2 = jA - j;
            long j3 = i3;
            if (j2 > j3) {
                int i4 = this.l;
                if ((j + ((long) i4)) - jA > j3) {
                    long j4 = i2;
                    int i5 = ((int) (((j2 + j4) - 1) / j4)) * i2;
                    if (i5 < i4) {
                        this.l = i5;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00b5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x00b7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:41:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:47:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:51:0x00d9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00db  */
    /* JADX WARN: Code duplicated, block: B:55:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:56:0x00fb  */
    final void e(com.google.android.libraries.navigation.internal.db.r rVar, boolean z) {
        i iVar;
        cp cpVarA;
        cp cpVarA2;
        fb fbVar;
        int i;
        fb fbVar2 = this.b.a;
        if (fbVar2.e || fbVar2.d) {
            Duration duration = rVar.g;
            e eVar = this.i;
            long jA = com.google.android.libraries.navigation.internal.ja.a.a(duration);
            boolean zD = eVar.d();
            if (m()) {
                j(jA, zD);
            }
            if (n(rVar)) {
                fb fbVar3 = this.b.a;
                int i2 = fbVar3.u * fbVar3.f;
                if (i2 < this.l) {
                    this.l = i2;
                }
            }
            if ((!z || jA < this.m) && jA < this.m + ((long) this.l)) {
                return;
            }
            int i3 = dd.a;
            dd.a(i3);
            cp cpVarA3 = null;
            if (i3 == 0) {
                throw null;
            }
            rVar.B();
            i iVar2 = this.q;
            long jA2 = a(jA);
            com.google.android.libraries.navigation.internal.db.r rVar2 = rVar.k;
            if (!rVar.B() || rVar2 == null) {
                com.google.android.libraries.navigation.internal.db.r rVar3 = rVar2;
                if (rVar.B()) {
                    cpVarA2 = iVar2.a(cr.CLIENT_SNAPPED_ONLY, zD, jA2, rVar);
                    iVar = iVar2;
                    cpVarA = null;
                } else {
                    if (rVar3 == null) {
                        rVar3 = rVar;
                    }
                    iVar = iVar2;
                    cpVarA = iVar2.a(cr.RAW_ONLY, zD, jA2, rVar3);
                }
                if (cpVarA2 != null && cpVarA != null) {
                    iVar.b(cpVarA);
                } else if (cpVarA == null || cpVarA2 == null) {
                    fbVar = iVar.a.a;
                    if (fbVar.s) {
                        if (fbVar.q && cpVarA2 != null) {
                            iVar.b(cpVarA2);
                        } else if (cpVarA != null) {
                            iVar.b(cpVarA);
                            iVar.b(cpVarA2);
                        }
                    } else if (fbVar.r && cpVarA != null) {
                        iVar.b(cpVarA);
                    } else if (cpVarA != null) {
                        iVar.b(cpVarA);
                        iVar.b(cpVarA2);
                    }
                } else {
                    iVar.b(cpVarA2);
                }
                int i4 = this.b.a.f;
                this.m = jA - (jA % ((long) i4));
                if (n(rVar)) {
                    i = this.b.a.u;
                } else {
                    i = this.b.a.g;
                }
                this.l = i * i4;
                this.f592n = Math.max(this.f592n, jA);
            }
            cpVarA3 = iVar2.a(cr.CLIENT_SNAPPED, zD, jA2, rVar);
            cpVarA = iVar2.a(cr.RAW, zD, jA2, rVar2);
            iVar = iVar2;
            cpVarA2 = cpVarA3;
            if (cpVarA2 != null) {
                if (cpVarA == null) {
                    fbVar = iVar.a.a;
                    if (fbVar.s) {
                        if (fbVar.q) {
                            if (cpVarA != null) {
                                iVar.b(cpVarA);
                                iVar.b(cpVarA2);
                            }
                        } else if (cpVarA != null) {
                            iVar.b(cpVarA);
                            iVar.b(cpVarA2);
                        }
                    } else if (fbVar.r) {
                        if (cpVarA != null) {
                            iVar.b(cpVarA);
                            iVar.b(cpVarA2);
                        }
                    } else if (cpVarA != null) {
                        iVar.b(cpVarA);
                        iVar.b(cpVarA2);
                    }
                } else {
                    fbVar = iVar.a.a;
                    if (fbVar.s) {
                        if (fbVar.q) {
                            if (cpVarA != null) {
                                iVar.b(cpVarA);
                                iVar.b(cpVarA2);
                            }
                        } else if (cpVarA != null) {
                            iVar.b(cpVarA);
                            iVar.b(cpVarA2);
                        }
                    } else if (fbVar.r) {
                        if (cpVarA != null) {
                            iVar.b(cpVarA);
                            iVar.b(cpVarA2);
                        }
                    } else if (cpVarA != null) {
                        iVar.b(cpVarA);
                        iVar.b(cpVarA2);
                    }
                }
            } else if (cpVarA == null) {
                fbVar = iVar.a.a;
                if (fbVar.s) {
                    if (fbVar.q) {
                        if (cpVarA != null) {
                            iVar.b(cpVarA);
                            iVar.b(cpVarA2);
                        }
                    } else if (cpVarA != null) {
                        iVar.b(cpVarA);
                        iVar.b(cpVarA2);
                    }
                } else if (fbVar.r) {
                    if (cpVarA != null) {
                        iVar.b(cpVarA);
                        iVar.b(cpVarA2);
                    }
                } else if (cpVarA != null) {
                    iVar.b(cpVarA);
                    iVar.b(cpVarA2);
                }
            } else {
                fbVar = iVar.a.a;
                if (fbVar.s) {
                    if (fbVar.q) {
                        if (cpVarA != null) {
                            iVar.b(cpVarA);
                            iVar.b(cpVarA2);
                        }
                    } else if (cpVarA != null) {
                        iVar.b(cpVarA);
                        iVar.b(cpVarA2);
                    }
                } else if (fbVar.r) {
                    if (cpVarA != null) {
                        iVar.b(cpVarA);
                        iVar.b(cpVarA2);
                    }
                } else if (cpVarA != null) {
                    iVar.b(cpVarA);
                    iVar.b(cpVarA2);
                }
            }
            int i5 = this.b.a.f;
            this.m = jA - (jA % ((long) i5));
            if (n(rVar)) {
                i = this.b.a.u;
            } else {
                i = this.b.a.g;
            }
            this.l = i * i5;
            this.f592n = Math.max(this.f592n, jA);
        }
    }

    final void f(boolean z) {
        if (this.d == Long.MAX_VALUE || this.g.y(com.google.android.libraries.navigation.internal.iv.ab.D, false)) {
            return;
        }
        long jA = a(this.a.a());
        if (jA < this.d && !z) {
            this.j.i(jA, false);
            return;
        }
        b(null, jA);
        this.d = jA + TimeUnit.SECONDS.toMillis(this.b.a.h);
    }

    public final synchronized void g() {
        ar.k(!this.z);
        this.j.h();
        StringBuilder sb = new StringBuilder();
        long jH = h();
        sb.append("session length: ");
        sb.append(TimeUnit.MILLISECONDS.toSeconds(jH));
        sb.append("s");
        this.j.d(sb, jH);
        if (jH > 0) {
            i iVar = this.q;
            k(sb, jH, "Location sample", iVar.f, iVar.e);
            k(sb, jH, "Client event", this.v, this.w);
            k(sb, jH, "Sensor observation event", 0, 0);
            for (Map.Entry entry : this.x.entrySet()) {
                k(sb, jH, (String) entry.getKey(), ((ab) entry.getValue()).a(), ((ab) entry.getValue()).b());
            }
        }
        this.z = true;
    }

    /* JADX WARN: Code duplicated, block: B:119:0x0318  */
    public final void b(final Runnable runnable, long j) {
        int iO;
        boolean z;
        boolean z2;
        if (runnable != null && !this.p && this.o && this.f592n != Long.MIN_VALUE) {
            fm fmVar = (fm) fn.a.q();
            am amVarA = com.google.android.libraries.navigation.internal.aen.a.a(h());
            if (!fmVar.b.H()) {
                fmVar.v();
            }
            fn fnVar = (fn) fmVar.b;
            amVarA.getClass();
            fnVar.c = amVarA;
            fnVar.b |= 1;
            int i = this.v + this.q.f;
            if (!fmVar.b.H()) {
                fmVar.v();
            }
            fn fnVar2 = (fn) fmVar.b;
            fnVar2.b |= 2;
            fnVar2.d = i;
            int i2 = this.w;
            if (!fmVar.b.H()) {
                fmVar.v();
            }
            fn fnVar3 = (fn) fmVar.b;
            fnVar3.b |= 4;
            fnVar3.e = i2;
            int i3 = this.q.e;
            if (!fmVar.b.H()) {
                fmVar.v();
            }
            fn fnVar4 = (fn) fmVar.b;
            fnVar4.b |= 8;
            fnVar4.f = i3;
            fn fnVar5 = (fn) fmVar.t();
            cz czVar = (cz) db.a.q();
            if (!czVar.b.H()) {
                czVar.v();
            }
            db dbVar = (db) czVar.b;
            fnVar5.getClass();
            dbVar.d = fnVar5;
            dbVar.c = 23;
            i(czVar, this.a.a(), this.i.d(), null, null);
            this.p = true;
        }
        cw cwVar = (cw) dl.a.q();
        ev evVarB = this.b.b();
        if (!cwVar.b.H()) {
            cwVar.v();
        }
        dl dlVar = (dl) cwVar.b;
        evVarB.getClass();
        dlVar.c = evVarB;
        dlVar.b |= 1;
        on onVar = null;
        if (this.q.d.size() == 0) {
            z = false;
        } else {
            dc dcVar = (dc) de.a.q();
            df dfVar = (df) dg.a.q();
            i iVar = this.q;
            List list = iVar.d;
            iVar.d = new ArrayList();
            iVar.b.clear();
            iVar.c.clear();
            if (!dfVar.b.H()) {
                dfVar.v();
            }
            dg dgVar = (dg) dfVar.b;
            bz bzVar = dgVar.b;
            if (!bzVar.c()) {
                dgVar.b = bi.A(bzVar);
            }
            com.google.android.libraries.navigation.internal.ael.b.m(list, dgVar.b);
            if (!dcVar.b.H()) {
                dcVar.v();
            }
            de deVar = (de) dcVar.b;
            dg dgVar2 = (dg) dfVar.t();
            dgVar2.getClass();
            deVar.c = dgVar2;
            deVar.b = 1;
            de deVar2 = (de) dcVar.t();
            cwVar.b(deVar2);
            int i4 = dd.a;
            String strA = dd.a(i4);
            if (i4 == 0) {
                throw null;
            }
            if (deVar2.H()) {
                iO = deVar2.o(null);
                if (iO < 0) {
                    throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(iO, "serialized size must be non-negative, was "));
                }
            } else {
                int iO2 = deVar2.am & Integer.MAX_VALUE;
                if (iO2 == Integer.MAX_VALUE) {
                    iO2 = deVar2.o(null);
                    if (iO2 < 0) {
                        throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(iO2, "serialized size must be non-negative, was "));
                    }
                    deVar2.am = (deVar2.am & Integer.MIN_VALUE) | iO2;
                }
                iO = iO2;
            }
            l(strA, iO);
            z = true;
        }
        if (this.s.size() != 0) {
            for (db dbVar2 : this.s) {
                dc dcVar2 = (dc) de.a.q();
                if (!dcVar2.b.H()) {
                    dcVar2.v();
                }
                de deVar3 = (de) dcVar2.b;
                dbVar2.getClass();
                deVar3.c = dbVar2;
                deVar3.b = 2;
                cwVar.a(dcVar2);
            }
            this.s.clear();
            this.r.a = null;
        }
        for (cz czVar2 : c.a.a()) {
            ed edVar = ((db) czVar2.b).f;
            if (edVar == null) {
                edVar = ed.a;
            }
            ed edVarB = com.google.android.libraries.navigation.internal.aen.d.b(a(com.google.android.libraries.navigation.internal.aen.d.a(edVar)));
            if (!czVar2.b.H()) {
                czVar2.v();
            }
            db dbVar3 = (db) czVar2.b;
            edVarB.getClass();
            dbVar3.f = edVarB;
            dbVar3.b |= 2;
            dc dcVar3 = (dc) de.a.q();
            if (!dcVar3.b.H()) {
                dcVar3.v();
            }
            de deVar4 = (de) dcVar3.b;
            db dbVar4 = (db) czVar2.t();
            dbVar4.getClass();
            deVar4.c = dbVar4;
            deVar4.b = 2;
            cwVar.a(dcVar3);
        }
        if (this.u.size() != 0) {
            for (di diVar : this.u) {
                dc dcVar4 = (dc) de.a.q();
                if (!dcVar4.b.H()) {
                    dcVar4.v();
                }
                de deVar5 = (de) dcVar4.b;
                diVar.getClass();
                deVar5.c = diVar;
                deVar5.b = 4;
                cwVar.a(dcVar4);
            }
            this.u.clear();
        }
        if (((dl) cwVar.b).d.size() != 0) {
            com.google.android.libraries.navigation.internal.acl.a aVar = (com.google.android.libraries.navigation.internal.acl.a) com.google.android.libraries.navigation.internal.acl.d.a.q();
            if (this.t.size() != 0) {
                for (com.google.android.libraries.navigation.internal.acl.c cVar : this.t) {
                    if (!aVar.b.H()) {
                        aVar.v();
                    }
                    com.google.android.libraries.navigation.internal.acl.d dVar = (com.google.android.libraries.navigation.internal.acl.d) aVar.b;
                    cVar.getClass();
                    bz bzVar2 = dVar.b;
                    if (!bzVar2.c()) {
                        dVar.b = bi.A(bzVar2);
                    }
                    dVar.b.add(cVar);
                }
                this.t.clear();
            }
            fb fbVar = this.b.a;
            boolean z3 = fbVar.e;
            if (fbVar.d) {
                int iA = fa.a(fbVar.z);
                if (iA == 0) {
                    iA = fa.a;
                }
                if (iA == fa.b && z) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            int andIncrement = this.y.getAndIncrement();
            if (!cwVar.b.H()) {
                cwVar.v();
            }
            dl dlVar2 = (dl) cwVar.b;
            dlVar2.b |= 2;
            dlVar2.e = andIncrement;
            mf mfVar = (mf) mg.a.q();
            if (!mfVar.b.H()) {
                mfVar.v();
            }
            mg mgVar = (mg) mfVar.b;
            mgVar.b |= 1;
            mgVar.e = z3;
            if (!mfVar.b.H()) {
                mfVar.v();
            }
            mg mgVar2 = (mg) mfVar.b;
            mgVar2.b = 4 | mgVar2.b;
            mgVar2.f = true;
            long j2 = this.c;
            if (!mfVar.b.H()) {
                mfVar.v();
            }
            mg mgVar3 = (mg) mfVar.b;
            mgVar3.b |= 8;
            mgVar3.g = j2;
            int i5 = this.b.a.o;
            if (!mfVar.b.H()) {
                mfVar.v();
            }
            mg mgVar4 = (mg) mfVar.b;
            mgVar4.b |= 16;
            mgVar4.h = i5;
            boolean z4 = this.b.a.q;
            if (!mfVar.b.H()) {
                mfVar.v();
            }
            mg mgVar5 = (mg) mfVar.b;
            mgVar5.b |= 32;
            mgVar5.i = z4;
            boolean z5 = this.b.a.r;
            if (!mfVar.b.H()) {
                mfVar.v();
            }
            mg mgVar6 = (mg) mfVar.b;
            mgVar6.b |= 64;
            mgVar6.j = z5;
            al alVarB = al.b(this.b.a.A);
            if (alVarB == null) {
                alVarB = al.DRIVE;
            }
            if (alVarB == al.TRANSIT) {
                if (!mfVar.b.H()) {
                    mfVar.v();
                }
                mg mgVar7 = (mg) mfVar.b;
                mgVar7.c = 12;
                mgVar7.d = true;
            }
            om omVar = (om) on.a.q();
            ma maVar = (ma) mh.a.q();
            mb mbVar = (mb) me.a.q();
            if (!mbVar.b.H()) {
                mbVar.v();
            }
            me meVar = (me) mbVar.b;
            meVar.b |= 1;
            meVar.c = z2;
            boolean z6 = this.b.a.s;
            if (!mbVar.b.H()) {
                mbVar.v();
            }
            me meVar2 = (me) mbVar.b;
            meVar2.b |= 2;
            meVar2.d = z6;
            if (!maVar.b.H()) {
                maVar.v();
            }
            mh mhVar = (mh) maVar.b;
            me meVar3 = (me) mbVar.t();
            meVar3.getClass();
            mhVar.d = meVar3;
            mhVar.b |= 2;
            if (!maVar.b.H()) {
                maVar.v();
            }
            mh mhVar2 = (mh) maVar.b;
            mg mgVar8 = (mg) mfVar.t();
            mgVar8.getClass();
            mhVar2.c = mgVar8;
            mhVar2.b |= 1;
            if (!omVar.b.H()) {
                omVar.v();
            }
            on onVar2 = (on) omVar.b;
            mh mhVar3 = (mh) maVar.t();
            mhVar3.getClass();
            onVar2.c = mhVar3;
            onVar2.b |= 1;
            if (!omVar.b.H()) {
                omVar.v();
            }
            on onVar3 = (on) omVar.b;
            dl dlVar3 = (dl) cwVar.t();
            dlVar3.getClass();
            onVar3.d = dlVar3;
            onVar3.b = 2 | onVar3.b;
            onVar = (on) omVar.t();
        }
        if (onVar != null) {
            this.j.e(onVar);
            this.j.i(j, true);
        } else {
            this.j.i(j, false);
        }
        if (runnable != null) {
            com.google.android.libraries.navigation.internal.hx.n.a(this.h.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ti.x
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.g();
                }
            }, this.b.a.D, TimeUnit.MILLISECONDS), this.h);
        }
    }
}
