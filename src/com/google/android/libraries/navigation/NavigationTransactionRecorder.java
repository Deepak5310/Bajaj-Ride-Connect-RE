package com.google.android.libraries.navigation;

import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.ed;
import com.google.android.libraries.navigation.internal.xe.be;
import com.google.android.libraries.navigation.internal.xe.bf;
import com.google.android.libraries.navigation.internal.yz.fz;
import com.google.maps.api.android.lib6.common.apiexception.ApiExpectedException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class NavigationTransactionRecorder {
    private static final com.google.android.libraries.navigation.internal.zb.j d = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.NavigationTransactionRecorder");
    public com.google.android.libraries.navigation.internal.db.n a;
    public com.google.android.libraries.navigation.internal.xh.b b;
    public final List c = new ArrayList();
    private final com.google.android.libraries.navigation.internal.fz.d e;
    private final com.google.android.libraries.navigation.internal.ia.e f;
    private final com.google.android.libraries.navigation.internal.xd.a g;
    private final com.google.android.libraries.navigation.internal.mj.a h;
    private final Executor i;
    private final com.google.android.libraries.navigation.internal.adc.f j;

    /* JADX INFO: compiled from: PG */
    public static class TransactionException extends Exception implements ApiExpectedException {
        public TransactionException(String str) {
            super("ERROR: Unable to record transaction. ".concat(String.valueOf(str)));
        }
    }

    public NavigationTransactionRecorder(com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.adc.f fVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.xd.a aVar2, com.google.android.libraries.navigation.internal.xh.c cVar, Executor executor, Executor executor2) {
        this.e = dVar;
        this.j = fVar;
        this.f = eVar;
        this.h = aVar;
        this.g = aVar2;
        com.google.android.libraries.navigation.internal.xh.b bVarA = cVar.a();
        this.b = bVarA;
        this.i = executor;
        if (bVarA == null) {
            az.o(cVar.b(), new j(this), executor2);
        }
    }

    private final void a(com.google.android.libraries.navigation.internal.zp.n nVar, List list) throws TransactionException {
        com.google.android.libraries.navigation.internal.xe.ao.a(list, false);
        this.g.d(nVar, list);
    }

    private final void b(com.google.android.libraries.navigation.internal.adc.d dVar) {
        this.j.a(dVar, new k(dVar), this.i);
    }

    private final com.google.android.libraries.navigation.internal.adc.d c(int i, Iterable iterable) {
        com.google.android.libraries.navigation.internal.adc.a aVar = (com.google.android.libraries.navigation.internal.adc.a) com.google.android.libraries.navigation.internal.adc.d.a.q();
        if (!aVar.b.H()) {
            aVar.v();
        }
        ((com.google.android.libraries.navigation.internal.adc.d) aVar.b).d = com.google.android.libraries.navigation.internal.adc.c.a(i);
        ed edVarB = com.google.android.libraries.navigation.internal.aen.d.b(this.h.f().toEpochMilli());
        if (!aVar.b.H()) {
            aVar.v();
        }
        com.google.android.libraries.navigation.internal.adc.d dVar = (com.google.android.libraries.navigation.internal.adc.d) aVar.b;
        edVarB.getClass();
        dVar.k = edVarB;
        dVar.b |= 1;
        if (!aVar.b.H()) {
            aVar.v();
        }
        com.google.android.libraries.navigation.internal.adc.d dVar2 = (com.google.android.libraries.navigation.internal.adc.d) aVar.b;
        bz bzVar = dVar2.e;
        if (!bzVar.c()) {
            dVar2.e = bi.A(bzVar);
        }
        com.google.android.libraries.navigation.internal.ael.b.m(iterable, dVar2.e);
        if (!aVar.b.H()) {
            aVar.v();
        }
        ((com.google.android.libraries.navigation.internal.adc.d) aVar.b).f = "6.1.0";
        com.google.android.libraries.navigation.internal.ia.e eVar = this.f;
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.db.o.class, new l(com.google.android.libraries.navigation.internal.db.o.class, this, com.google.android.libraries.navigation.internal.hx.ap.DANGEROUS_PUBLISHER_THREAD));
        eVar.c(this, fzVar.a());
        com.google.android.libraries.navigation.internal.db.n nVar = this.a;
        if (nVar != null) {
            long j = com.google.android.libraries.navigation.internal.zk.d.h(com.google.android.libraries.navigation.internal.zk.e.d(nVar.b(), nVar.c())).i(12).b;
            if (!aVar.b.H()) {
                aVar.v();
            }
            ((com.google.android.libraries.navigation.internal.adc.d) aVar.b).i = j;
        }
        this.f.e(this);
        return (com.google.android.libraries.navigation.internal.adc.d) aVar.t();
    }

    public static String generateTransactionId() {
        return UUID.randomUUID().toString();
    }

    public void dropoff(Waypoint waypoint, List<String> list) throws TransactionException {
        try {
            com.google.android.libraries.navigation.internal.xh.b bVar = this.b;
            if (bVar == null) {
                this.c.add(new be(this, waypoint, list));
                return;
            }
            if (bVar.c()) {
                com.google.android.libraries.navigation.internal.xe.ao.a(list, false);
                a(com.google.android.libraries.navigation.internal.zp.n.aT, list);
                com.google.android.libraries.navigation.internal.ti.c.a.b(this.h.a(), list);
                if (this.e.K().b) {
                    b(c(com.google.android.libraries.navigation.internal.adc.c.e, list));
                }
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void pickup(Waypoint waypoint, List<String> list) throws TransactionException {
        try {
            com.google.android.libraries.navigation.internal.xh.b bVar = this.b;
            if (bVar == null) {
                this.c.add(new bf(this, waypoint, list));
                return;
            }
            if (bVar.c()) {
                com.google.android.libraries.navigation.internal.xe.ao.a(list, false);
                a(com.google.android.libraries.navigation.internal.zp.n.aU, list);
                com.google.android.libraries.navigation.internal.ti.c.a.c(this.h.a(), list);
                if (this.e.K().b) {
                    b(c(com.google.android.libraries.navigation.internal.adc.c.d, list));
                }
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
