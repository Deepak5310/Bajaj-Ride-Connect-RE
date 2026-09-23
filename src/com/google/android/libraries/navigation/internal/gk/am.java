package com.google.android.libraries.navigation.internal.gk;

import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bl;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.yz.ba;
import com.google.android.libraries.navigation.internal.yz.md;
import java.util.PriorityQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class am implements ae {
    private static final com.google.android.libraries.navigation.internal.zb.j g = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.gk.am");
    public final bn a;
    public final Executor b;
    public final com.google.android.libraries.navigation.internal.mj.a d;
    public final ad e;
    private final r h;
    public final PriorityQueue c = new PriorityQueue(10, new ba(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.gk.ai
        @Override // com.google.android.libraries.navigation.internal.yx.aa
        public final Object ak(Object obj) {
            return Long.valueOf(((ac) obj).a);
        }
    }, md.a));
    public bl f = null;

    public am(bn bnVar, r rVar, com.google.android.libraries.navigation.internal.mj.a aVar, ad adVar) {
        this.a = bnVar;
        this.b = com.google.android.libraries.navigation.internal.hx.l.a(bnVar);
        this.h = rVar;
        this.d = aVar;
        this.e = adVar;
    }

    public final void b(final com.google.android.libraries.navigation.internal.yx.an anVar) {
        if (anVar.g()) {
            this.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.gk.ag
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c.remove(anVar.c());
                }
            });
        }
    }

    public final void c(long j) {
        bl blVar = this.f;
        if (blVar != null) {
            blVar.cancel(true);
        }
        this.f = this.a.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.gk.aj
            @Override // java.lang.Runnable
            public final void run() {
                final am amVar = this.a;
                amVar.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.gk.ah
                    @Override // java.lang.Runnable
                    public final void run() {
                        ac acVar;
                        final am amVar2 = amVar;
                        if (amVar2.c.isEmpty()) {
                            amVar2.f = null;
                            return;
                        }
                        ac acVar2 = (ac) amVar2.c.peek();
                        if (acVar2 == null) {
                            return;
                        }
                        com.google.android.libraries.navigation.internal.mj.a aVar = amVar2.d;
                        final long j2 = acVar2.a;
                        long jA = aVar.a();
                        if (j2 <= jA) {
                            long j3 = j2;
                            while (j3 <= jA) {
                                amVar2.c.poll();
                                if (amVar2.c.isEmpty() || (acVar = (ac) amVar2.c.peek()) == null) {
                                    break;
                                } else {
                                    j3 = acVar.a;
                                }
                            }
                            amVar2.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.gk.ak
                                @Override // java.lang.Runnable
                                public final void run() {
                                    amVar2.e.c();
                                }
                            });
                            j2 = j3;
                        }
                        if (amVar2.c.isEmpty()) {
                            return;
                        }
                        amVar2.c(j2 - jA);
                    }
                });
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    @Override // com.google.android.libraries.navigation.internal.gk.ae
    public final void a(Object obj, bj bjVar, Object obj2) {
        com.google.android.libraries.navigation.internal.yx.an anVarJ;
        final long jA = r.a(obj2);
        if (jA <= 0 || obj == null || !this.e.b()) {
            anVarJ = com.google.android.libraries.navigation.internal.yx.a.a;
        } else {
            final ac acVar = new ac(this.d.a() + jA);
            this.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.gk.af
                @Override // java.lang.Runnable
                public final void run() {
                    am amVar = this.a;
                    PriorityQueue priorityQueue = amVar.c;
                    ac acVar2 = acVar;
                    priorityQueue.offer(acVar2);
                    amVar.d.a();
                    if (amVar.c.peek() == acVar2) {
                        amVar.c(jA);
                    }
                }
            });
            anVarJ = com.google.android.libraries.navigation.internal.yx.an.j(acVar);
        }
        if (anVarJ.g()) {
            com.google.android.libraries.navigation.internal.yu.c.d(bjVar, new al(this, anVarJ), this.a);
        }
    }
}
