package com.google.android.libraries.navigation.internal.kh;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.ex;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class w implements z {
    private final fy a;
    private final bn b;
    private ScheduledFuture c;
    private ScheduledFuture d;

    public w(p pVar, p pVar2, bn bnVar) {
        this.b = bnVar;
        this.a = fy.q(pVar2, pVar);
    }

    @Override // com.google.android.libraries.navigation.internal.kh.z
    public final void a(com.google.android.libraries.navigation.internal.hj.i iVar, com.google.android.libraries.navigation.internal.ke.c cVar) {
        com.google.android.libraries.navigation.internal.hj.i iVarA = com.google.android.libraries.navigation.internal.hj.j.a(iVar);
        ar.k(!iVarA.an());
        nn nnVarListIterator = this.a.listIterator();
        while (nnVarListIterator.hasNext()) {
            p pVar = (p) nnVarListIterator.next();
            y yVar = cVar.k() ? y.HIGH : y.LOWEST;
            if (pVar.c()) {
                pVar.a(iVarA, cVar, yVar);
            }
        }
    }

    public final void b(y yVar) {
        com.google.android.libraries.navigation.internal.hj.i iVarB;
        if (aq.c(com.google.android.libraries.navigation.internal.hj.c.a.a())) {
            return;
        }
        nn nnVarListIterator = this.a.listIterator();
        while (nnVarListIterator.hasNext()) {
            p pVar = (p) nnVarListIterator.next();
            for (y yVar2 : y.values()) {
                if (yVar2.compareTo(yVar) >= 0) {
                    ex exVarA = pVar.g(yVar2).a();
                    nn nnVarListIterator2 = exVarA.x().listIterator();
                    while (nnVarListIterator2.hasNext()) {
                        String str = (String) nnVarListIterator2.next();
                        ev evVarA = exVarA.a(str);
                        try {
                            com.google.android.libraries.navigation.internal.nj.i.a();
                            if (str.equals("")) {
                                iVarB = com.google.android.libraries.navigation.internal.hj.c.a;
                            } else {
                                iVarB = (com.google.android.libraries.navigation.internal.hj.i) pVar.c.get(str);
                                if (iVarB == null) {
                                    pVar.d.c();
                                    iVarB = pVar.d.b(str);
                                    if (iVarB == null) {
                                        throw new n();
                                    }
                                }
                            }
                            pVar.b(new b(iVarB, evVarA, yVar2));
                        } catch (n unused) {
                            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(782)).s("Account %s wasn't found on device, dropping logs for it.", str);
                        }
                    }
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.kh.z
    public final void c() {
        ScheduledFuture scheduledFuture = this.c;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            this.c = this.b.scheduleAtFixedRate(new Runnable() { // from class: com.google.android.libraries.navigation.internal.kh.v
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b(y.HIGH);
                }
            }, 200L, 200L, TimeUnit.MILLISECONDS);
        }
        ScheduledFuture scheduledFuture2 = this.d;
        if (scheduledFuture2 == null || scheduledFuture2.isDone()) {
            this.d = this.b.scheduleAtFixedRate(new u(this), 81L, 81L, TimeUnit.SECONDS);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.kh.z
    public final void d() {
        ScheduledFuture scheduledFuture = this.c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        ScheduledFuture scheduledFuture2 = this.d;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(false);
        }
        this.b.execute(new u(this));
    }
}
