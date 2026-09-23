package com.google.android.libraries.navigation.internal.sv;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.fz;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.yz.lf;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aw implements com.google.android.libraries.navigation.internal.sp.b {
    private final com.google.android.libraries.navigation.internal.ia.e a;
    private final com.google.android.libraries.navigation.internal.aac.bn b;
    private final com.google.android.libraries.navigation.internal.mj.a c;
    private final com.google.android.libraries.navigation.internal.tb.b d;
    private final com.google.android.libraries.navigation.internal.dx.o e;
    private com.google.android.libraries.navigation.internal.tj.u f;
    private long g;
    private long h;
    private long i;
    private final com.google.android.libraries.navigation.internal.sj.a j;
    private final lf k = new lf(new LinkedHashMap());
    private final av l = new av();

    public aw(com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.sj.a aVar, com.google.android.libraries.navigation.internal.aac.bn bnVar, com.google.android.libraries.navigation.internal.mj.a aVar2, com.google.android.libraries.navigation.internal.tb.b bVar, com.google.android.libraries.navigation.internal.dx.o oVar) {
        this.a = eVar;
        this.j = aVar;
        this.b = bnVar;
        this.c = aVar2;
        this.d = bVar;
        this.e = oVar;
    }

    private final synchronized void k() {
        this.k.values().forEach(new at());
        this.k.clear();
        this.g = 0L;
        this.h = Long.MAX_VALUE;
        this.i = Long.MAX_VALUE;
        l(null);
    }

    private final void l(com.google.android.libraries.navigation.internal.tj.u uVar) {
        com.google.android.libraries.navigation.internal.sj.a aVar = this.j;
        if (uVar != null) {
            aVar.b(uVar);
        } else {
            aVar.a();
        }
        this.f = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void a(com.google.android.libraries.navigation.internal.sp.c cVar) {
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.sr.o.class, new ay(0, com.google.android.libraries.navigation.internal.sr.o.class, this, com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.sm.a.class, new ay(1, com.google.android.libraries.navigation.internal.sm.a.class, this, com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD));
        this.a.c(this, fzVar.a());
        synchronized (this) {
            com.google.android.libraries.navigation.internal.tb.b bVar = this.d;
            bVar.c.add(this.l);
        }
        k();
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void b(boolean z) {
        synchronized (this) {
            com.google.android.libraries.navigation.internal.tb.b bVar = this.d;
            bVar.c.remove(this.l);
        }
        this.a.e(this);
        k();
    }

    public final synchronized void c(com.google.android.libraries.navigation.internal.tj.u uVar) {
        if (uVar.equals(this.f)) {
            return;
        }
        if (uVar.a() < this.c.f().toEpochMilli()) {
            return;
        }
        if (uVar.n()) {
            l(uVar);
            return;
        }
        lf lfVar = this.k;
        Class<?> cls = uVar.getClass();
        lf.b(cls, lfVar.put(cls, uVar));
        e();
    }

    public final synchronized void d() {
        if (!this.k.isEmpty()) {
            fy fyVarN = fy.n(gs.a(this.k.values(), new com.google.android.libraries.navigation.internal.yx.as() { // from class: com.google.android.libraries.navigation.internal.sv.as
                @Override // com.google.android.libraries.navigation.internal.yx.as
                public final boolean a(Object obj) {
                    return ((com.google.android.libraries.navigation.internal.tj.u) obj).m();
                }
            }));
            if (!fyVarN.isEmpty()) {
                fyVarN.size();
                fyVarN.forEach(new at());
                this.k.values().removeAll(fyVarN);
            }
        }
        com.google.android.libraries.navigation.internal.tj.u uVar = this.f;
        if (uVar == null || !uVar.m()) {
            return;
        }
        this.a.a(new com.google.android.libraries.navigation.internal.sr.o(this.f));
    }

    public final synchronized void e() {
        com.google.android.libraries.navigation.internal.tj.u uVar;
        if (this.f == null) {
            long jA = this.c.a();
            if (jA >= this.g && jA <= this.h) {
                com.google.android.libraries.navigation.internal.tb.b bVar = this.d;
                Collection collectionValues = this.k.values();
                synchronized (bVar.b) {
                    uVar = (com.google.android.libraries.navigation.internal.tj.u) gs.c(gs.a(collectionValues, bVar.d), null);
                }
                if (uVar != null) {
                    this.k.remove(uVar.getClass());
                    l(uVar);
                }
            }
        }
    }

    public final synchronized void f(com.google.android.libraries.navigation.internal.sm.a aVar) {
        if (aVar.a != com.google.android.libraries.navigation.internal.sl.i.IDLE) {
            this.g = Long.MAX_VALUE;
        } else {
            this.g = this.c.a() + 3000;
            this.b.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sv.au
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.e();
                }
            }, 3000L, TimeUnit.MILLISECONDS);
        }
    }

    final synchronized void g(long j) {
        Iterator it2 = this.k.values().iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.tj.u uVar = (com.google.android.libraries.navigation.internal.tj.u) it2.next();
            if (uVar.a() < this.c.f().toEpochMilli()) {
                uVar.c();
                it2.remove();
            }
        }
        this.i = j;
        this.h = j - 20000;
        e();
    }

    public final synchronized void h(com.google.android.libraries.navigation.internal.sr.o oVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("PromptScheduler.onRequestDismissPromptEvent");
        try {
            com.google.android.libraries.navigation.internal.tj.u uVar = oVar.a;
            if (this.f == oVar.a) {
                l(null);
            }
            if (dVarB != null) {
                Trace.endSection();
            }
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

    public final synchronized void i() {
        if (!this.k.isEmpty()) {
            this.k.values().forEach(new at());
            this.k.clear();
        }
        if (this.f != null) {
            l(null);
        }
    }

    public final synchronized void j(Class cls) {
    }
}
