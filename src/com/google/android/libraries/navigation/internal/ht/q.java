package com.google.android.libraries.navigation.internal.ht;

import com.google.android.libraries.navigation.internal.adi.af;
import com.google.android.libraries.navigation.internal.adi.al;
import com.google.android.libraries.navigation.internal.adi.ar;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.x;
import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.aq;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q implements com.google.android.libraries.navigation.internal.hu.a {
    public final com.google.android.libraries.navigation.internal.afo.a a;
    public final d b;
    public final Executor c;
    public final com.google.android.libraries.navigation.internal.afo.a d;
    public final com.google.android.libraries.navigation.internal.mj.a e;
    public final com.google.android.libraries.navigation.internal.iu.b f;
    public final com.google.android.libraries.navigation.internal.hm.d g;
    public final a k;
    private final com.google.android.libraries.navigation.internal.ig.c l;
    private final com.google.android.libraries.navigation.internal.iv.f m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.afo.a f447n;
    public int j = 1;
    public volatile long h = 0;
    public final CountDownLatch i = new CountDownLatch(0);
    private final com.google.android.libraries.navigation.internal.nt.p o = new com.google.android.libraries.navigation.internal.nt.p(Boolean.FALSE);

    public q(com.google.android.libraries.navigation.internal.afo.a aVar, d dVar, a aVar2, com.google.android.libraries.navigation.internal.hm.d dVar2, Executor executor, com.google.android.libraries.navigation.internal.ig.c cVar, com.google.android.libraries.navigation.internal.iv.f fVar, an anVar, com.google.android.libraries.navigation.internal.mj.a aVar3, com.google.android.libraries.navigation.internal.iu.b bVar, com.google.android.libraries.navigation.internal.afo.a aVar4) {
        this.a = aVar;
        this.b = dVar;
        this.k = aVar2;
        this.g = dVar2;
        this.c = executor;
        this.l = cVar;
        this.m = fVar;
        this.d = (com.google.android.libraries.navigation.internal.afo.a) anVar.f();
        this.e = aVar3;
        this.f = bVar;
        this.f447n = aVar4;
    }

    @Override // com.google.android.libraries.navigation.internal.hu.a
    public final long a() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.hu.a
    public final com.google.android.libraries.navigation.internal.fz.d b() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.hu.a
    public final com.google.android.libraries.navigation.internal.nt.m c() {
        return this.o.a;
    }

    public final synchronized void d(com.google.android.libraries.navigation.internal.gd.m mVar) {
        boolean z;
        af afVarB;
        com.google.android.libraries.navigation.internal.hj.i iVarA = com.google.android.libraries.navigation.internal.hj.j.a(((com.google.android.libraries.navigation.internal.ng.b) this.a.a()).a());
        String strC = (iVarA.e() || iVarA.f()) ? iVarA.c() : null;
        String string = ((com.google.android.libraries.navigation.internal.no.a) this.f447n.a()).c().toString();
        String strA = aq.a(mVar.c);
        String str = mVar.d;
        this.l.a();
        if (!am.a(strA, strC) || !am.a(str, string) || (afVarB = com.google.android.libraries.navigation.internal.fz.b.b(this.g)) == null) {
            z = true;
            break;
        }
        ar arVar = afVarB.c;
        if (arVar == null) {
            arVar = ar.a;
        }
        Iterator it2 = arVar.c.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = true;
                break;
            }
            al alVar = (al) it2.next();
            com.google.android.libraries.navigation.internal.adi.an anVarB = com.google.android.libraries.navigation.internal.adi.an.b(alVar.c);
            if (anVarB == null) {
                anVarB = com.google.android.libraries.navigation.internal.adi.an.UNKNOWN;
            }
            if (anVarB == com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE && alVar.f.size() != 0) {
                z = false;
                break;
            }
        }
        this.h = mVar.e;
        if (z) {
            this.h = 0L;
        }
        this.o.c(true);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x009c  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x00a4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:37:0x00af  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:42:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:44:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c1  */
    @Override // com.google.android.libraries.navigation.internal.hu.a
    public final void e(com.google.android.libraries.navigation.internal.afl.am amVar, boolean z, com.google.android.libraries.navigation.internal.hj.i iVar, final Locale locale, com.google.android.libraries.navigation.internal.hu.b bVar) {
        boolean zAg;
        int i;
        final com.google.android.libraries.navigation.internal.afl.am amVarAe;
        int iOrdinal;
        String strC = null;
        if (iVar != null && (iVar.e() || iVar.f())) {
            strC = iVar.c();
        }
        x xVar = amVar.d;
        bz bzVar = amVar.c;
        long j = amVar.e;
        synchronized (this) {
            zAg = this.g.ag(strC, xVar, j, 4, bzVar);
            this.h = this.e.f().toEpochMilli();
            i = 4;
            f(4);
            amVarAe = this.g.aa().ae();
        }
        if (zAg) {
            this.k.a(this.g, false);
        }
        final long j2 = this.h;
        final String str = strC;
        this.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ht.n
            @Override // java.lang.Runnable
            public final void run() {
                q qVar = this.a;
                qVar.b.c(str, locale, j2, amVarAe);
                qVar.i.countDown();
            }
        });
        if (!this.m.w(ab.f452cl)) {
            this.m.r(ab.f452cl, j);
        }
        com.google.android.libraries.navigation.internal.hu.b bVar2 = (com.google.android.libraries.navigation.internal.hu.b) this.m.g(ab.f453cn, com.google.android.libraries.navigation.internal.hu.b.class, com.google.android.libraries.navigation.internal.hu.b.UNKNOWN);
        com.google.android.libraries.navigation.internal.afo.a aVar = this.d;
        if (aVar != null) {
            com.google.android.libraries.navigation.internal.kk.k kVar = (com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.a) aVar.a()).a(com.google.android.libraries.navigation.internal.hw.a.h);
            if (bVar2 != bVar) {
                iOrdinal = bVar2.ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal != 1) {
                        if (iOrdinal != 2) {
                            i = 1;
                        } else if (bVar == com.google.android.libraries.navigation.internal.hu.b.GWS) {
                            i = 10;
                        } else {
                            i = 9;
                        }
                    } else if (bVar == com.google.android.libraries.navigation.internal.hu.b.PHENOTYPE) {
                        i = 8;
                    } else {
                        i = 7;
                    }
                } else if (bVar == com.google.android.libraries.navigation.internal.hu.b.GWS) {
                    i = 5;
                } else {
                    i = 6;
                }
            } else {
                int iOrdinal2 = bVar.ordinal();
                if (iOrdinal2 == 0) {
                    i = 2;
                } else if (iOrdinal2 == 1) {
                    i = 3;
                } else if (iOrdinal2 != 2) {
                    iOrdinal = bVar2.ordinal();
                    if (iOrdinal != 0) {
                        if (iOrdinal != 1) {
                            if (iOrdinal != 2) {
                                i = 1;
                            } else if (bVar == com.google.android.libraries.navigation.internal.hu.b.GWS) {
                                i = 10;
                            } else {
                                i = 9;
                            }
                        } else if (bVar == com.google.android.libraries.navigation.internal.hu.b.PHENOTYPE) {
                            i = 8;
                        } else {
                            i = 7;
                        }
                    } else if (bVar == com.google.android.libraries.navigation.internal.hu.b.GWS) {
                        i = 5;
                    } else {
                        i = 6;
                    }
                }
            }
            kVar.a(i - 1);
        }
        this.m.o(ab.f453cn, bVar);
    }

    public final synchronized void f(int i) {
        this.j = i;
        if (com.google.android.libraries.navigation.internal.hn.d.a(i)) {
            notifyAll();
        }
    }
}
