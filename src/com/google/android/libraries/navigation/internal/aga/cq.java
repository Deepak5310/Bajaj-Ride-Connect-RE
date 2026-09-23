package com.google.android.libraries.navigation.internal.aga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cq extends a {
    final com.google.android.libraries.navigation.internal.afx.ao a;
    final com.google.android.libraries.navigation.internal.afx.aj b;
    final o c;
    final p d;
    List e;
    bt f;
    boolean g;
    boolean h;
    com.google.android.libraries.navigation.internal.afx.cp i;
    final /* synthetic */ cr j;

    public cq(cr crVar, com.google.android.libraries.navigation.internal.afx.ao aoVar) {
        this.j = crVar;
        this.e = aoVar.a;
        this.a = aoVar;
        com.google.android.libraries.navigation.internal.afx.aj ajVarB = com.google.android.libraries.navigation.internal.afx.aj.b("Subchannel", crVar.a());
        this.b = ajVarB;
        p pVar = new p(ajVarB, crVar.i.a(), "Subchannel for ".concat(String.valueOf(String.valueOf(aoVar.a))));
        this.d = pVar;
        this.c = new o(pVar, crVar.i);
    }

    @Override // com.google.android.libraries.navigation.internal.afx.aw
    public final List a() {
        this.j.j.d();
        com.google.android.libraries.navigation.internal.yx.ar.l(this.g, "not started");
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.aw
    public final void b() {
        this.j.j.d();
        com.google.android.libraries.navigation.internal.yx.ar.l(this.g, "not started");
        this.f.a();
    }

    @Override // com.google.android.libraries.navigation.internal.afx.aw
    public final void c() {
        com.google.android.libraries.navigation.internal.afx.cp cpVar;
        this.j.j.d();
        if (this.f == null) {
            this.h = true;
            return;
        }
        if (!this.h) {
            this.h = true;
        } else {
            if (!this.j.v || (cpVar = this.i) == null) {
                return;
            }
            cpVar.a();
            this.i = null;
        }
        cr crVar = this.j;
        if (crVar.v) {
            this.f.g(cr.b);
        } else {
            this.i = crVar.j.a(new bx(new cp(this)), 5L, TimeUnit.SECONDS, this.j.g.c());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.afx.aw
    public final void d(com.google.android.libraries.navigation.internal.afx.ay ayVar) {
        this.j.j.d();
        com.google.android.libraries.navigation.internal.yx.ar.l(!this.g, "already started");
        com.google.android.libraries.navigation.internal.yx.ar.l(!this.h, "already shutdown");
        com.google.android.libraries.navigation.internal.yx.ar.l(!this.j.v, "Channel is being terminated");
        this.g = true;
        String strA = this.j.a();
        cr crVar = this.j;
        s sVar = crVar.g;
        ScheduledExecutorService scheduledExecutorServiceC = sVar.c();
        co coVar = new co(this, ayVar);
        cr crVar2 = this.j;
        com.google.android.libraries.navigation.internal.afx.ag agVar = crVar2.z;
        n nVarA = crVar2.w.a();
        com.google.android.libraries.navigation.internal.afx.aj ajVar = this.b;
        cr crVar3 = this.j;
        bt btVar = new bt(this.a, strA, crVar.I, sVar, scheduledExecutorServiceC, crVar3.k, crVar3.j, coVar, agVar, nVarA, ajVar, this.c, this.j.m);
        com.google.android.libraries.navigation.internal.afx.ad adVar = new com.google.android.libraries.navigation.internal.afx.ad();
        adVar.a = "Child Subchannel started";
        adVar.b = com.google.android.libraries.navigation.internal.afx.ae.CT_INFO;
        adVar.b(this.j.i.a());
        adVar.c = btVar;
        this.j.x.b(adVar.a());
        this.f = btVar;
        com.google.android.libraries.navigation.internal.afx.ag.a(this.j.z.c, btVar);
        this.j.r.add(btVar);
    }

    @Override // com.google.android.libraries.navigation.internal.afx.aw
    public final void e(List list) {
        this.j.j.d();
        this.e = list;
        bt btVar = this.f;
        com.google.android.libraries.navigation.internal.yx.ar.r(list, "newAddressGroups");
        bt.c(list, "newAddressGroups contains null entry");
        com.google.android.libraries.navigation.internal.yx.ar.b(!list.isEmpty(), "newAddressGroups is empty");
        btVar.g.execute(new bh(btVar, Collections.unmodifiableList(new ArrayList(list))));
    }

    public final String toString() {
        return this.b.toString();
    }
}
