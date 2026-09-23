package com.google.android.libraries.navigation.internal.fi;

import android.content.Context;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.iv.ab;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l implements com.google.android.libraries.navigation.internal.ia.b {
    private final String a;
    private final com.google.android.libraries.navigation.internal.mj.a b;
    private final com.google.android.libraries.navigation.internal.iv.f c;
    private final com.google.android.libraries.navigation.internal.afo.a d;
    private volatile com.google.android.libraries.navigation.internal.ia.b e;
    private com.google.android.libraries.navigation.internal.ia.a f;

    public l(Context context, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.hm.j jVar, com.google.android.libraries.navigation.internal.afo.a aVar2, Executor executor) {
        this.a = com.google.android.libraries.navigation.internal.je.a.b(context);
        this.b = aVar;
        bj bjVarD = jVar.a().d();
        this.d = aVar2;
        this.e = new com.google.android.libraries.navigation.internal.kp.h();
        this.f = com.google.android.libraries.navigation.internal.ia.a.DEFAULT;
        this.c = fVar;
        com.google.android.libraries.navigation.internal.yu.c.d(bjVarD, new k(this), executor);
    }

    public final synchronized void a(com.google.android.libraries.navigation.internal.fz.d dVar) {
        j jVarF;
        if (dVar.b().a.aT) {
            com.google.android.libraries.navigation.internal.ia.a aVar = com.google.android.libraries.navigation.internal.ia.a.EXTERNAL;
            this.f = aVar;
            jVarF = j.f(this.a, 2, this.b, aVar);
        } else {
            jVarF = j.f(this.a, 1, this.b, this.f);
        }
        ((com.google.android.libraries.navigation.internal.fq.f) this.d.a()).d(jVarF, "EventTrack");
        this.e = jVarF;
        if (this.c.y(ab.aD, false)) {
            d(com.google.android.libraries.navigation.internal.ia.a.EV_IDAT);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ia.b
    public final String b() {
        return this.e.b();
    }

    @Override // com.google.android.libraries.navigation.internal.ia.b
    public final void c(com.google.android.libraries.navigation.internal.ic.a aVar) {
        this.e.c(aVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ia.b
    public final synchronized void d(com.google.android.libraries.navigation.internal.ia.a aVar) {
        this.f = aVar;
        this.e.d(aVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ia.b
    public final boolean e() {
        return this.e.e();
    }

    @Override // com.google.android.libraries.navigation.internal.ia.b
    public final synchronized void g(int i) {
        this.e.g(i);
    }
}
