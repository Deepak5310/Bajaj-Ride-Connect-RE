package com.google.android.libraries.navigation.internal.ht;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.x;
import com.google.android.libraries.navigation.internal.afl.am;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;
    private final com.google.android.libraries.navigation.internal.agl.a f;
    private final com.google.android.libraries.navigation.internal.agl.a g;
    private final com.google.android.libraries.navigation.internal.agl.a h;
    private final com.google.android.libraries.navigation.internal.agl.a i;
    private final com.google.android.libraries.navigation.internal.agl.a j;
    private final com.google.android.libraries.navigation.internal.agl.a k;
    private final com.google.android.libraries.navigation.internal.agl.a l;
    private final com.google.android.libraries.navigation.internal.agl.a m;

    public i(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5, com.google.android.libraries.navigation.internal.agl.a aVar6, com.google.android.libraries.navigation.internal.agl.a aVar7, com.google.android.libraries.navigation.internal.agl.a aVar8, com.google.android.libraries.navigation.internal.agl.a aVar9, com.google.android.libraries.navigation.internal.agl.a aVar10, com.google.android.libraries.navigation.internal.agl.a aVar11, com.google.android.libraries.navigation.internal.agl.a aVar12, com.google.android.libraries.navigation.internal.agl.a aVar13) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
        this.f = aVar6;
        this.g = aVar7;
        this.h = aVar8;
        this.i = aVar9;
        this.j = aVar10;
        this.k = aVar11;
        this.l = aVar12;
        this.m = aVar13;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        bn bnVarA = ((com.google.android.libraries.navigation.internal.nj.b) this.b).a();
        ((com.google.android.libraries.navigation.internal.nj.g) this.c).a();
        com.google.android.libraries.navigation.internal.mj.a aVar = (com.google.android.libraries.navigation.internal.mj.a) this.d.a();
        com.google.android.libraries.navigation.internal.iv.f fVar = (com.google.android.libraries.navigation.internal.iv.f) this.e.a();
        an anVar = (an) this.f.a();
        com.google.android.libraries.navigation.internal.afo.a aVarC = com.google.android.libraries.navigation.internal.afr.e.c(this.g);
        a aVarA = ((b) this.h).a();
        com.google.android.libraries.navigation.internal.ig.c cVar = (com.google.android.libraries.navigation.internal.ig.c) this.i.a();
        com.google.android.libraries.navigation.internal.iu.b bVarA = ((com.google.android.libraries.navigation.internal.iu.c) this.j).a();
        com.google.android.libraries.navigation.internal.afo.a aVarC2 = com.google.android.libraries.navigation.internal.afr.e.c(this.k);
        d dVar = (d) this.l.a();
        com.google.android.libraries.navigation.internal.hm.d dVar2 = (com.google.android.libraries.navigation.internal.hm.d) this.m.a();
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("create ClientParametersManager");
        try {
            final q qVar = new q(aVarC, dVar, aVarA, dVar2, bnVarA, cVar, fVar, anVar, aVar, bVarA, aVarC2);
            bnVarA.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ht.o
                @Override // java.lang.Runnable
                public final void run() {
                    int i;
                    final q qVar2 = qVar;
                    com.google.android.libraries.navigation.internal.yt.a aVarA2 = com.google.android.libraries.navigation.internal.yt.d.a("ClientParametersManagerImpl.initialize");
                    try {
                        com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("ClientParametersManagerImpl.loadParametersFromCache");
                        try {
                            long jA = qVar2.e.a();
                            final com.google.android.libraries.navigation.internal.gd.m mVarA = qVar2.b.a();
                            synchronized (qVar2) {
                                if (qVar2.j == 3 || mVarA == null) {
                                    mVarA = com.google.android.libraries.navigation.internal.gd.m.a;
                                } else {
                                    ar.a(!(qVar2.j != 1));
                                }
                                am amVar = mVarA.f;
                                if (amVar == null) {
                                    amVar = am.a;
                                }
                                String strA = aq.a(mVarA.c);
                                x xVar = amVar.d;
                                long j = amVar.e;
                                bz bzVar = amVar.c;
                                i = true != mVarA.equals(com.google.android.libraries.navigation.internal.gd.m.a) ? 2 : 3;
                                qVar2.g.ag(strA, xVar, j, i, bzVar);
                                if (i == 2) {
                                    qVar2.h = mVarA.e;
                                } else {
                                    qVar2.h = 0L;
                                }
                                qVar2.f(i);
                            }
                            com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("ClientParametersManagerImpl.loadParametersFromCache send broadcast");
                            try {
                                qVar2.k.a(qVar2.g, i == 3);
                                if (dVarB3 != null) {
                                    Trace.endSection();
                                }
                                final long jA2 = qVar2.e.a() - jA;
                                if (qVar2.d != null) {
                                    qVar2.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ht.p
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            q qVar3 = qVar2;
                                            long j2 = jA2;
                                            com.google.android.libraries.navigation.internal.nw.d dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("ClientParametersManagerImpl.loadParametersFromCache update metric");
                                            try {
                                                com.google.android.libraries.navigation.internal.afo.a aVar2 = qVar3.d;
                                                ar.q(aVar2);
                                                ((com.google.android.libraries.navigation.internal.kk.l) ((com.google.android.libraries.navigation.internal.kl.a) aVar2.a()).a(com.google.android.libraries.navigation.internal.hw.a.f)).a(j2);
                                                an anVar2 = qVar3.g.a;
                                                try {
                                                    if (qVar3.f.a() && anVar2.g()) {
                                                        ((com.google.android.libraries.navigation.internal.kk.l) ((com.google.android.libraries.navigation.internal.kl.a) qVar3.d.a()).a(com.google.android.libraries.navigation.internal.hw.a.g)).a(((Long) anVar2.c()).longValue());
                                                    }
                                                } catch (com.google.android.libraries.navigation.internal.iu.a unused) {
                                                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(TypedValues.TransitionType.TYPE_TO)).p("Unable to query process info");
                                                }
                                                if (dVarB4 != null) {
                                                    Trace.endSection();
                                                }
                                            } catch (Throwable th) {
                                                if (dVarB4 != null) {
                                                    try {
                                                        Trace.endSection();
                                                    } catch (Throwable th2) {
                                                        th.addSuppressed(th2);
                                                    }
                                                }
                                                throw th;
                                            }
                                        }
                                    });
                                }
                                if (dVarB2 != null) {
                                    Trace.endSection();
                                }
                                if (qVar2.d != null) {
                                    qVar2.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ht.l
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            q qVar3 = qVar2;
                                            com.google.android.libraries.navigation.internal.afo.a aVar2 = qVar3.d;
                                            ar.q(aVar2);
                                            com.google.android.libraries.navigation.internal.kk.k kVar = (com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.a) aVar2.a()).a(com.google.android.libraries.navigation.internal.hw.a.d);
                                            com.google.android.libraries.navigation.internal.gd.m mVar = mVarA;
                                            kVar.a(mVar.equals(com.google.android.libraries.navigation.internal.gd.m.a) ? 2 : 1);
                                            try {
                                                if (qVar3.f.a()) {
                                                    ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.a) qVar3.d.a()).a(com.google.android.libraries.navigation.internal.hw.a.e)).a(true != mVar.equals(com.google.android.libraries.navigation.internal.gd.m.a) ? 1 : 2);
                                                }
                                            } catch (com.google.android.libraries.navigation.internal.iu.a unused) {
                                                ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.a) qVar3.d.a()).a(com.google.android.libraries.navigation.internal.hw.a.e)).a(0);
                                            }
                                        }
                                    });
                                }
                                com.google.android.libraries.navigation.internal.yu.c.d(((com.google.android.libraries.navigation.internal.ng.b) qVar2.a.a()).c(), new com.google.android.libraries.navigation.internal.hx.s(new com.google.android.libraries.navigation.internal.hx.q() { // from class: com.google.android.libraries.navigation.internal.ht.m
                                    @Override // com.google.android.libraries.navigation.internal.hx.q
                                    public final void a(Object obj) {
                                        qVar2.d(mVarA);
                                    }
                                }), ac.INSTANCE);
                                aVarA2.close();
                            } catch (Throwable th) {
                                if (dVarB3 == null) {
                                    throw th;
                                }
                                try {
                                    Trace.endSection();
                                    throw th;
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                    throw th;
                                }
                                try {
                                    aVarA2.close();
                                    throw th;
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                    throw th;
                                }
                            }
                        } catch (Throwable th4) {
                            if (dVarB2 == null) {
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
                    } catch (Throwable th6) {
                        aVarA2.close();
                        throw th6;
                    }
                }
            });
            if (dVarB != null) {
                Trace.endSection();
            }
            return qVar;
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
