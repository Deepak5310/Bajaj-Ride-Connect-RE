package com.google.android.apps.gmm.location.navigation;

import com.google.android.apps.gmm.jni.util.NativeToJavaExecutor;
import com.google.android.libraries.navigation.internal.acu.ch;
import j$.time.Duration;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class v implements y {
    public x a = null;
    private final com.google.android.libraries.navigation.internal.mj.a b;
    private final com.google.android.libraries.navigation.internal.kl.a c;
    private final com.google.android.libraries.navigation.internal.ia.e d;
    private final bu e;
    private final com.google.android.libraries.navigation.internal.fz.d f;
    private final com.google.android.libraries.navigation.internal.yx.br g;
    private final com.google.android.libraries.navigation.internal.rw.q h;
    private final String i;
    private final String j;
    private final com.google.android.libraries.navigation.internal.ia.b k;
    private final com.google.android.libraries.navigation.internal.aac.bn l;
    private final com.google.android.libraries.navigation.internal.bf.d m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.sf.d f44n;
    private final Executor o;
    private final l p;
    private final com.google.android.libraries.navigation.internal.yx.an q;

    public v(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.kl.a aVar2, com.google.android.libraries.navigation.internal.ia.e eVar, bu buVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.yx.br brVar, com.google.android.libraries.navigation.internal.rw.q qVar, String str, String str2, com.google.android.libraries.navigation.internal.ia.b bVar, com.google.android.libraries.navigation.internal.aac.bn bnVar, com.google.android.libraries.navigation.internal.bf.d dVar2, com.google.android.libraries.navigation.internal.sf.d dVar3, Executor executor, l lVar, com.google.android.libraries.navigation.internal.yx.an anVar) {
        this.b = aVar;
        this.c = aVar2;
        this.d = eVar;
        this.e = buVar;
        this.f = dVar;
        this.g = brVar;
        this.h = qVar;
        this.i = str;
        this.j = str2;
        this.k = bVar;
        this.l = bnVar;
        this.m = dVar2;
        this.f44n = dVar3;
        this.o = executor;
        this.p = lVar;
        this.q = anVar;
    }

    public static boolean j(com.google.android.libraries.navigation.internal.ady.al alVar) {
        return alVar == com.google.android.libraries.navigation.internal.ady.al.DRIVE || alVar == com.google.android.libraries.navigation.internal.ady.al.TWO_WHEELER;
    }

    private final boolean l() {
        x xVar = this.a;
        if (xVar == null) {
            return false;
        }
        xVar.d();
        this.a = null;
        return true;
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final com.google.android.libraries.navigation.internal.cy.h a() {
        x xVar = this.a;
        if (xVar != null) {
            return xVar.a();
        }
        ch chVar = ch.a;
        Duration duration = Duration.ZERO;
        return new com.google.android.libraries.navigation.internal.cy.h();
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final com.google.android.libraries.navigation.internal.db.q b(long j) {
        x xVar = this.a;
        if (xVar != null) {
            return xVar.b(j);
        }
        throw new IllegalStateException("locationIntegrationAlgorithm == null");
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final com.google.android.libraries.navigation.internal.acu.ba c(com.google.android.libraries.navigation.internal.acu.ay ayVar) {
        x xVar = this.a;
        return xVar != null ? xVar.c(ayVar) : com.google.android.libraries.navigation.internal.acu.ba.a;
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final void d() {
        l();
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final void e(long j) {
        x xVar = this.a;
        if (xVar != null) {
            xVar.e(j);
        }
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final void f() {
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final void g() {
        x xVar = this.a;
        if (xVar != null) {
            xVar.g();
        }
    }

    @Override // com.google.android.apps.gmm.location.navigation.x
    public final void h(long j, com.google.android.libraries.navigation.internal.bp.bh bhVar) {
        x xVar = this.a;
        if (xVar != null) {
            xVar.h(j, bhVar);
        }
    }

    @Override // com.google.android.apps.gmm.location.navigation.y
    public final boolean i() {
        return this.a != null;
    }

    @Override // com.google.android.apps.gmm.location.navigation.y
    public final boolean k(com.google.android.libraries.navigation.internal.ady.al alVar, boolean z, boolean z2) {
        if (!z) {
            return l();
        }
        if (j(alVar)) {
            if (!(this.a instanceof bz)) {
                l();
                com.google.android.libraries.navigation.internal.yx.ar.l(this.q.g(), "Cannot perform road snapping without a SnaptileStore");
                com.google.android.libraries.navigation.internal.mj.a aVar = this.b;
                com.google.android.libraries.navigation.internal.fl.r rVar = (com.google.android.libraries.navigation.internal.fl.r) this.q.c();
                com.google.android.libraries.navigation.internal.rw.q qVar = this.h;
                String str = this.i;
                String str2 = this.j;
                com.google.android.libraries.navigation.internal.fz.d dVar = this.f;
                com.google.android.libraries.navigation.internal.ia.e eVar = this.d;
                com.google.android.libraries.navigation.internal.ia.b bVar = this.k;
                com.google.android.libraries.navigation.internal.aac.bn bnVar = this.l;
                com.google.android.libraries.navigation.internal.bf.d dVar2 = this.m;
                com.google.android.libraries.navigation.internal.sf.d dVar3 = this.f44n;
                Executor executor = this.o;
                com.google.android.libraries.navigation.internal.kl.a aVar2 = this.c;
                l lVar = this.p;
                com.google.android.libraries.navigation.internal.yx.br brVar = this.g;
                com.google.android.libraries.navigation.internal.hn.p pVarB = dVar.b();
                com.google.android.libraries.navigation.internal.acu.p pVar = (com.google.android.libraries.navigation.internal.acu.p) brVar.a();
                bu buVar = this.e;
                NativeToJavaExecutor nativeToJavaExecutor = new NativeToJavaExecutor(executor);
                long jD = rVar.d();
                long jA = buVar != null ? buVar.a() : 0L;
                byte[] bArrM = pVarB.j().m();
                byte[] bArrM2 = pVar.m();
                com.google.android.libraries.navigation.internal.acm.e eVar2 = dVar2.a().b;
                if (eVar2 == null) {
                    eVar2 = com.google.android.libraries.navigation.internal.acm.e.b;
                }
                bz bzVar = new bz(aVar, rVar, qVar, new ab(jD, jA, nativeToJavaExecutor, bArrM, false, str, str2, lVar.a, bArrM2, eVar2.m()), pVarB.a.aK, dVar2, eVar, bVar, bnVar, dVar3, aVar2);
                this.a = bzVar;
                bzVar.f();
                return true;
            }
        } else if (!(this.a instanceof bq)) {
            l();
            com.google.android.libraries.navigation.internal.mj.a aVar3 = this.b;
            com.google.android.libraries.navigation.internal.kl.a aVar4 = this.c;
            com.google.android.libraries.navigation.internal.ia.e eVar3 = this.d;
            com.google.android.libraries.navigation.internal.fz.d dVar4 = this.f;
            com.google.android.libraries.navigation.internal.yx.br brVar2 = this.g;
            com.google.android.libraries.navigation.internal.hn.p pVarB2 = dVar4.b();
            com.google.android.libraries.navigation.internal.acu.p pVar2 = (com.google.android.libraries.navigation.internal.acu.p) brVar2.a();
            bu buVar2 = this.e;
            bq bqVar = new bq(aVar3, aVar4, eVar3, new aa(buVar2 != null ? buVar2.a() : 0L, pVarB2.j().m(), alVar != com.google.android.libraries.navigation.internal.ady.al.WALK, pVar2.m()));
            this.a = bqVar;
            bqVar.f();
            return true;
        }
        return false;
    }
}
