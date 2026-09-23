package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class gt extends com.google.android.libraries.navigation.internal.abg.h {
    final /* synthetic */ gu b;
    private final boolean c;
    private final com.google.android.libraries.navigation.internal.ace.fw d;

    public gt(gu guVar, boolean z, com.google.android.libraries.navigation.internal.ace.fw fwVar) {
        this.b = guVar;
        this.c = z;
        this.d = fwVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abg.h, com.google.android.libraries.navigation.internal.abg.n
    public final boolean e() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.abg.h, com.google.android.libraries.navigation.internal.abg.n
    public final boolean f() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final int h() {
        return 75;
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final void i(DataOutputStream dataOutputStream) throws IOException {
        com.google.android.libraries.navigation.internal.afl.ai aiVar = (com.google.android.libraries.navigation.internal.afl.ai) com.google.android.libraries.navigation.internal.afl.aj.a.q();
        synchronized (this.b) {
            for (com.google.android.libraries.navigation.internal.afl.hb hbVar : this.b.d) {
                com.google.android.libraries.navigation.internal.afl.gy gyVar = (com.google.android.libraries.navigation.internal.afl.gy) com.google.android.libraries.navigation.internal.afl.hb.a.q();
                if ((hbVar.b & 1) != 0) {
                    com.google.android.libraries.navigation.internal.afl.ha haVarB = com.google.android.libraries.navigation.internal.afl.ha.b(hbVar.e);
                    if (haVarB == null) {
                        haVarB = com.google.android.libraries.navigation.internal.afl.ha.UNKNOWN_TYPE;
                    }
                    if (!gyVar.b.H()) {
                        gyVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afl.hb hbVar2 = (com.google.android.libraries.navigation.internal.afl.hb) gyVar.b;
                    hbVar2.e = haVarB.eg;
                    hbVar2.b = 1 | hbVar2.b;
                }
                if ((hbVar.b & 2) != 0) {
                    long j = hbVar.f;
                    if (!gyVar.b.H()) {
                        gyVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afl.hb hbVar3 = (com.google.android.libraries.navigation.internal.afl.hb) gyVar.b;
                    hbVar3.b |= 2;
                    hbVar3.f = j;
                }
                aiVar.d(gyVar);
            }
        }
        gu guVar = this.b;
        com.google.android.libraries.navigation.internal.afl.ag agVar = (com.google.android.libraries.navigation.internal.afl.ag) com.google.android.libraries.navigation.internal.afl.ah.a.q();
        if (!agVar.b.H()) {
            agVar.v();
        }
        Context context = guVar.r;
        com.google.android.libraries.navigation.internal.afl.ah.g((com.google.android.libraries.navigation.internal.afl.ah) agVar.b);
        boolean z = com.google.android.libraries.navigation.internal.abf.y.c(context) || com.google.android.libraries.navigation.internal.abf.y.b();
        if (!agVar.b.H()) {
            agVar.v();
        }
        com.google.android.libraries.navigation.internal.afl.ah ahVar = (com.google.android.libraries.navigation.internal.afl.ah) agVar.b;
        ahVar.b |= 2;
        ahVar.d = z;
        if (!agVar.b.H()) {
            agVar.v();
        }
        com.google.android.libraries.navigation.internal.afl.ah.e((com.google.android.libraries.navigation.internal.afl.ah) agVar.b);
        com.google.android.libraries.navigation.internal.adi.ab abVar = (com.google.android.libraries.navigation.internal.adi.ab) this.b.t.a();
        if (!agVar.b.H()) {
            agVar.v();
        }
        com.google.android.libraries.navigation.internal.afl.ah ahVar2 = (com.google.android.libraries.navigation.internal.afl.ah) agVar.b;
        abVar.getClass();
        ahVar2.h = abVar;
        ahVar2.b |= 32;
        com.google.android.libraries.navigation.internal.ace.fw fwVar = this.d;
        if (!agVar.b.H()) {
            agVar.v();
        }
        com.google.android.libraries.navigation.internal.afl.ah ahVar3 = (com.google.android.libraries.navigation.internal.afl.ah) agVar.b;
        fwVar.getClass();
        ahVar3.k = fwVar;
        ahVar3.b |= 512;
        com.google.android.libraries.navigation.internal.afl.ah ahVar4 = (com.google.android.libraries.navigation.internal.afl.ah) agVar.t();
        if (!aiVar.b.H()) {
            aiVar.v();
        }
        com.google.android.libraries.navigation.internal.afl.aj ajVar = (com.google.android.libraries.navigation.internal.afl.aj) aiVar.b;
        ahVar4.getClass();
        ajVar.d = ahVar4;
        ajVar.b |= 1;
        if (com.google.android.libraries.navigation.internal.abf.p.f(gu.a, 4)) {
            gu.k(aiVar);
        }
        com.google.android.libraries.navigation.internal.abf.u.a.b(dataOutputStream, aiVar.t());
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final void j(DataInputStream dataInputStream) throws IOException {
        gq gqVar;
        com.google.android.libraries.navigation.internal.ace.gm gmVar = null;
        com.google.android.libraries.navigation.internal.afl.am amVar = (com.google.android.libraries.navigation.internal.afl.am) com.google.android.libraries.navigation.internal.abf.u.a.a((com.google.android.libraries.navigation.internal.ael.dg) com.google.android.libraries.navigation.internal.afl.am.a.aH(7, null), dataInputStream);
        if (com.google.android.libraries.navigation.internal.abf.p.f(gu.a, 4)) {
            gu.l(amVar);
        }
        synchronized (this.b) {
            boolean z = false;
            for (com.google.android.libraries.navigation.internal.afl.hb hbVar : amVar.c) {
                if ((hbVar.b & 2) != 0 && this.b.j(hbVar)) {
                    this.b.i(hbVar);
                    com.google.android.libraries.navigation.internal.afl.ha haVarB = com.google.android.libraries.navigation.internal.afl.ha.b(hbVar.e);
                    if (haVarB == null) {
                        haVarB = com.google.android.libraries.navigation.internal.afl.ha.UNKNOWN_TYPE;
                    }
                    if (haVarB == com.google.android.libraries.navigation.internal.afl.ha.MAPS_API_PARAMETERS && hbVar.c == 151) {
                        gmVar = (com.google.android.libraries.navigation.internal.ace.gm) hbVar.d;
                    }
                    z = true;
                }
            }
            if (z) {
                gu guVar = this.b;
                com.google.android.libraries.navigation.internal.afl.al alVar = (com.google.android.libraries.navigation.internal.afl.al) com.google.android.libraries.navigation.internal.afl.am.a.q();
                alVar.c(guVar.d);
                guVar.v = (com.google.android.libraries.navigation.internal.afl.am) alVar.t();
                ((com.google.android.libraries.navigation.internal.abf.h) guVar.u.a()).b(guVar.v);
            }
            this.b.p = true;
        }
        this.b.d();
        if (gmVar != null && (gqVar = this.b.s) != null) {
            gqVar.j(gmVar);
        }
        synchronized (this.b.o) {
            this.b.f124n = false;
            if (this.b.m) {
                this.b.g();
            } else {
                this.b.l = gu.c.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.gs
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.k();
                    }
                }, 3L, TimeUnit.HOURS);
            }
        }
    }

    public final /* synthetic */ void k() {
        this.b.g();
    }
}
