package com.google.android.libraries.navigation.internal.xt;

import android.os.StrictMode;
import com.google.android.libraries.navigation.internal.yz.kc;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ae implements Comparable {
    public static final ad a = new ad();
    public final com.google.android.libraries.navigation.internal.xo.y b;
    public final String c;
    public final bs h;
    private final Set j;
    public final String d = "";
    public final boolean e = false;
    public final boolean f = false;
    private volatile br i = null;
    public final ak g = new ak();

    public ae(com.google.android.libraries.navigation.internal.xo.y yVar, String str, String str2, Set set) {
        this.b = yVar;
        this.c = str;
        this.j = set;
        this.h = new bs(yVar, str, "");
    }

    static /* synthetic */ boolean d(List list) {
        ad adVar = a;
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator it2 = list.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            ae[] aeVarArrB = adVar.b((String) it2.next());
            if (aeVarArrB != null) {
                int i = 0;
                while (i < aeVarArrB.length) {
                    boolean z2 = aeVarArrB[i].f;
                    i++;
                    z = true;
                }
            }
        }
        return z;
    }

    public final void b() {
        bs bsVar = this.h;
        final com.google.android.libraries.navigation.internal.aac.bj bjVarH = com.google.android.libraries.navigation.internal.aac.j.h(bsVar.b.b().c(bsVar.d, this.d), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.xt.bm
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                com.google.android.libraries.navigation.internal.xp.h hVar = (com.google.android.libraries.navigation.internal.xp.h) obj;
                bt btVar = (bt) bu.a.q();
                if (hVar == null) {
                    return (bu) btVar.t();
                }
                for (com.google.android.libraries.navigation.internal.xp.k kVar : hVar.f) {
                    bv bvVar = (bv) bx.a.q();
                    String str = kVar.e;
                    if (!bvVar.b.H()) {
                        bvVar.v();
                    }
                    bx bxVar = (bx) bvVar.b;
                    str.getClass();
                    bxVar.b |= 1;
                    bxVar.e = str;
                    int iA = com.google.android.libraries.navigation.internal.xp.j.a(kVar.c);
                    int i = iA - 1;
                    if (iA == 0) {
                        throw null;
                    }
                    if (i == 0) {
                        long jLongValue = kVar.c == 1 ? ((Long) kVar.d).longValue() : 0L;
                        if (!bvVar.b.H()) {
                            bvVar.v();
                        }
                        bx bxVar2 = (bx) bvVar.b;
                        bxVar2.c = 2;
                        bxVar2.d = Long.valueOf(jLongValue);
                    } else if (i == 1) {
                        boolean zBooleanValue = kVar.c == 2 ? ((Boolean) kVar.d).booleanValue() : false;
                        if (!bvVar.b.H()) {
                            bvVar.v();
                        }
                        bx bxVar3 = (bx) bvVar.b;
                        bxVar3.c = 3;
                        bxVar3.d = Boolean.valueOf(zBooleanValue);
                    } else if (i == 2) {
                        double dDoubleValue = kVar.c == 3 ? ((Double) kVar.d).doubleValue() : 0.0d;
                        if (!bvVar.b.H()) {
                            bvVar.v();
                        }
                        bx bxVar4 = (bx) bvVar.b;
                        bxVar4.c = 4;
                        bxVar4.d = Double.valueOf(dDoubleValue);
                    } else if (i == 3) {
                        String str2 = kVar.c == 4 ? (String) kVar.d : "";
                        if (!bvVar.b.H()) {
                            bvVar.v();
                        }
                        bx bxVar5 = (bx) bvVar.b;
                        str2.getClass();
                        bxVar5.c = 5;
                        bxVar5.d = str2;
                    } else {
                        if (i != 4) {
                            throw new IllegalStateException("No known flag type");
                        }
                        com.google.android.libraries.navigation.internal.ael.x xVar = kVar.c == 5 ? (com.google.android.libraries.navigation.internal.ael.x) kVar.d : com.google.android.libraries.navigation.internal.ael.x.b;
                        if (!bvVar.b.H()) {
                            bvVar.v();
                        }
                        bx bxVar6 = (bx) bvVar.b;
                        xVar.getClass();
                        bxVar6.c = 6;
                        bxVar6.d = xVar;
                    }
                    bx bxVar7 = (bx) bvVar.t();
                    if (!btVar.b.H()) {
                        btVar.v();
                    }
                    bu buVar = (bu) btVar.b;
                    bxVar7.getClass();
                    com.google.android.libraries.navigation.internal.ael.bz bzVar = buVar.g;
                    if (!bzVar.c()) {
                        buVar.g = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
                    }
                    buVar.g.add(bxVar7);
                }
                String str3 = hVar.e;
                if (!btVar.b.H()) {
                    btVar.v();
                }
                bu buVar2 = (bu) btVar.b;
                str3.getClass();
                buVar2.b = 4 | buVar2.b;
                buVar2.e = str3;
                String str4 = hVar.c;
                if (!btVar.b.H()) {
                    btVar.v();
                }
                bu buVar3 = (bu) btVar.b;
                str4.getClass();
                buVar3.b |= 1;
                buVar3.c = str4;
                long j = hVar.i;
                if (!btVar.b.H()) {
                    btVar.v();
                }
                bu buVar4 = (bu) btVar.b;
                buVar4.b |= 8;
                buVar4.f = j;
                if ((hVar.b & 2) != 0) {
                    com.google.android.libraries.navigation.internal.ael.x xVar2 = hVar.d;
                    if (!btVar.b.H()) {
                        btVar.v();
                    }
                    bu buVar5 = (bu) btVar.b;
                    xVar2.getClass();
                    buVar5.b |= 2;
                    buVar5.d = xVar2;
                }
                return (bu) btVar.t();
            }
        }, bsVar.b.d());
        final bs bsVar2 = this.h;
        Objects.requireNonNull(bsVar2);
        com.google.android.libraries.navigation.internal.aac.j.i(bjVarH, new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.xt.u
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final com.google.android.libraries.navigation.internal.aac.bj a(Object obj) {
                final bu buVar = (bu) obj;
                final bs bsVar3 = bsVar2;
                return com.google.android.libraries.navigation.internal.aac.az.k(new Callable() { // from class: com.google.android.libraries.navigation.internal.xt.bn
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        bs.c(bsVar3, buVar);
                        return null;
                    }
                }, bsVar3.b.d());
            }
        }, this.b.d()).l(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xt.v
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c(bjVarH);
            }
        }, this.b.d());
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0026 A[Catch: CancellationException | ExecutionException -> 0x003e, ExecutionException -> 0x0040, TryCatch #3 {CancellationException | ExecutionException -> 0x003e, blocks: (B:2:0x0000, B:4:0x000e, B:21:0x0036, B:14:0x001b, B:15:0x001c, B:17:0x0026, B:19:0x0032, B:5:0x000f, B:7:0x0013, B:8:0x0015, B:10:0x0017), top: B:29:0x0000, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0032 A[Catch: CancellationException | ExecutionException -> 0x003e, ExecutionException -> 0x0040, TryCatch #3 {CancellationException | ExecutionException -> 0x003e, blocks: (B:2:0x0000, B:4:0x000e, B:21:0x0036, B:14:0x001b, B:15:0x001c, B:17:0x0026, B:19:0x0032, B:5:0x000f, B:7:0x0013, B:8:0x0015, B:10:0x0017), top: B:29:0x0000, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:30:? A[RETURN, SYNTHETIC] */
    public final /* synthetic */ void c(com.google.android.libraries.navigation.internal.aac.bj bjVar) {
        ax axVar;
        try {
            br brVarA = br.a((bu) com.google.android.libraries.navigation.internal.aac.az.n(bjVar));
            br brVar = this.i;
            if (brVar == null) {
                synchronized (this) {
                    brVar = this.i;
                    if (brVar == null) {
                        this.i = brVarA;
                    } else if (!kc.k(brVar.d, brVarA.d)) {
                        axVar = (ax) this.b.e.a();
                        if (axVar != null) {
                            axVar.a();
                            return;
                        }
                        return;
                    }
                }
            } else if (!kc.k(brVar.d, brVarA.d)) {
                axVar = (ax) this.b.e.a();
                if (axVar != null) {
                    axVar.a();
                    return;
                }
                return;
            }
            this.g.a.incrementAndGet();
        } catch (CancellationException | ExecutionException e) {
            e.getCause();
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.d.compareTo((String) obj);
    }

    public final br a() {
        br brVar;
        br brVar2 = this.i;
        if (brVar2 == null) {
            synchronized (this) {
                brVar2 = this.i;
                if (brVar2 == null) {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
                    try {
                        bs bsVar = this.h;
                        bp bpVarA = bsVar.a();
                        if (((f) bpVarA).a != null) {
                            int i = bj.a;
                            bj.a(14903855);
                            com.google.android.libraries.navigation.internal.xs.k kVar = ((f) bpVarA).a;
                            com.google.android.libraries.navigation.internal.yx.ar.q(kVar);
                            brVar = new br(kVar, ((f) bpVarA).b);
                        } else {
                            int i2 = bj.a;
                            bj.a(14903854);
                            try {
                                brVar = new br((bu) bsVar.b.c().b(bsVar.c, com.google.android.libraries.navigation.internal.ye.b.b(bu.a)), new bq(com.google.android.libraries.navigation.internal.xp.d.c, ((f) bpVarA).b.c));
                            } catch (IOException | RuntimeException unused) {
                                bs.a.a(Level.INFO, bsVar.b.d(), "Unable to retrieve flag snapshot for %s, using defaults.", bsVar.d);
                                brVar = new br(bu.a, new bq(com.google.android.libraries.navigation.internal.xp.d.b, com.google.android.libraries.navigation.internal.xp.c.j));
                            }
                        }
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                        final cf cfVar = this.b.f;
                        if (!com.google.android.libraries.navigation.internal.nd.a.b(cfVar.c) && cfVar.a().g + TimeUnit.HOURS.toMillis(24L) < System.currentTimeMillis()) {
                            com.google.android.libraries.navigation.internal.aac.bn bnVar = (com.google.android.libraries.navigation.internal.aac.bn) cfVar.e.a();
                            com.google.android.libraries.navigation.internal.yx.ar.q(bnVar);
                            com.google.android.libraries.navigation.internal.aac.j.i(com.google.android.libraries.navigation.internal.aac.an.q(com.google.android.libraries.navigation.internal.aac.az.i((com.google.android.libraries.navigation.internal.aac.bj) cfVar.h.a())), new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.xt.cb
                                @Override // com.google.android.libraries.navigation.internal.aac.t
                                public final com.google.android.libraries.navigation.internal.aac.bj a(Object obj) {
                                    return com.google.android.libraries.navigation.internal.aac.az.i((com.google.android.libraries.navigation.internal.aac.bj) cfVar.g.a());
                                }
                            }, bnVar);
                        }
                        if (this.h.b() || !brVar.a.isEmpty()) {
                            this.b.d().execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xt.r
                                @Override // java.lang.Runnable
                                public final void run() {
                                    com.google.android.libraries.navigation.internal.aac.bj bjVarA;
                                    com.google.android.libraries.navigation.internal.xp.e eVar;
                                    final ae aeVar = this.a;
                                    br brVarA = aeVar.a();
                                    String str = brVarA.a;
                                    bl blVarB = aeVar.b.f.b();
                                    if (blVarB.h) {
                                        if (com.google.android.libraries.navigation.internal.yx.aq.c(str) && !blVarB.g) {
                                            return;
                                        }
                                        com.google.android.libraries.navigation.internal.xp.a aVar = (com.google.android.libraries.navigation.internal.xp.a) com.google.android.libraries.navigation.internal.xp.f.a.q();
                                        bq bqVar = brVarA.e;
                                        if (bqVar.a) {
                                            eVar = com.google.android.libraries.navigation.internal.xp.e.a;
                                        } else {
                                            com.google.android.libraries.navigation.internal.xp.b bVar = (com.google.android.libraries.navigation.internal.xp.b) com.google.android.libraries.navigation.internal.xp.e.a.q();
                                            int i3 = bqVar.b;
                                            if (!bVar.b.H()) {
                                                bVar.v();
                                            }
                                            com.google.android.libraries.navigation.internal.xp.e eVar2 = (com.google.android.libraries.navigation.internal.xp.e) bVar.b;
                                            eVar2.c = com.google.android.libraries.navigation.internal.xp.d.a(i3);
                                            eVar2.b |= 1;
                                            int i4 = bqVar.c;
                                            if (!bVar.b.H()) {
                                                bVar.v();
                                            }
                                            com.google.android.libraries.navigation.internal.xp.e eVar3 = (com.google.android.libraries.navigation.internal.xp.e) bVar.b;
                                            eVar3.d = com.google.android.libraries.navigation.internal.xp.c.a(i4);
                                            eVar3.b |= 2;
                                            eVar = (com.google.android.libraries.navigation.internal.xp.e) bVar.t();
                                        }
                                        if (!aVar.b.H()) {
                                            aVar.v();
                                        }
                                        com.google.android.libraries.navigation.internal.xp.f fVar = (com.google.android.libraries.navigation.internal.xp.f) aVar.b;
                                        eVar.getClass();
                                        fVar.d = eVar;
                                        fVar.b |= 2;
                                        if (!com.google.android.libraries.navigation.internal.yx.aq.c(str)) {
                                            if (!aVar.b.H()) {
                                                aVar.v();
                                            }
                                            com.google.android.libraries.navigation.internal.xp.f fVar2 = (com.google.android.libraries.navigation.internal.xp.f) aVar.b;
                                            str.getClass();
                                            fVar2.b |= 1;
                                            fVar2.c = str;
                                        }
                                        if (blVarB.g) {
                                            String str2 = aeVar.c;
                                            if (!aVar.b.H()) {
                                                aVar.v();
                                            }
                                            com.google.android.libraries.navigation.internal.xp.f fVar3 = (com.google.android.libraries.navigation.internal.xp.f) aVar.b;
                                            fVar3.b |= 4;
                                            fVar3.e = str2;
                                        }
                                        bjVarA = aeVar.b.b().b((com.google.android.libraries.navigation.internal.xp.f) aVar.t());
                                    } else if (com.google.android.libraries.navigation.internal.yx.aq.c(str)) {
                                        return;
                                    } else {
                                        bjVarA = aeVar.b.b().a(str);
                                    }
                                    com.google.android.libraries.navigation.internal.aac.c.i(bjVarA, com.google.android.libraries.navigation.internal.xp.m.class, new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.xt.q
                                        @Override // com.google.android.libraries.navigation.internal.aac.t
                                        public final com.google.android.libraries.navigation.internal.aac.bj a(Object obj) {
                                            int i5 = ((com.google.android.libraries.navigation.internal.xp.m) obj).a;
                                            if (i5 == 29501 || i5 == 29537 || i5 == 29538 || i5 == 29539 || i5 == 29540 || i5 == 29541 || i5 == 29542 || i5 == 29543 || i5 == 29544) {
                                                ae aeVar2 = aeVar;
                                                if (!aeVar2.h.b()) {
                                                    aeVar2.b();
                                                }
                                            }
                                            return com.google.android.libraries.navigation.internal.aac.be.a;
                                        }
                                    }, aeVar.b.d());
                                }
                            });
                            j jVar = this.b.c;
                            com.google.android.libraries.navigation.internal.ael.x xVar = brVar.b;
                            Set set = this.j;
                            String str = this.c;
                            if (!set.isEmpty() && !((n) jVar).a.getAndSet(true)) {
                                com.google.android.libraries.navigation.internal.ky.o.h(new m(jVar));
                            }
                            byte[] bArrB = xVar.B();
                            byte[][] bArr = com.google.android.libraries.navigation.internal.ma.l.a;
                            i iVar = new i(new com.google.android.libraries.navigation.internal.ma.l("", bArrB, bArr, bArr, bArr, bArr, null, null, null, null), str);
                            ((n) jVar).c.put(str, iVar);
                            Iterator it2 = set.iterator();
                            while (it2.hasNext()) {
                                n.b(iVar, (String) it2.next(), ((n) jVar).e);
                            }
                            if (!this.d.equals("")) {
                                this.b.d().execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xt.s
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        final ae aeVar = this.a;
                                        final com.google.android.libraries.navigation.internal.aac.bj bjVarA = am.a(aeVar.b, aeVar.c, aeVar.d);
                                        bjVarA.l(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xt.y
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                ad adVar = ae.a;
                                                try {
                                                    com.google.android.libraries.navigation.internal.aac.az.n(bjVarA);
                                                } catch (Exception unused2) {
                                                }
                                            }
                                        }, aeVar.b.d());
                                    }
                                });
                            }
                            if (this.h.b()) {
                                this.b.d().execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xt.t
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        final com.google.android.libraries.navigation.internal.aac.bj bjVarE;
                                        com.google.android.libraries.navigation.internal.aae.b bVar = com.google.android.libraries.navigation.internal.aae.b.PROCESS_STABLE;
                                        w wVar = new w();
                                        final ae aeVar = this.a;
                                        ar arVar = aeVar.b.h;
                                        ax axVar = (ax) arVar.a.a();
                                        if (axVar == null) {
                                            bjVarE = com.google.android.libraries.navigation.internal.aac.be.a;
                                        } else {
                                            int i3 = bVar.h;
                                            com.google.android.libraries.navigation.internal.yx.ar.a(true);
                                            int i4 = 1 << i3;
                                            if ((arVar.c & i4) == 0) {
                                                synchronized (arVar.d) {
                                                    int i5 = arVar.c;
                                                    if ((i5 & i4) == 0) {
                                                        arVar.d.add(wVar);
                                                        arVar.c = i4 | i5;
                                                    }
                                                }
                                            }
                                            bjVarE = arVar.f;
                                            if (bjVarE == null) {
                                                synchronized (arVar.e) {
                                                    bjVarE = arVar.f;
                                                    if (bjVarE == null) {
                                                        bjVarE = ((com.google.android.libraries.navigation.internal.xp.l) arVar.b.a()).e(new aq(arVar, axVar));
                                                        arVar.f = bjVarE;
                                                    }
                                                }
                                            }
                                        }
                                        bjVarE.l(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xt.x
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                ad adVar = ae.a;
                                                try {
                                                    com.google.android.libraries.navigation.internal.aac.az.n(bjVarE);
                                                } catch (Exception unused2) {
                                                }
                                            }
                                        }, aeVar.b.d());
                                    }
                                });
                            }
                        } else {
                            this.b.d().execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xt.p
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.a.b();
                                }
                            });
                            brVar = br.a(bu.a);
                        }
                        this.i = brVar;
                        brVar2 = brVar;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                        throw th;
                    }
                }
            }
        }
        return brVar2;
    }
}
