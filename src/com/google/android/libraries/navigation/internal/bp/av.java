package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.adr.Cif;
import com.google.android.libraries.navigation.internal.adr.dc;
import com.google.android.libraries.navigation.internal.adr.gj;
import com.google.android.libraries.navigation.internal.adr.gr;
import com.google.android.libraries.navigation.internal.adr.ib;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import j$.time.Duration;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class av {
    public final gj a;
    public final b b;
    public volatile gr c;
    public volatile com.google.android.libraries.navigation.internal.adr.z d;
    private bt[] e;
    private volatile List f;

    public av(gj gjVar) {
        this.a = gjVar;
        if ((gjVar.b & 16) != 0) {
            gr grVar = gjVar.g;
            this.c = grVar == null ? gr.a : grVar;
        }
        com.google.android.libraries.navigation.internal.adr.ar arVar = gjVar.f;
        if (((arVar == null ? com.google.android.libraries.navigation.internal.adr.ar.a : arVar).b & 32) != 0) {
            com.google.android.libraries.navigation.internal.adr.ar arVar2 = gjVar.f;
            com.google.android.libraries.navigation.internal.adr.z zVar = (arVar2 == null ? com.google.android.libraries.navigation.internal.adr.ar.a : arVar2).e;
            this.d = zVar == null ? com.google.android.libraries.navigation.internal.adr.z.a : zVar;
        }
        g gVar = null;
        if ((gjVar.b & 128) != 0) {
            int i = ev.d;
            eq eqVar = new eq();
            com.google.android.libraries.navigation.internal.adr.j jVar = gjVar.i;
            com.google.android.libraries.navigation.internal.ael.bz bzVar = (jVar == null ? com.google.android.libraries.navigation.internal.adr.j.a : jVar).b;
            com.google.android.libraries.navigation.internal.adr.i iVar = null;
            for (int i2 = 0; i2 < bzVar.size(); i2++) {
                com.google.android.libraries.navigation.internal.adr.i iVar2 = (com.google.android.libraries.navigation.internal.adr.i) bzVar.get(i2);
                int iA = com.google.android.libraries.navigation.internal.adr.g.a(iVar2.b);
                iA = iA == 0 ? com.google.android.libraries.navigation.internal.adr.g.a : iA;
                if (iA == com.google.android.libraries.navigation.internal.adr.g.b) {
                    if (iVar != null) {
                        ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) b.a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(new IllegalArgumentException("Encountered an ASSISTED_DRIVING_ON without first matching the previous ASSISTED_DRIVING_ON with an ASSISTED_DRIVING_OFF"))).F('0')).o();
                    }
                    iVar = iVar2;
                } else if (iA == com.google.android.libraries.navigation.internal.adr.g.c) {
                    if (iVar != null) {
                        b.b(eqVar, iVar, iVar2.c, Duration.ofSeconds(iVar2.d));
                    } else if (i2 != 0) {
                        ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) b.a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(new IllegalArgumentException("Encountered an ASSISTED_DRIVING_OFF without first finding a matched ASSISTED_DRIVING_ON"))).F('/')).o();
                    }
                    iVar = null;
                }
            }
            if (iVar != null) {
                Cif cif = gjVar.c;
                com.google.android.libraries.navigation.internal.adr.bm bmVar = (cif == null ? Cif.a : cif).e;
                int i3 = (bmVar == null ? com.google.android.libraries.navigation.internal.adr.bm.a : bmVar).c;
                Cif cif2 = gjVar.c;
                com.google.android.libraries.navigation.internal.aap.d dVar = (cif2 == null ? Cif.a : cif2).f;
                b.b(eqVar, iVar, i3, com.google.android.libraries.navigation.internal.bw.a.a(dVar == null ? com.google.android.libraries.navigation.internal.aap.d.a : dVar));
            }
            gVar = new g(eqVar.g());
        }
        this.b = gVar;
        if ((gjVar.b & 32) != 0 && gjVar.h == null) {
            dc dcVar = dc.a;
        }
        this.f = gjVar.j;
    }

    public final int a() {
        return this.a.e.size();
    }

    public final bt b(int i) {
        return g()[i];
    }

    public final com.google.android.libraries.navigation.internal.adr.ar c() {
        com.google.android.libraries.navigation.internal.adr.ar arVar = this.a.f;
        return arVar == null ? com.google.android.libraries.navigation.internal.adr.ar.a : arVar;
    }

    public final Cif d() {
        Cif cif = this.a.c;
        return cif == null ? Cif.a : cif;
    }

    public final boolean e() {
        return (this.a.b & 8) != 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof av) {
            return com.google.android.libraries.navigation.internal.yx.am.a(this.a, ((av) obj).a);
        }
        return false;
    }

    public final boolean f() {
        return (this.a.b & 1) != 0;
    }

    public final synchronized bt[] g() {
        if (this.e == null) {
            this.e = new bt[a()];
            for (int i = 0; i < this.a.e.size(); i++) {
                this.e[i] = new bt((ib) this.a.e.get(i), i);
            }
        }
        return this.e;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }
}
