package com.google.android.libraries.navigation.internal.aga;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cl extends com.google.android.libraries.navigation.internal.afx.bu {
    final cj a;
    final com.google.android.libraries.navigation.internal.afx.by b;
    final /* synthetic */ cr c;

    public cl(cr crVar, cj cjVar, com.google.android.libraries.navigation.internal.afx.by byVar) {
        this.c = crVar;
        this.a = cjVar;
        com.google.android.libraries.navigation.internal.yx.ar.r(byVar, "resolver");
        this.b = byVar;
    }

    /* JADX WARN: Code duplicated, block: B:76:0x0215  */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, java.util.List] */
    @Override // com.google.android.libraries.navigation.internal.afx.bu
    public final com.google.android.libraries.navigation.internal.afx.cl a(com.google.android.libraries.navigation.internal.afx.bw bwVar) {
        Object obj;
        this.c.j.d();
        if (this.c.f334n != this.b) {
            return com.google.android.libraries.navigation.internal.afx.cl.b;
        }
        com.google.android.libraries.navigation.internal.afx.cm cmVar = bwVar.a;
        if (!cmVar.d()) {
            b(cmVar.a());
            return cmVar.a();
        }
        Object objC = cmVar.c();
        this.c.y.b(1, "Resolved address: {0}, config={1}", objC, bwVar.b);
        if (this.c.H != 2) {
            this.c.y.b(2, "Address resolved: {0}", objC);
            this.c.H = 2;
        }
        com.google.android.libraries.navigation.internal.afx.bs bsVar = bwVar.c;
        com.google.android.libraries.navigation.internal.afx.ah ahVar = (com.google.android.libraries.navigation.internal.afx.ah) bwVar.b.a(com.google.android.libraries.navigation.internal.afx.ah.a);
        dc dcVar = (bsVar == null || (obj = bsVar.b) == null) ? null : (dc) obj;
        com.google.android.libraries.navigation.internal.afx.cl clVar = bsVar != null ? bsVar.a : null;
        cr crVar = this.c;
        if (crVar.E) {
            if (dcVar != null) {
                if (ahVar != null) {
                    crVar.A.b(ahVar);
                    if (dcVar.a() != null) {
                        this.c.y.a(1, "Method configs in service config will be discarded due to presence ofconfig-selector");
                    }
                } else {
                    crVar.A.b(dcVar.a());
                }
            } else if (clVar == null) {
                cm cmVar2 = crVar.A;
                dcVar = cr.d;
                cmVar2.b(null);
            } else {
                if (!crVar.D) {
                    crVar.y.a(2, "Fallback to error due to invalid first service config without default config");
                    com.google.android.libraries.navigation.internal.afx.cl clVar2 = bsVar.a;
                    com.google.android.libraries.navigation.internal.yx.ar.b(!clVar2.c(), "the error status must not be OK");
                    this.c.j.execute(new ck(this, clVar2));
                    return bsVar.a;
                }
                dcVar = crVar.B;
            }
            if (!dcVar.equals(this.c.B)) {
                this.c.y.b(2, "Service config changed{0}", dcVar == cr.d ? " to empty" : "");
                cr crVar2 = this.c;
                crVar2.B = dcVar;
                crVar2.G.a = dcVar.a;
            }
            try {
                this.c.D = true;
            } catch (RuntimeException e) {
                cr crVar3 = this.c;
                cr.a.logp(Level.WARNING, "io.grpc.internal.ManagedChannelImpl$NameResolverListener", "onResult2", "[" + String.valueOf(crVar3.f) + "] Unexpected exception from parsing service config", (Throwable) e);
            }
        } else {
            if (dcVar != null) {
                crVar.y.a(2, "Service config from name resolver discarded by channel settings");
            }
            cr crVar4 = this.c;
            dcVar = cr.d;
            if (ahVar != null) {
                crVar4.y.a(2, "Config selector from name resolver discarded by channel settings");
            }
            this.c.A.b(dcVar.a());
        }
        com.google.android.libraries.navigation.internal.afx.c cVar = bwVar.b;
        if (this.a != this.c.p) {
            return com.google.android.libraries.navigation.internal.afx.cl.b;
        }
        com.google.android.libraries.navigation.internal.afx.a aVar = new com.google.android.libraries.navigation.internal.afx.a(cVar);
        com.google.android.libraries.navigation.internal.afx.b bVar = com.google.android.libraries.navigation.internal.afx.ah.a;
        if (aVar.a.b.containsKey(bVar)) {
            IdentityHashMap identityHashMap = new IdentityHashMap(aVar.a.b);
            identityHashMap.remove(bVar);
            aVar.a = new com.google.android.libraries.navigation.internal.afx.c(identityHashMap);
        }
        IdentityHashMap identityHashMap2 = aVar.b;
        if (identityHashMap2 != null) {
            identityHashMap2.remove(bVar);
        }
        Map map = dcVar.c;
        if (map != null) {
            aVar.b(com.google.android.libraries.navigation.internal.afx.az.a, map);
            aVar.a();
        }
        com.google.android.libraries.navigation.internal.afx.c cVarA = aVar.a();
        com.google.android.libraries.navigation.internal.afx.au auVar = new com.google.android.libraries.navigation.internal.afx.au();
        auVar.a = cmVar.c();
        auVar.b = cVarA;
        auVar.c = dcVar.b;
        c cVar2 = this.a.a;
        com.google.android.libraries.navigation.internal.afx.av avVarA = auVar.a();
        el elVar = (el) avVarA.c;
        if (elVar == null) {
            try {
                h hVar = cVar2.d;
                String str = hVar.b;
                com.google.android.libraries.navigation.internal.afx.ba baVarA = hVar.a.a(str);
                if (baVarA == null) {
                    throw new g("Trying to load '" + str + "' because using default policy, but it's unavailable");
                }
                elVar = new el(baVarA, null);
            } catch (g e2) {
                cVar2.a.f(com.google.android.libraries.navigation.internal.afx.r.TRANSIENT_FAILURE, new e(com.google.android.libraries.navigation.internal.afx.cl.e.b(e2.getMessage())));
                cVar2.b.e();
                cVar2.c = null;
                cVar2.b = new f();
                return com.google.android.libraries.navigation.internal.afx.cl.b;
            }
        }
        if (cVar2.c != null) {
            if (!elVar.a.c().equals(cVar2.c.c())) {
                cVar2.a.f(com.google.android.libraries.navigation.internal.afx.r.CONNECTING, new d());
                cVar2.b.e();
                cVar2.c = elVar.a;
                com.google.android.libraries.navigation.internal.afx.az azVar = cVar2.b;
                cVar2.b = cVar2.c.a(cVar2.a);
                cVar2.a.a().b(2, "Load balancer changed from {0} to {1}", azVar.getClass().getSimpleName(), cVar2.b.getClass().getSimpleName());
            }
        } else {
            cVar2.a.f(com.google.android.libraries.navigation.internal.afx.r.CONNECTING, new d());
            cVar2.b.e();
            cVar2.c = elVar.a;
            com.google.android.libraries.navigation.internal.afx.az azVar2 = cVar2.b;
            cVar2.b = cVar2.c.a(cVar2.a);
            cVar2.a.a().b(2, "Load balancer changed from {0} to {1}", azVar2.getClass().getSimpleName(), cVar2.b.getClass().getSimpleName());
        }
        Object obj2 = elVar.b;
        if (obj2 != null) {
            cVar2.a.a().b(1, "Load-balancing config: {0}", elVar.b);
        }
        com.google.android.libraries.navigation.internal.afx.az azVar3 = cVar2.b;
        com.google.android.libraries.navigation.internal.afx.au auVar2 = new com.google.android.libraries.navigation.internal.afx.au();
        auVar2.a = avVarA.a;
        auVar2.b = avVarA.b;
        auVar2.c = obj2;
        return azVar3.a(auVar2.a());
    }

    public final void b(com.google.android.libraries.navigation.internal.afx.cl clVar) {
        cr.a.logp(Level.WARNING, "io.grpc.internal.ManagedChannelImpl$NameResolverListener", "handleErrorInSyncContext", "[{0}] Failed to resolve name. status={1}", new Object[]{this.c.f, clVar});
        cm cmVar = this.c.A;
        if (cmVar.a.get() == cr.e) {
            cr crVar = cmVar.c;
            cmVar.b(null);
        }
        if (this.c.H != 3) {
            this.c.y.b(3, "Failed to resolve name: {0}", clVar);
            this.c.H = 3;
        }
        cj cjVar = this.a;
        if (cjVar != this.c.p) {
            return;
        }
        cjVar.a.b.b(clVar);
    }
}
