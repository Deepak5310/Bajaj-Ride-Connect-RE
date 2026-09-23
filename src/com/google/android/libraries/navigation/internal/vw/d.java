package com.google.android.libraries.navigation.internal.vw;

import com.google.android.libraries.navigation.internal.adr.by;
import com.google.android.libraries.navigation.internal.adr.ka;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.bp.ai;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.yx.as;
import com.google.android.libraries.navigation.internal.zr.cd;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d implements com.google.android.libraries.navigation.internal.vp.f {
    final /* synthetic */ as a;
    final /* synthetic */ String b;
    final /* synthetic */ com.google.android.libraries.navigation.internal.si.d c;
    final /* synthetic */ com.google.android.libraries.navigation.internal.vq.b d;
    final /* synthetic */ List e;
    final /* synthetic */ lr f;
    final /* synthetic */ long g;
    final /* synthetic */ j h;

    public d(j jVar, as asVar, String str, com.google.android.libraries.navigation.internal.si.d dVar, com.google.android.libraries.navigation.internal.vq.b bVar, List list, lr lrVar, long j) {
        this.a = asVar;
        this.b = str;
        this.c = dVar;
        this.d = bVar;
        this.e = list;
        this.f = lrVar;
        this.g = j;
        this.h = jVar;
    }

    @Override // com.google.android.libraries.navigation.internal.vp.f
    public final void a(com.google.android.libraries.navigation.internal.vp.c cVar) {
        int i;
        synchronized (this.h) {
            List list = this.e;
            lr lrVar = this.f;
            long j = this.g;
            com.google.android.libraries.navigation.internal.vy.g gVar = (com.google.android.libraries.navigation.internal.vy.g) com.google.android.libraries.navigation.internal.vy.h.a.q();
            int size = list.size();
            if (!gVar.b.H()) {
                gVar.v();
            }
            com.google.android.libraries.navigation.internal.vy.h hVar = (com.google.android.libraries.navigation.internal.vy.h) gVar.b;
            hVar.b |= 1;
            hVar.c = size;
            com.google.android.libraries.navigation.internal.vy.c cVar2 = (com.google.android.libraries.navigation.internal.vy.c) com.google.android.libraries.navigation.internal.vy.f.a.q();
            ka kaVar = lrVar.f;
            if (kaVar == null) {
                kaVar = ka.a;
            }
            al alVarB = al.b(kaVar.c);
            if (alVarB == null) {
                alVarB = al.MIXED;
            }
            int iOrdinal = alVarB.ordinal();
            if (iOrdinal == 0) {
                i = com.google.android.libraries.navigation.internal.vy.e.b;
            } else if (iOrdinal == 1) {
                i = com.google.android.libraries.navigation.internal.vy.e.c;
            } else if (iOrdinal == 2) {
                i = com.google.android.libraries.navigation.internal.vy.e.d;
            } else if (iOrdinal != 5) {
                i = iOrdinal != 9 ? com.google.android.libraries.navigation.internal.vy.e.a : com.google.android.libraries.navigation.internal.vy.e.f;
            } else {
                i = com.google.android.libraries.navigation.internal.vy.e.e;
            }
            if (!cVar2.b.H()) {
                cVar2.v();
            }
            com.google.android.libraries.navigation.internal.vy.f fVar = (com.google.android.libraries.navigation.internal.vy.f) cVar2.b;
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            fVar.c = i2;
            fVar.b |= 1;
            by byVar = lrVar.h;
            if (byVar == null) {
                byVar = by.a;
            }
            boolean z = byVar.d;
            if (!cVar2.b.H()) {
                cVar2.v();
            }
            com.google.android.libraries.navigation.internal.vy.f fVar2 = (com.google.android.libraries.navigation.internal.vy.f) cVar2.b;
            fVar2.b |= 2;
            fVar2.d = z;
            by byVar2 = lrVar.h;
            if (byVar2 == null) {
                byVar2 = by.a;
            }
            boolean z2 = byVar2.c;
            if (!cVar2.b.H()) {
                cVar2.v();
            }
            com.google.android.libraries.navigation.internal.vy.f fVar3 = (com.google.android.libraries.navigation.internal.vy.f) cVar2.b;
            fVar3.b |= 4;
            fVar3.e = z2;
            if (!cVar2.b.H()) {
                cVar2.v();
            }
            com.google.android.libraries.navigation.internal.vy.f fVar4 = (com.google.android.libraries.navigation.internal.vy.f) cVar2.b;
            fVar4.b |= 8;
            fVar4.f = j;
            com.google.android.libraries.navigation.internal.vy.f fVar5 = (com.google.android.libraries.navigation.internal.vy.f) cVar2.t();
            if (!gVar.b.H()) {
                gVar.v();
            }
            com.google.android.libraries.navigation.internal.vy.h hVar2 = (com.google.android.libraries.navigation.internal.vy.h) gVar.b;
            fVar5.getClass();
            hVar2.d = fVar5;
            hVar2.b |= 2;
            com.google.android.libraries.navigation.internal.vy.h hVar3 = (com.google.android.libraries.navigation.internal.vy.h) gVar.t();
            com.google.android.libraries.navigation.internal.vy.a aVar = (com.google.android.libraries.navigation.internal.vy.a) com.google.android.libraries.navigation.internal.vy.b.a.q();
            if (!aVar.b.H()) {
                aVar.v();
            }
            com.google.android.libraries.navigation.internal.vy.b bVar = (com.google.android.libraries.navigation.internal.vy.b) aVar.b;
            hVar3.getClass();
            bVar.c = hVar3;
            bVar.b |= 1;
            this.h.B(this.b, cd.f, this.h.c.a() - this.h.p, (com.google.android.libraries.navigation.internal.vy.b) aVar.t());
        }
        this.d.d(cVar);
    }

    @Override // com.google.android.libraries.navigation.internal.vp.f
    public final void b(ai aiVar) {
        boolean zA = this.a.a(aiVar);
        synchronized (this.h) {
            this.h.B(this.b, cd.g, this.h.c.a() - this.h.p, null);
            if (zA) {
                this.h.j.d();
                this.h.j.c();
                j jVar = this.h;
                bg bgVar = jVar.k.e;
                jVar.k = com.google.android.libraries.navigation.internal.vv.a.b(aiVar, jVar.d);
                j jVar2 = this.h;
                jVar2.q(jVar2.k, bgVar, this.c);
                j jVar3 = this.h;
                if (jVar3.g) {
                    jVar3.n();
                }
            }
            j jVar4 = this.h;
            jVar4.B(this.b, cd.e, jVar4.c.a() - this.h.p, null);
        }
        this.d.d(zA ? com.google.android.libraries.navigation.internal.vp.c.OK : com.google.android.libraries.navigation.internal.vp.c.NAVIGATION_DISALLOWED);
    }
}
