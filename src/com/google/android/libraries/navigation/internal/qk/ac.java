package com.google.android.libraries.navigation.internal.qk;

import com.google.android.libraries.navigation.internal.aac.bz;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.ek;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.ma;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac implements com.google.android.libraries.navigation.internal.op.k {
    private final com.google.android.libraries.navigation.internal.afo.a a;
    private final Executor b;
    private final boolean c;
    private final o d;
    private final br e;
    private final com.google.android.libraries.navigation.internal.afo.a g;
    private fd h = ma.b;
    private final e f = null;

    public ac(com.google.android.libraries.navigation.internal.afo.a aVar, Executor executor, boolean z, o oVar, br brVar, e eVar, com.google.android.libraries.navigation.internal.afo.a aVar2) {
        this.a = aVar;
        this.b = new bz(executor);
        this.c = z;
        this.d = oVar;
        this.e = brVar;
        this.g = aVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.op.k
    public final void a(fd fdVar) {
        synchronized (this) {
            this.h = fdVar;
        }
        if (this.c) {
            c();
        } else {
            b();
        }
    }

    final void b() {
        this.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qk.ab
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c();
            }
        });
    }

    public final void c() {
        fd fdVar;
        com.google.android.libraries.navigation.internal.afo.a aVar = this.a;
        Object objA = this.e.a();
        com.google.android.libraries.navigation.internal.pb.t tVar = new com.google.android.libraries.navigation.internal.pb.t((com.google.android.libraries.navigation.internal.pb.t) aVar.a());
        com.google.android.libraries.navigation.internal.rf.g gVar = new com.google.android.libraries.navigation.internal.rf.g(com.google.android.libraries.navigation.internal.pd.d.b(tVar.w()), tVar.s(), tVar.r(), tVar.n());
        synchronized (this) {
            fdVar = this.h;
        }
        al alVar = new al(fdVar);
        this.d.a();
        p pVar = new p();
        nn nnVarListIterator = ((ek) objA).listIterator();
        while (nnVarListIterator.hasNext()) {
            ad adVar = (ad) nnVarListIterator.next();
            d dVar = (d) adVar.a;
            nn nnVar = nnVarListIterator;
            q qVar = new q(dVar.c, adVar.c ? adVar.b : null, adVar.d, gVar, this.d, alVar, dVar.e, (com.google.android.libraries.navigation.internal.pb.k) this.g.a());
            com.google.android.libraries.navigation.internal.op.f fVar = ((d) adVar.a).a;
            if (((d) adVar.a).b.b(fVar.a(), qVar, pVar, null)) {
                if (!adVar.e) {
                    v vVar = adVar.a;
                    adVar.e = true;
                }
                v vVar2 = adVar.a;
                fVar.e(pVar.a.t(), pVar.b);
                adVar.b.W(pVar.a);
                adVar.c = true;
                adVar.d = pVar.b;
            } else if (adVar.e) {
                v vVar3 = adVar.a;
                fVar.b();
                adVar.e = false;
            }
            nnVarListIterator = nnVar;
        }
    }
}
