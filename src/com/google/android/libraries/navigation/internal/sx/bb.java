package com.google.android.libraries.navigation.internal.sx;

import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.afl.lt;
import com.google.android.libraries.navigation.internal.afl.lz;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayList;
import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bb {
    public final av a;
    private final Optional b;

    public bb(av avVar, Optional optional) {
        this.a = avVar;
        this.b = optional;
    }

    public final bj a(com.google.android.libraries.navigation.internal.db.r rVar, ev evVar, bg bgVar, com.google.android.libraries.navigation.internal.ael.x xVar, boolean z, lt ltVar) {
        b(rVar, ay.b);
        av avVar = this.a;
        if (avVar.a()) {
            b bVar = new b();
            bVar.e = bgVar.P;
            bVar.c = rVar;
            bVar.c(z);
            bVar.f = evVar;
            bVar.b(true);
            bVar.d = ltVar;
            bVar.b = xVar;
            bVar.o = Long.valueOf(av.a);
            return avVar.f.a(bVar.d());
        }
        at atVar = avVar.c;
        com.google.android.libraries.navigation.internal.ady.al alVar = bgVar.j;
        lr lrVar = bgVar.P;
        ArrayList arrayList = new ArrayList();
        arrayList.add(ck.N(null, rVar == null ? null : rVar.m()));
        arrayList.addAll(evVar);
        com.google.android.libraries.navigation.internal.bs.a aVar = new com.google.android.libraries.navigation.internal.bs.a();
        aVar.d = com.google.android.libraries.navigation.internal.ts.a.a(rVar);
        aVar.e = rVar == null ? null : rVar.o();
        aVar.g = z;
        aVar.f = atVar.c();
        com.google.android.libraries.navigation.internal.ady.c cVar = (com.google.android.libraries.navigation.internal.ady.c) com.google.android.libraries.navigation.internal.ady.h.a.q();
        int i = com.google.android.libraries.navigation.internal.ady.e.e;
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.ady.h hVar = (com.google.android.libraries.navigation.internal.ady.h) cVar.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        hVar.c = i2;
        hVar.b |= 1;
        int i3 = com.google.android.libraries.navigation.internal.ady.g.e;
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.ady.h hVar2 = (com.google.android.libraries.navigation.internal.ady.h) cVar.b;
        int i4 = i3 - 1;
        if (i3 == 0) {
            throw null;
        }
        hVar2.d = i4;
        hVar2.b |= 2;
        aVar.c = (com.google.android.libraries.navigation.internal.ady.h) cVar.t();
        com.google.android.libraries.navigation.internal.bu.b bVarA = atVar.e.a(lrVar, alVar);
        bVarA.a = xVar;
        aVar.a = bVarA.a();
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            aVar.b((ck) arrayList.get(i5));
        }
        lz lzVarD = atVar.d(aVar.a(), null, ltVar);
        ab abVarA = atVar.d.a(null, null, null);
        abVarA.f(lzVarD, at.e(rVar), true, false);
        return abVarA.a();
    }

    public final void b(com.google.android.libraries.navigation.internal.db.r rVar, int i) {
        if (this.b.isPresent()) {
            ax axVar = (ax) az.a.q();
            if (rVar != null) {
                com.google.android.libraries.navigation.internal.adu.i iVar = (com.google.android.libraries.navigation.internal.adu.i) com.google.android.libraries.navigation.internal.adu.j.a.q();
                if (!iVar.b.H()) {
                    iVar.v();
                }
                com.google.android.libraries.navigation.internal.adu.j jVar = (com.google.android.libraries.navigation.internal.adu.j) iVar.b;
                jVar.b |= 1;
                jVar.c = rVar.b;
                if (!iVar.b.H()) {
                    iVar.v();
                }
                double d = rVar.c;
                com.google.android.libraries.navigation.internal.adu.j jVar2 = (com.google.android.libraries.navigation.internal.adu.j) iVar.b;
                jVar2.b |= 2;
                jVar2.d = d;
                if (!axVar.b.H()) {
                    axVar.v();
                }
                az azVar = (az) axVar.b;
                com.google.android.libraries.navigation.internal.adu.j jVar3 = (com.google.android.libraries.navigation.internal.adu.j) iVar.t();
                jVar3.getClass();
                azVar.c = jVar3;
                azVar.b |= 1;
            }
            if (!axVar.b.H()) {
                axVar.v();
            }
            az azVar2 = (az) axVar.b;
            azVar2.d = ay.a(i);
            azVar2.b |= 2;
            int i2 = ba.a;
        }
    }
}
