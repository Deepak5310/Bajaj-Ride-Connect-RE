package com.google.android.libraries.navigation.internal.xe;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bh implements com.google.android.libraries.navigation.internal.uh.n {
    public boolean a;
    public final com.google.android.libraries.navigation.internal.ia.e b;
    public final com.google.android.libraries.navigation.internal.uu.q c;
    private final WeakReference d;

    public bh(com.google.android.libraries.navigation.internal.nt.m mVar, WeakReference weakReference, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.uu.q qVar) {
        mVar.e(new com.google.android.libraries.navigation.internal.nt.t() { // from class: com.google.android.libraries.navigation.internal.xe.bg
            @Override // com.google.android.libraries.navigation.internal.nt.t
            public final void a(com.google.android.libraries.navigation.internal.nt.m mVar2) {
                this.a.a = ((Boolean) mVar2.c()).booleanValue();
            }
        }, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
        this.d = weakReference;
        this.b = eVar;
        this.c = qVar;
    }

    @Override // com.google.android.libraries.navigation.internal.uh.b
    public final /* synthetic */ void a() {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.b
    public final void b() {
        bp bpVar = (bp) this.d.get();
        if (bpVar == null) {
            return;
        }
        com.google.android.libraries.navigation.internal.ut.d dVar = bpVar.m;
        if (dVar != null) {
            dVar.c();
            bpVar.m = null;
        }
        com.google.android.libraries.navigation.internal.ms.cq cqVar = bpVar.p;
        if (cqVar != null) {
            cqVar.e();
            bpVar.p = null;
            bpVar.h.removeAllViews();
        }
        if (bpVar.l.ac()) {
            bpVar.m = bpVar.l.h().a();
            com.google.android.libraries.navigation.internal.ut.d dVar2 = bpVar.m;
            if (dVar2 != null) {
                dVar2.M(bpVar.l.x().intValue(), bpVar.l.w().intValue(), bpVar.l.v().intValue());
                if (bpVar.m.f() == com.google.android.libraries.navigation.internal.ut.d.c.VOTABLE_INCIDENT) {
                    if (bpVar.l.A().booleanValue() && !bpVar.l.z()) {
                        bpVar.l.B().booleanValue();
                        bpVar.p = bpVar.b.l().c(new com.google.android.libraries.navigation.internal.vf.bm(), bpVar.h);
                    }
                } else if (bpVar.m.f() == com.google.android.libraries.navigation.internal.ut.d.c.REPORT_INCIDENT) {
                    if (bpVar.l.A().booleanValue() && !bpVar.l.z()) {
                        bpVar.p = bpVar.b.l().c(new com.google.android.libraries.navigation.internal.dz.be(), bpVar.h);
                    }
                } else if (bpVar.m.f() != com.google.android.libraries.navigation.internal.ut.d.c.SELF_REPORTED_INCIDENT) {
                    bpVar.p = bpVar.b.l().c(new com.google.android.libraries.navigation.internal.ur.by(), bpVar.h);
                } else if (bpVar.l.A().booleanValue() && !bpVar.l.z()) {
                    bpVar.p = bpVar.b.l().c(new com.google.android.libraries.navigation.internal.vf.v(), bpVar.h);
                }
                com.google.android.libraries.navigation.internal.ms.cq cqVar2 = bpVar.p;
                if (cqVar2 != null) {
                    cqVar2.c(bpVar.m);
                    bpVar.m.b();
                    bpVar.m.P(true);
                    com.google.android.libraries.navigation.internal.ut.d dVar3 = bpVar.m;
                    int iB = -1;
                    if (bpVar.l.A().booleanValue() && com.google.android.libraries.navigation.internal.ms.aq.b(bpVar.a)) {
                        iB = dk.b(bpVar.a);
                    }
                    dVar3.Q(iB);
                    com.google.android.libraries.navigation.internal.ms.cq cqVar3 = bpVar.p;
                    if (cqVar3 != null) {
                        cqVar3.b();
                    }
                } else {
                    bpVar.m = null;
                }
            }
        }
        com.google.android.libraries.navigation.internal.ms.cy.a(bpVar.l);
    }

    @Override // com.google.android.libraries.navigation.internal.uh.b
    public final boolean c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.uh.b
    public final /* synthetic */ void d() {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.n
    public final /* synthetic */ void e() {
    }
}
