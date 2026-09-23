package com.google.android.libraries.navigation.internal.abh;

import com.google.android.libraries.navigation.internal.afl.qj;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ei implements com.google.android.libraries.navigation.internal.om.q, gr, gq {
    private static final ScheduledExecutorService c = com.google.android.libraries.navigation.internal.abf.ah.e("scpm");
    public final gu a;
    private volatile ScheduledFuture d = null;
    private final Map e = new HashMap();
    public final Map b = new HashMap();
    private com.google.android.libraries.navigation.internal.afl.am f = com.google.android.libraries.navigation.internal.afl.am.a;
    private final eh g = new eh(this);

    public ei(gu guVar) {
        this.a = guVar;
        guVar.s = this;
    }

    private final void l() {
        com.google.android.libraries.navigation.internal.afl.am amVarB = this.a.b();
        if (amVarB == null || !amVarB.equals(this.f)) {
            if (amVarB != null) {
                this.f = amVarB;
            }
            com.google.android.libraries.navigation.internal.afl.am amVar = this.f;
            if (amVar != null) {
                eh ehVar = this.g;
                qj qjVar = qj.a;
                com.google.android.libraries.navigation.internal.adi.af afVar = com.google.android.libraries.navigation.internal.adi.af.a;
                com.google.android.libraries.navigation.internal.ace.gm gmVar = com.google.android.libraries.navigation.internal.ace.gm.a;
                for (com.google.android.libraries.navigation.internal.afl.hb hbVar : amVar.c) {
                    com.google.android.libraries.navigation.internal.afl.ha haVarB = com.google.android.libraries.navigation.internal.afl.ha.b(hbVar.e);
                    if (haVarB == null) {
                        haVarB = com.google.android.libraries.navigation.internal.afl.ha.UNKNOWN_TYPE;
                    }
                    if (haVarB == com.google.android.libraries.navigation.internal.afl.ha.VECTOR_MAPS && hbVar.c == 10) {
                        qjVar = (qj) hbVar.d;
                    }
                    com.google.android.libraries.navigation.internal.afl.ha haVarB2 = com.google.android.libraries.navigation.internal.afl.ha.b(hbVar.e);
                    if (haVarB2 == null) {
                        haVarB2 = com.google.android.libraries.navigation.internal.afl.ha.UNKNOWN_TYPE;
                    }
                    if (haVarB2 == com.google.android.libraries.navigation.internal.afl.ha.PAINT_PARAMETERS && hbVar.c == 39) {
                        afVar = (com.google.android.libraries.navigation.internal.adi.af) hbVar.d;
                    }
                    com.google.android.libraries.navigation.internal.afl.ha haVarB3 = com.google.android.libraries.navigation.internal.afl.ha.b(hbVar.e);
                    if (haVarB3 == null) {
                        haVarB3 = com.google.android.libraries.navigation.internal.afl.ha.UNKNOWN_TYPE;
                    }
                    if (haVarB3 == com.google.android.libraries.navigation.internal.afl.ha.MAPS_API_PARAMETERS && hbVar.c == 151) {
                        gmVar = (com.google.android.libraries.navigation.internal.ace.gm) hbVar.d;
                    }
                }
                synchronized (ehVar) {
                    ehVar.a = qjVar;
                    ehVar.b = afVar;
                }
                ehVar.g(gmVar);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.om.q
    public final com.google.android.libraries.navigation.internal.om.p a() {
        l();
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.om.q
    public final void b(int i) {
        this.e.remove(Integer.valueOf(i));
    }

    @Override // com.google.android.libraries.navigation.internal.om.q
    public final void c(int i) {
        this.b.remove(Integer.valueOf(i));
    }

    @Override // com.google.android.libraries.navigation.internal.om.q
    public final void d(String str) {
        i();
        this.a.f(str);
    }

    @Override // com.google.android.libraries.navigation.internal.om.q
    public final void e(int i, Runnable runnable) {
        this.e.put(Integer.valueOf(i), runnable);
        this.a.c(this);
    }

    @Override // com.google.android.libraries.navigation.internal.om.q
    public final void f(int i, Runnable runnable) {
        this.b.put(Integer.valueOf(i), runnable);
    }

    @Override // com.google.android.libraries.navigation.internal.om.q
    public final boolean g(String str) {
        return this.g.c.f(str);
    }

    @Override // com.google.android.libraries.navigation.internal.om.q
    public final boolean h(String str) {
        return this.g.c.h(str);
    }

    public final void i() {
        if (this.d != null) {
            this.d.cancel(false);
            this.d = null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.gq
    public final void j(com.google.android.libraries.navigation.internal.ace.gm gmVar) {
        this.g.g(gmVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.gr
    public final void k() {
        l();
        for (Runnable runnable : this.e.values()) {
            if (runnable != null) {
                runnable.run();
            }
        }
        synchronized (this) {
        }
        this.d = c.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.eg
            @Override // java.lang.Runnable
            public final void run() {
                ei eiVar = this.a;
                eiVar.a.c(eiVar);
            }
        }, 3L, TimeUnit.HOURS);
    }
}
