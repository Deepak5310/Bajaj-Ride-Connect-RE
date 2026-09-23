package com.google.android.libraries.navigation.internal.afs;

import androidx.work.WorkRequest;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.aer.l;
import com.google.android.libraries.navigation.internal.gd.e;
import com.google.android.libraries.navigation.internal.gd.h;
import com.google.android.libraries.navigation.internal.gd.i;
import com.google.android.libraries.navigation.internal.gd.j;
import com.google.android.libraries.navigation.internal.gd.k;
import com.google.android.libraries.navigation.internal.gd.n;
import com.google.android.libraries.navigation.internal.gd.o;
import com.google.android.libraries.navigation.internal.gg.f;
import com.google.android.libraries.navigation.internal.gg.g;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a implements f {
    public final com.google.android.libraries.navigation.internal.afo.a a;
    public final com.google.android.libraries.navigation.internal.gh.c b;

    public a(com.google.android.libraries.navigation.internal.afo.a aVar) {
        this.a = aVar;
        com.google.android.libraries.navigation.internal.xn.a aVar2 = com.google.android.libraries.navigation.internal.gh.d.a;
        com.google.android.libraries.navigation.internal.gh.c cVar = new com.google.android.libraries.navigation.internal.gh.c();
        this.b = cVar;
        cVar.i = com.google.android.libraries.navigation.internal.gd.a.MAPS_MOBILE_SDKS;
        com.google.android.libraries.navigation.internal.gd.f fVar = (com.google.android.libraries.navigation.internal.gd.f) i.a.q();
        if (!fVar.b.H()) {
            fVar.v();
        }
        i iVar = (i) fVar.b;
        iVar.b |= 128;
        iVar.j = false;
        if (!fVar.b.H()) {
            fVar.v();
        }
        i iVar2 = (i) fVar.b;
        iVar2.b |= 512;
        iVar2.l = false;
        if (!fVar.b.H()) {
            fVar.v();
        }
        i iVar3 = (i) fVar.b;
        iVar3.b |= 1;
        iVar3.c = false;
        if (!fVar.b.H()) {
            fVar.v();
        }
        i iVar4 = (i) fVar.b;
        iVar4.b |= 8;
        iVar4.f = false;
        if (!fVar.b.H()) {
            fVar.v();
        }
        i iVar5 = (i) fVar.b;
        iVar5.b |= 2;
        iVar5.d = false;
        if (!fVar.b.H()) {
            fVar.v();
        }
        i iVar6 = (i) fVar.b;
        iVar6.b |= 32;
        iVar6.h = true;
        if (!fVar.b.H()) {
            fVar.v();
        }
        i iVar7 = (i) fVar.b;
        iVar7.b |= 64;
        iVar7.i = false;
        if (!fVar.b.H()) {
            fVar.v();
        }
        i.b((i) fVar.b);
        h hVar = h.UNSPECIFIED;
        if (!fVar.b.H()) {
            fVar.v();
        }
        i iVar8 = (i) fVar.b;
        iVar8.k = hVar.d;
        iVar8.b |= 256;
        if (!fVar.b.H()) {
            fVar.v();
        }
        i iVar9 = (i) fVar.b;
        iVar9.b |= 16;
        iVar9.g = false;
        cVar.a = (i) fVar.t();
        j jVar = (j) k.a.q();
        if (!jVar.b.H()) {
            jVar.v();
        }
        k kVar = (k) jVar.b;
        kVar.b |= 8;
        kVar.f = 0;
        if (!jVar.b.H()) {
            jVar.v();
        }
        k kVar2 = (k) jVar.b;
        kVar2.b |= 2;
        kVar2.d = 2;
        if (!jVar.b.H()) {
            jVar.v();
        }
        k.b((k) jVar.b);
        if (!jVar.b.H()) {
            jVar.v();
        }
        k kVar3 = (k) jVar.b;
        kVar3.b |= 4;
        kVar3.e = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        cVar.a((k) jVar.t());
        n nVar = (n) o.a.q();
        if (!nVar.b.H()) {
            nVar.v();
        }
        o.b((o) nVar.b);
        cVar.b((o) nVar.t());
        cVar.g = null;
        cVar.h = (dg) l.b.aH(7, null);
        com.google.android.libraries.navigation.internal.gd.b bVar = (com.google.android.libraries.navigation.internal.gd.b) e.a.q();
        int i = com.google.android.libraries.navigation.internal.gd.d.a;
        if (!bVar.b.H()) {
            bVar.v();
        }
        e eVar = (e) bVar.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        eVar.d = i2;
        eVar.b |= 2;
        if (!bVar.b.H()) {
            bVar.v();
        }
        e eVar2 = (e) bVar.b;
        eVar2.b |= 4;
        eVar2.e = 0;
        cVar.d = (e) bVar.t();
    }

    @Override // com.google.android.libraries.navigation.internal.gg.f
    public final /* synthetic */ g a() {
        return new b(this);
    }

    @Override // com.google.android.libraries.navigation.internal.gg.f
    public final com.google.android.libraries.navigation.internal.gh.c b() {
        return this.b;
    }
}
