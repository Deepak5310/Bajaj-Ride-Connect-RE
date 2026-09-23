package com.google.android.libraries.navigation.internal.we;

import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.iz;
import com.google.android.libraries.navigation.internal.adr.jb;
import com.google.android.libraries.navigation.internal.adr.jf;
import com.google.android.libraries.navigation.internal.adr.jg;
import j$.time.Instant;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bc implements ba {
    private bb a = null;
    private final com.google.android.libraries.navigation.internal.mj.a b;

    public bc(com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.b = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0033  */
    @Override // com.google.android.libraries.navigation.internal.we.ba
    public final az a(com.google.android.libraries.navigation.internal.tj.j jVar) {
        com.google.android.libraries.navigation.internal.add.bb bbVar = null;
        if (jVar.c().b.E == null) {
            this.a = null;
            return null;
        }
        bb bbVar2 = this.a;
        jg jgVar = jVar.c().b.E;
        if (bbVar2 == null) {
            this.a = new bb(jVar);
        } else {
            if (bbVar2.a != jVar.c().b.Y || !bbVar2.c.equals(jgVar.g)) {
                this.a = new bb(jVar);
            }
        }
        jg jgVar2 = jVar.c().b.E;
        Instant instant = jVar.c().b.i;
        jb jbVar = jgVar2.k;
        if (jbVar == null) {
            jbVar = jb.a;
        }
        if (instant.plusSeconds(jbVar.c).isBefore(this.b.f())) {
            return null;
        }
        jg jgVar3 = jVar.c().b.E;
        if (this.a == null) {
            return null;
        }
        boolean z = (jgVar3.b & 16) != 0 && jgVar3.h;
        com.google.android.libraries.navigation.internal.bp.bg bgVar = jVar.c().b;
        String str = this.a.b;
        com.google.android.libraries.navigation.internal.add.s sVar = com.google.android.libraries.navigation.internal.add.s.a;
        com.google.android.libraries.navigation.internal.add.o oVar = (com.google.android.libraries.navigation.internal.add.o) com.google.android.libraries.navigation.internal.add.t.a.q();
        if (!oVar.b.H()) {
            oVar.v();
        }
        com.google.android.libraries.navigation.internal.add.t tVar = (com.google.android.libraries.navigation.internal.add.t) oVar.b;
        sVar.getClass();
        tVar.d = sVar;
        tVar.c = 10;
        if (!oVar.b.H()) {
            oVar.v();
        }
        com.google.android.libraries.navigation.internal.add.t tVar2 = (com.google.android.libraries.navigation.internal.add.t) oVar.b;
        str.getClass();
        tVar2.e = str;
        el elVar = jgVar3.i;
        if (elVar == null) {
            elVar = el.a;
        }
        oVar.d(com.google.android.libraries.navigation.internal.wf.k.d(elVar.f221n));
        el elVar2 = jgVar3.i;
        if (elVar2 == null) {
            elVar2 = el.a;
        }
        oVar.c(com.google.android.libraries.navigation.internal.wf.k.d(elVar2.p));
        String str2 = (String) jgVar3.f.stream().map(new com.google.android.libraries.navigation.internal.wf.i()).findFirst().orElse("");
        if (!str2.isEmpty()) {
            com.google.android.libraries.navigation.internal.add.ba baVar = (com.google.android.libraries.navigation.internal.add.ba) com.google.android.libraries.navigation.internal.add.bb.a.q();
            if (!baVar.b.H()) {
                baVar.v();
            }
            com.google.android.libraries.navigation.internal.add.bb bbVar3 = (com.google.android.libraries.navigation.internal.add.bb) baVar.b;
            str2.getClass();
            bbVar3.b = str2;
            bbVar = (com.google.android.libraries.navigation.internal.add.bb) baVar.t();
        }
        if (bbVar != null) {
            if (!oVar.b.H()) {
                oVar.v();
            }
            com.google.android.libraries.navigation.internal.add.t tVar3 = (com.google.android.libraries.navigation.internal.add.t) oVar.b;
            tVar3.i = bbVar;
            tVar3.b |= 2;
        }
        if ((jgVar3.b & 64) != 0) {
            com.google.android.libraries.navigation.internal.add.j jVar2 = (com.google.android.libraries.navigation.internal.add.j) com.google.android.libraries.navigation.internal.add.k.a.q();
            iz izVar = jgVar3.j;
            if (izVar == null) {
                izVar = iz.a;
            }
            int i = izVar.b;
            if ((i & 8) != 0) {
                com.google.android.libraries.navigation.internal.adq.ab abVar = izVar.f;
                if (abVar == null) {
                    abVar = com.google.android.libraries.navigation.internal.adq.ab.a;
                }
                jVar2.c(com.google.android.libraries.navigation.internal.wf.k.c(abVar));
            } else if (izVar.e) {
                jVar2.c(com.google.android.libraries.navigation.internal.wf.k.b(bgVar, 0, bgVar.J));
            } else if ((i & 1) != 0) {
                jf jfVar = izVar.c;
                if (jfVar == null) {
                    jfVar = jf.a;
                }
                int i2 = jfVar.c;
                jf jfVar2 = izVar.c;
                if (jfVar2 == null) {
                    jfVar2 = jf.a;
                }
                jVar2.c(com.google.android.libraries.navigation.internal.wf.k.b(bgVar, i2, jfVar2.d));
            }
            com.google.android.libraries.navigation.internal.add.k kVar = (com.google.android.libraries.navigation.internal.add.k) jVar2.t();
            if (!oVar.b.H()) {
                oVar.v();
            }
            com.google.android.libraries.navigation.internal.add.t tVar4 = (com.google.android.libraries.navigation.internal.add.t) oVar.b;
            kVar.getClass();
            tVar4.f = kVar;
            tVar4.b |= 1;
        }
        return new n((com.google.android.libraries.navigation.internal.add.t) oVar.t(), z);
    }
}
